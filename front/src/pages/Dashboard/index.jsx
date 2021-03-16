import React, {useEffect, useState, useRef} from 'react';
import {Typography, Button, TextField, Grid, CardContent, CardHeader, Divider} from '@material-ui/core';
import {CustomInput, CustomButton} from '../../components/Custom.component';
import {CustomTypography, CustomFormLink, CustomBreadcrumb, CustomCard, CustonCardHeader} from '../../components/Custom.component';
import {CustomCarousel} from '../../components/Carousel.component';
import { useSnackbar } from 'notistack';
import { Messages } from '../../services/messages';
import {Logo} from '../../components/Logo.component';
import {Formik } from 'formik';
import {ConfigValidation} from '../../services/validations'
import {Links} from '../../services/links';

import API from '../../services/api';
import styled from 'styled-components';

function Config() {

  const { enqueueSnackbar } = useSnackbar();

  const [title] = useState('Configurações do Sistema');
  const [mainColor, setMainColor] = useState('');
  const [secondColor, setSecondColor] = useState('');
  const [successColor, setSuccessColor] = useState('');
  const [dangerColor, setDangerColor] = useState('');
  const [warningColor, setWarningColor] = useState('');
  const [infoColor, setInfoColor] = useState('');
  const [inverseColor, setInverseColor] = useState('');
  const [darkColor, setDarkColor] = useState('');
  const [lightColor, setLightColor] = useState('');
  const [refreshForm, setRefreshForm] = useState(false);

  const initialValues = {
    mainColor: mainColor,
    secondColor: secondColor,
    successColor: successColor,
    dangerColor: dangerColor,
    warningColor: warningColor,
    infoColor: infoColor,
    inverseColor: inverseColor,
    darkColor: darkColor,
    lightColor: lightColor,
  }

  const links = [
    Links('dashboard')
  ]
  const handleSubmit = (values) =>{
    console.log(values);
  }

  return (
      <>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <CustomTypography variant="h5" className="dark_color" bold="true" label={title}/>
            <CustomBreadcrumb links={links} label={title}/>
          </Grid>
        </Grid>
      </>
          
  );
}

export default Config;