package org.apache.http.impl.cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.http.annotation.Immutable;

@Immutable
public class PublicSuffixListParserHC4 {
    private static final int MAX_LINE_LEN = 0x100;
    private final PublicSuffixFilterHC4 filter;

    public PublicSuffixListParserHC4(PublicSuffixFilterHC4 publicSuffixFilterHC40) {
        this.filter = publicSuffixFilterHC40;
    }

    public void parse(Reader reader0) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        BufferedReader bufferedReader0 = new BufferedReader(reader0);
        StringBuilder stringBuilder0 = new StringBuilder(0x100);
        boolean z = true;
        while(z) {
            z = this.readLine(bufferedReader0, stringBuilder0);
            String s = stringBuilder0.toString();
            if(s.length() != 0 && !s.startsWith("//")) {
                if(s.startsWith(".")) {
                    s = s.substring(1);
                }
                boolean z1 = s.startsWith("!");
                if(z1) {
                    s = s.substring(1);
                }
                if(z1) {
                    arrayList1.add(s);
                }
                else {
                    arrayList0.add(s);
                }
            }
        }
        this.filter.setPublicSuffixes(arrayList0);
        this.filter.setExceptions(arrayList1);
    }

    private boolean readLine(Reader reader0, StringBuilder stringBuilder0) {
        int v;
        stringBuilder0.setLength(0);
        boolean z = false;
        while(true) {
            v = reader0.read();
            if(v == -1 || ((char)v) == 10) {
                break;
            }
            if(Character.isWhitespace(((char)v))) {
                z = true;
            }
            if(!z) {
                stringBuilder0.append(((char)v));
            }
            if(stringBuilder0.length() > 0x100) {
                throw new IOException("Line too long");
            }
        }
        return v != -1;
    }
}

