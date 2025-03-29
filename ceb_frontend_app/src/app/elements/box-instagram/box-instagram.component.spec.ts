import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxInstagramComponent } from './box-instagram.component';

describe('BoxInstagramComponent', () => {
  let component: BoxInstagramComponent;
  let fixture: ComponentFixture<BoxInstagramComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxInstagramComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoxInstagramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
