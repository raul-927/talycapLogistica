import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogisticaMaritimaComponent } from './logistica-maritima.component';

describe('LogisticaMaritimaComponent', () => {
  let component: LogisticaMaritimaComponent;
  let fixture: ComponentFixture<LogisticaMaritimaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LogisticaMaritimaComponent]
    });
    fixture = TestBed.createComponent(LogisticaMaritimaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
