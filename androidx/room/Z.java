package androidx.room;

import A0.c;
import H4.d;
import H4.e;
import P0.r;
import Vc.B;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder;
import d5.n;
import d5.v;
import e.k;
import h7.u0;
import ie.H;
import ie.m;
import ie.o;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import je.p;
import je.w;
import kotlin.jvm.internal.q;
import z4.b;
import z4.g;

public final class z {
    public boolean a;
    public boolean b;
    public final a c;
    public final L d;
    public final List e;
    public final b f;
    public H4.a g;

    public z(a a0, B b0) {
        D d0 = a0.g;
        super();
        this.c = a0;
        this.d = new x(-1, "", "");  // 初始化器: Landroidx/room/L;-><init>(ILjava/lang/String;Ljava/lang/String;)V
        List list0 = a0.e;
        w w0 = w.a;
        List list1 = list0 == null ? w0 : list0;
        this.e = list1;
        B b1 = new B(this, 11);
        if(list0 == null) {
            list0 = w0;
        }
        ArrayList arrayList0 = p.z0(new V4.a(b1), list0);
        q.g(a0.a, "context");
        q.g(a0.d, "migrationContainer");
        q.g(a0.h, "queryExecutor");
        q.g(a0.i, "transactionExecutor");
        q.g(a0.q, "typeConverters");
        q.g(a0.r, "autoMigrationSpecs");
        this.f = new A4.b(new c(((e)b0.invoke(new a(a0.a, a0.b, a0.c, a0.d, arrayList0, a0.f, d0, a0.h, a0.i, a0.j, a0.k, a0.l, a0.m, a0.n, a0.o, a0.p, a0.q, a0.r, a0.s, a0.t, a0.u)))));
        boolean z = d0 == D.c;
        e e0 = this.c();
        if(e0 != null) {
            e0.setWriteAheadLoggingEnabled(z);
        }
    }

