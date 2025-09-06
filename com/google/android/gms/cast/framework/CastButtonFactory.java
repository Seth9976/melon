package com.google.android.gms.cast.framework;

import U1.a;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.view.ActionProvider;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.s;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import l4.G;

public final class CastButtonFactory {
    public static final int zza;
    private static final Logger zzb;
    private static final List zzc;
    private static final Object zzd;
    private static final List zze;
    private static final Object zzf;

    static {
        CastButtonFactory.zzb = new Logger("CastButtonFactory");
        CastButtonFactory.zzc = new ArrayList();
        CastButtonFactory.zzd = new Object();
        CastButtonFactory.zze = new ArrayList();
        CastButtonFactory.zzf = new Object();
    }

    public static MenuItem setUpMediaRouteButton(Context context0, Menu menu0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu0);
        MenuItem menuItem0 = menu0.findItem(v);
        if(menuItem0 == null) {
            throw new IllegalArgumentException("menu doesn\'t contain a menu item whose ID is " + v + ".");
        }
        try {
            CastButtonFactory.zzg(context0, menuItem0, null);
            synchronized(CastButtonFactory.zzd) {
                WeakReference weakReference0 = new WeakReference(menuItem0);
                CastButtonFactory.zzc.add(weakReference0);
            }
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new IllegalArgumentException("menu item with ID " + v + " doesn\'t have a MediaRouteActionProvider.", illegalArgumentException0);
        }
        zzp.zzd(zzpb.zzH);
        return menuItem0;
    }

    public static Task setUpMediaRouteButton(Context context0, Executor executor0, Menu menu0, int v) {
        Task task0;
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(menu0);
        MenuItem menuItem0 = menu0.findItem(v);
        if(menuItem0 == null) {
            return Tasks.forException(new IllegalArgumentException("menu doesn\'t contain a menu item whose ID is " + v + "."));
        }
        try {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaRouteActionProvider mediaRouteActionProvider0 = CastButtonFactory.zzf(menuItem0);
            if(mediaRouteActionProvider0 == null) {
                task0 = Tasks.forException(new IllegalArgumentException("cannot refreshButtonSelector with null mediaRouteActionProvider"));
            }
            else {
                TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
                CastContext.getSharedInstance(context0, executor0).addOnSuccessListener(new zze(mediaRouteActionProvider0, null, taskCompletionSource0, menuItem0)).addOnFailureListener(new zzf(taskCompletionSource0));
                task0 = taskCompletionSource0.getTask();
            }
            return task0.addOnSuccessListener(new zzc(null));
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            return Tasks.forException(new IllegalArgumentException("menu item with ID " + v + " doesn\'t have a MediaRouteActionProvider.", illegalArgumentException0));
        }
    }

    public static Task setUpMediaRouteButton(Context context0, Executor executor0, MediaRouteButton mediaRouteButton0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(mediaRouteButton0 != null) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            CastContext.getSharedInstance(context0, executor0).addOnSuccessListener(new zza(mediaRouteButton0, null, taskCompletionSource0)).addOnFailureListener(new zzb(taskCompletionSource0));
            return taskCompletionSource0.getTask().addOnSuccessListener(new zzd(mediaRouteButton0, null));
        }
        zzp.zzd(zzpb.zzH);
        return Tasks.forResult(null);
    }

    public static void setUpMediaRouteButton(Context context0, MediaRouteButton mediaRouteButton0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(mediaRouteButton0 != null) {
            CastButtonFactory.zzh(context0, mediaRouteButton0, null);
            synchronized(CastButtonFactory.zzf) {
                WeakReference weakReference0 = new WeakReference(mediaRouteButton0);
                CastButtonFactory.zze.add(weakReference0);
            }
        }
        zzp.zzd(zzpb.zzH);
    }

    public static void zza(MediaRouteActionProvider mediaRouteActionProvider0, s s0, TaskCompletionSource taskCompletionSource0, MenuItem menuItem0, CastContext castContext0) {
        CastButtonFactory.zzi(castContext0, mediaRouteActionProvider0, null);
        taskCompletionSource0.setResult(menuItem0);
    }

    public static void zzb(MediaRouteButton mediaRouteButton0, s s0, TaskCompletionSource taskCompletionSource0, CastContext castContext0) {
        CastButtonFactory.zzj(castContext0, mediaRouteButton0, null);
        taskCompletionSource0.setResult(null);
    }

    public static void zzc(s s0, MenuItem menuItem0) {
        synchronized(CastButtonFactory.zzd) {
            WeakReference weakReference0 = new WeakReference(menuItem0);
            CastButtonFactory.zzc.add(weakReference0);
        }
        zzp.zzd(zzpb.zzH);
    }

    public static void zzd(MediaRouteButton mediaRouteButton0, s s0, Void void0) {
        synchronized(CastButtonFactory.zzf) {
            WeakReference weakReference0 = new WeakReference(mediaRouteButton0);
            CastButtonFactory.zze.add(weakReference0);
        }
        zzp.zzd(zzpb.zzH);
    }

    public static void zze(Context context0) {
        synchronized(CastButtonFactory.zzd) {
            for(Object object1: CastButtonFactory.zzc) {
                MenuItem menuItem0 = (MenuItem)((WeakReference)object1).get();
                if(menuItem0 != null) {
                    try {
                        CastButtonFactory.zzg(context0, menuItem0, null);
                    }
                    catch(IllegalArgumentException illegalArgumentException0) {
                        CastButtonFactory.zzb.w("Unexpected exception when refreshing MediaRouteSelectors for Cast buttons", new Object[]{illegalArgumentException0});
                    }
                }
            }
        }
        synchronized(CastButtonFactory.zzf) {
            for(Object object3: CastButtonFactory.zze) {
                MediaRouteButton mediaRouteButton0 = (MediaRouteButton)((WeakReference)object3).get();
                if(mediaRouteButton0 != null) {
                    CastButtonFactory.zzh(context0, mediaRouteButton0, null);
                }
            }
        }
    }

    private static MediaRouteActionProvider zzf(MenuItem menuItem0) {
        if(menuItem0 instanceof a) {
            ActionProvider actionProvider0 = ((a)menuItem0).a();
            return ((MediaRouteActionProvider)actionProvider0) == null ? null : ((MediaRouteActionProvider)actionProvider0);
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    private static void zzg(Context context0, MenuItem menuItem0, s s0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaRouteActionProvider mediaRouteActionProvider0 = CastButtonFactory.zzf(menuItem0);
        if(mediaRouteActionProvider0 == null) {
            throw new IllegalArgumentException("cannot refreshButtonSelector with null mediaRouteActionProvider");
        }
        CastButtonFactory.zzi(CastContext.zzb(context0), mediaRouteActionProvider0, null);
    }

    private static void zzh(Context context0, MediaRouteButton mediaRouteButton0, s s0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastButtonFactory.zzj(CastContext.zzb(context0), mediaRouteButton0, null);
    }

    private static void zzi(CastContext castContext0, MediaRouteActionProvider mediaRouteActionProvider0, s s0) {
        if(castContext0 != null) {
            G g0 = castContext0.getMergedSelector();
            if(g0 != null && !mediaRouteActionProvider0.d.equals(g0)) {
                mediaRouteActionProvider0.d = g0;
                MediaRouteButton mediaRouteButton0 = mediaRouteActionProvider0.f;
                if(mediaRouteButton0 != null) {
                    mediaRouteButton0.setRouteSelector(g0);
                }
            }
        }
    }

    private static void zzj(CastContext castContext0, MediaRouteButton mediaRouteButton0, s s0) {
        if(castContext0 != null) {
            G g0 = castContext0.getMergedSelector();
            if(g0 != null) {
                mediaRouteButton0.setRouteSelector(g0);
            }
        }
    }
}

