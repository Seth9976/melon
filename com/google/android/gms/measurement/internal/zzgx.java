package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;

final class zzgx implements Runnable {
    final zzgy zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzgv zzd;
    private final String zze;
    private final Map zzf;

    public zzgx(zzgy zzgy0, String s, URL uRL0, byte[] arr_b, Map map0, zzgv zzgv0) {
        Objects.requireNonNull(zzgy0);
        this.zza = zzgy0;
        super();
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(uRL0);
        Preconditions.checkNotNull(zzgv0);
        this.zzb = uRL0;
        this.zzc = arr_b;
        this.zzd = zzgv0;
        this.zze = s;
        this.zzf = map0;
    }

    @Override
    public final void run() {
        byte[] arr_b3;
        InputStream inputStream0;
        Map map3;
        int v2;
        OutputStream outputStream1;
        byte[] arr_b1;
        Map map1;
        int v1;
        Map map0;
        int v;
        IOException iOException1;
        zzib zzib0;
        HttpURLConnection httpURLConnection0;
        zzgy zzgy0 = this.zza;
        zzgy0.zzaX();
        OutputStream outputStream0 = null;
        try {
            URLConnection uRLConnection0 = this.zzb.openConnection();
            if(!(uRLConnection0 instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection0 = (HttpURLConnection)uRLConnection0;
            httpURLConnection0.setDefaultUseCaches(false);
            zzib0 = zzgy0.zzu;
            httpURLConnection0.setConnectTimeout(60000);
            httpURLConnection0.setReadTimeout(61000);
            httpURLConnection0.setInstanceFollowRedirects(false);
            httpURLConnection0.setDoInput(true);
        }
        catch(IOException iOException0) {
            iOException1 = iOException0;
            v = 0;
            httpURLConnection0 = null;
            map0 = null;
            goto label_99;
        }
        catch(Throwable throwable0) {
            v1 = 0;
            httpURLConnection0 = null;
            map1 = null;
            goto label_66;
        }
        try {
            Map map2 = this.zzf;
            if(map2 != null) {
                for(Object object0: map2.entrySet()) {
                    httpURLConnection0.addRequestProperty(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
                }
            }
            byte[] arr_b = this.zzc;
            if(arr_b != null) {
                arr_b1 = zzgy0.zzg.zzp().zzv(arr_b);
                zzib0.zzaV().zzk().zzb("Uploading data. size", ((int)arr_b1.length));
                httpURLConnection0.setDoOutput(true);
                httpURLConnection0.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnection0.setFixedLengthStreamingMode(arr_b1.length);
                httpURLConnection0.connect();
                outputStream1 = httpURLConnection0.getOutputStream();
                goto label_41;
            }
            v2 = httpURLConnection0.getResponseCode();
            goto label_68;
        }
        catch(IOException iOException2) {
            iOException1 = iOException2;
            v = 0;
            map0 = null;
            goto label_99;
        }
        catch(Throwable throwable0) {
            goto label_64;
        }
        try {
        label_41:
            outputStream1.write(arr_b1);
            outputStream1.close();
        }
        catch(IOException iOException3) {
            iOException1 = iOException3;
            v = 0;
            map0 = null;
            outputStream0 = outputStream1;
            goto label_99;
        }
        catch(Throwable throwable0) {
            v1 = 0;
            map1 = null;
            outputStream0 = outputStream1;
            goto label_66;
        }
        try {
            v2 = httpURLConnection0.getResponseCode();
            goto label_68;
        }
        catch(IOException iOException2) {
            iOException1 = iOException2;
            v = 0;
            map0 = null;
            goto label_99;
        }
        catch(Throwable throwable0) {
        }
    label_64:
        v1 = 0;
        map1 = null;
    label_66:
        Throwable throwable1 = throwable0;
        goto label_112;
        try {
        label_68:
            map3 = httpURLConnection0.getHeaderFields();
        }
        catch(IOException iOException4) {
            map0 = null;
            v = v2;
            goto label_98;
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            map1 = null;
            v1 = v2;
            goto label_112;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            inputStream0 = null;
            inputStream0 = httpURLConnection0.getInputStream();
            byte[] arr_b2 = new byte[0x400];
            int v3;
            while((v3 = inputStream0.read(arr_b2)) > 0) {
                byteArrayOutputStream0.write(arr_b2, 0, v3);
            }
            arr_b3 = byteArrayOutputStream0.toByteArray();
            goto label_93;
        }
        catch(Throwable throwable3) {
            try {
                if(inputStream0 != null) {
                    inputStream0.close();
                }
                throw throwable3;
            label_93:
                inputStream0.close();
                goto label_121;
            }
            catch(IOException iOException4) {
            }
            catch(Throwable throwable4) {
                goto label_109;
            }
        }
        v = v2;
        map0 = map3;
    label_98:
        iOException1 = iOException4;
    label_99:
        if(outputStream0 != null) {
            try {
                outputStream0.close();
            }
            catch(IOException iOException5) {
                this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), iOException5);
            }
        }
        if(httpURLConnection0 != null) {
            httpURLConnection0.disconnect();
        }
        this.zza.zzu.zzaW().zzj(new zzgw(this.zze, this.zzd, v, iOException1, null, map0, null));
        return;
    label_109:
        throwable1 = throwable4;
        v1 = v2;
        map1 = map3;
    label_112:
        if(outputStream0 != null) {
            try {
                outputStream0.close();
            }
            catch(IOException iOException6) {
                this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), iOException6);
            }
        }
        if(httpURLConnection0 != null) {
            httpURLConnection0.disconnect();
        }
        this.zza.zzu.zzaW().zzj(new zzgw(this.zze, this.zzd, v1, null, null, map1, null));
        throw throwable1;
    label_121:
        httpURLConnection0.disconnect();
        this.zza.zzu.zzaW().zzj(new zzgw(this.zze, this.zzd, v2, null, arr_b3, map3, null));
    }
}

