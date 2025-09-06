package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R.id;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class CustomViewTarget implements Target {
    static final class SizeDeterminer {
        static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference sizeDeterminerRef;

            public SizeDeterminerLayoutListener(SizeDeterminer customViewTarget$SizeDeterminer0) {
                this.sizeDeterminerRef = new WeakReference(customViewTarget$SizeDeterminer0);
            }

            @Override  // android.view.ViewTreeObserver$OnPreDrawListener
            public boolean onPreDraw() {
                if(Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer customViewTarget$SizeDeterminer0 = (SizeDeterminer)this.sizeDeterminerRef.get();
                if(customViewTarget$SizeDeterminer0 != null) {
                    customViewTarget$SizeDeterminer0.checkCurrentDimens();
                }
                return true;
            }
        }

        private static final int PENDING_SIZE;
        private final List cbs;
        private SizeDeterminerLayoutListener layoutListener;
        static Integer maxDisplayLength;
        private final View view;
        boolean waitForLayout;

        public SizeDeterminer(View view0) {
            this.cbs = new ArrayList();
            this.view = view0;
        }

        public void checkCurrentDimens() {
            if(!this.cbs.isEmpty()) {
                int v = this.getTargetWidth();
                int v1 = this.getTargetHeight();
                if(this.isViewStateAndSizeValid(v, v1)) {
                    this.notifyCbs(v, v1);
                    this.clearCallbacksAndListener();
                }
            }
        }

        public void clearCallbacksAndListener() {
            ViewTreeObserver viewTreeObserver0 = this.view.getViewTreeObserver();
            if(viewTreeObserver0.isAlive()) {
                viewTreeObserver0.removeOnPreDrawListener(this.layoutListener);
            }
            this.layoutListener = null;
            this.cbs.clear();
        }

        private static int getMaxDisplayLength(Context context0) {
            if(SizeDeterminer.maxDisplayLength == null) {
                Display display0 = ((WindowManager)Preconditions.checkNotNull(((WindowManager)context0.getSystemService("window")))).getDefaultDisplay();
                Point point0 = new Point();
                display0.getSize(point0);
                SizeDeterminer.maxDisplayLength = Math.max(point0.x, point0.y);
            }
            return (int)SizeDeterminer.maxDisplayLength;
        }

        public void getSize(SizeReadyCallback sizeReadyCallback0) {
            int v = this.getTargetWidth();
            int v1 = this.getTargetHeight();
            if(this.isViewStateAndSizeValid(v, v1)) {
                sizeReadyCallback0.onSizeReady(v, v1);
                return;
            }
            if(!this.cbs.contains(sizeReadyCallback0)) {
                this.cbs.add(sizeReadyCallback0);
            }
            if(this.layoutListener == null) {
                ViewTreeObserver viewTreeObserver0 = this.view.getViewTreeObserver();
                SizeDeterminerLayoutListener customViewTarget$SizeDeterminer$SizeDeterminerLayoutListener0 = new SizeDeterminerLayoutListener(this);
                this.layoutListener = customViewTarget$SizeDeterminer$SizeDeterminerLayoutListener0;
                viewTreeObserver0.addOnPreDrawListener(customViewTarget$SizeDeterminer$SizeDeterminerLayoutListener0);
            }
        }

        private int getTargetDimen(int v, int v1, int v2) {
            int v3 = v1 - v2;
            if(v3 > 0) {
                return v3;
            }
            if(this.waitForLayout && this.view.isLayoutRequested()) {
                return 0;
            }
            int v4 = v - v2;
            if(v4 > 0) {
                return v4;
            }
            if(!this.view.isLayoutRequested() && v1 == -2) {
                if(Log.isLoggable("CustomViewTarget", 4)) {
                    Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device\'s screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return SizeDeterminer.getMaxDisplayLength(this.view.getContext());
            }
            return 0;
        }

        private int getTargetHeight() {
            int v = this.view.getPaddingTop();
            int v1 = this.view.getPaddingBottom();
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.view.getLayoutParams();
            if(viewGroup$LayoutParams0 != null) {
                int v2 = viewGroup$LayoutParams0.height;
                return this.getTargetDimen(this.view.getHeight(), v2, v1 + v);
            }
            return this.getTargetDimen(this.view.getHeight(), 0, v1 + v);
        }

        private int getTargetWidth() {
            int v = this.view.getPaddingLeft();
            int v1 = this.view.getPaddingRight();
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.view.getLayoutParams();
            if(viewGroup$LayoutParams0 != null) {
                int v2 = viewGroup$LayoutParams0.width;
                return this.getTargetDimen(this.view.getWidth(), v2, v1 + v);
            }
            return this.getTargetDimen(this.view.getWidth(), 0, v1 + v);
        }

        private boolean isDimensionValid(int v) {
            return v > 0 || v == 0x80000000;
        }

        // 去混淆评级： 低(20)
        private boolean isViewStateAndSizeValid(int v, int v1) {
            return this.isDimensionValid(v) && this.isDimensionValid(v1);
        }

        private void notifyCbs(int v, int v1) {
            for(Object object0: new ArrayList(this.cbs)) {
                ((SizeReadyCallback)object0).onSizeReady(v, v1);
            }
        }

        public void removeCallback(SizeReadyCallback sizeReadyCallback0) {
            this.cbs.remove(sizeReadyCallback0);
        }
    }

    private static final String TAG = "CustomViewTarget";
    private static final int VIEW_TAG_ID;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final SizeDeterminer sizeDeterminer;
    protected final View view;

    static {
        CustomViewTarget.VIEW_TAG_ID = id.glide_custom_view_target_tag;
    }

    public CustomViewTarget(View view0) {
        this.view = (View)Preconditions.checkNotNull(view0);
        this.sizeDeterminer = new SizeDeterminer(view0);
    }

    public final CustomViewTarget clearOnDetach() {
        if(this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new View.OnAttachStateChangeListener() {
            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view0) {
                CustomViewTarget.this.resumeMyRequest();
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view0) {
                CustomViewTarget.this.pauseMyRequest();
            }
        };
        this.maybeAddAttachStateListener();
        return this;
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        Object object0 = this.getTag();
        if(object0 != null) {
            if(!(object0 instanceof Request)) {
                throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
            }
            return (Request)object0;
        }
        return null;
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback0) {
        this.sizeDeterminer.getSize(sizeReadyCallback0);
    }

    private Object getTag() {
        return this.view.getTag(CustomViewTarget.VIEW_TAG_ID);
    }

    public final View getView() {
        return this.view;
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener view$OnAttachStateChangeListener0 = this.attachStateListener;
        if(view$OnAttachStateChangeListener0 != null && !this.isAttachStateListenerAdded) {
            this.view.addOnAttachStateChangeListener(view$OnAttachStateChangeListener0);
            this.isAttachStateListenerAdded = true;
        }
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener view$OnAttachStateChangeListener0 = this.attachStateListener;
        if(view$OnAttachStateChangeListener0 != null && this.isAttachStateListenerAdded) {
            this.view.removeOnAttachStateChangeListener(view$OnAttachStateChangeListener0);
            this.isAttachStateListenerAdded = false;
        }
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
        this.sizeDeterminer.clearCallbacksAndListener();
        this.onResourceCleared(drawable0);
        if(!this.isClearedByUs) {
            this.maybeRemoveAttachStateListener();
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(Drawable drawable0) {
        this.maybeAddAttachStateListener();
    }

    public abstract void onResourceCleared(Drawable arg1);

    public void onResourceLoading(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    public final void pauseMyRequest() {
        Request request0 = this.getRequest();
        if(request0 != null) {
            this.isClearedByUs = true;
            request0.clear();
            this.isClearedByUs = false;
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback sizeReadyCallback0) {
        this.sizeDeterminer.removeCallback(sizeReadyCallback0);
    }

    public final void resumeMyRequest() {
        Request request0 = this.getRequest();
        if(request0 != null && request0.isCleared()) {
            request0.begin();
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void setRequest(Request request0) {
        this.setTag(request0);
    }

    private void setTag(Object object0) {
        this.view.setTag(CustomViewTarget.VIEW_TAG_ID, object0);
    }

    @Override
    public String toString() {
        return "Target for: " + this.view;
    }

    @Deprecated
    public final CustomViewTarget useTagId(int v) {
        return this;
    }

    public final CustomViewTarget waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}

