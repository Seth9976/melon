package co.ab180.airbridge.internal;

import A7.d;
import android.content.Context;
import android.net.Uri;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.common.AirbridgeTrackingLink;
import co.ab180.airbridge.internal.b0.i;
import co.ab180.airbridge.internal.c0.c;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.e0.g0;
import co.ab180.airbridge.internal.e0.h0;
import co.ab180.airbridge.internal.e0.j0;
import co.ab180.airbridge.internal.e0.k0;
import co.ab180.airbridge.internal.e0.m;
import co.ab180.airbridge.internal.e0.n0;
import co.ab180.airbridge.internal.e0.p;
import co.ab180.airbridge.internal.network.body.EventBody;
import co.ab180.airbridge.internal.network.body.EventChunk;
import co.ab180.airbridge.internal.network.body.LogData;
import co.ab180.airbridge.internal.network.body.LogInfo;
import co.ab180.airbridge.internal.network.body.ReportChunk;
import co.ab180.airbridge.internal.network.model.AppInfo;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.network.model.EventData;
import co.ab180.airbridge.internal.network.model.GoalData;
import co.ab180.airbridge.internal.network.model.UserInfo;
import co.ab180.airbridge.internal.network.response.DeferredDeeplinkResult;
import co.ab180.airbridge.internal.network.response.GeneratedTrackingLinkInfo;
import co.ab180.airbridge.internal.network.response.TrackingLinkResult;
import co.ab180.airbridge.internal.y.a;
import co.ab180.airbridge.internal.z.f;
import co.ab180.airbridge.throwable.AirbridgeHttpResponseException;
import d5.n;
import ie.H;
import ie.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Queue;
import je.C;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u00BE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0006\u001A\u00020\bH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0003J\u001F\u0010\u0006\u001A\u0004\u0018\u00010\b2\b\u0010\u0011\u001A\u0004\u0018\u00010\bH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010\u0012J\u0015\u0010\u0013\u001A\u0004\u0018\u00010\bH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0013\u0010\u000EJ#\u0010\u0006\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\bH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010\u0017J3\u0010\u0006\u001A\u00020\u000F2\u001E\u0010\u001A\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0019\u0012\u0004\u0012\u00020\u000F0\u0018H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010\u001BJ+\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00192\b\b\u0002\u0010\u001D\u001A\u00020\u001CH\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010\u001EJ\u0017\u0010\u0010\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\u0010\u0010!J\u0017\u0010\u0006\u001A\u00020\u001F2\u0006\u0010\"\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\u0006\u0010!J\u0017\u0010#\u001A\u00020\u00042\u0006\u0010\"\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b#\u0010$J\u0013\u0010\u0010\u001A\u00020\u000FH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u001B\u0010\u0006\u001A\u00020\b2\u0006\u0010&\u001A\u00020%H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010\'J\u0013\u0010#\u001A\u00020\u000FH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b#\u0010\u000EJ7\u0010\u0006\u001A\u00020\b2\u0006\u0010(\u001A\u00020\u001C2\b\u0010)\u001A\u0004\u0018\u00010\b2\u0006\u0010*\u001A\u00020\b2\b\u0010,\u001A\u0004\u0018\u00010+H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010-J\u0019\u0010\u0013\u001A\u00020\u000F2\b\u0010.\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0013\u0010/J\u0019\u0010\u0010\u001A\u00020\u000F2\b\u00100\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0010\u0010/J\u0019\u0010#\u001A\u00020\u000F2\b\u00101\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b#\u0010/J!\u0010\u0006\u001A\u00020\u000F2\u0006\u00102\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u000103H\u0016\u00A2\u0006\u0004\b\u0006\u00104J\u000F\u0010\u0006\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0003J!\u0010\u0006\u001A\u00020\u000F2\u0006\u00102\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0006\u00105J\u000F\u0010\u0013\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0003J\u000F\u0010\n\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\n\u0010\u0003J\u001F\u0010#\u001A\u00020\u000F2\u0006\u00102\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b#\u00105J\u0017\u0010\u0006\u001A\u00020\u000F2\u0006\u00102\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0006\u0010/J\u000F\u0010#\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b#\u0010\u0003J/\u0010\u0006\u001A\u0002082\u0006\u00106\u001A\u00020\b2\u0012\u00107\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002030\u0019H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u00109J\u0013\u0010\n\u001A\u00020\u000FH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\n\u0010\u000EJ\u0017\u0010\f\u001A\u00020\u000F2\u0006\u0010:\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\f\u0010/J\u001B\u0010\u0006\u001A\u00020\u001F2\u0006\u0010\"\u001A\u00020\u001FH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0006\u0010;J\u001F\u0010\u0006\u001A\u00020\u00042\u0006\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b\u0006\u0010?R\u001B\u0010D\u001A\u00020@8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0006\u0010A\u001A\u0004\bB\u0010CR\u001B\u0010H\u001A\u00020E8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b#\u0010A\u001A\u0004\bF\u0010GR\u001B\u0010L\u001A\u00020I8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0010\u0010A\u001A\u0004\bJ\u0010KR\u001B\u0010P\u001A\u00020M8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0013\u0010A\u001A\u0004\bN\u0010OR\u001B\u0010T\u001A\u00020Q8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\n\u0010A\u001A\u0004\bR\u0010SR\u001B\u0010X\u001A\u00020U8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\f\u0010A\u001A\u0004\bV\u0010WR\u0014\u0010[\u001A\u00020Y8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010ZR\u0014\u0010^\u001A\u00020\\8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010]R\u0014\u0010a\u001A\u00020_8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bF\u0010`R\u0014\u0010d\u001A\u00020b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bV\u0010c\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006e"}, d2 = {"Lco/ab180/airbridge/internal/q;", "Lco/ab180/airbridge/internal/o;", "<init>", "()V", "", "value", "a", "(Ljava/lang/Boolean;)Z", "", "link", "e", "(Ljava/lang/String;)Z", "f", "()Ljava/lang/String;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "c", "dataString", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "trackingLink", "touchPointType", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "onSuccess", "(Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeout", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "(J)J", "timeInMillis", "b", "(J)Z", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "(Lco/ab180/airbridge/internal/w/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "priority", "tag", "message", "", "throwable", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "(Ljava/lang/String;)V", "email", "phone", "key", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "channel", "params", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "categories", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/body/EventBody;", "eventBody", "additionalBytes", "(Lco/ab180/airbridge/internal/network/body/EventBody;I)Z", "Landroid/content/Context;", "Lie/j;", "h", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "i", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/a0/a;", "g", "()Lco/ab180/airbridge/internal/a0/a;", "apiService", "Lco/ab180/airbridge/internal/c0/c;", "l", "()Lco/ab180/airbridge/internal/c0/c;", "storageDataSource", "Lco/ab180/airbridge/internal/b0/i;", "k", "()Lco/ab180/airbridge/internal/b0/i;", "scrapper", "Lco/ab180/airbridge/internal/c0/f/a;", "j", "()Lco/ab180/airbridge/internal/c0/f/a;", "preferences", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "sdf", "Lco/ab180/airbridge/internal/y/a;", "Lco/ab180/airbridge/internal/y/a;", "dataBuilder", "Lco/ab180/airbridge/internal/e0/j0;", "Lco/ab180/airbridge/internal/e0/j0;", "urlLinkHandler", "Lco/ab180/airbridge/internal/e0/h0;", "Lco/ab180/airbridge/internal/e0/h0;", "trackEventPolicy", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class q implements o {
    private final j a;
    private final j b;
    private final j c;
    private final j d;
    private final j e;
    private final j f;
    private final SimpleDateFormat g;
    private final a h;
    private final j0 i;
    private final h0 j;

    public q() {
        this.a = f.b(Context.class);
        this.b = f.b(AirbridgeOption.class);
        this.c = f.b(co.ab180.airbridge.internal.a0.a.class);
        this.d = f.b(c.class);
        this.e = f.b(i.class);
        this.f = f.b(co.ab180.airbridge.internal.c0.f.a.class);
        this.g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.h = new a();
        this.i = new j0(k0.a(this.h(), this.i()));
        this.j = new h0();
    }

    private final Object a(long v, Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001A\u00020\u00002\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0082@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "timeInMillis", "Lkotlin/coroutines/Continuation;", "continuation", "", "grantEventTransmit", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {413}, m = "grantEventTransmit")
        static final class co.ab180.airbridge.internal.q.f extends oe.c {
            Object a;
            int b;
            final q c;
            Object d;

            public co.ab180.airbridge.internal.q.f(q q0, Continuation continuation0) {
                this.c = q0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(0L, this);
            }
        }

        co.ab180.airbridge.internal.q.f q$f0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.f) {
            q$f0 = (co.ab180.airbridge.internal.q.f)continuation0;
            int v1 = q$f0.b;
            if((v1 & 0x80000000) == 0) {
                q$f0 = new co.ab180.airbridge.internal.q.f(this, continuation0);
            }
            else {
                q$f0.b = v1 ^ 0x80000000;
            }
        }
        else {
            q$f0 = new co.ab180.airbridge.internal.q.f(this, continuation0);
        }
        Object object0 = q$f0.a;
        ne.a a0 = ne.a.a;
        switch(q$f0.b) {
            case 0: {
                n.D(object0);
                long v2 = this.j().k();
                long v3 = this.i().getEventTransmitIntervalMillis() - (v - v2);
                if(v3 > 0L) {
                    b.e.d("Waiting for next transmission: second={" + g0.a.a(v3) + '}', new Object[0]);
                    q$f0.d = this;
                    q$f0.b = 1;
                    if(DelayKt.delay(v3, q$f0) == a0) {
                        return a0;
                    }
                }
                return new Long(co.ab180.airbridge.internal.o.a.b(this, 0L, 1, null));
            }
            case 1: {
                q q0 = (q)q$f0.d;
                n.D(object0);
                return new Long(co.ab180.airbridge.internal.o.a.b(q0, 0L, 1, null));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static Object a(q q0, int v, Continuation continuation0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 60000;
        }
        return q0.a(v, continuation0);
    }

    private final boolean a(EventBody eventBody0, int v) {
        if(Long.compare(this.l().d() + 1L, this.i().getEventMaximumBufferCount()) > 0) {
            b.e.e("Event packet is ignored by eventBufferCountLimit: category={" + eventBody0.getUuid() + "} body={" + eventBody0 + '}', new Object[0]);
            return true;
        }
        long v1 = this.l().a();
        n0 n00 = n0.b.a(v1 + ((long)v));
        double f = this.i().getEventMaximumBufferSize();
        if(n00.a(n0.b.b(f)) > 0) {
            b.e.e("Event packet is ignored by eventBufferSizeLimit: category={" + eventBody0.getUuid() + "} body={" + eventBody0 + '}', new Object[0]);
            return true;
        }
        return false;
    }

    @Override  // co.ab180.airbridge.internal.o
    public long a(long v) {
        this.j().c(v);
        return this.j().g();
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(int v, @Nullable String s, @NotNull String s1, @Nullable Throwable throwable0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001A\u00020\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000B"}, d2 = {"", "priority", "", "tag", "message", "", "throwable", "Lkotlin/coroutines/Continuation;", "continuation", "", "insertReport", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {548, 549}, m = "insertReport")
        static final class h extends oe.c {
            Object a;
            int b;
            final q c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            int k;

            public h(q q0, Continuation continuation0) {
                this.c = q0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(0, null, null, null, this);
            }
        }

        AppInfo appInfo0;
        c c3;
        LogInfo logInfo3;
        String s11;
        q q0;
        LogInfo logInfo1;
        c c1;
        String s6;
        String s5;
        String s3;
        String s2;
        h q$h0;
        if(continuation0 instanceof h) {
            q$h0 = (h)continuation0;
            int v1 = q$h0.b;
            if((v1 & 0x80000000) == 0) {
                q$h0 = new h(this, continuation0);
            }
            else {
                q$h0.b = v1 ^ 0x80000000;
            }
        }
        else {
            q$h0 = new h(this, continuation0);
        }
        Object object0 = q$h0.a;
        ne.a a0 = ne.a.a;
        switch(q$h0.b) {
            case 0: {
                n.D(object0);
                StringBuilder stringBuilder0 = new StringBuilder("Repository(");
                stringBuilder0.append(p.a(this));
                stringBuilder0.append(")#insertReport: {");
                stringBuilder0.append(v);
                stringBuilder0.append("} {");
                d.u(stringBuilder0, s, "} {", s1, "} {");
                stringBuilder0.append(throwable0);
                stringBuilder0.append('}');
                b.e.e(stringBuilder0.toString(), new Object[0]);
                s2 = "eb0f1a28-0366-4cb7-9c69-6b0d44fba68b";
                c c0 = this.l();
                s3 = "M_A_v4.7.0";
                String s4 = this.i().getPlatform();
                LogInfo logInfo0 = new LogInfo(co.ab180.airbridge.internal.network.model.d.i.a(v).a(), s1, (throwable0 == null ? null : throwable0.getClass().getName()));
                q$h0.d = this;
                q$h0.e = "eb0f1a28-0366-4cb7-9c69-6b0d44fba68b";
                q$h0.f = c0;
                q$h0.g = "eb0f1a28-0366-4cb7-9c69-6b0d44fba68b";
                q$h0.h = "M_A_v4.7.0";
                q$h0.i = s4;
                q$h0.j = logInfo0;
                q$h0.k = v;
                q$h0.b = 1;
                Object object1 = this.h.a(q$h0);
                if(object1 == a0) {
                    return a0;
                }
                s5 = "eb0f1a28-0366-4cb7-9c69-6b0d44fba68b";
                s6 = s4;
                c1 = c0;
                object0 = object1;
                logInfo1 = logInfo0;
                q0 = this;
                goto label_61;
            }
            case 1: {
                v = q$h0.k;
                LogInfo logInfo2 = (LogInfo)q$h0.j;
                String s7 = (String)q$h0.i;
                String s8 = (String)q$h0.h;
                String s9 = (String)q$h0.g;
                c c2 = (c)q$h0.f;
                String s10 = (String)q$h0.e;
                q0 = (q)q$h0.d;
                n.D(object0);
                logInfo1 = logInfo2;
                s2 = s10;
                c1 = c2;
                s5 = s9;
                s3 = s8;
                s6 = s7;
            label_61:
                q$h0.d = s2;
                q$h0.e = c1;
                q$h0.f = s5;
                q$h0.g = s3;
                q$h0.h = s6;
                q$h0.i = logInfo1;
                q$h0.j = (AppInfo)object0;
                q$h0.k = v;
                q$h0.b = 2;
                Object object2 = q0.h.b(q$h0);
                if(object2 == a0) {
                    return a0;
                }
                s11 = s5;
                logInfo3 = logInfo1;
                c3 = c1;
                appInfo0 = (AppInfo)object0;
                object0 = object2;
                break;
            }
            case 2: {
                v = q$h0.k;
                AppInfo appInfo1 = (AppInfo)q$h0.j;
                LogInfo logInfo4 = (LogInfo)q$h0.i;
                s6 = (String)q$h0.h;
                String s12 = (String)q$h0.g;
                String s13 = (String)q$h0.f;
                c c4 = (c)q$h0.e;
                String s14 = (String)q$h0.d;
                n.D(object0);
                s3 = s12;
                s11 = s13;
                appInfo0 = appInfo1;
                logInfo3 = logInfo4;
                s2 = s14;
                c3 = c4;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        c3.a(v, new LogData(s11, s3, s6, logInfo3, appInfo0, ((DeviceInfo)object0), System.currentTimeMillis()));
        return s2;
    }

    @Nullable
    public final Object a(int v, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u001A\u0010\u0005\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\u0086@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "timeout", "Lkotlin/coroutines/Continuation;", "", "", "continuation", "", "getAttributionData", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {296, 298}, m = "getAttributionData")
        static final class co.ab180.airbridge.internal.q.d extends oe.c {
            Object a;
            int b;
            final q c;
            Object d;
            Object e;
            int f;

            public co.ab180.airbridge.internal.q.d(q q0, Continuation continuation0) {
                this.c = q0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(0, this);
            }
        }

        q q0;
        int v2;
        Object object2;
        co.ab180.airbridge.internal.a0.a a2;
        co.ab180.airbridge.internal.q.d q$d0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.d) {
            q$d0 = (co.ab180.airbridge.internal.q.d)continuation0;
            int v1 = q$d0.b;
            if((v1 & 0x80000000) == 0) {
                q$d0 = new co.ab180.airbridge.internal.q.d(this, continuation0);
            }
            else {
                q$d0.b = v1 ^ 0x80000000;
            }
        }
        else {
            q$d0 = new co.ab180.airbridge.internal.q.d(this, continuation0);
        }
        Object object0 = q$d0.a;
        ne.a a0 = ne.a.a;
        switch(q$d0.b) {
            case 0: {
                n.D(object0);
                if(this.j().z()) {
                    Map map0 = this.j().w();
                    b.e.a("Return to cached attribution: {" + map0 + '}', new Object[0]);
                    return map0;
                }
                try {
                    co.ab180.airbridge.internal.a0.a a1 = this.g();
                    i i0 = this.k();
                    q$d0.d = this;
                    q$d0.e = a1;
                    q$d0.f = v;
                    q$d0.b = 1;
                    Object object1 = i0.a(q$d0);
                    if(object1 == a0) {
                        return a0;
                    }
                    a2 = a1;
                    object2 = object1;
                    v2 = v;
                    q0 = this;
                    goto label_39;
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                int v3 = q$d0.f;
                co.ab180.airbridge.internal.a0.a a3 = (co.ab180.airbridge.internal.a0.a)q$d0.e;
                q q1 = (q)q$d0.d;
                try {
                    n.D(object0);
                    v2 = v3;
                    q0 = q1;
                    a2 = a3;
                    object2 = object0;
                label_39:
                    String s = q0.j().s();
                    q$d0.d = q0;
                    q$d0.e = null;
                    q$d0.b = 2;
                    object0 = a2.a(((String)object2), s, v2, q$d0);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_48;
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 2: {
                q0 = (q)q$d0.d;
                try {
                    n.D(object0);
                label_48:
                    if(!((Map)object0).isEmpty()) {
                        b.e.a("Succeeded to fetch attribution: attribution={" + ((Map)object0) + '}', new Object[0]);
                        q0.j().a(((Map)object0));
                        q0.j().h(true);
                        return (Map)object0;
                    }
                    b.e.a("Failed to fetch attribution", new Object[0]);
                    return null;
                }
                catch(Exception exception0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b.e.a("Failed to fetche attribution: error={" + exception0 + '}', new Object[0]);
        return null;
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(@NotNull co.ab180.airbridge.internal.w.b b0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lco/ab180/airbridge/internal/w/b;", "eventSeed", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "insertEvent", "(Lco/ab180/airbridge/internal/w/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {0x1B0, 435}, m = "insertEvent")
        static final class g extends oe.c {
            Object a;
            int b;
            final q c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            long k;

            public g(q q0, Continuation continuation0) {
                this.c = q0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, this);
            }
        }

        String s5;
        co.ab180.airbridge.internal.network.model.c c4;
        co.ab180.airbridge.internal.w.b b2;
        String s3;
        co.ab180.airbridge.internal.w.b b1;
        UserInfo userInfo1;
        a a2;
        long v2;
        co.ab180.airbridge.internal.network.model.c c2;
        q q0;
        String s1;
        g q$g0;
        if(continuation0 instanceof g) {
            q$g0 = (g)continuation0;
            int v = q$g0.b;
            if((v & 0x80000000) == 0) {
                q$g0 = new g(this, continuation0);
            }
            else {
                q$g0.b = v ^ 0x80000000;
            }
        }
        else {
            q$g0 = new g(this, continuation0);
        }
        Object object0 = q$g0.a;
        ne.a a0 = ne.a.a;
        String s = null;
        switch(q$g0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.network.model.c c0 = b0.m();
                switch(c0.ordinal()) {
                    case 0: 
                    case 5: {
                        s1 = this.j().s();
                        break;
                    }
                    default: {
                        s1 = "6e29ea65-da3e-4c15-a838-eb1e26722553";
                    }
                }
                String s2 = this.j().p();
                if(s2 == null) {
                    s2 = "";
                }
                co.ab180.airbridge.internal.w.c c1 = new co.ab180.airbridge.internal.w.c(s2, this.j().A());
                a a1 = this.h;
                long v1 = b0.k();
                UserInfo userInfo0 = co.ab180.airbridge.internal.a0.e.a(this.j(), this.i().isUserInfoHashEnabled());
                q$g0.d = this;
                q$g0.e = b0;
                q$g0.f = c0;
                q$g0.g = s1;
                q$g0.h = a1;
                q$g0.i = s1;
                q$g0.j = userInfo0;
                q$g0.k = v1;
                q$g0.b = 1;
                Object object1 = this.h.a(b0, c1, q$g0);
                if(object1 == a0) {
                    return a0;
                }
                q0 = this;
                c2 = c0;
                object0 = object1;
                v2 = v1;
                a2 = a1;
                userInfo1 = userInfo0;
                b1 = b0;
                s3 = s1;
                goto label_61;
            }
            case 1: {
                v2 = q$g0.k;
                UserInfo userInfo2 = (UserInfo)q$g0.j;
                s1 = (String)q$g0.i;
                a a3 = (a)q$g0.h;
                String s4 = (String)q$g0.g;
                co.ab180.airbridge.internal.network.model.c c3 = (co.ab180.airbridge.internal.network.model.c)q$g0.f;
                b1 = (co.ab180.airbridge.internal.w.b)q$g0.e;
                q q1 = (q)q$g0.d;
                n.D(object0);
                userInfo1 = userInfo2;
                s3 = s4;
                a2 = a3;
                q0 = q1;
                c2 = c3;
            label_61:
                Map map0 = b1.q();
                Map map1 = map0 == null ? co.ab180.airbridge.internal.e0.b.a(q0.i()) : C.U(co.ab180.airbridge.internal.e0.b.a(q0.i()), map0);
                q$g0.d = q0;
                q$g0.e = b1;
                q$g0.f = c2;
                q$g0.g = s3;
                q$g0.h = null;
                q$g0.i = null;
                q$g0.j = null;
                q$g0.b = 2;
                object0 = a2.a(s1, v2, userInfo1, ((EventData)object0), map1, q$g0);
                if(object0 == a0) {
                    return a0;
                }
                b2 = b1;
                c4 = c2;
                break;
            }
            case 2: {
                s3 = (String)q$g0.g;
                c4 = (co.ab180.airbridge.internal.network.model.c)q$g0.f;
                b2 = (co.ab180.airbridge.internal.w.b)q$g0.e;
                q q2 = (q)q$g0.d;
                n.D(object0);
                q0 = q2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        EventBody eventBody0 = (EventBody)object0;
        try {
            co.ab180.airbridge.internal.parser.c c5 = co.ab180.airbridge.internal.parser.c.b;
            J j0 = I.a;
            De.d d0 = j0.b(EventBody.class);
            if(!d0.equals(j0.b(Map.class))) {
                if(!d0.equals(j0.b(List.class))) {
                    s5 = c5.b(eventBody0).toString();
                    goto label_99;
                }
                if(eventBody0 != null) {
                    s5 = b0.a(((List)eventBody0)).toString();
                    goto label_99;
                }
            }
            else if(eventBody0 != null) {
                s5 = b0.a(((Map)eventBody0)).toString();
                goto label_99;
            }
        }
        catch(Throwable unused_ex) {
        }
        b.e.e("Event packet is ignored by Parser error: category={" + eventBody0.getUuid() + "} body={" + eventBody0 + '}', new Object[0]);
        return s3;
    label_99:
        if(q0.a(eventBody0, s5.length())) {
            return s3;
        }
        long v3 = b2.k();
        String s6 = q0.i().isSDKSignatureSecretEnabled$airbridge_release() ? q0.i().getSecretId() : null;
        String s7 = q0.i().isSDKSignatureSecretEnabled$airbridge_release() ? co.ab180.airbridge.internal.signature.e.b.a(s5, v3) : null;
        q0.l().a(s3, c4.b(), v3, s5, s6, s7);
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(c4);
        if(c4 == co.ab180.airbridge.internal.network.model.c.k) {
            StringBuilder stringBuilder1 = new StringBuilder("(");
            EventData eventData0 = eventBody0.getEventData();
            if(eventData0 != null) {
                GoalData goalData0 = eventData0.getGoalData();
                if(goalData0 != null) {
                    s = goalData0.getCategory();
                }
            }
            stringBuilder1.append(s);
            stringBuilder1.append(')');
            stringBuilder0.append(stringBuilder1.toString());
        }
        b.e.d("Event packet is stored in storage: categories={" + c4.b() + '}', new Object[0]);
        Date date0 = new Date(v3);
        b.e.a("QUEUED - " + stringBuilder0 + " [" + eventBody0.getUuid() + "](" + s5.length() + " bytes) TRIGGERED AT [" + q0.g.format(date0) + ']', new Object[0]);
        return s3;
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(@NotNull String s, @NotNull String s1, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001A\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00002\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "trackingLink", "touchPointType", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "continuation", "", "createTouchPoint", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {0xE5, 0xE8}, m = "createTouchPoint")
        static final class co.ab180.airbridge.internal.q.a extends oe.c {
            Object a;
            int b;
            final q c;

            public co.ab180.airbridge.internal.q.a(q q0, Continuation continuation0) {
                this.c = q0;
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

        co.ab180.airbridge.internal.q.a q$a0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.a) {
            q$a0 = (co.ab180.airbridge.internal.q.a)continuation0;
            int v = q$a0.b;
            if((v & 0x80000000) == 0) {
                q$a0 = new co.ab180.airbridge.internal.q.a(this, continuation0);
            }
            else {
                q$a0.b = v ^ 0x80000000;
            }
        }
        else {
            q$a0 = new co.ab180.airbridge.internal.q.a(this, continuation0);
        }
        Object object0 = q$a0.a;
        ne.a a0 = ne.a.a;
        switch(q$a0.b) {
            case 0: {
                n.D(object0);
                StringBuilder stringBuilder0 = new StringBuilder("Repository(");
                stringBuilder0.append(p.a(this));
                stringBuilder0.append(")#createTouchPoint: {");
                stringBuilder0.append(s);
                stringBuilder0.append("} {");
                String s2 = androidx.appcompat.app.o.r(stringBuilder0, s1, '}');
                b.e.e(s2, new Object[0]);
                try {
                    switch(s1) {
                        case "click": {
                            co.ab180.airbridge.internal.a0.a a1 = this.g();
                            q$a0.b = 1;
                            object0 = a1.b(s, q$a0);
                            return object0 == a0 ? a0 : ((TrackingLinkResult)object0);
                        }
                        case "impression": {
                            co.ab180.airbridge.internal.a0.a a2 = this.g();
                            q$a0.b = 2;
                            object0 = a2.a(s, s1, q$a0);
                            return object0 == a0 ? a0 : ((TrackingLinkResult)object0);
                        }
                        default: {
                            throw new IllegalArgumentException("wrong Argument. touchPointType={" + s1 + '}');
                        }
                    }
                label_33:
                    n.D(object0);
                    return (TrackingLinkResult)object0;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: 
            case 2: {
                goto label_33;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(throwable0 instanceof m) {
            throw new AirbridgeHttpResponseException(((m)throwable0).a(), (throwable0.getMessage() == null ? "" : throwable0.getMessage()), "create touch point");
        }
        throw throwable0;
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(@NotNull String s, @NotNull Map map0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0001\u001A\u00020\u00002\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "channel", "", "", "params", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "continuation", "createTrackingLink", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {617}, m = "createTrackingLink")
        static final class co.ab180.airbridge.internal.q.b extends oe.c {
            Object a;
            int b;
            final q c;

            public co.ab180.airbridge.internal.q.b(q q0, Continuation continuation0) {
                this.c = q0;
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

        co.ab180.airbridge.internal.q.b q$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.b) {
            q$b0 = (co.ab180.airbridge.internal.q.b)continuation0;
            int v = q$b0.b;
            if((v & 0x80000000) == 0) {
                q$b0 = new co.ab180.airbridge.internal.q.b(this, continuation0);
            }
            else {
                q$b0.b = v ^ 0x80000000;
            }
        }
        else {
            q$b0 = new co.ab180.airbridge.internal.q.b(this, continuation0);
        }
        Object object0 = q$b0.a;
        ne.a a0 = ne.a.a;
        switch(q$b0.b) {
            case 0: {
                n.D(object0);
                try {
                    co.ab180.airbridge.internal.a0.a a1 = this.g();
                    q$b0.b = 1;
                    object0 = a1.a(s, map0, q$b0);
                    if(object0 == a0) {
                        return a0;
                    label_19:
                        n.D(object0);
                    }
                    return new AirbridgeTrackingLink(Uri.parse(((GeneratedTrackingLinkInfo)object0).getShortURL()), Uri.parse(((GeneratedTrackingLinkInfo)object0).getQrcodeURL()));
                }
                catch(m m0) {
                    break;
                }
            }
            case 1: {
                goto label_19;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v1 = m0.a();
        if(400 <= v1 && 0x1F3 >= v1) {
            m0 = new AirbridgeHttpResponseException(m0.a(), (m0.getMessage() == null ? "" : m0.getMessage()), "creating tracking link");
        }
        throw m0;
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(@Nullable String s, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "dataString", "Lkotlin/coroutines/Continuation;", "continuation", "", "getActualDeeplink", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {0xA4}, m = "getActualDeeplink")
        static final class co.ab180.airbridge.internal.q.c extends oe.c {
            Object a;
            int b;
            final q c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.q.c(q q0, Continuation continuation0) {
                this.c = q0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, this);
            }
        }

        q q0;
        co.ab180.airbridge.internal.q.c q$c0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.c) {
            q$c0 = (co.ab180.airbridge.internal.q.c)continuation0;
            int v = q$c0.b;
            if((v & 0x80000000) == 0) {
                q$c0 = new co.ab180.airbridge.internal.q.c(this, continuation0);
            }
            else {
                q$c0.b = v ^ 0x80000000;
            }
        }
        else {
            q$c0 = new co.ab180.airbridge.internal.q.c(this, continuation0);
        }
        Object object0 = q$c0.a;
        ne.a a0 = ne.a.a;
        switch(q$c0.b) {
            case 0: {
                n.D(object0);
                b.e.e("Repository(" + p.a(this) + ")#getActualDeeplink: {" + s + '}', new Object[0]);
                if(s != null && s.length() != 0) {
                    if(!this.i.d(s)) {
                        return this.i.a(s);
                    }
                    co.ab180.airbridge.internal.a0.a a1 = this.g();
                    q$c0.d = this;
                    q$c0.e = s;
                    q$c0.b = 1;
                    object0 = a1.a(s, q$c0);
                    if(object0 == a0) {
                        return a0;
                    }
                    q0 = this;
                    break;
                }
                return null;
            }
            case 1: {
                s = (String)q$c0.e;
                q0 = (q)q$c0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s1 = ((TrackingLinkResult)object0).getDeeplink();
        if(s1 == null || s1.length() == 0) {
            throw new Exception("\'" + s + "\' link seems not having any path");
        }
        return q0.i.a(((TrackingLinkResult)object0).getDeeplink());
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(@NotNull Continuation continuation0) {
        return this.k().a(continuation0);
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object a(@NotNull k k0, @NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\u001E\u0010\u0004\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00002\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0096@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/Function1;", "", "", "Lie/H;", "onSuccess", "Lkotlin/coroutines/Continuation;", "continuation", "", "processAttributionResult", "(Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {0xFD}, m = "processAttributionResult")
        static final class co.ab180.airbridge.internal.q.i extends oe.c {
            Object a;
            int b;
            final q c;

            public co.ab180.airbridge.internal.q.i(q q0, Continuation continuation0) {
                this.c = q0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, this);
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl$processAttributionResult$2", f = "Repository.kt", l = {260, 273, 275}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.q.j extends oe.i implements we.n {
            private Object a;
            int b;
            long c;
            int d;
            final q e;
            final k f;

            public co.ab180.airbridge.internal.q.j(q q0, k k0, Continuation continuation0) {
                this.e = q0;
                this.f = k0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new co.ab180.airbridge.internal.q.j(this.e, this.f, continuation0);
                continuation1.a = object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.q.j)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                CoroutineScope coroutineScope2;
                long v2;
                int v;
                CoroutineScope coroutineScope0;
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                switch(this.d) {
                    case 0: {
                        n.D(object0);
                        coroutineScope0 = (CoroutineScope)this.a;
                        v = 0;
                        goto label_19;
                    }
                    case 1: {
                        long v1 = this.c;
                        v = this.b;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.a;
                        n.D(object0);
                        v2 = v1;
                        coroutineScope2 = coroutineScope1;
                        goto label_33;
                    }
                    case 2: 
                    case 3: {
                        v = this.b;
                        coroutineScope2 = (CoroutineScope)this.a;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            alab1:
                while(true) {
                    do {
                    label_18:
                        coroutineScope0 = coroutineScope2;
                    label_19:
                        if(!CoroutineScopeKt.isActive(coroutineScope0) || v >= this.e.i().getAttributionRequestMaxCount$airbridge_release()) {
                            break alab1;
                        }
                        ++v;
                        b.e.a("Request attribution fetch: " + v + " / 5", new Object[0]);
                        long v3 = System.currentTimeMillis();
                        int v4 = (int)(((float)this.e.i().getAttributionTimeout$airbridge_release()) * 1.2f);
                        this.a = coroutineScope0;
                        this.b = v;
                        this.c = v3;
                        this.d = 1;
                        Object object1 = this.e.a(v4, this);
                        if(object1 == a0) {
                            return a0;
                        }
                        v2 = v3;
                        coroutineScope2 = coroutineScope0;
                        object0 = object1;
                    label_33:
                        if(((Map)object0) != null) {
                            if(CoroutineScopeKt.isActive(coroutineScope2)) {
                                b.e.d("Successfully fetched the Attribution", new Object[0]);
                                this.f.invoke(((Map)object0));
                                if(this.e.i().getOnAttributionResultReceiveListener() != null) {
                                    this.e.j().c(false);
                                }
                            }
                            return h0;
                        }
                        long v5 = System.currentTimeMillis() - v2;
                        if(!CoroutineScopeKt.isActive(coroutineScope2) || v5 >= ((long)this.e.i().getAttributionTimeout$airbridge_release())) {
                            goto label_48;
                        }
                        long v6 = ((long)this.e.i().getAttributionTimeout$airbridge_release()) - v5;
                        this.a = coroutineScope2;
                        this.b = v;
                        this.d = 2;
                    }
                    while(DelayKt.delay(v6, this) != a0);
                    return a0;
                label_48:
                    this.a = coroutineScope2;
                    this.b = v;
                    this.d = 3;
                    if(DelayKt.delay(1L, this) != a0) {
                        goto label_18;
                    }
                    return a0;
                }
                if(v >= this.e.i().getAttributionRequestMaxCount$airbridge_release()) {
                    b.e.d("Failed to fetch attribution, the SDK will try again later when the app starts", new Object[0]);
                }
                return h0;
            }
        }

        co.ab180.airbridge.internal.q.i q$i0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.i) {
            q$i0 = (co.ab180.airbridge.internal.q.i)continuation0;
            int v = q$i0.b;
            if((v & 0x80000000) == 0) {
                q$i0 = new co.ab180.airbridge.internal.q.i(this, continuation0);
            }
            else {
                q$i0.b = v ^ 0x80000000;
            }
        }
        else {
            q$i0 = new co.ab180.airbridge.internal.q.i(this, continuation0);
        }
        Object object0 = q$i0.a;
        ne.a a0 = ne.a.a;
        switch(q$i0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.b.b b$b0 = b.e;
                b$b0.e("Repository(" + p.a(this) + ")#processAttributionResult", new Object[0]);
                if(this.j().e()) {
                    b$b0.d("Start to fetch attributions", new Object[0]);
                    co.ab180.airbridge.internal.q.j q$j0 = new co.ab180.airbridge.internal.q.j(this, k0, null);
                    q$i0.b = 1;
                    if(BuildersKt.withContext(Dispatchers.getIO(), q$j0, q$i0) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.o
    public void a() {
        this.j().a();
    }

    @Override  // co.ab180.airbridge.internal.o
    public void a(@NotNull String s) {
        this.j().a(s);
    }

    @Override  // co.ab180.airbridge.internal.o
    public void a(@NotNull String s, @Nullable Object object0) {
        if(object0 == null) {
            this.j().l(s);
            return;
        }
        this.j().a(s, object0);
    }

    @Override  // co.ab180.airbridge.internal.o
    public void a(@NotNull String s, @Nullable String s1) {
        if(s1 == null) {
            this.j().k(s);
            return;
        }
        this.j().a(s, s1);
    }

    @Override  // co.ab180.airbridge.internal.o
    public boolean a(@Nullable Boolean boolean0) {
        if(boolean0 != null) {
            this.j().g(boolean0.booleanValue());
        }
        return this.j().m();
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object b(@NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl$report$2", f = "Repository.kt", l = {0x204, 0x20B}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.q.k extends oe.i implements we.n {
            private Object a;
            Object b;
            Object c;
            int d;
            final q e;

            public co.ab180.airbridge.internal.q.k(q q0, Continuation continuation0) {
                this.e = q0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new co.ab180.airbridge.internal.q.k(this.e, continuation0);
                continuation1.a = object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.q.k)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                CoroutineScope coroutineScope2;
                Iterator iterator1;
                co.ab180.airbridge.internal.network.model.d d0;
                Iterator iterator0;
                CoroutineScope coroutineScope1;
                CoroutineScope coroutineScope0;
                ne.a a0 = ne.a.a;
                switch(this.d) {
                    case 0: {
                        n.D(object0);
                        coroutineScope0 = (CoroutineScope)this.a;
                        b.e.e("Repository(" + p.a(this.e) + ")#report", new Object[0]);
                        coroutineScope1 = coroutineScope0;
                        iterator0 = this.e.l().c().entrySet().iterator();
                        break;
                    }
                    case 1: {
                        d0 = (co.ab180.airbridge.internal.network.model.d)this.c;
                        iterator1 = (Iterator)this.b;
                        coroutineScope2 = (CoroutineScope)this.a;
                        try {
                            n.D(object0);
                            goto label_39;
                        }
                        catch(Throwable throwable0) {
                            goto label_42;
                        }
                    }
                    case 2: {
                        Iterator iterator2 = (Iterator)this.b;
                        coroutineScope0 = (CoroutineScope)this.a;
                        n.D(object0);
                        coroutineScope1 = coroutineScope0;
                        iterator0 = iterator2;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    int v = ((Number)((Map.Entry)object1).getKey()).intValue();
                    List list0 = (List)((Map.Entry)object1).getValue();
                    if(!CoroutineScopeKt.isActive(coroutineScope1)) {
                        break;
                    }
                    d0 = co.ab180.airbridge.internal.network.model.d.i.a(v);
                    try {
                        co.ab180.airbridge.internal.a0.a a1 = this.e.g();
                        ReportChunk reportChunk0 = co.ab180.airbridge.internal.a0.e.b(list0);
                        this.a = coroutineScope1;
                        this.b = iterator0;
                        this.c = d0;
                        this.d = 1;
                        if(a1.a(d0, System.currentTimeMillis(), reportChunk0, this) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        iterator1 = iterator0;
                        coroutineScope2 = coroutineScope1;
                        goto label_42;
                    }
                    iterator1 = iterator0;
                    coroutineScope2 = coroutineScope1;
                    try {
                    label_39:
                        b.e.d("Handle reporting log: level={" + d0 + '}', new Object[0]);
                        goto label_43;
                    }
                    catch(Throwable throwable0) {
                    }
                label_42:
                    b.e.d("Handle reporting log: level={" + d0 + "} error={" + throwable0 + '}', new Object[0]);
                label_43:
                    iterator0 = iterator1;
                    coroutineScope1 = coroutineScope2;
                    this.a = coroutineScope1;
                    this.b = iterator0;
                    this.c = null;
                    this.d = 2;
                    if(DelayKt.delay(1L, this) != a0) {
                        continue;
                    }
                    return a0;
                }
                this.e.l().b();
                return H.a;
            }
        }

        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.q.k(this, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Override  // co.ab180.airbridge.internal.o
    public void b() {
        this.j().b();
    }

    @Override  // co.ab180.airbridge.internal.o
    public void b(@Nullable String s) {
        this.j().b(s);
    }

    @Override  // co.ab180.airbridge.internal.o
    public void b(@NotNull String s, @NotNull String s1) {
        this.j().b(s, s1);
    }

    @Override  // co.ab180.airbridge.internal.o
    public boolean b(long v) {
        long v1 = this.j().g();
        boolean z = this.i().getSessionTimeoutMillis() <= v - v1;
        if(z) {
            this.j().g("f079fe03-c5ae-4a84-8ab5-e26c1d109564");
            this.j().b(System.currentTimeMillis());
        }
        return z;
    }

    @Override  // co.ab180.airbridge.internal.o
    public long c(long v) {
        this.j().a(v);
        return this.j().k();
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object c(@NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl$trackEvent$2", f = "Repository.kt", l = {365, 0x16F, 393}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.q.m extends oe.i implements we.n {
            private Object a;
            Object b;
            Object c;
            Object d;
            long e;
            int f;
            final q g;

            public co.ab180.airbridge.internal.q.m(q q0, Continuation continuation0) {
                this.g = q0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new co.ab180.airbridge.internal.q.m(this.g, continuation0);
                continuation1.a = object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.q.m)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lco/ab180/airbridge/internal/c0/a;", "it", "", "a", "(Lco/ab180/airbridge/internal/c0/a;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.q.m.a extends r implements k {
                    public static final co.ab180.airbridge.internal.q.m.a a;

                    static {
                        co.ab180.airbridge.internal.q.m.a.a = new co.ab180.airbridge.internal.q.m.a();
                    }

                    public co.ab180.airbridge.internal.q.m.a() {
                        super(1);
                    }

                    @NotNull
                    public final CharSequence a(@NotNull co.ab180.airbridge.internal.c0.a a0) {
                        return String.valueOf(a0.i());
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.a(((co.ab180.airbridge.internal.c0.a)object0));
                    }
                }

                Object object1;
                CoroutineScope coroutineScope1;
                Queue queue0;
                List list0;
                String s;
                long v;
                CoroutineScope coroutineScope0;
                ne.a a0 = ne.a.a;
                switch(this.f) {
                    case 0: {
                        n.D(object0);
                        coroutineScope0 = (CoroutineScope)this.a;
                        break;
                    }
                    case 1: {
                        v = this.e;
                        s = (String)this.d;
                        list0 = (List)this.c;
                        queue0 = (Queue)this.b;
                        coroutineScope1 = (CoroutineScope)this.a;
                        try {
                            n.D(object0);
                            object1 = object0;
                            goto label_67;
                        }
                        catch(m m0) {
                            goto label_81;
                        }
                        catch(Throwable throwable0) {
                            this.g.f(s);
                            throw throwable0;
                        }
                    }
                    case 2: {
                        v = this.e;
                        s = (String)this.d;
                        list0 = (List)this.c;
                        queue0 = (Queue)this.b;
                        coroutineScope1 = (CoroutineScope)this.a;
                        try {
                            n.D(object0);
                            b.e.d("Succeed to send event packets to Airbridge: categories={" + s + '}', new Object[0]);
                            goto label_90;
                        }
                        catch(m m0) {
                            goto label_81;
                        }
                        catch(Throwable throwable0) {
                            this.g.f(s);
                            throw throwable0;
                        }
                    }
                    case 3: {
                        coroutineScope0 = (CoroutineScope)this.a;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            label_24:
                while(CoroutineScopeKt.isActive(coroutineScope0)) {
                    List list1 = this.g.l().e();
                    if(list1.isEmpty()) {
                        break;
                    }
                    Queue queue1 = new LinkedList(list1);
                    CoroutineScope coroutineScope2 = coroutineScope0;
                    while(!queue1.isEmpty()) {
                        if(!CoroutineScopeKt.isActive(coroutineScope2)) {
                            break label_24;
                        }
                        ArrayList arrayList0 = new ArrayList();
                        int v1 = this.g.j.b();
                        if(1 <= v1) {
                            co.ab180.airbridge.internal.c0.a a1;
                            for(int v2 = 1; (a1 = (co.ab180.airbridge.internal.c0.a)queue1.poll()) != null; ++v2) {
                                arrayList0.add(a1);
                                if(v2 == v1) {
                                    break;
                                }
                            }
                        }
                        String s1 = je.p.q0(arrayList0, ", ", null, null, co.ab180.airbridge.internal.q.m.a.a, 30);
                        long v3 = System.currentTimeMillis();
                        try {
                            this.a = coroutineScope2;
                            this.b = queue1;
                            this.c = arrayList0;
                            this.d = s1;
                            this.e = v3;
                            this.f = 1;
                            object1 = this.g.a(v3, this);
                        }
                        catch(m m0) {
                            list0 = arrayList0;
                            s = s1;
                            coroutineScope1 = coroutineScope2;
                            queue0 = queue1;
                            v = v3;
                            goto label_81;
                        }
                        catch(Throwable throwable0) {
                            s = s1;
                            this.g.f(s);
                            throw throwable0;
                        }
                        if(object1 != a0) {
                            list0 = arrayList0;
                            s = s1;
                            coroutineScope1 = coroutineScope2;
                            queue0 = queue1;
                            v = v3;
                            try {
                            label_67:
                                v = ((Number)object1).longValue();
                                b.e.d("Send event packets to Airbridge: categories={" + s + '}', new Object[0]);
                                co.ab180.airbridge.internal.a0.a a2 = this.g.g();
                                EventChunk eventChunk0 = co.ab180.airbridge.internal.a0.e.a(list0);
                                this.a = coroutineScope1;
                                this.b = queue0;
                                this.c = list0;
                                this.d = s;
                                this.e = v;
                                this.f = 2;
                                if(a2.a(v, eventChunk0, this) != a0) {
                                    b.e.d("Succeed to send event packets to Airbridge: categories={" + s + '}', new Object[0]);
                                    goto label_90;
                                }
                                return a0;
                            }
                            catch(m m0) {
                            label_81:
                                this.g.f(s);
                                int v4 = m0.a();
                                if(400 > v4 || 0x1F3 < v4) {
                                    throw m0;
                                }
                                b.e.a("IGNORED - " + m0.a() + " : " + m0.getMessage(), new Object[0]);
                                goto label_90;
                            }
                            catch(Throwable throwable0) {
                            }
                            this.g.f(s);
                            throw throwable0;
                        label_90:
                            this.g.j.a(System.currentTimeMillis() - v);
                            for(Object object2: list0) {
                                this.g.l().a(((co.ab180.airbridge.internal.c0.a)object2).j());
                                Date date0 = new Date(((co.ab180.airbridge.internal.c0.a)object2).h());
                                Date date1 = new Date(v);
                                b.e.a("FLUSHED - " + co.ab180.airbridge.internal.network.model.c.n.a(((co.ab180.airbridge.internal.c0.a)object2).i()) + " [" + ((co.ab180.airbridge.internal.c0.a)object2).j() + "] TRIGGERED AT [" + this.g.g.format(date0) + "] SENT AT [" + this.g.g.format(date1) + ']', new Object[0]);
                            }
                            b.e.d("Event packet is removed in storage: categories={" + s + '}', new Object[0]);
                            queue1 = queue0;
                            coroutineScope2 = coroutineScope1;
                            continue;
                        }
                        return a0;
                    }
                    this.a = coroutineScope2;
                    this.b = null;
                    this.c = null;
                    this.d = null;
                    this.f = 3;
                    if(DelayKt.delay(1L, this) == a0) {
                        return a0;
                    }
                    coroutineScope0 = coroutineScope2;
                }
                return H.a;
            }
        }

        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.q.m(this, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Override  // co.ab180.airbridge.internal.o
    public void c() {
        this.k().c();
    }

    @Override  // co.ab180.airbridge.internal.o
    public void c(@Nullable String s) {
        this.j().c(s);
    }

    @Override  // co.ab180.airbridge.internal.o
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "getDeferredDeeplink", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl", f = "Repository.kt", l = {0xAE}, m = "getDeferredDeeplink")
        static final class co.ab180.airbridge.internal.q.e extends oe.c {
            Object a;
            int b;
            final q c;
            Object d;
            boolean e;

            public co.ab180.airbridge.internal.q.e(q q0, Continuation continuation0) {
                this.c = q0;
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

        boolean z1;
        q q0;
        co.ab180.airbridge.internal.q.e q$e0;
        if(continuation0 instanceof co.ab180.airbridge.internal.q.e) {
            q$e0 = (co.ab180.airbridge.internal.q.e)continuation0;
            int v = q$e0.b;
            if((v & 0x80000000) == 0) {
                q$e0 = new co.ab180.airbridge.internal.q.e(this, continuation0);
            }
            else {
                q$e0.b = v ^ 0x80000000;
            }
        }
        else {
            q$e0 = new co.ab180.airbridge.internal.q.e(this, continuation0);
        }
        Object object0 = q$e0.a;
        ne.a a0 = ne.a.a;
        switch(q$e0.b) {
            case 0: {
                n.D(object0);
                boolean z = this.j().f();
                if(!this.j().f()) {
                    q$e0.d = this;
                    q$e0.e = z;
                    q$e0.b = 1;
                    if(this.e(q$e0) == a0) {
                        return a0;
                    }
                }
                q0 = this;
                z1 = z;
                break;
            }
            case 1: {
                z1 = q$e0.e;
                q0 = (q)q$e0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s = q0.j().x();
        if(s != null && s.length() != 0) {
            if(!z1) {
                b.e.b("Succeed on loading error of fetching deferred-deeplink from storage: error={" + s + '}', new Object[0]);
            }
            throw new Throwable(s);
        }
        if(!z1) {
            b.e.d("Succeed on loading deferred-deeplink from storage: url={" + q0.j().q() + '}', new Object[0]);
        }
        return q0.j().q();
    }

    @Override  // co.ab180.airbridge.internal.o
    public void d() {
        this.j().d();
    }

    @Override  // co.ab180.airbridge.internal.o
    public void d(@Nullable String s) {
        this.j().f(s);
    }

    private final Object e(Continuation continuation0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.RepositoryImpl$request$2", f = "Repository.kt", l = {0xC3, 202, 202}, m = "invokeSuspend")
        static final class l extends oe.i implements we.n {
            Object a;
            int b;
            final q c;

            public l(q q0, Continuation continuation0) {
                this.c = q0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new l(this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((l)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                co.ab180.airbridge.internal.a0.a a2;
                Object object2;
                String s1;
                String s;
                ne.a a0;
                try {
                    a0 = ne.a.a;
                    s = null;
                    switch(this.b) {
                        case 0: {
                            goto label_4;
                        }
                        case 1: {
                            goto label_11;
                        }
                        case 2: {
                            goto label_24;
                        }
                        case 3: {
                            goto label_33;
                        }
                    }
                }
                catch(Throwable throwable0) {
                    goto label_42;
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            label_4:
                n.D(object0);
                try {
                    if(this.c.i().isFacebookDeferredAppLinkEnabled()) {
                        Context context0 = this.c.h();
                        this.b = 1;
                        Object object1 = co.ab180.airbridge.internal.d0.c.b.a.a(context0, this);
                        if(object1 == a0) {
                            return a0;
                        }
                        goto label_13;
                    label_11:
                        n.D(object0);
                        object1 = object0;
                    label_13:
                        s1 = (String)object1;
                        if(s1 != null && s1.length() != 0) {
                            b.e.d("Succeed on fetching deferred-deeplink from meta: url={" + s1 + '}', new Object[0]);
                        }
                        else {
                            goto label_15;
                        }
                    }
                    else {
                    label_15:
                        co.ab180.airbridge.internal.a0.a a1 = this.c.g();
                        this.a = a1;
                        this.b = 2;
                        object2 = a.a(this.c.h, null, 0L, null, null, null, this, 0x1F, null);
                        if(object2 == a0) {
                            return a0;
                        }
                        a2 = a1;
                        goto label_28;
                    }
                    goto label_43;
                }
                catch(Throwable throwable0) {
                    goto label_42;
                }
            label_24:
                co.ab180.airbridge.internal.a0.a a3 = (co.ab180.airbridge.internal.a0.a)this.a;
                try {
                    n.D(object0);
                    a2 = a3;
                    object2 = object0;
                label_28:
                    this.a = null;
                    this.b = 3;
                    Object object3 = a2.a(((EventBody)object2), this);
                    if(object3 == a0) {
                        return a0;
                    label_33:
                        n.D(object0);
                        object3 = object0;
                    }
                    s1 = ((DeferredDeeplinkResult)object3).getDeeplink();
                    if(s1 == null || s1.length() == 0) {
                        b.e.d("Succeed on fetching empty deferred-deeplink", new Object[0]);
                    }
                    else {
                        b.e.d("Succeed on fetching deferred-deeplink from airbridge: url={" + s1 + '}', new Object[0]);
                    }
                }
                catch(Throwable throwable0) {
                label_42:
                    s1 = n.t(throwable0);
                }
            label_43:
                if(!(s1 instanceof ie.o)) {
                    this.c.j().f(true);
                    co.ab180.airbridge.internal.c0.f.a a4 = this.c.j();
                    if(s1 != null && s1.length() != 0) {
                        s = s1;
                    }
                    a4.e(s);
                }
                Throwable throwable1 = ie.p.a(s1);
                if(throwable1 != null) {
                    b.e.b("Failed on fetching deferred-deeplink: error={" + throwable1 + '}', new Object[0]);
                    this.c.j().f(true);
                    this.c.j().j(throwable1.toString());
                }
                return H.a;
            }
        }

        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new l(this, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Override  // co.ab180.airbridge.internal.o
    public void e() {
        this.j().f(null);
        this.j().c(null);
        this.j().b(null);
        this.j().d();
        this.j().a();
    }

    @Override  // co.ab180.airbridge.internal.o
    public boolean e(@Nullable String s) {
        return this.i.c(s);
    }

    private final void f(String s) {
        b.e.d("Failed to send event packets to Airbridge: categories={" + s + '}', new Object[0]);
        this.j.a();
    }

    @Override  // co.ab180.airbridge.internal.o
    @NotNull
    public String f() {
        return this.k().f();
    }

    private final co.ab180.airbridge.internal.a0.a g() {
        return (co.ab180.airbridge.internal.a0.a)this.c.getValue();
    }

    private final Context h() {
        return (Context)this.a.getValue();
    }

    private final AirbridgeOption i() {
        return (AirbridgeOption)this.b.getValue();
    }

    private final co.ab180.airbridge.internal.c0.f.a j() {
        return (co.ab180.airbridge.internal.c0.f.a)this.f.getValue();
    }

    private final i k() {
        return (i)this.e.getValue();
    }

    private final c l() {
        return (c)this.d.getValue();
    }
}

