package io.netty.handler.ssl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

final class OpenSslKeyMaterialManager {
    private static final Map KEY_TYPES = null;
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final String KEY_TYPE_RSA = "RSA";
    private final OpenSslKeyMaterialProvider provider;

    static {
        HashMap hashMap0 = new HashMap();
        OpenSslKeyMaterialManager.KEY_TYPES = hashMap0;
        hashMap0.put("RSA", "RSA");
        hashMap0.put("DHE_RSA", "RSA");
        hashMap0.put("ECDHE_RSA", "RSA");
        hashMap0.put("ECDHE_ECDSA", "EC");
        hashMap0.put("ECDH_RSA", "EC_RSA");
        hashMap0.put("ECDH_ECDSA", "EC_EC");
        hashMap0.put("DH_RSA", "DH_RSA");
    }

    public OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider openSslKeyMaterialProvider0) {
        this.provider = openSslKeyMaterialProvider0;
    }

    private String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, String[] arr_s, X500Principal[] arr_x500Principal) {
        X509KeyManager x509KeyManager0 = this.provider.keyManager();
        return x509KeyManager0 instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager)x509KeyManager0).chooseEngineClientAlias(arr_s, arr_x500Principal, referenceCountedOpenSslEngine0) : x509KeyManager0.chooseClientAlias(arr_s, arr_x500Principal, null);
    }

    private String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, String s) {
        X509KeyManager x509KeyManager0 = this.provider.keyManager();
        return x509KeyManager0 instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager)x509KeyManager0).chooseEngineServerAlias(s, null, referenceCountedOpenSslEngine0) : x509KeyManager0.chooseServerAlias(s, null, null);
    }

    private void setKeyMaterial(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, String s) {
        OpenSslKeyMaterial openSslKeyMaterial0;
        try {
            try {
                openSslKeyMaterial0 = null;
                openSslKeyMaterial0 = this.provider.chooseKeyMaterial(referenceCountedOpenSslEngine0.alloc, s);
                if(openSslKeyMaterial0 == null) {
                    return;
                }
                referenceCountedOpenSslEngine0.setKeyMaterial(openSslKeyMaterial0);
            }
            catch(SSLException sSLException0) {
                throw sSLException0;
            }
            catch(Exception exception0) {
                throw new SSLException(exception0);
            }
        }
        catch(Throwable throwable0) {
            if(openSslKeyMaterial0 != null) {
                openSslKeyMaterial0.release();
            }
            throw throwable0;
        }
        openSslKeyMaterial0.release();
    }

    public void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, String[] arr_s, X500Principal[] arr_x500Principal) {
        String s = this.chooseClientAlias(referenceCountedOpenSslEngine0, arr_s, arr_x500Principal);
        if(s != null) {
            this.setKeyMaterial(referenceCountedOpenSslEngine0, s);
        }
    }

    public void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0) {
        String[] arr_s = referenceCountedOpenSslEngine0.authMethods();
        if(arr_s.length == 0) {
            throw new SSLHandshakeException("Unable to find key material");
        }
        HashSet hashSet0 = new HashSet(OpenSslKeyMaterialManager.KEY_TYPES.size());
        for(int v = 0; v < arr_s.length; ++v) {
            String s = (String)OpenSslKeyMaterialManager.KEY_TYPES.get(arr_s[v]);
            if(s != null && hashSet0.add(s)) {
                String s1 = this.chooseServerAlias(referenceCountedOpenSslEngine0, s);
                if(s1 != null) {
                    this.setKeyMaterial(referenceCountedOpenSslEngine0, s1);
                    return;
                }
            }
        }
        throw new SSLHandshakeException("Unable to find key material for auth method(s): " + Arrays.toString(arr_s));
    }
}

