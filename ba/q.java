package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.c;
import vg.e;
import vg.f;
import vg.o;
import vg.t;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u00C2\u0001\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001A\u00020\u00022\b\b\u0001\u0010\u0007\u001A\u00020\u00022\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\t\u001A\u00020\u00022\b\b\u0001\u0010\n\u001A\u00020\u00022\b\b\u0001\u0010\u000B\u001A\u00020\u00022\b\b\u0001\u0010\f\u001A\u00020\u00022\b\b\u0001\u0010\r\u001A\u00020\u00022\b\b\u0001\u0010\u000E\u001A\u00020\u00022\n\b\u0001\u0010\u000F\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0010\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0012\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00132\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u0018\u0010\u0019J*\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00132\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u001B\u0010\u0019J \u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001D0\u00132\b\b\u0001\u0010\u001C\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0016\u0010!\u001A\b\u0012\u0004\u0012\u00020 0\u0013H\u00A7@\u00A2\u0006\u0004\b!\u0010\"J \u0010%\u001A\b\u0012\u0004\u0012\u00020$0\u00132\b\b\u0001\u0010#\u001A\u00020\u0002H\u00A7@\u00A2\u0006\u0004\b%\u0010\u001FJb\u0010+\u001A\b\u0012\u0004\u0012\u00020*0\u00132\b\b\u0001\u0010&\u001A\u00020\u00022\b\b\u0001\u0010\'\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00022\b\b\u0001\u0010(\u001A\u00020\u00022\n\b\u0001\u0010#\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u00022\n\b\u0001\u0010)\u001A\u0004\u0018\u00010\u0002H\u00A7@\u00A2\u0006\u0004\b+\u0010,\u00A8\u0006-\u00C0\u0006\u0003"}, d2 = {"LBa/q;", "", "", "id", "pwd", "token", "loginType", "mdn", "min", "dcf", "deviceType", "mac", "sktFlag", "drmInst", "option", "kakaoId", "kakaoToken", "kakaoRefreshToken", "storeType", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/LoginLoginRes;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v4x/response/TokenValidInformRes;", "e", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v4x/response/TokenValidExpireRes;", "b", "memberKey", "Lcom/iloen/melon/net/v6x/response/InformMyProfileRes;", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v4x/response/LoginTokenNoticeMsgRes;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kakaoAccessToken", "Lcom/iloen/melon/net/v4x/response/CheckConnectKakaoByAccessTokenRes;", "c", "callerType", "userId", "kakaoUserId", "kakaoExpireYN", "Lcom/iloen/melon/net/v4x/response/KakaoConnIdCheckRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface q {
    @Api(type = ApiType.MEMBER)
    @Nullable
    @e
    @o("/muid/mobile/kakao/kakao_connIdCheck.json")
    Object a(@NotNull @c("type") String arg1, @NotNull @c("id") String arg2, @NotNull @c("token") String arg3, @NotNull @c("kakaoId") String arg4, @Nullable @c("kakaoToken") String arg5, @Nullable @c("kakaoRefreshToken") String arg6, @Nullable @c("kakaoExpireYN") String arg7, @NotNull Continuation arg8);

    @Api(type = ApiType.MEMBER)
    @Nullable
    @e
    @o("/muid/mobile/common/tokenvalid_expire.json")
    Object b(@NotNull @c("memberId") String arg1, @NotNull @c("token") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.MEMBER)
    @Nullable
    @e
    @o("/muid/mobile/api/checkConnectKakaoByAccessToken.json")
    Object c(@NotNull @c("kakaoToken") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6_1)
    @Nullable
    @f("/main/comm/informMyProfile.json")
    Object d(@NotNull @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.MEMBER)
    @Nullable
    @e
    @o("/muid/mobile/common/tokenvalid_inform.json")
    Object e(@NotNull @c("id") String arg1, @NotNull @c("token") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.MEMBER)
    @Nullable
    @f("/muid/mobile/login/login_tokenNoticeMsg.json")
    Object f(@NotNull Continuation arg1);

    @Api(type = ApiType.MEMBER)
    @Nullable
    @e
    @o("/muid/mobile/login/login_login.json")
    Object g(@NotNull @c("id") String arg1, @Nullable @c("pwd") String arg2, @Nullable @c("token") String arg3, @NotNull @c("loginType") String arg4, @NotNull @c("mdn") String arg5, @Nullable @c("min") String arg6, @NotNull @c("dcf") String arg7, @NotNull @c("phonetype") String arg8, @NotNull @c("mac") String arg9, @NotNull @c("skt_flag") String arg10, @NotNull @c("drmInst") String arg11, @NotNull @c("option") String arg12, @Nullable @c("kakaoId") String arg13, @Nullable @c("kakaoToken") String arg14, @Nullable @c("kakaoRefreshToken") String arg15, @NotNull @c("storeType") String arg16, @NotNull Continuation arg17);
}

