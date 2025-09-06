package com.iloen.melon.playback.playlist.smartplaylist;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.net.v6x.request.AutoplayMixPlayReq.Params;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.iloen.melon.playback.playlist.PlaylistUtil;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import e.k;
import java.util.List;
import k9.g;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002MLBW\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0002\u0012\b\b\u0002\u0010\b\u001A\u00020\u0002\u0012\b\b\u0002\u0010\t\u001A\u00020\u0002\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0010\u001A\f\u0012\u0004\u0012\u00020\u000E0\rj\u0002`\u000F\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\u00132\u0010\u0010\u0012\u001A\f\u0012\u0004\u0012\u00020\u000E0\rj\u0002`\u000F\u00A2\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\r\u0010\u001D\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001D\u0010\u001BJ\r\u0010\u001E\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001E\u0010\u001BJ\u001A\u0010!\u001A\u0004\u0018\u00010 2\u0006\u0010\u001F\u001A\u00020\u0002H\u0086@\u00A2\u0006\u0004\b!\u0010\"J\u001A\u0010%\u001A\u00020\u00192\b\u0010$\u001A\u0004\u0018\u00010#H\u0096\u0002\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b(\u0010)J\r\u0010*\u001A\u00020\'\u00A2\u0006\u0004\b*\u0010)J\u001D\u0010.\u001A\u00020\u00132\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020\'\u00A2\u0006\u0004\b.\u0010/J\u0010\u00100\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b0\u00101J\u0010\u00102\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b2\u00101J\u0010\u00103\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b3\u00101J\u0010\u00104\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b4\u00101J\u0010\u00105\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b5\u00101J\u0010\u00106\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b6\u00101J\u0010\u00107\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b7\u00101J\u0012\u00108\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b8\u00101Jb\u00109\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b9\u0010:J\u0010\u0010;\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b;\u00101R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010<\u001A\u0004\b=\u00101R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010<\u001A\u0004\b>\u00101R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010<\u001A\u0004\b?\u00101R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010<\u001A\u0004\b@\u00101R\u0017\u0010\u0007\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010<\u001A\u0004\bA\u00101R\u0017\u0010\b\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010<\u001A\u0004\bB\u00101R\"\u0010\t\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\t\u0010<\u001A\u0004\bC\u00101\"\u0004\bD\u0010ER$\u0010\n\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\n\u0010<\u001A\u0004\bF\u00101\"\u0004\bG\u0010ER$\u0010H\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\f\n\u0004\bH\u0010I\u0012\u0004\bJ\u0010K\u00A8\u0006N"}, d2 = {"Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "Landroid/os/Parcelable;", "", "landingFrom", "contsId", "contsTypeCode", "seedContsId", "seedContsTypeCode", "menuId", "title", "titleReplace", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo$DsPlyOrderData;", "Lcom/iloen/melon/player/playlist/drawernew/model/DsPlyOrderDataList;", "getDsPlyOrderDataList", "()Ljava/util/List;", "list", "Lie/H;", "setDsPlyOrderDataList", "(Ljava/util/List;)V", "Lk9/g;", "getResponseType", "()Lk9/g;", "", "hasSongCountForFilter", "()Z", "isRecentOrLike", "isOwner", "isDj", "tag", "Lcom/iloen/melon/net/HttpResponse;", "requestPlaylistInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "toString", "Ljava/lang/String;", "getLandingFrom", "getContsId", "getContsTypeCode", "getSeedContsId", "getSeedContsTypeCode", "getMenuId", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getTitleReplace", "setTitleReplace", "dsPlyOrderDataList", "Ljava/util/List;", "getDsPlyOrderDataList$annotations", "()V", "Companion", "DsPlyOrderData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistInfo implements Parcelable {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo$Companion;", "", "<init>", "()V", "PLAYLIST_SEQ_LIKE", "", "PLAYLIST_SEQ_RECENT", "log", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LogU getLog() {
            return DrawerPlaylistInfo.log;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class Creator implements Parcelable.Creator {
        public final DrawerPlaylistInfo createFromParcel(Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new DrawerPlaylistInfo(parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString());
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        public final DrawerPlaylistInfo[] newArray(int v) {
            return new DrawerPlaylistInfo[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u000B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u001F\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo$DsPlyOrderData;", "", "dsPlyOrder", "", "songId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDsPlyOrder", "()Ljava/lang/String;", "getSongId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DsPlyOrderData {
        public static final int $stable;
        @NotNull
        private final String dsPlyOrder;
        @Nullable
        private final String songId;

        public DsPlyOrderData(@NotNull String s, @Nullable String s1) {
            q.g(s, "dsPlyOrder");
            super();
            this.dsPlyOrder = s;
            this.songId = s1;
        }

        @NotNull
        public final String component1() {
            return this.dsPlyOrder;
        }

        @Nullable
        public final String component2() {
            return this.songId;
        }

        @NotNull
        public final DsPlyOrderData copy(@NotNull String s, @Nullable String s1) {
            q.g(s, "dsPlyOrder");
            return new DsPlyOrderData(s, s1);
        }

        public static DsPlyOrderData copy$default(DsPlyOrderData drawerPlaylistInfo$DsPlyOrderData0, String s, String s1, int v, Object object0) {
            if((v & 1) != 0) {
                s = drawerPlaylistInfo$DsPlyOrderData0.dsPlyOrder;
            }
            if((v & 2) != 0) {
                s1 = drawerPlaylistInfo$DsPlyOrderData0.songId;
            }
            return drawerPlaylistInfo$DsPlyOrderData0.copy(s, s1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DsPlyOrderData)) {
                return false;
            }
            return q.b(this.dsPlyOrder, ((DsPlyOrderData)object0).dsPlyOrder) ? q.b(this.songId, ((DsPlyOrderData)object0).songId) : false;
        }

        @NotNull
        public final String getDsPlyOrder() {
            return this.dsPlyOrder;
        }

        @Nullable
        public final String getSongId() {
            return this.songId;
        }

        @Override
        public int hashCode() {
            int v = this.dsPlyOrder.hashCode();
            return this.songId == null ? v * 0x1F : v * 0x1F + this.songId.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "DsPlyOrderData(dsPlyOrder=" + this.dsPlyOrder + ", songId=" + this.songId + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[g.values().length];
            try {
                arr_v[6] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[9] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[8] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[7] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[11] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String PLAYLIST_SEQ_LIKE = "PlaylistSeqLike";
    @NotNull
    public static final String PLAYLIST_SEQ_RECENT = "PlaylistSeqRecent";
    @NotNull
    private final String contsId;
    @NotNull
    private final String contsTypeCode;
    @Nullable
    private List dsPlyOrderDataList;
    @NotNull
    private final String landingFrom;
    @NotNull
    private static final LogU log;
    @NotNull
    private final String menuId;
    @NotNull
    private final String seedContsId;
    @NotNull
    private final String seedContsTypeCode;
    @NotNull
    private String title;
    @Nullable
    private String titleReplace;

    static {
        DrawerPlaylistInfo.Companion = new Companion(null);
        DrawerPlaylistInfo.$stable = 8;
        DrawerPlaylistInfo.CREATOR = new Creator();
        DrawerPlaylistInfo.log = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "DrawerPlaylistInfo", false, Category.None, 2, null);
    }

    public DrawerPlaylistInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @Nullable String s7) {
        q.g(s, "landingFrom");
        q.g(s1, "contsId");
        q.g(s2, "contsTypeCode");
        q.g(s3, "seedContsId");
        q.g(s4, "seedContsTypeCode");
        q.g(s5, "menuId");
        q.g(s6, "title");
        super();
        this.landingFrom = s;
        this.contsId = s1;
        this.contsTypeCode = s2;
        this.seedContsId = s3;
        this.seedContsTypeCode = s4;
        this.menuId = s5;
        this.title = s6;
        this.titleReplace = s7;
        if(this.isOwner()) {
            this.dsPlyOrderDataList = DrawerPlaylistInfoKt.placeHolderDsPlyOrderDataList();
            return;
        }
        this.dsPlyOrderDataList = null;
    }

    public DrawerPlaylistInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s1 = "";
        }
        if((v & 4) != 0) {
            s2 = "";
        }
        if((v & 8) != 0) {
            s3 = "";
        }
        if((v & 16) != 0) {
            s4 = "";
        }
        if((v & 0x20) != 0) {
            s5 = "";
        }
        if((v & 0x40) != 0) {
            s6 = "";
        }
        if((v & 0x80) != 0) {
            s7 = null;
        }
        this(s, s1, s2, s3, s4, s5, s6, s7);
    }

    @NotNull
    public final String component1() {
        return this.landingFrom;
    }

    @NotNull
    public final String component2() {
        return this.contsId;
    }

    @NotNull
    public final String component3() {
        return this.contsTypeCode;
    }

    @NotNull
    public final String component4() {
        return this.seedContsId;
    }

    @NotNull
    public final String component5() {
        return this.seedContsTypeCode;
    }

    @NotNull
    public final String component6() {
        return this.menuId;
    }

    @NotNull
    public final String component7() {
        return this.title;
    }

    @Nullable
    public final String component8() {
        return this.titleReplace;
    }

    @NotNull
    public final DrawerPlaylistInfo copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @Nullable String s7) {
        q.g(s, "landingFrom");
        q.g(s1, "contsId");
        q.g(s2, "contsTypeCode");
        q.g(s3, "seedContsId");
        q.g(s4, "seedContsTypeCode");
        q.g(s5, "menuId");
        q.g(s6, "title");
        return new DrawerPlaylistInfo(s, s1, s2, s3, s4, s5, s6, s7);
    }

    public static DrawerPlaylistInfo copy$default(DrawerPlaylistInfo drawerPlaylistInfo0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, Object object0) {
        if((v & 1) != 0) {
            s = drawerPlaylistInfo0.landingFrom;
        }
        if((v & 2) != 0) {
            s1 = drawerPlaylistInfo0.contsId;
        }
        if((v & 4) != 0) {
            s2 = drawerPlaylistInfo0.contsTypeCode;
        }
        if((v & 8) != 0) {
            s3 = drawerPlaylistInfo0.seedContsId;
        }
        if((v & 16) != 0) {
            s4 = drawerPlaylistInfo0.seedContsTypeCode;
        }
        if((v & 0x20) != 0) {
            s5 = drawerPlaylistInfo0.menuId;
        }
        if((v & 0x40) != 0) {
            s6 = drawerPlaylistInfo0.title;
        }
        if((v & 0x80) != 0) {
            s7 = drawerPlaylistInfo0.titleReplace;
        }
        return drawerPlaylistInfo0.copy(s, s1, s2, s3, s4, s5, s6, s7);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 中等(70)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof DrawerPlaylistInfo && q.b(((DrawerPlaylistInfo)object0).landingFrom, this.landingFrom) && q.b(((DrawerPlaylistInfo)object0).contsId, this.contsId) && q.b(((DrawerPlaylistInfo)object0).contsTypeCode, this.contsTypeCode) && q.b(((DrawerPlaylistInfo)object0).seedContsId, this.seedContsId) && q.b(((DrawerPlaylistInfo)object0).seedContsTypeCode, this.seedContsTypeCode) && q.b(((DrawerPlaylistInfo)object0).title, this.title);
    }

    @NotNull
    public final String getContsId() {
        return this.contsId;
    }

    @NotNull
    public final String getContsTypeCode() {
        return this.contsTypeCode;
    }

    @NotNull
    public final List getDsPlyOrderDataList() {
        return this.dsPlyOrderDataList == null ? DrawerPlaylistInfoKt.placeHolderDsPlyOrderDataList() : this.dsPlyOrderDataList;
    }

    private static void getDsPlyOrderDataList$annotations() {
    }

    @NotNull
    public final String getLandingFrom() {
        return this.landingFrom;
    }

    @NotNull
    public final String getMenuId() {
        return this.menuId;
    }

    @NotNull
    public final g getResponseType() {
        if(this.seedContsId.length() > 0 && this.seedContsTypeCode.length() > 0) {
            return g.g;
        }
        if(q.b(this.contsId, "PlaylistSeqLike")) {
            return g.j;
        }
        if(q.b(this.contsId, "PlaylistSeqRecent")) {
            return g.i;
        }
        if(q.b(this.contsTypeCode, "N10006")) {
            return g.h;
        }
        return q.b(this.contsTypeCode, "N10009") ? g.l : g.k;
    }

    @NotNull
    public final String getSeedContsId() {
        return this.seedContsId;
    }

    @NotNull
    public final String getSeedContsTypeCode() {
        return this.seedContsTypeCode;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTitleReplace() {
        return this.titleReplace;
    }

    public final boolean hasSongCountForFilter() {
        return !this.isRecentOrLike();
    }

    @Override
    public int hashCode() {
        int v = x.b(x.b(x.b(x.b(x.b(this.landingFrom.hashCode() * 0x1F, 0x1F, this.contsId), 0x1F, this.seedContsId), 0x1F, this.seedContsTypeCode), 0x1F, this.menuId), 0x1F, this.title);
        return this.titleReplace == null ? this.contsTypeCode.hashCode() + v * 0x1F : this.contsTypeCode.hashCode() + (v + this.titleReplace.hashCode()) * 0x1F;
    }

    public final boolean isDj() {
        return q.b(this.landingFrom, "DJ");
    }

    public final boolean isOwner() {
        return k.A(new String[]{"MADE_BY_ME", "DJ"}).contains(this.landingFrom);
    }

    // 去混淆评级： 低(20)
    public final boolean isRecentOrLike() {
        return q.b(this.contsId, "PlaylistSeqLike") || q.b(this.contsId, "PlaylistSeqRecent");
    }

    @Nullable
    public final Object requestPlaylistInfo(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo.requestPlaylistInfo.1 drawerPlaylistInfo$requestPlaylistInfo$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo.requestPlaylistInfo.1) {
            drawerPlaylistInfo$requestPlaylistInfo$10 = (com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo.requestPlaylistInfo.1)continuation0;
            int v = drawerPlaylistInfo$requestPlaylistInfo$10.label;
            if((v & 0x80000000) == 0) {
                drawerPlaylistInfo$requestPlaylistInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.requestPlaylistInfo(null, this);
                    }
                };
            }
            else {
                drawerPlaylistInfo$requestPlaylistInfo$10.label = v ^ 0x80000000;
            }
        }
        else {
            drawerPlaylistInfo$requestPlaylistInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.requestPlaylistInfo(null, this);
                }
            };
        }
        Object object0 = drawerPlaylistInfo$requestPlaylistInfo$10.result;
        a a0 = a.a;
        switch(drawerPlaylistInfo$requestPlaylistInfo$10.label) {
            case 0: {
                n.D(object0);
                switch(this.getResponseType().ordinal()) {
                    case 6: {
                        Params autoplayMixPlayReq$Params0 = new Params(this.contsId, this.seedContsTypeCode, this.seedContsId, this.menuId);
                        drawerPlaylistInfo$requestPlaylistInfo$10.L$0 = null;
                        drawerPlaylistInfo$requestPlaylistInfo$10.label = 1;
                        object0 = PlaylistUtil.INSTANCE.requestStreamGetAutoplayMixPlay(autoplayMixPlayReq$Params0, s, drawerPlaylistInfo$requestPlaylistInfo$10);
                        if(object0 != a0) {
                            return (ResponseV6Res)object0;
                        }
                        break;
                    }
                    case 7: {
                        drawerPlaylistInfo$requestPlaylistInfo$10.L$0 = null;
                        drawerPlaylistInfo$requestPlaylistInfo$10.label = 4;
                        object0 = PlaylistUtil.INSTANCE.requestStreamGetArtistPlaylistConnectedSong(this.contsId, s, drawerPlaylistInfo$requestPlaylistInfo$10);
                        if(object0 != a0) {
                            return (ResponseV6Res)object0;
                        }
                        break;
                    }
                    case 8: {
                        drawerPlaylistInfo$requestPlaylistInfo$10.L$0 = null;
                        drawerPlaylistInfo$requestPlaylistInfo$10.label = 3;
                        object0 = PlaylistUtil.INSTANCE.requestStreamGetMyMusicPlaylistRecentListSongRecnt(s, drawerPlaylistInfo$requestPlaylistInfo$10);
                        if(object0 != a0) {
                            return (ResponseV6Res)object0;
                        }
                        break;
                    }
                    case 9: {
                        drawerPlaylistInfo$requestPlaylistInfo$10.L$0 = null;
                        drawerPlaylistInfo$requestPlaylistInfo$10.label = 2;
                        object0 = PlaylistUtil.INSTANCE.requestStreamGetMyMusicLikeListLikeSong(s, drawerPlaylistInfo$requestPlaylistInfo$10);
                        if(object0 != a0) {
                            return (ResponseV6Res)object0;
                        }
                        break;
                    }
                    case 11: {
                        drawerPlaylistInfo$requestPlaylistInfo$10.L$0 = null;
                        drawerPlaylistInfo$requestPlaylistInfo$10.label = 5;
                        object0 = PlaylistUtil.INSTANCE.requestStreamGetDjConnectedPlaylistSongs(this.contsId, s, drawerPlaylistInfo$requestPlaylistInfo$10);
                        if(object0 != a0) {
                            return (ResponseV6Res)object0;
                        }
                        break;
                    }
                    default: {
                        drawerPlaylistInfo$requestPlaylistInfo$10.L$0 = null;
                        drawerPlaylistInfo$requestPlaylistInfo$10.label = 6;
                        object0 = PlaylistUtil.INSTANCE.requestStreamGetMyMusicPlaylistConnectedListSong(this.contsId, s, drawerPlaylistInfo$requestPlaylistInfo$10);
                        if(object0 != a0) {
                            return (ResponseV6Res)object0;
                        }
                    }
                }
                return a0;
            }
            case 1: {
                String s1 = (String)drawerPlaylistInfo$requestPlaylistInfo$10.L$0;
                n.D(object0);
                return (ResponseV6Res)object0;
            }
            case 2: {
                String s2 = (String)drawerPlaylistInfo$requestPlaylistInfo$10.L$0;
                n.D(object0);
                return (ResponseV6Res)object0;
            }
            case 3: {
                String s3 = (String)drawerPlaylistInfo$requestPlaylistInfo$10.L$0;
                n.D(object0);
                return (ResponseV6Res)object0;
            }
            case 4: {
                String s4 = (String)drawerPlaylistInfo$requestPlaylistInfo$10.L$0;
                n.D(object0);
                return (ResponseV6Res)object0;
            }
            case 5: {
                String s5 = (String)drawerPlaylistInfo$requestPlaylistInfo$10.L$0;
                n.D(object0);
                return (ResponseV6Res)object0;
            }
            case 6: {
                String s6 = (String)drawerPlaylistInfo$requestPlaylistInfo$10.L$0;
                n.D(object0);
                return (ResponseV6Res)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final void setDsPlyOrderDataList(@NotNull List list0) {
        q.g(list0, "list");
        this.dsPlyOrderDataList = list0;
    }

    public final void setTitle(@NotNull String s) {
        q.g(s, "<set-?>");
        this.title = s;
    }

    public final void setTitleReplace(@Nullable String s) {
        this.titleReplace = s;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.title;
        String s1 = this.titleReplace;
        StringBuilder stringBuilder0 = d.o("DrawerPlaylistInfo(landingFrom=", this.landingFrom, ", contsId=", this.contsId, ", contsTypeCode=");
        d.u(stringBuilder0, this.contsTypeCode, ", seedContsId=", this.seedContsId, ", seedContsTypeCode=");
        d.u(stringBuilder0, this.seedContsTypeCode, ", menuId=", this.menuId, ", title=");
        return d.n(stringBuilder0, s, ", titleReplace=", s1, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.landingFrom);
        parcel0.writeString(this.contsId);
        parcel0.writeString(this.contsTypeCode);
        parcel0.writeString(this.seedContsId);
        parcel0.writeString(this.seedContsTypeCode);
        parcel0.writeString(this.menuId);
        parcel0.writeString(this.title);
        parcel0.writeString(this.titleReplace);
    }
}

