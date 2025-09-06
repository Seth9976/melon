package com.kakaoent.trevi.ad.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001A\u00020\u0003R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/TreviAdUrl;", "", "type", "Lcom/kakaoent/trevi/ad/constants/TreviAdUrlType;", "()Lcom/kakaoent/trevi/ad/constants/TreviAdUrlType;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public @interface TreviAdUrl {
    TreviAdUrlType type();
}

