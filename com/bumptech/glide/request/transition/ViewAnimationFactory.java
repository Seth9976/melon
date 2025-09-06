package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;

public class ViewAnimationFactory implements TransitionFactory {
    static class ConcreteViewTransitionAnimationFactory implements ViewTransitionAnimationFactory {
        private final Animation animation;

        public ConcreteViewTransitionAnimationFactory(Animation animation0) {
            this.animation = animation0;
        }

        @Override  // com.bumptech.glide.request.transition.ViewTransition$ViewTransitionAnimationFactory
        public Animation build(Context context0) {
            return this.animation;
        }
    }

    static class ResourceViewTransitionAnimationFactory implements ViewTransitionAnimationFactory {
        private final int animationId;

        public ResourceViewTransitionAnimationFactory(int v) {
            this.animationId = v;
        }

        @Override  // com.bumptech.glide.request.transition.ViewTransition$ViewTransitionAnimationFactory
        public Animation build(Context context0) {
            return AnimationUtils.loadAnimation(context0, this.animationId);
        }
    }

    private Transition transition;
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public ViewAnimationFactory(int v) {
        this(new ResourceViewTransitionAnimationFactory(v));
    }

    public ViewAnimationFactory(Animation animation0) {
        this(new ConcreteViewTransitionAnimationFactory(animation0));
    }

    public ViewAnimationFactory(ViewTransitionAnimationFactory viewTransition$ViewTransitionAnimationFactory0) {
        this.viewTransitionAnimationFactory = viewTransition$ViewTransitionAnimationFactory0;
    }

    @Override  // com.bumptech.glide.request.transition.TransitionFactory
    public Transition build(DataSource dataSource0, boolean z) {
        if(dataSource0 != DataSource.MEMORY_CACHE && z) {
            if(this.transition == null) {
                this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
            }
            return this.transition;
        }
        return NoTransition.get();
    }
}

