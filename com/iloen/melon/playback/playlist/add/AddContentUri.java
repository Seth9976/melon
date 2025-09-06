package com.iloen.melon.playback.playlist.add;

import Qb.z;
import Ub.s;
import android.net.Uri;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EH\u0096@\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJF\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000B\u001A\u00020\nH\u00C6\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u0012J\u0010\u0010\u001F\u001A\u00020\u001EH\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010 J\u001A\u0010$\u001A\u00020#2\b\u0010\"\u001A\u0004\u0018\u00010!H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010&\u001A\u0004\b\'\u0010\u0012R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010(\u001A\u0004\b)\u0010\u0014R\u001A\u0010\u0007\u001A\u00020\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010*\u001A\u0004\b+\u0010\u0016R\u001C\u0010\t\u001A\u0004\u0018\u00010\b8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\t\u0010,\u001A\u0004\b-\u0010\u0018R\u0017\u0010\u000B\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010.\u001A\u0004\b/\u0010\u001AR\u001A\u00101\u001A\u0002008\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104R\u001A\u00105\u001A\u00020#8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b5\u00106\u001A\u0004\b7\u00108R\u001A\u00109\u001A\u00020#8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b9\u00106\u001A\u0004\b9\u00108R\"\u0010:\u001A\u00020#8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b:\u00106\u001A\u0004\b:\u00108\"\u0004\b;\u0010<R\u001A\u0010>\u001A\u00020=8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\u00A8\u0006B"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddContentUri;", "Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "Lcom/iloen/melon/custom/L0;", "progressUpdater", "Landroid/net/Uri;", "mediaUri", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Lcom/iloen/melon/playback/playlist/add/AddAction;Lcom/iloen/melon/custom/L0;Landroid/net/Uri;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getAddPlayableListInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Ljava/lang/String;", "component2", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "component3", "()Lcom/iloen/melon/playback/playlist/add/AddAction;", "component4", "()Lcom/iloen/melon/custom/L0;", "component5", "()Landroid/net/Uri;", "copy", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Lcom/iloen/melon/playback/playlist/add/AddAction;Lcom/iloen/melon/custom/L0;Landroid/net/Uri;)Lcom/iloen/melon/playback/playlist/add/AddContentUri;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMenuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "getAddAction", "Lcom/iloen/melon/custom/L0;", "getProgressUpdater", "Landroid/net/Uri;", "getMediaUri", "Lcom/iloen/melon/constants/CType;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "Z", "getNeedToClear", "()Z", "isExcludeGenre", "isAllowedBannedContents", "setAllowedBannedContents", "(Z)V", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "deviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "getDeviceConnectInfo", "()Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AddContentUri implements AddToPlaylist {
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
    private final Uri mediaUri;
    @NotNull
    private final String menuId;
    private final boolean needToClear;
    @Nullable
    private final L0 progressUpdater;
    @Nullable
    private final StatsElementsBase statsElements;

    public AddContentUri(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, @NotNull Uri uri0) {
        q.g(s, "menuId");
        q.g(addAction0, "addAction");
        q.g(uri0, "mediaUri");
        this(s, statsElementsBase0, addAction0, null, uri0, 8, null);
    }

    public AddContentUri(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, @Nullable L0 l00, @NotNull Uri uri0) {
        q.g(s, "menuId");
        q.g(addAction0, "addAction");
        q.g(uri0, "mediaUri");
        super();
        this.menuId = s;
        this.statsElements = statsElementsBase0;
        this.addAction = addAction0;
        this.progressUpdater = l00;
        this.mediaUri = uri0;
        q.f(CType.SONG, "SONG");
        this.cType = CType.SONG;
        this.deviceConnectInfo = new DeviceConnectableInfo(true, true);
    }

    public AddContentUri(String s, StatsElementsBase statsElementsBase0, AddAction addAction0, L0 l00, Uri uri0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            l00 = AddToPlaylistImplKt.access$getDefaultProgressUpdater();
        }
        this(s, statsElementsBase0, addAction0, l00, uri0);
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

    @Nullable
    public final L0 component4() {
        return this.progressUpdater;
    }

    @NotNull
    public final Uri component5() {
        return this.mediaUri;
    }

    @NotNull
    public final AddContentUri copy(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0, @NotNull AddAction addAction0, @Nullable L0 l00, @NotNull Uri uri0) {
        q.g(s, "menuId");
        q.g(addAction0, "addAction");
        q.g(uri0, "mediaUri");
        return new AddContentUri(s, statsElementsBase0, addAction0, l00, uri0);
    }

    public static AddContentUri copy$default(AddContentUri addContentUri0, String s, StatsElementsBase statsElementsBase0, AddAction addAction0, L0 l00, Uri uri0, int v, Object object0) {
        if((v & 1) != 0) {
            s = addContentUri0.menuId;
        }
        if((v & 2) != 0) {
            statsElementsBase0 = addContentUri0.statsElements;
        }
        if((v & 4) != 0) {
            addAction0 = addContentUri0.addAction;
        }
        if((v & 8) != 0) {
            l00 = addContentUri0.progressUpdater;
        }
        if((v & 16) != 0) {
            uri0 = addContentUri0.mediaUri;
        }
        return addContentUri0.copy(s, statsElementsBase0, addAction0, l00, uri0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AddContentUri)) {
            return false;
        }
        if(!q.b(this.menuId, ((AddContentUri)object0).menuId)) {
            return false;
        }
        if(!q.b(this.statsElements, ((AddContentUri)object0).statsElements)) {
            return false;
        }
        if(!q.b(this.addAction, ((AddContentUri)object0).addAction)) {
            return false;
        }
        return q.b(this.progressUpdater, ((AddContentUri)object0).progressUpdater) ? q.b(this.mediaUri, ((AddContentUri)object0).mediaUri) : false;
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
        com.iloen.melon.playback.playlist.add.AddContentUri.getAddPlayableListInfo.1 addContentUri$getAddPlayableListInfo$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddContentUri.getAddPlayableListInfo.1) {
            addContentUri$getAddPlayableListInfo$10 = (com.iloen.melon.playback.playlist.add.AddContentUri.getAddPlayableListInfo.1)continuation0;
            int v = addContentUri$getAddPlayableListInfo$10.label;
            if((v & 0x80000000) == 0) {
                addContentUri$getAddPlayableListInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                addContentUri$getAddPlayableListInfo$10.label = v ^ 0x80000000;
            }
        }
        else {
            addContentUri$getAddPlayableListInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = addContentUri$getAddPlayableListInfo$10.result;
        a a0 = a.a;
        switch(addContentUri$getAddPlayableListInfo$10.label) {
            case 0: {
                n.D(object0);
                TaskGetPlayablesFromContentUri taskGetPlayablesFromContentUri0 = new TaskGetPlayablesFromContentUri(this.mediaUri);
                addContentUri$getAddPlayableListInfo$10.label = 1;
                object0 = taskGetPlayablesFromContentUri0.execute(addContentUri$getAddPlayableListInfo$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return !((List)object0).isEmpty() ? new CommonAddRequestPlayableListInfo(((List)object0)) : EmptyAddRequestPlayableListInfo.INSTANCE;
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

    @NotNull
    public final Uri getMediaUri() {
        return this.mediaUri;
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

    @Override
    public int hashCode() {
        int v = this.menuId.hashCode();
        int v1 = 0;
        int v2 = this.statsElements == null ? 0 : this.statsElements.hashCode();
        int v3 = this.addAction.hashCode();
        L0 l00 = this.progressUpdater;
        if(l00 != null) {
            v1 = l00.hashCode();
        }
        return this.mediaUri.hashCode() + ((v3 + (v * 0x1F + v2) * 0x1F) * 0x1F + v1) * 0x1F;
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
        return "AddContentUri(menuId=" + this.menuId + ", statsElements=" + this.statsElements + ", addAction=" + this.addAction + ", progressUpdater=" + this.progressUpdater + ", mediaUri=" + this.mediaUri + ")";
    }
}

