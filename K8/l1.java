package k8;

import android.transition.Transition.TransitionListener;
import android.transition.Transition;
import android.view.View;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.player.video.FloatingFragment;

public final class l1 implements Transition.TransitionListener {
    public final MusicBrowserActivity a;

    public l1(MusicBrowserActivity musicBrowserActivity0) {
        this.a = musicBrowserActivity0;
    }

    @Override  // android.transition.Transition$TransitionListener
    public final void onTransitionCancel(Transition transition0) {
    }

    @Override  // android.transition.Transition$TransitionListener
    public final void onTransitionEnd(Transition transition0) {
        this.a.isTabAndMiniPlayerVisibilityAnimationPlaying = false;
        FloatingFragment floatingFragment0 = this.a.floatingFragment;
        if(floatingFragment0 != null) {
            View view0 = floatingFragment0.getView();
            if(view0 != null) {
                view0.requestLayout();
            }
        }
    }

    @Override  // android.transition.Transition$TransitionListener
    public final void onTransitionPause(Transition transition0) {
    }

    @Override  // android.transition.Transition$TransitionListener
    public final void onTransitionResume(Transition transition0) {
    }

    @Override  // android.transition.Transition$TransitionListener
    public final void onTransitionStart(Transition transition0) {
    }
}

