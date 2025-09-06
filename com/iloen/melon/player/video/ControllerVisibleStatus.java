package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/video/ControllerVisibleStatus;", "", "All_VISIBLE", "ONLY_TITLE", "ONLY_SEEK", "ALL_GONE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum ControllerVisibleStatus {
    All_VISIBLE,
    ONLY_TITLE,
    ONLY_SEEK,
    ALL_GONE;

    public static final ControllerVisibleStatus[] a;
    public static final b b;

    static {
        ControllerVisibleStatus.a = arr_controllerVisibleStatus;
        q.g(arr_controllerVisibleStatus, "entries");
        ControllerVisibleStatus.b = new b(arr_controllerVisibleStatus);
    }

    @NotNull
    public static a getEntries() {
        return ControllerVisibleStatus.b;
    }
}

