package com.iloen.melon.utils;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\u001AF\u0010\u0007\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u001E\b\u0004\u0010\u0006\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0086H¢\u0006\u0004\b\u0007\u0010\b\u001A\u0014\u0010\n\u001A\u00020\t*\u00020\u0001H\u0086H¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"T", "Lkotlinx/coroutines/sync/Mutex;", "", "owner", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "withReentrantLock", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isAlreadyLocked", "(Lkotlinx/coroutines/sync/Mutex;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ReentrantMutexKt {
    @Nullable
    public static final Object isAlreadyLocked(@NotNull Mutex mutex0, @NotNull Continuation continuation0) {
        return continuation0.getContext().get(new ReentrantMutexContextKey(mutex0)) == null ? false : true;
    }

    @Nullable
    public static final Object withReentrantLock(@NotNull Mutex mutex0, @Nullable Object object0, @NotNull k k0, @NotNull Continuation continuation0) {
        ReentrantMutexContextKey reentrantMutexContextKey0 = new ReentrantMutexContextKey(mutex0);
        return continuation0.getContext().get(reentrantMutexContextKey0) == null ? BuildersKt.withContext(new ReentrantMutexContextElement(reentrantMutexContextKey0), new n(mutex0, object0, k0, null) {
            public k B;
            public int D;
            public int E;
            public final Mutex G;
            public final Object I;
            public final k M;
            public Mutex r;
            public Object w;

            {
                this.G = mutex0;
                this.I = object0;
                this.M = k0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.ReentrantMutexKt.withReentrantLock.2(this.G, this.I, this.M, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.ReentrantMutexKt.withReentrantLock.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object4;
                Throwable throwable1;
                Mutex mutex2;
                Object object3;
                k k1;
                int v;
                Object object1;
                Mutex mutex0;
                a a0 = a.a;
                switch(this.E) {
                    case 0: {
                        d5.n.D(object0);
                        mutex0 = this.G;
                        this.r = mutex0;
                        object1 = this.I;
                        this.w = object1;
                        k k0 = this.M;
                        this.B = k0;
                        v = 0;
                        this.D = 0;
                        this.E = 1;
                        if(mutex0.lock(object1, this) == a0) {
                            return a0;
                        }
                        k1 = k0;
                        goto label_24;
                    }
                    case 1: {
                        int v1 = this.D;
                        k1 = this.B;
                        Object object2 = this.w;
                        Mutex mutex1 = this.r;
                        d5.n.D(object0);
                        mutex0 = mutex1;
                        v = v1;
                        object1 = object2;
                        try {
                        label_24:
                            this.r = mutex0;
                            this.w = object1;
                            this.B = null;
                            this.D = v;
                            this.E = 2;
                            object3 = k1.invoke(this);
                        }
                        catch(Throwable throwable0) {
                            mutex2 = mutex0;
                            throwable1 = throwable0;
                            object4 = object1;
                            mutex2.unlock(object4);
                            throw throwable1;
                        }
                        if(object3 == a0) {
                            return a0;
                        }
                        object4 = object1;
                        mutex2 = mutex0;
                        object0 = object3;
                        break;
                    }
                    case 2: {
                        try {
                            object4 = this.w;
                            mutex2 = this.r;
                            d5.n.D(object0);
                            break;
                        }
                        catch(Throwable throwable1) {
                        }
                        mutex2.unlock(object4);
                        throw throwable1;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                mutex2.unlock(object4);
                return object0;
            }

            public final Object invokeSuspend$$forInline(Object object0) {
                this.G.lock(this.I, this);
                try {
                    return this.M.invoke(null);
                }
                finally {
                    this.G.unlock(this.I);
                }
            }
        }, continuation0) : k0.invoke(continuation0);
    }

    public static Object withReentrantLock$default(Mutex mutex0, Object object0, k k0, Continuation continuation0, int v, Object object1) {
        new ReentrantMutexContextKey(mutex0);
        throw null;
    }
}

