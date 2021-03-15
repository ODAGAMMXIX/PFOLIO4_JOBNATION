import React, {useEffect, useState, useRef} from 'react';
import {Typography, Button, TextField} from '@material-ui/core';
import {CustomInput, CustomButton} from '../../components/Custom.component';
import {CustomTypography, CustomFormLink} from '../../components/Custom.component';
import {CustomCarousel} from '../../components/Carousel.component';
import { useSnackbar } from 'notistack';
import { Messages } from '../../services/messages';
import {Logo} from '../../components/Logo.component';
import {Formik } from 'formik';
import {LoginValidation, FirsAccessValidation} from '../../services/validations'

import API from '../../services/api';
import styled from 'styled-components';

const LoginTitleWrapper = styled('div')`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 30px;
`

function Login() {

  const { enqueueSnackbar } = useSnackbar();

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [doc] = useState('');
  const [username] = useState('');
  const [step, setStep] = useState(0);
  const [refreshLoginForm, setRefreshLoginForm] = useState(false);
  const [refreshFirstAccessForm, setRefreshFirstAccessForm] = useState(false);

  const handleStep = (step) =>{
    if(step === 1){
      setStep(1);
    }
    if(step === 0){
      setStep(0)
    }
  }

  const handleLoginSubmit = (values) =>{
    console.log(values);
  }

  const handleSubmit = (values) =>{
    console.log(values);
    enqueueSnackbar(Messages.error.registration_failed, {variant: 'error'});
  }

  return (
    
      <div>
        <LoginTitleWrapper>
          {/* <Logo /> */}
          <CustomTypography variant="h5" className="dark_color" bold="true" label="Seja bem vindo!"/>
        </LoginTitleWrapper>
          <div>
            <Formik
              initialValues={{email:email, password:password}}
              validationSchema={LoginValidation}
              onSubmit={(values) => handleLoginSubmit(values)}
              enableReinitialize={refreshLoginForm}
            >
              {(props) => {
                const { values, touched, errors, handleChange, handleBlur, handleSubmit, handleReset} = props;

                return(
                  <form onSubmit={handleSubmit}>
                    <Typography variant="subtitle1" align="center" className="default_gray_color">
                      Faça seu login:
                    </Typography>
                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      label="E-mail"
                      type="email"
                      size="small"
                      name="email"
                      id="email"
                      helperText={(errors.email && touched.email) && errors.email}
                      error={errors.email && touched.email}
                      value={values.email}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      label="Password"
                      type="password"
                      size="small"
                      name="password"
                      id="password"
                      helperText={(errors.password && errors.password) && errors.password}
                      error={errors.password && touched.password}
                      value={values.password}
                    />
                    
                    <CustomButton
                      type="submit"
                      label={'Acessar'}
                      bg={'main_background'}
                      color={'light_color'}
                      fullwidth
                      size="small"
                    />
                  </form>
                )
              }}
            </Formik>
            <CustomFormLink onClick={() => handleStep(1)} label="Esqueceu sua senha ou é o primeiro acesso?" color='danger_color' />
          </div>
      </div>
  );
}

export default Login;