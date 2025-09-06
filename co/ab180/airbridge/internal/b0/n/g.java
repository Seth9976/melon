package co.ab180.airbridge.internal.b0.n;

import android.content.Context;
import co.ab180.airbridge.internal.b0.m.f;
import co.ab180.airbridge.internal.d0.f.a.c;
import ie.H;
import ie.d;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@d
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u000F\u001A\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/g;", "Lco/ab180/airbridge/internal/b0/n/h;", "Lco/ab180/airbridge/internal/b0/m/f;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "()V", "Lco/ab180/airbridge/internal/d0/f/a/c;", "a", "Lco/ab180/airbridge/internal/d0/f/a/c;", "oneStoreInstallReferrerClient", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class g implements h {
    private final c a;

    public g(@NotNull Context context0) {
        this.a = new c(context0);
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    public void close() {
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/f;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.runner.OneStoreInstallReferrerRunner$request$2", f = "OneStoreInstallReferrerRunner.kt", l = {19}, m = "invokeSuspend")
        static final class a extends i implements n {
            Object a;
            Object b;
            int c;
            final g d;

            public a(g g0, Continuation continuation0) {
                this.d = g0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new a(this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                co.ab180.airbridge.internal.d0.f.a.d d0;
                Throwable throwable1;
                Closeable closeable0;
                ne.a a0 = ne.a.a;
                switch(this.c) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            closeable0 = this.d.a;
                        }
                        catch(Exception unused_ex) {
                            return null;
                        }
                        try {
                            this.a = closeable0;
                            this.b = null;
                            this.c = 1;
                            object0 = ((c)closeable0).d(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            throwable1 = null;
                            d0 = (co.ab180.airbridge.internal.d0.f.a.d)object0;
                            goto label_21;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        throwable1 = (Throwable)this.b;
                        closeable0 = (Closeable)this.a;
                        try {
                            d5.n.D(object0);
                            d0 = (co.ab180.airbridge.internal.d0.f.a.d)object0;
                            goto label_21;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                try {
                    d8.d.l(closeable0, throwable0);
                    throw throwable0;
                label_21:
                    d8.d.l(closeable0, throwable1);
                    if(d0 != null) {
                        String s = d0.d();
                        if(s != null) {
                            String s1 = d0.c();
                            if(s1 != null) {
                                return new f(s, s1, d0.e(), d0.b());
                            }
                        }
                    }
                }
                catch(Exception unused_ex) {
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new a(this, null), continuation0);
    }
}

