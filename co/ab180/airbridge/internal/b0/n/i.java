package co.ab180.airbridge.internal.b0.n;

import co.ab180.airbridge.internal.d0.b.a.d;
import d5.n;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001A\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\b\u001A\u00020\n¢\u0006\u0004\b\b\u0010\u000BR\u001E\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\b\u0010\fR \u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/i;", "T", "", "Lkotlin/Function0;", "Lco/ab180/airbridge/internal/d0/b/a/d;", "creator", "<init>", "(Lwe/a;)V", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "()V", "Lco/ab180/airbridge/internal/d0/b/a/d;", "client", "b", "Lwe/a;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class i {
    private d a;
    private final a b;

    public i(@NotNull a a0) {
        this.b = a0;
    }

    @Nullable
    public final Object a(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "continuation", "", "request", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.runner.ServiceClientRunner", f = "ServiceClientRunner.kt", l = {13}, m = "request")
        static final class co.ab180.airbridge.internal.b0.n.i.a extends c {
            Object a;
            int b;
            final i c;
            Object d;
            Object e;
            Object f;

            public co.ab180.airbridge.internal.b0.n.i.a(i i0, Continuation continuation0) {
                this.c = i0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(this);
            }
        }

        i i0;
        Closeable closeable0;
        co.ab180.airbridge.internal.b0.n.i.a i$a0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.n.i.a) {
            i$a0 = (co.ab180.airbridge.internal.b0.n.i.a)continuation0;
            int v = i$a0.b;
            if((v & 0x80000000) == 0) {
                i$a0 = new co.ab180.airbridge.internal.b0.n.i.a(this, continuation0);
            }
            else {
                i$a0.b = v ^ 0x80000000;
            }
        }
        else {
            i$a0 = new co.ab180.airbridge.internal.b0.n.i.a(this, continuation0);
        }
        Object object0 = i$a0.a;
        ne.a a0 = ne.a.a;
        switch(i$a0.b) {
            case 0: {
                n.D(object0);
                d d0 = this.a;
                if(d0 != null) {
                    d0.close();
                }
                closeable0 = (d)this.b.invoke();
                this.a = closeable0;
                if(closeable0 == null) {
                    i0 = this;
                    object0 = null;
                }
                else {
                    try {
                        i$a0.d = this;
                        i$a0.e = closeable0;
                        i$a0.f = null;
                        i$a0.b = 1;
                        object0 = ((d)closeable0).d(i$a0);
                        if(object0 == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        d8.d.l(closeable0, throwable0);
                        throw throwable0;
                    }
                    i0 = this;
                    d8.d.l(closeable0, null);
                }
                break;
            }
            case 1: {
                Throwable throwable1 = (Throwable)i$a0.f;
                closeable0 = (Closeable)i$a0.e;
                i0 = (i)i$a0.d;
                try {
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                    d8.d.l(closeable0, throwable0);
                    throw throwable0;
                }
                d8.d.l(closeable0, throwable1);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        i0.a = null;
        return object0;
    }

    public final void a() {
        d d0 = this.a;
        if(d0 != null) {
            d0.close();
        }
        this.a = null;
    }
}

