function showPosition(position) {

  localStorage.setItem("lat", position.coords.latitude);
  localStorage.setItem("long", position.coords.longitude);
  localStorage.setItem("accuracy", position.coords.accuracy);

}

export const GetLat = () =>{
  return parseFloat(localStorage.getItem("lat"), 10);
}

export const GetLong = () =>{
  return parseFloat(localStorage.getItem("long"), 10);
}

export const GetAccuracy = () =>{
  return parseInt(localStorage.getAccuracy("accuracy"), 10);
}

export const GetCurrentLocation = () => {

  if(navigator.geolocation){
    navigator.geolocation.getCurrentPosition(showPosition);
  }

}