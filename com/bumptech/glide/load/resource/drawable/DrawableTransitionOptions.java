package com.bumptech.glide.load.resource.drawable;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

public final class DrawableTransitionOptions extends TransitionOptions {
    public DrawableTransitionOptions crossFade() {
        return this.crossFade(new Builder());
    }

    public DrawableTransitionOptions crossFade(int v) {
        return this.crossFade(new Builder(v));
    }

    public DrawableTransitionOptions crossFade(Builder drawableCrossFadeFactory$Builder0) {
        return this.crossFade(drawableCrossFadeFactory$Builder0.build());
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory0) {
        return (DrawableTransitionOptions)this.transition(drawableCrossFadeFactory0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.TransitionOptions
    public boolean equals(Object object0) {
        return object0 instanceof DrawableTransitionOptions && super.equals(object0);
    }

    @Override  // com.bumptech.glide.TransitionOptions
    public int hashCode() {
        return super.hashCode();
    }

    public static DrawableTransitionOptions with(TransitionFactory transitionFactory0) {
        return (DrawableTransitionOptions)new DrawableTransitionOptions().transition(transitionFactory0);
    }

    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    public static DrawableTransitionOptions withCrossFade(int v) {
        return new DrawableTransitionOptions().crossFade(v);
    }

    public static DrawableTransitionOptions withCrossFade(Builder drawableCrossFadeFactory$Builder0) {
        return new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory$Builder0);
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory0) {
        return new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory0);
    }
}

