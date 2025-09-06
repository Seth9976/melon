package org.apache.http.client.utils;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeaderValueParserHC4;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtilsHC4;

@Immutable
public class URLEncodedUtilsHC4 {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final BitSet PATHSAFE = null;
    private static final BitSet PUNCT = null;
    private static final char[] QP_SEPS = null;
    private static final char QP_SEP_A = '&';
    private static final String QP_SEP_PATTERN = null;
    private static final char QP_SEP_S = ';';
    private static final int RADIX = 16;
    private static final BitSet RESERVED;
    private static final BitSet UNRESERVED;
    private static final BitSet URIC;
    private static final BitSet URLENCODER;
    private static final BitSet USERINFO;

    static {
        URLEncodedUtilsHC4.QP_SEPS = new char[]{'&', ';'};
        URLEncodedUtilsHC4.QP_SEP_PATTERN = "[&;]";
        URLEncodedUtilsHC4.UNRESERVED = new BitSet(0x100);
        URLEncodedUtilsHC4.PUNCT = new BitSet(0x100);
        URLEncodedUtilsHC4.USERINFO = new BitSet(0x100);
        URLEncodedUtilsHC4.PATHSAFE = new BitSet(0x100);
        URLEncodedUtilsHC4.URIC = new BitSet(0x100);
        URLEncodedUtilsHC4.RESERVED = new BitSet(0x100);
        URLEncodedUtilsHC4.URLENCODER = new BitSet(0x100);
        for(int v = 97; v <= 0x7A; ++v) {
            URLEncodedUtilsHC4.UNRESERVED.set(v);
        }
        for(int v1 = 65; v1 <= 90; ++v1) {
            URLEncodedUtilsHC4.UNRESERVED.set(v1);
        }
        for(int v2 = 0x30; v2 <= 57; ++v2) {
            URLEncodedUtilsHC4.UNRESERVED.set(v2);
        }
        URLEncodedUtilsHC4.UNRESERVED.set(0x5F);
        URLEncodedUtilsHC4.UNRESERVED.set(45);
        URLEncodedUtilsHC4.UNRESERVED.set(46);
        URLEncodedUtilsHC4.UNRESERVED.set(42);
        URLEncodedUtilsHC4.URLENCODER.or(URLEncodedUtilsHC4.UNRESERVED);
        URLEncodedUtilsHC4.UNRESERVED.set(33);
        URLEncodedUtilsHC4.UNRESERVED.set(0x7E);
        URLEncodedUtilsHC4.UNRESERVED.set(39);
        URLEncodedUtilsHC4.UNRESERVED.set(40);
        URLEncodedUtilsHC4.UNRESERVED.set(41);
        URLEncodedUtilsHC4.PUNCT.set(44);
        URLEncodedUtilsHC4.PUNCT.set(59);
        URLEncodedUtilsHC4.PUNCT.set(58);
        URLEncodedUtilsHC4.PUNCT.set(36);
        URLEncodedUtilsHC4.PUNCT.set(38);
        URLEncodedUtilsHC4.PUNCT.set(43);
        URLEncodedUtilsHC4.PUNCT.set(61);
        URLEncodedUtilsHC4.USERINFO.or(URLEncodedUtilsHC4.UNRESERVED);
        URLEncodedUtilsHC4.USERINFO.or(URLEncodedUtilsHC4.PUNCT);
        URLEncodedUtilsHC4.PATHSAFE.or(URLEncodedUtilsHC4.UNRESERVED);
        URLEncodedUtilsHC4.PATHSAFE.set(0x2F);
        URLEncodedUtilsHC4.PATHSAFE.set(59);
        URLEncodedUtilsHC4.PATHSAFE.set(58);
        URLEncodedUtilsHC4.PATHSAFE.set(0x40);
        URLEncodedUtilsHC4.PATHSAFE.set(38);
        URLEncodedUtilsHC4.PATHSAFE.set(61);
        URLEncodedUtilsHC4.PATHSAFE.set(43);
        URLEncodedUtilsHC4.PATHSAFE.set(36);
        URLEncodedUtilsHC4.PATHSAFE.set(44);
        URLEncodedUtilsHC4.RESERVED.set(59);
        URLEncodedUtilsHC4.RESERVED.set(0x2F);
        URLEncodedUtilsHC4.RESERVED.set(0x3F);
        URLEncodedUtilsHC4.RESERVED.set(58);
        URLEncodedUtilsHC4.RESERVED.set(0x40);
        URLEncodedUtilsHC4.RESERVED.set(38);
        URLEncodedUtilsHC4.RESERVED.set(61);
        URLEncodedUtilsHC4.RESERVED.set(43);
        URLEncodedUtilsHC4.RESERVED.set(36);
        URLEncodedUtilsHC4.RESERVED.set(44);
        URLEncodedUtilsHC4.RESERVED.set(91);
        URLEncodedUtilsHC4.RESERVED.set(93);
        URLEncodedUtilsHC4.URIC.or(URLEncodedUtilsHC4.RESERVED);
        URLEncodedUtilsHC4.URIC.or(URLEncodedUtilsHC4.UNRESERVED);
    }

