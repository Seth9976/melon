package com.iloen.melon.playback.playlist.smartplaylist;

import Cb.i;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003\u001A\u0014\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"placeHolderDsPlyOrderDataList", "", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo$DsPlyOrderData;", "Lcom/iloen/melon/player/playlist/drawernew/model/DsPlyOrderDataList;", "compareToViewMode", "", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "target", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistInfoKt {
    public static final boolean compareToViewMode(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0, @Nullable DrawerPlaylistInfo drawerPlaylistInfo1) {
        q.g(drawerPlaylistInfo0, "<this>");
        if(drawerPlaylistInfo1 == null) {
            LogU.debug$default(DrawerPlaylistInfo.Companion.getLog(), "compareToViewMode() target is null", null, false, 6, null);
            return true;
        }
        String s = drawerPlaylistInfo0.getLandingFrom();
        String s1 = drawerPlaylistInfo0.getContsId();
        String s2 = drawerPlaylistInfo0.getSeedContsId();
        boolean z = !q.b(s, drawerPlaylistInfo1.getLandingFrom()) | !q.b(s1, drawerPlaylistInfo1.getContsId()) | !q.b(s2, drawerPlaylistInfo1.getSeedContsId());
        a a0 = new a(s, drawerPlaylistInfo1, s1, s2, z);
        LogConstantsKt.buildDebug$default(DrawerPlaylistInfo.Companion.getLog(), false, a0, 1, null);
        return z;
    }

    private static final H compareToViewMode$lambda$0(String s, DrawerPlaylistInfo drawerPlaylistInfo0, String s1, String s2, boolean z, StringBuilder stringBuilder0) {
        q.g(stringBuilder0, "$this$buildDebug");
        stringBuilder0.append("compareToViewMode()");
        i.a(stringBuilder0, "base landingFrom: " + s + ", target landingFrom: " + drawerPlaylistInfo0.getLandingFrom());
        i.a(stringBuilder0, "base contsId: " + s1 + ", target contsId: " + drawerPlaylistInfo0.getContsId());
        i.a(stringBuilder0, "base seedContsId: " + s2 + ", target seedContsId: " + drawerPlaylistInfo0.getSeedContsId());
        i.a(stringBuilder0, "result isViewMode: " + z);
        return H.a;
    }

    @NotNull
    public static final List placeHolderDsPlyOrderDataList() {
        return w.a;
    }
}

