package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0016R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/OffPlaySvcRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/melon/net/res/OffPlaySvcRes$Response;", "getResponse", "()Lcom/melon/net/res/OffPlaySvcRes$Response;", "toString", "", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OffPlaySvcRes extends ResponseV4Res {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000E\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/melon/net/res/OffPlaySvcRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "availList", "", "", "getAvailList", "()Ljava/util/List;", "setAvailList", "(Ljava/util/List;)V", "unavailList", "getUnavailList", "setUnavailList", "result", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "errorCode", "getErrorCode", "setErrorCode", "errorMsg", "getErrorMsg", "setErrorMsg", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("AVAILLIST")
        @Nullable
        private List availList;
        @b("ERRORCODE")
        @Nullable
        private String errorCode;
        @b("ERRORMSG")
        @Nullable
        private String errorMsg;
        @b("RESULT")
        @Nullable
        private String result;
        @b("UNAVAILLIST")
        @Nullable
        private List unavailList;

        @Nullable
        public final List getAvailList() {
            return this.availList;
        }

        @Nullable
        public final String getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @Nullable
        public final String getResult() {
            return this.result;
        }

        @Nullable
        public final List getUnavailList() {
            return this.unavailList;
        }

        public final void setAvailList(@Nullable List list0) {
            this.availList = list0;
        }

        public final void setErrorCode(@Nullable String s) {
            this.errorCode = s;
        }

        public final void setErrorMsg(@Nullable String s) {
            this.errorMsg = s;
        }

        public final void setResult(@Nullable String s) {
            this.result = s;
        }

        public final void setUnavailList(@Nullable List list0) {
            this.unavailList = list0;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private final Response response;

    public OffPlaySvcRes() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

