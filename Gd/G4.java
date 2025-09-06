package gd;

import android.content.Context;
import androidx.viewpager.widget.j;
import com.google.firebase.b;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.utils.log.LogU;
import je.n;
import k8.Y;
import kotlin.jvm.internal.q;
import p8.f;
import p8.s;

public final class g4 implements j {
    public final h4 a;
    public final FixedTabLayout b;

    public g4(h4 h40, FixedTabLayout fixedTabLayout0) {
        this.a = h40;
        this.b = fixedTabLayout0;
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        Y.t("onPageScrollStateChanged: ", v, LogU.Companion, "MelonDjPopularPagerFragment");
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        LogU.Companion.d("MelonDjPopularPagerFragment", "onPageScrolled position: " + v + ", positionOffset: " + f);
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        String s4;
        String s3;
        String s2;
        h4 h40 = this.a;
        int v1 = ((i4)h40.getViewModel()).a;
        String s = (String)h40.h.get(v1);
        s s1 = (s)((i4)h40.getViewModel()).f.get(s);
        i4 i40 = (i4)h40.getViewModel();
        if(s1 == null) {
            s2 = "";
        }
        else {
            s2 = s1.a;
            if(s2 == null) {
                s2 = "";
            }
        }
        if(s1 == null) {
            s3 = "";
        }
        else {
            s3 = s1.b;
            if(s3 == null) {
                s3 = "";
            }
        }
        if(s1 == null) {
            s4 = "";
        }
        else {
            s4 = s1.c;
            if(s4 == null) {
                s4 = "";
            }
        }
        i40.updateTiaraProperty(s2, s3, s4);
        ((i4)h40.getViewModel()).a = v;
        f f0 = ((i4)h40.getViewModel()).d();
        if(f0 != null) {
            Context context0 = this.b.getContext();
            q.f("GNB", "getString(...)");
            String[] arr_s = h40.getResources().getStringArray(0x7F030016);  // array:melondj_playlist_period_tabs
            q.f(arr_s, "getStringArray(...)");
            String s5 = (String)n.n0(v, arr_s);
            b.O(f0, context0, null, "GNB", null, (s5 == null ? "" : s5), 0, null, null, null, null, null, false, 0, 8170);
        }
    }
}

