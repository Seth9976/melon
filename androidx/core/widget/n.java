package androidx.core.widget;

import android.content.ClipData.Item;
import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import c2.f;
import c2.g;

public final class n {
    public static g a(View view0, g g0) {
        CharSequence charSequence0;
        if(Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + g0);
        }
        f f0 = g0.a;
        if(f0.getSource() == 2) {
            return g0;
        }
        ClipData clipData0 = f0.l();
        int v = f0.getFlags();
        Editable editable0 = (Editable)((TextView)view0).getText();
        Context context0 = ((TextView)view0).getContext();
        boolean z = false;
        for(int v1 = 0; v1 < clipData0.getItemCount(); ++v1) {
            ClipData.Item clipData$Item0 = clipData0.getItemAt(v1);
            if((v & 1) == 0) {
                charSequence0 = clipData$Item0.coerceToStyledText(context0);
            }
            else {
                charSequence0 = clipData$Item0.coerceToText(context0);
                if(charSequence0 instanceof Spanned) {
                    charSequence0 = charSequence0.toString();
                }
            }
            if(charSequence0 != null) {
                if(z) {
                    editable0.insert(Selection.getSelectionEnd(editable0), "\n");
                    editable0.insert(Selection.getSelectionEnd(editable0), charSequence0);
                }
                else {
                    int v2 = Selection.getSelectionStart(editable0);
                    int v3 = Selection.getSelectionEnd(editable0);
                    int v4 = Math.max(0, Math.max(v2, v3));
                    Selection.setSelection(editable0, v4);
                    editable0.replace(Math.max(0, Math.min(v2, v3)), v4, charSequence0);
                    z = true;
                }
            }
        }
        return null;
    }
}

