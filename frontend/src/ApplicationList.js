import React, { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

const ApplicationList = () => {

    const [application, setApplication] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('/application/main')
            .then(response => response.json())
            .then(data => {
                setApplication(data);
                setLoading(false);
            })
    }, []);

    const remove = async (id) => {
        await fetch(`/application/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedApplication = [...application].filter(i => i.id !== id);
            setApplication(updatedApplication);
        });
    }

    if (loading) {
        return <p>Loading...</p>;
    }

    const applicationList = application.map(application => {
        return <tr key={application.id}>
            <td style={{whiteSpace: 'nowrap'}}>{application.number}</td>
            <td> {application.description || ''} </td>
            <td> {application.owner || ''} </td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="primary" tag={Link} to={"/application/" + application.id}>Edit</Button>
                    <Button size="sm" color="danger" onClick={() => remove(application.id)}>Delete</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <tr></tr>
            <Container fluid>
                <div className="float-end" >
                    <Button color="success" tag={Link} to="/application/create">Add application</Button>
                </div>
                <h3>My application</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="20%">number</th>
                        <th width="20%">description</th>
                        <th width="20%">owner</th>
                        <th width="10%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {applicationList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
};

export default ApplicationList;