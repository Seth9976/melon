package com.kakaoent.trevi.ad.repository.remote.api;

import com.kakaoent.trevi.ad.constants.TreviAdUrl;
import com.kakaoent.trevi.ad.constants.TreviAdUrlType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.b;
import vg.f;
import vg.i;
import vg.t;

@TreviAdUrl(type = TreviAdUrlType.CASH_FRIENDS_IMP_SERVER)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001Jà\u0001\u0010\u0002\u001A\u00020\u00032\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001A\u00020\u00052\b\b\u0001\u0010\u0007\u001A\u00020\u00052\b\b\u0001\u0010\b\u001A\u00020\u00052\b\b\u0001\u0010\t\u001A\u00020\u00052\b\b\u0003\u0010\n\u001A\u00020\u000B2\n\b\u0003\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000E\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000F\u001A\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0010\u001A\u00020\u00052\n\b\u0003\u0010\u0011\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0015\u001A\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0016\u001A\u00020\u00052\b\b\u0003\u0010\u0017\u001A\u00020\u00182\b\b\u0003\u0010\u0019\u001A\u00020\u0018H§@¢\u0006\u0002\u0010\u001AJ\"\u0010\u001B\u001A\u00020\u001C2\b\b\u0001\u0010\u0004\u001A\u00020\u00052\b\b\u0003\u0010\u0016\u001A\u00020\u0005H§@¢\u0006\u0002\u0010\u001DJ\"\u0010\u001E\u001A\u00020\u001F2\b\b\u0001\u0010 \u001A\u00020\u00052\b\b\u0001\u0010!\u001A\u00020\u0005H§@¢\u0006\u0002\u0010\u001D¨\u0006\""}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsImpApi;", "", "getBannerAd", "Lcom/kakaoent/trevi/ad/domain/TreviBannerAdApiData;", "clientId", "", "plainIfa", "slotId", "deviceOs", "userInfo_userId", "userInfo_age", "", "userInfo_gender", "deviceModelName", "deviceOsVersion", "deviceId", "network", "inchar", "outchar", "serviceContentType", "serviceContentId", "settlementValue", "sdkVersion", "customConnectTimeout", "", "customReadTimeout", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalCash", "Lcom/kakaoent/trevi/ad/domain/CashFriendsTotalCashApiData;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withdrawNegativeFeedback", "Lcom/kakaoent/trevi/ad/domain/WithdrawNegativeFeedback;", "userId", "dspAdGroupId", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface CashFriendsImpApi {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static Object getBannerAd$default(CashFriendsImpApi cashFriendsImpApi0, String s, String s1, String s2, String s3, String s4, int v, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, long v1, long v2, Continuation continuation0, int v3, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBannerAd");
            }
            String s16 = (v3 & 1) == 0 ? s : null;
            int v4 = (v3 & 0x20) == 0 ? v : 0;
            String s17 = (v3 & 0x40) == 0 ? s5 : null;
            String s18 = (v3 & 0x80) == 0 ? s6 : null;
            String s19 = (v3 & 0x100) == 0 ? s7 : null;
            String s20 = (v3 & 0x200) == 0 ? s8 : null;
            String s21 = (v3 & 0x800) == 0 ? s10 : null;
            String s22 = (v3 & 0x1000) == 0 ? s11 : null;
            String s23 = (v3 & 0x2000) == 0 ? s12 : null;
            String s24 = (v3 & 0x4000) == 0 ? s13 : null;
            String s25 = (0x8000 & v3) == 0 ? s14 : null;
            String s26 = (0x10000 & v3) == 0 ? s15 : "2.3.0";
            long v5 = (0x20000 & v3) == 0 ? v1 : 20L;
            return (v3 & 0x40000) == 0 ? cashFriendsImpApi0.getBannerAd(s16, s1, s2, s3, s4, v4, s17, s18, s19, s20, s9, s21, s22, s23, s24, s25, s26, v5, v2, continuation0) : cashFriendsImpApi0.getBannerAd(s16, s1, s2, s3, s4, v4, s17, s18, s19, s20, s9, s21, s22, s23, s24, s25, s26, v5, 25L, continuation0);
        }

        public static Object getTotalCash$default(CashFriendsImpApi cashFriendsImpApi0, String s, String s1, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTotalCash");
            }
            if((v & 2) != 0) {
                s1 = "2.3.0";
            }
            return cashFriendsImpApi0.getTotalCash(s, s1, continuation0);
        }
    }

    @Nullable
    @f("/ads")
    Object getBannerAd(@Nullable @t("clientId") String arg1, @NotNull @t("plainIfa") String arg2, @NotNull @t("slotId") String arg3, @NotNull @t("deviceOs") String arg4, @NotNull @t("userInfo_userId") String arg5, @t("userInfo_age") int arg6, @Nullable @t("userInfo_gender") String arg7, @Nullable @t("deviceModelName") String arg8, @Nullable @t("deviceOsVersion") String arg9, @Nullable @t("deviceId") String arg10, @NotNull @t("network") String arg11, @Nullable @t("inchar") String arg12, @Nullable @t("outchar") String arg13, @Nullable @t("serviceContentType") String arg14, @Nullable @t("serviceContentId") String arg15, @Nullable @t("settlementValue") String arg16, @NotNull @t("sdkVersion") String arg17, @i("CUSTOM_CONNECT_TIMEOUT") long arg18, @i("CUSTOM_READ_TIMEOUT") long arg19, @NotNull Continuation arg20);

    @Nullable
    @f("/api/v1/total_amount")
    Object getTotalCash(@NotNull @t("clientId") String arg1, @NotNull @t("sdkVersion") String arg2, @NotNull Continuation arg3);

    @Nullable
    @b("api/v1/exploit/redis/keys/negativeFeedback")
    Object withdrawNegativeFeedback(@NotNull @t("userId") String arg1, @NotNull @t("dspAdGroupId") String arg2, @NotNull Continuation arg3);
}

