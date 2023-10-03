import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentLocationMapComponent } from './current-location-map.component';

describe('CurrentLocationMapComponent', () => {
  let component: CurrentLocationMapComponent;
  let fixture: ComponentFixture<CurrentLocationMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurrentLocationMapComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CurrentLocationMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
