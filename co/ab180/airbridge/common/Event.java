package co.ab180.airbridge.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BE\b\u0017\u0012\u0006\u0010\u0016\u001A\u00020\u0003\u0012\u0018\b\u0002\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017\u0012\u0018\b\u0002\u0010\t\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019RD\u0010\t\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0016\u0010\u0004\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\n\u0010\u000BRD\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0016\u0010\u0004\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\r\u0010\u0006\"\u0004\b\u000E\u0010\bR&\u0010\u0011\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u000BR\u0019\u0010\u0016\u001A\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/common/Event;", "", "", "", "value", "getCustomAttributes", "()Ljava/util/Map;", "setCustomAttributes", "(Ljava/util/Map;)V", "customAttributes", "b", "Ljava/util/Map;", "_semanticAttributes", "getSemanticAttributes", "setSemanticAttributes", "semanticAttributes", "c", "_customAttributes", "a", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "category", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class Event {
    @NotNull
    private final String a;
    private Map b;
    private Map c;

    public Event(@NotNull String s) {
        this(s, null, null, 6, null);
    }

    public Event(@NotNull String s, @Nullable Map map0) {
        this(s, map0, null, 4, null);
    }

    public Event(@NotNull String s, @Nullable Map map0, @Nullable Map map1) {
        this.a = s;
        LinkedHashMap linkedHashMap0 = null;
        if(map0 == null || map0.isEmpty()) {
            map0 = null;
        }
        this.setSemanticAttributes((map0 == null ? null : C.a0(map0)));
        if(map1 == null || map1.isEmpty()) {
            map1 = null;
        }
        if(map1 != null) {
            linkedHashMap0 = C.a0(map1);
        }
        this.setCustomAttributes(linkedHashMap0);
    }

    public Event(String s, Map map0, Map map1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            map0 = null;
        }
        if((v & 4) != 0) {
            map1 = null;
        }
        this(s, map0, map1);
    }

    @NotNull
    public final String getCategory() {
        return this.a;
    }

    @Nullable
    public final Map getCustomAttributes() {
        return this.c;
    }

    @Nullable
    public final Map getSemanticAttributes() {
        return this.b;
    }

    public final void setCustomAttributes(@Nullable Map map0) {
        if(map0 != null && !map0.isEmpty()) {
            this.c = new HashMap(map0);
            return;
        }
        this.c = null;
    }

    public final void setSemanticAttributes(@Nullable Map map0) {
        if(map0 != null && !map0.isEmpty()) {
            this.b = new HashMap(map0);
            return;
        }
        this.b = null;
    }
}

