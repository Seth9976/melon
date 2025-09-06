package okhttp3;

import Tf.o;
import Tf.v;
import U4.x;
import ie.d;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import je.n;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 *2\u00020\u0001:\u0003+*,B#\b\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\u000F\u0010\u0010J+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\t2\u0012\u0010\u0013\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000B0\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\t2\u0012\u0010\r\u001A\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0016\"\u00020\fH\u0007¢\u0006\u0004\b\u000F\u0010\u0017J\u001B\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001A\u0004\b%\u0010&R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\'\u001A\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lokhttp3/CertificatePinner;", "", "", "Lokhttp3/CertificatePinner$Pin;", "pins", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lie/H;", "check", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "check$okhttp", "(Ljava/lang/String;Lwe/a;)V", "", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "findMatchingPins", "(Ljava/lang/String;)Ljava/util/List;", "withCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "Companion", "Builder", "Pin", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CertificatePinner {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\'\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\n2\u0012\u0010\u0003\u001A\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000B\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001A\u00020\u000ER\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private final List pins;

        public Builder() {
            this.pins = new ArrayList();
        }

        @NotNull
        public final Builder add(@NotNull String s, @NotNull String[] arr_s) {
            q.g(s, "pattern");
            q.g(arr_s, "pins");
            for(int v = 0; v < arr_s.length; ++v) {
                Pin certificatePinner$Pin0 = new Pin(s, arr_s[v]);
                this.pins.add(certificatePinner$Pin0);
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(p.T0(this.pins), null, 2, null);
        }

        @NotNull
        public final List getPins() {
            return this.pins;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007J\f\u0010\t\u001A\u00020\n*\u00020\u000BH\u0007J\f\u0010\f\u001A\u00020\n*\u00020\u000BH\u0007R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String pin(@NotNull Certificate certificate0) {
            q.g(certificate0, "certificate");
            if(!(certificate0 instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + this.sha256Hash(((X509Certificate)certificate0)).base64();
        }

        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate x509Certificate0) {
            q.g(x509Certificate0, "<this>");
            byte[] arr_b = x509Certificate0.getPublicKey().getEncoded();
            q.f(arr_b, "publicKey.encoded");
            return okio.ByteString.Companion.of$default(ByteString.Companion, arr_b, 0, 0, 3, null).sha1();
        }

        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate x509Certificate0) {
            q.g(x509Certificate0, "<this>");
            byte[] arr_b = x509Certificate0.getPublicKey().getEncoded();
            q.f(arr_b, "publicKey.encoded");
            return okio.ByteString.Companion.of$default(ByteString.Companion, arr_b, 0, 0, 3, null).sha256();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u000E\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0015J\u000E\u0010\u0016\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u0003J\b\u0010\u0018\u001A\u00020\u0003H\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", "other", "hashCode", "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", "toString", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Pin {
        @NotNull
        private final ByteString hash;
        @NotNull
        private final String hashAlgorithm;
        @NotNull
        private final String pattern;

        public Pin(@NotNull String s, @NotNull String s1) {
            q.g(s, "pattern");
            q.g(s1, "pin");
            super();
            if((!v.r0(s, "*.", false) || o.F0(s, "*", 1, false, 4) != -1) && (!v.r0(s, "**.", false) || o.F0(s, "*", 2, false, 4) != -1) && o.F0(s, "*", 0, false, 6) != -1) {
                throw new IllegalArgumentException(("Unexpected pattern: " + s).toString());
            }
            String s2 = HostnamesKt.toCanonicalHost(s);
            if(s2 == null) {
                throw new IllegalArgumentException("Invalid pattern: " + s);
            }
            this.pattern = s2;
            if(v.r0(s1, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                String s3 = s1.substring(5);
                q.f(s3, "this as java.lang.String).substring(startIndex)");
                ByteString byteString0 = ByteString.Companion.decodeBase64(s3);
                if(byteString0 == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + s1);
                }
                this.hash = byteString0;
                return;
            }
            if(!v.r0(s1, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with \'sha256/\' or \'sha1/\': " + s1);
            }
            this.hashAlgorithm = "sha256";
            String s4 = s1.substring(7);
            q.f(s4, "this as java.lang.String).substring(startIndex)");
            ByteString byteString1 = ByteString.Companion.decodeBase64(s4);
            if(byteString1 == null) {
                throw new IllegalArgumentException("Invalid pin hash: " + s1);
            }
            this.hash = byteString1;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Pin)) {
                return false;
            }
            if(!q.b(this.pattern, ((Pin)object0).pattern)) {
                return false;
            }
            return q.b(this.hashAlgorithm, ((Pin)object0).hashAlgorithm) ? q.b(this.hash, ((Pin)object0).hash) : false;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        @Override
        public int hashCode() {
            return this.hash.hashCode() + x.b(this.pattern.hashCode() * 0x1F, 0x1F, this.hashAlgorithm);
        }

        public final boolean matchesCertificate(@NotNull X509Certificate x509Certificate0) {
            q.g(x509Certificate0, "certificate");
            String s = this.hashAlgorithm;
            if(q.b(s, "sha256")) {
                ByteString byteString0 = CertificatePinner.Companion.sha256Hash(x509Certificate0);
                return q.b(this.hash, byteString0);
            }
            if(q.b(s, "sha1")) {
                ByteString byteString1 = CertificatePinner.Companion.sha1Hash(x509Certificate0);
                return q.b(this.hash, byteString1);
            }
            return false;
        }

        public final boolean matchesHostname(@NotNull String s) {
            q.g(s, "hostname");
            if(v.r0(this.pattern, "**.", false)) {
                int v = this.pattern.length();
                int v1 = s.length() - (v - 3);
                return v.m0(s.length() - (v - 3), 3, v - 3, s, this.pattern, false) && (v1 == 0 || s.charAt(v1 - 1) == 46);
            }
            if(v.r0(this.pattern, "*.", false)) {
                int v2 = this.pattern.length();
                return v.m0(s.length() - (v2 - 1), 1, v2 - 1, s, this.pattern, false) && o.J0(s, '.', s.length() - (v2 - 1) - 1, 4) == -1;
            }
            return s.equals(this.pattern);
        }

        @Override
        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final CertificatePinner DEFAULT;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    @NotNull
    private final Set pins;

    static {
        CertificatePinner.Companion = new Companion(null);
        CertificatePinner.DEFAULT = new Builder().build();
    }

    public CertificatePinner(@NotNull Set set0, @Nullable CertificateChainCleaner certificateChainCleaner0) {
        q.g(set0, "pins");
        super();
        this.pins = set0;
        this.certificateChainCleaner = certificateChainCleaner0;
    }

    public CertificatePinner(Set set0, CertificateChainCleaner certificateChainCleaner0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            certificateChainCleaner0 = null;
        }
        this(set0, certificateChainCleaner0);
    }

    public final void check(@NotNull String s, @NotNull List list0) {
        q.g(s, "hostname");
        q.g(list0, "peerCertificates");
        this.check$okhttp(s, new a(list0, s) {
            final String $hostname;
            final List $peerCertificates;

            {
                CertificatePinner.this = certificatePinner0;
                this.$peerCertificates = list0;
                this.$hostname = s;
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }

            @NotNull
            public final List invoke() {
                List list0;
                CertificateChainCleaner certificateChainCleaner0 = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                if(certificateChainCleaner0 == null) {
                    list0 = this.$peerCertificates;
                }
                else {
                    list0 = certificateChainCleaner0.clean(this.$peerCertificates, this.$hostname);
                    if(list0 == null) {
                        list0 = this.$peerCertificates;
                    }
                }
                List list1 = new ArrayList(je.q.Q(10, list0));
                for(Object object0: list0) {
                    q.e(((Certificate)object0), "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    list1.add(((X509Certificate)(((Certificate)object0))));
                }
                return list1;
            }
        });
    }

    @d
    public final void check(@NotNull String s, @NotNull Certificate[] arr_certificate) {
        q.g(s, "hostname");
        q.g(arr_certificate, "peerCertificates");
        this.check(s, n.z0(arr_certificate));
    }

    public final void check$okhttp(@NotNull String s, @NotNull a a0) {
        q.g(s, "hostname");
        q.g(a0, "cleanedPeerCertificatesFn");
        List list0 = this.findMatchingPins(s);
        if(!list0.isEmpty()) {
            List list1 = (List)a0.invoke();
            for(Object object0: list1) {
                X509Certificate x509Certificate0 = (X509Certificate)object0;
                ByteString byteString0 = null;
                ByteString byteString1 = null;
                Iterator iterator1 = list0.iterator();
            label_12:
                if(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    Pin certificatePinner$Pin0 = (Pin)object1;
                    String s1 = certificatePinner$Pin0.getHashAlgorithm();
                    if(q.b(s1, "sha256")) {
                        if(byteString0 == null) {
                            byteString0 = CertificatePinner.Companion.sha256Hash(x509Certificate0);
                        }
                        if(!q.b(certificatePinner$Pin0.getHash(), byteString0)) {
                            goto label_12;
                        }
                    }
                    else {
                        if(!q.b(s1, "sha1")) {
                            throw new AssertionError("unsupported hashAlgorithm: " + certificatePinner$Pin0.getHashAlgorithm());
                        }
                        if(byteString1 == null) {
                            byteString1 = CertificatePinner.Companion.sha1Hash(x509Certificate0);
                        }
                        if(!q.b(certificatePinner$Pin0.getHash(), byteString1)) {
                            goto label_12;
                        }
                    }
                    return;
                }
            }
            StringBuilder stringBuilder0 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            for(Object object2: list1) {
                stringBuilder0.append("\n    ");
                stringBuilder0.append(CertificatePinner.Companion.pin(((X509Certificate)object2)));
                stringBuilder0.append(": ");
                stringBuilder0.append(((X509Certificate)object2).getSubjectDN().getName());
            }
            stringBuilder0.append("\n  Pinned certificates for ");
            stringBuilder0.append(s);
            stringBuilder0.append(":");
            for(Object object3: list0) {
                stringBuilder0.append("\n    ");
                stringBuilder0.append(((Pin)object3));
            }
            String s2 = stringBuilder0.toString();
            q.f(s2, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(s2);
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof CertificatePinner && q.b(((CertificatePinner)object0).pins, this.pins) && q.b(((CertificatePinner)object0).certificateChainCleaner, this.certificateChainCleaner);
    }

    @NotNull
    public final List findMatchingPins(@NotNull String s) {
        q.g(s, "hostname");
        List list0 = w.a;
        for(Object object0: this.pins) {
            if(((Pin)object0).matchesHostname(s)) {
                if(list0.isEmpty()) {
                    list0 = new ArrayList();
                }
                N.b(list0).add(object0);
            }
        }
        return list0;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set getPins() {
        return this.pins;
    }

    @Override
    public int hashCode() {
        int v = this.pins.hashCode();
        return this.certificateChainCleaner == null ? (v + 0x5ED) * 41 : (v + 0x5ED) * 41 + this.certificateChainCleaner.hashCode();
    }

    @NotNull
    public static final String pin(@NotNull Certificate certificate0) {
        return CertificatePinner.Companion.pin(certificate0);
    }

    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate0) {
        return CertificatePinner.Companion.sha1Hash(x509Certificate0);
    }

    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate0) {
        return CertificatePinner.Companion.sha256Hash(x509Certificate0);
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner0) {
        q.g(certificateChainCleaner0, "certificateChainCleaner");
        return q.b(this.certificateChainCleaner, certificateChainCleaner0) ? this : new CertificatePinner(this.pins, certificateChainCleaner0);
    }
}

