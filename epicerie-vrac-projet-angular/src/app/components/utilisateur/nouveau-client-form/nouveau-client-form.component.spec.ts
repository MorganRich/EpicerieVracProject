import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauClientFormComponent } from './nouveau-client-form.component';

describe('NouveauClientFormComponent', () => {
  let component: NouveauClientFormComponent;
  let fixture: ComponentFixture<NouveauClientFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NouveauClientFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauClientFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
