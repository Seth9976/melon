package u6;

import A6.h;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;

public final class g extends a {
    public final float g;
    public final float h;
    public float i;
    public Rect j;
    public Rect k;
    public Integer l;

    public g(View view0) {
        super(view0);
        Resources resources0 = view0.getResources();
        this.g = resources0.getDimension(0x7F070157);  // dimen:m3_back_progress_main_container_min_edge_gap
        this.h = resources0.getDimension(0x7F070156);  // dimen:m3_back_progress_main_container_max_translation_y
    }

    public final AnimatorSet b(View view0) {
        AnimatorSet animatorSet0 = new AnimatorSet();
        animatorSet0.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.b, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.b, View.SCALE_Y, new float[]{1.0f}), ObjectAnimator.ofFloat(this.b, View.TRANSLATION_X, new float[]{0.0f}), ObjectAnimator.ofFloat(this.b, View.TRANSLATION_Y, new float[]{0.0f})});
        animatorSet0.addListener(new h(view0, 12));
        return animatorSet0;
    }

    public final int c() {
        if(this.l == null) {
            int[] arr_v = new int[2];
            View view0 = this.b;
            view0.getLocationOnScreen(arr_v);
            int v = 0;
            if(arr_v[1] == 0 && Build.VERSION.SDK_INT >= 0x1F) {
                WindowInsets windowInsets0 = view0.getRootWindowInsets();
                if(windowInsets0 != null) {
                    RoundedCorner roundedCorner0 = windowInsets0.getRoundedCorner(0);
                    int v1 = roundedCorner0 == null ? 0 : roundedCorner0.getRadius();
                    RoundedCorner roundedCorner1 = windowInsets0.getRoundedCorner(1);
                    int v2 = Math.max(v1, (roundedCorner1 == null ? 0 : roundedCorner1.getRadius()));
                    RoundedCorner roundedCorner2 = windowInsets0.getRoundedCorner(3);
                    int v3 = roundedCorner2 == null ? 0 : roundedCorner2.getRadius();
                    RoundedCorner roundedCorner3 = windowInsets0.getRoundedCorner(2);
                    if(roundedCorner3 != null) {
                        v = roundedCorner3.getRadius();
                    }
                    v = Math.max(v2, Math.max(v3, v));
                }
            }
            this.l = v;
        }
        return (int)this.l;
    }
}

