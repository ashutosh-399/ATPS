import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleControl } from './vehicle-control';

describe('VehicleControl', () => {
  let component: VehicleControl;
  let fixture: ComponentFixture<VehicleControl>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VehicleControl]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehicleControl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
