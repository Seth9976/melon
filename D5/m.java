package d5;

import B3.F;
import B3.t;
import I7.n;
import I7.p;
import Me.i;
import X.k;
import Y3.j;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.app.o;
import androidx.appcompat.widget.O;
import androidx.appcompat.widget.x;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.b;
import androidx.media3.session.legacy.L;
import androidx.work.impl.WorkDatabase_Impl;
import b3.H;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.r;
import com.iloen.melon.custom.MelonImageView;
import h4.C;
import h4.G;
import j3.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.q;
import m0.c;
import o3.h;
import org.json.JSONArray;
import org.json.JSONException;
import r1.f;
import r6.g;
import wa.a;
import x5.l;
import z7.d;

public final class m implements t, C, g {
    public final int a;
    public Object b;
    public Object c;
    public Object d;

    public m(int v) {
        this.a = v;
        switch(v) {
            case 14: {
                super();
                this.b = new WeakHashMap();
                this.c = new WeakHashMap();
                this.d = new WeakHashMap();
                return;
            }
            case 17: {
                super();
                this.b = new AtomicReference(c.b);
                this.c = new Object();
                return;
            }
            case 18: {
                super();
                this.b = new HashSet();
                this.c = h.a;
                return;
            }
            default: {
                super();
                this.b = new HashMap();
                this.c = new HashMap();
                this.d = new HashMap();
            }
        }
    }

    public m(int v, Serializable serializable0, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = serializable0;
        this.d = object1;
        super();
    }

    public m(int v, boolean z) {
        this.a = v;
        super();
    }

    public m(t t0, j j0) {
        this.a = 7;
        super();
        this.b = t0;
        this.c = j0;
        this.d = new SparseArray();
    }

    public m(i i0, List list0, m m0) {
        this.a = 4;
        q.g(i0, "classifierDescriptor");
        q.g(list0, "arguments");
        super();
        this.b = i0;
        this.c = list0;
        this.d = m0;
    }

    public m(Context context0, TypedArray typedArray0) {
        this.a = 8;
        super();
        this.b = context0;
        this.c = typedArray0;
    }

    public m(AudioTrack audioTrack0, e e0) {
        this.a = 15;
        super();
        this.b = audioTrack0;
        this.c = e0;
        this.d = new j3.q(this);
        Handler handler0 = new Handler(Looper.myLooper());
        audioTrack0.addOnRoutingChangedListener(((j3.q)this.d), handler0);
    }

    public m(View view0) {
        this.a = 12;
        super();
        this.b = view0;
        k k0 = new k(this, 15);
        this.c = d3.g.P(ie.k.c, k0);
        this.d = new b(view0);
    }

    public m(WorkDatabase_Impl workDatabase_Impl0) {
        this.a = 0;
        super();
        this.b = workDatabase_Impl0;
        new d5.b(workDatabase_Impl0, false, 4);
        this.c = new d5.h(workDatabase_Impl0, 2);
        this.d = new d5.h(workDatabase_Impl0, 3);
    }

    public m(ExtendedFloatingActionButton extendedFloatingActionButton0, d5.c c0, r6.c c1) {
        this.a = 19;
        super();
        this.d = extendedFloatingActionButton0;
        this.b = c0;
        this.c = c1;
    }

    public m(com.google.firebase.e e0, d d0, I7.j j0, I7.d d1, Context context0, p p0, ScheduledExecutorService scheduledExecutorService0) {
        this.a = 3;
        super();
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        this.b = linkedHashSet0;
        this.c = new n(e0, d0, j0, d1, context0, linkedHashSet0, p0, scheduledExecutorService0);
        this.d = scheduledExecutorService0;
    }

    public m(FirebaseMessagingService firebaseMessagingService0, L l0, ExecutorService executorService0) {
        this.a = 10;
        super();
        this.b = executorService0;
        this.c = firebaseMessagingService0;
        this.d = l0;
    }

    public m(i5.n n0, l l0, x5.k k0) {
        T8.b b0;
        this.a = 20;
        super();
        this.b = n0;
        this.c = l0;
        int v = Build.VERSION.SDK_INT;
        if(x5.b.a) {
            b0 = new T8.b(false);
        }
        else if(v == 26 || v == 27) {
            b0 = new a(k0);
        }
        else {
            b0 = new T8.b(true);
        }
        this.d = b0;
    }

