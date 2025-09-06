package com.melon.net.res.v3;

import A7.d;
import U4.x;
import ba.s;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u000F\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\b\u0012\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\b\u0012\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\b\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0016\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u000B0\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0016\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\r0\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u0016\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u000F0\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001AJn\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\b2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\b2\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\bH\u00C6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u0006H\u00D6\u0001\u00A2\u0006\u0004\b \u0010\u0018J\u0010\u0010!\u001A\u00020\u0004H\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\u0016J\u001A\u0010$\u001A\u00020\u00022\b\u0010#\u001A\u0004\u0018\u00010\"H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010&\u001A\u0004\b\'\u0010\u0014R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010(\u001A\u0004\b)\u0010\u0016R\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010*\u001A\u0004\b+\u0010\u0018R\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010,\u001A\u0004\b-\u0010\u001AR\u001D\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\b8\u0006\u00A2\u0006\f\n\u0004\b\f\u0010,\u001A\u0004\b.\u0010\u001AR\u001D\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\b8\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010,\u001A\u0004\b/\u0010\u001AR\u001D\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\b8\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010,\u001A\u0004\b0\u0010\u001A\u00A8\u00061"}, d2 = {"Lcom/melon/net/res/v3/CommentAttachUiModel;", "Lba/s;", "", "hasMore", "", "nextPageNo", "", "musicType", "", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachSongData;", "songList", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachAlbumData;", "albumList", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachArtistData;", "artistList", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachVideoData;", "videoList", "<init>", "(ZILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "component1", "()Z", "component2", "()I", "component3", "()Ljava/lang/String;", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "copy", "(ZILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/melon/net/res/v3/CommentAttachUiModel;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasMore", "I", "getNextPageNo", "Ljava/lang/String;", "getMusicType", "Ljava/util/List;", "getSongList", "getAlbumList", "getArtistList", "getVideoList", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentAttachUiModel implements s {
    public static final int $stable = 8;
    @NotNull
    private final List albumList;
    @NotNull
    private final List artistList;
    private final boolean hasMore;
    @NotNull
    private final String musicType;
    private final int nextPageNo;
    @NotNull
    private final List songList;
    @NotNull
    private final List videoList;

    public CommentAttachUiModel(boolean z, int v, @NotNull String s, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull List list3) {
        q.g(s, "musicType");
        q.g(list0, "songList");
        q.g(list1, "albumList");
        q.g(list2, "artistList");
        q.g(list3, "videoList");
        super();
        this.hasMore = z;
        this.nextPageNo = v;
        this.musicType = s;
        this.songList = list0;
        this.albumList = list1;
        this.artistList = list2;
        this.videoList = list3;
    }

    public CommentAttachUiModel(boolean z, int v, String s, List list0, List list1, List list2, List list3, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        w w0 = w.a;
        if((v1 & 8) != 0) {
            list0 = w0;
        }
        if((v1 & 16) != 0) {
            list1 = w0;
        }
        if((v1 & 0x20) != 0) {
            list2 = w0;
        }
        List list4 = (v1 & 0x40) == 0 ? list3 : w0;
        this(z, v, s, list0, list1, list2, list4);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final int component2() {
        return this.nextPageNo;
    }

    @NotNull
    public final String component3() {
        return this.musicType;
    }

    @NotNull
    public final List component4() {
        return this.songList;
    }

    @NotNull
    public final List component5() {
        return this.albumList;
    }

    @NotNull
    public final List component6() {
        return this.artistList;
    }

    @NotNull
    public final List component7() {
        return this.videoList;
    }

    @NotNull
    public final CommentAttachUiModel copy(boolean z, int v, @NotNull String s, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull List list3) {
        q.g(s, "musicType");
        q.g(list0, "songList");
        q.g(list1, "albumList");
        q.g(list2, "artistList");
        q.g(list3, "videoList");
        return new CommentAttachUiModel(z, v, s, list0, list1, list2, list3);
    }

    public static CommentAttachUiModel copy$default(CommentAttachUiModel commentAttachUiModel0, boolean z, int v, String s, List list0, List list1, List list2, List list3, int v1, Object object0) {
        if((v1 & 1) != 0) {
            z = commentAttachUiModel0.hasMore;
        }
        if((v1 & 2) != 0) {
            v = commentAttachUiModel0.nextPageNo;
        }
        if((v1 & 4) != 0) {
            s = commentAttachUiModel0.musicType;
        }
        if((v1 & 8) != 0) {
            list0 = commentAttachUiModel0.songList;
        }
        if((v1 & 16) != 0) {
            list1 = commentAttachUiModel0.albumList;
        }
        if((v1 & 0x20) != 0) {
            list2 = commentAttachUiModel0.artistList;
        }
        if((v1 & 0x40) != 0) {
            list3 = commentAttachUiModel0.videoList;
        }
        return commentAttachUiModel0.copy(z, v, s, list0, list1, list2, list3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CommentAttachUiModel)) {
            return false;
        }
        if(this.hasMore != ((CommentAttachUiModel)object0).hasMore) {
            return false;
        }
        if(this.nextPageNo != ((CommentAttachUiModel)object0).nextPageNo) {
            return false;
        }
        if(!q.b(this.musicType, ((CommentAttachUiModel)object0).musicType)) {
            return false;
        }
        if(!q.b(this.songList, ((CommentAttachUiModel)object0).songList)) {
            return false;
        }
        if(!q.b(this.albumList, ((CommentAttachUiModel)object0).albumList)) {
            return false;
        }
        return q.b(this.artistList, ((CommentAttachUiModel)object0).artistList) ? q.b(this.videoList, ((CommentAttachUiModel)object0).videoList) : false;
    }

    @NotNull
    public final List getAlbumList() {
        return this.albumList;
    }

    @NotNull
    public final List getArtistList() {
        return this.artistList;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final String getMusicType() {
        return this.musicType;
    }

    public final int getNextPageNo() {
        return this.nextPageNo;
    }

    @NotNull
    public final List getSongList() {
        return this.songList;
    }

    @NotNull
    public final List getVideoList() {
        return this.videoList;
    }

    @Override
    public int hashCode() {
        return this.videoList.hashCode() + d.d(d.d(d.d(x.b(d.b(this.nextPageNo, Boolean.hashCode(this.hasMore) * 0x1F, 0x1F), 0x1F, this.musicType), 0x1F, this.songList), 0x1F, this.albumList), 0x1F, this.artistList);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CommentAttachUiModel(hasMore=");
        stringBuilder0.append(this.hasMore);
        stringBuilder0.append(", nextPageNo=");
        stringBuilder0.append(this.nextPageNo);
        stringBuilder0.append(", musicType=");
        stringBuilder0.append(this.musicType);
        stringBuilder0.append(", songList=");
        stringBuilder0.append(this.songList);
        stringBuilder0.append(", albumList=");
        stringBuilder0.append(this.albumList);
        stringBuilder0.append(", artistList=");
        stringBuilder0.append(this.artistList);
        stringBuilder0.append(", videoList=");
        return Y.m(stringBuilder0, this.videoList, ")");
    }
}

