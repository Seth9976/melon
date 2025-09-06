package com.iloen.melon.playback.playlist.db.entity;

import A7.d;
import H0.b;
import U4.x;
import com.iloen.melon.playback.Playable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\bV\b\u0087\b\u0018\u0000 c2\u00020\u0001:\u0001cB\u00A7\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0005\u0012\b\b\u0002\u0010\n\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0019\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u001A\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u001B\u001A\u00020\f\u0012\b\b\u0002\u0010\u001C\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u001D\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u001E\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u001F\u001A\u00020\u0003\u0012\b\b\u0002\u0010 \u001A\u00020\u0005\u0012\b\b\u0002\u0010!\u001A\u00020\u0005\u0012\b\b\u0002\u0010\"\u001A\u00020\u0005\u00A2\u0006\u0004\b#\u0010$J\t\u0010A\u001A\u00020\u0003H\u00C6\u0003J\t\u0010B\u001A\u00020\u0005H\u00C6\u0003J\t\u0010C\u001A\u00020\u0005H\u00C6\u0003J\t\u0010D\u001A\u00020\u0005H\u00C6\u0003J\t\u0010E\u001A\u00020\u0005H\u00C6\u0003J\t\u0010F\u001A\u00020\u0005H\u00C6\u0003J\t\u0010G\u001A\u00020\u0005H\u00C6\u0003J\t\u0010H\u001A\u00020\fH\u00C6\u0003J\t\u0010I\u001A\u00020\u000EH\u00C6\u0003J\t\u0010J\u001A\u00020\u0003H\u00C6\u0003J\t\u0010K\u001A\u00020\u0005H\u00C6\u0003J\t\u0010L\u001A\u00020\u0005H\u00C6\u0003J\t\u0010M\u001A\u00020\u000EH\u00C6\u0003J\t\u0010N\u001A\u00020\u0005H\u00C6\u0003J\t\u0010O\u001A\u00020\u0005H\u00C6\u0003J\t\u0010P\u001A\u00020\u0005H\u00C6\u0003J\t\u0010Q\u001A\u00020\u0003H\u00C6\u0003J\t\u0010R\u001A\u00020\u000EH\u00C6\u0003J\t\u0010S\u001A\u00020\u000EH\u00C6\u0003J\t\u0010T\u001A\u00020\u000EH\u00C6\u0003J\t\u0010U\u001A\u00020\u000EH\u00C6\u0003J\t\u0010V\u001A\u00020\fH\u00C6\u0003J\t\u0010W\u001A\u00020\u0003H\u00C6\u0003J\t\u0010X\u001A\u00020\u0005H\u00C6\u0003J\t\u0010Y\u001A\u00020\u0005H\u00C6\u0003J\t\u0010Z\u001A\u00020\u0003H\u00C6\u0003J\t\u0010[\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\\\u001A\u00020\u0005H\u00C6\u0003J\t\u0010]\u001A\u00020\u0005H\u00C6\u0003J\u00AB\u0002\u0010^\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u00052\b\b\u0002\u0010\u0014\u001A\u00020\u00052\b\b\u0002\u0010\u0015\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u000E2\b\b\u0002\u0010\u0019\u001A\u00020\u000E2\b\b\u0002\u0010\u001A\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\f2\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00052\b\b\u0002\u0010!\u001A\u00020\u00052\b\b\u0002\u0010\"\u001A\u00020\u0005H\u00C6\u0001J\u0013\u0010_\u001A\u00020\u000E2\b\u0010`\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010a\u001A\u00020\u0003H\u00D6\u0001J\t\u0010b\u001A\u00020\u0005H\u00D6\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0016\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b)\u0010(R\u0016\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b*\u0010(R\u0016\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b+\u0010(R\u0016\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b,\u0010(R\u0016\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b-\u0010(R\u0016\u0010\u000B\u001A\u00020\f8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0016\u0010\r\u001A\u00020\u000E8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\r\u00100R\u0016\u0010\u000F\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b1\u0010&R\u0016\u0010\u0010\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b2\u0010(R\u0016\u0010\u0011\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b3\u0010(R\u0016\u0010\u0012\u001A\u00020\u000E8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b4\u00100R\u0016\u0010\u0013\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b5\u0010(R\u0016\u0010\u0014\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b6\u0010(R\u0016\u0010\u0015\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b7\u0010(R\u0016\u0010\u0016\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b8\u0010&R\u0016\u0010\u0017\u001A\u00020\u000E8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u00100R\u0016\u0010\u0018\u001A\u00020\u000E8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u00100R\u0016\u0010\u0019\u001A\u00020\u000E8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u00100R\u0016\u0010\u001A\u001A\u00020\u000E8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u00100R\u0016\u0010\u001B\u001A\u00020\f8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b9\u0010/R\u0016\u0010\u001C\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b:\u0010&R\u0016\u0010\u001D\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b;\u0010(R\u0016\u0010\u001E\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b<\u0010(R\u0016\u0010\u001F\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b=\u0010&R\u0016\u0010 \u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b>\u0010(R\u0016\u0010!\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b?\u0010(R\u0016\u0010\"\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b@\u0010(\u00A8\u0006d"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity;", "", "songId", "", "title", "", "data", "album", "albumId", "artist", "artistId", "duration", "", "isAdult", "", "origin", "menuId", "originMenuId", "hasMv", "mvName", "mvId", "cType", "playCount", "isFree", "isHitSong", "isHoldBack", "isTitle", "createdAt", "createdSeq", "albumImgPath", "albumThumbPath", "displayOrder", "statsElements", "uriString", "displayName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZJILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSongId", "()I", "getTitle", "()Ljava/lang/String;", "getData", "getAlbum", "getAlbumId", "getArtist", "getArtistId", "getDuration", "()J", "()Z", "getOrigin", "getMenuId", "getOriginMenuId", "getHasMv", "getMvName", "getMvId", "getCType", "getPlayCount", "getCreatedAt", "getCreatedSeq", "getAlbumImgPath", "getAlbumThumbPath", "getDisplayOrder", "getStatsElements", "getUriString", "getDisplayName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableEntity {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity;", "p", "Lcom/iloen/melon/playback/Playable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(41)
        @NotNull
        public final PlayableEntity newInstance(@NotNull Playable playable0) {
            q.g(playable0, "p");
            int v = playable0.getSongid();
            long v1 = playable0.getDuration();
            boolean z = playable0.isAdult();
            int v2 = playable0.origin;
            boolean z1 = playable0.hasMv();
            String s = playable0.getCtype().getValue();
            if(s == null) {
                s = "";
            }
            boolean z2 = playable0.isFree();
            boolean z3 = playable0.isHitSong();
            boolean z4 = playable0.isHoldback();
            boolean z5 = playable0.isTitle();
            q.f("", "getStatsElements(...)");
            q.f("", "getUriString(...)");
            q.f("", "getDisplayName(...)");
            return new PlayableEntity(v, "", "", "", "", "", "", v1, z, v2, "", "", z1, "", "", s, playable0.getPlayCount(), z2, z3, z4, z5, playable0.getCreatedAt(), playable0.getCreatedSeq(), "", "", playable0.getOrder(), "", "", "");
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String album;
    @NotNull
    private final String albumId;
    @NotNull
    private final String albumImgPath;
    @NotNull
    private final String albumThumbPath;
    @NotNull
    private final String artist;
    @NotNull
    private final String artistId;
    @NotNull
    private final String cType;
    private final long createdAt;
    private final int createdSeq;
    @NotNull
    private final String data;
    @NotNull
    private final String displayName;
    private final int displayOrder;
    private final long duration;
    private final boolean hasMv;
    private final boolean isAdult;
    private final boolean isFree;
    private final boolean isHitSong;
    private final boolean isHoldBack;
    private final boolean isTitle;
    @NotNull
    private final String menuId;
    @NotNull
    private final String mvId;
    @NotNull
    private final String mvName;
    private final int origin;
    @NotNull
    private final String originMenuId;
    private final int playCount;
    private final int songId;
    @NotNull
    private final String statsElements;
    @NotNull
    private final String title;
    @NotNull
    private final String uriString;

    static {
        PlayableEntity.Companion = new Companion(null);
    }

    public PlayableEntity(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, long v1, boolean z, int v2, @NotNull String s6, @NotNull String s7, boolean z1, @NotNull String s8, @NotNull String s9, @NotNull String s10, int v3, boolean z2, boolean z3, boolean z4, boolean z5, long v4, int v5, @NotNull String s11, @NotNull String s12, int v6, @NotNull String s13, @NotNull String s14, @NotNull String s15) {
        q.g(s, "title");
        q.g(s1, "data");
        q.g(s2, "album");
        q.g(s3, "albumId");
        q.g(s4, "artist");
        q.g(s5, "artistId");
        q.g(s6, "menuId");
        q.g(s7, "originMenuId");
        q.g(s8, "mvName");
        q.g(s9, "mvId");
        q.g(s10, "cType");
        q.g(s11, "albumImgPath");
        q.g(s12, "albumThumbPath");
        q.g(s13, "statsElements");
        q.g(s14, "uriString");
        q.g(s15, "displayName");
        super();
        this.songId = v;
        this.title = s;
        this.data = s1;
        this.album = s2;
        this.albumId = s3;
        this.artist = s4;
        this.artistId = s5;
        this.duration = v1;
        this.isAdult = z;
        this.origin = v2;
        this.menuId = s6;
        this.originMenuId = s7;
        this.hasMv = z1;
        this.mvName = s8;
        this.mvId = s9;
        this.cType = s10;
        this.playCount = v3;
        this.isFree = z2;
        this.isHitSong = z3;
        this.isHoldBack = z4;
        this.isTitle = z5;
        this.createdAt = v4;
        this.createdSeq = v5;
        this.albumImgPath = s11;
        this.albumThumbPath = s12;
        this.displayOrder = v6;
        this.statsElements = s13;
        this.uriString = s14;
        this.displayName = s15;
    }

    public PlayableEntity(int v, String s, String s1, String s2, String s3, String s4, String s5, long v1, boolean z, int v2, String s6, String s7, boolean z1, String s8, String s9, String s10, int v3, boolean z2, boolean z3, boolean z4, boolean z5, long v4, int v5, String s11, String s12, int v6, String s13, String s14, String s15, int v7, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, ((v7 & 2) == 0 ? s : ""), ((v7 & 4) == 0 ? s1 : ""), ((v7 & 8) == 0 ? s2 : ""), ((v7 & 16) == 0 ? s3 : ""), ((v7 & 0x20) == 0 ? s4 : ""), ((v7 & 0x40) == 0 ? s5 : ""), ((v7 & 0x80) == 0 ? v1 : -1L), ((v7 & 0x100) == 0 ? z : false), ((v7 & 0x200) == 0 ? v2 : 0), ((v7 & 0x400) == 0 ? s6 : ""), ((v7 & 0x800) == 0 ? s7 : ""), ((v7 & 0x1000) == 0 ? z1 : false), ((v7 & 0x2000) == 0 ? s8 : ""), ((v7 & 0x4000) == 0 ? s9 : ""), ((v7 & 0x8000) == 0 ? s10 : ""), ((v7 & 0x10000) == 0 ? v3 : 0), ((v7 & 0x20000) == 0 ? z2 : false), ((v7 & 0x40000) == 0 ? z3 : false), ((v7 & 0x80000) == 0 ? z4 : false), ((v7 & 0x100000) == 0 ? z5 : false), ((v7 & 0x200000) == 0 ? v4 : -1L), ((v7 & 0x400000) == 0 ? v5 : -1), ((v7 & 0x800000) == 0 ? s11 : ""), ((v7 & 0x1000000) == 0 ? s12 : ""), ((v7 & 0x2000000) == 0 ? v6 : 0), ((v7 & 0x4000000) == 0 ? s13 : ""), ((v7 & 0x8000000) == 0 ? s14 : ""), ((v7 & 0x10000000) == 0 ? s15 : ""));
    }

    public final int component1() {
        return this.songId;
    }

    public final int component10() {
        return this.origin;
    }

    @NotNull
    public final String component11() {
        return this.menuId;
    }

    @NotNull
    public final String component12() {
        return this.originMenuId;
    }

    public final boolean component13() {
        return this.hasMv;
    }

    @NotNull
    public final String component14() {
        return this.mvName;
    }

    @NotNull
    public final String component15() {
        return this.mvId;
    }

    @NotNull
    public final String component16() {
        return this.cType;
    }

    public final int component17() {
        return this.playCount;
    }

    public final boolean component18() {
        return this.isFree;
    }

    public final boolean component19() {
        return this.isHitSong;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final boolean component20() {
        return this.isHoldBack;
    }

    public final boolean component21() {
        return this.isTitle;
    }

    public final long component22() {
        return this.createdAt;
    }

    public final int component23() {
        return this.createdSeq;
    }

    @NotNull
    public final String component24() {
        return this.albumImgPath;
    }

    @NotNull
    public final String component25() {
        return this.albumThumbPath;
    }

    public final int component26() {
        return this.displayOrder;
    }

    @NotNull
    public final String component27() {
        return this.statsElements;
    }

    @NotNull
    public final String component28() {
        return this.uriString;
    }

    @NotNull
    public final String component29() {
        return this.displayName;
    }

    @NotNull
    public final String component3() {
        return this.data;
    }

    @NotNull
    public final String component4() {
        return this.album;
    }

    @NotNull
    public final String component5() {
        return this.albumId;
    }

    @NotNull
    public final String component6() {
        return this.artist;
    }

    @NotNull
    public final String component7() {
        return this.artistId;
    }

    public final long component8() {
        return this.duration;
    }

    public final boolean component9() {
        return this.isAdult;
    }

    @NotNull
    public final PlayableEntity copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, long v1, boolean z, int v2, @NotNull String s6, @NotNull String s7, boolean z1, @NotNull String s8, @NotNull String s9, @NotNull String s10, int v3, boolean z2, boolean z3, boolean z4, boolean z5, long v4, int v5, @NotNull String s11, @NotNull String s12, int v6, @NotNull String s13, @NotNull String s14, @NotNull String s15) {
        q.g(s, "title");
        q.g(s1, "data");
        q.g(s2, "album");
        q.g(s3, "albumId");
        q.g(s4, "artist");
        q.g(s5, "artistId");
        q.g(s6, "menuId");
        q.g(s7, "originMenuId");
        q.g(s8, "mvName");
        q.g(s9, "mvId");
        q.g(s10, "cType");
        q.g(s11, "albumImgPath");
        q.g(s12, "albumThumbPath");
        q.g(s13, "statsElements");
        q.g(s14, "uriString");
        q.g(s15, "displayName");
        return new PlayableEntity(v, s, s1, s2, s3, s4, s5, v1, z, v2, s6, s7, z1, s8, s9, s10, v3, z2, z3, z4, z5, v4, v5, s11, s12, v6, s13, s14, s15);
    }

    public static PlayableEntity copy$default(PlayableEntity playableEntity0, int v, String s, String s1, String s2, String s3, String s4, String s5, long v1, boolean z, int v2, String s6, String s7, boolean z1, String s8, String s9, String s10, int v3, boolean z2, boolean z3, boolean z4, boolean z5, long v4, int v5, String s11, String s12, int v6, String s13, String s14, String s15, int v7, Object object0) {
        int v8 = (v7 & 1) == 0 ? v : playableEntity0.songId;
        String s16 = (v7 & 2) == 0 ? s : playableEntity0.title;
        String s17 = (v7 & 4) == 0 ? s1 : playableEntity0.data;
        String s18 = (v7 & 8) == 0 ? s2 : playableEntity0.album;
        String s19 = (v7 & 16) == 0 ? s3 : playableEntity0.albumId;
        String s20 = (v7 & 0x20) == 0 ? s4 : playableEntity0.artist;
        String s21 = (v7 & 0x40) == 0 ? s5 : playableEntity0.artistId;
        long v9 = (v7 & 0x80) == 0 ? v1 : playableEntity0.duration;
        boolean z6 = (v7 & 0x100) == 0 ? z : playableEntity0.isAdult;
        int v10 = (v7 & 0x200) == 0 ? v2 : playableEntity0.origin;
        String s22 = (v7 & 0x400) == 0 ? s6 : playableEntity0.menuId;
        String s23 = (v7 & 0x800) == 0 ? s7 : playableEntity0.originMenuId;
        boolean z7 = (v7 & 0x1000) == 0 ? z1 : playableEntity0.hasMv;
        String s24 = (v7 & 0x2000) == 0 ? s8 : playableEntity0.mvName;
        String s25 = (v7 & 0x4000) == 0 ? s9 : playableEntity0.mvId;
        String s26 = (v7 & 0x8000) == 0 ? s10 : playableEntity0.cType;
        int v11 = (v7 & 0x10000) == 0 ? v3 : playableEntity0.playCount;
        boolean z8 = (v7 & 0x20000) == 0 ? z2 : playableEntity0.isFree;
        boolean z9 = (v7 & 0x40000) == 0 ? z3 : playableEntity0.isHitSong;
        boolean z10 = (v7 & 0x80000) == 0 ? z4 : playableEntity0.isHoldBack;
        boolean z11 = (v7 & 0x100000) == 0 ? z5 : playableEntity0.isTitle;
        long v12 = (v7 & 0x200000) == 0 ? v4 : playableEntity0.createdAt;
        int v13 = (v7 & 0x400000) == 0 ? v5 : playableEntity0.createdSeq;
        String s27 = (v7 & 0x800000) == 0 ? s11 : playableEntity0.albumImgPath;
        String s28 = (v7 & 0x1000000) == 0 ? s12 : playableEntity0.albumThumbPath;
        int v14 = (v7 & 0x2000000) == 0 ? v6 : playableEntity0.displayOrder;
        String s29 = (v7 & 0x4000000) == 0 ? s13 : playableEntity0.statsElements;
        String s30 = (v7 & 0x8000000) == 0 ? s14 : playableEntity0.uriString;
        return (v7 & 0x10000000) == 0 ? playableEntity0.copy(v8, s16, s17, s18, s19, s20, s21, v9, z6, v10, s22, s23, z7, s24, s25, s26, v11, z8, z9, z10, z11, v12, v13, s27, s28, v14, s29, s30, s15) : playableEntity0.copy(v8, s16, s17, s18, s19, s20, s21, v9, z6, v10, s22, s23, z7, s24, s25, s26, v11, z8, z9, z10, z11, v12, v13, s27, s28, v14, s29, s30, playableEntity0.displayName);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlayableEntity)) {
            return false;
        }
        PlayableEntity playableEntity0 = (PlayableEntity)object0;
        if(this.songId != playableEntity0.songId) {
            return false;
        }
        if(!q.b(this.title, playableEntity0.title)) {
            return false;
        }
        if(!q.b(this.data, playableEntity0.data)) {
            return false;
        }
        if(!q.b(this.album, playableEntity0.album)) {
            return false;
        }
        if(!q.b(this.albumId, playableEntity0.albumId)) {
            return false;
        }
        if(!q.b(this.artist, playableEntity0.artist)) {
            return false;
        }
        if(!q.b(this.artistId, playableEntity0.artistId)) {
            return false;
        }
        if(this.duration != playableEntity0.duration) {
            return false;
        }
        if(this.isAdult != playableEntity0.isAdult) {
            return false;
        }
        if(this.origin != playableEntity0.origin) {
            return false;
        }
        if(!q.b(this.menuId, playableEntity0.menuId)) {
            return false;
        }
        if(!q.b(this.originMenuId, playableEntity0.originMenuId)) {
            return false;
        }
        if(this.hasMv != playableEntity0.hasMv) {
            return false;
        }
        if(!q.b(this.mvName, playableEntity0.mvName)) {
            return false;
        }
        if(!q.b(this.mvId, playableEntity0.mvId)) {
            return false;
        }
        if(!q.b(this.cType, playableEntity0.cType)) {
            return false;
        }
        if(this.playCount != playableEntity0.playCount) {
            return false;
        }
        if(this.isFree != playableEntity0.isFree) {
            return false;
        }
        if(this.isHitSong != playableEntity0.isHitSong) {
            return false;
        }
        if(this.isHoldBack != playableEntity0.isHoldBack) {
            return false;
        }
        if(this.isTitle != playableEntity0.isTitle) {
            return false;
        }
        if(this.createdAt != playableEntity0.createdAt) {
            return false;
        }
        if(this.createdSeq != playableEntity0.createdSeq) {
            return false;
        }
        if(!q.b(this.albumImgPath, playableEntity0.albumImgPath)) {
            return false;
        }
        if(!q.b(this.albumThumbPath, playableEntity0.albumThumbPath)) {
            return false;
        }
        if(this.displayOrder != playableEntity0.displayOrder) {
            return false;
        }
        if(!q.b(this.statsElements, playableEntity0.statsElements)) {
            return false;
        }
        return q.b(this.uriString, playableEntity0.uriString) ? q.b(this.displayName, playableEntity0.displayName) : false;
    }

    @NotNull
    public final String getAlbum() {
        return this.album;
    }

    @NotNull
    public final String getAlbumId() {
        return this.albumId;
    }

    @NotNull
    public final String getAlbumImgPath() {
        return this.albumImgPath;
    }

    @NotNull
    public final String getAlbumThumbPath() {
        return this.albumThumbPath;
    }

    @NotNull
    public final String getArtist() {
        return this.artist;
    }

    @NotNull
    public final String getArtistId() {
        return this.artistId;
    }

    @NotNull
    public final String getCType() {
        return this.cType;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getCreatedSeq() {
        return this.createdSeq;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getDisplayOrder() {
        return this.displayOrder;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getHasMv() {
        return this.hasMv;
    }

    @NotNull
    public final String getMenuId() {
        return this.menuId;
    }

    @NotNull
    public final String getMvId() {
        return this.mvId;
    }

    @NotNull
    public final String getMvName() {
        return this.mvName;
    }

    public final int getOrigin() {
        return this.origin;
    }

    @NotNull
    public final String getOriginMenuId() {
        return this.originMenuId;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final int getSongId() {
        return this.songId;
    }

    @NotNull
    public final String getStatsElements() {
        return this.statsElements;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUriString() {
        return this.uriString;
    }

    @Override
    public int hashCode() {
        return this.displayName.hashCode() + x.b(x.b(d.b(this.displayOrder, x.b(x.b(d.b(this.createdSeq, d.c(d.e(d.e(d.e(d.e(d.b(this.playCount, x.b(x.b(x.b(d.e(x.b(x.b(d.b(this.origin, d.e(d.c(x.b(x.b(x.b(x.b(x.b(x.b(this.songId * 0x1F, 0x1F, this.title), 0x1F, this.data), 0x1F, this.album), 0x1F, this.albumId), 0x1F, this.artist), 0x1F, this.artistId), 0x1F, this.duration), 0x1F, this.isAdult), 0x1F), 0x1F, this.menuId), 0x1F, this.originMenuId), 0x1F, this.hasMv), 0x1F, this.mvName), 0x1F, this.mvId), 0x1F, this.cType), 0x1F), 0x1F, this.isFree), 0x1F, this.isHitSong), 0x1F, this.isHoldBack), 0x1F, this.isTitle), 0x1F, this.createdAt), 0x1F), 0x1F, this.albumImgPath), 0x1F, this.albumThumbPath), 0x1F), 0x1F, this.statsElements), 0x1F, this.uriString);
    }

    public final boolean isAdult() {
        return this.isAdult;
    }

    public final boolean isFree() {
        return this.isFree;
    }

    public final boolean isHitSong() {
        return this.isHitSong;
    }

    public final boolean isHoldBack() {
        return this.isHoldBack;
    }

    public final boolean isTitle() {
        return this.isTitle;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = x.o(this.songId, "PlayableEntity(songId=", ", title=", this.title, ", data=");
        d.u(stringBuilder0, this.data, ", album=", this.album, ", albumId=");
        d.u(stringBuilder0, this.albumId, ", artist=", this.artist, ", artistId=");
        b.t(this.duration, this.artistId, ", duration=", stringBuilder0);
        stringBuilder0.append(", isAdult=");
        stringBuilder0.append(this.isAdult);
        stringBuilder0.append(", origin=");
        stringBuilder0.append(this.origin);
        d.u(stringBuilder0, ", menuId=", this.menuId, ", originMenuId=", this.originMenuId);
        stringBuilder0.append(", hasMv=");
        stringBuilder0.append(this.hasMv);
        stringBuilder0.append(", mvName=");
        stringBuilder0.append(this.mvName);
        d.u(stringBuilder0, ", mvId=", this.mvId, ", cType=", this.cType);
        stringBuilder0.append(", playCount=");
        stringBuilder0.append(this.playCount);
        stringBuilder0.append(", isFree=");
        stringBuilder0.append(this.isFree);
        stringBuilder0.append(", isHitSong=");
        stringBuilder0.append(this.isHitSong);
        stringBuilder0.append(", isHoldBack=");
        stringBuilder0.append(this.isHoldBack);
        stringBuilder0.append(", isTitle=");
        stringBuilder0.append(this.isTitle);
        stringBuilder0.append(", createdAt=");
        stringBuilder0.append(this.createdAt);
        stringBuilder0.append(", createdSeq=");
        stringBuilder0.append(this.createdSeq);
        d.u(stringBuilder0, ", albumImgPath=", this.albumImgPath, ", albumThumbPath=", this.albumThumbPath);
        stringBuilder0.append(", displayOrder=");
        stringBuilder0.append(this.displayOrder);
        stringBuilder0.append(", statsElements=");
        stringBuilder0.append(this.statsElements);
        d.u(stringBuilder0, ", uriString=", this.uriString, ", displayName=", this.displayName);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

