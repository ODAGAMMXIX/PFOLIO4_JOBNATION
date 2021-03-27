import React, {useEffect, useState} from 'react';
import {Typography, Button, TextField, Card, CardContent, Grid, CardHeader, Divider} from '@material-ui/core';
import {CustomInput, CustomButton} from '../../components/Custom.component';
import {CustomTypography, CustomFormLink} from '../../components/Custom.component';
import {CustomCarousel} from '../../components/Carousel.component';
import Search from '../../components/Search.component'
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
  const [listCandidates, setListCandidates] = useState([]);

  const mockDataJob = {id: '123', name: 'Desenvolvedor Java Pleno', description: 'Breve descrição da vaga', openData:'13/03/2021', finishData: '15/03/2021', limit: '8', location: 'São José dos Campos - SP'};
  
  const mockCandidates  = [
    {id: '123', name: 'Rafael', resume: 'Breve descrição da experiência', experience:'5', distance: '12'},
    {id: '456', name: 'Fábio', resume: 'Breve descrição da experiência', experience:'1', distance: '6'},
    {id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'3', distance: '6'},
    {id: '12', name: 'Felipe', resume: 'Breve descrição da experiência', experience:'2', distance: '3'},
  ]

  const handleLoginSubmit = (values) =>{
    console.log(values);
  }

  const handleSubmit = (values) =>{
    console.log(values);
    enqueueSnackbar(Messages.error.registration_failed, {variant: 'error'});
  }

  const handleSearch = ({searchKM, experience}) =>{
    let list = [];
    setListCandidates([]);
    mockCandidates.map((item)=>{
      if(parseInt(item.distance, 10) <= parseInt(searchKM, 10) || parseInt(item.experience, 10) >= parseInt(experience, 10)){
        console.log(item);
        list.push(item);
        setListCandidates([...list]);
      }
    });
  }

  return (
      <>
        <Grid container spacing={3}>
          <Grid item md={8}>
            <Typography variant="h4" bold>
              {mockDataJob.name}
            </Typography>
            <Typography variant="p">
              {mockDataJob.description}
            </Typography>
          </Grid>
          <Grid item md={4}>
            <Card>
              <CardContent>
                <div style={{display: 'flex', alignItems: 'center', justifyContent: 'space-between'}}>
                  <p>Abertura da Vaga</p>
                  <p>{mockDataJob.openData}</p>
                </div>
                <div style={{display: 'flex', alignItems: 'center', justifyContent: 'space-between'}}>
                  <p>Fechamento da Vaga</p>
                  <p>{mockDataJob.openData}</p>
                </div>
              </CardContent>
              <Divider/>
              <CardContent>
                <Typography variant="h6" bold>
                  Número de candidatos
                </Typography>
                <Typography variant="p">
                  {mockDataJob.limit}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
        <br/>
        <Divider />
        <br/>
        <Grid container>
          <Grid item md={12}>
            <Search handleSearch={handleSearch} />
          </Grid>
        </Grid>
        <br/>
        <Grid container spacing={3}>
          {listCandidates?.map((item) => (
            <Grid item md={3} key={item.id}>
              <Card>
                <CardContent>
                  <Typography variant="h6">
                    {item.name}
                  </Typography>
                </CardContent>
                <Divider/>
                <CardContent>
                  <Typography variant="p">
                    {item.resume}
                  </Typography>
                </CardContent>
                <CardContent>
                  <Typography variant="b">
                    Experiência: {item.experience} anos
                  </Typography>
                </CardContent>
                <CardContent>
                  <Typography variant="b">
                    Distância: {item.distance} Km
                  </Typography>
                </CardContent>
                <CardContent>
                    <CustomButton
                      type="submit"
                      label={'Ver candidato'}
                      bg={'main_background'}
                      color={'light_color'}
                      fullwidth
                      size="small"
                    />
                </CardContent>
              </Card>
            </Grid>
          ))}
          
        </Grid>
      </>
      
  );
}

export default Login;