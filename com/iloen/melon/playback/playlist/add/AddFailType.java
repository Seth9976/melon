package com.iloen.melon.playback.playlist.add;

import android.os.Bundle;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.utils.Navigator;
import d5.w;
import ie.H;
import jd.X0;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000BB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000E\u000F\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType;", "", "<init>", "()V", "Normal", "SectionRepeatInterrupt", "SmartPlaylistAlert", "MusicWaveOpen", "AddAllBan", "VideoOpenWhenAuto", "EmptyPlaylist", "ShowNetworkPopup", "Lcom/iloen/melon/playback/playlist/add/AddFailType$AddAllBan;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$EmptyPlaylist;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$MusicWaveOpen;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$Normal;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$SectionRepeatInterrupt;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$ShowNetworkPopup;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$SmartPlaylistAlert;", "Lcom/iloen/melon/playback/playlist/add/AddFailType$VideoOpenWhenAuto;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class AddFailType {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$AddAllBan;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "()V", "popupData", "Lcom/iloen/melon/playback/playlist/add/PopupData;", "getPopupData", "()Lcom/iloen/melon/playback/playlist/add/PopupData;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AddAllBan extends AddFailType {
        public static final int $stable;
        @NotNull
        public static final AddAllBan INSTANCE;
        @NotNull
        private static final PopupData popupData;

        static {
            AddAllBan.INSTANCE = new AddAllBan();
            AddAllBan.popupData = new PopupData(0x7F1300D0, 0x7F1307AE, null, null, 12, null);  // string:alert_dlg_title_info "안내"
        }

        private AddAllBan() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof AddAllBan;
        }

        @NotNull
        public final PopupData getPopupData() {
            return AddAllBan.popupData;
        }

        @Override
        public int hashCode() {
            return -1693070461;
        }

        @Override
        @NotNull
        public String toString() {
            return "AddAllBan";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$EmptyPlaylist;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class EmptyPlaylist extends AddFailType {
        public static final int $stable;
        @NotNull
        public static final EmptyPlaylist INSTANCE;

        static {
            EmptyPlaylist.INSTANCE = new EmptyPlaylist();
        }

        private EmptyPlaylist() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof EmptyPlaylist;
        }

        @Override
        public int hashCode() {
            return 0xBA7F4D13;
        }

        @Override
        @NotNull
        public String toString() {
            return "EmptyPlaylist";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bH\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000EJ$\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000EJ\u0010\u0010\u0013\u001A\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001A\u0010\u0018\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001A\u001A\u0004\b\u001B\u0010\fR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001C\u001A\u0004\b\u001D\u0010\u000E¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$MusicWaveOpen;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "musicWaveChannelInfo", "", "menuId", "<init>", "(Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;Ljava/lang/String;)V", "Lie/H;", "navigate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "component2", "()Ljava/lang/String;", "copy", "(Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;Ljava/lang/String;)Lcom/iloen/melon/playback/playlist/add/AddFailType$MusicWaveOpen;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "getMusicWaveChannelInfo", "Ljava/lang/String;", "getMenuId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MusicWaveOpen extends AddFailType {
        public static final int $stable;
        @NotNull
        private final String menuId;
        @NotNull
        private final MusicWaveChannelInfo musicWaveChannelInfo;

        public MusicWaveOpen(@NotNull MusicWaveChannelInfo musicWaveChannelInfo0, @NotNull String s) {
            q.g(musicWaveChannelInfo0, "musicWaveChannelInfo");
            q.g(s, "menuId");
            super(null);
            this.musicWaveChannelInfo = musicWaveChannelInfo0;
            this.menuId = s;
        }

        @NotNull
        public final MusicWaveChannelInfo component1() {
            return this.musicWaveChannelInfo;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @NotNull
        public final MusicWaveOpen copy(@NotNull MusicWaveChannelInfo musicWaveChannelInfo0, @NotNull String s) {
            q.g(musicWaveChannelInfo0, "musicWaveChannelInfo");
            q.g(s, "menuId");
            return new MusicWaveOpen(musicWaveChannelInfo0, s);
        }

        public static MusicWaveOpen copy$default(MusicWaveOpen addFailType$MusicWaveOpen0, MusicWaveChannelInfo musicWaveChannelInfo0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                musicWaveChannelInfo0 = addFailType$MusicWaveOpen0.musicWaveChannelInfo;
            }
            if((v & 2) != 0) {
                s = addFailType$MusicWaveOpen0.menuId;
            }
            return addFailType$MusicWaveOpen0.copy(musicWaveChannelInfo0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MusicWaveOpen)) {
                return false;
            }
            return q.b(this.musicWaveChannelInfo, ((MusicWaveOpen)object0).musicWaveChannelInfo) ? q.b(this.menuId, ((MusicWaveOpen)object0).menuId) : false;
        }

        @NotNull
        public final String getMenuId() {
            return this.menuId;
        }

        @NotNull
        public final MusicWaveChannelInfo getMusicWaveChannelInfo() {
            return this.musicWaveChannelInfo;
        }

        @Override
        public int hashCode() {
            return this.menuId.hashCode() + this.musicWaveChannelInfo.hashCode() * 0x1F;
        }

        @Nullable
        public final Object navigate(@NotNull Continuation continuation0) {
            Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new n(null) {
                int label;

                {
                    MusicWaveOpen.this = addFailType$MusicWaveOpen0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.playback.playlist.add.AddFailType.MusicWaveOpen.navigate.2(MusicWaveOpen.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.playback.playlist.add.AddFailType.MusicWaveOpen.navigate.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    d5.n.D(object0);
                    String s = MusicWaveOpen.this.getMusicWaveChannelInfo().getType();
                    String s1 = MusicWaveOpen.this.getMusicWaveChannelInfo().getId();
                    String s2 = MusicWaveOpen.this.getMenuId();
                    q.g(s, "type");
                    q.g(s1, "id");
                    q.g(s2, "originMenuId");
                    w.d = false;
                    X0 x00 = new X0();
                    Bundle bundle0 = Y.c("musicWaveType", s, "musicWaveId", s1);
                    bundle0.putString("argOriginMenuId", s2);
                    x00.setArguments(bundle0);
                    Navigator.INSTANCE.open(x00);
                    return H.a;
                }
            }, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "MusicWaveOpen(musicWaveChannelInfo=" + this.musicWaveChannelInfo + ", menuId=" + this.menuId + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$Normal;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Normal extends AddFailType {
        public static final int $stable;
        @NotNull
        public static final Normal INSTANCE;

        static {
            Normal.INSTANCE = new Normal();
        }

        private Normal() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Normal;
        }

        @Override
        public int hashCode() {
            return 412583059;
        }

        @Override
        @NotNull
        public String toString() {
            return "Normal";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$SectionRepeatInterrupt;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SectionRepeatInterrupt extends AddFailType {
        public static final int $stable;
        @NotNull
        public static final SectionRepeatInterrupt INSTANCE;

        static {
            SectionRepeatInterrupt.INSTANCE = new SectionRepeatInterrupt();
        }

        private SectionRepeatInterrupt() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof SectionRepeatInterrupt;
        }

        @Override
        public int hashCode() {
            return 0x1E32210F;
        }

        @Override
        @NotNull
        public String toString() {
            return "SectionRepeatInterrupt";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000B\u0010\b\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$ShowNetworkPopup;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "msg", "", "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ShowNetworkPopup extends AddFailType {
        public static final int $stable;
        @Nullable
        private final String msg;

        public ShowNetworkPopup(@Nullable String s) {
            super(null);
            this.msg = s;
        }

        @Nullable
        public final String component1() {
            return this.msg;
        }

        @NotNull
        public final ShowNetworkPopup copy(@Nullable String s) {
            return new ShowNetworkPopup(s);
        }

        public static ShowNetworkPopup copy$default(ShowNetworkPopup addFailType$ShowNetworkPopup0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = addFailType$ShowNetworkPopup0.msg;
            }
            return addFailType$ShowNetworkPopup0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ShowNetworkPopup ? q.b(this.msg, ((ShowNetworkPopup)object0).msg) : false;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @Override
        public int hashCode() {
            return this.msg == null ? 0 : this.msg.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "ShowNetworkPopup(msg=" + this.msg + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$SmartPlaylistAlert;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "()V", "popupData", "Lcom/iloen/melon/playback/playlist/add/PopupData;", "getPopupData", "()Lcom/iloen/melon/playback/playlist/add/PopupData;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SmartPlaylistAlert extends AddFailType {
        public static final int $stable;
        @NotNull
        public static final SmartPlaylistAlert INSTANCE;
        @NotNull
        private static final PopupData popupData;

        static {
            SmartPlaylistAlert.INSTANCE = new SmartPlaylistAlert();
            SmartPlaylistAlert.popupData = new PopupData(0x7F1300D0, 0x7F130A25, null, null, 12, null);  // string:alert_dlg_title_info "안내"
        }

        private SmartPlaylistAlert() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof SmartPlaylistAlert;
        }

        @NotNull
        public final PopupData getPopupData() {
            return SmartPlaylistAlert.popupData;
        }

        @Override
        public int hashCode() {
            return 0xF19E190D;
        }

        @Override
        @NotNull
        public String toString() {
            return "SmartPlaylistAlert";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddFailType$VideoOpenWhenAuto;", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class VideoOpenWhenAuto extends AddFailType {
        public static final int $stable;
        @NotNull
        public static final VideoOpenWhenAuto INSTANCE;

        static {
            VideoOpenWhenAuto.INSTANCE = new VideoOpenWhenAuto();
        }

        private VideoOpenWhenAuto() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof VideoOpenWhenAuto;
        }

        @Override
        public int hashCode() {
            return -1638601374;
        }

        @Override
        @NotNull
        public String toString() {
            return "VideoOpenWhenAuto";
        }
    }

    public static final int $stable;

    private AddFailType() {
    }

    public AddFailType(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

