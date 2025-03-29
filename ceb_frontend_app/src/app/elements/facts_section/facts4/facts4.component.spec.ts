import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Facts4Component } from './facts4.component';

describe('Facts4Component', () => {
  let component: Facts4Component;
  let fixture: ComponentFixture<Facts4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Facts4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Facts4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
