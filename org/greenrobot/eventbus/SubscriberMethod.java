package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class SubscriberMethod {
    final Class eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method method0, Class class0, ThreadMode threadMode0, int v, boolean z) {
        this.method = method0;
        this.threadMode = threadMode0;
        this.eventType = class0;
        this.priority = v;
        this.sticky = z;
    }

    private void checkMethodString() {
        synchronized(this) {
            if(this.methodString == null) {
                this.methodString = this.method.getDeclaringClass().getName() + '#' + this.method.getName() + '(' + this.eventType.getName();
            }
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof SubscriberMethod) {
            this.checkMethodString();
            ((SubscriberMethod)object0).checkMethodString();
            return this.methodString.equals(((SubscriberMethod)object0).methodString);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.method.hashCode();
    }
}

