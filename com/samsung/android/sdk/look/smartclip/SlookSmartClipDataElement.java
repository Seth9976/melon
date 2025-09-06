package com.samsung.android.sdk.look.smartclip;

import android.graphics.Rect;

public interface SlookSmartClipDataElement {
    void addTag(SlookSmartClipMetaTag arg1);

    SlookSmartClipMetaTagArray getAllTag();

    Rect getMetaAreaRect();

    SlookSmartClipMetaTagArray getTag(String arg1);

    void removeTag(String arg1);

    void setMetaAreaRect(Rect arg1);
}

