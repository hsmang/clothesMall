import React, {Component} from 'react';
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'

class Customer extends Component{
    render() {
        return (
            <TableRow>
                <TableCell>{this.props.id}</TableCell>
                <TableCell>{this.props.aid}</TableCell>
                <TableCell>{this.props.name}</TableCell>
                <TableCell>{this.props.email}</TableCell>
                <TableCell>{this.props.phoneNumber}</TableCell>
            </TableRow>
        );
    }
}

export default Customer;