import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TousLesFilmsComponent } from './tous-les-films.component';

describe('TousLesFilmsComponent', () => {
  let component: TousLesFilmsComponent;
  let fixture: ComponentFixture<TousLesFilmsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TousLesFilmsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TousLesFilmsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
