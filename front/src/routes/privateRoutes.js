import React from 'react';
import {Route, Redirect} from 'react-router-dom';
import AuthTemplate from '../templates/auth';
import DefaultTemplate from '../templates/default';

export default function PrivateRoute({component: Component, isPrivate = false, ...attrs}){

    const signed = true; 

    if(!signed && isPrivate){
        return <Redirect to="/" />
    }

    if(signed && !isPrivate){
        return <Redirect to ="/jobs" />
    }

    const Layout = signed ? DefaultTemplate : AuthTemplate;

    return(
        <Route
            {...attrs}
            render={props=>(
                <Layout>
                    <Component {...props} />
                </Layout>
            )}
        />
    );

}