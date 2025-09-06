package com.bumptech.glide.request.transition;

import android.view.View;

public class ViewPropertyTransition implements Transition {
    public interface Animator {
        void animate(View arg1);
    }

    private final Animator animator;

    public ViewPropertyTransition(Animator viewPropertyTransition$Animator0) {
        this.animator = viewPropertyTransition$Animator0;
    }

    @Override  // com.bumptech.glide.request.transition.Transition
    public boolean transition(Object object0, ViewAdapter transition$ViewAdapter0) {
        if(transition$ViewAdapter0.getView() != null) {
            View view0 = transition$ViewAdapter0.getView();
            this.animator.animate(view0);
        }
        return false;
    }
}

