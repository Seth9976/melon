package com.iloen.melon.player.playlist.drawernew.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytType;", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public @interface DrawerPlytType {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytType$Companion;", "", "", "LIKE", "Ljava/lang/String;", "RECENT", "MIX", "PLAYLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        @NotNull
        public static final String LIKE = "like";
        @NotNull
        public static final String MIX = "mix";
        @NotNull
        public static final String PLAYLIST = "playlist";
        @NotNull
        public static final String RECENT = "recent";
        public static final Companion a;

        static {
            Companion.a = new Companion();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String LIKE = "like";
    @NotNull
    public static final String MIX = "mix";
    @NotNull
    public static final String PLAYLIST = "playlist";
    @NotNull
    public static final String RECENT = "recent";

    static {
        DrawerPlytType.Companion = Companion.a;
    }
}

