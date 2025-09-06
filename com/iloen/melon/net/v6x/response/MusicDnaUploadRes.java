package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE;)V", "toString", "", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicDnaUploadRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\t¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "accessKey", "", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "shortenUrl", "getShortenUrl", "setShortenUrl", "postImage", "getPostImage", "setPostImage", "longUrl", "getLongUrl", "setLongUrl", "info", "Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE$INFO;", "getInfo", "()Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE$INFO;", "setInfo", "(Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE$INFO;)V", "imgUrl", "getImgUrl", "setImgUrl", "INFO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes$RESPONSE$INFO;", "Ljava/io/Serializable;", "<init>", "()V", "filename", "", "getFilename", "()Ljava/lang/String;", "setFilename", "(Ljava/lang/String;)V", "size", "getSize", "setSize", "orgname", "getOrgname", "setOrgname", "ext", "getExt", "setExt", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class INFO implements Serializable {
            public static final int $stable = 8;
            @b("ext")
            @Nullable
            private String ext;
            @b("filename")
            @Nullable
            private String filename;
            @b("orgname")
            @Nullable
            private String orgname;
            @b("size")
            @Nullable
            private String size;

            @Nullable
            public final String getExt() {
                return this.ext;
            }

            @Nullable
            public final String getFilename() {
                return this.filename;
            }

            @Nullable
            public final String getOrgname() {
                return this.orgname;
            }

            @Nullable
            public final String getSize() {
                return this.size;
            }

            public final void setExt(@Nullable String s) {
                this.ext = s;
            }

            public final void setFilename(@Nullable String s) {
                this.filename = s;
            }

            public final void setOrgname(@Nullable String s) {
                this.orgname = s;
            }

            public final void setSize(@Nullable String s) {
                this.size = s;
            }
        }

        public static final int $stable = 8;
        @b("ACCESS_KEY")
        @Nullable
        private String accessKey;
        @b("IMGURL")
        @Nullable
        private String imgUrl;
        @b("INFO")
        @Nullable
        private INFO info;
        @b("LONGURL")
        @Nullable
        private String longUrl;
        @b("POSTIMAGE")
        @Nullable
        private String postImage;
        @b("SHORTENURL")
        @Nullable
        private String shortenUrl;

        @Nullable
        public final String getAccessKey() {
            return this.accessKey;
        }

        @Nullable
        public final String getImgUrl() {
            return this.imgUrl;
        }

        @Nullable
        public final INFO getInfo() {
            return this.info;
        }

        @Nullable
        public final String getLongUrl() {
            return this.longUrl;
        }

        @Nullable
        public final String getPostImage() {
            return this.postImage;
        }

        @Nullable
        public final String getShortenUrl() {
            return this.shortenUrl;
        }

        public final void setAccessKey(@Nullable String s) {
            this.accessKey = s;
        }

        public final void setImgUrl(@Nullable String s) {
            this.imgUrl = s;
        }

        public final void setInfo(@Nullable INFO musicDnaUploadRes$RESPONSE$INFO0) {
            this.info = musicDnaUploadRes$RESPONSE$INFO0;
        }

        public final void setLongUrl(@Nullable String s) {
            this.longUrl = s;
        }

        public final void setPostImage(@Nullable String s) {
            this.postImage = s;
        }

        public final void setShortenUrl(@Nullable String s) {
            this.shortenUrl = s;
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

    public final void setResponse(@Nullable RESPONSE musicDnaUploadRes$RESPONSE0) {
        this.response = musicDnaUploadRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

