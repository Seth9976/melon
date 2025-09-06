package co.ab180.airbridge.internal.u.c;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.network.response.TrackingLinkResult;
import co.ab180.airbridge.internal.o;
import co.ab180.airbridge.internal.r;
import co.ab180.airbridge.throwable.AirbridgeAppNameIsNotMatchedException;
import co.ab180.airbridge.throwable.AirbridgeTrackingLinkOpenException;
import ie.H;
import ie.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000E\u0010\rR\u001B\u0010\u0013\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0010\u0010\u0012R\u001B\u0010\u0016\u001A\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000E\u0010\u0011\u001A\u0004\b\u000E\u0010\u0015R\u001B\u0010\u001A\u001A\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0011\u001A\u0004\b\u0018\u0010\u0019R\u001B\u0010\u001D\u001A\u00020\u001B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001A\u0004\b\f\u0010\u001C¨\u0006\u001E"}, d2 = {"Lco/ab180/airbridge/internal/u/c/n;", "Lco/ab180/airbridge/internal/u/c/f;", "<init>", "()V", "", "trackingLink", "Lco/ab180/airbridge/common/OnSuccess;", "Lie/H;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "c", "(Ljava/lang/String;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "b", "Landroid/content/Context;", "a", "Lie/j;", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/r;", "d", "()Lco/ab180/airbridge/internal/r;", "tracker", "Lco/ab180/airbridge/internal/o;", "()Lco/ab180/airbridge/internal/o;", "repository", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class n implements f {
    private final j a;
    private final j b;
    private final j c;
    private final j d;

    public n() {
        this.a = co.ab180.airbridge.internal.z.f.b(Context.class);
        this.b = co.ab180.airbridge.internal.z.f.b(AirbridgeOption.class);
        this.c = co.ab180.airbridge.internal.z.f.b(r.class);
        this.d = co.ab180.airbridge.internal.z.f.b(o.class);
    }

    private final Context a() {
        return (Context)this.a.getValue();
    }

    private final AirbridgeOption b() {
        return (AirbridgeOption)this.b.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.f
    public boolean b(@NotNull String s, @Nullable OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.api.public.PublicApiPlacementImpl$click$1", f = "PublicApiPlacementImpl.kt", l = {62}, m = "invokeSuspend")
        static final class a extends i implements we.n {
            Object a;
            int b;
            final n c;
            final String d;
            final OnFailure e;
            final OnSuccess f;

            public a(n n0, String s, OnFailure onFailure0, OnSuccess onSuccess0, Continuation continuation0) {
                this.c = n0;
                this.d = s;
                this.e = onFailure0;
                this.f = onSuccess0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new a(this.c, this.d, this.e, this.f, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Throwable throwable1;
                ne.a a0 = ne.a.a;
                String s = null;
                H h0 = H.a;
                switch(this.b) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            b.e.d("Click event of tracking link is generated: trackingLink={" + this.d + '}', new Object[0]);
                            o o0 = this.c.c();
                            this.a = null;
                            this.b = 1;
                            object0 = o0.a(this.d, "click", this);
                            if(object0 == a0) {
                                return a0;
                            }
                            throwable1 = null;
                            goto label_17;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        throwable1 = (Throwable)this.a;
                        try {
                            d5.n.D(object0);
                        label_17:
                            if(co.ab180.airbridge.internal.e0.a.a(this.c.a(), ((TrackingLinkResult)object0).getDeeplink())) {
                                co.ab180.airbridge.internal.b.b b$b0 = b.e;
                                b$b0.d("Deeplink of tracking link is opened: trackingLink={" + this.d + "} deeplink={" + ((TrackingLinkResult)object0).getDeeplink() + '}', new Object[0]);
                                if(q.b(((TrackingLinkResult)object0).getAppName(), this.c.b().getName())) {
                                    String s1 = ((TrackingLinkResult)object0).getDeeplink();
                                    if(s1 != null && s1.length() != 0) {
                                        s = s1;
                                    }
                                    if(s != null) {
                                        b$b0.d("Movement event or tracking link occurred: trackingLink={" + this.d + '}', new Object[0]);
                                        this.c.d().f(s);
                                    }
                                }
                                else {
                                    throwable1 = new AirbridgeAppNameIsNotMatchedException(((TrackingLinkResult)object0).getAppName());
                                }
                            }
                            else if(co.ab180.airbridge.internal.e0.a.a(this.c.a(), ((TrackingLinkResult)object0).getFallback())) {
                                b.e.d("The fallback link of tracking link is opened because no deeplink information was found: trackingLink={" + this.d + "} fallback={" + ((TrackingLinkResult)object0).getFallback() + '}', new Object[0]);
                            }
                            else {
                                throwable1 = new AirbridgeTrackingLinkOpenException();
                            }
                            goto label_40;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                OnFailure onFailure0 = this.e;
                if(onFailure0 != null) {
                    onFailure0.invoke(throwable0);
                    return h0;
                label_40:
                    if(throwable1 == null) {
                        OnSuccess onSuccess0 = this.f;
                        if(onSuccess0 != null) {
                            onSuccess0.invoke(h0);
                            return h0;
                        }
                    }
                    else {
                        OnFailure onFailure1 = this.e;
                        if(onFailure1 != null) {
                            onFailure1.invoke(throwable1);
                            return h0;
                        }
                    }
                }
                return h0;
            }
        }

        if(!this.c().e(s)) {
            b.e.d("Received tracking link is not an Airbridge\'s tracking link. Either click or impression event will be ignored", new Object[0]);
            return false;
        }
        a n$a0 = new a(this, s, onFailure0, onSuccess0, null);
        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, n$a0, 2, null);
        return true;
    }

    private final o c() {
        return (o)this.d.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.f
    public boolean c(@NotNull String s, @Nullable OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.api.public.PublicApiPlacementImpl$impression$1", f = "PublicApiPlacementImpl.kt", l = {39}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.u.c.n.b extends i implements we.n {
            int a;
            final n b;
            final String c;
            final OnFailure d;
            final OnSuccess e;

            public co.ab180.airbridge.internal.u.c.n.b(n n0, String s, OnFailure onFailure0, OnSuccess onSuccess0, Continuation continuation0) {
                this.b = n0;
                this.c = s;
                this.d = onFailure0;
                this.e = onSuccess0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.u.c.n.b(this.b, this.c, this.d, this.e, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.u.c.n.b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            b.e.d("Impression event of tracking link is generated: trackingLink={" + this.c + '}', new Object[0]);
                            o o0 = this.b.c();
                            this.a = 1;
                            if(o0.a(this.c, "impression", this) != a0) {
                                goto label_17;
                            }
                            return a0;
                        label_10:
                            d5.n.D(object0);
                            goto label_17;
                        }
                        catch(Throwable throwable0) {
                        }
                        goto label_13;
                    }
                    case 1: {
                        goto label_10;
                    label_13:
                        OnFailure onFailure0 = this.d;
                        if(onFailure0 != null) {
                            onFailure0.invoke(throwable0);
                            return h0;
                        label_17:
                            OnSuccess onSuccess0 = this.e;
                            if(onSuccess0 != null) {
                                onSuccess0.invoke(h0);
                                return h0;
                            }
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h0;
            }
        }

        if(!this.c().e(s)) {
            b.e.d("Received tracking link is not an Airbridge\'s tracking link. Either click or impression event will be ignored", new Object[0]);
            return false;
        }
        co.ab180.airbridge.internal.u.c.n.b n$b0 = new co.ab180.airbridge.internal.u.c.n.b(this, s, onFailure0, onSuccess0, null);
        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getIO(), null, n$b0, 2, null);
        return true;
    }

    private final r d() {
        return (r)this.c.getValue();
    }
}

