import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxService2Component } from './box-service2.component';

describe('BoxService2Component', () => {
  let component: BoxService2Component;
  let fixture: ComponentFixture<BoxService2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxService2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoxService2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
