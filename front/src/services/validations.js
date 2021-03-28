import * as Yup from 'yup';
import {Messages} from './messages'

export const LoginValidation = Yup.object().shape({
    email: Yup.string().email(Messages.error.email_format).required(Messages.error.required),
    password: Yup.string().required(Messages.error.required)
});

export const FirsAccessValidation = Yup.object().shape({
    doc: Yup.string().required(Messages.error.required),
    username: Yup.string().required(Messages.error.required)
});

export const ConfigValidation = Yup.object().shape({
    mainColor: Yup.string().required(Messages.error.required),
    secondColor: Yup.string().required(Messages.error.required),
    successColor: Yup.string().required(Messages.error.required),
    dangerColor: Yup.string().required(Messages.error.required),
    warningColor: Yup.string().required(Messages.error.required),
    infoColor: Yup.string().required(Messages.error.required),
    inverseColor: Yup.string().required(Messages.error.required),
    darkColor: Yup.string().required(Messages.error.required),
    lightColor: Yup.string().required(Messages.error.required),
});

export const NewEditJobValidation = Yup.object().shape({
    title: Yup.string().required(Messages.error.required),
    description: Yup.string().required(Messages.error.required)
})