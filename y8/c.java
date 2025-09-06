package Y8;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResult;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final d B;
    public PurchasesResult r;
    public int w;

    public c(d d0, Continuation continuation0) {
        this.B = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PurchasesResult purchasesResult0;
        a a0 = a.a;
        d d0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.w = 1;
                object0 = d0.d("subs", this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_10;
            }
            case 1: {
                d5.n.D(object0);
            label_10:
                this.r = (PurchasesResult)object0;
                this.w = 2;
                Object object1 = d0.d("inapp", this);
                if(object1 == a0) {
                    return a0;
                }
                purchasesResult0 = (PurchasesResult)object0;
                object0 = object1;
                break;
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
        if(purchasesResult0.getBillingResult().getResponseCode() == 0) {
            d0.e.postValue(purchasesResult0.getPurchasesList());
        }
        if(((PurchasesResult)object0).getBillingResult().getResponseCode() == 0) {
            d0.d.postValue(((PurchasesResult)object0).getPurchasesList());
            for(Object object2: ((PurchasesResult)object0).getPurchasesList()) {
                Purchase purchase0 = (Purchase)object2;
                if(purchase0.isAcknowledged()) {
                    d0.a(purchase0);
                }
            }
        }
        return H.a;
    }
}

