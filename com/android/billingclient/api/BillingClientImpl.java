package com.android.billingclient.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.internal.play_billing.zzaa;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzgz;
import com.google.android.gms.internal.play_billing.zzhb;
import com.google.android.gms.internal.play_billing.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k8.Y;
import org.json.JSONException;
import va.e;

class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private ExecutorService zzB;
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzo zzd;
    private Context zze;
    private zzcc zzf;
    private volatile zzs zzg;
    private volatile zzbc zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private PendingPurchasesParams zzz;

    private BillingClientImpl(Activity activity0, PendingPurchasesParams pendingPurchasesParams0, String s) {
        this(activity0.getApplicationContext(), pendingPurchasesParams0, new zzbu(), s, null, null, null, null);
    }

    private BillingClientImpl(Context context0, PendingPurchasesParams pendingPurchasesParams0, PurchasesUpdatedListener purchasesUpdatedListener0, String s, String s1, UserChoiceBillingListener userChoiceBillingListener0, zzcc zzcc0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = s;
        this.initialize(context0, purchasesUpdatedListener0, pendingPurchasesParams0, userChoiceBillingListener0, s, null);
    }

    private BillingClientImpl(String s) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = s;
    }

    public BillingClientImpl(String s, Context context0, zzcc zzcc0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = "7.0.0";
        this.zze = context0.getApplicationContext();
        zzgt zzgt0 = zzgu.zzy();
        zzgt0.zzn("7.0.0");
        zzgt0.zzm("com.iloen.melon");
        this.zzf = new zzch(this.zze, ((zzgu)zzgt0.zzd()));
        this.zze.getPackageName();
    }

    public BillingClientImpl(String s, PendingPurchasesParams pendingPurchasesParams0, Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, UserChoiceBillingListener userChoiceBillingListener0, zzcc zzcc0, ExecutorService executorService0) {
        this(context0, pendingPurchasesParams0, purchasesUpdatedListener0, "7.0.0", null, userChoiceBillingListener0, null, null);
    }

    public BillingClientImpl(String s, PendingPurchasesParams pendingPurchasesParams0, Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, zzc zzc0, zzcc zzcc0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = "7.0.0";
        this.initialize(context0, purchasesUpdatedListener0, pendingPurchasesParams0, null, "7.0.0", null);
    }

    public BillingClientImpl(String s, PendingPurchasesParams pendingPurchasesParams0, Context context0, zzck zzck0, zzcc zzcc0, ExecutorService executorService0) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = "7.0.0";
        this.zze = context0.getApplicationContext();
        zzgt zzgt0 = zzgu.zzy();
        zzgt0.zzn("7.0.0");
        zzgt0.zzm("com.iloen.melon");
        this.zzf = new zzch(this.zze, ((zzgu)zzgt0.zzd()));
        zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzo(this.zze, null, null, null, null, this.zzf);
        this.zzz = pendingPurchasesParams0;
        this.zze.getPackageName();
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams0, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 3, zzce.zzm));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzce.zzm);
            return;
        }
        if(TextUtils.isEmpty(acknowledgePurchaseParams0.getPurchaseToken())) {
            zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            this.zzap(zzcb.zza(26, 3, zzce.zzi));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzce.zzi);
            return;
        }
        if(!this.zzn) {
            this.zzap(zzcb.zza(27, 3, zzce.zzb));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzce.zzb);
            return;
        }
        if(this.zzao(new zzu(this, acknowledgePurchaseParams0, acknowledgePurchaseResponseListener0), 30000L, new zzv(this, acknowledgePurchaseResponseListener0), this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 3, billingResult0));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(billingResult0);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void consumeAsync(ConsumeParams consumeParams0, ConsumeResponseListener consumeResponseListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 4, zzce.zzm));
            consumeResponseListener0.onConsumeResponse(zzce.zzm, consumeParams0.getPurchaseToken());
            return;
        }
        if(this.zzao(new zzah(this, consumeParams0, consumeResponseListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 4, zzce.zzn));
            consumeResponseListener0.onConsumeResponse(zzce.zzn, consumeParams0.getPurchaseToken());
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 4, billingResult0));
            consumeResponseListener0.onConsumeResponse(billingResult0, consumeParams0.getPurchaseToken());
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzg
    public void createAlternativeBillingOnlyReportingDetailsAsync(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 15, zzce.zzm));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzce.zzm, null);
            return;
        }
        if(!this.zzx) {
            zzb.zzk("BillingClient", "Current client doesn\'t support alternative billing only.");
            this.zzap(zzcb.zza(66, 15, zzce.zzE));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzce.zzE, null);
            return;
        }
        if(this.zzao(new zzz(this, alternativeBillingOnlyReportingDetailsListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 15, zzce.zzn));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzce.zzn, null);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 15, billingResult0));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzh
    public void createExternalOfferReportingDetailsAsync(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 24, zzce.zzm));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzce.zzm, null);
            return;
        }
        if(!this.zzy) {
            zzb.zzk("BillingClient", "Current client doesn\'t support external offer.");
            this.zzap(zzcb.zza(103, 24, zzce.zzy));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzce.zzy, null);
            return;
        }
        if(this.zzao(new zzab(this, externalOfferReportingDetailsListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 24, zzce.zzn));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzce.zzn, null);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 24, billingResult0));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        this.zzaq(zzcb.zzc(12));
        try {
            if(this.zzd != null) {
                this.zzd.zzf();
            }
            if(this.zzh != null) {
                this.zzh.zzc();
            }
            if(this.zzh != null && this.zzg != null) {
                zzb.zzj("BillingClient", "Unbinding from service.");
                this.zze.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            ExecutorService executorService0 = this.zzB;
            if(executorService0 != null) {
                executorService0.shutdownNow();
                this.zzB = null;
            }
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "There was an exception while ending connection!", exception0);
        }
        finally {
            this.zza = 3;
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzi
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams0, BillingConfigResponseListener billingConfigResponseListener0) {
        if(!this.isReady()) {
            zzb.zzk("BillingClient", "Service disconnected.");
            this.zzap(zzcb.zza(2, 13, zzce.zzm));
            billingConfigResponseListener0.onBillingConfigResponse(zzce.zzm, null);
            return;
        }
        if(!this.zzu) {
            zzb.zzk("BillingClient", "Current client doesn\'t support get billing config.");
            this.zzap(zzcb.zza(0x20, 13, zzce.zzA));
            billingConfigResponseListener0.onBillingConfigResponse(zzce.zzA, null);
            return;
        }
        if(this.zzao(new zzw(this, Y.b("playBillingLibraryVersion", this.zzb), billingConfigResponseListener0), 30000L, new zzx(this, billingConfigResponseListener0), this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 13, billingResult0));
            billingConfigResponseListener0.onBillingConfigResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    private void initialize(Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, PendingPurchasesParams pendingPurchasesParams0, UserChoiceBillingListener userChoiceBillingListener0, String s, zzcc zzcc0) {
        this.zze = context0.getApplicationContext();
        zzgt zzgt0 = zzgu.zzy();
        zzgt0.zzn(s);
        zzgt0.zzm("com.iloen.melon");
        this.zzf = zzcc0 == null ? new zzch(this.zze, ((zzgu)zzgt0.zzd())) : zzcc0;
        if(purchasesUpdatedListener0 == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzo(this.zze, purchasesUpdatedListener0, null, null, userChoiceBillingListener0, this.zzf);
        this.zzz = pendingPurchasesParams0;
        this.zzA = userChoiceBillingListener0 != null;
    }

    private void initialize(Context context0, PurchasesUpdatedListener purchasesUpdatedListener0, PendingPurchasesParams pendingPurchasesParams0, zzc zzc0, String s, zzcc zzcc0) {
        this.zze = context0.getApplicationContext();
        zzgt zzgt0 = zzgu.zzy();
        zzgt0.zzn(s);
        zzgt0.zzm("com.iloen.melon");
        this.zzf = zzcc0 == null ? new zzch(this.zze, ((zzgu)zzgt0.zzd())) : zzcc0;
        if(purchasesUpdatedListener0 == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzo(this.zze, purchasesUpdatedListener0, null, zzc0, null, this.zzf);
        this.zzz = pendingPurchasesParams0;
        this.zzA = zzc0 != null;
        this.zze.getPackageName();
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzg
    public void isAlternativeBillingOnlyAvailableAsync(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 14, zzce.zzm));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzm);
            return;
        }
        if(!this.zzx) {
            zzb.zzk("BillingClient", "Current client doesn\'t support alternative billing only.");
            this.zzap(zzcb.zza(66, 14, zzce.zzE));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzE);
            return;
        }
        if(this.zzao(new zzaf(this, alternativeBillingOnlyAvailabilityListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 14, zzce.zzn));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzn);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 14, billingResult0));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(billingResult0);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzh
    public void isExternalOfferAvailableAsync(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 23, zzce.zzm));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzce.zzm);
            return;
        }
        if(!this.zzy) {
            zzb.zzk("BillingClient", "Current client doesn\'t support external offer.");
            this.zzap(zzcb.zza(103, 23, zzce.zzy));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzce.zzy);
            return;
        }
        if(this.zzao(new zzaq(this, externalOfferAvailabilityListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 23, zzce.zzn));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzce.zzn);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 23, billingResult0));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(billingResult0);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String s) {
        if(!this.isReady()) {
            BillingResult billingResult0 = zzce.zzm;
            if(billingResult0.getResponseCode() != 0) {
                this.zzap(zzcb.zza(2, 5, billingResult0));
                return billingResult0;
            }
            this.zzaq(zzcb.zzc(5));
            return billingResult0;
        }
        switch(s) {
            case "aaa": {
                BillingResult billingResult2 = this.zzr ? zzce.zzl : zzce.zzs;
                this.zzau(billingResult2, 0x1F, 6);
                return billingResult2;
            }
            case "bbb": {
                BillingResult billingResult3 = this.zzp ? zzce.zzl : zzce.zzw;
                this.zzau(billingResult3, 30, 5);
                return billingResult3;
            }
            case "ccc": {
                BillingResult billingResult4 = this.zzs ? zzce.zzl : zzce.zzt;
                this.zzau(billingResult4, 19, 8);
                return billingResult4;
            }
            case "ddd": {
                BillingResult billingResult5 = this.zzq ? zzce.zzl : zzce.zzu;
                this.zzau(billingResult5, 21, 7);
                return billingResult5;
            }
            case "eee": {
                BillingResult billingResult6 = this.zzs ? zzce.zzl : zzce.zzt;
                this.zzau(billingResult6, 61, 9);
                return billingResult6;
            }
            case "fff": {
                BillingResult billingResult7 = this.zzt ? zzce.zzl : zzce.zzv;
                this.zzau(billingResult7, 20, 10);
                return billingResult7;
            }
            case "ggg": {
                BillingResult billingResult8 = this.zzu ? zzce.zzl : zzce.zzA;
                this.zzau(billingResult8, 0x20, 11);
                return billingResult8;
            }
            case "hhh": {
                BillingResult billingResult9 = this.zzu ? zzce.zzl : zzce.zzB;
                this.zzau(billingResult9, 33, 12);
                return billingResult9;
            }
            case "iii": {
                BillingResult billingResult10 = this.zzw ? zzce.zzl : zzce.zzD;
                this.zzau(billingResult10, 60, 13);
                return billingResult10;
            }
            case "jjj": {
                BillingResult billingResult11 = this.zzx ? zzce.zzl : zzce.zzE;
                this.zzau(billingResult11, 66, 14);
                return billingResult11;
            }
            case "kkk": {
                BillingResult billingResult12 = this.zzy ? zzce.zzl : zzce.zzy;
                this.zzau(billingResult12, 103, 18);
                return billingResult12;
            }
            case "priceChangeConfirmation": {
                BillingResult billingResult13 = this.zzm ? zzce.zzl : zzce.zzr;
                this.zzau(billingResult13, 35, 4);
                return billingResult13;
            }
            case "subscriptions": {
                BillingResult billingResult14 = this.zzi ? zzce.zzl : zzce.zzo;
                this.zzau(billingResult14, 9, 2);
                return billingResult14;
            }
            case "subscriptionsUpdate": {
                BillingResult billingResult1 = this.zzj ? zzce.zzl : zzce.zzp;
                this.zzau(billingResult1, 10, 3);
                return billingResult1;
            }
            default: {
                zzb.zzk("BillingClient", "Unsupported feature: " + s);
                this.zzau(zzce.zzz, 34, 1);
                return zzce.zzz;
            }
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return this.zza == 2 && this.zzg != null && this.zzh != null;
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(Activity activity0, BillingFlowParams billingFlowParams0) {
        int v9;
        Future future0;
        int v8;
        int v7;
        boolean z5;
        String s3;
        String s2;
        ProductDetailsParams billingFlowParams$ProductDetailsParams1;
        String s1;
        String s;
        if(this.zzd != null && this.zzd.zzd() != null) {
            if(!this.isReady()) {
                this.zzap(zzcb.zza(2, 2, zzce.zzm));
                this.zzak(zzce.zzm);
                return zzce.zzm;
            }
            ArrayList arrayList0 = billingFlowParams0.zzf();
            List list0 = billingFlowParams0.zzg();
            SkuDetails skuDetails0 = (SkuDetails)zzan.zza(arrayList0, null);
            ProductDetailsParams billingFlowParams$ProductDetailsParams0 = (ProductDetailsParams)zzan.zza(list0, null);
            if(skuDetails0 == null) {
                s = billingFlowParams$ProductDetailsParams0.zza().getProductId();
                s1 = billingFlowParams$ProductDetailsParams0.zza().getProductType();
            }
            else {
                s = skuDetails0.getSku();
                s1 = skuDetails0.getType();
            }
            if(s1.equals("subs") && !this.zzi) {
                zzb.zzk("BillingClient", "Current client doesn\'t support subscriptions.");
                this.zzap(zzcb.zza(9, 2, zzce.zzo));
                this.zzak(zzce.zzo);
                return zzce.zzo;
            }
            if(billingFlowParams0.zzp() && !this.zzl) {
                zzb.zzk("BillingClient", "Current client doesn\'t support extra params for buy intent.");
                this.zzap(zzcb.zza(18, 2, zzce.zzh));
                this.zzak(zzce.zzh);
                return zzce.zzh;
            }
            if(arrayList0.size() > 1 && !this.zzs) {
                zzb.zzk("BillingClient", "Current client doesn\'t support multi-item purchases.");
                this.zzap(zzcb.zza(19, 2, zzce.zzt));
                this.zzak(zzce.zzt);
                return zzce.zzt;
            }
            if(!list0.isEmpty() && !this.zzt) {
                zzb.zzk("BillingClient", "Current client doesn\'t support purchases with ProductDetails.");
                this.zzap(zzcb.zza(20, 2, zzce.zzv));
                this.zzak(zzce.zzv);
                return zzce.zzv;
            }
            if(this.zzl) {
                boolean z = this.zzn;
                boolean z1 = this.zzv;
                boolean z2 = this.zzz.isEnabledForOneTimeProducts();
                boolean z3 = this.zzz.isEnabledForPrepaidPlans();
                boolean z4 = this.zzA;
                Bundle bundle0 = Y.b("playBillingLibraryVersion", this.zzb);
                if(billingFlowParams0.zza() == 0) {
                    billingFlowParams$ProductDetailsParams1 = billingFlowParams$ProductDetailsParams0;
                }
                else {
                    billingFlowParams$ProductDetailsParams1 = billingFlowParams$ProductDetailsParams0;
                    bundle0.putInt("prorationMode", billingFlowParams0.zza());
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zzb())) {
                    bundle0.putString("accountId", billingFlowParams0.zzb());
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zzc())) {
                    bundle0.putString("obfuscatedProfileId", billingFlowParams0.zzc());
                }
                if(billingFlowParams0.zzo()) {
                    bundle0.putBoolean("isOfferPersonalizedByDeveloper", true);
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[]{0})));
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zzd())) {
                    bundle0.putString("oldSkuPurchaseToken", billingFlowParams0.zzd());
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("oldSkuPurchaseId", null);
                }
                if(!TextUtils.isEmpty(billingFlowParams0.zze())) {
                    bundle0.putString("originalExternalTransactionId", billingFlowParams0.zze());
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("paymentsPurchaseParams", null);
                }
                if(z && z2) {
                    bundle0.putBoolean("enablePendingPurchases", true);
                }
                if(z1 && z3) {
                    bundle0.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                if(z4) {
                    bundle0.putBoolean("enableAlternativeBilling", true);
                }
                if(arrayList0.isEmpty()) {
                    s2 = s;
                    s3 = s1;
                    ArrayList arrayList8 = new ArrayList(list0.size() - 1);
                    ArrayList arrayList9 = new ArrayList(list0.size() - 1);
                    ArrayList arrayList10 = new ArrayList();
                    ArrayList arrayList11 = new ArrayList();
                    ArrayList arrayList12 = new ArrayList();
                    for(int v6 = 0; v6 < list0.size(); ++v6) {
                        ProductDetailsParams billingFlowParams$ProductDetailsParams2 = (ProductDetailsParams)list0.get(v6);
                        ProductDetails productDetails0 = billingFlowParams$ProductDetailsParams2.zza();
                        if(!productDetails0.zzb().isEmpty()) {
                            arrayList10.add(productDetails0.zzb());
                        }
                        arrayList11.add(billingFlowParams$ProductDetailsParams2.zzb());
                        if(!TextUtils.isEmpty(productDetails0.zzc())) {
                            arrayList12.add(productDetails0.zzc());
                        }
                        if(v6 > 0) {
                            arrayList8.add(((ProductDetailsParams)list0.get(v6)).zza().getProductId());
                            arrayList9.add(((ProductDetailsParams)list0.get(v6)).zza().getProductType());
                        }
                    }
                    bundle0.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList11);
                    if(!arrayList10.isEmpty()) {
                        bundle0.putStringArrayList("skuDetailsTokens", arrayList10);
                    }
                    if(!arrayList12.isEmpty()) {
                        bundle0.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList12);
                    }
                    if(!arrayList8.isEmpty()) {
                        bundle0.putStringArrayList("additionalSkus", arrayList8);
                        bundle0.putStringArrayList("additionalSkuTypes", arrayList9);
                    }
                }
                else {
                    ArrayList arrayList1 = new ArrayList();
                    s2 = s;
                    ArrayList arrayList2 = new ArrayList();
                    s3 = s1;
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    int v = 0;
                    int v1 = 0;
                    int v2 = 0;
                    int v3 = 0;
                    for(Object object0: arrayList0) {
                        SkuDetails skuDetails1 = (SkuDetails)object0;
                        if(!skuDetails1.zzf().isEmpty()) {
                            arrayList1.add(skuDetails1.zzf());
                        }
                        String s4 = skuDetails1.zzc();
                        String s5 = skuDetails1.zzb();
                        int v4 = skuDetails1.zza();
                        String s6 = skuDetails1.zze();
                        arrayList2.add(s4);
                        v |= !TextUtils.isEmpty(s4);
                        arrayList3.add(s5);
                        v1 |= !TextUtils.isEmpty(s5);
                        arrayList4.add(v4);
                        v2 |= (v4 == 0 ? 0 : 1);
                        v3 |= !TextUtils.isEmpty(s6);
                        arrayList5.add(s6);
                    }
                    if(!arrayList1.isEmpty()) {
                        bundle0.putStringArrayList("skuDetailsTokens", arrayList1);
                    }
                    if(v != 0) {
                        bundle0.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
                    }
                    if(v1 != 0) {
                        bundle0.putStringArrayList("SKU_OFFER_ID_LIST", arrayList3);
                    }
                    if(v2 != 0) {
                        bundle0.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList4);
                    }
                    if(v3 != 0) {
                        bundle0.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                    }
                    if(arrayList0.size() > 1) {
                        ArrayList arrayList6 = new ArrayList(arrayList0.size() - 1);
                        ArrayList arrayList7 = new ArrayList(arrayList0.size() - 1);
                        for(int v5 = 1; v5 < arrayList0.size(); ++v5) {
                            arrayList6.add(((SkuDetails)arrayList0.get(v5)).getSku());
                            arrayList7.add(((SkuDetails)arrayList0.get(v5)).getType());
                        }
                        bundle0.putStringArrayList("additionalSkus", arrayList6);
                        bundle0.putStringArrayList("additionalSkuTypes", arrayList7);
                    }
                }
                if(bundle0.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzq) {
                    this.zzap(zzcb.zza(21, 2, zzce.zzu));
                    this.zzak(zzce.zzu);
                    return zzce.zzu;
                }
                if(skuDetails0 != null && !TextUtils.isEmpty(skuDetails0.zzd())) {
                    bundle0.putString("skuPackageName", skuDetails0.zzd());
                    z5 = true;
                }
                else if(billingFlowParams$ProductDetailsParams1 == null || TextUtils.isEmpty(billingFlowParams$ProductDetailsParams1.zza().zza())) {
                    z5 = false;
                }
                else {
                    bundle0.putString("skuPackageName", billingFlowParams$ProductDetailsParams1.zza().zza());
                    z5 = true;
                }
                if(!TextUtils.isEmpty(null)) {
                    bundle0.putString("accountName", null);
                }
                Intent intent0 = activity0.getIntent();
                if(intent0 == null) {
                    zzb.zzk("BillingClient", "Activity\'s intent is null.");
                }
                else if(!TextUtils.isEmpty(intent0.getStringExtra("PROXY_PACKAGE"))) {
                    String s7 = intent0.getStringExtra("PROXY_PACKAGE");
                    bundle0.putString("proxyPackage", s7);
                    try {
                        bundle0.putString("proxyPackageVersion", this.zze.getPackageManager().getPackageInfo(s7, 0).versionName);
                    }
                    catch(PackageManager.NameNotFoundException unused_ex) {
                        bundle0.putString("proxyPackageVersion", "package not found");
                    }
                }
                if(this.zzt && !list0.isEmpty()) {
                    v7 = 17;
                    goto label_181;
                }
                else if(!this.zzr || !z5) {
                    v8 = this.zzn ? 9 : 6;
                }
                else {
                    v7 = 15;
                label_181:
                    v8 = v7;
                }
                future0 = this.zzao(() -> this.zzg.zzg(v8, "com.iloen.melon", s2, s3, null, bundle0), 5000L, null, this.zzc);
                v9 = 78;
            }
            else {
                future0 = this.zzao(new zzr(this, s, s1), 5000L, null, this.zzc);
                v9 = 80;
            }
            try {
                if(future0 == null) {
                    this.zzap(zzcb.zza(25, 2, zzce.zzm));
                    this.zzak(zzce.zzm);
                    return zzce.zzm;
                }
                Bundle bundle1 = (Bundle)future0.get(5000L, TimeUnit.MILLISECONDS);
                int v10 = zzb.zzb(bundle1, "BillingClient");
                String s8 = zzb.zzg(bundle1, "BillingClient");
                if(v10 != 0) {
                    zzb.zzk("BillingClient", "Unable to buy item, Error response code: " + v10);
                    BillingResult billingResult0 = zzce.zza(v10, s8);
                    if(bundle1 != null) {
                        v9 = 23;
                    }
                    this.zzap(zzcb.zza(v9, 2, billingResult0));
                    this.zzak(billingResult0);
                    return billingResult0;
                }
                Intent intent1 = new Intent(activity0, ProxyBillingActivity.class);
                intent1.putExtra("BUY_INTENT", ((PendingIntent)bundle1.getParcelable("BUY_INTENT")));
                activity0.startActivity(intent1);
                return zzce.zzl;
            }
            catch(TimeoutException | CancellationException timeoutException0) {
            }
            catch(Exception exception0) {
                zzb.zzl("BillingClient", "Exception while launching billing flow. Try to reconnect", exception0);
                this.zzap(zzcb.zza(5, 2, zzce.zzm));
                this.zzak(zzce.zzm);
                return zzce.zzm;
            }
            zzb.zzl("BillingClient", "Time out while launching billing flow. Try to reconnect", timeoutException0);
            this.zzap(zzcb.zza(4, 2, zzce.zzn));
            this.zzak(zzce.zzn);
            return zzce.zzn;
        }
        this.zzap(zzcb.zza(12, 2, zzce.zzF));
        return zzce.zzF;
    }

    private int launchBillingFlowCpp(Activity activity0, BillingFlowParams billingFlowParams0) {
        return this.launchBillingFlow(activity0, billingFlowParams0).getResponseCode();
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams0, ProductDetailsResponseListener productDetailsResponseListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 7, zzce.zzm));
            ArrayList arrayList0 = new ArrayList();
            productDetailsResponseListener0.onProductDetailsResponse(zzce.zzm, arrayList0);
            return;
        }
        if(!this.zzt) {
            zzb.zzk("BillingClient", "Querying product details is not supported.");
            this.zzap(zzcb.zza(20, 7, zzce.zzv));
            ArrayList arrayList1 = new ArrayList();
            productDetailsResponseListener0.onProductDetailsResponse(zzce.zzv, arrayList1);
            return;
        }
        if(this.zzao(new com.android.billingclient.api.zzan(this, queryProductDetailsParams0, productDetailsResponseListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 7, zzce.zzn));
            ArrayList arrayList0 = new ArrayList();
            productDetailsResponseListener0.onProductDetailsResponse(zzce.zzn, arrayList0);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 7, billingResult0));
            productDetailsResponseListener0.onProductDetailsResponse(billingResult0, new ArrayList());
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams0, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zzar(queryPurchaseHistoryParams0.zza(), purchaseHistoryResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String s, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        this.zzar(s, purchaseHistoryResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams0, PurchasesResponseListener purchasesResponseListener0) {
        this.zzas(queryPurchasesParams0.zza(), purchasesResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String s, PurchasesResponseListener purchasesResponseListener0) {
        this.zzas(s, purchasesResponseListener0);
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams0, SkuDetailsResponseListener skuDetailsResponseListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 8, zzce.zzm));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzce.zzm, null);
            return;
        }
        String s = skuDetailsParams0.getSkuType();
        List list0 = skuDetailsParams0.getSkusList();
        if(TextUtils.isEmpty(s)) {
            zzb.zzk("BillingClient", "Please fix the input params. SKU type can\'t be empty.");
            this.zzap(zzcb.zza(49, 8, zzce.zzf));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzce.zzf, null);
            return;
        }
        if(list0 == null) {
            zzb.zzk("BillingClient", "Please fix the input params. The list of SKUs can\'t be empty.");
            this.zzap(zzcb.zza(0x30, 8, zzce.zze));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzce.zze, null);
            return;
        }
        if(this.zzao(new zzac(this, s, list0, null, skuDetailsResponseListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 8, zzce.zzn));
            skuDetailsResponseListener0.onSkuDetailsResponse(zzce.zzn, null);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 8, billingResult0));
            skuDetailsResponseListener0.onSkuDetailsResponse(billingResult0, null);
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzg
    public BillingResult showAlternativeBillingOnlyInformationDialog(Activity activity0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        if(activity0 == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 16, zzce.zzm));
            return zzce.zzm;
        }
        if(!this.zzx) {
            zzb.zzk("BillingClient", "Current Play Store version doesn\'t support alternative billing only.");
            this.zzap(zzcb.zza(66, 16, zzce.zzE));
            return zzce.zzE;
        }
        if(this.zzao(new com.android.billingclient.api.zzs(this, activity0, new zzax(this, this.zzc, alternativeBillingOnlyInformationDialogListener0), alternativeBillingOnlyInformationDialogListener0), 30000L, new zzt(this, alternativeBillingOnlyInformationDialogListener0), this.zzc) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 16, billingResult0));
            return billingResult0;
        }
        return zzce.zzl;
    }

    @Override  // com.android.billingclient.api.BillingClient
    @zzh
    public BillingResult showExternalOfferInformationDialog(Activity activity0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        if(activity0 == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 25, zzce.zzm));
            return zzce.zzm;
        }
        if(!this.zzy) {
            zzb.zzk("BillingClient", "Current Play Store version doesn\'t support external offer.");
            this.zzap(zzcb.zza(103, 25, zzce.zzy));
            return zzce.zzy;
        }
        if(this.zzao(new zzaj(this, activity0, new zzay(this, this.zzc, externalOfferInformationDialogListener0), externalOfferInformationDialogListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 25, zzce.zzn));
            externalOfferInformationDialogListener0.onExternalOfferInformationDialogResponse(zzce.zzn);
        }, this.zzc) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 25, billingResult0));
            return billingResult0;
        }
        return zzce.zzl;
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(Activity activity0, InAppMessageParams inAppMessageParams0, InAppMessageResponseListener inAppMessageResponseListener0) {
        if(!this.isReady()) {
            zzb.zzk("BillingClient", "Service disconnected.");
            return zzce.zzm;
        }
        if(!this.zzp) {
            zzb.zzk("BillingClient", "Current client doesn\'t support showing in-app messages.");
            return zzce.zzw;
        }
        View view0 = activity0.findViewById(0x1020002);
        IBinder iBinder0 = view0.getWindowToken();
        Rect rect0 = new Rect();
        view0.getGlobalVisibleRect(rect0);
        Bundle bundle0 = new Bundle();
        bundle0.putBinder("KEY_WINDOW_TOKEN", iBinder0);
        bundle0.putInt("KEY_DIMEN_LEFT", rect0.left);
        bundle0.putInt("KEY_DIMEN_TOP", rect0.top);
        bundle0.putInt("KEY_DIMEN_RIGHT", rect0.right);
        bundle0.putInt("KEY_DIMEN_BOTTOM", rect0.bottom);
        bundle0.putString("playBillingLibraryVersion", this.zzb);
        bundle0.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams0.zza());
        this.zzao(new zzap(this, bundle0, activity0, new zzaw(this, this.zzc, inAppMessageResponseListener0)), 5000L, null, this.zzc);
        return zzce.zzl;
    }

    private void startConnection(long v) {
        int v1 = 1;
        zzbu zzbu0 = new zzbu(v);
        if(this.isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzaq(zzcb.zzc(6));
            zzbu0.onBillingSetupFinished(zzce.zzl);
            return;
        }
        switch(this.zza) {
            case 1: {
                zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
                this.zzap(zzcb.zza(37, 6, zzce.zzd));
                zzbu0.onBillingSetupFinished(zzce.zzd);
                return;
            }
            case 3: {
                zzb.zzk("BillingClient", "Client was already closed and can\'t be reused. Please create another instance.");
                this.zzap(zzcb.zza(38, 6, zzce.zzm));
                zzbu0.onBillingSetupFinished(zzce.zzm);
                return;
            }
            default: {
                this.zza = 1;
                zzb.zzj("BillingClient", "Starting in-app billing setup.");
                this.zzh = new zzbc(this, zzbu0, null);
                Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent0.setPackage("com.android.vending");
                List list0 = this.zze.getPackageManager().queryIntentServices(intent0, 0);
                if(list0 == null || list0.isEmpty()) {
                    v1 = 41;
                }
                else {
                    ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                    if(serviceInfo0 != null) {
                        String s = serviceInfo0.packageName;
                        String s1 = serviceInfo0.name;
                        if(!"com.android.vending".equals(s) || s1 == null) {
                            zzb.zzk("BillingClient", "The device doesn\'t have valid Play Store.");
                            v1 = 40;
                        }
                        else {
                            ComponentName componentName0 = new ComponentName(s, s1);
                            Intent intent1 = new Intent(intent0);
                            intent1.setComponent(componentName0);
                            intent1.putExtra("playBillingLibraryVersion", this.zzb);
                            if(this.zze.bindService(intent1, this.zzh, 1)) {
                                zzb.zzj("BillingClient", "Service was bonded successfully.");
                                return;
                            }
                            zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                            v1 = 39;
                        }
                    }
                }
                this.zza = 0;
                zzb.zzj("BillingClient", "Billing service unavailable on device.");
                this.zzap(zzcb.zza(v1, 6, zzce.zzc));
                zzbu0.onBillingSetupFinished(zzce.zzc);
            }
        }
    }

    @Override  // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener0) {
        int v = 1;
        if(this.isReady()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzaq(zzcb.zzc(6));
            billingClientStateListener0.onBillingSetupFinished(zzce.zzl);
            return;
        }
        switch(this.zza) {
            case 1: {
                zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
                this.zzap(zzcb.zza(37, 6, zzce.zzd));
                billingClientStateListener0.onBillingSetupFinished(zzce.zzd);
                return;
            }
            case 3: {
                zzb.zzk("BillingClient", "Client was already closed and can\'t be reused. Please create another instance.");
                this.zzap(zzcb.zza(38, 6, zzce.zzm));
                billingClientStateListener0.onBillingSetupFinished(zzce.zzm);
                return;
            }
            default: {
                this.zza = 1;
                zzb.zzj("BillingClient", "Starting in-app billing setup.");
                this.zzh = new zzbc(this, billingClientStateListener0, null);
                Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent0.setPackage("com.android.vending");
                List list0 = this.zze.getPackageManager().queryIntentServices(intent0, 0);
                if(list0 == null || list0.isEmpty()) {
                    v = 41;
                }
                else {
                    ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                    if(serviceInfo0 != null) {
                        String s = serviceInfo0.packageName;
                        String s1 = serviceInfo0.name;
                        if(!"com.android.vending".equals(s) || s1 == null) {
                            zzb.zzk("BillingClient", "The device doesn\'t have valid Play Store.");
                            v = 40;
                        }
                        else {
                            ComponentName componentName0 = new ComponentName(s, s1);
                            Intent intent1 = new Intent(intent0);
                            intent1.setComponent(componentName0);
                            intent1.putExtra("playBillingLibraryVersion", this.zzb);
                            if(this.zze.bindService(intent1, this.zzh, 1)) {
                                zzb.zzj("BillingClient", "Service was bonded successfully.");
                                return;
                            }
                            zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                            v = 39;
                        }
                    }
                }
                this.zza = 0;
                zzb.zzj("BillingClient", "Billing service unavailable on device.");
                this.zzap(zzcb.zza(v, 6, zzce.zzc));
                billingClientStateListener0.onBillingSetupFinished(zzce.zzc);
            }
        }
    }

    public final void zzR(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) {
        this.zzap(zzcb.zza(24, 3, zzce.zzn));
        acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzce.zzn);
    }

    public final void zzS(BillingResult billingResult0) {
        if(this.zzd.zzd() != null) {
            this.zzd.zzd().onPurchasesUpdated(billingResult0, null);
            return;
        }
        zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
    }

    // 检测为 Lambda 实现
    public final void zzT(ConsumeResponseListener consumeResponseListener0, ConsumeParams consumeParams0) [...]

    // 检测为 Lambda 实现
    public final void zzU(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) [...]

    // 检测为 Lambda 实现
    public final void zzV(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) [...]

    public final void zzW(BillingConfigResponseListener billingConfigResponseListener0) {
        this.zzap(zzcb.zza(24, 13, zzce.zzn));
        billingConfigResponseListener0.onBillingConfigResponse(zzce.zzn, null);
    }

    // 检测为 Lambda 实现
    public final void zzX(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) [...]

    // 检测为 Lambda 实现
    public final void zzY(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) [...]

    // 检测为 Lambda 实现
    public final void zzZ(ProductDetailsResponseListener productDetailsResponseListener0) [...]

    // 检测为 Lambda 实现
    public final void zzaa(PurchaseHistoryResponseListener purchaseHistoryResponseListener0) [...]

    // 检测为 Lambda 实现
    public final void zzab(PurchasesResponseListener purchasesResponseListener0) [...]

    // 检测为 Lambda 实现
    public final void zzac(SkuDetailsResponseListener skuDetailsResponseListener0) [...]

    public final void zzad(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        this.zzap(zzcb.zza(24, 16, zzce.zzn));
        alternativeBillingOnlyInformationDialogListener0.onAlternativeBillingOnlyInformationDialogResponse(zzce.zzn);
    }

    // 检测为 Lambda 实现
    public final void zzae(ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) [...]

    public static zzcz zzag(BillingClientImpl billingClientImpl0, String s, int v) {
        Purchase purchase0;
        Bundle bundle1;
        zzb.zzj("BillingClient", "Querying owned items, item type: " + s);
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = zzb.zzc(billingClientImpl0.zzn, billingClientImpl0.zzv, billingClientImpl0.zzz.isEnabledForOneTimeProducts(), billingClientImpl0.zzz.isEnabledForPrepaidPlans(), billingClientImpl0.zzb);
        String s1 = null;
        do {
            try {
                bundle1 = billingClientImpl0.zzn ? billingClientImpl0.zzg.zzj((billingClientImpl0.zzv ? 19 : 9), "com.iloen.melon", s, s1, bundle0) : billingClientImpl0.zzg.zzi(3, "com.iloen.melon", s, s1);
            }
            catch(Exception exception0) {
                billingClientImpl0.zzap(zzcb.zza(52, 9, zzce.zzm));
                zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", exception0);
                return new zzcz(zzce.zzm, null);
            }
            zzda zzda0 = zzdb.zza(bundle1, "BillingClient", "getPurchase()");
            BillingResult billingResult0 = zzda0.zza();
            if(billingResult0 != zzce.zzl) {
                billingClientImpl0.zzap(zzcb.zza(zzda0.zzb(), 9, billingResult0));
                return new zzcz(billingResult0, null);
            }
            ArrayList arrayList1 = bundle1.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList2 = bundle1.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList3 = bundle1.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            boolean z = false;
            for(int v1 = 0; v1 < arrayList2.size(); ++v1) {
                String s2 = (String)arrayList2.get(v1);
                String s3 = (String)arrayList3.get(v1);
                zzb.zzj("BillingClient", "Sku is owned: " + ((String)arrayList1.get(v1)));
                try {
                    purchase0 = new Purchase(s2, s3);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", jSONException0);
                    billingClientImpl0.zzap(zzcb.zza(51, 9, zzce.zzj));
                    return new zzcz(zzce.zzj, null);
                }
                if(TextUtils.isEmpty(purchase0.getPurchaseToken())) {
                    zzb.zzk("BillingClient", "BUG: empty/null token!");
                    z = true;
                }
                arrayList0.add(purchase0);
            }
            if(z) {
                billingClientImpl0.zzap(zzcb.zza(26, 9, zzce.zzj));
            }
            s1 = bundle1.getString("INAPP_CONTINUATION_TOKEN");
            zzb.zzj("BillingClient", "Continuation token: " + s1);
        }
        while(!TextUtils.isEmpty(s1));
        return new zzcz(zzce.zzl, arrayList0);
    }

    public static void zzah(BillingClientImpl billingClientImpl0, int v, int v1, BillingResult billingResult0) {
        billingClientImpl0.zzap(zzcb.zza(v, v1, billingResult0));
    }

    public static void zzai(BillingClientImpl billingClientImpl0, int v) {
        billingClientImpl0.zzaq(zzcb.zzc(6));
    }

    private final Handler zzaj() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzak(BillingResult billingResult0) {
        if(Thread.interrupted()) {
            return billingResult0;
        }
        zzq zzq0 = new zzq(this, billingResult0);
        this.zzc.post(zzq0);
        return billingResult0;
    }

    private final BillingResult zzal() {
        return this.zza == 0 || this.zza == 3 ? zzce.zzm : zzce.zzj;
    }

    // 去混淆评级： 低(30)
    private final String zzam(QueryProductDetailsParams queryProductDetailsParams0) {
        return "com.iloen.melon";
    }

    @SuppressLint({"PrivateApi"})
    private static String zzan() [...] // 潜在的解密器

    private final Future zzao(Callable callable0, long v, Runnable runnable0, Handler handler0) {
        Future future0;
        if(this.zzB == null) {
            zzat zzat0 = new zzat(this);
            this.zzB = Executors.newFixedThreadPool(zzb.zza, zzat0);
        }
        try {
            future0 = this.zzB.submit(callable0);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "Async task throws exception!", exception0);
            return null;
        }
        handler0.postDelayed(new zzy(future0, runnable0), ((long)(((double)v) * 0.95)));
        return future0;
    }

    private final void zzap(zzga zzga0) {
        this.zzf.zzb(zzga0, this.zzk);
    }

    private final void zzaq(zzge zzge0) {
        this.zzf.zzd(zzge0, this.zzk);
    }

    private final void zzar(String s, PurchaseHistoryResponseListener purchaseHistoryResponseListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 11, zzce.zzm));
            purchaseHistoryResponseListener0.onPurchaseHistoryResponse(zzce.zzm, null);
            return;
        }
        if(this.zzao(new zzav(this, s, purchaseHistoryResponseListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 11, zzce.zzn));
            purchaseHistoryResponseListener0.onPurchaseHistoryResponse(zzce.zzn, null);
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 11, billingResult0));
            purchaseHistoryResponseListener0.onPurchaseHistoryResponse(billingResult0, null);
        }
    }

    private final void zzas(String s, PurchasesResponseListener purchasesResponseListener0) {
        if(!this.isReady()) {
            this.zzap(zzcb.zza(2, 9, zzce.zzm));
            purchasesResponseListener0.onQueryPurchasesResponse(zzce.zzm, zzai.zzk());
            return;
        }
        if(TextUtils.isEmpty(s)) {
            zzb.zzk("BillingClient", "Please provide a valid product type.");
            this.zzap(zzcb.zza(50, 9, zzce.zzg));
            purchasesResponseListener0.onQueryPurchasesResponse(zzce.zzg, zzai.zzk());
            return;
        }
        if(this.zzao(new zzau(this, s, purchasesResponseListener0), 30000L, () -> {
            this.zzap(zzcb.zza(24, 9, zzce.zzn));
            purchasesResponseListener0.onQueryPurchasesResponse(zzce.zzn, zzai.zzk());
        }, this.zzaj()) == null) {
            BillingResult billingResult0 = this.zzal();
            this.zzap(zzcb.zza(25, 9, billingResult0));
            purchasesResponseListener0.onQueryPurchasesResponse(billingResult0, zzai.zzk());
        }
    }

    // 去混淆评级： 低(20)
    private final boolean zzat() {
        return this.zzv && this.zzz.isEnabledForPrepaidPlans();
    }

    private final void zzau(BillingResult billingResult0, int v, int v1) {
        zzga zzga0 = null;
        if(billingResult0.getResponseCode() != 0) {
            try {
                zzfz zzfz0 = zzga.zzy();
                zzgg zzgg0 = zzgk.zzy();
                zzgg0.zzn(billingResult0.getResponseCode());
                zzgg0.zzm(billingResult0.getDebugMessage());
                zzgg0.zzo(v);
                zzfz0.zzl(zzgg0);
                zzfz0.zzn(5);
                zzgz zzgz0 = zzhb.zzy();
                zzgz0.zzl(v1);
                zzfz0.zzm(((zzhb)zzgz0.zzd()));
                zzga0 = (zzga)zzfz0.zzd();
            }
            catch(Exception exception0) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", exception0);
            }
            this.zzap(zzga0);
            return;
        }
        try {
            zzgd zzgd0 = zzge.zzy();
            zzgd0.zzm(5);
            zzgz zzgz1 = zzhb.zzy();
            zzgz1.zzl(v1);
            zzgd0.zzl(((zzhb)zzgz1.zzd()));
            zzga0 = (zzge)zzgd0.zzd();
        }
        catch(Exception exception1) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", exception1);
        }
        this.zzaq(((zzge)zzga0));
    }

    public static Context zzb(BillingClientImpl billingClientImpl0) {
        return billingClientImpl0.zze;
    }

    // 检测为 Lambda 实现
    public final Bundle zzc(int v, String s, String s1, BillingFlowParams billingFlowParams0, Bundle bundle0) [...]

    public final Bundle zzd(String s, String s1) {
        return this.zzg.zzf(3, "com.iloen.melon", s, s1, null);
    }

    public static zzbt zzg(BillingClientImpl billingClientImpl0, String s) {
        PurchaseHistoryRecord purchaseHistoryRecord0;
        Bundle bundle1;
        zzb.zzj("BillingClient", "Querying purchase history, item type: " + s);
        ArrayList arrayList0 = new ArrayList();
        Bundle bundle0 = zzb.zzc(billingClientImpl0.zzn, billingClientImpl0.zzv, billingClientImpl0.zzz.isEnabledForOneTimeProducts(), billingClientImpl0.zzz.isEnabledForPrepaidPlans(), billingClientImpl0.zzb);
        String s1 = null;
        do {
            if(!billingClientImpl0.zzl) {
                zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
                return new zzbt(zzce.zzq, null);
            }
            try {
                bundle1 = billingClientImpl0.zzg.zzh(6, "com.iloen.melon", s, s1, bundle0);
            }
            catch(RemoteException remoteException0) {
                zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", remoteException0);
                billingClientImpl0.zzap(zzcb.zza(59, 11, zzce.zzm));
                return new zzbt(zzce.zzm, null);
            }
            zzda zzda0 = zzdb.zza(bundle1, "BillingClient", "getPurchaseHistory()");
            BillingResult billingResult0 = zzda0.zza();
            if(billingResult0 != zzce.zzl) {
                billingClientImpl0.zzap(zzcb.zza(zzda0.zzb(), 11, billingResult0));
                return new zzbt(billingResult0, null);
            }
            ArrayList arrayList1 = bundle1.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList2 = bundle1.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList3 = bundle1.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            boolean z = false;
            for(int v = 0; v < arrayList2.size(); ++v) {
                String s2 = (String)arrayList2.get(v);
                String s3 = (String)arrayList3.get(v);
                zzb.zzj("BillingClient", "Purchase record found for sku : " + ((String)arrayList1.get(v)));
                try {
                    purchaseHistoryRecord0 = new PurchaseHistoryRecord(s2, s3);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", jSONException0);
                    billingClientImpl0.zzap(zzcb.zza(51, 11, zzce.zzj));
                    return new zzbt(zzce.zzj, null);
                }
                if(TextUtils.isEmpty(purchaseHistoryRecord0.getPurchaseToken())) {
                    zzb.zzk("BillingClient", "BUG: empty/null token!");
                    z = true;
                }
                arrayList0.add(purchaseHistoryRecord0);
            }
            if(z) {
                billingClientImpl0.zzap(zzcb.zza(26, 11, zzce.zzj));
            }
            s1 = bundle1.getString("INAPP_CONTINUATION_TOKEN");
            zzb.zzj("BillingClient", "Continuation token: " + s1);
        }
        while(!TextUtils.isEmpty(s1));
        return new zzbt(zzce.zzl, arrayList0);
    }

    public final Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams0, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener0) {
        Bundle bundle1;
        try {
            zzs zzs0 = this.zzg;
            Bundle bundle0 = new Bundle();
            bundle0.putString("playBillingLibraryVersion", this.zzb);
            bundle1 = zzs0.zzd(9, "com.iloen.melon", acknowledgePurchaseParams0.getPurchaseToken(), bundle0);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "Error acknowledge purchase!", exception0);
            this.zzap(zzcb.zza(28, 3, zzce.zzm));
            acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzce.zzm);
            return null;
        }
        acknowledgePurchaseResponseListener0.onAcknowledgePurchaseResponse(zzce.zza(zzb.zzb(bundle1, "BillingClient"), zzb.zzg(bundle1, "BillingClient")));
        return null;
    }

    public final Object zzl(ConsumeParams consumeParams0, ConsumeResponseListener consumeResponseListener0) {
        String s2;
        int v;
        String s = consumeParams0.getPurchaseToken();
        try {
            zzb.zzj("BillingClient", "Consuming purchase with token: " + s);
            if(this.zzn) {
                zzs zzs0 = this.zzg;
                boolean z = this.zzn;
                String s1 = this.zzb;
                Bundle bundle0 = new Bundle();
                if(z) {
                    bundle0.putString("playBillingLibraryVersion", s1);
                }
                Bundle bundle1 = zzs0.zze(9, "com.iloen.melon", s, bundle0);
                v = bundle1.getInt("RESPONSE_CODE");
                s2 = zzb.zzg(bundle1, "BillingClient");
            }
            else {
                v = this.zzg.zza(3, "com.iloen.melon", s);
                s2 = "";
            }
            BillingResult billingResult0 = zzce.zza(v, s2);
            if(v == 0) {
                zzb.zzj("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener0.onConsumeResponse(billingResult0, s);
                return null;
            }
            zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + v);
            this.zzap(zzcb.zza(23, 4, billingResult0));
            consumeResponseListener0.onConsumeResponse(billingResult0, s);
            return null;
        }
        catch(Exception exception0) {
        }
        zzb.zzl("BillingClient", "Error consuming purchase!", exception0);
        this.zzap(zzcb.zza(29, 4, zzce.zzm));
        consumeResponseListener0.onConsumeResponse(zzce.zzm, s);
        return null;
    }

    public final Object zzm(Bundle bundle0, BillingConfigResponseListener billingConfigResponseListener0) {
        try {
            this.zzg.zzp(18, "com.iloen.melon", bundle0, new zzbk(billingConfigResponseListener0, this.zzf, this.zzk, null));
        }
        catch(DeadObjectException deadObjectException0) {
            zzb.zzl("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", deadObjectException0);
            this.zzap(zzcb.zza(62, 13, zzce.zzm));
            billingConfigResponseListener0.onBillingConfigResponse(zzce.zzm, null);
        }
        catch(Exception exception0) {
            zzb.zzl("BillingClient", "getBillingConfig got an exception.", exception0);
            this.zzap(zzcb.zza(62, 13, zzce.zzj));
            billingConfigResponseListener0.onBillingConfigResponse(zzce.zzj, null);
        }
        return null;
    }

    public final Object zzn(QueryProductDetailsParams queryProductDetailsParams0, ProductDetailsResponseListener productDetailsResponseListener0) {
        ProductDetails productDetails0;
        int v9;
        String s1;
        int v8;
        Bundle bundle2;
        ArrayList arrayList0 = new ArrayList();
        String s = queryProductDetailsParams0.zzb();
        zzai zzai0 = queryProductDetailsParams0.zza();
        int v = zzai0.size();
    alab1:
        for(int v1 = 0; true; v1 += 20) {
            if(v1 >= v) {
                s1 = "";
                v9 = 0;
                break;
            }
            ArrayList arrayList1 = new ArrayList(zzai0.subList(v1, (v1 + 20 <= v ? v1 + 20 : v)));
            ArrayList arrayList2 = new ArrayList();
            int v2 = arrayList1.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                arrayList2.add(((Product)arrayList1.get(v3)).zza());
            }
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle0.putString("playBillingLibraryVersion", this.zzb);
            try {
                zzs zzs0 = this.zzg;
                int v4 = this.zzw ? 20 : 17;
                boolean z = this.zzat();
                this.zzam(queryProductDetailsParams0);
                this.zzam(queryProductDetailsParams0);
                this.zzam(queryProductDetailsParams0);
                Bundle bundle1 = new Bundle();
                bundle1.putString("playBillingLibraryVersion", this.zzb);
                bundle1.putBoolean("enablePendingPurchases", true);
                bundle1.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                if(z) {
                    bundle1.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                int v5 = arrayList1.size();
                int v7 = 0;
                boolean z1 = false;
                for(int v6 = 0; v6 < v5; ++v6) {
                    Product queryProductDetailsParams$Product0 = (Product)arrayList1.get(v6);
                    arrayList3.add(null);
                    v7 |= !TextUtils.isEmpty(null);
                    if(queryProductDetailsParams$Product0.zzb().equals("first_party")) {
                        zzaa.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList4.add(null);
                        z1 = true;
                    }
                }
                if(v7 != 0) {
                    bundle1.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList3);
                }
                if(!arrayList4.isEmpty()) {
                    bundle1.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList4);
                }
                if(z1 && !TextUtils.isEmpty(null)) {
                    bundle1.putString("accountName", null);
                }
                bundle2 = zzs0.zzl(v4, "com.iloen.melon", s, bundle0, bundle1);
                v8 = 4;
                s1 = "Item is unavailable for purchase.";
            }
            catch(Exception exception0) {
                v8 = 6;
                zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", exception0);
                this.zzap(zzcb.zza(43, 7, zzce.zzj));
                s1 = "An internal error occurred.";
                v9 = v8;
                break alab1;
            }
            if(bundle2 == null) {
                zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                this.zzap(zzcb.zza(44, 7, zzce.zzC));
                v9 = v8;
                break alab1;
            }
            if(!bundle2.containsKey("DETAILS_LIST")) {
                v9 = zzb.zzb(bundle2, "BillingClient");
                s1 = zzb.zzg(bundle2, "BillingClient");
                if(v9 != 0) {
                    zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + v9);
                    this.zzap(zzcb.zza(23, 7, zzce.zza(v9, s1)));
                    break;
                }
                zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                this.zzap(zzcb.zza(45, 7, zzce.zza(6, s1)));
                v9 = 6;
                break;
            }
            ArrayList arrayList5 = bundle2.getStringArrayList("DETAILS_LIST");
            if(arrayList5 == null) {
                zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                this.zzap(zzcb.zza(46, 7, zzce.zzC));
                v9 = v8;
                break alab1;
            }
            for(int v10 = 0; v10 < arrayList5.size(); ++v10) {
                String s2 = (String)arrayList5.get(v10);
                try {
                    productDetails0 = new ProductDetails(s2);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", jSONException0);
                    s1 = "Error trying to decode SkuDetails.";
                    v8 = 6;
                    this.zzap(zzcb.zza(0x2F, 7, zzce.zza(6, "Error trying to decode SkuDetails.")));
                    v9 = v8;
                    break alab1;
                }
                zzb.zzj("BillingClient", "Got product details: " + productDetails0.toString());
                arrayList0.add(productDetails0);
            }
        }
        productDetailsResponseListener0.onProductDetailsResponse(zzce.zza(v9, s1), arrayList0);
        return null;
    }

    public final Object zzo(String s, List list0, String s1, SkuDetailsResponseListener skuDetailsResponseListener0) {
        SkuDetails skuDetails0;
        ArrayList arrayList2;
        int v3;
        String s3;
        Bundle bundle2;
        ArrayList arrayList0 = new ArrayList();
        int v = list0.size();
        int v1 = 0;
    alab1:
        while(true) {
            if(v1 >= v) {
                s3 = "";
                v3 = 0;
                break;
            }
            ArrayList arrayList1 = new ArrayList(list0.subList(v1, (v1 + 20 <= v ? v1 + 20 : v)));
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("ITEM_ID_LIST", arrayList1);
            bundle0.putString("playBillingLibraryVersion", this.zzb);
            try {
                if(this.zzo) {
                    zzs zzs0 = this.zzg;
                    int v2 = this.zzk;
                    boolean z = this.zzz.isEnabledForOneTimeProducts();
                    boolean z1 = this.zzat();
                    String s2 = this.zzb;
                    Bundle bundle1 = new Bundle();
                    if(v2 >= 9) {
                        bundle1.putString("playBillingLibraryVersion", s2);
                    }
                    if(v2 >= 9 && z) {
                        bundle1.putBoolean("enablePendingPurchases", true);
                    }
                    if(z1) {
                        bundle1.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    bundle2 = zzs0.zzl(10, "com.iloen.melon", s, bundle0, bundle1);
                }
                else {
                    bundle2 = this.zzg.zzk(3, "com.iloen.melon", s, bundle0);
                }
            }
            catch(Exception exception0) {
                zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", exception0);
                this.zzap(zzcb.zza(43, 8, zzce.zzm));
                s3 = "Service connection is disconnected.";
                v3 = -1;
                arrayList0 = null;
                break alab1;
            }
            s3 = "Item is unavailable for purchase.";
            if(bundle2 == null) {
                zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                this.zzap(zzcb.zza(44, 8, zzce.zzC));
            }
            else {
                if(!bundle2.containsKey("DETAILS_LIST")) {
                    int v4 = zzb.zzb(bundle2, "BillingClient");
                    s3 = zzb.zzg(bundle2, "BillingClient");
                    if(v4 != 0) {
                        zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + v4);
                        this.zzap(zzcb.zza(23, 8, zzce.zza(v4, s3)));
                        v3 = v4;
                        break;
                    }
                    zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    this.zzap(zzcb.zza(45, 8, zzce.zza(6, s3)));
                    v3 = 6;
                    break;
                }
                arrayList2 = bundle2.getStringArrayList("DETAILS_LIST");
                if(arrayList2 == null) {
                    zzb.zzk("BillingClient", "querySkuDetailsAsync got null response list");
                    this.zzap(zzcb.zza(46, 8, zzce.zzC));
                }
                else {
                    goto label_54;
                }
            }
            v3 = 4;
            arrayList0 = null;
            break alab1;
        label_54:
            for(int v5 = 0; v5 < arrayList2.size(); ++v5) {
                String s4 = (String)arrayList2.get(v5);
                try {
                    skuDetails0 = new SkuDetails(s4);
                }
                catch(JSONException jSONException0) {
                    zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", jSONException0);
                    s3 = "Error trying to decode SkuDetails.";
                    this.zzap(zzcb.zza(0x2F, 8, zzce.zza(6, "Error trying to decode SkuDetails.")));
                    v3 = 6;
                    arrayList0 = null;
                    break alab1;
                }
                zzb.zzj("BillingClient", "Got sku details: " + skuDetails0.toString());
                arrayList0.add(skuDetails0);
            }
            v1 += 20;
        }
        skuDetailsResponseListener0.onSkuDetailsResponse(zzce.zza(v3, s3), arrayList0);
        return null;
    }

    public final Object zzp(Bundle bundle0, Activity activity0, ResultReceiver resultReceiver0) {
        this.zzg.zzt(12, "com.iloen.melon", bundle0, new zzbs(new WeakReference(activity0), resultReceiver0, null));
        return null;
    }

    public final Void zzq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0) {
        try {
            this.zzg.zzm(21, "com.iloen.melon", zzb.zzd(this.zzb), new zzbe(alternativeBillingOnlyReportingDetailsListener0, this.zzf, this.zzk, null));
        }
        catch(Exception unused_ex) {
            this.zzap(zzcb.zza(70, 15, zzce.zzj));
            alternativeBillingOnlyReportingDetailsListener0.onAlternativeBillingOnlyTokenResponse(zzce.zzj, null);
        }
        return null;
    }

    public final Void zzr(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0) {
        try {
            this.zzg.zzn(22, "com.iloen.melon", zzb.zzd(this.zzb), new zzbg(externalOfferReportingDetailsListener0, this.zzf, this.zzk, null));
        }
        catch(Exception exception0) {
            String s = exception0.getClass().getName();
            this.zzap(zzcb.zzb(94, 24, zzce.zzj, e.c(s, ": ", com.google.android.gms.internal.play_billing.zzab.zzb(exception0.getMessage()))));
            externalOfferReportingDetailsListener0.onExternalOfferReportingDetailsResponse(zzce.zzj, null);
        }
        return null;
    }

    public final Void zzs(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener0) {
        try {
            this.zzg.zzr(21, "com.iloen.melon", zzb.zzd(this.zzb), new zzbo(alternativeBillingOnlyAvailabilityListener0, this.zzf, this.zzk, null));
        }
        catch(Exception unused_ex) {
            this.zzap(zzcb.zza(69, 14, zzce.zzj));
            alternativeBillingOnlyAvailabilityListener0.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzj);
        }
        return null;
    }

    public final Void zzt(ExternalOfferAvailabilityListener externalOfferAvailabilityListener0) {
        try {
            this.zzg.zzs(22, "com.iloen.melon", zzb.zzd(this.zzb), new zzbq(externalOfferAvailabilityListener0, this.zzf, this.zzk, null));
        }
        catch(Exception exception0) {
            String s = exception0.getClass().getName();
            this.zzap(zzcb.zzb(91, 23, zzce.zzj, e.c(s, ": ", com.google.android.gms.internal.play_billing.zzab.zzb(exception0.getMessage()))));
            externalOfferAvailabilityListener0.onExternalOfferAvailabilityResponse(zzce.zzj);
        }
        return null;
    }

    public final Void zzu(Activity activity0, ResultReceiver resultReceiver0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        try {
            this.zzg.zzo(21, "com.iloen.melon", zzb.zzd(this.zzb), new zzbi(new WeakReference(activity0), resultReceiver0, null));
        }
        catch(Exception unused_ex) {
            this.zzap(zzcb.zza(74, 16, zzce.zzj));
            alternativeBillingOnlyInformationDialogListener0.onAlternativeBillingOnlyInformationDialogResponse(zzce.zzj);
        }
        return null;
    }

    public final Void zzv(Activity activity0, ResultReceiver resultReceiver0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        try {
            this.zzg.zzq(22, "com.iloen.melon", zzb.zzd(this.zzb), new zzbm(new WeakReference(activity0), resultReceiver0, null));
        }
        catch(Exception exception0) {
            String s = exception0.getClass().getName();
            this.zzap(zzcb.zzb(98, 25, zzce.zzj, e.c(s, ": ", com.google.android.gms.internal.play_billing.zzab.zzb(exception0.getMessage()))));
            externalOfferInformationDialogListener0.onExternalOfferInformationDialogResponse(zzce.zzj);
        }
        return null;
    }

    public static Future zzw(BillingClientImpl billingClientImpl0, Callable callable0, long v, Runnable runnable0, Handler handler0) {
        return billingClientImpl0.zzao(callable0, 30000L, runnable0, handler0);
    }
}

