import { TestBed } from '@angular/core/testing';

import { ItemListhttpService } from './itemlisthttp.service';

describe('ItemListhttpService', () => {
  let service: ItemListhttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemListhttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
