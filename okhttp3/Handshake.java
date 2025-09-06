package okhttp3;

import d3.g;
import ie.d;
import ie.j;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0001-B;\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0017\u001A\u0004\u0018\u00010\u0014H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0012J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u0014H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0016J\u001A\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001H\u0096\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001A\u00020\u00028\u0007\u00A2\u0006\f\n\u0004\b\u0003\u0010%\u001A\u0004\b\u0003\u0010\u000ER\u0017\u0010\u0005\u001A\u00020\u00048\u0007\u00A2\u0006\f\n\u0004\b\u0005\u0010&\u001A\u0004\b\u0005\u0010\u0010R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007\u00A2\u0006\f\n\u0004\b\b\u0010\'\u001A\u0004\b\b\u0010\u0012R!\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068GX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b\u0013\u0010\u0012R\u0018\u0010,\u001A\u00020\"*\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b*\u0010+R\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u00148G\u00A2\u0006\u0006\u001A\u0004\b\u0017\u0010\u0016R\u0013\u0010\u001A\u001A\u0004\u0018\u00010\u00148G\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\u0016\u00A8\u0006."}, d2 = {"Lokhttp3/Handshake;", "", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "localCertificates", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lwe/a;)V", "-deprecated_tlsVersion", "()Lokhttp3/TlsVersion;", "-deprecated_cipherSuite", "()Lokhttp3/CipherSuite;", "-deprecated_peerCertificates", "()Ljava/util/List;", "peerCertificates", "Ljava/security/Principal;", "-deprecated_peerPrincipal", "()Ljava/security/Principal;", "peerPrincipal", "-deprecated_localCertificates", "-deprecated_localPrincipal", "localPrincipal", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lokhttp3/TlsVersion;", "Lokhttp3/CipherSuite;", "Ljava/util/List;", "peerCertificates$delegate", "Lie/j;", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Handshake {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J4\u0010\u0003\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0007J\u0011\u0010\u0010\u001A\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003J!\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000E0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000E\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @d
        @NotNull
        public final Handshake -deprecated_get(@NotNull SSLSession sSLSession0) {
            q.g(sSLSession0, "sslSession");
            return this.get(sSLSession0);
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Handshake get(@NotNull SSLSession sSLSession0) {
            q.g(sSLSession0, "<this>");
            String s = sSLSession0.getCipherSuite();
            if(s == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if((s.equals("TLS_NULL_WITH_NULL_NULL") ? true : s.equals("SSL_NULL_WITH_NULL_NULL"))) {
                throw new IOException("cipherSuite == " + s);
            }
            CipherSuite cipherSuite0 = CipherSuite.Companion.forJavaName(s);
            String s1 = sSLSession0.getProtocol();
            if(s1 == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if(!"NONE".equals(s1)) {
                TlsVersion tlsVersion0 = TlsVersion.Companion.forJavaName(s1);
                try {
                    List list0 = this.toImmutableList(sSLSession0.getPeerCertificates());
                    return new Handshake(tlsVersion0, cipherSuite0, this.toImmutableList(sSLSession0.getLocalCertificates()), new a() {
                        final List $peerCertificatesCopy;

                        {
                            this.$peerCertificatesCopy = list0;
                            super(0);
                        }

                        @Override  // we.a
                        public Object invoke() {
                            return this.invoke();
                        }

                        @NotNull
                        public final List invoke() {
                            return this.$peerCertificatesCopy;
                        }
                    });
                }
                catch(SSLPeerUnverifiedException unused_ex) {
                    return new Handshake(tlsVersion0, cipherSuite0, this.toImmutableList(sSLSession0.getLocalCertificates()), new a() {
                        final List $peerCertificatesCopy;

                        {
                            this.$peerCertificatesCopy = list0;
                            super(0);
                        }

                        @Override  // we.a
                        public Object invoke() {
                            return this.invoke();
                        }

                        @NotNull
                        public final List invoke() {
                            return this.$peerCertificatesCopy;
                        }
                    });
                }
            }
            throw new IOException("tlsVersion == NONE");
        }

        @NotNull
        public final Handshake get(@NotNull TlsVersion tlsVersion0, @NotNull CipherSuite cipherSuite0, @NotNull List list0, @NotNull List list1) {
            q.g(tlsVersion0, "tlsVersion");
            q.g(cipherSuite0, "cipherSuite");
            q.g(list0, "peerCertificates");
            q.g(list1, "localCertificates");
            List list2 = Util.toImmutableList(list0);
            return new Handshake(tlsVersion0, cipherSuite0, Util.toImmutableList(list1), new a() {
                final List $peerCertificatesCopy;

                {
                    this.$peerCertificatesCopy = list0;
                    super(0);
                }

                @Override  // we.a
                public Object invoke() {
                    return this.invoke();
                }

                @NotNull
                public final List invoke() {
                    return this.$peerCertificatesCopy;
                }
            });
        }

        private final List toImmutableList(Certificate[] arr_certificate) {
            return arr_certificate != null ? Util.immutableListOf(Arrays.copyOf(arr_certificate, arr_certificate.length)) : w.a;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final CipherSuite cipherSuite;
    @NotNull
    private final List localCertificates;
    @NotNull
    private final j peerCertificates$delegate;
    @NotNull
    private final TlsVersion tlsVersion;

    @d
    @NotNull
    public final CipherSuite -deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @d
    @NotNull
    public final List -deprecated_localCertificates() {
        return this.localCertificates;
    }

    @d
    @Nullable
    public final Principal -deprecated_localPrincipal() {
        return this.localPrincipal();
    }

    @d
    @NotNull
    public final List -deprecated_peerCertificates() {
        return this.peerCertificates();
    }

    @d
    @Nullable
    public final Principal -deprecated_peerPrincipal() {
        return this.peerPrincipal();
    }

    @d
    @NotNull
    public final TlsVersion -deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    static {
        Handshake.Companion = new Companion(null);
    }

    public Handshake(@NotNull TlsVersion tlsVersion0, @NotNull CipherSuite cipherSuite0, @NotNull List list0, @NotNull a a0) {
        q.g(tlsVersion0, "tlsVersion");
        q.g(cipherSuite0, "cipherSuite");
        q.g(list0, "localCertificates");
        q.g(a0, "peerCertificatesFn");
        super();
        this.tlsVersion = tlsVersion0;
        this.cipherSuite = cipherSuite0;
        this.localCertificates = list0;
        this.peerCertificates$delegate = g.Q(new a() {
            final a $peerCertificatesFn;

            {
                this.$peerCertificatesFn = a0;
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }

            @NotNull
            public final List invoke() {
                try {
                    return (List)this.$peerCertificatesFn.invoke();
                }
                catch(SSLPeerUnverifiedException unused_ex) {
                    return w.a;
                }
            }
        });
    }

    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof Handshake && ((Handshake)object0).tlsVersion == this.tlsVersion && q.b(((Handshake)object0).cipherSuite, this.cipherSuite) && q.b(((Handshake)object0).peerCertificates(), this.peerCertificates()) && q.b(((Handshake)object0).localCertificates, this.localCertificates);
    }

    @NotNull
    public static final Handshake get(@NotNull SSLSession sSLSession0) {
        return Handshake.Companion.get(sSLSession0);
    }

    @NotNull
    public static final Handshake get(@NotNull TlsVersion tlsVersion0, @NotNull CipherSuite cipherSuite0, @NotNull List list0, @NotNull List list1) {
        return Handshake.Companion.get(tlsVersion0, cipherSuite0, list0, list1);
    }

    private final String getName(Certificate certificate0) {
        if(certificate0 instanceof X509Certificate) {
            return ((X509Certificate)certificate0).getSubjectDN().toString();
        }
        String s = certificate0.getType();
        q.f(s, "type");
        return s;
    }

    @Override
    public int hashCode() {
        int v = this.peerCertificates().hashCode();
        return this.localCertificates.hashCode() + (v + (this.cipherSuite.hashCode() + (this.tlsVersion.hashCode() + 0x20F) * 0x1F) * 0x1F) * 0x1F;
    }

    @NotNull
    public final List localCertificates() {
        return this.localCertificates;
    }

    @Nullable
    public final Principal localPrincipal() {
        Object object0 = p.m0(this.localCertificates);
        X509Certificate x509Certificate0 = object0 instanceof X509Certificate ? ((X509Certificate)object0) : null;
        return x509Certificate0 != null ? x509Certificate0.getSubjectX500Principal() : null;
    }

    @NotNull
    public final List peerCertificates() {
        return (List)this.peerCertificates$delegate.getValue();
    }

    @Nullable
    public final Principal peerPrincipal() {
        Object object0 = p.m0(this.peerCertificates());
        X509Certificate x509Certificate0 = object0 instanceof X509Certificate ? ((X509Certificate)object0) : null;
        return x509Certificate0 != null ? x509Certificate0.getSubjectX500Principal() : null;
    }

    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @Override
    @NotNull
    public String toString() {
        Iterable iterable0 = this.peerCertificates();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(this.getName(((Certificate)object0)));
        }
        StringBuilder stringBuilder0 = new StringBuilder("Handshake{tlsVersion=");
        stringBuilder0.append(this.tlsVersion);
        stringBuilder0.append(" cipherSuite=");
        stringBuilder0.append(this.cipherSuite);
        stringBuilder0.append(" peerCertificates=");
        stringBuilder0.append(arrayList0.toString());
        stringBuilder0.append(" localCertificates=");
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, this.localCertificates));
        for(Object object1: this.localCertificates) {
            arrayList1.add(this.getName(((Certificate)object1)));
        }
        stringBuilder0.append(arrayList1);
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

