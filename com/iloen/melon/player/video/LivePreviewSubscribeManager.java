package com.iloen.melon.player.video;

import androidx.lifecycle.K;
import androidx.lifecycle.L;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.LiveSubscribeReq;
import com.iloen.melon.net.v6x.response.LiveSubscribeCancelRes;
import com.iloen.melon.net.v6x.response.LiveSubscribeInsertRes;
import com.iloen.melon.net.v6x.response.LiveSubscribeRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveSubscribeRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.b;
import u8.d;
import u8.e;
import v8.g;
import v8.h;
import v8.i;
import we.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\tH\u0086@¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\tH\u0086@¢\u0006\u0004\b\u0010\u0010\u000FR\u001D\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/video/LivePreviewSubscribeManager;", "", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "tag", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "newLiveSeq", "Lie/H;", "changeLiveSeqAndFetchSubscribe", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSubscribeAsync", "()V", "requestSubscribe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUnSubscribe", "Landroidx/lifecycle/K;", "", "f", "Landroidx/lifecycle/K;", "isSubscribe", "()Landroidx/lifecycle/K;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LivePreviewSubscribeManager {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/LivePreviewSubscribeManager$Companion;", "", "", "DEFAULT_TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final CoroutineScope a;
    public final String b;
    public final LogU c;
    public String d;
    public final L e;
    public final L f;

    static {
        LivePreviewSubscribeManager.Companion = new Companion(null);
        LivePreviewSubscribeManager.$stable = 8;
    }

    public LivePreviewSubscribeManager(@NotNull CoroutineScope coroutineScope0, @NotNull String s) {
        q.g(coroutineScope0, "coroutineScope");
        q.g(s, "tag");
        super();
        this.a = coroutineScope0;
        this.b = s;
        this.c = new LogU("LivePreviewSubscribeManager");
        L l0 = new L(Boolean.FALSE);  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        this.e = l0;
        this.f = l0;
    }

    public LivePreviewSubscribeManager(CoroutineScope coroutineScope0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s = "LivePreviewSubscribeManager";
        }
        this(coroutineScope0, s);
    }

    public final Object a(Continuation continuation0) {
        LivePreviewSubscribeManager.fetchSubscribe.1 livePreviewSubscribeManager$fetchSubscribe$10;
        if(continuation0 instanceof LivePreviewSubscribeManager.fetchSubscribe.1) {
            livePreviewSubscribeManager$fetchSubscribe$10 = (LivePreviewSubscribeManager.fetchSubscribe.1)continuation0;
            int v = livePreviewSubscribeManager$fetchSubscribe$10.B;
            if((v & 0x80000000) == 0) {
                livePreviewSubscribeManager$fetchSubscribe$10 = new LivePreviewSubscribeManager.fetchSubscribe.1(this, continuation0);
            }
            else {
                livePreviewSubscribeManager$fetchSubscribe$10.B = v ^ 0x80000000;
            }
        }
        else {
            livePreviewSubscribeManager$fetchSubscribe$10 = new LivePreviewSubscribeManager.fetchSubscribe.1(this, continuation0);
        }
        Object object0 = livePreviewSubscribeManager$fetchSubscribe$10.r;
        a a0 = a.a;
        int v1 = livePreviewSubscribeManager$fetchSubscribe$10.B;
        H h0 = H.a;
        String s = null;
        switch(v1) {
            case 0: {
                n.D(object0);
                if(this.d == null || this.d.length() == 0) {
                    LogU.warn$default(this.c, "fetchSubscribeAsync - skipped because of invalid liveSeq.", null, false, 6, null);
                    return h0;
                }
                LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1 livePreviewSubscribeManager$fetchSubscribe$$inlined$request$default$10 = new LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1(new g(new LiveSubscribeReq(Y.a(MelonAppBase.Companion), this.d), this.b), null);
                livePreviewSubscribeManager$fetchSubscribe$10.B = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$fetchSubscribe$$inlined$request$default$10, livePreviewSubscribeManager$fetchSubscribe$10);
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
                if(v1 != 2) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                break;
            }
        }
        i i0 = e1.n.g(((d)object0), v9.i.b);
        if(i0.a == h.a) {
            LiveSubscribeRes liveSubscribeRes0 = (LiveSubscribeRes)i0.c;
            if(liveSubscribeRes0 != null) {
                RESPONSE liveSubscribeRes$RESPONSE0 = liveSubscribeRes0.response;
                if(liveSubscribeRes$RESPONSE0 != null) {
                    s = liveSubscribeRes$RESPONSE0.subscribeYN;
                }
            }
            Boolean boolean0 = Boolean.valueOf(q.b(s, "Y"));
            this.e.setValue(boolean0);
        }
        return h0;
    }

    public static final Object access$fetchSubscribe(LivePreviewSubscribeManager livePreviewSubscribeManager0, Continuation continuation0) {
        return livePreviewSubscribeManager0.a(continuation0);
    }

    @Nullable
    public final Object changeLiveSeqAndFetchSubscribe(@Nullable String s, @NotNull Continuation continuation0) {
        this.d = s;
        this.e.setValue(Boolean.FALSE);
        Object object0 = this.a(continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @NotNull
    public final K isSubscribe() {
        return this.f;
    }

    @Nullable
    public final Object requestSubscribe(@NotNull Continuation continuation0) {
        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe.1 livePreviewSubscribeManager$requestSubscribe$10;
        if(continuation0 instanceof com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe.1) {
            livePreviewSubscribeManager$requestSubscribe$10 = (com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe.1)continuation0;
            int v = livePreviewSubscribeManager$requestSubscribe$10.B;
            if((v & 0x80000000) == 0) {
                livePreviewSubscribeManager$requestSubscribe$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.requestSubscribe(this);
                    }
                };
            }
            else {
                livePreviewSubscribeManager$requestSubscribe$10.B = v ^ 0x80000000;
            }
        }
        else {
            livePreviewSubscribeManager$requestSubscribe$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.requestSubscribe(this);
                }
            };
        }
        Object object0 = livePreviewSubscribeManager$requestSubscribe$10.r;
        a a0 = a.a;
        int v1 = livePreviewSubscribeManager$requestSubscribe$10.B;
        H h0 = H.a;
        String s = null;
        switch(v1) {
            case 0: {
                n.D(object0);
                if(this.d == null || this.d.length() == 0) {
                    LogU.warn$default(this.c, "requestSubscribeAsync - skipped because of invalid liveSeq.", null, false, 6, null);
                    return h0;
                }
                com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$10 = new we.n(null) {
                    public int r;
                    public final g w;

                    {
                        this.w = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.2 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$1$20 = new we.n("DataAccessStrategy", "LiveSubscribeInsertRes", null) {
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
                                        return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d d0;
                                        a a0 = a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                this.r = 1;
                                                object0 = this.w.invoke(this);
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
                                        switch(((d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse0 = ((d)object0).b;
                                                if(httpResponse0 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    d0 = new d(e.a, httpResponse0, null);
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new d(e.b, null, ((d)object0).c);
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
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$1$20, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }

                        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                        @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                        public final class com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1 extends oe.i implements k {
                            public int r;
                            public final g w;

                            public com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1(g g0, Continuation continuation0) {
                                this.w = g0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1(this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        b.b();
                                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1.1 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$1$1$10 = new we.n(null) {
                                            public final g r;

                                            {
                                                this.r = g0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                n.D(object0);
                                                try {
                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                    if(httpResponse0 != null && httpResponse0 instanceof LiveSubscribeInsertRes) {
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                    return new d(e.b, null, volleyError1);
                                                }
                                                catch(VolleyError volleyError0) {
                                                    return new d(e.b, null, volleyError0);
                                                }
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$1$1$10, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
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
                livePreviewSubscribeManager$requestSubscribe$10.B = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$10, livePreviewSubscribeManager$requestSubscribe$10);
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
                if(v1 != 2) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                break;
            }
        }
        i i0 = e1.n.g(((d)object0), v9.i.b);
        if(i0.a == h.a) {
            LiveSubscribeInsertRes liveSubscribeInsertRes0 = (LiveSubscribeInsertRes)i0.c;
            com.iloen.melon.net.v6x.response.LiveSubscribeInsertRes.RESPONSE liveSubscribeInsertRes$RESPONSE0 = liveSubscribeInsertRes0 == null ? null : liveSubscribeInsertRes0.response;
            Boolean boolean0 = Boolean.valueOf(q.b((liveSubscribeInsertRes$RESPONSE0 == null ? null : liveSubscribeInsertRes$RESPONSE0.subscribeYN), "Y"));
            this.e.setValue(boolean0);
            if(liveSubscribeInsertRes$RESPONSE0 != null) {
                s = liveSubscribeInsertRes$RESPONSE0.message;
            }
            ToastManager.show(s);
        }
        return h0;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
        public final class com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2 extends oe.i implements we.n {
            public final int B;
            public final g D;
            public int r;
            public final u8.c w;

            public com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2(u8.c c0, int v, g g0, Continuation continuation0) {
                this.w = c0;
                this.B = v;
                this.D = g0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.1 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$10 = new k(null) {
                            public int r;
                            public final g w;

                            {
                                this.w = g0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.1(this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        b.b();
                                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.1.1 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$1$10 = new we.n(null) {
                                            public final g r;

                                            {
                                                this.r = g0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                n.D(object0);
                                                try {
                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                    if(httpResponse0 != null && httpResponse0 instanceof LiveSubscribeInsertRes) {
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                    return new d(e.b, null, volleyError1);
                                                }
                                                catch(VolleyError volleyError0) {
                                                    return new d(e.b, null, volleyError0);
                                                }
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$1$10, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.2 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$20 = new we.a() {
                            @Override  // we.a
                            public Object invoke() {
                                return this.invoke();
                            }

                            public final s8.b invoke() {
                                return b.a().a(this.a.a);
                            }
                        };
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.3 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$30 = new k() {
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
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.4 livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$40 = new we.n(new Integer(this.B), this.w.b, livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$10, livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$30, null) {
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
                                Continuation continuation1 = new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.4(this.E, this.G, this.I, this.M, this.N, continuation0);
                                continuation1.D = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
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
                                        n.D(object0);
                                        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                        logU$Companion0.d("DataAccessStrategy", "getData() LiveSubscribeInsertRes");
                                        s8.b b0 = this.E == null ? null : ((s8.b)this.E.invoke());
                                        if(b0 != null && !u.H(b0, this.G, this.I)) {
                                            HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, LiveSubscribeInsertRes.class);
                                            if(httpResponse0 != null) {
                                                logU$Companion0.d("DataAccessStrategy", "getData() LiveSubscribeInsertRes cacheEntity not expired. > return cachedRes");
                                                return new d(e.a, httpResponse0, null);
                                            }
                                        }
                                        logU$Companion0.d("DataAccessStrategy", "getData() LiveSubscribeInsertRes cacheEntity expired.");
                                        this.D = coroutineScope0;
                                        this.r = "DataAccessStrategy";
                                        this.w = "LiveSubscribeInsertRes";
                                        this.B = 1;
                                        Object object1 = this.M.invoke(this);
                                        if(object1 == a0) {
                                            return a0;
                                        }
                                        s = "LiveSubscribeInsertRes";
                                        object0 = object1;
                                        s1 = "DataAccessStrategy";
                                        break;
                                    }
                                    case 1: {
                                        s = this.w;
                                        String s2 = this.r;
                                        n.D(object0);
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
                                            d0 = new d(e.b, null, volleyError0);
                                        }
                                        else {
                                            d d1 = new d(e.a, httpResponse1, null);
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(((d)object0), null) {
                                                public final k r;
                                                public final d w;

                                                {
                                                    this.r = k0;
                                                    this.w = d0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.4.1(this.r, this.w, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestSubscribe..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    n.D(object0);
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
                                        d0 = new d(e.b, null, ((d)object0).c);
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
                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestSubscribe$$inlined$request$default$2$40, this);
                        return object1 == a0 ? a0 : object1;
                    }
                    case 1: {
                        n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @Nullable
    public final Object requestUnSubscribe(@NotNull Continuation continuation0) {
        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe.1 livePreviewSubscribeManager$requestUnSubscribe$10;
        if(continuation0 instanceof com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe.1) {
            livePreviewSubscribeManager$requestUnSubscribe$10 = (com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe.1)continuation0;
            int v = livePreviewSubscribeManager$requestUnSubscribe$10.B;
            if((v & 0x80000000) == 0) {
                livePreviewSubscribeManager$requestUnSubscribe$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.requestUnSubscribe(this);
                    }
                };
            }
            else {
                livePreviewSubscribeManager$requestUnSubscribe$10.B = v ^ 0x80000000;
            }
        }
        else {
            livePreviewSubscribeManager$requestUnSubscribe$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.requestUnSubscribe(this);
                }
            };
        }
        Object object0 = livePreviewSubscribeManager$requestUnSubscribe$10.r;
        a a0 = a.a;
        int v1 = livePreviewSubscribeManager$requestUnSubscribe$10.B;
        H h0 = H.a;
        String s = null;
        switch(v1) {
            case 0: {
                n.D(object0);
                if(this.d == null || this.d.length() == 0) {
                    LogU.warn$default(this.c, "requestUnSubscribeAsync - skipped because of invalid liveSeq.", null, false, 6, null);
                    return h0;
                }
                com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$10 = new we.n(null) {
                    public int r;
                    public final g w;

                    {
                        this.w = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.2 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$1$20 = new we.n("DataAccessStrategy", "LiveSubscribeCancelRes", null) {
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
                                        return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d d0;
                                        a a0 = a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                this.r = 1;
                                                object0 = this.w.invoke(this);
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
                                        switch(((d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse0 = ((d)object0).b;
                                                if(httpResponse0 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    d0 = new d(e.a, httpResponse0, null);
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new d(e.b, null, ((d)object0).c);
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
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$1$20, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }

                        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                        @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                        public final class com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1 extends oe.i implements k {
                            public int r;
                            public final g w;

                            public com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1(g g0, Continuation continuation0) {
                                this.w = g0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1(this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        b.b();
                                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1.1 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$1$1$10 = new we.n(null) {
                                            public final g r;

                                            {
                                                this.r = g0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                n.D(object0);
                                                try {
                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                    if(httpResponse0 != null && httpResponse0 instanceof LiveSubscribeCancelRes) {
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                    return new d(e.b, null, volleyError1);
                                                }
                                                catch(VolleyError volleyError0) {
                                                    return new d(e.b, null, volleyError0);
                                                }
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$1$1$10, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
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
                livePreviewSubscribeManager$requestUnSubscribe$10.B = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$10, livePreviewSubscribeManager$requestUnSubscribe$10);
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
                if(v1 != 2) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                break;
            }
        }
        i i0 = e1.n.g(((d)object0), v9.i.b);
        if(i0.a == h.a) {
            LiveSubscribeCancelRes liveSubscribeCancelRes0 = (LiveSubscribeCancelRes)i0.c;
            com.iloen.melon.net.v6x.response.LiveSubscribeCancelRes.RESPONSE liveSubscribeCancelRes$RESPONSE0 = liveSubscribeCancelRes0 == null ? null : liveSubscribeCancelRes0.response;
            Boolean boolean0 = Boolean.valueOf(q.b((liveSubscribeCancelRes$RESPONSE0 == null ? null : liveSubscribeCancelRes$RESPONSE0.subscribeYN), "Y"));
            this.e.setValue(boolean0);
            if(liveSubscribeCancelRes$RESPONSE0 != null) {
                s = liveSubscribeCancelRes$RESPONSE0.message;
            }
            ToastManager.show(s);
        }
        return h0;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
        public final class com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2 extends oe.i implements we.n {
            public final int B;
            public final g D;
            public int r;
            public final u8.c w;

            public com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2(u8.c c0, int v, g g0, Continuation continuation0) {
                this.w = c0;
                this.B = v;
                this.D = g0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.1 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$10 = new k(null) {
                            public int r;
                            public final g w;

                            {
                                this.w = g0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.1(this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        b.b();
                                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.1.1 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$1$10 = new we.n(null) {
                                            public final g r;

                                            {
                                                this.r = g0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                n.D(object0);
                                                try {
                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                    if(httpResponse0 != null && httpResponse0 instanceof LiveSubscribeCancelRes) {
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                    return new d(e.b, null, volleyError1);
                                                }
                                                catch(VolleyError volleyError0) {
                                                    return new d(e.b, null, volleyError0);
                                                }
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$1$10, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.2 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$20 = new we.a() {
                            @Override  // we.a
                            public Object invoke() {
                                return this.invoke();
                            }

                            public final s8.b invoke() {
                                return b.a().a(this.a.a);
                            }
                        };
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.3 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$30 = new k() {
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
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.4 livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$40 = new we.n(new Integer(this.B), this.w.b, livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$10, livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$30, null) {
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
                                Continuation continuation1 = new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.4(this.E, this.G, this.I, this.M, this.N, continuation0);
                                continuation1.D = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
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
                                        n.D(object0);
                                        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                        logU$Companion0.d("DataAccessStrategy", "getData() LiveSubscribeCancelRes");
                                        s8.b b0 = this.E == null ? null : ((s8.b)this.E.invoke());
                                        if(b0 != null && !u.H(b0, this.G, this.I)) {
                                            HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, LiveSubscribeCancelRes.class);
                                            if(httpResponse0 != null) {
                                                logU$Companion0.d("DataAccessStrategy", "getData() LiveSubscribeCancelRes cacheEntity not expired. > return cachedRes");
                                                return new d(e.a, httpResponse0, null);
                                            }
                                        }
                                        logU$Companion0.d("DataAccessStrategy", "getData() LiveSubscribeCancelRes cacheEntity expired.");
                                        this.D = coroutineScope0;
                                        this.r = "DataAccessStrategy";
                                        this.w = "LiveSubscribeCancelRes";
                                        this.B = 1;
                                        Object object1 = this.M.invoke(this);
                                        if(object1 == a0) {
                                            return a0;
                                        }
                                        s = "LiveSubscribeCancelRes";
                                        object0 = object1;
                                        s1 = "DataAccessStrategy";
                                        break;
                                    }
                                    case 1: {
                                        s = this.w;
                                        String s2 = this.r;
                                        n.D(object0);
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
                                            d0 = new d(e.b, null, volleyError0);
                                        }
                                        else {
                                            d d1 = new d(e.a, httpResponse1, null);
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(((d)object0), null) {
                                                public final k r;
                                                public final d w;

                                                {
                                                    this.r = k0;
                                                    this.w = d0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.4.1(this.r, this.w, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.requestUnSubscribe..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    n.D(object0);
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
                                        d0 = new d(e.b, null, ((d)object0).c);
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
                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$requestUnSubscribe$$inlined$request$default$2$40, this);
                        return object1 == a0 ? a0 : object1;
                    }
                    case 1: {
                        n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    public final void toggleSubscribeAsync() {
        com.iloen.melon.player.video.LivePreviewSubscribeManager.toggleSubscribeAsync.1 livePreviewSubscribeManager$toggleSubscribeAsync$10 = new we.n(null) {
            public int r;
            public final LivePreviewSubscribeManager w;

            {
                this.w = livePreviewSubscribeManager0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.toggleSubscribeAsync.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.toggleSubscribeAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        LivePreviewSubscribeManager livePreviewSubscribeManager0 = this.w;
                        if(q.b(livePreviewSubscribeManager0.isSubscribe().getValue(), Boolean.TRUE)) {
                            this.r = 1;
                            if(livePreviewSubscribeManager0.requestUnSubscribe(this) == a0) {
                                return a0;
                            }
                        }
                        else {
                            this.r = 2;
                            if(livePreviewSubscribeManager0.requestSubscribe(this) == a0) {
                                return a0;
                            }
                        }
                        return H.a;
                    }
                    case 1: 
                    case 2: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        BuildersKt__Builders_commonKt.launch$default(this.a, null, null, livePreviewSubscribeManager$toggleSubscribeAsync$10, 3, null);
    }
}

