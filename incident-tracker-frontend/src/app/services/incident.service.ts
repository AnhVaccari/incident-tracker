import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {
  CreateIncidentRequest,
  Incident,
  StatusUpdateRequest,
} from '../interfaces/incident.interface';

@Injectable({
  providedIn: 'root',
})
export class IncidentService {
  private apiUrl = 'http://localhost:8080/api/incidents';

  constructor(private http: HttpClient) {}

  // Récupérer tous les incidents
  getAllIncidents(): Observable<Incident[]> {
    return this.http.get<Incident[]>(this.apiUrl);
  }

  // Créer un incident
  createIncident(request: CreateIncidentRequest): Observable<Incident> {
    return this.http.post<Incident>(this.apiUrl, request);
  }

  // Changer le statut
  changeStatus(id: number, request: StatusUpdateRequest): Observable<Incident> {
    return this.http.put<Incident>(`${this.apiUrl}/${id}/status`, request);
  }
}
