import React, {Component} from 'react';
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import AdminDelete from "./AdminDelete";

class Customer extends Component{
    render() {
        return (
            <TableRow>
                <TableCell>{this.props.id}</TableCell>
                <TableCell>{this.props.aid}</TableCell>
                <TableCell>{this.props.name}</TableCell>
                <TableCell>{this.props.email}</TableCell>
                <TableCell>{this.props.phoneNumber}</TableCell>
                <TableCell><AdminDelete stateRefresh={this.props.stateRefresh} id={this.props.id} /></TableCell>
            </TableRow>
        );
    }
}

export default Customer;