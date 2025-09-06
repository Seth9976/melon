package com.iloen.melon.fragments.present;

import E9.h;
import com.iloen.melon.playback.Playable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A2\u0010\u0000\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0003\u001A\n\u0010\u0005\u001A\u00020\u0002*\u00020\u0004¨\u0006\u0006"}, d2 = {"toPresentDataList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/present/PresentData;", "Lkotlin/collections/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "toPresentData", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PresentSongSendFragmentKt {
    @NotNull
    public static final PresentData toPresentData(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        String s = playable0.getSongidString();
        q.f(s, "getSongidString(...)");
        return new PresentData(s, playable0.isAdult());
    }

    @Nullable
    public static final ArrayList toPresentDataList(@Nullable ArrayList arrayList0) {
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                String s = ((Playable)object0).getSongidString();
                q.f(s, "getSongidString(...)");
                arrayList1.add(new PresentData(s, ((Playable)object0).isAdult()));
            }
            return h.W(arrayList1);
        }
        return null;
    }
}

