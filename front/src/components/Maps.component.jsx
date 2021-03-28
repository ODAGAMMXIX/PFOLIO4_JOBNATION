import React, {useEffect, useState, useRef} from 'react';
import { GoogleMap, useJsApiLoader, DirectionsRenderer, DirectionsService } from '@react-google-maps/api';
import { GetCurrentLocation, GetLat, GetLong, GetAccuracy } from '../services/location';

const containerStyle = {
  width: '100%',
  height: '300px'
};

function MapsComponent({HandleGetDistance, HandleGetDuration}) {

  const [directions, setDirections] = useState('');

  const defaultProps = {
    center: {
      lat: GetLat(),
      lng: GetLong()
    },
    zoom: 8
  };

  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: process.env.REACT_APP_MAPS
  })

  const position = {
    lat: GetLat(),
    lng: GetLong()
  }

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
      >

        {position !== '' && directions === '' &&
          <DirectionsService
            options={{ 
              destination: 'Rua Professora Maria José de Oliveira, 136, São Jodé sod Campos',
              origin: 'AV. Cidade Jardim, São José dos Campos',
              travelMode: 'DRIVING' //BICYCLING | TRANSIT
            }}
            callback={(res) => {
              setDirections(res);
              HandleGetDistance(res.routes[0]?.legs[0].distance.text);
              HandleGetDuration(res.routes[0]?.legs[0].duration.text);
            }}
          />
        }

        <DirectionsRenderer
          options={{ 
            directions: directions
          }}
        >
        </DirectionsRenderer>

      </GoogleMap>
    ) : <></>
}

export default MapsComponent;