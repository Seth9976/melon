package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

public final class BitmapTransitionOptions extends TransitionOptions {
    public BitmapTransitionOptions crossFade() {
        return this.crossFade(new Builder());
    }

    public BitmapTransitionOptions crossFade(int v) {
        return this.crossFade(new Builder(v));
    }

    public BitmapTransitionOptions crossFade(Builder drawableCrossFadeFactory$Builder0) {
        return this.transitionUsing(drawableCrossFadeFactory$Builder0.build());
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory0) {
        return this.transitionUsing(drawableCrossFadeFactory0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.TransitionOptions
    public boolean equals(Object object0) {
        return object0 instanceof BitmapTransitionOptions && super.equals(object0);
    }

    @Override  // com.bumptech.glide.TransitionOptions
    public int hashCode() {
        return super.hashCode();
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory transitionFactory0) {
        return (BitmapTransitionOptions)this.transition(new BitmapTransitionFactory(transitionFactory0));
    }

    public static BitmapTransitionOptions with(TransitionFactory transitionFactory0) {
        return (BitmapTransitionOptions)new BitmapTransitionOptions().transition(transitionFactory0);
    }

    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withCrossFade(int v) {
        return new BitmapTransitionOptions().crossFade(v);
    }

    public static BitmapTransitionOptions withCrossFade(Builder drawableCrossFadeFactory$Builder0) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory$Builder0);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory0) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory0);
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory transitionFactory0) {
        return new BitmapTransitionOptions().transitionUsing(transitionFactory0);
    }
}

