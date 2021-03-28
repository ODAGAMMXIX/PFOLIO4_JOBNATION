import React, {useEffect, useState, useRef} from 'react';
import {Avatar, Typography, Button, TextField, Card, CardContent, Grid, CardHeader, Divider} from '@material-ui/core';
import {useParams} from 'react-router-dom';
import MapsComponent from '../../components/Maps.component';
import LocationOnIcon from '@material-ui/icons/LocationOn';
import {CustomDiv} from '../../components/Custom.component';

import API from '../../services/api';
import styled from 'styled-components';

function Candidates() {

  const params = useParams();

  const [distance, setDistance] = useState('');
  const [duration, setDuration] = useState('');

  const mock = {
    id_candidato: "",
    id_endereco: "",
    nome_candidato: "",
    descricao_candidato: "",
    estado_civil_candidato: "",
    sexo_candidato: "",
    idade_candidato: "",
    nascimento_candidato: "",
    competencia_candidato: [
        {id_competencia: "", descricao_competencia: "" },
        {id_competencia: "", descricao_competencia: "" },
    ],
    idiomas_candidato: [
        {id_idioma: "", descricao_idioma: "", nivel_idioma: ""},
        {id_idioma: "", descricao_idioma: "", nivel_idioma: ""},
    ],
    graduacao_candidato: [
        {id_graduacao: "", descricao_graduacao: "", inicio_graduacao: "", fim_graduacao: ""},
    ],
    experiencia_candidato: [
        {id_experiencia: "", descricao_experiencia: "", inicio_experiencia: "", fim_experiencia: ""},
    ]

  }

  const HandleGetDistance = (dis) => {
    setDistance(dis);
  }

  const HandleGetDuration = (dur) => {
    setDuration(dur);
  }

  return (
      <>

        <MapsComponent HandleGetDistance={HandleGetDistance} HandleGetDuration={HandleGetDuration} />

        <CardContent>
          <Grid container spacing={3}>
            <Grid item xs={8}>
              <CardContent>
                <Typography variant="h4">
                  {mock.nome_candidato}
                </Typography>
                <br/>
                <Grid container spacing={3}>
                  <Grid item xs={12}>
                    <Typography >
                      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales convallis urna eu
                      sollicitudin. In pretium nec ipsum eu vestibulum. Lorem ipsum dolor sit amet, Lorem
                      ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales convallis urna eu
                      sollicitudin. In pretium nec ipsum eu vestibulum. Lorem ipsum dolor sit amet, 
                    </Typography>
                  </Grid>
                </Grid>
                <br/>
                <Grid>
                  <div style={{display: 'flex', justifyContent: 'space-between', padding: '15px 0px'}}>
                    <p><b>E-mail:</b> rafael@teste.com </p>
                    <p><b>Telefone:</b> rafael@teste.com </p>
                    <p><b>Celular:</b> rafael@teste.com </p>
                  </div>
                </Grid>
                <br/>
                <Card>
                  <CardContent>
                    <Grid content>
                      <Grid item xs={12}>
                        <CardContent>
                          <Typography variant="h4">
                            Experiência Profissional
                          </Typography>
                          <br/>
                          <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales convallis urna eu
                            sollicitudin. In pretium nec ipsum eu vestibulum. Lorem ipsum dolor sit amet, Lorem
                            ipsum dolor sit amet, consectetur adipiscing elit. Ut sodales convallis urna eu
                            sollicitudin. In pretium nec ipsum eu vestibulum. Lorem ipsum dolor sit amet, 
                          </p>
                          <br/>
                          <Divider/>
                          <br/>
                          <Typography variant="h4">
                            Últimos empregos
                          </Typography>
                        </CardContent>
                      </Grid>
                    </Grid>
                  </CardContent>
                </Card>
              </CardContent>
              

            </Grid>
            <Grid item xs={4}>
              <CardContent>
                <Card>
                  <CardHeader
                    avatar={
                      <Avatar aria-label="recipe">
                        <LocationOnIcon />
                      </Avatar>
                    }
                    title="Rua Professora Maria José de Oliveira, 136, CEP: 12225-430"
                    subheader="São José dos Campos - SP"
                  />
                  <CardContent>
                    <p><b>Trajeto:</b> {distance}</p>
                  </CardContent>
                  <CardContent>
                    <p><b>Sexo:</b></p>
                    <p><b>Estado Civil:</b></p>
                    <p><b>Idade:</b></p>
                  </CardContent>
                </Card>
                <br />
                <Button variant="contained" color="secondary">Download CV</Button>
              </CardContent>
              
              <CardContent>
                <Typography variant="h5">
                  Escolaridade
                </Typography>
                <br/>
                  <p><b>Ensino Superior Completo</b></p>
                <br/>
                <Divider/>
              </CardContent>

              <CardContent>
                <Typography variant="h5">
                  Idiomas
                </Typography>
                <br/>
                  <p><b>Inglês</b></p>
                  <p><b>Espanhol</b></p>
                <br/>
                <Divider/>
              </CardContent>

              <CardContent>
                <Typography variant="h5">
                  Competências
                </Typography>
                <br/>
                  <p><b>Html</b></p>
                  <p><b>Css</b></p>
                  <p><b>React</b></p>
                  <p><b>Node JS</b></p>
                  <p><b>Bootstap</b></p>
                  <p><b>Javascript</b></p>
                <br/>
              </CardContent>

              <CardContent>
                <Button fullWidth variant="contained" color="primary">
                  Registrar candidatura
                </Button>
              </CardContent>

            </Grid>
          </Grid>
        </CardContent>
        
      </>
      
  );
}

export default Candidates;