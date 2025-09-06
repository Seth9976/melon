package a1;

import android.text.Editable;
import android.text.Html.TagHandler;
import kotlin.jvm.internal.q;
import org.xml.sax.XMLReader;

public final class r implements Html.TagHandler {
    @Override  // android.text.Html$TagHandler
    public final void handleTag(boolean z, String s, Editable editable0, XMLReader xMLReader0) {
        if(xMLReader0 != null && editable0 != null && z && q.b(s, "ContentHandlerReplacementTag")) {
            xMLReader0.setContentHandler(new j(xMLReader0.getContentHandler(), editable0));
        }
    }
}

