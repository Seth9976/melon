package org.apache.http.impl.cookie;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class NetscapeDraftHeaderParserHC4 {
    public static final NetscapeDraftHeaderParserHC4 DEFAULT;

    static {
        NetscapeDraftHeaderParserHC4.DEFAULT = new NetscapeDraftHeaderParserHC4();
    }

    public HeaderElement parseHeader(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        Args.notNull(parserCursor0, "Parser cursor");
        NameValuePair nameValuePair0 = this.parseNameValuePair(charArrayBuffer0, parserCursor0);
        ArrayList arrayList0 = new ArrayList();
        while(!parserCursor0.atEnd()) {
            arrayList0.add(this.parseNameValuePair(charArrayBuffer0, parserCursor0));
        }
        return new BasicHeaderElement(nameValuePair0.getName(), nameValuePair0.getValue(), ((NameValuePair[])arrayList0.toArray(new NameValuePair[arrayList0.size()])));
    }

    private NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        String s;
        boolean z1;
        boolean z = false;
        int v = parserCursor0.getPos();
        int v1 = parserCursor0.getPos();
        int v2 = parserCursor0.getUpperBound();
    alab1:
        while(true) {
            z1 = true;
            if(v >= v2) {
                break;
            }
            switch(charArrayBuffer0.charAt(v)) {
                case 59: {
                    z = true;
                    break alab1;
                }
                case 61: {
                    break alab1;
                }
                default: {
                    ++v;
                }
            }
        }
        if(v == v2) {
            s = charArrayBuffer0.substringTrimmed(v1, v2);
            z = true;
        }
        else {
            s = charArrayBuffer0.substringTrimmed(v1, v);
            ++v;
        }
        if(z) {
            parserCursor0.updatePos(v);
            return new BasicNameValuePair(s, null);
        }
        int v3;
        for(v3 = v; true; ++v3) {
            if(v3 >= v2) {
                z1 = false;
                break;
            }
            if(charArrayBuffer0.charAt(v3) == 59) {
                break;
            }
        }
        while(v < v3 && HTTP.isWhitespace(charArrayBuffer0.charAt(v))) {
            ++v;
        }
        int v4;
        for(v4 = v3; v4 > v && HTTP.isWhitespace(charArrayBuffer0.charAt(v4 - 1)); --v4) {
        }
        String s1 = charArrayBuffer0.substring(v, v4);
        if(z1) {
            ++v3;
        }
        parserCursor0.updatePos(v3);
        return new BasicNameValuePair(s, s1);
    }
}

