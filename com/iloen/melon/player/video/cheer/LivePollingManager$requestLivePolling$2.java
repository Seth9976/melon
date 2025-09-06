package com.iloen.melon.player.video.cheer;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.response.LivePollingRes.Response;
import com.iloen.melon.net.v6x.response.LivePollingRes;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.e;
import oe.i;
import u8.b;
import u8.c;
import u8.d;
import v8.g;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.cheer.LivePollingManager$requestLivePolling$2", f = "LivePollingManager.kt", l = {120, 0x83}, m = "invokeSuspend")
final class LivePollingManager.requestLivePolling.2 extends i implements n {
    public int r;
    public final LivePollingManager w;

    public LivePollingManager.requestLivePolling.2(LivePollingManager livePollingManager0, Continuation continuation0) {
        this.w = livePollingManager0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new LivePollingManager.requestLivePolling.2(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((LivePollingManager.requestLivePolling.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        int v = this.r;
        LivePollingManager livePollingManager0 = this.w;
        switch(v) {
            case 0: {
                d5.n.D(object0);
                LogU.debug$default(livePollingManager0.e, "requestGetLikeCnt()", null, false, 6, null);
                com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$10 = new n(null) {
                    public int r;
                    public final g w;

                    {
                        this.w = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.2 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$1$20 = new n("DataAccessStrategy", "LivePollingRes", null) {
                                    public final String B;
                                    public final String D;
                                    public int r;
                                    public final k w;

                                    {
                                        this.w = k0;
                                        this.B = s;
                                        this.D = s1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d d0;
                                        a a0 = a.a;
                                        switch(this.r) {
                                            case 0: {
                                                d5.n.D(object0);
                                                this.r = 1;
                                                object0 = this.w.invoke(this);
                                                if(object0 == a0) {
                                                    return a0;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d5.n.D(object0);
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        switch(((d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse0 = ((d)object0).b;
                                                if(httpResponse0 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new d(u8.e.b, null, volleyError0);
                                                }
                                                else {
                                                    d0 = new d(u8.e.a, httpResponse0, null);
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new d(u8.e.b, null, ((d)object0).c);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        LogU.Companion.d(this.B, "getData() " + this.D + " " + d0);
                                        return d0;
                                    }
                                };
                                this.r = 1;
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$1$20, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }

                        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                        @e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                        public final class com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1 extends i implements k {
                            public int r;
                            public final g w;

                            public com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1(g g0, Continuation continuation0) {
                                this.w = g0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1(this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        b.b();
                                        com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1.1 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$1$1$10 = new n(null) {
                                            public final g r;

                                            {
                                                this.r = g0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d5.n.D(object0);
                                                try {
                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                    if(httpResponse0 != null && httpResponse0 instanceof LivePollingRes) {
                                                        return new d(u8.e.a, httpResponse0, null);
                                                    }
                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                    return new d(u8.e.b, null, volleyError1);
                                                }
                                                catch(VolleyError volleyError0) {
                                                    return new d(u8.e.b, null, volleyError0);
                                                }
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$1$1$10, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }

                    }
                };
                this.r = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$10, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                if(v != 2) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                break;
            }
        }
        H h0 = H.a;
        if(((d)object0).a == u8.e.a) {
            LivePollingRes livePollingRes0 = (LivePollingRes)((d)object0).b;
            if(livePollingRes0 != null) {
                Response livePollingRes$Response0 = livePollingRes0.response;
                if(livePollingRes$Response0 != null) {
                    livePollingManager0.h = livePollingRes$Response0.pollingPeriod;
                    LivePollingManager.access$calculateRealCnt(livePollingManager0, livePollingRes$Response0.cheer.count);
                    livePollingManager0.getSetViewCnt().invoke(new Long(livePollingRes$Response0.play.count));
                    if(livePollingRes$Response0.isCplanMode) {
                        livePollingManager0.stopPolling("button off");
                        livePollingManager0.getSetDataVisible().invoke(Boolean.FALSE);
                        return h0;
                    }
                    livePollingManager0.getSetDataVisible().invoke(Boolean.TRUE);
                    LivePollingManager.access$requestInsertLikeCnt(livePollingManager0);
                }
            }
        }
        return h0;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
        public final class com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2 extends i implements n {
            public final int B;
            public final g D;
            public int r;
            public final c w;

            public com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2(c c0, int v, g g0, Continuation continuation0) {
                this.w = c0;
                this.B = v;
                this.D = g0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.1 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                            public int r;
                            public final g w;

                            {
                                this.w = g0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.1(this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        b.b();
                                        com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.1.1 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$1$10 = new n(null) {
                                            public final g r;

                                            {
                                                this.r = g0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d5.n.D(object0);
                                                try {
                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                    if(httpResponse0 != null && httpResponse0 instanceof LivePollingRes) {
                                                        return new d(u8.e.a, httpResponse0, null);
                                                    }
                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                    return new d(u8.e.b, null, volleyError1);
                                                }
                                                catch(VolleyError volleyError0) {
                                                    return new d(u8.e.b, null, volleyError0);
                                                }
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$1$10, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.2 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                            @Override  // we.a
                            public Object invoke() {
                                return this.invoke();
                            }

                            public final s8.b invoke() {
                                return b.a().a(this.a.a);
                            }
                        };
                        com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.3 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$30 = new k() {
                            @Override  // we.k
                            public Object invoke(Object object0) {
                                this.invoke(((HttpResponse)object0));
                                return H.a;
                            }

                            public final void invoke(HttpResponse httpResponse0) {
                                q.g(httpResponse0, "it");
                                s8.a a0 = b.a();
                                String s = b.c.k(httpResponse0);
                                q.f(s, "toJson(...)");
                                a0.b(new s8.b(this.b, this.B.a, s, System.currentTimeMillis()));
                            }
                        };
                        com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.4 livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$40 = new n(new Integer(this.B), this.w.b, livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$10, livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$30, null) {
                            public int B;
                            public Object D;
                            public final we.a E;
                            public final Integer G;
                            public final long I;
                            public final k M;
                            public final k N;
                            public String r;
                            public String w;

                            {
                                this.E = a0;
                                this.G = integer0;
                                this.I = v;
                                this.M = k0;
                                this.N = k1;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.4(this.E, this.G, this.I, this.M, this.N, continuation0);
                                continuation1.D = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                d d0;
                                String s1;
                                String s;
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.D;
                                a a0 = a.a;
                                switch(this.B) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Companion logU$Companion0 = LogU.Companion;
                                        logU$Companion0.d("DataAccessStrategy", "getData() LivePollingRes");
                                        s8.b b0 = this.E == null ? null : ((s8.b)this.E.invoke());
                                        if(b0 != null && !u.H(b0, this.G, this.I)) {
                                            HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, LivePollingRes.class);
                                            if(httpResponse0 != null) {
                                                logU$Companion0.d("DataAccessStrategy", "getData() LivePollingRes cacheEntity not expired. > return cachedRes");
                                                return new d(u8.e.a, httpResponse0, null);
                                            }
                                        }
                                        logU$Companion0.d("DataAccessStrategy", "getData() LivePollingRes cacheEntity expired.");
                                        this.D = coroutineScope0;
                                        this.r = "DataAccessStrategy";
                                        this.w = "LivePollingRes";
                                        this.B = 1;
                                        Object object1 = this.M.invoke(this);
                                        if(object1 == a0) {
                                            return a0;
                                        }
                                        s = "LivePollingRes";
                                        object0 = object1;
                                        s1 = "DataAccessStrategy";
                                        break;
                                    }
                                    case 1: {
                                        s = this.w;
                                        String s2 = this.r;
                                        d5.n.D(object0);
                                        s1 = s2;
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                switch(((d)object0).a.ordinal()) {
                                    case 0: {
                                        HttpResponse httpResponse1 = ((d)object0).b;
                                        if(httpResponse1 == null) {
                                            VolleyError volleyError0 = new VolleyError("status success but response is null");
                                            d0 = new d(u8.e.b, null, volleyError0);
                                        }
                                        else {
                                            d d1 = new d(u8.e.a, httpResponse1, null);
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new n(((d)object0), null) {
                                                public final k r;
                                                public final d w;

                                                {
                                                    this.r = k0;
                                                    this.w = d0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.4.1(this.r, this.w, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.video.cheer.LivePollingManager.requestLivePolling.2.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    d5.n.D(object0);
                                                    k k0 = this.r;
                                                    if(k0 != null) {
                                                        k0.invoke(this.w.b);
                                                    }
                                                    return H.a;
                                                }
                                            }, 2, null);
                                            d0 = d1;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        d0 = new d(u8.e.b, null, ((d)object0).c);
                                        break;
                                    }
                                    default: {
                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                    }
                                }
                                LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                return d0;
                            }
                        };
                        this.r = 1;
                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePollingManager$requestLivePolling$2$invokeSuspend$$inlined$request$default$2$40, this);
                        return object1 == a0 ? a0 : object1;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }
}

