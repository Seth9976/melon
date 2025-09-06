package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;

public final class c2 implements a {
    public final LinearLayout a;
    public final ImageView b;
    public final b c;
    public final MelonTextView d;
    public final MelonTextView e;

    public c2(LinearLayout linearLayout0, ImageView imageView0, b b0, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = linearLayout0;
        this.b = imageView0;
        this.c = b0;
        this.d = melonTextView0;
        this.e = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

