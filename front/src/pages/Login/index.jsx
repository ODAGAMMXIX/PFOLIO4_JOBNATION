import React, {useEffect, useState} from 'react';
import {FormGroup, Button, Grid, CardContent, TextField} from '@material-ui/core';
import {CustonInput, CustonButton} from '../../components/Custon.component';
// import { ValidatorForm, TextValidator} from 'react-material-ui-form-validator';
import {Link} from 'react-router-dom';
import api from '../../services/api';

function Login() {

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();

  const handleSubmit = (e) =>{
    e.preventDefault();
  }

  return (
    <Grid container>
      <Grid item xs={12}>
        <CardContent>
          <div>
            
            <form onSubmit={handleSubmit}>
              <CustonInput
                onChange={(e) => setEmail(e.target.value)}
                fullWidth
                label="E-mail"
                type="email"
                value={email}
              />

              <CustonInput
                onChange={(e) => setPassword(e.target.value)}
                fullWidth
                label="Password"
                type="password"
                value={password}
              />
              
              <Button type="submit" variant="contained" color="primary">Login</Button>
            </form>
          </div>
        </CardContent>
      </Grid>
    </Grid>
  );
}

export default Login;