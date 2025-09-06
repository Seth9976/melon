package com.melon.net.res.v3;

import S7.b;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/InformOembedRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "response", "Lcom/melon/net/res/v3/InformOembedRes$Result;", "getResponse", "()Lcom/melon/net/res/v3/InformOembedRes$Result;", "setResponse", "(Lcom/melon/net/res/v3/InformOembedRes$Result;)V", "Result", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InformOembedRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR \u0010\u0013\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR\u001E\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001E\u0010\u0019\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\r\"\u0004\b\u001E\u0010\u000F¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/v3/InformOembedRes$Result;", "Ljava/io/Serializable;", "<init>", "()V", "cmtSeq", "", "getCmtSeq", "()I", "setCmtSeq", "(I)V", "videoUrl", "", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "videoTitle", "getVideoTitle", "setVideoTitle", "videoWidth", "getVideoWidth", "setVideoWidth", "videoHeight", "getVideoHeight", "setVideoHeight", "videoHtml", "getVideoHtml", "setVideoHtml", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        public static final int $stable = 8;
        @b("cmtSeq")
        private int cmtSeq;
        @b("thumbUrl")
        @Nullable
        private String thumbUrl;
        @b("videoHeight")
        private int videoHeight;
        @b("videoHtml")
        @Nullable
        private String videoHtml;
        @b("videoTitle")
        @Nullable
        private String videoTitle;
        @b("videoUrl")
        @Nullable
        private String videoUrl;
        @b("videoWidth")
        private int videoWidth;

        public Result() {
            this.cmtSeq = -1;
            this.videoWidth = -1;
            this.videoHeight = -1;
        }

        public final int getCmtSeq() {
            return this.cmtSeq;
        }

        @Nullable
        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        public final int getVideoHeight() {
            return this.videoHeight;
        }

        @Nullable
        public final String getVideoHtml() {
            return this.videoHtml;
        }

        @Nullable
        public final String getVideoTitle() {
            return this.videoTitle;
        }

        @Nullable
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public final int getVideoWidth() {
            return this.videoWidth;
        }

        public final void setCmtSeq(int v) {
            this.cmtSeq = v;
        }

        public final void setThumbUrl(@Nullable String s) {
            this.thumbUrl = s;
        }

        public final void setVideoHeight(int v) {
            this.videoHeight = v;
        }

        public final void setVideoHtml(@Nullable String s) {
            this.videoHtml = s;
        }

        public final void setVideoTitle(@Nullable String s) {
            this.videoTitle = s;
        }

        public final void setVideoUrl(@Nullable String s) {
            this.videoUrl = s;
        }

        public final void setVideoWidth(int v) {
            this.videoWidth = v;
        }
    }

    public static final int $stable = 8;
    @b("result")
    @Nullable
    private Result response;

    @Nullable
    public final Result getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Result informOembedRes$Result0) {
        this.response = informOembedRes$Result0;
    }
}