    public m(String s, int v) {
        this.a = v;
        if(v != 13) {
            super();
            v v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.c = v1;
            this.d = v1;
            this.b = s;
            return;
        }
        super();
        b3.n n0 = new b3.n();
        n0.m = H.l(s);
        this.b = new androidx.media3.common.b(n0);
    }

    public m(Socket socket0) {
        this.a = 16;
        super();
        this.d = socket0;
        this.b = new BufferedInputStream(socket0.getInputStream());
        this.c = new BufferedOutputStream(socket0.getOutputStream());
    }

    public m(jf.e e0, Re.b b0) {
        this.a = 6;
        super();
        this.b = e0;
        this.c = b0;
        this.d = new ConcurrentHashMap();
    }

    @Override  // h4.C
    public void a(e3.p p0) {
        long v3;
        long v2;
        e3.b.k(((e3.v)this.c));
        e3.v v0 = (e3.v)this.c;
        synchronized(v0) {
            long v1 = v0.c;
            v2 = v1 == 0x8000000000000001L ? v0.d() : v1 + v0.b;
        }
        synchronized(((e3.v)this.c)) {
            v3 = ((e3.v)this.c).b;
        }
        if(v2 != 0x8000000000000001L && v3 != 0x8000000000000001L) {
            androidx.media3.common.b b0 = (androidx.media3.common.b)this.b;
            if(v3 != b0.s) {
                b3.n n0 = b0.a();
                n0.r = v3;
                androidx.media3.common.b b1 = new androidx.media3.common.b(n0);
                this.b = b1;
                ((B3.L)this.d).b(b1);
            }
            int v4 = p0.a();
            ((B3.L)this.d).d(p0, v4, 0);
            ((B3.L)this.d).c(v2, 1, v4, 0, null);
        }
    }

    @Override  // h4.C
    public void b(e3.v v0, t t0, G g0) {
        this.c = v0;
        g0.c();
        g0.d();
        B3.L l0 = t0.track(g0.d, 5);
        this.d = l0;
        l0.b(((androidx.media3.common.b)this.b));
    }

    @Override  // r6.g
    public ViewGroup.LayoutParams c() {
        ExtendedFloatingActionButton extendedFloatingActionButton0 = (ExtendedFloatingActionButton)this.d;
        int v = extendedFloatingActionButton0.f0;
        int v1 = -2;
        if(v == 0) {
            v = -2;
        }
        int v2 = extendedFloatingActionButton0.g0;
        if(v2 != 0) {
            v1 = v2;
        }
        return new ViewGroup.LayoutParams(v, v1);
    }

    public B1.c d() {
        f f0 = (f)this.b;
        if(f0 != null) {
            return new B1.e(f0.a);
        }
        String s = (String)this.c;
        if(s != null) {
            return B1.i.k(s);
        }
        Log.e("CCL", "DimensionDescription: Null value & symbol for " + ((String)this.d) + ". Using WrapContent.");
        return B1.i.k("wrap");
    }

    public Q5.j e() {
        String s = ((String)this.b) == null ? " backendName" : "";
        if(((N5.d)this.d) == null) {
            s = s + " priority";
        }
        if(!s.isEmpty()) {
            throw new IllegalStateException("Missing required properties:" + s);
        }
        return new Q5.j(((String)this.b), ((byte[])this.c), ((N5.d)this.d));
    }

    @Override  // B3.t
    public void endTracks() {
        ((t)this.b).endTracks();
    }

