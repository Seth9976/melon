package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"LBa/r;", "", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/BadgeListRes;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/TabConfigRes;", "a", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface r {
    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/tab/config.json")
    Object a(@NotNull Continuation arg1);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/badge/list.json")
    Object b(@NotNull Continuation arg1);
}

