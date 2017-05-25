import {inject, TestBed} from '@angular/core/testing';

import {AttendanceService} from './attendance.service';

describe('AttendanceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AttendanceService]
    });
  });

  it('should ...', inject([AttendanceService], (service: AttendanceService) => {
    expect(service).toBeTruthy();
  }));
});
