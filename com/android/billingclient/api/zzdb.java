package com.android.billingclient.api;

import android.os.Bundle;
import b3.Z;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;

final class zzdb {
    public static zzda zza(Bundle bundle0, String s, String s1) {
        BillingResult billingResult0 = zzce.zzj;
        if(bundle0 == null) {
            zzb.zzk("BillingClient", s1 + " got null owned items list");
            return new zzda(billingResult0, 54);
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult1 = Z.f(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", s1 + " failed. Response code: " + v);
            return new zzda(billingResult1, 23);
        }
        if(bundle0.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle0.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle0.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList arrayList0 = bundle0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList1 = bundle0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList2 = bundle0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if(arrayList0 == null) {
                zzb.zzk("BillingClient", "Bundle returned from " + s1 + " contains null SKUs list.");
                return new zzda(billingResult0, 56);
            }
            if(arrayList1 == null) {
                zzb.zzk("BillingClient", "Bundle returned from " + s1 + " contains null purchases list.");
                return new zzda(billingResult0, 57);
            }
            if(arrayList2 == null) {
                zzb.zzk("BillingClient", "Bundle returned from " + s1 + " contains null signatures list.");
                return new zzda(billingResult0, 58);
            }
            return new zzda(zzce.zzl, 1);
        }
        zzb.zzk("BillingClient", "Bundle returned from " + s1 + " doesn\'t contain required fields.");
        return new zzda(billingResult0, 55);
    }
}

