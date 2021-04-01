import React, {useEffect, useState, useRef} from 'react';
import {Typography, Button, TextField, Card, CardContent, Grid, CardHeader, Divider} from '@material-ui/core';
import {CustomInput, CustomButton} from '../../components/Custom.component';
import {CustomTypography, CustomFormLink} from '../../components/Custom.component';
import {CustomCarousel} from '../../components/Carousel.component';
import Search from '../../components/Search.component'
import { useSnackbar } from 'notistack';
import { Messages } from '../../services/messages';
import Location from '../../components/Location.component';
import {Logo} from '../../components/Logo.component';
import {Formik } from 'formik';
import {LoginValidation, FirsAccessValidation} from '../../services/validations';

import TuneIcon from '@material-ui/icons/Tune';
import MapIcon from '@material-ui/icons/Map';

import API from '../../services/api';
import styled from 'styled-components';

const LoginTitleWrapper = styled('div')`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 30px;
`

const FilterSelect = styled('div')`
  display: flex;
  height: 100%;
  justify-content: flex-end;
  border-right: 1px solid #eee;
`

function Login() {

  const { enqueueSnackbar } = useSnackbar();
  const [listCandidates, setListCandidates] = useState([]);
  const [searchByDistance, setSearchByDistante] = useState('');
  const [searchCandidates, setSearchCandidates] = useState([]);
  // const [km, setKm] = useState('');

  const mockDataJob = {lat: -23.1174248, lng: -45.7975872, id: '123', name: 'Desenvolvedor Java Pleno', description: 'Breve descrição da vaga', openData:'13/03/2021', finishData: '15/03/2021', limit: '8', location: 'São José dos Campos - SP'};
  
  const mockCandidates  = [
    {lat: -23.1834248, lng: -45.7951872, id: '123', name: 'Rafael', resume: 'Breve descrição da experiência', experience:'5', distance: '12'},
    {lat: -23.1854248, lng: -45.7255872, id: '456', name: 'Fábio', resume: 'Breve descrição da experiência', experience:'1', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'6', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'3', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'5', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'5', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'5', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'3', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'1', distance: '6'},
    {lat: -23.1274248, lng: -45.7955832, id: '789', name: 'Gabriela', resume: 'Breve descrição da experiência', experience:'3', distance: '6'},
    {lat: -23.1874548, lng: -45.7955272, id: '12', name: 'Felipe', resume: 'Breve descrição da experiência', experience:'2', distance: '3'},
  ]


  const handleSearch = ({experience}) =>{
    let list = [];
    setListCandidates([]);
    mockCandidates.map((item)=>{
      if(parseInt(item.experience, 10) >= parseInt(experience, 10)){
        // console.log(item);
        list.push(item);
        setListCandidates([...list]);
      }
    });
  }

  const HandleSearchCandidates = async (km) => {

    const params = {
      longitude:-45.795591699999996,
      latitude:-23.1874251,
      distance: km * 1000,
    }

    // console.log(km);

    // testDebounce();


    await API.get("/search", {params:params}).then((response) => {
      setSearchCandidates(response.data.devs)
    })
  }

  const HandleSetSearchByDistance = (km) => {
    setSearchByDistante(km);
    HandleSearchCandidates(km);
  }

  return (
      <>
        <CardContent>
          <Grid container spacing={3}>
            <Grid item md={8}>
              <Typography variant="h4">
                {mockDataJob.name}
              </Typography>
              <Typography >
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
                  <Typography variant="h6">
                    Número de candidatos
                  </Typography>
                  <Typography >
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
            <Grid item md={8}> 
              <Search
                HandleSetSearchByDistance={HandleSetSearchByDistance}
                handleSearch={handleSearch}
              />
            </Grid>
            {/* <Grid item md={4}>
              <FilterSelect>
                <Button><TuneIcon/></Button>
                <Button><MapIcon/></Button>
              </FilterSelect>
            </Grid> */}
          </Grid>
          {/* <br/>
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
                    <Typography >
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
          </Grid> */}
        </CardContent>

        <Location job={mockDataJob} candidates={searchCandidates} />

      </>
      
  );
}

export default Login;