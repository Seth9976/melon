package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;

public final class m2 implements a {
    public final LinearLayout a;
    public final View b;
    public final ImageView c;
    public final MelonTextView d;
    public final MelonTextView e;
    public final ImageView f;
    public final LinearLayout g;
    public final MelonTextView h;

    public m2(LinearLayout linearLayout0, View view0, ImageView imageView0, MelonTextView melonTextView0, MelonTextView melonTextView1, ImageView imageView1, LinearLayout linearLayout1, MelonTextView melonTextView2) {
        this.a = linearLayout0;
        this.b = view0;
        this.c = imageView0;
        this.d = melonTextView0;
        this.e = melonTextView1;
        this.f = imageView1;
        this.g = linearLayout1;
        this.h = melonTextView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

