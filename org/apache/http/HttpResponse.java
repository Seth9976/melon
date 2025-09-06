package org.apache.http;

import java.util.Locale;

@Deprecated
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity arg1);

    void setLocale(Locale arg1);

    void setReasonPhrase(String arg1);

    void setStatusCode(int arg1);

    void setStatusLine(ProtocolVersion arg1, int arg2);

    void setStatusLine(ProtocolVersion arg1, int arg2, String arg3);

    void setStatusLine(StatusLine arg1);
}

