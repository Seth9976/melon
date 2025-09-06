package co.ab180.airbridge.internal.b0;

import co.ab180.airbridge.internal.b0.m.d;
import co.ab180.airbridge.internal.c0.f.a;
import co.ab180.airbridge.internal.e0.a0;
import co.ab180.airbridge.internal.e0.z;
import co.ab180.airbridge.internal.network.model.AppInfo;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.network.model.LocationInfo;
import co.ab180.airbridge.internal.network.model.NetworkInfo;
import co.ab180.airbridge.internal.network.model.ScreenInfo;
import co.ab180.airbridge.internal.z.f;
import d5.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001A\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u000F\u0010\t\u001A\u00020\nH\u0016¢\u0006\u0004\b\t\u0010\u0003J\u0013\u0010\f\u001A\u00020\u000BH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\bJE\u0010\u0007\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\r2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000F2\u0014\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000FH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0014J%\u0010\u0007\u001A\u00020\u00172\u0006\u0010\u0015\u001A\u00020\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0018R\u001B\u0010\u001D\u001A\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u001B\u0010 \u001A\u00020\u001E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u001A\u001A\u0004\b\f\u0010\u001FR\u001B\u0010#\u001A\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u001A\u001A\u0004\b\u0007\u0010\"R\u001B\u0010\'\u001A\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001B\u0010\u001A\u001A\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lco/ab180/airbridge/internal/b0/j;", "Lco/ab180/airbridge/internal/b0/i;", "<init>", "()V", "", "f", "()Ljava/lang/String;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "Lie/H;", "Lco/ab180/airbridge/internal/network/model/AppInfo;", "b", "", "locationCollectionEnabled", "", "deviceAlias", "", "iabtcf", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "(ZLjava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chkInstallReferrer", "facebookAppId", "Lco/ab180/airbridge/internal/b0/d;", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/c0/f/a;", "Lie/j;", "d", "()Lco/ab180/airbridge/internal/c0/f/a;", "preferences", "Lco/ab180/airbridge/internal/b0/g;", "()Lco/ab180/airbridge/internal/b0/g;", "installReferrerProvider", "Lco/ab180/airbridge/internal/b0/b;", "()Lco/ab180/airbridge/internal/b0/b;", "deviceInfoProvider", "Lco/ab180/airbridge/internal/b0/k;", "e", "()Lco/ab180/airbridge/internal/b0/k;", "uuidProvider", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class j implements i {
    private final ie.j a;
    private final ie.j b;
    private final ie.j c;
    private final ie.j d;

    public j() {
        this.a = f.b(a.class);
        this.b = f.b(g.class);
        this.c = f.b(b.class);
        this.d = f.b(k.class);
    }

    private final b a() {
        return (b)this.c.getValue();
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    @Nullable
    public Object a(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "getDeviceUUID", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.ScrapperImpl", f = "Scrapper.kt", l = {67, 68}, m = "getDeviceUUID")
        static final class c extends oe.c {
            Object a;
            int b;
            final j c;
            Object d;
            Object e;

            public c(j j0, Continuation continuation0) {
                this.c = j0;
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

        j j1;
        String s2;
        j j0;
        c j$c0;
        if(continuation0 instanceof c) {
            j$c0 = (c)continuation0;
            int v = j$c0.b;
            if((v & 0x80000000) == 0) {
                j$c0 = new c(this, continuation0);
            }
            else {
                j$c0.b = v ^ 0x80000000;
            }
        }
        else {
            j$c0 = new c(this, continuation0);
        }
        Object object0 = j$c0.a;
        ne.a a0 = ne.a.a;
        String s = null;
        switch(j$c0.b) {
            case 0: {
                n.D(object0);
                k k0 = this.e();
                j$c0.d = this;
                j$c0.b = 1;
                object0 = k0.a(j$c0);
                if(object0 == a0) {
                    return a0;
                }
                j0 = this;
                goto label_24;
            }
            case 1: {
                j0 = (j)j$c0.d;
                n.D(object0);
            label_24:
                String s1 = ((d)object0) == null ? null : ((d)object0).d();
                k k1 = j0.e();
                j$c0.d = j0;
                j$c0.e = s1;
                j$c0.b = 2;
                Object object1 = k1.c(j$c0);
                if(object1 == a0) {
                    return a0;
                }
                s2 = s1;
                object0 = object1;
                j1 = j0;
                break;
            }
            case 2: {
                s2 = (String)j$c0.e;
                j1 = (j)j$c0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((co.ab180.airbridge.internal.b0.a.a)object0) != null) {
            s = ((co.ab180.airbridge.internal.b0.a.a)object0).c();
        }
        return co.ab180.airbridge.internal.e0.g.a(s2, s, j1.f(), j1.d().r());
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    @Nullable
    public Object a(boolean z, @Nullable String s, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0096@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "chkInstallReferrer", "", "facebookAppId", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/b0/d;", "continuation", "", "createEventBodyPart", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.ScrapperImpl", f = "Scrapper.kt", l = {0x87, 0x89, 0x8A, 0x8B}, m = "createEventBodyPart")
        static final class co.ab180.airbridge.internal.b0.j.b extends oe.c {
            Object a;
            int b;
            final j c;
            Object d;
            Object e;
            Object f;
            Object g;

            public co.ab180.airbridge.internal.b0.j.b(j j0, Continuation continuation0) {
                this.c = j0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(false, null, this);
            }
        }

        co.ab180.airbridge.internal.b0.m.c c0;
        j j2;
        String s2;
        co.ab180.airbridge.internal.b0.m.b b2;
        co.ab180.airbridge.internal.b0.j.b j$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.j.b) {
            j$b0 = (co.ab180.airbridge.internal.b0.j.b)continuation0;
            int v = j$b0.b;
            if((v & 0x80000000) == 0) {
                j$b0 = new co.ab180.airbridge.internal.b0.j.b(this, continuation0);
            }
            else {
                j$b0.b = v ^ 0x80000000;
            }
        }
        else {
            j$b0 = new co.ab180.airbridge.internal.b0.j.b(this, continuation0);
        }
        Object object0 = j$b0.a;
        ne.a a0 = ne.a.a;
        switch(j$b0.b) {
            case 0: {
                n.D(object0);
                if(z) {
                    g g0 = this.b();
                    j$b0.d = this;
                    j$b0.e = s;
                    j$b0.b = 1;
                    object0 = g0.b(j$b0);
                    if(object0 != a0) {
                        j2 = this;
                    label_48:
                        b2 = (co.ab180.airbridge.internal.b0.m.b)object0;
                        g g1 = j2.b();
                        j$b0.d = j2;
                        j$b0.e = s;
                        j$b0.f = b2;
                        j$b0.b = 2;
                        object0 = g1.g(j$b0);
                        if(object0 != a0) {
                        label_56:
                            g g2 = j2.b();
                            j$b0.d = j2;
                            j$b0.e = s;
                            j$b0.f = b2;
                            j$b0.g = (co.ab180.airbridge.internal.b0.m.c)object0;
                            j$b0.b = 3;
                            Object object1 = g2.e(j$b0);
                            if(object1 != a0) {
                                s2 = s;
                                c0 = (co.ab180.airbridge.internal.b0.m.c)object0;
                                object0 = object1;
                            label_67:
                                g g3 = j2.b();
                                j$b0.d = j2;
                                j$b0.e = b2;
                                j$b0.f = c0;
                                j$b0.g = (co.ab180.airbridge.internal.b0.m.a)object0;
                                j$b0.b = 4;
                                Object object2 = g3.a(s2, j$b0);
                                if(object2 != a0) {
                                    return new co.ab180.airbridge.internal.b0.d(b2, c0, ((co.ab180.airbridge.internal.b0.m.a)object0), ((co.ab180.airbridge.internal.b0.m.e)object2), new Long(j2.a().b()));
                                }
                            }
                        }
                    }
                    return a0;
                }
                return new co.ab180.airbridge.internal.b0.d(null, null, null, null, new Long(this.a().b()));
            }
            case 1: {
                s = (String)j$b0.e;
                j j3 = (j)j$b0.d;
                n.D(object0);
                j2 = j3;
                goto label_48;
            }
            case 2: {
                b2 = (co.ab180.airbridge.internal.b0.m.b)j$b0.f;
                s = (String)j$b0.e;
                j2 = (j)j$b0.d;
                n.D(object0);
                goto label_56;
            }
            case 3: {
                co.ab180.airbridge.internal.b0.m.c c1 = (co.ab180.airbridge.internal.b0.m.c)j$b0.g;
                co.ab180.airbridge.internal.b0.m.b b1 = (co.ab180.airbridge.internal.b0.m.b)j$b0.f;
                String s1 = (String)j$b0.e;
                j j1 = (j)j$b0.d;
                n.D(object0);
                c0 = c1;
                b2 = b1;
                s2 = s1;
                j2 = j1;
                goto label_67;
            }
            case 4: {
                co.ab180.airbridge.internal.b0.m.a a1 = (co.ab180.airbridge.internal.b0.m.a)j$b0.g;
                c0 = (co.ab180.airbridge.internal.b0.m.c)j$b0.f;
                co.ab180.airbridge.internal.b0.m.b b0 = (co.ab180.airbridge.internal.b0.m.b)j$b0.e;
                j j0 = (j)j$b0.d;
                n.D(object0);
                return new co.ab180.airbridge.internal.b0.d(b0, c0, a1, ((co.ab180.airbridge.internal.b0.m.e)object0), new Long(j0.a().b()));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    @Nullable
    public Object a(boolean z, @NotNull Map map0, @Nullable Map map1, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000B"}, d2 = {"", "locationCollectionEnabled", "", "", "deviceAlias", "", "iabtcf", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "continuation", "createDeviceInfo", "(ZLjava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.ScrapperImpl", f = "Scrapper.kt", l = {90, 93, 94, 0x5F, 0x60, 97, 98}, m = "createDeviceInfo")
        static final class co.ab180.airbridge.internal.b0.j.a extends oe.c {
            Object a;
            int b;
            final j c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            Object k;
            Object l;
            Object m;
            boolean n;
            boolean o;

            public co.ab180.airbridge.internal.b0.j.a(j j0, Continuation continuation0) {
                this.c = j0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(false, null, null, this);
            }
        }

        j j6;
        boolean z7;
        Map map16;
        boolean z6;
        String s17;
        String s16;
        String s15;
        String s14;
        Map map14;
        Boolean boolean5;
        String s13;
        Map map13;
        Boolean boolean4;
        String s12;
        String s8;
        String s7;
        Map map10;
        Boolean boolean1;
        String s6;
        Map map9;
        j j3;
        String s5;
        String s2;
        boolean z4;
        boolean z3;
        Map map6;
        String s1;
        j j1;
        Map map5;
        j j0;
        boolean z1;
        Map map3;
        Object object1;
        Map map2;
        co.ab180.airbridge.internal.b0.j.a j$a0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.j.a) {
            j$a0 = (co.ab180.airbridge.internal.b0.j.a)continuation0;
            int v = j$a0.b;
            if((v & 0x80000000) == 0) {
                j$a0 = new co.ab180.airbridge.internal.b0.j.a(this, continuation0);
            }
            else {
                j$a0.b = v ^ 0x80000000;
            }
        }
        else {
            j$a0 = new co.ab180.airbridge.internal.b0.j.a(this, continuation0);
        }
        Object object0 = j$a0.a;
        ne.a a0 = ne.a.a;
        switch(j$a0.b) {
            case 0: {
                n.D(object0);
                j$a0.d = this;
                map2 = map0;
                j$a0.e = map2;
                j$a0.f = map1;
                j$a0.n = z;
                j$a0.b = 1;
                object1 = this.a(j$a0);
                if(object1 == a0) {
                    return a0;
                }
                map3 = map1;
                z1 = z;
                j0 = this;
                goto label_33;
            }
            case 1: {
                z1 = j$a0.n;
                map3 = (Map)j$a0.f;
                Map map4 = (Map)j$a0.e;
                j0 = (j)j$a0.d;
                n.D(object0);
                object1 = object0;
                map2 = map4;
            label_33:
                boolean z2 = j0.d().r();
                String s = j0.d().h();
                k k0 = j0.e();
                j$a0.d = j0;
                j$a0.e = map2;
                j$a0.f = map3;
                j$a0.g = (String)object1;
                j$a0.h = s;
                j$a0.n = z1;
                j$a0.o = z2;
                j$a0.b = 2;
                Object object2 = k0.a(j$a0);
                if(object2 == a0) {
                    return a0;
                }
                map5 = map2;
                object0 = object2;
                j1 = j0;
                s1 = s;
                map6 = map3;
                z3 = z1;
                z4 = z2;
                s2 = (String)object1;
                goto label_68;
            }
            case 2: {
                z4 = j$a0.o;
                z3 = j$a0.n;
                String s3 = (String)j$a0.h;
                String s4 = (String)j$a0.g;
                Map map7 = (Map)j$a0.f;
                Map map8 = (Map)j$a0.e;
                j j2 = (j)j$a0.d;
                n.D(object0);
                j1 = j2;
                map5 = map8;
                map6 = map7;
                s2 = s4;
                s1 = s3;
            label_68:
                s5 = ((d)object0) == null ? null : ((d)object0).d();
                k k1 = j1.e();
                j$a0.d = j1;
                j$a0.e = map5;
                j$a0.f = map6;
                j$a0.g = s2;
                j$a0.h = s1;
                j$a0.i = s5;
                j$a0.n = z3;
                j$a0.o = z4;
                j$a0.b = 3;
                object0 = k1.a(j$a0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_91;
            }
            case 3: {
                z4 = j$a0.o;
                z3 = j$a0.n;
                s5 = (String)j$a0.i;
                s1 = (String)j$a0.h;
                s2 = (String)j$a0.g;
                map6 = (Map)j$a0.f;
                map5 = (Map)j$a0.e;
                j1 = (j)j$a0.d;
                n.D(object0);
            label_91:
                Boolean boolean0 = ((d)object0) == null ? null : Boolean.valueOf(((d)object0).c());
                k k2 = j1.e();
                j$a0.d = j1;
                j$a0.e = map5;
                j$a0.f = map6;
                j$a0.g = s2;
                j$a0.h = s1;
                j$a0.i = s5;
                j$a0.j = boolean0;
                j$a0.n = z3;
                j$a0.o = z4;
                j$a0.b = 4;
                Object object3 = k2.f(j$a0);
                if(object3 == a0) {
                    return a0;
                }
                j3 = j1;
                map9 = map6;
                s6 = s1;
                boolean1 = boolean0;
                object0 = object3;
                map10 = map5;
                s7 = s2;
                s8 = s5;
                goto label_131;
            }
            case 4: {
                z4 = j$a0.o;
                z3 = j$a0.n;
                Boolean boolean2 = (Boolean)j$a0.j;
                String s9 = (String)j$a0.i;
                String s10 = (String)j$a0.h;
                String s11 = (String)j$a0.g;
                Map map11 = (Map)j$a0.f;
                Map map12 = (Map)j$a0.e;
                j j4 = (j)j$a0.d;
                n.D(object0);
                j3 = j4;
                map10 = map12;
                map9 = map11;
                s7 = s11;
                s6 = s10;
                s8 = s9;
                boolean1 = boolean2;
            label_131:
                s12 = ((d)object0) == null ? null : ((d)object0).d();
                k k3 = j3.e();
                j$a0.d = j3;
                j$a0.e = map10;
                j$a0.f = map9;
                j$a0.g = s7;
                j$a0.h = s6;
                j$a0.i = s8;
                j$a0.j = boolean1;
                j$a0.k = s12;
                j$a0.n = z3;
                j$a0.o = z4;
                j$a0.b = 5;
                object0 = k3.f(j$a0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_158;
            }
            case 5: {
                z4 = j$a0.o;
                z3 = j$a0.n;
                s12 = (String)j$a0.k;
                boolean1 = (Boolean)j$a0.j;
                s8 = (String)j$a0.i;
                s6 = (String)j$a0.h;
                s7 = (String)j$a0.g;
                map9 = (Map)j$a0.f;
                map10 = (Map)j$a0.e;
                j3 = (j)j$a0.d;
                n.D(object0);
            label_158:
                Boolean boolean3 = ((d)object0) == null ? null : Boolean.valueOf(((d)object0).c());
                k k4 = j3.e();
                j$a0.d = j3;
                j$a0.e = map10;
                j$a0.f = map9;
                j$a0.g = s7;
                j$a0.h = s6;
                j$a0.i = s8;
                j$a0.j = boolean1;
                j$a0.k = s12;
                j$a0.l = boolean3;
                j$a0.n = z3;
                j$a0.o = z4;
                j$a0.b = 6;
                Object object4 = k4.c(j$a0);
                if(object4 == a0) {
                    return a0;
                }
                boolean4 = boolean3;
                object0 = object4;
                map13 = map9;
                s13 = s6;
                boolean5 = boolean1;
                map14 = map10;
                s14 = s7;
                s15 = s8;
                s16 = s12;
                goto label_199;
            }
            case 6: {
                z4 = j$a0.o;
                boolean z5 = j$a0.n;
                boolean4 = (Boolean)j$a0.l;
                s16 = (String)j$a0.k;
                boolean5 = (Boolean)j$a0.j;
                s15 = (String)j$a0.i;
                s13 = (String)j$a0.h;
                s14 = (String)j$a0.g;
                Map map15 = (Map)j$a0.f;
                map14 = (Map)j$a0.e;
                j j5 = (j)j$a0.d;
                n.D(object0);
                map13 = map15;
                j3 = j5;
                z3 = z5;
            label_199:
                s17 = ((co.ab180.airbridge.internal.b0.a.a)object0) == null ? null : ((co.ab180.airbridge.internal.b0.a.a)object0).c();
                k k5 = j3.e();
                j$a0.d = j3;
                j$a0.e = map14;
                j$a0.f = map13;
                j$a0.g = s14;
                j$a0.h = s13;
                j$a0.i = s15;
                j$a0.j = boolean5;
                j$a0.k = s16;
                j$a0.l = boolean4;
                j$a0.m = s17;
                j$a0.n = z3;
                j$a0.o = z4;
                j$a0.b = 7;
                object0 = k5.c(j$a0);
                if(object0 == a0) {
                    return a0;
                }
                z6 = z4;
                map16 = map13;
                z7 = z3;
                j6 = j3;
                break;
            }
            case 7: {
                boolean z8 = j$a0.o;
                z7 = j$a0.n;
                s17 = (String)j$a0.m;
                boolean4 = (Boolean)j$a0.l;
                s16 = (String)j$a0.k;
                boolean5 = (Boolean)j$a0.j;
                s15 = (String)j$a0.i;
                s13 = (String)j$a0.h;
                s14 = (String)j$a0.g;
                Map map17 = (Map)j$a0.f;
                map14 = (Map)j$a0.e;
                j6 = (j)j$a0.d;
                n.D(object0);
                z6 = z8;
                map16 = map17;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Integer integer0 = ((co.ab180.airbridge.internal.b0.a.a)object0) == null ? null : new Integer(((co.ab180.airbridge.internal.b0.a.a)object0).d());
        String s18 = j6.a().p();
        String s19 = j6.a().n();
        String s20 = z.a.a();
        String s21 = j6.a().r();
        String s22 = j6.a().u();
        String s23 = j6.a().f();
        String s24 = j6.a().k();
        String s25 = a0.a(j6.a().m().g());
        ScreenInfo screenInfo0 = co.ab180.airbridge.internal.a0.e.a(j6.a().m());
        NetworkInfo networkInfo0 = new NetworkInfo(j6.a().s(), j6.a().e(), j6.a().d(), j6.a().c() == co.ab180.airbridge.internal.network.model.a.a, j6.a().c() == co.ab180.airbridge.internal.network.model.a.b, j6.a().l());
        if(z7) {
            co.ab180.airbridge.internal.b0.b.b b$b0 = j6.a().g();
            if(b$b0 != null) {
                LocationInfo locationInfo0 = co.ab180.airbridge.internal.a0.e.a(b$b0);
                return map14.isEmpty() ? new DeviceInfo(s14, z6, s13, s15, boolean5, s16, boolean4, s17, integer0, s18, s19, s20, s21, "Android", s22, s23, s24, s25, screenInfo0, networkInfo0, locationInfo0, null, map16) : new DeviceInfo(s14, z6, s13, s15, boolean5, s16, boolean4, s17, integer0, s18, s19, s20, s21, "Android", s22, s23, s24, s25, screenInfo0, networkInfo0, locationInfo0, map14, map16);
            }
        }
        return map14.isEmpty() ? new DeviceInfo(s14, z6, s13, s15, boolean5, s16, boolean4, s17, integer0, s18, s19, s20, s21, "Android", s22, s23, s24, s25, screenInfo0, networkInfo0, null, null, map16) : new DeviceInfo(s14, z6, s13, s15, boolean5, s16, boolean4, s17, integer0, s18, s19, s20, s21, "Android", s22, s23, s24, s25, screenInfo0, networkInfo0, null, map14, map16);
    }

    private final g b() {
        return (g)this.b.getValue();
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    @Nullable
    public Object b(@NotNull Continuation continuation0) {
        return new AppInfo(this.a().h(), String.valueOf(this.a().t()), this.a().a());
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    @Nullable
    public Object c(@NotNull Continuation continuation0) {
        return this.a().j();
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    public void c() {
        this.e().c();
    }

    private final a d() {
        return (a)this.a.getValue();
    }

    private final k e() {
        return (k)this.d.getValue();
    }

    @Override  // co.ab180.airbridge.internal.b0.i
    @NotNull
    public String f() {
        return this.d().h();
    }
}

