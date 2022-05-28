import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireProjetComponent } from './formulaire-projet.component';

describe('FormulaireProjetComponent', () => {
  let component: FormulaireProjetComponent;
  let fixture: ComponentFixture<FormulaireProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulaireProjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaireProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
