package com.iloen.melon.fragments.detail.viewholder;

import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001B\u0010\u0004\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/custom/MelonTextView;", "", "countText", "Lie/H;", "setCountText", "(Lcom/iloen/melon/custom/MelonTextView;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class StReportHolderKt {
    public static final void access$setCountText(MelonTextView melonTextView0, String s) {
        StReportHolderKt.setCountText(melonTextView0, s);
    }

    private static final void setCountText(MelonTextView melonTextView0, String s) {
        if(s.length() > 0) {
            melonTextView0.setTextColor(ColorUtils.getColor(melonTextView0.getContext(), 0x7F06016D));  // color:gray900s
        }
        else {
            melonTextView0.setTextColor(ColorUtils.getColor(melonTextView0.getContext(), 0x7F060160));  // color:gray600s_support_high_contrast
            s = "-";
        }
        melonTextView0.setText(s);
    }
}

