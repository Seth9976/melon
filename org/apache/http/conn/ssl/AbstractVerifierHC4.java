package org.apache.http.conn.ssl;

import H0.b;
import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.util.InetAddressUtilsHC4;
import org.apache.http.util.TextUtils;

@Immutable
public abstract class AbstractVerifierHC4 implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS = null;
    private static final String TAG = "HttpClient";

    static {
        String[] arr_s = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        AbstractVerifierHC4.BAD_COUNTRY_2LDS = arr_s;
        Arrays.sort(arr_s);
    }

    @Deprecated
    public static boolean acceptableCountryWildcard(String s) {
        String[] arr_s = s.split("\\.");
        return arr_s.length != 3 || arr_s[2].length() != 2 || Arrays.binarySearch(AbstractVerifierHC4.BAD_COUNTRY_2LDS, arr_s[1]) < 0;
    }

    public static int countDots(String s) {
        int v1 = 0;
        for(int v = 0; v < s.length(); ++v) {
            if(s.charAt(v) == 46) {
                ++v1;
            }
        }
        return v1;
    }

    public static String[] extractCNs(String s) {
        if(s == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        List list0 = DistinguishedNameParser.INSTANCE.parse(s);
        for(int v = 0; v < list0.size(); ++v) {
            NameValuePair nameValuePair0 = (NameValuePair)list0.get(v);
            String s1 = nameValuePair0.getName();
            String s2 = nameValuePair0.getValue();
            if(TextUtils.isBlank(s2)) {
                throw new SSLException(s + " is not a valid X500 distinguished name");
            }
            if(s1.equalsIgnoreCase("cn")) {
                arrayList0.add(s2);
            }
        }
        return arrayList0.isEmpty() ? null : ((String[])arrayList0.toArray(new String[arrayList0.size()]));
    }

    public static String[] getCNs(X509Certificate x509Certificate0) {
        String s = x509Certificate0.getSubjectX500Principal().toString();
        try {
            return AbstractVerifierHC4.extractCNs(s);
        }
        catch(SSLException unused_ex) {
            return null;
        }
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate0) {
        return AbstractVerifierHC4.getSubjectAlts(x509Certificate0, null);
    }

    private static String[] getSubjectAlts(X509Certificate x509Certificate0, String s) {
        int v = AbstractVerifierHC4.isIPAddress(s) ? 7 : 2;
        LinkedList linkedList0 = new LinkedList();
        try {
            Collection collection0 = null;
            collection0 = x509Certificate0.getSubjectAlternativeNames();
        }
        catch(CertificateParsingException unused_ex) {
        }
        if(collection0 != null) {
            for(Object object0: collection0) {
                List list0 = (List)object0;
                if(((int)(((Integer)list0.get(0)))) == v) {
                    linkedList0.add(((String)list0.get(1)));
                }
            }
        }
        if(!linkedList0.isEmpty()) {
            String[] arr_s = new String[linkedList0.size()];
            linkedList0.toArray(arr_s);
            return arr_s;
        }
        return null;
    }

    // 去混淆评级： 低(20)
    private static boolean isIPAddress(String s) {
        return s != null && (InetAddressUtilsHC4.isIPv4Address(s) || InetAddressUtilsHC4.isIPv6Address(s));
    }

    private String normaliseIPv6Address(String s) {
        if(s != null && InetAddressUtilsHC4.isIPv6Address(s)) {
            try {
                return InetAddress.getByName(s).getHostAddress();
            }
            catch(UnknownHostException unknownHostException0) {
                Log.e("HttpClient", "Unexpected error converting " + s, unknownHostException0);
            }
        }
        return s;
    }

    public boolean validCountryWildcard(String s) {
        String[] arr_s = s.split("\\.");
        return arr_s.length != 3 || arr_s[2].length() != 2 || Arrays.binarySearch(AbstractVerifierHC4.BAD_COUNTRY_2LDS, arr_s[1]) < 0;
    }

    @Override  // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String s, X509Certificate x509Certificate0) {
        this.verify(s, AbstractVerifierHC4.getCNs(x509Certificate0), AbstractVerifierHC4.getSubjectAlts(x509Certificate0, s));
    }

    @Override  // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String s, SSLSocket sSLSocket0) {
        if(s == null) {
            throw new NullPointerException("host to verify is null");
        }
        SSLSession sSLSession0 = sSLSocket0.getSession();
        if(sSLSession0 == null) {
            sSLSocket0.getInputStream().available();
            sSLSession0 = sSLSocket0.getSession();
            if(sSLSession0 == null) {
                sSLSocket0.startHandshake();
                sSLSession0 = sSLSocket0.getSession();
            }
        }
        this.verify(s, ((X509Certificate)sSLSession0.getPeerCertificates()[0]));
    }

    public final void verify(String s, String[] arr_s, String[] arr_s1, boolean z) {
        boolean z3;
        LinkedList linkedList0 = new LinkedList();
        if(arr_s != null && arr_s.length > 0) {
            String s1 = arr_s[0];
            if(s1 != null) {
                linkedList0.add(s1);
            }
        }
        if(arr_s1 != null) {
            for(int v = 0; v < arr_s1.length; ++v) {
                String s2 = arr_s1[v];
                if(s2 != null) {
                    linkedList0.add(s2);
                }
            }
        }
        if(linkedList0.isEmpty()) {
            throw new SSLException("Certificate for <" + s + "> doesn\'t contain CN or DNS subjectAlt");
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        String s3 = this.normaliseIPv6Address(s.trim().toLowerCase(Locale.ENGLISH));
        boolean z1 = false;
        Iterator iterator0 = linkedList0.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s4 = ((String)object0).toLowerCase(Locale.ENGLISH);
            stringBuilder0.append(" <");
            stringBuilder0.append(s4);
            stringBuilder0.append('>');
            if(iterator0.hasNext()) {
                stringBuilder0.append(" OR");
            }
            String[] arr_s2 = s4.split("\\.");
            if(arr_s2.length < 3 || !arr_s2[0].endsWith("*") || !this.validCountryWildcard(s4) || AbstractVerifierHC4.isIPAddress(s)) {
                z1 = s3.equals(this.normaliseIPv6Address(s4));
            }
            else {
                String s5 = arr_s2[0];
                boolean z2 = true;
                if(s5.length() > 1) {
                    String s6 = b.d(1, 0, s5);
                    z3 = !s3.startsWith(s6) || !s3.substring(s6.length()).endsWith(s4.substring(s5.length())) ? false : true;
                }
                else {
                    z3 = s3.endsWith(s4.substring(1));
                }
                if(z3 && z) {
                    if(AbstractVerifierHC4.countDots(s3) != AbstractVerifierHC4.countDots(s4)) {
                        z2 = false;
                    }
                    z3 = z2;
                }
                z1 = z3;
            }
            if(z1) {
                break;
            }
        }
        if(!z1) {
            throw new SSLException("hostname in certificate didn\'t match: <" + s + "> !=" + stringBuilder0);
        }
    }

    @Override  // org.apache.http.conn.ssl.X509HostnameVerifier
    public final boolean verify(String s, SSLSession sSLSession0) {
        try {
            this.verify(s, ((X509Certificate)sSLSession0.getPeerCertificates()[0]));
            return true;
        }
        catch(SSLException unused_ex) {
            return false;
        }
    }
}

