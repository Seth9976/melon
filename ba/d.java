package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\t\u0010\u0007J \u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00042\b\b\u0001\u0010\n\u001A\u00020\u0002H§@¢\u0006\u0004\b\f\u0010\u0007J*\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00042\b\b\u0003\u0010\r\u001A\u00020\u00022\b\b\u0003\u0010\u000E\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"LBa/d;", "", "", "castSeq", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v5x/response/CastDetailRes;", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v5x/response/CastCmtExistRes;", "b", "brandDjKey", "Lcom/iloen/melon/net/v5x/response/CastBrandDetailRes;", "c", "startIndex", "pageSize", "Lcom/iloen/melon/net/v5x/response/CastPopularListRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface d {
    @Api(type = ApiType.V5, useAppVersion = false)
    @Nullable
    @f("/cast/popular/list.json")
    Object a(@NotNull @t("startIndex") String arg1, @NotNull @t("pageSize") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V5)
    @Nullable
    @f("/cast/cmt/exist.json")
    Object b(@NotNull @t("castSeq") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/cast/brand/detail.json")
    Object c(@NotNull @t("brandDjKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V5)
    @Nullable
    @f("/cast/detail.json")
    Object d(@NotNull @t("castSeq") String arg1, @NotNull Continuation arg2);
}

