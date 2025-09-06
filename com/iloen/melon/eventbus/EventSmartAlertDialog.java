package com.iloen.melon.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/eventbus/EventSmartAlertDialog;", "Lcom/iloen/melon/eventbus/EventSmartDialog;", "desc", "", "<init>", "(Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventSmartAlertDialog extends EventSmartDialog {
    public static final int $stable;
    @NotNull
    private final String desc;

    public EventSmartAlertDialog() {
        this(null, 1, null);
    }

    public EventSmartAlertDialog(@NotNull String s) {
        q.g(s, "desc");
        super(null);
        this.desc = s;
    }

    public EventSmartAlertDialog(String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = "";
        }
        this(s);
    }

    @NotNull
    public final String component1() {
        return this.desc;
    }

    @NotNull
    public final EventSmartAlertDialog copy(@NotNull String s) {
        q.g(s, "desc");
        return new EventSmartAlertDialog(s);
    }

    public static EventSmartAlertDialog copy$default(EventSmartAlertDialog eventSmartAlertDialog0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = eventSmartAlertDialog0.desc;
        }
        return eventSmartAlertDialog0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EventSmartAlertDialog ? q.b(this.desc, ((EventSmartAlertDialog)object0).desc) : false;
    }

    @NotNull
    public final String getDesc() [...] // 潜在的解密器

    @Override
    public int hashCode() {
        return this.desc.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "EventSmartAlertDialog(desc=" + this.desc + ")";
    }
}

