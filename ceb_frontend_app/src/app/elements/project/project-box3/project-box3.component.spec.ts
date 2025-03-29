import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectBox3Component } from './project-box3.component';

describe('ProjectBox3Component', () => {
  let component: ProjectBox3Component;
  let fixture: ComponentFixture<ProjectBox3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectBox3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectBox3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
