import React, {useEffect, useState} from 'react';
import {useHistory} from 'react-router-dom';
import {Card, CardContent, Grid} from '@material-ui/core';
import {CustomInput, CustonTitle, CustomFormFooter} from '../../components/Custom.component';
import { useSnackbar } from 'notistack';
import { Messages } from '../../services/messages';
import {useParams} from 'react-router-dom';
import {Formik} from 'formik';
import {NewEditJobValidation} from '../../services/validations';
import {Links} from '../../services/links';

import API from '../../services/api';

const initValues = {
  title: '',
  description: ''
}

function JobsNew() {

  const params = useParams();
  const history = useHistory();
  const { enqueueSnackbar } = useSnackbar();
  
  const title = params?.id ? "Editar vaga" : "Nova vaga"
  const [refreshForm, setRefreshForm] = useState(false);
  const [initialValues, setInitialValues] = useState(initValues); 

  const links = [
    Links('jobs')
  ]

  const handleSubmit = (values) =>{
    if(params?.id){
      values.id = params?.id;
      // console.log(values);
      API.put(`/jobs/${params?.id}`, values).then((res) => {
        enqueueSnackbar(Messages.success.save_success, {variant: 'success'});
      }).catch((error) => {
        enqueueSnackbar(Messages.error.save_failed, {variant: 'error'});
      })
    }else{
      // console.log(values);
      API.post(`/jobs/${params?.id}`, values).then((res) => {
        enqueueSnackbar(Messages.success.save_success, {variant: 'success'});
      }).catch((error) => {
        enqueueSnackbar(Messages.error.save_failed, {variant: 'error'});
      })
    }

  }

  function handleDelete (){
    API.delete(`/jobs/${params?.id}`).then((res) => {
      enqueueSnackbar(Messages.success.save_success, {variant: 'success'});
      history.push('/jobs');
    }).catch((error) => {
      enqueueSnackbar(Messages.error.delete_failed, {variant: 'error'});
    })
  }

  useEffect(() => {
    if(params?.id){
      setRefreshForm(true);
      setInitialValues({title: 'teste', description: '123'});
      enqueueSnackbar(Messages.success.loaded, {variant: 'success'});
    }
  }, [])

  return (
      <>
        <Formik
          initialValues={initialValues}
          validationSchema={NewEditJobValidation}
          onSubmit={(values) => handleSubmit(values)}
          enableReinitialize={refreshForm}
        >
          {(props) => {
          const { values, touched, errors, handleChange, handleBlur, handleSubmit, handleReset} = props;
          return(
            <form onSubmit={handleSubmit} style={{height: '100%', display:'flex', flexDirection:'column', justifyContent:'space-between'}}>
              <CardContent>
                <CustonTitle links={links} title={title} showView={params?.id && "true"} linkShowItem="/jobs/view/" id={params?.id} />

                <Grid container spacing={3}>
                  <Grid item xs={12} md={8}>
                    <Card style={{marginBottom: '70px'}}>
                      <CardContent>
                        <CustomInput
                          onChange={handleChange}
                          onBlur={handleBlur}
                          fullWidth
                          label="Título"
                          type="text"
                          size="small"
                          name="title"
                          id="title"
                          helperText={(errors.title && touched.title) && errors.title}
                          error={errors.title && touched.title}
                          value={values.title}
                        />

                        <CustomInput
                          onChange={handleChange}
                          onBlur={handleBlur}
                          fullWidth
                          label="Descrição"
                          type="text"
                          size="small"
                          name="description"
                          id="description"
                          helperText={(errors.description && errors.description) && errors.description}
                          error={errors.description && touched.description}
                          value={values.description}
                          multiline
                          rows="5"
                        />

                      </CardContent>
                    </Card>
                  </Grid>
                </Grid>

              </CardContent>

              <CustomFormFooter showDelete={params?.id && "true"} handleDelete={handleDelete}/>

            </form>
          )}}
        </Formik>
      </>
      
  );
}

export default JobsNew;