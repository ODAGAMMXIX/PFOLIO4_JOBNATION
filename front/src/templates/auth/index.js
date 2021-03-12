import React from 'react';
import {
  Box,
  Button,
  Container,
  Grid,
  Card,
  CardContent,
  Link,
  TextField,
  Typography,
  makeStyles
} from '@material-ui/core';
import styled from 'styled-components';

const LoginWrapper = styled(Grid)`
  background: #ccc;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
`
function TemplateAuth({children}) {
  return (
    <Grid container>
      <LoginWrapper item md={3} xs={12} >
        {children}
      </LoginWrapper>
    </Grid>
  );
}

export default TemplateAuth;