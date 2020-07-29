import React, {Component} from 'react';
import Paper from '@material-ui/core/Paper'
import Table from '@material-ui/core/Table'
import TableHead from '@material-ui/core/TableHead'
import TableBody from '@material-ui/core/TableBody'
import TableRow from '@material-ui/core/TableRow'
import TableCell from '@material-ui/core/TableCell'
import CircularProgress from '@material-ui/core/CircularProgress'
import { withStyles } from '@material-ui/core/styles'

import Customer from './components/Customer'
import AdminAdd from './components/AdminAdd'


const styles = theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing(5),
        overflowX: "auto"
    },
    table : {
        minWidth : 1080
    },
    progress : {

    }
})
// 라이프 사이클 순서
// 1. constructor()

// 2. componentWillMount()

// 3. render()

// 4. componentDidMount()

class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            customers : '',
            completed : 0
        }
    }

    stateRefresh = () => {
        this.setState({
            customers : '',
            completed : 0
        })

        this.callApi()
            .then(res => this.setState({customers:res}))
            .catch(err => console.log(err));
    }

    componentDidMount() {
        this.timer = setInterval(this.progress, 20);
        this.callApi()
            .then(res => this.setState({customers : res}))
            .catch(err => console.log(err));
    }

    callApi = async () => {
        const response = await fetch('http://localhost:8080/api/admins');
        const body = await response.json();
        console.log(body.list);
        return body.list;
    }

    progress = () => {
        const { completed } = this.state;
        this.setState({
            completed: completed >= 100 ? 0 : completed + 1
        })
    }

    render() {
    const { classes } = this.props;
    return (
        <div>
            <Paper className={classes.root}>
                <Table className={classes.table}>
                    <TableHead>
                        <TableRow>
                            <TableCell>번호</TableCell>
                            <TableCell>아이디</TableCell>
                            <TableCell>이름</TableCell>
                            <TableCell>이메일</TableCell>
                            <TableCell>핸드폰번호</TableCell>
                            <TableCell>설정</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {
                            this.state.customers ? this.state.customers.map(c => {
                                return ( <Customer stateRefresh={this.stateRefresh} key={c.id} id={c.id} aid={c.aid} name={c.name} email={c.email} phoneNumber={c.phoneNumber}></Customer> )})
                                :
                                <TableRow>
                                    <TableCell colSpan={"6"} align={"center"}>
                                        <CircularProgress className={classes.progress} variant={"determinate"} value={this.state.completed}></CircularProgress>
                                    </TableCell>
                                </TableRow>
                        }
                    </TableBody>
                </Table>
            </Paper>
            <AdminAdd stateRefresh={this.stateRefresh}></AdminAdd>
        </div>
    );
  }

}

export default withStyles(styles)(App) ;
