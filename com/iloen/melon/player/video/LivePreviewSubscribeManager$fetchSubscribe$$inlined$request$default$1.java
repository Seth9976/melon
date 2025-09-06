package com.iloen.melon.player.video;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.response.LiveSubscribeRes;
import com.iloen.melon.utils.log.LogU;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.e;
import oe.i;
import u8.b;
import u8.d;
import v8.g;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2", f = "ApiRepository.kt", l = {84}, m = "invokeSuspend")
public final class LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1 extends i implements n {
    public int r;
    public final g w;

    public LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1(g g0, Continuation continuation0) {
        this.w = g0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.2 livePreviewSubscribeManager$fetchSubscribe$$inlined$request$default$1$20 = new n("DataAccessStrategy", "LiveSubscribeRes", null) {
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
                        return new com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
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
                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$fetchSubscribe$$inlined$request$default$1$20, this);
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
        public final class com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1 extends i implements k {
            public int r;
            public final g w;

            public com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1(g g0, Continuation continuation0) {
                this.w = g0;
                super(1, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Continuation continuation0) {
                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1(this.w, continuation0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        b.b();
                        com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1.1 livePreviewSubscribeManager$fetchSubscribe$$inlined$request$default$1$1$10 = new n(null) {
                            public final g r;

                            {
                                this.r = g0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1.1(this.r, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LivePreviewSubscribeManager.fetchSubscribe..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                d5.n.D(object0);
                                try {
                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                    if(httpResponse0 != null && httpResponse0 instanceof LiveSubscribeRes) {
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
                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), livePreviewSubscribeManager$fetchSubscribe$$inlined$request$default$1$1$10, this);
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

