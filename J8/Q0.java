package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class q0 implements a {
    public final RelativeLayout a;
    public final View b;
    public final LinearLayout c;
    public final MainTabTitleView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final MelonTextView g;
    public final MelonTextView h;
    public final MelonTextView i;

    public q0(RelativeLayout relativeLayout0, View view0, LinearLayout linearLayout0, MainTabTitleView mainTabTitleView0, LinearLayout linearLayout1, LinearLayout linearLayout2, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2) {
        this.a = relativeLayout0;
        this.b = view0;
        this.c = linearLayout0;
        this.d = mainTabTitleView0;
        this.e = linearLayout1;
        this.f = linearLayout2;
        this.g = melonTextView0;
        this.h = melonTextView1;
        this.i = melonTextView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

