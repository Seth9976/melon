package co.ab180.airbridge.internal.b0.n;

import android.content.Context;
import co.ab180.airbridge.internal.d0.b.a.d;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/c;", "Lco/ab180/airbridge/internal/b0/n/h;", "Lco/ab180/airbridge/internal/b0/m/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "()V", "Lco/ab180/airbridge/internal/b0/n/i;", "Lco/ab180/airbridge/internal/d0/d/c/c;", "a", "Lco/ab180/airbridge/internal/b0/n/i;", "clientRunner", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c implements h {
    private final i a;

    public c(@NotNull Context context0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/d0/b/a/d;", "Lco/ab180/airbridge/internal/d0/d/c/c;", "a", "()Lco/ab180/airbridge/internal/d0/b/a/d;"}, k = 3, mv = {1, 4, 3})
        static final class a extends r implements we.a {
            final Context a;

            public a(Context context0) {
                this.a = context0;
                super(0);
            }

            @NotNull
            public final d a() {
                return new co.ab180.airbridge.internal.d0.d.c.a(this.a);
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.runner.GoogleInstallReferrerRunner$request$2", f = "GoogleInstallReferrerRunner.kt", l = {18}, m = "invokeSuspend")
        static final class b extends oe.i implements n {
            int a;
            final c b;

            public b(c c0, Continuation continuation0) {
                this.b = c0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new b(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            this.a = 1;
                            Object object1 = this.b.a.a(this);
                            if(object1 == a0) {
                                return a0;
                            label_8:
                                d5.n.D(object0);
                                object1 = object0;
                            }
                            if(((co.ab180.airbridge.internal.d0.d.c.c)object1) != null) {
                                String s = ((co.ab180.airbridge.internal.d0.d.c.c)object1).d();
                                if(s != null) {
                                    return new co.ab180.airbridge.internal.b0.m.b(s, ((co.ab180.airbridge.internal.d0.d.c.c)object1).f(), ((co.ab180.airbridge.internal.d0.d.c.c)object1).g(), ((co.ab180.airbridge.internal.d0.d.c.c)object1).b(), ((co.ab180.airbridge.internal.d0.d.c.c)object1).c(), ((co.ab180.airbridge.internal.d0.d.c.c)object1).a(), ((co.ab180.airbridge.internal.d0.d.c.c)object1).e());
                                }
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                        return null;
                    }
                    case 1: {
                        goto label_8;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new b(this, null), continuation0);
    }
}

