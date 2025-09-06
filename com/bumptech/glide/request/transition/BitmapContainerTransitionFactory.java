package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.DataSource;

public abstract class BitmapContainerTransitionFactory implements TransitionFactory {
    final class BitmapGlideAnimation implements Transition {
        private final Transition transition;

        public BitmapGlideAnimation(Transition transition0) {
            this.transition = transition0;
        }

        @Override  // com.bumptech.glide.request.transition.Transition
        public boolean transition(Object object0, ViewAdapter transition$ViewAdapter0) {
            BitmapDrawable bitmapDrawable0 = new BitmapDrawable(transition$ViewAdapter0.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(object0));
            return this.transition.transition(bitmapDrawable0, transition$ViewAdapter0);
        }
    }

    private final TransitionFactory realFactory;

    public BitmapContainerTransitionFactory(TransitionFactory transitionFactory0) {
        this.realFactory = transitionFactory0;
    }

    @Override  // com.bumptech.glide.request.transition.TransitionFactory
    public Transition build(DataSource dataSource0, boolean z) {
        return new BitmapGlideAnimation(this, this.realFactory.build(dataSource0, z));
    }

    public abstract Bitmap getBitmap(Object arg1);
}

