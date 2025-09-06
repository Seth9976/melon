package com.iloen.melon.utils.ui;

import Ra.d;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MainLayerPopupReq.Params;
import com.iloen.melon.net.v4x.request.MainLayerPopupReq;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes;
import com.iloen.melon.popup.MelonMainPromotionPopup;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import ie.H;
import java.util.ArrayList;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.e;
import oe.i;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$fetchAndShowLayerPopup$1", f = "MusicBrowserPopupHelper.kt", l = {520}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.fetchAndShowLayerPopup.1 extends i implements n {
    public int B;
    public final MusicBrowserPopupHelper D;
    public final MusicBrowserActivity E;
    public String r;
    public String w;

    public MusicBrowserPopupHelper.fetchAndShowLayerPopup.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.D = musicBrowserPopupHelper0;
        this.E = musicBrowserActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.fetchAndShowLayerPopup.1(this.D, this.E, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.fetchAndShowLayerPopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        String s;
        a a0 = a.a;
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.D;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                s = u.v(((e0)o.a()).j());
                this.r = s;
                this.w = "LAYER";
                this.B = 1;
                Object object1 = MusicBrowserPopupHelper.access$getBannedJson(musicBrowserPopupHelper0, s, "LAYER", this);
                if(object1 == a0) {
                    return a0;
                }
                s1 = "LAYER";
                object0 = object1;
                break;
            }
            case 1: {
                s1 = this.w;
                s = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.Companion.d("MusicBrowserPopupHelper", "fetchAndShowLayerPopup() bannedJson : " + ((String)object0));
        Params mainLayerPopupReq$Params0 = new Params();
        mainLayerPopupReq$Params0.bans = (String)object0;
        MusicBrowserPopupHelper.access$dismissLayerPopup(musicBrowserPopupHelper0);
        MusicBrowserPopupHelper.access$get_loginPopUpStateFlow$p(musicBrowserPopupHelper0).setValue(Boolean.TRUE);
        RequestBuilder.newInstance(new MainLayerPopupReq(this.E, mainLayerPopupReq$Params0)).tag("MusicBrowserPopupHelper").listener(new com.iloen.melon.utils.ui.i(musicBrowserPopupHelper0, this.E, s, s1)).errorListener(new k(musicBrowserPopupHelper0, 4)).request();
        return H.a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$fetchAndShowLayerPopup$1$1$1", f = "MusicBrowserPopupHelper.kt", l = {539}, m = "invokeSuspend")
        final class com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1 extends i implements n {
            public final MusicBrowserPopupHelper B;
            public final MusicBrowserActivity D;
            public final String E;
            public final String G;
            public int r;
            public final MainLayerPopupRes w;

            public com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1(MainLayerPopupRes mainLayerPopupRes0, MusicBrowserPopupHelper musicBrowserPopupHelper0, MusicBrowserActivity musicBrowserActivity0, String s, String s1, Continuation continuation0) {
                this.w = mainLayerPopupRes0;
                this.B = musicBrowserPopupHelper0;
                this.D = musicBrowserActivity0;
                this.E = s;
                this.G = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1(this.w, this.B, this.D, this.E, this.G, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                MainLayerPopupRes mainLayerPopupRes0 = this.w;
                MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.B;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1.1 musicBrowserPopupHelper$fetchAndShowLayerPopup$1$1$1$10 = new n(this.E, this.G, mainLayerPopupRes0.response.expiredBans, null) {
                            public final MusicBrowserPopupHelper B;
                            public final String D;
                            public final String E;
                            public int r;
                            public final ArrayList w;

                            {
                                this.w = arrayList0;
                                this.B = musicBrowserPopupHelper0;
                                this.D = s;
                                this.E = s1;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1.1(this.B, this.D, this.E, this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        ArrayList arrayList0 = this.w;
                                        if(arrayList0 == null || arrayList0.isEmpty()) {
                                            LogU.Companion.d("MusicBrowserPopupHelper", "fetchAndShowLayerPopup() expiredBans isNullOrEmpty");
                                            return H.a;
                                        }
                                        d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(this.B);
                                        this.r = 1;
                                        object0 = d0.a(this.D, this.E, arrayList0, this);
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
                                Y.t("fetchAndShowLayerPopup() deletedCount : ", ((Number)object0).intValue(), LogU.Companion, "MusicBrowserPopupHelper");
                                return H.a;
                            }
                        };
                        this.r = 1;
                        if(BuildersKt.withContext(Dispatchers.getIO(), musicBrowserPopupHelper$fetchAndShowLayerPopup$1$1$1$10, this) == a0) {
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
                boolean z = MelonMainPromotionPopup.Companion.canPopupShow(mainLayerPopupRes0);
                l1.B("fetchAndShowLayerPopup() canShowPopup : ", z, LogU.Companion, "MusicBrowserPopupHelper");
                H h0 = H.a;
                if(z && MusicBrowserPopupHelper.access$getUserVisibleHint$p(musicBrowserPopupHelper0) && MusicBrowserPopupHelper.access$getShouldShowMiniPlayer$p(musicBrowserPopupHelper0) && !MusicBrowserPopupHelper.access$isLockByInfoPush$p(musicBrowserPopupHelper0)) {
                    MusicBrowserPopupHelper.access$dismissLayerPopup(musicBrowserPopupHelper0);
                    MelonMainPromotionPopup melonMainPromotionPopup0 = new MelonMainPromotionPopup(this.D, mainLayerPopupRes0);
                    melonMainPromotionPopup0.setCancelable(false);
                    melonMainPromotionPopup0.show();
                    MusicBrowserPopupHelper.access$setLayerPopup$p(musicBrowserPopupHelper0, melonMainPromotionPopup0);
                }
                return h0;
            }
        }

    }
}

