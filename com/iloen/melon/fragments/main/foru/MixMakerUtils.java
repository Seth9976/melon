package com.iloen.melon.fragments.main.foru;

import androidx.annotation.Keep;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.x;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000B¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000F\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0015\u001A\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/MixMakerUtils;", "", "<init>", "()V", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "tag", "Lie/H;", "addRecentSelectedTagHistory", "(Lcom/iloen/melon/fragments/main/foru/SelectedTag;)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRecentSelectedTagHistory", "()Ljava/util/ArrayList;", "", "RECENT_KEYWORD_SIZE_MAX", "I", "TAG", "Ljava/lang/String;", "Lcom/google/gson/n;", "kotlin.jvm.PlatformType", "json", "Lcom/google/gson/n;", "RecentSelectedTagHistory", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixMakerUtils {
    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0016\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000B\u001A\u00020\u00002\u0018\b\u0002\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0004HÖ\u0001R!\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/MixMakerUtils$RecentSelectedTagHistory;", "", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RecentSelectedTagHistory {
        public static final int $stable = 8;
        @NotNull
        private final ArrayList list;

        public RecentSelectedTagHistory(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "list");
            super();
            this.list = arrayList0;
        }

        @NotNull
        public final ArrayList component1() {
            return this.list;
        }

        @NotNull
        public final RecentSelectedTagHistory copy(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "list");
            return new RecentSelectedTagHistory(arrayList0);
        }

        public static RecentSelectedTagHistory copy$default(RecentSelectedTagHistory mixMakerUtils$RecentSelectedTagHistory0, ArrayList arrayList0, int v, Object object0) {
            if((v & 1) != 0) {
                arrayList0 = mixMakerUtils$RecentSelectedTagHistory0.list;
            }
            return mixMakerUtils$RecentSelectedTagHistory0.copy(arrayList0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof RecentSelectedTagHistory ? q.b(this.list, ((RecentSelectedTagHistory)object0).list) : false;
        }

        @NotNull
        public final ArrayList getList() {
            return this.list;
        }

        @Override
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "RecentSelectedTagHistory(list=" + this.list + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final MixMakerUtils INSTANCE = null;
    private static final int RECENT_KEYWORD_SIZE_MAX = 3;
    @NotNull
    private static final String TAG = "MixMakerUtils";
    private static final n json;

    static {
        MixMakerUtils.INSTANCE = new MixMakerUtils();
        MixMakerUtils.json = new o().a();
        MixMakerUtils.$stable = 8;
    }

    public final void addRecentSelectedTagHistory(@NotNull SelectedTag selectedTag0) {
        q.g(selectedTag0, "tag");
        String s = selectedTag0.getTagName();
        if(s == null) {
            return;
        }
        ArrayList arrayList0 = this.getRecentSelectedTagHistory();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(!q.b(((String)object0), s)) {
                arrayList1.add(object0);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList1);
        arrayList2.add(s);
        while(arrayList2.size() > 3) {
            arrayList2.remove(0);
        }
        RecentSelectedTagHistory mixMakerUtils$RecentSelectedTagHistory0 = new RecentSelectedTagHistory(arrayList2);
        MelonPrefs.getInstance().setString("mixMakerRecentSelectedTag", MixMakerUtils.json.l(mixMakerUtils$RecentSelectedTagHistory0, RecentSelectedTagHistory.class));
    }

    @NotNull
    public final ArrayList getRecentSelectedTagHistory() {
        String s = MelonPrefs.getInstance().getString("mixMakerRecentSelectedTag", "");
        try {
            RecentSelectedTagHistory mixMakerUtils$RecentSelectedTagHistory0 = (RecentSelectedTagHistory)MixMakerUtils.json.e(s, RecentSelectedTagHistory.class);
            return mixMakerUtils$RecentSelectedTagHistory0 == null ? new ArrayList() : mixMakerUtils$RecentSelectedTagHistory0.getList();
        }
        catch(x x0) {
        }
        LogU.Companion.d("MixMakerUtils", "getAddedKeywordHistory(), " + x0);
        return new ArrayList();
    }
}

