package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable extends Drawable {
    static final class State extends Drawable.ConstantState {
        final int height;
        final int width;
        private final Drawable.ConstantState wrapped;

        public State(Drawable.ConstantState drawable$ConstantState0, int v, int v1) {
            this.wrapped = drawable$ConstantState0;
            this.width = v;
            this.height = v1;
        }

        public State(State fixedSizeDrawable$State0) {
            this(fixedSizeDrawable$State0.wrapped, fixedSizeDrawable$State0.width, fixedSizeDrawable$State0.height);
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable());
        }

        @Override  // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources0) {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable(resources0));
        }
    }

    private final RectF bounds;
    private final Matrix matrix;
    private boolean mutated;
    private State state;
    private Drawable wrapped;
    private final RectF wrappedRect;

    public FixedSizeDrawable(Drawable drawable0, int v, int v1) {
        this(new State(drawable0.getConstantState(), v, v1), drawable0);
    }

    public FixedSizeDrawable(State fixedSizeDrawable$State0, Drawable drawable0) {
        this.state = (State)Preconditions.checkNotNull(fixedSizeDrawable$State0);
        this.wrapped = (Drawable)Preconditions.checkNotNull(drawable0);
        drawable0.setBounds(0, 0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.wrappedRect = new RectF(0.0f, 0.0f, ((float)drawable0.getIntrinsicWidth()), ((float)drawable0.getIntrinsicHeight()));
        this.bounds = new RectF();
    }

    @Override  // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override  // android.graphics.drawable.Drawable
    public void draw(Canvas canvas0) {
        canvas0.save();
        canvas0.concat(this.matrix);
        this.wrapped.draw(canvas0);
        canvas0.restore();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.height;
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.width;
    }

    @Override  // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect0) {
        return this.wrapped.getPadding(rect0);
    }

    @Override  // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if(!this.mutated && super.mutate() == this) {
            this.wrapped = this.wrapped.mutate();
            this.state = new State(this.state);
            this.mutated = true;
        }
        return this;
    }

    @Override  // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable0, long v) {
        super.scheduleSelf(runnable0, v);
        this.wrapped.scheduleSelf(runnable0, v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setAlpha(int v) {
        this.wrapped.setAlpha(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setBounds(int v, int v1, int v2, int v3) {
        super.setBounds(v, v1, v2, v3);
        this.bounds.set(((float)v), ((float)v1), ((float)v2), ((float)v3));
        this.updateMatrix();
    }

    @Override  // android.graphics.drawable.Drawable
    public void setBounds(Rect rect0) {
        super.setBounds(rect0);
        this.bounds.set(rect0);
        this.updateMatrix();
    }

    @Override  // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int v) {
        this.wrapped.setChangingConfigurations(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(int v, PorterDuff.Mode porterDuff$Mode0) {
        this.wrapped.setColorFilter(v, porterDuff$Mode0);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter0) {
        this.wrapped.setColorFilter(colorFilter0);
    }

    @Override  // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.wrapped.setDither(z);
    }

    @Override  // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.wrapped.setFilterBitmap(z);
    }

    @Override  // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z1) {
        return this.wrapped.setVisible(z, z1);
    }

    @Override  // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable0) {
        super.unscheduleSelf(runnable0);
        this.wrapped.unscheduleSelf(runnable0);
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, Matrix.ScaleToFit.CENTER);
    }
}

