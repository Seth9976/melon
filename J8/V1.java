package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class v1 implements a {
    public final ConstraintLayout a;
    public final MelonTextView b;
    public final ImageView c;
    public final ImageView d;
    public final LottieAnimationView e;
    public final MelonImageView f;
    public final ImageView g;
    public final ImageView h;
    public final MelonTextView i;
    public final b j;
    public final FrameLayout k;

    public v1(ConstraintLayout constraintLayout0, MelonTextView melonTextView0, ImageView imageView0, ImageView imageView1, LottieAnimationView lottieAnimationView0, MelonImageView melonImageView0, ImageView imageView2, ImageView imageView3, MelonTextView melonTextView1, b b0, FrameLayout frameLayout0) {
        this.a = constraintLayout0;
        this.b = melonTextView0;
        this.c = imageView0;
        this.d = imageView1;
        this.e = lottieAnimationView0;
        this.f = melonImageView0;
        this.g = imageView2;
        this.h = imageView3;
        this.i = melonTextView1;
        this.j = b0;
        this.k = frameLayout0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

