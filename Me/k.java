package me;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.d;
import org.jetbrains.annotations.Nullable;

public final class k implements Continuation, d {
    public final Continuation a;
    public static final AtomicReferenceFieldUpdater b;
    @Nullable
    private volatile Object result;

    static {
        k.b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "result");
    }

    public k(Continuation continuation0) {
        this.a = continuation0;
        this.result = a.a;
    }

    // 去混淆评级： 低(20)
    @Override  // oe.d
    public final d getCallerFrame() {
        return this.a instanceof d ? ((d)this.a) : null;
    }

    @Override  // kotlin.coroutines.Continuation
    public final i getContext() {
        return this.a.getContext();
    }

    @Override  // kotlin.coroutines.Continuation
    public final void resumeWith(Object object0) {
        while(true) {
            Object object1 = this.result;
            a a0 = a.b;
            if(object1 == a0) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = k.b;
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, a0, object0)) {
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == a0);
            }
            else {
                a a1 = a.a;
                if(object1 != a1) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = k.b;
                a a2 = a.c;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, a1, a2)) {
                        this.a.resumeWith(object0);
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == a1);
            }
        }
        throw new IllegalStateException("Already resumed");
    }

    @Override
    public final String toString() {
        return "SafeContinuation for " + this.a;
    }
}

