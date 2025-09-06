package Y8;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResult;
import com.android.billingclient.api.QueryPurchasesParams.Builder;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.gson.o;
import com.iloen.melon.iap.google.GoogleIapOwnedPurchase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.GoogleIapPurchaseRestoreReq;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class b extends i implements n {
    public final d B;
    public PurchasesResult r;
    public int w;

    public b(d d0, Continuation continuation0) {
        this.B = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        w w1;
        PurchasesResult purchasesResult0;
        a a0 = a.a;
        d d0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                BillingClient billingClient0 = d0.b;
                if(billingClient0 != null) {
                    Builder queryPurchasesParams$Builder0 = QueryPurchasesParams.newBuilder();
                    queryPurchasesParams$Builder0.setProductType("subs");
                    QueryPurchasesParams queryPurchasesParams0 = queryPurchasesParams$Builder0.build();
                    q.f(queryPurchasesParams0, "build(...)");
                    this.w = 1;
                    object0 = BillingClientKotlinKt.queryPurchasesAsync(billingClient0, queryPurchasesParams0, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_18;
                }
                q.m("billingClient");
                throw null;
            }
            case 1: {
                d5.n.D(object0);
            label_18:
                BillingClient billingClient1 = d0.b;
                if(billingClient1 != null) {
                    Builder queryPurchasesParams$Builder1 = QueryPurchasesParams.newBuilder();
                    queryPurchasesParams$Builder1.setProductType("inapp");
                    QueryPurchasesParams queryPurchasesParams1 = queryPurchasesParams$Builder1.build();
                    q.f(queryPurchasesParams1, "build(...)");
                    this.r = (PurchasesResult)object0;
                    this.w = 2;
                    Object object1 = BillingClientKotlinKt.queryPurchasesAsync(billingClient1, queryPurchasesParams1, this);
                    if(object1 == a0) {
                        return a0;
                    }
                    purchasesResult0 = (PurchasesResult)object0;
                    object0 = object1;
                    break;
                }
                q.m("billingClient");
                throw null;
            }
            case 2: {
                purchasesResult0 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.Companion.d("BillingClientLifecycle", "restorePurchases() SUBS subResult:" + purchasesResult0);
        LogU.Companion.d("BillingClientLifecycle", "restorePurchases() INAPP purchasesList:" + ((PurchasesResult)object0));
        if(purchasesResult0.getBillingResult().getResponseCode() == 0 && ((PurchasesResult)object0).getBillingResult().getResponseCode() == 0) {
            List list0 = purchasesResult0.getPurchasesList();
            List list1 = ((PurchasesResult)object0).getPurchasesList();
            d0.getClass();
            w w0 = w.a;
            if(list0 == null) {
                w1 = w0;
            }
            else {
                ArrayList arrayList0 = new ArrayList();
                for(Object object2: list0) {
                    if(!((Purchase)object2).isAcknowledged()) {
                        arrayList0.add(object2);
                    }
                }
                w1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object3: arrayList0) {
                    ((ArrayList)w1).add(f.a(((Purchase)object3)));
                }
            }
            if(list1 != null) {
                ArrayList arrayList1 = new ArrayList();
                for(Object object4: list1) {
                    if(!((Purchase)object4).isAcknowledged()) {
                        arrayList1.add(object4);
                    }
                }
                ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
                for(Object object5: arrayList1) {
                    arrayList2.add(f.a(((Purchase)object5)));
                }
                w0 = arrayList2;
            }
            GoogleIapOwnedPurchase googleIapOwnedPurchase0 = new GoogleIapOwnedPurchase(w1, w0);
            String s = new o().a().k(googleIapOwnedPurchase0);
            LogU.Companion.d("GoogleIapUtilities", "convertPurchaseListToNonAcknowledgedJsonStr() result:" + s);
            q.d(s);
            LogU.Companion.d("BillingClientLifecycle", "requestRestorePurchase() reqJson:" + s);
            RequestBuilder.newInstance(new GoogleIapPurchaseRestoreReq(d0.a.getApplicationContext(), s)).tag("BillingClientLifecycle").listener(new Y8.a(d0, 0)).errorListener(new Y8.a(d0, 1)).request();
            return H.a;
        }
        d.b(d0, 2002);
        return H.a;
    }
}

