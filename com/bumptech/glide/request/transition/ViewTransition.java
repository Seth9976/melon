package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

public class ViewTransition implements Transition {
    interface ViewTransitionAnimationFactory {
        Animation build(Context arg1);
    }

    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public ViewTransition(ViewTransitionAnimationFactory viewTransition$ViewTransitionAnimationFactory0) {
        this.viewTransitionAnimationFactory = viewTransition$ViewTransitionAnimationFactory0;
    }

    @Override  // com.bumptech.glide.request.transition.Transition
    public boolean transition(Object object0, ViewAdapter transition$ViewAdapter0) {
        View view0 = transition$ViewAdapter0.getView();
        if(view0 != null) {
            view0.clearAnimation();
            Context context0 = view0.getContext();
            view0.startAnimation(this.viewTransitionAnimationFactory.build(context0));
        }
        return false;
    }
}

