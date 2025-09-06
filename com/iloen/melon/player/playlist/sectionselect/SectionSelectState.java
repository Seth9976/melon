package com.iloen.melon.player.playlist.sectionselect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;", "", "Companion", "STATE_IDLE", "STATE_START_POSITION", "STATE_END_POSITION", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum SectionSelectState {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0011\u0010\u0004\u001A\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState$Companion;", "", "Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;", "", "isSectionSelectMode", "(Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final boolean isSectionSelectMode(@NotNull SectionSelectState sectionSelectState0) {
            q.g(sectionSelectState0, "<this>");
            return sectionSelectState0 == SectionSelectState.STATE_START_POSITION || sectionSelectState0 == SectionSelectState.STATE_END_POSITION;
        }
    }

    STATE_IDLE,
    STATE_START_POSITION,
    STATE_END_POSITION;

    @NotNull
    public static final Companion Companion;
    public static final SectionSelectState[] a;
    public static final b b;

    static {
        SectionSelectState.a = arr_sectionSelectState;
        q.g(arr_sectionSelectState, "entries");
        SectionSelectState.b = new b(arr_sectionSelectState);
        SectionSelectState.Companion = new Companion(null);
    }

    @NotNull
    public static a getEntries() {
        return SectionSelectState.b;
    }
}

