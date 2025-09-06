package com.iloen.melon.player.video;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/video/VideoStatus;", "", "", "getMotionStateId", "()I", "Companion", "MiniMode", "Expand", "FullScreen", "Undefined", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum VideoStatus {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/player/video/VideoStatus$Companion;", "", "", "motionId", "Lcom/iloen/melon/player/video/VideoStatus;", "newInstance", "(I)Lcom/iloen/melon/player/video/VideoStatus;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoStatus newInstance(int v) {
            switch(v) {
                case 0x7F0A0471: {  // id:expand
                    return VideoStatus.Expand;
                }
                case 0x7F0A04E2: {  // id:full
                    return VideoStatus.FullScreen;
                }
                case 0x7F0A0808: {  // id:mini
                    return VideoStatus.MiniMode;
                }
                default: {
                    return VideoStatus.Undefined;
                }
            }
        }
    }

    MiniMode(0x7F0A0808),  // id:mini
    Expand(0x7F0A0471),  // id:expand
    FullScreen(0x7F0A04E2),  // id:full
    Undefined(0x7F0A0471);  // id:expand

    @NotNull
    public static final Companion Companion;
    public final int a;
    public static final VideoStatus[] b;
    public static final b c;

    static {
        VideoStatus.b = arr_videoStatus;
        q.g(arr_videoStatus, "entries");
        VideoStatus.c = new b(arr_videoStatus);
        VideoStatus.Companion = new Companion(null);
    }

    public VideoStatus(int v1) {
        this.a = v1;
    }

    @NotNull
    public static a getEntries() {
        return VideoStatus.c;
    }

    public final int getMotionStateId() {
        return this.a;
    }
}

