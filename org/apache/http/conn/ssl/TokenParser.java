package org.apache.http.conn.ssl;

import java.util.BitSet;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

class TokenParser {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final char HT = '\t';
    public static final TokenParser INSTANCE = null;
    public static final char LF = '\n';
    public static final char SP = ' ';

    static {
        TokenParser.INSTANCE = new TokenParser();
    }

    public static BitSet INIT_BITSET(int[] arr_v) {
        BitSet bitSet0 = new BitSet();
        for(int v = 0; v < arr_v.length; ++v) {
            bitSet0.set(arr_v[v]);
        }
        return bitSet0;
    }

    public void copyContent(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0, StringBuilder stringBuilder0) {
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getPos();
        int v2 = parserCursor0.getUpperBound();
        while(v1 < v2) {
            int v3 = charArrayBuffer0.charAt(v1);
            if(bitSet0 != null && bitSet0.get(v3) || TokenParser.isWhitespace(((char)v3))) {
                break;
            }
            ++v;
            stringBuilder0.append(((char)v3));
            ++v1;
        }
        parserCursor0.updatePos(v);
    }

    public void copyQuotedContent(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, StringBuilder stringBuilder0) {
        if(!parserCursor0.atEnd()) {
            int v = parserCursor0.getPos();
            int v1 = parserCursor0.getPos();
            int v2 = parserCursor0.getUpperBound();
            if(charArrayBuffer0.charAt(v) == 34) {
                int v3 = v + 1;
                int v4 = v1 + 1;
                boolean z = false;
                while(v4 < v2) {
                    int v5 = charArrayBuffer0.charAt(v4);
                    if(z) {
                        if(v5 != 34 && v5 != 92) {
                            stringBuilder0.append('\\');
                        }
                        stringBuilder0.append(((char)v5));
                        z = false;
                    }
                    else {
                        if(v5 == 34) {
                            ++v3;
                            break;
                        }
                        if(v5 == 92) {
                            z = true;
                        }
                        else if(v5 != 13 && v5 != 10) {
                            stringBuilder0.append(((char)v5));
                        }
                    }
                    ++v4;
                    ++v3;
                }
                parserCursor0.updatePos(v3);
            }
        }
    }

    public void copyUnquotedContent(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0, StringBuilder stringBuilder0) {
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getPos();
        int v2 = parserCursor0.getUpperBound();
        while(v1 < v2) {
            int v3 = charArrayBuffer0.charAt(v1);
            if(bitSet0 != null && bitSet0.get(v3) || TokenParser.isWhitespace(((char)v3)) || v3 == 34) {
                break;
            }
            ++v;
            stringBuilder0.append(((char)v3));
            ++v1;
        }
        parserCursor0.updatePos(v);
    }

    public static boolean isWhitespace(char c) {
        return c == 9 || c == 10 || c == 13 || c == 0x20;
    }

    public String parseToken(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0) {
        StringBuilder stringBuilder0 = new StringBuilder();
    alab1:
        while(true) {
            for(boolean z = false; true; z = true) {
                if(parserCursor0.atEnd()) {
                    break alab1;
                }
                int v = charArrayBuffer0.charAt(parserCursor0.getPos());
                if(bitSet0 != null && bitSet0.get(v)) {
                    break alab1;
                }
                if(!TokenParser.isWhitespace(((char)v))) {
                    if(z && stringBuilder0.length() > 0) {
                        stringBuilder0.append(' ');
                    }
                    this.copyContent(charArrayBuffer0, parserCursor0, bitSet0, stringBuilder0);
                    break;
                }
                this.skipWhiteSpace(charArrayBuffer0, parserCursor0);
            }
        }
        return stringBuilder0.toString();
    }

    public String parseValue(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, BitSet bitSet0) {
        StringBuilder stringBuilder0 = new StringBuilder();
    alab1:
        while(true) {
            for(boolean z = false; true; z = true) {
                if(parserCursor0.atEnd()) {
                    break alab1;
                }
                int v = charArrayBuffer0.charAt(parserCursor0.getPos());
                if(bitSet0 != null && bitSet0.get(v)) {
                    break alab1;
                }
                if(!TokenParser.isWhitespace(((char)v))) {
                    if(v == 34) {
                        if(z && stringBuilder0.length() > 0) {
                            stringBuilder0.append(' ');
                        }
                        this.copyQuotedContent(charArrayBuffer0, parserCursor0, stringBuilder0);
                        break;
                    }
                    if(z && stringBuilder0.length() > 0) {
                        stringBuilder0.append(' ');
                    }
                    this.copyUnquotedContent(charArrayBuffer0, parserCursor0, bitSet0, stringBuilder0);
                    break;
                }
                this.skipWhiteSpace(charArrayBuffer0, parserCursor0);
            }
        }
        return stringBuilder0.toString();
    }

    public void skipWhiteSpace(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getPos();
        int v2 = parserCursor0.getUpperBound();
        while(v1 < v2 && TokenParser.isWhitespace(charArrayBuffer0.charAt(v1))) {
            ++v;
            ++v1;
        }
        parserCursor0.updatePos(v);
    }
}

