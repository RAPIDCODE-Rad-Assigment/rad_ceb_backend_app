import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxService1Component } from './box-service1.component';

describe('BoxService1Component', () => {
  let component: BoxService1Component;
  let fixture: ComponentFixture<BoxService1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxService1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoxService1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
