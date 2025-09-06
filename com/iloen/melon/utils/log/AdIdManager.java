package com.iloen.melon.utils.log;

import H0.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.iloen.melon.MelonAppBase;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x8.f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u000B\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J\u000F\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001A\u00020\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\bJ\r\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\u0007¢\u0006\u0004\b\u000B\u0010\nR\u0014\u0010\r\u001A\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000ER$\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/utils/log/AdIdManager;", "", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "getAdId", "()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "Lcom/iloen/melon/utils/log/AdIdManager$Callback;", "callback", "Lie/H;", "(Lcom/iloen/melon/utils/log/AdIdManager$Callback;)V", "init", "()V", "refresh", "", "TAG", "Ljava/lang/String;", "a", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "getMInfo", "setMInfo", "(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;)V", "mInfo", "AdIdRefreshTask", "Callback", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AdIdManager {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001C\u0010\n\u001A\u0004\u0018\u00010\u00032\b\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000E\u0010\u000FR$\u0010\u0015\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/utils/log/AdIdManager$AdIdRefreshTask;", "Lx8/f;", "Ljava/lang/Void;", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "<init>", "()V", "Lcom/iloen/melon/utils/log/AdIdManager$Callback;", "callback", "(Lcom/iloen/melon/utils/log/AdIdManager$Callback;)V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "Lie/H;", "postTask", "(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;)V", "a", "Lcom/iloen/melon/utils/log/AdIdManager$Callback;", "getMCallback", "()Lcom/iloen/melon/utils/log/AdIdManager$Callback;", "setMCallback", "mCallback", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class AdIdRefreshTask extends f {
        public Callback a;

        public AdIdRefreshTask() {
        }

        public AdIdRefreshTask(@Nullable Callback adIdManager$Callback0) {
            this.a = adIdManager$Callback0;
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        @Nullable
        public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
            try {
                MelonAppBase.Companion.getClass();
                return AdvertisingIdClient.getAdvertisingIdInfo(t.a().getContext());
            }
            catch(Exception exception0) {
                b.w("AdIdRefreshTask Exception : ", exception0.getMessage(), LogU.Companion, "AdIdManager");
                return null;
            }
        }

        @Nullable
        public final Callback getMCallback() {
            return this.a;
        }

        public void postTask(@Nullable Info advertisingIdClient$Info0) {
            AdIdManager.INSTANCE.setMInfo(advertisingIdClient$Info0);
            Callback adIdManager$Callback0 = this.a;
            if(adIdManager$Callback0 != null) {
                adIdManager$Callback0.onReceiveAdId(advertisingIdClient$Info0);
            }
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Info)object0));
        }

        public final void setMCallback(@Nullable Callback adIdManager$Callback0) {
            this.a = adIdManager$Callback0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/log/AdIdManager$Callback;", "", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "info", "Lie/H;", "onReceiveAdId", "(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface Callback {
        void onReceiveAdId(@Nullable Info arg1);
    }

    public static final int $stable = 8;
    @NotNull
    public static final AdIdManager INSTANCE = null;
    @NotNull
    public static final String TAG = "AdIdManager";
    public static Info a;

    static {
        AdIdManager.INSTANCE = new AdIdManager();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Nullable
    public final Info getAdId() {
        return AdIdManager.a;
    }

    public final void getAdId(@Nullable Callback adIdManager$Callback0) {
        f.execute$default(new AdIdRefreshTask(adIdManager$Callback0), null, 1, null);
    }

    @Nullable
    public final Info getMInfo() {
        return AdIdManager.a;
    }

    public final void init() {
        this.refresh();
    }

    public final void refresh() {
        f.execute$default(new AdIdRefreshTask(), null, 1, null);
    }

    public final void setMInfo(@Nullable Info advertisingIdClient$Info0) {
        AdIdManager.a = advertisingIdClient$Info0;
    }
}

