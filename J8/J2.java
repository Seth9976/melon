package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;

public final class j2 implements a {
    public final LinearLayout a;
    public final MelonTextView b;
    public final ImageView c;
    public final ImageView d;
    public final x e;

    public j2(LinearLayout linearLayout0, MelonTextView melonTextView0, ImageView imageView0, ImageView imageView1, x x0) {
        this.a = linearLayout0;
        this.b = melonTextView0;
        this.c = imageView0;
        this.d = imageView1;
        this.e = x0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

