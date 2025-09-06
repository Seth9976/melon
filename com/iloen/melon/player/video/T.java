package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE.Banner;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import e1.m;
import java.io.Serializable;
import kotlin.jvm.internal.q;

public final class t implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Serializable c;
    public final Object d;

    public t(int v, Serializable serializable0, Object object0, Object object1) {
        this.a = v;
        this.c = serializable0;
        this.d = object0;
        this.b = object1;
        super();
    }

    public t(MelonLinkInfo melonLinkInfo0, VideoInfoAdapter videoInfoAdapter0, Banner promotionContentsBannerRes$RESPONSE$Banner0) {
        this.a = 1;
        super();
        this.c = melonLinkInfo0;
        this.b = videoInfoAdapter0;
        this.d = promotionContentsBannerRes$RESPONSE$Banner0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Object object0 = this.b;
        Object object1 = this.d;
        Serializable serializable0 = this.c;
        switch(this.a) {
            case 0: {
                ((Mv)serializable0).isOpen = true;
                ((InfoViewHolder)object1).getBinding().p.setMaxLines(0x7FFFFFFF);
                ((InfoViewHolder)object1).getBinding().e.setVisibility(8);
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = ((VideoInfoAdapter)object0).b;
                if(videoInfoFragment$VideoInfoClickListener0 != null) {
                    videoInfoFragment$VideoInfoClickListener0.onMoreDesc();
                }
                return;
            }
            case 1: {
                MelonLinkExecutor.open(((MelonLinkInfo)serializable0));
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = ((VideoInfoAdapter)object0).b;
                if(videoInfoFragment$VideoInfoClickListener1 != null) {
                    String s2 = ((Banner)object1).bannerSeq;
                    q.f(s2, "bannerSeq");
                    String s3 = ((Banner)object1).imgUrl;
                    q.f(s3, "imgUrl");
                    videoInfoFragment$VideoInfoClickListener1.onBanner(s2, s3);
                }
                return;
            }
            default: {
                MelonLinkExecutor.open(((MelonLinkInfo)serializable0));
                String s = ((Banner)object0).imgUrl;
                q.f(s, "imgUrl");
                String s1 = ((Banner)object0).bannerSeq;
                m.F(new U(((VideoLivePreviewFragment)object1), s, ((Playable)((VideoLivePreviewFragment)object1).L().getCurrentVideoPlayable().getValue()), s1)).track();
            }
        }
    }
}

