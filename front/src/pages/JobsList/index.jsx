import React, {useEffect, useState, useRef} from 'react';
import {useHistory} from 'react-router-dom';
import {Typography, Button, IconButton, TextField, Card, CardContent, Grid, CardHeader, Divider} from '@material-ui/core';
import { useSnackbar } from 'notistack';
import Datatable from 'react-data-table-component';
import EditIcon from '@material-ui/icons/Edit';
import DeleteIcon from '@material-ui/icons/Delete';
import SearchIcon from '@material-ui/icons/Search';

import API from '../../services/api';
import styled from 'styled-components';

const data = [
  {id: 1, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 12, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 13, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 14, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 15, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 16, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 17, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 18, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 19, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 111, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 122, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 133, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 144, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 155, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 166, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 177, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 188, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 199, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 1000, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 1123, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 113, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 143, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 123, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
  {id: 51, vaga:'Java Pleno', abertura:'20/03/2021', fechamento: '22/03/2021', empresa:'Estevam Design', recrutador:'Rafael Estevam'},
]

function Jobs() {

  const { enqueueSnackbar } = useSnackbar();
  const history = useHistory();

  function handleView (id){
    const path = `/jobs/view/${id}`;
    history.push(path);
  }

  function handleEdit (id){
    const path = `/jobs/${id}`;
    history.push(path);
  }

  function handleNew (){
    const path = `/jobs/new`;
    history.push(path);
  }
  
  const columns = [
    {
      name: 'ID',
      selector: 'id',
      sortable: true,
    },
    {
      name: 'Vaga',
      selector: 'vaga',
      sortable: true,
    },
    {
      name: 'Abertura',
      selector: 'abertura',
      sortable: true,
    },
    {
      name: 'Fechamento',
      selector: 'fechamento',
      sortable: true,
    },
    {
      name: 'Empresa',
      selector: 'empresa',
      sortable: true,
    },
    {
      name: 'Recrutador',
      selector: 'recrutador',
      sortable: true,
    },
    {
      cell: (row) =>
      <>
        <IconButton color="primary" onClick={() => handleView(row.id)}><SearchIcon/></IconButton>
        <IconButton color="default" onClick={() => handleEdit(row.id)}><EditIcon/></IconButton>
      </>,
      button: true,
    }
  ]

  return (
      <CardContent>
        <Grid container spacing={3}>
          <Grid item md={8}>
            <Typography variant="h4" bold>
              Vagas cadastradas
            </Typography>
            <br/>
            <Button variant="contained" color="primary" size="small" onClick={handleNew}>+ Nova Vaga</Button>
          </Grid>
        </Grid>
        <br/>
        <Card>
          <Datatable
            title="Veja abaixo as vagas cadastradas no sistema"
            columns={columns}
            data={data}
            pagination
          />
        </Card>
        
      </CardContent>
      
  );
}

export default Jobs;