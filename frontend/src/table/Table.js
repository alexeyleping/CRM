import React, {Component} from 'react';

export default props => (
    <table className="table">
        <thead>
        <tr>
            <th>id</th>
            <th>date of create</th>
            <th>type</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody>
        {props.data.map(item => (
            <tr key={item.id}>
                <td>{item.dateCreated}</td>
                <td>{item.applicationType}</td>
                <td>{item.description}</td>
            </tr>
        ))}
        </tbody>
    </table>
)