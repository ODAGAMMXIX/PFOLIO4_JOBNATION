import React, {useEffect, useState, useRef} from 'react';
import {useHistory} from 'react-router-dom';
import { GoogleMap, useJsApiLoader, Marker, InfoWindow } from '@react-google-maps/api';
import {Typography, Button, TextField, Card, CardContent, Grid, CardHeader, Divider} from '@material-ui/core';
import { GetCurrentLocation, GetLat, GetLong, GetAccuracy } from '../services/location';
import AccountBalanceIcon from '@material-ui/icons/AccountBalance';
import jobPlace from '../assets/002-place.png'
// import peoplePlace from '../assets/001-place-1.png'
import redPlace from '../assets/place-red.png'
import bluePlace from '../assets/place-blue.png'

const containerStyle = {
  width: '100%',
  height: '590px'
};

const JobInfoMarker = ({ selectedMarker, setSelectedMarker}) => {
  return (
    <InfoWindow
      position={{lat:selectedMarker.lat, lng:selectedMarker.lng}}
      onCloseClick={() => {
        setSelectedMarker(null);
      }}
    >
      <div>
        <h6>{selectedMarker.name}</h6>
        <p>{selectedMarker.location}</p>
      </div>
    </InfoWindow>
  )
}


const CandidateInfoMarker = ({ selectedMarker, setSelectedMarker, jobId}) => {

  const history = useHistory();

  const handleRedirect = () => {
    history.push(`/candidates/${jobId}/${selectedMarker.id || selectedMarker._id}`)
  }

  return (
    <InfoWindow
      position={{lat: selectedMarker.lat || selectedMarker.location.coordinates[1], lng: selectedMarker.lng || selectedMarker.location.coordinates[0]}}
      onCloseClick={() => {
        setSelectedMarker(null);
      }}
    >
      <div>
        <img src={selectedMarker.avatar_url} style={{width: '50px', height: 'auto', marginBottom: '15px'}} />
        <h6>{selectedMarker.name}</h6>
        <p>{selectedMarker.resume}</p>
        <br/>
        <Button variant="contained" color="primary" size="small" onClick={handleRedirect} fullwidth>Ver candidato</Button>
      </div>
    </InfoWindow>
  )
}

function MapsComponent({job, candidates}) {

  const {lat, lng} = job;

  const jobList = [job];

  const [selectedMarker, setSelectedMarker] = useState(null);
  const [isCandidate, setIsCandidate] = useState(false);
  const [mapCenter, setMapCenter] = useState('');
  const [jobCoords, setJobCoords] = useState({lat: lat, lng: lng})
  const [mapCoords, setMapCoords] = useState(jobCoords)

  const defaultProps = {
    center: mapCoords,
    zoom: 8
  };

  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: process.env.REACT_APP_MAPS
  })

  useEffect(() => {
    const listener = e => {
      if (e.key === "Escape") {
          setSelectedMarker(null);
      }
    };
    window.addEventListener("keydown", listener);
    return () => {
      window.removeEventListener("keydown", listener);
    };
  }, 
  []);

    return isLoaded ? (
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={defaultProps.center}
        zoom={10}
        options={{
          zoomControl: false,
          fullScreenControl: false,
          streetViewControl: false,
          mapTypeControl: false,
        }}
        // onLoad={(e) => {
        //   console.log(e);
        // }}
      >

        {jobList.map(marker => (            
           <Marker                 
              key={marker.id}                 
              position={jobCoords}
              onClick={() => {
                setSelectedMarker(marker);
                setIsCandidate(false);
                setMapCoords(jobCoords);
             }}
             icon={{
              url: redPlace
            }}
           />        
        ))};

        {candidates?.map(candidate => (
          <Marker                 
            key={candidate.id || candidate._id }                 
            position={{lat: candidate.lat || candidate.location.coordinates[1], lng: candidate.lng || candidate.location.coordinates[0]}}
            onClick={() => {
              const data = {
                id: candidate.id || candidate._id,
                lat: candidate.location.coordinates[1],
                lng: candidate.location.coordinates[0],
                name: candidate.name,
                github_user: candidate.github_user,
                resume: candidate.bio,
                avatar_url: candidate.avatar_url
              }

              setSelectedMarker(data);
              setIsCandidate(true);
              setMapCoords({lat: candidate.location.coordinates[1], lng: candidate.location.coordinates[0]});

            }}
            icon={{
              url: bluePlace
            }}
          />  
        ))}

        {selectedMarker && !isCandidate && (
          <JobInfoMarker selectedMarker={selectedMarker} setSelectedMarker={setSelectedMarker} />
        )}

        {selectedMarker && isCandidate && (
          <CandidateInfoMarker selectedMarker={selectedMarker} setSelectedMarker={setSelectedMarker} jobId={job.id} />
        )}

      </GoogleMap>
    ) : <></>
}

export default MapsComponent;