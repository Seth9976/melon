package org.apache.http.impl.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.util.Args;

@ThreadSafe
public class BasicCredentialsProviderHC4 implements CredentialsProvider {
    private final ConcurrentHashMap credMap;

    public BasicCredentialsProviderHC4() {
        this.credMap = new ConcurrentHashMap();
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public void clear() {
        this.credMap.clear();
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public Credentials getCredentials(AuthScope authScope0) {
        Args.notNull(authScope0, "Authentication scope");
        return BasicCredentialsProviderHC4.matchCredentials(this.credMap, authScope0);
    }

    private static Credentials matchCredentials(Map map0, AuthScope authScope0) {
        Credentials credentials0 = (Credentials)map0.get(authScope0);
        if(credentials0 == null) {
            int v = -1;
            AuthScope authScope1 = null;
            for(Object object0: map0.keySet()) {
                AuthScope authScope2 = (AuthScope)object0;
                int v1 = authScope0.match(authScope2);
                if(v1 > v) {
                    authScope1 = authScope2;
                    v = v1;
                }
            }
            return authScope1 == null ? null : ((Credentials)map0.get(authScope1));
        }
        return credentials0;
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public void setCredentials(AuthScope authScope0, Credentials credentials0) {
        Args.notNull(authScope0, "Authentication scope");
        this.credMap.put(authScope0, credentials0);
    }

    @Override
    public String toString() {
        return this.credMap.toString();
    }
}

