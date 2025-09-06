package com.kakaoent.trevi.ad.constants;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001A\u0004\b\u0017\u0010\u000ER\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001A\u0004\b\u0018\u0010\u000ER\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001A\u0004\b\u0019\u0010\u000ER\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001A\u0004\b\u001A\u0010\u000E¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/trevi/ad/constants/UrlData;", "", "", "production", "stage", "qa", "debug", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/kakaoent/trevi/ad/constants/ServerConfig;", "type", "getUrl", "(Lcom/kakaoent/trevi/ad/constants/ServerConfig;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProduction", "getStage", "getQa", "getDebug", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class UrlData {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[ServerConfig.values().length];
            try {
                arr_v[ServerConfig.STAGE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ServerConfig.QA.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ServerConfig.DEBUG.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private final String debug;
    @NotNull
    private final String production;
    @NotNull
    private final String qa;
    @NotNull
    private final String stage;

    public UrlData(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "production");
        q.g(s1, "stage");
        q.g(s2, "qa");
        q.g(s3, "debug");
        super();
        this.production = s;
        this.stage = s1;
        this.qa = s2;
        this.debug = s3;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UrlData)) {
            return false;
        }
        if(!q.b(this.production, ((UrlData)object0).production)) {
            return false;
        }
        if(!q.b(this.stage, ((UrlData)object0).stage)) {
            return false;
        }
        return q.b(this.qa, ((UrlData)object0).qa) ? q.b(this.debug, ((UrlData)object0).debug) : false;
    }

    @NotNull
    public final String getUrl(@NotNull ServerConfig serverConfig0) {
        q.g(serverConfig0, "type");
        switch(WhenMappings.$EnumSwitchMapping$0[serverConfig0.ordinal()]) {
            case 1: {
                return this.stage;
            }
            case 2: {
                return this.qa;
            }
            case 3: {
                return this.debug;
            }
            default: {
                return this.production;
            }
        }
    }

    @Override
    public int hashCode() {
        return this.debug.hashCode() + x.b(x.b(this.production.hashCode() * 0x1F, 0x1F, this.stage), 0x1F, this.qa);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("UrlData(production=");
        stringBuilder0.append(this.production);
        stringBuilder0.append(", stage=");
        stringBuilder0.append(this.stage);
        stringBuilder0.append(", qa=");
        stringBuilder0.append(this.qa);
        stringBuilder0.append(", debug=");
        return o.r(stringBuilder0, this.debug, ')');
    }
}

