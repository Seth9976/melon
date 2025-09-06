package org.greenrobot.eventbus.util;

import i.n.i.b.a.s.e.P3;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;

public class AsyncExecutor {
    public static class Builder {
        private EventBus eventBus;
        private Class failureEventType;
        private Executor threadPool;

        private Builder() {
        }

        public Builder(org.greenrobot.eventbus.util.AsyncExecutor.1 asyncExecutor$10) {
        }

        public AsyncExecutor build() {
            return this.buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object object0) {
            if(this.eventBus == null) {
                this.eventBus = EventBus.getDefault();
            }
            if(this.threadPool == null) {
                this.threadPool = Executors.newCachedThreadPool();
            }
            if(this.failureEventType == null) {
                this.failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, object0, null);
        }

        public Builder eventBus(EventBus eventBus0) {
            this.eventBus = eventBus0;
            return this;
        }

        public Builder failureEventType(Class class0) {
            this.failureEventType = class0;
            return this;
        }

        public Builder threadPool(Executor executor0) {
            this.threadPool = executor0;
            return this;
        }
    }

    public interface RunnableEx {
        void run();
    }

    private final EventBus eventBus;
    private final Constructor failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    private AsyncExecutor(Executor executor0, EventBus eventBus0, Class class0, Object object0) {
        this.threadPool = executor0;
        this.eventBus = eventBus0;
        this.scope = object0;
        try {
            this.failureEventConstructor = class0.getConstructor(Throwable.class);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", noSuchMethodException0);
        }
    }

    public AsyncExecutor(Executor executor0, EventBus eventBus0, Class class0, Object object0, org.greenrobot.eventbus.util.AsyncExecutor.1 asyncExecutor$10) {
        this(executor0, eventBus0, class0, object0);
    }

    public static void a(AsyncExecutor asyncExecutor0, RunnableEx asyncExecutor$RunnableEx0) {
        asyncExecutor0.lambda$execute$0(asyncExecutor$RunnableEx0);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static AsyncExecutor create() {
        return new Builder(null).build();
    }

    public void execute(RunnableEx asyncExecutor$RunnableEx0) {
        P3 p30 = new P3(20, this, asyncExecutor$RunnableEx0);
        this.threadPool.execute(p30);
    }

    private void lambda$execute$0(RunnableEx asyncExecutor$RunnableEx0) {
        Object object0;
        try {
            asyncExecutor$RunnableEx0.run();
        }
        catch(Exception exception0) {
            try {
                object0 = this.failureEventConstructor.newInstance(exception0);
            }
            catch(Exception exception1) {
                this.eventBus.getLogger().log(Level.SEVERE, "Original exception:", exception0);
                throw new RuntimeException("Could not create failure event", exception1);
            }
            if(object0 instanceof HasExecutionScope) {
                ((HasExecutionScope)object0).setExecutionScope(this.scope);
            }
            this.eventBus.post(object0);
        }
    }

    class org.greenrobot.eventbus.util.AsyncExecutor.1 {
    }

}

