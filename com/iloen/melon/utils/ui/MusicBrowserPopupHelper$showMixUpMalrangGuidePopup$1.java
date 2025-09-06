package com.iloen.melon.utils.ui;

import A8.M;
import Ba.N;
import Ra.d;
import androidx.fragment.app.l0;
import com.google.gson.t;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v4x.response.ServiceInfoRes.Response;
import com.iloen.melon.net.v4x.response.ServiceInfoRes;
import com.iloen.melon.popup.MalrangServiceGuidePopup;
import com.melon.net.ApiClient;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.ResultCallAdapterFactory;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import tg.T;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$showMixUpMalrangGuidePopup$1", f = "MusicBrowserPopupHelper.kt", l = {621, 0x26F}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.showMixUpMalrangGuidePopup.1 extends i implements n {
    public final MusicBrowserPopupHelper B;
    public Success r;
    public int w;

    public MusicBrowserPopupHelper.showMixUpMalrangGuidePopup.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, Continuation continuation0) {
        this.B = musicBrowserPopupHelper0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.showMixUpMalrangGuidePopup.1(this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.showMixUpMalrangGuidePopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ApiResult apiResult0;
        a a0 = a.a;
        H h0 = H.a;
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                MusicBrowserPopupHelper.access$get_loginPopUpStateFlow$p(musicBrowserPopupHelper0).setValue(Boolean.TRUE);
                T t0 = new T();
                t0.a(M.a);
                ug.a a1 = ug.a.c();
                t0.c.add(a1);
                t0.c(new ApiClient(null, null, 3, null).getClient());
                ResultCallAdapterFactory resultCallAdapterFactory0 = new ResultCallAdapterFactory();
                t0.d.add(resultCallAdapterFactory0);
                Object object1 = t0.b().b(N.class);
                q.f(object1, "create(...)");
                this.w = 1;
                object0 = ((N)object1).a("SIMPLEMODE", this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_21;
            }
            case 1: {
                d5.n.D(object0);
            label_21:
                if(((ApiResult)object0) instanceof Success) {
                    Response serviceInfoRes$Response0 = ((ServiceInfoRes)((Success)(((ApiResult)object0))).getData()).getResponse();
                    if((serviceInfoRes$Response0 == null ? false : q.b(serviceInfoRes$Response0.isAvailable(), Boolean.TRUE))) {
                        d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(musicBrowserPopupHelper0);
                        this.r = (Success)(((ApiResult)object0));
                        this.w = 2;
                        Object object2 = d0.b("0", "DJ_MALRANG_GUIDE", this);
                        if(object2 == a0) {
                            return a0;
                        }
                        apiResult0 = (ApiResult)object0;
                        object0 = object2;
                        goto label_35;
                    }
                }
                break;
            }
            case 2: {
                apiResult0 = this.r;
                d5.n.D(object0);
            label_35:
                if(((List)object0).isEmpty()) {
                    MusicBrowserActivity musicBrowserActivity0 = musicBrowserPopupHelper0.getActivity();
                    if(musicBrowserActivity0 != null) {
                        l0 l00 = musicBrowserActivity0.getSupportFragmentManager();
                        if(l00 != null) {
                            Response serviceInfoRes$Response1 = ((ServiceInfoRes)((Success)apiResult0).getData()).getResponse();
                            if(serviceInfoRes$Response1 != null) {
                                t t1 = serviceInfoRes$Response1.getExtra();
                                if(t1 != null) {
                                    com.google.gson.q q0 = (com.google.gson.q)t1.a.get("INFOPOPUPURL");
                                    if(q0 != null) {
                                        String s = q0.b();
                                        if(s != null) {
                                            new MalrangServiceGuidePopup().show(s, l00);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    MusicBrowserPopupHelper.access$get_loginPopUpStateFlow$p(musicBrowserPopupHelper0).setValue(Boolean.FALSE);
                    return h0;
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MusicBrowserPopupHelper.access$get_loginPopUpStateFlow$p(musicBrowserPopupHelper0).setValue(Boolean.FALSE);
        MusicBrowserPopupHelper.access$showBottomPopupOrLayerPopup(musicBrowserPopupHelper0);
        return h0;
    }
}

