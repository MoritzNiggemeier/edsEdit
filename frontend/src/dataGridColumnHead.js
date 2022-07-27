import React from 'react';

export default class DataGridColumnHead extends React.Component {

	getIcon = () => {
		return this.props.getIcon( this.props.column );
	}

	setSort = ( /*event*/ ) => {
		this.props.setSort( this.props.column );
	}

	setFilter = ( event ) => {
		this.props.setFilter( this.props.column, event.target.value );
	}

	renderButton = () => {
		return <span>
			<img src={this.getIcon()} onClick={this.setSort} />
			<a href="#" onClick={this.setSort}>{this.props.name}</a>
		</span>

	}

	render = () => {
		if( this.props.setFilter === false ){
			return <th><div className="tabHeader">{this.renderButton()}</div></th>
		} else {
			return <th>
				<div className="tabHeader">
					<span></span>
					{this.renderButton()}
					<input type="text" placeholder=" -> no filter <- " onChange={this.setFilter} />
				</div>
			</th>
		}
	}

}
