package com.iloen.melon.audioeffect;

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
import y8.s;

public final class SolMetaDatabase_Impl extends SolMetaDatabase {
    public volatile s c;

    @Override  // com.iloen.melon.audioeffect.SolMetaDatabase
    public final s b() {
        if(this.c != null) {
            return this.c;
        }
        synchronized(this) {
            if(this.c == null) {
                s s0 = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
                s0.a = this;
                s0.b = new f(20);
                s0.c = new h(7);
                this.c = s0;
            }
            return this.c;
        }
    }

    @Override  // androidx.room.H
    public final void clearAllTables() {
        this.performClear(false, new String[]{"SolMetaDataEntity"});
    }

    @Override  // androidx.room.H
    public final l createInvalidationTracker() {
        return new l(this, new HashMap(0), new HashMap(0), new String[]{"SolMetaDataEntity"});
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
        ((HashMap)map0).put(s.class, Collections.EMPTY_LIST);
        return map0;
    }
}

