import React from 'react';
import { createMuiTheme, withStyles, makeStyles, ThemeProvider } from '@material-ui/core/styles';
import {CustomInput, CustonTitle, CustonSubmit, CustonForm} from './Custom.component';
import {Typography, Button, TextField, Card, CardContent, Grid, CardHeader, Divider} from '@material-ui/core';

import styled from 'styled-components';
import {Link} from 'react-router-dom';
import {GetTheme} from '../services/theme';

import {Formik} from 'formik';


const LogoImgWrapper = styled('div')`
    max-width: 150px;
    img{
        width: 100%;
        height: auto;
    }
`

export default function CustomFormik({initialValues, NewEditJobValidation, refreshForm, onSubmit, children }){
    return (
        <Formik
          initialValues={initialValues}
          validationSchema={NewEditJobValidation}
          onSubmit={onSubmit}
          enableReinitialize={refreshForm}
        >

          {children}
          
        </Formik>
    )
}