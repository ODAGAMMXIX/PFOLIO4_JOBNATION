import React, {useEffect, useState} from 'react';
import {CardContent} from '@material-ui/core';
import {CustomInput, CustomButton, CustonCardHeader} from './Custom.component';
import { useSnackbar } from 'notistack';
import { Messages } from '../services/messages';
import {Formik } from 'formik';
import API from '../services/api';
import styled from 'styled-components';
import {GetTheme} from '../services/theme';

const CustonDrawerConfig = styled('div')`
    max-width: 250px;
`

function ConfigComponent({handleSearch}) {

  const initialValues = {
    searchKM: ""
  }

  return (
      <CustonDrawerConfig>
        <CardContent>
            <Formik
              initialValues={initialValues}
              onSubmit={(values) => handleSearch(values)}
            >
            {(props) => {
                const { values, touched, errors, handleChange, handleBlur, handleSubmit, handleReset} = props;

                return(
                  <form onSubmit={handleSubmit}>

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Distância em Km"
                      type="text"
                      name="searchKM"
                      id="searchKM"
                      helperText={(errors.searchKM && touched.searchKM) && errors.searchKM}
                      error={errors.searchKM && touched.searchKM}
                      value={values.searchKM}
                    />

                    <CustomButton
                        type="submit"
                        label={'Buscar'}
                        bg={'main_background'}
                        color={'light_color'}
                        fullwidth
                        size="small"
                    />

                </form>
                )
            }}
            </Formik>
        </CardContent>
      </CustonDrawerConfig>
          
  );
}

export default ConfigComponent;