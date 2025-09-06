package org.apache.http.message;

import b3.Z;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicLineFormatterHC4 implements LineFormatter {
    @Deprecated
    public static final BasicLineFormatterHC4 DEFAULT;
    public static final BasicLineFormatterHC4 INSTANCE;

    static {
        BasicLineFormatterHC4.DEFAULT = new BasicLineFormatterHC4();
        BasicLineFormatterHC4.INSTANCE = new BasicLineFormatterHC4();
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer0, ProtocolVersion protocolVersion0) {
        Args.notNull(protocolVersion0, "Protocol version");
        int v = this.estimateProtocolVersionLen(protocolVersion0);
        if(charArrayBuffer0 == null) {
            charArrayBuffer0 = new CharArrayBuffer(v);
        }
        else {
            charArrayBuffer0.ensureCapacity(v);
        }
        charArrayBuffer0.append(protocolVersion0.getProtocol());
        charArrayBuffer0.append('/');
        charArrayBuffer0.append(Integer.toString(protocolVersion0.getMajor()));
        charArrayBuffer0.append('.');
        charArrayBuffer0.append(Integer.toString(protocolVersion0.getMinor()));
        return charArrayBuffer0;
    }

    public void doFormatHeader(CharArrayBuffer charArrayBuffer0, Header header0) {
        String s = header0.getName();
        String s1 = header0.getValue();
        int v = s.length() + 2;
        if(s1 != null) {
            v += s1.length();
        }
        charArrayBuffer0.ensureCapacity(v);
        charArrayBuffer0.append(s);
        charArrayBuffer0.append(": ");
        if(s1 != null) {
            charArrayBuffer0.append(s1);
        }
    }

    public void doFormatRequestLine(CharArrayBuffer charArrayBuffer0, RequestLine requestLine0) {
        String s = requestLine0.getMethod();
        String s1 = requestLine0.getUri();
        charArrayBuffer0.ensureCapacity(this.estimateProtocolVersionLen(requestLine0.getProtocolVersion()) + Z.d(s.length() + 1, 1, s1));
        charArrayBuffer0.append(s);
        charArrayBuffer0.append(' ');
        charArrayBuffer0.append(s1);
        charArrayBuffer0.append(' ');
        this.appendProtocolVersion(charArrayBuffer0, requestLine0.getProtocolVersion());
    }

    public void doFormatStatusLine(CharArrayBuffer charArrayBuffer0, StatusLine statusLine0) {
        int v = this.estimateProtocolVersionLen(statusLine0.getProtocolVersion()) + 5;
        String s = statusLine0.getReasonPhrase();
        if(s != null) {
            v += s.length();
        }
        charArrayBuffer0.ensureCapacity(v);
        this.appendProtocolVersion(charArrayBuffer0, statusLine0.getProtocolVersion());
        charArrayBuffer0.append(' ');
        charArrayBuffer0.append(Integer.toString(statusLine0.getStatusCode()));
        charArrayBuffer0.append(' ');
        if(s != null) {
            charArrayBuffer0.append(s);
        }
    }

    public int estimateProtocolVersionLen(ProtocolVersion protocolVersion0) {
        return protocolVersion0.getProtocol().length() + 4;
    }

    public static String formatHeader(Header header0, LineFormatter lineFormatter0) {
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        return lineFormatter0.formatHeader(null, header0).toString();
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer0, Header header0) {
        Args.notNull(header0, "Header");
        if(header0 instanceof FormattedHeader) {
            return ((FormattedHeader)header0).getBuffer();
        }
        CharArrayBuffer charArrayBuffer1 = this.initBuffer(charArrayBuffer0);
        this.doFormatHeader(charArrayBuffer1, header0);
        return charArrayBuffer1;
    }

    public static String formatProtocolVersion(ProtocolVersion protocolVersion0, LineFormatter lineFormatter0) {
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        return lineFormatter0.appendProtocolVersion(null, protocolVersion0).toString();
    }

    public static String formatRequestLine(RequestLine requestLine0, LineFormatter lineFormatter0) {
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        return lineFormatter0.formatRequestLine(null, requestLine0).toString();
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer0, RequestLine requestLine0) {
        Args.notNull(requestLine0, "Request line");
        CharArrayBuffer charArrayBuffer1 = this.initBuffer(charArrayBuffer0);
        this.doFormatRequestLine(charArrayBuffer1, requestLine0);
        return charArrayBuffer1;
    }

    public static String formatStatusLine(StatusLine statusLine0, LineFormatter lineFormatter0) {
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        return lineFormatter0.formatStatusLine(null, statusLine0).toString();
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer0, StatusLine statusLine0) {
        Args.notNull(statusLine0, "Status line");
        CharArrayBuffer charArrayBuffer1 = this.initBuffer(charArrayBuffer0);
        this.doFormatStatusLine(charArrayBuffer1, statusLine0);
        return charArrayBuffer1;
    }

    public CharArrayBuffer initBuffer(CharArrayBuffer charArrayBuffer0) {
        if(charArrayBuffer0 != null) {
            charArrayBuffer0.clear();
            return charArrayBuffer0;
        }
        return new CharArrayBuffer(0x40);
    }
}

