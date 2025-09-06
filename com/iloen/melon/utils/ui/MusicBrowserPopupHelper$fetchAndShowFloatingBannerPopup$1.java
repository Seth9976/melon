package com.iloen.melon.utils.ui;

import Q0.t0;
import a1.g;
import android.text.TextUtils;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.FloatingBannerReq.Params;
import com.iloen.melon.net.v6x.request.FloatingBannerReq;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.FloatingBannerRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import e1.u;
import ie.H;
import java.util.ArrayList;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import m0.b;
import ne.a;
import oe.e;
import oe.i;
import va.e0;
import va.o;
import we.n;
import y0.M;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$fetchAndShowFloatingBannerPopup$1", f = "MusicBrowserPopupHelper.kt", l = {283, 289}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1 extends i implements n {
    public Params B;
    public int D;
    public final MusicBrowserPopupHelper E;
    public String r;
    public String w;

    public MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, Continuation continuation0) {
        this.E = musicBrowserPopupHelper0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1(this.E, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Params floatingBannerReq$Params1;
        String s3;
        String s2;
        String s1;
        a a0 = a.a;
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.E;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                String s = u.v(((e0)o.a()).j());
                this.r = s;
                s1 = "FLOATING";
                this.w = "FLOATING";
                this.D = 1;
                Object object1 = MusicBrowserPopupHelper.access$getBannedJson(musicBrowserPopupHelper0, s, "FLOATING", this);
                if(object1 == a0) {
                    return a0;
                }
                s2 = s;
                object0 = object1;
                goto label_18;
            }
            case 1: {
                s1 = this.w;
                s2 = this.r;
                d5.n.D(object0);
            label_18:
                Params floatingBannerReq$Params0 = new Params();
                floatingBannerReq$Params0.bans = (String)object0;
                MusicBrowserPopupHelper.access$updateFloatingBannerVisible(musicBrowserPopupHelper0, false, true);
                this.r = s2;
                this.w = s1;
                this.B = floatingBannerReq$Params0;
                this.D = 2;
                object0 = MusicBrowserPopupHelper.access$isSimpleLoginBannerAvailable(musicBrowserPopupHelper0, this);
                if(object0 == a0) {
                    return a0;
                }
                s3 = s2;
                floatingBannerReq$Params1 = floatingBannerReq$Params0;
                break;
            }
            case 2: {
                floatingBannerReq$Params1 = this.B;
                s1 = this.w;
                s3 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Boolean)object0).booleanValue()) {
            MusicBrowserActivity musicBrowserActivity0 = musicBrowserPopupHelper0.getActivity();
            MusicBrowserPopupHelper.access$setFloatingPopupLayout$p(musicBrowserPopupHelper0, (musicBrowserActivity0 == null ? null : ((ComposeView)musicBrowserActivity0.findViewById(0x7F0A032A))));  // id:container_free_user_popup
            ComposeView composeView0 = MusicBrowserPopupHelper.access$getFloatingPopupLayout$p(musicBrowserPopupHelper0);
            if(composeView0 != null) {
                composeView0.setViewCompositionStrategy(t0.d);
                composeView0.setContent(new b(0xE4EAE9C0, new d(musicBrowserPopupHelper0), true));
            }
            MusicBrowserPopupHelper.access$updateFloatingBannerVisible(musicBrowserPopupHelper0, MusicBrowserPopupHelper.access$getShouldShowMiniPlayer$p(musicBrowserPopupHelper0), false);
            return H.a;
        }
        RequestBuilder.newInstance(new FloatingBannerReq(musicBrowserPopupHelper0.getActivity(), floatingBannerReq$Params1)).tag("MusicBrowserPopupHelper").listener(new com.iloen.melon.utils.ui.e(musicBrowserPopupHelper0, s3, s1)).errorListener(new k(musicBrowserPopupHelper0, 3)).request();
        return H.a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$fetchAndShowFloatingBannerPopup$1$2$1", f = "MusicBrowserPopupHelper.kt", l = {329}, m = "invokeSuspend")
        final class com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1 extends i implements n {
            public final MusicBrowserPopupHelper B;
            public final String D;
            public final String E;
            public int r;
            public final Object w;

            public com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1(Object object0, MusicBrowserPopupHelper musicBrowserPopupHelper0, String s, String s1, Continuation continuation0) {
                this.w = object0;
                this.B = musicBrowserPopupHelper0;
                this.D = s;
                this.E = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1(this.w, this.B, this.D, this.E, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                boolean z2;
                long v2;
                BANNER floatingBannerRes$RESPONSE$BANNER0;
                a a0 = a.a;
                MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.B;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1.1 musicBrowserPopupHelper$fetchAndShowFloatingBannerPopup$1$2$1$10 = new n(musicBrowserPopupHelper0, this.D, this.E, null) {
                            public final MusicBrowserPopupHelper B;
                            public final String D;
                            public final String E;
                            public int r;
                            public final Object w;

                            {
                                this.w = object0;
                                this.B = musicBrowserPopupHelper0;
                                this.D = s;
                                this.E = s1;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1.1(this.w, this.B, this.D, this.E, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        RESPONSE floatingBannerRes$RESPONSE0 = ((FloatingBannerRes)this.w).getResponse();
                                        ArrayList arrayList0 = floatingBannerRes$RESPONSE0 == null ? null : floatingBannerRes$RESPONSE0.getExpiredBans();
                                        if(arrayList0 != null && !arrayList0.isEmpty()) {
                                            Ra.d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(this.B);
                                            this.r = 1;
                                            if(d0.a(this.D, this.E, arrayList0, this) == a0) {
                                                return a0;
                                            }
                                        }
                                        return H.a;
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
                        };
                        this.r = 1;
                        if(BuildersKt.withContext(Dispatchers.getIO(), musicBrowserPopupHelper$fetchAndShowFloatingBannerPopup$1$2$1$10, this) == a0) {
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
                FloatingBannerRes floatingBannerRes0 = (FloatingBannerRes)this.w;
                RESPONSE floatingBannerRes$RESPONSE0 = floatingBannerRes0.getResponse();
                ArrayList arrayList0 = floatingBannerRes$RESPONSE0 == null ? null : floatingBannerRes$RESPONSE0.getBanners();
                H h0 = H.a;
                if(arrayList0 != null && !arrayList0.isEmpty() && !MusicBrowserPopupHelper.access$isLockByInfoPush$p(musicBrowserPopupHelper0)) {
                    RESPONSE floatingBannerRes$RESPONSE1 = floatingBannerRes0.getResponse();
                    if(floatingBannerRes$RESPONSE1 == null) {
                        floatingBannerRes$RESPONSE$BANNER0 = null;
                    }
                    else {
                        ArrayList arrayList1 = floatingBannerRes$RESPONSE1.getBanners();
                        floatingBannerRes$RESPONSE$BANNER0 = arrayList1 == null ? null : ((BANNER)arrayList1.get(0));
                    }
                    if(floatingBannerRes$RESPONSE$BANNER0 != null) {
                        boolean z = q.b(floatingBannerRes$RESPONSE$BANNER0.isInduceLogin(), Boolean.TRUE);
                        String s = this.D;
                        if(!z || q.b(s, "0")) {
                            boolean z1 = TextUtils.equals(floatingBannerRes$RESPONSE$BANNER0.getFloatingDetailType(), "B");
                            long v = M.c(ColorUtils.getColorFromHexStr(("#" + floatingBannerRes$RESPONSE$BANNER0.getText1PointColor())));
                            MelonAppBase.Companion.getClass();
                            g g0 = StringUtils.INSTANCE.getAnnotatedString-WkMS-hQ("", v, M.c(ColorUtils.getColor(t.a().getContext(), 0x7F0604A1)));  // color:white000e
                            g g1 = StringUtils.INSTANCE.getAnnotatedString-WkMS-hQ("", M.c(ColorUtils.getColorFromHexStr(("#" + floatingBannerRes$RESPONSE$BANNER0.getText2PointColor()))), M.c(ColorUtils.getColor(t.a().getContext(), 0x7F0604A1)));  // color:white000e
                            long v1 = M.c(ColorUtils.getColorFromHexStr(("#" + floatingBannerRes$RESPONSE$BANNER0.getBgColor())));
                            MusicBrowserActivity musicBrowserActivity0 = musicBrowserPopupHelper0.getActivity();
                            MusicBrowserPopupHelper.access$setFloatingPopupLayout$p(musicBrowserPopupHelper0, (musicBrowserActivity0 == null ? null : ((ComposeView)musicBrowserActivity0.findViewById(0x7F0A032A))));  // id:container_free_user_popup
                            ComposeView composeView0 = MusicBrowserPopupHelper.access$getFloatingPopupLayout$p(musicBrowserPopupHelper0);
                            if(composeView0 != null) {
                                if(!q.b(floatingBannerRes$RESPONSE$BANNER0.isInduceLogin(), Boolean.TRUE) || !q.b(s, "0")) {
                                    v2 = v1;
                                    z2 = false;
                                }
                                else {
                                    v2 = v1;
                                    z2 = true;
                                }
                                composeView0.setViewCompositionStrategy(t0.d);
                                composeView0.setContent(new b(-2002208828, new com.iloen.melon.utils.ui.g(g0, g1, v2, z1, z2, musicBrowserPopupHelper0, floatingBannerRes$RESPONSE$BANNER0), true));
                            }
                            MusicBrowserPopupHelper.access$updateFloatingBannerVisible(musicBrowserPopupHelper0, MusicBrowserPopupHelper.access$getShouldShowMiniPlayer$p(musicBrowserPopupHelper0), false);
                            return h0;
                        }
                    }
                    MusicBrowserPopupHelper.access$updateFloatingBannerVisible(musicBrowserPopupHelper0, false, true);
                }
                return h0;
            }
        }

    }
}

