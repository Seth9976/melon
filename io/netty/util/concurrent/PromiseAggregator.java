package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashSet;
import java.util.Set;

@Deprecated
public class PromiseAggregator implements GenericFutureListener {
    private final Promise aggregatePromise;
    private final boolean failPending;
    private Set pendingPromises;

    public PromiseAggregator(Promise promise0) {
        this(promise0, true);
    }

    public PromiseAggregator(Promise promise0, boolean z) {
        this.aggregatePromise = (Promise)ObjectUtil.checkNotNull(promise0, "aggregatePromise");
        this.failPending = z;
    }

    @SafeVarargs
    public final PromiseAggregator add(Promise[] arr_promise) {
        ObjectUtil.checkNotNull(arr_promise, "promises");
        if(arr_promise.length == 0) {
            return this;
        }
        synchronized(this) {
            if(this.pendingPromises == null) {
                this.pendingPromises = new LinkedHashSet((arr_promise.length <= 1 ? 2 : arr_promise.length));
            }
            for(int v1 = 0; v1 < arr_promise.length; ++v1) {
                Promise promise0 = arr_promise[v1];
                if(promise0 != null) {
                    this.pendingPromises.add(promise0);
                    promise0.addListener(this);
                }
            }
            return this;
        }
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future future0) {
        synchronized(this) {
            Set set0 = this.pendingPromises;
            if(set0 == null) {
                this.aggregatePromise.setSuccess(null);
            }
            else {
                set0.remove(future0);
                if(!future0.isSuccess()) {
                    Throwable throwable0 = future0.cause();
                    this.aggregatePromise.setFailure(throwable0);
                    if(this.failPending) {
                        for(Object object0: this.pendingPromises) {
                            ((Promise)object0).setFailure(throwable0);
                        }
                    }
                }
                else if(this.pendingPromises.isEmpty()) {
                    this.aggregatePromise.setSuccess(null);
                }
            }
        }
    }
}

