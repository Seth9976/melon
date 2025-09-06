package com.iloen.melon.fragments.present;

import Fd.D;
import J8.L2;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.ProgramDetailFragment;
import com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment;
import com.iloen.melon.net.v4x.response.GiftListSongGiftBoxRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v5x.response.CastDetailRes.PROGRAM;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.kakao.emoticon.activity.adapter.EmoticonEditAdapter;
import com.kakao.emoticon.util.IntentUtils;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import ed.F0;
import p8.g;
import td.E1;
import ud.T;
import z6.f;

public final class a implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public a(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PresentReceiveAdapter.onBindViewImpl$lambda$1(((PresentReceivedListFragment)this.b), ((PresentReceiveAdapter)this.c), view0);
                return;
            }
            case 1: {
                PresentSendFragment.onViewCreated$lambda$12$lambda$11(((PresentSendFragment)this.b), ((TitleBar)this.c), view0);
                return;
            }
            case 2: {
                PresentSendAdapter.onBindViewImpl$lambda$1(((PresentSendListFragment)this.b), ((PresentSendAdapter)this.c), view0);
                return;
            }
            case 3: {
                SongSendAdapter.onBindViewHolder$lambda$2(((SongSendAdapter)this.b), ((SONGLIST)this.c), view0);
                return;
            }
            case 4: {
                TrendMusicWaveExclusiveFragment.p(((SLOTLIST)this.b), ((TrendMusicWaveExclusiveFragment)this.c), view0);
                return;
            }
            case 5: {
                EmoticonEditAdapter.b(((EmoticonEditAdapter)this.b), ((O0)this.c), view0);
                return;
            }
            case 6: {
                IntentUtils.a(((String)this.b), ((String)this.c), view0);
                return;
            }
            case 7: {
                ((we.a)this.b).invoke();
                g g0 = ((F0)((ed.Z.a)this.c).getViewModel()).k().a();
                g0.a = "";
                g0.y = "";
                g0.a().track();
                return;
            }
            case 8: {
                L2 l20 = (L2)this.b;
                ed.Z.a z$a0 = (ed.Z.a)this.c;
                CharSequence charSequence0 = l20.c.getText();
                if(charSequence0 != null) {
                    D d0 = f.q(6, charSequence0.toString(), null, null);
                    Navigator.INSTANCE.open(d0);
                    ((F0)z$a0.getViewModel()).k().b(charSequence0.toString(), "0", l20.e.getText().toString());
                }
                return;
            }
            case 9: {
                ((E1)this.b).b.invoke(((MelonBottomSheetItem)this.c));
                return;
            }
            default: {
                BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(((T)this.b).a);
                String s = ((PROGRAM)this.c).progSeq;
                if(s != null) {
                    ProgramDetailFragment.Companion.newInstance(s).open();
                }
            }
        }
    }
}

