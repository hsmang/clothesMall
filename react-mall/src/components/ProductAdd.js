import React, {Component} from 'react';
import { axios } from 'axios';
import qs from 'query-string';


class ProductAdd extends Component{
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
            })
    }


    handleValueChange = (e) => {
        let nextState = {};
        nextState[e.target.name] = e.target.value;
        this.setState(nextState);
    }

    callCategory = async() => {
        const response = await fetch('http://localhost:8080/api/categories');
        const body = await response.json();
        console.log(body.list);
        return body.list;
    }

    addAdmin = async () => {
        const axios = require('axios');
        const url = 'http://localhost:8080/api/admins';
        const formData = new FormData();
        formData.append('aid', this.state.aid);
        formData.append('password', this.state.password);
        formData.append('name', this.state.name);
        formData.append('email', this.state.email);
        formData.append('phoneNumber', this.state.phoneNumber);

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
              <h1>상품 추가</h1>
              카테고리 : <input type={"text"} name={"aid"} value={this.state.aid} onChange={this.handleValueChange}/><br/>
              상품명 : <input type={"text"} name={"name"} value={this.state.password} onChange={this.handleValueChange}/><br/>
              원가 : <input type={"text"} name={"costPrice"} value={this.state.name} onChange={this.handleValueChange}/><br/>
              판매가 : <input type={"text"} name={"sellingPrice"} value={this.state.email} onChange={this.handleValueChange}/><br/>
              상세정보 : <textarea name={"productInformation"} value={this.state.phoneNumber} onChange={this.handleValueChange}/><br/>
              <button type={"submit"}>등록하기</button>
          </form>
        );
    }
}

export default ProductAdd;