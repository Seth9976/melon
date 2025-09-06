package co.ab180.airbridge.internal.b0.n;

import android.content.Context;
import co.ab180.airbridge.internal.d0.e.a.c;
import co.ab180.airbridge.internal.e0.l0;
import d5.n;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/d;", "Lco/ab180/airbridge/internal/b0/n/h;", "Lco/ab180/airbridge/internal/b0/m/d;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "()V", "Lco/ab180/airbridge/internal/b0/n/i;", "Lco/ab180/airbridge/internal/d0/e/a/b;", "a", "Lco/ab180/airbridge/internal/b0/n/i;", "clientRunner", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d implements h {
    private final i a;

    public d(@NotNull Context context0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/d0/b/a/d;", "Lco/ab180/airbridge/internal/d0/e/a/b;", "a", "()Lco/ab180/airbridge/internal/d0/b/a/d;"}, k = 3, mv = {1, 4, 3})
        static final class a extends r implements we.a {
            final Context a;

            public a(Context context0) {
                this.a = context0;
                super(0);
            }

            @NotNull
            public final co.ab180.airbridge.internal.d0.b.a.d a() {
                return new c(this.a);
            }

            @Override  // we.a
            public Object invoke() {
                return this.a();
            }
        }

        this.a = new i(new a(context0));
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    public void close() {
        this.a.a();
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/b0/m/d;", "continuation", "", "request", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.runner.HuaweiIdentifierRunner", f = "HuaweiIdentifierRunner.kt", l = {13}, m = "request")
        static final class b extends oe.c {
            Object a;
            int b;
            final d c;

            public b(d d0, Continuation continuation0) {
                this.c = d0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.d(this);
            }
        }

        b d$b0;
        if(continuation0 instanceof b) {
            d$b0 = (b)continuation0;
            int v = d$b0.b;
            if((v & 0x80000000) == 0) {
                d$b0 = new b(this, continuation0);
            }
            else {
                d$b0.b = v ^ 0x80000000;
            }
        }
        else {
            d$b0 = new b(this, continuation0);
        }
        Object object0 = d$b0.a;
        ne.a a0 = ne.a.a;
        switch(d$b0.b) {
            case 0: {
                n.D(object0);
                d$b0.b = 1;
                object0 = this.a.a(d$b0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((co.ab180.airbridge.internal.d0.e.a.b)object0) != null && l0.a(((co.ab180.airbridge.internal.d0.e.a.b)object0).c()) ? new co.ab180.airbridge.internal.b0.m.d(((co.ab180.airbridge.internal.d0.e.a.b)object0).c(), ((co.ab180.airbridge.internal.d0.e.a.b)object0).d()) : null;
    }
}

