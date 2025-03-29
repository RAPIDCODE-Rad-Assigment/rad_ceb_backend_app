import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Facts2Component } from './facts2.component';

describe('Facts2Component', () => {
  let component: Facts2Component;
  let fixture: ComponentFixture<Facts2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Facts2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Facts2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
