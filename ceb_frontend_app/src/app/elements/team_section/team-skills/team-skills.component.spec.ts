import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamSkillsComponent } from './team-skills.component';

describe('TeamSkillsComponent', () => {
  let component: TeamSkillsComponent;
  let fixture: ComponentFixture<TeamSkillsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeamSkillsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamSkillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
