package org.apache.http.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderValueFormatterHC4;
import org.apache.http.message.BasicHeaderValueParserHC4;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.TextUtils;

@Immutable
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML = null;
    public static final ContentType APPLICATION_FORM_URLENCODED = null;
    public static final ContentType APPLICATION_JSON = null;
    public static final ContentType APPLICATION_OCTET_STREAM = null;
    public static final ContentType APPLICATION_SVG_XML = null;
    public static final ContentType APPLICATION_XHTML_XML = null;
    public static final ContentType APPLICATION_XML = null;
    public static final ContentType DEFAULT_BINARY = null;
    public static final ContentType DEFAULT_TEXT = null;
    public static final ContentType MULTIPART_FORM_DATA = null;
    public static final ContentType TEXT_HTML = null;
    public static final ContentType TEXT_PLAIN = null;
    public static final ContentType TEXT_XML = null;
    public static final ContentType WILDCARD = null;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;
    private static final long serialVersionUID = 0x94300D50674E5D48L;

    static {
        ContentType.APPLICATION_ATOM_XML = ContentType.create("application/atom+xml", Consts.ISO_8859_1);
        ContentType.APPLICATION_FORM_URLENCODED = ContentType.create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
        ContentType.APPLICATION_JSON = ContentType.create("application/json", Consts.UTF_8);
        ContentType contentType0 = ContentType.create("application/octet-stream", null);
        ContentType.APPLICATION_OCTET_STREAM = contentType0;
        ContentType.APPLICATION_SVG_XML = ContentType.create("application/svg+xml", Consts.ISO_8859_1);
        ContentType.APPLICATION_XHTML_XML = ContentType.create("application/xhtml+xml", Consts.ISO_8859_1);
        ContentType.APPLICATION_XML = ContentType.create("application/xml", Consts.ISO_8859_1);
        ContentType.MULTIPART_FORM_DATA = ContentType.create("multipart/form-data", Consts.ISO_8859_1);
        ContentType.TEXT_HTML = ContentType.create("text/html", Consts.ISO_8859_1);
        ContentType contentType1 = ContentType.create("text/plain", Consts.ISO_8859_1);
        ContentType.TEXT_PLAIN = contentType1;
        ContentType.TEXT_XML = ContentType.create("text/xml", Consts.ISO_8859_1);
        ContentType.WILDCARD = ContentType.create("*/*", null);
        ContentType.DEFAULT_TEXT = contentType1;
        ContentType.DEFAULT_BINARY = contentType0;
    }

    public ContentType(String s, Charset charset0) {
        this.mimeType = s;
        this.charset = charset0;
        this.params = null;
    }

    public ContentType(String s, NameValuePair[] arr_nameValuePair) {
        this.mimeType = s;
        this.params = arr_nameValuePair;
        String s1 = this.getParameter("charset");
        this.charset = TextUtils.isBlank(s1) ? null : Charset.forName(s1);
    }

    public static ContentType create(String s) {
        return new ContentType(s, null);
    }

    public static ContentType create(String s, String s1) {
        return TextUtils.isBlank(s1) ? ContentType.create(s, null) : ContentType.create(s, Charset.forName(s1));
    }

    public static ContentType create(String s, Charset charset0) {
        String s1 = ((String)Args.notBlank(s, "MIME type")).toLowerCase(Locale.US);
        Args.check(ContentType.valid(s1), "MIME type may not contain reserved characters");
        return new ContentType(s1, charset0);
    }

    private static ContentType create(HeaderElement headerElement0) {
        String s = headerElement0.getName();
        NameValuePair[] arr_nameValuePair = headerElement0.getParameters();
        if(arr_nameValuePair == null || arr_nameValuePair.length <= 0) {
            arr_nameValuePair = null;
        }
        return new ContentType(s, arr_nameValuePair);
    }

    public static ContentType get(HttpEntity httpEntity0) {
        if(httpEntity0 == null) {
            return null;
        }
        Header header0 = httpEntity0.getContentType();
        if(header0 != null) {
            HeaderElement[] arr_headerElement = header0.getElements();
            return arr_headerElement.length <= 0 ? null : ContentType.create(arr_headerElement[0]);
        }
        return null;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public static ContentType getOrDefault(HttpEntity httpEntity0) {
        ContentType contentType0 = ContentType.get(httpEntity0);
        return contentType0 == null ? ContentType.DEFAULT_TEXT : contentType0;
    }

    public String getParameter(String s) {
        Args.notEmpty(s, "Parameter name");
        NameValuePair[] arr_nameValuePair = this.params;
        if(arr_nameValuePair == null) {
            return null;
        }
        for(int v = 0; v < arr_nameValuePair.length; ++v) {
            NameValuePair nameValuePair0 = arr_nameValuePair[v];
            if(nameValuePair0.getName().equalsIgnoreCase(s)) {
                return nameValuePair0.getValue();
            }
        }
        return null;
    }

    public static ContentType parse(String s) {
        Args.notNull(s, "Content type");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        HeaderElement[] arr_headerElement = BasicHeaderValueParserHC4.INSTANCE.parseElements(charArrayBuffer0, parserCursor0);
        if(arr_headerElement.length <= 0) {
            throw new ParseException("Invalid content type: " + s);
        }
        return ContentType.create(arr_headerElement[0]);
    }

    @Override
    public String toString() {
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(0x40);
        charArrayBuffer0.append(this.mimeType);
        if(this.params != null) {
            charArrayBuffer0.append("; ");
            BasicHeaderValueFormatterHC4.INSTANCE.formatParameters(charArrayBuffer0, this.params, false);
            return charArrayBuffer0.toString();
        }
        if(this.charset != null) {
            charArrayBuffer0.append("; charset=");
            charArrayBuffer0.append(this.charset.name());
        }
        return charArrayBuffer0.toString();
    }

    private static boolean valid(String s) {
        int v = 0;
        while(v < s.length()) {
            if(s.charAt(v) != 34 && s.charAt(v) != 44 && s.charAt(v) != 59) {
                ++v;
                continue;
            }
            return false;
        }
        return true;
    }

    public ContentType withCharset(String s) {
        return ContentType.create(this.getMimeType(), s);
    }

    public ContentType withCharset(Charset charset0) {
        return ContentType.create(this.getMimeType(), charset0);
    }
}

