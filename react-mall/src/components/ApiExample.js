import React, {Component} from 'react';

class ApiExample extends Component{
    constructor(props) {
        super(props);
        this.state = {
            data : ''
        }
    }
  render() {
    return (
        <h3>
            {this.state.data? this.state.data : '데이터를 불러오는 중입니다.'}
        </h3>
    );
  }
  // 이렇게하면 자동으로 함수에 바인딩됨.
  callApi = () => {
        fetch('https://jsonplaceholder.typicode.com/todos/1')
            .then(res => res.json())
            .then(json => {
                this.setState({
                    data : json.title
                })
            })
  }

  componentDidMount() {
        this.callApi();
  }

}

export default ApiExample;
