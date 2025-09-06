package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0003\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"LBa/t;", "", "", "memberKey", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/MyMusicInformStorageRes;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface t {
    @Api(type = ApiType.V6_2, useAppVersion = true)
    @Nullable
    @f("/mymusic/informStorage.json")
    Object a(@NotNull @vg.t("memberKey") String arg1, @NotNull Continuation arg2);
}