    public z(a a0, L l0) {
        int v1;
        g g0;
        D d0 = a0.g;
        d d1 = a0.c;
        String s = a0.b;
        super();
        this.c = a0;
        this.d = l0;
        List list0 = a0.e;
        if(list0 == null) {
            list0 = w.a;
        }
        this.e = list0;
        G4.b b0 = a0.t;
        boolean z = true;
        if(b0 == null) {
            if(d1 == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            q.g(a0.a, "context");
            SupportSQLiteOpenHelper.Configuration.Builder supportSQLiteOpenHelper$Configuration$Builder0 = new SupportSQLiteOpenHelper.Configuration.Builder(a0.a);
            supportSQLiteOpenHelper$Configuration$Builder0.b = s;
            supportSQLiteOpenHelper$Configuration$Builder0.c = new y(this, l0.getVersion());
            this.f = new A4.b(new c(d1.a(supportSQLiteOpenHelper$Configuration$Builder0.a())));
        }
        else {
            if(s == null) {
                g0 = new g(new v(this, b0));
            }
            else {
                v v0 = new v(this, b0);
                switch(d0.ordinal()) {
                    case 1: {
                        v1 = 1;
                        break;
                    }
                    case 2: {
                        v1 = 4;
                        break;
                    }
                    default: {
                        throw new IllegalStateException(("Can\'t get max number of reader for journal mode \'" + d0 + '\'').toString());
                    }
                }
                if(d0.ordinal() != 1 && d0.ordinal() != 2) {
                    throw new IllegalStateException(("Can\'t get max number of writers for journal mode \'" + d0 + '\'').toString());
                }
                g0 = new g(v0, s, v1);
            }
            this.f = g0;
        }
        if(d0 != D.c) {
            z = false;
        }
        e e0 = this.c();
        if(e0 != null) {
            e0.setWriteAheadLoggingEnabled(z);
        }
    }

    public static final void a(z z0, G4.a a0) {
        H h0;
        long v;
        L l0 = z0.d;
        a a1 = z0.c;
        D d0 = D.c;
        if(a1.g == d0) {
            u0.w("PRAGMA journal_mode = WAL", a0);
        }
        else {
            u0.w("PRAGMA journal_mode = TRUNCATE", a0);
        }
        if(a1.g == d0) {
            u0.w("PRAGMA synchronous = NORMAL", a0);
        }
        else {
            u0.w("PRAGMA synchronous = FULL", a0);
        }
        z.b(a0);
        G4.c c0 = a0.l0("PRAGMA user_version");
        try {
            c0.j0();
            v = c0.getLong(0);
        }
        catch(Throwable throwable0) {
            e1.x.y(c0, throwable0);
            throw throwable0;
        }
        e1.x.y(c0, null);
        if(((int)v) != l0.getVersion()) {
            u0.w("BEGIN EXCLUSIVE TRANSACTION", a0);
            try {
                if(((int)v) == 0) {
                    z0.d(a0);
                }
                else {
                    z0.e(a0, ((int)v), l0.getVersion());
                }
                u0.w(("PRAGMA user_version = " + l0.getVersion()), a0);
                h0 = H.a;
            }
            catch(Throwable throwable1) {
                h0 = n.t(throwable1);
            }
            if(!(h0 instanceof o)) {
                u0.w("END TRANSACTION", a0);
            }
            Throwable throwable2 = ie.p.a(h0);
            if(throwable2 != null) {
                u0.w("ROLLBACK TRANSACTION", a0);
                throw throwable2;
            }
        }
        z0.f(a0);
    }

    public static void b(G4.a a0) {
        G4.c c0 = a0.l0("PRAGMA busy_timeout");
        try {
            c0.j0();
            long v = c0.getLong(0);
        }
        catch(Throwable throwable0) {
            e1.x.y(c0, throwable0);
            throw throwable0;
        }
        e1.x.y(c0, null);
        if(v < 3000L) {
            u0.w("PRAGMA busy_timeout = 3000", a0);
        }
    }

    public final e c() {
        A4.b b0 = this.f instanceof A4.b ? ((A4.b)this.f) : null;
        if(b0 != null) {
            return b0.a == null ? null : ((e)b0.a.b);
        }
        return null;
    }

    public final void d(G4.a a0) {
        boolean z = false;
        q.g(a0, "connection");
        G4.c c0 = a0.l0("SELECT count(*) FROM sqlite_master WHERE name != \'android_metadata\'");
        try {
            if(c0.j0() && c0.getLong(0) == 0L) {
                z = true;
            }
        }
        catch(Throwable throwable0) {
            e1.x.y(c0, throwable0);
            throw throwable0;
        }
        e1.x.y(c0, null);
        L l0 = this.d;
        l0.createAllTables(a0);
        if(!z) {
            K k0 = l0.onValidateSchema(a0);
            if(!k0.a) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + k0.b).toString());
            }
        }
        this.g(a0);
        l0.onCreate(a0);
        for(Object object0: this.e) {
            ((androidx.room.B)object0).onCreate(a0);
        }
    }

    public final void e(G4.a a0, int v, int v1) {
        ke.b b1;
        q.g(a0, "connection");
        a a1 = this.c;
        List list0 = H0.e.F(a1.d, v, v1);
        L l0 = this.d;
        if(list0 != null) {
            l0.onPreMigrate(a0);
            for(Object object0: list0) {
                ((B4.a)object0).migrate(a0);
            }
            K k0 = l0.onValidateSchema(a0);
            if(!k0.a) {
                throw new IllegalStateException(("Migration didn\'t properly handle: " + k0.b).toString());
            }
            l0.onPostMigrate(a0);
            this.g(a0);
            return;
        }
        if(H0.e.L(a1, v, v1)) {
            throw new IllegalStateException(("A migration from " + v + " to " + v1 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
        if(a1.s) {
            G4.c c0 = a0.l0("SELECT name, type FROM sqlite_master WHERE type = \'table\' OR type = \'view\'");
            try {
                ke.b b0 = k.l();
                while(c0.j0()) {
                    String s = c0.S(0);
                    if(!Tf.v.r0(s, "sqlite_", false) && !s.equals("android_metadata")) {
                        b0.add(new m(s, Boolean.valueOf(q.b(c0.S(1), "view"))));
                    }
                }
                b1 = k.h(b0);
                goto label_33;
            }
            catch(Throwable throwable0) {
            }
            try {
                throw throwable0;
            }
            catch(Throwable throwable1) {
                e1.x.y(c0, throwable0);
                throw throwable1;
            }
        label_33:
            e1.x.y(c0, null);
            ListIterator listIterator0 = b1.listIterator(0);
            while(((r)listIterator0).hasNext()) {
                m m0 = (m)((r)listIterator0).next();
                String s1 = (String)m0.a;
                if(((Boolean)m0.b).booleanValue()) {
                    u0.w(("DROP VIEW IF EXISTS " + s1), a0);
                }
                else {
                    u0.w(("DROP TABLE IF EXISTS " + s1), a0);
                }
            }
        }
        else {
            l0.dropAllTables(a0);
        }
        for(Object object1: this.e) {
            ((androidx.room.B)object1).onDestructiveMigration(a0);
        }
        l0.createAllTables(a0);
    }

    public final void f(G4.a a0) {
        H h0;
        String s;
        q.g(a0, "connection");
        G4.c c0 = a0.l0("SELECT 1 FROM sqlite_master WHERE type = \'table\' AND name = \'room_master_table\'");
        try {
            if(!c0.j0() || c0.getLong(0) == 0L) {
                goto label_9;
            }
            else {
                goto label_7;
            }
            goto label_10;
        }
        catch(Throwable throwable0) {
            e1.x.y(c0, throwable0);
            throw throwable0;
        }
    label_7:
        boolean z = true;
        goto label_10;
    label_9:
        z = false;
    label_10:
        e1.x.y(c0, null);
        L l0 = this.d;
        if(z) {
            G4.c c1 = a0.l0("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            try {
                s = c1.j0() ? c1.S(0) : null;
            }
            catch(Throwable throwable1) {
                e1.x.y(c1, throwable1);
                throw throwable1;
            }
            e1.x.y(c1, null);
            if(!q.b(l0.getIdentityHash(), s) && !q.b(l0.getLegacyIdentityHash(), s)) {
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you\'ve changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + l0.getIdentityHash() + ", found: " + s).toString());
            }
            goto label_39;
        }
        u0.w("BEGIN EXCLUSIVE TRANSACTION", a0);
        try {
            K k0 = l0.onValidateSchema(a0);
            if(!k0.a) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + k0.b).toString());
            }
            l0.onPostMigrate(a0);
            this.g(a0);
            h0 = H.a;
        }
        catch(Throwable throwable2) {
            h0 = n.t(throwable2);
        }
        if(!(h0 instanceof o)) {
            u0.w("END TRANSACTION", a0);
        }
        Throwable throwable3 = ie.p.a(h0);
        if(throwable3 == null) {
        label_39:
            l0.onOpen(a0);
            for(Object object0: this.e) {
                ((androidx.room.B)object0).onOpen(a0);
            }
            this.a = true;
            return;
        }
        u0.w("ROLLBACK TRANSACTION", a0);
        throw throwable3;
    }

    public final void g(G4.a a0) {
        u0.w("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)", a0);
        String s = this.d.getIdentityHash();
        q.g(s, "hash");
        u0.w(("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \'" + s + "\')"), a0);
    }
}

