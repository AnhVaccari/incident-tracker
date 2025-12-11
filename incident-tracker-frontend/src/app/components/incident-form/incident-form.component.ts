import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { IncidentService } from '../../services/incident.service';
import { CreateIncidentRequest } from '../../interfaces/incident.interface';

@Component({
  selector: 'app-incident-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './incident-form.component.html',
  styleUrl: './incident-form.component.css',
})
export class IncidentFormComponent {
  incidentForm: FormGroup;
  isSubmitting = false;
  showForm = false;

  priorities = [
    { value: 'LOW', label: 'Faible' },
    { value: 'NORMAL', label: 'Normale' },
    { value: 'HIGH', label: 'Haute' },
    { value: 'CRITICAL', label: 'Critique' },
  ];

  constructor(private fb: FormBuilder, private incidentService: IncidentService) {
    this.incidentForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      description: ['', [Validators.required, Validators.minLength(10)]],
      priority: ['NORMAL', [Validators.required]],
    });
  }

  toggleForm(): void {
    this.showForm = !this.showForm;
    if (!this.showForm) {
      this.incidentForm.reset();
    }
  }

  onSubmit(): void {
    if (this.incidentForm.valid) {
      this.isSubmitting = true;
      const request: CreateIncidentRequest = this.incidentForm.value;

      this.incidentService.createIncident(request).subscribe({
        next: () => {
          this.isSubmitting = false;
          this.toggleForm();
          // Émettre un événement pour recharger la liste d'incidents
          window.location.reload(); // Solution rapide
        },
        error: (error) => {
          console.error('Erreur création:', error);
          this.isSubmitting = false;
        },
      });
    }
  }
}
