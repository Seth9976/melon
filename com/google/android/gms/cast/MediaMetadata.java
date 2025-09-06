package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.appcompat.app.o;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.zza;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "MediaMetadataCreator")
@Reserved({1})
public class MediaMetadata extends AbstractSafeParcelable {
    @KeepForSdk
    public class Writer {
        final MediaMetadata zza;

        @KeepForSdk
        public Object getRawValue(String s) {
            return MediaMetadata.this.zza.get(s);
        }

        @KeepForSdk
        public void remove(String s) {
            MediaMetadata.this.zza.remove(s);
        }

        @KeepForSdk
        public void setMediaType(int v) {
            MediaMetadata.this.zze = v;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BOOK_TITLE = "com.google.android.gms.cast.metadata.BOOK_TITLE";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_CHAPTER_NUMBER = "com.google.android.gms.cast.metadata.CHAPTER_NUMBER";
    public static final String KEY_CHAPTER_TITLE = "com.google.android.gms.cast.metadata.CHAPTER_TITLE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_QUEUE_ITEM_ID = "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SECTION_DURATION = "com.google.android.gms.cast.metadata.SECTION_DURATION";
    public static final String KEY_SECTION_START_ABSOLUTE_TIME = "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME";
    public static final String KEY_SECTION_START_TIME_IN_CONTAINER = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER";
    public static final String KEY_SECTION_START_TIME_IN_MEDIA = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_AUDIOBOOK_CHAPTER = 5;
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    @Field(id = 3)
    final Bundle zza;
    private static final String[] zzb;
    private static final zzcb zzc;
    @Field(getter = "getImages", id = 2)
    private final List zzd;
    @Field(getter = "getMediaType", id = 4)
    private int zze;
    private final Writer zzf;

    static {
        MediaMetadata.zzb = new String[]{"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};
        MediaMetadata.CREATOR = new zzcc();
        zzcb zzcb0 = new zzcb();
        zzcb0.zzb("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4);
        zzcb0.zzb("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4);
        zzcb0.zzb("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4);
        zzcb0.zzb("com.google.android.gms.cast.metadata.TITLE", "title", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.ARTIST", "artist", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.STUDIO", "studio", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.WIDTH", "width", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.HEIGHT", "height", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3);
        zzcb0.zzb("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SECTION_DURATION", "sectionDuration", 5);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "sectionStartTimeInMedia", 5);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "sectionStartAbsoluteTime", 5);
        zzcb0.zzb("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "sectionStartTimeInContainer", 5);
        zzcb0.zzb("com.google.android.gms.cast.metadata.QUEUE_ITEM_ID", "queueItemId", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.BOOK_TITLE", "bookTitle", 1);
        zzcb0.zzb("com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "chapterNumber", 2);
        zzcb0.zzb("com.google.android.gms.cast.metadata.CHAPTER_TITLE", "chapterTitle", 1);
        MediaMetadata.zzc = zzcb0;
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int v) {
        this(new ArrayList(), new Bundle(), v);
    }

    @Constructor
    public MediaMetadata(@Param(id = 2) List list0, @Param(id = 3) Bundle bundle0, @Param(id = 4) int v) {
        this.zzf = new Writer(this);
        this.zzd = list0;
        this.zza = bundle0;
        this.zze = v;
    }

    public void addImage(WebImage webImage0) {
        this.zzd.add(webImage0);
    }

    public void clear() {
        this.zza.clear();
        this.zzd.clear();
    }

    public void clearImages() {
        this.zzd.clear();
    }

    public boolean containsKey(String s) {
        return this.zza.containsKey(s);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MediaMetadata ? this.zzd(this.zza, ((MediaMetadata)object0).zza) && this.zzd.equals(((MediaMetadata)object0).zzd) : false;
    }

    public Calendar getDate(String s) {
        MediaMetadata.throwIfWrongType(s, 4);
        String s1 = this.zza.getString(s);
        return s1 == null ? null : zza.zzb(s1);
    }

    public String getDateAsString(String s) {
        MediaMetadata.throwIfWrongType(s, 4);
        return this.zza.getString(s);
    }

    public double getDouble(String s) {
        MediaMetadata.throwIfWrongType(s, 3);
        return this.zza.getDouble(s);
    }

    public List getImages() {
        return this.zzd;
    }

    public int getInt(String s) {
        MediaMetadata.throwIfWrongType(s, 2);
        return this.zza.getInt(s);
    }

    public int getMediaType() {
        return this.zze;
    }

    public String getString(String s) {
        MediaMetadata.throwIfWrongType(s, 1);
        return this.zza.getString(s);
    }

    public long getTimeMillis(String s) {
        MediaMetadata.throwIfWrongType(s, 5);
        return this.zza.getLong(s);
    }

    @KeepForSdk
    public static int getTypeForKey(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        return MediaMetadata.zzc.zza(s);
    }

    @KeepForSdk
    public Writer getWriter() {
        return this.zzf;
    }

    public boolean hasImages() {
        return this.zzd != null && !this.zzd.isEmpty();
    }

    @Override
    public int hashCode() {
        Bundle bundle0 = this.zza;
        int v = 17;
        if(bundle0 != null) {
            for(Object object0: bundle0.keySet()) {
                Object object1 = bundle0.get(((String)object0));
                v = v * 0x1F + (object1 == null ? 0 : object1.hashCode());
            }
        }
        return this.zzd.hashCode() + v * 0x1F;
    }

    public Set keySet() {
        return this.zza.keySet();
    }

    public void putDate(String s, Calendar calendar0) {
        MediaMetadata.throwIfWrongType(s, 4);
        String s1 = zza.zza(calendar0);
        this.zza.putString(s, s1);
    }

    public void putDouble(String s, double f) {
        MediaMetadata.throwIfWrongType(s, 3);
        this.zza.putDouble(s, f);
    }

    public void putInt(String s, int v) {
        MediaMetadata.throwIfWrongType(s, 2);
        this.zza.putInt(s, v);
    }

    public void putString(String s, String s1) {
        MediaMetadata.throwIfWrongType(s, 1);
        this.zza.putString(s, s1);
    }

    public void putTimeMillis(String s, long v) {
        MediaMetadata.throwIfWrongType(s, 5);
        this.zza.putLong(s, v);
    }

    @KeepForSdk
    public static void throwIfWrongType(String s, int v) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int v1 = MediaMetadata.zzc.zza(s);
        if(v1 != v && v1 != 0) {
            throw new IllegalArgumentException(o.o("Value for ", s, " must be a ", MediaMetadata.zzb[v]));
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.getImages(), false);
        SafeParcelWriter.writeBundle(parcel0, 3, this.zza, false);
        SafeParcelWriter.writeInt(parcel0, 4, this.getMediaType());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final JSONObject zza() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("metadataType", this.zze);
        }
        catch(JSONException unused_ex) {
        }
        JSONArray jSONArray0 = zza.zzc(this.zzd);
        if(jSONArray0.length() != 0) {
            try {
                jSONObject0.put("images", jSONArray0);
            }
            catch(JSONException unused_ex) {
            }
        }
        ArrayList arrayList0 = new ArrayList();
        switch(this.zze) {
            case 0: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            }
            case 1: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            }
            case 2: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
                break;
            }
            case 3: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            }
            case 4: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
                break;
            }
            case 5: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE"});
            }
        }
        Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID"});
        try {
            Iterator iterator0 = arrayList0.iterator();
        alab1:
            while(true) {
            label_21:
                if(!iterator0.hasNext()) {
                    Bundle bundle0 = this.zza;
                    Iterator iterator1 = bundle0.keySet().iterator();
                    while(true) {
                        if(!iterator1.hasNext()) {
                            return jSONObject0;
                        }
                        Object object0 = iterator1.next();
                        String s = (String)object0;
                        if(!s.startsWith("com.google.")) {
                            Object object1 = bundle0.get(s);
                            if(object1 instanceof String) {
                            }
                            else if(object1 instanceof Integer) {
                            }
                            else if(!(object1 instanceof Double)) {
                                continue;
                            }
                            jSONObject0.put(s, object1);
                        }
                    }
                }
                Object object2 = iterator0.next();
                String s1 = (String)object2;
                if(s1 == null) {
                    continue;
                }
                Bundle bundle1 = this.zza;
                if(!bundle1.containsKey(s1)) {
                    continue;
                }
                zzcb zzcb0 = MediaMetadata.zzc;
                String s2 = zzcb0.zzc(s1);
                if(s2 == null) {
                    continue;
                }
                switch(zzcb0.zza(s1)) {
                    case 2: {
                        jSONObject0.put(s2, bundle1.getInt(s1));
                        break alab1;
                    }
                    case 3: {
                        jSONObject0.put(s2, bundle1.getDouble(s1));
                        break alab1;
                    }
                    case 1: 
                    case 4: {
                        jSONObject0.put(s2, bundle1.getString(s1));
                        break alab1;
                    }
                    case 5: {
                        jSONObject0.put(s2, CastUtils.millisecToSec(bundle1.getLong(s1)));
                        break alab1;
                    }
                    default: {
                        break alab1;
                    }
                }
                return jSONObject0;
            }
        }
        catch(JSONException unused_ex) {
            return jSONObject0;
        }
        goto label_21;
    }

    public final void zzc(JSONObject jSONObject0) {
        String s1;
        String s;
        this.clear();
        this.zze = 0;
        try {
            this.zze = jSONObject0.getInt("metadataType");
        }
        catch(JSONException unused_ex) {
        }
        JSONArray jSONArray0 = jSONObject0.optJSONArray("images");
        if(jSONArray0 != null) {
            zza.zzd(this.zzd, jSONArray0);
        }
        ArrayList arrayList0 = new ArrayList();
        switch(this.zze) {
            case 0: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            }
            case 1: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            }
            case 2: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
                break;
            }
            case 3: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            }
            case 4: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
                break;
            }
            case 5: {
                Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE"});
            }
        }
        Collections.addAll(arrayList0, new String[]{"com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID"});
        HashSet hashSet0 = new HashSet(arrayList0);
        try {
            Iterator iterator0 = jSONObject0.keys();
            while(true) {
            label_23:
                if(!iterator0.hasNext()) {
                    return;
                }
                Object object0 = iterator0.next();
                s = (String)object0;
                if(s != null && !"metadataType".equals(s)) {
                    zzcb zzcb0 = MediaMetadata.zzc;
                    s1 = zzcb0.zzd(s);
                    if(s1 == null) {
                        Object object1 = jSONObject0.get(s);
                        if(object1 instanceof String) {
                            this.zza.putString(s, ((String)object1));
                        }
                        else if(object1 instanceof Integer) {
                            this.zza.putInt(s, ((int)(((Integer)object1))));
                        }
                        else {
                            if(!(object1 instanceof Double)) {
                                continue;
                            }
                            this.zza.putDouble(s, ((double)(((Double)object1))));
                        }
                    }
                    else if(hashSet0.contains(s1)) {
                        break;
                    }
                }
            }
        }
        catch(JSONException unused_ex) {
            return;
        }
        try {
            Object object2 = jSONObject0.get(s);
            if(object2 == null) {
                goto label_23;
            }
            switch(zzcb0.zza(s1)) {
                case 1: {
                    if(object2 instanceof String) {
                        break;
                    }
                    goto label_23;
                }
                case 2: {
                    if(!(object2 instanceof Integer)) {
                        goto label_23;
                    }
                    this.zza.putInt(s1, ((int)(((Integer)object2))));
                    goto label_23;
                }
                case 3: {
                    double f = jSONObject0.optDouble(s);
                    if(Double.isNaN(f)) {
                        goto label_23;
                    }
                    this.zza.putDouble(s1, f);
                    goto label_23;
                }
                case 4: {
                    if(!(object2 instanceof String) || zza.zzb(((String)object2)) == null) {
                        goto label_23;
                    }
                    this.zza.putString(s1, ((String)object2));
                    goto label_23;
                }
                case 5: {
                    long v = CastUtils.secToMillisec(jSONObject0.optLong(s));
                    this.zza.putLong(s1, v);
                    goto label_23;
                }
                default: {
                    goto label_23;
                }
            }
            this.zza.putString(s1, ((String)object2));
        }
        catch(JSONException unused_ex) {
        }
        goto label_23;
    }

    private final boolean zzd(Bundle bundle0, Bundle bundle1) {
        if(bundle0.size() != bundle1.size()) {
            return false;
        }
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            Object object1 = bundle0.get(s);
            Object object2 = bundle1.get(s);
            if(object1 instanceof Bundle && object2 instanceof Bundle && !this.zzd(((Bundle)object1), ((Bundle)object2))) {
                return false;
            }
            if(object1 == null) {
                if(object2 == null && bundle1.containsKey(s)) {
                    continue;
                }
                return false;
            }
            if(!object1.equals(object2)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }
}

