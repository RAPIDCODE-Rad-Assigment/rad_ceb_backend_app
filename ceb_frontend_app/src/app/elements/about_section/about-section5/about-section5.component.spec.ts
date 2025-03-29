import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutSection5Component } from './about-section5.component';

describe('AboutSection5Component', () => {
  let component: AboutSection5Component;
  let fixture: ComponentFixture<AboutSection5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutSection5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutSection5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
