import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Facts5Component } from './facts5.component';

describe('Facts5Component', () => {
  let component: Facts5Component;
  let fixture: ComponentFixture<Facts5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Facts5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Facts5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
