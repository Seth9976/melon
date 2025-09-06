package co.ab180.airbridge.internal.b0.n;

import android.content.Context;
import co.ab180.airbridge.internal.d0.c.d.b;
import co.ab180.airbridge.internal.d0.c.d.d;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/f;", "Lco/ab180/airbridge/internal/b0/n/h;", "Lco/ab180/airbridge/internal/b0/m/e;", "Landroid/content/Context;", "context", "", "facebookAppId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "()V", "a", "Landroid/content/Context;", "b", "Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class f implements h {
    private final Context a;
    private final String b;

    public f(@NotNull Context context0, @Nullable String s) {
        this.a = context0;
        this.b = s;
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    public void close() {
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/e;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.runner.MetaInstallReferrerRunner$request$2", f = "MetaInstallReferrerRunner.kt", l = {}, m = "invokeSuspend")
        static final class a extends i implements n {
            int a;
            final f b;

            public a(f f0, Continuation continuation0) {
                this.b = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new a(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.b.b != null) {
                    try {
                        d d0 = new b(this.b.a, this.b.b).a();
                        return new co.ab180.airbridge.internal.b0.m.e(d0.e(), d0.d(), d0.f(), null, 8, null);
                    }
                    catch(Exception exception0) {
                        return new co.ab180.airbridge.internal.b0.m.e(null, null, null, exception0.getMessage(), 7, null);
                    }
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new a(this, null), continuation0);
    }
}

