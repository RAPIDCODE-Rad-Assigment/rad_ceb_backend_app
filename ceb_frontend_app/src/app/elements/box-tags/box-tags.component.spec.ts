import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxTagsComponent } from './box-tags.component';

describe('BoxTagsComponent', () => {
  let component: BoxTagsComponent;
  let fixture: ComponentFixture<BoxTagsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxTagsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoxTagsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
