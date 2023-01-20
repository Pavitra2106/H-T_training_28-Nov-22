import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllJobListComponent } from './all-job-list.component';

describe('AllJobListComponent', () => {
  let component: AllJobListComponent;
  let fixture: ComponentFixture<AllJobListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllJobListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllJobListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
