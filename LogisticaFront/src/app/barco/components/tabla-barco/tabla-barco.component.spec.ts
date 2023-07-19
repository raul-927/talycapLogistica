import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaBarcoComponent } from './tabla-barco.component';

describe('TablaBarcoComponent', () => {
  let component: TablaBarcoComponent;
  let fixture: ComponentFixture<TablaBarcoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaBarcoComponent]
    });
    fixture = TestBed.createComponent(TablaBarcoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
