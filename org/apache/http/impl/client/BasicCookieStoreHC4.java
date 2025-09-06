package org.apache.http.impl.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;

@ThreadSafe
public class BasicCookieStoreHC4 implements Serializable, CookieStore {
    @GuardedBy("this")
    private final TreeSet cookies;
    private static final long serialVersionUID = -7581093305228232025L;

    public BasicCookieStoreHC4() {
        this.cookies = new TreeSet(new CookieIdentityComparator());
    }

    @Override  // org.apache.http.client.CookieStore
    public void addCookie(Cookie cookie0) {
        synchronized(this) {
            if(cookie0 != null) {
                this.cookies.remove(cookie0);
                if(!cookie0.isExpired(new Date())) {
                    this.cookies.add(cookie0);
                }
            }
        }
    }

    public void addCookies(Cookie[] arr_cookie) {
        synchronized(this) {
            if(arr_cookie != null) {
                for(int v1 = 0; v1 < arr_cookie.length; ++v1) {
                    this.addCookie(arr_cookie[v1]);
                }
            }
        }
    }

    @Override  // org.apache.http.client.CookieStore
    public void clear() {
        synchronized(this) {
            this.cookies.clear();
        }
    }

    @Override  // org.apache.http.client.CookieStore
    public boolean clearExpired(Date date0) {
        boolean z = false;
        synchronized(this) {
            if(date0 == null) {
                return false;
            }
            Iterator iterator0 = this.cookies.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(((Cookie)object0).isExpired(date0)) {
                    iterator0.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    @Override  // org.apache.http.client.CookieStore
    public List getCookies() {
        synchronized(this) {
            return new ArrayList(this.cookies);
        }
    }

    @Override
    public String toString() {
        synchronized(this) {
        }
        return this.cookies.toString();
    }
}

