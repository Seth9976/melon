package com.kakaoent.trevi.ad.repository.remote.interactor;

import A7.d;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.t;
import com.kakaoent.trevi.ad.domain.CashFriendsApplyApiData;
import com.kakaoent.trevi.ad.util.AppContextHolder;
import com.kakaoent.trevi.ad.util.DeviceInfoUtil;
import com.kakaoent.trevi.ad.util.PrintExtKt;
import com.kakaoent.trevi.ad.util.TreviAdFunctionKt;
import com.kakaoent.trevi.ad.util.TreviLog;
import ie.H;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00C0\u0002\u0018\u00002\u00020\u0001:\u00016B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000E\u0010\u000FJ5\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\t\u00A2\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0010\u001A\u0004\u0018\u00010\t2\b\u0010\u0011\u001A\u0004\u0018\u00010\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001A\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u0003J\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010 \u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b \u0010\fJ%\u0010#\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001D\u0018\u00010\"2\u0006\u0010!\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b#\u0010$J-\u0010&\u001A\u00020\u00062\u0006\u0010!\u001A\u00020\t2\u0014\u0010%\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001D\u0018\u00010\"H\u0002\u00A2\u0006\u0004\b&\u0010\'J\u001D\u0010(\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001D\u0018\u00010\"H\u0002\u00A2\u0006\u0004\b(\u0010)J#\u0010+\u001A\u00020\u00062\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001D0\"H\u0002\u00A2\u0006\u0004\b+\u0010,R\u0016\u0010.\u001A\u00020-8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001A\u0002008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001A\u0002038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105\u00A8\u00067"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lie/H;", "initialize", "(Landroid/content/Context;)V", "", "packageName", "checkAppliedAndNotify", "(Ljava/lang/String;)V", "", "isInstallApp", "(Ljava/lang/String;)Z", "dspContentId", "clientId", "advId", "expDate", "setCpiPackageInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kakaoent/trevi/ad/domain/CashFriendsApplyApiData;", "notifyInstalled", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "checkCpiExpire", "(Ljava/lang/String;Ljava/lang/String;)Z", "retryNotifyInstalled", "Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsManager$CpiModel;", "getCpiPackageInfo", "(Ljava/lang/String;)Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsManager$CpiModel;", "removeCpiPackageInfo", "key", "Ljava/util/HashMap;", "getJsonToListValue", "(Ljava/lang/String;)Ljava/util/HashMap;", "obj", "setJsonFromListValue", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getCpiPackageNames", "()Ljava/util/HashMap;", "packageList", "setCpiPackageNames", "(Ljava/util/HashMap;)V", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsInstallReceiver;", "mPackageReceiver", "Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsInstallReceiver;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "CpiModel", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000E\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u0006\"\u0004\b\u000B\u0010\bR\u001C\u0010\f\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u0006\"\u0004\b\u000E\u0010\bR\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsManager$CpiModel;", "", "()V", "advId", "", "getAdvId", "()Ljava/lang/String;", "setAdvId", "(Ljava/lang/String;)V", "clientId", "getClientId", "setClientId", "dspContentId", "getDspContentId", "setDspContentId", "expDate", "getExpDate", "setExpDate", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class CpiModel {
        @Nullable
        private String advId;
        @Nullable
        private String clientId;
        @Nullable
        private String dspContentId;
        @Nullable
        private String expDate;

        @Nullable
        public final String getAdvId() {
            return this.advId;
        }

        @Nullable
        public final String getClientId() {
            return this.clientId;
        }

        @Nullable
        public final String getDspContentId() {
            return this.dspContentId;
        }

        @Nullable
        public final String getExpDate() {
            return this.expDate;
        }

        public final void setAdvId(@Nullable String s) {
            this.advId = s;
        }

        public final void setClientId(@Nullable String s) {
            this.clientId = s;
        }

        public final void setDspContentId(@Nullable String s) {
            this.dspContentId = s;
        }

        public final void setExpDate(@Nullable String s) {
            this.expDate = s;
        }
    }

    @NotNull
    public static final CashFriendsManager INSTANCE;
    @NotNull
    private static CashFriendsInstallReceiver mPackageReceiver;
    @NotNull
    private static CoroutineScope scope;
    private static SharedPreferences sharedPreferences;

    static {
        CashFriendsManager.INSTANCE = new CashFriendsManager();
        CashFriendsManager.mPackageReceiver = new CashFriendsInstallReceiver();
        CashFriendsManager.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    public final void checkAppliedAndNotify(@NotNull String s) {
        q.g(s, "packageName");
        TreviLog.INSTANCE.d("CashFriendsManager", "checkAppliedAndNotify packageName : " + s);
        CpiModel cashFriendsManager$CpiModel0 = this.getCpiPackageInfo(s);
        if(cashFriendsManager$CpiModel0 == null || !this.isInstallApp(s)) {
            return;
        }
        String s1 = cashFriendsManager$CpiModel0.getExpDate();
        if(s1 == null) {
            s1 = "";
        }
        if(!this.checkCpiExpire(s1, s)) {
            this.removeCpiPackageInfo(s);
            return;
        }
        String s2 = cashFriendsManager$CpiModel0.getDspContentId();
        if(s2 != null && s2.length() != 0) {
            FlowKt.launchIn(FlowKt.catch(FlowKt.onEach(this.notifyInstalled(cashFriendsManager$CpiModel0.getDspContentId(), cashFriendsManager$CpiModel0.getClientId(), cashFriendsManager$CpiModel0.getAdvId()), new n(null) {
                final String $packageName;
                Object L$0;
                int label;

                {
                    this.$packageName = s;
                    super(2, continuation0);
                }

                @Override  // oe.a
                @NotNull
                public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                    Continuation continuation1 = new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.checkAppliedAndNotify.1(this.$packageName, continuation0);
                    continuation1.L$0 = object0;
                    return continuation1;
                }

                @Nullable
                public final Object invoke(@NotNull CashFriendsApplyApiData cashFriendsApplyApiData0, @Nullable Continuation continuation0) {
                    return ((com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.checkAppliedAndNotify.1)this.create(cashFriendsApplyApiData0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CashFriendsApplyApiData)object0), ((Continuation)object1));
                }

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    d5.n.D(object0);
                    TreviLog.INSTANCE.e("CashFriendsManager", "checkAppliedAndNotify Success : " + ((CashFriendsApplyApiData)this.L$0));
                    CashFriendsManager.INSTANCE.removeCpiPackageInfo(this.$packageName);
                    return H.a;
                }
            }), new o() {
                Object L$0;
                int label;

                {
                    super(3, continuation0);
                }

                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
                }

                @Nullable
                public final Object invoke(@NotNull FlowCollector flowCollector0, @NotNull Throwable throwable0, @Nullable Continuation continuation0) {
                    com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.checkAppliedAndNotify.2 cashFriendsManager$checkAppliedAndNotify$20 = new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.checkAppliedAndNotify.2(continuation0);
                    cashFriendsManager$checkAppliedAndNotify$20.L$0 = throwable0;
                    return cashFriendsManager$checkAppliedAndNotify$20.invokeSuspend(H.a);
                }

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    d5.n.D(object0);
                    TreviLog.INSTANCE.e("CashFriendsManager", "checkAppliedAndNotify Fail : " + ((Throwable)this.L$0));
                    return H.a;
                }
            }), CashFriendsManager.scope);
        }
    }

    private final boolean checkCpiExpire(String s, String s1) {
        PackageManager packageManager0 = AppContextHolder.INSTANCE.getContext().getPackageManager();
        q.f(packageManager0, "getPackageManager(...)");
        PackageInfo packageInfo0 = packageManager0.getPackageInfo(s1, 0);
        long v = packageInfo0.firstInstallTime;
        long v1 = PrintExtKt.toMilliseconds(s);
        TreviLog.INSTANCE.d("CashFriendsManager", "Package Installed: " + packageInfo0.firstInstallTime);
        TreviLog.INSTANCE.e("CashFriendsManager", "Server Expire Time: " + PrintExtKt.toMilliseconds(s));
        return v < v1;
    }

    private final CpiModel getCpiPackageInfo(String s) {
        HashMap hashMap0 = this.getCpiPackageNames();
        return hashMap0 == null || !hashMap0.containsKey(s) ? null : ((CpiModel)hashMap0.get(s));
    }

    private final HashMap getCpiPackageNames() {
        return this.getJsonToListValue("CPI_PACKAGE_KEY");
    }

    private final HashMap getJsonToListValue(String s) {
        SharedPreferences sharedPreferences0 = CashFriendsManager.sharedPreferences;
        if(sharedPreferences0 != null) {
            String s1 = sharedPreferences0.getString(s, "");
            return q.b(s1, "") ? null : ((HashMap)new com.google.gson.n().f(s1, new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.getJsonToListValue.1().getType()));
        }
        q.m("sharedPreferences");
        throw null;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsManager$getJsonToListValue$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsManager$CpiModel;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public final class com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.getJsonToListValue.1 extends TypeToken {
        }

    }

    public final void initialize(@NotNull Context context0) {
        q.g(context0, "context");
        TreviLog.INSTANCE.d("CashFriendsManager", "initialize");
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("TREVI_AD_CASH_FRIENDS_SHARED_PREFERENCE", 0);
        q.f(sharedPreferences0, "getSharedPreferences(...)");
        CashFriendsManager.sharedPreferences = sharedPreferences0;
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter0.addDataScheme("package");
        Context context1 = context0.getApplicationContext();
        q.f(context1, "getApplicationContext(...)");
        TreviAdFunctionKt.registerReceiverCompat$default(context1, CashFriendsManager.mPackageReceiver, intentFilter0, false, 4, null);
        TreviLog.INSTANCE.d("CashFriendsManager", "initialize registerReceiver complete");
        this.retryNotifyInstalled();
    }

    public final boolean isInstallApp(@NotNull String s) {
        q.g(s, "packageName");
        PackageManager packageManager0 = AppContextHolder.INSTANCE.getContext().getPackageManager();
        try {
            packageManager0.getPackageInfo(s, 1);
            return true;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return false;
        }
    }

    @NotNull
    public final Flow notifyInstalled(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        t t0 = new t();
        try {
            t0.e("dspContentId", s);
            t0.e("clientId", s1);
            t0.e("advId", s2);
            t0.e("env", "real");
            Locale locale0 = Locale.getDefault();
            q.f(locale0, "getDefault(...)");
            String s3 = "Android".toUpperCase(locale0);
            q.f(s3, "toUpperCase(...)");
            t0.e("deviceOs", s3);
            t0.e("ip", DeviceInfoUtil.INSTANCE.getCurrentIp());
            t0.e("userId", "0");
            return CashFriendsInteractor.INSTANCE.notifyInstalled(t0);
        }
        catch(r r0) {
            r0.printStackTrace();
            return CashFriendsInteractor.INSTANCE.notifyInstalled(t0);
        }
    }

    private final void removeCpiPackageInfo(String s) {
        HashMap hashMap0 = this.getCpiPackageNames();
        if(hashMap0 != null) {
            CpiModel cashFriendsManager$CpiModel0 = (CpiModel)hashMap0.remove(s);
        }
        if(hashMap0 != null) {
            CashFriendsManager.INSTANCE.setCpiPackageNames(hashMap0);
        }
        TreviLog.INSTANCE.d("CashFriendsManager", "removeCpiPackageInfo success");
    }

    private final void retryNotifyInstalled() {
        HashMap hashMap0 = this.getCpiPackageNames();
        if(hashMap0 != null) {
            for(Object object0: hashMap0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                CpiModel cashFriendsManager$CpiModel0 = (CpiModel)map$Entry0.getValue();
                String s = (String)map$Entry0.getKey();
                CashFriendsManager cashFriendsManager0 = CashFriendsManager.INSTANCE;
                if(cashFriendsManager0.isInstallApp(s)) {
                    TreviLog.INSTANCE.d("CashFriendsManager", "retryNotifyInstalled() : 설치가 되어있지만 notifyInstalled 를 못한 광고 Retry: " + ((String)map$Entry0.getKey()));
                    String s1 = cashFriendsManager$CpiModel0.getExpDate();
                    if(s1 == null) {
                        s1 = "";
                    }
                    if(!cashFriendsManager0.checkCpiExpire(s1, s)) {
                        cashFriendsManager0.removeCpiPackageInfo(s);
                        return;
                    }
                    FlowKt.launchIn(FlowKt.catch(FlowKt.onEach(cashFriendsManager0.notifyInstalled(cashFriendsManager$CpiModel0.getDspContentId(), cashFriendsManager$CpiModel0.getClientId(), cashFriendsManager$CpiModel0.getAdvId()), new n(null) {
                        final String $packageName;
                        Object L$0;
                        int label;

                        {
                            this.$packageName = s;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        @NotNull
                        public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                            Continuation continuation1 = new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.retryNotifyInstalled.1.1(this.$packageName, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Nullable
                        public final Object invoke(@NotNull CashFriendsApplyApiData cashFriendsApplyApiData0, @Nullable Continuation continuation0) {
                            return ((com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.retryNotifyInstalled.1.1)this.create(cashFriendsApplyApiData0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CashFriendsApplyApiData)object0), ((Continuation)object1));
                        }

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            TreviLog.INSTANCE.e("CashFriendsManager", "retryNotifyInstalled() Success : " + ((CashFriendsApplyApiData)this.L$0));
                            CashFriendsManager.INSTANCE.removeCpiPackageInfo(this.$packageName);
                            return H.a;
                        }
                    }), new o(null) {
                        final String $packageName;
                        Object L$0;
                        int label;

                        {
                            this.$packageName = s;
                            super(3, continuation0);
                        }

                        @Override  // we.o
                        public Object invoke(Object object0, Object object1, Object object2) {
                            return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
                        }

                        @Nullable
                        public final Object invoke(@NotNull FlowCollector flowCollector0, @NotNull Throwable throwable0, @Nullable Continuation continuation0) {
                            com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.retryNotifyInstalled.1.2 cashFriendsManager$retryNotifyInstalled$1$20 = new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsManager.retryNotifyInstalled.1.2(this.$packageName, continuation0);
                            cashFriendsManager$retryNotifyInstalled$1$20.L$0 = throwable0;
                            return cashFriendsManager$retryNotifyInstalled$1$20.invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            TreviLog.INSTANCE.e("CashFriendsManager", "retryNotifyInstalled() Fail : " + ((Throwable)this.L$0));
                            CashFriendsManager.INSTANCE.removeCpiPackageInfo(this.$packageName);
                            return H.a;
                        }
                    }), CashFriendsManager.scope);
                }
                else {
                    TreviLog.INSTANCE.e("CashFriendsManager", "설치가 안되어 있으니 무효");
                    cashFriendsManager0.removeCpiPackageInfo(((String)map$Entry0.getKey()));
                }
            }
        }
    }

    public final void setCpiPackageInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "dspContentId");
        q.g(s1, "clientId");
        q.g(s2, "advId");
        q.g(s3, "packageName");
        q.g(s4, "expDate");
        TreviLog treviLog0 = TreviLog.INSTANCE;
        treviLog0.d("CashFriendsManager", Y.l(d.o("setCpiPackageInfo dspContentId : ", s, ", clientId : ", s1, ", packageName : "), s3, ", expDate : ", s4));
        HashMap hashMap0 = this.getCpiPackageNames();
        if(hashMap0 == null) {
            hashMap0 = new HashMap();
        }
        else {
            treviLog0.d("CashFriendsManager", "setCpiPackageInfo() " + hashMap0 + " exists");
            if(hashMap0.containsKey(s3)) {
                hashMap0.remove(s3);
            }
        }
        CpiModel cashFriendsManager$CpiModel0 = new CpiModel();
        cashFriendsManager$CpiModel0.setDspContentId(s);
        cashFriendsManager$CpiModel0.setClientId(s1);
        cashFriendsManager$CpiModel0.setAdvId(s2);
        cashFriendsManager$CpiModel0.setExpDate(s4);
        hashMap0.put(s3, cashFriendsManager$CpiModel0);
        this.setCpiPackageNames(hashMap0);
    }

    private final void setCpiPackageNames(HashMap hashMap0) {
        TreviLog.INSTANCE.e("CashFriendsManager", "setCpiPackageNames");
        this.setJsonFromListValue("CPI_PACKAGE_KEY", hashMap0);
    }

    private final void setJsonFromListValue(String s, HashMap hashMap0) {
        SharedPreferences sharedPreferences0 = CashFriendsManager.sharedPreferences;
        if(sharedPreferences0 != null) {
            sharedPreferences0.edit().putString(s, new com.google.gson.n().k(hashMap0)).apply();
            return;
        }
        q.m("sharedPreferences");
        throw null;
    }
}

