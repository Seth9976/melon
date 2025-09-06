package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AspectRatioFrameLayout extends FrameLayout {
    public interface AspectRatioListener {
        void onAspectRatioUpdated(float arg1, float arg2, boolean arg3);
    }

    final class AspectRatioUpdateDispatcher implements Runnable {
        private boolean aspectRatioMismatch;
        private boolean isScheduled;
        private float naturalAspectRatio;
        private float targetAspectRatio;

        private AspectRatioUpdateDispatcher() {
        }

        public AspectRatioUpdateDispatcher(com.google.android.exoplayer2.ui.AspectRatioFrameLayout.1 aspectRatioFrameLayout$10) {
        }

        @Override
        public void run() {
            this.isScheduled = false;
            if(AspectRatioFrameLayout.this.aspectRatioListener == null) {
                return;
            }
            AspectRatioFrameLayout.this.aspectRatioListener.onAspectRatioUpdated(this.targetAspectRatio, this.naturalAspectRatio, this.aspectRatioMismatch);
        }

        public void scheduleUpdate(float f, float f1, boolean z) {
            this.targetAspectRatio = f;
            this.naturalAspectRatio = f1;
            this.aspectRatioMismatch = z;
            if(!this.isScheduled) {
                this.isScheduled = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    private static final float MAX_ASPECT_RATIO_DEFORMATION_FRACTION = 0.01f;
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;
    private AspectRatioListener aspectRatioListener;
    private final AspectRatioUpdateDispatcher aspectRatioUpdateDispatcher;
    private int resizeMode;
    private float videoAspectRatio;

    public AspectRatioFrameLayout(Context context0) {
        this(context0, null);
    }

    public AspectRatioFrameLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.resizeMode = 0;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.resizeMode = typedArray0.getInt(styleable.AspectRatioFrameLayout_resize_mode, 0);
            }
            finally {
                typedArray0.recycle();
            }
        }
        this.aspectRatioUpdateDispatcher = new AspectRatioUpdateDispatcher(this, null);
    }

    public int getResizeMode() {
        return this.resizeMode;
    }

    @Override  // android.widget.FrameLayout
    public void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.videoAspectRatio <= 0.0f) {
            return;
        }
        int v2 = this.getMeasuredWidth();
        int v3 = this.getMeasuredHeight();
        float f = ((float)v2) / ((float)v3);
        float f1 = this.videoAspectRatio / f - 1.0f;
        if(Math.abs(f1) <= 0.01f) {
            this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f, false);
            return;
        }
        switch(this.resizeMode) {
            case 0: {
                if(f1 > 0.0f) {
                    v3 = (int)(((float)v2) / this.videoAspectRatio);
                }
                else {
                    v2 = (int)(((float)v3) * this.videoAspectRatio);
                }
                break;
            }
            case 1: {
                v3 = (int)(((float)v2) / this.videoAspectRatio);
                break;
            }
            case 2: {
                v2 = (int)(((float)v3) * this.videoAspectRatio);
                break;
            }
            case 4: {
                if(f1 > 0.0f) {
                    v2 = (int)(((float)v3) * this.videoAspectRatio);
                }
                else {
                    v3 = (int)(((float)v2) / this.videoAspectRatio);
                }
            }
        }
        this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(v2, 0x40000000), View.MeasureSpec.makeMeasureSpec(v3, 0x40000000));
    }

    public void setAspectRatio(float f) {
        if(this.videoAspectRatio != f) {
            this.videoAspectRatio = f;
            this.requestLayout();
        }
    }

    public void setAspectRatioListener(AspectRatioListener aspectRatioFrameLayout$AspectRatioListener0) {
        this.aspectRatioListener = aspectRatioFrameLayout$AspectRatioListener0;
    }

    public void setResizeMode(int v) {
        if(this.resizeMode != v) {
            this.resizeMode = v;
            this.requestLayout();
        }
    }

    class com.google.android.exoplayer2.ui.AspectRatioFrameLayout.1 {
    }

}

