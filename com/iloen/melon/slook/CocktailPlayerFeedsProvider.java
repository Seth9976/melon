package com.iloen.melon.slook;

import E9.w;
import Ma.m;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import com.bumptech.glide.Glide;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailManager;
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider;
import k8.o;
import kc.s2;
import kotlin.jvm.internal.q;
import ob.z;

public class CocktailPlayerFeedsProvider extends SlookCocktailProvider {
    public final CocktailPlayerKt a;
    public final s2 b;
    public final z c;
    public Uri d;
    public static Bitmap e;

    static {
    }

    public CocktailPlayerFeedsProvider() {
        this.a = new CocktailPlayerKt();
        Context context0 = MelonAppBase.instance.getContext();
        q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        this.b = (s2)((o)(((m)b.B(context1, m.class)))).w.get();
        Context context2 = MelonAppBase.instance.getContext();
        q.g(context2, "context");
        Context context3 = context2.getApplicationContext();
        q.d(context3);
        this.c = ((o)(((Ma.o)b.B(context3, Ma.o.class)))).k();
    }

    public final RemoteViews a(Context context0) {
        RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", 0x7F0D013C);  // layout:cocktail_player_view
        if(2 == SlookCompat.getInstance().getSupportedFeature(context0)) {
            remoteViews0.setInt(0x7F0A02D9, "setBackgroundResource", 0x7F060077);  // id:cocktail_container
            remoteViews0.setInt(0x7F0A02DA, "setBackgroundResource", 0x7F060078);  // id:cocktail_sub_container
        }
        else {
            remoteViews0.setInt(0x7F0A02D9, "setBackgroundResource", 0x7F060075);  // id:cocktail_container
            remoteViews0.setInt(0x7F0A02DA, "setBackgroundResource", 0x7F060076);  // id:cocktail_sub_container
        }
        PlayableData playableData0 = this.a.getCurrentPlayableDataOfRecentAudioPlaylist(this.b);
        z z0 = this.c;
        if(playableData0 != null) {
            boolean z1 = z0.n();
            int v = 8;
            remoteViews0.setViewVisibility(0x7F0A0B82, 8);  // id:thumbnail
            remoteViews0.setImageViewBitmap(0x7F0A0B82, CocktailPlayerFeedsProvider.e);  // id:thumbnail
            if(CocktailPlayerFeedsProvider.e != null) {
                v = 0;
            }
            remoteViews0.setViewVisibility(0x7F0A0B82, v);  // id:thumbnail
            Uri uri0 = playableData0.m;
            if(!ClassUtils.equals(uri0, this.d)) {
                this.d = uri0;
                CocktailPlayerFeedsProvider.e = null;
                Glide.with(context0).asBitmap().load(this.d).into(new CocktailPlayerFeedsProvider.1(this, uri0, context0));
            }
            remoteViews0.setTextViewText(0x7F0A0AB4, "재생 가능한 곡이 없습니다.");  // id:song_title
            remoteViews0.setImageViewResource(0x7F0A0189, (z1 ? 0x7F0807EC : 0x7F0807ED));  // id:btn_play_toggle
        }
        boolean z2 = z0.n();
        PendingIntent pendingIntent0 = PendingIntent.getActivity(context0, 0, CocktailPlayerFeedsProvider.b(context0, true), 0xC000000);
        remoteViews0.setOnClickPendingIntent(0x7F0A0B72, pendingIntent0);  // id:thumb_container
        remoteViews0.setOnClickPendingIntent(0x7F0A0AB5, pendingIntent0);  // id:song_title_container
        remoteViews0.setOnClickPendingIntent(0x7F0A0189, PendingIntent.getService(context0, 0, w.z(Actor.EdgeSingle), 0xC000000));  // id:btn_play_toggle
        remoteViews0.setOnClickPendingIntent(0x7F0A017F, PendingIntent.getService(context0, 0, w.y(Actor.EdgeSingle), 0xC000000));  // id:btn_next
        remoteViews0.setOnClickPendingIntent(0x7F0A07F3, PendingIntent.getActivity(context0, 0, CocktailPlayerFeedsProvider.b(context0, z2), 0xC000000));  // id:melon_icon
        remoteViews0.setViewVisibility(0x7F0A0198, 0);  // id:btn_prev
        remoteViews0.setOnClickPendingIntent(0x7F0A0198, PendingIntent.getService(context0, 0, w.A(Actor.EdgeSingle), 0xC000000));  // id:btn_prev
        return remoteViews0;
    }

    public static Intent b(Context context0, boolean z) {
        Intent intent0;
        Class class0 = MusicBrowserActivity.class;
        if(z) {
            intent0 = new Intent(context0, class0);
            intent0.setAction("com.iloen.melon.MELON_PLAYER_START");
            intent0.addFlags(0x10000000);
            intent0.putExtra("activitystartactionname", "player");
        }
        else {
            intent0 = new Intent(context0, class0);
            intent0.setAction("com.iloen.melon.intent.action.MAIN");
        }
        intent0.addCategory("android.intent.category.DEFAULT");
        intent0.putExtra("com.iloen.melon.intent.extra.actor", Actor.EdgeSingle);
        return intent0;
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider
    public void onReceive(Context context0, Intent intent0) {
        if(!SlookCompat.getInstance().isSupported(context0)) {
            return;
        }
        if(intent0 == null) {
            LogU.e("CocktailPlayerFeedsProvider", "onReceive() Intent instance is NULL!");
            return;
        }
        LogU.v("CocktailPlayerFeedsProvider", "onReceive() action : " + intent0.getStringExtra("com.iloen.melon.intent.action"));
        this.performUpdate(context0);
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider
    public void onUpdate(Context context0, SlookCocktailManager slookCocktailManager0, int[] arr_v) {
        if(SlookCompat.getInstance().isSupported(context0)) {
            RemoteViews remoteViews0 = this.a(context0);
            if(slookCocktailManager0 != null) {
                for(int v = 0; v < arr_v.length; ++v) {
                    int v1 = arr_v[v];
                    LogU.v("CocktailPlayerFeedsProvider", " - cocktailId : " + v1);
                    slookCocktailManager0.updateCocktail(v1, remoteViews0);
                }
            }
        }
    }

    public void performUpdate(Context context0) {
        try {
            SlookCocktailManager slookCocktailManager0 = SlookCocktailManager.getInstance(context0);
            int[] arr_v = slookCocktailManager0.getCocktailIds(new ComponentName("com.iloen.melon", this.getClass().getName()));
            for(int v = 0; v < arr_v.length; ++v) {
                int v1 = arr_v[v];
                LogU.v("CocktailPlayerFeedsProvider", "performUpdate() cocktailId : " + v1);
                slookCocktailManager0.updateCocktail(v1, this.a(context0));
            }
        }
        catch(Error | Exception unused_ex) {
        }
    }
}

