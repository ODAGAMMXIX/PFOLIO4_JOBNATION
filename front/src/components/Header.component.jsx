import React, {useState, useEffect, useContext} from 'react';
import styled from 'styled-components';
import {Link} from 'react-router-dom'
import {Drawer, Button} from '@material-ui/core';

import {GetTheme, GetDefaultTheme} from '../services/theme';
import { useSnackbar } from 'notistack';
import ColorizeIcon from '@material-ui/icons/Colorize';
import ConfigComponent from './Config.component';
import themeContext from '../store/ThemeContext';

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

    const { enqueueSnackbar } = useSnackbar();
    const currentThemeContext = useContext(themeContext);

    const [openDrawer, setOpenDrawer] = useState(false);
    const [domain] = useState(window.location.origin);
    const [themeConfig, setThemeConfig] = useState();
    const [configData, setConfigData] = useState();

    const handleDrawer = (toggle) =>{
      setOpenDrawer(toggle);
    }

    const handleCloseDrawer = () =>{
        setOpenDrawer(false);
    }

    useEffect(() => {        
      if(currentThemeContext){
        setThemeConfig(GetTheme.parseThemetoJson(currentThemeContext.second_color));
      }else{
        setThemeConfig(GetDefaultTheme());
      }
    }, [openDrawer]);

    return (
        <>
            <HeaderWrapper className="header_background">
                <div>
                    <ul>
                        <Link to='/dashboard'>Dashboard</Link>
                        <Link to='/profile'>Profile</Link>
                    </ul>
                </div>
                <Button onClick={() => handleDrawer(true)}><ColorizeIcon /></Button>
            </HeaderWrapper>
            <Drawer open={openDrawer} anchor={"right"} onClose={() => handleDrawer(false)}>
                <ConfigComponent config={themeConfig} configData={currentThemeContext} domain={domain} />
            </Drawer>
        </>
    )
}