package com.kakao.emoticon.net;

import com.kakao.emoticon.util.ScreenUtils;
import d3.g;
import ie.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\t\u001A\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u000B\u001A\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakao/emoticon/net/HeaderInfo;", "", "<init>", "()V", "", "eAHeader$delegate", "Lie/j;", "getEAHeader", "()Ljava/lang/String;", "eAHeader", "getEmoticonDensity", "emoticonDensity", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class HeaderInfo {
    public static final HeaderInfo INSTANCE;
    @NotNull
    private static final j eAHeader$delegate;

    static {
        HeaderInfo.INSTANCE = new HeaderInfo();
        HeaderInfo.eAHeader$delegate = g.Q(HeaderInfo.eAHeader.2.INSTANCE);
    }

    @NotNull
    public final String getEAHeader() {
        return (String)HeaderInfo.eAHeader$delegate.getValue();
    }

    private final String getEmoticonDensity() {
        int v = ScreenUtils.INSTANCE.getDensityDPI();
        if(v <= 120) {
            return "ldpi";
        }
        if(v <= 0xA0) {
            return "mdpi";
        }
        if(v <= 0xF0) {
            return "hdpi";
        }
        if(v <= 320) {
            return "xhdpi";
        }
        if(v <= 480) {
            return "xxhdpi";
        }
        return v > 640 ? "xxhdpi" : "xxxhdpi";
    }
}

