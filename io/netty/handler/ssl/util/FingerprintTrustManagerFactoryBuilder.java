package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FingerprintTrustManagerFactoryBuilder {
    private final String algorithm;
    private final List fingerprints;

    public FingerprintTrustManagerFactoryBuilder(String s) {
        this.fingerprints = new ArrayList();
        this.algorithm = (String)ObjectUtil.checkNotNull(s, "algorithm");
    }

    public FingerprintTrustManagerFactory build() {
        if(this.fingerprints.isEmpty()) {
            throw new IllegalStateException("No fingerprints provided");
        }
        byte[][] arr2_b = FingerprintTrustManagerFactory.toFingerprintArray(this.fingerprints);
        return new FingerprintTrustManagerFactory(this.algorithm, arr2_b);
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(Iterable iterable0) {
        ObjectUtil.checkNotNull(iterable0, "fingerprints");
        for(Object object0: iterable0) {
            ObjectUtil.checkNotNullWithIAE(((CharSequence)object0), "fingerprint");
            this.fingerprints.add(((CharSequence)object0).toString());
        }
        return this;
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(CharSequence[] arr_charSequence) {
        return this.fingerprints(Arrays.asList(((Object[])ObjectUtil.checkNotNull(arr_charSequence, "fingerprints"))));
    }
}

