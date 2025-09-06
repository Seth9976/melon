package org.greenrobot.eventbus.util;

public class ThrowableFailureEvent implements HasExecutionScope {
    private Object executionContext;
    protected final boolean suppressErrorUi;
    protected final Throwable throwable;

    public ThrowableFailureEvent(Throwable throwable0) {
        this.throwable = throwable0;
        this.suppressErrorUi = false;
    }

    public ThrowableFailureEvent(Throwable throwable0, boolean z) {
        this.throwable = throwable0;
        this.suppressErrorUi = z;
    }

    @Override  // org.greenrobot.eventbus.util.HasExecutionScope
    public Object getExecutionScope() {
        return this.executionContext;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    @Override  // org.greenrobot.eventbus.util.HasExecutionScope
    public void setExecutionScope(Object object0) {
        this.executionContext = object0;
    }
}

