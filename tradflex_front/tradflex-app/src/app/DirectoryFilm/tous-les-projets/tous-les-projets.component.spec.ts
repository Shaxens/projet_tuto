import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TousLesProjetsComponent } from './tous-les-projets.component';

describe('TousLesProjetsComponent', () => {
  let component: TousLesProjetsComponent;
  let fixture: ComponentFixture<TousLesProjetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TousLesProjetsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TousLesProjetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
