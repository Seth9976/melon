package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;

@Deprecated
public class BasicClientCookie implements ClientCookie, SetCookie {
    public BasicClientCookie(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.ClientCookie
    public boolean containsAttribute(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.ClientCookie
    public String getAttribute(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getComment() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getCommentURL() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getDomain() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public Date getExpiryDate() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getPath() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public int[] getPorts() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getValue() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public int getVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public boolean isExpired(Date date0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.Cookie
    public boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    public void setAttribute(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setComment(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setDomain(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setExpiryDate(Date date0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setPath(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setSecure(boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setValue(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setVersion(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

