import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireFilmComponent } from './formulaire-film.component';

describe('FormulaireFilmComponent', () => {
  let component: FormulaireFilmComponent;
  let fixture: ComponentFixture<FormulaireFilmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulaireFilmComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaireFilmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
