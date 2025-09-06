package com.kakaoent.trevi.ad.ui;

import A7.d;
import H0.b;
import P9.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.gson.n;
import com.kakaoent.trevi.ad.TreviAd.OfferWallCallback;
import com.kakaoent.trevi.ad.TreviAd.OfferWallEventCallback;
import com.kakaoent.trevi.ad.TreviAd;
import com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment;
import com.kakaoent.trevi.ad.util.AppContextHolder;
import com.kakaoent.trevi.ad.util.JsonUtilKt;
import com.kakaoent.trevi.ad.util.NetworkManager;
import com.kakaoent.trevi.ad.util.TreviLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 72\u00020\u0001:\u0005789:;B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\t\u0010\bJ\u000F\u0010\n\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\f\u0010\rJ7\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u001BJ\'\u0010\u001F\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u001F\u0010\u0019J\u000F\u0010 \u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b\"\u0010!J\u000F\u0010#\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b#\u0010!J\u000F\u0010$\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b$\u0010!J\u001B\u0010&\u001A\u00020\u00122\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010)\u001A\u00020\u00122\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b)\u0010\'J\u001B\u0010*\u001A\u00020\u00122\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b*\u0010\'J\u001B\u0010+\u001A\u00020\u00122\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b+\u0010\'J\u001B\u0010,\u001A\u00020\u00122\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b,\u0010\'J\r\u0010-\u001A\u00020\u0012\u00A2\u0006\u0004\b-\u0010!J\u000F\u0010.\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b.\u0010!J\u000F\u0010/\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b/\u0010\bR\u0018\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0003\u00100R\u0016\u00102\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001A\u0002048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106\u00A8\u0006<"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface;", "", "Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsWebViewFragment;", "fragment", "<init>", "(Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsWebViewFragment;)V", "", "getVersionInfo", "()Ljava/lang/String;", "getUserInfo", "getAdIdTrackingInfo", "packageName", "checkInstalledPackage", "(Ljava/lang/String;)Ljava/lang/String;", "dspContentId", "clientId", "advId", "endDate", "Lie/H;", "setCPIAdInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "videoUrl", "orientation", "ask", "playCPVAd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "popupUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "type", "content", "opacity", "setTitle", "showCustomerCenter", "()V", "showAdIdSetting", "showLogin", "runFinish", "url", "openAppSchemeUrl", "(Ljava/lang/String;)V", "json", "pageViewEvent", "trackExtraEvent", "trackEvent", "viewImp", "clear", "getAdIdInfo", "getAdId", "Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsWebViewFragment;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/google/gson/n;", "gson", "Lcom/google/gson/n;", "Companion", "InstallInfo", "LimitAdTrackingInfo", "UserInfo", "VersionInfo", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsWebInterface {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface$Companion;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u001A\u0010\r\u001A\u00020\u00022\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface$InstallInfo;", "", "", "isInstalled", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class InstallInfo {
        private final boolean isInstalled;

        public InstallInfo(boolean z) {
            this.isInstalled = z;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof InstallInfo ? this.isInstalled == ((InstallInfo)object0).isInstalled : false;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isInstalled);
        }

        @Override
        @NotNull
        public String toString() {
            return b.k(new StringBuilder("InstallInfo(isInstalled="), this.isInstalled, ')');
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u001A\u0010\r\u001A\u00020\u00022\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface$LimitAdTrackingInfo;", "", "", "isLimitAdTrackingEnabled", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class LimitAdTrackingInfo {
        private final boolean isLimitAdTrackingEnabled;

        public LimitAdTrackingInfo(boolean z) {
            this.isLimitAdTrackingEnabled = z;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof LimitAdTrackingInfo ? this.isLimitAdTrackingEnabled == ((LimitAdTrackingInfo)object0).isLimitAdTrackingEnabled : false;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isLimitAdTrackingEnabled);
        }

        @Override
        @NotNull
        public String toString() {
            return b.k(new StringBuilder("LimitAdTrackingInfo(isLimitAdTrackingEnabled="), this.isLimitAdTrackingEnabled, ')');
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u000BR\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001A\u0004\b\u0015\u0010\u000BR\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001A\u0004\b\u0016\u0010\u000BR\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001A\u0004\b\u0017\u0010\u000BR\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001A\u0004\b\u0018\u0010\u000B¨\u0006\u0019"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface$UserInfo;", "", "", "deviceOs", "ifa", "userId", "network", "appId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceOs", "getIfa", "getUserId", "getNetwork", "getAppId", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class UserInfo {
        @Nullable
        private final String appId;
        @Nullable
        private final String deviceOs;
        @Nullable
        private final String ifa;
        @Nullable
        private final String network;
        @Nullable
        private final String userId;

        public UserInfo(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            this.deviceOs = s;
            this.ifa = s1;
            this.userId = s2;
            this.network = s3;
            this.appId = s4;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof UserInfo)) {
                return false;
            }
            if(!q.b(this.deviceOs, ((UserInfo)object0).deviceOs)) {
                return false;
            }
            if(!q.b(this.ifa, ((UserInfo)object0).ifa)) {
                return false;
            }
            if(!q.b(this.userId, ((UserInfo)object0).userId)) {
                return false;
            }
            return q.b(this.network, ((UserInfo)object0).network) ? q.b(this.appId, ((UserInfo)object0).appId) : false;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.deviceOs == null ? 0 : this.deviceOs.hashCode();
            int v2 = this.ifa == null ? 0 : this.ifa.hashCode();
            int v3 = this.userId == null ? 0 : this.userId.hashCode();
            int v4 = this.network == null ? 0 : this.network.hashCode();
            String s = this.appId;
            if(s != null) {
                v = s.hashCode();
            }
            return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("UserInfo(deviceOs=");
            stringBuilder0.append(this.deviceOs);
            stringBuilder0.append(", ifa=");
            stringBuilder0.append(this.ifa);
            stringBuilder0.append(", userId=");
            stringBuilder0.append(this.userId);
            stringBuilder0.append(", network=");
            stringBuilder0.append(this.network);
            stringBuilder0.append(", appId=");
            return o.r(stringBuilder0, this.appId, ')');
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001F\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u001A\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000E\u0010\u000FR\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001A\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001A\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsWebInterface$VersionInfo;", "", "", "appVersion", "templateVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAppVersion", "getTemplateVersion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class VersionInfo {
        @Nullable
        private final String appVersion;
        @Nullable
        private final String templateVersion;

        public VersionInfo(@Nullable String s, @Nullable String s1) {
            this.appVersion = s;
            this.templateVersion = s1;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof VersionInfo)) {
                return false;
            }
            return q.b(this.appVersion, ((VersionInfo)object0).appVersion) ? q.b(this.templateVersion, ((VersionInfo)object0).templateVersion) : false;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.appVersion == null ? 0 : this.appVersion.hashCode();
            String s = this.templateVersion;
            if(s != null) {
                v = s.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("VersionInfo(appVersion=");
            stringBuilder0.append(this.appVersion);
            stringBuilder0.append(", templateVersion=");
            return o.r(stringBuilder0, this.templateVersion, ')');
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private CashFriendsWebViewFragment fragment;
    @NotNull
    private final n gson;
    @NotNull
    private Handler handler;
    private static boolean isInTestMode;

    static {
        CashFriendsWebInterface.Companion = new Companion(null);
    }

    public CashFriendsWebInterface(@Nullable CashFriendsWebViewFragment cashFriendsWebViewFragment0) {
        this.fragment = cashFriendsWebViewFragment0;
        this.handler = new Handler(Looper.getMainLooper());
        this.gson = new n();
    }

    public static void a(CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.runFinish$lambda$4(cashFriendsWebInterface0);
    }

    public static void b(CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.showCustomerCenter$lambda$2(cashFriendsWebInterface0);
    }

    public static void c(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.trackEvent$lambda$12(s, cashFriendsWebInterface0);
    }

    @JavascriptInterface
    @Keep
    @NotNull
    public final String checkInstalledPackage(@NotNull String s) {
        q.g(s, "packageName");
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "checkInstalledPackage(packageName : " + s + ')');
        InstallInfo cashFriendsWebInterface$InstallInfo0 = new InstallInfo(CashFriendsManager.INSTANCE.isInstallApp(s));
        String s1 = this.gson.k(cashFriendsWebInterface$InstallInfo0);
        q.f(s1, "toJson(...)");
        return s1;
    }

    public final void clear() {
        this.fragment = null;
    }

    public static void e(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.viewImp$lambda$14(s, cashFriendsWebInterface0);
    }

    public static void f(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.pageViewEvent$lambda$8(s, cashFriendsWebInterface0);
    }

    public static void g(CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.showLogin$lambda$3(cashFriendsWebInterface0);
    }

    // 去混淆评级： 低(30)
    private final String getAdId() {
        this.getAdIdInfo();
        return "";
    }

    private final void getAdIdInfo() {
        try {
            Info advertisingIdClient$Info0 = AdvertisingIdClient.getAdvertisingIdInfo(AppContextHolder.INSTANCE.getContext());
            q.f(advertisingIdClient$Info0, "getAdvertisingIdInfo(...)");
            TreviAd treviAd0 = TreviAd.INSTANCE;
            String s = advertisingIdClient$Info0.getId();
            if(s == null) {
                s = "";
            }
            treviAd0.setAdid$trevi_ad_android_sdk_release(s);
            treviAd0.setLimitAdTrackingEnabled$trevi_ad_android_sdk_release(advertisingIdClient$Info0.isLimitAdTrackingEnabled());
            return;
        }
        catch(IOException iOException0) {
        }
        catch(GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException0) {
            TreviLog.INSTANCE.e("onConsloeMessage", "Tiara setAdid Error : {}" + googlePlayServicesNotAvailableException0.getMessage());
            return;
        }
        catch(Throwable throwable0) {
            TreviLog.INSTANCE.e("onConsloeMessage", "Tiara setAdid Error : {}", throwable0);
            return;
        }
        TreviLog.INSTANCE.e("onConsloeMessage", "Tiara setAdid Error : {}" + iOException0.getMessage());
    }

    @JavascriptInterface
    @Keep
    @NotNull
    public final String getAdIdTrackingInfo() {
        this.getAdIdInfo();
        LimitAdTrackingInfo cashFriendsWebInterface$LimitAdTrackingInfo0 = new LimitAdTrackingInfo(false);
        String s = this.gson.k(cashFriendsWebInterface$LimitAdTrackingInfo0);
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "isLimitAdTrackingEnabled() : " + s);
        q.d(s);
        return s;
    }

    @JavascriptInterface
    @Keep
    @NotNull
    public final String getUserInfo() {
        boolean z;
        n n0 = this.gson;
        q.f("ANDROID", "toUpperCase(...)");
        String s = this.getAdId();
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = this.fragment;
        if(cashFriendsWebViewFragment0 == null) {
            z = false;
        }
        else {
            Context context0 = cashFriendsWebViewFragment0.getContext();
            z = context0 == null ? false : NetworkManager.INSTANCE.isWifiConnected(context0);
        }
        String s1 = n0.k(new UserInfo("ANDROID", s, "0", (z ? "WIFI" : "WWAN"), ""));
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "getUserInfo() : " + s1);
        q.d(s1);
        return s1;
    }

    @JavascriptInterface
    @Keep
    @NotNull
    public final String getVersionInfo() {
        VersionInfo cashFriendsWebInterface$VersionInfo0 = new VersionInfo("", "1.1.2");
        String s = this.gson.k(cashFriendsWebInterface$VersionInfo0);
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "getVersionInfo() : " + s);
        q.d(s);
        return s;
    }

    public static void h(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.trackExtraEvent$lambda$10(s, cashFriendsWebInterface0);
    }

    public static void i(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        CashFriendsWebInterface.openAppSchemeUrl$lambda$6(s, cashFriendsWebInterface0);
    }

    @JavascriptInterface
    @Keep
    public final void openAppSchemeUrl(@Nullable String s) {
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "openAppSchemeUrl(url : " + s + ')');
        this.handler.post(new P9.b(s, this, 1));
    }

    private static final void openAppSchemeUrl$lambda$6(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        if(s != null) {
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
            if(cashFriendsWebViewFragment0 != null) {
                OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(cashFriendsWebViewFragment0.hashCode());
                if(treviAd$OfferWallCallback0 != null) {
                    treviAd$OfferWallCallback0.onReceivedAnotherSchemeUrl(s);
                }
            }
        }
    }

    @JavascriptInterface
    @Keep
    public final void pageViewEvent(@Nullable String s) {
        this.handler.post(new P9.b(s, this, 3));
    }

    private static final void pageViewEvent$lambda$8(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        if(s != null) {
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
            if(cashFriendsWebViewFragment0 != null) {
                OfferWallEventCallback treviAd$OfferWallEventCallback0 = (OfferWallEventCallback)TreviAd.INSTANCE.getOfferWallEventCallbackList$trevi_ad_android_sdk_release().get(cashFriendsWebViewFragment0.hashCode());
                if(treviAd$OfferWallEventCallback0 != null) {
                    treviAd$OfferWallEventCallback0.pageViewEvent(JsonUtilKt.jsonStringToHashMap(s));
                }
            }
        }
    }

    @JavascriptInterface
    @Keep
    public final void playCPVAd(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "videoUrl");
        q.g(s1, "orientation");
        q.g(s2, "ask");
        StringBuilder stringBuilder0 = d.o("playCPVAd(videoUrl : ", s, ", orientation : ", s1, ", ask : ");
        stringBuilder0.append(s2);
        TreviLog.INSTANCE.d("CashFriendsWebInterface", stringBuilder0.toString());
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = this.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            cashFriendsWebViewFragment0.playVideo(s, s1, s2, "");
        }
    }

    @JavascriptInterface
    @Keep
    public final void playCPVAd(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "videoUrl");
        q.g(s1, "orientation");
        q.g(s2, "ask");
        q.g(s3, "popupUrl");
        StringBuilder stringBuilder0 = d.o("playCPVAd(videoUrl : ", s, ", orientation : ", s1, ", ask : ");
        stringBuilder0.append(s2);
        stringBuilder0.append(", popupUrl : ");
        stringBuilder0.append(s3);
        stringBuilder0.append(')');
        TreviLog.INSTANCE.d("CashFriendsWebInterface", stringBuilder0.toString());
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = this.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            cashFriendsWebViewFragment0.playVideo(s, s1, s2, s3);
        }
    }

    @JavascriptInterface
    @Keep
    public final void runFinish() {
        this.handler.post(new a(this, 1));
    }

    private static final void runFinish$lambda$4(CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            FragmentActivity fragmentActivity0 = cashFriendsWebViewFragment0.getActivity();
            if(fragmentActivity0 != null) {
                fragmentActivity0.finish();
            }
        }
    }

    @JavascriptInterface
    @Keep
    public final void setCPIAdInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "dspContentId");
        q.g(s1, "clientId");
        q.g(s2, "advId");
        q.g(s3, "packageName");
        q.g(s4, "endDate");
        StringBuilder stringBuilder0 = d.o("setCPIAdInfo(dspContentId : ", s, ", clientId : ", s1, ", advId : ");
        d.u(stringBuilder0, s2, ", packageName : ", s3, ", endDate : ");
        stringBuilder0.append(s4);
        stringBuilder0.append(')');
        TreviLog.INSTANCE.d("CashFriendsWebInterface", stringBuilder0.toString());
        CashFriendsManager.INSTANCE.setCpiPackageInfo(s, s1, s2, s3, s4);
    }

    @JavascriptInterface
    @Keep
    public final void setTitle(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "type");
        q.g(s1, "content");
        q.g(s2, "opacity");
        StringBuilder stringBuilder0 = d.o("setTitle(type : ", s, ", content : ", s1, ", opacity : ");
        stringBuilder0.append(s2);
        stringBuilder0.append(')');
        TreviLog.INSTANCE.d("CashFriendsWebInterface", stringBuilder0.toString());
        this.handler.post(new D5.a(this, s, s1, s2, 1));
    }

    private static final void setTitle$lambda$1(CashFriendsWebInterface cashFriendsWebInterface0, String s, String s1, String s2) {
        q.g(cashFriendsWebInterface0, "this$0");
        q.g(s, "$type");
        q.g(s1, "$content");
        q.g(s2, "$opacity");
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            cashFriendsWebViewFragment0.setHeaderTitle(s, s1, Float.parseFloat(s2));
        }
    }

    @JavascriptInterface
    @Keep
    public final void showAdIdSetting() {
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "showAdIdSetting()");
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = this.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            cashFriendsWebViewFragment0.showAdIdSetting();
        }
    }

    @JavascriptInterface
    @Keep
    public final void showCustomerCenter() {
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "showCustomerCenter()");
        this.handler.post(new a(this, 0));
    }

    private static final void showCustomerCenter$lambda$2(CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            cashFriendsWebViewFragment0.showCustomerCenter();
        }
    }

    @JavascriptInterface
    @Keep
    public final void showLogin() {
        TreviLog.INSTANCE.d("CashFriendsWebInterface", "showLogin()");
        this.handler.post(new a(this, 2));
    }

    private static final void showLogin$lambda$3(CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
        if(cashFriendsWebViewFragment0 != null) {
            cashFriendsWebViewFragment0.showLogin();
        }
    }

    @JavascriptInterface
    @Keep
    public final void trackEvent(@Nullable String s) {
        this.handler.post(new P9.b(s, this, 4));
    }

    private static final void trackEvent$lambda$12(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        if(s != null) {
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
            if(cashFriendsWebViewFragment0 != null) {
                OfferWallEventCallback treviAd$OfferWallEventCallback0 = (OfferWallEventCallback)TreviAd.INSTANCE.getOfferWallEventCallbackList$trevi_ad_android_sdk_release().get(cashFriendsWebViewFragment0.hashCode());
                if(treviAd$OfferWallEventCallback0 != null) {
                    treviAd$OfferWallEventCallback0.trackEvent(JsonUtilKt.jsonStringToHashMap(s));
                }
            }
        }
    }

    @JavascriptInterface
    @Keep
    public final void trackExtraEvent(@Nullable String s) {
        this.handler.post(new P9.b(s, this, 2));
    }

    private static final void trackExtraEvent$lambda$10(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        if(s != null) {
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
            if(cashFriendsWebViewFragment0 != null) {
                OfferWallEventCallback treviAd$OfferWallEventCallback0 = (OfferWallEventCallback)TreviAd.INSTANCE.getOfferWallEventCallbackList$trevi_ad_android_sdk_release().get(cashFriendsWebViewFragment0.hashCode());
                if(treviAd$OfferWallEventCallback0 != null) {
                    treviAd$OfferWallEventCallback0.trackExtraEvent(JsonUtilKt.jsonStringToHashMap(s));
                }
            }
        }
    }

    @JavascriptInterface
    @Keep
    public final void viewImp(@Nullable String s) {
        this.handler.post(new P9.b(s, this, 0));
    }

    private static final void viewImp$lambda$14(String s, CashFriendsWebInterface cashFriendsWebInterface0) {
        q.g(cashFriendsWebInterface0, "this$0");
        if(s != null) {
            CashFriendsWebViewFragment cashFriendsWebViewFragment0 = cashFriendsWebInterface0.fragment;
            if(cashFriendsWebViewFragment0 != null) {
                OfferWallEventCallback treviAd$OfferWallEventCallback0 = (OfferWallEventCallback)TreviAd.INSTANCE.getOfferWallEventCallbackList$trevi_ad_android_sdk_release().get(cashFriendsWebViewFragment0.hashCode());
                if(treviAd$OfferWallEventCallback0 != null) {
                    treviAd$OfferWallEventCallback0.viewImp(JsonUtilKt.jsonStringToHashMap(s));
                }
            }
        }
    }
}

