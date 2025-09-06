package y;

import I6.V;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.car.app.serialization.Bundleable;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTable;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.flac.VorbisComment;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.media3.extractor.metadata.icy.IcyInfo;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.BinaryFrame;
import androidx.media3.extractor.metadata.id3.ChapterFrame;
import androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.GeobFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.metadata.id3.UrlLinkFrame;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import androidx.media3.extractor.metadata.scte35.PrivateCommand;
import androidx.media3.extractor.metadata.scte35.SpliceInsertCommand;
import androidx.media3.extractor.metadata.scte35.SpliceNullCommand;
import androidx.media3.extractor.metadata.scte35.SpliceScheduleCommand;
import androidx.versionedparcelable.ParcelImpl;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.inisoft.media.MediaPlayer.TrackInfo;
import com.inisoft.media.MediaPlayer.TrackRepresentation;
import com.inisoft.media.download.DownloadRequestBuilder.DownloadSelectionOverride;
import com.melon.ui.detail.holder.DetailHolderUiState.CreditItemUiState;
import java.util.Objects;
import kotlin.jvm.internal.q;

public final class a implements Parcelable.Creator {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                Bundle bundle0 = parcel0.readBundle(a.class.getClassLoader());
                Objects.requireNonNull(bundle0);
                return new Bundleable(bundle0);
            }
            case 1: {
                TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                tabInfo0.i = -1;
                tabInfo0.j = -1.0f;
                tabInfo0.k = -1.0f;
                tabInfo0.l = -1.0f;
                tabInfo0.m = -1.0f;
                tabInfo0.n = 1.0f;
                tabInfo0.o = -1;
                tabInfo0.a = parcel0.readInt();
                tabInfo0.b = parcel0.readString();
                tabInfo0.c = parcel0.readInt();
                tabInfo0.d = parcel0.readString();
                tabInfo0.e = parcel0.readInt();
                tabInfo0.f = parcel0.readInt();
                tabInfo0.g = parcel0.readInt();
                tabInfo0.h = parcel0.readInt();
                tabInfo0.i = parcel0.readInt();
                tabInfo0.j = parcel0.readFloat();
                tabInfo0.k = parcel0.readFloat();
                tabInfo0.l = parcel0.readFloat();
                tabInfo0.m = parcel0.readFloat();
                tabInfo0.n = parcel0.readFloat();
                tabInfo0.o = parcel0.readInt();
                return tabInfo0;
            }
            case 2: {
                return new MediaPlayer.TrackInfo(parcel0);
            }
            case 3: {
                return new MediaPlayer.TrackRepresentation(parcel0);
            }
            case 4: {
                return new DownloadRequestBuilder.DownloadSelectionOverride(parcel0);
            }
            case 5: {
                q.g(parcel0, "parcel");
                return new DetailHolderUiState.CreditItemUiState(parcel0.readString(), parcel0.readString());
            }
            case 6: {
                String s = parcel0.readString();
                s.getClass();
                return new AppInfoTable(parcel0.readInt(), s);
            }
            case 7: {
                return new EventMessage(parcel0);
            }
            case 8: {
                return new PictureFrame(parcel0);
            }
            case 9: {
                return new VorbisComment(parcel0);
            }
            case 10: {
                return new IcyHeaders(parcel0);
            }
            case 11: {
                return new IcyInfo(parcel0);
            }
            case 12: {
                return new ApicFrame(parcel0);
            }
            case 13: {
                return new BinaryFrame(parcel0);
            }
            case 14: {
                return new ChapterFrame(parcel0);
            }
            case 15: {
                return new ChapterTocFrame(parcel0);
            }
            case 16: {
                return new CommentFrame(parcel0);
            }
            case 17: {
                return new GeobFrame(parcel0);
            }
            case 18: {
                return new InternalFrame(parcel0);
            }
            case 19: {
                return new MlltFrame(parcel0);
            }
            case 20: {
                return new PrivFrame(parcel0);
            }
            case 21: {
                String s1 = parcel0.readString();
                s1.getClass();
                String s2 = parcel0.readString();
                String[] arr_s = parcel0.createStringArray();
                arr_s.getClass();
                return new TextInformationFrame(s1, s2, V.q(arr_s));
            }
            case 22: {
                return new UrlLinkFrame(parcel0);
            }
            case 23: {
                return new ParcelImpl(parcel0);
            }
            case 24: {
                return new MotionPhotoMetadata(parcel0);
            }
            case 25: {
                return new SmtaMetadataEntry(parcel0);
            }
            case 26: {
                return new PrivateCommand(parcel0);
            }
            case 27: {
                return new SpliceInsertCommand(parcel0);
            }
            case 28: {
                return new SpliceNullCommand();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            default: {
                return new SpliceScheduleCommand(parcel0);
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new Bundleable[v];
            }
            case 1: {
                return new TabInfo[v];
            }
            case 2: {
                return new MediaPlayer.TrackInfo[v];
            }
            case 3: {
                return new MediaPlayer.TrackRepresentation[v];
            }
            case 4: {
                return new DownloadRequestBuilder.DownloadSelectionOverride[v];
            }
            case 5: {
                return new DetailHolderUiState.CreditItemUiState[v];
            }
            case 6: {
                return new AppInfoTable[v];
            }
            case 7: {
                return new EventMessage[v];
            }
            case 8: {
                return new PictureFrame[v];
            }
            case 9: {
                return new VorbisComment[v];
            }
            case 10: {
                return new IcyHeaders[v];
            }
            case 11: {
                return new IcyInfo[v];
            }
            case 12: {
                return new ApicFrame[v];
            }
            case 13: {
                return new BinaryFrame[v];
            }
            case 14: {
                return new ChapterFrame[v];
            }
            case 15: {
                return new ChapterTocFrame[v];
            }
            case 16: {
                return new CommentFrame[v];
            }
            case 17: {
                return new GeobFrame[v];
            }
            case 18: {
                return new InternalFrame[v];
            }
            case 19: {
                return new MlltFrame[v];
            }
            case 20: {
                return new PrivFrame[v];
            }
            case 21: {
                return new TextInformationFrame[v];
            }
            case 22: {
                return new UrlLinkFrame[v];
            }
            case 23: {
                return new ParcelImpl[v];
            }
            case 24: {
                return new MotionPhotoMetadata[v];
            }
            case 25: {
                return new SmtaMetadataEntry[v];
            }
            case 26: {
                return new PrivateCommand[v];
            }
            case 27: {
                return new SpliceInsertCommand[v];
            }
            case 28: {
                return new SpliceNullCommand[v];
            }
            default: {
                return new SpliceScheduleCommand[v];
            }
        }
    }
}

