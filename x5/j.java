package X5;

import I7.g;
import Y5.b;
import Z5.a;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Provider;

public final class j implements c, d, Y5.c {
    public final l a;
    public final a b;
    public final a c;
    public final X5.a d;
    public final Provider e;
    public static final N5.c f;

    static {
        j.f = new N5.c("proto");
    }

    public j(a a0, a a1, X5.a a2, l l0, Provider provider0) {
        this.a = l0;
        this.b = a0;
        this.c = a1;
        this.d = a2;
        this.e = provider0;
    }

    @Override
    public final void close() {
        this.a.close();
    }

    public final SQLiteDatabase h() {
        l l0 = this.a;
        Objects.requireNonNull(l0);
        a a0 = this.c;
        long v = a0.f();
        while(true) {
            try {
                return l0.getWritableDatabase();
            }
            catch(SQLiteDatabaseLockedException sQLiteDatabaseLockedException0) {
            }
            if(a0.f() >= ((long)this.d.c) + v) {
                break;
            }
            SystemClock.sleep(50L);
        }
        throw new Y5.a("Timed out while trying to open db.", sQLiteDatabaseLockedException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    }

    public static Long i(SQLiteDatabase sQLiteDatabase0, Q5.j j0) {
        StringBuilder stringBuilder0 = new StringBuilder("backend_name = ? and priority = ?");
        String s = String.valueOf(a6.a.a(j0.c));
        ArrayList arrayList0 = new ArrayList(Arrays.asList(new String[]{j0.a, s}));
        byte[] arr_b = j0.b;
        if(arr_b == null) {
            stringBuilder0.append(" and extras is null");
        }
        else {
            stringBuilder0.append(" and extras = ?");
            arrayList0.add(Base64.encodeToString(arr_b, 0));
        }
        Object[] arr_object = arrayList0.toArray(new String[0]);
        try(Cursor cursor0 = sQLiteDatabase0.query("transport_contexts", new String[]{"_id"}, stringBuilder0.toString(), ((String[])arr_object), null, null, null)) {
            return !cursor0.moveToNext() ? null : cursor0.getLong(0);
        }
    }

    public final Object j(h h0) {
        SQLiteDatabase sQLiteDatabase0 = this.h();
        sQLiteDatabase0.beginTransaction();
        try {
            Object object0 = h0.apply(sQLiteDatabase0);
            sQLiteDatabase0.setTransactionSuccessful();
            return object0;
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
    }

    public final ArrayList l(SQLiteDatabase sQLiteDatabase0, Q5.j j0, int v) {
        ArrayList arrayList0 = new ArrayList();
        Long long0 = j.i(sQLiteDatabase0, j0);
        if(long0 == null) {
            return arrayList0;
        }
        j.p(sQLiteDatabase0.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{long0.toString()}, null, null, null, String.valueOf(v)), new H7.c(this, arrayList0, j0, 8));
        return arrayList0;
    }

    public final void m(long v, T5.c c0, String s) {
        this.j(new g(s, c0, v));
    }

    public final Object n(b b0) {
        SQLiteDatabase sQLiteDatabase0 = this.h();
        a a0 = this.c;
        long v = a0.f();
        while(true) {
            try {
                sQLiteDatabase0.beginTransaction();
                break;
            }
            catch(SQLiteDatabaseLockedException sQLiteDatabaseLockedException0) {
                if(a0.f() >= ((long)this.d.c) + v) {
                    throw new Y5.a("Timed out while trying to acquire the lock.", sQLiteDatabaseLockedException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
                SystemClock.sleep(50L);
            }
        }
        try {
            Object object0 = b0.execute();
            sQLiteDatabase0.setTransactionSuccessful();
            return object0;
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
    }

    public static String o(Iterable iterable0) {
        StringBuilder stringBuilder0 = new StringBuilder("(");
        Iterator iterator0 = iterable0.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            stringBuilder0.append(((X5.b)object0).a);
            if(iterator0.hasNext()) {
                stringBuilder0.append(',');
            }
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    public static Object p(Cursor cursor0, h h0) {
        try(cursor0) {
            return h0.apply(cursor0);
        }
    }
}

