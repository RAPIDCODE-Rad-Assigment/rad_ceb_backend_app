import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Facts1Component } from './facts1.component';

describe('Facts1Component', () => {
  let component: Facts1Component;
  let fixture: ComponentFixture<Facts1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Facts1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Facts1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
