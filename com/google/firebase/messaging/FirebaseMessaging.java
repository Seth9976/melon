package com.google.firebase.messaging;

import A3.c;
import E9.u;
import U4.F;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.collection.f;
import androidx.compose.foundation.lazy.layout.Z;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.e;
import ea.a;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import y7.b;
import z7.d;

public class FirebaseMessaging {
    public final e a;
    public final Context b;
    public final u c;
    public final a d;
    public final c e;
    public final ScheduledThreadPoolExecutor f;
    public final ThreadPoolExecutor g;
    public final Z h;
    public boolean i;
    public static final long j;
    public static Store k;
    public static b l;
    public static ScheduledThreadPoolExecutor m;

    static {
        FirebaseMessaging.j = TimeUnit.HOURS.toSeconds(8L);
        FirebaseMessaging.l = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public FirebaseMessaging(e e0, b b0, b b1, d d0, b b2, v7.c c0) {
        e0.a();
        Context context0 = e0.a;
        Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
        z0.b = 0;
        z0.c = context0;
        e0.a();
        Rpc rpc0 = new Rpc(e0.a);
        u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        u0.a = e0;
        u0.b = z0;
        u0.c = rpc0;
        u0.d = b0;
        u0.e = b1;
        u0.f = d0;
        ExecutorService executorService0 = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-File-Io"));
        super();
        this.i = false;
        FirebaseMessaging.l = b2;
        this.a = e0;
        this.e = new c(this, c0);
        e0.a();
        Context context1 = e0.a;
        this.b = context1;
        k k0 = new k();
        this.h = z0;
        this.c = u0;
        this.d = new a(executorService0);
        this.f = scheduledThreadPoolExecutor0;
        this.g = threadPoolExecutor0;
        e0.a();
        if(context0 instanceof Application) {
            ((Application)context0).registerActivityLifecycleCallbacks(k0);
        }
        else {
            Log.w("FirebaseMessaging", "Context " + context0 + " was not an application, can\'t register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        scheduledThreadPoolExecutor0.execute(new m(this, 0));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor1 = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
        Tasks.call(scheduledThreadPoolExecutor1, new B(context1, scheduledThreadPoolExecutor1, this, z0, u0)).addOnSuccessListener(scheduledThreadPoolExecutor0, new o(this, 1));
        scheduledThreadPoolExecutor0.execute(new m(this, 1));
    }

    public final String a() {
        Task task0;
        w w0 = this.f();
        if(!this.i(w0)) {
            return w0.a;
        }
        String s = Z.i(this.a);
        a a0 = this.d;
        synchronized(a0) {
            task0 = (Task)((f)a0.b).get(s);
            if(task0 == null) {
                if(Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + s);
                }
                String s1 = Z.i(((e)this.c.a));
                Bundle bundle0 = new Bundle();
                Task task1 = this.c.H(s1, "*", bundle0);
                Task task2 = this.c.r(task1);
                p p0 = new p(this, s, w0);
                Task task3 = task2.onSuccessTask(this.g, p0);
                g g0 = new g(a0, s);
                task0 = task3.continueWithTask(((Executor)a0.a), g0);
                ((f)a0.b).put(s, task0);
            }
            else if(Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + s);
            }
        }
        try {
            return (String)Tasks.await(task0);
        }
        catch(ExecutionException | InterruptedException executionException0) {
            throw new IOException(executionException0);
        }
    }

    public static void b(Runnable runnable0, long v) {
        synchronized(FirebaseMessaging.class) {
            if(FirebaseMessaging.m == null) {
                FirebaseMessaging.m = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            FirebaseMessaging.m.schedule(runnable0, v, TimeUnit.SECONDS);
        }
    }

    public static FirebaseMessaging c() {
        synchronized(FirebaseMessaging.class) {
            return FirebaseMessaging.getInstance(e.c());
        }
    }

    public static Store d(Context context0) {
        synchronized(FirebaseMessaging.class) {
            if(FirebaseMessaging.k == null) {
                FirebaseMessaging.k = new Store(context0);
            }
            return FirebaseMessaging.k;
        }
    }

    public final Task e() {
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        n n0 = new n(this, taskCompletionSource0, 0);
        this.f.execute(n0);
        return taskCompletionSource0.getTask();
    }

    public final w f() {
        Store store0 = FirebaseMessaging.d(this.b);
        this.a.a();
        String s = "[DEFAULT]".equals(this.a.b) ? "" : this.a.d();
        String s1 = Z.i(this.a);
        synchronized(store0) {
            return w.b(store0.a.getString(s + "|T|" + s1 + "|*", null));
        }
    }

    public final boolean g() {
        Context context0 = this.b;
        F.K(context0);
        if(Binder.getCallingUid() == context0.getApplicationInfo().uid) {
            if("com.google.android.gms".equals(((NotificationManager)context0.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
                if(Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "GMS core is set for proxying");
                }
                return this.a.b(V6.b.class) != null || Q1.c.t() && FirebaseMessaging.l != null;
            }
            return false;
        }
        Log.e("FirebaseMessaging", "error retrieving notification delegate for package com.iloen.melon");
        return false;
    }

    @Keep
    public static FirebaseMessaging getInstance(e e0) {
        synchronized(FirebaseMessaging.class) {
            FirebaseMessaging firebaseMessaging0 = (FirebaseMessaging)e0.b(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging0, "Firebase Messaging component is not present");
            return firebaseMessaging0;
        }
    }

    public final void h(long v) {
        synchronized(this) {
            FirebaseMessaging.b(new y(this, Math.min(Math.max(30L, 2L * v), FirebaseMessaging.j)), v);
            this.i = true;
        }
    }

    public final boolean i(w w0) {
        if(w0 != null) {
            String s = this.h.h();
            return System.currentTimeMillis() > w0.c + w.d || !s.equals(w0.b);
        }
        return true;
    }
}

