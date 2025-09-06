package com.iloen.melon.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/eventbus/EventSmartAppUpdateNeedDialog;", "Lcom/iloen/melon/eventbus/EventSmartDialog;", "desc", "", "<init>", "(Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventSmartAppUpdateNeedDialog extends EventSmartDialog {
    public static final int $stable;
    @NotNull
    private final String desc;

    public EventSmartAppUpdateNeedDialog(@NotNull String s) {
        q.g(s, "desc");
        super(null);
        this.desc = s;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }
}

