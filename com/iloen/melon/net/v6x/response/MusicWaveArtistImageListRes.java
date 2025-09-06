package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveArtistImageListRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "imageList", "", "Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes$RESPONSE$IMAGE;", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "IMAGE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u001A\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\t¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveArtistImageListRes$RESPONSE$IMAGE;", "", "<init>", "()V", "imageSeq", "", "getImageSeq", "()Ljava/lang/String;", "setImageSeq", "(Ljava/lang/String;)V", "smallImageUrl", "getSmallImageUrl", "setSmallImageUrl", "largeImageUrl", "getLargeImageUrl", "setLargeImageUrl", "artistId", "getArtistId", "setArtistId", "artistName", "getArtistName", "setArtistName", "artistImageUrl", "getArtistImageUrl", "setArtistImageUrl", "dpDate", "getDpDate", "setDpDate", "memberKey", "getMemberKey", "setMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class IMAGE {
            public static final int $stable = 8;
            @b("ARTISTID")
            @Nullable
            private String artistId;
            @b("ARTISTIMAGEURL")
            @Nullable
            private String artistImageUrl;
            @b("ARTISTNAME")
            @Nullable
            private String artistName;
            @b("DPDATE")
            @Nullable
            private String dpDate;
            @b("IMAGESEQ")
            @Nullable
            private String imageSeq;
            @b("LARGEIMAGEURL")
            @Nullable
            private String largeImageUrl;
            @b("MEMBERKEY")
            @Nullable
            private String memberKey;
            @b("SMALLIMAGEURL")
            @Nullable
            private String smallImageUrl;

            @Nullable
            public final String getArtistId() {
                return this.artistId;
            }

            @Nullable
            public final String getArtistImageUrl() {
                return this.artistImageUrl;
            }

            @Nullable
            public final String getArtistName() {
                return this.artistName;
            }

            @Nullable
            public final String getDpDate() {
                return this.dpDate;
            }

            @Nullable
            public final String getImageSeq() {
                return this.imageSeq;
            }

            @Nullable
            public final String getLargeImageUrl() {
                return this.largeImageUrl;
            }

            @Nullable
            public final String getMemberKey() {
                return this.memberKey;
            }

            @Nullable
            public final String getSmallImageUrl() {
                return this.smallImageUrl;
            }

            public final void setArtistId(@Nullable String s) {
                this.artistId = s;
            }

            public final void setArtistImageUrl(@Nullable String s) {
                this.artistImageUrl = s;
            }

            public final void setArtistName(@Nullable String s) {
                this.artistName = s;
            }

            public final void setDpDate(@Nullable String s) {
                this.dpDate = s;
            }

            public final void setImageSeq(@Nullable String s) {
                this.imageSeq = s;
            }

            public final void setLargeImageUrl(@Nullable String s) {
                this.largeImageUrl = s;
            }

            public final void setMemberKey(@Nullable String s) {
                this.memberKey = s;
            }

            public final void setSmallImageUrl(@Nullable String s) {
                this.smallImageUrl = s;
            }
        }

        public static final int $stable = 8;
        @b("IMAGELIST")
        @Nullable
        private List imageList;

        @Nullable
        public final List getImageList() {
            return this.imageList;
        }

        public final void setImageList(@Nullable List list0) {
            this.imageList = list0;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private RESPONSE response;

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE musicWaveArtistImageListRes$RESPONSE0) {
        this.response = musicWaveArtistImageListRes$RESPONSE0;
    }
}

