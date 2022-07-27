import React from 'react';

let draggedElement = undefined;

export default class DataGridRow extends React.Component {

	handleChange = ( event, column, index ) => {
		return this.props.setData( index, column, event.target.value );
	}

	getBackground = ( column ) => {
		return this.props.isUpdated( this.props.data, column );
	}

	onDragStart = ( event, index ) => {
		event.dataTransfer.setData( "index", index );
		draggedElement = event.target;
		this.props.setOrder();
		event.target.classList.add( "dragged" );
	}

	onDragOver = ( event ) => {
		event.preventDefault();
		event.target.closest( "tr" ).classList.add( "dragOver");
	}

	onDragLeave = ( event ) => {
		event.preventDefault();
		event.target.closest( "tr" ).classList.remove( "dragOver");
	}

	onDrop = ( event, data ) => {
		event.target.closest( "tr" ).classList.remove( "dragOver");
		draggedElement.classList.remove( "dragged");
		let indexSwap = this.handleChange( {target:{value:( data.indexUpdated )}}, "indexUpdated", event.dataTransfer.getData( "index" ));
		this.props.updatePosition( event.dataTransfer.getData( "index" ), indexSwap );
	}

	render = () => {
		return <tr draggable onDragStart={( event ) => this.onDragStart( event, this.props.data.index )}
					onDragOver={this.onDragOver} onDragLeave={this.onDragLeave}
					onDrop={( event ) => this.onDrop( event, this.props.data)} >

			<td className={this.getBackground("isUpdated")} >
				<input type="checkbox" checked={this.props.data.isUpdated} readOnly />
			</td>

			<td className={this.getBackground("indexUpdated")}>
				<input type="number" value={this.props.data.indexUpdated}
					onChange={((event) => this.handleChange( event, "indexUpdated", this.props.data.index ))} />
			</td>

			<td>{this.props.data.parameterName}</td>

			<td className={this.getBackground("parameterValue")}>
				<input type="text" value={this.props.data.parameterValue}
					onChange={((event) => this.handleChange( event, "parameterValue", this.props.data.index ))} />
			</td>

			<td>{this.props.data.knowledgeBase}</td>
			<td>{this.props.data.KBversion}</td>
			<td>{this.props.data.parameterDomain}</td>

			<td><input type="checkbox" checked={this.props.data.setByDefault} readOnly /></td>
			<td><input type="checkbox" checked={this.props.data.setByExternal} readOnly /></td>
		</tr>
	}
}
