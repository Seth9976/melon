package co.ab180.airbridge.internal.e0;

import Q0.D;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Base64;
import co.ab180.airbridge.BuildConfig;
import co.ab180.airbridge.internal.b;
import e.k;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Properties;
import je.p;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004*\u0004\u000F\u0012\u0016\u001A\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0011\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001D\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lco/ab180/airbridge/internal/e0/t;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/c0/f/a;", "preferenceStorage", "", "versionName", "", "limitVersionName", "Lie/H;", "a", "(Landroid/content/Context;Lco/ab180/airbridge/internal/c0/f/a;Ljava/lang/String;Z)V", "co/ab180/airbridge/internal/e0/t$a", "Lco/ab180/airbridge/internal/e0/t$a;", "MIGRATION_0_10_11", "co/ab180/airbridge/internal/e0/t$b", "b", "Lco/ab180/airbridge/internal/e0/t$b;", "MIGRATION_2_0_0", "co/ab180/airbridge/internal/e0/t$c", "c", "Lco/ab180/airbridge/internal/e0/t$c;", "MIGRATION_2_25_0", "co/ab180/airbridge/internal/e0/t$d", "d", "Lco/ab180/airbridge/internal/e0/t$d;", "MIGRATION_4_4_0", "", "Lco/ab180/airbridge/internal/e0/s;", "e", "Ljava/util/List;", "migrations", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class t {
    @Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"co/ab180/airbridge/internal/e0/t$a", "Lco/ab180/airbridge/internal/e0/s;", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/c0/f/a;", "preferenceStorage", "Lie/H;", "a", "(Landroid/content/Context;Lco/ab180/airbridge/internal/c0/f/a;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a extends s {
        public a(int v, int v1, int v2) {
            super(v, v1, v2);
        }

        @Override  // co.ab180.airbridge.internal.e0.s
        public void a(@NotNull Context context0, @NotNull co.ab180.airbridge.internal.c0.f.a a0) {
            b.e.a("Migrating v0.10.11 preferences ...", new Object[0]);
            File file0 = new File(context0.getNoBackupFilesDir(), "ab_session");
            Properties properties0 = new Properties();
            if(file0.exists()) {
                properties0.load(new FileInputStream(file0));
            }
            SharedPreferences sharedPreferences0 = context0.getSharedPreferences("ab_session", 0);
            if(sharedPreferences0.contains("initialTransactionId")) {
                properties0.put("installed", "true");
            }
            properties0.store(new FileOutputStream(file0), null);
            sharedPreferences0.edit().clear().apply();
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"co/ab180/airbridge/internal/e0/t$b", "Lco/ab180/airbridge/internal/e0/s;", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/c0/f/a;", "preferenceStorage", "Lie/H;", "a", "(Landroid/content/Context;Lco/ab180/airbridge/internal/c0/f/a;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.e0.t.b extends s {
        public co.ab180.airbridge.internal.e0.t.b(int v, int v1, int v2) {
            super(v, v1, v2);
        }

        @Override  // co.ab180.airbridge.internal.e0.s
        public void a(@NotNull Context context0, @NotNull co.ab180.airbridge.internal.c0.f.a a0) {
            b.e.a("Migrating v2.0.0 preferences ...", new Object[0]);
            File file0 = new File(context0.getNoBackupFilesDir(), "ab_session");
            Properties properties0 = new Properties();
            properties0.load(new FileInputStream(file0));
            SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("airbridge-internal", 0).edit();
            if(properties0.containsKey("installed")) {
                String s = properties0.getProperty("installed");
                if(s != null) {
                    sharedPreferences$Editor0.putBoolean("first_open", !Boolean.parseBoolean(s));
                }
            }
            sharedPreferences$Editor0.apply();
            SharedPreferences.Editor sharedPreferences$Editor1 = context0.getSharedPreferences("airbridge-user-info", 0).edit();
            if(properties0.containsKey("externalUserID")) {
                String s1 = properties0.getProperty("externalUserID");
                if(s1 != null) {
                    sharedPreferences$Editor1.putString("user_id", s1);
                }
            }
            if(properties0.containsKey("externalUserEmail")) {
                String s2 = properties0.getProperty("externalUserEmail");
                if(s2 != null) {
                    sharedPreferences$Editor1.putString("user_email", s2);
                }
            }
            if(properties0.containsKey("externalUserPhone")) {
                String s3 = properties0.getProperty("externalUserPhone");
                if(s3 != null) {
                    sharedPreferences$Editor1.putString("user_phone", s3);
                }
            }
            sharedPreferences$Editor1.apply();
            Object object0 = null;
            if(properties0.containsKey("alias")) {
                try {
                    SharedPreferences.Editor sharedPreferences$Editor2 = context0.getSharedPreferences("airbridge-user-alias", 0).edit();
                    ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(Base64.decode(properties0.getProperty("alias"), 2));
                    ObjectInputStream objectInputStream0 = new ObjectInputStream(byteArrayInputStream0);
                    Object object1 = objectInputStream0.readObject();
                    if(!(object1 instanceof Map)) {
                        object1 = null;
                    }
                    if(((Map)object1) != null) {
                        for(Object object2: ((Map)object1).entrySet()) {
                            Object object3 = ((Map.Entry)object2).getKey();
                            Object object4 = ((Map.Entry)object2).getValue();
                            if(object3 instanceof String && object4 instanceof String) {
                                sharedPreferences$Editor2.putString(((String)object3), ((String)object4));
                            }
                        }
                    }
                    sharedPreferences$Editor2.apply();
                    objectInputStream0.close();
                    byteArrayInputStream0.close();
                    goto label_47;
                }
                catch(Throwable throwable0) {
                }
                b.e.b("Failed to read user alias data from old preferences: error={" + throwable0 + '}', new Object[0]);
            }
        label_47:
            if(properties0.containsKey("attributes")) {
                try {
                    SharedPreferences.Editor sharedPreferences$Editor3 = context0.getSharedPreferences("airbridge-user-attributes", 0).edit();
                    ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(Base64.decode(properties0.getProperty("attributes"), 2));
                    ObjectInputStream objectInputStream1 = new ObjectInputStream(byteArrayInputStream1);
                    Object object5 = objectInputStream1.readObject();
                    if(!(object5 instanceof Map)) {
                        object5 = null;
                    }
                    if(((Map)object5) != null) {
                        for(Object object6: ((Map)object5).entrySet()) {
                            Object object7 = ((Map.Entry)object6).getKey();
                            Object object8 = ((Map.Entry)object6).getValue();
                            if(!(object7 instanceof String)) {
                            }
                            else if(object8 instanceof Integer) {
                                sharedPreferences$Editor3.putInt(((String)object7), ((Number)object8).intValue());
                            }
                            else if(object8 instanceof Long) {
                                sharedPreferences$Editor3.putLong(((String)object7), ((Number)object8).longValue());
                            }
                            else if(object8 instanceof Float) {
                                sharedPreferences$Editor3.putFloat(((String)object7), ((Number)object8).floatValue());
                            }
                            else if(object8 instanceof Boolean) {
                                sharedPreferences$Editor3.putBoolean(((String)object7), ((Boolean)object8).booleanValue());
                            }
                            else {
                                if(!(object8 instanceof String)) {
                                    continue;
                                }
                                sharedPreferences$Editor3.putString(((String)object7), ((String)object8));
                            }
                        }
                    }
                    sharedPreferences$Editor3.apply();
                    objectInputStream1.close();
                    byteArrayInputStream1.close();
                    goto label_82;
                }
                catch(Throwable throwable1) {
                }
                b.e.b("Failed to read user attributes data from old preferences: error={" + throwable1 + '}', new Object[0]);
            }
        label_82:
            if(properties0.containsKey("externalDeviceAlias")) {
                try {
                    SharedPreferences.Editor sharedPreferences$Editor4 = context0.getSharedPreferences("airbridge-device-alias", 0).edit();
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(Base64.decode(properties0.getProperty("externalDeviceAlias"), 2));
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream2);
                    Object object9 = objectInputStream2.readObject();
                    if(object9 instanceof Map) {
                        object0 = object9;
                    }
                    if(((Map)object0) != null) {
                        for(Object object10: ((Map)object0).entrySet()) {
                            Object object11 = ((Map.Entry)object10).getKey();
                            Object object12 = ((Map.Entry)object10).getValue();
                            if(object11 instanceof String && object12 instanceof String) {
                                sharedPreferences$Editor4.putString(((String)object11), ((String)object12));
                            }
                        }
                    }
                    sharedPreferences$Editor4.apply();
                    objectInputStream2.close();
                    byteArrayInputStream2.close();
                    goto label_104;
                }
                catch(Throwable throwable2) {
                }
                b.e.b("Failed to read device alias data from old preferences: error={" + throwable2 + '}', new Object[0]);
            }
        label_104:
            file0.delete();
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"co/ab180/airbridge/internal/e0/t$c", "Lco/ab180/airbridge/internal/e0/s;", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/c0/f/a;", "preferenceStorage", "Lie/H;", "a", "(Landroid/content/Context;Lco/ab180/airbridge/internal/c0/f/a;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class c extends s {
        public c(int v, int v1, int v2) {
            super(v, v1, v2);
        }

        @Override  // co.ab180.airbridge.internal.e0.s
        public void a(@NotNull Context context0, @NotNull co.ab180.airbridge.internal.c0.f.a a0) {
            boolean z = false;
            b.e.a("Migrating v2.25.0 preferences ...", new Object[0]);
            if(a0.i() != null) {
                z = true;
            }
            a0.e(z);
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"co/ab180/airbridge/internal/e0/t$d", "Lco/ab180/airbridge/internal/e0/s;", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/c0/f/a;", "preferenceStorage", "Lie/H;", "a", "(Landroid/content/Context;Lco/ab180/airbridge/internal/c0/f/a;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class d extends s {
        public d(int v, int v1, int v2) {
            super(v, v1, v2);
        }

        @Override  // co.ab180.airbridge.internal.e0.s
        public void a(@NotNull Context context0, @NotNull co.ab180.airbridge.internal.c0.f.a a0) {
            b.e.a("Migrating v4.4.0 preferences ...", new Object[0]);
            if(BuildConfig.RESTRICTED.booleanValue()) {
                a0.e(true);
            }
        }
    }

    private static final a a;
    private static final co.ab180.airbridge.internal.e0.t.b b;
    private static final c c;
    private static final d d;
    private static final List e;
    @NotNull
    public static final t f;

    static {
        t.f = new t();
        a t$a0 = new a(0, 10, 11);
        t.a = t$a0;
        co.ab180.airbridge.internal.e0.t.b t$b0 = new co.ab180.airbridge.internal.e0.t.b(2, 0, 0);
        t.b = t$b0;
        c t$c0 = new c(2, 25, 0);
        t.c = t$c0;
        d t$d0 = new d(4, 4, 0);
        t.d = t$d0;
        t.e = k.A(new s[]{t$a0, t$b0, t$c0, t$d0});
    }

    public static void a(t t0, Context context0, co.ab180.airbridge.internal.c0.f.a a0, String s, boolean z, int v, Object object0) {
        if((v & 8) != 0) {
            z = false;
        }
        t0.a(context0, a0, s, z);
    }

    public final void a(@NotNull Context context0, @NotNull co.ab180.airbridge.internal.c0.f.a a0, @NotNull String s, boolean z) {
        b.e.a("Migrating. current version: " + s, new Object[0]);
        if(a0.i() != null) {
            D d0 = e1.b.q(new we.k[]{u.a, v.a, w.a});
            List list0 = p.J0(t.e, d0);
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                if(!z || m0.a.a(((s)object0).toString(), s) <= 0) {
                    arrayList0.add(object0);
                }
            }
            for(Object object1: arrayList0) {
                s s1 = (s)object1;
                String s2 = a0.i();
                if(m0.a.a(s2, s1.toString()) < 0) {
                    try {
                        s1.a(context0, a0);
                    }
                    catch(Exception exception0) {
                        b.e.g(exception0);
                    }
                }
            }
        }
        a0.h(s);
    }
}

