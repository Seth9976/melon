package androidx.work.impl;

import H4.a;
import Ua.h;
import V4.d;
import androidx.room.N;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder;
import d5.b;
import d5.c;
import d5.e;
import d5.f;
import d5.i;
import d5.l;
import d5.m;
import d5.s;
import d5.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.q;

public final class WorkDatabase_Impl extends WorkDatabase {
    public volatile s a;
    public volatile c b;
    public volatile v c;
    public volatile i d;
    public volatile l e;
    public volatile m f;
    public volatile e g;

    @Override  // androidx.work.impl.WorkDatabase
    public final c b() {
        if(this.b != null) {
            return this.b;
        }
        synchronized(this) {
            if(this.b == null) {
                this.b = new c(this);
            }
            return this.b;
        }
    }

    @Override  // androidx.work.impl.WorkDatabase
    public final e c() {
        if(this.g != null) {
            return this.g;
        }
        synchronized(this) {
            if(this.g == null) {
                this.g = new e(this);
            }
            return this.g;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        super.assertNotMainThread();
        a a0 = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            a0.u("PRAGMA defer_foreign_keys = TRUE");
            a0.u("DELETE FROM `Dependency`");
            a0.u("DELETE FROM `WorkSpec`");
            a0.u("DELETE FROM `WorkTag`");
            a0.u("DELETE FROM `SystemIdInfo`");
            a0.u("DELETE FROM `WorkName`");
            a0.u("DELETE FROM `WorkProgress`");
            a0.u("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        }
        finally {
            super.endTransaction();
            a0.R("PRAGMA wal_checkpoint(FULL)").close();
            if(!a0.Y()) {
                a0.u("VACUUM");
            }
        }
    }

    @Override  // androidx.room.H
    public final androidx.room.l createInvalidationTracker() {
        return new androidx.room.l(this, new HashMap(0), new HashMap(0), new String[]{"Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference"});
    }

    @Override  // androidx.room.H
    public final H4.e createOpenHelper(androidx.room.a a0) {
        N n0 = new N(a0, new h(this));
        q.g(a0.a, "context");
        SupportSQLiteOpenHelper.Configuration.Builder supportSQLiteOpenHelper$Configuration$Builder0 = new SupportSQLiteOpenHelper.Configuration.Builder(a0.a);
        supportSQLiteOpenHelper$Configuration$Builder0.b = a0.b;
        supportSQLiteOpenHelper$Configuration$Builder0.c = n0;
        H4.c c0 = supportSQLiteOpenHelper$Configuration$Builder0.a();
        return a0.c.a(c0);
    }

    @Override  // androidx.work.impl.WorkDatabase
    public final i d() {
        if(this.d != null) {
            return this.d;
        }
        synchronized(this) {
            if(this.d == null) {
                i i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
                i0.a = this;
                i0.b = new b(this, false, 2);
                i0.c = new d5.h(this, 0);
                i0.d = new d5.h(this, 1);
                this.d = i0;
            }
            return this.d;
        }
    }

    @Override  // androidx.work.impl.WorkDatabase
    public final l e() {
        if(this.e != null) {
            return this.e;
        }
        synchronized(this) {
            if(this.e == null) {
                this.e = new l(this);
            }
            return this.e;
        }
    }

    @Override  // androidx.work.impl.WorkDatabase
    public final m f() {
        if(this.f != null) {
            return this.f;
        }
        synchronized(this) {
            if(this.f == null) {
                this.f = new m(this);
            }
            return this.f;
        }
    }

    @Override  // androidx.work.impl.WorkDatabase
    public final s g() {
        if(this.a != null) {
            return this.a;
        }
        synchronized(this) {
            if(this.a == null) {
                this.a = new s(this);
            }
            return this.a;
        }
    }

    @Override  // androidx.room.H
    public final List getAutoMigrations(Map map0) {
        List list0 = new ArrayList();
        ((ArrayList)list0).add(new d(13, 14, 10));
        ((ArrayList)list0).add(new d(11));
        ((ArrayList)list0).add(new d(16, 17, 12));
        ((ArrayList)list0).add(new d(17, 18, 13));
        ((ArrayList)list0).add(new d(18, 19, 14));
        ((ArrayList)list0).add(new d(15));
        ((ArrayList)list0).add(new d(20, 21, 16));
        ((ArrayList)list0).add(new d(22, 23, 17));
        return list0;
    }

    @Override  // androidx.room.H
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override  // androidx.room.H
    public final Map getRequiredTypeConverters() {
        Map map0 = new HashMap();
        List list0 = Collections.EMPTY_LIST;
        ((HashMap)map0).put(s.class, list0);
        ((HashMap)map0).put(c.class, list0);
        ((HashMap)map0).put(v.class, list0);
        ((HashMap)map0).put(i.class, list0);
        ((HashMap)map0).put(l.class, list0);
        ((HashMap)map0).put(m.class, list0);
        ((HashMap)map0).put(e.class, list0);
        ((HashMap)map0).put(f.class, list0);
        return map0;
    }

    @Override  // androidx.work.impl.WorkDatabase
    public final v h() {
        if(this.c != null) {
            return this.c;
        }
        synchronized(this) {
            if(this.c == null) {
                v v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
                v1.a = this;
                v1.b = new b(this, false, 6);
                new d5.h(this, 20);
                this.c = v1;
            }
            return this.c;
        }
    }

    public static List i(WorkDatabase_Impl workDatabase_Impl0) {
        return workDatabase_Impl0.mCallbacks;
    }

    public static List j(WorkDatabase_Impl workDatabase_Impl0) {
        return workDatabase_Impl0.mCallbacks;
    }

    public static void k(WorkDatabase_Impl workDatabase_Impl0, I4.b b0) {
        workDatabase_Impl0.mDatabase = b0;
    }

    public static List l(WorkDatabase_Impl workDatabase_Impl0) {
        return workDatabase_Impl0.mCallbacks;
    }
}

