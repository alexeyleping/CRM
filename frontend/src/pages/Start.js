import React, {Component} from "react";
import Loader from "../loader/Loader";
import Table from "../table/Table";
import {map} from "react-bootstrap/ElementChildren";

export default class Start extends Component {

    state = {
        applications: []
    };

    async componentDidMount() {
        const response = await fetch('/application/main');
        const body = await response.json();
        this.setState({applications: body});
    }

    /*state  = {
        isLoading: true,
        data: []
    }
*/


    render() {
    const {applications} = this.state;
    return(
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <h2>Applications</h2>
                    {applications.map(application =>
                        <div key={application.id}>
                            {application._owner} ({application.description})
                        </div>
                    )}
                </div>
            </header>
        </div>
    )
}
}