import React, {Component} from 'react';

class ReadContent extends Component{
  render() {
    return (
        <article>
            <h1><a href="/">{this.props.title}</a></h1>
            {this.props.desc}
        </article>
    );
  }

}

export default ReadContent;
