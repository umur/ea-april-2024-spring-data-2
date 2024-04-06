package edu.miu.cs544.labs.lab3.service.impl;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import edu.miu.cs544.labs.lab3.repository.ActivityLogRepo;
import edu.miu.cs544.labs.lab3.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void add(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
