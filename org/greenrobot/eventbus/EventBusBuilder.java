package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    boolean eventInheritance;
    ExecutorService executorService;
    boolean ignoreGeneratedIndex;
    boolean logNoSubscriberMessages;
    boolean logSubscriberExceptions;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    boolean sendNoSubscriberEvent;
    boolean sendSubscriberExceptionEvent;
    List skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List subscriberInfoIndexes;
    boolean throwSubscriberException;

    static {
        EventBusBuilder.DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    }

    public EventBusBuilder() {
        this.logSubscriberExceptions = true;
        this.logNoSubscriberMessages = true;
        this.sendSubscriberExceptionEvent = true;
        this.sendNoSubscriberEvent = true;
        this.eventInheritance = true;
        this.executorService = EventBusBuilder.DEFAULT_EXECUTOR_SERVICE;
    }

    public EventBusBuilder addIndex(SubscriberInfoIndex subscriberInfoIndex0) {
        if(this.subscriberInfoIndexes == null) {
            this.subscriberInfoIndexes = new ArrayList();
        }
        this.subscriberInfoIndexes.add(subscriberInfoIndex0);
        return this;
    }

    public EventBus build() {
        return new EventBus(this);
    }

    public EventBusBuilder eventInheritance(boolean z) {
        this.eventInheritance = z;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService executorService0) {
        this.executorService = executorService0;
        return this;
    }

    public Logger getLogger() {
        Logger logger0 = this.logger;
        return logger0 == null ? Default.get() : logger0;
    }

    // 去混淆评级： 低(40)
    public MainThreadSupport getMainThreadSupport() {
        return this.mainThreadSupport == null ? null : this.mainThreadSupport;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean z) {
        this.ignoreGeneratedIndex = z;
        return this;
    }

    public EventBus installDefaultEventBus() {
        synchronized(EventBus.class) {
            if(EventBus.defaultInstance == null) {
                EventBus.defaultInstance = this.build();
                return EventBus.defaultInstance;
            }
        }
        throw new EventBusException("Default instance already exists. It may be only set once before it\'s used the first time to ensure consistent behavior.");
    }

    public EventBusBuilder logNoSubscriberMessages(boolean z) {
        this.logNoSubscriberMessages = z;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean z) {
        this.logSubscriberExceptions = z;
        return this;
    }

    public EventBusBuilder logger(Logger logger0) {
        this.logger = logger0;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean z) {
        this.sendNoSubscriberEvent = z;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean z) {
        this.sendSubscriberExceptionEvent = z;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class class0) {
        if(this.skipMethodVerificationForClasses == null) {
            this.skipMethodVerificationForClasses = new ArrayList();
        }
        this.skipMethodVerificationForClasses.add(class0);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean z) {
        this.strictMethodVerification = z;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean z) {
        this.throwSubscriberException = z;
        return this;
    }
}

