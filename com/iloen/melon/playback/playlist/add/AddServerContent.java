package com.iloen.melon.playback.playlist.add;

import A7.d;
import Qb.z;
import Ub.s;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.playlist.PlaylistId;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0001BB9\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rH\u0096@\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\tH\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018JD\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\tH\u00C6\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\u001BH\u00D6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001EH\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010 J\u001A\u0010#\u001A\u00020\u00042\b\u0010\"\u001A\u0004\u0018\u00010!H\u00D6\u0003\u00A2\u0006\u0004\b#\u0010$R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010%\u001A\u0004\b&\u0010\u0011R\"\u0010\u0005\u001A\u00020\u00048\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b\u0005\u0010\'\u001A\u0004\b\u0005\u0010\u0013\"\u0004\b(\u0010)R\u001A\u0010\u0006\u001A\u00020\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010\'\u001A\u0004\b\u0006\u0010\u0013R\u001C\u0010\b\u001A\u0004\u0018\u00010\u00078\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\b\u0010*\u001A\u0004\b+\u0010\u0016R\u0017\u0010\n\u001A\u00020\t8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010,\u001A\u0004\b-\u0010\u0018R\u001A\u0010.\u001A\u00020\u001B8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u0010\u001DR\u001A\u00102\u001A\u0002018\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105R\u001C\u00107\u001A\u0004\u0018\u0001068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b7\u00108\u001A\u0004\b9\u0010:R\u001A\u0010;\u001A\u00020\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b;\u0010\'\u001A\u0004\b<\u0010\u0013R\u001A\u0010>\u001A\u00020=8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\u00A8\u0006C"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddServerContent;", "Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "", "isAllowedBannedContents", "isExcludeGenre", "Lcom/iloen/melon/custom/L0;", "progressUpdater", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "playData", "<init>", "(Lcom/iloen/melon/playback/playlist/add/AddAction;ZZLcom/iloen/melon/custom/L0;Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getAddPlayableListInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Lcom/iloen/melon/playback/playlist/add/AddAction;", "component2", "()Z", "component3", "component4", "()Lcom/iloen/melon/custom/L0;", "component5", "()Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "copy", "(Lcom/iloen/melon/playback/playlist/add/AddAction;ZZLcom/iloen/melon/custom/L0;Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;)Lcom/iloen/melon/playback/playlist/add/AddServerContent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "getAddAction", "Z", "setAllowedBannedContents", "(Z)V", "Lcom/iloen/melon/custom/L0;", "getProgressUpdater", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "getPlayData", "menuId", "Ljava/lang/String;", "getMenuId", "Lcom/iloen/melon/constants/CType;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "needToClear", "getNeedToClear", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "deviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "getDeviceConnectInfo", "()Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddServerContent implements AddToPlaylist {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddServerContent$Companion;", "", "<init>", "()V", "Lcom/iloen/melon/constants/CType;", "cType", "", "contsId", "menuId", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "Lcom/iloen/melon/custom/L0;", "progressUpdater", "Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "with", "(Lcom/iloen/melon/constants/CType;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/playback/playlist/add/AddAction;Lcom/iloen/melon/custom/L0;)Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AddToPlaylist with(@NotNull CType cType0, @NotNull String s, @NotNull String s1, @NotNull AddAction addAction0, @Nullable L0 l00) {
            q.g(cType0, "cType");
            q.g(s, "contsId");
            q.g(s1, "menuId");
            q.g(addAction0, "addAction");
            if(!cType0.equals(CType.ALBUM) && !cType0.equals(CType.ALBUM2)) {
                if(cType0.equals(CType.PLAYLIST)) {
                    return new AddServerContent(addAction0, false, false, l00, new Playlist(s, s1, null));
                }
                if(cType0.equals(CType.MV)) {
                    return new AddServerContent(addAction0, false, false, l00, new MV(null, s, s1, null));
                }
                if(cType0.equals(CType.CHART_TOP100)) {
                    return new AddServerContent(addAction0, false, false, l00, new ChartTop100(s1, null));
                }
                if(cType0.equals(CType.STATION)) {
                    return new AddServerContent(addAction0, false, false, l00, new Station(s, "", s1, null));
                }
                if(cType0.equals(CType.ARTIST)) {
                    return new AddServerContent(addAction0, false, false, l00, new Artist(s, s1, null));
                }
                return cType0.equals(CType.LIVE) ? new AddServerContent(addAction0, false, false, l00, new Live(s, s1, null)) : new AddServerContent(addAction0, false, false, l00, new Song(s, cType0, s1, null));
            }
            return new AddServerContent(addAction0, false, false, l00, new Album(s, cType0, s1, null));
        }

        public static AddToPlaylist with$default(Companion addServerContent$Companion0, CType cType0, String s, String s1, AddAction addAction0, L0 l00, int v, Object object0) {
            if((v & 16) != 0) {
                l00 = AddToPlaylistImplKt.getDefaultProgressUpdater();
            }
            return addServerContent$Companion0.with(cType0, s, s1, addAction0, l00);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final AddAction addAction;
    @NotNull
    private final CType cType;
    @NotNull
    private final DeviceConnectableInfo deviceConnectInfo;
    private boolean isAllowedBannedContents;
    private final boolean isExcludeGenre;
    @NotNull
    private final String menuId;
    private final boolean needToClear;
    @NotNull
    private final PlayDataForSeverContent playData;
    @Nullable
    private final L0 progressUpdater;
    @Nullable
    private final StatsElementsBase statsElements;

    static {
        AddServerContent.Companion = new Companion(null);
        AddServerContent.$stable = 8;
    }

    public AddServerContent(@NotNull AddAction addAction0, @NotNull PlayDataForSeverContent playDataForSeverContent0) {
        q.g(addAction0, "addAction");
        q.g(playDataForSeverContent0, "playData");
        this(addAction0, false, false, null, playDataForSeverContent0, 14, null);
    }

    public AddServerContent(@NotNull AddAction addAction0, boolean z, @NotNull PlayDataForSeverContent playDataForSeverContent0) {
        q.g(addAction0, "addAction");
        q.g(playDataForSeverContent0, "playData");
        this(addAction0, z, false, null, playDataForSeverContent0, 12, null);
    }

    public AddServerContent(@NotNull AddAction addAction0, boolean z, boolean z1, @Nullable L0 l00, @NotNull PlayDataForSeverContent playDataForSeverContent0) {
        q.g(addAction0, "addAction");
        q.g(playDataForSeverContent0, "playData");
        super();
        this.addAction = addAction0;
        this.isAllowedBannedContents = z;
        this.isExcludeGenre = z1;
        this.progressUpdater = l00;
        this.playData = playDataForSeverContent0;
        this.menuId = playDataForSeverContent0.getMenuId();
        this.cType = playDataForSeverContent0.getCType();
        this.statsElements = playDataForSeverContent0.getStatsElements();
        this.needToClear = playDataForSeverContent0.getNeedToClear();
        this.deviceConnectInfo = playDataForSeverContent0.getDeviceConnectInfo();
    }

    public AddServerContent(AddAction addAction0, boolean z, boolean z1, L0 l00, PlayDataForSeverContent playDataForSeverContent0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        if((v & 8) != 0) {
            l00 = AddToPlaylistImplKt.access$getDefaultProgressUpdater();
        }
        this(addAction0, z, z1, l00, playDataForSeverContent0);
    }

    public AddServerContent(@NotNull AddAction addAction0, boolean z, boolean z1, @NotNull PlayDataForSeverContent playDataForSeverContent0) {
        q.g(addAction0, "addAction");
        q.g(playDataForSeverContent0, "playData");
        this(addAction0, z, z1, null, playDataForSeverContent0, 8, null);
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public Object checkPreCondition(@NotNull PlaylistId playlistId0, @NotNull Continuation continuation0) {
        return AddToPlaylist.super.checkPreCondition(playlistId0, continuation0);
    }

    @NotNull
    public final AddAction component1() {
        return this.addAction;
    }

    public final boolean component2() {
        return this.isAllowedBannedContents;
    }

    public final boolean component3() {
        return this.isExcludeGenre;
    }

    @Nullable
    public final L0 component4() {
        return this.progressUpdater;
    }

    @NotNull
    public final PlayDataForSeverContent component5() {
        return this.playData;
    }

    @NotNull
    public final AddServerContent copy(@NotNull AddAction addAction0, boolean z, boolean z1, @Nullable L0 l00, @NotNull PlayDataForSeverContent playDataForSeverContent0) {
        q.g(addAction0, "addAction");
        q.g(playDataForSeverContent0, "playData");
        return new AddServerContent(addAction0, z, z1, l00, playDataForSeverContent0);
    }

    public static AddServerContent copy$default(AddServerContent addServerContent0, AddAction addAction0, boolean z, boolean z1, L0 l00, PlayDataForSeverContent playDataForSeverContent0, int v, Object object0) {
        if((v & 1) != 0) {
            addAction0 = addServerContent0.addAction;
        }
        if((v & 2) != 0) {
            z = addServerContent0.isAllowedBannedContents;
        }
        if((v & 4) != 0) {
            z1 = addServerContent0.isExcludeGenre;
        }
        if((v & 8) != 0) {
            l00 = addServerContent0.progressUpdater;
        }
        if((v & 16) != 0) {
            playDataForSeverContent0 = addServerContent0.playData;
        }
        return addServerContent0.copy(addAction0, z, z1, l00, playDataForSeverContent0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AddServerContent)) {
            return false;
        }
        if(!q.b(this.addAction, ((AddServerContent)object0).addAction)) {
            return false;
        }
        if(this.isAllowedBannedContents != ((AddServerContent)object0).isAllowedBannedContents) {
            return false;
        }
        if(this.isExcludeGenre != ((AddServerContent)object0).isExcludeGenre) {
            return false;
        }
        return q.b(this.progressUpdater, ((AddServerContent)object0).progressUpdater) ? q.b(this.playData, ((AddServerContent)object0).playData) : false;
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
        return this.playData.getPlayableList(continuation0);
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
    public final PlayDataForSeverContent getPlayData() {
        return this.playData;
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
        int v = d.e(d.e(this.addAction.hashCode() * 0x1F, 0x1F, this.isAllowedBannedContents), 0x1F, this.isExcludeGenre);
        return this.progressUpdater == null ? this.playData.hashCode() + v * 0x1F : this.playData.hashCode() + (v + this.progressUpdater.hashCode()) * 0x1F;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public boolean isAllowedBannedContents() {
        return this.isAllowedBannedContents;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public boolean isExcludeGenre() {
        return this.isExcludeGenre;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    public void setAllowedBannedContents(boolean z) {
        this.isAllowedBannedContents = z;
    }

    @Override
    @NotNull
    public String toString() {
        return "AddServerContent(addAction=" + this.addAction + ", isAllowedBannedContents=" + this.isAllowedBannedContents + ", isExcludeGenre=" + this.isExcludeGenre + ", progressUpdater=" + this.progressUpdater + ", playData=" + this.playData + ")";
    }
}

