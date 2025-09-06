package com.iloen.melon.fragments.cashfriends;

import com.kakaoent.trevi.ad.TreviAd.OfferWallCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jg\u0010\u0012\u001A\u00020\u000F2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\t\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u00072\b\u0010\r\u001A\u0004\u0018\u00010\u00072\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001D\u0010\u0014\u001A\u00020\u000F2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001A\u00020\u000F2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000F0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001B\u001A\u00020\u000F2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u001A\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001D\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ;\u0010$\u001A\u00020\u000F2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010 \u001A\u00020\n2\u0006\u0010\"\u001A\u00020!2\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010\'\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\'\u0010(¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/cashfriends/SimpleOfferWallCallBack;", "Lcom/kakaoent/trevi/ad/TreviAd$OfferWallCallback;", "<init>", "()V", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "", "title", "message", "", "cancelable", "positiveButtonText", "negativeButtonText", "Lkotlin/Function0;", "Lie/H;", "positiveButtonAction", "negativeButtonAction", "showAlertDialog", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lwe/a;Lwe/a;)V", "showCustomerCenter", "(Ljava/lang/ref/WeakReference;)V", "Lkotlin/Function1;", "setAppUserId", "showLogin", "(Ljava/lang/ref/WeakReference;Lwe/k;)V", "text", "showToast", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "isCreated", "cpvLifecycle", "(Z)V", "isEnter", "", "webViewClientErrorCode", "reload", "onNetworkError", "(Ljava/lang/ref/WeakReference;ZILwe/a;)V", "url", "onReceivedAnotherSchemeUrl", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class SimpleOfferWallCallBack implements OfferWallCallback {
    public static final int $stable;

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void cpvLifecycle(boolean z) {
    }

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void onNetworkError(@NotNull WeakReference weakReference0, boolean z, int v, @NotNull a a0) {
        q.g(weakReference0, "activityRef");
        q.g(a0, "reload");
    }

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void onReceivedAnotherSchemeUrl(@NotNull String s) {
        q.g(s, "url");
    }

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void showAlertDialog(@NotNull WeakReference weakReference0, @Nullable String s, @Nullable String s1, boolean z, @NotNull String s2, @Nullable String s3, @NotNull a a0, @NotNull a a1) {
        q.g(weakReference0, "activityRef");
        q.g(s2, "positiveButtonText");
        q.g(a0, "positiveButtonAction");
        q.g(a1, "negativeButtonAction");
    }

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void showCustomerCenter(@NotNull WeakReference weakReference0) {
        q.g(weakReference0, "activityRef");
    }

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void showLogin(@NotNull WeakReference weakReference0, @NotNull k k0) {
        q.g(weakReference0, "activityRef");
        q.g(k0, "setAppUserId");
    }

    @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallCallback
    public void showToast(@NotNull WeakReference weakReference0, @Nullable String s) {
        q.g(weakReference0, "activityRef");
    }
}

