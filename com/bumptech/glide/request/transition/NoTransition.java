package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class NoTransition implements Transition {
    public static class NoAnimationFactory implements TransitionFactory {
        @Override  // com.bumptech.glide.request.transition.TransitionFactory
        public Transition build(DataSource dataSource0, boolean z) {
            return NoTransition.NO_ANIMATION;
        }
    }

    static final NoTransition NO_ANIMATION;
    private static final TransitionFactory NO_ANIMATION_FACTORY;

    static {
        NoTransition.NO_ANIMATION = new NoTransition();
        NoTransition.NO_ANIMATION_FACTORY = new NoAnimationFactory();
    }

    public static Transition get() {
        return NoTransition.NO_ANIMATION;
    }

    public static TransitionFactory getFactory() {
        return NoTransition.NO_ANIMATION_FACTORY;
    }

    @Override  // com.bumptech.glide.request.transition.Transition
    public boolean transition(Object object0, ViewAdapter transition$ViewAdapter0) {
        return false;
    }
}

