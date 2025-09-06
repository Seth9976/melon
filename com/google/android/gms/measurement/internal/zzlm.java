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
import java.util.zip.GZIPOutputStream;

final class zzlm implements Runnable {
    final zzln zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzlk zzd;
    private final String zze;
    private final Map zzf;

    public zzlm(zzln zzln0, String s, URL uRL0, byte[] arr_b, Map map0, zzlk zzlk0) {
        Objects.requireNonNull(zzln0);
        this.zza = zzln0;
        super();
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(uRL0);
        Preconditions.checkNotNull(zzlk0);
        this.zzb = uRL0;
        this.zzc = arr_b;
        this.zzd = zzlk0;
        this.zze = s;
        this.zzf = map0;
    }

    @Override
    public final void run() {
        byte[] arr_b3;
        InputStream inputStream0;
        Map map3;
        int v1;
        Map map2;
        Map map1;
        byte[] arr_b1;
        byte[] arr_b;
        OutputStream outputStream0;
        HttpURLConnection httpURLConnection0;
        this.zza.zzaX();
        int v = 0;
        try {
            URLConnection uRLConnection0 = this.zzb.openConnection();
            if(!(uRLConnection0 instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection0 = (HttpURLConnection)uRLConnection0;
            httpURLConnection0.setDefaultUseCaches(false);
            httpURLConnection0.setConnectTimeout(60000);
            httpURLConnection0.setReadTimeout(61000);
            httpURLConnection0.setInstanceFollowRedirects(false);
            httpURLConnection0.setDoInput(true);
        }
        catch(IOException iOException0) {
            httpURLConnection0 = null;
            outputStream0 = null;
            map1 = null;
            goto label_95;
        }
        catch(Throwable throwable0) {
            httpURLConnection0 = null;
            outputStream0 = null;
            map2 = null;
            goto label_109;
        }
        try {
            try {
                Map map0 = this.zzf;
                if(map0 != null) {
                    for(Object object0: map0.entrySet()) {
                        httpURLConnection0.addRequestProperty(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
                    }
                }
                arr_b = this.zzc;
                if(arr_b != null) {
                    goto label_29;
                }
                v1 = httpURLConnection0.getResponseCode();
                map3 = httpURLConnection0.getHeaderFields();
                goto label_74;
            }
            catch(IOException iOException0) {
                outputStream0 = null;
                map1 = null;
                goto label_95;
            }
            try {
            label_29:
                ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(byteArrayOutputStream0);
                gZIPOutputStream0.write(arr_b);
                gZIPOutputStream0.close();
                byteArrayOutputStream0.close();
                arr_b1 = byteArrayOutputStream0.toByteArray();
                goto label_39;
            }
            catch(IOException iOException1) {
                try {
                    this.zza.zzu.zzaV().zzb().zzb("Failed to gzip post request content", iOException1);
                    throw iOException1;
                label_39:
                    this.zza.zzu.zzaV().zzk().zzb("Uploading data. size", ((int)arr_b1.length));
                    httpURLConnection0.setDoOutput(true);
                    httpURLConnection0.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection0.setFixedLengthStreamingMode(arr_b1.length);
                    httpURLConnection0.connect();
                    outputStream0 = httpURLConnection0.getOutputStream();
                }
                catch(IOException iOException0) {
                    outputStream0 = null;
                    map1 = null;
                    goto label_95;
                }
            }
        }
        catch(Throwable throwable0) {
            outputStream0 = null;
            map2 = null;
            goto label_109;
        }
        try {
            outputStream0.write(arr_b1);
            outputStream0.close();
        }
        catch(IOException iOException0) {
            map1 = null;
            goto label_95;
        }
        catch(Throwable throwable0) {
            map2 = null;
            goto label_109;
        }
        try {
            v1 = httpURLConnection0.getResponseCode();
            map3 = httpURLConnection0.getHeaderFields();
            goto label_74;
        }
        catch(IOException iOException0) {
            outputStream0 = null;
            map1 = null;
            goto label_95;
        }
        catch(Throwable throwable0) {
            outputStream0 = null;
            map2 = null;
            goto label_109;
        }
        try {
            map3 = httpURLConnection0.getHeaderFields();
            goto label_74;
        }
        catch(IOException iOException2) {
            v = v1;
            iOException0 = iOException2;
            outputStream0 = null;
            map1 = null;
            goto label_95;
        }
        catch(Throwable throwable1) {
            v = v1;
            throwable0 = throwable1;
        }
        outputStream0 = null;
        map2 = null;
        goto label_109;
        try {
        label_74:
            ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
            inputStream0 = null;
            inputStream0 = httpURLConnection0.getInputStream();
            byte[] arr_b2 = new byte[0x400];
            int v2;
            while((v2 = inputStream0.read(arr_b2)) > 0) {
                byteArrayOutputStream1.write(arr_b2, 0, v2);
            }
            arr_b3 = byteArrayOutputStream1.toByteArray();
            goto label_88;
        }
        catch(Throwable throwable2) {
            try {
                if(inputStream0 != null) {
                    inputStream0.close();
                }
                throw throwable2;
            label_88:
                inputStream0.close();
                goto label_118;
            }
            catch(IOException iOException3) {
            }
            catch(Throwable throwable3) {
                goto label_105;
            }
        }
        v = v1;
        iOException0 = iOException3;
        map1 = map3;
        outputStream0 = null;
    label_95:
        if(outputStream0 != null) {
            try {
                outputStream0.close();
            }
            catch(IOException iOException4) {
                this.zza.zzu.zzaV().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgt.zzl(this.zze), iOException4);
            }
        }
        if(httpURLConnection0 != null) {
            httpURLConnection0.disconnect();
        }
        this.zzb(v, iOException0, null, map1);
        return;
    label_105:
        v = v1;
        throwable0 = throwable3;
        map2 = map3;
        outputStream0 = null;
    label_109:
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
        this.zzb(v, null, null, map2);
        throw throwable0;
    label_118:
        httpURLConnection0.disconnect();
        this.zzb(v1, null, arr_b3, map3);
    }

    // 检测为 Lambda 实现
    public final void zza(int v, Exception exception0, byte[] arr_b, Map map0) [...]

    private final void zzb(int v, Exception exception0, byte[] arr_b, Map map0) {
        this.zza.zzu.zzaW().zzj(() -> this.zzd.zza(this.zze, v, exception0, arr_b, map0));
    }
}

