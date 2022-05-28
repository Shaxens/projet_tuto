import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutProjetComponent } from './ajout-projet.component';

describe('AjoutProjetComponent', () => {
  let component: AjoutProjetComponent;
  let fixture: ComponentFixture<AjoutProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjoutProjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
