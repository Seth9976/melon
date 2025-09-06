package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\n\u001A\u00020\t2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\b¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"LBa/o;", "", "", "memberKey", "liveSeq", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/LiveDetailRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v6x/response/LivePlayerRes;", "b", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface o {
    @Api(type = ApiType.V6)
    @Nullable
    @f("/live/detail.json")
    Object a(@Nullable @t("memberKey") String arg1, @NotNull @t("liveSeq") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6)
    @Nullable
    @f("/live/player.json")
    Object b(@NotNull @t("memberKey") String arg1, @NotNull @t("liveSeq") String arg2, @NotNull Continuation arg3);
}

