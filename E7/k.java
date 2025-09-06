package e7;

import A3.c;
import E5.b;
import E9.g;
import G1.f;
import H8.q;
import P0.d0;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonReader;
import android.util.Log;
import b7.a;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.internal.F;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import f7.d;
import g7.e;
import g7.n;
import h7.A;
import h7.B;
import h7.C;
import h7.D;
import h7.E;
import h7.I;
import h7.J;
import h7.K;
import h7.M;
import h7.N0;
import h7.O;
import h7.P;
import h7.Q;
import h7.S;
import h7.V;
import h7.Z;
import h7.a0;
import h7.i0;
import h7.k0;
import h7.l0;
import h7.m0;
import h7.n0;
import h7.o0;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicMarkableReference;
import jeb.synthetic.TWR;

public final class k {
    public final Context a;
    public final f b;
    public final g c;
    public final q d;
    public final d e;
    public final u f;
    public final FileStore g;
    public final d0 h;
    public final g7.f i;
    public final a j;
    public final c7.a k;
    public final h l;
    public final q m;
    public e7.q n;
    public final TaskCompletionSource o;
    public final TaskCompletionSource p;
    public final TaskCompletionSource q;
    public static final b r;
    public static final Charset s;

    static {
        k.r = new b(5);
        k.s = Charset.forName("UTF-8");
    }

    public k(Context context0, u u0, f f0, FileStore fileStore0, g g0, d0 d00, q q0, g7.f f1, q q1, a a0, c7.a a1, h h0, d d0) {
        this.o = new TaskCompletionSource();
        this.p = new TaskCompletionSource();
        this.q = new TaskCompletionSource();
        new AtomicBoolean(false);
        this.a = context0;
        this.f = u0;
        this.b = f0;
        this.g = fileStore0;
        this.c = g0;
        this.h = d00;
        this.d = q0;
        this.i = f1;
        this.j = a0;
        this.k = a1;
        this.l = h0;
        this.m = q1;
        this.e = d0;
    }

