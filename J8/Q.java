package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class q implements a {
    public final int a;
    public final LinearLayout b;
    public final MelonTextView c;
    public final MelonTextView d;
    public final View e;
    public final View f;
    public final View g;
    public final View h;
    public final Object i;

    public q(LinearLayout linearLayout0, ImageView imageView0, ImageView imageView1, ImageView imageView2, f3 f30, MelonTextView melonTextView0, MelonTextView melonTextView1, View view0) {
        this.a = 1;
        super();
        this.b = linearLayout0;
        this.f = imageView0;
        this.g = imageView1;
        this.h = imageView2;
        this.i = f30;
        this.c = melonTextView0;
        this.d = melonTextView1;
        this.e = view0;
    }

    public q(RelativeLayout relativeLayout0, LinearLayout linearLayout0, MelonTextView melonTextView0, LinearLayout linearLayout1, MelonTextView melonTextView1, MelonTextView melonTextView2, MelonTextView melonTextView3, View view0) {
        this.a = 0;
        super();
        this.f = relativeLayout0;
        this.b = linearLayout0;
        this.c = melonTextView0;
        this.g = linearLayout1;
        this.d = melonTextView1;
        this.h = melonTextView2;
        this.i = melonTextView3;
        this.e = view0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a != 0 ? this.b : ((RelativeLayout)this.f);
    }
}

