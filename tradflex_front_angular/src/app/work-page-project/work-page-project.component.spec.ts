import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkPageProjectComponent } from './work-page-project.component';

describe('WorkPageProjectComponent', () => {
  let component: WorkPageProjectComponent;
  let fixture: ComponentFixture<WorkPageProjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkPageProjectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkPageProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
