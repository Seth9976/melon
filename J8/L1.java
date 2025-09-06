package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.CheckableImageView;

public final class l1 implements a {
    public final FrameLayout a;
    public final ImageView b;
    public final CheckableImageView c;
    public final ConstraintLayout d;
    public final LottieAnimationView e;
    public final ViewPager2 f;

    public l1(FrameLayout frameLayout0, ImageView imageView0, CheckableImageView checkableImageView0, ConstraintLayout constraintLayout0, LottieAnimationView lottieAnimationView0, ViewPager2 viewPager20) {
        this.a = frameLayout0;
        this.b = imageView0;
        this.c = checkableImageView0;
        this.d = constraintLayout0;
        this.e = lottieAnimationView0;
        this.f = viewPager20;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

