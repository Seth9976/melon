package com.google.android.gms.common.internal;

import A7.d;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import b3.Z;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ViewUtils {
    @KeepForSdk
    public static String getXmlAttributeString(String s, String s1, Context context0, AttributeSet attributeSet0, boolean z, boolean z1, String s2) {
        String s3 = attributeSet0 == null ? null : attributeSet0.getAttributeValue(s, s1);
        if(s3 != null && s3.startsWith("@string/") && z) {
            TypedValue typedValue0 = new TypedValue();
            try {
                context0.getResources().getValue("com.iloen.melon:string/" + s3.substring(8), typedValue0, true);
            }
            catch(Resources.NotFoundException unused_ex) {
                Log.w(s2, d.n(new StringBuilder(Z.e(30, s1) + s3.length()), "Could not find resource for ", s1, ": ", s3));
            }
            CharSequence charSequence0 = typedValue0.string;
            if(charSequence0 == null) {
                String s4 = typedValue0.toString();
                Log.w(s2, d.n(new StringBuilder(Z.e(28, s1) + s4.length()), "Resource ", s1, " was not a string: ", s4));
            }
            else {
                s3 = charSequence0.toString();
            }
        }
        if(z1 && s3 == null) {
            Log.w(s2, "Required XML attribute \"" + s1 + "\" missing");
        }
        return s3;
    }
}