    private static String decodeFormFields(String s, String s1) {
        if(s == null) {
            return null;
        }
        return s1 == null ? URLEncodedUtilsHC4.urlDecode(s, Consts.UTF_8, true) : URLEncodedUtilsHC4.urlDecode(s, Charset.forName(s1), true);
    }

    private static String decodeFormFields(String s, Charset charset0) {
        if(s == null) {
            return null;
        }
        if(charset0 == null) {
            charset0 = Consts.UTF_8;
        }
        return URLEncodedUtilsHC4.urlDecode(s, charset0, true);
    }

    public static String encPath(String s, Charset charset0) {
        return URLEncodedUtilsHC4.urlEncode(s, charset0, URLEncodedUtilsHC4.PATHSAFE, false);
    }

    public static String encUric(String s, Charset charset0) {
        return URLEncodedUtilsHC4.urlEncode(s, charset0, URLEncodedUtilsHC4.URIC, false);
    }

    public static String encUserInfo(String s, Charset charset0) {
        return URLEncodedUtilsHC4.urlEncode(s, charset0, URLEncodedUtilsHC4.USERINFO, false);
    }

    private static String encodeFormFields(String s, String s1) {
        if(s == null) {
            return null;
        }
        return s1 == null ? URLEncodedUtilsHC4.urlEncode(s, Consts.UTF_8, URLEncodedUtilsHC4.URLENCODER, true) : URLEncodedUtilsHC4.urlEncode(s, Charset.forName(s1), URLEncodedUtilsHC4.URLENCODER, true);
    }

    private static String encodeFormFields(String s, Charset charset0) {
        if(s == null) {
            return null;
        }
        if(charset0 == null) {
            charset0 = Consts.UTF_8;
        }
        return URLEncodedUtilsHC4.urlEncode(s, charset0, URLEncodedUtilsHC4.URLENCODER, true);
    }

