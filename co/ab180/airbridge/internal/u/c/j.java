package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.o;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\n\u001A\u00020\t2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\f\u001A\u00020\t2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000BJ\u001F\u0010\f\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\f\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\f\u0010\u0003R\u001B\u0010\u0016\u001A\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001A\u0004\b\u0011\u0010\u0015¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/u/c/j;", "Lco/ab180/airbridge/internal/u/c/c;", "<init>", "()V", "Lco/ab180/airbridge/common/OnSuccess;", "", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "c", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "b", "key", "value", "Lie/H;", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "(Ljava/lang/String;)V", "Lco/ab180/airbridge/internal/o;", "Lie/j;", "()Lco/ab180/airbridge/internal/o;", "repository", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class j implements c {
    private final ie.j a;

    public j() {
        this.a = f.b(o.class);
    }

    private final o a() {
        return (o)this.a.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public void a(@NotNull String s) {
        this.a().a(s);
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public void b() {
        this.a().b();
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public void b(@NotNull String s, @NotNull String s1) {
        this.a().b(s, s1);
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public boolean b(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.api.public.PublicApiDeviceImpl$fetchDeviceUUID$1", f = "PublicApiDeviceImpl.kt", l = {35}, m = "invokeSuspend")
        static final class a extends i implements n {
            int a;
            final j b;
            final OnFailure c;
            final OnSuccess d;

            public a(j j0, OnFailure onFailure0, OnSuccess onSuccess0, Continuation continuation0) {
                this.b = j0;
                this.c = onFailure0;
                this.d = onSuccess0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new a(this.b, this.c, this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                String s;
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            o o0 = this.b.a();
                            this.a = 1;
                            object0 = o0.a(this);
                            if(object0 == a0) {
                                return a0;
                            label_10:
                                d5.n.D(object0);
                            }
                            s = (String)object0;
                            goto label_19;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    case 1: {
                        goto label_10;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                b.e.d("Failed to fetch DeviceUUID", new Object[0]);
                OnFailure onFailure0 = this.c;
                if(onFailure0 != null) {
                    onFailure0.invoke(throwable0);
                }
                return h0;
            label_19:
                b.e.d("Successfully fetched the DeviceUUID", new Object[0]);
                this.d.invoke(s);
                return h0;
            }
        }

        a j$a0 = new a(this, onFailure0, onSuccess0, null);
        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, j$a0, 2, null);
        return true;
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public boolean c(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        try {
            onSuccess0.invoke(this.a().f());
        }
        catch(Throwable throwable0) {
            if(onFailure0 != null) {
                onFailure0.invoke(throwable0);
            }
        }
        return true;
    }
}

