package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.offline.HlsDownloader;
import java.lang.reflect.Constructor;
import java.util.List;

public class DefaultDownloaderFactory implements DownloaderFactory {
    private static final Constructor DASH_DOWNLOADER_CONSTRUCTOR;
    private static final Constructor HLS_DOWNLOADER_CONSTRUCTOR;
    private static final Constructor SS_DOWNLOADER_CONSTRUCTOR;
    private final DownloaderConstructorHelper downloaderConstructorHelper;

    static {
        Constructor constructor2;
        Constructor constructor1;
        Constructor constructor0 = null;
        try {
            constructor1 = null;
            constructor1 = DefaultDownloaderFactory.getDownloaderConstructor(Class.forName("com.google.android.exoplayer2.source.dash.offline.DashDownloader"));
        }
        catch(ClassNotFoundException unused_ex) {
        }
        try {
            DefaultDownloaderFactory.DASH_DOWNLOADER_CONSTRUCTOR = constructor1;
            constructor2 = null;
            constructor2 = DefaultDownloaderFactory.getDownloaderConstructor(HlsDownloader.class);
        }
        catch(ClassNotFoundException unused_ex) {
        }
        try {
            DefaultDownloaderFactory.HLS_DOWNLOADER_CONSTRUCTOR = constructor2;
            constructor0 = DefaultDownloaderFactory.getDownloaderConstructor(Class.forName("com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader"));
        }
        catch(ClassNotFoundException unused_ex) {
        }
        DefaultDownloaderFactory.SS_DOWNLOADER_CONSTRUCTOR = constructor0;
    }

    public DefaultDownloaderFactory(DownloaderConstructorHelper downloaderConstructorHelper0) {
        this.downloaderConstructorHelper = downloaderConstructorHelper0;
    }

    private Downloader createDownloader(DownloadRequest downloadRequest0, Constructor constructor0) {
        if(constructor0 == null) {
            String s = String.valueOf(downloadRequest0.type);
            throw new IllegalStateException((s.length() == 0 ? new String("Module missing for: ") : "Module missing for: " + s));
        }
        try {
            return (Downloader)constructor0.newInstance(downloadRequest0.uri, downloadRequest0.streamKeys, this.downloaderConstructorHelper);
        }
        catch(Exception exception0) {
            String s1 = String.valueOf(downloadRequest0.type);
            throw new RuntimeException((s1.length() == 0 ? new String("Failed to instantiate downloader for: ") : "Failed to instantiate downloader for: " + s1), exception0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.DownloaderFactory
    public Downloader createDownloader(DownloadRequest downloadRequest0) {
        downloadRequest0.type.getClass();
        switch(downloadRequest0.type) {
            case "dash": {
                return this.createDownloader(downloadRequest0, DefaultDownloaderFactory.DASH_DOWNLOADER_CONSTRUCTOR);
            }
            case "hls": {
                return this.createDownloader(downloadRequest0, DefaultDownloaderFactory.HLS_DOWNLOADER_CONSTRUCTOR);
            }
            case "progressive": {
                return new ProgressiveDownloader(downloadRequest0.uri, downloadRequest0.customCacheKey, this.downloaderConstructorHelper);
            }
            case "ss": {
                return this.createDownloader(downloadRequest0, DefaultDownloaderFactory.SS_DOWNLOADER_CONSTRUCTOR);
            }
            default: {
                String s = String.valueOf(downloadRequest0.type);
                throw new IllegalArgumentException((s.length() == 0 ? new String("Unsupported type: ") : "Unsupported type: " + s));
            }
        }
    }

    private static Constructor getDownloaderConstructor(Class class0) {
        try {
            return class0.asSubclass(Downloader.class).getConstructor(Uri.class, List.class, DownloaderConstructorHelper.class);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new RuntimeException("Downloader constructor missing", noSuchMethodException0);
        }
    }
}

