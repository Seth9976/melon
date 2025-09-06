package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

public interface ActivityRecognitionClient extends HasApiKey {
    Task removeActivityTransitionUpdates(PendingIntent arg1);

    Task removeActivityUpdates(PendingIntent arg1);

    Task removeSleepSegmentUpdates(PendingIntent arg1);

    Task requestActivityTransitionUpdates(ActivityTransitionRequest arg1, PendingIntent arg2);

    Task requestActivityUpdates(long arg1, PendingIntent arg2);

    Task requestSleepSegmentUpdates(PendingIntent arg1, SleepSegmentRequest arg2);
}

