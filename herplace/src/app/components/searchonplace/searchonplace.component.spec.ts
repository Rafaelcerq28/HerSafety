import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchonplaceComponent } from './searchonplace.component';

describe('SearchonplaceComponent', () => {
  let component: SearchonplaceComponent;
  let fixture: ComponentFixture<SearchonplaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchonplaceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchonplaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
