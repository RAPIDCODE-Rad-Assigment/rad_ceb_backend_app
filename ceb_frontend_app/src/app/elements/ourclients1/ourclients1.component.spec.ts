import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ourclients1Component } from './ourclients1.component';

describe('Ourclients1Component', () => {
  let component: Ourclients1Component;
  let fixture: ComponentFixture<Ourclients1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Ourclients1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Ourclients1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
