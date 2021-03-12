import React, {useEffect, useState} from 'react';
import {
  Box,
  Button,
  Container,
  Grid,
  Link,
  TextField,
  Typography,
  makeStyles
} from '@material-ui/core';
// import { ValidatorForm, TextValidator} from 'react-material-ui-form-validator';
// import {Link as Linked} from 'react-router-dom';
// import { ColorPicker } from 'material-ui-color';
import API from '../../services/api';

function Login() {

  const [id, setId] = useState('')
  const [domain] = useState(window.location.origin);
  const [logo, setLogo] = useState('');
  const [main_color, setMainColor] = useState('');
  const [second_color, setSecondColor] = useState('');

  const handleSubmit = async (e) =>{
    e.preventDefault();
    const data = {domain, logo, main_color, second_color};
    if(!id){
      await API.post(`/config`, data).then((response) => {
        console.log(response);
      })
    }else{

      data.id = id;
      await API.put(`/config/${id}`, data).then((response) => {
        console.log(response);
      })
    }
    
  }

  useEffect(() => {
    API.post(`/config/get`, {domain: domain}).then((response) => {
      setId(response.data._id);
    })
  }, [])

  return (
    <div title="Login">
      <Box display="flex" flexDirection="column" height="100%" justifyContent="center">
        <Container maxWidth="sm">
          <form onSubmit={handleSubmit}>
            <TextField
              fullWidth
              label="Logo"
              margin="normal"
              name="logo"
              type="text"
              variant="outlined"
              value={logo}
              onChange={(e) => setLogo(e.target.value)}
            />

            <TextField
              fullWidth
              label="Cor principal"
              margin="normal"
              name="mainColor"
              variant="outlined"
              value={main_color}
              onChange={(e) => setMainColor(e.target.value)}
            />

            <TextField
              fullWidth
              label="Cor secundária"
              margin="normal"
              name="secondColor"
              variant="outlined"
              value={second_color}
              onChange={(e) => setSecondColor(e.target.value)}
            />

            <Box my={2}>
              <Button color="primary" fullWidth size="large" type="submit" variant="contained">
                Salvar
              </Button>
            </Box>
          </form>
        </Container>
      </Box>
    </div>
  )

  // return (
  //     <>
  //       <h1>Login</h1>
  //           <ValidatorForm onSubmit={handleSubmit} onError={errors => console.log(errors)}>
  //             <TextValidator
  //               label="Email"
  //               name="email"
  //               value={logo}
  //               validators={['required', 'isEmail']}
  //               errorMessages={['this field is required', 'email is not valid']}
  //           />
  //         <input type="text" value={email} onChange={e => setEmail(e.target.value)} />
  //         <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
  //         <button type="submit">Login</button>
  //       </ValidatorForm>
  //     </>
  // );
}

export default Login;