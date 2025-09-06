package com.iloen.melon.userstore;

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
import w9.c;
import w9.d;

public final class UserDatabase_Impl extends UserDatabase {
    public volatile d b;

    @Override  // com.iloen.melon.userstore.UserDatabase
    public final c b() {
        if(this.b != null) {
            return this.b;
        }
        synchronized(this) {
            if(this.b == null) {
                this.b = new d(this);
            }
            return this.b;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"dcf_extension_logs", "excluded_artist", "excluded_genre", "sync_info"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"dcf_extension_logs", "excluded_artist", "excluded_genre", "sync_info"});
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
        ((HashMap)map0).put(c.class, Collections.EMPTY_LIST);
        return map0;
    }
}

