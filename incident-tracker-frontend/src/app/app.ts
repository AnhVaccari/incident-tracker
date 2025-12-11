import { Component, signal } from '@angular/core';
import { IncidentListComponent } from './components/incident-list/incident-list.component';
import { IncidentFormComponent } from './components/incident-form/incident-form.component';

@Component({
  selector: 'app-root',
  imports: [IncidentListComponent, IncidentFormComponent],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('incident-tracker-frontend');
}
