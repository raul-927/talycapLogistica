import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaCamionComponent } from './tabla-camion.component';

describe('TablaCamionComponent', () => {
  let component: TablaCamionComponent;
  let fixture: ComponentFixture<TablaCamionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaCamionComponent]
    });
    fixture = TestBed.createComponent(TablaCamionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
