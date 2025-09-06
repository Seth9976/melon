package com.melon.net;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\u00020\u0005B\u0004\b\u0007\u0010\u0002\u0012\u000E\b\u0002\u0010\u0006\u001A\u00020\u0005B\u0004\b\u0007\u0010\u0002R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0007R\u000F\u0010\u0004\u001A\u00020\u0005¢\u0006\u0006\u001A\u0004\b\u0004\u0010\bR\u000F\u0010\u0006\u001A\u00020\u0005¢\u0006\u0006\u001A\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/melon/net/Api;", "", "type", "Lcom/melon/net/ApiType;", "useAppVersion", "", "useCache", "()Lcom/melon/net/ApiType;", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public @interface Api {
    ApiType type();

    boolean useAppVersion() default true;

    boolean useCache() default true;
}

