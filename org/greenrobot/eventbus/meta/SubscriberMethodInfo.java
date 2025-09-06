package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethodInfo {
    final Class eventType;
    final String methodName;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethodInfo(String s, Class class0) {
        this(s, class0, ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethodInfo(String s, Class class0, ThreadMode threadMode0) {
        this(s, class0, threadMode0, 0, false);
    }

    public SubscriberMethodInfo(String s, Class class0, ThreadMode threadMode0, int v, boolean z) {
        this.methodName = s;
        this.threadMode = threadMode0;
        this.eventType = class0;
        this.priority = v;
        this.sticky = z;
    }
}

