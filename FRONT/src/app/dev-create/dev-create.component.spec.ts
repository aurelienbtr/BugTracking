import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevCreateComponent } from './dev-create.component';

describe('DevCreateComponent', () => {
  let component: DevCreateComponent;
  let fixture: ComponentFixture<DevCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
