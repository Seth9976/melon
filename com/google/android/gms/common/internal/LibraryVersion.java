package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
@Deprecated
public class LibraryVersion {
    private static final GmsLogger zza;
    private static final LibraryVersion zzb;
    private final ConcurrentHashMap zzc;

    static {
        LibraryVersion.zza = new GmsLogger("LibraryVersion", "");
        LibraryVersion.zzb = new LibraryVersion();
    }

    public LibraryVersion() {
        this.zzc = new ConcurrentHashMap();
    }

    @KeepForSdk
    public static LibraryVersion getInstance() {
        return LibraryVersion.zzb;
    }

    @KeepForSdk
    @Deprecated
    public String getVersion(String s) {
        InputStream inputStream0;
        Preconditions.checkNotEmpty(s, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap0 = this.zzc;
        if(concurrentHashMap0.containsKey(s)) {
            return (String)concurrentHashMap0.get(s);
        }
        Properties properties0 = new Properties();
        String s1 = null;
        try {
            inputStream0 = LibraryVersion.class.getResourceAsStream("/" + s + ".properties");
            goto label_12;
        }
        catch(IOException iOException0) {
            IOException iOException1 = iOException0;
            String s2 = null;
            goto label_25;
        label_12:
            if(inputStream0 == null) {
                goto label_17;
                try {
                label_25:
                    LibraryVersion.zza.e("LibraryVersion", "Failed to get app version for libraryName: " + s, iOException1);
                    String s4 = s1;
                    s1 = s2;
                    inputStream0 = s4;
                    goto label_36;
                }
                catch(Throwable throwable0) {
                }
                goto label_33;
            }
            else {
                try {
                    properties0.load(inputStream0);
                    s1 = properties0.getProperty("version", null);
                    LibraryVersion.zza.v("LibraryVersion", s + " version is " + s1);
                    goto label_36;
                label_17:
                    LibraryVersion.zza.w("LibraryVersion", "Failed to get app version for libraryName: " + s);
                    goto label_36;
                label_22:
                    String s3 = s1;
                    s1 = inputStream0;
                    s2 = s3;
                    goto label_25;
                }
                catch(IOException iOException1) {
                    goto label_22;
                }
                catch(Throwable throwable0) {
                    goto label_32;
                }
            }
            goto label_36;
        }
        catch(Throwable throwable0) {
            goto label_33;
        }
    label_32:
        s1 = inputStream0;
    label_33:
        if(s1 != null) {
            IOUtils.closeQuietly(((Closeable)s1));
        }
        throw throwable0;
    label_36:
        if(inputStream0 != null) {
            IOUtils.closeQuietly(inputStream0);
        }
        if(s1 == null) {
            LibraryVersion.zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            s1 = "UNKNOWN";
        }
        this.zzc.put(s, s1);
        return s1;
    }
}

