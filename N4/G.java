package N4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.transition.ChangeClipBounds;
import androidx.transition.Transition;

public final class g extends AnimatorListenerAdapter implements S {
    public final Rect a;
    public final Rect b;
    public final View c;

    public g(View view0, Rect rect0, Rect rect1) {
        this.c = view0;
        this.a = rect0;
        this.b = rect1;
    }

    @Override  // N4.S
    public final void a() {
        View view0 = this.c;
        Rect rect0 = view0.getClipBounds();
        if(rect0 == null) {
            rect0 = ChangeClipBounds.c0;
        }
        view0.setTag(0x7F0A0BDE, rect0);  // id:transition_clip
        view0.setClipBounds(this.b);
    }

    @Override  // N4.S
    public final void d() {
        Rect rect0 = (Rect)this.c.getTag(0x7F0A0BDE);  // id:transition_clip
        this.c.setClipBounds(rect0);
        this.c.setTag(0x7F0A0BDE, null);  // id:transition_clip
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
        this.onAnimationEnd(animator0, false);
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0, boolean z) {
        View view0 = this.c;
        if(!z) {
            view0.setClipBounds(this.b);
            return;
        }
        view0.setClipBounds(this.a);
    }
}

