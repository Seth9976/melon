package u6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

public final class f extends a {
    public final float g;
    public final float h;

    public f(View view0) {
        super(view0);
        Resources resources0 = view0.getResources();
        this.g = resources0.getDimension(0x7F070154);  // dimen:m3_back_progress_bottom_container_max_scale_x_distance
        this.h = resources0.getDimension(0x7F070155);  // dimen:m3_back_progress_bottom_container_max_scale_y_distance
    }

    public final AnimatorSet b() {
        AnimatorSet animatorSet0 = new AnimatorSet();
        View view0 = this.b;
        animatorSet0.playTogether(new Animator[]{ObjectAnimator.ofFloat(view0, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(view0, View.SCALE_Y, new float[]{1.0f})});
        if(view0 instanceof ViewGroup) {
            for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                animatorSet0.playTogether(new Animator[]{ObjectAnimator.ofFloat(((ViewGroup)view0).getChildAt(v), View.SCALE_Y, new float[]{1.0f})});
            }
        }
        animatorSet0.setInterpolator(new P2.a(1));
        return animatorSet0;
    }

    public final void c(float f) {
        float f1 = this.a.getInterpolation(f);
        View view0 = this.b;
        float f2 = (float)view0.getWidth();
        float f3 = (float)view0.getHeight();
        if(f2 > 0.0f && f3 > 0.0f) {
            float f4 = e6.a.a(0.0f, this.g / f2, f1);
            float f5 = e6.a.a(0.0f, this.h / f3, f1);
            view0.setScaleX(1.0f - f4);
            view0.setPivotY(f3);
            view0.setScaleY(1.0f - f5);
            if(view0 instanceof ViewGroup) {
                for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                    View view1 = ((ViewGroup)view0).getChildAt(v);
                    view1.setPivotY(((float)(-view1.getTop())));
                    view1.setScaleY((1.0f - f5 == 0.0f ? 1.0f : (1.0f - f4) / (1.0f - f5)));
                }
            }
        }
    }
}

