package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class m1 implements a {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final MelonImageView e;
    public final ConstraintLayout f;
    public final r1 g;
    public final MelonTextView h;
    public final MelonTextView i;
    public final MelonTextView j;

    public m1(ConstraintLayout constraintLayout0, ImageView imageView0, ImageView imageView1, ImageView imageView2, MelonImageView melonImageView0, ConstraintLayout constraintLayout1, r1 r10, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2) {
        this.a = constraintLayout0;
        this.b = imageView0;
        this.c = imageView1;
        this.d = imageView2;
        this.e = melonImageView0;
        this.f = constraintLayout1;
        this.g = r10;
        this.h = melonTextView0;
        this.i = melonTextView1;
        this.j = melonTextView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

