package io.netty.handler.ssl;

import java.util.List;
import java.util.Set;

public interface CipherSuiteFilter {
    String[] filterCipherSuites(Iterable arg1, List arg2, Set arg3);
}

