package com.google.firebase.sessions;

import Gd.e;
import M7.c0;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService;", "Landroid/app/Service;", "<init>", "()V", "M7/c0", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SessionLifecycleService extends Service {
    public final HandlerThread a;
    public c0 b;
    public Messenger c;

    public SessionLifecycleService() {
        this.a = new HandlerThread("FirebaseSessions_HandlerThread");
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        if(intent0 == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent0.getAction());
        Messenger messenger0 = Build.VERSION.SDK_INT < 33 ? ((Messenger)intent0.getParcelableExtra("ClientCallbackMessenger")) : ((Messenger)e.r(intent0));
        if(messenger0 != null) {
            Message message0 = Message.obtain(null, 4, 0, 0);
            message0.replyTo = messenger0;
            c0 c00 = this.b;
            if(c00 != null) {
                c00.sendMessage(message0);
            }
        }
        return this.c == null ? null : this.c.getBinder();
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a.start();
        Looper looper0 = this.a.getLooper();
        q.f(looper0, "handlerThread.looper");
        this.b = new c0(looper0);
        this.c = new Messenger(this.b);
        Log.d("SessionLifecycleService", "Service created on process " + Process.myPid());
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.a.quit();
    }
}

