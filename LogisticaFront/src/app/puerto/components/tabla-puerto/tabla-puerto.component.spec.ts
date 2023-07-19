import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaPuertoComponent } from './tabla-puerto.component';

describe('TablaPuertoComponent', () => {
  let component: TablaPuertoComponent;
  let fixture: ComponentFixture<TablaPuertoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaPuertoComponent]
    });
    fixture = TestBed.createComponent(TablaPuertoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
