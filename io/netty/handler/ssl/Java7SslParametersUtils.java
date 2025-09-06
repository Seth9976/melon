package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

final class Java7SslParametersUtils {
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void setAlgorithmConstraints(SSLParameters sSLParameters0, Object object0) {
        sSLParameters0.setAlgorithmConstraints(((AlgorithmConstraints)object0));
    }
}

