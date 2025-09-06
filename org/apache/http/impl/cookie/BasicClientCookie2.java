package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.cookie.SetCookie2;

@Deprecated
public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    public BasicClientCookie2(String s, String s1) {
        super(null, null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookie
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public String getCommentURL() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public int[] getPorts() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public boolean isExpired(Date date0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie2
    public void setCommentURL(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie2
    public void setDiscard(boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.SetCookie2
    public void setPorts(int[] arr_v) {
        throw new RuntimeException("Stub!");
    }
}

