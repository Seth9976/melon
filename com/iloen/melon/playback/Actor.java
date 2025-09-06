package com.iloen.melon.playback;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/playback/Actor;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Widget", "Widget_2x1", "Widget_2x2", "Widget_4x1", "Widget_4x2", "Widget_cover", "StatusBar", "MediaButton", "EdgeSingle", "EdgeSinglePlus", "RemoteControl", "MelonAppSvc", "AndroidAuto", "CarMode", "PlayerLock", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum Actor {
    Normal,
    Widget,
    Widget_2x1,
    Widget_2x2,
    Widget_4x1,
    Widget_4x2,
    Widget_cover,
    StatusBar,
    MediaButton,
    EdgeSingle,
    EdgeSinglePlus,
    RemoteControl,
    MelonAppSvc,
    AndroidAuto,
    CarMode,
    PlayerLock;

    private static final a $ENTRIES;
    private static final Actor[] $VALUES;

    private static final Actor[] $values() [...] // Inlined contents

    static {
        Actor.$VALUES = arr_actor;
        q.g(arr_actor, "entries");
        Actor.$ENTRIES = new b(arr_actor);
    }

    @NotNull
    public static a getEntries() {
        return Actor.$ENTRIES;
    }
}

