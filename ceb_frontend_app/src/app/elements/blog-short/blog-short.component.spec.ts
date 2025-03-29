import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogShortComponent } from './blog-short.component';

describe('BlogShortComponent', () => {
  let component: BlogShortComponent;
  let fixture: ComponentFixture<BlogShortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlogShortComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogShortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
