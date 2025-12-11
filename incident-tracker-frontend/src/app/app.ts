import { Component, signal } from '@angular/core';
import { IncidentListComponent } from './components/incident-list/incident-list.component';

@Component({
  selector: 'app-root',
  imports: [IncidentListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('incident-tracker-frontend');
}
