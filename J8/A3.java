package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class a3 implements a {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final RelativeLayout c;
    public final MelonImageView d;
    public final ImageView e;
    public final e3 f;
    public final e3 g;
    public final e3 h;
    public final MelonTextView i;
    public final MelonTextView j;
    public final MelonTextView k;

    public a3(ConstraintLayout constraintLayout0, ConstraintLayout constraintLayout1, RelativeLayout relativeLayout0, MelonImageView melonImageView0, ImageView imageView0, e3 e30, e3 e31, e3 e32, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2) {
        this.a = constraintLayout0;
        this.b = constraintLayout1;
        this.c = relativeLayout0;
        this.d = melonImageView0;
        this.e = imageView0;
        this.f = e30;
        this.g = e31;
        this.h = e32;
        this.i = melonTextView0;
        this.j = melonTextView1;
        this.k = melonTextView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

