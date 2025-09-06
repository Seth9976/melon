package com.iloen.melon.playback.playlist;

import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfoKt;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\b\u0002\u0010\u0005\u001A\f\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0013\u0010\u000E\u001A\f\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007HÆ\u0003J-\u0010\u000F\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\b\u0002\u0010\u0005\u001A\f\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001B\u0010\u0005\u001A\f\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/playback/playlist/PlaylistListType;", "", "playableList", "", "Lcom/iloen/melon/playback/Playable;", "dsplyOrderList", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo$DsPlyOrderData;", "Lcom/iloen/melon/player/playlist/drawernew/model/DsPlyOrderDataList;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getPlayableList", "()Ljava/util/List;", "getDsplyOrderList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistListType {
    public static final int $stable = 8;
    @NotNull
    private final List dsplyOrderList;
    @NotNull
    private final List playableList;

    public PlaylistListType() {
        this(null, null, 3, null);
    }

    public PlaylistListType(@NotNull List list0, @NotNull List list1) {
        q.g(list0, "playableList");
        q.g(list1, "dsplyOrderList");
        super();
        this.playableList = list0;
        this.dsplyOrderList = list1;
    }

    public PlaylistListType(List list0, List list1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            list0 = w.a;
        }
        if((v & 2) != 0) {
            list1 = DrawerPlaylistInfoKt.placeHolderDsPlyOrderDataList();
        }
        this(list0, list1);
    }

    @NotNull
    public final List component1() {
        return this.playableList;
    }

    @NotNull
    public final List component2() {
        return this.dsplyOrderList;
    }

    @NotNull
    public final PlaylistListType copy(@NotNull List list0, @NotNull List list1) {
        q.g(list0, "playableList");
        q.g(list1, "dsplyOrderList");
        return new PlaylistListType(list0, list1);
    }

    public static PlaylistListType copy$default(PlaylistListType playlistListType0, List list0, List list1, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = playlistListType0.playableList;
        }
        if((v & 2) != 0) {
            list1 = playlistListType0.dsplyOrderList;
        }
        return playlistListType0.copy(list0, list1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlaylistListType)) {
            return false;
        }
        return q.b(this.playableList, ((PlaylistListType)object0).playableList) ? q.b(this.dsplyOrderList, ((PlaylistListType)object0).dsplyOrderList) : false;
    }

    @NotNull
    public final List getDsplyOrderList() {
        return this.dsplyOrderList;
    }

    @NotNull
    public final List getPlayableList() {
        return this.playableList;
    }

    @Override
    public int hashCode() {
        return this.dsplyOrderList.hashCode() + this.playableList.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "PlaylistListType(playableList=" + this.playableList + ", dsplyOrderList=" + this.dsplyOrderList + ")";
    }
}

