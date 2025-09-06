package com.iloen.melon.fragments.detail.viewholder;

import J8.S2;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment;
import com.iloen.melon.fragments.shortform.TrendShortLyricsFragment;
import com.iloen.melon.fragments.shortform.TrendShortVideoEmphasisFragment;
import com.iloen.melon.fragments.shortform.TrendShortVideoOfferingFragment;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes.Response.Banners;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.BANNER;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.search.PlaylistSearchFragment;
import com.iloen.melon.popup.MelonMainPromotionPopup;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.ui.widget.EmoticonView;
import com.kakao.tiara.data.ActionKind;
import d3.g;
import kotlin.jvm.internal.q;
import o8.d;

public final class s implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public s(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Object object0 = this.d;
        Object object1 = this.c;
        Object object2 = this.b;
        switch(this.a) {
            case 0: {
                InnerLyricAdapter.onBindViewHolder$lambda$3$lambda$2(((InnerLyricAdapter)object2), ((MoreViewHolder)object1), ((LyricHolder)object0), view0);
                return;
            }
            case 1: {
                RepresentTagAdapter.a(((RepresentTagAdapter)object2), ((TagInfoBase)object1), ((Bundle)object0), view0);
                return;
            }
            case 2: {
                SettingMusicAlarmFragment.N(((S2)object2), ((d)object1), ((SettingMusicAlarmFragment)object0), view0);
                return;
            }
            case 3: {
                TrendShortLyricsFragment.o(((BANNER)object2), ((TrendShortLyricsFragment)object1), ((SLOTLIST)object0), view0);
                return;
            }
            case 4: {
                TrendShortVideoEmphasisFragment.o(((BANNER)object2), ((TrendShortVideoEmphasisFragment)object1), ((SLOTLIST)object0), view0);
                return;
            }
            case 5: {
                TrendShortVideoOfferingFragment.m(((BANNER)object2), ((TrendShortVideoOfferingFragment)object1), ((SLOTLIST)object0), view0);
                return;
            }
            case 6: {
                PlaylistSearchFragment.access$performShowMoreContextPopup(((PlaylistSearchFragment)object2), ((Playable)object1), ((Uri)object0));
                PlaylistSearchFragment.access$getTiaraLogHelper(((PlaylistSearchFragment)object2)).sendMoreClickLog(((Playable)object1));
                return;
            }
            case 7: {
                MelonLinkExecutor.open(MelonLinkInfo.a(((Banners)object2), ((MainLayerPopupRes)object1).getMenuId()));
                g.Z("2", null, "Z01", ((Banners)object2).banerseq, ((Banners)object2).contstypecode, ((Banners)object2).contsid);
                q.f("페이지이동", "getString(...)");
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.d = ActionKind.ClickContent;
                g0.a = "페이지이동";
                g0.b = "멜론홈탭";
                g0.c = "멜론홈탭_뮤직";
                g0.I = ((Banners)object2).menuId;
                g0.y = "레이어드팝업";
                g0.B = TextUtils.isEmpty(((Banners)object2).linkurl) ? ((Banners)object2).scheme : ((Banners)object2).linkurl;
                g0.E = ((Banners)object2).imgurl;
                g0.H = "melon_admin";
                g0.e = ((Banners)object2).banerseq;
                g0.f = "배너";
                g0.j = "melon_admin";
                g0.g = ((Banners)object2).adminTitle;
                g0.K = ((Banners)object2).targetId;
                g0.J = ((Banners)object2).impArea;
                g0.R = ((Banners)object2).banerseq;
                g0.a().track();
                ((MelonMainPromotionPopup)object0).dismiss();
                return;
            }
            default: {
                EmoticonView.a(((EmoticonView)object2), ((EmoticonViewParam)object1), ((View.OnClickListener)object0), view0);
            }
        }
    }
}

