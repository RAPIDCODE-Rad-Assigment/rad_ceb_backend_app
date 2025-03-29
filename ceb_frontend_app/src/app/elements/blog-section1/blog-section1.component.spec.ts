import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogSection1Component } from './blog-section1.component';

describe('BlogSection1Component', () => {
  let component: BlogSection1Component;
  let fixture: ComponentFixture<BlogSection1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlogSection1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogSection1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
