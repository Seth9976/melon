package com.melon.log.db;

import Eb.b;
import Eb.g;
import Eb.i;
import Eb.m;
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

public final class LogDatabase_Impl extends LogDatabase {
    public volatile m e;
    public volatile g f;

    @Override  // com.melon.log.db.LogDatabase
    public final i b() {
        if(this.e != null) {
            return this.e;
        }
        synchronized(this) {
            if(this.e == null) {
                this.e = new m(this);
            }
            return this.e;
        }
    }

    @Override  // com.melon.log.db.LogDatabase
    public final b c() {
        if(this.f != null) {
            return this.f;
        }
        synchronized(this) {
            if(this.f == null) {
                this.f = new g(this);
            }
            return this.f;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"log_history", "dev_log_history"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"log_history", "dev_log_history"});
    }

    @Override  // androidx.room.H
    public final M createOpenDelegate() {
        return new o(this);
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
        ((HashMap)map0).put(i.class, list0);
        ((HashMap)map0).put(b.class, list0);
        return map0;
    }
}

