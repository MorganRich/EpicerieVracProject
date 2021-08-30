import { TestBed } from '@angular/core/testing';

import { GestionPanierService } from './gestion-panier.service';

describe('GestionPanierService', () => {
  let service: GestionPanierService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionPanierService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
