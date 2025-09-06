package com.iloen.melon.fragments;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistBannerHolder;
import com.iloen.melon.fragments.detail.MixPlaylistDetailFragment;
import com.iloen.melon.net.v5x.response.CastDetailRes.CAST;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE.Banner;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.template.TemplateImageLoader;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import ud.T;
import ud.Z;

public final class a implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public a(Object object0, Object object1, Object object2, Object object3, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Object object0 = this.e;
        Object object1 = this.d;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                DetailSongMetaContentBaseFragment.setDescText$lambda$38$lambda$37(((LinearLayout)object3), ((RelativeLayout)object2), ((RelativeLayout)object1), ((RelativeLayout)object0), view0);
                return;
            }
            case 1: {
                ArtistBannerHolder.a(((Banner)object3), ((MelonLinkInfo)object2), ((AdapterInViewHolder.Row)object1), ((ArtistBannerHolder)object0), view0);
                return;
            }
            case 2: {
                MixPlaylistDetailFragment.N0(((TemplateImageLoader)object3), ((ForUMixInfoBase)object2), ((MixPlaylistDetailFragment)object1), ((H)object0), view0);
                return;
            }
            default: {
                BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(((T)object3).a);
                if(!q.b((((CAST)object2) == null ? null : ((CAST)object2).castSeq), ((CastInfoBase)object1).castSeq)) {
                    ((Z)object0).playRadioCast(((CastInfoBase)object1).castSeq, ((T)object3).getMenuId(), null);
                }
            }
        }
    }
}

