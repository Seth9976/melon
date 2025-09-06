package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J>\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\b\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\t2\b\b\u0003\u0010\u000B\u001A\u00020\tH§@¢\u0006\u0004\b\r\u0010\u000EJ4\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\t2\b\b\u0003\u0010\u000B\u001A\u00020\tH§@¢\u0006\u0004\b\u0010\u0010\u0011J>\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0012\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\t2\b\b\u0003\u0010\u000B\u001A\u00020\tH§@¢\u0006\u0004\b\u0014\u0010\u000EJ \u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0016\u0010\u0007J*\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0017\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001BÀ\u0006\u0003"}, d2 = {"LBa/m;", "", "", "gnrCode", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v5x/response/GenreDetailRes;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orderBy", "", "startIndex", "pageSize", "Lcom/iloen/melon/net/v5x/response/GenreDetailGuiType2Res;", "a", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v5x/response/GenreDetailGuiType3Res;", "e", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contsTypeCode", "Lcom/iloen/melon/net/v5x/response/GenreDetailGuiType4Res;", "c", "Lcom/iloen/melon/net/v5x/response/GenreDetailGuiType5Res;", "d", "refcrTypeCode", "Lcom/iloen/melon/net/v5x/response/GenreMenuDtlGnrsRes;", "f", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface m {
    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/genre/detail/guitype2.json")
    Object a(@NotNull @t("gnrCode") String arg1, @NotNull @t("orderBy") String arg2, @t("startIndex") int arg3, @t("pageSize") int arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/genre/detail.json")
    Object b(@NotNull @t("gnrCode") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/genre/detail/guitype4.json")
    Object c(@NotNull @t("gnrCode") String arg1, @NotNull @t("contsTypeCode") String arg2, @t("startIndex") int arg3, @t("pageSize") int arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/genre/detail/guitype5.json")
    Object d(@NotNull @t("gnrCode") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/genre/detail/guitype3.json")
    Object e(@NotNull @t("gnrCode") String arg1, @t("startIndex") int arg2, @t("pageSize") int arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V5, useAppVersion = true)
    @Nullable
    @f("/genre/menu/gnrs.json")
    Object f(@NotNull @t("gnrCode") String arg1, @NotNull @t("refcrTypeCode") String arg2, @NotNull Continuation arg3);
}

