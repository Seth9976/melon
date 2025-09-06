package com.kakaoent.trevi.ad.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/exception/TreviAdAirPlaneModeNetworkException;", "Lcom/kakaoent/trevi/ad/exception/TreviAdException;", "message", "", "(Ljava/lang/String;)V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAdAirPlaneModeNetworkException extends TreviAdException {
    public TreviAdAirPlaneModeNetworkException(@Nullable String s) {
        if(s == null) {
            s = "";
        }
        super(s);
    }

    public TreviAdAirPlaneModeNetworkException(String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        this(s);
    }
}

