import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectBox4Component } from './project-box4.component';

describe('ProjectBox4Component', () => {
  let component: ProjectBox4Component;
  let fixture: ComponentFixture<ProjectBox4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectBox4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectBox4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
