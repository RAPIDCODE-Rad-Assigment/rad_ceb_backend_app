import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectBox2Component } from './project-box2.component';

describe('ProjectBox2Component', () => {
  let component: ProjectBox2Component;
  let fixture: ComponentFixture<ProjectBox2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectBox2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectBox2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
