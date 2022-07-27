import React from 'react';
import LoadingIndicator from "./loadingIndicator";
import DataGrid from "./dataGrid";
import ShowError from "./showError";

export default class EDSedit extends React.Component {

	constructor(props) {
		super(props);

		this.state = {

			data : {},
			error : null,

			urlEncode: "http://localhost:8080/backend/encode",
			urlDecode: "http://localhost:8080/backend/decode",

			loaded: false,
			loading: false
		};

	}

	onDataDecoded = ( event ) => {
		if( event.target.status == 200 ){
			this.setState({
				data: JSON.parse( event.target.responseText ),
				loaded: true,
				loading: false });
		} else {
			this.setState({
				loading: false,
				error:{
					code:  event.target.status,
					short: event.target.statusText,
					long:  event.target.responseText
				}});
		}
	}

	onDataEncoded = ( event ) => {
		if( event.target.status == 200 ){
			this.setState({ loading: false });
			let i;
			let binary = window.atob( event.target.response );
			let length = binary.length;
			let bytes = new Uint8Array( length );
			for( i = 0; i < length; i++ ){ bytes[ i ] = binary.charCodeAt( i ); }
			let blob = new Blob([ bytes ], { type: 'application/octet-stream' });
			let link = document.createElement('a');
				link.href = window.URL.createObjectURL( blob );
				link.target = "_blank";
				link.download = "edited.eds";
			document.body.appendChild( link );
			link.click();
			document.body.removeChild( link );
		} else {
			this.setState({ error:{
				code : event.target.code,
				short: event.target.statusText,
				long : event.target.responseText
			}});
		}
	}

	loadEDS = ( event ) => {
		this.setState({
			loading: true,
			loaded: false });
		let formData = new FormData();
		formData.append( "file", event.target.files[0] );
		let request = new XMLHttpRequest();
		request.addEventListener( "load", this.onDataDecoded );
		request.open( "POST", this.state.urlDecode, true );
		request.send( formData );
	}

	saveEDS = ( event ) => {
		this.setState({ loading: true });
		let eds = this.state.data;
		eds.globaldecisionslist.decision = window.dataGrid.state.data.sort(( a, b ) => {
			return a.indexUpdated - b.indexUpdated;
		});
		let formData = new FormData();
		formData.append( "data", JSON.stringify( eds ));
		let request = new XMLHttpRequest();
		request.addEventListener( "load", this.onDataEncoded );
		request.open( "POST", this.state.urlEncode, true );
		request.send( formData );
	}

	renderSaveButton = () => {
		return this.state.loaded
			? <div className="upload">
				<input type="button" className="hidden" id="saveEDS" name="data" onClick={this.saveEDS} />
				<label htmlFor="saveEDS" className="filebutton"><img src="img/save.png" /></label>
			  </div>
			: "";
	}

	renderDataGrid = () => {
		return this.state.loaded
			? <DataGrid
				ref={(dataGrid) => {window.dataGrid = dataGrid}}
				data={this.state.data.globaldecisionslist.decision}
				meta={this.state.data.configtree} />
			: "";
	}

	render = () => {
		return <div className="screen">
			<div className="header">
				<div>
					<img src="img/encologo.png" className="encologo" />
				</div>
				<div>
					<img src="img/edslogo.png" className="edslogo" />
				</div>
				<div>
					{this.renderSaveButton()}
					<form id="upload" className="upload" action="edit" method="POST" encType="multipart/form-data">
						<input type="file" id="file" name="file" onChange={this.loadEDS} />
						<label htmlFor="file" className="filebutton"><img src="img/load.png" /></label>
					</form>
				</div>
			</div>
			{this.renderDataGrid()}
			<LoadingIndicator isVisible={ this.state.loading } />
			<ShowError error={ this.state.error } />
		</div>
	}

}
