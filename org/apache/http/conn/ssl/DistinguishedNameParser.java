package org.apache.http.conn.ssl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

@Immutable
final class DistinguishedNameParser {
    static class InternalTokenParser extends TokenParser {
        @Override  // org.apache.http.conn.ssl.TokenParser
        public void copyUnquotedContent(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0, StringBuilder stringBuilder0) {
            int v = parserCursor0.getPos();
            int v1 = parserCursor0.getPos();
            int v2 = parserCursor0.getUpperBound();
            boolean z = false;
            while(v1 < v2) {
                int v3 = charArrayBuffer0.charAt(v1);
                if(z) {
                    stringBuilder0.append(((char)v3));
                    z = false;
                }
                else {
                    if(bitSet0 != null && bitSet0.get(v3) || TokenParser.isWhitespace(((char)v3)) || v3 == 34) {
                        break;
                    }
                    if(v3 == 92) {
                        z = true;
                    }
                    else {
                        stringBuilder0.append(((char)v3));
                    }
                }
                ++v1;
                ++v;
            }
            parserCursor0.updatePos(v);
        }
    }

    private static final BitSet COMMA_OR_PLUS;
    private static final BitSet EQUAL_OR_COMMA_OR_PLUS;
    public static final DistinguishedNameParser INSTANCE;
    private final TokenParser tokenParser;

    static {
        DistinguishedNameParser.INSTANCE = new DistinguishedNameParser();
        DistinguishedNameParser.EQUAL_OR_COMMA_OR_PLUS = TokenParser.INIT_BITSET(new int[]{61, 44, 43});
        DistinguishedNameParser.COMMA_OR_PLUS = TokenParser.INIT_BITSET(new int[]{44, 43});
    }

    public DistinguishedNameParser() {
        this.tokenParser = new InternalTokenParser();
    }

    public List parse(String s) {
        if(s == null) {
            return null;
        }
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(s.length());
        charArrayBuffer0.append(s);
        return this.parse(charArrayBuffer0, new ParserCursor(0, s.length()));
    }

    public List parse(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        List list0 = new ArrayList();
        this.tokenParser.skipWhiteSpace(charArrayBuffer0, parserCursor0);
        while(!parserCursor0.atEnd()) {
            ((ArrayList)list0).add(this.parseParameter(charArrayBuffer0, parserCursor0));
        }
        return list0;
    }

    public NameValuePair parseParameter(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        String s = this.parseToken(charArrayBuffer0, parserCursor0, DistinguishedNameParser.EQUAL_OR_COMMA_OR_PLUS);
        if(parserCursor0.atEnd()) {
            return new BasicNameValuePair(s, null);
        }
        int v = charArrayBuffer0.charAt(parserCursor0.getPos());
        parserCursor0.updatePos(parserCursor0.getPos() + 1);
        if(v == 44) {
            return new BasicNameValuePair(s, null);
        }
        String s1 = this.parseValue(charArrayBuffer0, parserCursor0, DistinguishedNameParser.COMMA_OR_PLUS);
        if(!parserCursor0.atEnd()) {
            parserCursor0.updatePos(parserCursor0.getPos() + 1);
        }
        return new BasicNameValuePair(s, s1);
    }

    public String parseToken(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0) {
        return this.tokenParser.parseToken(charArrayBuffer0, parserCursor0, bitSet0);
    }

    public String parseValue(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0) {
        return this.tokenParser.parseValue(charArrayBuffer0, parserCursor0, bitSet0);
    }
}

