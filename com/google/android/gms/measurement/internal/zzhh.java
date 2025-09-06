package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import b3.Z;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbq;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

final class zzhh implements Runnable {
    final zzbq zza;
    final ServiceConnection zzb;
    final zzhi zzc;

    public zzhh(zzhi zzhi0, zzbq zzbq0, ServiceConnection serviceConnection0) {
        this.zza = zzbq0;
        this.zzb = serviceConnection0;
        Objects.requireNonNull(zzhi0);
        this.zzc = zzhi0;
        super();
    }

    @Override
    public final void run() {
        Bundle bundle1;
        zzhj zzhj0 = this.zzc.zza;
        zzib zzib0 = zzhj0.zza;
        zzib0.zzaW().zzg();
        Bundle bundle0 = new Bundle();
        String s = this.zzc.zza();
        bundle0.putString("package_name", s);
        try {
            bundle1 = this.zza.zze(bundle0);
            if(bundle1 == null) {
                zzib0.zzaV().zzb().zza("Install Referrer Service returned a null response");
                goto label_12;
            }
            goto label_13;
        }
        catch(Exception exception0) {
            zzhj0.zza.zzaV().zzb().zzb("Exception occurred while retrieving the Install Referrer", exception0.getMessage());
        }
    label_12:
        bundle1 = null;
    label_13:
        zzib zzib1 = zzhj0.zza;
        zzib1.zzaW().zzg();
        zzib.zzL();
        if(bundle1 != null) {
            long v = bundle1.getLong("install_begin_timestamp_seconds", 0L);
            if(v * 1000L == 0L) {
                Z.A(zzib1, "Service response is missing Install Referrer install timestamp");
            }
            else {
                String s1 = bundle1.getString("install_referrer");
                if(s1 == null || s1.isEmpty()) {
                    Z.u(zzib1, "No referrer defined in Install Referrer response");
                }
                else {
                    zzib1.zzaV().zzk().zzb("InstallReferrer API result", s1);
                    Bundle bundle2 = zzib1.zzk().zzi(Uri.parse(("?" + s1)));
                    if(bundle2 == null) {
                        Z.u(zzib1, "No campaign params defined in Install Referrer result");
                    }
                    else {
                        List list0 = Arrays.asList(new String[]{"gclid", "gbraid", "gad_campaignid"});
                        for(Object object0: bundle2.keySet()) {
                            if(list0.contains(((String)object0))) {
                                long v1 = bundle1.getLong("referrer_click_timestamp_server_seconds", 0L);
                                if(v1 * 1000L <= 0L) {
                                    break;
                                }
                                bundle2.putLong("click_timestamp", v1 * 1000L);
                                break;
                            }
                            if(false) {
                                break;
                            }
                        }
                        if(v * 1000L == zzib1.zzd().zzd.zza()) {
                            zzib1.zzaV().zzk().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if(zzib1.zzB()) {
                            zzib1.zzd().zzd.zzb(v * 1000L);
                            zzib1.zzaV().zzk().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            bundle2.putString("_cis", "referrer API v2");
                            zzib1.zzj().zzI("auto", "_cmp", bundle2, s);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzib1.zzaY(), this.zzb);
    }
}

