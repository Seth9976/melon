package com.iloen.melon.utils.ui;

import Tf.o;
import Tf.v;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.iloen.melon.custom.MelonTypefaceSpan;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList.Fields;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.types.TagInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.net.res.common.ArtistsInfoBase;
import d5.f;
import e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import je.p;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u00C7\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\b\u0010\u0006J#\u0010\u000B\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\nH\u0007\u00A2\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001A\u00020\u00162\u001A\u0010\u0015\u001A\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\nH\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00022\b\u0010\u0019\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001C\u001A\u00020\u00022\b\u0010\u0019\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001BJ7\u0010!\u001A\u00020\u00022\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u001E\u0010 \u001A\u001A\u0012\u0006\b\u0001\u0012\u00020\u001F\u0018\u00010\tj\f\u0012\u0006\b\u0001\u0012\u00020\u001F\u0018\u0001`\n\u00A2\u0006\u0004\b!\u0010\"J)\u0010%\u001A\u00020\u00022\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0010\u0010$\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0018\u00010#\u00A2\u0006\u0004\b%\u0010&J1\u0010%\u001A\u00020\u00022\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0010\u0010$\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0018\u00010#2\u0006\u0010\'\u001A\u00020\r\u00A2\u0006\u0004\b%\u0010(J+\u0010+\u001A\u0004\u0018\u00010\u00022\u001A\u0010*\u001A\u0016\u0012\u0004\u0012\u00020)\u0018\u00010\tj\n\u0012\u0004\u0012\u00020)\u0018\u0001`\n\u00A2\u0006\u0004\b+\u0010,J%\u0010\u0005\u001A\u00020\u00042\u0016\u0010*\u001A\u0012\u0012\u0004\u0012\u00020)0\tj\b\u0012\u0004\u0012\u00020)`\n\u00A2\u0006\u0004\b\u0005\u0010-J)\u0010/\u001A\u00020\u00042\u001A\u0010.\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\n\u00A2\u0006\u0004\b/\u0010-J\'\u00103\u001A\u0002022\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u00100\u001A\u00020\u00022\u0006\u00101\u001A\u00020\u0002\u00A2\u0006\u0004\b3\u00104J\u001F\u00105\u001A\u0002022\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u00100\u001A\u00020\u0002\u00A2\u0006\u0004\b5\u00106J\u001D\u00109\u001A\u00020\u00022\u0006\u00107\u001A\u00020\u00022\u0006\u00108\u001A\u00020\r\u00A2\u0006\u0004\b9\u0010:J1\u0010<\u001A\u00020\u00042\u001A\u0010\u0015\u001A\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\n2\u0006\u0010;\u001A\u00020\u0016\u00A2\u0006\u0004\b<\u0010=\u00A8\u0006>"}, d2 = {"Lcom/iloen/melon/utils/ui/MelonDetailInfoUtils;", "", "", "content", "Lie/H;", "saveDjPlaylistLatelyTags", "(Ljava/lang/String;)V", "delTagName", "removeDjPlaylistLatelyTag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "loadDjPlaylistLatelyTags", "()Ljava/util/ArrayList;", "", "color", "width", "height", "Landroid/graphics/Bitmap;", "createCircleBitmap", "(III)Landroid/graphics/Bitmap;", "Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response$RelationList;", "relList", "", "getUserActionLikeInfo", "(Ljava/util/ArrayList;)Z", "strNo", "getSongTrackNumberFormat", "(Ljava/lang/String;)Ljava/lang/String;", "getCdTrackNumberFormat", "Landroid/content/Context;", "context", "Lcom/melon/net/res/common/ArtistsInfoBase;", "list", "getNamesFormat", "(Landroid/content/Context;Ljava/util/ArrayList;)Ljava/lang/String;", "", "artistArray", "getArtistFormat", "(Landroid/content/Context;Ljava/util/List;)Ljava/lang/String;", "maxArtistLength", "(Landroid/content/Context;Ljava/util/List;I)Ljava/lang/String;", "Lcom/iloen/melon/types/TagInfo;", "tagInfoArray", "getTagArrayStringForServer", "(Ljava/util/ArrayList;)Ljava/lang/String;", "(Ljava/util/ArrayList;)V", "tagArray", "saveDjPlaylistLatelyTagsProc", "strSource", "strTarget", "Landroid/text/SpannableString;", "getMaaxRoundedString", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "changeBoldStringToColorString", "(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableString;", "nickname", "length", "shortenNickname", "(Ljava/lang/String;I)Ljava/lang/String;", "bLike", "setUserActionLikeInfo", "(Ljava/util/ArrayList;Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonDetailInfoUtils {
    public static final int $stable;
    @NotNull
    public static final MelonDetailInfoUtils INSTANCE;

    static {
        MelonDetailInfoUtils.INSTANCE = new MelonDetailInfoUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static String a(int v, List list0) {
        String s1;
        StringBuilder stringBuilder0 = new StringBuilder();
        int v1 = 0;
        while(v1 < v) {
            try {
                ArtistsInfoBase artistsInfoBase0 = (ArtistsInfoBase)list0.get(v1);
                if(artistsInfoBase0 != null) {
                    String s = artistsInfoBase0.getArtistName();
                    if(s != null && s.length() != 0) {
                        stringBuilder0.append(artistsInfoBase0.getArtistName());
                        stringBuilder0.append(", ");
                    }
                }
                ++v1;
                continue;
            }
            catch(IndexOutOfBoundsException unused_ex) {
            }
            break;
        }
        if(stringBuilder0.length() > 2) {
            s1 = stringBuilder0.substring(0, stringBuilder0.length() - 2);
            q.d(s1);
            return s1;
        }
        s1 = stringBuilder0.toString();
        q.d(s1);
        return s1;
    }

    @NotNull
    public final SpannableString changeBoldStringToColorString(@Nullable Context context0, @NotNull String s) {
        q.g(s, "strSource");
        if(o.v0(s, "<b>", false) && o.v0(s, "</b>", false)) {
            int v = o.F0(s, "<b>", 0, false, 6);
            int v1 = o.F0(s, "</b>", v + 3, false, 4);
            String s1 = s.substring(v, v1 + 4);
            q.f(s1, "substring(...)");
            String s2 = s.substring(v + 3, v1);
            q.f(s2, "substring(...)");
            Pattern pattern0 = Pattern.compile(s1);
            q.f(pattern0, "compile(...)");
            String s3 = pattern0.matcher(s).replaceFirst(s2);
            q.f(s3, "replaceFirst(...)");
            SpannableString spannableString0 = new SpannableString(s3);
            spannableString0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(context0, 0x7F06017C)), v, s2.length() + v, 33);  // color:green500s_support_high_contrast
            return spannableString0;
        }
        return new SpannableString(s);
    }

    @NotNull
    public static final Bitmap createCircleBitmap(int v, int v1, int v2) {
        Bitmap bitmap0 = Bitmap.createBitmap(v1, v2, Bitmap.Config.ARGB_8888);
        q.f(bitmap0, "createBitmap(...)");
        Canvas canvas0 = new Canvas(bitmap0);
        Paint paint0 = new Paint();
        Rect rect0 = new Rect(0, 0, v1, v2);
        paint0.setAntiAlias(true);
        canvas0.drawARGB(0, 0, 0, 0);
        paint0.setColor(v);
        paint0.setStyle(Paint.Style.FILL);
        float f = (float)(v1 / 2);
        canvas0.drawCircle(f, ((float)(v2 / 2)), f, paint0);
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas0.drawBitmap(bitmap0, rect0, rect0, paint0);
        return bitmap0;
    }

    @NotNull
    public final String getArtistFormat(@Nullable Context context0, @Nullable List list0) {
        return this.getArtistFormat(context0, list0, 1);
    }

    @NotNull
    public final String getArtistFormat(@Nullable Context context0, @Nullable List list0, int v) {
        if(context0 != null && list0 != null && !list0.isEmpty()) {
            if(list0.size() <= v) {
                return MelonDetailInfoUtils.a(v, list0);
            }
            String s = context0.getString(0x7F1307B5, new Object[]{MelonDetailInfoUtils.a(v, list0), ((int)(list0.size() - v))});  // string:number_of_except_one_format2 "%1$s 외 %2$d명"
            q.d(s);
            return s;
        }
        return "";
    }

    @NotNull
    public final String getCdTrackNumberFormat(@Nullable String s) {
        return s == null || s.length() == 0 ? "" : "CD" + s;
    }

    @NotNull
    public final SpannableString getMaaxRoundedString(@Nullable Context context0, @NotNull String s, @NotNull String s1) {
        q.g(s, "strSource");
        q.g(s1, "strTarget");
        int v = o.F0(s, s1, 0, false, 6);
        MelonTypefaceSpan melonTypefaceSpan0 = new MelonTypefaceSpan(f.G(context0));
        SpannableString spannableString0 = new SpannableString(s);
        spannableString0.setSpan(melonTypefaceSpan0, v, s1.length() + v, 33);
        return spannableString0;
    }

    @NotNull
    public final String getNamesFormat(@Nullable Context context0, @Nullable ArrayList arrayList0) {
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            if(arrayList0.size() == 1) {
                String s = ((ArtistsInfoBase)arrayList0.get(0)).getArtistName();
                return s == null ? "" : s;
            }
            return p.q0(arrayList0, ", ", null, null, new h(27), 30);
        }
        LogU.Companion.e("MelonDetailInfoUtils", "getStyleNames() invalid parameter");
        return "";
    }

    @NotNull
    public final String getSongTrackNumberFormat(@Nullable String s) {
        if(s != null && s.length() != 0) {
            return s.length() == 1 ? "0" + s : s;
        }
        return "";
    }

    @Nullable
    public final String getTagArrayStringForServer(@Nullable ArrayList arrayList0) {
        if(arrayList0 != null && arrayList0.size() >= 1) {
            StringBuilder stringBuilder0 = new StringBuilder();
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                stringBuilder0.append(((TagInfo)object0).a);
                stringBuilder0.append(",");
            }
            return stringBuilder0.length() >= 1 ? l1.q(stringBuilder0, 1, 0) : null;
        }
        return null;
    }

    public static final boolean getUserActionLikeInfo(@Nullable ArrayList arrayList0) {
        if(arrayList0 != null) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                Fields userActionsRes$Response$RelationList$Fields0 = ((RelationList)object0).fields;
                if(userActionsRes$Response$RelationList$Fields0 != null) {
                    Y.w("getUserActionLikeInfo() >> like: ", userActionsRes$Response$RelationList$Fields0.like, LogU.Companion, "MelonDetailInfoUtils");
                    return ProtocolUtils.parseBoolean(userActionsRes$Response$RelationList$Fields0.like);
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    @Nullable
    public static final ArrayList loadDjPlaylistLatelyTags() {
        List list1;
        List list0;
        String s = MelonPrefs.getInstance().getString("DJ_PLAYLIST_RECOMMEND_TAG_LIST", null);
        if(s != null && s.length() != 0) {
            Pattern pattern0 = Pattern.compile(",");
            q.f(pattern0, "compile(...)");
            o.P0(0);
            Matcher matcher0 = pattern0.matcher(s);
            if(matcher0.find()) {
                ArrayList arrayList0 = new ArrayList(10);
                int v1 = 0;
                do {
                    v1 = androidx.appcompat.app.o.c(matcher0, s, v1, arrayList0);
                }
                while(matcher0.find());
                androidx.appcompat.app.o.w(v1, s, arrayList0);
                list0 = arrayList0;
            }
            else {
                list0 = k.z(s.toString());
            }
            if(!list0.isEmpty()) {
                ListIterator listIterator0 = list0.listIterator(list0.size());
                while(listIterator0.hasPrevious()) {
                    if(((String)listIterator0.previous()).length() == 0) {
                        continue;
                    }
                    list1 = p.K0(listIterator0.nextIndex() + 1, list0);
                    goto label_23;
                }
            }
            list1 = w.a;
        label_23:
            String[] arr_s = (String[])list1.toArray(new String[0]);
            ArrayList arrayList1 = new ArrayList();
            for(int v = 0; v < arr_s.length; ++v) {
                arrayList1.add(arr_s[v]);
            }
            return arrayList1;
        }
        return null;
    }

    public static final void removeDjPlaylistLatelyTag(@NotNull String s) {
        String s1;
        q.g(s, "delTagName");
        ArrayList arrayList0 = MelonDetailInfoUtils.loadDjPlaylistLatelyTags();
        q.d(arrayList0);
        Iterator iterator0 = arrayList0.iterator();
        q.f(iterator0, "iterator(...)");
        for(int v = 0; iterator0.hasNext(); ++v) {
            Object object0 = iterator0.next();
            q.f(object0, "next(...)");
            if(s.equals(((String)object0))) {
                arrayList0.remove(v);
                break;
            }
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        Iterator iterator1 = arrayList0.iterator();
        q.f(iterator1, "iterator(...)");
        while(iterator1.hasNext()) {
            Object object1 = iterator1.next();
            q.f(object1, "next(...)");
            stringBuilder0.append(((String)object1));
            stringBuilder0.append(",");
        }
        if(stringBuilder0.length() > 0) {
            s1 = stringBuilder0.substring(0, stringBuilder0.length() - 1);
            q.f(s1, "substring(...)");
        }
        else {
            s1 = "";
        }
        LogU.Companion.i("MelonDetailInfoUtils", "removeDjPlaylistLatelyTag() >> tags: " + s1);
        MelonPrefs.getInstance().setString("DJ_PLAYLIST_RECOMMEND_TAG_LIST", s1);
    }

    public static final void saveDjPlaylistLatelyTags(@NotNull String s) {
        List list1;
        List list0;
        q.g(s, "content");
        Pattern pattern0 = Pattern.compile("\n");
        q.f(pattern0, "compile(...)");
        String s1 = pattern0.matcher(s).replaceAll(" ");
        q.f(s1, "replaceAll(...)");
        Pattern pattern1 = Pattern.compile(" ");
        q.f(pattern1, "compile(...)");
        o.P0(0);
        Matcher matcher0 = pattern1.matcher(s1);
        if(matcher0.find()) {
            ArrayList arrayList0 = new ArrayList(10);
            int v = 0;
            do {
                v = androidx.appcompat.app.o.c(matcher0, s1, v, arrayList0);
            }
            while(matcher0.find());
            androidx.appcompat.app.o.w(v, s1, arrayList0);
            list0 = arrayList0;
        }
        else {
            list0 = k.z(s1.toString());
        }
        if(!list0.isEmpty()) {
            ListIterator listIterator0 = list0.listIterator(list0.size());
            while(listIterator0.hasPrevious()) {
                if(((String)listIterator0.previous()).length() == 0) {
                    continue;
                }
                list1 = p.K0(listIterator0.nextIndex() + 1, list0);
                goto label_25;
            }
        }
        list1 = w.a;
    label_25:
        String[] arr_s = (String[])list1.toArray(new String[0]);
        if(arr_s != null && arr_s.length > 0) {
            ArrayList arrayList1 = new ArrayList();
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                String s2 = arr_s[v1];
                if(v.r0(s2, "#", false) && s2.length() > 1) {
                    arrayList1.add(s2);
                }
            }
            MelonDetailInfoUtils.INSTANCE.saveDjPlaylistLatelyTagsProc(arrayList1);
        }
    }

    public final void saveDjPlaylistLatelyTags(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "tagInfoArray");
        ArrayList arrayList1 = new ArrayList();
        Iterator iterator0 = arrayList0.iterator();
        q.f(iterator0, "iterator(...)");
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            q.f(object0, "next(...)");
            arrayList1.add(((TagInfo)object0).a);
        }
        this.saveDjPlaylistLatelyTagsProc(arrayList1);
    }

    public final void saveDjPlaylistLatelyTagsProc(@Nullable ArrayList arrayList0) {
        List list1;
        List list0;
        if(arrayList0 != null && arrayList0.size() >= 1) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                String s = (String)object0;
                if(s.length() > 0) {
                    linkedHashMap0.put(s, s);
                }
            }
            String s1 = MelonPrefs.getInstance().getString("DJ_PLAYLIST_RECOMMEND_TAG_LIST", null);
            if(s1 != null && s1.length() != 0) {
                Pattern pattern0 = Pattern.compile(",");
                q.f(pattern0, "compile(...)");
                o.P0(0);
                Matcher matcher0 = pattern0.matcher(s1);
                if(matcher0.find()) {
                    ArrayList arrayList1 = new ArrayList(10);
                    int v = 0;
                    do {
                        v = androidx.appcompat.app.o.c(matcher0, s1, v, arrayList1);
                    }
                    while(matcher0.find());
                    androidx.appcompat.app.o.w(v, s1, arrayList1);
                    list0 = arrayList1;
                }
                else {
                    list0 = k.z(s1.toString());
                }
                if(!list0.isEmpty()) {
                    ListIterator listIterator0 = list0.listIterator(list0.size());
                    while(listIterator0.hasPrevious()) {
                        if(((String)listIterator0.previous()).length() == 0) {
                            continue;
                        }
                        list1 = p.K0(listIterator0.nextIndex() + 1, list0);
                        goto label_33;
                    }
                }
                list1 = w.a;
            label_33:
                String[] arr_s = (String[])list1.toArray(new String[0]);
                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                    String s2 = arr_s[v1];
                    if(linkedHashMap0.size() >= 10) {
                        break;
                    }
                    if(linkedHashMap0.get(s2) == null) {
                        linkedHashMap0.put(s2, s2);
                    }
                }
            }
            Set set0 = linkedHashMap0.keySet();
            q.f(set0, "<get-keys>(...)");
            Iterator iterator1 = set0.iterator();
            StringBuilder stringBuilder0 = new StringBuilder();
            while(iterator1.hasNext()) {
                Object object1 = iterator1.next();
                stringBuilder0.append(((String)object1));
                stringBuilder0.append(",");
            }
            if(stringBuilder0.length() > 0) {
                String s3 = l1.q(stringBuilder0, 1, 0);
                LogU.Companion.i("MelonDetailInfoUtils", "saveDjPlaylistLatelyTags() >> tags: " + s3);
                MelonPrefs.getInstance().setString("DJ_PLAYLIST_RECOMMEND_TAG_LIST", s3);
            }
        }
    }

    public final void setUserActionLikeInfo(@Nullable ArrayList arrayList0, boolean z) {
        if(arrayList0 != null) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                Fields userActionsRes$Response$RelationList$Fields0 = ((RelationList)object0).fields;
                if(userActionsRes$Response$RelationList$Fields0 != null) {
                    userActionsRes$Response$RelationList$Fields0.like = z ? "Y" : "N";
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
    }

    @NotNull
    public final String shortenNickname(@NotNull String s, int v) {
        q.g(s, "nickname");
        if(s.length() == 0) {
            return s;
        }
        if(v >= s.length()) {
            return s;
        }
        String s1 = s.substring(0, v);
        q.f(s1, "substring(...)");
        return s1 + "...";
    }
}

