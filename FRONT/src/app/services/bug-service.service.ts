import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bug } from '../models/bug';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BugsService {

  constructor(private http: HttpClient) { }

  public findById(id: number): Observable<Bug>
  {
    return this.http.get<Bug>(`${environment.url}/bug/${id}`);
  }

  public getAllBugs(): Observable<Bug[]>
  {
    return this.http.get<Bug[]>(`${environment.url}/bug`);
  }

  public createBug(bug: Bug): Observable<Bug>
  {
    return this.http.post<Bug>(`${environment.url}/bug`, bug);
  }

  public getBugByTitle(titre: String): Observable<Bug[]>
  {
    return this.http.get<Bug[]>(`${environment.url}/bug/titre`);
  }

  public getBugByEtat(etat: String): Observable<Bug[]>
  {
    return this.http.get<Bug[]>(`${environment.url}/bug/etat`);
  }

 

  public ajoutDev(bug: Bug, id: number, iddev: number): Observable<Bug>
  {
    return this.http.put<Bug>(`${environment.url}/bug/${id}/dev/${iddev}`, bug);
  }
}