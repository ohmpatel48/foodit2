import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import * as mapboxgl from 'mapbox-gl';
import { environment } from 'src/environments/environment.development';


@Component({
  selector: 'app-current-location-map',
  templateUrl: './current-location-map.component.html',
  styleUrls: ['./current-location-map.component.css']
})
export class CurrentLocationMapComponent implements OnInit {
  latitude: any;
  longitude: any;
  marker: any;
  constructor(
    public dialogRef: MatDialogRef<CurrentLocationMapComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}
  ngOnInit(): void {
    (mapboxgl as typeof mapboxgl).accessToken = environment.mapboxkey.accessToken;
    const map = new mapboxgl.Map({
      container: 'map', // container ID
      style: 'mapbox://styles/mapbox/streets-v12', // style URL
      center: [-74.5, 40], // starting position [lng, lat]
      zoom: 10, // starting zoom
      });
      
      const geolocate = new mapboxgl.GeolocateControl({
        positionOptions: {
        enableHighAccuracy: true
        },
        trackUserLocation: true,
        showUserLocation: false
        });
        // Add the control to the map.
        map.addControl(geolocate);
        map.on('load', () => {
        geolocate.trigger();
        navigator.geolocation.getCurrentPosition((position) => {
          this.latitude = position.coords.latitude;
          this.longitude = position.coords.longitude;
          this.marker = new mapboxgl.Marker({
            color: "#fc0307",
            draggable: true
            }).setLngLat([ position.coords.longitude,position.coords.latitude ])
            .addTo(map);
          });
        });
        
  }
  exit(){
    const a =  this.marker.getLngLat();
    this.latitude = a.lat;
    this.longitude = a.lng;
    this.dialogRef.close({latitude: this.latitude, longitude: this.longitude});
  };
}
