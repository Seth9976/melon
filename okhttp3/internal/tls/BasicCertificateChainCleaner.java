package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001A\u00020\nH\u0016J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0018\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0013H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "()V", "MAX_SIGNERS", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_SIGNERS = 9;
    @NotNull
    private final TrustRootIndex trustRootIndex;

    static {
        BasicCertificateChainCleaner.Companion = new Companion(null);
    }

    public BasicCertificateChainCleaner(@NotNull TrustRootIndex trustRootIndex0) {
        q.g(trustRootIndex0, "trustRootIndex");
        super();
        this.trustRootIndex = trustRootIndex0;
    }

    @Override  // okhttp3.internal.tls.CertificateChainCleaner
    @NotNull
    public List clean(@NotNull List list0, @NotNull String s) {
        q.g(list0, "chain");
        q.g(s, "hostname");
        ArrayDeque arrayDeque0 = new ArrayDeque(list0);
        List list1 = new ArrayList();
        Object object0 = arrayDeque0.removeFirst();
        q.f(object0, "queue.removeFirst()");
        list1.add(object0);
        boolean z = false;
        int v = 0;
        while(v < 9) {
            Object object1 = list1.get(list1.size() - 1);
            q.e(object1, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate0 = (X509Certificate)object1;
            X509Certificate x509Certificate1 = this.trustRootIndex.findByIssuerAndSignature(x509Certificate0);
            if(x509Certificate1 == null) {
                Iterator iterator0 = arrayDeque0.iterator();
                q.f(iterator0, "queue.iterator()");
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_31;
                    }
                    Object object2 = iterator0.next();
                    q.e(object2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate)object2;
                    if(this.verifySignature(x509Certificate0, x509Certificate2)) {
                        iterator0.remove();
                        list1.add(x509Certificate2);
                        break;
                    }
                }
            }
            else {
                if(list1.size() > 1 || !x509Certificate0.equals(x509Certificate1)) {
                    list1.add(x509Certificate1);
                }
                if(this.verifySignature(x509Certificate1, x509Certificate1)) {
                    return list1;
                }
                z = true;
            }
            ++v;
            continue;
        label_31:
            if(!z) {
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate0);
            }
            return list1;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + list1);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 == this ? true : object0 instanceof BasicCertificateChainCleaner && q.b(((BasicCertificateChainCleaner)object0).trustRootIndex, this.trustRootIndex);
    }

    @Override
    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    private final boolean verifySignature(X509Certificate x509Certificate0, X509Certificate x509Certificate1) {
        if(!q.b(x509Certificate0.getIssuerDN(), x509Certificate1.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate0.verify(x509Certificate1.getPublicKey());
            return true;
        }
        catch(GeneralSecurityException unused_ex) {
            return false;
        }
    }
}

