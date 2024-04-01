import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditNeedComponent } from './edit-need.component';

describe('EditNeedComponent', () => {
  let component: EditNeedComponent;
  let fixture: ComponentFixture<EditNeedComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditNeedComponent]
    });
    fixture = TestBed.createComponent(EditNeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
