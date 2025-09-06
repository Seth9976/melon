package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import jeb.synthetic.TWR;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.entity.ContentType;

public final class EntityUtilsHC4 {
    public static void consume(HttpEntity httpEntity0) {
        if(httpEntity0 != null && httpEntity0.isStreaming()) {
            InputStream inputStream0 = httpEntity0.getContent();
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
    }

    public static void consumeQuietly(HttpEntity httpEntity0) {
        try {
            EntityUtilsHC4.consume(httpEntity0);
        }
        catch(IOException unused_ex) {
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity0) {
        Args.notNull(httpEntity0, "Entity");
        if(httpEntity0.getContentType() != null) {
            HeaderElement[] arr_headerElement = httpEntity0.getContentType().getElements();
            if(arr_headerElement.length > 0) {
                NameValuePair nameValuePair0 = arr_headerElement[0].getParameterByName("charset");
                return nameValuePair0 == null ? null : nameValuePair0.getValue();
            }
        }
        return null;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity0) {
        Args.notNull(httpEntity0, "Entity");
        if(httpEntity0.getContentType() != null) {
            HeaderElement[] arr_headerElement = httpEntity0.getContentType().getElements();
            return arr_headerElement.length <= 0 ? null : arr_headerElement[0].getName();
        }
        return null;
    }

    public static byte[] toByteArray(HttpEntity httpEntity0) {
        byte[] arr_b1;
        Args.notNull(httpEntity0, "Entity");
        InputStream inputStream0 = httpEntity0.getContent();
        if(inputStream0 == null) {
            return null;
        }
        try {
            Args.check(Long.compare(httpEntity0.getContentLength(), 0x7FFFFFFFL) <= 0, "HTTP entity too large to be buffered in memory");
            int v = (int)httpEntity0.getContentLength();
            if(v < 0) {
                v = 0x1000;
            }
            ByteArrayBuffer byteArrayBuffer0 = new ByteArrayBuffer(v);
            byte[] arr_b = new byte[0x1000];
            int v1;
            while((v1 = inputStream0.read(arr_b)) != -1) {
                byteArrayBuffer0.append(arr_b, 0, v1);
            }
            arr_b1 = byteArrayBuffer0.toByteArray();
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(inputStream0, throwable0);
            throw throwable0;
        }
        inputStream0.close();
        return arr_b1;
    }

    public static String toString(HttpEntity httpEntity0) {
        return EntityUtilsHC4.toString(httpEntity0, null);
    }

    public static String toString(HttpEntity httpEntity0, String s) {
        return s == null ? EntityUtilsHC4.toString(httpEntity0, null) : EntityUtilsHC4.toString(httpEntity0, Charset.forName(s));
    }

    public static String toString(HttpEntity httpEntity0, Charset charset0) {
        CharArrayBuffer charArrayBuffer0;
        Args.notNull(httpEntity0, "Entity");
        InputStream inputStream0 = httpEntity0.getContent();
        Charset charset1 = null;
        if(inputStream0 == null) {
            return null;
        }
        try {
            Args.check(Long.compare(httpEntity0.getContentLength(), 0x7FFFFFFFL) <= 0, "HTTP entity too large to be buffered in memory");
            int v = (int)httpEntity0.getContentLength();
            if(v < 0) {
                v = 0x1000;
            }
            try {
                ContentType contentType0 = ContentType.get(httpEntity0);
                if(contentType0 != null) {
                    charset1 = contentType0.getCharset();
                }
            }
            catch(UnsupportedCharsetException unsupportedCharsetException0) {
                throw new UnsupportedEncodingException(unsupportedCharsetException0.getMessage());
            }
            if(charset1 != null) {
                charset0 = charset1;
            }
            if(charset0 == null) {
                charset0 = Charset.forName("ISO-8859-1");
            }
            InputStreamReader inputStreamReader0 = new InputStreamReader(inputStream0, charset0);
            charArrayBuffer0 = new CharArrayBuffer(v);
            char[] arr_c = new char[0x400];
            int v1;
            while((v1 = inputStreamReader0.read(arr_c)) != -1) {
                charArrayBuffer0.append(arr_c, 0, v1);
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(inputStream0, throwable0);
            throw throwable0;
        }
        inputStream0.close();
        return charArrayBuffer0.toString();
    }

    public static void updateEntity(HttpResponse httpResponse0, HttpEntity httpEntity0) {
        Args.notNull(httpResponse0, "Response");
        EntityUtilsHC4.consume(httpResponse0.getEntity());
        httpResponse0.setEntity(httpEntity0);
    }
}

