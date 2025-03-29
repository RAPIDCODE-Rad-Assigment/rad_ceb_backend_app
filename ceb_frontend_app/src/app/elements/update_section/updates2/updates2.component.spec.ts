import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Updates2Component } from './updates2.component';

describe('Updates2Component', () => {
  let component: Updates2Component;
  let fixture: ComponentFixture<Updates2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Updates2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Updates2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
