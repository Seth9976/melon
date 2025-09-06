package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class superSubscriberInfoClass;

    public AbstractSubscriberInfo(Class class0, Class class1, boolean z) {
        this.subscriberClass = class0;
        this.superSubscriberInfoClass = class1;
        this.shouldCheckSuperclass = z;
    }

    public SubscriberMethod createSubscriberMethod(String s, Class class0) {
        return this.createSubscriberMethod(s, class0, ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethod createSubscriberMethod(String s, Class class0, ThreadMode threadMode0) {
        return this.createSubscriberMethod(s, class0, threadMode0, 0, false);
    }

    public SubscriberMethod createSubscriberMethod(String s, Class class0, ThreadMode threadMode0, int v, boolean z) {
        try {
            return new SubscriberMethod(this.subscriberClass.getDeclaredMethod(s, class0), class0, threadMode0, v, z);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", noSuchMethodException0);
        }
    }

    @Override  // org.greenrobot.eventbus.meta.SubscriberInfo
    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    @Override  // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberInfo getSuperSubscriberInfo() {
        Class class0 = this.superSubscriberInfoClass;
        if(class0 == null) {
            return null;
        }
        try {
            return (SubscriberInfo)class0.newInstance();
        }
        catch(InstantiationException instantiationException0) {
            throw new RuntimeException(instantiationException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
    }

    @Override  // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }
}

