package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.utils.Logger;
import com.iloen.melon.utils.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jeb.synthetic.TWR;

public class NetworkCache {
    private final LottieNetworkCacheProvider cacheProvider;

    public NetworkCache(LottieNetworkCacheProvider lottieNetworkCacheProvider0) {
        this.cacheProvider = lottieNetworkCacheProvider0;
    }

    public void clear() {
        File file0 = this.parentDir();
        if(file0.exists()) {
            File[] arr_file = file0.listFiles();
            if(arr_file != null && arr_file.length > 0) {
                for(int v = 0; v < arr_file.length; ++v) {
                    arr_file[v].delete();
                }
            }
            file0.delete();
        }
    }

    public Pair fetch(String s) {
        FileExtension fileExtension0;
        FileInputStream fileInputStream0;
        File file0;
        try {
            file0 = this.getCachedFile(s);
            if(file0 == null) {
                return null;
            }
            fileInputStream0 = new FileInputStream(file0);
        }
        catch(FileNotFoundException unused_ex) {
            return null;
        }
        if(file0.getAbsolutePath().endsWith(".zip")) {
            fileExtension0 = FileExtension.ZIP;
        }
        else {
            fileExtension0 = file0.getAbsolutePath().endsWith(".gz") ? FileExtension.GZIP : FileExtension.JSON;
        }
        StringBuilder stringBuilder0 = a.n("Cache hit for ", s, " at ");
        stringBuilder0.append(file0.getAbsolutePath());
        Logger.debug(stringBuilder0.toString());
        return new Pair(fileExtension0, fileInputStream0);
    }

    private static String filenameForUrl(String s, FileExtension fileExtension0, boolean z) {
        String s1 = z ? fileExtension0.tempExtension() : fileExtension0.extension;
        String s2 = s.replaceAll("\\W+", "");
        int v = s1.length();
        if(s2.length() > 0xF2 - v) {
            s2 = NetworkCache.getMD5(s2, 0xF2 - v);
        }
        return "lottie_cache_" + s2 + s1;
    }

    private File getCachedFile(String s) {
        File file0 = new File(this.parentDir(), NetworkCache.filenameForUrl(s, FileExtension.JSON, false));
        if(file0.exists()) {
            return file0;
        }
        File file1 = new File(this.parentDir(), NetworkCache.filenameForUrl(s, FileExtension.ZIP, false));
        if(file1.exists()) {
            return file1;
        }
        File file2 = new File(this.parentDir(), NetworkCache.filenameForUrl(s, FileExtension.GZIP, false));
        return file2.exists() ? file2 : null;
    }

    private static String getMD5(String s, int v) {
        MessageDigest messageDigest0;
        try {
            messageDigest0 = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException unused_ex) {
            return s.substring(0, v);
        }
        byte[] arr_b = messageDigest0.digest(s.getBytes());
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v1 = 0; v1 < arr_b.length; ++v1) {
            stringBuilder0.append(String.format("%02x", ((byte)arr_b[v1])));
        }
        return stringBuilder0.toString();
    }

    private File parentDir() {
        File file0 = this.cacheProvider.getCacheDir();
        if(file0.isFile()) {
            file0.delete();
        }
        if(!file0.exists()) {
            file0.mkdirs();
        }
        return file0;
    }

    public void renameTempFile(String s, FileExtension fileExtension0) {
        String s1 = NetworkCache.filenameForUrl(s, fileExtension0, true);
        File file0 = new File(this.parentDir(), s1);
        File file1 = new File(file0.getAbsolutePath().replace(".temp", ""));
        boolean z = file0.renameTo(file1);
        Logger.debug(("Copying temp file to real file (" + file1 + ")"));
        if(!z) {
            Logger.warning(("Unable to rename cache file " + file0.getAbsolutePath() + " to " + file1.getAbsolutePath() + "."));
        }
    }

    public File writeTempCacheFile(String s, InputStream inputStream0, FileExtension fileExtension0) {
        String s1 = NetworkCache.filenameForUrl(s, fileExtension0, true);
        File file0 = new File(this.parentDir(), s1);
        try {
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
            try {
                byte[] arr_b = new byte[0x400];
                while(true) {
                    inputStream0 = TWR.getResource$NT(inputStream0);
                    TWR.declareResource(inputStream0);
                    TWR.useResource$NT(inputStream0);
                    int v1 = inputStream0.read(arr_b);
                    if(v1 == -1) {
                        break;
                    }
                    TWR.useResource$NT(inputStream0);
                    fileOutputStream0.write(arr_b, 0, v1);
                }
                TWR.useResource$NT(inputStream0);
                fileOutputStream0.flush();
                TWR.useResource$NT(inputStream0);
                return file0;
            }
            finally {
                fileOutputStream0.close();
            }
        }
        catch(Throwable throwable0) {
            TWR.moot$NT();
            throw throwable0;
        }
    }
}

