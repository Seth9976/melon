package com.iloen.melon.player.video;

import Q4.a;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.iloen.melon.utils.color.ColorUtils;
import m4.f;
import m4.g;
import m4.h;
import m4.i;

public final class r implements f {
    public final VideoChatFragment a;
    public final a b;

    public r(VideoChatFragment videoChatFragment0, a a0) {
        this.a = videoChatFragment0;
        this.b = a0;
    }

    @Override  // m4.f
    public final void a(h h0) {
        CardView cardView0 = null;
        g g0 = h0 == null ? null : h0.a(i.h);
        int v = g0 == null ? ColorUtils.getColor(this.a.getContext(), 0x7F06015D) : g0.d;  // color:gray500s_support_high_contrast
        View view0 = this.b.getRoot();
        if(view0 instanceof CardView) {
            cardView0 = (CardView)view0;
        }
        if(cardView0 != null) {
            cardView0.setCardBackgroundColor(v);
        }
    }
}

