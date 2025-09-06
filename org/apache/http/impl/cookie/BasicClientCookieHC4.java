package org.apache.http.impl.cookie;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicClientCookieHC4 implements Serializable, Cloneable, ClientCookie, SetCookie {
    private Map attribs;
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private boolean isSecure;
    private final String name;
    private static final long serialVersionUID = 0xCA4BB969BA98B1CEL;
    private String value;

    public BasicClientCookieHC4(String s, String s1) {
        Args.notNull(s, "Name");
        this.name = s;
        this.attribs = new HashMap();
        this.value = s1;
    }

    @Override
    public Object clone() {
        BasicClientCookieHC4 basicClientCookieHC40 = (BasicClientCookieHC4)super.clone();
        basicClientCookieHC40.attribs = new HashMap(this.attribs);
        return basicClientCookieHC40;
    }

    @Override  // org.apache.http.cookie.ClientCookie
    public boolean containsAttribute(String s) {
        return this.attribs.get(s) != null;
    }

    @Override  // org.apache.http.cookie.ClientCookie
    public String getAttribute(String s) {
        return (String)this.attribs.get(s);
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getComment() {
        return this.cookieComment;
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getCommentURL() {
        return null;
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getDomain() {
        return this.cookieDomain;
    }

    @Override  // org.apache.http.cookie.Cookie
    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getName() {
        return this.name;
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getPath() {
        return this.cookiePath;
    }

    @Override  // org.apache.http.cookie.Cookie
    public int[] getPorts() {
        return null;
    }

    @Override  // org.apache.http.cookie.Cookie
    public String getValue() {
        return this.value;
    }

    @Override  // org.apache.http.cookie.Cookie
    public int getVersion() {
        return this.cookieVersion;
    }

    @Override  // org.apache.http.cookie.Cookie
    public boolean isExpired(Date date0) {
        Args.notNull(date0, "Date");
        return this.cookieExpiryDate != null && this.cookieExpiryDate.getTime() <= date0.getTime();
    }

    @Override  // org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        return this.cookieExpiryDate != null;
    }

    @Override  // org.apache.http.cookie.Cookie
    public boolean isSecure() {
        return this.isSecure;
    }

    public void setAttribute(String s, String s1) {
        this.attribs.put(s, s1);
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setComment(String s) {
        this.cookieComment = s;
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setDomain(String s) {
        if(s != null) {
            this.cookieDomain = s.toLowerCase(Locale.ENGLISH);
            return;
        }
        this.cookieDomain = null;
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setExpiryDate(Date date0) {
        this.cookieExpiryDate = date0;
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setPath(String s) {
        this.cookiePath = s;
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setSecure(boolean z) {
        this.isSecure = z;
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setValue(String s) {
        this.value = s;
    }

    @Override  // org.apache.http.cookie.SetCookie
    public void setVersion(int v) {
        this.cookieVersion = v;
    }

    @Override
    public String toString() {
        return "[version: " + Integer.toString(this.cookieVersion) + "][name: " + this.name + "][value: " + this.value + "][domain: " + this.cookieDomain + "][path: " + this.cookiePath + "][expiry: " + this.cookieExpiryDate + "]";
    }
}

