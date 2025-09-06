package com.iloen.melon.playback.playlist.add;

import A7.d;
import Qb.z;
import U4.x;
import Ub.s;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import e.k;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001BM\b\u0007\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011H\u0096@\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u0010\u0010\u001B\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0019J\u0012\u0010\u001C\u001A\u0004\u0018\u00010\nH\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0016\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ`\u0010 \u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u00C6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010#\u001A\u00020\"H\u00D6\u0001\u00A2\u0006\u0004\b#\u0010$J\u0010\u0010&\u001A\u00020%H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010*\u001A\u00020\u00062\b\u0010)\u001A\u0004\u0018\u00010(H\u00D6\u0003\u00A2\u0006\u0004\b*\u0010+R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010,\u001A\u0004\b-\u0010\u0015R\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010.\u001A\u0004\b/\u0010\u0017R\"\u0010\u0007\u001A\u00020\u00068\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b\u0007\u00100\u001A\u0004\b\u0007\u0010\u0019\"\u0004\b1\u00102R\u001A\u0010\b\u001A\u00020\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\b\u00100\u001A\u0004\b\b\u0010\u0019R\u001A\u0010\t\u001A\u00020\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\t\u00100\u001A\u0004\b3\u0010\u0019R\u001C\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u000B\u00104\u001A\u0004\b5\u0010\u001DR\u001D\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00A2\u0006\f\n\u0004\b\u000E\u00106\u001A\u0004\b7\u0010\u001FR\u001A\u00109\u001A\u0002088\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<R\u001A\u0010=\u001A\u00020\"8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b=\u0010>\u001A\u0004\b?\u0010$R\u0017\u0010@\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b@\u00100\u001A\u0004\b@\u0010\u0019R\u001A\u0010B\u001A\u00020A8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\bB\u0010C\u001A\u0004\bD\u0010E\u00A8\u0006F"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddPlayableList;", "Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "", "isAllowedBannedContents", "isExcludeGenre", "needToClear", "Lcom/iloen/melon/custom/L0;", "progressUpdater", "", "Lcom/iloen/melon/playback/Playable;", "playables", "<init>", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Lcom/iloen/melon/playback/playlist/add/AddAction;ZZZLcom/iloen/melon/custom/L0;Ljava/util/List;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getAddPlayableListInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "component2", "()Lcom/iloen/melon/playback/playlist/add/AddAction;", "component3", "()Z", "component4", "component5", "component6", "()Lcom/iloen/melon/custom/L0;", "component7", "()Ljava/util/List;", "copy", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Lcom/iloen/melon/playback/playlist/add/AddAction;ZZZLcom/iloen/melon/custom/L0;Ljava/util/List;)Lcom/iloen/melon/playback/playlist/add/AddPlayableList;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "getAddAction", "Z", "setAllowedBannedContents", "(Z)V", "getNeedToClear", "Lcom/iloen/melon/custom/L0;", "getProgressUpdater", "Ljava/util/List;", "getPlayables", "Lcom/iloen/melon/constants/CType;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "menuId", "Ljava/lang/String;", "getMenuId", "isVideoType", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "deviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "getDeviceConnectInfo", "()Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddPlayableList implements AddToPlaylist {
    public static final int $stable = 8;
    @NotNull
    private final AddAction addAction;
    @NotNull
    private final CType cType;
    @NotNull
    private final DeviceConnectableInfo deviceConnectInfo;
    private boolean isAllowedBannedContents;
    private final boolean isExcludeGenre;
    private final boolean isVideoType;
    @NotNull
    private final String menuId;
    private final boolean needToClear;
    @NotNull
    private final List playables;
    @Nullable
    private final L0 progressUpdater;
    @Nullable
    private final StatsElementsBase statsElements;

    public AddPlayableList(@Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, boolean z, boolean z1, boolean z2, @Nullable L0 l00, @NotNull List list0) {
        q.g(addAction0, "addAction");
        String s;
        CType cType0;
        q.g(list0, "playables");
        super();
        this.statsElements = statsElementsBase0;
        this.addAction = addAction0;
        this.isAllowedBannedContents = z;
        this.isExcludeGenre = z1;
        this.needToClear = z2;
        this.progressUpdater = l00;
        this.playables = list0;
        Playable playable0 = (Playable)p.m0(list0);
        if(playable0 == null) {
            cType0 = CType.UNKNOWN;
            q.f(cType0, "UNKNOWN");
        }
        else {
            cType0 = playable0.getCtype();
            if(cType0 == null) {
                cType0 = CType.UNKNOWN;
                q.f(cType0, "UNKNOWN");
            }
        }
        this.cType = cType0;
        Playable playable1 = (Playable)p.m0(list0);
        if(playable1 == null) {
            s = "";
        }
        else {
            s = playable1.getMenuid();
            if(s == null) {
                s = "";
            }
        }
        this.menuId = s;
        boolean z3 = k.A(new CType[]{CType.MV, CType.LIVE}).contains(this.getCType());
        this.isVideoType = z3;
        this.deviceConnectInfo = new DeviceConnectableInfo(true, !z3);
    }

    public AddPlayableList(StatsElementsBase statsElementsBase0, AddAction addAction0, boolean z, boolean z1, boolean z2, L0 l00, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 0x20) != 0) {
            l00 = AddToPlaylistImplKt.access$getDefaultProgressUpdater();
        }
        this(statsElementsBase0, addAction0, z, z1, z2, l00, list0);
    }

    public AddPlayableList(@Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, boolean z, boolean z1, boolean z2, @NotNull List list0) {
        q.g(addAction0, "addAction");
        q.g(list0, "playables");
        this(statsElementsBase0, addAction0, z, z1, z2, null, list0, 0x20, null);
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public Object checkPreCondition(@NotNull PlaylistId playlistId0, @NotNull Continuation continuation0) {
        return AddToPlaylist.super.checkPreCondition(playlistId0, continuation0);
    }

    @Nullable
    public final StatsElementsBase component1() {
        return this.statsElements;
    }

    @NotNull
    public final AddAction component2() {
        return this.addAction;
    }

    public final boolean component3() {
        return this.isAllowedBannedContents;
    }

    public final boolean component4() {
        return this.isExcludeGenre;
    }

    public final boolean component5() {
        return this.needToClear;
    }

    @Nullable
    public final L0 component6() {
        return this.progressUpdater;
    }

    @NotNull
    public final List component7() {
        return this.playables;
    }

    @NotNull
    public final AddPlayableList copy(@Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, boolean z, boolean z1, boolean z2, @Nullable L0 l00, @NotNull List list0) {
        q.g(addAction0, "addAction");
        q.g(list0, "playables");
        return new AddPlayableList(statsElementsBase0, addAction0, z, z1, z2, l00, list0);
    }

    public static AddPlayableList copy$default(AddPlayableList addPlayableList0, StatsElementsBase statsElementsBase0, AddAction addAction0, boolean z, boolean z1, boolean z2, L0 l00, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            statsElementsBase0 = addPlayableList0.statsElements;
        }
        if((v & 2) != 0) {
            addAction0 = addPlayableList0.addAction;
        }
        if((v & 4) != 0) {
            z = addPlayableList0.isAllowedBannedContents;
        }
        if((v & 8) != 0) {
            z1 = addPlayableList0.isExcludeGenre;
        }
        if((v & 16) != 0) {
            z2 = addPlayableList0.needToClear;
        }
        if((v & 0x20) != 0) {
            l00 = addPlayableList0.progressUpdater;
        }
        if((v & 0x40) != 0) {
            list0 = addPlayableList0.playables;
        }
        return addPlayableList0.copy(statsElementsBase0, addAction0, z, z1, z2, l00, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AddPlayableList)) {
            return false;
        }
        if(!q.b(this.statsElements, ((AddPlayableList)object0).statsElements)) {
            return false;
        }
        if(!q.b(this.addAction, ((AddPlayableList)object0).addAction)) {
            return false;
        }
        if(this.isAllowedBannedContents != ((AddPlayableList)object0).isAllowedBannedContents) {
            return false;
        }
        if(this.isExcludeGenre != ((AddPlayableList)object0).isExcludeGenre) {
            return false;
        }
        if(this.needToClear != ((AddPlayableList)object0).needToClear) {
            return false;
        }
        return q.b(this.progressUpdater, ((AddPlayableList)object0).progressUpdater) ? q.b(this.playables, ((AddPlayableList)object0).playables) : false;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public Object execute(@NotNull Continuation continuation0) {
        return AddToPlaylist.super.execute(continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public AddAction getAddAction() {
        return this.addAction;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public Object getAddPlayableListInfo(@NotNull Continuation continuation0) {
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.playables));
        for(Object object0: this.playables) {
            arrayList0.add(Playable.copyValueOfWithNewTrackId(((Playable)object0)));
        }
        return new CommonAddRequestPlayableListInfo(arrayList0);
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public CType getCType() {
        return this.cType;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public DeviceConnectableInfo getDeviceConnectInfo() {
        return this.deviceConnectInfo;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public String getMenuId() {
        return this.menuId;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public boolean getNeedToClear() {
        return this.needToClear;
    }

    @NotNull
    public final List getPlayables() {
        return this.playables;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public z getPlayerController() {
        return AddToPlaylist.super.getPlayerController();
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public ob.z getPlayerUseCase() {
        return AddToPlaylist.super.getPlayerUseCase();
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public Object getPlaylistId(@NotNull CType cType0, @NotNull Continuation continuation0) {
        return AddToPlaylist.super.getPlaylistId(cType0, continuation0);
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public s2 getPlaylistManager() {
        return AddToPlaylist.super.getPlaylistManager();
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public L0 getProgressUpdater() {
        return this.progressUpdater;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @NotNull
    public s getRemotePlayerManager() {
        return AddToPlaylist.super.getRemotePlayerManager();
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public StatsElementsBase getStatsElements() {
        return this.statsElements;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e((this.addAction.hashCode() + (this.statsElements == null ? 0 : this.statsElements.hashCode()) * 0x1F) * 0x1F, 0x1F, this.isAllowedBannedContents), 0x1F, this.isExcludeGenre), 0x1F, this.needToClear);
        L0 l00 = this.progressUpdater;
        if(l00 != null) {
            v = l00.hashCode();
        }
        return this.playables.hashCode() + (v1 + v) * 0x1F;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public boolean isAllowedBannedContents() {
        return this.isAllowedBannedContents;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public boolean isExcludeGenre() {
        return this.isExcludeGenre;
    }

    public final boolean isVideoType() {
        return this.isVideoType;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public void setAllowedBannedContents(boolean z) {
        this.isAllowedBannedContents = z;
    }

    @Override
    @NotNull
    public String toString() {
        boolean z = this.isAllowedBannedContents;
        StringBuilder stringBuilder0 = new StringBuilder("AddPlayableList(statsElements=");
        stringBuilder0.append(this.statsElements);
        stringBuilder0.append(", addAction=");
        stringBuilder0.append(this.addAction);
        stringBuilder0.append(", isAllowedBannedContents=");
        x.y(stringBuilder0, z, ", isExcludeGenre=", this.isExcludeGenre, ", needToClear=");
        stringBuilder0.append(this.needToClear);
        stringBuilder0.append(", progressUpdater=");
        stringBuilder0.append(this.progressUpdater);
        stringBuilder0.append(", playables=");
        return Y.m(stringBuilder0, this.playables, ")");
    }
}

