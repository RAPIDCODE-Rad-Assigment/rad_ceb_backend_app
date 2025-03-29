import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutSection7Component } from './about-section7.component';

describe('AboutSection7Component', () => {
  let component: AboutSection7Component;
  let fixture: ComponentFixture<AboutSection7Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutSection7Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutSection7Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
