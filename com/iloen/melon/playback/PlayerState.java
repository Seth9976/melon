package com.iloen.melon.playback;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/playback/PlayerState;", "", "<init>", "(Ljava/lang/String;I)V", "Error", "Idle", "Initialized", "Preparing", "Prepared", "Started", "Paused", "Stopped", "PlaybackCompleted", "End", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum PlayerState {
    Error,
    Idle,
    Initialized,
    Preparing,
    Prepared,
    Started,
    Paused,
    Stopped,
    PlaybackCompleted,
    End;

    private static final a $ENTRIES;
    private static final PlayerState[] $VALUES;

    private static final PlayerState[] $values() [...] // Inlined contents

    static {
        PlayerState.$VALUES = arr_playerState;
        q.g(arr_playerState, "entries");
        PlayerState.$ENTRIES = new b(arr_playerState);
    }

    @NotNull
    public static a getEntries() {
        return PlayerState.$ENTRIES;
    }
}

