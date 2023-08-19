import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

const ApplicationEdit = () => {
    const initialFormState = {
        description: '',
        owner: ''
    };
    const [application, setApplication] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id !== 'new') {
            fetch(`/application/${id}`)
                .then(response => response.json())
                .then(data => setApplication(data));
        }
    }, [id, setApplication]);

    const handleChange = (event) => {
        const { name, value } = event.target

        setApplication({ ...application, [name]: value })
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        await fetch(`/application/${application.id ? `/${application.id}` : ''}`, {
            method: (application.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(application)
        });
        setApplication(initialFormState);
        navigate('/application/main');
    }

    const title = <h2>{application.id ? 'Edit application' : 'Add application'}</h2>;

    return (<div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label for="number">number</Label>
                        <Input type="text" name="number" id="number" value={application.number || ''}
                               onChange={handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="description">description</Label>
                        <Input type="text" name="description" id="description" value={application.description || ''}
                               onChange={handleChange} autoComplete="address-level1"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="owner">owner</Label>
                        <Input type="text" name="owner" id="owner" value={application.owner || ''}
                               onChange={handleChange} autoComplete="address-level1"/>
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/application/main">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
};

export default ApplicationEdit;