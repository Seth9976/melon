package org.apache.http.client.methods;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpRequest;
import org.apache.http.client.utils.CloneUtilsHC4;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.HttpParams;

public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements Cloneable, HttpRequest, AbortableHttpRequest, HttpExecutionAware {
    private final AtomicBoolean aborted;
    private final AtomicReference cancellableRef;

    public AbstractExecutionAwareRequest() {
        this.aborted = new AtomicBoolean(false);
        this.cancellableRef = new AtomicReference(null);
    }

    @Override  // org.apache.http.client.methods.AbortableHttpRequest
    public void abort() {
        if(this.aborted.compareAndSet(false, true)) {
            Cancellable cancellable0 = (Cancellable)this.cancellableRef.getAndSet(null);
            if(cancellable0 != null) {
                cancellable0.cancel();
            }
        }
    }

    @Override
    public Object clone() {
        AbstractExecutionAwareRequest abstractExecutionAwareRequest0 = (AbstractExecutionAwareRequest)super.clone();
        abstractExecutionAwareRequest0.headergroup = (HeaderGroup)CloneUtilsHC4.cloneObject(this.headergroup);
        abstractExecutionAwareRequest0.params = (HttpParams)CloneUtilsHC4.cloneObject(this.params);
        return abstractExecutionAwareRequest0;
    }

    public void completed() {
        this.cancellableRef.set(null);
    }

    @Override  // org.apache.http.client.methods.HttpExecutionAware
    public boolean isAborted() {
        return this.aborted.get();
    }

    public void reset() {
        Cancellable cancellable0 = (Cancellable)this.cancellableRef.getAndSet(null);
        if(cancellable0 != null) {
            cancellable0.cancel();
        }
        this.aborted.set(false);
    }

    @Override  // org.apache.http.client.methods.HttpExecutionAware
    public void setCancellable(Cancellable cancellable0) {
        if(!this.aborted.get()) {
            this.cancellableRef.set(cancellable0);
        }
    }

    @Override  // org.apache.http.client.methods.AbortableHttpRequest
    @Deprecated
    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest0) {
        this.setCancellable(new Cancellable() {
            @Override  // org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                clientConnectionRequest0.abortRequest();
                return true;
            }
        });
    }

    @Override  // org.apache.http.client.methods.AbortableHttpRequest
    @Deprecated
    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger0) {
        this.setCancellable(new Cancellable() {
            @Override  // org.apache.http.concurrent.Cancellable
            public boolean cancel() {
                try {
                    connectionReleaseTrigger0.abortConnection();
                    return true;
                }
                catch(IOException unused_ex) {
                    return false;
                }
            }
        });
    }
}

