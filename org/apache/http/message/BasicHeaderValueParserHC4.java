package org.apache.http.message;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicHeaderValueParserHC4 implements HeaderValueParser {
    private static final char[] ALL_DELIMITERS = null;
    @Deprecated
    public static final BasicHeaderValueParserHC4 DEFAULT = null;
    private static final char ELEM_DELIMITER = ',';
    public static final BasicHeaderValueParserHC4 INSTANCE = null;
    private static final char PARAM_DELIMITER = ';';

    static {
        BasicHeaderValueParserHC4.DEFAULT = new BasicHeaderValueParserHC4();
        BasicHeaderValueParserHC4.INSTANCE = new BasicHeaderValueParserHC4();
        BasicHeaderValueParserHC4.ALL_DELIMITERS = new char[]{';', ','};
    }

    public HeaderElement createHeaderElement(String s, String s1, NameValuePair[] arr_nameValuePair) {
        return new BasicHeaderElement(s, s1, arr_nameValuePair);
    }

    public NameValuePair createNameValuePair(String s, String s1) {
        return new BasicNameValuePair(s, s1);
    }

    private static boolean isOneOf(char c, char[] arr_c) {
        if(arr_c != null) {
            for(int v = 0; v < arr_c.length; ++v) {
                if(c == arr_c[v]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static HeaderElement[] parseElements(String s, HeaderValueParser headerValueParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(headerValueParser0 == null) {
            headerValueParser0 = BasicHeaderValueParserHC4.INSTANCE;
        }
        return headerValueParser0.parseElements(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        ArrayList arrayList0 = new ArrayList();
        while(!parserCursor0.atEnd()) {
            HeaderElement headerElement0 = this.parseHeaderElement(charArrayBuffer0, parserCursor0);
            if(headerElement0.getName().length() != 0 || headerElement0.getValue() != null) {
                arrayList0.add(headerElement0);
            }
        }
        return (HeaderElement[])arrayList0.toArray(new HeaderElement[arrayList0.size()]);
    }

    public static HeaderElement parseHeaderElement(String s, HeaderValueParser headerValueParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(headerValueParser0 == null) {
            headerValueParser0 = BasicHeaderValueParserHC4.INSTANCE;
        }
        return headerValueParser0.parseHeaderElement(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        NameValuePair nameValuePair0 = this.parseNameValuePair(charArrayBuffer0, parserCursor0);
        if(!parserCursor0.atEnd() && charArrayBuffer0.charAt(parserCursor0.getPos() - 1) != 44) {
            NameValuePair[] arr_nameValuePair = this.parseParameters(charArrayBuffer0, parserCursor0);
            return this.createHeaderElement(nameValuePair0.getName(), nameValuePair0.getValue(), arr_nameValuePair);
        }
        return this.createHeaderElement(nameValuePair0.getName(), nameValuePair0.getValue(), null);
    }

    public static NameValuePair parseNameValuePair(String s, HeaderValueParser headerValueParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(headerValueParser0 == null) {
            headerValueParser0 = BasicHeaderValueParserHC4.INSTANCE;
        }
        return headerValueParser0.parseNameValuePair(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        return this.parseNameValuePair(charArrayBuffer0, parserCursor0, BasicHeaderValueParserHC4.ALL_DELIMITERS);
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, char[] arr_c) {
        String s;
        boolean z1;
        boolean z;
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getPos();
        int v2 = parserCursor0.getUpperBound();
        while(true) {
            z = true;
            if(v < v2) {
                int v3 = charArrayBuffer0.charAt(v);
                if(v3 != 61) {
                    if(BasicHeaderValueParserHC4.isOneOf(((char)v3), arr_c)) {
                        z1 = true;
                        break;
                    }
                    ++v;
                    continue;
                }
            }
            z1 = false;
            break;
        }
        if(v == v2) {
            s = charArrayBuffer0.substringTrimmed(v1, v2);
            z1 = true;
        }
        else {
            s = charArrayBuffer0.substringTrimmed(v1, v);
            ++v;
        }
        if(z1) {
            parserCursor0.updatePos(v);
            return this.createNameValuePair(s, null);
        }
        int v4 = v;
        boolean z2 = false;
        int v5 = 0;
        while(true) {
            if(v4 >= v2) {
                z = false;
                break;
            }
            int v6 = charArrayBuffer0.charAt(v4);
            if(v6 == 34 && !z2) {
                v5 ^= 1;
            }
            if(v5 == 0 && !z2 && BasicHeaderValueParserHC4.isOneOf(((char)v6), arr_c)) {
                break;
            }
            z2 = !z2 && (v5 != 0 && v6 == 92);
            ++v4;
        }
        while(v < v4 && HTTP.isWhitespace(charArrayBuffer0.charAt(v))) {
            ++v;
        }
        int v7;
        for(v7 = v4; v7 > v && HTTP.isWhitespace(charArrayBuffer0.charAt(v7 - 1)); --v7) {
        }
        if(v7 - v >= 2 && charArrayBuffer0.charAt(v) == 34 && charArrayBuffer0.charAt(v7 - 1) == 34) {
            ++v;
            --v7;
        }
        String s1 = charArrayBuffer0.substring(v, v7);
        if(z) {
            ++v4;
        }
        parserCursor0.updatePos(v4);
        return this.createNameValuePair(s, s1);
    }

    public static NameValuePair[] parseParameters(String s, HeaderValueParser headerValueParser0) {
        Args.notNull(s, "Value");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        ParserCursor parserCursor0 = new ParserCursor(0, s.length());
        if(headerValueParser0 == null) {
            headerValueParser0 = BasicHeaderValueParserHC4.INSTANCE;
        }
        return headerValueParser0.parseParameters(charArrayBuffer0, parserCursor0);
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getUpperBound();
        while(v < v1 && HTTP.isWhitespace(charArrayBuffer0.charAt(v))) {
            ++v;
        }
        parserCursor0.updatePos(v);
        if(parserCursor0.atEnd()) {
            return new NameValuePair[0];
        }
        ArrayList arrayList0 = new ArrayList();
        while(!parserCursor0.atEnd()) {
            arrayList0.add(this.parseNameValuePair(charArrayBuffer0, parserCursor0));
            if(charArrayBuffer0.charAt(parserCursor0.getPos() - 1) == 44) {
                break;
            }
        }
        return (NameValuePair[])arrayList0.toArray(new NameValuePair[arrayList0.size()]);
    }
}

