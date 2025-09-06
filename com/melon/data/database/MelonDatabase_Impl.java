package com.melon.data.database;

import Eb.f;
import Eb.o;
import androidx.room.M;
import androidx.room.l;
import ea.a;
import ea.b;
import ea.c;
import ea.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class MelonDatabase_Impl extends MelonDatabase {
    public volatile c b;
    public volatile b c;
    public volatile d d;
    public volatile a e;

    @Override  // com.melon.data.database.MelonDatabase
    public final a b() {
        if(this.e != null) {
            return this.e;
        }
        synchronized(this) {
            if(this.e == null) {
                this.e = new a(this);
            }
            return this.e;
        }
    }

    @Override  // com.melon.data.database.MelonDatabase
    public final b c() {
        if(this.c != null) {
            return this.c;
        }
        synchronized(this) {
            if(this.c == null) {
                b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b0.a = this;
                b0.b = new f(7);
                this.c = b0;
            }
            return this.c;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"search_history", "local_playback_log", "premium_off_play_log", "banner_popup", "user_equalizer", "response_cache"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"search_history", "local_playback_log", "premium_off_play_log", "banner_popup", "user_equalizer", "response_cache"});
    }

    @Override  // androidx.room.H
    public final M createOpenDelegate() {
        return new o(this);
    }

    @Override  // com.melon.data.database.MelonDatabase
    public final c d() {
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

    @Override  // com.melon.data.database.MelonDatabase
    public final d e() {
        if(this.d != null) {
            return this.d;
        }
        synchronized(this) {
            if(this.d == null) {
                this.d = new d(this);
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
        ((HashMap)map0).put(b.class, list0);
        ((HashMap)map0).put(d.class, list0);
        ((HashMap)map0).put(a.class, list0);
        return map0;
    }
}

