package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v4x/response/GetSongLyricRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v4x/response/GetSongLyricRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v4x/response/GetSongLyricRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v4x/response/GetSongLyricRes$RESPONSE;)V", "toString", "", "RESPONSE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GetSongLyricRes extends ResponseV4Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/GetSongLyricRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0015\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/net/v4x/response/GetSongLyricRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "objecturi", "", "getObjecturi", "()Ljava/lang/String;", "setObjecturi", "(Ljava/lang/String;)V", "name", "getName", "setName", "lcode", "getLcode", "setLcode", "type", "getType", "setType", "title", "getTitle", "setTitle", "installnotifyuri", "getInstallnotifyuri", "setInstallnotifyuri", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/response/GetSongLyricRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v4x.response.GetSongLyricRes.RESPONSE.Companion {
            private com.iloen.melon.net.v4x.response.GetSongLyricRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v4x.response.GetSongLyricRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v4x.response.GetSongLyricRes.RESPONSE.Companion Companion = null;
        @b("INSTALLNOTIFYURI")
        @Nullable
        private String installnotifyuri;
        @b("LCODE")
        @Nullable
        private String lcode;
        @b("NAME")
        @Nullable
        private String name;
        @b("OBJECTURI")
        @Nullable
        private String objecturi;
        private static final long serialVersionUID = 0x67CA4E52442E156DL;
        @b("TITLE")
        @Nullable
        private String title;
        @b("TYPE")
        @Nullable
        private String type;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v4x.response.GetSongLyricRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final String getInstallnotifyuri() {
            return this.installnotifyuri;
        }

        @Nullable
        public final String getLcode() {
            return this.lcode;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getObjecturi() {
            return this.objecturi;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setInstallnotifyuri(@Nullable String s) {
            this.installnotifyuri = s;
        }

        public final void setLcode(@Nullable String s) {
            this.lcode = s;
        }

        public final void setName(@Nullable String s) {
            this.name = s;
        }

        public final void setObjecturi(@Nullable String s) {
            this.objecturi = s;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        public final void setType(@Nullable String s) {
            this.type = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private RESPONSE response;
    private static final long serialVersionUID = 0xB8D309588AA82268L;

    static {
        GetSongLyricRes.Companion = new Companion(null);
        GetSongLyricRes.$stable = 8;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE getSongLyricRes$RESPONSE0) {
        this.response = getSongLyricRes$RESPONSE0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

