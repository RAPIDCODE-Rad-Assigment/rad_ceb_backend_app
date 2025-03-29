import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceSection1Component } from './service-section1.component';

describe('ServiceSection1Component', () => {
  let component: ServiceSection1Component;
  let fixture: ComponentFixture<ServiceSection1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceSection1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceSection1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
