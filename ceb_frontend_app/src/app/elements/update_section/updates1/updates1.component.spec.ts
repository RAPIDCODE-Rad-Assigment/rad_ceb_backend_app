import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Updates1Component } from './updates1.component';

describe('Updates1Component', () => {
  let component: Updates1Component;
  let fixture: ComponentFixture<Updates1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Updates1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Updates1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
