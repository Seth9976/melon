package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicLineParserHC4 implements LineParser {
    @Deprecated
    public static final BasicLineParserHC4 DEFAULT;
    public static final BasicLineParserHC4 INSTANCE;
    protected final ProtocolVersion protocol;

    static {
        BasicLineParserHC4.DEFAULT = new BasicLineParserHC4();
        BasicLineParserHC4.INSTANCE = new BasicLineParserHC4();
    }

    public BasicLineParserHC4() {
        this(null);
    }

    public BasicLineParserHC4(ProtocolVersion protocolVersion0) {
        if(protocolVersion0 == null) {
            protocolVersion0 = HttpVersion.HTTP_1_1;
        }
        this.protocol = protocolVersion0;
    }

    public ProtocolVersion createProtocolVersion(int v, int v1) {
        return this.protocol.forVersion(v, v1);
    }

    public RequestLine createRequestLine(String s, String s1, ProtocolVersion protocolVersion0) {
        return new BasicRequestLine(s, s1, protocolVersion0);
    }

    public StatusLine createStatusLine(ProtocolVersion protocolVersion0, int v, String s) {
        return new BasicStatusLine(protocolVersion0, v, s);
    }

    @Override  // org.apache.http.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        int v = parserCursor0.getPos();
        String s = this.protocol.getProtocol();
        int v1 = s.length();
        if(charArrayBuffer0.length() < v1 + 4) {
            return false;
        }
        if(v < 0) {
            v = charArrayBuffer0.length() - 4 - v1;
        }
        else if(v == 0) {
            while(v < charArrayBuffer0.length() && HTTP.isWhitespace(charArrayBuffer0.charAt(v))) {
                ++v;
            }
        }
        int v2 = v + v1;
        if(v2 + 4 > charArrayBuffer0.length()) {
            return false;
        }
        boolean z = true;
        for(int v3 = 0; z && v3 < v1; ++v3) {
            z = charArrayBuffer0.charAt(v + v3) == s.charAt(v3);
        }
        return z && charArrayBuffer0.charAt(v2) == 0x2F;
    }

    public static Header parseHeader(String s, LineParser lineParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        return lineParser0.parseHeader(charArrayBuffer0);
    }

    @Override  // org.apache.http.message.LineParser
    public Header parseHeader(CharArrayBuffer charArrayBuffer0) {
        return new BufferedHeader(charArrayBuffer0);
    }

    public static ProtocolVersion parseProtocolVersion(String s, LineParser lineParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        return lineParser0.parseProtocolVersion(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        int v12;
        int v10;
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        String s = this.protocol.getProtocol();
        int v = s.length();
        int v1 = parserCursor0.getPos();
        int v2 = parserCursor0.getUpperBound();
        this.skipWhitespace(charArrayBuffer0, parserCursor0);
        int v3 = parserCursor0.getPos();
        int v4 = v3 + v;
        if(v4 + 4 > v2) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer0.substring(v1, v2));
        }
        int v5 = 0;
        int v7 = 1;
        for(int v6 = 0; v7 != 0 && v6 < v; ++v6) {
            v7 = charArrayBuffer0.charAt(v3 + v6) == s.charAt(v6) ? 1 : 0;
        }
        if(v7 != 0) {
            if(charArrayBuffer0.charAt(v4) == 0x2F) {
                v5 = 1;
            }
            v7 = v5;
        }
        if(v7 == 0) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer0.substring(v1, v2));
        }
        int v8 = v + 1 + v3;
        int v9 = charArrayBuffer0.indexOf(46, v8, v2);
        if(v9 == -1) {
            throw new ParseException("Invalid protocol version number: " + charArrayBuffer0.substring(v1, v2));
        }
        try {
            v10 = Integer.parseInt(charArrayBuffer0.substringTrimmed(v8, v9));
        }
        catch(NumberFormatException unused_ex) {
            throw new ParseException("Invalid protocol major version number: " + charArrayBuffer0.substring(v1, v2));
        }
        int v11 = charArrayBuffer0.indexOf(0x20, v9 + 1, v2);
        if(v11 == -1) {
            v11 = v2;
        }
        try {
            v12 = Integer.parseInt(charArrayBuffer0.substringTrimmed(v9 + 1, v11));
        }
        catch(NumberFormatException unused_ex) {
            throw new ParseException("Invalid protocol minor version number: " + charArrayBuffer0.substring(v1, v2));
        }
        parserCursor0.updatePos(v11);
        return this.createProtocolVersion(v10, v12);
    }

    public static RequestLine parseRequestLine(String s, LineParser lineParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        return lineParser0.parseRequestLine(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getUpperBound();
        try {
            this.skipWhitespace(charArrayBuffer0, parserCursor0);
            int v2 = parserCursor0.getPos();
            int v3 = charArrayBuffer0.indexOf(0x20, v2, v1);
            if(v3 < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer0.substring(v, v1));
            }
            String s = charArrayBuffer0.substringTrimmed(v2, v3);
            parserCursor0.updatePos(v3);
            this.skipWhitespace(charArrayBuffer0, parserCursor0);
            int v4 = parserCursor0.getPos();
            int v5 = charArrayBuffer0.indexOf(0x20, v4, v1);
            if(v5 < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer0.substring(v, v1));
            }
            String s1 = charArrayBuffer0.substringTrimmed(v4, v5);
            parserCursor0.updatePos(v5);
            ProtocolVersion protocolVersion0 = this.parseProtocolVersion(charArrayBuffer0, parserCursor0);
            this.skipWhitespace(charArrayBuffer0, parserCursor0);
            if(!parserCursor0.atEnd()) {
                throw new ParseException("Invalid request line: " + charArrayBuffer0.substring(v, v1));
            }
            return this.createRequestLine(s, s1, protocolVersion0);
        }
        catch(IndexOutOfBoundsException unused_ex) {
            throw new ParseException("Invalid request line: " + charArrayBuffer0.substring(v, v1));
        }
    }

    public static StatusLine parseStatusLine(String s, LineParser lineParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        return lineParser0.parseStatusLine(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        int v5;
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getUpperBound();
        try {
            ProtocolVersion protocolVersion0 = this.parseProtocolVersion(charArrayBuffer0, parserCursor0);
            this.skipWhitespace(charArrayBuffer0, parserCursor0);
            int v2 = parserCursor0.getPos();
            int v3 = charArrayBuffer0.indexOf(0x20, v2, v1);
            if(v3 < 0) {
                v3 = v1;
            }
            String s = charArrayBuffer0.substringTrimmed(v2, v3);
            for(int v4 = 0; v4 < s.length(); ++v4) {
                if(!Character.isDigit(s.charAt(v4))) {
                    throw new ParseException("Status line contains invalid status code: " + charArrayBuffer0.substring(v, v1));
                }
            }
            try {
                v5 = Integer.parseInt(s);
            }
            catch(NumberFormatException unused_ex) {
                throw new ParseException("Status line contains invalid status code: " + charArrayBuffer0.substring(v, v1));
            }
            String s1 = v3 < v1 ? charArrayBuffer0.substringTrimmed(v3, v1) : "";
            return this.createStatusLine(protocolVersion0, v5, s1);
        }
        catch(IndexOutOfBoundsException unused_ex) {
            throw new ParseException("Invalid status line: " + charArrayBuffer0.substring(v, v1));
        }
    }

    public void skipWhitespace(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getUpperBound();
        while(v < v1 && HTTP.isWhitespace(charArrayBuffer0.charAt(v))) {
            ++v;
        }
        parserCursor0.updatePos(v);
    }
}

