import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { IncidentService } from '../../services/incident.service';
import { Incident } from '../../interfaces/incident.interface';

@Component({
  selector: 'app-incident-list',
  imports: [CommonModule],
  templateUrl: './incident-list.component.html',
  styleUrl: './incident-list.component.css',
})
export class IncidentListComponent implements OnInit {
  incidents: Incident[] = [];
  isLoading = false;

  constructor(private incidentService: IncidentService) {}

  ngOnInit(): void {
    this.loadIncidents();
  }

  loadIncidents(): void {
    this.isLoading = true;
    this.incidentService.getAllIncidents().subscribe({
      next: (data) => {
        this.incidents = data;
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Erreur lors du chargement:', error);
        this.isLoading = false;
      },
    });
  }

  changeStatus(incident: Incident, newStatus: string): void {
    if (incident.id) {
      this.incidentService.changeStatus(incident.id, { status: newStatus as any }).subscribe({
        next: () => {
          this.loadIncidents(); // Recharge la liste
        },
        error: (error) => {
          console.error('Erreur changement statut:', error);
        },
      });
    }
  }
}
