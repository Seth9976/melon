package com.iloen.melon.playback.playlist.add;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/DefaultMixUpRequestInfo;", "Lcom/iloen/melon/playback/playlist/add/MixUpRequestInfo;", "mainTitle", "", "subTitle", "contsIdForLogging", "mixUpTypeForLogging", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMainTitle", "()Ljava/lang/String;", "getSubTitle", "getContsIdForLogging", "getMixUpTypeForLogging", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DefaultMixUpRequestInfo implements MixUpRequestInfo {
    public static final int $stable;
    @NotNull
    private final String contsIdForLogging;
    @NotNull
    private final String mainTitle;
    @NotNull
    private final String mixUpTypeForLogging;
    @NotNull
    private final String subTitle;

    public DefaultMixUpRequestInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "mainTitle");
        q.g(s1, "subTitle");
        q.g(s2, "contsIdForLogging");
        q.g(s3, "mixUpTypeForLogging");
        super();
        this.mainTitle = s;
        this.subTitle = s1;
        this.contsIdForLogging = s2;
        this.mixUpTypeForLogging = s3;
    }

    @NotNull
    public final String component1() {
        return this.mainTitle;
    }

    @NotNull
    public final String component2() {
        return this.subTitle;
    }

    @NotNull
    public final String component3() {
        return this.contsIdForLogging;
    }

    @NotNull
    public final String component4() {
        return this.mixUpTypeForLogging;
    }

    @NotNull
    public final DefaultMixUpRequestInfo copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "mainTitle");
        q.g(s1, "subTitle");
        q.g(s2, "contsIdForLogging");
        q.g(s3, "mixUpTypeForLogging");
        return new DefaultMixUpRequestInfo(s, s1, s2, s3);
    }

    public static DefaultMixUpRequestInfo copy$default(DefaultMixUpRequestInfo defaultMixUpRequestInfo0, String s, String s1, String s2, String s3, int v, Object object0) {
        if((v & 1) != 0) {
            s = defaultMixUpRequestInfo0.mainTitle;
        }
        if((v & 2) != 0) {
            s1 = defaultMixUpRequestInfo0.subTitle;
        }
        if((v & 4) != 0) {
            s2 = defaultMixUpRequestInfo0.contsIdForLogging;
        }
        if((v & 8) != 0) {
            s3 = defaultMixUpRequestInfo0.mixUpTypeForLogging;
        }
        return defaultMixUpRequestInfo0.copy(s, s1, s2, s3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DefaultMixUpRequestInfo)) {
            return false;
        }
        if(!q.b(this.mainTitle, ((DefaultMixUpRequestInfo)object0).mainTitle)) {
            return false;
        }
        if(!q.b(this.subTitle, ((DefaultMixUpRequestInfo)object0).subTitle)) {
            return false;
        }
        return q.b(this.contsIdForLogging, ((DefaultMixUpRequestInfo)object0).contsIdForLogging) ? q.b(this.mixUpTypeForLogging, ((DefaultMixUpRequestInfo)object0).mixUpTypeForLogging) : false;
    }

    @NotNull
    public final String getContsIdForLogging() {
        return this.contsIdForLogging;
    }

    @NotNull
    public final String getMainTitle() {
        return this.mainTitle;
    }

    @NotNull
    public final String getMixUpTypeForLogging() {
        return this.mixUpTypeForLogging;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Override
    public int hashCode() {
        return this.mixUpTypeForLogging.hashCode() + x.b(x.b(this.mainTitle.hashCode() * 0x1F, 0x1F, this.subTitle), 0x1F, this.contsIdForLogging);
    }

    @Override
    @NotNull
    public String toString() {
        return d.n(d.o("DefaultMixUpRequestInfo(mainTitle=", this.mainTitle, ", subTitle=", this.subTitle, ", contsIdForLogging="), this.contsIdForLogging, ", mixUpTypeForLogging=", this.mixUpTypeForLogging, ")");
    }
}

