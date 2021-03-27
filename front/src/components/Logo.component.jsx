import React from 'react';
import { createMuiTheme, withStyles, makeStyles, ThemeProvider } from '@material-ui/core/styles';
import styled from 'styled-components';
import {Link} from 'react-router-dom';
import {GetTheme} from '../services/theme';


const LogoImgWrapper = styled('div')`
    max-width: 150px;
    img{
        width: 100%;
        height: auto;
    }
`

export function Logo(){
    return (
        <LogoImgWrapper>
            <img src={GetTheme.getThemeLogo()} alt="Logo licenciado" />
        </LogoImgWrapper>
    )
}