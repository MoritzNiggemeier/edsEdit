import React from 'react';

export default class LoadingIndicator extends React.Component {

	isVisible = () => {
		return this.props.isVisible ? "loadIndiShow" : "loadIndiHide";
	}

	render = () => {
		return <div id="loader" className={this.isVisible()}>
			<svg className="loader" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 320">
				<image href="img/icon.png" x="136" y="136" height="48px" width="48px" />
				<circle cx="160" cy="160" r="100" stroke="#0077c8"/>
				<circle cx="160" cy="160" r="80"  stroke="#1568c9"/>
				<circle cx="160" cy="160" r="60"  stroke="#3158ca"/>
				<circle cx="160" cy="160" r="40"  stroke="#4648cb"/>
			</svg>
		</div>
	}

}
