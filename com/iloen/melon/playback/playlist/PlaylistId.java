package com.iloen.melon.playback.playlist;

import e.k;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\'B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001A\u00020\u0017J\u0006\u0010\u0018\u001A\u00020\u0017J\u0006\u0010\u0019\u001A\u00020\u0017J\u0006\u0010\u001A\u001A\u00020\u0017J\b\u0010\u001B\u001A\u00020\u0017H\u0007J\b\u0010\u001C\u001A\u00020\u0017H\u0007J\u0006\u0010\u001D\u001A\u00020\u0017J\u0006\u0010\u001E\u001A\u00020\u0017J\u0006\u0010\u001F\u001A\u00020\u0017J\u0006\u0010 \u001A\u00020\u0017J\u0006\u0010!\u001A\u00020\u0017J\u0006\u0010\"\u001A\u00020\u0017J\u0006\u0010#\u001A\u00020\u0017J\u0006\u0010$\u001A\u00020\u0017J\u0006\u0010%\u001A\u00020\u0017J\u0006\u0010&\u001A\u00020\u0017R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006("}, d2 = {"Lcom/iloen/melon/playback/playlist/PlaylistId;", "", "seq", "", "<init>", "(Ljava/lang/String;II)V", "getSeq", "()I", "EMPTY", "MUSIC", "VOD", "MELON_RADIO", "PLAYLIST", "EDU", "TEMP", "SPORT", "STATION", "LIVE", "SMART", "DRAWER", "MIX_UP", "MUSIC_WAVE", "isEmpty", "", "isVod", "isStation", "isMusic", "isEdu", "isTabPlaylist", "isTemp", "isLive", "isSmart", "isDrawer", "isMixUp", "isMusicWave", "isAudioType", "isOfflineSupport", "isVideoType", "isDeprecated", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum PlaylistId {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001A\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/playback/playlist/PlaylistId$Companion;", "", "<init>", "()V", "makePlaylistId", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistId makePlaylistId(int v) {
            PlaylistId playlistId0 = PlaylistId.EMPTY;
            if(v != playlistId0.getSeq()) {
                PlaylistId playlistId1 = PlaylistId.MUSIC;
                if(v == playlistId1.getSeq()) {
                    return playlistId1;
                }
                PlaylistId playlistId2 = PlaylistId.VOD;
                if(v == playlistId2.getSeq()) {
                    return playlistId2;
                }
                PlaylistId playlistId3 = PlaylistId.PLAYLIST;
                if(v == playlistId3.getSeq()) {
                    return playlistId3;
                }
                PlaylistId playlistId4 = PlaylistId.EDU;
                if(v == playlistId4.getSeq()) {
                    return playlistId4;
                }
                PlaylistId playlistId5 = PlaylistId.TEMP;
                if(v == playlistId5.getSeq()) {
                    return playlistId5;
                }
                PlaylistId playlistId6 = PlaylistId.STATION;
                if(v == playlistId6.getSeq()) {
                    return playlistId6;
                }
                PlaylistId playlistId7 = PlaylistId.LIVE;
                if(v == playlistId7.getSeq()) {
                    return playlistId7;
                }
                PlaylistId playlistId8 = PlaylistId.MELON_RADIO;
                if(v == playlistId8.getSeq()) {
                    return playlistId8;
                }
                PlaylistId playlistId9 = PlaylistId.SPORT;
                if(v == playlistId9.getSeq()) {
                    return playlistId9;
                }
                PlaylistId playlistId10 = PlaylistId.SMART;
                if(v == playlistId10.getSeq()) {
                    return playlistId10;
                }
                PlaylistId playlistId11 = PlaylistId.DRAWER;
                if(v == playlistId11.getSeq()) {
                    return playlistId11;
                }
                PlaylistId playlistId12 = PlaylistId.MIX_UP;
                if(v == playlistId12.getSeq()) {
                    return playlistId12;
                }
                return v == PlaylistId.MUSIC_WAVE.getSeq() ? PlaylistId.MUSIC_WAVE : playlistId0;
            }
            return playlistId0;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[PlaylistId.values().length];
            try {
                arr_v[PlaylistId.VOD.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.TEMP.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.LIVE.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.EMPTY.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.MUSIC.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.SMART.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.DRAWER.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    EMPTY(-1),
    MUSIC(0),
    VOD(1),
    @d
    MELON_RADIO(2),
    @d
    PLAYLIST(3),
    @d
    EDU(4),
    TEMP(5),
    @d
    SPORT(6),
    STATION(8),
    LIVE(9),
    SMART(10),
    DRAWER(11),
    MIX_UP(12),
    MUSIC_WAVE(13);

    private static final a $ENTRIES;
    private static final PlaylistId[] $VALUES;
    @NotNull
    public static final Companion Companion;
    private final int seq;

    private static final PlaylistId[] $values() [...] // Inlined contents

    static {
        PlaylistId.$VALUES = arr_playlistId;
        q.g(arr_playlistId, "entries");
        PlaylistId.$ENTRIES = new b(arr_playlistId);
        PlaylistId.Companion = new Companion(null);
    }

    private PlaylistId(int v1) {
        this.seq = v1;
    }

    @NotNull
    public static a getEntries() {
        return PlaylistId.$ENTRIES;
    }

    public final int getSeq() {
        return this.seq;
    }

    public final boolean isAudioType() {
        switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return false;
            }
            default: {
                return true;
            }
        }
    }

    public final boolean isDeprecated() {
        return k.A(new PlaylistId[]{PlaylistId.MELON_RADIO, PlaylistId.PLAYLIST, PlaylistId.EDU, PlaylistId.SPORT}).contains(this);
    }

    public final boolean isDrawer() [...] // 潜在的解密器

    @d
    public final boolean isEdu() [...] // 潜在的解密器

    public final boolean isEmpty() [...] // 潜在的解密器

    public final boolean isLive() [...] // 潜在的解密器

    public final boolean isMixUp() {
        return this == PlaylistId.MIX_UP;
    }

    public final boolean isMusic() [...] // 潜在的解密器

    public final boolean isMusicWave() [...] // 潜在的解密器

    public final boolean isOfflineSupport() {
        switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 5: 
            case 6: 
            case 7: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public final boolean isSmart() [...] // 潜在的解密器

    public final boolean isStation() [...] // 潜在的解密器

    @d
    public final boolean isTabPlaylist() [...] // 潜在的解密器

    public final boolean isTemp() {
        return this == PlaylistId.TEMP;
    }

    public final boolean isVideoType() [...] // 潜在的解密器

    public final boolean isVod() [...] // 潜在的解密器
}

