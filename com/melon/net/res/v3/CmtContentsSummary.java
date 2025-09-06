package com.melon.net.res.v3;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\bHÆ\u0003J\t\u0010\u0018\u001A\u00020\bHÆ\u0003J;\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001A\u001A\u00020\b2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001D\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012¨\u0006\u001E"}, d2 = {"Lcom/melon/net/res/v3/CmtContentsSummary;", "", "chnlSeq", "", "contsRefValue", "", "validCmtCnt", "hotFlag", "", "newFlag", "<init>", "(ILjava/lang/String;IZZ)V", "getChnlSeq", "()I", "getContsRefValue", "()Ljava/lang/String;", "getValidCmtCnt", "getHotFlag", "()Z", "getNewFlag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CmtContentsSummary {
    public static final int $stable;
    private final int chnlSeq;
    @NotNull
    private final String contsRefValue;
    private final boolean hotFlag;
    private final boolean newFlag;
    private final int validCmtCnt;

    public CmtContentsSummary(int v, @NotNull String s, int v1, boolean z, boolean z1) {
        q.g(s, "contsRefValue");
        super();
        this.chnlSeq = v;
        this.contsRefValue = s;
        this.validCmtCnt = v1;
        this.hotFlag = z;
        this.newFlag = z1;
    }

    public final int component1() {
        return this.chnlSeq;
    }

    @NotNull
    public final String component2() {
        return this.contsRefValue;
    }

    public final int component3() {
        return this.validCmtCnt;
    }

    public final boolean component4() {
        return this.hotFlag;
    }

    public final boolean component5() {
        return this.newFlag;
    }

    @NotNull
    public final CmtContentsSummary copy(int v, @NotNull String s, int v1, boolean z, boolean z1) {
        q.g(s, "contsRefValue");
        return new CmtContentsSummary(v, s, v1, z, z1);
    }

    public static CmtContentsSummary copy$default(CmtContentsSummary cmtContentsSummary0, int v, String s, int v1, boolean z, boolean z1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = cmtContentsSummary0.chnlSeq;
        }
        if((v2 & 2) != 0) {
            s = cmtContentsSummary0.contsRefValue;
        }
        if((v2 & 4) != 0) {
            v1 = cmtContentsSummary0.validCmtCnt;
        }
        if((v2 & 8) != 0) {
            z = cmtContentsSummary0.hotFlag;
        }
        if((v2 & 16) != 0) {
            z1 = cmtContentsSummary0.newFlag;
        }
        return cmtContentsSummary0.copy(v, s, v1, z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CmtContentsSummary)) {
            return false;
        }
        if(this.chnlSeq != ((CmtContentsSummary)object0).chnlSeq) {
            return false;
        }
        if(!q.b(this.contsRefValue, ((CmtContentsSummary)object0).contsRefValue)) {
            return false;
        }
        if(this.validCmtCnt != ((CmtContentsSummary)object0).validCmtCnt) {
            return false;
        }
        return this.hotFlag == ((CmtContentsSummary)object0).hotFlag ? this.newFlag == ((CmtContentsSummary)object0).newFlag : false;
    }

    public final int getChnlSeq() {
        return this.chnlSeq;
    }

    @NotNull
    public final String getContsRefValue() {
        return this.contsRefValue;
    }

    public final boolean getHotFlag() {
        return this.hotFlag;
    }

    public final boolean getNewFlag() {
        return this.newFlag;
    }

    public final int getValidCmtCnt() {
        return this.validCmtCnt;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.newFlag) + d.e(d.b(this.validCmtCnt, x.b(this.chnlSeq * 0x1F, 0x1F, this.contsRefValue), 0x1F), 0x1F, this.hotFlag);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = x.o(this.chnlSeq, "CmtContentsSummary(chnlSeq=", ", contsRefValue=", this.contsRefValue, ", validCmtCnt=");
        stringBuilder0.append(this.validCmtCnt);
        stringBuilder0.append(", hotFlag=");
        stringBuilder0.append(this.hotFlag);
        stringBuilder0.append(", newFlag=");
        return o.s(stringBuilder0, this.newFlag, ")");
    }
}

