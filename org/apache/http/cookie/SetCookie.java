package org.apache.http.cookie;

import java.util.Date;

@Deprecated
public interface SetCookie extends Cookie {
    void setComment(String arg1);

    void setDomain(String arg1);

    void setExpiryDate(Date arg1);

    void setPath(String arg1);

    void setSecure(boolean arg1);

    void setValue(String arg1);

    void setVersion(int arg1);
}

