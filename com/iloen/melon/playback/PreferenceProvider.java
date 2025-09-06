package com.iloen.melon.playback;

import A7.d;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.preference.PlaylistPrefs;

public class PreferenceProvider extends ContentProvider {
    public static final String NOTIFY_UPDATE = "update";
    private static final int PREF_MELON = 200;
    private static final int PREF_PLAYLIST = 100;
    private static final String TAG = "PreferenceProvider";
    private static final UriMatcher sUriMatcher;

    static {
        UriMatcher uriMatcher0 = new UriMatcher(-1);
        PreferenceProvider.sUriMatcher = uriMatcher0;
        uriMatcher0.addURI("com.iloen.melon.preference.provider", "preferences_melon", 200);
        uriMatcher0.addURI("com.iloen.melon.preference.provider", "preferences_playlist", 100);
    }

    @Override  // android.content.ContentProvider
    public int delete(Uri uri0, String s, String[] arr_s) {
        LogU.v("PreferenceProvider", "delete() " + uri0);
        throw new UnsupportedOperationException("delete operation is not supported");
    }

    private String getPlaylistPrefFileValueForRemoteAccess(PlaylistPrefs playlistPrefs0, String s, String s1) {
        if("java.lang.String".equals(s)) {
            return playlistPrefs0.getString(s1, "");
        }
        if("java.lang.Integer".equals(s)) {
            return String.valueOf(playlistPrefs0.getInt(s1, -1));
        }
        if("java.lang.Long".equals(s)) {
            return String.valueOf(playlistPrefs0.getLong(s1, -1L));
        }
        if("java.lang.Float".equals(s)) {
            return String.valueOf(playlistPrefs0.getFloat(s1, -1.0f));
        }
        if("java.lang.Boolean".equals(s)) {
            return String.valueOf(playlistPrefs0.getBoolean(s1, false));
        }
        LogU.w("PreferenceProvider", "getPlaylistPrefFileValueForRemoteAccess() - Unsupported Primitive Type");
        return null;
    }

