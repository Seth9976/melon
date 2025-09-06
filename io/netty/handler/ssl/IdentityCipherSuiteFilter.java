package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class IdentityCipherSuiteFilter implements CipherSuiteFilter {
    public static final IdentityCipherSuiteFilter INSTANCE;
    public static final IdentityCipherSuiteFilter INSTANCE_DEFAULTING_TO_SUPPORTED_CIPHERS;
    private final boolean defaultToDefaultCiphers;

    static {
        IdentityCipherSuiteFilter.INSTANCE = new IdentityCipherSuiteFilter(true);
        IdentityCipherSuiteFilter.INSTANCE_DEFAULTING_TO_SUPPORTED_CIPHERS = new IdentityCipherSuiteFilter(false);
    }

    private IdentityCipherSuiteFilter(boolean z) {
        this.defaultToDefaultCiphers = z;
    }

    @Override  // io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable iterable0, List list0, Set set0) {
        if(iterable0 == null) {
            return this.defaultToDefaultCiphers ? ((String[])list0.toArray(EmptyArrays.EMPTY_STRINGS)) : ((String[])set0.toArray(EmptyArrays.EMPTY_STRINGS));
        }
        ArrayList arrayList0 = new ArrayList(set0.size());
        for(Object object0: iterable0) {
            if(((String)object0) == null) {
                break;
            }
            arrayList0.add(((String)object0));
        }
        return (String[])arrayList0.toArray(EmptyArrays.EMPTY_STRINGS);
    }
}

