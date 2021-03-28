import React from 'react';
import { createMuiTheme, withStyles, makeStyles, ThemeProvider } from '@material-ui/core/styles';
import styled from 'styled-components';
import {Link, useHistory} from 'react-router-dom';
import {TextField, Typography, Breadcrumbs, Link as LinkMUI, Card, CardContent, Divider, Grid, Button} from '@material-ui/core';
import {GetTheme, GetDefaultTheme} from '../services/theme';
import { TextValidator } from 'react-material-ui-form-validator';
import { PowerInputSharp } from '@material-ui/icons';
import { Search } from '@material-ui/icons';
import { Visibility } from '@material-ui/icons';
import { Save } from '@material-ui/icons';
import { Delete } from '@material-ui/icons';
import {Formik } from 'formik';

const CustomStyledCard = styled(Card)`
    box-shadow: 0 0 0 1px rgb(63 63 68 / 5%), 0 1px 2px 0 rgb(63 63 68 / 15%);
`

const CustomStyledTextField = styled(TextValidator)`
    margin-bottom: 15px;
`

const CustonTextField = styled(TextField)`
    margin-bottom: 15px !important;
`

const CustomStyledTypography = styled(Typography)`
    font-weight: ${props => props.bold && 'bold !important'};
`

const CustonStyledLink = styled('a')`
    color: ${props => props.color && props.color};
    font-weight: bold;
    text-align: center;
    display: block;
    font-size: 0.8em;
    margin-top: 15px;
    cursor: pointer;

    :hover{
        color: ${props => props.color && props.color};
    }
`

const CustomStyledButton = styled('button')`
    border: 0px solid;
    border-radius: 4px;
    font-weight: bold;
    text-transform: uppercase;
    padding: 12px 15px;
    box-shadow: 0px 1px 3px rgba(0,0,0,0.3);
    cursor: pointer;
    transition: linear all 0.1s !important;
    width: ${props => props.fullwidth ? '100%' : 'inherit'};
    height: ${props => props.size === 'small' ? '40px' : '56px'};
    display: flex;
    align-items: center;
    justify-content: center;
    :hover{
        box-shadow: 0px 1px 3px rgba(0,0,0,0.3), 0px 0px 100px inset rgba(0,0,0,0.2);
        transition: linear all 0.1s !important;
    }
    :active{
        box-shadow: 0px 0px 10px ${props => props.bg}, 0px 0px 100px inset rgba(0,0,0,0.2);
    }
`

const StyledDiv = styled('div')`
    margin-top: ${(props) => props.mt ? props.mt : 'inherit'};
    margin-bottom: ${(props) => props.mb ? props.mb : 'inherit'};
    display: ${(props) => props.display ? props.display : 'inherit'};
    justify-content: ${(props) => props.justifycontent ? props.justifycontent : 'inherit'};
    align-items: ${(props) => props.alignitems ? props.alignitems : 'inherit'};
`

const StyledRangeInput = styled('div')`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;

    label{
        font-weight: bold;
        font-size: 12px;
    }

    input{
        width: 100%;
    }
`

const StyledForm = styled('form')`
  height: 100%;
  width: 100%;
`

const StyledCardContent = styled(CardContent)`
  height: 100%;
  width: 100%;
`

const StyledCardContentWrapper = styled(StyledCardContent)`
    padding: 15px;
    box-shadow: 0px 0px 0px rgba(0,0,0,0.2), 0px 0px 0px inset rgba(0,0,0,0.2);
    :last-child{
      padding-bottom: 15px !important;
    }
`

export function CustonRangeInput({name, id, value, onChange, max, onBlur}){
    return(
        <StyledRangeInput>
            <label>Distância (em Km):</label>
            <input 
                type="range"
                name={name}
                id={id}
                value={value}
                max={max}
                onChange={onChange}
                onBlur={onBlur}
            />
        </StyledRangeInput>
    )
}

export function CustomInput({onChange, onBlur, value, fullWidth, label, type, size, required, readonly, disabled, error, helperText, name, id, variant, multiline, rows}){
    return (
        <CustonTextField
            onChange={onChange}
            onBlur={onBlur}
            value={value}
            type={type}
            label={label}
            fullWidth={fullWidth}
            size={size}
            required={required}
            readOnly={readonly}
            disabled={disabled}
            error={error}
            helperText={helperText}
            name={name}
            id={id}
            variant={variant ? variant : "outlined"}
            multiline={multiline}
            rows={rows}
        />
    )
}

