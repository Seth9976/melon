package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;

@Deprecated
public class BasicHeaderElement implements HeaderElement {
    public BasicHeaderElement(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public BasicHeaderElement(String s, String s1, NameValuePair[] arr_nameValuePair) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElement
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElement
    public NameValuePair getParameter(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElement
    public NameValuePair getParameterByName(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElement
    public int getParameterCount() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElement
    public NameValuePair[] getParameters() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElement
    public String getValue() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

