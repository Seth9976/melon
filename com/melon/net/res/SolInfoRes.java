package com.melon.net.res;

import A7.d;
import S7.b;
import com.iloen.melon.net.v4x.common.SolMetaBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/SolInfoRes;", "", "<init>", "()V", "response", "Lcom/melon/net/res/SolInfoRes$Response;", "getResponse", "()Lcom/melon/net/res/SolInfoRes$Response;", "setResponse", "(Lcom/melon/net/res/SolInfoRes$Response;)V", "Response", "SolInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SolInfoRes {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u001A\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u000B\u0010\u000E\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u001D\u0010\u000F\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J3\u0010\u0010\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u001C\b\u0002\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR*\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/melon/net/res/SolInfoRes$Response;", "", "result", "", "solInfoList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/SolInfoRes$SolInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getResult", "()Ljava/lang/String;", "getSolInfoList", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response {
        public static final int $stable = 8;
        @b("RESULT")
        @Nullable
        private final String result;
        @b("SOLINFOLIST")
        @Nullable
        private final ArrayList solInfoList;

        public Response(@Nullable String s, @Nullable ArrayList arrayList0) {
            this.result = s;
            this.solInfoList = arrayList0;
        }

        @Nullable
        public final String component1() {
            return this.result;
        }

        @Nullable
        public final ArrayList component2() {
            return this.solInfoList;
        }

        @NotNull
        public final Response copy(@Nullable String s, @Nullable ArrayList arrayList0) {
            return new Response(s, arrayList0);
        }

        public static Response copy$default(Response solInfoRes$Response0, String s, ArrayList arrayList0, int v, Object object0) {
            if((v & 1) != 0) {
                s = solInfoRes$Response0.result;
            }
            if((v & 2) != 0) {
                arrayList0 = solInfoRes$Response0.solInfoList;
            }
            return solInfoRes$Response0.copy(s, arrayList0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Response)) {
                return false;
            }
            return q.b(this.result, ((Response)object0).result) ? q.b(this.solInfoList, ((Response)object0).solInfoList) : false;
        }

        @Nullable
        public final String getResult() {
            return this.result;
        }

        @Nullable
        public final ArrayList getSolInfoList() {
            return this.solInfoList;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.result == null ? 0 : this.result.hashCode();
            ArrayList arrayList0 = this.solInfoList;
            if(arrayList0 != null) {
                v = arrayList0.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override
        @NotNull
        public String toString() {
            return "Response(result=" + this.result + ", solInfoList=" + this.solInfoList + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000B\u0010\u000E\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001A"}, d2 = {"Lcom/melon/net/res/SolInfoRes$SolInfo;", "Lcom/iloen/melon/net/v4x/common/SolMetaBase;", "cType", "", "cId", "metaType", "bitrate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCType", "()Ljava/lang/String;", "getCId", "getMetaType", "getBitrate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SolInfo extends SolMetaBase {
        public static final int $stable = 8;
        @b("BITRATE")
        @Nullable
        private final String bitrate;
        @b("CID")
        @Nullable
        private final String cId;
        @b("CTYPE")
        @Nullable
        private final String cType;
        @b("METATYPE")
        @Nullable
        private final String metaType;

        public SolInfo(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            this.cType = s;
            this.cId = s1;
            this.metaType = s2;
            this.bitrate = s3;
        }

        @Nullable
        public final String component1() {
            return this.cType;
        }

        @Nullable
        public final String component2() {
            return this.cId;
        }

        @Nullable
        public final String component3() {
            return this.metaType;
        }

        @Nullable
        public final String component4() {
            return this.bitrate;
        }

        @NotNull
        public final SolInfo copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            return new SolInfo(s, s1, s2, s3);
        }

        public static SolInfo copy$default(SolInfo solInfoRes$SolInfo0, String s, String s1, String s2, String s3, int v, Object object0) {
            if((v & 1) != 0) {
                s = solInfoRes$SolInfo0.cType;
            }
            if((v & 2) != 0) {
                s1 = solInfoRes$SolInfo0.cId;
            }
            if((v & 4) != 0) {
                s2 = solInfoRes$SolInfo0.metaType;
            }
            if((v & 8) != 0) {
                s3 = solInfoRes$SolInfo0.bitrate;
            }
            return solInfoRes$SolInfo0.copy(s, s1, s2, s3);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SolInfo)) {
                return false;
            }
            if(!q.b(this.cType, ((SolInfo)object0).cType)) {
                return false;
            }
            if(!q.b(this.cId, ((SolInfo)object0).cId)) {
                return false;
            }
            return q.b(this.metaType, ((SolInfo)object0).metaType) ? q.b(this.bitrate, ((SolInfo)object0).bitrate) : false;
        }

        @Nullable
        public final String getBitrate() {
            return this.bitrate;
        }

        @Nullable
        public final String getCId() {
            return this.cId;
        }

        @Nullable
        public final String getCType() {
            return this.cType;
        }

        @Nullable
        public final String getMetaType() {
            return this.metaType;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.cType == null ? 0 : this.cType.hashCode();
            int v2 = this.cId == null ? 0 : this.cId.hashCode();
            int v3 = this.metaType == null ? 0 : this.metaType.hashCode();
            String s = this.bitrate;
            if(s != null) {
                v = s.hashCode();
            }
            return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
        }

        @Override  // com.iloen.melon.net.v4x.common.SolMetaBase
        @NotNull
        public String toString() {
            return d.n(d.o("SolInfo(cType=", this.cType, ", cId=", this.cId, ", metaType="), this.metaType, ", bitrate=", this.bitrate, ")");
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private Response response;

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response solInfoRes$Response0) {
        this.response = solInfoRes$Response0;
    }
}

