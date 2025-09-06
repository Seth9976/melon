package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface HeaderValueFormatter {
    CharArrayBuffer formatElements(CharArrayBuffer arg1, HeaderElement[] arg2, boolean arg3);

    CharArrayBuffer formatHeaderElement(CharArrayBuffer arg1, HeaderElement arg2, boolean arg3);

    CharArrayBuffer formatNameValuePair(CharArrayBuffer arg1, NameValuePair arg2, boolean arg3);

    CharArrayBuffer formatParameters(CharArrayBuffer arg1, NameValuePair[] arg2, boolean arg3);
}

