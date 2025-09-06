package org.greenrobot.eventbus;

final class Subscription {
    volatile boolean active;
    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    public Subscription(Object object0, SubscriberMethod subscriberMethod0) {
        this.subscriber = object0;
        this.subscriberMethod = subscriberMethod0;
        this.active = true;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof Subscription && this.subscriber == ((Subscription)object0).subscriber && this.subscriberMethod.equals(((Subscription)object0).subscriberMethod);
    }

    @Override
    public int hashCode() {
        return this.subscriberMethod.methodString.hashCode() + this.subscriber.hashCode();
    }
}

