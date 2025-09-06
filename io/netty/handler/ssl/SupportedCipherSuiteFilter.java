package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class SupportedCipherSuiteFilter implements CipherSuiteFilter {
    public static final SupportedCipherSuiteFilter INSTANCE;

    static {
        SupportedCipherSuiteFilter.INSTANCE = new SupportedCipherSuiteFilter();
    }

    @Override  // io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable iterable0, List list0, Set set0) {
        ArrayList arrayList0;
        ObjectUtil.checkNotNull(list0, "defaultCiphers");
        ObjectUtil.checkNotNull(set0, "supportedCiphers");
        if(iterable0 == null) {
            arrayList0 = new ArrayList(list0.size());
            iterable0 = list0;
        }
        else {
            arrayList0 = new ArrayList(set0.size());
        }
        for(Object object0: iterable0) {
            String s = (String)object0;
            if(s == null) {
                break;
            }
            if(set0.contains(s)) {
                arrayList0.add(s);
            }
        }
        return (String[])arrayList0.toArray(EmptyArrays.EMPTY_STRINGS);
    }
}

