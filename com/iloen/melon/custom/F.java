package com.iloen.melon.custom;

import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE.MEMORIALCARDRELAYLIST;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class f extends View.AccessibilityDelegate {
    public final ArtistCardRelayRollingView a;
    public final List b;
    public final ArtistCardRelayItemView c;

    public f(ArtistCardRelayRollingView artistCardRelayRollingView0, List list0, ArtistCardRelayItemView artistCardRelayItemView0) {
        this.a = artistCardRelayRollingView0;
        this.b = list0;
        this.c = artistCardRelayItemView0;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        q.g(view0, "host");
        q.g(accessibilityNodeInfo0, "info");
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        if(this.a.getContext() == null) {
            return;
        }
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, "상세보기"));
        if(this.b.size() > 1) {
            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, "다음 배너"));
        }
        accessibilityNodeInfo0.setContentDescription(this.c.getTalkbackText());
        accessibilityNodeInfo0.setClassName("android.widget.Button");
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        ArtistCardRelayRollingView artistCardRelayRollingView0 = this.a;
        ArrayList arrayList0 = artistCardRelayRollingView0.g;
        q.g(view0, "host");
        switch(v) {
            case 100000001: {
                return view0.performClick();
            }
            case 100000002: {
                ArtistCardRelayItemView artistCardRelayItemView0 = (ArtistCardRelayItemView)arrayList0.get(artistCardRelayRollingView0.f);
                ArtistCardRelayItemView artistCardRelayItemView1 = (ArtistCardRelayItemView)arrayList0.get((artistCardRelayRollingView0.f + 1) % 2);
                artistCardRelayItemView1.requestFocusFromTouch();
                artistCardRelayItemView1.setTranslationY(0.0f);
                artistCardRelayRollingView0.f = (artistCardRelayRollingView0.f + 1) % 2;
                artistCardRelayRollingView0.h = (artistCardRelayRollingView0.h + 1) % this.b.size();
                artistCardRelayItemView0.setTranslationY(artistCardRelayRollingView0.b);
                int v1 = (artistCardRelayRollingView0.h + 1) % this.b.size();
                artistCardRelayItemView0.setData(((MEMORIALCARDRELAYLIST)this.b.get(v1)));
                artistCardRelayItemView0.setOnClickListener(new d(artistCardRelayRollingView0, v1, this.b, 1));
                return true;
            }
            default: {
                return super.performAccessibilityAction(view0, v, bundle0);
            }
        }
    }
}

