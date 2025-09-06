package org.apache.http.client.utils;

import b3.Z;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import k8.Y;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Immutable
public class URIUtilsHC4 {
    @Deprecated
    public static URI createURI(String s, String s1, int v, String s2, String s3, String s4) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(s1 != null) {
            if(s != null) {
                stringBuilder0.append(s);
                stringBuilder0.append("://");
            }
            stringBuilder0.append(s1);
            if(v > 0) {
                stringBuilder0.append(':');
                stringBuilder0.append(v);
            }
        }
        if(s2 == null || !s2.startsWith("/")) {
            stringBuilder0.append('/');
        }
        if(s2 != null) {
            stringBuilder0.append(s2);
        }
        if(s3 != null) {
            stringBuilder0.append('?');
            stringBuilder0.append(s3);
        }
        if(s4 != null) {
            stringBuilder0.append('#');
            stringBuilder0.append(s4);
        }
        return new URI(stringBuilder0.toString());
    }

    public static HttpHost extractHost(URI uRI0) {
        if(uRI0 == null) {
            return null;
        }
        if(uRI0.isAbsolute()) {
            int v = uRI0.getPort();
            String s = uRI0.getHost();
            if(s == null) {
                s = uRI0.getAuthority();
                if(s != null) {
                    int v1 = s.indexOf(0x40);
                    if(v1 >= 0) {
                        s = s.length() <= v1 + 1 ? null : s.substring(v1 + 1);
                    }
                    if(s != null) {
                        int v2 = s.indexOf(58);
                        if(v2 >= 0) {
                            int v3 = v2 + 1;
                            int v4 = 0;
                            while(v3 < s.length() && Character.isDigit(s.charAt(v3))) {
                                ++v4;
                                ++v3;
                            }
                            if(v4 > 0) {
                                try {
                                    v = Integer.parseInt(s.substring(v2 + 1, v4 + (v2 + 1)));
                                }
                                catch(NumberFormatException unused_ex) {
                                }
                            }
                            s = s.substring(0, v2);
                        }
                    }
                }
            }
            String s1 = uRI0.getScheme();
            return TextUtils.isBlank(s) ? null : new HttpHost(s, v, s1);
        }
        return null;
    }

    private static URI normalizeSyntax(URI uRI0) {
        if(!uRI0.isOpaque() && uRI0.getAuthority() != null) {
            Args.check(uRI0.isAbsolute(), "Base URI must be absolute");
            String s = uRI0.getPath() == null ? "" : uRI0.getPath();
            String[] arr_s = s.split("/");
            Stack stack0 = new Stack();
            for(int v = 0; v < arr_s.length; ++v) {
                String s1 = arr_s[v];
                if(s1.length() != 0 && !".".equals(s1)) {
                    if(!"..".equals(s1)) {
                        stack0.push(s1);
                    }
                    else if(!stack0.isEmpty()) {
                        stack0.pop();
                    }
                }
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: stack0) {
                stringBuilder0.append('/');
                stringBuilder0.append(((String)object0));
            }
            if(s.lastIndexOf(0x2F) == s.length() - 1) {
                stringBuilder0.append('/');
            }
            try {
                String s2 = uRI0.getScheme();
                Locale locale0 = Locale.ENGLISH;
                URI uRI1 = new URI(s2.toLowerCase(locale0), uRI0.getAuthority().toLowerCase(locale0), stringBuilder0.toString(), null, null);
                if(uRI0.getQuery() == null && uRI0.getFragment() == null) {
                    return uRI1;
                }
                StringBuilder stringBuilder1 = new StringBuilder(uRI1.toASCIIString());
                if(uRI0.getQuery() != null) {
                    stringBuilder1.append('?');
                    stringBuilder1.append(uRI0.getRawQuery());
                }
                if(uRI0.getFragment() != null) {
                    stringBuilder1.append('#');
                    stringBuilder1.append(uRI0.getRawFragment());
                }
                return URI.create(stringBuilder1.toString());
            }
            catch(URISyntaxException uRISyntaxException0) {
                throw new IllegalArgumentException(uRISyntaxException0);
            }
        }
        return uRI0;
    }

    public static URI resolve(URI uRI0, String s) {
        return URIUtilsHC4.resolve(uRI0, URI.create(s));
    }

    public static URI resolve(URI uRI0, URI uRI1) {
        Args.notNull(uRI0, "Base URI");
        Args.notNull(uRI1, "Reference URI");
        String s = uRI1.toString();
        if(s.startsWith("?")) {
            return URIUtilsHC4.resolveReferenceStartingWithQueryString(uRI0, uRI1);
        }
        boolean z = s.length() == 0;
        if(z) {
            uRI1 = URI.create("#");
        }
        URI uRI2 = uRI0.resolve(uRI1);
        if(z) {
            String s1 = uRI2.toString();
            uRI2 = URI.create(s1.substring(0, s1.indexOf(35)));
        }
        return URIUtilsHC4.normalizeSyntax(uRI2);
    }

    public static URI resolve(URI uRI0, HttpHost httpHost0, List list0) {
        URIBuilder uRIBuilder0;
        Args.notNull(uRI0, "Request URI");
        if(list0 == null || list0.isEmpty()) {
            uRIBuilder0 = new URIBuilder(uRI0);
        }
        else {
            uRIBuilder0 = new URIBuilder(((URI)Z.h(1, list0)));
            String s = uRIBuilder0.getFragment();
            for(int v = list0.size() - 1; s == null && v >= 0; --v) {
                s = ((URI)list0.get(v)).getFragment();
            }
            uRIBuilder0.setFragment(s);
        }
        if(uRIBuilder0.getFragment() == null) {
            uRIBuilder0.setFragment(uRI0.getFragment());
        }
        if(httpHost0 != null && !uRIBuilder0.isAbsolute()) {
            uRIBuilder0.setScheme(httpHost0.getSchemeName());
            uRIBuilder0.setHost(httpHost0.getHostName());
            uRIBuilder0.setPort(httpHost0.getPort());
        }
        return uRIBuilder0.build();
    }

    private static URI resolveReferenceStartingWithQueryString(URI uRI0, URI uRI1) {
        String s = uRI0.toString();
        if(s.indexOf(0x3F) > -1) {
            s = s.substring(0, s.indexOf(0x3F));
        }
        StringBuilder stringBuilder0 = Y.p(s);
        stringBuilder0.append(uRI1.toString());
        return URI.create(stringBuilder0.toString());
    }

    public static URI rewriteURI(URI uRI0) {
        Args.notNull(uRI0, "URI");
        if(uRI0.isOpaque()) {
            return uRI0;
        }
        URIBuilder uRIBuilder0 = new URIBuilder(uRI0);
        if(uRIBuilder0.getUserInfo() != null) {
            uRIBuilder0.setUserInfo(null);
        }
        if(TextUtils.isEmpty(uRIBuilder0.getPath())) {
            uRIBuilder0.setPath("/");
        }
        if(uRIBuilder0.getHost() != null) {
            uRIBuilder0.setHost(uRIBuilder0.getHost().toLowerCase(Locale.ENGLISH));
        }
        uRIBuilder0.setFragment(null);
        return uRIBuilder0.build();
    }

    public static URI rewriteURI(URI uRI0, HttpHost httpHost0) {
        return URIUtilsHC4.rewriteURI(uRI0, httpHost0, false);
    }

    public static URI rewriteURI(URI uRI0, HttpHost httpHost0, boolean z) {
        Args.notNull(uRI0, "URI");
        if(uRI0.isOpaque()) {
            return uRI0;
        }
        URIBuilder uRIBuilder0 = new URIBuilder(uRI0);
        if(httpHost0 == null) {
            uRIBuilder0.setScheme(null);
            uRIBuilder0.setHost(null);
            uRIBuilder0.setPort(-1);
        }
        else {
            uRIBuilder0.setScheme(httpHost0.getSchemeName());
            uRIBuilder0.setHost(httpHost0.getHostName());
            uRIBuilder0.setPort(httpHost0.getPort());
        }
        if(z) {
            uRIBuilder0.setFragment(null);
        }
        if(TextUtils.isEmpty(uRIBuilder0.getPath())) {
            uRIBuilder0.setPath("/");
        }
        return uRIBuilder0.build();
    }
}

