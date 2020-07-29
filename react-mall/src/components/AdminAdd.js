import React, {Component} from 'react';
import { axios } from 'axios';
import qs from 'query-string';


class AdminAdd extends Component{
    constructor(props) {
        super(props);
        this.state = {
            aid : '',
            password : '',
            name : '',
            email : '',
            phoneNumber : ''
        }

    }

    handleFormSubmit = (e) => {
        e.preventDefault();
        this.addAdmin()
            .then((response) => {
                console.log(response.data);
                this.props.stateRefresh();
            })
    }


    handleValueChange = (e) => {
        let nextState = {};
        nextState[e.target.name] = e.target.value;
        this.setState(nextState);
    }

    addAdmin = async () => {
        const axios = require('axios');
        const url = 'http://localhost:8080/api/admins';

        const params = {
            aid : this.state.aid,
            password : this.state.password,
            name : this.state.name,
            email : this.state.email,
            phoneNumber : this.state.phoneNumber
        }


        const result = await axios.post(url, params, {
            headers: {
                'Content-Type' : 'application/json',
            }
        }).then( (res) => {
            console.log(res);
            return res;
        }).catch( (res) => {
            console.log(res);
        });

        return result;
    }



    render() {
        return (
          <form onSubmit={this.handleFormSubmit}>
              <h1>관리자 추가</h1>
              아이디 : <input type={"text"} name={"aid"} value={this.state.aid} onChange={this.handleValueChange}/><br/>
              비밀번호 : <input type={"text"} name={"password"} value={this.state.password} onChange={this.handleValueChange}/><br/>
              이름 : <input type={"text"} name={"name"} value={this.state.name} onChange={this.handleValueChange}/><br/>
              이메일 : <input type={"text"} name={"email"} value={this.state.email} onChange={this.handleValueChange}/><br/>
              핸드폰번호 : <input type={"text"} name={"phoneNumber"} value={this.state.phoneNumber} onChange={this.handleValueChange}/><br/>
              <button type={"submit"}>등록하기</button>
          </form>
        );
    }
}

export default AdminAdd;