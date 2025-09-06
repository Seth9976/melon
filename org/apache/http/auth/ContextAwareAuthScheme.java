package org.apache.http.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;

public interface ContextAwareAuthScheme extends AuthScheme {
    Header authenticate(Credentials arg1, HttpRequest arg2, HttpContext arg3);
}

