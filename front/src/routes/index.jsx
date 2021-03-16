import React from 'react';
import { Switch } from "react-router-dom";
import Route from './privateRoutes';
import Login from '../pages/Login/index';
import Register from '../pages/Register';
import Dashboard from '../pages/Dashboard';
import Profile from '../pages/Profile';
import Jobs from '../pages/Jobs';
import Config from '../pages/Config';

function Routes(){
    return(
        <Switch>
            <Route path="/" exact component={Login} />
            <Route path="/register" component={Register} />
            {/* <Route path="/config" isPrivate component={Config} /> */}
            
            {/* <Route path="/dashboard" isPrivate component={Dashboard} /> */}
            {/* <Route path="/profile" isPrivate component={Profile} /> */}
            <Route path="/jobs" isPrivate component={Jobs} />

            <Route path="*" component={() => <h1> 404 </h1>} />
        
        </Switch>
    )
}

export default Routes;