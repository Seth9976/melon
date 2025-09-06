package io.netty.util.internal;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class ReferenceCountUpdater {
    public static long getUnsafeOffset(Class class0, String s) {
        try {
            return PlatformDependent.hasUnsafe() ? PlatformDependent.objectFieldOffset(class0.getDeclaredField(s)) : -1L;
        }
        catch(Throwable unused_ex) {
        }
        return -1L;
    }

    public final int initialValue() [...] // Inlined contents

    public final boolean isLiveNonVolatile(ReferenceCounted referenceCounted0) {
        long v = this.unsafeOffset();
        int v1 = v == -1L ? this.updater().get(referenceCounted0) : PlatformDependent.getInt(referenceCounted0, v);
        return v1 == 2 || v1 == 4 || v1 == 6 || v1 == 8 || (v1 & 1) == 0;
    }

    private boolean nonFinalRelease0(ReferenceCounted referenceCounted0, int v, int v1, int v2) {
        return v >= v2 || !this.updater().compareAndSet(referenceCounted0, v1, v1 - (v << 1)) ? this.retryRelease0(referenceCounted0, v) : false;
    }

    private int nonVolatileRawCnt(ReferenceCounted referenceCounted0) {
        long v = this.unsafeOffset();
        return v == -1L ? this.updater().get(referenceCounted0) : PlatformDependent.getInt(referenceCounted0, v);
    }

    private static int realRefCnt(int v) {
        return v == 2 || v == 4 || (v & 1) == 0 ? v >>> 1 : 0;
    }

    public final int refCnt(ReferenceCounted referenceCounted0) {
        return ReferenceCountUpdater.realRefCnt(this.updater().get(referenceCounted0));
    }

    public final boolean release(ReferenceCounted referenceCounted0) {
        int v = this.nonVolatileRawCnt(referenceCounted0);
        return v == 2 ? this.tryFinalRelease0(referenceCounted0, 2) || this.retryRelease0(referenceCounted0, 1) : this.nonFinalRelease0(referenceCounted0, 1, v, ReferenceCountUpdater.toLiveRealRefCnt(v, 1));
    }

    public final boolean release(ReferenceCounted referenceCounted0, int v) {
        int v1 = this.nonVolatileRawCnt(referenceCounted0);
        int v2 = ReferenceCountUpdater.toLiveRealRefCnt(v1, ObjectUtil.checkPositive(v, "decrement"));
        return v == v2 ? this.tryFinalRelease0(referenceCounted0, v1) || this.retryRelease0(referenceCounted0, v) : this.nonFinalRelease0(referenceCounted0, v, v1, v2);
    }

    public final void resetRefCnt(ReferenceCounted referenceCounted0) {
        this.updater().lazySet(referenceCounted0, 2);
    }

    public final ReferenceCounted retain(ReferenceCounted referenceCounted0) {
        return this.retain0(referenceCounted0, 1, 2);
    }

    public final ReferenceCounted retain(ReferenceCounted referenceCounted0, int v) {
        return this.retain0(referenceCounted0, v, ObjectUtil.checkPositive(v, "increment") << 1);
    }

    private ReferenceCounted retain0(ReferenceCounted referenceCounted0, int v, int v1) {
        int v2 = this.updater().getAndAdd(referenceCounted0, v1);
        if(v2 != 2 && v2 != 4 && (v2 & 1) != 0) {
            throw new IllegalReferenceCountException(0, v);
        }
        if(v2 <= 0 && v2 + v1 >= 0 || v2 >= 0 && v2 + v1 < v2) {
            this.updater().getAndAdd(referenceCounted0, -v1);
            throw new IllegalReferenceCountException(ReferenceCountUpdater.realRefCnt(v2), v);
        }
        return referenceCounted0;
    }

    private boolean retryRelease0(ReferenceCounted referenceCounted0, int v) {
        int v2;
        while(true) {
            int v1 = this.updater().get(referenceCounted0);
            v2 = ReferenceCountUpdater.toLiveRealRefCnt(v1, v);
            if(v != v2) {
                if(v >= v2) {
                    break;
                }
                if(this.updater().compareAndSet(referenceCounted0, v1, v1 - (v << 1))) {
                    return false;
                }
            }
            else if(this.tryFinalRelease0(referenceCounted0, v1)) {
                return true;
            }
            Thread.yield();
        }
        throw new IllegalReferenceCountException(v2, -v);
    }

    public void setInitialValue(ReferenceCounted referenceCounted0) {
        long v = this.unsafeOffset();
        if(v == -1L) {
            this.updater().set(referenceCounted0, 2);
            return;
        }
        PlatformDependent.safeConstructPutInt(referenceCounted0, v, 2);
    }

    public final void setRefCnt(ReferenceCounted referenceCounted0, int v) {
        this.updater().set(referenceCounted0, (v <= 0 ? 1 : v << 1));
    }

    private static int toLiveRealRefCnt(int v, int v1) {
        if(v != 2 && v != 4 && (v & 1) != 0) {
            throw new IllegalReferenceCountException(0, -v1);
        }
        return v >>> 1;
    }

    private boolean tryFinalRelease0(ReferenceCounted referenceCounted0, int v) {
        return this.updater().compareAndSet(referenceCounted0, v, 1);
    }

    public abstract long unsafeOffset();

    public abstract AtomicIntegerFieldUpdater updater();
}

