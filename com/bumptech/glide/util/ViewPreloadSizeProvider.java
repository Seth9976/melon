package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader.PreloadSizeProvider;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

public class ViewPreloadSizeProvider implements PreloadSizeProvider, SizeReadyCallback {
    static final class SizeViewTarget extends CustomViewTarget {
        public SizeViewTarget(View view0) {
            super(view0);
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object object0, Transition transition0) {
        }
    }

    private int[] size;
    private SizeViewTarget viewTarget;

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(View view0) {
        SizeViewTarget viewPreloadSizeProvider$SizeViewTarget0 = new SizeViewTarget(view0);
        this.viewTarget = viewPreloadSizeProvider$SizeViewTarget0;
        viewPreloadSizeProvider$SizeViewTarget0.getSize(this);
    }

    @Override  // com.bumptech.glide.ListPreloader$PreloadSizeProvider
    public int[] getPreloadSize(Object object0, int v, int v1) {
        return this.size == null ? null : Arrays.copyOf(this.size, this.size.length);
    }

    @Override  // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int v, int v1) {
        this.size = new int[]{v, v1};
        this.viewTarget = null;
    }

    public void setView(View view0) {
        if(this.size == null && this.viewTarget == null) {
            SizeViewTarget viewPreloadSizeProvider$SizeViewTarget0 = new SizeViewTarget(view0);
            this.viewTarget = viewPreloadSizeProvider$SizeViewTarget0;
            viewPreloadSizeProvider$SizeViewTarget0.getSize(this);
        }
    }
}

