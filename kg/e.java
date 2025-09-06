package kg;

import de.c;
import ie.m;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import kotlin.jvm.internal.q;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class e {
    public final p a;
    public final String b;
    public final Map c;

    public e(d d0) {
        this.a = d0.c;
        this.b = d0.d;
        this.c = d0.e;
    }

    public static Element a(String s, String s1) {
        Element element0 = d8.d.A(s).getDocumentElement();
        q.f(element0, "XmlUtils.newDocument(true, xml).documentElement");
        Element element1 = c.t(element0, "Body");
        if(element1 != null) {
            Element element2 = c.t(element1, s1);
            if(element2 != null) {
                return element2;
            }
        }
        throw new IOException("no response tag");
    }

    public static String b(Document document0) {
        StringWriter stringWriter0 = new StringWriter();
        Transformer transformer0 = TransformerFactory.newInstance().newTransformer();
        transformer0.setOutputProperty("omit-xml-declaration", "yes");
        transformer0.transform(new DOMSource(document0), new StreamResult(stringWriter0));
        String s = stringWriter0.toString();
        q.f(s, "sw.toString()");
        return s;
    }

    public final Element c(Document document0) {
        Element element0 = document0.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "s:Envelope");
        document0.appendChild(element0);
        q.f(element0, "createElementNS(namespac….also { appendChild(it) }");
        element0.setAttributeNS("http://schemas.xmlsoap.org/soap/envelope/", "s:encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
        return c.l(c.l(element0, "http://schemas.xmlsoap.org/soap/envelope/", "s:Body"), this.a.h, "u:" + this.b);
    }

    public static LinkedHashMap d(String s) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        Node node0 = e.a(s, "Fault").getFirstChild();
        if(node0 != null) {
            for(Object object0: ((Iterable)je.p.c0(new Sf.p(node0, 3)).b)) {
                Element element0 = (Element)object0;
                String s1 = element0.getLocalName();
                if(q.b(s1, "detail")) {
                    Element element1 = c.t(element0, "UPnPError");
                    if(element1 != null) {
                        Node node1 = element1.getFirstChild();
                        if(node1 != null) {
                            for(Object object1: ((Iterable)je.p.c0(new Sf.p(node1, 3)).b)) {
                                String s2 = ((Element)object1).getTextContent();
                                q.f(s2, "it.textContent");
                                linkedHashMap0.put("UPnPError/" + ((Element)object1).getLocalName(), s2);
                            }
                            continue;
                        }
                    }
                    throw new IOException("no UPnPError tag");
                }
                q.f(s1, "tag");
                String s3 = element0.getTextContent();
                q.f(s3, "it.textContent");
                linkedHashMap0.put(s1, s3);
            }
        }
        if(!linkedHashMap0.containsKey("UPnPError/errorCode")) {
            throw new IOException("no UPnPError/errorCode tag");
        }
        return linkedHashMap0;
    }

    public final LinkedHashMap e(String s) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        Node node0 = e.a(s, this.b + "Response").getFirstChild();
        if(node0 != null) {
            for(Object object0: ((Iterable)je.p.c0(new Sf.p(node0, 3)).b)) {
                String s1 = ((Element)object0).getLocalName();
                String s2 = ((Element)object0).getTextContent();
                this.c.get(s1);
                q.f(s1, "tag");
                q.f(s2, "text");
                linkedHashMap0.put(s1, s2);
            }
        }
        return linkedHashMap0;
    }

    public static void f(Element element0, ArrayList arrayList0) {
        for(Object object0: arrayList0) {
            q.g(((String)((m)object0).a), "tagName");
            Element element1 = element0.getOwnerDocument().createElement(((String)((m)object0).a));
            element0.appendChild(element1);
            q.f(element1, "ownerDocument.createElem….also { appendChild(it) }");
            element1.setTextContent(((String)((m)object0).b));
        }
    }
}

