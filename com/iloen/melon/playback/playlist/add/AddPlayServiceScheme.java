package com.iloen.melon.playback.playlist.add;

import A7.d;
import Qb.z;
import Ub.s;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.playlist.PlaylistId;
import d5.n;
import java.util.List;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001A\u00020\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u0010\u001A\u00020\u000FH\u0096@\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\nH\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0013JP\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001A\u00020\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010\u0013J\u0010\u0010!\u001A\u00020 H\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\"J\u001A\u0010%\u001A\u00020\b2\b\u0010$\u001A\u0004\u0018\u00010#H\u00D6\u0003\u00A2\u0006\u0004\b%\u0010&R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010\'\u001A\u0004\b(\u0010\u0013R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010)\u001A\u0004\b*\u0010\u0015R\u001A\u0010\u0007\u001A\u00020\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010+\u001A\u0004\b,\u0010\u0017R\"\u0010\t\u001A\u00020\b8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b\t\u0010-\u001A\u0004\b\t\u0010\u0019\"\u0004\b.\u0010/R\u001C\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u000B\u00100\u001A\u0004\b1\u0010\u001BR\u0017\u0010\f\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\f\u0010\'\u001A\u0004\b2\u0010\u0013R\u001A\u00104\u001A\u0002038\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u00107R\u001A\u00108\u001A\u00020\b8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b8\u0010-\u001A\u0004\b8\u0010\u0019R\u001A\u00109\u001A\u00020\b8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b9\u0010-\u001A\u0004\b:\u0010\u0019R\u001A\u0010<\u001A\u00020;8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b<\u0010=\u001A\u0004\b>\u0010?\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddPlayServiceScheme;", "Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "", "isAllowedBannedContents", "Lcom/iloen/melon/custom/L0;", "progressUpdater", "uriString", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Lcom/iloen/melon/playback/playlist/add/AddAction;ZLcom/iloen/melon/custom/L0;Ljava/lang/String;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getAddPlayableListInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Ljava/lang/String;", "component2", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "component3", "()Lcom/iloen/melon/playback/playlist/add/AddAction;", "component4", "()Z", "component5", "()Lcom/iloen/melon/custom/L0;", "component6", "copy", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Lcom/iloen/melon/playback/playlist/add/AddAction;ZLcom/iloen/melon/custom/L0;Ljava/lang/String;)Lcom/iloen/melon/playback/playlist/add/AddPlayServiceScheme;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMenuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "getAddAction", "Z", "setAllowedBannedContents", "(Z)V", "Lcom/iloen/melon/custom/L0;", "getProgressUpdater", "getUriString", "Lcom/iloen/melon/constants/CType;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "isExcludeGenre", "needToClear", "getNeedToClear", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "deviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "getDeviceConnectInfo", "()Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddPlayServiceScheme implements AddToPlaylist {
    public static final int $stable = 8;
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
    @Nullable
    private final L0 progressUpdater;
    @Nullable
    private final StatsElementsBase statsElements;
    @NotNull
    private final String uriString;

    public AddPlayServiceScheme(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, boolean z, @Nullable L0 l00, @NotNull String s1) {
        q.g(s, "menuId");
        q.g(addAction0, "addAction");
        q.g(s1, "uriString");
        super();
        this.menuId = s;
        this.statsElements = statsElementsBase0;
        this.addAction = addAction0;
        this.isAllowedBannedContents = z;
        this.progressUpdater = l00;
        this.uriString = s1;
        q.f(CType.SERVICE_SCHEME, "SERVICE_SCHEME");
        this.cType = CType.SERVICE_SCHEME;
        this.deviceConnectInfo = new DeviceConnectableInfo(true, true);
    }

    public AddPlayServiceScheme(String s, StatsElementsBase statsElementsBase0, AddAction addAction0, boolean z, L0 l00, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            addAction0 = new AddPlay(false);
        }
        if((v & 16) != 0) {
            l00 = AddToPlaylistImplKt.access$getDefaultProgressUpdater();
        }
        this(s, statsElementsBase0, addAction0, z, l00, s1);
    }

    public AddPlayServiceScheme(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, boolean z, @NotNull String s1) {
        q.g(s, "menuId");
        q.g(addAction0, "addAction");
        q.g(s1, "uriString");
        this(s, statsElementsBase0, addAction0, z, null, s1, 16, null);
    }

    public AddPlayServiceScheme(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, boolean z, @NotNull String s1) {
        q.g(s, "menuId");
        q.g(s1, "uriString");
        this(s, statsElementsBase0, null, z, null, s1, 20, null);
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddToPlaylist
    @Nullable
    public Object checkPreCondition(@NotNull PlaylistId playlistId0, @NotNull Continuation continuation0) {
        return AddToPlaylist.super.checkPreCondition(playlistId0, continuation0);
    }

    @NotNull
    public final String component1() {
        return this.menuId;
    }

    @Nullable
    public final StatsElementsBase component2() {
        return this.statsElements;
    }

    @NotNull
    public final AddAction component3() {
        return this.addAction;
    }

    public final boolean component4() {
        return this.isAllowedBannedContents;
    }

    @Nullable
    public final L0 component5() {
        return this.progressUpdater;
    }

    @NotNull
    public final String component6() {
        return this.uriString;
    }

    @NotNull
    public final AddPlayServiceScheme copy(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, boolean z, @Nullable L0 l00, @NotNull String s1) {
        q.g(s, "menuId");
        q.g(addAction0, "addAction");
        q.g(s1, "uriString");
        return new AddPlayServiceScheme(s, statsElementsBase0, addAction0, z, l00, s1);
    }

    public static AddPlayServiceScheme copy$default(AddPlayServiceScheme addPlayServiceScheme0, String s, StatsElementsBase statsElementsBase0, AddAction addAction0, boolean z, L0 l00, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = addPlayServiceScheme0.menuId;
        }
        if((v & 2) != 0) {
            statsElementsBase0 = addPlayServiceScheme0.statsElements;
        }
        if((v & 4) != 0) {
            addAction0 = addPlayServiceScheme0.addAction;
        }
        if((v & 8) != 0) {
            z = addPlayServiceScheme0.isAllowedBannedContents;
        }
        if((v & 16) != 0) {
            l00 = addPlayServiceScheme0.progressUpdater;
        }
        if((v & 0x20) != 0) {
            s1 = addPlayServiceScheme0.uriString;
        }
        return addPlayServiceScheme0.copy(s, statsElementsBase0, addAction0, z, l00, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AddPlayServiceScheme)) {
            return false;
        }
        if(!q.b(this.menuId, ((AddPlayServiceScheme)object0).menuId)) {
            return false;
        }
        if(!q.b(this.statsElements, ((AddPlayServiceScheme)object0).statsElements)) {
            return false;
        }
        if(!q.b(this.addAction, ((AddPlayServiceScheme)object0).addAction)) {
            return false;
        }
        if(this.isAllowedBannedContents != ((AddPlayServiceScheme)object0).isAllowedBannedContents) {
            return false;
        }
        return q.b(this.progressUpdater, ((AddPlayServiceScheme)object0).progressUpdater) ? q.b(this.uriString, ((AddPlayServiceScheme)object0).uriString) : false;
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
        com.iloen.melon.playback.playlist.add.AddPlayServiceScheme.getAddPlayableListInfo.1 addPlayServiceScheme$getAddPlayableListInfo$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddPlayServiceScheme.getAddPlayableListInfo.1) {
            addPlayServiceScheme$getAddPlayableListInfo$10 = (com.iloen.melon.playback.playlist.add.AddPlayServiceScheme.getAddPlayableListInfo.1)continuation0;
            int v = addPlayServiceScheme$getAddPlayableListInfo$10.label;
            if((v & 0x80000000) == 0) {
                addPlayServiceScheme$getAddPlayableListInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getAddPlayableListInfo(this);
                    }
                };
            }
            else {
                addPlayServiceScheme$getAddPlayableListInfo$10.label = v ^ 0x80000000;
            }
        }
        else {
            addPlayServiceScheme$getAddPlayableListInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getAddPlayableListInfo(this);
                }
            };
        }
        Object object0 = addPlayServiceScheme$getAddPlayableListInfo$10.result;
        a a0 = a.a;
        switch(addPlayServiceScheme$getAddPlayableListInfo$10.label) {
            case 0: {
                n.D(object0);
                TaskGetPlayablesFromServiceScheme taskGetPlayablesFromServiceScheme0 = new TaskGetPlayablesFromServiceScheme(this.uriString, this.getMenuId());
                addPlayServiceScheme$getAddPlayableListInfo$10.label = 1;
                object0 = taskGetPlayablesFromServiceScheme0.execute(addPlayServiceScheme$getAddPlayableListInfo$10);
                return object0 == a0 ? a0 : new CommonAddRequestPlayableListInfo(((List)object0));
            }
            case 1: {
                n.D(object0);
                return new CommonAddRequestPlayableListInfo(((List)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
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

    @NotNull
    public final String getUriString() {
        return this.uriString;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e((this.addAction.hashCode() + (this.menuId.hashCode() * 0x1F + (this.statsElements == null ? 0 : this.statsElements.hashCode())) * 0x1F) * 0x1F, 0x1F, this.isAllowedBannedContents);
        L0 l00 = this.progressUpdater;
        if(l00 != null) {
            v = l00.hashCode();
        }
        return this.uriString.hashCode() + (v1 + v) * 0x1F;
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
        return "AddPlayServiceScheme(menuId=" + this.menuId + ", statsElements=" + this.statsElements + ", addAction=" + this.addAction + ", isAllowedBannedContents=" + this.isAllowedBannedContents + ", progressUpdater=" + this.progressUpdater + ", uriString=" + this.uriString + ")";
    }
}

