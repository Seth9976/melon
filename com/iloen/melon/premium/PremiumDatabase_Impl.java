package com.iloen.melon.premium;

import Eb.f;
import Eb.o;
import H8.h;
import androidx.room.M;
import androidx.room.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o9.b;

public final class PremiumDatabase_Impl extends PremiumDatabase {
    public volatile b c;

    @Override  // com.iloen.melon.premium.PremiumDatabase
    public final b b() {
        if(this.c != null) {
            return this.c;
        }
        synchronized(this) {
            if(this.c == null) {
                b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b0.a = this;
                b0.b = new f(10);
                b0.c = new f(11);
                b0.d = new h(6);
                this.c = b0;
            }
            return this.c;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"premium_contents", "premium_playlist"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"premium_contents", "premium_playlist"});
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
        ((HashMap)map0).put(b.class, Collections.EMPTY_LIST);
        return map0;
    }
}

