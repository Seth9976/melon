package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class j implements a {
    public final LinearLayout a;
    public final MelonTextView b;
    public final MelonTextView c;
    public final MelonTextView d;
    public final MelonImageView e;
    public final View f;
    public final MainTabTitleView g;
    public final MelonTextView h;

    public j(LinearLayout linearLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2, MelonImageView melonImageView0, View view0, MainTabTitleView mainTabTitleView0, MelonTextView melonTextView3) {
        this.a = linearLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
        this.d = melonTextView2;
        this.e = melonImageView0;
        this.f = view0;
        this.g = mainTabTitleView0;
        this.h = melonTextView3;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

