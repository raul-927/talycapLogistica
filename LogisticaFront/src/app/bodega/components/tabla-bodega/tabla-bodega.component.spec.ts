import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaBodegaComponent } from './tabla-bodega.component';

describe('TablaBodegaComponent', () => {
  let component: TablaBodegaComponent;
  let fixture: ComponentFixture<TablaBodegaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaBodegaComponent]
    });
    fixture = TestBed.createComponent(TablaBodegaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
