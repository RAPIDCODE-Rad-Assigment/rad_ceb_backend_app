import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutSection6Component } from './about-section6.component';

describe('AboutSection6Component', () => {
  let component: AboutSection6Component;
  let fixture: ComponentFixture<AboutSection6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutSection6Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutSection6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
