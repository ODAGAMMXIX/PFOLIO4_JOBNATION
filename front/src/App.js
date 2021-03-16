import react, {useState, useEffect} from 'react';
import {Router} from 'react-router-dom';
import { CircularProgress } from '@material-ui/core/'
import {GetLocalConfig, GetTheme, GetDefaultTheme, JsonToStringSetLocal} from './services/theme';
import { useSnackbar } from 'notistack';
import { Messages } from './services/messages';

import Routes from './routes';
import history from './services/history';
import API from './services/api';

import ThemeContext from './store/ThemeContext';

import GlobalStyle from './styles/global';

function App() {

  const { enqueueSnackbar } = useSnackbar();

  const [loaded, setLoaded] = useState(false);
  const [domain] = useState(window.location.origin);
  const [defaultTheme, setDefaultTheme] = useState(true);
  const [themeContextValue, setThemeContextValue] = useState(undefined);
  const [themeStyles, setThemeStyles] = useState(false);

  // useEffect(() => {
  //   const data = {domain: domain};
  //   if(!themeContextValue){
  //     API.post('/config/get', data ).then((response) => {
  //       setThemeContextValue(response.data);
  //       setLoaded(false);
  //     }).catch((err) => {
  //       setLoaded(false);
  //       setDefaultTheme(true);
  //       enqueueSnackbar(Messages.error.not_config_erro, {variant: 'error'});
  //     })
  //   }else{
  //     setLoaded(false);
  //   }
  // }, [])

  return (loaded) ? <CircularProgress />
  : 
    <ThemeContext.Provider value={themeContextValue}>
      <Router history={history}>
        <Routes />
        {(!loaded && !defaultTheme) && <GlobalStyle theme={themeContextValue && GetTheme.parseThemetoJson(themeContextValue.second_color)} />}
        {(!loaded && defaultTheme) && <GlobalStyle theme={GetDefaultTheme()} />}
      </Router>
    </ThemeContext.Provider>
    
}

export default App;