export function CustomInputValidator({onChange, value, fullWidth, label, type, size, validators, errorMessages}){
    return (
        <CustomStyledTextField
            onChange={onChange}
            value={value}
            type={type}
            label={label}
            fullWidth={fullWidth}
            variant="outlined"
            size={size}
            validators={validators}
            errorMessages={errorMessages}
        />
    )
}

export function CustomButton({type, label, bg, color, fullwidth, size, onClick, disabled}){

    const custonClass = `${bg} ${color}`;

    return (
        <CustomStyledButton
            type={type}
            fullwidth={fullwidth}
            className={custonClass}
            onClick={onClick}
            size={size}
            disabled={disabled}
        >
            {label}
        </CustomStyledButton>
    )
}

export function CustomTypography({variant, className, label, bold}){
    return (
        <CustomStyledTypography
            variant={variant} className={className} bold={bold}
        >
            {label}
        </CustomStyledTypography>
    )
}

export function CustomFormLink({onClick, label, color}){
    return (
        <CustonStyledLink className={color} onClick={onClick}>
            {label}
        </CustonStyledLink>
    )
}

export function CustomBreadcrumb({links, label}){
    return(
        <Breadcrumbs aria-label="breadcrumb" style={{marginTop: '10px'}}>
            {links?.map((item) => (
                <Link to={item.to} key={item.label} >
                    {item.label}
                </Link>
            ))}
            <Typography color="textPrimary">{label}</Typography>
        </Breadcrumbs>
    )
}

export function CustomCard({children}){
    return (
        <CustomStyledCard>
            {children}
        </CustomStyledCard>
    )
}

export function CustomCardHeader({classNameTitle, boldTitle, boldSubtitle, variantTitle, title, variantSubtitle, subTitle, className, divider}){
    return (
        <>
            <CardContent>
                <CustomStyledTypography
                    variant={variantTitle} className={classNameTitle} bold={boldTitle}
                >
                    {title}
                </CustomStyledTypography>
                <CustomStyledTypography
                    variant={variantSubtitle} bold={boldSubtitle}
                >
                    {subTitle}
                </CustomStyledTypography>
            </CardContent>
            {divider && <Divider/>}
        </>
    )
}

export function CustomDiv({children, mt, mb, display, justifycontent, alignitems}){
  return (
    <StyledDiv mt={mt} mb={mb} display={display} justifycontent={justifycontent} alignitems={alignitems}>
      {children}
    </StyledDiv>
  )
}

export function CustonTitle({title, links, showView, linkShowItem, id}){

  const history = useHistory();

  function handleView (itemId){
    const path = `${linkShowItem}${itemId}`;
    history.push(path);
  }

  return (
    <>
      <Grid container spacing={3}>
        <Grid item xs={8}>
          <Typography variant="h4" bold>
            {title}
          </Typography>
          <CustomBreadcrumb links={links} label={title}/>
        </Grid>
        {showView &&
          <Grid item xs={4} style={{display: 'flex', justifyContent:'flex-end', alignItems: 'center'}}>
            <Button color="primary" variant="outlined" onClick={() => handleView(id)}> <Visibility/> Visualizar </Button>
          </Grid>
        }
        
      </Grid>
      <br/>
    </>
  )
}

export function CustonForm({children, onSubmit}){
  return (
    <StyledForm onSubmit={onSubmit}>
      {children}
    </StyledForm>
  )
}

export function CustonSubmit({title, links}){
  return (
    <Grid container spacing={3}>
      <Grid item xs={12}>
        <CustomButton
          type="submit"
          label={'Acessar'}
          bg={'main_background'}
          color={'light_color'}
          fullwidth
          size="small"
        />
      </Grid>
    </Grid>
  )
}

export function CustonCardContent ({children}){
  return(
    <StyledCardContent>
      {children}
    </StyledCardContent>
  )
}

export function CustomFormFooter ({handleDelete, showDelete}){

  function confirmDelete(){
    if(window.confirm("Tem certeza que deseja apagar esse registro?")){
      handleDelete()
    }
  }

  return (
    <div style={{bottom: '0px', width: '100%', zIndex: '1', position: 'fixed', right: '0px', display: 'flex', justifyContent: 'flex-end'}}>

      <div style={{width: '15%'}}></div>
      <StyledCardContentWrapper style={{width: '100%', background: '#fff', display: 'flex', justifyContent:'space-between'}}>
        
        <Button
          type="submit"
          size="small"
          variant="contained"
          color="primary"
        ><Save/> Salvar</Button>
        
        {showDelete &&
          <Button
            type="button"
            size="small"
            variant="outlined"
            color="secondary"
            onClick={() => confirmDelete()}
          ><Delete/> Apagar</Button>
        }
        
      </StyledCardContentWrapper>
      
    </div>
  )
}