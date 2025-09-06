package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.lifecycle.b;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l.a;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {
    public final ExecutorService a;
    public G b;
    public final Object c;
    public int d;
    public int e;
    public static final int f;

    public EnhancedIntentService() {
        NamedThreadFactory namedThreadFactory0 = new NamedThreadFactory("Firebase-Messaging-Intent-Handle");
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), namedThreadFactory0);
        threadPoolExecutor0.allowCoreThreadTimeOut(true);
        this.a = Executors.unconfigurableExecutorService(threadPoolExecutor0);
        this.c = new Object();
        this.e = 0;
    }

    public final void a(Intent intent0) {
        if(intent0 != null) {
            F.a(intent0);
        }
        synchronized(this.c) {
            int v1 = this.e - 1;
            this.e = v1;
            if(v1 == 0) {
                this.stopSelfResult(this.d);
            }
        }
    }

    public Intent b(Intent intent0) {
        return intent0;
    }

    public abstract void c(Intent arg1);

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        synchronized(this) {
            if(Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if(this.b == null) {
                this.b = new G(new b(this, 25));
            }
            return this.b;
        }
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        this.a.shutdown();
        super.onDestroy();
    }

    @Override  // android.app.Service
    public final int onStartCommand(Intent intent0, int v, int v1) {
        synchronized(this.c) {
            this.d = v1;
            ++this.e;
        }
        Intent intent1 = this.b(intent0);
        if(intent1 == null) {
            this.a(intent0);
            return 2;
        }
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        h h0 = new h(this, intent1, taskCompletionSource0);
        this.a.execute(h0);
        Task task0 = taskCompletionSource0.getTask();
        if(task0.isComplete()) {
            this.a(intent0);
            return 2;
        }
        task0.addOnCompleteListener(new a(1), new g(this, intent0));
        return 3;
    }
}

