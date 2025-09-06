package com.iloen.melon.database.core;

import Eb.o;
import H8.i;
import androidx.room.M;
import androidx.room.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class LocalContentDatabase_Impl extends LocalContentDatabase {
    public volatile i d;

    @Override  // com.iloen.melon.database.core.LocalContentDatabase
    public final i b() {
        if(this.d != null) {
            return this.d;
        }
        synchronized(this) {
            if(this.d == null) {
                this.d = new i(this);
            }
            return this.d;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"local_contents"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"local_contents"});
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
        ((HashMap)map0).put(i.class, Collections.EMPTY_LIST);
        return map0;
    }
}

