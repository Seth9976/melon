package okhttp3;

import H0.b;
import ie.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import le.a;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0002,+B9\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0013J\u000F\u0010\u0004\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u0002H\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001F\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u000B\u00A2\u0006\u0004\b\u001F\u0010 J\u001A\u0010\"\u001A\u00020\u00022\b\u0010!\u001A\u0004\u0018\u00010\u0001H\u0096\u0002\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0016\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\'\u0010(R\u0017\u0010\u0003\u001A\u00020\u00028\u0007\u00A2\u0006\f\n\u0004\b\u0003\u0010)\u001A\u0004\b\u0003\u0010\u0019R\u0017\u0010\u0004\u001A\u00020\u00028\u0007\u00A2\u0006\f\n\u0004\b\u0004\u0010)\u001A\u0004\b\u0004\u0010\u0019R\u001C\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010*R\u001C\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010*R\u0019\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108G\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u0013R\u0019\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00108G\u00A2\u0006\u0006\u001A\u0004\b\u0017\u0010\u0013\u00A8\u0006-"}, d2 = {"Lokhttp3/ConnectionSpec;", "", "", "isTls", "supportsTlsExtensions", "", "", "cipherSuitesAsString", "tlsVersionsAsString", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "supportedSpec", "(Ljavax/net/ssl/SSLSocket;Z)Lokhttp3/ConnectionSpec;", "", "Lokhttp3/CipherSuite;", "-deprecated_cipherSuites", "()Ljava/util/List;", "cipherSuites", "Lokhttp3/TlsVersion;", "-deprecated_tlsVersions", "tlsVersions", "-deprecated_supportsTlsExtensions", "()Z", "Lie/H;", "apply$okhttp", "(Ljavax/net/ssl/SSLSocket;Z)V", "apply", "socket", "isCompatible", "(Ljavax/net/ssl/SSLSocket;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Z", "[Ljava/lang/String;", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ConnectionSpec {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000F\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001A\u00020\u0000J\u0006\u0010\u001A\u001A\u00020\u0000J\u0006\u0010\u001B\u001A\u00020\u0006J\u001F\u0010\b\u001A\u00020\u00002\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u001CJ\u001F\u0010\b\u001A\u00020\u00002\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u001D0\t\"\u00020\u001D¢\u0006\u0002\u0010\u001EJ\u0010\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0003H\u0007J\u001F\u0010\u0016\u001A\u00020\u00002\u0012\u0010\u0016\u001A\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u001CJ\u001F\u0010\u0016\u001A\u00020\u00002\u0012\u0010\u0016\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u001F0\t\"\u00020\u001F¢\u0006\u0002\u0010 R$\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001A\u0010\u0002\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000E¨\u0006!"}, d2 = {"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", "build", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @Nullable
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        @Nullable
        private String[] tlsVersions;

        public Builder(@NotNull ConnectionSpec connectionSpec0) {
            q.g(connectionSpec0, "connectionSpec");
            super();
            this.tls = connectionSpec0.isTls();
            this.cipherSuites = connectionSpec0.cipherSuitesAsString;
            this.tlsVersions = connectionSpec0.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec0.supportsTlsExtensions();
        }

        public Builder(boolean z) {
            this.tls = z;
        }

        @NotNull
        public final Builder allEnabledCipherSuites() {
            if(!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            this.cipherSuites = null;
            return this;
        }

        @NotNull
        public final Builder allEnabledTlsVersions() {
            if(!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            this.tlsVersions = null;
            return this;
        }

        @NotNull
        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        @NotNull
        public final Builder cipherSuites(@NotNull String[] arr_s) {
            q.g(arr_s, "cipherSuites");
            if(!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            if(arr_s.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.cipherSuites = (String[])arr_s.clone();
            return this;
        }

        @NotNull
        public final Builder cipherSuites(@NotNull CipherSuite[] arr_cipherSuite) {
            q.g(arr_cipherSuite, "cipherSuites");
            if(!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList0 = new ArrayList(arr_cipherSuite.length);
            for(int v = 0; v < arr_cipherSuite.length; ++v) {
                arrayList0.add(arr_cipherSuite[v].javaName());
            }
            String[] arr_s = (String[])arrayList0.toArray(new String[0]);
            return this.cipherSuites(((String[])Arrays.copyOf(arr_s, arr_s.length)));
        }

        @Nullable
        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        @Nullable
        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(@Nullable String[] arr_s) {
            this.cipherSuites = arr_s;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z) {
            this.supportsTlsExtensions = z;
        }

        public final void setTls$okhttp(boolean z) {
            this.tls = z;
        }

        public final void setTlsVersions$okhttp(@Nullable String[] arr_s) {
            this.tlsVersions = arr_s;
        }

        @d
        @NotNull
        public final Builder supportsTlsExtensions(boolean z) {
            if(!this.tls) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = z;
            return this;
        }

        @NotNull
        public final Builder tlsVersions(@NotNull String[] arr_s) {
            q.g(arr_s, "tlsVersions");
            if(!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            if(arr_s.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.tlsVersions = (String[])arr_s.clone();
            return this;
        }

        @NotNull
        public final Builder tlsVersions(@NotNull TlsVersion[] arr_tlsVersion) {
            q.g(arr_tlsVersion, "tlsVersions");
            if(!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList0 = new ArrayList(arr_tlsVersion.length);
            for(int v = 0; v < arr_tlsVersion.length; ++v) {
                arrayList0.add(arr_tlsVersion[v].javaName());
            }
            String[] arr_s = (String[])arrayList0.toArray(new String[0]);
            return this.tlsVersions(((String[])Arrays.copyOf(arr_s, arr_s.length)));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/ConnectionSpec$Companion;", "", "()V", "APPROVED_CIPHER_SUITES", "", "Lokhttp3/CipherSuite;", "[Lokhttp3/CipherSuite;", "CLEARTEXT", "Lokhttp3/ConnectionSpec;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    @NotNull
    public static final ConnectionSpec CLEARTEXT;
    @NotNull
    public static final ConnectionSpec COMPATIBLE_TLS;
    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final ConnectionSpec MODERN_TLS;
    @NotNull
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES;
    @NotNull
    public static final ConnectionSpec RESTRICTED_TLS;
    @Nullable
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    @Nullable
    private final String[] tlsVersionsAsString;

    @d
    @Nullable
    public final List -deprecated_cipherSuites() {
        return this.cipherSuites();
    }

    @d
    public final boolean -deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @d
    @Nullable
    public final List -deprecated_tlsVersions() {
        return this.tlsVersions();
    }

    static {
        ConnectionSpec.Companion = new Companion(null);
        CipherSuite[] arr_cipherSuite = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
        ConnectionSpec.RESTRICTED_CIPHER_SUITES = arr_cipherSuite;
        CipherSuite[] arr_cipherSuite1 = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        ConnectionSpec.APPROVED_CIPHER_SUITES = arr_cipherSuite1;
        ConnectionSpec.RESTRICTED_TLS = new Builder(true).cipherSuites(((CipherSuite[])Arrays.copyOf(arr_cipherSuite, 9))).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        ConnectionSpec.MODERN_TLS = new Builder(true).cipherSuites(((CipherSuite[])Arrays.copyOf(arr_cipherSuite1, 16))).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2}).supportsTlsExtensions(true).build();
        ConnectionSpec.COMPATIBLE_TLS = new Builder(true).cipherSuites(((CipherSuite[])Arrays.copyOf(arr_cipherSuite1, 16))).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0}).supportsTlsExtensions(true).build();
        ConnectionSpec.CLEARTEXT = new Builder(false).build();
    }

    public ConnectionSpec(boolean z, boolean z1, @Nullable String[] arr_s, @Nullable String[] arr_s1) {
        this.isTls = z;
        this.supportsTlsExtensions = z1;
        this.cipherSuitesAsString = arr_s;
        this.tlsVersionsAsString = arr_s1;
    }

    public final void apply$okhttp(@NotNull SSLSocket sSLSocket0, boolean z) {
        q.g(sSLSocket0, "sslSocket");
        ConnectionSpec connectionSpec0 = this.supportedSpec(sSLSocket0, z);
        if(connectionSpec0.tlsVersions() != null) {
            sSLSocket0.setEnabledProtocols(connectionSpec0.tlsVersionsAsString);
        }
        if(connectionSpec0.cipherSuites() != null) {
            sSLSocket0.setEnabledCipherSuites(connectionSpec0.cipherSuitesAsString);
        }
    }

    @Nullable
    public final List cipherSuites() {
        String[] arr_s = this.cipherSuitesAsString;
        if(arr_s != null) {
            ArrayList arrayList0 = new ArrayList(arr_s.length);
            for(int v = 0; v < arr_s.length; ++v) {
                arrayList0.add(CipherSuite.Companion.forJavaName(arr_s[v]));
            }
            return p.P0(arrayList0);
        }
        return null;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(!(object0 instanceof ConnectionSpec)) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        boolean z = this.isTls;
        if(z != ((ConnectionSpec)object0).isTls) {
            return false;
        }
        if(z) {
            if(!Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec)object0).cipherSuitesAsString)) {
                return false;
            }
            return Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec)object0).tlsVersionsAsString) ? this.supportsTlsExtensions == ((ConnectionSpec)object0).supportsTlsExtensions : false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if(this.isTls) {
            int v = 0;
            int v1 = this.cipherSuitesAsString == null ? 0 : Arrays.hashCode(this.cipherSuitesAsString);
            String[] arr_s = this.tlsVersionsAsString;
            if(arr_s != null) {
                v = Arrays.hashCode(arr_s);
            }
            return ((v1 + 0x20F) * 0x1F + v) * 0x1F + !this.supportsTlsExtensions;
        }
        return 17;
    }

    public final boolean isCompatible(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "socket");
        if(!this.isTls) {
            return false;
        }
        return this.tlsVersionsAsString == null || Util.hasIntersection(this.tlsVersionsAsString, sSLSocket0.getEnabledProtocols(), a.b) ? this.cipherSuitesAsString == null || Util.hasIntersection(this.cipherSuitesAsString, sSLSocket0.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp()) : false;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    private final ConnectionSpec supportedSpec(SSLSocket sSLSocket0, boolean z) {
        String[] arr_s3;
        String[] arr_s1;
        if(this.cipherSuitesAsString == null) {
            arr_s1 = sSLSocket0.getEnabledCipherSuites();
        }
        else {
            String[] arr_s = sSLSocket0.getEnabledCipherSuites();
            q.f(arr_s, "sslSocket.enabledCipherSuites");
            arr_s1 = Util.intersect(arr_s, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        }
        if(this.tlsVersionsAsString == null) {
            arr_s3 = sSLSocket0.getEnabledProtocols();
        }
        else {
            String[] arr_s2 = sSLSocket0.getEnabledProtocols();
            q.f(arr_s2, "sslSocket.enabledProtocols");
            arr_s3 = Util.intersect(arr_s2, this.tlsVersionsAsString, a.b);
        }
        String[] arr_s4 = sSLSocket0.getSupportedCipherSuites();
        q.f(arr_s4, "supportedCipherSuites");
        int v = Util.indexOf(arr_s4, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if(z && v != -1) {
            q.f(arr_s1, "cipherSuitesIntersection");
            String s = arr_s4[v];
            q.f(s, "supportedCipherSuites[indexOfFallbackScsv]");
            arr_s1 = Util.concat(arr_s1, s);
        }
        Builder connectionSpec$Builder0 = new Builder(this);
        q.f(arr_s1, "cipherSuitesIntersection");
        Builder connectionSpec$Builder1 = connectionSpec$Builder0.cipherSuites(((String[])Arrays.copyOf(arr_s1, arr_s1.length)));
        q.f(arr_s3, "tlsVersionsIntersection");
        return connectionSpec$Builder1.tlsVersions(((String[])Arrays.copyOf(arr_s3, arr_s3.length))).build();
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @Nullable
    public final List tlsVersions() {
        String[] arr_s = this.tlsVersionsAsString;
        if(arr_s != null) {
            ArrayList arrayList0 = new ArrayList(arr_s.length);
            for(int v = 0; v < arr_s.length; ++v) {
                arrayList0.add(TlsVersion.Companion.forJavaName(arr_s[v]));
            }
            return p.P0(arrayList0);
        }
        return null;
    }

    @Override
    @NotNull
    public String toString() {
        if(!this.isTls) {
            return "ConnectionSpec()";
        }
        StringBuilder stringBuilder0 = new StringBuilder("ConnectionSpec(cipherSuites=");
        stringBuilder0.append(Objects.toString(this.cipherSuites(), "[all enabled]"));
        stringBuilder0.append(", tlsVersions=");
        stringBuilder0.append(Objects.toString(this.tlsVersions(), "[all enabled]"));
        stringBuilder0.append(", supportsTlsExtensions=");
        return b.k(stringBuilder0, this.supportsTlsExtensions, ')');
    }
}

