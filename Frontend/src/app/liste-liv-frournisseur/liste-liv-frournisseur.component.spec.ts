import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeLivFrournisseurComponent } from './liste-liv-frournisseur.component';

describe('ListeLivFrournisseurComponent', () => {
  let component: ListeLivFrournisseurComponent;
  let fixture: ComponentFixture<ListeLivFrournisseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeLivFrournisseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeLivFrournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
