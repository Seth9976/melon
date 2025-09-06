package com.gaa.sdk.iap;

import De.I;
import E9.g;
import E9.w;
import M6.u;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.room.O;
import androidx.work.impl.WorkDatabase_Impl;
import d5.s;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import y5.a;

public final class e implements Callable {
    public final int a;
    public final Object b;
    public final Object c;

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    @Override
    public final Object call() {
        boolean z1;
        d5.e e0;
        k k0;
        int v1;
        if(this.a != 0) {
            try {
                boolean z = false;
                try(Cursor cursor0 = w.R(((WorkDatabase_Impl)((s)this.c).a), ((O)this.b), false)) {
                    if(cursor0.moveToFirst()) {
                        if(cursor0.getInt(0) != 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                }
                return false;
            }
            catch(Throwable throwable0) {
                throw throwable0;
            }
        }
        j j0 = (j)this.c;
        a.X("PurchaseClientImpl", "Querying owned items, item type: inapp");
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = new Bundle();
        bundle0.putString("inAppSdkLibraryVersion", j0.h);
        bundle0.putBoolean("enableQuantity", true);
        int v = j0.c ? 7 : 6;
        String s = null;
        do {
            try {
                Bundle bundle1 = ((K5.a)j0.f).D0(v, "com.iloen.melon", s, bundle0);
                v1 = B.a.e(bundle1);
                if(v1 != 0) {
                    goto label_60;
                }
                ArrayList arrayList1 = bundle1.getStringArrayList("productIdList");
                ArrayList arrayList2 = bundle1.getStringArrayList("purchaseDetailList");
                ArrayList arrayList3 = bundle1.getStringArrayList("purchaseSignatureList");
                int v2 = 0;
                while(v2 < arrayList2.size()) {
                    String s1 = (String)arrayList1.get(v2);
                    String s2 = (String)arrayList2.get(v2);
                    String s3 = (String)arrayList3.get(v2);
                    a.X("PurchaseClientImpl", "Product is owned: " + s1);
                    try {
                        k0 = new k(s2, s3, "");
                    }
                    catch(JSONException jSONException0) {
                        a.Y("PurchaseClientImpl", "Got an exception trying to decode the purchase: " + jSONException0);
                        e0 = new d5.e(B.a.Z(1001), null, false, 7);
                        goto label_76;
                    }
                    if(TextUtils.isEmpty(null)) {
                        a.X("PurchaseClientImpl", "verifyPurchase() - base64PublicKey is empty!");
                        z1 = true;
                    }
                    else {
                        z1 = I.c0(s2, s3);
                    }
                    if(z1) {
                        arrayList0.add(k0);
                        ++v2;
                        continue;
                    }
                    a.Y("PurchaseClientImpl", "A signature verification error has occurred.");
                    e0 = new d5.e(B.a.Z(1002), null, false, 7);
                    goto label_76;
                }
                s = bundle1.getString("continuationKey");
                a.X("PurchaseClientImpl", "Continuation key: " + s);
            }
            catch(NullPointerException nullPointerException0) {
                goto label_67;
            }
            catch(b b0) {
                goto label_65;
            }
            catch(Exception exception0) {
                goto label_63;
            }
        }
        while(!TextUtils.isEmpty(s));
        d5.e e1 = new d5.e(B.a.Z(0), arrayList0, false, 7);
        goto label_72;
        try {
        label_60:
            e0 = new d5.e(B.a.Z(v1), null, false, 7);
            goto label_76;
        label_63:
            goto label_74;
        label_65:
            goto label_70;
        }
        catch(NullPointerException nullPointerException0) {
        }
        catch(b b0) {
            goto label_65;
        }
        catch(Exception exception0) {
            goto label_63;
        }
    label_67:
        a.Y("PurchaseClientImpl", "Got an exception trying to decode the purchase: " + nullPointerException0);
        e0 = new d5.e(B.a.Z(1001), null, false, 7);
        goto label_76;
    label_70:
        a.Y("PurchaseClientImpl", "Got an IapException trying to decode the purchase: " + b0);
        e1 = new d5.e(B.a.Z(b0.a), null, false, 7);
    label_72:
        e0 = e1;
        goto label_76;
    label_74:
        a.Y("PurchaseClientImpl", "Got exception trying to get purchases: " + exception0 + "; try to reconnect");
        e0 = new d5.e(B.a.Z(1007), null, false, 7);
    label_76:
        g g0 = j0.j;
        u u0 = new u(this, e0, false, 14);
        g0.getClass();
        if(Thread.interrupted()) {
            return null;
        }
        ((Handler)g0.a).post(u0);
        return null;
    }

    @Override
    public void finalize() {
        if(this.a != 1) {
            super.finalize();
            return;
        }
        ((O)this.b).release();
    }
}

