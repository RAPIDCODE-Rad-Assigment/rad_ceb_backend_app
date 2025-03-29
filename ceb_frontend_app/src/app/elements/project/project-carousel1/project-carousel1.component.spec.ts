import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCarousel1Component } from './project-carousel1.component';

describe('ProjectCarousel1Component', () => {
  let component: ProjectCarousel1Component;
  let fixture: ComponentFixture<ProjectCarousel1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectCarousel1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCarousel1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
