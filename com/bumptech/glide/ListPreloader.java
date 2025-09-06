package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader implements AbsListView.OnScrollListener {
    public interface PreloadModelProvider {
        List getPreloadItems(int arg1);

        RequestBuilder getPreloadRequestBuilder(Object arg1);
    }

    public interface PreloadSizeProvider {
        int[] getPreloadSize(Object arg1, int arg2, int arg3);
    }

    static final class PreloadTarget implements Target {
        int photoHeight;
        int photoWidth;
        private Request request;

        @Override  // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return this.request;
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback sizeReadyCallback0) {
            sizeReadyCallback0.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override  // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable0) {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object object0, Transition transition0) {
        }

        @Override  // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override  // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback sizeReadyCallback0) {
        }

        @Override  // com.bumptech.glide.request.target.Target
        public void setRequest(Request request0) {
            this.request = request0;
        }
    }

    static final class PreloadTargetQueue {
        final Queue queue;

        public PreloadTargetQueue(int v) {
            this.queue = Util.createQueue(v);
            for(int v1 = 0; v1 < v; ++v1) {
                PreloadTarget listPreloader$PreloadTarget0 = new PreloadTarget();
                this.queue.offer(listPreloader$PreloadTarget0);
            }
        }

        public PreloadTarget next(int v, int v1) {
            PreloadTarget listPreloader$PreloadTarget0 = (PreloadTarget)this.queue.poll();
            this.queue.offer(listPreloader$PreloadTarget0);
            listPreloader$PreloadTarget0.photoWidth = v;
            listPreloader$PreloadTarget0.photoHeight = v1;
            return listPreloader$PreloadTarget0;
        }
    }

    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider preloadDimensionProvider;
    private final PreloadModelProvider preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public ListPreloader(RequestManager requestManager0, PreloadModelProvider listPreloader$PreloadModelProvider0, PreloadSizeProvider listPreloader$PreloadSizeProvider0, int v) {
        this.lastFirstVisible = -1;
        this.isIncreasing = true;
        this.requestManager = requestManager0;
        this.preloadModelProvider = listPreloader$PreloadModelProvider0;
        this.preloadDimensionProvider = listPreloader$PreloadSizeProvider0;
        this.maxPreload = v;
        this.preloadTargetQueue = new PreloadTargetQueue(v + 1);
    }

    private void cancelAll() {
        for(int v = 0; v < this.preloadTargetQueue.queue.size(); ++v) {
            PreloadTarget listPreloader$PreloadTarget0 = this.preloadTargetQueue.next(0, 0);
            this.requestManager.clear(listPreloader$PreloadTarget0);
        }
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public void onScroll(AbsListView absListView0, int v, int v1, int v2) {
        if(this.totalItemCount == 0 && v2 == 0) {
            return;
        }
        this.totalItemCount = v2;
        int v3 = this.lastFirstVisible;
        if(v > v3) {
            this.preload(v1 + v, true);
        }
        else if(v < v3) {
            this.preload(v, false);
        }
        this.lastFirstVisible = v;
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public void onScrollStateChanged(AbsListView absListView0, int v) {
    }

    private void preload(int v, int v1) {
        int v3;
        int v2;
        if(v < v1) {
            v2 = Math.max(this.lastEnd, v);
            v3 = v1;
        }
        else {
            v3 = Math.min(this.lastStart, v);
            v2 = v1;
        }
        int v4 = Math.min(this.totalItemCount, v3);
        int v5 = Math.min(this.totalItemCount, Math.max(0, v2));
        if(v < v1) {
            for(int v6 = v5; v6 < v4; ++v6) {
                this.preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(v6), v6, true);
            }
        }
        else {
            for(int v7 = v4 - 1; v7 >= v5; --v7) {
                this.preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(v7), v7, false);
            }
        }
        this.lastStart = v5;
        this.lastEnd = v4;
    }

    private void preload(int v, boolean z) {
        if(this.isIncreasing != z) {
            this.isIncreasing = z;
            this.cancelAll();
        }
        this.preload(v, (z ? this.maxPreload : -this.maxPreload) + v);
    }

    private void preloadAdapterPosition(List list0, int v, boolean z) {
        int v1 = list0.size();
        if(z) {
            for(int v2 = 0; v2 < v1; ++v2) {
                this.preloadItem(list0.get(v2), v, v2);
            }
            return;
        }
        for(int v3 = v1 - 1; v3 >= 0; --v3) {
            this.preloadItem(list0.get(v3), v, v3);
        }
    }

    private void preloadItem(Object object0, int v, int v1) {
        if(object0 != null) {
            int[] arr_v = this.preloadDimensionProvider.getPreloadSize(object0, v, v1);
            if(arr_v != null) {
                RequestBuilder requestBuilder0 = this.preloadModelProvider.getPreloadRequestBuilder(object0);
                if(requestBuilder0 != null) {
                    requestBuilder0.into(this.preloadTargetQueue.next(arr_v[0], arr_v[1]));
                }
            }
        }
    }
}

