package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v4x.common.SolMetaBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/melon/net/res/MCachePathRes;", "", "<init>", "()V", "response", "Lcom/melon/net/res/MCachePathRes$Response;", "Response", "GetPathInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MCachePathRes {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00020\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/melon/net/res/MCachePathRes$GetPathInfo;", "Lcom/iloen/melon/net/v4x/common/SolMetaBase;", "<init>", "()V", "cid", "", "path", "metatype", "bitrate", "ishttps", "", "c", "binfo", "fileupdate", "filesize", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class GetPathInfo extends SolMetaBase {
        public static final int $stable = 8;
        @b("BINFO")
        @Nullable
        public String binfo;
        @b("BITRATE")
        @Nullable
        public String bitrate;
        @b("C")
        @Nullable
        public String c;
        @b("CID")
        @Nullable
        public String cid;
        @b("FILESIZE")
        @Nullable
        public String filesize;
        @b("FILEUPDTDATE")
        @Nullable
        public String fileupdate;
        @b("ISHTTPS")
        public boolean ishttps;
        @b("METATYPE")
        @Nullable
        public String metatype;
        @b("PATH")
        @Nullable
        public String path;

    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R&\u0010\u000B\u001A\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/melon/net/res/MCachePathRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "result", "", "Ljava/lang/Integer;", "productInfo", "", "getpathinfo", "Lcom/melon/net/res/MCachePathRes$GetPathInfo;", "contentsInfo", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/response/StreamGetSongInfoRes$RESPONSE$ContentsInfo;", "Lkotlin/collections/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("CONTENTSINFO")
        @Nullable
        public ArrayList contentsInfo;
        @b("GETPATHINFO")
        @Nullable
        public GetPathInfo getpathinfo;
        @b("PRODUCTINFO")
        @Nullable
        public String productInfo;
        @b("RESULT")
        @Nullable
        public Integer result;

    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    public Response response;

    public MCachePathRes() {
        this.response = new Response();
    }
}