    public void f(Object object0, ByteArrayOutputStream byteArrayOutputStream0) {
        HashMap hashMap0 = (HashMap)this.b;
        u7.f f0 = new u7.f(byteArrayOutputStream0, hashMap0, ((HashMap)this.c), ((r7.d)this.d));
        if(object0 == null) {
            return;
        }
        r7.d d0 = (r7.d)hashMap0.get(object0.getClass());
        if(d0 == null) {
            throw new r7.b("No encoder for " + object0.getClass());  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        d0.a(object0, f0);
    }

    public static t5.f g(t5.j j0, Throwable throwable0) {
        if(throwable0 instanceof t5.m) {
            j0.getClass();
            j0.D.getClass();
            j0.D.getClass();
            return new t5.f(null, j0, throwable0);
        }
        j0.D.getClass();
        return new t5.f(null, j0, throwable0);
    }

    @Override  // r6.g
    public int getHeight() {
        int v = ((ExtendedFloatingActionButton)this.d).g0;
        if(v == -1) {
            return ((d5.c)this.b).getHeight();
        }
        return v == -2 || v == 0 ? ((r6.c)this.c).b.getMeasuredHeight() : v;
    }

    @Override  // r6.g
    public int getPaddingEnd() {
        return ((ExtendedFloatingActionButton)this.d).V;
    }

    @Override  // r6.g
    public int getPaddingStart() {
        return ((ExtendedFloatingActionButton)this.d).T;
    }

    @Override  // r6.g
    public int getWidth() {
        int v = ((ExtendedFloatingActionButton)this.d).f0;
        if(v == -1) {
            return ((d5.c)this.b).getWidth();
        }
        return v == -2 || v == 0 ? ((r6.c)this.c).getWidth() : v;
    }

    public float h(B1.c c0) {
        HashMap hashMap0 = (HashMap)this.b;
        HashMap hashMap1 = (HashMap)this.c;
        if(c0 instanceof B1.i) {
            String s = ((B1.i)c0).d();
            if(hashMap1.containsKey(s)) {
                return ((C1.d)hashMap1.get(s)).value();
            }
            return hashMap0.containsKey(s) ? ((Integer)hashMap0.get(s)).floatValue() : 0.0f;
        }
        return c0 instanceof B1.e ? ((B1.e)c0).e() : 0.0f;
    }

    public Object i() {
        if(0x6D2D2L == m0.i.a) {
            return this.d;
        }
        m0.h h0 = (m0.h)((AtomicReference)this.b).get();
        int v = h0.a(0x6D2D2L);
        return v < 0 ? null : h0.c[v];
    }

    public ColorStateList j(int v) {
        TypedArray typedArray0 = (TypedArray)this.c;
        if(typedArray0.hasValue(v)) {
            int v1 = typedArray0.getResourceId(v, 0);
            if(v1 != 0) {
                ColorStateList colorStateList0 = P1.c.getColorStateList(((Context)this.b), v1);
                return colorStateList0 == null ? typedArray0.getColorStateList(v) : colorStateList0;
            }
        }
        return typedArray0.getColorStateList(v);
    }

    public Drawable k(int v) {
        TypedArray typedArray0 = (TypedArray)this.c;
        if(typedArray0.hasValue(v)) {
            int v1 = typedArray0.getResourceId(v, 0);
            return v1 == 0 ? typedArray0.getDrawable(v) : w.B(((Context)this.b), v1);
        }
        return typedArray0.getDrawable(v);
    }

    public Drawable l(int v) {
        if(((TypedArray)this.c).hasValue(v)) {
            int v1 = ((TypedArray)this.c).getResourceId(v, 0);
            if(v1 != 0) {
                x x0 = x.a();
                Context context0 = (Context)this.b;
                synchronized(x0) {
                    return x0.a.d(context0, v1, true);
                }
            }
        }
        return null;
    }

    public Typeface m(int v, int v1, O o0) {
        int v2 = ((TypedArray)this.c).getResourceId(v, 0);
        if(v2 != 0) {
            if(((TypedValue)this.d) == null) {
                this.d = new TypedValue();
            }
            Context context0 = (Context)this.b;
            TypedValue typedValue0 = (TypedValue)this.d;
            return context0.isRestricted() ? null : R1.j.b(context0, v2, typedValue0, v1, o0, true, false);
        }
        return null;
    }

    @Override  // B3.t
    public void n(F f0) {
        ((t)this.b).n(f0);
    }

    public boolean o() {
        IconCompat iconCompat0;
        int[] arr_v1;
        long[] arr_v;
        Long long0;
        Integer integer0;
        PendingIntent pendingIntent1;
        PendingIntent pendingIntent0;
        Intent intent0;
        Uri uri0;
        int v2;
        String s2;
        Bundle bundle0;
        ApplicationInfo applicationInfo0;
        r r0;
        if(((L)this.d).a("gcm.n.noui")) {
            return true;
        }
        FirebaseMessagingService firebaseMessagingService0 = (FirebaseMessagingService)this.c;
        if(!((KeyguardManager)firebaseMessagingService0.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            int v = Process.myPid();
            List list0 = ((ActivityManager)firebaseMessagingService0.getSystemService("activity")).getRunningAppProcesses();
            if(list0 != null) {
                for(Object object0: list0) {
                    ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = (ActivityManager.RunningAppProcessInfo)object0;
                    if(activityManager$RunningAppProcessInfo0.pid == v) {
                        if(activityManager$RunningAppProcessInfo0.importance != 100) {
                            break;
                        }
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        String s = ((L)this.d).e("gcm.n.image");
        if(TextUtils.isEmpty(s)) {
            r0 = null;
        }
        else {
            try {
                r0 = new r(new URL(s));
            }
            catch(MalformedURLException unused_ex) {
                o.A("Not downloading image, bad URL: ", s, "FirebaseMessaging");
                r0 = null;
            }
        }
        if(r0 != null) {
            ExecutorService executorService0 = (ExecutorService)this.b;
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            r0.b = executorService0.submit(new com.google.firebase.messaging.n(r0, taskCompletionSource0, 1));
            r0.c = taskCompletionSource0.getTask();
        }
        FirebaseMessagingService firebaseMessagingService1 = (FirebaseMessagingService)this.c;
        L l0 = (L)this.d;
        PackageManager packageManager0 = firebaseMessagingService1.getPackageManager();
        try {
            applicationInfo0 = packageManager0.getApplicationInfo("com.iloen.melon", 0x80);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Log.w("FirebaseMessaging", "Couldn\'t get own application info: " + packageManager$NameNotFoundException0);
            goto label_41;
        }
        if(applicationInfo0 == null) {
        label_41:
            bundle0 = Bundle.EMPTY;
        }
        else {
            bundle0 = applicationInfo0.metaData;
            if(bundle0 == null) {
                bundle0 = Bundle.EMPTY;
            }
        }
        String s1 = l0.e("gcm.n.android_channel_id");
        try {
            firebaseMessagingService1.getPackageManager().getApplicationInfo("com.iloen.melon", 0);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            s1 = null;
            goto label_66;
        }
        NotificationManager notificationManager0 = (NotificationManager)firebaseMessagingService1.getSystemService(NotificationManager.class);
        if(TextUtils.isEmpty(s1)) {
        label_51:
            s1 = bundle0.getString("com.google.firebase.messaging.default_notification_channel_id");
            if(TextUtils.isEmpty(s1)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            label_57:
                s1 = "fcm_fallback_notification_channel";
                if(notificationManager0.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                    int v1 = firebaseMessagingService1.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", "com.iloen.melon");
                    if(v1 == 0) {
                        Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                        s2 = "Misc";
                    }
                    else {
                        s2 = firebaseMessagingService1.getString(v1);
                    }
                    notificationManager0.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", s2, 3));
                }
            }
            else if(notificationManager0.getNotificationChannel(s1) == null) {
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                goto label_57;
            }
        }
        else if(notificationManager0.getNotificationChannel(s1) == null) {
            Log.w("FirebaseMessaging", "Notification Channel requested (" + s1 + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            goto label_51;
        }
    label_66:
        AtomicInteger atomicInteger0 = com.google.firebase.messaging.e.a;
        Resources resources0 = firebaseMessagingService1.getResources();
        PackageManager packageManager1 = firebaseMessagingService1.getPackageManager();
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(firebaseMessagingService1, s1);
        String s3 = l0.d("com.iloen.melon", resources0, "gcm.n.title");
        if(!TextUtils.isEmpty(s3)) {
            notificationCompat$Builder0.d(s3);
        }
        String s4 = l0.d("com.iloen.melon", resources0, "gcm.n.body");
        if(!TextUtils.isEmpty(s4)) {
            notificationCompat$Builder0.c(s4);
            N1.q q0 = new N1.q(0);
            q0.e = NotificationCompat.Builder.b(s4);
            notificationCompat$Builder0.g(q0);
        }
        String s5 = l0.e("gcm.n.icon");
        if(TextUtils.isEmpty(s5)) {
        label_86:
            int v3 = bundle0.getInt("com.google.firebase.messaging.default_notification_icon", 0);
            if(v3 == 0 || !com.google.firebase.messaging.e.a(resources0, v3)) {
                try {
                    v3 = packageManager1.getApplicationInfo("com.iloen.melon", 0).icon;
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException1) {
                    Log.w("FirebaseMessaging", "Couldn\'t get own application info: " + packageManager$NameNotFoundException1);
                }
            }
            v2 = v3 == 0 || !com.google.firebase.messaging.e.a(resources0, v3) ? 0x1080093 : v3;
        }
        else {
            v2 = resources0.getIdentifier(s5, "drawable", "com.iloen.melon");
            if(v2 == 0 || !com.google.firebase.messaging.e.a(resources0, v2)) {
                v2 = resources0.getIdentifier(s5, "mipmap", "com.iloen.melon");
                if(v2 == 0 || !com.google.firebase.messaging.e.a(resources0, v2)) {
                    Log.w("FirebaseMessaging", "Icon resource " + s5 + " not found. Notification will use default icon.");
                    goto label_86;
                }
            }
        }
        notificationCompat$Builder0.G.icon = v2;
        String s6 = l0.e("gcm.n.sound2");
        if(TextUtils.isEmpty(s6)) {
            s6 = l0.e("gcm.n.sound");
        }
        if(TextUtils.isEmpty(s6)) {
            uri0 = null;
        }
        else {
            uri0 = "default".equals(s6) || resources0.getIdentifier(s6, "raw", "com.iloen.melon") == 0 ? RingtoneManager.getDefaultUri(2) : Uri.parse(("android.resource://com.iloen.melon/raw/" + s6));
        }
        if(uri0 != null) {
            notificationCompat$Builder0.G.sound = uri0;
            notificationCompat$Builder0.G.audioStreamType = -1;
            notificationCompat$Builder0.G.audioAttributes = N1.r.a(N1.r.d(N1.r.c(N1.r.b(), 4), 5));
        }
        String s7 = l0.e("gcm.n.click_action");
        if(TextUtils.isEmpty(s7)) {
            String s8 = l0.e("gcm.n.link_android");
            if(TextUtils.isEmpty(s8)) {
                s8 = l0.e("gcm.n.link");
            }
            Uri uri1 = TextUtils.isEmpty(s8) ? null : Uri.parse(s8);
            if(uri1 == null) {
                intent0 = packageManager1.getLaunchIntentForPackage("com.iloen.melon");
                if(intent0 == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
            else {
                intent0 = new Intent("android.intent.action.VIEW");
                intent0.setPackage("com.iloen.melon");
                intent0.setData(uri1);
            }
        }
        else {
            intent0 = new Intent(s7);
            intent0.setPackage("com.iloen.melon");
            intent0.setFlags(0x10000000);
        }
        if(intent0 == null) {
            pendingIntent0 = null;
        }
        else {
            intent0.addFlags(0x4000000);
            Bundle bundle1 = new Bundle(l0.a);
            for(Object object1: l0.a.keySet()) {
                String s9 = (String)object1;
                if(s9.startsWith("google.c.") || s9.startsWith("gcm.n.") || s9.startsWith("gcm.notification.")) {
                    bundle1.remove(s9);
                }
            }
            intent0.putExtras(bundle1);
            if(l0.a("google.c.a.e")) {
                intent0.putExtra("gcm.n.analytics_data", l0.g());
            }
            pendingIntent0 = PendingIntent.getActivity(firebaseMessagingService1, atomicInteger0.incrementAndGet(), intent0, 0x44000000);
        }
        notificationCompat$Builder0.g = pendingIntent0;
        if(l0.a("google.c.a.e")) {
            Intent intent1 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(l0.g());
            pendingIntent1 = PendingIntent.getBroadcast(firebaseMessagingService1, atomicInteger0.incrementAndGet(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage("com.iloen.melon").putExtra("wrapped_intent", intent1), 0x44000000);
        }
        else {
            pendingIntent1 = null;
        }
        if(pendingIntent1 != null) {
            notificationCompat$Builder0.G.deleteIntent = pendingIntent1;
        }
        String s10 = l0.e("gcm.n.color");
        if(TextUtils.isEmpty(s10)) {
        label_152:
            int v4 = bundle0.getInt("com.google.firebase.messaging.default_notification_color", 0);
            if(v4 == 0) {
                integer0 = null;
            }
            else {
                try {
                    integer0 = P1.c.getColor(firebaseMessagingService1, v4);
                }
                catch(Resources.NotFoundException unused_ex) {
                    Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                    integer0 = null;
                }
            }
        }
        else {
            try {
                integer0 = Color.parseColor(s10);
            }
            catch(IllegalArgumentException unused_ex) {
                Log.w("FirebaseMessaging", "Color is invalid: " + s10 + ". Notification will use default color.");
                goto label_152;
            }
        }
        if(integer0 != null) {
            notificationCompat$Builder0.z = (int)integer0;
        }
        notificationCompat$Builder0.e(16, !l0.a("gcm.n.sticky"));
        notificationCompat$Builder0.u = l0.a("gcm.n.local_only");
        String s11 = l0.e("gcm.n.ticker");
        if(s11 != null) {
            notificationCompat$Builder0.h(s11);
        }
        Integer integer1 = l0.b("gcm.n.notification_priority");
        if(integer1 == null) {
            integer1 = null;
        }
        else if(((int)integer1) < -2 || ((int)integer1) > 2) {
            Log.w("FirebaseMessaging", "notificationPriority is invalid " + integer1 + ". Skipping setting notificationPriority.");
            integer1 = null;
        }
        if(integer1 != null) {
            notificationCompat$Builder0.j = (int)integer1;
        }
        Integer integer2 = l0.b("gcm.n.visibility");
        if(integer2 == null) {
            integer2 = null;
        }
        else if(((int)integer2) < -1 || ((int)integer2) > 1) {
            Log.w("NotificationParams", "visibility is invalid: " + integer2 + ". Skipping setting visibility.");
            integer2 = null;
        }
        if(integer2 != null) {
            notificationCompat$Builder0.A = (int)integer2;
        }
        Integer integer3 = l0.b("gcm.n.notification_count");
        if(integer3 == null) {
            integer3 = null;
        }
        else if(((int)integer3) < 0) {
            Log.w("FirebaseMessaging", "notificationCount is invalid: " + integer3 + ". Skipping setting notificationCount.");
            integer3 = null;
        }
        if(integer3 != null) {
            notificationCompat$Builder0.i = (int)integer3;
        }
        String s12 = l0.e("gcm.n.event_time");
        if(TextUtils.isEmpty(s12)) {
            long0 = null;
        }
        else {
            try {
                long0 = Long.parseLong(s12);
            }
            catch(NumberFormatException unused_ex) {
                Log.w("NotificationParams", "Couldn\'t parse value of event_time(" + s12 + ") into a long");
                long0 = null;
            }
        }
        if(long0 != null) {
            notificationCompat$Builder0.k = true;
            notificationCompat$Builder0.G.when = (long)long0;
        }
        JSONArray jSONArray0 = l0.c("gcm.n.vibrate_timings");
        if(jSONArray0 == null) {
            arr_v = null;
        }
        else {
            try {
                if(jSONArray0.length() > 1) {
                    int v5 = jSONArray0.length();
                    arr_v = new long[v5];
                    for(int v6 = 0; v6 < v5; ++v6) {
                        arr_v[v6] = jSONArray0.optLong(v6);
                    }
                }
                else {
                    goto label_215;
                }
            }
            catch(JSONException | NumberFormatException unused_ex) {
            label_215:
                Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + jSONArray0 + ". Skipping setting vibrateTimings.");
                arr_v = null;
            }
        }
        if(arr_v != null) {
            notificationCompat$Builder0.G.vibrate = arr_v;
        }
        JSONArray jSONArray1 = l0.c("gcm.n.light_settings");
        if(jSONArray1 != null) {
            try {
                arr_v1 = new int[3];
                if(jSONArray1.length() == 3) {
                    int v7 = Color.parseColor(jSONArray1.optString(0));
                    if(v7 == 0xFF000000) {
                        throw new IllegalArgumentException("Transparent color is invalid");
                    }
                    arr_v1[0] = v7;
                    arr_v1[1] = jSONArray1.optInt(1);
                    arr_v1[2] = jSONArray1.optInt(2);
                }
                else {
                    goto label_235;
                }
                goto label_239;
            }
            catch(JSONException unused_ex) {
                goto label_235;
            }
            catch(IllegalArgumentException illegalArgumentException0) {
            }
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArray1 + ". " + illegalArgumentException0.getMessage() + ". Skipping setting LightSettings");
            goto label_238;
        label_235:
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArray1 + ". Skipping setting LightSettings");
        }
    label_238:
        arr_v1 = null;
    label_239:
        if(arr_v1 != null) {
            int v8 = arr_v1[0];
            int v9 = arr_v1[1];
            notificationCompat$Builder0.G.ledARGB = v8;
            notificationCompat$Builder0.G.ledOnMS = v9;
            notificationCompat$Builder0.G.ledOffMS = arr_v1[2];
            notificationCompat$Builder0.G.flags = (v9 == 0 || arr_v1[2] == 0 ? 0 : 1) | -2 & notificationCompat$Builder0.G.flags;
        }
        boolean z = l0.a("gcm.n.default_sound");
        if(l0.a("gcm.n.default_vibrate_timings")) {
            z |= 2;
        }
        if(l0.a("gcm.n.default_light_settings")) {
            z |= 4;
        }
        Notification notification0 = notificationCompat$Builder0.G;
        notification0.defaults = z;
        if((z & 4) != 0) {
            notification0.flags |= 1;
        }
        String s13 = l0.e("gcm.n.tag");
        if(TextUtils.isEmpty(s13)) {
            s13 = "FCM-Notification:" + SystemClock.uptimeMillis();
        }
        if(r0 != null) {
            try {
                Bitmap bitmap0 = (Bitmap)Tasks.await(((Task)Preconditions.checkNotNull(r0.c)), 5L, TimeUnit.SECONDS);
                notificationCompat$Builder0.f(bitmap0);
                N1.p p0 = new N1.p();  // 初始化器: LN1/s;-><init>()V
                if(bitmap0 == null) {
                    iconCompat0 = null;
                }
                else {
                    iconCompat0 = new IconCompat(1);
                    iconCompat0.b = bitmap0;
                }
                p0.d = iconCompat0;
                p0.e = null;
                p0.f = true;
                notificationCompat$Builder0.g(p0);
            }
            catch(ExecutionException executionException0) {
                Log.w("FirebaseMessaging", "Failed to download image: " + executionException0.getCause());
            }
            catch(InterruptedException unused_ex) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                r0.close();
                Thread.currentThread().interrupt();
            }
            catch(TimeoutException unused_ex) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                r0.close();
            }
        }
        if(Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager)((FirebaseMessagingService)this.c).getSystemService("notification")).notify(s13, 0, notificationCompat$Builder0.a());
        return true;
    }

    public static boolean p(t5.j j0, Bitmap.Config bitmap$Config0) {
        if(bitmap$Config0 == Bitmap.Config.HARDWARE) {
            if(!j0.n) {
                return false;
            }
            v5.b b0 = j0.c;
            if(b0 instanceof v5.a) {
                MelonImageView melonImageView0 = ((v5.a)b0).b;
                return !melonImageView0.isAttachedToWindow() || melonImageView0.isHardwareAccelerated();
            }
        }
        return true;
    }

    public static m q(Context context0, AttributeSet attributeSet0, int[] arr_v) {
        return new m(context0, context0.obtainStyledAttributes(attributeSet0, arr_v));
    }

    public static m r(Context context0, AttributeSet attributeSet0, int[] arr_v, int v) {
        return new m(context0, context0.obtainStyledAttributes(attributeSet0, arr_v, v, 0));
    }

    public t5.o s(t5.j j0, u5.g g0) {
        Bitmap.Config bitmap$Config0 = (j0.i.isEmpty() || je.n.Q(x5.g.a, j0.f)) && (j0.f != Bitmap.Config.HARDWARE || m.p(j0, j0.f) && ((x5.i)this.d).d(g0)) ? j0.f : Bitmap.Config.ARGB_8888;
        u5.f f0 = g0.a.equals(u5.b.e) || g0.b.equals(u5.b.e) ? u5.f.b : j0.z;
        boolean z = j0.o && j0.i.isEmpty() && bitmap$Config0 != Bitmap.Config.ALPHA_8;
        boolean z1 = x5.e.a(j0);
        return new t5.o(j0.a, bitmap$Config0, null, g0, f0, z1, z, j0.p, null, j0.k, j0.l, j0.A, j0.q, j0.r, j0.s);
    }

    public void t() {
        ((TypedArray)this.c).recycle();
    }

    @Override
    public String toString() {
        if(this.a != 2) {
            return super.toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder(0x20);
        stringBuilder0.append(((String)this.b));
        stringBuilder0.append('{');
        v v0 = (v)((v)this.c).b;
        for(String s = ""; v0 != null; s = ", ") {
            Object object0 = v0.a;
            stringBuilder0.append(s);
            if(object0 == null || !object0.getClass().isArray()) {
                stringBuilder0.append(object0);
            }
            else {
                String s1 = Arrays.deepToString(new Object[]{object0});
                stringBuilder0.append(s1, 1, s1.length() - 1);
            }
            v0 = (v)v0.b;
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    @Override  // B3.t
    public B3.L track(int v, int v1) {
        SparseArray sparseArray0 = (SparseArray)this.d;
        t t0 = (t)this.b;
        if(v1 != 3) {
            return t0.track(v, v1);
        }
        B3.L l0 = (Y3.n)sparseArray0.get(v);
        if(l0 != null) {
            return l0;
        }
        B3.L l1 = new Y3.n(t0.track(v, 3), ((j)this.c));
        sparseArray0.put(v, l1);
        return l1;
    }

    public void u(MediaCodec mediaCodec0) {
        if(((HashSet)this.b).remove(mediaCodec0)) {
            LoudnessCodecController loudnessCodecController0 = (LoudnessCodecController)this.d;
            if(loudnessCodecController0 != null) {
                loudnessCodecController0.removeMediaCodec(mediaCodec0);
            }
        }
    }

    public void v(Object object0) {
        if(0x6D138L == m0.i.a) {
            this.d = object0;
            return;
        }
        synchronized(this.c) {
            m0.h h0 = (m0.h)((AtomicReference)this.b).get();
            int v1 = h0.a(0x6D138L);
            if(v1 < 0) {
                ((AtomicReference)this.b).set(h0.b(0x6D138L, object0));
                return;
            }
            h0.c[v1] = object0;
        }
    }

    public void w(String s) {
        if(s == null) {
            throw new NullPointerException("Null backendName");
        }
        this.b = s;
    }

    public t5.o x(t5.o o0) {
        boolean z;
        Bitmap.Config bitmap$Config0 = o0.b;
        t5.b b0 = o0.o;
        if(bitmap$Config0 != Bitmap.Config.HARDWARE || ((x5.i)this.d).b()) {
            z = false;
        }
        else {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
            z = true;
        }
        if(o0.o.a) {
            l l0 = (l)this.c;
            synchronized(l0) {
                l0.a();
            }
            if(!l0.e) {
                return new t5.o(o0.a, bitmap$Config0, o0.c, o0.d, o0.e, o0.f, o0.g, o0.h, o0.i, o0.j, o0.k, o0.l, o0.m, o0.n, t5.b.d);
            }
        }
        return z ? new t5.o(o0.a, bitmap$Config0, o0.c, o0.d, o0.e, o0.f, o0.g, o0.h, o0.i, o0.j, o0.k, o0.l, o0.m, o0.n, b0) : o0;
    }
}

