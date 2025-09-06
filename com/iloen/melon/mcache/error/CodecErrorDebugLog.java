package com.iloen.melon.mcache.error;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CodecErrorDebugLog {
    @NotNull
    private String bitrate;
    @NotNull
    private String c;
    private long cacheFileLength;
    @NotNull
    private String cacheFileStatus;
    private long decryptOffset;
    @NotNull
    private String deletedFileName;
    @NotNull
    private String fileName;
    @NotNull
    private String hCode;
    @NotNull
    private String metaType;
    @NotNull
    private String responseHeader;

    public CodecErrorDebugLog() {
        this("", "", 0L, "", "", "", "", "", "", 0L);
    }

    public CodecErrorDebugLog(@NotNull String s, @NotNull String s1, long v, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, long v1) {
        q.g(s, "responseHeader");
        q.g(s1, "hCode");
        q.g(s2, "cacheFileStatus");
        q.g(s3, "c");
        q.g(s4, "fileName");
        q.g(s5, "deletedFileName");
        q.g(s6, "metaType");
        q.g(s7, "bitrate");
        super();
        this.responseHeader = s;
        this.hCode = s1;
        this.cacheFileLength = v;
        this.cacheFileStatus = s2;
        this.c = s3;
        this.fileName = s4;
        this.deletedFileName = s5;
        this.metaType = s6;
        this.bitrate = s7;
        this.decryptOffset = v1;
    }

    @NotNull
    public final String component1() {
        return this.responseHeader;
    }

    public final long component10() {
        return this.decryptOffset;
    }

    @NotNull
    public final String component2() {
        return this.hCode;
    }

    public final long component3() {
        return this.cacheFileLength;
    }

    @NotNull
    public final String component4() {
        return this.cacheFileStatus;
    }

    @NotNull
    public final String component5() {
        return this.c;
    }

    @NotNull
    public final String component6() {
        return this.fileName;
    }

    @NotNull
    public final String component7() {
        return this.deletedFileName;
    }

    @NotNull
    public final String component8() {
        return this.metaType;
    }

    @NotNull
    public final String component9() {
        return this.bitrate;
    }

    @NotNull
    public final CodecErrorDebugLog copy(@NotNull String s, @NotNull String s1, long v, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, long v1) {
        q.g(s, "responseHeader");
        q.g(s1, "hCode");
        q.g(s2, "cacheFileStatus");
        q.g(s3, "c");
        q.g(s4, "fileName");
        q.g(s5, "deletedFileName");
        q.g(s6, "metaType");
        q.g(s7, "bitrate");
        return new CodecErrorDebugLog(s, s1, v, s2, s3, s4, s5, s6, s7, v1);
    }

    public static CodecErrorDebugLog copy$default(CodecErrorDebugLog codecErrorDebugLog0, String s, String s1, long v, String s2, String s3, String s4, String s5, String s6, String s7, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = codecErrorDebugLog0.responseHeader;
        }
        if((v2 & 2) != 0) {
            s1 = codecErrorDebugLog0.hCode;
        }
        if((v2 & 4) != 0) {
            v = codecErrorDebugLog0.cacheFileLength;
        }
        if((v2 & 8) != 0) {
            s2 = codecErrorDebugLog0.cacheFileStatus;
        }
        if((v2 & 16) != 0) {
            s3 = codecErrorDebugLog0.c;
        }
        if((v2 & 0x20) != 0) {
            s4 = codecErrorDebugLog0.fileName;
        }
        if((v2 & 0x40) != 0) {
            s5 = codecErrorDebugLog0.deletedFileName;
        }
        if((v2 & 0x80) != 0) {
            s6 = codecErrorDebugLog0.metaType;
        }
        if((v2 & 0x100) != 0) {
            s7 = codecErrorDebugLog0.bitrate;
        }
        if((v2 & 0x200) != 0) {
            v1 = codecErrorDebugLog0.decryptOffset;
        }
        return codecErrorDebugLog0.copy(s, s1, v, s2, s3, s4, s5, s6, s7, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CodecErrorDebugLog)) {
            return false;
        }
        if(!q.b(this.responseHeader, ((CodecErrorDebugLog)object0).responseHeader)) {
            return false;
        }
        if(!q.b(this.hCode, ((CodecErrorDebugLog)object0).hCode)) {
            return false;
        }
        if(this.cacheFileLength != ((CodecErrorDebugLog)object0).cacheFileLength) {
            return false;
        }
        if(!q.b(this.cacheFileStatus, ((CodecErrorDebugLog)object0).cacheFileStatus)) {
            return false;
        }
        if(!q.b(this.c, ((CodecErrorDebugLog)object0).c)) {
            return false;
        }
        if(!q.b(this.fileName, ((CodecErrorDebugLog)object0).fileName)) {
            return false;
        }
        if(!q.b(this.deletedFileName, ((CodecErrorDebugLog)object0).deletedFileName)) {
            return false;
        }
        if(!q.b(this.metaType, ((CodecErrorDebugLog)object0).metaType)) {
            return false;
        }
        return q.b(this.bitrate, ((CodecErrorDebugLog)object0).bitrate) ? this.decryptOffset == ((CodecErrorDebugLog)object0).decryptOffset : false;
    }

    @NotNull
    public final String getBitrate() {
        return this.bitrate;
    }

    @NotNull
    public final String getC() {
        return this.c;
    }

    public final long getCacheFileLength() {
        return this.cacheFileLength;
    }

    @NotNull
    public final String getCacheFileStatus() {
        return this.cacheFileStatus;
    }

    public final long getDecryptOffset() {
        return this.decryptOffset;
    }

    @NotNull
    public final String getDeletedFileName() {
        return this.deletedFileName;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    @NotNull
    public final String getHCode() {
        return this.hCode;
    }

    @NotNull
    public final String getMetaType() {
        return this.metaType;
    }

    @NotNull
    public final String getResponseHeader() {
        return this.responseHeader;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.decryptOffset) + x.b(x.b(x.b(x.b(x.b(x.b(d.c(x.b(this.responseHeader.hashCode() * 0x1F, 0x1F, this.hCode), 0x1F, this.cacheFileLength), 0x1F, this.cacheFileStatus), 0x1F, this.c), 0x1F, this.fileName), 0x1F, this.deletedFileName), 0x1F, this.metaType), 0x1F, this.bitrate);
    }

    public final void setBitrate(@NotNull String s) {
        q.g(s, "<set-?>");
        this.bitrate = s;
    }

    public final void setC(@NotNull String s) {
        q.g(s, "<set-?>");
        this.c = s;
    }

    public final void setCacheFileLength(long v) {
        this.cacheFileLength = v;
    }

    public final void setCacheFileStatus(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cacheFileStatus = s;
    }

    public final void setDecryptOffset(long v) {
        this.decryptOffset = v;
    }

    public final void setDeletedFileName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.deletedFileName = s;
    }

    public final void setFileName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.fileName = s;
    }

    public final void setHCode(@NotNull String s) {
        q.g(s, "<set-?>");
        this.hCode = s;
    }

    public final void setMetaType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.metaType = s;
    }

    public final void setResponseHeader(@NotNull String s) {
        q.g(s, "<set-?>");
        this.responseHeader = s;
    }

    @Override
    @NotNull
    public String toString() {
        return "CodecErrorDebugLog(responseHeader=" + this.responseHeader + ", hCode=" + this.hCode + ", cacheFileLength=" + this.cacheFileLength + ", cacheFileStatus=" + this.cacheFileStatus + ", c=" + this.c + ", fileName=" + this.fileName + ", deletedFileName=" + this.deletedFileName + ", metaType=" + this.metaType + ", bitrate=" + this.bitrate + ", decryptOffset=" + this.decryptOffset + ')';
    }
}

