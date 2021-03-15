import React, {useEffect, useState} from 'react';
import { useHistory } from 'react-router-dom';
import {CardContent} from '@material-ui/core';
import {CustomInput, CustomButton, CustonCardHeader} from './Custom.component';
import { useSnackbar } from 'notistack';
import { Messages } from '../services/messages';
import {Formik } from 'formik';
import {ConfigValidation} from '../services/validations'
import API from '../services/api';
import styled from 'styled-components';
import {GetTheme} from '../services/theme';

const CustonDrawerConfig = styled('div')`
    max-width: 250px;
`

function ConfigComponent({config, configData, domain}) {

  const history = useHistory();

  const { enqueueSnackbar } = useSnackbar();
  const [configId] = useState(configData?._id);
  const [refreshForm, setRefreshForm] = useState(false);

  const {
    main_color,
    second_color,
    success_color,
    danger_color,
    warning_color,
    info_color,
    inverse_color,
    dark_color,
    light_color,
    menu_color,
    submenu_color,
    header_color,
    text_color,
    link_color,
    title_color
  } = config;
  
  const initialValues = {
    mainColor: main_color,
    secondColor: second_color,
    successColor: success_color,
    dangerColor: danger_color,
    warningColor: warning_color,
    infoColor: info_color,
    inverseColor: inverse_color,
    darkColor: dark_color,
    lightColor: light_color,
    menuColor: menu_color,
    submenuColor: submenu_color,
    headerColor: header_color,
    textColor: text_color,
    linkColor: link_color,
    titleColor: title_color,
  }
  
  const handleConfigSubmit = (values) =>{
    const {
      mainColor,
      secondColor,
      successColor,
      dangerColor,
      warningColor,
      infoColor,
      inverseColor,
      darkColor,
      lightColor,
      menuColor,
      submenuColor,
      headerColor,
      textColor,
      linkColor,
      titleColor
    } = values;

    const colorData = {
      main_color: mainColor,
      second_color: secondColor,
      success_color: successColor,
      danger_color: dangerColor,
      warning_color: warningColor,
      info_color: infoColor,
      inverse_color: inverseColor,
      dark_color: darkColor,
      light_color: lightColor,
      menu_color: menuColor,
      submenu_color: submenuColor,
      header_color: headerColor,
      text_color: textColor,
      title_color: titleColor,
      link_color: linkColor,
    }

    const data = {
      logo: 'https://jovemnerd.com.br/wp-content/themes/jovem-nerd-v8/assets/images/logo-jovemnerd.png',
      domain: domain,
      main_color: '#000',
      second_color: GetTheme.parseThemeToString(colorData)
    }

    if(window.confirm("Tem certeza que deseja aplicar as alterações? A página será recarregada")){
      if(configId){
        data._id = configId;
        API.put(`/config/${configId}`, data ).then((response) => {
          history.go(0);
        }).catch((err) => {
          enqueueSnackbar(Messages.error.not_config_erro, {variant: 'error'});
        });
        
      }else{
        API.post(`/config`, data ).then((response) => {
          history.go(0);
        }).catch((err) => {
          enqueueSnackbar(Messages.error.not_config_erro, {variant: 'error'});
        })
      }
    }
    
  }

  return (
      <CustonDrawerConfig>
        <CardContent>
            <Formik
              initialValues={initialValues}
              validationSchema={ConfigValidation}
              onSubmit={(values) => handleConfigSubmit(values)}
            >
            {(props) => {
                const { values, touched, errors, handleChange, handleBlur, handleSubmit, handleReset} = props;

                return(
                  <form onSubmit={handleSubmit}>

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Menu principal"
                      type="text"
                      name="menuColor"
                      id="menuColor"
                      helperText={(errors.menuColor && touched.menuColor) && errors.menuColor}
                      error={errors.menuColor && touched.menuColor}
                      value={values.menuColor}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Cor do submenu"
                      type="text"
                      name="submenuColor"
                      id="submenuColor"
                      helperText={(errors.submenuColor && touched.submenuColor) && errors.submenuColor}
                      error={errors.submenuColor && touched.submenuColor}
                      value={values.submenuColor}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Cor do cabeçalho"
                      type="text"
                      name="headerColor"
                      id="headerColor"
                      helperText={(errors.headerColor && touched.headerColor) && errors.headerColor}
                      error={errors.headerColor && touched.headerColor}
                      value={values.headerColor}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Cor de título"
                      type="text"
                      name="titleColor"
                      id="titleColor"
                      helperText={(errors.titleColor && touched.titleColor) && errors.titleColor}
                      error={errors.titleColor && touched.titleColor}
                      value={values.titleColor}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Cor de texto"
                      type="text"
                      name="textColor"
                      id="textColor"
                      helperText={(errors.textColor && touched.textColor) && errors.textColor}
                      error={errors.textColor && touched.textColor}
                      value={values.textColor}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Cor de link"
                      type="text"
                      name="linkColor"
                      id="linkColor"
                      helperText={(errors.linkColor && touched.linkColor) && errors.linkColor}
                      error={errors.linkColor && touched.linkColor}
                      value={values.linkColor}
                    />

                    <CustomInput
                      onChange={handleChange}
                      onBlur={handleBlur}
                      fullWidth
                      size="small"
                      label="Cor principal"
                      type="text"
                      name="mainColor"
                      id="mainColor"
                      helperText={(errors.mainColor && touched.mainColor) && errors.mainColor}
                      error={errors.mainColor && touched.mainColor}
                      value={values.mainColor}
                    />

                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor secundária"
                        type="text"
                        name="secondColor"
                        id="secondColor"
                        helperText={(errors.secondColor && touched.secondColor) && errors.secondColor}
                        error={errors.secondColor && touched.secondColor}
                        value={values.secondColor}
                    />

                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor de confirmação"
                        type="text"
                        name="successColor"
                        id="successColor"
                        helperText={(errors.successColor && touched.successColor) && errors.successColor}
                        error={errors.successColor && touched.successColor}
                        value={values.successColor}
                    />
                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor de erro"
                        type="text"
                        name="dangerColor"
                        id="dangerColor"
                        helperText={(errors.dangerColor && touched.dangerColor) && errors.dangerColor}
                        error={errors.dangerColor && touched.dangerColor}
                        value={values.dangerColor}
                    />

                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor de aviso"
                        type="text"
                        name="warningColor"
                        id="warningColor"
                        helperText={(errors.warningColor && touched.warningColor) && errors.warningColor}
                        error={errors.warningColor && touched.warningColor}
                        value={values.warningColor}
                    />
                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor de informação"
                        type="text"
                        name="infoColor"
                        id="infoColor"
                        helperText={(errors.infoColor && touched.infoColor) && errors.infoColor}
                        error={errors.infoColor && touched.infoColor}
                        value={values.infoColor}
                    />

                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor inversa"
                        type="text"
                        name="inverseColor"
                        id="inverseColor"
                        helperText={(errors.inverseColor && touched.inverseColor) && errors.inverseColor}
                        error={errors.inverseColor && touched.inverseColor}
                        value={values.inverseColor}
                    />

                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor escura"
                        type="text"
                        name="darkColor"
                        id="darkColor"
                        helperText={(errors.darkColor && touched.darkColor) && errors.darkColor}
                        error={errors.darkColor && touched.darkColor}
                        value={values.darkColor}
                    />

                    <CustomInput
                        onChange={handleChange}
                        onBlur={handleBlur}
                        fullWidth
                        size="small"
                        label="Cor clara"
                        type="text"
                        name="lightColor"
                        id="lightColor"
                        helperText={(errors.lightColor && touched.lightColor) && errors.lightColor}
                        error={errors.lightColor && touched.lightColor}
                        value={values.lightColor}
                    />
                    
                    <CustomButton
                        type="submit"
                        label={'Salvar'}
                        bg={'success_background'}
                        color={'light_color'}
                        fullwidth
                        size="small"
                        size="small"
                    />

                </form>
                )
            }}
            </Formik>
        </CardContent>
      </CustonDrawerConfig>
          
  );
}

export default ConfigComponent;