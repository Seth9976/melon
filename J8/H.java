package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.MelonTextView;

public final class h implements a {
    public final LinearLayout a;
    public final MelonTextView b;
    public final LinearLayout c;
    public final AlphaControlCheckButton d;
    public final MelonTextView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;

    public h(LinearLayout linearLayout0, MelonTextView melonTextView0, LinearLayout linearLayout1, AlphaControlCheckButton alphaControlCheckButton0, MelonTextView melonTextView1, ImageView imageView0, ImageView imageView1, ImageView imageView2) {
        this.a = linearLayout0;
        this.b = melonTextView0;
        this.c = linearLayout1;
        this.d = alphaControlCheckButton0;
        this.e = melonTextView1;
        this.f = imageView0;
        this.g = imageView1;
        this.h = imageView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

