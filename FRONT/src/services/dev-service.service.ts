import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Developpeur } from '../models/Developpeur';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment'


@Injectable({
  providedIn: 'root'
})
export class DevService {

  constructor(private http: HttpClient) { }

  public getDeveloppeursList(): Observable<Developpeur[]> {
    return this.http.get<Developpeur[]>(`${environment.url}/developpeurs`);
  }

  public deleteDeveloppeur(id: number): Observable<any> {
    return this.http.delete(`${environment.url}/developpeur/${id}`);
  }
  public createDeveloppeur(dev: Developpeur): Observable<Developpeur> {
    return this.http.post<Developpeur>(`${environment.url}/developpeur`, dev);
  }
}