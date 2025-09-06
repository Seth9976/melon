package okhttp3.internal.tls;

import Tf.o;
import Tf.v;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\nJ\u001E\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0004H\u0002J\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nJ\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0018\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002J\u001C\u0010\u0012\u001A\u00020\u000E2\b\u0010\u0013\u001A\u0004\u0018\u00010\b2\b\u0010\u0014\u001A\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002J\f\u0010\u0017\u001A\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001A\u00020\u000E*\u00020\bH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    @NotNull
    public static final OkHostnameVerifier INSTANCE;

    static {
        OkHostnameVerifier.INSTANCE = new OkHostnameVerifier();
    }

    @NotNull
    public final List allSubjectAltNames(@NotNull X509Certificate x509Certificate0) {
        q.g(x509Certificate0, "certificate");
        return p.A0(this.getSubjectAltNames(x509Certificate0, 7), this.getSubjectAltNames(x509Certificate0, 2));
    }

    private final String asciiToLowercase(String s) {
        if(this.isAscii(s)) {
            Locale locale0 = Locale.US;
            q.f(locale0, "US");
            s = s.toLowerCase(locale0);
            q.f(s, "this as java.lang.String).toLowerCase(locale)");
        }
        return s;
    }

    private final List getSubjectAltNames(X509Certificate x509Certificate0, int v) {
        List list0;
        try {
            list0 = w.a;
            Collection collection0 = x509Certificate0.getSubjectAlternativeNames();
            if(collection0 == null) {
                return list0;
            }
            List list1 = new ArrayList();
            for(Object object0: collection0) {
                List list2 = (List)object0;
                if(list2 != null && list2.size() >= 2 && q.b(list2.get(0), v)) {
                    Object object1 = list2.get(1);
                    if(object1 != null) {
                        list1.add(((String)object1));
                    }
                }
            }
            return list1;
        }
        catch(CertificateParsingException unused_ex) {
            return list0;
        }
    }

    private final boolean isAscii(String s) {
        return s.length() == ((int)Utf8.size$default(s, 0, 0, 3, null));
    }

    public final boolean verify(@NotNull String s, @NotNull X509Certificate x509Certificate0) {
        q.g(s, "host");
        q.g(x509Certificate0, "certificate");
        return Util.canParseAsIpAddress(s) ? this.verifyIpAddress(s, x509Certificate0) : this.verifyHostname(s, x509Certificate0);
    }

    @Override  // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String s, @NotNull SSLSession sSLSession0) {
        q.g(s, "host");
        q.g(sSLSession0, "session");
        if(!this.isAscii(s)) {
            return false;
        }
        try {
            Certificate certificate0 = sSLSession0.getPeerCertificates()[0];
            q.e(certificate0, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return this.verify(s, ((X509Certificate)certificate0));
        }
        catch(SSLException unused_ex) {
            return false;
        }
    }

    private final boolean verifyHostname(String s, String s1) {
        if(s != null && s.length() != 0 && !v.r0(s, ".", false) && !v.i0(s, "..", false) && s1 != null && s1.length() != 0 && !v.r0(s1, ".", false) && !v.i0(s1, "..", false)) {
            if(!v.i0(s, ".", false)) {
                s = s + ".";
            }
            if(!v.i0(s1, ".", false)) {
                s1 = s1 + ".";
            }
            String s2 = this.asciiToLowercase(s1);
            if(!o.v0(s2, "*", false)) {
                return q.b(s, s2);
            }
            if(v.r0(s2, "*.", false) && o.E0(s2, '*', 1, 4) == -1 && s.length() >= s2.length() && !"*.".equals(s2)) {
                String s3 = s2.substring(1);
                q.f(s3, "this as java.lang.String).substring(startIndex)");
                if(v.i0(s, s3, false)) {
                    int v = s.length() - s3.length();
                    return v <= 0 || o.J0(s, '.', v - 1, 4) == -1;
                }
            }
        }
        return false;
    }

    private final boolean verifyHostname(String s, X509Certificate x509Certificate0) {
        String s1 = this.asciiToLowercase(s);
        Iterable iterable0 = this.getSubjectAltNames(x509Certificate0, 2);
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(OkHostnameVerifier.INSTANCE.verifyHostname(s1, ((String)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String s, X509Certificate x509Certificate0) {
        String s1 = HostnamesKt.toCanonicalHost(s);
        Iterable iterable0 = this.getSubjectAltNames(x509Certificate0, 7);
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(q.b(s1, HostnamesKt.toCanonicalHost(((String)object0)))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }
}

