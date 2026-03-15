import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserControl } from './user-control';

describe('UserControl', () => {
  let component: UserControl;
  let fixture: ComponentFixture<UserControl>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserControl]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserControl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
