import React from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ApplicationList from "./ApplicationList";
import ApplicationEdit from "./ApplicationEdit";


const App = () => {
  return (
      <Router>
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route path='/application/main' exact={true} element={<ApplicationList/>}/>
          <Route path='/application/:id' element={<ApplicationEdit/>}/>
        </Routes>
      </Router>
  )
}

export default App;