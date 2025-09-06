package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource.Factory;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.UUID;
import jeb.synthetic.FIN;

@TargetApi(18)
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map keyRequestProperties;

    public HttpMediaDrmCallback(String s, Factory httpDataSource$Factory0) {
        this(s, false, httpDataSource$Factory0);
    }

    public HttpMediaDrmCallback(String s, boolean z, Factory httpDataSource$Factory0) {
        this.dataSourceFactory = httpDataSource$Factory0;
        this.defaultLicenseUrl = s;
        this.forceDefaultLicenseUrl = z;
        this.keyRequestProperties = new HashMap();
    }

    public void clearAllKeyRequestProperties() {
        synchronized(this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    public void clearKeyRequestProperty(String s) {
        Assertions.checkNotNull(s);
        synchronized(this.keyRequestProperties) {
            this.keyRequestProperties.remove(s);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uUID0, KeyRequest exoMediaDrm$KeyRequest0) {
        String s1;
        String s = exoMediaDrm$KeyRequest0.getLicenseServerUrl();
        if(this.forceDefaultLicenseUrl || TextUtils.isEmpty(s)) {
            s = this.defaultLicenseUrl;
        }
        HashMap hashMap0 = new HashMap();
        UUID uUID1 = C.PLAYREADY_UUID;
        if(uUID1.equals(uUID0)) {
            s1 = "text/xml";
        }
        else {
            s1 = C.CLEARKEY_UUID.equals(uUID0) ? "application/json" : "application/octet-stream";
        }
        hashMap0.put("Content-Type", s1);
        if(uUID1.equals(uUID0)) {
            hashMap0.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized(this.keyRequestProperties) {
            hashMap0.putAll(this.keyRequestProperties);
        }
        return HttpMediaDrmCallback.executePost(this.dataSourceFactory, s, exoMediaDrm$KeyRequest0.getData(), hashMap0);
    }

    private static byte[] executePost(Factory httpDataSource$Factory0, String s, byte[] arr_b, Map map0) {
        boolean z;
        int v2;
        HttpDataSource httpDataSource0 = httpDataSource$Factory0.createDataSource();
        if(map0 != null) {
            for(Object object0: map0.entrySet()) {
                httpDataSource0.setRequestProperty(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
            }
        }
        String s1 = s;
        for(int v = 0; true; v = v2) {
            DataSourceInputStream dataSourceInputStream0 = new DataSourceInputStream(httpDataSource0, new DataSpec(Uri.parse(s1), 2, arr_b, 0L, 0L, -1L, null, 1));
            try {
                return Util.toByteArray(dataSourceInputStream0);
            }
            catch(InvalidResponseCodeException httpDataSource$InvalidResponseCodeException0) {
            }
            finally {
                Util.closeQuietly(dataSourceInputStream0);
            }
            if(httpDataSource$InvalidResponseCodeException0.responseCode != 307 && httpDataSource$InvalidResponseCodeException0.responseCode != 308) {
                v2 = v;
                z = false;
            }
            else {
                v2 = v + 1;
                z = v < 5;
            }
            String s2 = z ? HttpMediaDrmCallback.getRedirectUrl(httpDataSource$InvalidResponseCodeException0) : null;
            if(s2 == null) {
                break;
            }
            s1 = s2;
        }
        FIN.finallyExec$NT(v1);
        throw httpDataSource$InvalidResponseCodeException0;
    }

    @Override  // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uUID0, ProvisionRequest exoMediaDrm$ProvisionRequest0) {
        String s = Util.fromUtf8Bytes(exoMediaDrm$ProvisionRequest0.getData());
        return HttpMediaDrmCallback.executePost(this.dataSourceFactory, exoMediaDrm$ProvisionRequest0.getDefaultUrl() + "&signedRequest=" + s, null, null);
    }

    private static String getRedirectUrl(InvalidResponseCodeException httpDataSource$InvalidResponseCodeException0) {
        Map map0 = httpDataSource$InvalidResponseCodeException0.headerFields;
        if(map0 != null) {
            List list0 = (List)map0.get("Location");
            return list0 == null || list0.isEmpty() ? null : ((String)list0.get(0));
        }
        return null;
    }

    public void setKeyRequestProperty(String s, String s1) {
        Assertions.checkNotNull(s);
        Assertions.checkNotNull(s1);
        synchronized(this.keyRequestProperties) {
            this.keyRequestProperties.put(s, s1);
        }
    }
}

