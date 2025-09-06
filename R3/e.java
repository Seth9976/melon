package R3;

import W.p;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.StreamKey;
import androidx.media3.extractor.metadata.scte35.TimeSignalCommand;
import androidx.media3.extractor.metadata.vorbis.VorbisComment;
import com.gaa.sdk.base.ConnectionInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.material.internal.ParcelableSparseBooleanArray;
import com.google.android.material.internal.ParcelableSparseIntArray;
import com.google.firebase.messaging.RemoteMessage;
import com.iloen.melon.sns.model.SharableAlbum;
import com.iloen.melon.sns.model.SharableArtist;
import com.iloen.melon.sns.model.SharableArtistFriendship;
import com.iloen.melon.sns.model.SharableArtistPick;
import com.iloen.melon.sns.model.SharableArtistPlaylist;
import com.iloen.melon.sns.model.SharableBrandDj;
import com.iloen.melon.sns.model.SharableCast;
import com.iloen.melon.sns.model.SharableCastEpisode;
import com.iloen.melon.sns.model.SharableContent;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.SharableHighlight;
import com.iloen.melon.sns.model.SharableMelOnAward;
import com.iloen.melon.sns.model.SharableMelgun;
import com.iloen.melon.sns.model.SharableMelgunsPick;
import com.iloen.melon.sns.model.SharableMemorialCard;
import com.iloen.melon.sns.model.SharableMusicDna;
import com.iloen.melon.sns.model.SharableMusicWave;
import com.iloen.melon.sns.model.SharableMv;
import com.iloen.melon.sns.model.SharableMvTheme;
import com.iloen.melon.sns.model.SharableMyMusic;
import com.iloen.melon.sns.model.SharableNowplaying;
import com.iloen.melon.sns.model.ShareLinkData;
import kotlin.jvm.internal.q;

