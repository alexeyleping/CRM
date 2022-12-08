import React, {Component} from "react";
import {Button, Container, Form, FormControl, Nav, Navbar, NavbarBrand, NavLink} from "react-bootstrap";
import logo from './logo192.png'
import {BrowserRouter as Router, Route, Link, Routes} from "react-router-dom";
import Start from "../pages/Start"
import Queue from "../pages/Queue"
import Contacts from "../pages/Contacts"
import AboutUs from "../pages/AboutUs"

export default class Header extends Component {
    render() {
        return(
            <Router>
            <div>
                <Navbar collapseOnSelect expand="md" bg="dark" variant="dark">
                    <Container>
                        <Navbar.Brand href="/start">
                            <img
                                src={logo}
                                height="30"
                                width="30"
                                className="d-inline-block align-top"
                                alt="Logo"
                            />
                        </Navbar.Brand>
                        <Navbar.Toggle aria-control="responsive-navbar-nav" />
                        <Navbar.Collapse id ="responsive-navbar-nav">
                            <Nav className="ml-auto" >
                                <Nav.Link href="/start">Start</Nav.Link>
                                <Nav.Link href="/queue">Queue</Nav.Link>
                                <Nav.Link href="/contacts">Contacts</Nav.Link>
                                <Nav.Link href="/about">About Us</Nav.Link>
                            </Nav>
                            <Form>
                                <FormControl
                                    type = "text"
                                    placeholder="Search"
                                    className="float-end"
                                />
                            </Form>
                            <Button variant="outline-info" >Search</Button>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
                <Routes>
                    <Route path="/start" element={<Start />} />
                    <Route path="/queue" element={<Queue />} />
                    <Route path="/contacts" element={<Contacts />} />
                    <Route path="/about" element={<AboutUs />} />
                </Routes>
            </div>
            </Router>
        )
    }
}