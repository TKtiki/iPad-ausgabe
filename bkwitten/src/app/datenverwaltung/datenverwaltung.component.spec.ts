import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DatenverwaltungComponent } from './datenverwaltung.component';

describe('DatenverwaltungComponent', () => {
  let component: DatenverwaltungComponent;
  let fixture: ComponentFixture<DatenverwaltungComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatenverwaltungComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatenverwaltungComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