    @Override  // android.content.ContentProvider
    public String getType(Uri uri0) {
        switch(PreferenceProvider.sUriMatcher.match(uri0)) {
            case 100: {
                return "vnd.android.cursor.dir/vnd.com.iloen.melon.preference.provider/preferences_playlist";
            }
            case 200: {
                return "vnd.android.cursor.dir/vnd.com.iloen.melon.preference.provider/preferences_melon";
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
    }

    private String getValueForMelonPref(String s, String s1, String s2) {
        if("java.lang.String".equals(s)) {
            return MelonPrefs.getInstance().getString(s1, s2);
        }
        if("java.lang.Integer".equals(s)) {
            return String.valueOf(MelonPrefs.getInstance().getInt(s1, ProtocolUtils.parseInt(s2, -1)));
        }
        if("java.lang.Long".equals(s)) {
            return String.valueOf(MelonPrefs.getInstance().getLong(s1, ProtocolUtils.parseLong(s2, -1L)));
        }
        if("java.lang.Float".equals(s)) {
            return String.valueOf(MelonPrefs.getInstance().getFloat(s1, ProtocolUtils.parseFloat(s2, -1L)));
        }
        if("java.lang.Boolean".equals(s)) {
            return String.valueOf(MelonPrefs.getInstance().getBoolean(s1, ProtocolUtils.parseBoolean(s2)));
        }
        LogU.w("PreferenceProvider", "getValueForMelonPref() - Unsupported Primitive Type");
        return null;
    }

    @Override  // android.content.ContentProvider
    public Uri insert(Uri uri0, ContentValues contentValues0) {
        LogU.v("PreferenceProvider", "insert() " + uri0);
        throw new UnsupportedOperationException("insert operation is not supported");
    }

    @Override  // android.content.ContentProvider
    public boolean onCreate() {
        LogU.v("PreferenceProvider", "onCreate()");
        return true;
    }

    @Override  // android.content.ContentProvider
    public Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        UriMatcher uriMatcher0 = PreferenceProvider.sUriMatcher;
        if(-1 == uriMatcher0.match(uri0)) {
            return null;
        }
        Cursor cursor0 = new MatrixCursor(new String[]{"_id", "prim_type", "key", "value"});
        switch(uriMatcher0.match(uri0)) {
            case 100: {
                if(arr_s1 != null && arr_s1.length >= 2) {
                    int v1 = ProtocolUtils.parseInt(s, -1);
                    if(v1 < 0) {
                        return null;
                    }
                    LogU.v("PreferenceProvider", "query() PREF_PLAYLIST - playlistSeq: " + v1);
                    if(arr_s1.length % 2 == 1) {
                        LogU.v("PreferenceProvider", "Incompatibility Protocol");
                        return null;
                    }
                    PlaylistPrefs playlistPrefs0 = new PlaylistPrefs(MelonAppBase.instance.getContext(), v1);
                    for(int v = 0; v < arr_s1.length; v += 2) {
                        String s2 = arr_s1[v];
                        String s3 = arr_s1[v + 1];
                        try {
                            String s4 = this.getPlaylistPrefFileValueForRemoteAccess(playlistPrefs0, s2, s3);
                            LogU.v("PreferenceProvider", "query() PREF_PLAYLIST - primType: " + s2 + ", keyVal: " + s3 + ", retVal: " + s4);
                            ((MatrixCursor)cursor0).addRow(new Object[]{((int)(v / 2)), s2, s3, s4});
                        }
                        catch(Exception exception0) {
                            Z.v(exception0, a.n("PreferenceProvider query() >> keyVal: ", s3, " => Err: "), "PreferenceProvider");
                        }
                    }
                    return cursor0;
                }
                return null;
            }
            case 200: {
                if(arr_s1 != null && arr_s1.length >= 3) {
                    String s5 = arr_s1[0];
                    String s6 = arr_s1[1];
                    String s7 = arr_s1[2];
                    String s8 = this.getValueForMelonPref(s5, s6, s7);
                    StringBuilder stringBuilder0 = d.o("query() PREF_MELON - primType: ", s5, ", keyVal: ", s6, "defVal: ");
                    stringBuilder0.append(s7);
                    stringBuilder0.append(", retVal: ");
                    stringBuilder0.append(s8);
                    LogU.v("PreferenceProvider", stringBuilder0.toString());
                    if(TextUtils.isEmpty(s8)) {
                        return null;
                    }
                    ((MatrixCursor)cursor0).addRow(new Object[]{0, "java.lang.String", s6, s8});
                    return cursor0;
                }
                return null;
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
    }

    private void setValueForMelonPref(String s, String s1, String s2) {
        if("java.lang.String".equals(s)) {
            MelonPrefs.getInstance().setString(s1, s2);
            return;
        }
        if("java.lang.Integer".equals(s)) {
            MelonPrefs.getInstance().setInt(s1, ProtocolUtils.parseInt(s2, -1));
            return;
        }
        if("java.lang.Long".equals(s)) {
            MelonPrefs.getInstance().setLong(s1, ProtocolUtils.parseLong(s2, -1L));
            return;
        }
        if("java.lang.Float".equals(s)) {
            MelonPrefs.getInstance().setLong(s1, ProtocolUtils.parseLong(s2, -1L));
            return;
        }
        if("java.lang.Boolean".equals(s)) {
            MelonPrefs.getInstance().setBoolean(s1, ProtocolUtils.parseBoolean(s2));
            return;
        }
        LogU.w("PreferenceProvider", "setValueForMelonPref() - Unsupported Primitive Type");
    }

    private boolean setValueForPlaylistPref(PlaylistPrefs playlistPrefs0, String s, String s1, String s2) {
        if("java.lang.String".equals(s)) {
            playlistPrefs0.setString(s1, s2);
            return true;
        }
        if("java.lang.Integer".equals(s)) {
            playlistPrefs0.setInt(s1, ProtocolUtils.parseInt(s2, -1));
            return true;
        }
        if("java.lang.Long".equals(s)) {
            playlistPrefs0.setLong(s1, ProtocolUtils.parseLong(s2, -1L));
            return true;
        }
        if("java.lang.Float".equals(s)) {
            playlistPrefs0.setFloat(s1, ProtocolUtils.parseFloat(s2, -1L));
            return true;
        }
        if("java.lang.Boolean".equals(s)) {
            playlistPrefs0.setBoolean(s1, ProtocolUtils.parseBoolean(s2));
            return true;
        }
        LogU.w("PreferenceProvider", "setValueForPlaylistPref() - Unsupported Primitive Type");
        return true;
    }

    @Override  // android.content.ContentProvider
    public int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        LogU.v("PreferenceProvider", "update() " + uri0);
        int v = 0;
        String s1 = "update";
        switch(PreferenceProvider.sUriMatcher.match(uri0)) {
            case 100: {
                if(arr_s != null && arr_s.length >= 2) {
                    int v1 = ProtocolUtils.parseInt(s, -1);
                    if(v1 < 0) {
                        return 0;
                    }
                    if(arr_s.length % 3 > 0) {
                        LogU.w("PreferenceProvider", "Incompatibility Protocol");
                        return 0;
                    }
                    PlaylistPrefs playlistPrefs0 = new PlaylistPrefs(MelonAppBase.instance.getContext(), v1);
                    int v2 = 0;
                    while(v < arr_s.length) {
                        String s2 = arr_s[v];
                        String s3 = arr_s[v + 1];
                        String s4 = arr_s[v + 2];
                        try {
                            this.setValueForPlaylistPref(playlistPrefs0, s2, s3, s4);
                            ++v2;
                        }
                        catch(Exception exception0) {
                            Z.v(exception0, d.o("update() PREF_PLAYLIST >> key: ", s3, ", value: ", s4, " >> "), "PreferenceProvider");
                        }
                        v += 3;
                    }
                    if(v2 > 0) {
                        s1 = "update&playlistSeq=" + s;
                    }
                    else {
                        LogU.v("PreferenceProvider", "update() >> commit rows is 0");
                    }
                    v = v2;
                    goto label_39;
                }
                break;
            }
            case 200: {
                if(!TextUtils.isEmpty(s) && arr_s != null && arr_s.length >= 2) {
                    String s5 = arr_s[0];
                    String s6 = arr_s[1];
                    try {
                        this.setValueForMelonPref(s5, s, s6);
                        v = 1;
                    }
                    catch(Exception exception1) {
                        Z.v(exception1, new StringBuilder("update() PREF_MELON - Err: "), "PreferenceProvider");
                    }
                }
            label_39:
                if(v > 0) {
                    Uri uri1 = Uri.withAppendedPath(uri0, s1);
                    LogU.v("PreferenceProvider", "update() Success - notifyUri: " + uri1);
                    MelonAppBase.instance.getContext().getContentResolver().notifyChange(uri1, null);
                    return v;
                }
                LogU.w("PreferenceProvider", "update() Failed");
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
        return v;
    }
}

