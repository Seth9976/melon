package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost.TabSpec;
import android.widget.TabHost;
import androidx.fragment.app.w;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack.Builder;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.cast.framework.R.layout;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class TracksChooserDialogFragment extends w {
    boolean zza;
    List zzb;
    List zzc;
    private long[] zzd;
    private Dialog zze;
    private RemoteMediaClient zzf;
    private MediaInfo zzg;
    private long[] zzh;

    @Deprecated
    public TracksChooserDialogFragment() {
    }

    private TracksChooserDialogFragment(MediaInfo mediaInfo0, long[] arr_v) {
        this.zzg = mediaInfo0;
        this.zzh = arr_v;
    }

    public static TracksChooserDialogFragment newInstance() {
        return new TracksChooserDialogFragment();
    }

    @Deprecated
    public static TracksChooserDialogFragment newInstance(MediaInfo mediaInfo0, long[] arr_v) {
        return new TracksChooserDialogFragment(mediaInfo0, arr_v);
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.zza = true;
        this.zzc = new ArrayList();
        this.zzb = new ArrayList();
        this.zzd = new long[0];
        CastSession castSession0 = CastContext.getSharedInstance(this.getContext()).getSessionManager().getCurrentCastSession();
        if(castSession0 != null && castSession0.isConnected()) {
            RemoteMediaClient remoteMediaClient0 = castSession0.getRemoteMediaClient();
            this.zzf = remoteMediaClient0;
            if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && this.zzf.getMediaInfo() != null) {
                RemoteMediaClient remoteMediaClient1 = this.zzf;
                long[] arr_v = this.zzh;
                if(arr_v == null) {
                    MediaStatus mediaStatus0 = remoteMediaClient1.getMediaStatus();
                    if(mediaStatus0 != null) {
                        this.zzd = mediaStatus0.getActiveTrackIds();
                    }
                }
                else {
                    this.zzd = arr_v;
                }
                MediaInfo mediaInfo0 = this.zzg == null ? remoteMediaClient1.getMediaInfo() : this.zzg;
                if(mediaInfo0 == null) {
                    this.zza = false;
                    return;
                }
                List list0 = mediaInfo0.getMediaTracks();
                if(list0 == null) {
                    this.zza = false;
                    return;
                }
                this.zzc = TracksChooserDialogFragment.zze(list0, 2);
                ArrayList arrayList0 = TracksChooserDialogFragment.zze(list0, 1);
                this.zzb = arrayList0;
                if(!arrayList0.isEmpty()) {
                    List list1 = this.zzb;
                    Builder mediaTrack$Builder0 = new Builder(-1L, 1);
                    mediaTrack$Builder0.setName(String.format(Locale.ROOT, this.getActivity().getString(string.cast_tracks_chooser_dialog_none)));
                    mediaTrack$Builder0.setSubtype(2);
                    mediaTrack$Builder0.setContentId("");
                    list1.add(0, mediaTrack$Builder0.build());
                }
                return;
            }
        }
        this.zza = false;
    }

    @Override  // androidx.fragment.app.w
    public Dialog onCreateDialog(Bundle bundle0) {
        int v = TracksChooserDialogFragment.zzd(this.zzb, this.zzd, 0);
        int v1 = TracksChooserDialogFragment.zzd(this.zzc, this.zzd, -1);
        zzbq zzbq0 = new zzbq(this.getActivity(), this.zzb, v);
        zzbq zzbq1 = new zzbq(this.getActivity(), this.zzc, v1);
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this.getActivity());
        View view0 = this.getActivity().getLayoutInflater().inflate(layout.cast_tracks_chooser_dialog_layout, null);
        ListView listView0 = (ListView)view0.findViewById(id.text_list_view);
        ListView listView1 = (ListView)view0.findViewById(id.audio_list_view);
        TabHost tabHost0 = (TabHost)view0.findViewById(id.tab_host);
        tabHost0.setup();
        if(zzbq0.getCount() == 0) {
            listView0.setVisibility(4);
        }
        else {
            listView0.setAdapter(zzbq0);
            TabHost.TabSpec tabHost$TabSpec0 = tabHost0.newTabSpec("textTab");
            tabHost$TabSpec0.setContent(0x7F0A0B5A);  // id:text_list_view
            tabHost$TabSpec0.setIndicator(String.format(Locale.ROOT, this.getActivity().getString(string.cast_tracks_chooser_dialog_subtitles)));
            tabHost0.addTab(tabHost$TabSpec0);
        }
        if(zzbq1.getCount() <= 1) {
            listView1.setVisibility(4);
        }
        else {
            listView1.setAdapter(zzbq1);
            TabHost.TabSpec tabHost$TabSpec1 = tabHost0.newTabSpec("audioTab");
            tabHost$TabSpec1.setContent(0x7F0A00D2);  // id:audio_list_view
            tabHost$TabSpec1.setIndicator(String.format(Locale.ROOT, this.getActivity().getString(string.cast_tracks_chooser_dialog_audio)));
            tabHost0.addTab(tabHost$TabSpec1);
        }
        AlertDialog.Builder alertDialog$Builder1 = alertDialog$Builder0.setView(view0);
        Locale locale0 = Locale.ROOT;
        alertDialog$Builder1.setPositiveButton(String.format(locale0, this.getActivity().getString(string.cast_tracks_chooser_dialog_ok)), new zzbn(this, zzbq0, zzbq1)).setNegativeButton(String.format(locale0, this.getActivity().getString(string.cast_tracks_chooser_dialog_cancel)), new zzbm(this));
        Dialog dialog0 = this.zze;
        if(dialog0 != null) {
            dialog0.cancel();
            this.zze = null;
        }
        Dialog dialog1 = alertDialog$Builder0.create();
        this.zze = dialog1;
        return dialog1;
    }

    @Override  // androidx.fragment.app.w
    public void onDestroyView() {
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null && this.getRetainInstance()) {
            dialog0.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public static void zzb(TracksChooserDialogFragment tracksChooserDialogFragment0, Dialog dialog0) {
        tracksChooserDialogFragment0.zze = null;
    }

    public static void zzc(TracksChooserDialogFragment tracksChooserDialogFragment0, zzbq zzbq0, zzbq zzbq1) {
        if(!tracksChooserDialogFragment0.zza) {
            tracksChooserDialogFragment0.zzf();
            return;
        }
        RemoteMediaClient remoteMediaClient0 = (RemoteMediaClient)Preconditions.checkNotNull(tracksChooserDialogFragment0.zzf);
        if(!remoteMediaClient0.hasMediaSession()) {
            tracksChooserDialogFragment0.zzf();
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        MediaTrack mediaTrack0 = zzbq0.zza();
        if(mediaTrack0 != null && mediaTrack0.getId() != -1L) {
            arrayList0.add(mediaTrack0.getId());
        }
        MediaTrack mediaTrack1 = zzbq1.zza();
        if(mediaTrack1 != null) {
            arrayList0.add(mediaTrack1.getId());
        }
        long[] arr_v = tracksChooserDialogFragment0.zzd;
        if(arr_v != null && arr_v.length > 0) {
            HashSet hashSet0 = new HashSet();
            for(Object object0: tracksChooserDialogFragment0.zzc) {
                hashSet0.add(((MediaTrack)object0).getId());
            }
            for(Object object1: tracksChooserDialogFragment0.zzb) {
                hashSet0.add(((MediaTrack)object1).getId());
            }
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                Long long0 = (long)arr_v[v1];
                if(!hashSet0.contains(long0)) {
                    arrayList0.add(long0);
                }
            }
        }
        long[] arr_v1 = new long[arrayList0.size()];
        for(int v = 0; v < arrayList0.size(); ++v) {
            arr_v1[v] = (long)(((Long)arrayList0.get(v)));
        }
        Arrays.sort(arr_v1);
        remoteMediaClient0.setActiveMediaTracks(arr_v1);
        tracksChooserDialogFragment0.zzf();
    }

    private static int zzd(List list0, long[] arr_v, int v) {
        if(arr_v != null && list0 != null) {
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                for(int v2 = 0; v2 < arr_v.length; ++v2) {
                    if(arr_v[v2] == ((MediaTrack)list0.get(v1)).getId()) {
                        return v1;
                    }
                }
            }
        }
        return v;
    }

    private static ArrayList zze(List list0, int v) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            MediaTrack mediaTrack0 = (MediaTrack)object0;
            if(mediaTrack0.getType() == v) {
                arrayList0.add(mediaTrack0);
            }
        }
        return arrayList0;
    }

    private final void zzf() {
        Dialog dialog0 = this.zze;
        if(dialog0 != null) {
            dialog0.cancel();
            this.zze = null;
        }
    }
}

