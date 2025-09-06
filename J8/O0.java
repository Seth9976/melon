package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class o0 implements a {
    public final LinearLayout a;
    public final RelativeLayout b;
    public final RelativeLayout c;
    public final RelativeLayout d;
    public final RelativeLayout e;
    public final MainTabTitleView f;
    public final RelativeLayout g;
    public final FlexboxLayout h;
    public final FlexboxLayout i;
    public final FlexboxLayout j;
    public final FlexboxLayout k;
    public final FlexboxLayout l;
    public final MelonTextView m;

    public o0(LinearLayout linearLayout0, RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, MainTabTitleView mainTabTitleView0, RelativeLayout relativeLayout4, FlexboxLayout flexboxLayout0, FlexboxLayout flexboxLayout1, FlexboxLayout flexboxLayout2, FlexboxLayout flexboxLayout3, FlexboxLayout flexboxLayout4, MelonTextView melonTextView0) {
        this.a = linearLayout0;
        this.b = relativeLayout0;
        this.c = relativeLayout1;
        this.d = relativeLayout2;
        this.e = relativeLayout3;
        this.f = mainTabTitleView0;
        this.g = relativeLayout4;
        this.h = flexboxLayout0;
        this.i = flexboxLayout1;
        this.j = flexboxLayout2;
        this.k = flexboxLayout3;
        this.l = flexboxLayout4;
        this.m = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

