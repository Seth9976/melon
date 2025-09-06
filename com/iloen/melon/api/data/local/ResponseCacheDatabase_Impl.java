package com.iloen.melon.api.data.local;

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
import s8.a;

public final class ResponseCacheDatabase_Impl extends ResponseCacheDatabase {
    public volatile a c;

    @Override  // com.iloen.melon.api.data.local.ResponseCacheDatabase
    public final a b() {
        if(this.c != null) {
            return this.c;
        }
        synchronized(this) {
            if(this.c == null) {
                this.c = new a(this);
            }
            return this.c;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"response_cache"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"response_cache"});
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
        ((HashMap)map0).put(a.class, Collections.EMPTY_LIST);
        return map0;
    }
}

