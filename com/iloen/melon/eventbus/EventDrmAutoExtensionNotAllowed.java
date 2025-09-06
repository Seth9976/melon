package com.iloen.melon.eventbus;

import Yb.h;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/eventbus/EventDrmAutoExtensionNotAllowed;", "", "LYb/h;", "exception", "<init>", "(LYb/h;)V", "component1", "()LYb/h;", "copy", "(LYb/h;)Lcom/iloen/melon/eventbus/EventDrmAutoExtensionNotAllowed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LYb/h;", "getException", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventDrmAutoExtensionNotAllowed {
    public static final int $stable = 8;
    @NotNull
    private final h exception;

    public EventDrmAutoExtensionNotAllowed(@NotNull h h0) {
        q.g(h0, "exception");
        super();
        this.exception = h0;
    }

    @NotNull
    public final h component1() {
        return this.exception;
    }

    @NotNull
    public final EventDrmAutoExtensionNotAllowed copy(@NotNull h h0) {
        q.g(h0, "exception");
        return new EventDrmAutoExtensionNotAllowed(h0);
    }

    public static EventDrmAutoExtensionNotAllowed copy$default(EventDrmAutoExtensionNotAllowed eventDrmAutoExtensionNotAllowed0, h h0, int v, Object object0) {
        if((v & 1) != 0) {
            h0 = eventDrmAutoExtensionNotAllowed0.exception;
        }
        return eventDrmAutoExtensionNotAllowed0.copy(h0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EventDrmAutoExtensionNotAllowed ? q.b(this.exception, ((EventDrmAutoExtensionNotAllowed)object0).exception) : false;
    }

    @NotNull
    public final h getException() {
        return this.exception;
    }

    @Override
    public int hashCode() {
        return this.exception.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "EventDrmAutoExtensionNotAllowed(exception=" + this.exception + ")";
    }
}

