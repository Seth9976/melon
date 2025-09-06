package com.iloen.melon.fragments.comments;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/comments/BbsParam;", "", "requestTag", "", "bbsChnlSeq", "", "bbsContentRefValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRequestTag", "()Ljava/lang/String;", "getBbsChnlSeq", "()I", "getBbsContentRefValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BbsParam {
    public static final int $stable;
    private final int bbsChnlSeq;
    @NotNull
    private final String bbsContentRefValue;
    @NotNull
    private final String requestTag;

    public BbsParam() {
        this(null, 0, null, 7, null);
    }

    public BbsParam(@NotNull String s, int v, @NotNull String s1) {
        q.g(s, "requestTag");
        q.g(s1, "bbsContentRefValue");
        super();
        this.requestTag = s;
        this.bbsChnlSeq = v;
        this.bbsContentRefValue = s1;
    }

    public BbsParam(String s, int v, String s1, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = "";
        }
        if((v1 & 2) != 0) {
            v = -1;
        }
        if((v1 & 4) != 0) {
            s1 = "";
        }
        this(s, v, s1);
    }

    @NotNull
    public final String component1() {
        return this.requestTag;
    }

    public final int component2() {
        return this.bbsChnlSeq;
    }

    @NotNull
    public final String component3() {
        return this.bbsContentRefValue;
    }

    @NotNull
    public final BbsParam copy(@NotNull String s, int v, @NotNull String s1) {
        q.g(s, "requestTag");
        q.g(s1, "bbsContentRefValue");
        return new BbsParam(s, v, s1);
    }

    public static BbsParam copy$default(BbsParam bbsParam0, String s, int v, String s1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = bbsParam0.requestTag;
        }
        if((v1 & 2) != 0) {
            v = bbsParam0.bbsChnlSeq;
        }
        if((v1 & 4) != 0) {
            s1 = bbsParam0.bbsContentRefValue;
        }
        return bbsParam0.copy(s, v, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BbsParam)) {
            return false;
        }
        if(!q.b(this.requestTag, ((BbsParam)object0).requestTag)) {
            return false;
        }
        return this.bbsChnlSeq == ((BbsParam)object0).bbsChnlSeq ? q.b(this.bbsContentRefValue, ((BbsParam)object0).bbsContentRefValue) : false;
    }

    public final int getBbsChnlSeq() {
        return this.bbsChnlSeq;
    }

    @NotNull
    public final String getBbsContentRefValue() [...] // 潜在的解密器

    @NotNull
    public final String getRequestTag() [...] // 潜在的解密器

    @Override
    public int hashCode() {
        return this.bbsContentRefValue.hashCode() + d.b(this.bbsChnlSeq, this.requestTag.hashCode() * 0x1F, 0x1F);
    }

    @Override
    @NotNull
    public String toString() {
        return x.m(o.u(this.bbsChnlSeq, "BbsParam(requestTag=", this.requestTag, ", bbsChnlSeq=", ", bbsContentRefValue="), this.bbsContentRefValue, ")");
    }
}

