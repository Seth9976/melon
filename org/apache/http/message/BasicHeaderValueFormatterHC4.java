package org.apache.http.message;

import b3.Z;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicHeaderValueFormatterHC4 implements HeaderValueFormatter {
    @Deprecated
    public static final BasicHeaderValueFormatterHC4 DEFAULT = null;
    public static final BasicHeaderValueFormatterHC4 INSTANCE = null;
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    static {
        BasicHeaderValueFormatterHC4.DEFAULT = new BasicHeaderValueFormatterHC4();
        BasicHeaderValueFormatterHC4.INSTANCE = new BasicHeaderValueFormatterHC4();
    }

    public void doFormatValue(CharArrayBuffer charArrayBuffer0, String s, boolean z) {
        if(!z) {
            for(int v1 = 0; v1 < s.length() && !z; ++v1) {
                z = this.isSeparator(s.charAt(v1));
            }
        }
        if(z) {
            charArrayBuffer0.append('\"');
        }
        for(int v = 0; v < s.length(); ++v) {
            int v2 = s.charAt(v);
            if(this.isUnsafe(((char)v2))) {
                charArrayBuffer0.append('\\');
            }
            charArrayBuffer0.append(((char)v2));
        }
        if(z) {
            charArrayBuffer0.append('\"');
        }
    }

    public int estimateElementsLen(HeaderElement[] arr_headerElement) {
        if(arr_headerElement != null && arr_headerElement.length >= 1) {
            int v1 = (arr_headerElement.length - 1) * 2;
            for(int v = 0; v < arr_headerElement.length; ++v) {
                v1 += this.estimateHeaderElementLen(arr_headerElement[v]);
            }
            return v1;
        }
        return 0;
    }

    public int estimateHeaderElementLen(HeaderElement headerElement0) {
        if(headerElement0 == null) {
            return 0;
        }
        int v1 = headerElement0.getName().length();
        String s = headerElement0.getValue();
        if(s != null) {
            v1 = Z.d(3, v1, s);
        }
        int v2 = headerElement0.getParameterCount();
        if(v2 > 0) {
            for(int v = 0; v < v2; ++v) {
                v1 += this.estimateNameValuePairLen(headerElement0.getParameter(v)) + 2;
            }
        }
        return v1;
    }

    public int estimateNameValuePairLen(NameValuePair nameValuePair0) {
        if(nameValuePair0 == null) {
            return 0;
        }
        int v = nameValuePair0.getName().length();
        String s = nameValuePair0.getValue();
        return s == null ? v : Z.d(3, v, s);
    }

    public int estimateParametersLen(NameValuePair[] arr_nameValuePair) {
        if(arr_nameValuePair != null && arr_nameValuePair.length >= 1) {
            int v1 = (arr_nameValuePair.length - 1) * 2;
            for(int v = 0; v < arr_nameValuePair.length; ++v) {
                v1 += this.estimateNameValuePairLen(arr_nameValuePair[v]);
            }
            return v1;
        }
        return 0;
    }

    public static String formatElements(HeaderElement[] arr_headerElement, boolean z, HeaderValueFormatter headerValueFormatter0) {
        if(headerValueFormatter0 == null) {
            headerValueFormatter0 = BasicHeaderValueFormatterHC4.INSTANCE;
        }
        return headerValueFormatter0.formatElements(null, arr_headerElement, z).toString();
    }

    @Override  // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer charArrayBuffer0, HeaderElement[] arr_headerElement, boolean z) {
        Args.notNull(arr_headerElement, "Header element array");
        int v = this.estimateElementsLen(arr_headerElement);
        if(charArrayBuffer0 == null) {
            charArrayBuffer0 = new CharArrayBuffer(v);
        }
        else {
            charArrayBuffer0.ensureCapacity(v);
        }
        for(int v1 = 0; v1 < arr_headerElement.length; ++v1) {
            if(v1 > 0) {
                charArrayBuffer0.append(", ");
            }
            this.formatHeaderElement(charArrayBuffer0, arr_headerElement[v1], z);
        }
        return charArrayBuffer0;
    }

    public static String formatHeaderElement(HeaderElement headerElement0, boolean z, HeaderValueFormatter headerValueFormatter0) {
        if(headerValueFormatter0 == null) {
            headerValueFormatter0 = BasicHeaderValueFormatterHC4.INSTANCE;
        }
        return headerValueFormatter0.formatHeaderElement(null, headerElement0, z).toString();
    }

    @Override  // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer charArrayBuffer0, HeaderElement headerElement0, boolean z) {
        Args.notNull(headerElement0, "Header element");
        int v = this.estimateHeaderElementLen(headerElement0);
        if(charArrayBuffer0 == null) {
            charArrayBuffer0 = new CharArrayBuffer(v);
        }
        else {
            charArrayBuffer0.ensureCapacity(v);
        }
        charArrayBuffer0.append(headerElement0.getName());
        String s = headerElement0.getValue();
        if(s != null) {
            charArrayBuffer0.append('=');
            this.doFormatValue(charArrayBuffer0, s, z);
        }
        int v1 = headerElement0.getParameterCount();
        if(v1 > 0) {
            for(int v2 = 0; v2 < v1; ++v2) {
                charArrayBuffer0.append("; ");
                this.formatNameValuePair(charArrayBuffer0, headerElement0.getParameter(v2), z);
            }
        }
        return charArrayBuffer0;
    }

    public static String formatNameValuePair(NameValuePair nameValuePair0, boolean z, HeaderValueFormatter headerValueFormatter0) {
        if(headerValueFormatter0 == null) {
            headerValueFormatter0 = BasicHeaderValueFormatterHC4.INSTANCE;
        }
        return headerValueFormatter0.formatNameValuePair(null, nameValuePair0, z).toString();
    }

    @Override  // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer charArrayBuffer0, NameValuePair nameValuePair0, boolean z) {
        Args.notNull(nameValuePair0, "Name / value pair");
        int v = this.estimateNameValuePairLen(nameValuePair0);
        if(charArrayBuffer0 == null) {
            charArrayBuffer0 = new CharArrayBuffer(v);
        }
        else {
            charArrayBuffer0.ensureCapacity(v);
        }
        charArrayBuffer0.append(nameValuePair0.getName());
        String s = nameValuePair0.getValue();
        if(s != null) {
            charArrayBuffer0.append('=');
            this.doFormatValue(charArrayBuffer0, s, z);
        }
        return charArrayBuffer0;
    }

    public static String formatParameters(NameValuePair[] arr_nameValuePair, boolean z, HeaderValueFormatter headerValueFormatter0) {
        if(headerValueFormatter0 == null) {
            headerValueFormatter0 = BasicHeaderValueFormatterHC4.INSTANCE;
        }
        return headerValueFormatter0.formatParameters(null, arr_nameValuePair, z).toString();
    }

    @Override  // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer charArrayBuffer0, NameValuePair[] arr_nameValuePair, boolean z) {
        Args.notNull(arr_nameValuePair, "Header parameter array");
        int v = this.estimateParametersLen(arr_nameValuePair);
        if(charArrayBuffer0 == null) {
            charArrayBuffer0 = new CharArrayBuffer(v);
        }
        else {
            charArrayBuffer0.ensureCapacity(v);
        }
        for(int v1 = 0; v1 < arr_nameValuePair.length; ++v1) {
            if(v1 > 0) {
                charArrayBuffer0.append("; ");
            }
            this.formatNameValuePair(charArrayBuffer0, arr_nameValuePair[v1], z);
        }
        return charArrayBuffer0;
    }

    public boolean isSeparator(char c) {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(((int)c)) >= 0;
    }

    public boolean isUnsafe(char c) {
        return "\"\\".indexOf(((int)c)) >= 0;
    }
}

