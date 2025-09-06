package com.android.billingclient.api;

import b3.Z;

final class zzce {
    static final BillingResult zzA;
    static final BillingResult zzB;
    static final BillingResult zzC;
    static final BillingResult zzD;
    static final BillingResult zzE;
    static final BillingResult zzF;
    public static final int zzG;
    static final BillingResult zza;
    static final BillingResult zzb;
    static final BillingResult zzc;
    static final BillingResult zzd;
    static final BillingResult zze;
    static final BillingResult zzf;
    static final BillingResult zzg;
    static final BillingResult zzh;
    static final BillingResult zzi;
    static final BillingResult zzj;
    static final BillingResult zzk;
    static final BillingResult zzl;
    static final BillingResult zzm;
    static final BillingResult zzn;
    static final BillingResult zzo;
    static final BillingResult zzp;
    static final BillingResult zzq;
    static final BillingResult zzr;
    static final BillingResult zzs;
    static final BillingResult zzt;
    static final BillingResult zzu;
    static final BillingResult zzv;
    static final BillingResult zzw;
    static final BillingResult zzx;
    static final BillingResult zzy;
    static final BillingResult zzz;

    static {
        zzce.zza = Z.f(3, "Google Play In-app Billing API version is less than 3");
        zzce.zzb = Z.f(3, "Google Play In-app Billing API version is less than 9");
        zzce.zzc = Z.f(3, "Billing service unavailable on device.");
        zzce.zzd = Z.f(5, "Client is already in the process of connecting to billing service.");
        zzce.zze = Z.f(5, "The list of SKUs can\'t be empty.");
        zzce.zzf = Z.f(5, "SKU type can\'t be empty.");
        zzce.zzg = Z.f(5, "Product type can\'t be empty.");
        zzce.zzh = Z.f(-2, "Client does not support extra params.");
        zzce.zzi = Z.f(5, "Invalid purchase token.");
        zzce.zzj = Z.f(6, "An internal error occurred.");
        zzce.zzk = Z.f(5, "SKU can\'t be null.");
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(0);
        zzce.zzl = billingResult$Builder0.build();
        zzce.zzm = Z.f(-1, "Service connection is disconnected.");
        zzce.zzn = Z.f(2, "Timeout communicating with service.");
        zzce.zzo = Z.f(-2, "Client does not support subscriptions.");
        zzce.zzp = Z.f(-2, "Client does not support subscriptions update.");
        zzce.zzq = Z.f(-2, "Client does not support get purchase history.");
        zzce.zzr = Z.f(-2, "Client does not support price change confirmation.");
        zzce.zzs = Z.f(-2, "Play Store version installed does not support cross selling products.");
        zzce.zzt = Z.f(-2, "Client does not support multi-item purchases.");
        zzce.zzu = Z.f(-2, "Client does not support offer_id_token.");
        zzce.zzv = Z.f(-2, "Client does not support ProductDetails.");
        zzce.zzw = Z.f(-2, "Client does not support in-app messages.");
        zzce.zzx = Z.f(-2, "Client does not support user choice billing.");
        zzce.zzy = Z.f(-2, "Play Store version installed does not support external offer.");
        zzce.zzz = Z.f(5, "Unknown feature");
        zzce.zzA = Z.f(-2, "Play Store version installed does not support get billing config.");
        zzce.zzB = Z.f(-2, "Query product details with serialized docid is not supported.");
        zzce.zzC = Z.f(4, "Item is unavailable for purchase.");
        zzce.zzD = Z.f(-2, "Query product details with developer specified account is not supported.");
        zzce.zzE = Z.f(-2, "Play Store version installed does not support alternative billing only.");
        zzce.zzF = Z.f(5, "To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
    }

    public static BillingResult zza(int v, String s) {
        return Z.f(v, s);
    }
}

