package ed;

import J8.L2;
import J8.q1;
import android.animation.AnimatorSet.Builder;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.iloen.melon.custom.z1;
import com.melon.ui.playermusic.PlayerMoreView;
import td.B1;
import we.a;

public final class r implements Runnable {
    public final int a;
    public final int b;
    public final float c;
    public final Object d;
    public final Object e;

    public r(L2 l20, float f, int v, String s) {
        this.a = 0;
        super();
        this.d = l20;
        this.c = f;
        this.b = v;
        this.e = s;
    }

    public r(PlayerMoreView playerMoreView0, int v, float f, a a0) {
        this.a = 1;
        super();
        this.d = playerMoreView0;
        this.b = v;
        this.c = f;
        this.e = a0;
    }

    @Override
    public final void run() {
        Object object0 = this.e;
        float f = this.c;
        int v = this.b;
        Object object1 = this.d;
        if(this.a != 0) {
            boolean z = ((PlayerMoreView)object1).isAttachedToWindow();
            q1 q10 = ((PlayerMoreView)object1).E;
            if(z) {
                AnimatorSet animatorSet0 = ((PlayerMoreView)object1).V;
                if(animatorSet0 != null) {
                    animatorSet0.cancel();
                }
                AnimatorSet animatorSet1 = new AnimatorSet();
                int v1 = q10.j.getWidth();
                float f1 = q10.j.getAlpha();
                ValueAnimator valueAnimator0 = ValueAnimator.ofInt(new int[]{v1, v});
                valueAnimator0.setDuration(100L);
                valueAnimator0.addUpdateListener(new B1(((PlayerMoreView)object1), 0));
                AnimatorSet.Builder animatorSet$Builder0 = animatorSet1.play(valueAnimator0);
                ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{f1, f});
                valueAnimator1.setDuration(100L);
                valueAnimator1.addUpdateListener(new B1(((PlayerMoreView)object1), 1));
                animatorSet$Builder0.with(valueAnimator1);
                animatorSet1.addListener(new z1(((a)object0), 1));
                animatorSet1.start();
                ((PlayerMoreView)object1).V = animatorSet1;
            }
            return;
        }
        ((L2)object1).d.setTranslationY(f);
        ((L2)object1).e.setText(String.valueOf(v + 1));
        ((L2)object1).c.setText(((String)object0));
        ((L2)object1).d.animate().translationY(0.0f).setDuration(500L).start();
    }
}

