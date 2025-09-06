package org.apache.http.impl.client;

import java.net.Authenticator.RequestorType;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.util.Args;

@ThreadSafe
public class SystemDefaultCredentialsProvider implements CredentialsProvider {
    private static final Map SCHEME_MAP;
    private final BasicCredentialsProviderHC4 internal;

    static {
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
        SystemDefaultCredentialsProvider.SCHEME_MAP = concurrentHashMap0;
        concurrentHashMap0.put("BASIC", "Basic");
        concurrentHashMap0.put("DIGEST", "Digest");
        concurrentHashMap0.put("NTLM", "NTLM");
        concurrentHashMap0.put("NEGOTIATE", "SPNEGO");
        concurrentHashMap0.put("KERBEROS", "Kerberos");
    }

    public SystemDefaultCredentialsProvider() {
        this.internal = new BasicCredentialsProviderHC4();
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public void clear() {
        this.internal.clear();
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public Credentials getCredentials(AuthScope authScope0) {
        Args.notNull(authScope0, "Auth scope");
        Credentials credentials0 = this.internal.getCredentials(authScope0);
        if(credentials0 != null) {
            return credentials0;
        }
        if(authScope0.getHost() != null) {
            PasswordAuthentication passwordAuthentication0 = SystemDefaultCredentialsProvider.getSystemCreds(authScope0, Authenticator.RequestorType.SERVER);
            if(passwordAuthentication0 == null) {
                passwordAuthentication0 = SystemDefaultCredentialsProvider.getSystemCreds(authScope0, Authenticator.RequestorType.PROXY);
            }
            if(passwordAuthentication0 != null) {
                String s = System.getProperty("http.auth.ntlm.domain");
                if(s != null) {
                    return new NTCredentials(passwordAuthentication0.getUserName(), new String(passwordAuthentication0.getPassword()), null, s);
                }
                return "NTLM".equalsIgnoreCase(authScope0.getScheme()) ? new NTCredentials(passwordAuthentication0.getUserName(), new String(passwordAuthentication0.getPassword()), null, null) : new UsernamePasswordCredentials(passwordAuthentication0.getUserName(), new String(passwordAuthentication0.getPassword()));
            }
        }
        return null;
    }

    private static PasswordAuthentication getSystemCreds(AuthScope authScope0, Authenticator.RequestorType authenticator$RequestorType0) {
        String s = authScope0.getHost();
        int v = authScope0.getPort();
        return v == 443 ? Authenticator.requestPasswordAuthentication(s, null, 443, "https", null, SystemDefaultCredentialsProvider.translateScheme(authScope0.getScheme()), null, authenticator$RequestorType0) : Authenticator.requestPasswordAuthentication(s, null, v, "http", null, SystemDefaultCredentialsProvider.translateScheme(authScope0.getScheme()), null, authenticator$RequestorType0);
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public void setCredentials(AuthScope authScope0, Credentials credentials0) {
        this.internal.setCredentials(authScope0, credentials0);
    }

    private static String translateScheme(String s) {
        if(s == null) {
            return null;
        }
        String s1 = (String)SystemDefaultCredentialsProvider.SCHEME_MAP.get(s);
        return s1 == null ? s : s1;
    }
}

