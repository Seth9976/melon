package com.iloen.melon.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/eventbus/EventPremiumCacheDelete;", "", "cType", "", "<init>", "(Ljava/lang/String;)V", "getCType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventPremiumCacheDelete {
    public static final int $stable;
    @NotNull
    private final String cType;

    public EventPremiumCacheDelete(@NotNull String s) {
        q.g(s, "cType");
        super();
        this.cType = s;
    }

    @NotNull
    public final String component1() {
        return this.cType;
    }

    @NotNull
    public final EventPremiumCacheDelete copy(@NotNull String s) {
        q.g(s, "cType");
        return new EventPremiumCacheDelete(s);
    }

    public static EventPremiumCacheDelete copy$default(EventPremiumCacheDelete eventPremiumCacheDelete0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = eventPremiumCacheDelete0.cType;
        }
        return eventPremiumCacheDelete0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EventPremiumCacheDelete ? q.b(this.cType, ((EventPremiumCacheDelete)object0).cType) : false;
    }

    @NotNull
    public final String getCType() {
        return this.cType;
    }

    @Override
    public int hashCode() {
        return this.cType.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "EventPremiumCacheDelete(cType=" + this.cType + ")";
    }
}

