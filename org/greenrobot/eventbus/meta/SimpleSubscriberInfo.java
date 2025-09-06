package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class class0, boolean z, SubscriberMethodInfo[] arr_subscriberMethodInfo) {
        super(class0, null, z);
        this.methodInfos = arr_subscriberMethodInfo;
    }

    @Override  // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberMethod[] getSubscriberMethods() {
        synchronized(this) {
            SubscriberMethod[] arr_subscriberMethod = new SubscriberMethod[this.methodInfos.length];
            for(int v1 = 0; v1 < this.methodInfos.length; ++v1) {
                SubscriberMethodInfo subscriberMethodInfo0 = this.methodInfos[v1];
                arr_subscriberMethod[v1] = this.createSubscriberMethod(subscriberMethodInfo0.methodName, subscriberMethodInfo0.eventType, subscriberMethodInfo0.threadMode, subscriberMethodInfo0.priority, subscriberMethodInfo0.sticky);
            }
            return arr_subscriberMethod;
        }
    }
}

