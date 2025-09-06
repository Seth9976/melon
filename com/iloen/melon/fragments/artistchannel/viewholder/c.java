package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.comments.CommentListRenewalViewHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistBannerHolder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v5x.response.DetailBaseRes.BANNERLIST;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv;
import com.iloen.melon.player.video.VideoInfoAdapter;
import com.iloen.melon.player.video.VideoInfoFragment.VideoInfoClickListener;
import kotlin.jvm.internal.q;

public final class c implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;

    public c(VideoInfoAdapter videoInfoAdapter0, Mv vodDetailRes$Response$Mv0, boolean z) {
        this.a = 3;
        super();
        this.c = videoInfoAdapter0;
        this.d = vodDetailRes$Response$Mv0;
        this.b = z;
    }

    public c(Object object0, boolean z, Object object1, int v) {
        this.a = v;
        this.c = object0;
        this.b = z;
        this.d = object1;
        super();
    }

    public c(boolean z, CommentListRenewalViewHolder commentListRenewalViewHolder0, cmtList cmtResViewModel$result$cmtList0) {
        this.a = 1;
        super();
        this.b = z;
        this.c = commentListRenewalViewHolder0;
        this.d = cmtResViewModel$result$cmtList0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ArtistFanCmtShareHolder.onBindView$lambda$2(((RESPONSE)this.c), this.b, ((ArtistFanCmtShareHolder)this.d), view0);
                return;
            }
            case 1: {
                CommentListRenewalViewHolder.g(this.b, ((CommentListRenewalViewHolder)this.c), ((cmtList)this.d), view0);
                return;
            }
            case 2: {
                PlaylistBannerHolder.a(((PlaylistBannerHolder)this.c), this.b, ((BANNERLIST)this.d), view0);
                return;
            }
            default: {
                Mv vodDetailRes$Response$Mv0 = (Mv)this.d;
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = ((VideoInfoAdapter)this.c).b;
                if(videoInfoFragment$VideoInfoClickListener0 != null) {
                    q.d(view0);
                    String s = vodDetailRes$Response$Mv0.contsTypeCode;
                    q.f(s, "contsTypeCode");
                    videoInfoFragment$VideoInfoClickListener0.onInfoLike(view0, s, this.b);
                }
            }
        }
    }
}

