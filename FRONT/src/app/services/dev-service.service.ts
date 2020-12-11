import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Developpeur } from '../models/Developpeur';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment'
import { Event } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class DevService {

  constructor(private http: HttpClient) { }

  public getAllDeveloppeur(): Observable<Developpeur[]> {
    return this.http.get<Developpeur[]>(`${environment.url}/developpeurs`);
  }

  public AddDev(dev: Developpeur): Observable<Developpeur> {
    return this.http.post<Developpeur>(`${environment.url}/developpeur`, dev);
  }
}