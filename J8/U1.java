package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;

public final class u1 implements a {
    public final LinearLayout a;
    public final ScrollableAlyacFilter b;
    public final MelonTextView c;
    public final MelonTextView d;
    public final View e;

    public u1(LinearLayout linearLayout0, ScrollableAlyacFilter scrollableAlyacFilter0, MelonTextView melonTextView0, MelonTextView melonTextView1, View view0) {
        this.a = linearLayout0;
        this.b = scrollableAlyacFilter0;
        this.c = melonTextView0;
        this.d = melonTextView1;
        this.e = view0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