    public static Task a(k k0) {
        Task task0;
        k0.getClass();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: FileStore.e(k0.g.c.listFiles(k.r))) {
            File file0 = (File)object0;
            try {
                long v = Long.parseLong(file0.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                }
                catch(ClassNotFoundException unused_ex) {
                    if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Logging app exception event to Firebase Analytics", null);
                    }
                    task0 = Tasks.call(new ScheduledThreadPoolExecutor(1), new j(k0, v));
                    goto label_15;
                }
                Log.w("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists", null);
                task0 = Tasks.forResult(null);
            label_15:
                arrayList0.add(task0);
            }
            catch(NumberFormatException unused_ex) {
                Log.w("FirebaseCrashlytics", "Could not parse app exception timestamp from file " + file0.getName(), null);
            }
            file0.delete();
        }
        return Tasks.whenAll(arrayList0);
    }

    public final void b(boolean z, A1.g g0, boolean z1) {
        String s15;
        boolean z4;
        Throwable throwable3;
        P p2;
        JsonReader jsonReader0;
        String s7;
        List list2;
        String s1;
        ApplicationExitInfo applicationExitInfo0;
        List list1;
        FileInputStream fileInputStream0;
        a a0 = this.j;
        d.a();
        q q0 = this.m;
        ArrayList arrayList0 = new ArrayList(((k7.a)q0.b).c());
        if(arrayList0.size() > z) {
            String s = (String)arrayList0.get(((int)z));
            if(z1 && g0.d().b.b) {
                FileStore fileStore0 = this.g;
                int v = Build.VERSION.SDK_INT;
                if(v >= 30) {
                    List list0 = F.p(((ActivityManager)this.a.getSystemService("activity")));
                    if(list0.size() != 0) {
                        g7.f f0 = new g7.f(fileStore0);
                        f0.b = g7.f.c;
                        if(s != null) {
                            f0.b = new n(fileStore0.b(s, "userlog"));
                        }
                        g7.h h0 = new g7.h(fileStore0);
                        q q1 = new q(s, fileStore0, this.e);
                        ((e)((AtomicMarkableReference)((c)q1.d).b).getReference()).c(h0.c(s, false));
                        ((e)((AtomicMarkableReference)((c)q1.e).b).getReference()).c(h0.c(s, true));
                        ((AtomicMarkableReference)q1.g).set(h0.d(s), false);
                        T3.e e0 = (T3.e)q1.f;
                        File file0 = fileStore0.b(s, "rollouts-state");
                        if(!file0.exists() || file0.length() == 0L) {
                            g7.h.g(file0, "The file has a length of zero for session: " + s);
                            list1 = Collections.EMPTY_LIST;
                        }
                        else {
                            try {
                                fileInputStream0 = null;
                                fileInputStream0 = new FileInputStream(file0);
                                goto label_33;
                            }
                            catch(Exception exception0) {
                                goto label_38;
                            }
                            catch(Throwable throwable0) {
                            }
                            Closeable closeable0 = null;
                            e7.f.b(closeable0, "Failed to close rollouts state file.");
                            throw throwable0;
                            try {
                                try {
                                label_33:
                                    list1 = g7.h.b(e7.f.i(fileInputStream0));
                                    if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                                        Log.d("FirebaseCrashlytics", "Loaded rollouts state:\n" + list1 + "\nfor session " + s, null);
                                    }
                                    goto label_47;
                                }
                                catch(Exception exception0) {
                                }
                            label_38:
                                Log.w("FirebaseCrashlytics", "Error deserializing rollouts state.", exception0);
                                g7.h.f(file0);
                            }
                            catch(Throwable throwable0) {
                                closeable0 = fileInputStream0;
                                e7.f.b(closeable0, "Failed to close rollouts state file.");
                                throw throwable0;
                            }
                            e7.f.b(fileInputStream0, "Failed to close rollouts state file.");
                            list1 = Collections.EMPTY_LIST;
                            goto label_51;
                        label_47:
                            e7.f.b(fileInputStream0, "Failed to close rollouts state file.");
                        }
                    label_51:
                        e0.k(list1);
                        k7.a a1 = (k7.a)q0.b;
                        long v1 = a1.b.b(s, "start-time").lastModified();
                        for(Object object0: list0) {
                            applicationExitInfo0 = (ApplicationExitInfo)object0;
                            if(applicationExitInfo0.getTimestamp() < v1) {
                                break;
                            }
                            if(applicationExitInfo0.getReason() != 6) {
                                continue;
                            }
                            goto label_62;
                        }
                        applicationExitInfo0 = null;
                    label_62:
                        if(applicationExitInfo0 != null) {
                            p p0 = (p)q0.a;
                            try {
                                InputStream inputStream0 = applicationExitInfo0.getTraceInputStream();
                                if(inputStream0 == null) {
                                    goto label_75;
                                }
                                else {
                                    s1 = q.e(inputStream0);
                                }
                            }
                            catch(IOException iOException0) {
                                Log.w("FirebaseCrashlytics", "Could not get input trace in application exit info: " + applicationExitInfo0.toString() + " Error: " + iOException0, null);
                                s1 = null;
                            }
                            goto label_76;
                        label_75:
                            s1 = null;
                        label_76:
                            C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                            c0.d = applicationExitInfo0.getImportance();
                            c0.j = (byte)(c0.j | 4);
                            String s2 = applicationExitInfo0.getProcessName();
                            if(s2 == null) {
                                throw new NullPointerException("Null processName");
                            }
                            c0.b = s2;
                            c0.c = applicationExitInfo0.getReason();
                            c0.j = (byte)(c0.j | 2);
                            c0.g = applicationExitInfo0.getTimestamp();
                            c0.j = (byte)(c0.j | 0x20);
                            c0.a = applicationExitInfo0.getPid();
                            c0.j = (byte)(c0.j | 1);
                            c0.e = applicationExitInfo0.getPss();
                            c0.j = (byte)(c0.j | 8);
                            c0.f = applicationExitInfo0.getRss();
                            c0.j = (byte)(c0.j | 16);
                            c0.h = s1;
                            D d0 = c0.a();
                            int v2 = p0.a.getResources().getConfiguration().orientation;
                            O o0 = new O();  // 初始化器: Ljava/lang/Object;-><init>()V
                            o0.b = "anr";
                            long v3 = d0.g;
                            o0.a = v3;
                            o0.g = (byte)(o0.g | 1);
                            d0 d00 = p0.c;
                            if(!p0.e.d().b.c || ((ArrayList)d00.d).size() <= 0) {
                                list2 = null;
                            }
                            else {
                                ArrayList arrayList1 = new ArrayList();
                                for(Object object1: ((ArrayList)d00.d)) {
                                    String s3 = ((e7.c)object1).a;
                                    if(s3 == null) {
                                        throw new NullPointerException("Null libraryName");
                                    }
                                    String s4 = ((e7.c)object1).b;
                                    if(s4 == null) {
                                        throw new NullPointerException("Null arch");
                                    }
                                    String s5 = ((e7.c)object1).c;
                                    if(s5 == null) {
                                        throw new NullPointerException("Null buildId");
                                    }
                                    arrayList1.add(new E(s4, s3, s5));
                                }
                                list2 = Collections.unmodifiableList(arrayList1);
                            }
                            C c1 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                            c1.d = d0.d;
                            byte b = (byte)(c1.j | 4);
                            c1.j = b;
                            String s6 = d0.b;
                            if(s6 == null) {
                                throw new NullPointerException("Null processName");
                            }
                            c1.b = s6;
                            c1.c = d0.c;
                            c1.g = v3;
                            c1.a = d0.a;
                            c1.e = d0.e;
                            c1.f = d0.f;
                            c1.j = (byte)(((byte)(((byte)(((byte)(((byte)(b | 2)) | 0x20)) | 1)) | 8)) | 16);
                            c1.h = d0.h;
                            c1.i = list2;
                            D d1 = c1.a();
                            Boolean boolean0 = Boolean.valueOf(d1.d != 100);
                            kotlin.jvm.internal.q.g(d1.b, "processName");
                            Z z2 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
                            z2.a = d1.b;
                            z2.b = d1.a;
                            z2.c = d1.d;
                            z2.d = false;
                            z2.e = (byte)(((byte)(((byte)(z2.e | 1)) | 2)) | 4);
                            a0 a00 = z2.a();
                            V v4 = p.e();
                            List list3 = p0.a();
                            if(list3 == null) {
                                throw new NullPointerException("Null binaries");
                            }
                            o0.c = new Q(new S(null, null, d1, v4, list3), null, null, boolean0, a00, null, v2);
                            o0.d = p0.b(v2);
                            P p1 = o0.a();
                            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                                Log.d("FirebaseCrashlytics", "Persisting anr for session " + s, null);
                            }
                            a1.d(q.d(q.a(p1, f0, q1, Collections.EMPTY_MAP), q1), s, true);
                        }
                        else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                            Log.v("FirebaseCrashlytics", "No relevant ApplicationExitInfo occurred during session: " + s, null);
                        }
                    }
                    else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "No ApplicationExitInfo available. Session: " + s, null);
                    }
                }
                else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "ANR feature enabled, but device is API " + v, null);
                }
            }
            else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "ANR feature disabled.", null);
            }
            if(z1 && a0.c(s)) {
                if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Finalizing native report for session " + s, null);
                }
                a0.a(s).getClass();
                Log.w("FirebaseCrashlytics", "No minidump data found for session " + s, null);
                Log.i("FirebaseCrashlytics", "No Tombstones data found for session " + s, null);
                Log.w("FirebaseCrashlytics", "No native core present", null);
            }
            if(z) {
                s7 = (String)arrayList0.get(0);
            }
            else {
                this.l.a(null);
                s7 = null;
            }
            long v5 = System.currentTimeMillis();
            k7.a a2 = (k7.a)q0.b;
            FileStore fileStore1 = a2.b;
            fileStore1.a(".com.google.firebase.crashlytics");
            fileStore1.a(".com.google.firebase.crashlytics-ndk");
            if(!fileStore1.a.isEmpty()) {
                fileStore1.a(".com.google.firebase.crashlytics.files.v1");
                File file1 = fileStore1.b;
                if(file1.exists()) {
                    String[] arr_s = file1.list(new k7.b(".com.google.firebase.crashlytics.files.v2;"));
                    if(arr_s != null) {
                        for(int v6 = 0; v6 < arr_s.length; ++v6) {
                            fileStore1.a(arr_s[v6]);
                        }
                    }
                }
            }
            NavigableSet navigableSet0 = a2.c();
            if(s7 != null) {
                navigableSet0.remove(s7);
            }
            if(navigableSet0.size() > 8) {
                while(navigableSet0.size() > 8) {
                    String s8 = (String)navigableSet0.last();
                    String s9 = "Removing session over cap: " + s8;
                    if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", s9, null);
                    }
                    FileStore.d(new File(fileStore1.d, s8));
                    navigableSet0.remove(s8);
                }
            }
            for(Object object2: navigableSet0) {
                String s10 = (String)object2;
                String s11 = "Finalizing report for session " + s10;
                if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", s11, null);
                }
                i7.a a3 = k7.a.g;
                File file2 = new File(fileStore1.d, s10);
                file2.mkdirs();
                List list4 = FileStore.e(file2.listFiles(k7.a.i));
                if(!list4.isEmpty()) {
                    Collections.sort(list4);
                    ArrayList arrayList2 = new ArrayList();
                    boolean z3 = false;
                    for(Object object3: list4) {
                        File file3 = (File)object3;
                        try {
                            String s12 = k7.a.e(file3);
                            a3.getClass();
                            try {
                                jsonReader0 = new JsonReader(new StringReader(s12));
                            }
                            catch(IllegalStateException illegalStateException0) {
                                throw new IOException(illegalStateException0);
                            }
                        }
                        catch(IOException iOException1) {
                            Log.w("FirebaseCrashlytics", "Could not add event to report for " + file3, iOException1);
                            continue;
                        }
                        try {
                            p2 = i7.a.e(jsonReader0);
                            goto label_240;
                        }
                        catch(Throwable throwable1) {
                            try {
                                throwable3 = throwable1;
                                jsonReader0.close();
                                throw throwable3;
                            }
                            catch(Throwable throwable2) {
                                try {
                                    try {
                                        throwable3.addSuppressed(throwable2);
                                        throw throwable3;
                                    label_240:
                                        jsonReader0.close();
                                    }
                                    catch(IllegalStateException illegalStateException0) {
                                        throw new IOException(illegalStateException0);
                                    }
                                    arrayList2.add(p2);
                                    if(!z3) {
                                        String s13 = file3.getName();
                                        if(s13.startsWith("event")) {
                                            goto label_252;
                                        }
                                        else {
                                            goto label_255;
                                        }
                                    }
                                    goto label_257;
                                }
                                catch(IOException iOException1) {
                                }
                            }
                        }
                        Log.w("FirebaseCrashlytics", "Could not add event to report for " + file3, iOException1);
                        continue;
                    label_252:
                        if(s13.endsWith("_")) {
                        label_257:
                            z4 = true;
                        label_258:
                            z3 = z4;
                        }
                        else {
                            z4 = false;
                            goto label_258;
                        label_255:
                            z3 = false;
                        }
                    }
                    if(arrayList2.isEmpty()) {
                        Log.w("FirebaseCrashlytics", "Could not parse event files for session " + s10, null);
                    }
                    else {
                        String s14 = new g7.h(fileStore1).d(s10);
                        e7.g g1 = a2.d.b;
                        synchronized(g1) {
                            if(Objects.equals(g1.b, s10)) {
                                s15 = g1.c;
                            }
                            else {
                                File file4 = new File(g1.a.d, s10);
                                file4.mkdirs();
                                List list5 = FileStore.e(file4.listFiles(e7.g.d));
                                if(list5.isEmpty()) {
                                    Log.w("FirebaseCrashlytics", "Unable to read App Quality Sessions session id.", null);
                                    s15 = null;
                                }
                                else {
                                    s15 = ((File)Collections.min(list5, e7.g.e)).getName().substring(4);
                                }
                            }
                        }
                        File file5 = fileStore1.b(s10, "report");
                        try {
                            String s16 = k7.a.e(file5);
                            a3.getClass();
                            B b1 = i7.a.i(s16);
                            A a4 = b1.a();
                            N0 n00 = b1.k;
                            if(n00 != null) {
                                I i0 = n00.a();
                                i0.e = (long)(v5 / 1000L);
                                i0.f = z3;
                                i0.m = (byte)(i0.m | 2);
                                if(s14 != null) {
                                    i0.h = new k0(s14);
                                }
                                a4.j = i0.a();
                            }
                            B b2 = a4.a();
                            A a5 = b2.a();
                            a5.g = s15;
                            N0 n01 = b2.k;
                            if(n01 != null) {
                                I i1 = n01.a();
                                i1.c = s15;
                                a5.j = i1.a();
                            }
                            B b3 = a5.a();
                            N0 n02 = b3.k;
                            if(n02 == null) {
                                throw new IllegalStateException("Reports without sessions cannot have events added to them.");
                            }
                            A a6 = b3.a();
                            I i2 = n02.a();
                            i2.k = arrayList2;
                            a6.j = i2.a();
                            B b4 = a6.a();
                            N0 n03 = b4.k;
                            if(n03 != null) {
                                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                                    Log.d("FirebaseCrashlytics", "appQualitySessionId: " + s15, null);
                                }
                                k7.a.f((z3 ? new File(fileStore1.f, ((J)n03).b) : new File(fileStore1.e, ((J)n03).b)), i7.a.a.o(b4));
                            }
                        }
                        catch(IOException iOException2) {
                            Log.w("FirebaseCrashlytics", "Could not synthesize final report file for " + file5, iOException2);
                        }
                    }
                }
                else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Session " + s10 + " has no events.", null);
                }
                FileStore.d(new File(fileStore1.d, s10));
            }
            a2.c.d();
            ArrayList arrayList3 = a2.b();
            int v8 = arrayList3.size();
            if(v8 > 4) {
                for(Object object4: arrayList3.subList(4, v8)) {
                    ((File)object4).delete();
                }
            }
        }
        else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No open sessions to be closed.", null);
        }
    }

    public final void c(String s, Boolean boolean0) {
        String s13;
        String s12;
        String s11;
        String s10;
        Map map0;
        long v = System.currentTimeMillis();
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Opening a new session with ID " + s, null);
        }
        Locale locale0 = Locale.US;
        String s1 = (String)this.h.g;
        String s2 = (String)this.h.h;
        String s3 = this.f.c().a;
        m0 m00 = new m0(this.f.c, s1, s2, s3, com.iloen.melon.utils.a.b((((String)this.h.e) == null ? 1 : 4)), ((DevelopmentPlatformProvider)this.h.i));
        String s4 = Build.VERSION.RELEASE;
        String s5 = Build.VERSION.CODENAME;
        o0 o00 = new o0(e7.f.g());
        Context context0 = this.a;
        StatFs statFs0 = new StatFs(Environment.getDataDirectory().getPath());
        long v1 = ((long)statFs0.getBlockCount()) * ((long)statFs0.getBlockSize());
        e7.e e0 = e7.e.a;
        if(!TextUtils.isEmpty("arm64-v8a")) {
            e7.e e1 = (e7.e)e7.e.b.get("arm64-v8a".toLowerCase(locale0));
            if(e1 != null) {
                e0 = e1;
            }
        }
        else if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Architecture#getValue()::Build.CPU_ABI returned null or empty", null);
        }
        String s6 = Build.MODEL;
        long v2 = e7.f.a(context0);
        boolean z = e7.f.f();
        int v3 = e7.f.c();
        String s7 = Build.MANUFACTURER;
        String s8 = Build.PRODUCT;
        l0 l00 = new l0(m00, o00, new n0(e0.ordinal(), Runtime.getRuntime().availableProcessors(), v2, v1, z, v3));
        this.j.d(s, v / 1000L, l00);
        if(!boolean0.booleanValue() || s == null) {
            s12 = s5;
            s10 = s7;
            s13 = s8;
            s11 = s6;
        }
        else {
            q q0 = this.d;
            synchronized(((String)q0.c)) {
                q0.c = s;
                e e2 = (e)((AtomicMarkableReference)((c)q0.d).b).getReference();
                synchronized(e2) {
                    map0 = Collections.unmodifiableMap(new HashMap(e2.a));
                }
                List list0 = ((T3.e)q0.f).f();
                s10 = s7;
                s11 = s6;
                s12 = s5;
                s13 = s8;
                ((d)q0.b).b.a(new D5.a(q0, s, map0, list0, 22));
            }
        }
        g7.f f0 = this.i;
        ((g7.d)f0.b).a();
        f0.b = g7.f.c;
        if(s != null) {
            f0.b = new n(((FileStore)f0.a).b(s, "userlog"));
        }
        this.l.a(s);
        q q1 = this.m;
        p p0 = (p)q1.a;
        A a0 = new A();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = "19.4.4";
        d0 d00 = p0.c;
        String s14 = (String)d00.b;
        if(s14 == null) {
            throw new NullPointerException("Null gmpAppId");
        }
        a0.b = s14;
        u u0 = p0.b;
        String s15 = u0.c().a;
        if(s15 == null) {
            throw new NullPointerException("Null installationUuid");
        }
        a0.d = s15;
        a0.e = u0.c().b;
        a0.f = u0.c().c;
        String s16 = (String)d00.g;
        if(s16 == null) {
            throw new NullPointerException("Null buildVersion");
        }
        a0.h = s16;
        String s17 = (String)d00.h;
        if(s17 == null) {
            throw new NullPointerException("Null displayVersion");
        }
        a0.i = s17;
        a0.c = 4;
        a0.m = (byte)(a0.m | 1);
        I i0 = new I();  // 初始化器: Ljava/lang/Object;-><init>()V
        i0.f = false;
        i0.d = v / 1000L;
        i0.m = (byte)(((byte)(i0.m | 2)) | 1);
        if(s == null) {
            throw new NullPointerException("Null identifier");
        }
        i0.b = s;
        i0.a = "Crashlytics Android SDK/19.4.4";
        String s18 = u0.c;
        if(s18 == null) {
            throw new NullPointerException("Null identifier");
        }
        String s19 = u0.c().a;
        DevelopmentPlatformProvider developmentPlatformProvider0 = (DevelopmentPlatformProvider)d00.i;
        if(developmentPlatformProvider0.b == null) {
            developmentPlatformProvider0.b = new ea.c(developmentPlatformProvider0);
        }
        ea.c c0 = developmentPlatformProvider0.b;
        String s20 = (String)c0.b;
        if(c0 == null) {
            developmentPlatformProvider0.b = new ea.c(developmentPlatformProvider0);
        }
        i0.g = new K(s18, s16, s17, s19, s20, ((String)developmentPlatformProvider0.b.c));
        i0 i00 = new i0();  // 初始化器: Ljava/lang/Object;-><init>()V
        i00.a = 3;
        i00.e = (byte)(i00.e | 1);
        if(s4 == null) {
            throw new NullPointerException("Null version");
        }
        i00.b = s4;
        if(s12 == null) {
            throw new NullPointerException("Null buildVersion");
        }
        i00.c = s12;
        i00.d = e7.f.g();
        i00.e = (byte)(i00.e | 2);
        i0.i = i00.a();
        StatFs statFs1 = new StatFs(Environment.getDataDirectory().getPath());
        int v5 = 7;
        if(!TextUtils.isEmpty("arm64-v8a")) {
            Integer integer0 = (Integer)p.f.get("arm64-v8a".toLowerCase(locale0));
            if(integer0 != null) {
                v5 = (int)integer0;
            }
        }
        int v6 = Runtime.getRuntime().availableProcessors();
        long v7 = e7.f.a(p0.a);
        long v8 = ((long)statFs1.getBlockCount()) * ((long)statFs1.getBlockSize());
        boolean z1 = e7.f.f();
        int v9 = e7.f.c();
        M m0 = new M();  // 初始化器: Ljava/lang/Object;-><init>()V
        m0.a = v5;
        byte b = (byte)(m0.j | 1);
        m0.j = b;
        if(s11 == null) {
            throw new NullPointerException("Null model");
        }
        m0.b = s11;
        m0.c = v6;
        m0.d = v7;
        m0.e = v8;
        m0.f = z1;
        m0.g = v9;
        m0.j = (byte)(((byte)(((byte)(((byte)(((byte)(b | 2)) | 4)) | 8)) | 16)) | 0x20);
        if(s10 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        m0.h = s10;
        if(s13 == null) {
            throw new NullPointerException("Null modelClass");
        }
        m0.i = s13;
        i0.j = m0.a();
        i0.l = 3;
        i0.m = (byte)(i0.m | 4);
        a0.j = i0.a();
        B b1 = a0.a();
        FileStore fileStore0 = ((k7.a)q1.b).b;
        N0 n00 = b1.k;
        if(n00 != null) {
            String s21 = ((J)n00).b;
            try {
                k7.a.g.getClass();
                String s22 = i7.a.a.o(b1);
                k7.a.f(fileStore0.b(s21, "report"), s22);
                File file0 = fileStore0.b(s21, "start-time");
                try(OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(file0), k7.a.e)) {
                    outputStreamWriter0.write("");
                    file0.setLastModified(((J)n00).d * 1000L);
                }
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Could not persist report for session " + s21, iOException0);
                }
            }
        }
        else if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Could not get session for report", null);
        }
    }

    public final boolean d(A1.g g0) {
        d.a();
        if(this.n != null && this.n.e.get()) {
            Log.w("FirebaseCrashlytics", "Skipping session finalization because a crash has already occurred.", null);
            return false;
        }
        if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Finalizing previously open sessions.", null);
        }
        try {
            this.b(true, g0, true);
        }
        catch(Exception exception0) {
            Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", exception0);
            return false;
        }
        if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Closed all previously open sessions.", null);
        }
        return true;
    }

    public final String e() {
        NavigableSet navigableSet0 = ((k7.a)this.m.b).c();
        return navigableSet0.isEmpty() ? null : ((String)navigableSet0.first());
    }

    public final String f() {
        String s1;
        byte[] arr_b1;
        InputStream inputStream0;
        int v = e7.f.d(this.a, "com.google.firebase.crashlytics.version_control_info", "string");
        String s = v == 0 ? null : this.a.getResources().getString(v);
        if(s != null) {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Read version control info from string resource", null);
            }
            return Base64.encodeToString(s.getBytes(k.s), 0);
        }
        ClassLoader classLoader0 = k.class.getClassLoader();
        if(classLoader0 == null) {
            Log.w("FirebaseCrashlytics", "Couldn\'t get Class Loader", null);
            inputStream0 = null;
        }
        else {
            inputStream0 = classLoader0.getResourceAsStream("META-INF/version-control-info.textproto");
        }
        if(inputStream0 != null) {
            try {
                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Read version control info from file", null);
                }
                ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                try {
                    byte[] arr_b = new byte[0x400];
                    int v1;
                    while((v1 = inputStream0.read(arr_b)) != -1) {
                        byteArrayOutputStream0.write(arr_b, 0, v1);
                    }
                    arr_b1 = byteArrayOutputStream0.toByteArray();
                }
                catch(Throwable throwable1) {
                    TWR.safeClose$NT(byteArrayOutputStream0, throwable1);
                    throw throwable1;
                }
                byteArrayOutputStream0.close();
                s1 = Base64.encodeToString(arr_b1, 0);
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(inputStream0, throwable0);
                throw throwable0;
            }
            inputStream0.close();
            return s1;
        }
        Log.i("FirebaseCrashlytics", "No version control information found", null);
        return null;
    }

    public final void g() {
        try {
            String s = this.f();
            if(s != null) {
                try {
                    ((c)this.d.e).m("com.crashlytics.version-control-info", s);
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    if(this.a != null && (this.a.getApplicationInfo().flags & 2) != 0) {
                        throw illegalArgumentException0;
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                }
                Log.i("FirebaseCrashlytics", "Saved version control info", null);
            }
        }
        catch(IOException iOException0) {
            Log.w("FirebaseCrashlytics", "Unable to save version control info", iOException0);
        }
    }

    public final void h(Task task0) {
        Task task2;
        Task task1;
        TaskCompletionSource taskCompletionSource0 = this.o;
        FileStore fileStore0 = ((k7.a)this.m.b).b;
        if(FileStore.e(fileStore0.e.listFiles()).isEmpty() && FileStore.e(fileStore0.f.listFiles()).isEmpty() && FileStore.e(fileStore0.g.listFiles()).isEmpty()) {
            if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "No crash reports are available to be sent.", null);
            }
            taskCompletionSource0.trySetResult(Boolean.FALSE);
            return;
        }
        b7.c c0 = b7.c.a;
        c0.e("Crash reports are available to be sent.");
        f f0 = this.b;
        if(f0.f()) {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Automatic data collection is enabled. Allowing upload.", null);
            }
            taskCompletionSource0.trySetResult(Boolean.FALSE);
            task1 = Tasks.forResult(Boolean.TRUE);
        }
        else {
            c0.b("Automatic data collection is disabled.");
            c0.e("Notifying that unsent reports are available.");
            taskCompletionSource0.trySetResult(Boolean.TRUE);
            synchronized(f0.e) {
                task2 = ((TaskCompletionSource)f0.f).getTask();
            }
            Task task3 = task2.onSuccessTask(new e3.h());  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.b("Waiting for send/deleteUnsentReports to be called.");
            task1 = f7.a.a(task3, this.p.getTask());
        }
        x9.c c1 = new x9.c(this, task0);
        task1.onSuccessTask(this.e.a, c1);
    }
}

