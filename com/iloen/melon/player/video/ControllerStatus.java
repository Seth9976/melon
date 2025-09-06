package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/player/video/ControllerStatus;", "", "VOD_NORMAL", "VOD_NORMAL_LAND", "VOD_FULL", "VOD_FULL_LAND", "LIVE_NORMAL", "LIVE_NORMAL_LAND", "LIVE_FULL", "LIVE_FULL_LAND", "PREVIEW_NORMAL", "PREVIEW_NORMAL_LAND", "PREVIEW_FULL", "PREVIEW_FULL_LAND", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum ControllerStatus {
    VOD_NORMAL,
    VOD_NORMAL_LAND,
    VOD_FULL,
    VOD_FULL_LAND,
    LIVE_NORMAL,
    LIVE_NORMAL_LAND,
    LIVE_FULL,
    LIVE_FULL_LAND,
    PREVIEW_NORMAL,
    PREVIEW_NORMAL_LAND,
    PREVIEW_FULL,
    PREVIEW_FULL_LAND;

    public static final ControllerStatus[] a;
    public static final b b;

    static {
        ControllerStatus.a = arr_controllerStatus;
        q.g(arr_controllerStatus, "entries");
        ControllerStatus.b = new b(arr_controllerStatus);
    }

    @NotNull
    public static a getEntries() {
        return ControllerStatus.b;
    }
}

