package org.apache.http.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public class BasicHttpContextHC4 implements HttpContext {
    private final Map map;
    private final HttpContext parentContext;

    public BasicHttpContextHC4() {
        this(null);
    }

    public BasicHttpContextHC4(HttpContext httpContext0) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext0;
    }

    public void clear() {
        this.map.clear();
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object getAttribute(String s) {
        Args.notNull(s, "Id");
        Object object0 = this.map.get(s);
        if(object0 == null) {
            return this.parentContext == null ? null : this.parentContext.getAttribute(s);
        }
        return object0;
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String s) {
        Args.notNull(s, "Id");
        return this.map.remove(s);
    }

    @Override  // org.apache.http.protocol.HttpContext
    public void setAttribute(String s, Object object0) {
        Args.notNull(s, "Id");
        if(object0 != null) {
            this.map.put(s, object0);
            return;
        }
        this.map.remove(s);
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}

