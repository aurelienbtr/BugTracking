import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BugFindComponent } from './bug-find.component';

describe('BugFindComponent', () => {
  let component: BugFindComponent;
  let fixture: ComponentFixture<BugFindComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BugFindComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BugFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
