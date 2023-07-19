import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaLogisticaComponent } from './tabla-logistica.component';

describe('TablaLogisticaComponent', () => {
  let component: TablaLogisticaComponent;
  let fixture: ComponentFixture<TablaLogisticaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaLogisticaComponent]
    });
    fixture = TestBed.createComponent(TablaLogisticaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
