package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzcd;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzge;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzn extends BroadcastReceiver {
    final zzo zza;
    private boolean zzb;
    private final boolean zzc;

    public zzn(zzo zzo0, boolean z) {
        this.zza = zzo0;
        super();
        this.zzc = z;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        Bundle bundle0 = intent0.getExtras();
        int v = 1;
        if(bundle0 == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            BillingResult billingResult0 = zzce.zzj;
            zzga zzga0 = zzcb.zza(11, 1, billingResult0);
            this.zza.zze.zza(zzga0);
            zzo zzo0 = this.zza;
            if(zzo0.zzb == null) {
                return;
            }
            zzo0.zzb.onPurchasesUpdated(billingResult0, null);
            return;
        }
        BillingResult billingResult1 = zzb.zze(intent0, "BillingBroadcastManager");
        String s = intent0.getAction();
        if(Objects.equals(bundle0.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW")) {
            v = 2;
        }
        if(!s.equals("com.android.vending.billing.PURCHASES_UPDATED") && !s.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            if(s.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                if(billingResult1.getResponseCode() != 0) {
                    this.zzd(bundle0, billingResult1, v);
                    this.zza.zzb.onPurchasesUpdated(billingResult1, zzai.zzk());
                    return;
                }
                if(this.zza.zzc == null && this.zza.zzd == null) {
                    zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                    zzga zzga1 = zzcb.zza(77, v, zzce.zzj);
                    this.zza.zze.zza(zzga1);
                    this.zza.zzb.onPurchasesUpdated(zzce.zzj, zzai.zzk());
                    return;
                }
                String s1 = bundle0.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if(s1 != null) {
                    try {
                        if(this.zza.zzd == null) {
                            JSONArray jSONArray0 = new JSONObject(s1).optJSONArray("products");
                            ArrayList arrayList0 = new ArrayList();
                            if(jSONArray0 != null) {
                                for(int v1 = 0; v1 < jSONArray0.length(); ++v1) {
                                    JSONObject jSONObject0 = jSONArray0.optJSONObject(v1);
                                    if(jSONObject0 != null) {
                                        arrayList0.add(new zze(jSONObject0, null));
                                    }
                                }
                            }
                            this.zza.zzc.zza();
                        }
                        else {
                            UserChoiceDetails userChoiceDetails0 = new UserChoiceDetails(s1);
                            this.zza.zzd.userSelectedAlternativeBilling(userChoiceDetails0);
                        }
                    }
                    catch(JSONException unused_ex) {
                        zzb.zzk("BillingBroadcastManager", "Error when parsing invalid user choice data: [" + s1 + "]");
                        zzga zzga2 = zzcb.zza(17, v, zzce.zzj);
                        this.zza.zze.zza(zzga2);
                        this.zza.zzb.onPurchasesUpdated(zzce.zzj, zzai.zzk());
                        return;
                    }
                    zzge zzge0 = zzcb.zzc(v);
                    this.zza.zze.zzc(zzge0);
                    return;
                }
                zzb.zzk("BillingBroadcastManager", "Couldn\'t find alternative billing user choice data in bundle.");
                zzga zzga3 = zzcb.zza(16, v, zzce.zzj);
                this.zza.zze.zza(zzga3);
                this.zza.zzb.onPurchasesUpdated(zzce.zzj, zzai.zzk());
            }
            return;
        }
        List list0 = zzb.zzi(bundle0);
        if(billingResult1.getResponseCode() == 0) {
            zzge zzge1 = zzcb.zzc(v);
            this.zza.zze.zzc(zzge1);
        }
        else {
            this.zzd(bundle0, billingResult1, v);
        }
        this.zza.zzb.onPurchasesUpdated(billingResult1, list0);
    }

    public final void zza(Context context0, IntentFilter intentFilter0) {
        synchronized(this) {
            if(this.zzb) {
                return;
            }
            if(Build.VERSION.SDK_INT >= 33) {
                context0.registerReceiver(this, intentFilter0, (this.zzc ? 2 : 4));
            }
            else {
                context0.registerReceiver(this, intentFilter0);
            }
            this.zzb = true;
        }
    }

    public final void zzb(Context context0, IntentFilter intentFilter0, String s) {
        synchronized(this) {
            if(!this.zzb) {
                if(Build.VERSION.SDK_INT >= 33) {
                    context0.registerReceiver(this, intentFilter0, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, (this.zzc ? 2 : 4));
                }
                else {
                    context0.registerReceiver(this, intentFilter0, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                this.zzb = true;
            }
        }
    }

    public final void zzc(Context context0) {
        synchronized(this) {
            if(this.zzb) {
                context0.unregisterReceiver(this);
                this.zzb = false;
                return;
            }
            zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
        }
    }

    private final void zzd(Bundle bundle0, BillingResult billingResult0, int v) {
        if(bundle0.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                zzga zzga0 = zzga.zzA(bundle0.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzcd.zza());
                zzo.zzb(this.zza).zza(zzga0);
            }
            catch(Throwable unused_ex) {
                zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
            }
            return;
        }
        zzga zzga1 = zzcb.zza(23, v, billingResult0);
        zzo.zzb(this.zza).zza(zzga1);
    }
}

