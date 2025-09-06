package c2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.RecoverableSecurityException;
import android.app.RemoteAction;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.RenderNode;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets;
import java.util.concurrent.Executor;

public abstract class n0 {
    public static RemoteAction b(RecoverableSecurityException recoverableSecurityException0) {
        return recoverableSecurityException0.getUserAction();
    }

    public static RenderNode f() {
        return new RenderNode("OffscreenLayer.main");
    }

    public static WindowInsets.Builder j() {
        return new WindowInsets.Builder();
    }

    public static WindowInsets.Builder k(WindowInsets windowInsets0) {
        return new WindowInsets.Builder(windowInsets0);
    }

    public static void o(NotificationManager notificationManager0) {
        notificationManager0.setNotificationDelegate("com.google.android.gms");
    }

    public static void p(Service service0, int v, Notification notification0) {
        service0.startForeground(v, notification0, 1);
    }

    public static void q(RenderNode renderNode0, Paint paint0) {
        renderNode0.setUseCompositingLayer(true, paint0);
    }

    public static void r(WindowInsets.Builder windowInsets$Builder0, Insets insets0) {
        windowInsets$Builder0.setStableInsets(insets0);
    }

    public static boolean v(Context context0, Intent intent0, ServiceConnection serviceConnection0, int v, Executor executor0) {
        return context0.bindService(intent0, v, executor0, serviceConnection0);
    }

    public static RenderNode x() {
        return new RenderNode("OffscreenLayer.shadow");
    }

    public static void y(NotificationManager notificationManager0) {
        notificationManager0.setNotificationDelegate(null);
    }

    public static void z(Service service0, int v, Notification notification0) {
        service0.startForeground(v, notification0, 0x800);
    }
}

