import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogisticaTerrestreComponent } from './logistica-terrestre.component';

describe('LogisticaTerrestreComponent', () => {
  let component: LogisticaTerrestreComponent;
  let fixture: ComponentFixture<LogisticaTerrestreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LogisticaTerrestreComponent]
    });
    fixture = TestBed.createComponent(LogisticaTerrestreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
