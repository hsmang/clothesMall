import React, {Component} from 'react';

const axios = require('axios');
class AdminDelete extends Component{



    deleteAdmin = (id) => {
        const url = 'http://localhost:8080/api/admins/' + id;

        const result = axios.delete(url,  {
            headers: {
                'Content-Type' : 'application/json',
            }
        }).then( (res) => {
            console.log(res);
            this.props.stateRefresh();
        }).catch( (res) => {
            console.log(res);
        });

    }

    render() {
        return (
            <button onClick={(e) => {this.deleteAdmin(this.props.id)}}> 삭제</button>
        )
    }
}

export default AdminDelete;