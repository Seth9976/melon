package Y8;

import B9.g;
import U4.x;
import android.util.Log;
import androidx.lifecycle.D;
import androidx.lifecycle.f;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams.Builder;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.android.billingclient.api.UserChoiceBillingListener;
import com.android.billingclient.api.UserChoiceDetails;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.GoogleIapPurchaseReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import oe.i;

public final class d implements f, BillingClientStateListener, ConsumeResponseListener, PurchasesUpdatedListener, UserChoiceBillingListener {
    public final MelonAppBase a;
    public BillingClient b;
    public final SingleLiveEvent c;
    public final SingleLiveEvent d;
    public final SingleLiveEvent e;
    public static final R6.d f;
    public static volatile d g;

    static {
        d.f = new R6.d(10);
    }

    public d(MelonAppBase melonAppBase0) {
        this.a = melonAppBase0;
        this.c = new SingleLiveEvent();
        this.d = new SingleLiveEvent();
        this.e = new SingleLiveEvent();
    }

    public final void a(Purchase purchase0) {
        LogU.Companion.d("BillingClientLifecycle", "consume() " + purchase0);
        Builder consumeParams$Builder0 = ConsumeParams.newBuilder();
        consumeParams$Builder0.setPurchaseToken(purchase0.getPurchaseToken());
        ConsumeParams consumeParams0 = consumeParams$Builder0.build();
        q.f(consumeParams0, "build(...)");
        BillingClient billingClient0 = this.b;
        if(billingClient0 != null) {
            billingClient0.consumeAsync(consumeParams0, this);
            return;
        }
        q.m("billingClient");
        throw null;
    }

    public static void b(d d0, int v) {
        e e0 = new e(v, null);
        d0.c.postValue(e0);
    }

    @Override  // androidx.lifecycle.f
    public final void c(D d0) {
        q.g(d0, "owner");
        Log.d("BillingClientLifecycle", "onCreate()");
        com.android.billingclient.api.BillingClient.Builder billingClient$Builder0 = BillingClient.newBuilder(this.a.getApplicationContext()).setListener(this).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build());
        q.f(billingClient$Builder0, "enablePendingPurchases(...)");
        if(MelonPrefs.getInstance().getBoolean("USER_CHOICE_BILLING", true)) {
            billingClient$Builder0.enableUserChoiceBilling(this);
        }
        BillingClient billingClient0 = billingClient$Builder0.build();
        q.f(billingClient0, "build(...)");
        this.b = billingClient0;
        if(!billingClient0.isReady()) {
            Log.d("BillingClientLifecycle", "onCreate() BillingClient: Start connection...");
            BillingClient billingClient1 = this.b;
            if(billingClient1 != null) {
                billingClient1.startConnection(this);
                return;
            }
            q.m("billingClient");
            throw null;
        }
    }

    public final Object d(String s, i i0) {
        BillingClient billingClient0 = this.b;
        if(billingClient0 != null) {
            com.android.billingclient.api.QueryPurchasesParams.Builder queryPurchasesParams$Builder0 = QueryPurchasesParams.newBuilder();
            queryPurchasesParams$Builder0.setProductType(s);
            QueryPurchasesParams queryPurchasesParams0 = queryPurchasesParams$Builder0.build();
            q.f(queryPurchasesParams0, "build(...)");
            return BillingClientKotlinKt.queryPurchasesAsync(billingClient0, queryPurchasesParams0, i0);
        }
        q.m("billingClient");
        throw null;
    }

    public final void e() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new c(this, null), 3, null);
    }

    @Override  // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        LogU.Companion.e("BillingClientLifecycle", "onBillingServiceDisconnected");
    }

    @Override  // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult0) {
        q.g(billingResult0, "billingResult");
        String s = billingResult0.getDebugMessage();
        q.f(s, "getDebugMessage(...)");
        Log.d("BillingClientLifecycle", "onBillingSetupFinished() responseCode:" + billingResult0.getResponseCode() + ", debugMessage:" + s);
        if(billingResult0.getResponseCode() == 0) {
            LogU.Companion.d("BillingClientLifecycle", "onBillingSetupFinished");
            this.e();
        }
    }

    @Override  // com.android.billingclient.api.ConsumeResponseListener
    public final void onConsumeResponse(BillingResult billingResult0, String s) {
        q.g(billingResult0, "billingResult");
        q.g(s, "purchaseToken");
        String s1 = billingResult0.getDebugMessage();
        q.f(s1, "getDebugMessage(...)");
        StringBuilder stringBuilder0 = x.o(billingResult0.getResponseCode(), "onConsumeResponse() ", ", ", s1, ", ");
        stringBuilder0.append(s);
        LogU.Companion.d("BillingClientLifecycle", stringBuilder0.toString());
    }

    @Override  // androidx.lifecycle.f
    public final void onDestroy(D d0) {
        Log.d("BillingClientLifecycle", "onDestroy()");
        BillingClient billingClient0 = this.b;
        if(billingClient0 != null) {
            if(billingClient0.isReady()) {
                Log.d("BillingClientLifecycle", "onDestroy() BillingClient can only be used once -- closing connection");
                BillingClient billingClient1 = this.b;
                if(billingClient1 != null) {
                    billingClient1.endConnection();
                    return;
                }
                q.m("billingClient");
                throw null;
            }
            return;
        }
        q.m("billingClient");
        throw null;
    }

    @Override  // androidx.lifecycle.f
    public final void onPause(D d0) {
    }

    @Override  // com.android.billingclient.api.PurchasesUpdatedListener
    public final void onPurchasesUpdated(BillingResult billingResult0, List list0) {
        q.g(billingResult0, "billingResult");
        int v = billingResult0.getResponseCode();
        String s = billingResult0.getDebugMessage();
        q.f(s, "getDebugMessage(...)");
        Log.d("BillingClientLifecycle", "onPurchasesUpdated() responseCode:" + v + ", debugMessage:" + s);
        if(v == 0) {
            Log.d("BillingClientLifecycle", "onPurchasesUpdated() purchases:" + list0);
            this.e();
            if(list0 != null) {
                for(Object object0: list0) {
                    boolean z = !MelonSettingInfo.isBlockIapConfirmRequest();
                    String s1 = Y8.f.a(((Purchase)object0));
                    LogU.Companion.d("BillingClientLifecycle", "requestConfirmPurchase() " + s1);
                    RequestBuilder.newInstance(new GoogleIapPurchaseReq(this.a.getApplicationContext(), s1)).tag("BillingClientLifecycle").listener(new g(18, this, ((Purchase)object0))).errorListener(new a(this, 2)).request();
                }
            }
            return;
        }
        d.b(this, v);
    }

    @Override  // androidx.lifecycle.f
    public final void onStop(D d0) {
    }

    @Override  // com.android.billingclient.api.UserChoiceBillingListener
    public final void userSelectedAlternativeBilling(UserChoiceDetails userChoiceDetails0) {
        q.g(userChoiceDetails0, "userChoiceDetails");
        e e0 = new e(1003, userChoiceDetails0.getExternalTransactionToken());
        this.c.postValue(e0);
    }
}

