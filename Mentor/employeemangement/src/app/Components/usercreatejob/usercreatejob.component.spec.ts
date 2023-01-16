import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsercreatejobComponent } from './usercreatejob.component';

describe('UsercreatejobComponent', () => {
  let component: UsercreatejobComponent;
  let fixture: ComponentFixture<UsercreatejobComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsercreatejobComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsercreatejobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
