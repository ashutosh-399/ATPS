import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TollControl } from './toll-control';

describe('TollControl', () => {
  let component: TollControl;
  let fixture: ComponentFixture<TollControl>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TollControl]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TollControl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
