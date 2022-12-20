import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutLibraryComponent } from './about-library.component';

describe('AboutLibraryComponent', () => {
  let component: AboutLibraryComponent;
  let fixture: ComponentFixture<AboutLibraryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutLibraryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutLibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
