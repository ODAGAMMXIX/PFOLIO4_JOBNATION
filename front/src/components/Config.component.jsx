import React, {useEffect, useState} from 'react';
import {CardContent, Button, Typography, Grid, Divider} from '@material-ui/core';
import {CustomInput, CustomButton, CustonCardHeader, CustonRangeInput} from './Custom.component';
import { useSnackbar } from 'notistack';
import { Messages } from '../services/messages';
import {Formik } from 'formik';
import API from '../services/api';
import styled from 'styled-components';
import {GetTheme} from '../services/theme';

import TuneIcon from '@material-ui/icons/Tune';
import MapIcon from '@material-ui/icons/Map';

const CustonDrawerConfig = styled('div')`
  max-width: 350px;
  min-width: 350px;
  display: flex;
  height: 100%;

  > div{
    width: 100%;
  }
`

const FilterSelect = styled('div')`
  display: flex;
  flex-direction: column;
  height: 100%;
  border-right: 1px solid #eee;
`

function ConfigComponent({HandleSetSearchByDistance, handleSearch}) {

  const [km, setKm] = useState('');

  const initialValues = {
    experience: "",
  }

  return (
      <CustonDrawerConfig>
        {/* <FilterSelect>
          <Button><MapIcon/></Button>
          <Button><TuneIcon/></Button>
        </FilterSelect> */}

        <div>
          <CardContent>
            <CardContent>
              <Typography variant="h6" align="center">Filtrar por: </Typography>
              <br/>
              <Grid container>
                <Grid item xs={12}>
                  <CustonRangeInput
                    name="searchKM"
                    id="searchKM"
                    value={km}
                    max={200}
                    onChange={(e) => {
                      setKm(e.target.value);
                    }}
                    onBlur={(e) =>{
                      HandleSetSearchByDistance(e.target.value);
                    }}
                  />
                  <br/>
                  <Typography align="center">{km} quilómetros</Typography>
                </Grid>
              </Grid>
            </CardContent>
          </CardContent>
          <Divider />
          {/* <CardContent>
            <CardContent>
              <Typography variant="h6" align="center">Filtrar por: </Typography>
              <br/>
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
                        label="Experiência"
                        type="text"
                        name="experience"
                        id="experience"
                        helperText={(errors.experience && touched.experience) && errors.experience}
                        error={errors.experience && touched.experience}
                        value={values.experience}
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
          </CardContent> */}
        </div>
          
      </CustonDrawerConfig>
          
  );
}

export default ConfigComponent;