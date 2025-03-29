import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectBox1Component } from './project-box1.component';

describe('ProjectBox1Component', () => {
  let component: ProjectBox1Component;
  let fixture: ComponentFixture<ProjectBox1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectBox1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectBox1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
