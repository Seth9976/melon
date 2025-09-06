package com.melon.net.res.v3;

import S7.b;
import ba.s;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import e.k;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/v3/ListMusicRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "res", "Lcom/melon/net/res/v3/ListMusicRes$Result;", "getRes", "()Lcom/melon/net/res/v3/ListMusicRes$Result;", "setRes", "(Lcom/melon/net/res/v3/ListMusicRes$Result;)V", "Result", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListMusicRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/melon/net/res/v3/ListMusicRes$Companion;", "", "<init>", "()V", "getMvTitle", "", "item", "Lcom/melon/net/res/v3/ListMusicRes$Result$MusicList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final String getMvTitle(@Nullable MusicList listMusicRes$Result$MusicList0) {
            if(listMusicRes$Result$MusicList0 == null) {
                return null;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            q.d(listMusicRes$Result$MusicList0);
            if(listMusicRes$Result$MusicList0.getMvFlag()) {
                stringBuilder0.append("[MV] ");
            }
            else if(listMusicRes$Result$MusicList0.getLiveFlag()) {
                stringBuilder0.append("[Live] ");
            }
            stringBuilder0.append("");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001F B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R6\u0010\u000B\u001A\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006!"}, d2 = {"Lcom/melon/net/res/v3/ListMusicRes$Result;", "Ljava/io/Serializable;", "", "<init>", "()V", "Lcom/melon/net/res/v3/CommentAttachUiModel;", "toUiModel", "()Lcom/melon/net/res/v3/CommentAttachUiModel;", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/ListMusicRes$Result$MusicList;", "Lkotlin/collections/ArrayList;", "musicList", "Ljava/util/ArrayList;", "getMusicList", "()Ljava/util/ArrayList;", "setMusicList", "(Ljava/util/ArrayList;)V", "Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "pagingInfo", "Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "getPagingInfo", "()Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "setPagingInfo", "(Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;)V", "Lcom/melon/net/res/v3/ListMusicRes$Result$PageInfo;", "pageInfo", "Lcom/melon/net/res/v3/ListMusicRes$Result$PageInfo;", "getPageInfo", "()Lcom/melon/net/res/v3/ListMusicRes$Result$PageInfo;", "setPageInfo", "(Lcom/melon/net/res/v3/ListMusicRes$Result$PageInfo;)V", "MusicList", "PageInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b,\n\u0002\u0010\u000B\n\u0002\bP\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001E\u0010\u0013\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR\u001E\u0010\u0016\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000FR\u001E\u0010\u0019\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\r\"\u0004\b\u001B\u0010\u000FR\u001E\u0010\u001C\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\r\"\u0004\b\u001E\u0010\u000FR\u001E\u0010\u001F\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\r\"\u0004\b!\u0010\u000FR\u001E\u0010\"\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\r\"\u0004\b$\u0010\u000FR\u001E\u0010%\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\r\"\u0004\b\'\u0010\u000FR\u001E\u0010(\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001E\u0010+\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\r\"\u0004\b-\u0010\u000FR\u001E\u0010.\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\r\"\u0004\b0\u0010\u000FR\u001E\u00101\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\r\"\u0004\b3\u0010\u000FR\u001E\u00104\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010\r\"\u0004\b6\u0010\u000FR\u001E\u00107\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001E\u0010=\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b>\u0010:\"\u0004\b?\u0010<R\u001E\u0010@\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bA\u0010:\"\u0004\bB\u0010<R\u001E\u0010C\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bD\u0010:\"\u0004\bE\u0010<R\u001E\u0010F\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010:\"\u0004\bH\u0010<R\u001E\u0010I\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010:\"\u0004\bK\u0010<R\u001E\u0010L\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bM\u0010:\"\u0004\bN\u0010<R\u001E\u0010O\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000FR\u001E\u0010R\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bS\u0010\r\"\u0004\bT\u0010\u000FR\u001E\u0010U\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bV\u0010\r\"\u0004\bW\u0010\u000FR\u001E\u0010X\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bY\u0010\r\"\u0004\bZ\u0010\u000FR\u001E\u0010[\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010\u0007\"\u0004\b]\u0010\tR\u001E\u0010^\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b_\u0010\u0007\"\u0004\b`\u0010\tR\u001E\u0010a\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bb\u0010\r\"\u0004\bc\u0010\u000FR\u001E\u0010d\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\be\u0010:\"\u0004\bf\u0010<R\u001E\u0010g\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bh\u0010\r\"\u0004\bi\u0010\u000FR\u001E\u0010j\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bk\u0010\r\"\u0004\bl\u0010\u000FR\u001E\u0010m\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bn\u0010\r\"\u0004\bo\u0010\u000FR\u001E\u0010p\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bq\u0010\r\"\u0004\br\u0010\u000FR\u001E\u0010s\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bt\u0010\u0007\"\u0004\bu\u0010\tR\u001E\u0010v\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bw\u0010\u0007\"\u0004\bx\u0010\tR\u001E\u0010y\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bz\u0010:\"\u0004\b{\u0010<R\u001E\u0010|\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b}\u0010:\"\u0004\b~\u0010<R \u0010\u007F\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010\u000FR!\u0010\u0082\u0001\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0083\u0001\u0010\r\"\u0005\b\u0084\u0001\u0010\u000FR!\u0010\u0085\u0001\u001A\u0002088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0086\u0001\u0010:\"\u0005\b\u0087\u0001\u0010<R;\u0010\u0088\u0001\u001A\u001A\u0012\u0005\u0012\u00030\u008A\u0001\u0018\u00010\u0089\u0001j\f\u0012\u0005\u0012\u00030\u008A\u0001\u0018\u0001`\u008B\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u008C\u0001\u0010\u008D\u0001\"\u0006\b\u008E\u0001\u0010\u008F\u0001\u00A8\u0006\u0090\u0001"}, d2 = {"Lcom/melon/net/res/v3/ListMusicRes$Result$MusicList;", "Ljava/io/Serializable;", "<init>", "()V", "songId", "", "getSongId", "()I", "setSongId", "(I)V", "songName", "", "getSongName", "()Ljava/lang/String;", "setSongName", "(Ljava/lang/String;)V", "albumId", "getAlbumId", "setAlbumId", "albumName", "getAlbumName", "setAlbumName", "albumImagePath", "getAlbumImagePath", "setAlbumImagePath", "albumImageDsplyPath", "getAlbumImageDsplyPath", "setAlbumImageDsplyPath", "albumOnlyFlag", "getAlbumOnlyFlag", "setAlbumOnlyFlag", "albumDiscountFlag", "getAlbumDiscountFlag", "setAlbumDiscountFlag", "issueDate", "getIssueDate", "setIssueDate", "dsplyIssueDate", "getDsplyIssueDate", "setDsplyIssueDate", "artistId", "getArtistId", "setArtistId", "artistName", "getArtistName", "setArtistName", "artistImagePath", "getArtistImagePath", "setArtistImagePath", "artistImageDsplyPath", "getArtistImageDsplyPath", "setArtistImageDsplyPath", "svcAvailFlag", "getSvcAvailFlag", "setSvcAvailFlag", "stAvailFlag", "", "getStAvailFlag", "()Z", "setStAvailFlag", "(Z)V", "dlAvailFlag", "getDlAvailFlag", "setDlAvailFlag", "adultFlag", "getAdultFlag", "setAdultFlag", "holdBackFlag", "getHoldBackFlag", "setHoldBackFlag", "freezoneFlag", "getFreezoneFlag", "setFreezoneFlag", "hotSongFlag", "getHotSongFlag", "setHotSongFlag", "serviceFlag", "getServiceFlag", "setServiceFlag", "nationalityName", "getNationalityName", "setNationalityName", "actTypeName", "getActTypeName", "setActTypeName", "sex", "getSex", "setSex", "gnr", "getGnr", "setGnr", "fanCnt", "getFanCnt", "setFanCnt", "videoId", "getVideoId", "setVideoId", "videoTitle", "getVideoTitle", "setVideoTitle", "videoAdultFlag", "getVideoAdultFlag", "setVideoAdultFlag", "videoImagePath", "getVideoImagePath", "setVideoImagePath", "videoImageDsplyPath", "getVideoImageDsplyPath", "setVideoImageDsplyPath", "videoIssueDate", "getVideoIssueDate", "setVideoIssueDate", "dsplyVideoIssueDate", "getDsplyVideoIssueDate", "setDsplyVideoIssueDate", "videoAgeLevel", "getVideoAgeLevel", "setVideoAgeLevel", "videoViewCnt", "getVideoViewCnt", "setVideoViewCnt", "mvFlag", "getMvFlag", "setMvFlag", "liveFlag", "getLiveFlag", "setLiveFlag", "dsplyPlayTime", "getDsplyPlayTime", "setDsplyPlayTime", "videoEpsdName", "getVideoEpsdName", "setVideoEpsdName", "videoFreezoneFlag", "getVideoFreezoneFlag", "setVideoFreezoneFlag", "artistList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/ArtistsInfoBase;", "Lkotlin/collections/ArrayList;", "getArtistList", "()Ljava/util/ArrayList;", "setArtistList", "(Ljava/util/ArrayList;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MusicList implements Serializable {
            public static final int $stable = 8;
            @b("actTypeName")
            @NotNull
            private String actTypeName;
            @b("adultFlag")
            private boolean adultFlag;
            @b("albumDiscountFlag")
            @NotNull
            private String albumDiscountFlag;
            @b("albumId")
            private int albumId;
            @b("albumImageDsplyPath")
            @NotNull
            private String albumImageDsplyPath;
            @b("albumImagePath")
            @NotNull
            private String albumImagePath;
            @b("albumName")
            @NotNull
            private String albumName;
            @b("albumOnlyFlag")
            @NotNull
            private String albumOnlyFlag;
            @b("artistId")
            private int artistId;
            @b("artistImageDsplyPath")
            @NotNull
            private String artistImageDsplyPath;
            @b("artistImagePath")
            @NotNull
            private String artistImagePath;
            @b("artistList")
            @Nullable
            private ArrayList artistList;
            @b("artistName")
            @NotNull
            private String artistName;
            @b("dlAvailFlag")
            private boolean dlAvailFlag;
            @b("dsplyIssueDate")
            @NotNull
            private String dsplyIssueDate;
            @b("dsplyPlayTime")
            @NotNull
            private String dsplyPlayTime;
            @b("dsplyVideoIssueDate")
            @NotNull
            private String dsplyVideoIssueDate;
            @b("fanCnt")
            private int fanCnt;
            @b("freezoneFlag")
            private boolean freezoneFlag;
            @b("gnr")
            @NotNull
            private String gnr;
            @b("holdBackFlag")
            private boolean holdBackFlag;
            @b("hotSongFlag")
            private boolean hotSongFlag;
            @b("issueDate")
            @NotNull
            private String issueDate;
            @b("liveFlag")
            private boolean liveFlag;
            @b("mvFlag")
            private boolean mvFlag;
            @b("nationalityName")
            @NotNull
            private String nationalityName;
            @b("serviceFlag")
            private boolean serviceFlag;
            @b("sex")
            @NotNull
            private String sex;
            @b("songId")
            private int songId;
            @b("songName")
            @NotNull
            private String songName;
            @b("stAvailFlag")
            private boolean stAvailFlag;
            @b("svcAvailFlag")
            @NotNull
            private String svcAvailFlag;
            @b("videoAdultFlag")
            private boolean videoAdultFlag;
            @b("videoAgeLevel")
            private int videoAgeLevel;
            @b("videoEpsdName")
            @NotNull
            private String videoEpsdName;
            @b("videoFreezoneFlag")
            private boolean videoFreezoneFlag;
            @b("videoId")
            private int videoId;
            @b("videoImageDsplyPath")
            @NotNull
            private String videoImageDsplyPath;
            @b("videoImagePath")
            @NotNull
            private String videoImagePath;
            @b("videoIssueDate")
            @NotNull
            private String videoIssueDate;
            @b("videoTitle")
            @NotNull
            private String videoTitle;
            @b("videoViewCnt")
            private int videoViewCnt;

            public MusicList() {
                this.songId = -1;
                this.songName = "";
                this.albumId = -1;
                this.albumName = "";
                this.albumImagePath = "";
                this.albumImageDsplyPath = "";
                this.albumOnlyFlag = "";
                this.albumDiscountFlag = "";
                this.issueDate = "";
                this.dsplyIssueDate = "";
                this.artistId = -1;
                this.artistName = "";
                this.artistImagePath = "";
                this.artistImageDsplyPath = "";
                this.svcAvailFlag = "";
                this.nationalityName = "";
                this.actTypeName = "";
                this.sex = "";
                this.gnr = "";
                this.fanCnt = -1;
                this.videoId = -1;
                this.videoTitle = "";
                this.videoImagePath = "";
                this.videoImageDsplyPath = "";
                this.videoIssueDate = "";
                this.dsplyVideoIssueDate = "";
                this.videoAgeLevel = -1;
                this.videoViewCnt = -1;
                this.dsplyPlayTime = "";
                this.videoEpsdName = "";
            }

            @NotNull
            public final String getActTypeName() [...] // 潜在的解密器

            public final boolean getAdultFlag() {
                return this.adultFlag;
            }

            @NotNull
            public final String getAlbumDiscountFlag() {
                return this.albumDiscountFlag;
            }

            public final int getAlbumId() {
                return this.albumId;
            }

            @NotNull
            public final String getAlbumImageDsplyPath() {
                return this.albumImageDsplyPath;
            }

            @NotNull
            public final String getAlbumImagePath() [...] // 潜在的解密器

            @NotNull
            public final String getAlbumName() [...] // 潜在的解密器

            @NotNull
            public final String getAlbumOnlyFlag() {
                return this.albumOnlyFlag;
            }

            public final int getArtistId() {
                return this.artistId;
            }

            @NotNull
            public final String getArtistImageDsplyPath() {
                return this.artistImageDsplyPath;
            }

            @NotNull
            public final String getArtistImagePath() [...] // 潜在的解密器

            @Nullable
            public final ArrayList getArtistList() {
                return this.artistList;
            }

            @NotNull
            public final String getArtistName() [...] // 潜在的解密器

            public final boolean getDlAvailFlag() {
                return this.dlAvailFlag;
            }

            @NotNull
            public final String getDsplyIssueDate() [...] // 潜在的解密器

            @NotNull
            public final String getDsplyPlayTime() [...] // 潜在的解密器

            @NotNull
            public final String getDsplyVideoIssueDate() [...] // 潜在的解密器

            public final int getFanCnt() {
                return this.fanCnt;
            }

            public final boolean getFreezoneFlag() {
                return this.freezoneFlag;
            }

            @NotNull
            public final String getGnr() [...] // 潜在的解密器

            public final boolean getHoldBackFlag() {
                return this.holdBackFlag;
            }

            public final boolean getHotSongFlag() {
                return this.hotSongFlag;
            }

            @NotNull
            public final String getIssueDate() {
                return this.issueDate;
            }

            public final boolean getLiveFlag() {
                return this.liveFlag;
            }

            public final boolean getMvFlag() {
                return this.mvFlag;
            }

            @NotNull
            public final String getNationalityName() [...] // 潜在的解密器

            public final boolean getServiceFlag() {
                return this.serviceFlag;
            }

            @NotNull
            public final String getSex() [...] // 潜在的解密器

            public final int getSongId() {
                return this.songId;
            }

            @NotNull
            public final String getSongName() [...] // 潜在的解密器

            public final boolean getStAvailFlag() {
                return this.stAvailFlag;
            }

            @NotNull
            public final String getSvcAvailFlag() {
                return this.svcAvailFlag;
            }

            public final boolean getVideoAdultFlag() {
                return this.videoAdultFlag;
            }

            public final int getVideoAgeLevel() {
                return this.videoAgeLevel;
            }

            @NotNull
            public final String getVideoEpsdName() {
                return this.videoEpsdName;
            }

            public final boolean getVideoFreezoneFlag() {
                return this.videoFreezoneFlag;
            }

            public final int getVideoId() {
                return this.videoId;
            }

            @NotNull
            public final String getVideoImageDsplyPath() {
                return this.videoImageDsplyPath;
            }

            @NotNull
            public final String getVideoImagePath() [...] // 潜在的解密器

            @NotNull
            public final String getVideoIssueDate() {
                return this.videoIssueDate;
            }

            @NotNull
            public final String getVideoTitle() [...] // 潜在的解密器

            public final int getVideoViewCnt() {
                return this.videoViewCnt;
            }

            public final void setActTypeName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.actTypeName = s;
            }

            public final void setAdultFlag(boolean z) {
                this.adultFlag = z;
            }

            public final void setAlbumDiscountFlag(@NotNull String s) {
                q.g(s, "<set-?>");
                this.albumDiscountFlag = s;
            }

            public final void setAlbumId(int v) {
                this.albumId = v;
            }

            public final void setAlbumImageDsplyPath(@NotNull String s) {
                q.g(s, "<set-?>");
                this.albumImageDsplyPath = s;
            }

            public final void setAlbumImagePath(@NotNull String s) {
                q.g(s, "<set-?>");
                this.albumImagePath = s;
            }

            public final void setAlbumName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.albumName = s;
            }

            public final void setAlbumOnlyFlag(@NotNull String s) {
                q.g(s, "<set-?>");
                this.albumOnlyFlag = s;
            }

            public final void setArtistId(int v) {
                this.artistId = v;
            }

            public final void setArtistImageDsplyPath(@NotNull String s) {
                q.g(s, "<set-?>");
                this.artistImageDsplyPath = s;
            }

            public final void setArtistImagePath(@NotNull String s) {
                q.g(s, "<set-?>");
                this.artistImagePath = s;
            }

            public final void setArtistList(@Nullable ArrayList arrayList0) {
                this.artistList = arrayList0;
            }

            public final void setArtistName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.artistName = s;
            }

            public final void setDlAvailFlag(boolean z) {
                this.dlAvailFlag = z;
            }

            public final void setDsplyIssueDate(@NotNull String s) {
                q.g(s, "<set-?>");
                this.dsplyIssueDate = s;
            }

            public final void setDsplyPlayTime(@NotNull String s) {
                q.g(s, "<set-?>");
                this.dsplyPlayTime = s;
            }

            public final void setDsplyVideoIssueDate(@NotNull String s) {
                q.g(s, "<set-?>");
                this.dsplyVideoIssueDate = s;
            }

            public final void setFanCnt(int v) {
                this.fanCnt = v;
            }

            public final void setFreezoneFlag(boolean z) {
                this.freezoneFlag = z;
            }

            public final void setGnr(@NotNull String s) {
                q.g(s, "<set-?>");
                this.gnr = s;
            }

            public final void setHoldBackFlag(boolean z) {
                this.holdBackFlag = z;
            }

            public final void setHotSongFlag(boolean z) {
                this.hotSongFlag = z;
            }

            public final void setIssueDate(@NotNull String s) {
                q.g(s, "<set-?>");
                this.issueDate = s;
            }

            public final void setLiveFlag(boolean z) {
                this.liveFlag = z;
            }

            public final void setMvFlag(boolean z) {
                this.mvFlag = z;
            }

            public final void setNationalityName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.nationalityName = s;
            }

            public final void setServiceFlag(boolean z) {
                this.serviceFlag = z;
            }

            public final void setSex(@NotNull String s) {
                q.g(s, "<set-?>");
                this.sex = s;
            }

            public final void setSongId(int v) {
                this.songId = v;
            }

            public final void setSongName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.songName = s;
            }

            public final void setStAvailFlag(boolean z) {
                this.stAvailFlag = z;
            }

            public final void setSvcAvailFlag(@NotNull String s) {
                q.g(s, "<set-?>");
                this.svcAvailFlag = s;
            }

            public final void setVideoAdultFlag(boolean z) {
                this.videoAdultFlag = z;
            }

            public final void setVideoAgeLevel(int v) {
                this.videoAgeLevel = v;
            }

            public final void setVideoEpsdName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.videoEpsdName = s;
            }

            public final void setVideoFreezoneFlag(boolean z) {
                this.videoFreezoneFlag = z;
            }

            public final void setVideoId(int v) {
                this.videoId = v;
            }

            public final void setVideoImageDsplyPath(@NotNull String s) {
                q.g(s, "<set-?>");
                this.videoImageDsplyPath = s;
            }

            public final void setVideoImagePath(@NotNull String s) {
                q.g(s, "<set-?>");
                this.videoImagePath = s;
            }

            public final void setVideoIssueDate(@NotNull String s) {
                q.g(s, "<set-?>");
                this.videoIssueDate = s;
            }

            public final void setVideoTitle(@NotNull String s) {
                q.g(s, "<set-?>");
                this.videoTitle = s;
            }

            public final void setVideoViewCnt(int v) {
                this.videoViewCnt = v;
            }
        }

        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001E\u0010\u0013\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR\u001E\u0010\u0016\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000F¨\u0006\u0019"}, d2 = {"Lcom/melon/net/res/v3/ListMusicRes$Result$PageInfo;", "Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "<init>", "()V", "musicType", "", "getMusicType", "()Ljava/lang/String;", "setMusicType", "(Ljava/lang/String;)V", "songCnt", "", "getSongCnt", "()I", "setSongCnt", "(I)V", "albumCnt", "getAlbumCnt", "setAlbumCnt", "artistCnt", "getArtistCnt", "setArtistCnt", "videoCnt", "getVideoCnt", "setVideoCnt", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class PageInfo extends PageInfoBase {
            public static final int $stable = 8;
            @b("albumCnt")
            private int albumCnt;
            @b("artistCnt")
            private int artistCnt;
            @b("musicType")
            @NotNull
            private String musicType;
            @b("songCnt")
            private int songCnt;
            @b("videoCnt")
            private int videoCnt;

            public PageInfo() {
                this.musicType = "";
                this.songCnt = -1;
                this.albumCnt = -1;
                this.artistCnt = -1;
                this.videoCnt = -1;
            }

            public final int getAlbumCnt() {
                return this.albumCnt;
            }

            public final int getArtistCnt() {
                return this.artistCnt;
            }

            @NotNull
            public final String getMusicType() [...] // 潜在的解密器

            public final int getSongCnt() {
                return this.songCnt;
            }

            public final int getVideoCnt() {
                return this.videoCnt;
            }

            public final void setAlbumCnt(int v) {
                this.albumCnt = v;
            }

            public final void setArtistCnt(int v) {
                this.artistCnt = v;
            }

            public final void setMusicType(@NotNull String s) {
                q.g(s, "<set-?>");
                this.musicType = s;
            }

            public final void setSongCnt(int v) {
                this.songCnt = v;
            }

            public final void setVideoCnt(int v) {
                this.videoCnt = v;
            }
        }

        public static final int $stable = 8;
        @b("musicList")
        @Nullable
        private ArrayList musicList;
        @b("pageInfo")
        @Nullable
        private PageInfo pageInfo;
        @b("pagingInfo")
        @Nullable
        private PagingInfoBase pagingInfo;

        @Nullable
        public final ArrayList getMusicList() {
            return this.musicList;
        }

        @Nullable
        public final PageInfo getPageInfo() {
            return this.pageInfo;
        }

        @Nullable
        public final PagingInfoBase getPagingInfo() {
            return this.pagingInfo;
        }

        public final void setMusicList(@Nullable ArrayList arrayList0) {
            this.musicList = arrayList0;
        }

        public final void setPageInfo(@Nullable PageInfo listMusicRes$Result$PageInfo0) {
            this.pageInfo = listMusicRes$Result$PageInfo0;
        }

        public final void setPagingInfo(@Nullable PagingInfoBase commentApiModel$PagingInfoBase0) {
            this.pagingInfo = commentApiModel$PagingInfoBase0;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public CommentAttachUiModel toUiModel() {
            String s = this.pageInfo == null ? "song" : "";
            ArrayList arrayList0 = new ArrayList();
            ArrayList arrayList1 = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if(q.b(s, "song")) {
                ArrayList arrayList4 = this.musicList;
                if(arrayList4 != null) {
                    int v = 0;
                    for(Object object0: arrayList4) {
                        if(v >= 0) {
                            int v1 = ((MusicList)object0).getSongId();
                            int v2 = ((MusicList)object0).getAlbumId();
                            int v3 = ((MusicList)object0).getArtistId();
                            String s1 = ProtocolUtils.getArtistNames(((MusicList)object0).getArtistList());
                            arrayList0.add(new AttachSongData(v1, "", v2, "", "", v3, (s1 == null ? "" : s1), "", ((MusicList)object0).getAdultFlag(), ((MusicList)object0).getHoldBackFlag(), ((MusicList)object0).getFreezoneFlag(), ((MusicList)object0).getServiceFlag()));
                            ++v;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                }
            }
            else if(q.b(s, "album")) {
                ArrayList arrayList5 = this.musicList;
                if(arrayList5 != null) {
                    for(Object object1: arrayList5) {
                        int v4 = ((MusicList)object1).getAlbumId();
                        int v5 = ((MusicList)object1).getArtistId();
                        String s2 = ProtocolUtils.getArtistNames(((MusicList)object1).getArtistList());
                        if(s2 == null) {
                            s2 = "";
                        }
                        arrayList1.add(new AttachAlbumData(v4, "", "", v5, s2, "", ((MusicList)object1).getServiceFlag()));
                    }
                }
            }
            else if(q.b(s, "artist")) {
                ArrayList arrayList6 = this.musicList;
                if(arrayList6 != null) {
                    for(Object object2: arrayList6) {
                        arrayList2.add(new AttachArtistData(((MusicList)object2).getArtistId(), "", "", "", "", "", "", "", ((MusicList)object2).getFanCnt()));
                    }
                }
            }
            else if(q.b(s, "video")) {
                ArrayList arrayList7 = this.musicList;
                if(arrayList7 != null) {
                    for(Object object3: arrayList7) {
                        int v6 = ((MusicList)object3).getVideoId();
                        String s3 = ListMusicRes.Companion.getMvTitle(((MusicList)object3));
                        if(s3 == null) {
                            s3 = "";
                        }
                        int v7 = ((MusicList)object3).getSongId();
                        int v8 = ((MusicList)object3).getAlbumId();
                        int v9 = ((MusicList)object3).getArtistId();
                        String s4 = ProtocolUtils.getArtistNames(((MusicList)object3).getArtistList());
                        if(s4 == null) {
                            s4 = "";
                        }
                        int v10 = ((MusicList)object3).getVideoViewCnt();
                        boolean z = ((MusicList)object3).getVideoAdultFlag();
                        boolean z1 = ((MusicList)object3).getHoldBackFlag();
                        boolean z2 = ((MusicList)object3).getVideoFreezoneFlag();
                        int v11 = ((MusicList)object3).getVideoAgeLevel();
                        String s5 = MediaAttachHelper.INSTANCE.getMvAgeLevelIcon(v11);
                        arrayList3.add(new AttachVideoData(v6, s3, "", "", "", v7, v8, v9, s4, v10, z, z1, z2, (s5 == null ? "" : s5)));
                    }
                }
            }
            int v12 = -1;
            boolean z3 = (this.pageInfo == null ? -1 : this.pageInfo.getPageNo()) < (this.pagingInfo == null ? -1 : this.pagingInfo.getNextPageNo());
            PagingInfoBase commentApiModel$PagingInfoBase0 = this.pagingInfo;
            if(commentApiModel$PagingInfoBase0 != null) {
                v12 = commentApiModel$PagingInfoBase0.getNextPageNo();
            }
            q.d(s);
            return new CommentAttachUiModel(z3, v12, s, arrayList0, arrayList1, arrayList2, arrayList3);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @b("result")
    @Nullable
    private Result res;

    static {
        ListMusicRes.Companion = new Companion(null);
        ListMusicRes.$stable = 8;
    }

    @Nullable
    public final Result getRes() {
        return this.res;
    }

    public final void setRes(@Nullable Result listMusicRes$Result0) {
        this.res = listMusicRes$Result0;
    }
}

