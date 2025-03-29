import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutSection4Component } from './about-section4.component';

describe('AboutSection4Component', () => {
  let component: AboutSection4Component;
  let fixture: ComponentFixture<AboutSection4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutSection4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutSection4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
