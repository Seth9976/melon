package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;

public final class c3 implements a {
    public final LinearLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final ConstraintLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final FrameLayout j;
    public final MelonTextView k;
    public final ConstraintLayout l;
    public final ImageView m;
    public final TextView n;
    public final CheckableImageView o;

    public c3(LinearLayout linearLayout0, FrameLayout frameLayout0, FrameLayout frameLayout1, FrameLayout frameLayout2, ConstraintLayout constraintLayout0, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, FrameLayout frameLayout7, MelonTextView melonTextView0, ConstraintLayout constraintLayout1, ImageView imageView0, TextView textView0, CheckableImageView checkableImageView0) {
        this.a = linearLayout0;
        this.b = frameLayout0;
        this.c = frameLayout1;
        this.d = frameLayout2;
        this.e = constraintLayout0;
        this.f = frameLayout3;
        this.g = frameLayout4;
        this.h = frameLayout5;
        this.i = frameLayout6;
        this.j = frameLayout7;
        this.k = melonTextView0;
        this.l = constraintLayout1;
        this.m = imageView0;
        this.n = textView0;
        this.o = checkableImageView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

