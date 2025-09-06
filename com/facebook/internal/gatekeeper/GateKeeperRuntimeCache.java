package com.facebook.internal.gatekeeper;

import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000B\u001A\u00020\n2\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u00052\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000B\u0010\fJ#\u0010\r\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\r\u0010\u000EJ+\u0010\u0012\u001A\u00020\u00102\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u00052\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0015\u001A\u00020\n2\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u00052\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001A\u0004\u0018\u00010\b2\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u00052\u0006\u0010\u000F\u001A\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001A\u001A\u00020\n2\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u00052\u0006\u0010\u0019\u001A\u00020\b¢\u0006\u0004\b\u001A\u0010\u001BJ\u001B\u0010\u001C\u001A\u00020\n2\f\b\u0002\u0010\u0006\u001A\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001C\u0010\u001DR0\u0010\u001F\u001A\u001E\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u001E0\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "", "<init>", "()V", "", "Lcom/facebook/internal/gatekeeper/AppID;", "appId", "", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "gateKeeperList", "Lie/H;", "setGateKeepers", "(Ljava/lang/String;Ljava/util/List;)V", "dumpGateKeepers", "(Ljava/lang/String;)Ljava/util/List;", "name", "", "defaultValue", "getGateKeeperValue", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "value", "setGateKeeperValue", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getGateKeeper", "(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/internal/gatekeeper/GateKeeper;", "gateKeeper", "setGateKeeper", "(Ljava/lang/String;Lcom/facebook/internal/gatekeeper/GateKeeper;)V", "resetCache", "(Ljava/lang/String;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "gateKeepers", "Ljava/util/concurrent/ConcurrentHashMap;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GateKeeperRuntimeCache {
    @NotNull
    private final ConcurrentHashMap gateKeepers;

    public GateKeeperRuntimeCache() {
        this.gateKeepers = new ConcurrentHashMap();
    }

    @Nullable
    public final List dumpGateKeepers(@NotNull String s) {
        q.g(s, "appId");
        ConcurrentHashMap concurrentHashMap0 = (ConcurrentHashMap)this.gateKeepers.get(s);
        if(concurrentHashMap0 != null) {
            List list0 = new ArrayList(concurrentHashMap0.size());
            for(Object object0: concurrentHashMap0.entrySet()) {
                list0.add(((GateKeeper)((Map.Entry)object0).getValue()));
            }
            return list0;
        }
        return null;
    }

    public static List dumpGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache0.dumpGateKeepers(s);
    }

    @Nullable
    public final GateKeeper getGateKeeper(@NotNull String s, @NotNull String s1) {
        q.g(s, "appId");
        q.g(s1, "name");
        ConcurrentHashMap concurrentHashMap0 = (ConcurrentHashMap)this.gateKeepers.get(s);
        return concurrentHashMap0 == null ? null : ((GateKeeper)concurrentHashMap0.get(s1));
    }

    public static GateKeeper getGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache0.getGateKeeper(s, s1);
    }

    public final boolean getGateKeeperValue(@NotNull String s, @NotNull String s1, boolean z) {
        q.g(s, "appId");
        q.g(s1, "name");
        GateKeeper gateKeeper0 = this.getGateKeeper(s, s1);
        return gateKeeper0 == null ? z : gateKeeper0.getValue();
    }

    public static boolean getGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, String s1, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache0.getGateKeeperValue(s, s1, z);
    }

    public final void resetCache(@NotNull String s) {
        q.g(s, "appId");
        this.gateKeepers.remove(s);
    }

    public static void resetCache$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache0.resetCache(s);
    }

    public final void setGateKeeper(@NotNull String s, @NotNull GateKeeper gateKeeper0) {
        q.g(s, "appId");
        q.g(gateKeeper0, "gateKeeper");
        if(!this.gateKeepers.containsKey(s)) {
            ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
            this.gateKeepers.put(s, concurrentHashMap0);
        }
        ConcurrentHashMap concurrentHashMap1 = (ConcurrentHashMap)this.gateKeepers.get(s);
        if(concurrentHashMap1 != null) {
            concurrentHashMap1.put(gateKeeper0.getName(), gateKeeper0);
        }
    }

    public static void setGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, GateKeeper gateKeeper0, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache0.setGateKeeper(s, gateKeeper0);
    }

    public final void setGateKeeperValue(@NotNull String s, @NotNull String s1, boolean z) {
        q.g(s, "appId");
        q.g(s1, "name");
        this.setGateKeeper(s, new GateKeeper(s1, z));
    }

    public static void setGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, String s1, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache0.setGateKeeperValue(s, s1, z);
    }

    public final void setGateKeepers(@NotNull String s, @NotNull List list0) {
        q.g(s, "appId");
        q.g(list0, "gateKeeperList");
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
        for(Object object0: list0) {
            concurrentHashMap0.put(((GateKeeper)object0).getName(), ((GateKeeper)object0));
        }
        this.gateKeepers.put(s, concurrentHashMap0);
    }

    public static void setGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache0, String s, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache0.setGateKeepers(s, list0);
    }
}

