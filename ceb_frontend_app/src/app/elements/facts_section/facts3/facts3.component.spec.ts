import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Facts3Component } from './facts3.component';

describe('Facts3Component', () => {
  let component: Facts3Component;
  let fixture: ComponentFixture<Facts3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Facts3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Facts3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
