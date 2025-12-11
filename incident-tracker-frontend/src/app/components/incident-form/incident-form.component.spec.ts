import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncidentFormComponent } from './incident-form.component';

describe('IncidentForm', () => {
  let component: IncidentFormComponent;
  let fixture: ComponentFixture<IncidentFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IncidentFormComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(IncidentFormComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
