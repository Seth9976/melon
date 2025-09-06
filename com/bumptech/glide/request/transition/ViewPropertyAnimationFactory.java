package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class ViewPropertyAnimationFactory implements TransitionFactory {
    private ViewPropertyTransition animation;
    private final Animator animator;

    public ViewPropertyAnimationFactory(Animator viewPropertyTransition$Animator0) {
        this.animator = viewPropertyTransition$Animator0;
    }

    @Override  // com.bumptech.glide.request.transition.TransitionFactory
    public Transition build(DataSource dataSource0, boolean z) {
        if(dataSource0 != DataSource.MEMORY_CACHE && z) {
            if(this.animation == null) {
                this.animation = new ViewPropertyTransition(this.animator);
            }
            return this.animation;
        }
        return NoTransition.get();
    }
}

