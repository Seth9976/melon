package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.OutlineTextView;
import com.iloen.melon.player.video.VideoMiniPlayer;
import com.iloen.melon.player.video.VideoMotionLayout;
import com.iloen.melon.player.video.VideoSeekBarAndDuration;

public final class n2 implements a {
    public final VideoMotionLayout a;
    public final View b;
    public final View c;
    public final OutlineTextView d;
    public final Guideline e;
    public final LottieAnimationView f;
    public final FragmentContainerView g;
    public final ConstraintLayout h;
    public final LottieAnimationView i;
    public final VideoSeekBarAndDuration j;
    public final ConstraintLayout k;
    public final View l;
    public final FragmentContainerView m;
    public final RelativeLayout n;
    public final VideoMotionLayout o;
    public final VideoMiniPlayer p;
    public final FragmentContainerView q;
    public final CardView r;

    public n2(VideoMotionLayout videoMotionLayout0, View view0, View view1, OutlineTextView outlineTextView0, Guideline guideline0, LottieAnimationView lottieAnimationView0, FragmentContainerView fragmentContainerView0, ConstraintLayout constraintLayout0, LottieAnimationView lottieAnimationView1, VideoSeekBarAndDuration videoSeekBarAndDuration0, ConstraintLayout constraintLayout1, View view2, FragmentContainerView fragmentContainerView1, RelativeLayout relativeLayout0, VideoMotionLayout videoMotionLayout1, VideoMiniPlayer videoMiniPlayer0, FragmentContainerView fragmentContainerView2, CardView cardView0) {
        this.a = videoMotionLayout0;
        this.b = view0;
        this.c = view1;
        this.d = outlineTextView0;
        this.e = guideline0;
        this.f = lottieAnimationView0;
        this.g = fragmentContainerView0;
        this.h = constraintLayout0;
        this.i = lottieAnimationView1;
        this.j = videoSeekBarAndDuration0;
        this.k = constraintLayout1;
        this.l = view2;
        this.m = fragmentContainerView1;
        this.n = relativeLayout0;
        this.o = videoMotionLayout1;
        this.p = videoMiniPlayer0;
        this.q = fragmentContainerView2;
        this.r = cardView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

