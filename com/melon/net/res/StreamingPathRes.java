package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/melon/net/res/StreamingPathRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/melon/net/res/StreamingPathRes$Response;", "getResponse", "()Lcom/melon/net/res/StreamingPathRes$Response;", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StreamingPathRes extends ResponseV4Res {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001C\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\u00020\u000E8\u0006X\u0087D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000FR\u0016\u0010\u0010\u001A\u00020\u000E8\u0006X\u0087D¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0016\u0010\u0011\u001A\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/melon/net/res/StreamingPathRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "pathInfo", "Lcom/melon/net/res/GetPathInfo;", "getPathInfo", "()Lcom/melon/net/res/GetPathInfo;", "contentsInfoList", "", "Lcom/melon/net/res/ContentsInfo;", "getContentsInfoList", "()Ljava/util/List;", "isFlacStok", "", "()Z", "isFlac16Stallok", "productInfo", "", "getProductInfo", "()Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("CONTENTSINFO")
        @NotNull
        private final List contentsInfoList;
        @b("ISFLAC16STALLOK")
        private final boolean isFlac16Stallok;
        @b("ISFLACSTOK")
        private final boolean isFlacStok;
        @b("GETPATHINFO")
        @NotNull
        private final GetPathInfo pathInfo;
        @b("PRODUCTINFO")
        @NotNull
        private final String productInfo;

        public Response() {
            this.pathInfo = new GetPathInfo(null, null, null, null, null, null, null, null, null, false, null, null, null, 0, null, 0x7FFF, null);
            this.contentsInfoList = w.a;
            this.productInfo = "";
        }

        @NotNull
        public final List getContentsInfoList() {
            return this.contentsInfoList;
        }

        @NotNull
        public final GetPathInfo getPathInfo() {
            return this.pathInfo;
        }

        @NotNull
        public final String getProductInfo() [...] // 潜在的解密器

        public final boolean isFlac16Stallok() {
            return this.isFlac16Stallok;
        }

        public final boolean isFlacStok() {
            return this.isFlacStok;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private final Response response;

    public StreamingPathRes() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }
}

