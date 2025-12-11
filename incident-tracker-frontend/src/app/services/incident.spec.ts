import { TestBed } from '@angular/core/testing';

import { Incident } from './incident.service';

describe('Incident', () => {
  let service: Incident;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Incident);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
