import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCarousel2Component } from './project-carousel2.component';

describe('ProjectCarousel2Component', () => {
  let component: ProjectCarousel2Component;
  let fixture: ComponentFixture<ProjectCarousel2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectCarousel2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCarousel2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
