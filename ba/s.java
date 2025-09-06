package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0003\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\b\u001A\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u000B¨\u0006\fÀ\u0006\u0003"}, d2 = {"LBa/s;", "", "", "memberKey", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/ForuTabRes;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "songIds", "Lcom/iloen/melon/net/v6x/response/ForuPreviewRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface s {
    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/foru/tab.json")
    Object a(@NotNull @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1, useAppVersion = true)
    @Nullable
    @f("/foru/previews.json")
    Object b(@NotNull @t("memberKey") String arg1, @NotNull @t("songIds") String arg2, @NotNull Continuation arg3);
}

