package og;

import D0.E;
import Sf.p;
import Tf.v;
import X2.k;
import com.google.firebase.messaging.u;
import d5.e;
import d5.w;
import ie.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import jg.f;
import kotlin.jvm.internal.q;
import mg.d;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import pc.t;
import pg.c;

public final class b implements Runnable {
    public final c a;
    public final k b;
    public final Socket c;
    public static final e d;
    public static final e e;
    public static final e f;

    static {
        e e0 = w.u();
        f f0 = (f)e0.b;
        f0.a = jg.b.d;
        f0.b = 200;
        f0.c = "OK";
        e0.setHeader("SERVER", "Linux/4.14.295-g84b42e6a786c-ab9578266 UPnP/1.0 mmupnp/3.0.0");
        e0.setHeader("Connection", "close");
        e0.setHeader("Content-Length", "0");
        b.d = e0;
        e e1 = w.u();
        f f1 = (f)e1.b;
        f1.a = jg.b.e;
        f1.b = 400;
        f1.c = "Bad Request";
        e1.setHeader("SERVER", "Linux/4.14.295-g84b42e6a786c-ab9578266 UPnP/1.0 mmupnp/3.0.0");
        e1.setHeader("Connection", "close");
        e1.setHeader("Content-Length", "0");
        b.e = e1;
        e e2 = w.u();
        f f2 = (f)e2.b;
        f2.a = jg.b.f;
        f2.b = 412;
        f2.c = "Precondition Failed";
        e2.setHeader("SERVER", "Linux/4.14.295-g84b42e6a786c-ab9578266 UPnP/1.0 mmupnp/3.0.0");
        e2.setHeader("Connection", "close");
        e2.setHeader("Content-Length", "0");
        b.f = e2;
    }

    public b(u u0, k k0, Socket socket0) {
        q.g(u0, "taskExecutors");
        super();
        this.b = k0;
        this.c = socket0;
        this.a = new c(((t)u0.b));
    }

    public final void a(InputStream inputStream0, OutputStream outputStream0) {
        d d0 = new d(new jg.e("GET", "", "HTTP/1.1"), null);
        d0.e(inputStream0);
        mg.b b0 = d0.a;
        String s = b0.b("NT");
        String s1 = b0.b("NTS");
        String s2 = b0.b("SID");
        if(s != null && s.length() != 0 && s1 != null && s1.length() != 0) {
            e e0 = b.f;
            if(s2 != null && s2.length() != 0 && s.equals("upnp:event") && s1.equals("upnp:propchange")) {
                String s3 = b0.b("SEQ");
                boolean z = false;
                if(s3 != null) {
                    Long long0 = v.u0(s3);
                    if(long0 != null) {
                        String s4 = d0.a();
                        je.w w0 = je.w.a;
                        if(s4 != null && s4.length() != 0) {
                            try {
                                Element element0 = d8.d.A(s4).getDocumentElement();
                                q.f(element0, "propertySetNode");
                                if(q.b(element0.getLocalName(), "propertyset")) {
                                    ArrayList arrayList0 = new ArrayList();
                                    Node node0 = element0.getFirstChild();
                                    if(node0 != null) {
                                        ArrayList arrayList1 = new ArrayList();
                                        E e1 = new E();
                                        e1.b = node0;
                                        while(e1.hasNext()) {
                                            Object object0 = e1.next();
                                            if(q.b(((Element)object0).getLocalName(), "property")) {
                                                arrayList1.add(object0);
                                            }
                                        }
                                        ArrayList arrayList2 = new ArrayList();
                                        for(Object object1: arrayList1) {
                                            Node node1 = ((Element)object1).getFirstChild();
                                            p p0 = node1 == null ? w0 : new p(node1, 3);
                                            je.u.U(arrayList2, p0);
                                        }
                                        for(Object object2: arrayList2) {
                                            Element element1 = (Element)object2;
                                            String s5 = element1.getLocalName();
                                            if(s5 != null && s5.length() != 0) {
                                                arrayList0.add(new m(s5, element1.getTextContent()));
                                            }
                                        }
                                    }
                                    w0 = arrayList0;
                                }
                            }
                            catch(Exception unused_ex) {
                            }
                        }
                        if(!w0.isEmpty()) {
                            z = ((Boolean)((Q0.m)this.b.e).invoke(s2, long0, w0)).booleanValue();
                        }
                    }
                }
                if(z) {
                    ((d)b.d.c).d(outputStream0);
                    return;
                }
                ((d)e0.c).d(outputStream0);
                return;
            }
            ((d)e0.c).d(outputStream0);
            return;
        }
        ((d)b.e.c).d(outputStream0);
    }

    @Override
    public final void run() {
        List list0 = (List)this.b.c;
        Socket socket0 = this.c;
        try {
            try {
                InputStream inputStream0 = socket0.getInputStream();
                q.f(inputStream0, "socket.getInputStream()");
                OutputStream outputStream0 = socket0.getOutputStream();
                q.f(outputStream0, "socket.getOutputStream()");
                this.a(inputStream0, outputStream0);
                goto label_17;
            }
            catch(IOException iOException0) {
            }
            d8.d.I(iOException0);
        }
        catch(Throwable throwable0) {
            goto label_14;
        }
        try {
            socket0.close();
        }
        catch(IOException unused_ex) {
        }
        list0.remove(this);
        return;
        try {
        label_14:
            socket0.close();
        }
        catch(IOException unused_ex) {
        }
        list0.remove(this);
        throw throwable0;
        try {
        label_17:
            socket0.close();
        }
        catch(IOException unused_ex) {
        }
        list0.remove(this);
    }
}

