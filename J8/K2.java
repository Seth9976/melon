package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class k2 implements a {
    public final ConstraintLayout a;
    public final MelonTextView b;
    public final ImageView c;
    public final LottieAnimationView d;
    public final MelonImageView e;
    public final MelonTextView f;
    public final g3 g;
    public final MelonTextView h;

    public k2(ConstraintLayout constraintLayout0, MelonTextView melonTextView0, ImageView imageView0, LottieAnimationView lottieAnimationView0, MelonImageView melonImageView0, MelonTextView melonTextView1, g3 g30, MelonTextView melonTextView2) {
        this.a = constraintLayout0;
        this.b = melonTextView0;
        this.c = imageView0;
        this.d = lottieAnimationView0;
        this.e = melonImageView0;
        this.f = melonTextView1;
        this.g = g30;
        this.h = melonTextView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

