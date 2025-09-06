package co.ab180.airbridge.internal;

import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.OnAttributionResultReceiveListener;
import co.ab180.airbridge.internal.e0.p;
import co.ab180.airbridge.internal.x.b;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import ie.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003R\u001B\u0010\f\u001A\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001B\u0010\u0010\u001A\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\t\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0014\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lco/ab180/airbridge/internal/d;", "Lco/ab180/airbridge/internal/c;", "<init>", "()V", "Lie/H;", "a", "b", "close", "Lco/ab180/airbridge/AirbridgeOption;", "Lie/j;", "h", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/o;", "m", "()Lco/ab180/airbridge/internal/o;", "repository", "Lco/ab180/airbridge/internal/x/b;", "c", "Lco/ab180/airbridge/internal/x/b;", "worker", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d implements c {
    private final j a;
    private final j b;
    private final b c;

    public d() {
        this.a = f.b(AirbridgeOption.class);
        this.b = f.b(o.class);
        this.c = new b("attribution-runner");
    }

    @Override  // co.ab180.airbridge.internal.c
    public void a() {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.AttributionImpl$start$1", f = "Attribution.kt", l = {30}, m = "invokeSuspend")
        static final class a extends i implements n {
            int a;
            final d b;

            public a(d d0, Continuation continuation0) {
                this.b = d0;
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
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\u00020\u00032\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "it", "Lie/H;", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.d.a.a extends r implements k {
                    final a a;

                    public co.ab180.airbridge.internal.d.a.a(a d$a0) {
                        this.a = d$a0;
                        super(1);
                    }

                    public final void a(@NotNull Map map0) {
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                        @e(c = "co.ab180.airbridge.internal.AttributionImpl$start$1$1$1", f = "Attribution.kt", l = {}, m = "invokeSuspend")
                        static final class co.ab180.airbridge.internal.d.a.a.a extends i implements n {
                            int a;
                            final co.ab180.airbridge.internal.d.a.a b;
                            final Map c;

                            public co.ab180.airbridge.internal.d.a.a.a(co.ab180.airbridge.internal.d.a.a d$a$a0, Map map0, Continuation continuation0) {
                                this.b = d$a$a0;
                                this.c = map0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            @NotNull
                            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                return new co.ab180.airbridge.internal.d.a.a.a(this.b, this.c, continuation0);
                            }

                            @Override  // we.n
                            public final Object invoke(Object object0, Object object1) {
                                return ((co.ab180.airbridge.internal.d.a.a.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object object0) {
                                if(this.a != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                OnAttributionResultReceiveListener onAttributionResultReceiveListener0 = this.b.a.b.h().getOnAttributionResultReceiveListener();
                                if(onAttributionResultReceiveListener0 != null) {
                                    onAttributionResultReceiveListener0.onAttributionResultReceived(this.c);
                                }
                                return H.a;
                            }
                        }

                        co.ab180.airbridge.internal.d.a.a.a d$a$a$a0 = new co.ab180.airbridge.internal.d.a.a.a(this, map0, null);
                        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, d$a$a$a0, 2, null);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.a(((Map)object0));
                        return H.a;
                    }
                }

                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        o o0 = this.b.m();
                        co.ab180.airbridge.internal.d.a.a d$a$a0 = new co.ab180.airbridge.internal.d.a.a(this);
                        this.a = 1;
                        return o0.a(d$a$a0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

        co.ab180.airbridge.internal.b.e.e("Attribution(" + p.a(this) + ")#start", new Object[0]);
        a d$a0 = new a(this, null);
        this.c.a(d$a0);
    }

    @Override  // co.ab180.airbridge.internal.c
    public void b() {
        co.ab180.airbridge.internal.b.e.e("Attribution(" + p.a(this) + ")#stop", new Object[0]);
        this.c.c();
    }

    @Override
    public void close() {
        this.c.a();
    }

    private final AirbridgeOption h() {
        return (AirbridgeOption)this.a.getValue();
    }

    private final o m() {
        return (o)this.b.getValue();
    }
}

