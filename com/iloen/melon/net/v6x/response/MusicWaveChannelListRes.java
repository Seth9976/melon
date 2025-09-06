package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveChannelListRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000B\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000E\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000E\"\u0004\b\u0019\u0010\u0010¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "channelList", "", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE$CHANNELINFO;", "getChannelList", "()Ljava/util/List;", "setChannelList", "(Ljava/util/List;)V", "profileCleanUrl", "", "getProfileCleanUrl", "()Ljava/lang/String;", "setProfileCleanUrl", "(Ljava/lang/String;)V", "chatCleanUrl", "getChatCleanUrl", "setChatCleanUrl", "heartImgUrl", "getHeartImgUrl", "setHeartImgUrl", "heartsImgUrl", "getHeartsImgUrl", "setHeartsImgUrl", "CHANNELINFO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001E\u0010\u0019\u001A\u00020\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001B\"\u0004\b\u001C\u0010\u001DR \u0010\u001E\u001A\u0004\u0018\u00010\u001F8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010\'\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006+"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE$CHANNELINFO;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "id", "getId", "setId", "key", "getKey", "setKey", "m", "getM", "setM", "title", "getTitle", "setTitle", "bgColor", "getBgColor", "setBgColor", "isChatAvail", "", "()Z", "setChatAvail", "(Z)V", "host", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST;", "getHost", "()Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST;", "setHost", "(Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST;)V", "bgImgUrl", "getBgImgUrl", "setBgImgUrl", "artistChatBgColor", "getArtistChatBgColor", "setArtistChatBgColor", "HOST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CHANNELINFO {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST;", "", "<init>", "()V", "hostType", "", "getHostType", "()Ljava/lang/String;", "setHostType", "(Ljava/lang/String;)V", "hostId", "getHostId", "setHostId", "name", "getName", "setName", "imgUrl", "getImgUrl", "setImgUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class HOST {
                public static final int $stable = 8;
                @b("HOSTID")
                @Nullable
                private String hostId;
                @b("HOSTTYPE")
                @Nullable
                private String hostType;
                @b("IMGURL")
                @Nullable
                private String imgUrl;
                @b("NAME")
                @Nullable
                private String name;

                @Nullable
                public final String getHostId() {
                    return this.hostId;
                }

                @Nullable
                public final String getHostType() {
                    return this.hostType;
                }

                @Nullable
                public final String getImgUrl() {
                    return this.imgUrl;
                }

                @Nullable
                public final String getName() {
                    return this.name;
                }

                public final void setHostId(@Nullable String s) {
                    this.hostId = s;
                }

                public final void setHostType(@Nullable String s) {
                    this.hostType = s;
                }

                public final void setImgUrl(@Nullable String s) {
                    this.imgUrl = s;
                }

                public final void setName(@Nullable String s) {
                    this.name = s;
                }
            }

            public static final int $stable = 8;
            @b("ARTISTCHATBGCOLOR")
            @Nullable
            private String artistChatBgColor;
            @b("BGCOLOR")
            @Nullable
            private String bgColor;
            @b("BGIMGURL")
            @Nullable
            private String bgImgUrl;
            @b("HOST")
            @Nullable
            private HOST host;
            @b("ID")
            @Nullable
            private String id;
            @b("ISCHATAVAIL")
            private boolean isChatAvail;
            @b("KEY")
            @Nullable
            private String key;
            @b("M")
            @Nullable
            private String m;
            @b("TITLE")
            @Nullable
            private String title;
            @b("TYPE")
            @Nullable
            private String type;

            public CHANNELINFO() {
                this.isChatAvail = true;
            }

            @Nullable
            public final String getArtistChatBgColor() {
                return this.artistChatBgColor;
            }

            @Nullable
            public final String getBgColor() {
                return this.bgColor;
            }

            @Nullable
            public final String getBgImgUrl() {
                return this.bgImgUrl;
            }

            @Nullable
            public final HOST getHost() {
                return this.host;
            }

            @Nullable
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final String getKey() {
                return this.key;
            }

            @Nullable
            public final String getM() {
                return this.m;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            public final String getType() {
                return this.type;
            }

            public final boolean isChatAvail() {
                return this.isChatAvail;
            }

            public final void setArtistChatBgColor(@Nullable String s) {
                this.artistChatBgColor = s;
            }

            public final void setBgColor(@Nullable String s) {
                this.bgColor = s;
            }

            public final void setBgImgUrl(@Nullable String s) {
                this.bgImgUrl = s;
            }

            public final void setChatAvail(boolean z) {
                this.isChatAvail = z;
            }

            public final void setHost(@Nullable HOST musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST0) {
                this.host = musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST0;
            }

            public final void setId(@Nullable String s) {
                this.id = s;
            }

            public final void setKey(@Nullable String s) {
                this.key = s;
            }

            public final void setM(@Nullable String s) {
                this.m = s;
            }

            public final void setTitle(@Nullable String s) {
                this.title = s;
            }

            public final void setType(@Nullable String s) {
                this.type = s;
            }
        }

        public static final int $stable = 8;
        @b("CHANNELLIST")
        @Nullable
        private List channelList;
        @b("CHATCLEANURL")
        @Nullable
        private String chatCleanUrl;
        @b("HEART")
        @Nullable
        private String heartImgUrl;
        @b("HEARTS")
        @Nullable
        private String heartsImgUrl;
        @b("PROFILECLEANURL")
        @Nullable
        private String profileCleanUrl;

        @Nullable
        public final List getChannelList() {
            return this.channelList;
        }

        @Nullable
        public final String getChatCleanUrl() {
            return this.chatCleanUrl;
        }

        @Nullable
        public final String getHeartImgUrl() {
            return this.heartImgUrl;
        }

        @Nullable
        public final String getHeartsImgUrl() {
            return this.heartsImgUrl;
        }

        @Nullable
        public final String getProfileCleanUrl() {
            return this.profileCleanUrl;
        }

        public final void setChannelList(@Nullable List list0) {
            this.channelList = list0;
        }

        public final void setChatCleanUrl(@Nullable String s) {
            this.chatCleanUrl = s;
        }

        public final void setHeartImgUrl(@Nullable String s) {
            this.heartImgUrl = s;
        }

        public final void setHeartsImgUrl(@Nullable String s) {
            this.heartsImgUrl = s;
        }

        public final void setProfileCleanUrl(@Nullable String s) {
            this.profileCleanUrl = s;
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

    public final void setResponse(@Nullable RESPONSE musicWaveChannelListRes$RESPONSE0) {
        this.response = musicWaveChannelListRes$RESPONSE0;
    }
}

