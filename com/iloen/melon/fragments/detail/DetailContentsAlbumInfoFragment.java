package com.iloen.melon.fragments.detail;

import A7.d;
import B.a;
import De.I;
import F8.o;
import J8.F;
import U4.x;
import Vb.i;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.melon.ui.c0;
import com.melon.ui.detail.holder.DetailHolderUiState.CreditItemUiState;
import d3.g;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u000E2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u001B\u0010 \u001A\u00020\u001B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment;", "Lcom/melon/ui/c0;", "<init>", "()V", "Lie/H;", "initUi", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "LJ8/F;", "binding", "LJ8/F;", "Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment$AlbumInfoParam;", "albumInfoParam", "Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment$AlbumInfoParam;", "LUd/j;", "titleBarEventHelper$delegate", "Lie/j;", "getTitleBarEventHelper", "()LUd/j;", "titleBarEventHelper", "Companion", "AlbumInfoParam", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsAlbumInfoFragment extends c0 {
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0002\u0012\u000E\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001AJ\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001AJ\u0012\u0010\u001F\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001AJ\u0012\u0010 \u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001AJ\u0012\u0010!\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001AJ\u0018\u0010\"\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#J~\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BH\u00C6\u0001\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\u001AJ\u0010\u0010\'\u001A\u00020\u0010H\u00D6\u0001\u00A2\u0006\u0004\b\'\u0010\u0012J\u001A\u0010+\u001A\u00020*2\b\u0010)\u001A\u0004\u0018\u00010(H\u00D6\u0003\u00A2\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010-\u001A\u0004\b.\u0010\u001AR\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010-\u001A\u0004\b/\u0010\u001AR\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010-\u001A\u0004\b0\u0010\u001AR\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010-\u001A\u0004\b1\u0010\u001AR\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010-\u001A\u0004\b2\u0010\u001AR\u0019\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010-\u001A\u0004\b3\u0010\u001AR\u0019\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\t\u0010-\u001A\u0004\b4\u0010\u001AR\u0019\u0010\n\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u0010-\u001A\u0004\b5\u0010\u001AR\u001F\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006\u00A2\u0006\f\n\u0004\b\r\u00106\u001A\u0004\b7\u0010#\u00A8\u00068"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment$AlbumInfoParam;", "Landroid/os/Parcelable;", "", "albumName", "artistNames", "genreNames", "issueDate", "report", "albumType", "publisher", "agency", "", "Lcom/melon/ui/detail/holder/DetailHolderUiState$CreditItemUiState;", "creditList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment$AlbumInfoParam;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAlbumName", "getArtistNames", "getGenreNames", "getIssueDate", "getReport", "getAlbumType", "getPublisher", "getAgency", "Ljava/util/List;", "getCreditList", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AlbumInfoParam implements Parcelable {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class Creator implements Parcelable.Creator {
            public final AlbumInfoParam createFromParcel(Parcel parcel0) {
                q.g(parcel0, "parcel");
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                String s2 = parcel0.readString();
                String s3 = parcel0.readString();
                String s4 = parcel0.readString();
                String s5 = parcel0.readString();
                String s6 = parcel0.readString();
                String s7 = parcel0.readString();
                if(parcel0.readInt() == 0) {
                    return new AlbumInfoParam(s, s1, s2, s3, s4, s5, s6, s7, null);
                }
                int v = parcel0.readInt();
                ArrayList arrayList0 = new ArrayList(v);
                for(int v1 = 0; v1 != v; ++v1) {
                    arrayList0.add(DetailHolderUiState.CreditItemUiState.CREATOR.createFromParcel(parcel0));
                }
                return new AlbumInfoParam(s, s1, s2, s3, s4, s5, s6, s7, arrayList0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public final AlbumInfoParam[] newArray(int v) {
                return new AlbumInfoParam[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        }

        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator CREATOR;
        @Nullable
        private final String agency;
        @NotNull
        private final String albumName;
        @Nullable
        private final String albumType;
        @NotNull
        private final String artistNames;
        @Nullable
        private final List creditList;
        @Nullable
        private final String genreNames;
        @Nullable
        private final String issueDate;
        @Nullable
        private final String publisher;
        @Nullable
        private final String report;

        static {
            AlbumInfoParam.CREATOR = new Creator();
        }

        public AlbumInfoParam(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable List list0) {
            q.g(s, "albumName");
            q.g(s1, "artistNames");
            super();
            this.albumName = s;
            this.artistNames = s1;
            this.genreNames = s2;
            this.issueDate = s3;
            this.report = s4;
            this.albumType = s5;
            this.publisher = s6;
            this.agency = s7;
            this.creditList = list0;
        }

        @NotNull
        public final String component1() {
            return this.albumName;
        }

        @NotNull
        public final String component2() {
            return this.artistNames;
        }

        @Nullable
        public final String component3() {
            return this.genreNames;
        }

        @Nullable
        public final String component4() {
            return this.issueDate;
        }

        @Nullable
        public final String component5() {
            return this.report;
        }

        @Nullable
        public final String component6() {
            return this.albumType;
        }

        @Nullable
        public final String component7() {
            return this.publisher;
        }

        @Nullable
        public final String component8() {
            return this.agency;
        }

        @Nullable
        public final List component9() {
            return this.creditList;
        }

        @NotNull
        public final AlbumInfoParam copy(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable List list0) {
            q.g(s, "albumName");
            q.g(s1, "artistNames");
            return new AlbumInfoParam(s, s1, s2, s3, s4, s5, s6, s7, list0);
        }

        public static AlbumInfoParam copy$default(AlbumInfoParam detailContentsAlbumInfoFragment$AlbumInfoParam0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                s = detailContentsAlbumInfoFragment$AlbumInfoParam0.albumName;
            }
            if((v & 2) != 0) {
                s1 = detailContentsAlbumInfoFragment$AlbumInfoParam0.artistNames;
            }
            if((v & 4) != 0) {
                s2 = detailContentsAlbumInfoFragment$AlbumInfoParam0.genreNames;
            }
            if((v & 8) != 0) {
                s3 = detailContentsAlbumInfoFragment$AlbumInfoParam0.issueDate;
            }
            if((v & 16) != 0) {
                s4 = detailContentsAlbumInfoFragment$AlbumInfoParam0.report;
            }
            if((v & 0x20) != 0) {
                s5 = detailContentsAlbumInfoFragment$AlbumInfoParam0.albumType;
            }
            if((v & 0x40) != 0) {
                s6 = detailContentsAlbumInfoFragment$AlbumInfoParam0.publisher;
            }
            if((v & 0x80) != 0) {
                s7 = detailContentsAlbumInfoFragment$AlbumInfoParam0.agency;
            }
            if((v & 0x100) != 0) {
                list0 = detailContentsAlbumInfoFragment$AlbumInfoParam0.creditList;
            }
            return detailContentsAlbumInfoFragment$AlbumInfoParam0.copy(s, s1, s2, s3, s4, s5, s6, s7, list0);
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AlbumInfoParam)) {
                return false;
            }
            if(!q.b(this.albumName, ((AlbumInfoParam)object0).albumName)) {
                return false;
            }
            if(!q.b(this.artistNames, ((AlbumInfoParam)object0).artistNames)) {
                return false;
            }
            if(!q.b(this.genreNames, ((AlbumInfoParam)object0).genreNames)) {
                return false;
            }
            if(!q.b(this.issueDate, ((AlbumInfoParam)object0).issueDate)) {
                return false;
            }
            if(!q.b(this.report, ((AlbumInfoParam)object0).report)) {
                return false;
            }
            if(!q.b(this.albumType, ((AlbumInfoParam)object0).albumType)) {
                return false;
            }
            if(!q.b(this.publisher, ((AlbumInfoParam)object0).publisher)) {
                return false;
            }
            return q.b(this.agency, ((AlbumInfoParam)object0).agency) ? q.b(this.creditList, ((AlbumInfoParam)object0).creditList) : false;
        }

        @Nullable
        public final String getAgency() {
            return this.agency;
        }

        @NotNull
        public final String getAlbumName() {
            return this.albumName;
        }

        @Nullable
        public final String getAlbumType() {
            return this.albumType;
        }

        @NotNull
        public final String getArtistNames() {
            return this.artistNames;
        }

        @Nullable
        public final List getCreditList() {
            return this.creditList;
        }

        @Nullable
        public final String getGenreNames() {
            return this.genreNames;
        }

        @Nullable
        public final String getIssueDate() {
            return this.issueDate;
        }

        @Nullable
        public final String getPublisher() {
            return this.publisher;
        }

        @Nullable
        public final String getReport() {
            return this.report;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.albumName.hashCode() * 0x1F, 0x1F, this.artistNames);
            int v1 = 0;
            int v2 = this.genreNames == null ? 0 : this.genreNames.hashCode();
            int v3 = this.issueDate == null ? 0 : this.issueDate.hashCode();
            int v4 = this.report == null ? 0 : this.report.hashCode();
            int v5 = this.albumType == null ? 0 : this.albumType.hashCode();
            int v6 = this.publisher == null ? 0 : this.publisher.hashCode();
            int v7 = this.agency == null ? 0 : this.agency.hashCode();
            List list0 = this.creditList;
            if(list0 != null) {
                v1 = list0.hashCode();
            }
            return ((((((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v1;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("AlbumInfoParam(albumName=", this.albumName, ", artistNames=", this.artistNames, ", genreNames=");
            d.u(stringBuilder0, this.genreNames, ", issueDate=", this.issueDate, ", report=");
            d.u(stringBuilder0, this.report, ", albumType=", this.albumType, ", publisher=");
            d.u(stringBuilder0, this.publisher, ", agency=", this.agency, ", creditList=");
            return Y.m(stringBuilder0, this.creditList, ")");
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.albumName);
            parcel0.writeString(this.artistNames);
            parcel0.writeString(this.genreNames);
            parcel0.writeString(this.issueDate);
            parcel0.writeString(this.report);
            parcel0.writeString(this.albumType);
            parcel0.writeString(this.publisher);
            parcel0.writeString(this.agency);
            List list0 = this.creditList;
            if(list0 == null) {
                parcel0.writeInt(0);
                return;
            }
            parcel0.writeInt(1);
            parcel0.writeInt(list0.size());
            for(Object object0: list0) {
                ((DetailHolderUiState.CreditItemUiState)object0).writeToParcel(parcel0, v);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_ITEM", "newInstance", "Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment;", "param", "Lcom/iloen/melon/fragments/detail/DetailContentsAlbumInfoFragment$AlbumInfoParam;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsAlbumInfoFragment newInstance(@NotNull AlbumInfoParam detailContentsAlbumInfoFragment$AlbumInfoParam0) {
            q.g(detailContentsAlbumInfoFragment$AlbumInfoParam0, "param");
            DetailContentsAlbumInfoFragment detailContentsAlbumInfoFragment0 = new DetailContentsAlbumInfoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("argItem", detailContentsAlbumInfoFragment$AlbumInfoParam0);
            detailContentsAlbumInfoFragment0.setArguments(bundle0);
            return detailContentsAlbumInfoFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_ITEM = "argItem";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "DetailContentsAlbumInfoFragment";
    @Nullable
    private AlbumInfoParam albumInfoParam;
    @Nullable
    private F binding;
    @NotNull
    private final j titleBarEventHelper$delegate;

    static {
        DetailContentsAlbumInfoFragment.Companion = new Companion(null);
        DetailContentsAlbumInfoFragment.$stable = 8;
    }

    public DetailContentsAlbumInfoFragment() {
        this.titleBarEventHelper$delegate = g.Q(new i(23));
    }

    private final Ud.j getTitleBarEventHelper() {
        return (Ud.j)this.titleBarEventHelper$delegate.getValue();
    }

    private final void initUi() {
        F f0 = this.binding;
        if(f0 != null) {
            Ud.j j0 = this.getTitleBarEventHelper();
            b b0 = new b(this, 1);
            Ud.j.a(j0, f0.k, b0);
            o o0 = a.s(1);
            f0.k.a(o0);
            String s = this.getString(0x7F130055);  // string:album_detail_album_introduce "앨범 소개"
            f0.k.setTitle(s);
            f0.k.f(false);
        }
        F f1 = this.binding;
        if(f1 != null) {
            e e0 = new e(this, 1);
            f1.j.setOnScrollChangeListener(e0);
        }
        AlbumInfoParam detailContentsAlbumInfoFragment$AlbumInfoParam0 = this.albumInfoParam;
        if(detailContentsAlbumInfoFragment$AlbumInfoParam0 != null) {
            RelativeLayout relativeLayout0 = this.binding == null ? null : this.binding.d;
            MelonTextView melonTextView0 = this.binding == null ? null : this.binding.n;
            MelonTextView melonTextView1 = this.binding == null ? null : this.binding.p;
            if(detailContentsAlbumInfoFragment$AlbumInfoParam0.getAlbumName().length() > 0 && detailContentsAlbumInfoFragment$AlbumInfoParam0.getArtistNames().length() > 0) {
                if(relativeLayout0 != null) {
                    relativeLayout0.setVisibility(0);
                }
                if(melonTextView0 != null) {
                    melonTextView0.setText(detailContentsAlbumInfoFragment$AlbumInfoParam0.getAlbumName());
                }
                if(melonTextView1 != null) {
                    melonTextView1.setText(detailContentsAlbumInfoFragment$AlbumInfoParam0.getArtistNames());
                }
            }
            else if(relativeLayout0 != null) {
                relativeLayout0.setVisibility(8);
            }
            RelativeLayout relativeLayout1 = this.binding == null ? null : this.binding.c;
            MelonTextView melonTextView2 = this.binding == null ? null : this.binding.r;
            MelonTextView melonTextView3 = this.binding == null ? null : this.binding.q;
            MelonTextView melonTextView4 = this.binding == null ? null : this.binding.s;
            String s1 = detailContentsAlbumInfoFragment$AlbumInfoParam0.getGenreNames();
            if(s1 != null && s1.length() != 0) {
            label_40:
                if(relativeLayout1 != null) {
                    relativeLayout1.setVisibility(0);
                }
                if(melonTextView2 != null) {
                    melonTextView2.setText(detailContentsAlbumInfoFragment$AlbumInfoParam0.getGenreNames());
                }
                if(melonTextView3 != null) {
                    melonTextView3.setText(detailContentsAlbumInfoFragment$AlbumInfoParam0.getIssueDate());
                }
                if(melonTextView4 != null) {
                    melonTextView4.setText(detailContentsAlbumInfoFragment$AlbumInfoParam0.getReport());
                }
            }
            else {
                String s2 = detailContentsAlbumInfoFragment$AlbumInfoParam0.getReport();
                if(s2 == null || s2.length() != 0) {
                    goto label_40;
                }
                else if(relativeLayout1 != null) {
                    relativeLayout1.setVisibility(8);
                }
            }
            RelativeLayout relativeLayout2 = this.binding == null ? null : this.binding.h;
            LinearLayout linearLayout0 = this.binding == null ? null : this.binding.e;
            MelonTextView melonTextView5 = this.binding == null ? null : this.binding.o;
            LinearLayout linearLayout1 = this.binding == null ? null : this.binding.i;
            MelonTextView melonTextView6 = this.binding == null ? null : this.binding.t;
            LinearLayout linearLayout2 = this.binding == null ? null : this.binding.b;
            MelonTextView melonTextView7 = this.binding == null ? null : this.binding.m;
            String s3 = detailContentsAlbumInfoFragment$AlbumInfoParam0.getAlbumType();
            String s4 = detailContentsAlbumInfoFragment$AlbumInfoParam0.getPublisher();
            String s5 = detailContentsAlbumInfoFragment$AlbumInfoParam0.getAgency();
            if(s3 != null && s3.length() != 0 || s4 != null && s4.length() != 0 || s5 != null && s5.length() != 0) {
                if(relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
                if(linearLayout0 != null) {
                    linearLayout0.setVisibility((s3 == null || s3.length() == 0 ? 8 : 0));
                }
                if(melonTextView5 != null) {
                    melonTextView5.setText(s3);
                }
                if(linearLayout1 != null) {
                    linearLayout1.setVisibility((s4 == null || s4.length() == 0 ? 8 : 0));
                }
                if(melonTextView6 != null) {
                    melonTextView6.setText(s4);
                }
                if(linearLayout2 != null) {
                    linearLayout2.setVisibility((s5 == null || s5.length() == 0 ? 8 : 0));
                }
                if(melonTextView7 != null) {
                    melonTextView7.setText(s5);
                }
            }
            else if(relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            RelativeLayout relativeLayout3 = this.binding == null ? null : this.binding.f;
            LinearLayout linearLayout3 = this.binding == null ? null : this.binding.g;
            Collection collection0 = detailContentsAlbumInfoFragment$AlbumInfoParam0.getCreditList();
            if(collection0 != null && !collection0.isEmpty()) {
                for(Object object0: detailContentsAlbumInfoFragment$AlbumInfoParam0.getCreditList()) {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D01FA, null, false);  // layout:detail_album_info_credit_item
                    ((TextView)view0.findViewById(0x7F0A0CFE)).setText(((DetailHolderUiState.CreditItemUiState)object0).a);  // id:tv_role_name
                    ((TextView)view0.findViewById(0x7F0A0C54)).setText(((DetailHolderUiState.CreditItemUiState)object0).b);  // id:tv_credit_artist
                    if(linearLayout3 != null) {
                        linearLayout3.addView(view0);
                    }
                }
                return;
            }
            if(relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
        }
    }

    private static final H initUi$lambda$2$lambda$1(DetailContentsAlbumInfoFragment detailContentsAlbumInfoFragment0) {
        H0.e.w(detailContentsAlbumInfoFragment0);
        return H.a;
    }

    private static final void initUi$lambda$3(DetailContentsAlbumInfoFragment detailContentsAlbumInfoFragment0, NestedScrollView nestedScrollView0, int v, int v1, int v2, int v3) {
        if(v1 > 0) {
            F f0 = detailContentsAlbumInfoFragment0.binding;
            if(f0 != null) {
                TitleBar titleBar0 = f0.k;
                if(titleBar0 != null) {
                    titleBar0.f(true);
                }
            }
        }
        else {
            F f1 = detailContentsAlbumInfoFragment0.binding;
            if(f1 != null) {
                TitleBar titleBar1 = f1.k;
                if(titleBar1 != null) {
                    titleBar1.f(false);
                }
            }
        }
    }

    @Override  // com.melon.ui.c0
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            bundle0 = bundle1;
        }
        if(bundle0 != null) {
            this.albumInfoParam = (AlbumInfoParam)(((Parcelable)com.google.firebase.b.F(bundle0, "argItem", AlbumInfoParam.class)));
        }
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D01F7, viewGroup0, false);  // layout:detail_album_album_info_item
        int v = 0x7F0A007B;  // id:agency_container
        View view1 = I.C(view0, 0x7F0A007B);  // id:agency_container
        if(((LinearLayout)view1) != null && ((LinearLayout)I.C(view0, 0x7F0A0082)) != null && ((LinearLayout)I.C(view0, 0x7F0A0083)) != null) {  // id:album_date_container
            v = 0x7F0A0088;  // id:album_intro_container
            View view2 = I.C(view0, 0x7F0A0088);  // id:album_intro_container
            if(((RelativeLayout)view2) != null) {
                v = 0x7F0A008B;  // id:album_name_container
                View view3 = I.C(view0, 0x7F0A008B);  // id:album_name_container
                if(((RelativeLayout)view3) != null) {
                    v = 0x7F0A0090;  // id:album_type_container
                    View view4 = I.C(view0, 0x7F0A0090);  // id:album_type_container
                    if(((LinearLayout)view4) != null) {
                        v = 0x7F0A0361;  // id:credit_container
                        View view5 = I.C(view0, 0x7F0A0361);  // id:credit_container
                        if(((RelativeLayout)view5) != null) {
                            v = 0x7F0A0362;  // id:credit_item_container
                            View view6 = I.C(view0, 0x7F0A0362);  // id:credit_item_container
                            if(((LinearLayout)view6) != null) {
                                v = 0x7F0A0577;  // id:info_container
                                View view7 = I.C(view0, 0x7F0A0577);  // id:info_container
                                if(((RelativeLayout)view7) != null) {
                                    v = 0x7F0A098B;  // id:publisher_container
                                    View view8 = I.C(view0, 0x7F0A098B);  // id:publisher_container
                                    if(((LinearLayout)view8) != null) {
                                        v = 0x7F0A0A2F;  // id:scroll_view
                                        View view9 = I.C(view0, 0x7F0A0A2F);  // id:scroll_view
                                        if(((NestedScrollView)view9) != null && ((MelonTextView)I.C(view0, 0x7F0A0B90)) != null && (((MelonTextView)I.C(view0, 0x7F0A0B97)) != null && ((MelonTextView)I.C(view0, 0x7F0A0B98)) != null)) {  // id:title_album_intro
                                            v = 0x7F0A0BAD;  // id:titlebar
                                            View view10 = I.C(view0, 0x7F0A0BAD);  // id:titlebar
                                            if(((TitleBar)view10) != null) {
                                                v = 0x7F0A0BD4;  // id:top_space
                                                View view11 = I.C(view0, 0x7F0A0BD4);  // id:top_space
                                                if(view11 != null) {
                                                    v = 0x7F0A0C05;  // id:tv_agency
                                                    View view12 = I.C(view0, 0x7F0A0C05);  // id:tv_agency
                                                    if(((MelonTextView)view12) != null) {
                                                        v = 0x7F0A0C06;  // id:tv_album
                                                        View view13 = I.C(view0, 0x7F0A0C06);  // id:tv_album
                                                        if(((MelonTextView)view13) != null) {
                                                            v = 0x7F0A0C10;  // id:tv_album_type
                                                            View view14 = I.C(view0, 0x7F0A0C10);  // id:tv_album_type
                                                            if(((MelonTextView)view14) != null) {
                                                                v = 0x7F0A0C12;  // id:tv_artist
                                                                View view15 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                                                if(((MelonTextView)view15) != null) {
                                                                    v = 0x7F0A0C59;  // id:tv_date
                                                                    View view16 = I.C(view0, 0x7F0A0C59);  // id:tv_date
                                                                    if(((MelonTextView)view16) != null) {
                                                                        v = 0x7F0A0C83;  // id:tv_genre
                                                                        View view17 = I.C(view0, 0x7F0A0C83);  // id:tv_genre
                                                                        if(((MelonTextView)view17) != null) {
                                                                            v = 0x7F0A0C85;  // id:tv_genre_desc
                                                                            View view18 = I.C(view0, 0x7F0A0C85);  // id:tv_genre_desc
                                                                            if(((MelonTextView)view18) != null) {
                                                                                v = 0x7F0A0CF1;  // id:tv_publisher
                                                                                View view19 = I.C(view0, 0x7F0A0CF1);  // id:tv_publisher
                                                                                if(((MelonTextView)view19) != null) {
                                                                                    this.binding = new F(((RelativeLayout)view0), ((LinearLayout)view1), ((RelativeLayout)view2), ((RelativeLayout)view3), ((LinearLayout)view4), ((RelativeLayout)view5), ((LinearLayout)view6), ((RelativeLayout)view7), ((LinearLayout)view8), ((NestedScrollView)view9), ((TitleBar)view10), view11, ((MelonTextView)view12), ((MelonTextView)view13), ((MelonTextView)view14), ((MelonTextView)view15), ((MelonTextView)view16), ((MelonTextView)view17), ((MelonTextView)view18), ((MelonTextView)view19));
                                                                                    return (RelativeLayout)view0;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.c0
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override  // com.melon.ui.c0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initUi();
    }

    private static final Ud.j titleBarEventHelper_delegate$lambda$0() {
        return new Ud.j();
    }
}

