package com.bumptech.glide.request.target;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget extends CustomTarget {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    @SuppressLint({"InlinedApi"})
    public NotificationTarget(Context context0, int v, int v1, int v2, RemoteViews remoteViews0, Notification notification0, int v3, String s) {
        super(v, v1);
        this.context = (Context)Preconditions.checkNotNull(context0, "Context must not be null!");
        this.notification = (Notification)Preconditions.checkNotNull(notification0, "Notification object can not be null!");
        this.remoteViews = (RemoteViews)Preconditions.checkNotNull(remoteViews0, "RemoteViews object can not be null!");
        this.viewId = v2;
        this.notificationId = v3;
        this.notificationTag = s;
    }

    @SuppressLint({"InlinedApi"})
    public NotificationTarget(Context context0, int v, RemoteViews remoteViews0, Notification notification0, int v1) {
        this(context0, v, remoteViews0, notification0, v1, null);
    }

    @SuppressLint({"InlinedApi"})
    public NotificationTarget(Context context0, int v, RemoteViews remoteViews0, Notification notification0, int v1, String s) {
        this(context0, 0x80000000, 0x80000000, v, remoteViews0, notification0, v1, s);
    }

    @Override  // com.bumptech.glide.request.target.Target
    @SuppressLint({"InlinedApi"})
    public void onLoadCleared(Drawable drawable0) {
        this.setBitmap(null);
    }

    @SuppressLint({"InlinedApi"})
    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
        this.setBitmap(bitmap0);
    }

    @Override  // com.bumptech.glide.request.target.Target
    @SuppressLint({"InlinedApi"})
    public void onResourceReady(Object object0, Transition transition0) {
        this.onResourceReady(((Bitmap)object0), transition0);
    }

    @SuppressLint({"InlinedApi"})
    private void setBitmap(Bitmap bitmap0) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap0);
        this.update();
    }

    @SuppressLint({"InlinedApi"})
    private void update() {
        ((NotificationManager)Preconditions.checkNotNull(((NotificationManager)this.context.getSystemService("notification")))).notify(this.notificationTag, this.notificationId, this.notification);
    }
}

