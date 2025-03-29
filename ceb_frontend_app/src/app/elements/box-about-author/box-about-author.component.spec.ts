import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxAboutAuthorComponent } from './box-about-author.component';

describe('BoxAboutAuthorComponent', () => {
  let component: BoxAboutAuthorComponent;
  let fixture: ComponentFixture<BoxAboutAuthorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxAboutAuthorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoxAboutAuthorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
