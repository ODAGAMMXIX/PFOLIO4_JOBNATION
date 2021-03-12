

import react, {useState, useEffect} from 'react';

import {Router} from 'react-router-dom';
import { CircularProgress } from '@material-ui/core/'
import Routes from './routes';
import history from './services/history';
import API from './services/api';

import GlobalStyle from './styles/global'

function App() {

  const [loaded, setLoaded] = useState(false);
  const [domain] = useState(window.location.origin);

  useEffect(() => {

    const data = {domain: domain}

    API.post('/config/get', data ).then((response) => {
      setLoaded(false);
    }).catch((err) => {
      console.log(err);
    })

  }, [])

  return loaded ? <CircularProgress />
  : <Router history={history}>
      <Routes />
      <GlobalStyle />
    </Router>
    
}

export default App;
