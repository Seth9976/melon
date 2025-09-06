package com.iloen.melon.fragments.detail.viewholder;

import Fd.D;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.musicmessage.MusicMessageBlockListViewHolder;
import com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogAdapter;
import com.iloen.melon.fragments.news.FeedLogsListFragment;
import com.iloen.melon.fragments.present.PresentReceivedListFragment.PresentReceiveAdapter;
import com.iloen.melon.fragments.present.PresentSendListFragment.PresentSendAdapter;
import com.iloen.melon.fragments.settings.alarm.b;
import com.iloen.melon.fragments.webview.MelonWebViewFirstDepthFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenWithBackButtonFragment;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxReceiveRes.RESPONSE.GIFTLIST;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v5x.response.CastDetailRes.CAST;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.kakao.emoticon.ui.widget.EmptyRetryView;
import com.kakao.tiara.data.ActionKind;
import com.melon.playlist.station.CastData;
import com.melon.ui.E3;
import ed.F0;
import ed.Z.a;
import gd.B4;
import gd.C4;
import gd.F4;
import gd.T4;
import gd.h4;
import gd.l4;
import kotlin.jvm.internal.q;
import p8.g;
import td.b0;
import td.q0;
import ud.K;
import ud.Z;
import ud.i0;
import vb.c;
import vd.z;
import wd.u;
import we.k;

public final class p implements View.OnClickListener {
    public final int a;
    public final Object b;

    public p(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                return;
            }
            case 1: {
                return;
            }
            case 2: {
                return;
            }
            case 3: {
                StReportHolder.updateMyListenContainer$lambda$6$lambda$5(((StReportHolder)object0), view0);
                return;
            }
            case 4: {
                MusicMessageBlockListViewHolder.a(((USERLIST)object0), view0);
                return;
            }
            case 5: {
                MonthlyDnaLogAdapter.d(((MonthlyDnaLogAdapter)object0), view0);
                return;
            }
            case 6: {
                FeedLogsListFragment.h0(((FeedLogsListFragment)object0), view0);
                return;
            }
            case 7: {
                PresentReceiveAdapter.c(((GIFTLIST)object0), view0);
                return;
            }
            case 8: {
                PresentSendAdapter.a(((com.iloen.melon.net.v4x.response.GiftListGiftBoxSendRes.RESPONSE.GIFTLIST)object0), view0);
                return;
            }
            case 9: {
                MelonWebViewFirstDepthFragment.t0(((MelonWebViewFirstDepthFragment)object0), view0);
                return;
            }
            case 10: {
                MelonWebViewFullScreenWithBackButtonFragment.t0(((MelonWebViewFullScreenWithBackButtonFragment)object0), view0);
                return;
            }
            case 11: {
                EmptyRetryView.a(((EmptyRetryView)object0), view0);
                return;
            }
            case 12: {
                D d0 = new D();
                Navigator.INSTANCE.open(d0);
                g g0 = ((F0)((a)object0).getViewModel()).k().a();
                g0.a = "";
                g0.d = ActionKind.Search;
                g0.y = "";
                g0.a().track();
                return;
            }
            case 13: {
                I i0 = ((h4)object0).getCurrentFragment();
                String s = i0 instanceof l4 ? ((B4)((l4)i0).getViewModel()).h : null;
                String s1 = ((h4)object0).getString(0x7F13066E);  // string:melondj_title_popular_playlist "인기 플레이리스트"
                q.f(s1, "getString(...)");
                if(s == null) {
                    s = "";
                }
                ((h4)object0).sendUserEvent(new C4(s1, s));
                return;
            }
            case 14: {
                String s2 = ((F4)object0).getString(0x7F130656);  // string:melondj_power_dj "파워DJ"
                q.f(s2, "getString(...)");
                ((F4)object0).sendUserEvent(new T4(s2));
                return;
            }
            case 15: {
                ((b0)object0).sendUserEvent(q0.a);
                return;
            }
            case 16: {
                ((K)object0).d.invoke(i0.a);
                BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(((K)object0));
                return;
            }
            case 17: {
                CastData castData0 = (CastData)((Z)object0).f.getValue();
                if(castData0 != null) {
                    CAST castDetailRes$CAST0 = castData0.b;
                    if(castDetailRes$CAST0 != null) {
                        k k0 = ((Z)object0).d;
                        if(k0 != null) {
                            String s3 = castDetailRes$CAST0.castSeq;
                            q.f(s3, "castSeq");
                            String s4 = castDetailRes$CAST0.castTitle;
                            q.f(s4, "castTitle");
                            String s5 = castDetailRes$CAST0.castImgUrl;
                            q.f(s5, "castImgUrl");
                            String s6 = CreatorInfoBase.getFirstNameAndNumber(((Z)object0).getContext(), castDetailRes$CAST0.creator);
                            q.f(s6, "getFirstNameAndNumber(...)");
                            k0.invoke(new E3(new c(s3, s4, s5, s6)));
                        }
                        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(((Z)object0));
                    }
                }
                return;
            }
            case 18: {
                ((z)object0).dismiss();
                return;
            }
            default: {
                b b0 = ((u)object0).b;
                if(b0 != null) {
                    b0.invoke();
                }
                ((u)object0).dismiss();
            }
        }
    }
}

