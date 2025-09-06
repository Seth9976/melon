package org.apache.http;

@Deprecated
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int arg1);

    NameValuePair getParameterByName(String arg1);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}

