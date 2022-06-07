import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditerProjetComponent } from './editer-projet.component';

describe('EditerProjetComponent', () => {
  let component: EditerProjetComponent;
  let fixture: ComponentFixture<EditerProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditerProjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditerProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
