package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tg.d;
import vg.c;
import vg.e;
import vg.o;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0003\u0010\u0003\u001A\u00020\u0002H\'¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\b\u001A\u00020\u00022\b\b\u0001\u0010\t\u001A\u00020\u00022\b\b\u0001\u0010\n\u001A\u00020\u00022\b\b\u0001\u0010\u000B\u001A\u00020\u00022\b\b\u0003\u0010\u0003\u001A\u00020\u0002H\'¢\u0006\u0004\b\r\u0010\u000EJ=\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00042\b\b\u0001\u0010\u000B\u001A\u00020\u00022\b\b\u0001\u0010\n\u001A\u00020\u00022\b\b\u0001\u0010\b\u001A\u00020\u00022\b\b\u0003\u0010\u0003\u001A\u00020\u0002H\'¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u00042\b\b\u0001\u0010\u000B\u001A\u00020\u00022\b\b\u0001\u0010\n\u001A\u00020\u00022\b\b\u0001\u0010\b\u001A\u00020\u00022\b\b\u0001\u0010\u0012\u001A\u00020\u00022\b\b\u0001\u0010\u0013\u001A\u00020\u00022\b\b\u0003\u0010\u0003\u001A\u00020\u0002H\'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"LBa/j;", "", "", "memberKey", "Ltg/d;", "Lcom/iloen/melon/net/v4x/response/DcfExtensionBaseInfoRes;", "d", "(Ljava/lang/String;)Ltg/d;", "lcode", "count", "cid", "ctype", "Lcom/iloen/melon/net/v4x/response/DcfExtensionExpireDateRes;", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "Lcom/iloen/melon/net/v4x/response/DcfExtensionLoggingRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "pstime", "mediaType", "Lcom/iloen/melon/net/v4x/response/DcfExtensionPlayLoggingRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface j {
    @Api(type = ApiType.V4, useAppVersion = false)
    @NotNull
    @e
    @o("/dcfextension/playLogging.json")
    d a(@NotNull @c("ctype") String arg1, @NotNull @c("cid") String arg2, @NotNull @c("lcode") String arg3, @NotNull @c("pstime") String arg4, @NotNull @c("mediaType") String arg5, @NotNull @c("memberKey") String arg6);

    @Api(type = ApiType.V4, useAppVersion = false)
    @NotNull
    @e
    @o("/dcfextension/logging.json")
    d b(@NotNull @c("ctype") String arg1, @NotNull @c("cid") String arg2, @NotNull @c("lcode") String arg3, @NotNull @c("memberKey") String arg4);

    @Api(type = ApiType.V4, useAppVersion = false)
    @NotNull
    @e
    @o("/dcfextension/expireDate.json")
    d c(@NotNull @c("lcode") String arg1, @NotNull @c("count") String arg2, @NotNull @c("cid") String arg3, @NotNull @c("ctype") String arg4, @NotNull @c("memberKey") String arg5);

    @Api(type = ApiType.V4, useAppVersion = false)
    @NotNull
    @e
    @o("/dcfextension/baseInfo.json")
    d d(@NotNull @c("memberKey") String arg1);
}