    public static String format(Iterable iterable0, char c, Charset charset0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: iterable0) {
            String s = URLEncodedUtilsHC4.encodeFormFields(((NameValuePair)object0).getName(), charset0);
            String s1 = URLEncodedUtilsHC4.encodeFormFields(((NameValuePair)object0).getValue(), charset0);
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(c);
            }
            stringBuilder0.append(s);
            if(s1 != null) {
                stringBuilder0.append("=");
                stringBuilder0.append(s1);
            }
        }
        return stringBuilder0.toString();
    }

    public static String format(Iterable iterable0, Charset charset0) {
        return URLEncodedUtilsHC4.format(iterable0, '&', charset0);
    }

    public static String format(List list0, char c, String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: list0) {
            String s1 = URLEncodedUtilsHC4.encodeFormFields(((NameValuePair)object0).getName(), s);
            String s2 = URLEncodedUtilsHC4.encodeFormFields(((NameValuePair)object0).getValue(), s);
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(c);
            }
            stringBuilder0.append(s1);
            if(s2 != null) {
                stringBuilder0.append("=");
                stringBuilder0.append(s2);
            }
        }
        return stringBuilder0.toString();
    }

    public static String format(List list0, String s) {
        return URLEncodedUtilsHC4.format(list0, '&', s);
    }

    public static boolean isEncoded(HttpEntity httpEntity0) {
        Header header0 = httpEntity0.getContentType();
        if(header0 != null) {
            HeaderElement[] arr_headerElement = header0.getElements();
            return arr_headerElement.length <= 0 ? false : arr_headerElement[0].getName().equalsIgnoreCase("application/x-www-form-urlencoded");
        }
        return false;
    }

    public static List parse(String s, Charset charset0) {
        return URLEncodedUtilsHC4.parse(s, charset0, URLEncodedUtilsHC4.QP_SEPS);
    }

    public static List parse(String s, Charset charset0, char[] arr_c) {
        if(s == null) {
            return Collections.EMPTY_LIST;
        }
        BasicHeaderValueParserHC4 basicHeaderValueParserHC40 = BasicHeaderValueParserHC4.INSTANCE;
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, charArrayBuffer0.length());
        List list0 = new ArrayList();
        while(!parserCursor0.atEnd()) {
            NameValuePair nameValuePair0 = basicHeaderValueParserHC40.parseNameValuePair(charArrayBuffer0, parserCursor0, arr_c);
            if(nameValuePair0.getName().length() > 0) {
                ((ArrayList)list0).add(new BasicNameValuePair(URLEncodedUtilsHC4.decodeFormFields(nameValuePair0.getName(), charset0), URLEncodedUtilsHC4.decodeFormFields(nameValuePair0.getValue(), charset0)));
            }
        }
        return list0;
    }

    public static List parse(URI uRI0, String s) {
        String s1 = uRI0.getRawQuery();
        if(s1 != null && s1.length() > 0) {
            List list0 = new ArrayList();
            URLEncodedUtilsHC4.parse(list0, new Scanner(s1), "[&;]", s);
            return list0;
        }
        return Collections.EMPTY_LIST;
    }

    public static List parse(HttpEntity httpEntity0) {
        ContentType contentType0 = ContentType.get(httpEntity0);
        if(contentType0 != null && contentType0.getMimeType().equalsIgnoreCase("application/x-www-form-urlencoded")) {
            String s = EntityUtilsHC4.toString(httpEntity0, Consts.ASCII);
            return s == null || s.length() <= 0 ? Collections.EMPTY_LIST : URLEncodedUtilsHC4.parse(s, (contentType0.getCharset() == null ? Charset.forName("ISO-8859-1") : contentType0.getCharset()), URLEncodedUtilsHC4.QP_SEPS);
        }
        return Collections.EMPTY_LIST;
    }

    public static void parse(List list0, Scanner scanner0, String s) {
        URLEncodedUtilsHC4.parse(list0, scanner0, "[&;]", s);
    }

    public static void parse(List list0, Scanner scanner0, String s, String s1) {
        String s4;
        String s3;
        scanner0.useDelimiter(s);
        while(scanner0.hasNext()) {
            String s2 = scanner0.next();
            int v = s2.indexOf("=");
            if(v == -1) {
                s3 = URLEncodedUtilsHC4.decodeFormFields(s2.trim(), s1);
                s4 = null;
            }
            else {
                s3 = URLEncodedUtilsHC4.decodeFormFields(s2.substring(0, v).trim(), s1);
                s4 = URLEncodedUtilsHC4.decodeFormFields(s2.substring(v + 1).trim(), s1);
            }
            list0.add(new BasicNameValuePair(s3, s4));
        }
    }

    private static String urlDecode(String s, Charset charset0, boolean z) {
        if(s == null) {
            return null;
        }
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(s.length());
        CharBuffer charBuffer0 = CharBuffer.wrap(s);
        while(charBuffer0.hasRemaining()) {
            int v = charBuffer0.get();
            if(v == 37 && charBuffer0.remaining() >= 2) {
                int v1 = charBuffer0.get();
                int v2 = charBuffer0.get();
                int v3 = Character.digit(((char)v1), 16);
                int v4 = Character.digit(((char)v2), 16);
                if(v3 == -1 || v4 == -1) {
                    byteBuffer0.put(37);
                    byteBuffer0.put(((byte)v1));
                    byteBuffer0.put(((byte)v2));
                }
                else {
                    byteBuffer0.put(((byte)((v3 << 4) + v4)));
                }
            }
            else if(z && v == 43) {
                byteBuffer0.put(0x20);
            }
            else {
                byteBuffer0.put(((byte)v));
            }
        }
        byteBuffer0.flip();
        return charset0.decode(byteBuffer0).toString();
    }

    private static String urlEncode(String s, Charset charset0, BitSet bitSet0, boolean z) {
        if(s == null) {
            return null;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        ByteBuffer byteBuffer0 = charset0.encode(s);
        while(byteBuffer0.hasRemaining()) {
            int v = byteBuffer0.get();
            int v1 = v & 0xFF;
            if(bitSet0.get(v1)) {
                stringBuilder0.append(((char)v1));
            }
            else if(z && v1 == 0x20) {
                stringBuilder0.append('+');
            }
            else {
                stringBuilder0.append("%");
                stringBuilder0.append(Character.toUpperCase(Character.forDigit(v1 >> 4 & 15, 16)));
                stringBuilder0.append(Character.toUpperCase(Character.forDigit(v & 15, 16)));
            }
        }
        return stringBuilder0.toString();
    }
}

