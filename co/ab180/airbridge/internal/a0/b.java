package co.ab180.airbridge.internal.a0;

import De.d;
import Tf.v;
import android.net.Uri.Builder;
import android.net.Uri;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.e0.d0;
import co.ab180.airbridge.internal.e0.i0;
import co.ab180.airbridge.internal.e0.j;
import co.ab180.airbridge.internal.network.body.EventBody;
import co.ab180.airbridge.internal.network.body.EventChunk;
import co.ab180.airbridge.internal.network.body.ReportChunk;
import co.ab180.airbridge.internal.network.response.DeferredDeeplinkResult;
import co.ab180.airbridge.internal.network.response.GeneratedTrackingLinkResult;
import co.ab180.airbridge.internal.network.response.TrackingLinkResult;
import co.ab180.airbridge.internal.parser.e.y;
import ie.H;
import ie.m;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C;
import je.D;
import je.x;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import we.n;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u00101\u001A\u00020\u0002\u0012\u0006\u0010,\u001A\u00020\u0002\u0012\u0006\u00100\u001A\u00020-\u00A2\u0006\u0004\b2\u00103J=\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00022\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b\t\u0010\fJ\u001F\u0010\t\u001A\u00020\u000F2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\t\u0010\u0010J/\u0010\t\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00022\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0006H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010\u0015J\u001B\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0002H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010\u0016J#\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u0002H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010\u0018J\u001B\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0002H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0019\u0010\u0016J7\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\rH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010\u001CJ\u001B\u0010\t\u001A\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010 J#\u0010\t\u001A\u00020%2\u0006\u0010\"\u001A\u00020!2\u0006\u0010$\u001A\u00020#H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010&J+\u0010\t\u001A\u00020%2\u0006\u0010(\u001A\u00020\'2\u0006\u0010\"\u001A\u00020!2\u0006\u0010$\u001A\u00020)H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010*R\u0016\u0010,\u001A\u00020\u00028\u0002@\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0016\u00100\u001A\u00020-8\u0002@\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001A\u00020\u00028\u0002@\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00064"}, d2 = {"Lco/ab180/airbridge/internal/a0/b;", "Lco/ab180/airbridge/internal/a0/a;", "", "url", "key", "trackingLink", "", "extras", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "function", "(Ljava/lang/String;)Ljava/lang/String;", "", "timeout", "Ljava/net/HttpURLConnection;", "(Ljava/lang/String;I)Ljava/net/HttpURLConnection;", "channel", "", "params", "Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchPointType", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "deviceUUID", "installEventUUID", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/body/EventBody;", "body", "Lco/ab180/airbridge/internal/network/response/DeferredDeeplinkResult;", "(Lco/ab180/airbridge/internal/network/body/EventBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "requestedAt", "Lco/ab180/airbridge/internal/network/body/EventChunk;", "chunk", "Lco/ab180/airbridge/internal/e0/d0;", "(JLco/ab180/airbridge/internal/network/body/EventChunk;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/network/model/d;", "logLevel", "Lco/ab180/airbridge/internal/network/body/ReportChunk;", "(Lco/ab180/airbridge/internal/network/model/d;JLco/ab180/airbridge/internal/network/body/ReportChunk;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "appToken", "Lco/ab180/airbridge/internal/a0/c;", "c", "Lco/ab180/airbridge/internal/a0/c;", "httpClient", "appName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/a0/c;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b implements a {
    private final String a;
    private final String b;
    private final c c;

    public b(@NotNull String s, @NotNull String s1, @NotNull c c0) {
        this.a = s;
        this.b = s1;
        this.c = c0;
    }

    public static TrackingLinkResult a(b b0, String s, String s1, String s2, Map map0, int v, Object object0) {
        if((v & 8) != 0) {
            map0 = x.a;
        }
        return b0.a(s, s1, s2, map0);
    }

    private final TrackingLinkResult a(String s, String s1, String s2, Map map0) {
        Object object0;
        String s3;
        HttpURLConnection httpURLConnection0 = j.a(this.a(s, 3000), true);
        co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
        LinkedHashMap linkedHashMap0 = C.U(D.O(new m(s1, s2)), map0);
        J j0 = I.a;
        Class class0 = Map.class;
        d d0 = j0.b(class0);
        boolean z = d0.equals(j0.b(class0));
        Class class1 = List.class;
        if(z) {
            s3 = b0.a(linkedHashMap0).toString();
        }
        else {
            s3 = d0.equals(j0.b(class1)) ? b0.a(((List)linkedHashMap0)).toString() : c0.b(linkedHashMap0).toString();
        }
        List list0 = null;
        String s4 = j.a(httpURLConnection0, s3, null, 2, null).d();
        Class class2 = TrackingLinkResult.class;
        d d1 = j0.b(class2);
        if(d1.equals(j0.b(class0))) {
            Map map1 = b0.a(new JSONObject(s4));
            if(map1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.response.TrackingLinkResult");
            }
            return (TrackingLinkResult)map1;
        }
        if(d1.equals(j0.b(class1))) {
            List list1 = b0.a(new JSONArray(s4));
            if(list1 instanceof TrackingLinkResult) {
                list0 = list1;
            }
            if(((TrackingLinkResult)list0) == null) {
                throw new IllegalAccessException();
            }
            return (TrackingLinkResult)list0;
        }
        JSONObject jSONObject0 = new JSONObject(s4);
        co.ab180.airbridge.internal.parser.a a0 = co.ab180.airbridge.internal.parser.c.a(c0, class2);
        if(a0 == null) {
            object0 = null;
        }
        else {
            y y0 = a0.b();
            object0 = y0 == null ? null : y0.a(jSONObject0);
        }
        if(object0 instanceof TrackingLinkResult) {
            list0 = object0;
        }
        if(((TrackingLinkResult)list0) == null) {
            throw new IllegalAccessException();
        }
        return (TrackingLinkResult)list0;
    }

    private final String a(String s) {
        return v.p0("https://{FUNCTION}.airbridge.io", "{FUNCTION}", s);
    }

    private final HttpURLConnection a(String s, int v) {
        URL uRL0 = new URL(s);
        return j.a(j.a(j.a(j.a(j.a(j.a(this.c.a(uRL0)), "Authorization", "AIRBRIDGE-SDK-TOKEN " + this.b), "Content-Type", "application/json"), "Accept", "application/json"), "Accept-Encoding", "utf-8"), v, v);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(long v, @NotNull EventChunk eventChunk0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/e0/d0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$trackEvent$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class h extends i implements n {
            int a;
            final b b;
            final long c;
            final EventChunk d;

            public h(b b0, long v, EventChunk eventChunk0, Continuation continuation0) {
                this.b = b0;
                this.c = v;
                this.d = eventChunk0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new h(this.b, this.c, this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((h)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                HttpURLConnection httpURLConnection0 = j.a(j.a(this.b.a(this.b.a("event") + "/v1/apps/" + this.b.a, 60000), "X-Airbridge-Request-Timestamp", String.valueOf(this.c)), true);
                co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
                EventChunk eventChunk0 = this.d;
                J j0 = I.a;
                d d0 = j0.b(EventChunk.class);
                if(d0.equals(j0.b(Map.class))) {
                    if(eventChunk0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    }
                    return j.a(httpURLConnection0, b0.a(((Map)eventChunk0)).toString(), null, 2, null);
                }
                if(d0.equals(j0.b(List.class))) {
                    if(eventChunk0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    return j.a(httpURLConnection0, b0.a(((List)eventChunk0)).toString(), null, 2, null);
                }
                return j.a(httpURLConnection0, c0.b(eventChunk0).toString(), null, 2, null);
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new h(this, v, eventChunk0, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(@NotNull EventBody eventBody0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/network/response/DeferredDeeplinkResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$getDeferredDeeplink$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.a0.b.e extends i implements n {
            int a;
            final b b;
            final EventBody c;

            public co.ab180.airbridge.internal.a0.b.e(b b0, EventBody eventBody0, Continuation continuation0) {
                this.b = b0;
                this.c = eventBody0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.a0.b.e(this.b, this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.a0.b.e)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Object object1;
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Uri.Builder uri$Builder0 = Uri.parse((this.b.a("touchpoint") + "/deferred-deeplink/v1/apps/" + this.b.a)).buildUpon();
                uri$Builder0.appendQueryParameter("device_uuid", this.c.getDeviceInfo().getUuid());
                uri$Builder0.appendQueryParameter("os_name", this.c.getDeviceInfo().getOsName());
                uri$Builder0.appendQueryParameter("os_version", this.c.getDeviceInfo().getOsVersion());
                uri$Builder0.appendQueryParameter("device_model", this.c.getDeviceInfo().getModel());
                uri$Builder0.appendQueryParameter("device_type", this.c.getDeviceInfo().getType());
                String s = this.c.getDeviceInfo().getGaid();
                if(s != null) {
                    uri$Builder0.appendQueryParameter("gaid", s);
                }
                List list0 = null;
                String s1 = uri$Builder0.build().toString();
                HttpURLConnection httpURLConnection0 = this.b.a(s1, 15000);
                j.a(httpURLConnection0, "X-Airbridge-SDK-Version", this.c.getSdkVersion());
                d0 d00 = j.a(httpURLConnection0);
                co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
                String s2 = d00.d();
                J j0 = I.a;
                Class class0 = DeferredDeeplinkResult.class;
                d d0 = j0.b(class0);
                if(d0.equals(j0.b(Map.class))) {
                    Map map0 = b0.a(new JSONObject(s2));
                    if(map0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.response.DeferredDeeplinkResult");
                    }
                    return (DeferredDeeplinkResult)map0;
                }
                if(d0.equals(j0.b(List.class))) {
                    List list1 = b0.a(new JSONArray(s2));
                    if(list1 instanceof DeferredDeeplinkResult) {
                        list0 = list1;
                    }
                    if(((DeferredDeeplinkResult)list0) == null) {
                        throw new IllegalAccessException();
                    }
                    return (DeferredDeeplinkResult)list0;
                }
                JSONObject jSONObject0 = new JSONObject(s2);
                co.ab180.airbridge.internal.parser.a a0 = co.ab180.airbridge.internal.parser.c.a(c0, class0);
                if(a0 == null) {
                    object1 = null;
                }
                else {
                    y y0 = a0.b();
                    object1 = y0 == null ? null : y0.a(jSONObject0);
                }
                if(object1 instanceof DeferredDeeplinkResult) {
                    list0 = object1;
                }
                if(((DeferredDeeplinkResult)list0) == null) {
                    throw new IllegalAccessException();
                }
                return (DeferredDeeplinkResult)list0;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.a0.b.e(this, eventBody0, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(@NotNull co.ab180.airbridge.internal.network.model.d d0, long v, @NotNull ReportChunk reportChunk0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/e0/d0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$report$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class g extends i implements n {
            int a;
            final b b;
            final co.ab180.airbridge.internal.network.model.d c;
            final ReportChunk d;

            public g(b b0, co.ab180.airbridge.internal.network.model.d d0, ReportChunk reportChunk0, Continuation continuation0) {
                this.b = b0;
                this.c = d0;
                this.d = reportChunk0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new g(this.b, this.c, this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((g)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                HttpURLConnection httpURLConnection0 = j.a(this.b.a(this.b.a("config") + "/android/v1/apps/" + this.b.a + '/' + this.c.a(), 30000), true);
                co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
                ReportChunk reportChunk0 = this.d;
                J j0 = I.a;
                d d0 = j0.b(ReportChunk.class);
                if(d0.equals(j0.b(Map.class))) {
                    if(reportChunk0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    }
                    return j.a(httpURLConnection0, b0.a(((Map)reportChunk0)).toString(), null, 2, null);
                }
                if(d0.equals(j0.b(List.class))) {
                    if(reportChunk0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    return j.a(httpURLConnection0, b0.a(((List)reportChunk0)).toString(), null, 2, null);
                }
                return j.a(httpURLConnection0, c0.b(reportChunk0).toString(), null, 2, null);
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new g(this, d0, reportChunk0, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(@NotNull String s, @NotNull String s1, int v, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0003\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$getAttributionResult$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.a0.b.d extends i implements n {
            int a;
            final b b;
            final String c;
            final String d;
            final int e;

            public co.ab180.airbridge.internal.a0.b.d(b b0, String s, String s1, int v, Continuation continuation0) {
                this.b = b0;
                this.c = s;
                this.d = s1;
                this.e = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.a0.b.d(this.b, this.c, this.d, this.e, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.a0.b.d)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Object object1;
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                List list0 = null;
                d5.n.D(object0);
                String s = i0.a(i0.a(i0.a(Uri.parse((this.b.a("attribution") + "/attribution-result/v1/apps/" + this.b.a)), "device_uuid", this.c), "install_event_uuid", this.d), "long_polling", "true").toString();
                d0 d00 = j.a(this.b.a(s, this.e));
                co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
                String s1 = d00.d();
                J j0 = I.a;
                Class class0 = Map.class;
                d d0 = j0.b(class0);
                if(d0.equals(j0.b(class0))) {
                    Map map0 = b0.a(new JSONObject(s1));
                    if(map0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    }
                    return map0;
                }
                if(d0.equals(j0.b(List.class))) {
                    List list1 = b0.a(new JSONArray(s1));
                    if(list1 instanceof Map) {
                        list0 = list1;
                    }
                    if(((Map)list0) == null) {
                        throw new IllegalAccessException();
                    }
                    return (Map)list0;
                }
                JSONObject jSONObject0 = new JSONObject(s1);
                co.ab180.airbridge.internal.parser.a a0 = co.ab180.airbridge.internal.parser.c.a(c0, class0);
                if(a0 == null) {
                    object1 = null;
                }
                else {
                    y y0 = a0.b();
                    object1 = y0 == null ? null : y0.a(jSONObject0);
                }
                if(object1 instanceof Map) {
                    list0 = object1;
                }
                if(((Map)list0) == null) {
                    throw new IllegalAccessException();
                }
                return (Map)list0;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.a0.b.d(this, s, s1, v, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(@NotNull String s, @NotNull String s1, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$createTouchPoint$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.a0.b.b extends i implements n {
            int a;
            final b b;
            final String c;
            final String d;

            public co.ab180.airbridge.internal.a0.b.b(b b0, String s, String s1, Continuation continuation0) {
                this.b = b0;
                this.c = s;
                this.d = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.a0.b.b(this.b, this.c, this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.a0.b.b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                return b.a(this.b, this.b.a("tracking-link") + "/touchpoint/v1/" + this.b.a + '/' + this.c, "trackingLink", this.d, null, 8, null);
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.a0.b.b(this, s1, s, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(@NotNull String s, @NotNull Map map0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$createTrackingLink$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.a0.b.c extends i implements n {
            int a;
            final b b;
            final Map c;
            final String d;

            public co.ab180.airbridge.internal.a0.b.c(b b0, Map map0, String s, Continuation continuation0) {
                this.b = b0;
                this.c = map0;
                this.d = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.a0.b.c(this.b, this.c, this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.a0.b.c)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Object object1;
                GeneratedTrackingLinkResult generatedTrackingLinkResult0;
                String s;
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                linkedHashMap0.putAll(this.c);
                linkedHashMap0.put("channel", this.d);
                HttpURLConnection httpURLConnection0 = j.a(this.b.a(this.b.a("tracking-link") + "/v1/" + this.b.a + "/create", 15000), true);
                co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
                J j0 = I.a;
                Class class0 = Map.class;
                d d0 = j0.b(class0);
                boolean z = d0.equals(j0.b(class0));
                Class class1 = List.class;
                if(z) {
                    s = b0.a(linkedHashMap0).toString();
                }
                else {
                    s = d0.equals(j0.b(class1)) ? b0.a(((List)linkedHashMap0)).toString() : c0.b(linkedHashMap0).toString();
                }
                List list0 = null;
                String s1 = j.a(httpURLConnection0, s, null, 2, null).d();
                Class class2 = GeneratedTrackingLinkResult.class;
                d d1 = j0.b(class2);
                if(d1.equals(j0.b(class0))) {
                    Map map0 = b0.a(new JSONObject(s1));
                    if(map0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.response.GeneratedTrackingLinkResult");
                    }
                    return ((GeneratedTrackingLinkResult)map0).getData();
                }
                if(d1.equals(j0.b(class1))) {
                    List list1 = b0.a(new JSONArray(s1));
                    if(list1 instanceof GeneratedTrackingLinkResult) {
                        list0 = list1;
                    }
                    generatedTrackingLinkResult0 = (GeneratedTrackingLinkResult)list0;
                    if(generatedTrackingLinkResult0 == null) {
                        throw new IllegalAccessException();
                    }
                }
                else {
                    JSONObject jSONObject0 = new JSONObject(s1);
                    co.ab180.airbridge.internal.parser.a a0 = co.ab180.airbridge.internal.parser.c.a(c0, class2);
                    if(a0 == null) {
                        object1 = null;
                    }
                    else {
                        y y0 = a0.b();
                        object1 = y0 == null ? null : y0.a(jSONObject0);
                    }
                    if(object1 instanceof GeneratedTrackingLinkResult) {
                        list0 = object1;
                    }
                    generatedTrackingLinkResult0 = (GeneratedTrackingLinkResult)list0;
                    if(generatedTrackingLinkResult0 == null) {
                        throw new IllegalAccessException();
                    }
                }
                return generatedTrackingLinkResult0.getData();
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.a0.b.c(this, map0, s, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object a(@NotNull String s, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$getTrackingLinkResult$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class f extends i implements n {
            int a;
            final b b;
            final String c;

            public f(b b0, String s, Continuation continuation0) {
                this.b = b0;
                this.c = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new f(this.b, this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((f)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Map map0 = D.O(new m("os", "android"));
                return this.b.a(this.b.a("tracking-link") + "/v1/" + this.b.a + "/scheme-deeplink", "airbridgeHttpDeeplink", this.c, map0);
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new f(this, s, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.a0.a
    @Nullable
    public Object b(@NotNull String s, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/network/response/TrackingLinkResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.network.ApiServiceImpl$createClickTouchPoint$2", f = "ApiService.kt", l = {}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.a0.b.a extends i implements n {
            int a;
            final b b;
            final String c;

            public co.ab180.airbridge.internal.a0.b.a(b b0, String s, Continuation continuation0) {
                this.b = b0;
                this.c = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.a0.b.a(this.b, this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.a0.b.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                return b.a(this.b, this.b.a("tracking-link") + "/v1/" + this.b.a + "/track", "trackingLink", this.c, null, 8, null);
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.a0.b.a(this, s, null), continuation0);
    }
}