public final class e implements Parcelable.Creator {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                return new TimeSignalCommand(parcel0.readLong(), parcel0.readLong());
            }
            case 1: {
                return new VorbisComment(parcel0);  // 初始化器: Landroidx/media3/extractor/metadata/flac/VorbisComment;-><init>(Landroid/os/Parcel;)V
            }
            case 2: {
                return new DrmInitData(parcel0);
            }
            case 3: {
                return new Metadata(parcel0);
            }
            case 4: {
                return new StreamKey(parcel0);
            }
            case 5: {
                ConnectionInfo connectionInfo0 = new ConnectionInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                connectionInfo0.a = p0;
                p0.a = parcel0.readString();
                p0.b = parcel0.readString();
                return connectionInfo0;
            }
            case 6: {
                int v = parcel0.readInt();
                ParcelableSparseBooleanArray parcelableSparseBooleanArray0 = new ParcelableSparseBooleanArray(v);  // 初始化器: Landroid/util/SparseBooleanArray;-><init>(I)V
                int[] arr_v = new int[v];
                boolean[] arr_z = new boolean[v];
                parcel0.readIntArray(arr_v);
                parcel0.readBooleanArray(arr_z);
                for(int v1 = 0; v1 < v; ++v1) {
                    parcelableSparseBooleanArray0.put(arr_v[v1], arr_z[v1]);
                }
                return parcelableSparseBooleanArray0;
            }
            case 7: {
                int v2 = parcel0.readInt();
                ParcelableSparseIntArray parcelableSparseIntArray0 = new ParcelableSparseIntArray(v2);  // 初始化器: Landroid/util/SparseIntArray;-><init>(I)V
                int[] arr_v1 = new int[v2];
                int[] arr_v2 = new int[v2];
                parcel0.readIntArray(arr_v1);
                parcel0.readIntArray(arr_v2);
                for(int v3 = 0; v3 < v2; ++v3) {
                    parcelableSparseIntArray0.put(arr_v1[v3], arr_v2[v3]);
                }
                return parcelableSparseIntArray0;
            }
            case 8: {
                int v4 = SafeParcelReader.validateObjectHeader(parcel0);
                Bundle bundle0 = null;
                while(parcel0.dataPosition() < v4) {
                    int v5 = SafeParcelReader.readHeader(parcel0);
                    if(((char)v5) == 2) {
                        bundle0 = SafeParcelReader.createBundle(parcel0, v5);
                    }
                    else {
                        SafeParcelReader.skipUnknownField(parcel0, v5);
                    }
                }
                SafeParcelReader.ensureAtEnd(parcel0, v4);
                return new RemoteMessage(bundle0);
            }
            case 9: {
                SharableAlbum sharableAlbum0 = new SharableAlbum();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableAlbum0.b = parcel0.readString();
                sharableAlbum0.d = parcel0.readString();
                sharableAlbum0.e = parcel0.readString();
                sharableAlbum0.f = parcel0.readString();
                sharableAlbum0.g = parcel0.readString();
                sharableAlbum0.h = parcel0.readString();
                return sharableAlbum0;
            }
            case 10: {
                SharableArtist sharableArtist0 = new SharableArtist();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableArtist0.a = parcel0.readString();
                sharableArtist0.b = parcel0.readString();
                sharableArtist0.d = parcel0.readString();
                sharableArtist0.e = parcel0.readString();
                sharableArtist0.f = parcel0.readString();
                sharableArtist0.g = parcel0.readString();
                sharableArtist0.h = parcel0.readString();
                sharableArtist0.i = parcel0.readString();
                return sharableArtist0;
            }
            case 11: {
                SharableArtistFriendship sharableArtistFriendship0 = new SharableArtistFriendship();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableArtistFriendship0.a = parcel0.readString();
                sharableArtistFriendship0.b = parcel0.readString();
                sharableArtistFriendship0.d = parcel0.readString();
                sharableArtistFriendship0.e = parcel0.readString();
                sharableArtistFriendship0.f = parcel0.readString();
                sharableArtistFriendship0.g = parcel0.readString();
                sharableArtistFriendship0.h = parcel0.readString();
                sharableArtistFriendship0.i = parcel0.readString();
                sharableArtistFriendship0.j = parcel0.readString();
                sharableArtistFriendship0.k = parcel0.readString();
                return sharableArtistFriendship0;
            }
            case 12: {
                SharableArtistPick sharableArtistPick0 = new SharableArtistPick();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableArtistPick0.a = parcel0.readString();
                sharableArtistPick0.b = parcel0.readString();
                sharableArtistPick0.d = parcel0.readString();
                sharableArtistPick0.e = parcel0.readString();
                sharableArtistPick0.f = parcel0.readString();
                sharableArtistPick0.g = parcel0.readString();
                return sharableArtistPick0;
            }
            case 13: {
                SharableArtistPlaylist sharableArtistPlaylist0 = new SharableArtistPlaylist(parcel0);  // 初始化器: Lcom/iloen/melon/sns/model/SharablePlaylist;-><init>(Landroid/os/Parcel;)V
                sharableArtistPlaylist0.k = parcel0.readString();
                sharableArtistPlaylist0.l = parcel0.readString();
                return sharableArtistPlaylist0;
            }
            case 14: {
                SharableBrandDj sharableBrandDj0 = new SharableBrandDj();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableBrandDj0.a = parcel0.readString();
                sharableBrandDj0.b = parcel0.readString();
                sharableBrandDj0.d = parcel0.readString();
                sharableBrandDj0.e = parcel0.readString();
                return sharableBrandDj0;
            }
            case 15: {
                q.g(parcel0, "source");
                SharableCast sharableCast0 = new SharableCast();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableCast0.a = parcel0.readString();
                sharableCast0.b = parcel0.readString();
                sharableCast0.d = parcel0.readString();
                sharableCast0.e = parcel0.readString();
                return sharableCast0;
            }
            case 16: {
                q.g(parcel0, "source");
                SharableCastEpisode sharableCastEpisode0 = new SharableCastEpisode();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableCastEpisode0.a = parcel0.readString();
                sharableCastEpisode0.b = parcel0.readString();
                sharableCastEpisode0.d = parcel0.readString();
                sharableCastEpisode0.e = parcel0.readString();
                sharableCastEpisode0.f = (ShareLinkData)parcel0.readParcelable(ShareLinkData.class.getClassLoader());
                return sharableCastEpisode0;
            }
            case 17: {
                SharableContent sharableContent0 = new SharableContent();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableContent0.a = parcel0.readString();
                sharableContent0.b = parcel0.readString();
                sharableContent0.d = parcel0.readString();
                sharableContent0.e = parcel0.readString();
                sharableContent0.f = parcel0.readString();
                return sharableContent0;
            }
            case 18: {
                SharableDJCollection sharableDJCollection0 = new SharableDJCollection();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableDJCollection0.a = parcel0.readString();
                sharableDJCollection0.b = parcel0.readString();
                sharableDJCollection0.d = parcel0.readString();
                sharableDJCollection0.e = parcel0.readString();
                sharableDJCollection0.f = parcel0.readString();
                sharableDJCollection0.g = parcel0.readString();
                sharableDJCollection0.h = parcel0.readString();
                sharableDJCollection0.i = parcel0.readString();
                sharableDJCollection0.j = parcel0.readString();
                return sharableDJCollection0;
            }
            case 19: {
                q.g(parcel0, "source");
                return new SharableHighlight(parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString());
            }
            case 20: {
                return new SharableMelOnAward();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            case 21: {
                SharableMelgun sharableMelgun0 = new SharableMelgun();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableMelgun0.a = parcel0.readString();
                sharableMelgun0.b = parcel0.readString();
                return sharableMelgun0;
            }
            case 22: {
                SharableMelgunsPick sharableMelgunsPick0 = new SharableMelgunsPick();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableMelgunsPick0.b = "";
                sharableMelgunsPick0.d = "";
                sharableMelgunsPick0.e = "";
                sharableMelgunsPick0.f = "";
                sharableMelgunsPick0.a = parcel0.readString();
                sharableMelgunsPick0.b = parcel0.readString();
                sharableMelgunsPick0.d = parcel0.readString();
                sharableMelgunsPick0.e = parcel0.readString();
                sharableMelgunsPick0.f = parcel0.readString();
                return sharableMelgunsPick0;
            }
            case 23: {
                q.g(parcel0, "source");
                SharableMemorialCard sharableMemorialCard0 = new SharableMemorialCard();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableMemorialCard0.a = parcel0.readString();
                sharableMemorialCard0.b = parcel0.readString();
                sharableMemorialCard0.d = parcel0.readString();
                sharableMemorialCard0.e = parcel0.readString();
                sharableMemorialCard0.f = parcel0.readString();
                return sharableMemorialCard0;
            }
            case 24: {
                q.g(parcel0, "source");
                SharableMusicDna sharableMusicDna0 = new SharableMusicDna();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableMusicDna0.a = parcel0.readString();
                sharableMusicDna0.b = parcel0.readString();
                sharableMusicDna0.d = parcel0.readString();
                sharableMusicDna0.e = parcel0.readString();
                sharableMusicDna0.f = parcel0.readString();
                sharableMusicDna0.g = parcel0.readString();
                sharableMusicDna0.h = parcel0.readString();
                sharableMusicDna0.i = parcel0.readString();
                sharableMusicDna0.j = parcel0.readString();
                sharableMusicDna0.k = parcel0.readString();
                sharableMusicDna0.l = parcel0.readString();
                sharableMusicDna0.m = parcel0.readString();
                sharableMusicDna0.n = parcel0.readString();
                sharableMusicDna0.o = parcel0.readString();
                sharableMusicDna0.r = parcel0.readString();
                return sharableMusicDna0;
            }
            case 25: {
                q.g(parcel0, "source");
                SharableMusicWave sharableMusicWave0 = new SharableMusicWave();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableMusicWave0.a = parcel0.readString();
                sharableMusicWave0.b = parcel0.readString();
                sharableMusicWave0.d = parcel0.readString();
                sharableMusicWave0.e = parcel0.readString();
                sharableMusicWave0.f = parcel0.readString();
                return sharableMusicWave0;
            }
            case 26: {
                return new SharableMv(parcel0);
            }
            case 27: {
                SharableMvTheme sharableMvTheme0 = new SharableMvTheme(parcel0);  // 初始化器: Lcom/iloen/melon/sns/model/SharableMv;-><init>(Landroid/os/Parcel;)V
                sharableMvTheme0.j = parcel0.readString();
                return sharableMvTheme0;
            }
            case 28: {
                SharableMyMusic sharableMyMusic0 = new SharableMyMusic();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableMyMusic0.a = parcel0.readString();
                sharableMyMusic0.b = parcel0.readString();
                sharableMyMusic0.d = parcel0.readString();
                sharableMyMusic0.e = parcel0.readString();
                return sharableMyMusic0;
            }
            default: {
                SharableNowplaying sharableNowplaying0 = new SharableNowplaying();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableNowplaying0.b = "";
                sharableNowplaying0.d = "";
                sharableNowplaying0.e = "";
                sharableNowplaying0.a = parcel0.readString();
                sharableNowplaying0.b = parcel0.readString();
                sharableNowplaying0.d = parcel0.readString();
                sharableNowplaying0.e = parcel0.readString();
                return sharableNowplaying0;
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new TimeSignalCommand[v];
            }
            case 1: {
                return new VorbisComment[v];
            }
            case 2: {
                return new DrmInitData[v];
            }
            case 3: {
                return new Metadata[v];
            }
            case 4: {
                return new StreamKey[v];
            }
            case 5: {
                return new ConnectionInfo[v];
            }
            case 6: {
                return new ParcelableSparseBooleanArray[v];
            }
            case 7: {
                return new ParcelableSparseIntArray[v];
            }
            case 8: {
                return new RemoteMessage[v];
            }
            case 9: {
                return new SharableAlbum[v];
            }
            case 10: {
                return new SharableArtist[v];
            }
            case 11: {
                return new SharableArtistFriendship[v];
            }
            case 12: {
                return new SharableArtistPick[v];
            }
            case 13: {
                return new SharableArtistPlaylist[v];
            }
            case 14: {
                return new SharableBrandDj[v];
            }
            case 15: {
                return new SharableCast[v];
            }
            case 16: {
                return new SharableCastEpisode[v];
            }
            case 17: {
                return new SharableContent[v];
            }
            case 18: {
                return new SharableDJCollection[v];
            }
            case 19: {
                return new SharableHighlight[v];
            }
            case 20: {
                return new SharableMelOnAward[v];
            }
            case 21: {
                return new SharableMelgun[v];
            }
            case 22: {
                return new SharableMelgunsPick[v];
            }
            case 23: {
                return new SharableMemorialCard[v];
            }
            case 24: {
                return new SharableMusicDna[v];
            }
            case 25: {
                return new SharableMusicWave[v];
            }
            case 26: {
                return new SharableMv[v];
            }
            case 27: {
                return new SharableMvTheme[v];
            }
            case 28: {
                return new SharableMyMusic[v];
            }
            default: {
                return new SharableNowplaying[v];
            }
        }
    }
}

