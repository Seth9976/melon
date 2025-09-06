package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.ReasonPhraseCatalog;

@Deprecated
public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
    public static final EnglishReasonPhraseCatalog INSTANCE;

    public EnglishReasonPhraseCatalog() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.ReasonPhraseCatalog
    public String getReason(int v, Locale locale0) {
        throw new RuntimeException("Stub!");
    }
}

