import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllUserInfoActionComponent } from './all-user-info-action.component';

describe('AllUserInfoActionComponent', () => {
  let component: AllUserInfoActionComponent;
  let fixture: ComponentFixture<AllUserInfoActionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllUserInfoActionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllUserInfoActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
