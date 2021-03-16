import React, {useState} from 'react';
import { createMuiTheme, withStyles, makeStyles, ThemeProvider } from '@material-ui/core/styles';
import styled from 'styled-components';
import {Link} from 'react-router-dom';
import {GetTheme} from '../services/theme';
import {Drawer, Button} from '@material-ui/core';
import SearchIcon from '@material-ui/icons/Search';
import ConfigComponent from './Config.component';


export default function Search({handleSearch}){

    const [openDrawer, setOpenDrawer] = useState(false);
    const [themeConfig, setThemeConfig] = useState();

    const handleDrawer = (toggle) =>{
        setOpenDrawer(toggle);
    }
  
    const handleCloseDrawer = () =>{
        setOpenDrawer(false);
    }

    return (
        <>
            <Button color="secondary" variant="contained" onClick={() => handleDrawer(true)}><SearchIcon /> Filtrar</Button>
            <Drawer open={openDrawer} anchor={"left"} onClose={() => handleDrawer(false)}>
                <ConfigComponent handleSearch={handleSearch} />
            </Drawer>
        </>
    )
}