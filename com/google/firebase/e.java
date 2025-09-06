package com.google.firebase;

import R6.d;
import Y6.c;
import Y6.h;
import Y6.o;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import androidx.collection.f;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import y7.b;

public final class e {
    public final Context a;
    public final String b;
    public final g c;
    public final h d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final o g;
    public final b h;
    public final CopyOnWriteArrayList i;
    public final CopyOnWriteArrayList j;
    public static final Object k;
    public static final f l;

    static {
        e.k = new Object();
        e.l = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public e(Context context0, String s, g g0) {
        List list0;
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean();
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.a = (Context)Preconditions.checkNotNull(context0);
        this.b = Preconditions.checkNotEmpty(s);
        this.c = (g)Preconditions.checkNotNull(g0);
        a a0 = FirebaseInitProvider.a;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        Class class0 = ComponentDiscoveryService.class;
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = null;
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            if(packageManager0 == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            }
            else {
                ServiceInfo serviceInfo0 = packageManager0.getServiceInfo(new ComponentName(context0, class0), 0x80);
                if(serviceInfo0 == null) {
                    Log.w("ComponentDiscovery", class0 + " has no service info.");
                }
                else {
                    bundle0 = serviceInfo0.metaData;
                }
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if(bundle0 == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            list0 = Collections.EMPTY_LIST;
        }
        else {
            list0 = new ArrayList();
            for(Object object0: bundle0.keySet()) {
                String s1 = (String)object0;
                if("com.google.firebase.components.ComponentRegistrar".equals(bundle0.get(s1)) && s1.startsWith("com.google.firebase.components:")) {
                    ((ArrayList)list0).add(s1.substring(0x1F));
                }
            }
        }
        for(Object object1: list0) {
            arrayList0.add(new Y6.e(((String)object1), 0));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList1.addAll(arrayList0);
        arrayList1.add(new Y6.e(new FirebaseCommonRegistrar(), 1));
        arrayList1.add(new Y6.e(new ExecutorsRegistrar(), 1));
        arrayList2.add(c.c(context0, Context.class, new Class[0]));
        arrayList2.add(c.c(this, e.class, new Class[0]));
        arrayList2.add(c.c(g0, g.class, new Class[0]));
        d d0 = new d(1);
        if(x1.a.H(context0) && FirebaseInitProvider.b.get()) {
            arrayList2.add(c.c(a0, a.class, new Class[0]));
        }
        h h0 = new h(arrayList1, arrayList2, d0);
        this.d = h0;
        Trace.endSection();
        this.g = new o(new Y6.g(1, this, context0));
        this.h = h0.b(w7.c.class);
        com.google.firebase.c c0 = new com.google.firebase.c(this);
        this.a();
        if(this.e.get()) {
            BackgroundDetector.getInstance().isInBackground();
        }
        this.i.add(c0);
        Trace.endSection();
    }

    public final void a() {
        Preconditions.checkState(!this.f.get(), "FirebaseApp was deleted");
    }

    public final Object b(Class class0) {
        this.a();
        return this.d.get(class0);
    }

    public static e c() {
        synchronized(e.k) {
            e e0 = (e)e.l.get("[DEFAULT]");
            if(e0 != null) {
                ((w7.c)e0.h.get()).b();
                return e0;
            }
        }
        throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
    }

    public final String d() {
        this.a();
        Charset charset0 = Charset.defaultCharset();
        this.a();
        Charset charset1 = Charset.defaultCharset();
        return Base64Utils.encodeUrlSafeNoPadding(this.b.getBytes(charset0)) + "+" + Base64Utils.encodeUrlSafeNoPadding(this.c.b.getBytes(charset1));
    }

    public final void e() {
        HashMap hashMap0;
        if(!x1.a.H(this.a)) {
            this.a();
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + this.b);
            Context context0 = this.a;
            AtomicReference atomicReference0 = FirebaseApp.UserUnlockReceiver.b;
            if(atomicReference0.get() == null) {
                FirebaseApp.UserUnlockReceiver firebaseApp$UserUnlockReceiver0 = new FirebaseApp.UserUnlockReceiver(context0);
                while(true) {
                    if(atomicReference0.compareAndSet(null, firebaseApp$UserUnlockReceiver0)) {
                        context0.registerReceiver(firebaseApp$UserUnlockReceiver0, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                        return;
                    }
                    if(atomicReference0.get() != null) {
                        break;
                    }
                }
            }
            return;
        }
        this.a();
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + this.b);
        h h0 = this.d;
        this.a();
        boolean z = "[DEFAULT]".equals(this.b);
        AtomicReference atomicReference1 = h0.f;
        Boolean boolean0 = Boolean.valueOf(z);
        do {
            if(atomicReference1.compareAndSet(null, boolean0)) {
                synchronized(h0) {
                    hashMap0 = new HashMap(h0.a);
                }
                h0.g(hashMap0, z);
                break;
            }
        }
        while(atomicReference1.get() == null);
        ((w7.c)this.h.get()).b();
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof e)) {
            return false;
        }
        ((e)object0).a();
        return this.b.equals(((e)object0).b);
    }

    public static e f(Context context0) {
        g g0;
        synchronized(e.k) {
            if(e.l.containsKey("[DEFAULT]")) {
                return e.c();
            }
            g0 = g.a(context0);
            if(g0 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
        }
        return e.g(context0, g0);
    }

    public static e g(Context context0, g g0) {
        e e0;
        if(context0.getApplicationContext() instanceof Application) {
            Application application0 = (Application)context0.getApplicationContext();
            AtomicReference atomicReference0 = com.google.firebase.d.a;
            if(atomicReference0.get() == null) {
                com.google.firebase.d d0 = new com.google.firebase.d();  // 初始化器: Ljava/lang/Object;-><init>()V
                while(true) {
                    if(atomicReference0.compareAndSet(null, d0)) {
                        BackgroundDetector.initialize(application0);
                        BackgroundDetector.getInstance().addListener(d0);
                        break;
                    }
                    if(atomicReference0.get() != null) {
                        break;
                    }
                }
            }
        }
        if(context0.getApplicationContext() != null) {
            context0 = context0.getApplicationContext();
        }
        synchronized(e.k) {
            Preconditions.checkState(!e.l.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            Preconditions.checkNotNull(context0, "Application context cannot be null.");
            e0 = new e(context0, "[DEFAULT]", g0);
            e.l.put("[DEFAULT]", e0);
        }
        e0.e();
        return e0;
    }

    public final boolean h() {
        this.a();
        D7.a a0 = (D7.a)this.g.get();
        synchronized(a0) {
        }
        return a0.a;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.b).add("options", this.c).toString();
    }
}

