package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class OpenSslCertificateCompressionConfig implements Iterable {
    public static final class AlgorithmConfig {
        private final OpenSslCertificateCompressionAlgorithm algorithm;
        private final AlgorithmMode mode;

        private AlgorithmConfig(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm0, AlgorithmMode openSslCertificateCompressionConfig$AlgorithmMode0) {
            this.algorithm = (OpenSslCertificateCompressionAlgorithm)ObjectUtil.checkNotNull(openSslCertificateCompressionAlgorithm0, "algorithm");
            this.mode = (AlgorithmMode)ObjectUtil.checkNotNull(openSslCertificateCompressionConfig$AlgorithmMode0, "mode");
        }

        public AlgorithmConfig(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm0, AlgorithmMode openSslCertificateCompressionConfig$AlgorithmMode0, io.netty.handler.ssl.OpenSslCertificateCompressionConfig.1 openSslCertificateCompressionConfig$10) {
            this(openSslCertificateCompressionAlgorithm0, openSslCertificateCompressionConfig$AlgorithmMode0);
        }

        public OpenSslCertificateCompressionAlgorithm algorithm() {
            return this.algorithm;
        }

        public AlgorithmMode mode() {
            return this.mode;
        }
    }

    public static enum AlgorithmMode {
        Compress,
        Decompress,
        Both;

    }

    public static final class Builder {
        private final List algorithmList;

        private Builder() {
            this.algorithmList = new ArrayList();
        }

        public Builder(io.netty.handler.ssl.OpenSslCertificateCompressionConfig.1 openSslCertificateCompressionConfig$10) {
        }

        public Builder addAlgorithm(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm0, AlgorithmMode openSslCertificateCompressionConfig$AlgorithmMode0) {
            AlgorithmConfig openSslCertificateCompressionConfig$AlgorithmConfig0 = new AlgorithmConfig(openSslCertificateCompressionAlgorithm0, openSslCertificateCompressionConfig$AlgorithmMode0, null);
            this.algorithmList.add(openSslCertificateCompressionConfig$AlgorithmConfig0);
            return this;
        }

        public OpenSslCertificateCompressionConfig build() {
            return new OpenSslCertificateCompressionConfig(((AlgorithmConfig[])this.algorithmList.toArray(new AlgorithmConfig[0])), null);
        }
    }

    private final List pairList;

    private OpenSslCertificateCompressionConfig(AlgorithmConfig[] arr_openSslCertificateCompressionConfig$AlgorithmConfig) {
        this.pairList = Collections.unmodifiableList(Arrays.asList(arr_openSslCertificateCompressionConfig$AlgorithmConfig));
    }

    public OpenSslCertificateCompressionConfig(AlgorithmConfig[] arr_openSslCertificateCompressionConfig$AlgorithmConfig, io.netty.handler.ssl.OpenSslCertificateCompressionConfig.1 openSslCertificateCompressionConfig$10) {
        this(arr_openSslCertificateCompressionConfig$AlgorithmConfig);
    }

    @Override
    public Iterator iterator() {
        return this.pairList.iterator();
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    class io.netty.handler.ssl.OpenSslCertificateCompressionConfig.1 {
    }

}

