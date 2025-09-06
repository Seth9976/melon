package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzib;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public final class zzgy extends zzor {
    public zzgy(zzpf zzpf0) {
        super(zzpf0);
    }

    public final boolean zzb() {
        this.zzay();
        ConnectivityManager connectivityManager0 = (ConnectivityManager)this.zzu.zzaY().getSystemService("connectivity");
        NetworkInfo networkInfo0 = null;
        if(connectivityManager0 != null) {
            try {
                networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            }
            catch(SecurityException unused_ex) {
            }
        }
        return networkInfo0 != null && networkInfo0.isConnected();
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        return false;
    }

    public final void zzc(String s, zzos zzos0, zzib zzib0, zzgv zzgv0) {
        this.zzg();
        this.zzay();
        try {
            URL uRL0 = new URI(zzos0.zza()).toURL();
            this.zzg.zzp();
            byte[] arr_b = zzib0.zzcc();
            this.zzu.zzaW().zzm(new zzgx(this, s, uRL0, arr_b, zzos0.zzb(), zzgv0));
        }
        catch(IllegalArgumentException | MalformedURLException | URISyntaxException unused_ex) {
            this.zzu.zzaV().zzb().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgt.zzl(s), zzos0.zza());
        }
    }

    public final void zzd(zzh zzh0, Map map0, zzgv zzgv0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(zzh0);
        Preconditions.checkNotNull(zzgv0);
        Uri.Builder uri$Builder0 = new Uri.Builder();
        String s = zzh0.zzf();
        Uri.Builder uri$Builder1 = uri$Builder0.scheme("https").encodedAuthority("app-measurement.com").path("config/app/" + s).appendQueryParameter("platform", "android");
        this.zzg.zzf().zzu.zzc().zzi();
        uri$Builder1.appendQueryParameter("gmp_version", "130000").appendQueryParameter("runtime_version", "0");
        String s1 = uri$Builder0.build().toString();
        try {
            URL uRL0 = new URI(s1).toURL();
            this.zzu.zzaW().zzm(new zzgx(this, zzh0.zzc(), uRL0, null, map0, zzgv0));
        }
        catch(IllegalArgumentException | MalformedURLException | URISyntaxException unused_ex) {
            this.zzu.zzaV().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzgt.zzl(zzh0.zzc()), s1);
        }
    }
}

