package kg;

import Tf.a;
import com.google.firebase.messaging.u;
import d3.g;
import e3.o;
import ie.m;
import ie.r;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import je.C;
import je.x;
import jg.c;
import jg.f;
import kotlin.jvm.internal.q;
import org.w3c.dom.Document;

public final class d {
    public final u a;
    public final r b;
    public final p c;
    public final String d;
    public final Map e;

    public d(p p0, String s, Map map0) {
        q.g(p0, "service");
        q.g(s, "name");
        super();
        this.c = p0;
        this.d = s;
        this.e = map0;
        this.a = p0.f.f.m;
        this.b = g.Q(new b(this, 1));
        g.Q(new b(this, 0));
    }

    public final LinkedHashMap a(Map map0) {
        LinkedHashMap linkedHashMap0;
        String s3;
        l l0;
        p p0;
        String s2;
        q.g(map0, "argumentValues");
        e e0 = (e)this.b.getValue();
        e0.getClass();
        Iterable iterable0 = e0.c.values();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(((kg.g)object0).b) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            kg.g g0 = (kg.g)object1;
            String s = g0.a;
            String s1 = (String)map0.get(s);
            if(s1 == null) {
                s1 = g0.c.d;
            }
            arrayList1.add(new m(s, s1));
        }
        ArrayList arrayList2 = je.p.A0(arrayList1, C.X(x.a));
        try {
            DocumentBuilderFactory documentBuilderFactory0 = DocumentBuilderFactory.newInstance();
            q.f(documentBuilderFactory0, "it");
            documentBuilderFactory0.setNamespaceAware(true);
            DocumentBuilder documentBuilder0 = documentBuilderFactory0.newDocumentBuilder();
            q.f(documentBuilder0, "DocumentBuilderFactory.n…   }.newDocumentBuilder()");
            Document document0 = documentBuilder0.newDocument();
            q.f(document0, "newDocumentBuilder(awareness).newDocument()");
            e.f(e0.c(document0), arrayList2);
            s2 = e.b(document0);
            p0 = e0.a;
            l0 = p0.f;
            s3 = l0.p;
        }
        catch(Exception exception0) {
            throw new IOException(exception0);
        }
        if(s3 == null) {
            s3 = l0.b;
        }
        URL uRL0 = c.a(l0.a.f(), s3, p0.j);
        jg.e e1 = new jg.e("GET", "", "HTTP/1.1");
        mg.d d0 = new mg.d(e1, null);
        o o0 = new o(e1, d0);
        e1.a = "POST";
        o0.h(uRL0);
        o0.setHeader("SOAPACTION", "\"" + p0.h + '#' + e0.b + '\"');
        o0.setHeader("User-Agent", "Linux/4.14.295-g84b42e6a786c-ab9578266 UPnP/1.0 mmupnp/3.0.0");
        o0.setHeader("Connection", "close");
        o0.setHeader("Content-Type", "text/xml; charset=\"utf-8\"");
        d0.b = s2;
        if(s2.length() == 0) {
            d0.c = new byte[0];
        }
        else {
            try {
                byte[] arr_b = s2.getBytes(a.a);
                q.f(arr_b, "(this as java.lang.String).getBytes(charset)");
                d0.c = arr_b;
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                d8.d.I(unsupportedEncodingException0);
            }
        }
        d0.setHeader("Content-Length", String.valueOf((d0.c == null ? 0 : d0.c.length)));
        d5.e e2 = new Gf.l(false).h(0, o0);
        mg.d d1 = (mg.d)e2.c;
        f f0 = (f)e2.b;
        String s4 = d1.a();
        if(f0.a == jg.b.g && s4 != null && s4.length() != 0) {
            try {
                linkedHashMap0 = e.d(s4);
            }
            catch(Exception exception1) {
                throw new IOException(s4, exception1);
            }
        }
        else {
            if(f0.a != jg.b.d || s4 == null || s4.length() == 0) {
                throw new IOException(((mg.d)e2.c).d.b());
            }
            try {
                linkedHashMap0 = e0.e(s4);
            }
            catch(Exception exception2) {
                throw new IOException(s4, exception2);
            }
        }
        if(linkedHashMap0.containsKey("UPnPError/errorCode")) {
            throw new IOException("error response: " + linkedHashMap0);
        }
        return linkedHashMap0;
    }
}

