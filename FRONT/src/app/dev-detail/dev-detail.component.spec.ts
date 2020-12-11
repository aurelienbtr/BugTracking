import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevDetailComponent } from './dev-detail.component';

describe('DevDetailComponent', () => {
  let component: DevDetailComponent;
  let fixture: ComponentFixture<DevDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
