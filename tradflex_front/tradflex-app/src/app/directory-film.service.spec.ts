import { TestBed } from '@angular/core/testing';

import { DirectoryFilmService } from './directory-film.service';

describe('DirectoryFilmService', () => {
  let service: DirectoryFilmService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DirectoryFilmService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
