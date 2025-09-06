package com.iloen.melon.custom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE.MEMORIALCARDRELAYLIST;
import java.util.List;
import kotlin.jvm.internal.q;

public final class e extends AnimatorListenerAdapter {
    public final ArtistCardRelayRollingView a;
    public final ArtistCardRelayItemView b;

    public e(ArtistCardRelayRollingView artistCardRelayRollingView0, ArtistCardRelayItemView artistCardRelayItemView0) {
        this.a = artistCardRelayRollingView0;
        this.b = artistCardRelayItemView0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        q.g(animator0, "animation");
        ArtistCardRelayRollingView artistCardRelayRollingView0 = this.a;
        List list0 = artistCardRelayRollingView0.getData();
        if(list0 != null) {
            artistCardRelayRollingView0.f = (artistCardRelayRollingView0.f + 1) % 2;
            artistCardRelayRollingView0.h = (artistCardRelayRollingView0.h + 1) % list0.size();
            this.b.setTranslationY(artistCardRelayRollingView0.b);
            int v = (artistCardRelayRollingView0.h + 1) % list0.size();
            MEMORIALCARDRELAYLIST artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0 = (MEMORIALCARDRELAYLIST)list0.get(v);
            this.b.setData(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0);
            d d0 = new d(artistCardRelayRollingView0, v, list0, 0);
            this.b.setOnClickListener(d0);
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        q.g(animator0, "animation");
    }
}

