package com.bumptech.glide;

import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition.Animator;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public abstract class TransitionOptions implements Cloneable {
    private TransitionFactory transitionFactory;

    public TransitionOptions() {
        this.transitionFactory = NoTransition.getFactory();
    }

    public final TransitionOptions clone() {
        try {
            return (TransitionOptions)super.clone();
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new RuntimeException(cloneNotSupportedException0);
        }
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    public final TransitionOptions dontTransition() {
        return this.transition(NoTransition.getFactory());
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof TransitionOptions ? Util.bothNullOrEqual(this.transitionFactory, ((TransitionOptions)object0).transitionFactory) : false;
    }

    public final TransitionFactory getTransitionFactory() {
        return this.transitionFactory;
    }

    @Override
    public int hashCode() {
        return this.transitionFactory == null ? 0 : this.transitionFactory.hashCode();
    }

    private TransitionOptions self() [...] // Inlined contents

    public final TransitionOptions transition(int v) {
        return this.transition(new ViewAnimationFactory(v));
    }

    public final TransitionOptions transition(TransitionFactory transitionFactory0) {
        this.transitionFactory = (TransitionFactory)Preconditions.checkNotNull(transitionFactory0);
        return this;
    }

    public final TransitionOptions transition(Animator viewPropertyTransition$Animator0) {
        return this.transition(new ViewPropertyAnimationFactory(viewPropertyTransition$Animator0));
    }
}

