package com.iloen.melon.utils.ui;

import H0.b;
import androidx.fragment.app.l0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v4x.response.MainBottomSlidePopupRes.Response.Banner;
import com.iloen.melon.net.v4x.response.MainBottomSlidePopupRes;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes;
import com.iloen.melon.popup.MainBottomPopup;
import com.iloen.melon.utils.log.LogU;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class k implements ErrorListener, Listener {
    public final int a;
    public final MusicBrowserPopupHelper b;

    public k(MusicBrowserPopupHelper musicBrowserPopupHelper0, int v) {
        this.a = v;
        this.b = musicBrowserPopupHelper0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 2: {
                this.b.n.setValue(Boolean.FALSE);
                this.b.e();
                b.w("fetchAndShowBottomSlidePopup(): ", volleyError0.getMessage(), LogU.Companion, "MusicBrowserPopupHelper");
                return;
            }
            case 3: {
                b.w("fetchAndShowFloatingBannerPopup() error: ", volleyError0.getMessage(), LogU.Companion, "MusicBrowserPopupHelper");
                this.b.l(false, true);
                return;
            }
            case 4: {
                this.b.n.setValue(Boolean.FALSE);
                b.w("fetchAndShowLayerPopup() : ", volleyError0.getMessage(), LogU.Companion, "MusicBrowserPopupHelper");
                return;
            }
            default: {
                this.b.n.setValue(Boolean.FALSE);
                MusicBrowserPopupHelper.access$showMixUpMalrangGuidePopup(this.b);
                b.w("fetchAndShowNoticePopup(): ", volleyError0.getMessage(), LogU.Companion, "MusicBrowserPopupHelper");
            }
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 0) {
            MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.b;
            musicBrowserPopupHelper0.n.setValue(Boolean.FALSE);
            if(!((MainBottomSlidePopupRes)object0).isSuccessful(false) || !MainBottomPopup.Companion.isBannerAvailable(((MainBottomSlidePopupRes)object0).response.banners)) {
                LogU.Companion.d("MusicBrowserPopupHelper", "showBottomPopupOrLayerPopup() MainBottomPopup is not available");
                musicBrowserPopupHelper0.e();
            }
            else {
                List list0 = ((MainBottomSlidePopupRes)object0).response.banners;
                if(list0 != null) {
                    Banner mainBottomSlidePopupRes$Response$Banner0 = (Banner)p.m0(list0);
                    if(mainBottomSlidePopupRes$Response$Banner0 != null) {
                        if(musicBrowserPopupHelper0.g != null && q.b(musicBrowserPopupHelper0.g.banerseq, mainBottomSlidePopupRes$Response$Banner0.banerseq)) {
                            LogU.Companion.d("MusicBrowserPopupHelper", "showBottomPopupOrLayerPopup() bottomPopupBanner is already shown");
                            return;
                        }
                        musicBrowserPopupHelper0.g = mainBottomSlidePopupRes$Response$Banner0;
                        MusicBrowserActivity musicBrowserActivity0 = musicBrowserPopupHelper0.getActivity();
                        if(musicBrowserActivity0 != null) {
                            l0 l00 = musicBrowserActivity0.getSupportFragmentManager();
                            if(l00 != null) {
                                synchronized(musicBrowserPopupHelper0) {
                                    new MainBottomPopup().show(((MainBottomSlidePopupRes)object0).response.banners, l00);
                                }
                                return;
                            }
                        }
                    }
                }
            }
            return;
        }
        MusicBrowserPopupHelper musicBrowserPopupHelper1 = this.b;
        musicBrowserPopupHelper1.n.setValue(Boolean.FALSE);
        if(((MainNoticePopupRes)object0).isSuccessful(false)) {
            BuildersKt__Builders_commonKt.launch$default(musicBrowserPopupHelper1.g(), null, null, new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showPopupWithPriority.1.1.1(musicBrowserPopupHelper1, ((MainNoticePopupRes)object0), null), 3, null);
        }
    }
}

