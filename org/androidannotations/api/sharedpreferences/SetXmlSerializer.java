package org.androidannotations.api.sharedpreferences;

import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class SetXmlSerializer {
    private static final String NAMESPACE = "";
    private static final String SET_TAG = "AA_set";
    private static final String STRING_TAG = "AA_string";

    public static Set deserialize(String s) {
        Set set0 = new TreeSet();
        XmlPullParser xmlPullParser0 = Xml.newPullParser();
        try {
            xmlPullParser0.setInput(new StringReader(s));
            xmlPullParser0.next();
            xmlPullParser0.require(2, "", "AA_set");
            while(xmlPullParser0.next() != 3) {
                xmlPullParser0.require(2, "", "AA_string");
                xmlPullParser0.next();
                xmlPullParser0.require(4, null, null);
                ((TreeSet)set0).add(xmlPullParser0.getText());
                xmlPullParser0.next();
                xmlPullParser0.require(3, null, "AA_string");
            }
            return set0;
        }
        catch(XmlPullParserException xmlPullParserException0) {
            Log.w("getStringSet", xmlPullParserException0);
            return null;
        }
        catch(IOException iOException0) {
            Log.w("getStringSet", iOException0);
            return null;
        }
    }

    public static String serialize(Set set0) {
        if(set0 == null) {
            set0 = Collections.EMPTY_SET;
        }
        StringWriter stringWriter0 = new StringWriter();
        XmlSerializer xmlSerializer0 = Xml.newSerializer();
        try {
            xmlSerializer0.setOutput(stringWriter0);
            xmlSerializer0.startTag("", "AA_set");
            for(Object object0: set0) {
                xmlSerializer0.startTag("", "AA_string").text(((String)object0)).endTag("", "AA_string");
            }
            xmlSerializer0.endTag("", "AA_set").endDocument();
        }
        catch(IllegalArgumentException | IOException | IllegalStateException unused_ex) {
        }
        return stringWriter0.toString();
    }
}

