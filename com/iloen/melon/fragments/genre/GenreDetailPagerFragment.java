package com.iloen.melon.fragments.genre;

import A7.d;
import U4.x;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.view.View;
import androidx.viewpager.widget.j;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.fragments.DetailTabPagerBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.request.GenreMenuDtlGnrsReq.Params;
import com.iloen.melon.net.v5x.request.GenreMenuDtlGnrsReq;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE.GNR;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE.GNRLIST;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;
import v9.i;
import we.n;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\'\u0018\u0000 Q2\u00020\u0001:\u0002QRB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000B\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u000E\u0010\fJ\u0011\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0004\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0011\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J-\u0010&\u001A\u00020\u00182\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010$\u001A\u0004\u0018\u00010#2\b\u0010%\u001A\u0004\u0018\u00010\u000FH\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b(\u0010\u0003R\"\u0010)\u001A\u00020\u000F8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010\u0011\"\u0004\b,\u0010-R\"\u0010.\u001A\u00020\u000F8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010*\u001A\u0004\b/\u0010\u0011\"\u0004\b0\u0010-R\"\u00101\u001A\u00020\u000F8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010*\u001A\u0004\b2\u0010\u0011\"\u0004\b3\u0010-R\"\u00104\u001A\u00020\u001E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b4\u00105\u001A\u0004\b6\u0010 \"\u0004\b7\u00108R$\u0010:\u001A\u0004\u0018\u0001098\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b:\u0010;\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010A\u001A\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010I\u001A\b\u0012\u0004\u0012\u00020H0G8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bI\u0010J\u001A\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0018\u0010O\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010*R\u0018\u0010P\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010*\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment;", "Lcom/iloen/melon/fragments/DetailTabPagerBaseFragment;", "<init>", "()V", "Lie/H;", "updateTabInfoList", "onSetProgress", "onTabFetchStart", "onTabFetched", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "", "getGenreBgImg", "()Ljava/lang/String;", "getRefcrTypeCode", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isMixUpButtonVisible", "()Z", "Lcom/iloen/melon/custom/tablayout/AbsTabIndicatorLayout;", "createTabIndicator", "()Lcom/iloen/melon/custom/tablayout/AbsTabIndicatorLayout;", "", "getTabHeight", "()I", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "fetchTabMenuInfo", "menuName", "Ljava/lang/String;", "getMenuName", "setMenuName", "(Ljava/lang/String;)V", "genreCode", "getGenreCode", "setGenreCode", "alyacGenreCode", "getAlyacGenreCode", "setAlyacGenreCode", "selectedTabIndex", "I", "getSelectedTabIndex", "setSelectedTabIndex", "(I)V", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "LE8/d;", "tabIndicatorView", "LE8/d;", "getTabIndicatorView", "()LE8/d;", "setTabIndicatorView", "(LE8/d;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$GenreMenu;", "genreMenuArray", "Ljava/util/ArrayList;", "getGenreMenuArray", "()Ljava/util/ArrayList;", "setGenreMenuArray", "(Ljava/util/ArrayList;)V", "genreBgImg", "genreFontColor", "Companion", "GenreMenu", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class GenreDetailPagerFragment extends DetailTabPagerBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\bX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SELECTED_TAB_INDEX", "TAB_SELECTED_INDEX_NONE", "", "getTAB_SELECTED_INDEX_NONE", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        public final int getTAB_SELECTED_INDEX_NONE() [...] // 潜在的解密器
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B7\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00A2\u0006\u0004\b\n\u0010\u000BB\u0011\b\u0016\u0012\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\b\n\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0017J\u0018\u0010\u001B\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJJ\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00022\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010\u0017J\u0010\u0010 \u001A\u00020\u000FH\u00D6\u0001\u00A2\u0006\u0004\b \u0010\u0015J\u001A\u0010$\u001A\u00020#2\b\u0010\"\u001A\u0004\u0018\u00010!H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010&\u001A\u0004\b\'\u0010\u0017R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010&\u001A\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010&\u001A\u0004\b)\u0010\u0017R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010&\u001A\u0004\b*\u0010\u0017R\u001F\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\t\u0010+\u001A\u0004\b,\u0010\u001C\u00A8\u0006."}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$GenreMenu;", "Landroid/os/Parcelable;", "", "gnrCode", "gnrName", "guiType", "yearlyGnrYN", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/GenreMenuDtlGnrsRes$RESPONSE$DTLGNRLIST;", "dtlGnrList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Ljava/util/ArrayList;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$GenreMenu;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGnrCode", "getGnrName", "getGuiType", "getYearlyGnrYN", "Ljava/util/ArrayList;", "getDtlGnrList", "CREATOR", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class GenreMenu implements Parcelable {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u001D\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$GenreMenu$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$GenreMenu;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment$GenreMenu;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CREATOR implements Parcelable.Creator {
            private CREATOR() {
            }

            public CREATOR(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public GenreMenu createFromParcel(@NotNull Parcel parcel0) {
                q.g(parcel0, "parcel");
                return new GenreMenu(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            @NotNull
            public GenreMenu[] newArray(int v) {
                return new GenreMenu[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        }

        public static final int $stable;
        @NotNull
        public static final CREATOR CREATOR;
        @Nullable
        private final ArrayList dtlGnrList;
        @NotNull
        private final String gnrCode;
        @NotNull
        private final String gnrName;
        @NotNull
        private final String guiType;
        @NotNull
        private final String yearlyGnrYN;

        static {
            GenreMenu.CREATOR = new CREATOR(null);
            GenreMenu.$stable = 8;
        }

        public GenreMenu(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            String s = parcel0.readString();
            String s1 = parcel0.readString();
            String s2 = parcel0.readString();
            String s3 = parcel0.readString();
            this((s == null ? "" : s), (s1 == null ? "" : s1), (s2 == null ? "" : s2), (s3 == null ? "" : s3), ((ArrayList)parcel0.readSerializable()));
        }

        public GenreMenu(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable ArrayList arrayList0) {
            q.g(s, "gnrCode");
            q.g(s1, "gnrName");
            q.g(s2, "guiType");
            q.g(s3, "yearlyGnrYN");
            super();
            this.gnrCode = s;
            this.gnrName = s1;
            this.guiType = s2;
            this.yearlyGnrYN = s3;
            this.dtlGnrList = arrayList0;
        }

        @NotNull
        public final String component1() {
            return this.gnrCode;
        }

        @NotNull
        public final String component2() {
            return this.gnrName;
        }

        @NotNull
        public final String component3() {
            return this.guiType;
        }

        @NotNull
        public final String component4() {
            return this.yearlyGnrYN;
        }

        @Nullable
        public final ArrayList component5() {
            return this.dtlGnrList;
        }

        @NotNull
        public final GenreMenu copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable ArrayList arrayList0) {
            q.g(s, "gnrCode");
            q.g(s1, "gnrName");
            q.g(s2, "guiType");
            q.g(s3, "yearlyGnrYN");
            return new GenreMenu(s, s1, s2, s3, arrayList0);
        }

        public static GenreMenu copy$default(GenreMenu genreDetailPagerFragment$GenreMenu0, String s, String s1, String s2, String s3, ArrayList arrayList0, int v, Object object0) {
            if((v & 1) != 0) {
                s = genreDetailPagerFragment$GenreMenu0.gnrCode;
            }
            if((v & 2) != 0) {
                s1 = genreDetailPagerFragment$GenreMenu0.gnrName;
            }
            if((v & 4) != 0) {
                s2 = genreDetailPagerFragment$GenreMenu0.guiType;
            }
            if((v & 8) != 0) {
                s3 = genreDetailPagerFragment$GenreMenu0.yearlyGnrYN;
            }
            if((v & 16) != 0) {
                arrayList0 = genreDetailPagerFragment$GenreMenu0.dtlGnrList;
            }
            return genreDetailPagerFragment$GenreMenu0.copy(s, s1, s2, s3, arrayList0);
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof GenreMenu)) {
                return false;
            }
            if(!q.b(this.gnrCode, ((GenreMenu)object0).gnrCode)) {
                return false;
            }
            if(!q.b(this.gnrName, ((GenreMenu)object0).gnrName)) {
                return false;
            }
            if(!q.b(this.guiType, ((GenreMenu)object0).guiType)) {
                return false;
            }
            return q.b(this.yearlyGnrYN, ((GenreMenu)object0).yearlyGnrYN) ? q.b(this.dtlGnrList, ((GenreMenu)object0).dtlGnrList) : false;
        }

        @Nullable
        public final ArrayList getDtlGnrList() {
            return this.dtlGnrList;
        }

        @NotNull
        public final String getGnrCode() {
            return this.gnrCode;
        }

        @NotNull
        public final String getGnrName() {
            return this.gnrName;
        }

        @NotNull
        public final String getGuiType() {
            return this.guiType;
        }

        @NotNull
        public final String getYearlyGnrYN() {
            return this.yearlyGnrYN;
        }

        @Override
        public int hashCode() {
            int v = x.b(x.b(x.b(this.gnrCode.hashCode() * 0x1F, 0x1F, this.gnrName), 0x1F, this.guiType), 0x1F, this.yearlyGnrYN);
            return this.dtlGnrList == null ? v : v + this.dtlGnrList.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("GenreMenu(gnrCode=", this.gnrCode, ", gnrName=", this.gnrName, ", guiType=");
            d.u(stringBuilder0, this.guiType, ", yearlyGnrYN=", this.yearlyGnrYN, ", dtlGnrList=");
            stringBuilder0.append(this.dtlGnrList);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "parcel");
            parcel0.writeString(this.gnrCode);
            parcel0.writeString(this.gnrName);
            parcel0.writeString(this.guiType);
            parcel0.writeString(this.yearlyGnrYN);
            parcel0.writeSerializable(this.dtlGnrList);
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_SELECTED_TAB_INDEX;
    @NotNull
    public static final Companion Companion;
    private static final int TAB_SELECTED_INDEX_NONE;
    @NotNull
    private static final String TAG;
    @NotNull
    private String alyacGenreCode;
    @Nullable
    private String genreBgImg;
    @NotNull
    private String genreCode;
    @Nullable
    private String genreFontColor;
    @NotNull
    private ArrayList genreMenuArray;
    @NotNull
    private String menuName;
    private int selectedTabIndex;
    @Nullable
    private StatsElementsBase statsElements;
    @Nullable
    private E8.d tabIndicatorView;

    static {
        GenreDetailPagerFragment.Companion = new Companion(null);
        GenreDetailPagerFragment.$stable = 8;
        GenreDetailPagerFragment.TAG = "GenreDetailPagerFragment";
        GenreDetailPagerFragment.ARG_SELECTED_TAB_INDEX = "argCenreCode";
        GenreDetailPagerFragment.TAB_SELECTED_INDEX_NONE = -1;
    }

    public GenreDetailPagerFragment() {
        this.menuName = "";
        this.genreCode = "";
        this.alyacGenreCode = "";
        this.selectedTabIndex = -1;
        this.genreMenuArray = new ArrayList();
    }

    public static final int access$getTAB_SELECTED_INDEX_NONE$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public AbsTabIndicatorLayout createTabIndicator() {
        Context context0 = this.getContext();
        if(context0 != null) {
            E8.d d0 = new E8.d(this.getActivity());  // 初始化器: Lcom/iloen/melon/custom/tablayout/ScrollTabLayout;-><init>(Landroid/content/Context;)V
            d0.B = true;
            d0.w = false;
            this.tabIndicatorView = d0;
            d0.setScrollOffset(ScreenUtils.dipToPixel(this.getContext(), 135.0f));
            E8.d d1 = this.tabIndicatorView;
            if(d1 != null) {
                d1.setBackgroundColor(ColorUtils.getColor(context0, 0x7F06002B));  // color:bg
            }
            if(q.b(this.genreCode, "GN2300")) {
                E8.d d2 = this.tabIndicatorView;
                if(d2 != null) {
                    d2.setMixUpButtonEnabled(false);
                }
            }
            E8.d d3 = this.tabIndicatorView;
            if(d3 != null) {
                d3.setOnPageChangeListener(new j() {
                    @Override  // androidx.viewpager.widget.j
                    public void onPageScrollStateChanged(int v) {
                    }

                    @Override  // androidx.viewpager.widget.j
                    public void onPageScrolled(int v, float f, int v1) {
                    }

                    @Override  // androidx.viewpager.widget.j
                    public void onPageSelected(int v) {
                        GenreDetailPagerFragment.this.setSelectedTabIndex(v);
                    }
                });
            }
        }
        return this.tabIndicatorView;
    }

    public void fetchTabMenuInfo() {
        Params genreMenuDtlGnrsReq$Params0 = new Params();
        genreMenuDtlGnrsReq$Params0.gnrCode = this.genreCode;
        genreMenuDtlGnrsReq$Params0.refcrTypeCode = this.getRefcrTypeCode();
        RequestBuilder.newInstance(new GenreMenuDtlGnrsReq(this.getContext(), genreMenuDtlGnrsReq$Params0)).tag("MelonPagerFragment").listener(new r(this)).errorListener(new r(this)).request();
    }

    private static final void fetchTabMenuInfo$lambda$3(GenreDetailPagerFragment genreDetailPagerFragment0, GenreMenuDtlGnrsRes genreMenuDtlGnrsRes0) {
        genreDetailPagerFragment0.mEmptyView = genreDetailPagerFragment0.findViewById(0x7F0A08A5);  // id:network_error_layout
        if(genreDetailPagerFragment0.prepareFetchComplete(genreMenuDtlGnrsRes0) && genreMenuDtlGnrsRes0 != null && genreMenuDtlGnrsRes0.isSuccessful()) {
            RESPONSE genreMenuDtlGnrsRes$RESPONSE0 = genreMenuDtlGnrsRes0.response;
            if(genreMenuDtlGnrsRes$RESPONSE0 != null) {
                genreDetailPagerFragment0.mMenuId = genreMenuDtlGnrsRes$RESPONSE0.menuId;
                genreDetailPagerFragment0.statsElements = genreMenuDtlGnrsRes$RESPONSE0.statsElements;
                genreDetailPagerFragment0.mMelonTiaraProperty = new s(genreMenuDtlGnrsRes$RESPONSE0.section, genreMenuDtlGnrsRes$RESPONSE0.page, genreMenuDtlGnrsRes$RESPONSE0.menuId, null);
                GNR genreMenuDtlGnrsRes$RESPONSE$GNR0 = genreMenuDtlGnrsRes$RESPONSE0.gnr;
                if(genreMenuDtlGnrsRes$RESPONSE$GNR0 != null) {
                    String s = genreMenuDtlGnrsRes$RESPONSE$GNR0.gnrName;
                    q.f(s, "gnrName");
                    genreDetailPagerFragment0.menuName = s;
                    genreDetailPagerFragment0.genreBgImg = genreMenuDtlGnrsRes$RESPONSE0.gnr.bgImgUrl;
                    genreDetailPagerFragment0.genreFontColor = genreMenuDtlGnrsRes$RESPONSE0.gnr.fontColor;
                }
                ArrayList arrayList0 = genreMenuDtlGnrsRes$RESPONSE0.dtlGnrList;
                if(arrayList0 != null) {
                    genreDetailPagerFragment0.genreMenuArray.clear();
                    Iterator iterator0 = arrayList0.iterator();
                    q.f(iterator0, "iterator(...)");
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        ArrayList arrayList1 = genreDetailPagerFragment0.genreMenuArray;
                        String s1 = ((GNRLIST)object0).gnrCode;
                        q.f(s1, "gnrCode");
                        String s2 = ((GNRLIST)object0).gnrName;
                        q.f(s2, "gnrName");
                        String s3 = ((GNRLIST)object0).guiType;
                        q.f(s3, "guiType");
                        String s4 = ((GNRLIST)object0).isYearlyGnr;
                        q.f(s4, "isYearlyGnr");
                        arrayList1.add(new GenreMenu(s1, s2, s3, s4, ((GNRLIST)object0).dtlGnrList));
                    }
                }
                genreDetailPagerFragment0.updateTabInfoList();
                genreDetailPagerFragment0.onTabFetched();
                genreDetailPagerFragment0.updateParallaxHeaderHeight();
            }
        }
    }

    private static final void fetchTabMenuInfo$lambda$4(GenreDetailPagerFragment genreDetailPagerFragment0, VolleyError volleyError0) {
        LogU.Companion.w("GenreDetailPagerFragment", "fetchTabMenuInfo() - Could not get the menus from genreCode: " + genreDetailPagerFragment0.genreCode + "\nErr: " + volleyError0);
        genreDetailPagerFragment0.mResponseErrorListener.onErrorResponse(volleyError0);
    }

    @NotNull
    public final String getAlyacGenreCode() {
        return this.alyacGenreCode;
    }

    @Nullable
    public final String getGenreBgImg() {
        return this.genreBgImg;
    }

    @NotNull
    public final String getGenreCode() {
        return this.genreCode;
    }

    @NotNull
    public final ArrayList getGenreMenuArray() {
        return this.genreMenuArray;
    }

    @NotNull
    public final String getMenuName() {
        return this.menuName;
    }

    @Nullable
    public String getRefcrTypeCode() {
        return null;
    }

    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    @Nullable
    public final StatsElementsBase getStatsElements() {
        return this.statsElements;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTabHeight() {
        if(this.genreMenuArray.size() <= 1) {
            return 0;
        }
        Context context0 = this.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            return resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F07044D);  // dimen:tab_container_genre_detail_height
        }
        return 0;
    }

    @Nullable
    public final E8.d getTabIndicatorView() {
        return this.tabIndicatorView;
    }

    public boolean isMixUpButtonVisible() [...] // Inlined contents

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(null) {
            int label;

            {
                GenreDetailPagerFragment.this = genreDetailPagerFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.genre.GenreDetailPagerFragment.onFetchStart.1(GenreDetailPagerFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.genre.GenreDetailPagerFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                GenreDetailPagerFragment.this.showProgress(true);
                GenreDetailPagerFragment.this.fetchTabMenuInfo();
                GenreDetailPagerFragment.this.showProgress(false);
                return H.a;
            }
        }, 3, null);
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.selectedTabIndex = bundle0.getInt("argCenreCode", -1);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argCenreCode", this.selectedTabIndex);
    }

    public abstract void onSetProgress();

    public abstract void onTabFetchStart();

    public abstract void onTabFetched();

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
    }

    public final void setAlyacGenreCode(@NotNull String s) {
        q.g(s, "<set-?>");
        this.alyacGenreCode = s;
    }

    public final void setGenreCode(@NotNull String s) {
        q.g(s, "<set-?>");
        this.genreCode = s;
    }

    public final void setGenreMenuArray(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<set-?>");
        this.genreMenuArray = arrayList0;
    }

    public final void setMenuName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.menuName = s;
    }

    public final void setSelectedTabIndex(int v) {
        this.selectedTabIndex = v;
    }

    public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
        this.statsElements = statsElementsBase0;
    }

    public final void setTabIndicatorView(@Nullable E8.d d0) {
        this.tabIndicatorView = d0;
    }

    public abstract void updateTabInfoList();
}

