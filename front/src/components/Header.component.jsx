import React, {useState, useEffect, useContext} from 'react';
import styled from 'styled-components';
import {Link} from 'react-router-dom'
import {Drawer, Button} from '@material-ui/core';

import {GetTheme, GetDefaultTheme} from '../services/theme';
import { useSnackbar } from 'notistack';
import ColorizeIcon from '@material-ui/icons/Colorize';
import ConfigComponent from './Config.component';
import themeContext from '../store/ThemeContext';
import Search from './Search.component';

import { Messages } from '../services/messages';
import API from '../services/api';

const HeaderWrapper = styled('header')`
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    padding: 15px;
`

export default function HeaderComponent(){

    return (
        <>
            <HeaderWrapper className="header_background">
                {/* <div>
                    <ul>
                        <Link to='/dashboard'>Dashboard</Link>
                        <Link to='/profile'>Profile</Link>
                    </ul>
                </div> */}
            </HeaderWrapper>
        </>
    )
}