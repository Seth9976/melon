package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.SetCookie2;

@NotThreadSafe
public class BasicClientCookie2HC4 extends BasicClientCookieHC4 implements SetCookie2 {
    private String commentURL;
    private boolean discard;
    private int[] ports;
    private static final long serialVersionUID = 0x9485A8E1F84FBB1FL;

    public BasicClientCookie2HC4(String s, String s1) {
        super(s, s1);
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookieHC4
    public Object clone() {
        BasicClientCookie2HC4 basicClientCookie2HC40 = (BasicClientCookie2HC4)super.clone();
        int[] arr_v = this.ports;
        if(arr_v != null) {
            basicClientCookie2HC40.ports = (int[])arr_v.clone();
        }
        return basicClientCookie2HC40;
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public String getCommentURL() {
        return this.commentURL;
    }

    @Override  // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public int[] getPorts() {
        return this.ports;
    }

    // 去混淆评级： 低(20)
    @Override  // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public boolean isExpired(Date date0) {
        return this.discard || super.isExpired(date0);
    }

    // 去混淆评级： 低(20)
    @Override  // org.apache.http.impl.cookie.BasicClientCookieHC4, org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        return !this.discard && super.isPersistent();
    }

    @Override  // org.apache.http.cookie.SetCookie2
    public void setCommentURL(String s) {
        this.commentURL = s;
    }

    @Override  // org.apache.http.cookie.SetCookie2
    public void setDiscard(boolean z) {
        this.discard = z;
    }

    @Override  // org.apache.http.cookie.SetCookie2
    public void setPorts(int[] arr_v) {
        this.ports = arr_v;
    }
}

