package org.apache.http.client.utils;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicNameValuePair;

@NotThreadSafe
public class URIBuilder {
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private String path;
    private int port;
    private String query;
    private List queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String s) {
        this.digestURI(new URI(s));
    }

    public URIBuilder(URI uRI0) {
        this.digestURI(uRI0);
    }

    public URIBuilder addParameter(String s, String s1) {
        if(this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.add(new BasicNameValuePair(s, s1));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameters(List list0) {
        if(this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.addAll(list0);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    // 去混淆评级： 低(20)
    public URI build() {
        return new URI("");
    }

    private String buildString() [...] // 潜在的解密器

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    private void digestURI(URI uRI0) {
        this.scheme = uRI0.getScheme();
        this.encodedSchemeSpecificPart = uRI0.getRawSchemeSpecificPart();
        this.encodedAuthority = uRI0.getRawAuthority();
        this.host = uRI0.getHost();
        this.port = uRI0.getPort();
        this.encodedUserInfo = uRI0.getRawUserInfo();
        this.userInfo = uRI0.getUserInfo();
        this.encodedPath = uRI0.getRawPath();
        this.path = uRI0.getPath();
        this.encodedQuery = uRI0.getRawQuery();
        this.queryParams = this.parseQuery(uRI0.getRawQuery(), Consts.UTF_8);
        this.encodedFragment = uRI0.getRawFragment();
        this.fragment = uRI0.getFragment();
    }

    private String encodePath(String s) {
        return URLEncodedUtilsHC4.encPath(s, Consts.UTF_8);
    }

    private String encodeUric(String s) {
        return URLEncodedUtilsHC4.encUric(s, Consts.UTF_8);
    }

    private String encodeUrlForm(List list0) {
        return URLEncodedUtilsHC4.format(list0, Consts.UTF_8);
    }

    private String encodeUserInfo(String s) {
        return URLEncodedUtilsHC4.encUserInfo(s, Consts.UTF_8);
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public List getQueryParams() {
        return this.queryParams == null ? new ArrayList() : new ArrayList(this.queryParams);
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.path == null;
    }

    private static String normalizePath(String s) {
        if(s == null) {
            return null;
        }
        int v;
        for(v = 0; v < s.length() && s.charAt(v) == 0x2F; ++v) {
        }
        return v <= 1 ? s : s.substring(v - 1);
    }

    private List parseQuery(String s, Charset charset0) {
        return s == null || s.length() <= 0 ? null : URLEncodedUtilsHC4.parse(s, charset0);
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCustomQuery(String s) {
        this.query = s;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String s) {
        this.fragment = s;
        this.encodedFragment = null;
        return this;
    }

    public URIBuilder setHost(String s) {
        this.host = s;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setParameter(String s, String s1) {
        if(this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if(!this.queryParams.isEmpty()) {
            Iterator iterator0 = this.queryParams.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(((NameValuePair)object0).getName().equals(s)) {
                    iterator0.remove();
                }
            }
        }
        this.queryParams.add(new BasicNameValuePair(s, s1));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(List list0) {
        List list1 = this.queryParams;
        if(list1 == null) {
            this.queryParams = new ArrayList();
        }
        else {
            list1.clear();
        }
        this.queryParams.addAll(list0);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(NameValuePair[] arr_nameValuePair) {
        List list0 = this.queryParams;
        if(list0 == null) {
            this.queryParams = new ArrayList();
        }
        else {
            list0.clear();
        }
        for(int v = 0; v < arr_nameValuePair.length; ++v) {
            this.queryParams.add(arr_nameValuePair[v]);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setPath(String s) {
        this.path = s;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder setPort(int v) {
        if(v < 0) {
            v = -1;
        }
        this.port = v;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    @Deprecated
    public URIBuilder setQuery(String s) {
        this.queryParams = this.parseQuery(s, Consts.UTF_8);
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setScheme(String s) {
        this.scheme = s;
        return this;
    }

    public URIBuilder setUserInfo(String s) {
        this.userInfo = s;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String s, String s1) {
        return this.setUserInfo(s + ':' + s1);
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return "";
    }
}

