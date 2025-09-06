package org.apache.http;

import org.apache.http.params.HttpParams;

@Deprecated
public interface HttpMessage {
    void addHeader(String arg1, String arg2);

    void addHeader(Header arg1);

    boolean containsHeader(String arg1);

    Header[] getAllHeaders();

    Header getFirstHeader(String arg1);

    Header[] getHeaders(String arg1);

    Header getLastHeader(String arg1);

    HttpParams getParams();

    ProtocolVersion getProtocolVersion();

    HeaderIterator headerIterator();

    HeaderIterator headerIterator(String arg1);

    void removeHeader(Header arg1);

    void removeHeaders(String arg1);

    void setHeader(String arg1, String arg2);

    void setHeader(Header arg1);

    void setHeaders(Header[] arg1);

    void setParams(HttpParams arg1);
}

