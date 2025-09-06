package co.ab180.airbridge.internal;

import android.content.Intent;
import android.net.Uri;
import co.ab180.airbridge.common.AirbridgeTrackingLink;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.internal.e0.l;
import co.ab180.airbridge.internal.e0.p;
import co.ab180.airbridge.internal.z.f;
import d5.n;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0007\u0010\u000EJ)\u0010\u0007\u001A\u00020\r2\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0007\u0010\u000FJC\u0010\u0007\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u00102\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00150\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0007\u0010\u0017R\u001B\u0010\u001C\u001A\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u001B\u0010\u001F\u001A\u00020\u001D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001A\u0010\u0019\u001A\u0004\b\u0007\u0010\u001E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lco/ab180/airbridge/internal/h;", "Lco/ab180/airbridge/internal/g;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/net/Uri;", "a", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/common/OnSuccess;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "(Landroid/content/Intent;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "", "channel", "", "", "option", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "Lie/H;", "(Ljava/lang/String;Ljava/util/Map;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)V", "Lco/ab180/airbridge/internal/r;", "Lie/j;", "b", "()Lco/ab180/airbridge/internal/r;", "tracker", "Lco/ab180/airbridge/internal/o;", "()Lco/ab180/airbridge/internal/o;", "repository", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class h implements g {
    private final j a;
    private final j b;

    public h() {
        this.a = f.b(r.class);
        this.b = f.b(o.class);
    }

    private final o a() {
        return (o)this.b.getValue();
    }

    private final Object a(Intent intent0, Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Intent;", "intent", "Lkotlin/coroutines/Continuation;", "Landroid/net/Uri;", "continuation", "", "getActualDeeplink", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl", f = "Deeplinker.kt", l = {84}, m = "getActualDeeplink")
        static final class b extends c {
            Object a;
            int b;
            final h c;

            public b(h h0, Continuation continuation0) {
                this.c = h0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return h.a(this.c, null, this);
            }
        }

        b h$b0;
        if(continuation0 instanceof b) {
            h$b0 = (b)continuation0;
            int v = h$b0.b;
            if((v & 0x80000000) == 0) {
                h$b0 = new b(this, continuation0);
            }
            else {
                h$b0.b = v ^ 0x80000000;
            }
        }
        else {
            h$b0 = new b(this, continuation0);
        }
        Object object0 = h$b0.a;
        a a0 = a.a;
        switch(h$b0.b) {
            case 0: {
                n.D(object0);
                if(l.d(intent0)) {
                    co.ab180.airbridge.internal.b.e.f("Deeplinker(" + p.a(this) + ")#getActualDeeplink intent was consumed", new Object[0]);
                    return null;
                }
                l.a(intent0);
                o o0 = this.a();
                String s = intent0.getDataString();
                h$b0.b = 1;
                object0 = o0.a(s, h$b0);
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
        return ((String)object0) != null ? Uri.parse(((String)object0)) : null;
    }

    @Override  // co.ab180.airbridge.internal.g
    public void a(@NotNull String s, @NotNull Map map0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl$createTrackingLink$1", f = "Deeplinker.kt", l = {0x84}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.h.a extends i implements we.n {
            int a;
            final h b;
            final Map c;
            final String d;
            final OnSuccess e;
            final OnFailure f;

            public co.ab180.airbridge.internal.h.a(h h0, Map map0, String s, OnSuccess onSuccess0, OnFailure onFailure0, Continuation continuation0) {
                this.b = h0;
                this.c = map0;
                this.d = s;
                this.e = onSuccess0;
                this.f = onFailure0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.h.a(this.b, this.c, this.d, this.e, this.f, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.h.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl$createTrackingLink$1$1", f = "Deeplinker.kt", l = {}, m = "invokeSuspend")
                static final class co.ab180.airbridge.internal.h.a.a extends i implements we.n {
                    int a;
                    final co.ab180.airbridge.internal.h.a b;
                    final AirbridgeTrackingLink c;

                    public co.ab180.airbridge.internal.h.a.a(co.ab180.airbridge.internal.h.a h$a0, AirbridgeTrackingLink airbridgeTrackingLink0, Continuation continuation0) {
                        this.b = h$a0;
                        this.c = airbridgeTrackingLink0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        return new co.ab180.airbridge.internal.h.a.a(this.b, this.c, continuation0);
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((co.ab180.airbridge.internal.h.a.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.a != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        this.b.e.invoke(this.c);
                        co.ab180.airbridge.internal.b.e.d("Succeed on create tracking link: result={" + this.c + '}', new Object[0]);
                        return H.a;
                    }
                }


                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl$createTrackingLink$1$2", f = "Deeplinker.kt", l = {}, m = "invokeSuspend")
                static final class co.ab180.airbridge.internal.h.a.b extends i implements we.n {
                    int a;
                    final co.ab180.airbridge.internal.h.a b;
                    final Throwable c;

                    public co.ab180.airbridge.internal.h.a.b(co.ab180.airbridge.internal.h.a h$a0, Throwable throwable0, Continuation continuation0) {
                        this.b = h$a0;
                        this.c = throwable0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        return new co.ab180.airbridge.internal.h.a.b(this.b, this.c, continuation0);
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((co.ab180.airbridge.internal.h.a.b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.a != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        OnFailure onFailure0 = this.b.f;
                        if(onFailure0 != null) {
                            onFailure0.invoke(this.c);
                        }
                        co.ab180.airbridge.internal.b.e.b("Failed on create tracking link: error={" + this.c + '}', new Object[0]);
                        return H.a;
                    }
                }

                a a0 = a.a;
                switch(this.a) {
                    case 0: {
                        n.D(object0);
                        try {
                            ArrayList arrayList0 = new ArrayList();
                            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                            for(Object object1: this.c.entrySet()) {
                                Map.Entry map$Entry0 = (Map.Entry)object1;
                                Object object2 = map$Entry0.getValue();
                                if(object2 instanceof String || object2 instanceof Number || object2 instanceof Boolean) {
                                    linkedHashMap0.put(map$Entry0.getKey(), map$Entry0.getValue());
                                }
                                else {
                                    arrayList0.add(map$Entry0.getKey());
                                }
                            }
                            if(!arrayList0.isEmpty()) {
                                co.ab180.airbridge.internal.b.e.f("Drop invalid tracking link option: keys={" + je.p.q0(arrayList0, null, null, null, null, 0x3F) + '}', new Object[0]);
                            }
                            o o0 = this.b.a();
                            this.a = 1;
                            object0 = o0.a(this.d, linkedHashMap0, this);
                            if(object0 == a0) {
                                return a0;
                            label_23:
                                n.D(object0);
                            }
                            co.ab180.airbridge.internal.h.a.a h$a$a0 = new co.ab180.airbridge.internal.h.a.a(this, ((AirbridgeTrackingLink)object0), null);
                            BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, h$a$a0, 2, null);
                            return H.a;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        goto label_23;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                co.ab180.airbridge.internal.h.a.b h$a$b0 = new co.ab180.airbridge.internal.h.a.b(this, throwable0, null);
                BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, h$a$b0, 2, null);
                return H.a;
            }
        }

        co.ab180.airbridge.internal.b.e.e("Deeplinker(" + p.a(this) + ")#createTrackingLink.", new Object[0]);
        co.ab180.airbridge.internal.h.a h$a0 = new co.ab180.airbridge.internal.h.a(this, map0, s, onSuccess0, onFailure0, null);
        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getIO(), null, h$a0, 2, null);
    }

    @Override  // co.ab180.airbridge.internal.g
    public boolean a(@NotNull Intent intent0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl$handleDeeplink$1", f = "Deeplinker.kt", l = {57}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.h.c extends i implements we.n {
            int a;
            final h b;
            final Intent c;
            final OnFailure d;
            final OnSuccess e;

            public co.ab180.airbridge.internal.h.c(h h0, Intent intent0, OnFailure onFailure0, OnSuccess onSuccess0, Continuation continuation0) {
                this.b = h0;
                this.c = intent0;
                this.d = onFailure0;
                this.e = onSuccess0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.h.c(this.b, this.c, this.d, this.e, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.h.c)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Uri uri0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.a) {
                    case 0: {
                        n.D(object0);
                        try {
                            this.a = 1;
                            object0 = this.b.a(this.c, this);
                            if(object0 == a0) {
                                return a0;
                            label_9:
                                n.D(object0);
                            }
                            uri0 = (Uri)object0;
                            goto label_18;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    case 1: {
                        goto label_9;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                OnFailure onFailure0 = this.d;
                if(onFailure0 != null) {
                    onFailure0.invoke(throwable0);
                }
                co.ab180.airbridge.internal.b.e.b("Failed on handling deeplink: error={" + throwable0 + '}', new Object[0]);
                return h0;
            label_18:
                if(uri0 == null) {
                    IllegalStateException illegalStateException0 = new IllegalStateException("result may not be null");
                    OnFailure onFailure1 = this.d;
                    if(onFailure1 != null) {
                        onFailure1.invoke(illegalStateException0);
                    }
                    co.ab180.airbridge.internal.b.e.f("Failed on handling deeplink: error={" + illegalStateException0 + '}', new Object[0]);
                    return h0;
                }
                this.e.invoke(uri0);
                co.ab180.airbridge.internal.b.e.d("Succeed on handling deeplink: url={" + uri0 + '}', new Object[0]);
                return h0;
            }
        }

        co.ab180.airbridge.internal.b.b b$b0 = co.ab180.airbridge.internal.b.e;
        b$b0.e("Deeplinker(" + p.a(this) + ")#handleDeeplink: {" + intent0 + ".dataString}", new Object[0]);
        if(!this.a().e(intent0.getDataString())) {
            b$b0.d("Drop the deeplink event because the deep link is not from Airbridge: url={" + intent0.getDataString() + '}', new Object[0]);
            return false;
        }
        co.ab180.airbridge.internal.h.c h$c0 = new co.ab180.airbridge.internal.h.c(this, intent0, onFailure0, onSuccess0, null);
        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, h$c0, 2, null);
        return true;
    }

    @Override  // co.ab180.airbridge.internal.g
    public boolean a(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\b\u0010\u0001\u001A\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "it", "Lie/H;", "a", "(Landroid/net/Uri;)V"}, k = 3, mv = {1, 4, 3})
        static final class d extends kotlin.jvm.internal.r implements k {
            final OnSuccess a;

            public d(OnSuccess onSuccess0) {
                this.a = onSuccess0;
                super(1);
            }

            public final void a(@Nullable Uri uri0) {
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl$handleDeferredDeeplink$1$1", f = "Deeplinker.kt", l = {}, m = "invokeSuspend")
                static final class co.ab180.airbridge.internal.h.d.a extends i implements we.n {
                    int a;
                    final d b;
                    final Uri c;

                    public co.ab180.airbridge.internal.h.d.a(d h$d0, Uri uri0, Continuation continuation0) {
                        this.b = h$d0;
                        this.c = uri0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        return new co.ab180.airbridge.internal.h.d.a(this.b, this.c, continuation0);
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((co.ab180.airbridge.internal.h.d.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.a != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        this.b.a.invoke(this.c);
                        co.ab180.airbridge.internal.b.e.d("Succeed on handling deferred deeplink: url={" + this.c + '}', new Object[0]);
                        return H.a;
                    }
                }

                co.ab180.airbridge.internal.h.d.a h$d$a0 = new co.ab180.airbridge.internal.h.d.a(this, uri0, null);
                BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, h$d$a0, 2, null);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((Uri)object0));
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lie/H;", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.h.e extends kotlin.jvm.internal.r implements k {
            final OnFailure a;

            public co.ab180.airbridge.internal.h.e(OnFailure onFailure0) {
                this.a = onFailure0;
                super(1);
            }

            public final void a(@NotNull Throwable throwable0) {
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
                @e(c = "co.ab180.airbridge.internal.DeeplinkerImpl$handleDeferredDeeplink$2$1", f = "Deeplinker.kt", l = {}, m = "invokeSuspend")
                static final class co.ab180.airbridge.internal.h.e.a extends i implements we.n {
                    int a;
                    final co.ab180.airbridge.internal.h.e b;
                    final Throwable c;

                    public co.ab180.airbridge.internal.h.e.a(co.ab180.airbridge.internal.h.e h$e0, Throwable throwable0, Continuation continuation0) {
                        this.b = h$e0;
                        this.c = throwable0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        return new co.ab180.airbridge.internal.h.e.a(this.b, this.c, continuation0);
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((co.ab180.airbridge.internal.h.e.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        if(this.a != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        OnFailure onFailure0 = this.b.a;
                        if(onFailure0 != null) {
                            onFailure0.invoke(this.c);
                        }
                        co.ab180.airbridge.internal.b.e.b("Failed on handling deferred deeplink: error={" + this.c + '}', new Object[0]);
                        return H.a;
                    }
                }

                co.ab180.airbridge.internal.h.e.a h$e$a0 = new co.ab180.airbridge.internal.h.e.a(this, throwable0, null);
                BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, h$e$a0, 2, null);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((Throwable)object0));
                return H.a;
            }
        }

        co.ab180.airbridge.internal.b.e.e("Deeplinker(" + p.a(this) + ")#handleDeferredDeeplink", new Object[0]);
        return this.b().a(new d(onSuccess0), new co.ab180.airbridge.internal.h.e(onFailure0));
    }

    private final r b() {
        return (r)this.a.getValue();
    }
}

