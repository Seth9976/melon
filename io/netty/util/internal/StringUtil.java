package io.netty.util.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class StringUtil {
    static final boolean $assertionsDisabled = false;
    private static final String[] BYTE2HEX_NOPAD = null;
    private static final String[] BYTE2HEX_PAD = null;
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    private static final byte[] HEX2B = null;
    public static final char LINE_FEED = '\n';
    public static final String NEWLINE = null;
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';

    static {
        StringUtil.NEWLINE = "\n";
        StringUtil.BYTE2HEX_PAD = new String[0x100];
        StringUtil.BYTE2HEX_NOPAD = new String[0x100];
        for(int v = 0; true; ++v) {
            String[] arr_s = StringUtil.BYTE2HEX_PAD;
            if(v >= arr_s.length) {
                break;
            }
            String s = Integer.toHexString(v);
            arr_s[v] = v <= 15 ? "0" + s : s;
            StringUtil.BYTE2HEX_NOPAD[v] = s;
        }
        byte[] arr_b = new byte[0x10000];
        StringUtil.HEX2B = arr_b;
        Arrays.fill(arr_b, -1);
        arr_b[0x30] = 0;
        arr_b[49] = 1;
        arr_b[50] = 2;
        arr_b[51] = 3;
        arr_b[52] = 4;
        arr_b[53] = 5;
        arr_b[54] = 6;
        arr_b[55] = 7;
        arr_b[56] = 8;
        arr_b[57] = 9;
        arr_b[65] = 10;
        arr_b[66] = 11;
        arr_b[67] = 12;
        arr_b[68] = 13;
        arr_b[69] = 14;
        arr_b[70] = 15;
        arr_b[97] = 10;
        arr_b[98] = 11;
        arr_b[99] = 12;
        arr_b[100] = 13;
        arr_b[101] = 14;
        arr_b[102] = 15;
    }

    public static Appendable byteToHexString(Appendable appendable0, int v) {
        try {
            appendable0.append(StringUtil.byteToHexString(v));
        }
        catch(IOException iOException0) {
            PlatformDependent.throwException(iOException0);
        }
        return appendable0;
    }

    public static String byteToHexString(int v) {
        return StringUtil.BYTE2HEX_NOPAD[v & 0xFF];
    }

    public static Appendable byteToHexStringPadded(Appendable appendable0, int v) {
        try {
            appendable0.append(StringUtil.byteToHexStringPadded(v));
        }
        catch(IOException iOException0) {
            PlatformDependent.throwException(iOException0);
        }
        return appendable0;
    }

    public static String byteToHexStringPadded(int v) {
        return StringUtil.BYTE2HEX_PAD[v & 0xFF];
    }

    public static boolean commonSuffixOfLength(String s, String s1, int v) {
        return s != null && s1 != null && v >= 0 && s.regionMatches(s.length() - v, s1, s1.length() - v, v);
    }

    public static byte decodeHexByte(CharSequence charSequence0, int v) {
        int v1 = StringUtil.decodeHexNibble(charSequence0.charAt(v));
        int v2 = StringUtil.decodeHexNibble(charSequence0.charAt(v + 1));
        if(v1 == -1 || v2 == -1) {
            throw new IllegalArgumentException(String.format("invalid hex byte \'%s\' at index %d of \'%s\'", charSequence0.subSequence(v, v + 2), v, charSequence0));
        }
        return (byte)((v1 << 4) + v2);
    }

    public static byte[] decodeHexDump(CharSequence charSequence0) {
        return StringUtil.decodeHexDump(charSequence0, 0, charSequence0.length());
    }

    public static byte[] decodeHexDump(CharSequence charSequence0, int v, int v1) {
        if(v1 < 0 || (v1 & 1) != 0) {
            throw new IllegalArgumentException("length: " + v1);
        }
        if(v1 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        byte[] arr_b = new byte[v1 >>> 1];
        for(int v2 = 0; v2 < v1; v2 += 2) {
            arr_b[v2 >>> 1] = StringUtil.decodeHexByte(charSequence0, v + v2);
        }
        return arr_b;
    }

    public static int decodeHexNibble(byte b) {
        return StringUtil.HEX2B[b];
    }

    public static int decodeHexNibble(char c) {
        return StringUtil.HEX2B[c];
    }

    public static boolean endsWith(CharSequence charSequence0, char c) {
        int v = charSequence0.length();
        return v > 0 && charSequence0.charAt(v - 1) == c;
    }

    public static CharSequence escapeCsv(CharSequence charSequence0) {
        return StringUtil.escapeCsv(charSequence0, false);
    }

    public static CharSequence escapeCsv(CharSequence charSequence0, boolean z) {
        int v7;
        int v6;
        int v5;
        int v4;
        int v3;
        int v2;
        int v = ((CharSequence)ObjectUtil.checkNotNull(charSequence0, "value")).length();
        int v1 = 0;
        if(z) {
            v2 = StringUtil.indexOfFirstNonOwsChar(charSequence0, v);
            v3 = StringUtil.indexOfLastNonOwsChar(charSequence0, v2, v);
        }
        else {
            v3 = v - 1;
            v2 = 0;
        }
        if(v2 > v3) {
            return "";
        }
        if(StringUtil.isDoubleQuote(charSequence0.charAt(v2))) {
            v1 = 1;
            if(!StringUtil.isDoubleQuote(charSequence0.charAt(v3)) || v3 <= v2) {
                v4 = 0;
                v5 = v3;
                v6 = v2;
            }
            else {
                ++v2;
                --v3;
                v4 = v1;
                v5 = v3;
                v6 = v2;
                v2 = -1;
            }
        }
        else {
            v4 = v1;
            v5 = v3;
            v6 = v2;
            v2 = -1;
        }
        if(v2 < 0) {
            if(v4 == 0) {
                v7 = v6;
                while(true) {
                    if(v7 > v5) {
                        goto label_46;
                    }
                    int v8 = charSequence0.charAt(v7);
                    if(v8 == 10 || v8 == 13 || v8 == 44) {
                        break;
                    }
                    if(StringUtil.isDoubleQuote(((char)v8))) {
                        if(v7 == v5 || !StringUtil.isDoubleQuote(charSequence0.charAt(v7 + 1))) {
                            break;
                        }
                        ++v7;
                    }
                    ++v7;
                }
            }
            else {
                v7 = v6;
                while(v7 <= v5) {
                    if(StringUtil.isDoubleQuote(charSequence0.charAt(v7))) {
                        if(v7 == v5 || !StringUtil.isDoubleQuote(charSequence0.charAt(v7 + 1))) {
                            goto label_43;
                        }
                        ++v7;
                    }
                    ++v7;
                }
                goto label_46;
            }
        label_43:
            v2 = v7;
        label_46:
            if(v2 < 0) {
                return v4 == 0 ? charSequence0.subSequence(v6, v5 + 1) : charSequence0.subSequence(v6 - 1, v5 + 2);
            }
        }
        CharSequence charSequence1 = new StringBuilder(v5 - v6 + 8);
        ((StringBuilder)charSequence1).append('\"');
        ((StringBuilder)charSequence1).append(charSequence0, v6, v2);
        while(v2 <= v5) {
            int v9 = charSequence0.charAt(v2);
            if(StringUtil.isDoubleQuote(((char)v9))) {
                ((StringBuilder)charSequence1).append('\"');
                if(v2 < v5 && StringUtil.isDoubleQuote(charSequence0.charAt(v2 + 1))) {
                    ++v2;
                }
            }
            ((StringBuilder)charSequence1).append(((char)v9));
            ++v2;
        }
        ((StringBuilder)charSequence1).append('\"');
        return charSequence1;
    }

    private static int indexOfFirstNonOwsChar(CharSequence charSequence0, int v) {
        int v1;
        for(v1 = 0; v1 < v && StringUtil.isOws(charSequence0.charAt(v1)); ++v1) {
        }
        return v1;
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence0, int v, int v1) {
        int v2;
        for(v2 = v1 - 1; v2 > v && StringUtil.isOws(charSequence0.charAt(v2)); --v2) {
        }
        return v2;
    }

    public static int indexOfNonWhiteSpace(CharSequence charSequence0, int v) {
        while(v < charSequence0.length()) {
            if(!Character.isWhitespace(charSequence0.charAt(v))) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    public static int indexOfWhiteSpace(CharSequence charSequence0, int v) {
        while(v < charSequence0.length()) {
            if(Character.isWhitespace(charSequence0.charAt(v))) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    private static boolean isDoubleQuote(char c) {
        return c == 34;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static boolean isOws(char c) {
        return c == 9 || c == 0x20;
    }

    public static boolean isSurrogate(char c) {
        return c >= 0xD800 && c <= 0xDFFF;
    }

    public static CharSequence join(CharSequence charSequence0, Iterable iterable0) {
        ObjectUtil.checkNotNull(charSequence0, "separator");
        ObjectUtil.checkNotNull(iterable0, "elements");
        Iterator iterator0 = iterable0.iterator();
        if(!iterator0.hasNext()) {
            return "";
        }
        Object object0 = iterator0.next();
        if(!iterator0.hasNext()) {
            return (CharSequence)object0;
        }
        CharSequence charSequence1 = new StringBuilder(((CharSequence)object0));
        do {
            ((StringBuilder)charSequence1).append(charSequence0);
            Object object1 = iterator0.next();
            ((StringBuilder)charSequence1).append(((CharSequence)object1));
        }
        while(iterator0.hasNext());
        return charSequence1;
    }

    public static int length(String s) {
        return s == null ? 0 : s.length();
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence0, int v) {
        return new IllegalArgumentException("invalid escaped CSV field: " + charSequence0 + " index: " + v);
    }

    public static String simpleClassName(Class class0) [...] // 潜在的解密器

    public static String simpleClassName(Object object0) {
        return object0 == null ? "null_object" : StringUtil.simpleClassName(object0.getClass());
    }

    public static String substringAfter(String s, char c) {
        int v = s.indexOf(((int)c));
        return v < 0 ? null : s.substring(v + 1);
    }

    public static String substringBefore(String s, char c) {
        int v = s.indexOf(((int)c));
        return v < 0 ? null : s.substring(0, v);
    }

    public static Appendable toHexString(Appendable appendable0, byte[] arr_b) {
        return StringUtil.toHexString(appendable0, arr_b, 0, arr_b.length);
    }

    public static Appendable toHexString(Appendable appendable0, byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return appendable0;
        }
        int v2 = v1 + v;
        while(v < v2 - 1 && arr_b[v] == 0) {
            ++v;
        }
        StringUtil.byteToHexString(appendable0, ((int)arr_b[v]));
        StringUtil.toHexStringPadded(appendable0, arr_b, v + 1, v2 - (v + 1));
        return appendable0;
    }

    public static String toHexString(byte[] arr_b) {
        return StringUtil.toHexString(arr_b, 0, arr_b.length);
    }

    public static String toHexString(byte[] arr_b, int v, int v1) {
        return ((StringBuilder)StringUtil.toHexString(new StringBuilder(v1 << 1), arr_b, v, v1)).toString();
    }

    public static Appendable toHexStringPadded(Appendable appendable0, byte[] arr_b) {
        return StringUtil.toHexStringPadded(appendable0, arr_b, 0, arr_b.length);
    }

    public static Appendable toHexStringPadded(Appendable appendable0, byte[] arr_b, int v, int v1) {
        int v2 = v1 + v;
        while(v < v2) {
            StringUtil.byteToHexStringPadded(appendable0, ((int)arr_b[v]));
            ++v;
        }
        return appendable0;
    }

    public static String toHexStringPadded(byte[] arr_b) {
        return StringUtil.toHexStringPadded(arr_b, 0, arr_b.length);
    }

    public static String toHexStringPadded(byte[] arr_b, int v, int v1) {
        return ((StringBuilder)StringUtil.toHexStringPadded(new StringBuilder(v1 << 1), arr_b, v, v1)).toString();
    }

    public static CharSequence trimOws(CharSequence charSequence0) {
        int v = charSequence0.length();
        if(v != 0) {
            int v1 = StringUtil.indexOfFirstNonOwsChar(charSequence0, v);
            int v2 = StringUtil.indexOfLastNonOwsChar(charSequence0, v1, v);
            return v1 != 0 || v2 != v - 1 ? charSequence0.subSequence(v1, v2 + 1) : charSequence0;
        }
        return charSequence0;
    }

    public static CharSequence unescapeCsv(CharSequence charSequence0) {
        int v = ((CharSequence)ObjectUtil.checkNotNull(charSequence0, "value")).length();
        if(v == 0) {
            return charSequence0;
        }
        if(StringUtil.isDoubleQuote(charSequence0.charAt(0)) && StringUtil.isDoubleQuote(charSequence0.charAt(v - 1)) && v != 1) {
            StringBuilder stringBuilder0 = InternalThreadLocalMap.get().stringBuilder();
            for(int v1 = 1; v1 < v - 1; ++v1) {
                int v2 = charSequence0.charAt(v1);
                if(v2 == 34) {
                    if(!StringUtil.isDoubleQuote(charSequence0.charAt(v1 + 1)) || v1 + 1 == v - 1) {
                        throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v1);
                    }
                    ++v1;
                }
                stringBuilder0.append(((char)v2));
            }
            return stringBuilder0.toString();
        }
        StringUtil.validateCsvFormat(charSequence0);
        return charSequence0;
    }

    public static List unescapeCsvFields(CharSequence charSequence0) {
        List list0 = new ArrayList(2);
        StringBuilder stringBuilder0 = InternalThreadLocalMap.get().stringBuilder();
        int v = charSequence0.length();
        boolean z = false;
        for(int v1 = 0; v1 <= v - 1; ++v1) {
            int v2 = charSequence0.charAt(v1);
            if(!z) {
                if(v2 == 10) {
                    throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v1);
                }
                switch(v2) {
                    case 13: {
                        throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v1);
                    }
                    case 34: {
                        if(stringBuilder0.length() != 0) {
                            throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v1);
                        }
                        z = true;
                        break;
                    }
                    case 44: {
                        ((ArrayList)list0).add(stringBuilder0.toString());
                        stringBuilder0.setLength(0);
                        break;
                    }
                    default: {
                        stringBuilder0.append(((char)v2));
                    }
                }
            }
            else if(v2 == 34) {
                if(v1 == v - 1) {
                    ((ArrayList)list0).add(stringBuilder0.toString());
                    return list0;
                }
                int v3 = charSequence0.charAt(v1 + 1);
                if(v3 == 34) {
                    stringBuilder0.append('\"');
                }
                else {
                    if(v3 != 44) {
                        throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v1);
                    }
                    ((ArrayList)list0).add(stringBuilder0.toString());
                    stringBuilder0.setLength(0);
                    z = false;
                }
                ++v1;
            }
            else {
                stringBuilder0.append(((char)v2));
            }
        }
        if(z) {
            throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v - 1);
        }
        ((ArrayList)list0).add(stringBuilder0.toString());
        return list0;
    }

    private static void validateCsvFormat(CharSequence charSequence0) {
        int v = charSequence0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            switch(charSequence0.charAt(v1)) {
                case 10: 
                case 13: 
                case 34: 
                case 44: {
                    throw StringUtil.newInvalidEscapedCsvFieldException(charSequence0, v1);
                }
            }
        }
    }
}

