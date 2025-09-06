package com.iloen.melon.task;

import com.iloen.melon.utils.ClassUtils;
import va.e;

public class TaskState {
    public static final TaskState FINISHED = null;
    public static final TaskState NULL = null;
    public static final TaskState RUNNING = null;
    public static final TaskState STARTED = null;
    public static final int STATUS_FINISHED = 3;
    public static final int STATUS_NULL = 0;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_STARTED = 1;
    public int mProgress;
    public int mStatus;
    public Object mUserData;

    static {
        TaskState.NULL = new TaskState(0);
        TaskState.STARTED = new TaskState(1);
        TaskState.RUNNING = new TaskState(2);
        TaskState.FINISHED = new TaskState(3);
    }

    public TaskState(int v) {
        this(v, 0, null);
    }

    public TaskState(int v, int v1, Object object0) {
        this.mStatus = v;
        this.mProgress = v1;
        this.mUserData = object0;
    }

    public static boolean equals(Object object0, Object object1) {
        if(object0 == object1) {
            return true;
        }
        return object0 == null ? false : object0.equals(object1);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof TaskState && this.mStatus == ((TaskState)object0).mStatus && this.mProgress == ((TaskState)object0).mProgress && ClassUtils.equals(this, ((TaskState)object0));
    }

    public static TaskState getRunningState(int v, Object object0) {
        return new TaskState(2, v, object0);
    }

    @Override
    public int hashCode() {
        return this.mStatus;
    }

    public boolean statusEquals(TaskState taskState0) {
        return taskState0 != null && this.mStatus == taskState0.mStatus;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TaskState {status=");
        stringBuilder0.append(this.mStatus);
        stringBuilder0.append(", progress=");
        stringBuilder0.append(this.mProgress);
        stringBuilder0.append(", userdata:");
        return e.d(stringBuilder0, this.mUserData, "}");
    }
}

