package com.iloen.melon.fragments.comments;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\bHÆ\u0003J;\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020\u0003HÖ\u0001J\t\u0010#\u001A\u00020\bHÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\f\"\u0004\b\u0010\u0010\u000ER\u001A\u0010\u0005\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000ER\u001A\u0010\u0006\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000ER\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/comments/CmtPositionInfo;", "", "chnlSeq", "", "cmtSeq", "adapterPosition", "dataPosition", "cacheKey", "", "<init>", "(IIIILjava/lang/String;)V", "getChnlSeq", "()I", "setChnlSeq", "(I)V", "getCmtSeq", "setCmtSeq", "getAdapterPosition", "setAdapterPosition", "getDataPosition", "setDataPosition", "getCacheKey", "()Ljava/lang/String;", "setCacheKey", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CmtPositionInfo {
    public static final int $stable = 8;
    private int adapterPosition;
    @NotNull
    private String cacheKey;
    private int chnlSeq;
    private int cmtSeq;
    private int dataPosition;

    public CmtPositionInfo(int v, int v1, int v2, int v3, @NotNull String s) {
        q.g(s, "cacheKey");
        super();
        this.chnlSeq = v;
        this.cmtSeq = v1;
        this.adapterPosition = v2;
        this.dataPosition = v3;
        this.cacheKey = s;
    }

    public final int component1() {
        return this.chnlSeq;
    }

    public final int component2() {
        return this.cmtSeq;
    }

    public final int component3() {
        return this.adapterPosition;
    }

    public final int component4() {
        return this.dataPosition;
    }

    @NotNull
    public final String component5() {
        return this.cacheKey;
    }

    @NotNull
    public final CmtPositionInfo copy(int v, int v1, int v2, int v3, @NotNull String s) {
        q.g(s, "cacheKey");
        return new CmtPositionInfo(v, v1, v2, v3, s);
    }

    public static CmtPositionInfo copy$default(CmtPositionInfo cmtPositionInfo0, int v, int v1, int v2, int v3, String s, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = cmtPositionInfo0.chnlSeq;
        }
        if((v4 & 2) != 0) {
            v1 = cmtPositionInfo0.cmtSeq;
        }
        if((v4 & 4) != 0) {
            v2 = cmtPositionInfo0.adapterPosition;
        }
        if((v4 & 8) != 0) {
            v3 = cmtPositionInfo0.dataPosition;
        }
        if((v4 & 16) != 0) {
            s = cmtPositionInfo0.cacheKey;
        }
        return cmtPositionInfo0.copy(v, v1, v2, v3, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CmtPositionInfo)) {
            return false;
        }
        if(this.chnlSeq != ((CmtPositionInfo)object0).chnlSeq) {
            return false;
        }
        if(this.cmtSeq != ((CmtPositionInfo)object0).cmtSeq) {
            return false;
        }
        if(this.adapterPosition != ((CmtPositionInfo)object0).adapterPosition) {
            return false;
        }
        return this.dataPosition == ((CmtPositionInfo)object0).dataPosition ? q.b(this.cacheKey, ((CmtPositionInfo)object0).cacheKey) : false;
    }

    public final int getAdapterPosition() {
        return this.adapterPosition;
    }

    @NotNull
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final int getChnlSeq() {
        return this.chnlSeq;
    }

    public final int getCmtSeq() {
        return this.cmtSeq;
    }

    public final int getDataPosition() {
        return this.dataPosition;
    }

    @Override
    public int hashCode() {
        return this.cacheKey.hashCode() + d.b(this.dataPosition, d.b(this.adapterPosition, d.b(this.cmtSeq, this.chnlSeq * 0x1F, 0x1F), 0x1F), 0x1F);
    }

    public final void setAdapterPosition(int v) {
        this.adapterPosition = v;
    }

    public final void setCacheKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cacheKey = s;
    }

    public final void setChnlSeq(int v) {
        this.chnlSeq = v;
    }

    public final void setCmtSeq(int v) {
        this.cmtSeq = v;
    }

    public final void setDataPosition(int v) {
        this.dataPosition = v;
    }

    @Override
    @NotNull
    public String toString() {
        int v = this.adapterPosition;
        int v1 = this.dataPosition;
        String s = this.cacheKey;
        StringBuilder stringBuilder0 = o.t(this.chnlSeq, this.cmtSeq, "CmtPositionInfo(chnlSeq=", ", cmtSeq=", ", adapterPosition=");
        x.x(stringBuilder0, v, ", dataPosition=", v1, ", cacheKey=");
        return x.m(stringBuilder0, s, ")");
    }
}

