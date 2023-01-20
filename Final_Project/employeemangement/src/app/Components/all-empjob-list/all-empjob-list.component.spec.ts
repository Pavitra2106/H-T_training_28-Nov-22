import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllEmpjobListComponent } from './all-empjob-list.component';

describe('AllEmpjobListComponent', () => {
  let component: AllEmpjobListComponent;
  let fixture: ComponentFixture<AllEmpjobListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllEmpjobListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllEmpjobListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
