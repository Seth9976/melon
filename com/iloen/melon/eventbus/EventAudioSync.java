package com.iloen.melon.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/eventbus/EventAudioSync;", "", "<init>", "()V", "Companion", "Finish", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventAudioSync {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/eventbus/EventAudioSync$Companion;", "", "<init>", "()V", "SYNC_ALL", "", "SYNC_MEDIA_STORE", "SYNC_DCF", "SYNC_DCF_UPDATE", "SYNC_DCF_INSERT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "", "type", "", "updateCount", "<init>", "(II)V", "getType", "()I", "getUpdateCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Finish {
        public static final int $stable;
        private final int type;
        private final int updateCount;

        public Finish(int v, int v1) {
            this.type = v;
            this.updateCount = v1;
        }

        public final int getType() {
            return this.type;
        }

        public final int getUpdateCount() {
            return this.updateCount;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int SYNC_ALL = 0;
    public static final int SYNC_DCF = 2;
    public static final int SYNC_DCF_INSERT = 4;
    public static final int SYNC_DCF_UPDATE = 3;
    public static final int SYNC_MEDIA_STORE = 1;

    static {
        EventAudioSync.Companion = new Companion(null);
    }
}

