package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class AppWidgetTarget extends CustomTarget {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context0, int v, int v1, int v2, RemoteViews remoteViews0, ComponentName componentName0) {
        super(v, v1);
        this.context = (Context)Preconditions.checkNotNull(context0, "Context can not be null!");
        this.remoteViews = (RemoteViews)Preconditions.checkNotNull(remoteViews0, "RemoteViews object can not be null!");
        this.componentName = (ComponentName)Preconditions.checkNotNull(componentName0, "ComponentName can not be null!");
        this.viewId = v2;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context context0, int v, int v1, int v2, RemoteViews remoteViews0, int[] arr_v) {
        super(v, v1);
        if(arr_v.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.context = (Context)Preconditions.checkNotNull(context0, "Context can not be null!");
        this.remoteViews = (RemoteViews)Preconditions.checkNotNull(remoteViews0, "RemoteViews object can not be null!");
        this.widgetIds = (int[])Preconditions.checkNotNull(arr_v, "WidgetIds can not be null!");
        this.viewId = v2;
        this.componentName = null;
    }

    public AppWidgetTarget(Context context0, int v, RemoteViews remoteViews0, ComponentName componentName0) {
        this(context0, 0x80000000, 0x80000000, v, remoteViews0, componentName0);
    }

    public AppWidgetTarget(Context context0, int v, RemoteViews remoteViews0, int[] arr_v) {
        this(context0, 0x80000000, 0x80000000, v, remoteViews0, arr_v);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable0) {
        this.setBitmap(null);
    }

    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
        this.setBitmap(bitmap0);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object object0, Transition transition0) {
        this.onResourceReady(((Bitmap)object0), transition0);
    }

    private void setBitmap(Bitmap bitmap0) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap0);
        this.update();
    }

    private void update() {
        AppWidgetManager appWidgetManager0 = AppWidgetManager.getInstance(this.context);
        ComponentName componentName0 = this.componentName;
        if(componentName0 != null) {
            appWidgetManager0.updateAppWidget(componentName0, this.remoteViews);
            return;
        }
        appWidgetManager0.updateAppWidget(this.widgetIds, this.remoteViews);
    }
}

