import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametreProjetComponent } from './parametre-projet.component';

describe('ParametreProjetComponent', () => {
  let component: ParametreProjetComponent;
  let fixture: ComponentFixture<ParametreProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParametreProjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametreProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
