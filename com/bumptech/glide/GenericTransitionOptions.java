package com.bumptech.glide;

import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition.Animator;

public final class GenericTransitionOptions extends TransitionOptions {
    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.TransitionOptions
    public boolean equals(Object object0) {
        return object0 instanceof GenericTransitionOptions && super.equals(object0);
    }

    @Override  // com.bumptech.glide.TransitionOptions
    public int hashCode() {
        return super.hashCode();
    }

    public static GenericTransitionOptions with(int v) {
        return (GenericTransitionOptions)new GenericTransitionOptions().transition(v);
    }

    public static GenericTransitionOptions with(TransitionFactory transitionFactory0) {
        return (GenericTransitionOptions)new GenericTransitionOptions().transition(transitionFactory0);
    }

    public static GenericTransitionOptions with(Animator viewPropertyTransition$Animator0) {
        return (GenericTransitionOptions)new GenericTransitionOptions().transition(viewPropertyTransition$Animator0);
    }

    public static GenericTransitionOptions withNoTransition() {
        return (GenericTransitionOptions)new GenericTransitionOptions().dontTransition();
    }
}

