package org.apache.http.client.entity;

import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.URLEncodedUtilsHC4;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntityHC4;

@NotThreadSafe
public class UrlEncodedFormEntityHC4 extends StringEntityHC4 {
    public UrlEncodedFormEntityHC4(Iterable iterable0) {
        this(iterable0, null);
    }

    public UrlEncodedFormEntityHC4(Iterable iterable0, Charset charset0) {
        super(URLEncodedUtilsHC4.format(iterable0, (charset0 == null ? Charset.forName("ISO-8859-1") : charset0)), ContentType.create("application/x-www-form-urlencoded", charset0));
    }

    public UrlEncodedFormEntityHC4(List list0) {
        this(list0, null);
    }

    public UrlEncodedFormEntityHC4(List list0, String s) {
        super(URLEncodedUtilsHC4.format(list0, (s == null ? "ISO-8859-1" : s)), ContentType.create("application/x-www-form-urlencoded", s));
    }
}

