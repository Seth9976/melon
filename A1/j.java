package a1;

import android.text.Editable;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

public final class j implements ContentHandler {
    public final ContentHandler a;
    public final Editable b;
    public int c;
    public o d;

    public j(ContentHandler contentHandler0, Editable editable0) {
        this.a = contentHandler0;
        this.b = editable0;
    }

    public final void a() {
        o o0 = this.d;
        if(o0 != null) {
            int v = this.b.length();
            this.b.setSpan(o0, o0.c, v, 33);
        }
        this.d = null;
    }

    @Override  // org.xml.sax.ContentHandler
    public final void characters(char[] arr_c, int v, int v1) {
        this.a.characters(arr_c, v, v1);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void endDocument() {
        this.a.endDocument();
    }

    @Override  // org.xml.sax.ContentHandler
    public final void endElement(String s, String s1, String s2) {
        if(s1 != null) {
            switch(s1) {
                case "annotation": {
                    Editable editable0 = this.b;
                    Object[] arr_object = editable0.getSpans(0, editable0.length(), k.class);
                    ArrayList arrayList0 = new ArrayList();
                    for(int v1 = 0; v1 < arr_object.length; ++v1) {
                        Object object0 = arr_object[v1];
                        if(editable0.getSpanFlags(((k)object0)) == 17) {
                            arrayList0.add(object0);
                        }
                    }
                    int v2 = arrayList0.size();
                    for(int v = 0; v < v2; ++v) {
                        k k0 = (k)arrayList0.get(v);
                        int v3 = editable0.getSpanStart(k0);
                        int v4 = editable0.length();
                        editable0.removeSpan(k0);
                        if(v3 != v4) {
                            editable0.setSpan(k0, v3, v4, 33);
                        }
                    }
                    return;
                }
                case "li": {
                    this.a();
                    return;
                }
                case "ul": {
                    this.a();
                    --this.c;
                    return;
                }
            }
        }
        this.a.endElement(s, s1, s2);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void endPrefixMapping(String s) {
        this.a.endPrefixMapping(s);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void ignorableWhitespace(char[] arr_c, int v, int v1) {
        this.a.ignorableWhitespace(arr_c, v, v1);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void processingInstruction(String s, String s1) {
        this.a.processingInstruction(s, s1);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void setDocumentLocator(Locator locator0) {
        this.a.setDocumentLocator(locator0);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void skippedEntity(String s) {
        this.a.skippedEntity(s);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void startDocument() {
        this.a.startDocument();
    }

    @Override  // org.xml.sax.ContentHandler
    public final void startElement(String s, String s1, String s2, Attributes attributes0) {
        if(s1 != null) {
            Editable editable0 = this.b;
            switch(s1) {
                case "annotation": {
                    if(attributes0 != null) {
                        int v = attributes0.getLength();
                        for(int v1 = 0; v1 < v; ++v1) {
                            String s3 = attributes0.getLocalName(v1);
                            String s4 = "";
                            if(s3 == null) {
                                s3 = "";
                            }
                            String s5 = attributes0.getValue(v1);
                            if(s5 != null) {
                                s4 = s5;
                            }
                            if(s3.length() > 0 && s4.length() > 0) {
                                int v2 = editable0.length();
                                editable0.setSpan(new k(s3, s4), v2, v2, 17);
                            }
                        }
                    }
                    return;
                }
                case "li": {
                    this.a();
                    int v3 = this.c;
                    int v4 = editable0.length();
                    this.d = new o(n.b, v3, v4);
                    return;
                }
                case "ul": {
                    this.a();
                    ++this.c;
                    return;
                }
            }
        }
        this.a.startElement(s, s1, s2, attributes0);
    }

    @Override  // org.xml.sax.ContentHandler
    public final void startPrefixMapping(String s, String s1) {
        this.a.startPrefixMapping(s, s1);
    }
}

