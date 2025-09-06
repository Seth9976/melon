package io.netty.util.internal;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;

public final class PendingWrite {
    private static final ObjectPool RECYCLER;
    private final Handle handle;
    private Object msg;
    private Promise promise;

    static {
        PendingWrite.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PendingWrite newObject(Handle objectPool$Handle0) {
                return new PendingWrite(objectPool$Handle0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private PendingWrite(Handle objectPool$Handle0) {
        this.handle = objectPool$Handle0;
    }

    public PendingWrite(Handle objectPool$Handle0, io.netty.util.internal.PendingWrite.1 pendingWrite$10) {
        this(objectPool$Handle0);
    }

    public boolean failAndRecycle(Throwable throwable0) {
        ReferenceCountUtil.release(this.msg);
        Promise promise0 = this.promise;
        if(promise0 != null) {
            promise0.setFailure(throwable0);
        }
        return this.recycle();
    }

    public Object msg() {
        return this.msg;
    }

    public static PendingWrite newInstance(Object object0, Promise promise0) {
        PendingWrite pendingWrite0 = (PendingWrite)PendingWrite.RECYCLER.get();
        pendingWrite0.msg = object0;
        pendingWrite0.promise = promise0;
        return pendingWrite0;
    }

    public Promise promise() {
        return this.promise;
    }

    public boolean recycle() {
        this.msg = null;
        this.promise = null;
        this.handle.recycle(this);
        return true;
    }

    public Promise recycleAndGet() {
        Promise promise0 = this.promise;
        this.recycle();
        return promise0;
    }

    public boolean successAndRecycle() {
        Promise promise0 = this.promise;
        if(promise0 != null) {
            promise0.setSuccess(null);
        }
        return this.recycle();
    }
}

