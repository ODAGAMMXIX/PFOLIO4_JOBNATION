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

        <Grid container spacing={3}>
          <Grid item md={3} xs={12}>
            <CustomCard>
              <CustonCardHeader
                boldTitle
                variantTitle="h6"
                variantSubtitle="p"
                title="Upload de imagem"
                subTitle="Faça o upload da logo de sua empresa"
                classNameTitle="dark_color"
                divider
              />
              
              <CardContent>
                adf
              </CardContent>
            </CustomCard>
          </Grid>
          <Grid item md={9} xs={12}>
            <CustomCard>
              <CustonCardHeader
                variantTitle="h5"
                variantSubtitle="p"
                title="Configurações"
                subTitle="Configure as cores do sistema"
                classNameTitle="dark_color"
                divider
              />
              <CardContent>
                <Formik
                  initialValues={initialValues}
                  validationSchema={ConfigValidation}
                  onSubmit={(values) => handleSubmit(values)}
                  enableReinitialize={refreshForm}
                >
                {(props) => {
                  const { values, touched, errors, handleChange, handleBlur, handleSubmit, handleReset} = props;

                  return(
                    <form onSubmit={handleSubmit}>

                      <Grid container spacing={3}>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor principal"
                            type="text"
                            name="mainColor"
                            id="mainColor"
                            helperText={(errors.mainColor && touched.mainColor) && errors.mainColor}
                            error={errors.mainColor && touched.mainColor}
                            value={values.mainColor}
                          />
                        </Grid>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor secundária"
                            type="text"
                            name="secondColor"
                            id="secondColor"
                            helperText={(errors.secondColor && touched.secondColor) && errors.secondColor}
                            error={errors.secondColor && touched.secondColor}
                            value={values.secondColor}
                          />
                        </Grid>
                      </Grid>

                      <Grid container spacing={3}>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor de confirmação"
                            type="text"
                            name="successColor"
                            id="successColor"
                            helperText={(errors.successColor && touched.successColor) && errors.successColor}
                            error={errors.successColor && touched.successColor}
                            value={values.successColor}
                          />
                        </Grid>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor de erro"
                            type="text"
                            name="dangerColor"
                            id="dangerColor"
                            helperText={(errors.dangerColor && touched.dangerColor) && errors.dangerColor}
                            error={errors.dangerColor && touched.dangerColor}
                            value={values.dangerColor}
                          />
                        </Grid>
                      </Grid>

                      <Grid container spacing={3}>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor de aviso"
                            type="text"
                            name="warningColor"
                            id="warningColor"
                            helperText={(errors.warningColor && touched.warningColor) && errors.warningColor}
                            error={errors.warningColor && touched.warningColor}
                            value={values.warningColor}
                          />
                        </Grid>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor de informação"
                            type="text"
                            name="infoColor"
                            id="infoColor"
                            helperText={(errors.infoColor && touched.infoColor) && errors.infoColor}
                            error={errors.infoColor && touched.infoColor}
                            value={values.infoColor}
                          />
                        </Grid>
                      </Grid>

                      <Grid container spacing={3}>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor inversa"
                            type="text"
                            name="inverseColor"
                            id="inverseColor"
                            helperText={(errors.inverseColor && touched.inverseColor) && errors.inverseColor}
                            error={errors.inverseColor && touched.inverseColor}
                            value={values.inverseColor}
                          />
                        </Grid>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor escura"
                            type="text"
                            name="darkColor"
                            id="darkColor"
                            helperText={(errors.darkColor && touched.darkColor) && errors.darkColor}
                            error={errors.darkColor && touched.darkColor}
                            value={values.darkColor}
                          />
                        </Grid>
                      </Grid>

                      <Grid container spacing={3}>
                        <Grid item md={6} xs={12}>
                          <CustomInput
                            onChange={handleChange}
                            onBlur={handleBlur}
                            fullWidth
                            label="Cor clara"
                            type="text"
                            name="lightColor"
                            id="lightColor"
                            helperText={(errors.lightColor && touched.lightColor) && errors.lightColor}
                            error={errors.lightColor && touched.lightColor}
                            value={values.lightColor}
                          />
                        </Grid>
                      </Grid>
                      
                      <CustomButton
                        type="submit"
                        label={'Acessar'}
                        asdf="second_background"
                        color="main_color"
                        fullwidth
                        size="small"
                      />
                    </form>
                  )
                }}
                </Formik>
              </CardContent>
            </CustomCard>
          </Grid>
        </Grid>

      </>
          
  );
}

export default Config;