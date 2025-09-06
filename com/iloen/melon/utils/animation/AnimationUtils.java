package com.iloen.melon.utils.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

public class AnimationUtils {
    public static abstract class AnimationListenerAdapter implements Animation.AnimationListener {
        @Override  // android.view.animation.Animation$AnimationListener
        public void onAnimationEnd(Animation animation0) {
        }

        @Override  // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation0) {
        }

        @Override  // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation0) {
        }
    }

    public static void setFadeAnimation(Context context0, View view0, boolean z) {
        if(context0 != null && view0 != null && (!z || view0.getVisibility() != 0) && (z || view0.getVisibility() == 0)) {
            view0.setAnimation((z ? android.view.animation.AnimationUtils.loadAnimation(context0, 0x10A0000) : android.view.animation.AnimationUtils.loadAnimation(context0, 0x10A0001)));
            view0.setVisibility((z ? 0 : 8));
        }
    }

    public static void setFadeInAndOutAnimation(View view0) {
        view0.setVisibility(0);
        AlphaAnimation alphaAnimation0 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation0.setInterpolator(new AccelerateInterpolator());
        alphaAnimation0.setStartOffset(2000L);
        alphaAnimation0.setDuration(300L);
        alphaAnimation0.setAnimationListener(new Animation.AnimationListener() {
            public final View a;

            {
                View view0 = view0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = view0;
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                this.a.setVisibility(8);
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
            }
        });
        AnimationSet animationSet0 = new AnimationSet(false);
        animationSet0.addAnimation(alphaAnimation0);
        view0.setAnimation(animationSet0);
    }

    public static void setFadeOutWithDelaysAnimation(Context context0, View view0) {
        if(view0 == null) {
            throw new NullPointerException();
        }
        Animation animation0 = android.view.animation.AnimationUtils.loadAnimation(context0, 0x10A0001);
        animation0.setStartOffset(3000L);
        view0.setAnimation(animation0);
        view0.setVisibility(8);
    }
}

