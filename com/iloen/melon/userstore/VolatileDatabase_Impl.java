package com.iloen.melon.userstore;

import Eb.f;
import Eb.o;
import androidx.room.M;
import androidx.room.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import x9.a;
import x9.b;
import x9.c;

public final class VolatileDatabase_Impl extends VolatileDatabase {
    public volatile c d;
    public volatile a e;
    public volatile b f;

    @Override  // com.iloen.melon.userstore.VolatileDatabase
    public final a b() {
        if(this.e != null) {
            return this.e;
        }
        synchronized(this) {
            if(this.e == null) {
                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a0.a = this;
                a0.b = new f(17);
                this.e = a0;
            }
            return this.e;
        }
    }

    @Override  // com.iloen.melon.userstore.VolatileDatabase
    public final b c() {
        if(this.f != null) {
            return this.f;
        }
        synchronized(this) {
            if(this.f == null) {
                b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b0.a = this;
                b0.b = new f(18);
                this.f = b0;
            }
            return this.f;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"tag", "restore_data", "tab_menu_shortcut"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"tag", "restore_data", "tab_menu_shortcut"});
    }

    @Override  // androidx.room.H
    public final M createOpenDelegate() {
        return new o(this);
    }

    @Override  // com.iloen.melon.userstore.VolatileDatabase
    public final c d() {
        if(this.d != null) {
            return this.d;
        }
        synchronized(this) {
            if(this.d == null) {
                this.d = new c(this);
            }
            return this.d;
        }
    }

    @Override  // androidx.room.H
    public final List getAutoMigrations(Map map0) {
        return new ArrayList();
    }

    @Override  // androidx.room.H
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override  // androidx.room.H
    public final Map getRequiredTypeConverters() {
        Map map0 = new HashMap();
        List list0 = Collections.EMPTY_LIST;
        ((HashMap)map0).put(c.class, list0);
        ((HashMap)map0).put(a.class, list0);
        ((HashMap)map0).put(b.class, list0);
        return map0;
    }
}

