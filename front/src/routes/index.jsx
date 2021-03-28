import React from 'react';
import { Switch } from "react-router-dom";
import Route from './privateRoutes';
import Login from '../pages/Login/index';
import Register from '../pages/Register';
import Dashboard from '../pages/Dashboard';
import Profile from '../pages/Profile';
import CandidatesList from '../pages/JobsList';
import JobsList from '../pages/JobsList';
import Jobs from '../pages/Jobs';
import JobsNew from '../pages/Jobs/new';
import Candidates from '../pages/Candidates';
import Config from '../pages/Config';

function Routes(){
    return(
        <Switch>
            <Route path="/" exact component={Login} />
            <Route path="/register" component={Register} />
            {/* <Route path="/config" exact isPrivate component={Config} /> */}
            
            <Route path="/dashboard" exact isPrivate component={Dashboard} />
            {/* <Route path="/profile" exact isPrivate component={Profile} /> */}
            <Route path="/jobs" exact isPrivate component={JobsList} />
            <Route path="/jobs/new" exact isPrivate component={JobsNew} />
            <Route path="/jobs/:id" exact isPrivate component={JobsNew} />
            <Route path="/jobs/view/:id" exact isPrivate component={Jobs} />
            <Route path="/benefits" exact isPrivate component={JobsList} />
            <Route path="/benefits/:id" exact isPrivate component={Jobs} />
            <Route path="/skills" exact isPrivate component={JobsList} />
            <Route path="/skills/:id" exact isPrivate component={Jobs} />
            <Route path="/languages" exact isPrivate component={JobsList} />
            <Route path="/languages/:id" exact isPrivate component={Jobs} />
            <Route path="/business" exact isPrivate component={JobsList} />
            <Route path="/business/:id" exact isPrivate component={Jobs} />
            <Route path="/candidates" exact isPrivate component={JobsList} />
            <Route path="/candidates/:jobId/:id" exact isPrivate component={Candidates} />

            <Route path="*" component={() => <h1> 404 </h1>} />
        
        </Switch>
    )
}

export default Routes;