package org.apache.http.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

@Deprecated
public interface AuthScheme {
    Header authenticate(Credentials arg1, HttpRequest arg2);

    String getParameter(String arg1);

    String getRealm();

    String getSchemeName();

    boolean isComplete();

    boolean isConnectionBased();

    void processChallenge(Header arg1);
}

