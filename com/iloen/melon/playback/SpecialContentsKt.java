package com.iloen.melon.playback;

import com.iloen.melon.net.v4x.common.BgImgsBase;
import com.iloen.melon.net.v4x.common.BgVideoBase;
import com.melon.net.res.BgVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u0004\u0018\u00010\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u001A\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u001A\u0010\u0010\t\u001A\u0004\u0018\u00010\u00012\u0006\u0010\n\u001A\u00020\u000B\u001A\u001A\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0005¨\u0006\u000F"}, d2 = {"getSpecialBgVideoFromBgVideoBase", "Lcom/iloen/melon/playback/SpecialBgVideo;", "bgVideoBase", "Lcom/iloen/melon/net/v4x/common/BgVideoBase;", "getSpecialBgImageListFromBgImgsBaseList", "", "Lcom/iloen/melon/playback/SpecialBgImage;", "bgImgsBase", "Lcom/iloen/melon/net/v4x/common/BgImgsBase;", "getSpecialBgVideoFromBgVideo", "bgVideo", "Lcom/melon/net/res/BgVideo;", "getSpecialBgImageListFromBgImageList", "bgImageList", "Lcom/melon/net/res/BgImage;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class SpecialContentsKt {
    @NotNull
    public static final List getSpecialBgImageListFromBgImageList(@NotNull List list0) {
        q.g(list0, "bgImageList");
        List list1 = new ArrayList(je.q.Q(10, list0));
        Iterator iterator0 = list0.iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
            list1.add(new SpecialBgImage("", ""));
        }
        return list1;
    }

    @NotNull
    public static final List getSpecialBgImageListFromBgImgsBaseList(@Nullable List list0) {
        if(list0 != null) {
            List list1 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                list1.add(new SpecialBgImage(((BgImgsBase)object0).bgImgPath, ((BgImgsBase)object0).dpOrder));
            }
            return list1;
        }
        return w.a;
    }

    // 去混淆评级： 低(30)
    @Nullable
    public static final SpecialBgVideo getSpecialBgVideoFromBgVideo(@NotNull BgVideo bgVideo0) {
        q.g(bgVideo0, "bgVideo");
        return bgVideo0.equals(BgVideo.Companion.getNone()) ? null : new SpecialBgVideo("", "");
    }

    @Nullable
    public static final SpecialBgVideo getSpecialBgVideoFromBgVideoBase(@Nullable BgVideoBase bgVideoBase0) {
        return bgVideoBase0 == null ? null : new SpecialBgVideo(bgVideoBase0.bgVideoPath, bgVideoBase0.bgVideoImgPath);
    }
}

