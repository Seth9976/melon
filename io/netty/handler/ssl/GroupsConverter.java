package io.netty.handler.ssl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class GroupsConverter {
    private static final Map mappings;

    static {
        HashMap hashMap0 = new HashMap();
        hashMap0.put("secp224r1", "P-224");
        hashMap0.put("prime256v1", "P-256");
        hashMap0.put("secp256r1", "P-256");
        hashMap0.put("secp384r1", "P-384");
        hashMap0.put("secp521r1", "P-521");
        hashMap0.put("x25519", "X25519");
        GroupsConverter.mappings = Collections.unmodifiableMap(hashMap0);
    }

    public static String toOpenSsl(String s) {
        String s1 = (String)GroupsConverter.mappings.get(s);
        return s1 == null ? s : s1;
    }
}

