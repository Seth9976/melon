package Y8;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResult;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final h B;
    public PurchasesResult r;
    public int w;

    public g(h h0, Continuation continuation0) {
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PurchasesResult purchasesResult1;
        a a0 = a.a;
        PurchasesResult purchasesResult0 = null;
        h h0 = this.B;
        boolean z = true;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                d d0 = h0.a;
                if(d0 == null) {
                    purchasesResult1 = null;
                }
                else {
                    this.w = 1;
                    object0 = d0.d("subs", this);
                    if(object0 == a0) {
                        return a0;
                    }
                    purchasesResult1 = (PurchasesResult)object0;
                }
                goto label_18;
            }
            case 1: {
                d5.n.D(object0);
                purchasesResult1 = (PurchasesResult)object0;
            label_18:
                d d1 = h0.a;
                if(d1 != null) {
                    this.r = purchasesResult1;
                    this.w = 2;
                    Object object1 = d1.d("inapp", this);
                    if(object1 == a0) {
                        return a0;
                    }
                    purchasesResult0 = (PurchasesResult)object1;
                }
                break;
            }
            case 2: {
                PurchasesResult purchasesResult2 = this.r;
                d5.n.D(object0);
                purchasesResult0 = (PurchasesResult)object0;
                purchasesResult1 = purchasesResult2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("GoogleIapViewModel", "checkRestore() subResult:" + purchasesResult1);
        logU$Companion0.d("GoogleIapViewModel", "checkRestore() purchasesList:" + purchasesResult0);
        if(purchasesResult1 != null) {
            BillingResult billingResult0 = purchasesResult1.getBillingResult();
            if(billingResult0 != null && billingResult0.getResponseCode() == 0 && purchasesResult0 != null) {
                BillingResult billingResult1 = purchasesResult0.getBillingResult();
                if(billingResult1 != null && billingResult1.getResponseCode() == 0) {
                    if(!f.b(purchasesResult1.getPurchasesList()) && !f.b(purchasesResult0.getPurchasesList())) {
                        z = false;
                    }
                    l1.B("checkRestore() isHasNeededRestoredPurchase:", z, logU$Companion0, "GoogleIapViewModel");
                    h0.b(1002, (z ? "\"Y\"" : "\"N\""));
                }
            }
        }
        return H.a;
    }
}

