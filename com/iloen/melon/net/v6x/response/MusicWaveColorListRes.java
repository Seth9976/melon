package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveColorListRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "colorList", "", "Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes$RESPONSE$COLORINFO;", "getColorList", "()Ljava/util/List;", "setColorList", "(Ljava/util/List;)V", "COLORINFO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveColorListRes$RESPONSE$COLORINFO;", "", "<init>", "()V", "hue", "", "getHue", "()Ljava/lang/String;", "setHue", "(Ljava/lang/String;)V", "saturation", "getSaturation", "setSaturation", "lightness", "getLightness", "setLightness", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class COLORINFO {
            public static final int $stable = 8;
            @b("HUE")
            @Nullable
            private String hue;
            @b("LIGHTNESS")
            @Nullable
            private String lightness;
            @b("SATURATION")
            @Nullable
            private String saturation;

            @Nullable
            public final String getHue() {
                return this.hue;
            }

            @Nullable
            public final String getLightness() {
                return this.lightness;
            }

            @Nullable
            public final String getSaturation() {
                return this.saturation;
            }

            public final void setHue(@Nullable String s) {
                this.hue = s;
            }

            public final void setLightness(@Nullable String s) {
                this.lightness = s;
            }

            public final void setSaturation(@Nullable String s) {
                this.saturation = s;
            }
        }

        public static final int $stable = 8;
        @b("COLOR")
        @Nullable
        private List colorList;

        @Nullable
        public final List getColorList() {
            return this.colorList;
        }

        public final void setColorList(@Nullable List list0) {
            this.colorList = list0;
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

    public final void setResponse(@Nullable RESPONSE musicWaveColorListRes$RESPONSE0) {
        this.response = musicWaveColorListRes$RESPONSE0;
    }
}

