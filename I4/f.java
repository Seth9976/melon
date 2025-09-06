package I4;

import A0.c;
import H4.b;
import J4.a;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import i.n.i.b.a.s.e.M3;
import java.io.File;
import kotlin.jvm.internal.q;

public final class f extends SQLiteOpenHelper {
    public final Context a;
    public final c b;
    public final b c;
    public final boolean d;
    public boolean e;
    public final a f;
    public boolean g;
    public static final int h;

    public f(Context context0, String s, c c0, b b0, boolean z) {
        q.g(b0, "callback");
        String s1;
        super(context0, s, null, b0.b, new I4.c(b0, c0));
        this.a = context0;
        this.b = c0;
        this.c = b0;
        this.d = z;
        if(s == null) {
            s1 = "272955f5-2162-4c6c-81f5-b37e460e6ffa";
            q.f("272955f5-2162-4c6c-81f5-b37e460e6ffa", "toString(...)");
        }
        else {
            s1 = s;
        }
        this.f = new a(s1, context0.getCacheDir(), false);
    }

    public final H4.a c(boolean z) {
        H4.a a2;
        H4.a a1;
        SQLiteDatabase sQLiteDatabase0;
        a a0;
        try {
            a0 = this.f;
            a0.a(!this.g && this.getDatabaseName() != null);
            this.e = false;
            sQLiteDatabase0 = this.f(z);
            if(this.e) {
                this.close();
                a1 = this.c(z);
                goto label_7;
            }
            a2 = x1.a.E(this.b, sQLiteDatabase0);
            goto label_14;
        }
        catch(Throwable throwable0) {
            a0.b();
            throw throwable0;
        }
    label_7:
        a0.b();
        return a1;
        try {
            a2 = x1.a.E(this.b, sQLiteDatabase0);
        }
        catch(Throwable throwable0) {
            a0.b();
            throw throwable0;
        }
    label_14:
        a0.b();
        return a2;
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void close() {
        try {
            this.f.a(this.f.a);
            super.close();
            this.b.b = null;
            this.g = false;
        }
        finally {
            this.f.b();
        }
    }

    public final SQLiteDatabase f(boolean z) {
        SQLiteDatabase sQLiteDatabase3;
        SQLiteDatabase sQLiteDatabase2;
        String s = this.getDatabaseName();
        Context context0 = this.a;
        if(s != null && !this.g) {
            File file0 = context0.getDatabasePath(s).getParentFile();
            if(file0 != null) {
                file0.mkdirs();
                if(!file0.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + file0);
                }
            }
        }
        try {
            if(z) {
                SQLiteDatabase sQLiteDatabase0 = this.getWritableDatabase();
                q.d(sQLiteDatabase0);
                return sQLiteDatabase0;
            }
            SQLiteDatabase sQLiteDatabase1 = this.getReadableDatabase();
            q.d(sQLiteDatabase1);
            return sQLiteDatabase1;
        }
        catch(Throwable unused_ex) {
            try {
                Thread.sleep(500L);
            }
            catch(InterruptedException unused_ex) {
            }
            try {
                if(z) {
                    sQLiteDatabase2 = this.getWritableDatabase();
                    q.d(sQLiteDatabase2);
                    return sQLiteDatabase2;
                }
                sQLiteDatabase2 = this.getReadableDatabase();
                q.d(sQLiteDatabase2);
                return sQLiteDatabase2;
            label_24:
                if(throwable0 instanceof d) {
                    goto label_25;
                }
                goto label_32;
            }
            catch(Throwable throwable0) {
                goto label_24;
            }
        label_25:
            int v = ((d)throwable0).a.ordinal();
            throwable0 = ((d)throwable0).b;
            switch(v) {
                case 0: 
                case 1: 
                case 2: 
                case 3: {
                    throw throwable0;
                }
                case 4: {
                    if(!(throwable0 instanceof SQLiteException)) {
                        throw throwable0;
                    }
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        label_32:
            if(!(throwable0 instanceof SQLiteException) || s == null || !this.d) {
                throw throwable0;
            }
            context0.deleteDatabase(s);
            try {
                if(z) {
                    sQLiteDatabase3 = this.getWritableDatabase();
                    q.d(sQLiteDatabase3);
                    return sQLiteDatabase3;
                }
                sQLiteDatabase3 = this.getReadableDatabase();
                q.d(sQLiteDatabase3);
                return sQLiteDatabase3;
            }
            catch(d d0) {
            }
            throw d0.b;
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase0) {
        q.g(sQLiteDatabase0, "db");
        b b0 = this.c;
        if(!this.e && b0.b != sQLiteDatabase0.getVersion()) {
            sQLiteDatabase0.setMaxSqlCacheSize(1);
        }
        try {
            b0.j(x1.a.E(this.b, sQLiteDatabase0));
        }
        catch(Throwable throwable0) {
            throw new d(e.a, throwable0);
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase0) {
        q.g(sQLiteDatabase0, "sqLiteDatabase");
        try {
            I4.b b0 = x1.a.E(this.b, sQLiteDatabase0);
            this.c.k(b0);
        }
        catch(Throwable throwable0) {
            throw new d(e.b, throwable0);
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        q.g(sQLiteDatabase0, "db");
        this.e = true;
        try {
            I4.b b0 = x1.a.E(this.b, sQLiteDatabase0);
            this.c.l(b0, v, v1);
        }
        catch(Throwable throwable0) {
            throw new d(e.d, throwable0);
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase0) {
        q.g(sQLiteDatabase0, "db");
        if(!this.e) {
            try {
                I4.b b0 = x1.a.E(this.b, sQLiteDatabase0);
                this.c.m(b0);
            }
            catch(Throwable throwable0) {
                throw new d(e.e, throwable0);
            }
        }
        this.g = true;
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        q.g(sQLiteDatabase0, "sqLiteDatabase");
        this.e = true;
        try {
            I4.b b0 = x1.a.E(this.b, sQLiteDatabase0);
            this.c.n(b0, v, v1);
        }
        catch(Throwable throwable0) {
            throw new d(e.c, throwable0);
        }
    }
}

