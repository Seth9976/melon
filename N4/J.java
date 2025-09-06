package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Matrix;
import android.widget.ImageView;
import androidx.transition.Transition;

public final class j extends AnimatorListenerAdapter implements S {
    public final ImageView a;
    public final Matrix b;
    public final Matrix c;
    public boolean d;

    public j(ImageView imageView0, Matrix matrix0, Matrix matrix1) {
        this.d = true;
        this.a = imageView0;
        this.b = matrix0;
        this.c = matrix1;
    }

    @Override  // N4.S
    public final void a() {
        if(this.d) {
            this.a.setTag(0x7F0A0BE0, this.b);  // id:transition_image_transform
            L.c(this.a, this.c);
        }
    }

    @Override  // N4.S
    public final void d() {
        ImageView imageView0 = this.a;
        Matrix matrix0 = (Matrix)imageView0.getTag(0x7F0A0BE0);  // id:transition_image_transform
        if(matrix0 != null) {
            L.c(imageView0, matrix0);
            imageView0.setTag(0x7F0A0BE0, null);  // id:transition_image_transform
        }
    }

    @Override  // N4.S
    public final void e(Transition transition0) {
    }

    @Override  // N4.S
    public final void f(Transition transition0) {
    }

    @Override  // N4.S
    public final void g(Transition transition0) {
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.d = false;
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0, boolean z) {
        this.d = z;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationPause(Animator animator0) {
        Matrix matrix0 = (Matrix)((ObjectAnimator)animator0).getAnimatedValue();
        this.a.setTag(0x7F0A0BE0, matrix0);  // id:transition_image_transform
        L.c(this.a, this.c);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationResume(Animator animator0) {
        ImageView imageView0 = this.a;
        Matrix matrix0 = (Matrix)imageView0.getTag(0x7F0A0BE0);  // id:transition_image_transform
        if(matrix0 != null) {
            L.c(imageView0, matrix0);
            imageView0.setTag(0x7F0A0BE0, null);  // id:transition_image_transform
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        this.d = false;
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationStart(Animator animator0, boolean z) {
        this.d = false;
    }
}

