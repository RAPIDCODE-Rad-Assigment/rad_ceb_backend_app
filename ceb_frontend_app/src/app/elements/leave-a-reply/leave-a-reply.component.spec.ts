import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveAReplyComponent } from './leave-a-reply.component';

describe('LeaveAReplyComponent', () => {
  let component: LeaveAReplyComponent;
  let fixture: ComponentFixture<LeaveAReplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaveAReplyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveAReplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
