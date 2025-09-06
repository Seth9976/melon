package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0096\u0002J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u0004H\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R \u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "", "equals", "", "other", "", "findByIssuerAndSignature", "cert", "hashCode", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BasicTrustRootIndex implements TrustRootIndex {
    @NotNull
    private final Map subjectToCaCerts;

    public BasicTrustRootIndex(@NotNull X509Certificate[] arr_x509Certificate) {
        q.g(arr_x509Certificate, "caCerts");
        super();
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(int v = 0; v < arr_x509Certificate.length; ++v) {
            X509Certificate x509Certificate0 = arr_x509Certificate[v];
            X500Principal x500Principal0 = x509Certificate0.getSubjectX500Principal();
            q.f(x500Principal0, "caCert.subjectX500Principal");
            LinkedHashSet linkedHashSet0 = linkedHashMap0.get(x500Principal0);
            if(linkedHashSet0 == null) {
                linkedHashSet0 = new LinkedHashSet();
                linkedHashMap0.put(x500Principal0, linkedHashSet0);
            }
            linkedHashSet0.add(x509Certificate0);
        }
        this.subjectToCaCerts = linkedHashMap0;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 == this || object0 instanceof BasicTrustRootIndex && q.b(((BasicTrustRootIndex)object0).subjectToCaCerts, this.subjectToCaCerts);
    }

    @Override  // okhttp3.internal.tls.TrustRootIndex
    @Nullable
    public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate x509Certificate0) {
        q.g(x509Certificate0, "cert");
        X500Principal x500Principal0 = x509Certificate0.getIssuerX500Principal();
        Set set0 = (Set)this.subjectToCaCerts.get(x500Principal0);
        Object object0 = null;
        if(set0 == null) {
            return null;
        }
        Iterator iterator0 = set0.iterator();
    label_7:
        if(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            X509Certificate x509Certificate1 = (X509Certificate)object1;
            try {
                x509Certificate0.verify(x509Certificate1.getPublicKey());
                object0 = object1;
            }
            catch(Exception unused_ex) {
                goto label_7;
            }
        }
        return (X509Certificate)object0;
    }

    @Override
    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}

