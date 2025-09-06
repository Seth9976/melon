package com.kakaoent.trevi.ad.repository.remote.api;

import com.kakaoent.trevi.ad.constants.TreviAdUrl;
import com.kakaoent.trevi.ad.constants.TreviAdUrlType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.t;
import vg.y;

@TreviAdUrl(type = TreviAdUrlType.CASH_FRIENDS_TRACK_SERVER)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J<\u0010\u0002\u001A\u00020\u00032\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001A\u0004\u0018\u00010\u00052\b\b\u0003\u0010\b\u001A\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001A\u00020\u00032\b\b\u0001\u0010\u000B\u001A\u00020\u0005H§@¢\u0006\u0002\u0010\fJ<\u0010\r\u001A\u00020\u000E2\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001A\u0004\u0018\u00010\u00052\b\b\u0003\u0010\b\u001A\u00020\u0005H§@¢\u0006\u0002\u0010\tJ<\u0010\u000F\u001A\u00020\u00102\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001A\u0004\u0018\u00010\u00052\b\b\u0003\u0010\b\u001A\u00020\u0005H§@¢\u0006\u0002\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsTrackApi;", "", "getTrack", "Lcom/kakaoent/trevi/ad/domain/TrackResponse;", "actType", "", "ask", "env", "sdkVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "log", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendTracking", "Lcom/kakaoent/trevi/ad/domain/TreviBannerAdTrackApiData;", "sendVideoTracking", "Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface CashFriendsTrackApi {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static Object getTrack$default(CashFriendsTrackApi cashFriendsTrackApi0, String s, String s1, String s2, String s3, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTrack");
            }
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "2.3.0";
            }
            return cashFriendsTrackApi0.getTrack(s, s1, s2, s3, continuation0);
        }

        public static Object sendTracking$default(CashFriendsTrackApi cashFriendsTrackApi0, String s, String s1, String s2, String s3, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTracking");
            }
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "2.3.0";
            }
            return cashFriendsTrackApi0.sendTracking(s, s1, s2, s3, continuation0);
        }

        public static Object sendVideoTracking$default(CashFriendsTrackApi cashFriendsTrackApi0, String s, String s1, String s2, String s3, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendVideoTracking");
            }
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "2.3.0";
            }
            return cashFriendsTrackApi0.sendVideoTracking(s, s1, s2, s3, continuation0);
        }
    }

    @Nullable
    @f("/track")
    Object getTrack(@Nullable @t("actType") String arg1, @Nullable @t("ask") String arg2, @Nullable @t("env") String arg3, @NotNull @t("sdkVersion") String arg4, @NotNull Continuation arg5);

    @Nullable
    @f("")
    Object log(@NotNull @y String arg1, @NotNull Continuation arg2);

    @Nullable
    @f("/track")
    Object sendTracking(@Nullable @t("ask") String arg1, @Nullable @t("actType") String arg2, @Nullable @t("env") String arg3, @NotNull @t("sdkVersion") String arg4, @NotNull Continuation arg5);

    @Nullable
    @f("/track")
    Object sendVideoTracking(@Nullable @t("ask") String arg1, @Nullable @t("actType") String arg2, @Nullable @t("env") String arg3, @NotNull @t("sdkVersion") String arg4, @NotNull Continuation arg5);
}

