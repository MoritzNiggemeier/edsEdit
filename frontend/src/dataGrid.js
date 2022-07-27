import React from 'react';
import DataGridRow from "./dataGridRow";
import DataGridColumnHead from "./dataGridColumnHead";

export default class DataGrid extends React.Component {

	constructor(props) {
		super(props);
		this.filter = {};
		this.sortColumn = "indexUpdated";
		this.sortOrder = true;
		this.listOrder = [];
		this.state = {
			ori:  this.initData(),
			data: this.initData(),
			live: undefined,
		};
		this.state.live = this.state.data;
	}

	initData = () => {
		return JSON.parse( JSON.stringify( this.props.data )).map(( decision ) => {
			decision.isUpdated = false;
			decision.indexUpdated = decision.index;

			let index = this.props.meta.configNode.findIndex((e) => { return e.id == decision.nodeId; });
			decision.knowledgeBase = this.props.meta.configNode[ index ].knowledgeBase;
			decision.KBversion = this.props.meta.configNode[ index ].knowledgeBaseVersion;

			if( decision.facetName ){
				decision.parameterValue = decision.facetValue;
				decision.parameterName = decision.facetName + " " + decision.parameterName;
				decision.parameterDomain = "FACET";
			}
			return decision;
		});
	}

	isDatasetUpdated = ( index, dataset ) => {
		let result = false;
		if( this.state.data[ index ].indexUpdated != this.state.ori[ index ].indexUpdated ){ result = true; }
		if( this.state.data[ index ].parameterValue != this.state.ori[ index ].parameterValue ){ result = true; }
		return result;
	}

	setData = ( index, column, value ) => {
		let indexSwap = undefined;
		let isUpdated = false;
		let dataset = this.state.data.slice(0);
		if( column == "indexUpdated" ){
			if( value < 0 ){ return; }
			value = Number( value );
			indexSwap = dataset.findIndex( (e) => { return e.indexUpdated == value;} );
			if( indexSwap > -1 ){
				dataset[ indexSwap ][ column ] = dataset[ index ][ column ];
				dataset[ indexSwap ].isUpdated = this.isDatasetUpdated( indexSwap, dataset );
			}
		}
		dataset[ index ][ column ] = value;
		dataset[ index ].isUpdated = this.isDatasetUpdated( index, dataset );
		this.setState({ data: dataset });
		return indexSwap;
	}

	updatePosition = ( indexA, indexB ) => {
		let dataset = [];
		this.listOrder.map(( index ) => {
			dataset.push( this.state.data[ index ] ); });
		let indexLiveA = dataset.findIndex( (e) => { return e.index == indexA;} );
		let indexLiveB = dataset.findIndex( (e) => { return e.index == indexB;} );
		dataset.splice( indexLiveA, 1, this.state.data[ indexB ] );
		dataset.splice( indexLiveB, 1, this.state.data[ indexA ] );
		this.setState({ live: dataset });
	}

	setOrder = () => {
		let result = [];
		this.state.live.map(( decision ) => { result.push( decision.index ); });
		this.listOrder = result;
	}

	updateData = () => {
		let dataset = this.state.data.slice(0);
		dataset = this.filterData( dataset);
		dataset = this.sortData( dataset );
		this.setState({ live: dataset });
	}

	setSortColumn = ( column ) => {
		if( column == this.sortColumn ){
			this.sortOrder = !this.sortOrder;
		} else {
			this.sortColumn = column;
			this.sortOrder = true;
		}
		this.updateData();
	}

	getSortIcon = ( column ) => {
		let icon = "img/";
		if( column == this.sortColumn ){
			icon += ( this.sortOrder ? "down.svg" : "up.svg" );
		} else { icon += "trans32.png"; }
		return icon;
	}

	sortData = ( dataset ) => {
		dataset = dataset.sort(( a, b ) => {
			return this.sortColumn == "indexUpdated"
				? a.indexUpdated - b.indexUpdated
				: a[ this.sortColumn ].toString().toLowerCase().localeCompare(
				  b[ this.sortColumn ].toString().toLowerCase());
		});
		if( !this.sortOrder ){ dataset.reverse(); }
		return dataset;
	}

	setFilter = ( column, value ) => {
		this.filter[ column ] = value;
		this.updateData();
	}

	filterData = ( dataset ) => {
		for( var column in this.filter ){
			dataset = dataset.filter(( row ) => {
				return row[ column ].toString().toLowerCase().includes( this.filter[ column ].toLowerCase())})};
		return dataset;
	}

	isUpdated = ( data, column ) => {
		return data[ column ] != this.state.ori[ data.index ][ column ] ? "isUpdated" : "isUnchanged";
	}

	render = () => {

		let rows = this.state.live.map(( item, index ) => {
			return( <DataGridRow key={index} data={item} setData={this.setData} setOrder={this.setOrder}
									updatePosition={this.updatePosition} isUpdated={this.isUpdated} /> );
		});

		return <div className="datagrid">
			<table>
				<thead>
					<tr>
						<DataGridColumnHead name="change"   column="isUpdated"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={false} />
						<DataGridColumnHead name="Index" column="indexUpdated"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={this.setFilter} />
						<DataGridColumnHead name="Name"  column="parameterName"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={this.setFilter} />
						<DataGridColumnHead name="Value" column="parameterValue"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={this.setFilter} />
						<DataGridColumnHead name="Base" column="knowledgeBase"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={this.setFilter} />
						<DataGridColumnHead name="KB version" column="KBversion"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={this.setFilter} />
						<DataGridColumnHead name="Type"  column="parameterDomain"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={this.setFilter} />
						<DataGridColumnHead name="default" column="setByDefault"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={false} />
						<DataGridColumnHead name="extern" column="setByExternal"
							getIcon={this.getSortIcon} setSort={this.setSortColumn} setFilter={false} />
					</tr>
				</thead>
				<tbody>
					{rows}
				</tbody>
				<tfoot>
					<tr>
						<th colSpan="3" className="footerLeft"></th>
						<th colSpan="4" className="footerRight"></th>
					</tr>
				</tfoot>
			</table>
		</div>
	}
}
