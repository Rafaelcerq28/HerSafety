import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakereportComponent } from './makereport.component';

describe('MakereportComponent', () => {
  let component: MakereportComponent;
  let fixture: ComponentFixture<MakereportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MakereportComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MakereportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
