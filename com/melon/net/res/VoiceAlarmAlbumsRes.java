package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumsRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response;", "getResponse", "()Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response;", "setResponse", "(Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response;)V", "Response", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceAlarmAlbumsRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumsRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0002\u001D\u001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000B\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\"\u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000E\"\u0004\b\u0019\u0010\u0010R \u0010\u001A\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u000E\"\u0004\b\u001C\u0010\u0010¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "albumList", "", "Lcom/melon/net/res/VoiceAlarm$AlbumDto;", "getAlbumList", "()Ljava/util/List;", "setAlbumList", "(Ljava/util/List;)V", "buttonMessage", "", "getButtonMessage", "()Ljava/lang/String;", "setButtonMessage", "(Ljava/lang/String;)V", "isButton", "", "()Ljava/lang/Boolean;", "setButton", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mainMessage", "getMainMessage", "setMainMessage", "subMessage", "getSubMessage", "setSubMessage", "Banner", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response$Banner;", "Lcom/iloen/melon/net/v4x/common/BannerBase;", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Banner extends BannerBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response$Banner$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.melon.net.res.VoiceAlarmAlbumsRes.Response.Banner.Companion {
                private com.melon.net.res.VoiceAlarmAlbumsRes.Response.Banner.Companion() {
                }

                public com.melon.net.res.VoiceAlarmAlbumsRes.Response.Banner.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.melon.net.res.VoiceAlarmAlbumsRes.Response.Banner.Companion Companion = null;
            private static final long serialVersionUID = 0x963F50B715342956L;

            static {
                Banner.Companion = new com.melon.net.res.VoiceAlarmAlbumsRes.Response.Banner.Companion(null);
                Banner.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumsRes$Response$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.VoiceAlarmAlbumsRes.Response.Companion {
            private com.melon.net.res.VoiceAlarmAlbumsRes.Response.Companion() {
            }

            public com.melon.net.res.VoiceAlarmAlbumsRes.Response.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.melon.net.res.VoiceAlarmAlbumsRes.Response.Companion Companion;
        @b("ALBUMLIST")
        @Nullable
        private List albumList;
        @b("BUTTONMESSAGE")
        @Nullable
        private String buttonMessage;
        @b("ISBUTTON")
        @Nullable
        private Boolean isButton;
        @b("MAINMESSAGE")
        @Nullable
        private String mainMessage;
        private static final long serialVersionUID;
        @b("SUBMESSAGE")
        @Nullable
        private String subMessage;

        static {
            Response.Companion = new com.melon.net.res.VoiceAlarmAlbumsRes.Response.Companion(null);
            Response.$stable = 8;
            Response.serialVersionUID = 6607680700485407362L;
        }

        @Nullable
        public final List getAlbumList() {
            return this.albumList;
        }

        @Nullable
        public final String getButtonMessage() {
            return this.buttonMessage;
        }

        @Nullable
        public final String getMainMessage() {
            return this.mainMessage;
        }

        @Nullable
        public final String getSubMessage() {
            return this.subMessage;
        }

        @Nullable
        public final Boolean isButton() {
            return this.isButton;
        }

        public final void setAlbumList(@Nullable List list0) {
            this.albumList = list0;
        }

        public final void setButton(@Nullable Boolean boolean0) {
            this.isButton = boolean0;
        }

        public final void setButtonMessage(@Nullable String s) {
            this.buttonMessage = s;
        }

        public final void setMainMessage(@Nullable String s) {
            this.mainMessage = s;
        }

        public final void setSubMessage(@Nullable String s) {
            this.subMessage = s;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @b("response")
    @Nullable
    private Response response;
    private static final long serialVersionUID;

    static {
        VoiceAlarmAlbumsRes.Companion = new Companion(null);
        VoiceAlarmAlbumsRes.$stable = 8;
        VoiceAlarmAlbumsRes.serialVersionUID = 0x55D1F2654FF0843EL;
    }

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response voiceAlarmAlbumsRes$Response0) {
        this.response = voiceAlarmAlbumsRes$Response0;
    }
}

