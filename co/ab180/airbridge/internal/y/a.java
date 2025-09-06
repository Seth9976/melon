package co.ab180.airbridge.internal.y;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.internal.b0.d;
import co.ab180.airbridge.internal.b0.i;
import co.ab180.airbridge.internal.e0.j0;
import co.ab180.airbridge.internal.e0.k0;
import co.ab180.airbridge.internal.e0.k;
import co.ab180.airbridge.internal.network.body.EventBody;
import co.ab180.airbridge.internal.network.model.AppInfo;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.network.model.EventData;
import co.ab180.airbridge.internal.network.model.GalaxyStoreReferrerDetails;
import co.ab180.airbridge.internal.network.model.GoogleReferrerDetails;
import co.ab180.airbridge.internal.network.model.HuaweiStoreReferrerDetails;
import co.ab180.airbridge.internal.network.model.InstallReferrerData;
import co.ab180.airbridge.internal.network.model.MetaInstallReferrerData;
import co.ab180.airbridge.internal.network.model.UserInfo;
import co.ab180.airbridge.internal.w.b;
import co.ab180.airbridge.internal.w.c;
import co.ab180.airbridge.internal.z.f;
import d5.n;
import ie.j;
import ie.m;
import java.util.Map;
import je.D;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0018\b\u0002\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000F\u0010\u0010J#\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000F\u0010\u0015J\u0013\u0010\u000F\u001A\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000F\u0010\u0017J\u0013\u0010\u0019\u001A\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u001B\u0010\u001D\u001A\u00020\u001A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\u001B\u001A\u0004\b\u000F\u0010\u001CR\u001B\u0010 \u001A\u00020\u001E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001B\u001A\u0004\b\u0019\u0010\u001FR\u001B\u0010%\u001A\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001B\u001A\u0004\b#\u0010$R\u001B\u0010(\u001A\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001B\u001A\u0004\b\"\u0010\'R\u0014\u0010,\u001A\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lco/ab180/airbridge/internal/y/a;", "", "<init>", "()V", "", "eventUUID", "", "createdTimeMillis", "Lco/ab180/airbridge/internal/network/model/UserInfo;", "userInfo", "Lco/ab180/airbridge/internal/network/model/EventData;", "data", "", "sdkAttributes", "Lco/ab180/airbridge/internal/network/body/EventBody;", "a", "(Ljava/lang/String;JLco/ab180/airbridge/internal/network/model/UserInfo;Lco/ab180/airbridge/internal/network/model/EventData;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "Lco/ab180/airbridge/internal/w/c;", "eventSession", "(Lco/ab180/airbridge/internal/w/b;Lco/ab180/airbridge/internal/w/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "b", "Landroid/content/Context;", "Lie/j;", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/b0/i;", "c", "d", "()Lco/ab180/airbridge/internal/b0/i;", "scrapper", "Lco/ab180/airbridge/internal/c0/f/a;", "()Lco/ab180/airbridge/internal/c0/f/a;", "preferences", "Lco/ab180/airbridge/internal/e0/j0;", "e", "Lco/ab180/airbridge/internal/e0/j0;", "urlLinkHandler", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    private final j a;
    private final j b;
    private final j c;
    private final j d;
    private final j0 e;

    public a() {
        this.a = f.b(Context.class);
        this.b = f.b(AirbridgeOption.class);
        this.c = f.b(i.class);
        this.d = f.b(co.ab180.airbridge.internal.c0.f.a.class);
        this.e = new j0(k0.a(this.a(), this.b()));
    }

    private final Context a() {
        return (Context)this.a.getValue();
    }

    public static Object a(a a0, String s, long v, UserInfo userInfo0, EventData eventData0, Map map0, Continuation continuation0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = "3efe8d13-c04f-42e2-aeda-012080aa4e9c";
        }
        if((v1 & 2) != 0) {
            v = System.currentTimeMillis();
        }
        if((v1 & 4) != 0) {
            userInfo0 = null;
        }
        if((v1 & 8) != 0) {
            eventData0 = null;
        }
        return (v1 & 16) == 0 ? a0.a(s, v, userInfo0, eventData0, map0, continuation0) : a0.a(s, v, userInfo0, eventData0, null, continuation0);
    }

    @Nullable
    public final Object a(@NotNull b b0, @NotNull c c0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lco/ab180/airbridge/internal/w/b;", "eventSeed", "Lco/ab180/airbridge/internal/w/c;", "eventSession", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/network/model/EventData;", "continuation", "", "createEventData", "(Lco/ab180/airbridge/internal/w/b;Lco/ab180/airbridge/internal/w/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.delegate.DataBuilder", f = "DataBuilder.kt", l = {57}, m = "createEventData")
        static final class co.ab180.airbridge.internal.y.a.b extends oe.c {
            Object a;
            int b;
            final a c;
            Object d;
            Object e;
            Object f;

            public co.ab180.airbridge.internal.y.a.b(a a0, Continuation continuation0) {
                this.c = a0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, null, this);
            }
        }

        GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0;
        a a3;
        HuaweiStoreReferrerDetails huaweiStoreReferrerDetails1;
        d d0;
        c c1;
        b b1;
        a a1;
        co.ab180.airbridge.internal.y.a.b a$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.y.a.b) {
            a$b0 = (co.ab180.airbridge.internal.y.a.b)continuation0;
            int v = a$b0.b;
            if((v & 0x80000000) == 0) {
                a$b0 = new co.ab180.airbridge.internal.y.a.b(this, continuation0);
            }
            else {
                a$b0.b = v ^ 0x80000000;
            }
        }
        else {
            a$b0 = new co.ab180.airbridge.internal.y.a.b(this, continuation0);
        }
        Object object0 = a$b0.a;
        ne.a a0 = ne.a.a;
        switch(a$b0.b) {
            case 0: {
                n.D(object0);
                i i0 = this.d();
                String s = this.b().getFacebookAppId();
                a$b0.d = this;
                a$b0.e = b0;
                a$b0.f = c0;
                a$b0.b = 1;
                object0 = i0.a(b0.j(), s, a$b0);
                if(object0 == a0) {
                    return a0;
                }
                a1 = this;
                b1 = b0;
                c1 = c0;
                break;
            }
            case 1: {
                c1 = (c)a$b0.f;
                b1 = (b)a$b0.e;
                a1 = (a)a$b0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s1 = c1.c();
        long v1 = c1.d();
        long v2 = a1.b().getSessionTimeoutMillis();
        String s2 = b1.r().a();
        String s3 = b1.l();
        String s4 = b1.l();
        Boolean boolean0 = s4 == null || s4.length() == 0 ? null : Boolean.valueOf(a1.e.e(b1.l()));
        Long long0 = ((d)object0).j();
        Long long1 = ((d)object0).i();
        String s5 = b1.p();
        String s6 = s5 == null || s5.length() == 0 ? ((d)object0).l() : b1.p();
        Long long2 = ((d)object0).m();
        String s7 = b1.o();
        co.ab180.airbridge.internal.b0.m.e e0 = ((d)object0).k();
        MetaInstallReferrerData metaInstallReferrerData0 = e0 == null ? null : co.ab180.airbridge.internal.a0.e.a(e0);
        co.ab180.airbridge.internal.b0.m.b b2 = ((d)object0).g();
        GoogleReferrerDetails googleReferrerDetails0 = b2 == null ? null : co.ab180.airbridge.internal.a0.e.a(b2);
        co.ab180.airbridge.internal.b0.m.c c2 = ((d)object0).h();
        if(c2 == null) {
            d0 = (d)object0;
            huaweiStoreReferrerDetails1 = null;
        }
        else {
            HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0 = co.ab180.airbridge.internal.a0.e.a(c2);
            d0 = (d)object0;
            huaweiStoreReferrerDetails1 = huaweiStoreReferrerDetails0;
        }
        co.ab180.airbridge.internal.b0.m.a a2 = d0.f();
        if(a2 == null) {
            a3 = a1;
            galaxyStoreReferrerDetails0 = null;
        }
        else {
            a3 = a1;
            galaxyStoreReferrerDetails0 = co.ab180.airbridge.internal.a0.e.a(a2);
        }
        InstallReferrerData installReferrerData0 = new InstallReferrerData(googleReferrerDetails0, huaweiStoreReferrerDetails1, galaxyStoreReferrerDetails0);
        Context context0 = a3.a();
        AirbridgeOption airbridgeOption0 = a3.b();
        String s8 = co.ab180.airbridge.internal.e0.d.b.a(context0, airbridgeOption0);
        Context context1 = a3.a();
        return new EventData(s1, v1, v2, s2, s3, boolean0, long0, long1, s6, long2, s7, metaInstallReferrerData0, installReferrerData0, s8, co.ab180.airbridge.internal.e0.d.b.a(context1), b1.n());
    }

    @Nullable
    public final Object a(@NotNull String s, long v, @Nullable UserInfo userInfo0, @Nullable EventData eventData0, @Nullable Map map0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000E\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\n\u001A\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0086@¢\u0006\u0004\b\u000E\u0010\u000F"}, d2 = {"", "eventUUID", "", "createdTimeMillis", "Lco/ab180/airbridge/internal/network/model/UserInfo;", "userInfo", "Lco/ab180/airbridge/internal/network/model/EventData;", "data", "", "", "sdkAttributes", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/network/body/EventBody;", "continuation", "createEventBody", "(Ljava/lang/String;JLco/ab180/airbridge/internal/network/model/UserInfo;Lco/ab180/airbridge/internal/network/model/EventData;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.delegate.DataBuilder", f = "DataBuilder.kt", l = {42, 44}, m = "createEventBody")
        static final class co.ab180.airbridge.internal.y.a.a extends oe.c {
            Object a;
            int b;
            final a c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            long k;

            public co.ab180.airbridge.internal.y.a.a(a a0, Continuation continuation0) {
                this.c = a0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, 0L, null, null, null, this);
            }
        }

        AppInfo appInfo0;
        a a1;
        String s6;
        Map map2;
        String s5;
        long v3;
        EventData eventData2;
        UserInfo userInfo2;
        String s4;
        co.ab180.airbridge.internal.y.a.a a$a0;
        if(continuation0 instanceof co.ab180.airbridge.internal.y.a.a) {
            a$a0 = (co.ab180.airbridge.internal.y.a.a)continuation0;
            int v1 = a$a0.b;
            if((v1 & 0x80000000) == 0) {
                a$a0 = new co.ab180.airbridge.internal.y.a.a(this, continuation0);
            }
            else {
                a$a0.b = v1 ^ 0x80000000;
            }
        }
        else {
            a$a0 = new co.ab180.airbridge.internal.y.a.a(this, continuation0);
        }
        Object object0 = a$a0.a;
        ne.a a0 = ne.a.a;
        switch(a$a0.b) {
            case 0: {
                n.D(object0);
                s4 = this.b().getPlatform();
                a$a0.d = this;
                userInfo2 = userInfo0;
                a$a0.e = userInfo2;
                eventData2 = eventData0;
                a$a0.f = eventData2;
                a$a0.g = map0;
                a$a0.h = s;
                a$a0.i = "M_A_v4.7.0";
                a$a0.j = s4;
                v3 = v;
                a$a0.k = v3;
                a$a0.b = 1;
                Object object1 = this.a(a$a0);
                if(object1 == a0) {
                    return a0;
                }
                s5 = "M_A_v4.7.0";
                object0 = object1;
                map2 = map0;
                s6 = s;
                a1 = this;
                break;
            }
            case 1: {
                long v4 = a$a0.k;
                s4 = (String)a$a0.j;
                String s7 = (String)a$a0.i;
                s6 = (String)a$a0.h;
                map2 = (Map)a$a0.g;
                EventData eventData3 = (EventData)a$a0.f;
                UserInfo userInfo3 = (UserInfo)a$a0.e;
                a1 = (a)a$a0.d;
                n.D(object0);
                s5 = s7;
                eventData2 = eventData3;
                userInfo2 = userInfo3;
                v3 = v4;
                break;
            }
            case 2: {
                long v2 = a$a0.k;
                UserInfo userInfo1 = (UserInfo)a$a0.j;
                appInfo0 = (AppInfo)a$a0.i;
                String s1 = (String)a$a0.h;
                String s2 = (String)a$a0.g;
                String s3 = (String)a$a0.f;
                Map map1 = (Map)a$a0.e;
                EventData eventData1 = (EventData)a$a0.d;
                n.D(object0);
                return map1 == null ? new EventBody(s3, s2, s1, appInfo0, ((DeviceInfo)object0), userInfo1, eventData1, v2, null) : new EventBody(s3, s2, s1, appInfo0, ((DeviceInfo)object0), userInfo1, eventData1, v2, D.O(new m("sdkAttributes", map1)));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a$a0.d = eventData2;
        a$a0.e = map2;
        a$a0.f = s6;
        a$a0.g = s5;
        a$a0.h = s4;
        a$a0.i = (AppInfo)object0;
        a$a0.j = userInfo2;
        a$a0.k = v3;
        a$a0.b = 2;
        Object object2 = a1.b(a$a0);
        if(object2 == a0) {
            return a0;
        }
        appInfo0 = (AppInfo)object0;
        return map2 == null ? new EventBody(s6, s5, s4, appInfo0, ((DeviceInfo)object2), userInfo2, eventData2, v3, null) : new EventBody(s6, s5, s4, appInfo0, ((DeviceInfo)object2), userInfo2, eventData2, v3, D.O(new m("sdkAttributes", map2)));
    }

    @Nullable
    public final Object a(@NotNull Continuation continuation0) {
        return this.d().b(continuation0);
    }

    private final AirbridgeOption b() {
        return (AirbridgeOption)this.b.getValue();
    }

    @Nullable
    public final Object b(@NotNull Continuation continuation0) {
        i i0 = this.d();
        boolean z = this.b().isLocationCollectionEnabled();
        Map map0 = this.c().v();
        if(this.b().isCollectTCFDataEnabled()) {
            Context context0 = this.a();
            return i0.a(z, map0, k.c.a(context0), continuation0);
        }
        return i0.a(z, map0, null, continuation0);
    }

    private final co.ab180.airbridge.internal.c0.f.a c() {
        return (co.ab180.airbridge.internal.c0.f.a)this.d.getValue();
    }

    private final i d() {
        return (i)this.c.getValue();
    }
}

