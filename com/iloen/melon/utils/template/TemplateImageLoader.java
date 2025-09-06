package com.iloen.melon.utils.template;

import Cb.i;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUArtist;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUBirth;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUDailyPick;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUDjPlaylist;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUEveryoneSongs;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUGenreRecm;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUHistory;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUHourMix;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUMixMaker;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUMonthSuperLike;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUMyReplay;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUNewSongs;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecentRecm;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForURecentRecmMix;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForURemind;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUStationRecm;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUUserTaste;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUWeather;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUWeeklyPick;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUWelcomePick;
import com.iloen.melon.fragments.main.foru.template.TemplateCoverForUYearSuperLike;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0013\b\u0007\u0018\u0000 #2\u00020\u0001:\u0003$%#B\u0013\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001F\u0010\u000E\u001A\u00020\r2\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u000E\u001A\u00020\r2\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u000E\u0010\u0010J\u001D\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u0017J\r\u0010\u0018\u001A\u00020\u000B¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u000B8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u0019R(\u0010\"\u001A\u0004\u0018\u00010\u00132\b\u0010\u001A\u001A\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateImageLoader;", "", "Lcom/iloen/melon/utils/template/TemplateCoverBase;", "templateCover", "<init>", "(Lcom/iloen/melon/utils/template/TemplateCoverBase;)V", "Lcom/iloen/melon/utils/template/TemplateData;", "templateData", "(Lcom/iloen/melon/utils/template/TemplateData;)V", "Lcom/iloen/melon/utils/template/TemplateImageLoader$CaptureStateListener;", "listener", "", "cacheEnable", "Lie/H;", "load", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$CaptureStateListener;Z)V", "(Lcom/iloen/melon/utils/template/TemplateImageLoader$CaptureStateListener;)V", "Landroid/view/View;", "view", "", "key", "captureWithCustomKey", "(Landroid/view/View;Ljava/lang/String;)Ljava/lang/String;", "()V", "isDefaultCover", "()Z", "value", "b", "Z", "isCachingSuccess", "e", "Ljava/lang/String;", "getTemplateCacheKey", "()Ljava/lang/String;", "templateCacheKey", "Companion", "DownloadStateListener", "CaptureStateListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateImageLoader {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateImageLoader$CaptureStateListener;", "", "Landroid/graphics/Bitmap;", "bitmap", "Lie/H;", "onCaptureComplete", "(Landroid/graphics/Bitmap;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface CaptureStateListener {
        void onCaptureComplete(@NotNull Bitmap arg1);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateImageLoader$Companion;", "", "", "TAG", "Ljava/lang/String;", "CACHE_URI_SCHEME", "", "MIX_COVER_DEBUG_ON", "Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Bitmap access$getCapturedDrawableFromView(Companion templateImageLoader$Companion0, View view0) {
            templateImageLoader$Companion0.getClass();
            if(view0 != null) {
                view0.measure(0, 0);
                view0.layout(0, 0, view0.getMeasuredWidth(), view0.getMeasuredHeight());
                Bitmap bitmap0 = Bitmap.createBitmap(view0.getMeasuredWidth(), view0.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                q.f(bitmap0, "createBitmap(...)");
                view0.draw(new Canvas(bitmap0));
                return bitmap0;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u0007\u0010\u000BJ+\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0007\u0010\u000E¨\u0006\u000FÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateImageLoader$DownloadStateListener;", "", "Landroid/view/View;", "vRoot", "", "enableCache", "Lie/H;", "onDownloadCompleted", "(Landroid/view/View;Z)V", "", "defaultShadowColor", "(Landroid/view/View;ZI)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/view/View;ZLandroid/graphics/drawable/Drawable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface DownloadStateListener {
        void onDownloadCompleted(@Nullable View arg1, boolean arg2);

        void onDownloadCompleted(@Nullable View arg1, boolean arg2, int arg3);

        void onDownloadCompleted(@Nullable View arg1, boolean arg2, @Nullable Drawable arg3);
    }

    public static final int $stable = 0;
    @NotNull
    public static final String CACHE_URI_SCHEME = "template://";
    @NotNull
    public static final Companion Companion;
    public static boolean MIX_COVER_DEBUG_ON;
    public boolean a;
    public boolean b;
    public final TemplateData c;
    public final TemplateCoverBase d;
    public String e;
    public int f;

    static {
        TemplateImageLoader.Companion = new Companion(null);
        TemplateImageLoader.$stable = 8;
    }

    public TemplateImageLoader(@Nullable TemplateCoverBase templateCoverBase0) {
        this.a = true;
        this.d = templateCoverBase0;
    }

    public TemplateImageLoader(@Nullable TemplateData templateData0) {
        this.a = true;
        if(templateData0 == null) {
            return;
        }
        this.c = templateData0;
        int v = 0;
        this.c(false);
        String s = templateData0.getShadowColor();
        if(!TextUtils.isEmpty(s)) {
            v = ColorUtils.getColorFromHexStr(s);
        }
        this.f = v;
        TemplateCoverInfo templateCoverInfo0 = templateData0.getTemplateCoverInfo();
        if("TYPE_FORU_REMIND".equals(templateCoverInfo0.getType())) {
            TemplateCoverForURemind templateCoverForURemind0 = new TemplateCoverForURemind(templateData0);
            templateCoverForURemind0.setDebugCoverName("리마인드 커버");
            this.d = templateCoverForURemind0;
            return;
        }
        if("TYPE_FORU_BIRTH".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUBirth templateCoverForUBirth0 = new TemplateCoverForUBirth(templateData0);
            templateCoverForUBirth0.setDebugCoverName("생일축하 커버");
            this.d = templateCoverForUBirth0;
            return;
        }
        if("TYPE_FORU_YEAR_SUPERLIKE".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUYearSuperLike templateCoverForUYearSuperLike0 = new TemplateCoverForUYearSuperLike(templateData0);
            templateCoverForUYearSuperLike0.setDebugCoverName("Year 슈퍼라이크 커버");
            this.d = templateCoverForUYearSuperLike0;
            return;
        }
        if("TYPE_FORU_MONTH_SUPERLIKE".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUMonthSuperLike templateCoverForUMonthSuperLike0 = new TemplateCoverForUMonthSuperLike(templateData0);
            templateCoverForUMonthSuperLike0.setDebugCoverName("Month 슈퍼라이크믹스 커버");
            this.d = templateCoverForUMonthSuperLike0;
            return;
        }
        if("TYPE_FORU_WEEKLY_PICK".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUWeeklyPick templateCoverForUWeeklyPick0 = new TemplateCoverForUWeeklyPick(templateData0);
            templateCoverForUWeeklyPick0.setDebugCoverName("위클리믹스 커버");
            this.d = templateCoverForUWeeklyPick0;
            return;
        }
        if("TYPE_FORU_DAILY_PICK".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUDailyPick templateCoverForUDailyPick0 = new TemplateCoverForUDailyPick(templateData0);
            templateCoverForUDailyPick0.setDebugCoverName("데일리믹스 커버");
            this.d = templateCoverForUDailyPick0;
            return;
        }
        if("TYPE_FORU_NEW_SONGS".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUNewSongs templateCoverForUNewSongs0 = new TemplateCoverForUNewSongs(templateData0);
            templateCoverForUNewSongs0.setDebugCoverName("뉴쏭\'s 커버");
            this.d = templateCoverForUNewSongs0;
            return;
        }
        if("TYPE_FORU_WELCOMEPICK".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUWelcomePick templateCoverForUWelcomePick0 = new TemplateCoverForUWelcomePick(templateData0);
            templateCoverForUWelcomePick0.setDebugCoverName("웰컴픽 커버");
            this.d = templateCoverForUWelcomePick0;
            return;
        }
        if("TYPE_FORU_ARTIST".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUArtist templateCoverForUArtist0 = new TemplateCoverForUArtist(templateData0);
            templateCoverForUArtist0.setDebugCoverName("아티스트믹스 커버");
            this.d = templateCoverForUArtist0;
            return;
        }
        if("TYPE_FORU_WEATHER".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUWeather templateCoverForUWeather0 = new TemplateCoverForUWeather(templateData0);
            templateCoverForUWeather0.setDebugCoverName("날씨믹스 커버");
            this.d = templateCoverForUWeather0;
            return;
        }
        if("TYPE_FORU_RECENT_RECM_MIX".equals(templateCoverInfo0.getType())) {
            TemplateCoverForURecentRecmMix templateCoverForURecentRecmMix0 = new TemplateCoverForURecentRecmMix(templateData0);
            templateCoverForURecentRecmMix0.setDebugCoverName("추천믹스 커버");
            this.d = templateCoverForURecentRecmMix0;
            return;
        }
        if("TYPE_FORU_RECENT_RECM".equals(templateCoverInfo0.getType())) {
            TemplateCoverForURecentRecm templateCoverForURecentRecm0 = new TemplateCoverForURecentRecm(templateData0);
            templateCoverForURecentRecm0.setDebugCoverName("추천컨텐츠(최근 들은) 커버");
            this.d = templateCoverForURecentRecm0;
            return;
        }
        if("TYPE_FORU_HOUR_MIX".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUHourMix templateCoverForUHourMix0 = new TemplateCoverForUHourMix(templateData0);
            templateCoverForUHourMix0.setDebugCoverName("N시믹스 커버");
            this.d = templateCoverForUHourMix0;
            return;
        }
        if("TYPE_FORU_GENRE_RECM".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUGenreRecm templateCoverForUGenreRecm0 = new TemplateCoverForUGenreRecm(templateData0);
            templateCoverForUGenreRecm0.setDebugCoverName("장르추천 커버");
            this.d = templateCoverForUGenreRecm0;
            return;
        }
        if("TYPE_FORU_STATION_RECM".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUStationRecm templateCoverForUStationRecm0 = new TemplateCoverForUStationRecm(templateData0);
            templateCoverForUStationRecm0.setDebugCoverName("스테이션추천 커버");
            this.d = templateCoverForUStationRecm0;
            return;
        }
        if("TYPE_FORU_DJ_PLAYLIST".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUDjPlaylist templateCoverForUDjPlaylist0 = new TemplateCoverForUDjPlaylist(templateData0);
            templateCoverForUDjPlaylist0.setDebugCoverName("DJ 플레이리스트 커버");
            this.d = templateCoverForUDjPlaylist0;
            return;
        }
        if("TYPE_FORU_MY_REPLAY".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUMyReplay templateCoverForUMyReplay0 = new TemplateCoverForUMyReplay(templateData0);
            templateCoverForUMyReplay0.setDebugCoverName("My Replay 커버");
            this.d = templateCoverForUMyReplay0;
            return;
        }
        if("TYPE_FORU_EVERYONE_SONG".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUEveryoneSongs templateCoverForUEveryoneSongs0 = new TemplateCoverForUEveryoneSongs(templateData0);
            templateCoverForUEveryoneSongs0.setDebugCoverName("모두의 명곡 커버");
            this.d = templateCoverForUEveryoneSongs0;
            return;
        }
        if("TYPE_FORU_USER_TASTE".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUUserTaste templateCoverForUUserTaste0 = new TemplateCoverForUUserTaste(templateData0);
            templateCoverForUUserTaste0.setDebugCoverName("취향의 재설정 커버");
            this.d = templateCoverForUUserTaste0;
            return;
        }
        if("TYPE_FORU_MIX_MAKER_PLAYLIST".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUMixMaker templateCoverForUMixMaker0 = new TemplateCoverForUMixMaker(templateData0);
            templateCoverForUMixMaker0.setDebugCoverName("믹스 메이커 플레이리스트 커버");
            this.d = templateCoverForUMixMaker0;
            return;
        }
        if("TYPE_FORU_HISTORY".equals(templateCoverInfo0.getType())) {
            TemplateCoverForUHistory templateCoverForUHistory0 = new TemplateCoverForUHistory(templateData0);
            templateCoverForUHistory0.setDebugCoverName("많이들은 음악 커버");
            this.d = templateCoverForUHistory0;
            return;
        }
        this.d = new TemplateCoverDefault(templateData0);
    }

    public final void a(CaptureStateListener templateImageLoader$CaptureStateListener0, Bitmap bitmap0) {
        String s;
        View view0 = null;
        TemplateCoverBase templateCoverBase0 = this.d;
        if(TemplateImageLoader.MIX_COVER_DEBUG_ON) {
            Canvas canvas0 = new Canvas(bitmap0);
            Paint paint0 = new Paint();
            paint0.setTextSize(20.0f);
            paint0.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            paint0.setColor(0xFFFF0000);
            paint0.setStyle(Paint.Style.FILL);
            float f = paint0.measureText("yY");
            if(templateCoverBase0 == null) {
                s = "";
            }
            else {
                s = templateCoverBase0.getDebugCoverName();
                if(s == null) {
                    s = "";
                }
            }
            canvas0.drawText(s, 20.0f, f + 20.0f, paint0);
            if(templateCoverBase0 != null) {
                ArrayList arrayList0 = templateCoverBase0.getBgColors();
                if(arrayList0 != null) {
                    StringBuilder stringBuilder0 = new StringBuilder("BG Color - ");
                    if(arrayList0.size() > 0) {
                        Iterator iterator0 = arrayList0.iterator();
                        q.f(iterator0, "iterator(...)");
                        while(iterator0.hasNext()) {
                            Object object0 = iterator0.next();
                            q.f(object0, "next(...)");
                            if(stringBuilder0.length() > 0) {
                                stringBuilder0.append(" : ");
                            }
                            stringBuilder0.append(((String)object0));
                        }
                    }
                    canvas0.drawText(stringBuilder0.toString(), 20.0f, f + 40.0f, paint0);
                    canvas0.drawText("Shadow Color - " + (this.c == null ? null : this.c.getShadowColor()), 20.0f, f + 60.0f, paint0);
                }
            }
        }
        if(templateImageLoader$CaptureStateListener0 != null) {
            templateImageLoader$CaptureStateListener0.onCaptureComplete(bitmap0);
        }
        if(templateCoverBase0 != null) {
            view0 = templateCoverBase0.getTargetCoverView();
        }
        if(view0 instanceof CoverView) {
            int v = this.f;
            if(v == 0) {
                ViewUtils.showWhen(((CoverView)view0).h, false);
                return;
            }
            ((CoverView)view0).setShadowColor(v);
        }
    }

    public static final void access$addBitmapCache(TemplateImageLoader templateImageLoader0, String s, Bitmap bitmap0) {
        templateImageLoader0.getClass();
        if(s == null || bitmap0 == null) {
            return;
        }
        TemplateImageCacheManager.addBitmapToMemoryCache(s, bitmap0);
    }

    public final void b(View view0, Bitmap bitmap0) {
        if(view0 instanceof CoverView) {
            ((CoverView)view0).setImageBitmap(bitmap0);
        }
        else if(view0 instanceof ImageView) {
            ((ImageView)view0).setImageBitmap(bitmap0);
        }
        if(view0 instanceof CoverView) {
            int v = this.f;
            if(v == 0) {
                ViewUtils.showWhen(((CoverView)view0).h, false);
                return;
            }
            ((CoverView)view0).setShadowColor(v);
        }
    }

    public final void c(boolean z) {
        CoverView coverView0 = null;
        View view0 = this.c == null ? null : this.c.getTargetView();
        if(view0 instanceof CoverView) {
            coverView0 = (CoverView)view0;
        }
        if(coverView0 != null) {
            coverView0.b(z);
        }
    }

    @NotNull
    public final String captureWithCustomKey(@NotNull View view0, @NotNull String s) {
        q.g(view0, "view");
        q.g(s, "key");
        String s1 = this.e + "_" + s;
        Bitmap bitmap0 = Companion.access$getCapturedDrawableFromView(TemplateImageLoader.Companion, view0);
        if(bitmap0 != null && s1 != null) {
            TemplateImageCacheManager.addBitmapToMemoryCache(s1, bitmap0);
        }
        return s1;
    }

    @Nullable
    public final String getTemplateCacheKey() {
        return this.e;
    }

    public final boolean isCachingSuccess() {
        return this.b;
    }

    public final boolean isDefaultCover() {
        return this.d instanceof TemplateCoverDefault;
    }

    public final void load() {
        TemplateCoverBase templateCoverBase0 = this.d;
        if(templateCoverBase0 != null) {
            Bitmap bitmap0 = TemplateImageCacheManager.getBitmapFromMemCache(this.e);
            if(this.a && bitmap0 != null && !bitmap0.isRecycled()) {
                LogU.Companion.d("TemplateImageLoader", "load() - templateCacheKey: " + this.e + ", cache is exist");
                this.c(true);
                this.b(templateCoverBase0.getTargetCoverView(), bitmap0);
                return;
            }
            LogU.Companion.d("TemplateImageLoader", "load() - templateCacheKey: " + this.e + ", cache is null");
            templateCoverBase0.load(new DownloadStateListener() {
                public final Bitmap a;
                public final TemplateImageLoader b;
                public final TemplateCoverBase c;

                {
                    Bitmap bitmap0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    TemplateImageLoader templateImageLoader0 = templateCoverBase0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.a = bitmap0;
                    this.b = templateImageLoader0;
                    this.c = templateCoverBase0;
                }

                @Override  // com.iloen.melon.utils.template.TemplateImageLoader$DownloadStateListener
                public void onDownloadCompleted(View view0, boolean z) {
                    Bitmap bitmap0 = Companion.access$getCapturedDrawableFromView(TemplateImageLoader.Companion, view0);
                    if(bitmap0 != null) {
                        TemplateImageLoader templateImageLoader0 = this.b;
                        if(i.l(this.a)) {
                            templateImageLoader0.c(true);
                        }
                        if(z) {
                            TemplateImageLoader.access$addBitmapCache(templateImageLoader0, templateImageLoader0.getTemplateCacheKey(), bitmap0);
                        }
                        templateImageLoader0.b(this.c.getTargetCoverView(), bitmap0);
                    }
                }

                @Override  // com.iloen.melon.utils.template.TemplateImageLoader$DownloadStateListener
                public void onDownloadCompleted(View view0, boolean z, int v) {
                    this.b.f = v;
                    this.onDownloadCompleted(view0, z);
                }

                @Override  // com.iloen.melon.utils.template.TemplateImageLoader$DownloadStateListener
                public void onDownloadCompleted(View view0, boolean z, Drawable drawable0) {
                    this.onDownloadCompleted(view0, z);
                    TemplateCoverBase templateCoverBase0 = this.c;
                    if(templateCoverBase0.getTargetCoverView() instanceof CoverView) {
                        ((CoverView)templateCoverBase0.getTargetCoverView()).getAnimationView().setImageDrawable(drawable0);
                    }
                }
            });
        }
    }

    public final void load(@Nullable CaptureStateListener templateImageLoader$CaptureStateListener0) {
        TemplateCoverBase templateCoverBase0 = this.d;
        if(templateCoverBase0 != null) {
            String s = "template://" + templateCoverBase0.getTemplateCacheKey();
            this.e = s;
            Bitmap bitmap0 = TemplateImageCacheManager.getBitmapFromMemCache(s);
            if(this.a && bitmap0 != null && !bitmap0.isRecycled()) {
                LogU.Companion.d("TemplateImageLoader", "load() - templateCacheKey: " + this.e + ", cache is exist");
                this.b = true;
                this.c(true);
                this.a(templateImageLoader$CaptureStateListener0, bitmap0);
                return;
            }
            LogU.Companion.d("TemplateImageLoader", "load() - templateCacheKey: " + this.e + ", cache is null");
            templateCoverBase0.load(new DownloadStateListener() {
                public final CaptureStateListener a;
                public final TemplateImageLoader b;

                {
                    CaptureStateListener templateImageLoader$CaptureStateListener0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.a = templateImageLoader$CaptureStateListener0;
                    this.b = templateImageLoader0;
                }

                @Override  // com.iloen.melon.utils.template.TemplateImageLoader$DownloadStateListener
                public void onDownloadCompleted(View view0, boolean z) {
                    CaptureStateListener templateImageLoader$CaptureStateListener0 = this.a;
                    if(templateImageLoader$CaptureStateListener0 != null) {
                        Bitmap bitmap0 = Companion.access$getCapturedDrawableFromView(TemplateImageLoader.Companion, view0);
                        if(bitmap0 != null) {
                            TemplateImageLoader templateImageLoader0 = this.b;
                            templateImageLoader0.c(true);
                            if(z) {
                                TemplateImageLoader.access$addBitmapCache(templateImageLoader0, templateImageLoader0.getTemplateCacheKey(), bitmap0);
                                templateImageLoader0.b = true;
                            }
                            templateImageLoader0.a(templateImageLoader$CaptureStateListener0, bitmap0);
                        }
                    }
                }

                @Override  // com.iloen.melon.utils.template.TemplateImageLoader$DownloadStateListener
                public void onDownloadCompleted(View view0, boolean z, int v) {
                    this.b.f = v;
                    this.onDownloadCompleted(view0, z);
                }

                @Override  // com.iloen.melon.utils.template.TemplateImageLoader$DownloadStateListener
                public void onDownloadCompleted(View view0, boolean z, Drawable drawable0) {
                    this.onDownloadCompleted(view0, z);
                }
            });
        }
    }

    public final void load(@Nullable CaptureStateListener templateImageLoader$CaptureStateListener0, boolean z) {
        this.a = z;
        this.load(templateImageLoader$CaptureStateListener0);
    }
}

