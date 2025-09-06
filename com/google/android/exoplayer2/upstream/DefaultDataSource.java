package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource implements DataSource {
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    private static final String SCHEME_UDP = "udp";
    private static final String TAG = "DefaultDataSource";
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSchemeDataSource;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private DataSource rawResourceDataSource;
    private DataSource rtmpDataSource;
    private final List transferListeners;
    private DataSource udpDataSource;

    public DefaultDataSource(Context context0, DataSource dataSource0) {
        this.context = context0.getApplicationContext();
        this.baseDataSource = (DataSource)Assertions.checkNotNull(dataSource0);
        this.transferListeners = new ArrayList();
    }

    public DefaultDataSource(Context context0, String s, int v, int v1, boolean z) {
        this(context0, new DefaultHttpDataSource(s, v, v1, z, null));
    }

    public DefaultDataSource(Context context0, String s, boolean z) {
        this(context0, s, 8000, 8000, z);
    }

    private void addListenersToDataSource(DataSource dataSource0) {
        for(int v = 0; v < this.transferListeners.size(); ++v) {
            dataSource0.addTransferListener(((TransferListener)this.transferListeners.get(v)));
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.baseDataSource.addTransferListener(transferListener0);
        this.transferListeners.add(transferListener0);
        this.maybeAddListenerToDataSource(this.fileDataSource, transferListener0);
        this.maybeAddListenerToDataSource(this.assetDataSource, transferListener0);
        this.maybeAddListenerToDataSource(this.contentDataSource, transferListener0);
        this.maybeAddListenerToDataSource(this.rtmpDataSource, transferListener0);
        this.maybeAddListenerToDataSource(this.udpDataSource, transferListener0);
        this.maybeAddListenerToDataSource(this.dataSchemeDataSource, transferListener0);
        this.maybeAddListenerToDataSource(this.rawResourceDataSource, transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        DataSource dataSource0 = this.dataSource;
        if(dataSource0 != null) {
            try {
                dataSource0.close();
                this.dataSource = null;
            }
            catch(Throwable throwable0) {
                this.dataSource = null;
                throw throwable0;
            }
        }
    }

    private DataSource getAssetDataSource() {
        if(this.assetDataSource == null) {
            AssetDataSource assetDataSource0 = new AssetDataSource(this.context);
            this.assetDataSource = assetDataSource0;
            this.addListenersToDataSource(assetDataSource0);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        if(this.contentDataSource == null) {
            ContentDataSource contentDataSource0 = new ContentDataSource(this.context);
            this.contentDataSource = contentDataSource0;
            this.addListenersToDataSource(contentDataSource0);
        }
        return this.contentDataSource;
    }

    private DataSource getDataSchemeDataSource() {
        if(this.dataSchemeDataSource == null) {
            DataSchemeDataSource dataSchemeDataSource0 = new DataSchemeDataSource();
            this.dataSchemeDataSource = dataSchemeDataSource0;
            this.addListenersToDataSource(dataSchemeDataSource0);
        }
        return this.dataSchemeDataSource;
    }

    private DataSource getFileDataSource() {
        if(this.fileDataSource == null) {
            FileDataSource fileDataSource0 = new FileDataSource();
            this.fileDataSource = fileDataSource0;
            this.addListenersToDataSource(fileDataSource0);
        }
        return this.fileDataSource;
    }

    private DataSource getRawResourceDataSource() {
        if(this.rawResourceDataSource == null) {
            RawResourceDataSource rawResourceDataSource0 = new RawResourceDataSource(this.context);
            this.rawResourceDataSource = rawResourceDataSource0;
            this.addListenersToDataSource(rawResourceDataSource0);
        }
        return this.rawResourceDataSource;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.dataSource == null ? Collections.EMPTY_MAP : this.dataSource.getResponseHeaders();
    }

    private DataSource getRtmpDataSource() {
        if(this.rtmpDataSource == null) {
            try {
                DataSource dataSource0 = (DataSource)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.rtmpDataSource = dataSource0;
                this.addListenersToDataSource(dataSource0);
            }
            catch(ClassNotFoundException unused_ex) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            }
            catch(Exception exception0) {
                throw new RuntimeException("Error instantiating RTMP extension", exception0);
            }
            if(this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    private DataSource getUdpDataSource() {
        if(this.udpDataSource == null) {
            UdpDataSource udpDataSource0 = new UdpDataSource();
            this.udpDataSource = udpDataSource0;
            this.addListenersToDataSource(udpDataSource0);
        }
        return this.udpDataSource;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.dataSource == null ? null : this.dataSource.getUri();
    }

    private void maybeAddListenerToDataSource(DataSource dataSource0, TransferListener transferListener0) {
        if(dataSource0 != null) {
            dataSource0.addTransferListener(transferListener0);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        Assertions.checkState(this.dataSource == null);
        String s = dataSpec0.uri.getScheme();
        if(Util.isLocalFileUri(dataSpec0.uri)) {
            String s1 = dataSpec0.uri.getPath();
            if(s1 != null && s1.startsWith("/android_asset/")) {
                this.dataSource = this.getAssetDataSource();
                return this.dataSource.open(dataSpec0);
            }
            this.dataSource = this.getFileDataSource();
            return this.dataSource.open(dataSpec0);
        }
        if("asset".equals(s)) {
            this.dataSource = this.getAssetDataSource();
            return this.dataSource.open(dataSpec0);
        }
        if("content".equals(s)) {
            this.dataSource = this.getContentDataSource();
            return this.dataSource.open(dataSpec0);
        }
        if("rtmp".equals(s)) {
            this.dataSource = this.getRtmpDataSource();
            return this.dataSource.open(dataSpec0);
        }
        if("udp".equals(s)) {
            this.dataSource = this.getUdpDataSource();
            return this.dataSource.open(dataSpec0);
        }
        if("data".equals(s)) {
            this.dataSource = this.getDataSchemeDataSource();
            return this.dataSource.open(dataSpec0);
        }
        if("rawresource".equals(s)) {
            this.dataSource = this.getRawResourceDataSource();
            return this.dataSource.open(dataSpec0);
        }
        this.dataSource = this.baseDataSource;
        return this.dataSource.open(dataSpec0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        return ((DataSource)Assertions.checkNotNull(this.dataSource)).read(arr_b, v, v1);
    }
}

