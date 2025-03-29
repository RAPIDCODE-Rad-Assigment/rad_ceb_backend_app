import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxRecentPostsComponent } from './box-recent-posts.component';

describe('BoxRecentPostsComponent', () => {
  let component: BoxRecentPostsComponent;
  let fixture: ComponentFixture<BoxRecentPostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoxRecentPostsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoxRecentPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
