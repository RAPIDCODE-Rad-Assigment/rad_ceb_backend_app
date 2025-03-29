import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Buildfuture1Component } from './buildfuture1.component';

describe('Buildfuture1Component', () => {
  let component: Buildfuture1Component;
  let fixture: ComponentFixture<Buildfuture1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Buildfuture1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Buildfuture1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
