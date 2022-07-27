import React from 'react';

export default class ShowError extends React.Component {

	render = () => {
		if( this.props.error ){
			return <div className="errorArea">
				<h1>{this.props.error.short}</h1>
				<h3>{this.props.error.code}</h3>
				<p>{this.props.error.long}</p>
			</div>
		} else { return ""; }
	}

}
