package org.gagravarr.theora;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.OggFile;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggPacketReader;
import org.gagravarr.ogg.OggPacketWriter;
import org.gagravarr.ogg.OggStreamAudioData;
import org.gagravarr.ogg.OggStreamAudioVisualData;
import org.gagravarr.ogg.OggStreamVideoData;
import org.gagravarr.ogg.audio.OggAudioHeaders;
import org.gagravarr.ogg.audio.OggAudioStreamHeaders;
import org.gagravarr.skeleton.SkeletonFisbone;
import org.gagravarr.skeleton.SkeletonKeyFramePacket;
import org.gagravarr.skeleton.SkeletonPacketFactory;
import org.gagravarr.skeleton.SkeletonStream;

public class TheoraFile extends HighLevelOggStreamPacket implements Closeable {
    public static class AudioVisualDataAndSid {
        protected OggStreamAudioVisualData data;
        protected int sid;

        private AudioVisualDataAndSid(OggStreamAudioVisualData oggStreamAudioVisualData0, int v) {
            this.data = oggStreamAudioVisualData0;
            this.sid = v;
        }

        public AudioVisualDataAndSid(OggStreamAudioVisualData oggStreamAudioVisualData0, int v, org.gagravarr.theora.TheoraFile.1 theoraFile$10) {
            this(oggStreamAudioVisualData0, v);
        }
    }

    private TheoraComments comments;
    private TheoraInfo info;
    private OggFile ogg;
    private LinkedList pendingPackets;
    private OggPacketReader r;
    private TheoraSetup setup;
    private int sid;
    private SkeletonStream skeleton;
    private Map soundtrackWriters;
    private Map soundtracks;
    private OggPacketWriter w;
    private List writtenPackets;

    public TheoraFile(File file0) {
        this(new OggFile(new FileInputStream(file0)));
    }

    public TheoraFile(OutputStream outputStream0) {
        this(outputStream0, new TheoraInfo(), new TheoraComments(), new TheoraSetup());
    }

    public TheoraFile(OutputStream outputStream0, int v, TheoraInfo theoraInfo0, TheoraComments theoraComments0, TheoraSetup theoraSetup0) {
        this.sid = -1;
        OggFile oggFile0 = new OggFile(outputStream0);
        this.ogg = oggFile0;
        if(v > 0) {
            this.w = oggFile0.getPacketWriter(v);
            this.sid = v;
        }
        else {
            OggPacketWriter oggPacketWriter0 = oggFile0.getPacketWriter();
            this.w = oggPacketWriter0;
            this.sid = oggPacketWriter0.getSid();
        }
        this.writtenPackets = new ArrayList();
        this.soundtracks = new HashMap();
        this.soundtrackWriters = new HashMap();
        this.info = theoraInfo0;
        this.comments = theoraComments0;
        this.setup = theoraSetup0;
    }

    public TheoraFile(OutputStream outputStream0, TheoraInfo theoraInfo0, TheoraComments theoraComments0, TheoraSetup theoraSetup0) {
        this(outputStream0, -1, theoraInfo0, theoraComments0, theoraSetup0);
    }

    public TheoraFile(OggFile oggFile0) {
        this(oggFile0.getPacketReader());
        this.ogg = oggFile0;
    }

    public TheoraFile(OggPacketReader oggPacketReader0) {
        this.sid = -1;
        this.r = oggPacketReader0;
        this.pendingPackets = new LinkedList();
        this.soundtracks = new HashMap();
        HashSet hashSet0 = new HashSet();
        int v = -1;
        OggPacket oggPacket0;
        while((oggPacket0 = oggPacketReader0.getNextPacket()) != null) {
            int v1 = oggPacket0.getSid();
            if(!oggPacket0.isBeginningOfStream() || oggPacket0.getData().length <= 10) {
                if(v1 == this.sid) {
                    TheoraPacket theoraPacket0 = TheoraPacketFactory.create(oggPacket0);
                    if(this.comments == null) {
                        this.comments = (TheoraComments)theoraPacket0;
                        continue;
                    }
                    else if(this.setup == null) {
                        this.setup = (TheoraSetup)theoraPacket0;
                        v = 0;
                        continue;
                    }
                    else {
                        this.pendingPackets.add(new AudioVisualDataAndSid(((TheoraVideoData)theoraPacket0), this.sid, null));
                        ++v;
                        if(v <= 10) {
                            continue;
                        }
                        break;
                    }
                }
                if(this.skeleton != null && this.skeleton.getSid() == v1) {
                    this.skeleton.processPacket(oggPacket0);
                }
                else if(this.soundtracks.containsKey(v1)) {
                    OggAudioStreamHeaders oggAudioStreamHeaders0 = (OggAudioStreamHeaders)this.soundtracks.get(v1);
                    if(hashSet0.contains(v1)) {
                        this.pendingPackets.add(new AudioVisualDataAndSid(oggAudioStreamHeaders0.createAudio(oggPacket0), v1, null));
                    }
                    else if(!oggAudioStreamHeaders0.populate(oggPacket0)) {
                        hashSet0.add(v1);
                    }
                }
            }
            else if(TheoraPacketFactory.isTheoraStream(oggPacket0)) {
                this.sid = v1;
                this.info = (TheoraInfo)TheoraPacketFactory.create(oggPacket0);
            }
            else if(SkeletonPacketFactory.isSkeletonStream(oggPacket0)) {
                this.skeleton = new SkeletonStream(oggPacket0);
            }
            else {
                try {
                    this.soundtracks.put(v1, OggAudioStreamHeaders.create(oggPacket0));
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
        }
        if(this.sid == -1) {
            throw new IllegalArgumentException("Supplied File is not Theora");
        }
    }

    public int addSoundtrack(OggAudioHeaders oggAudioHeaders0) {
        if(this.w == null) {
            throw new IllegalStateException("Not in write mode");
        }
        OggPacketWriter oggPacketWriter0 = oggAudioHeaders0.getSid() == -1 ? this.ogg.getPacketWriter() : this.ogg.getPacketWriter(oggAudioHeaders0.getSid());
        int v = oggPacketWriter0.getSid();
        SkeletonStream skeletonStream0 = this.skeleton;
        if(skeletonStream0 != null) {
            skeletonStream0.addBoneForStream(v).setContentType(oggAudioHeaders0.getType().mimetype);
        }
        this.soundtracks.put(v, ((OggAudioStreamHeaders)oggAudioHeaders0));
        this.soundtrackWriters.put(((OggAudioStreamHeaders)oggAudioHeaders0), oggPacketWriter0);
        return v;
    }

    @Override
    public void close() {
        OggPacketWriter oggPacketWriter0;
        if(this.r != null) {
            this.r = null;
            this.ogg.close();
            this.ogg = null;
        }
        if(this.w != null) {
            if(this.skeleton == null) {
                oggPacketWriter0 = null;
            }
            else {
                oggPacketWriter0 = this.ogg.getPacketWriter();
                oggPacketWriter0.bufferPacket(this.skeleton.getFishead().write(), true);
            }
            this.w.bufferPacket(this.info.write(), true);
            for(Object object0: this.soundtrackWriters.keySet()) {
                ((OggPacketWriter)this.soundtrackWriters.get(((OggAudioStreamHeaders)object0))).bufferPacket(((OggAudioStreamHeaders)object0).getInfo().write(), true);
            }
            SkeletonStream skeletonStream0 = this.skeleton;
            if(skeletonStream0 != null) {
                for(Object object1: skeletonStream0.getFisbones()) {
                    oggPacketWriter0.bufferPacket(((SkeletonFisbone)object1).write(), true);
                }
                for(Object object2: this.skeleton.getKeyFrames()) {
                    oggPacketWriter0.bufferPacket(((SkeletonKeyFramePacket)object2).write(), true);
                }
            }
            this.w.bufferPacket(this.comments.write(), true);
            this.w.bufferPacket(this.setup.write(), true);
            for(Object object3: this.soundtrackWriters.keySet()) {
                OggAudioStreamHeaders oggAudioStreamHeaders0 = (OggAudioStreamHeaders)object3;
                OggPacketWriter oggPacketWriter1 = (OggPacketWriter)this.soundtrackWriters.get(oggAudioStreamHeaders0);
                oggPacketWriter1.bufferPacket(oggAudioStreamHeaders0.getTags().write(), true);
                if(oggAudioStreamHeaders0.getSetup() != null) {
                    oggPacketWriter1.bufferPacket(oggAudioStreamHeaders0.getSetup().write(), true);
                }
            }
            long v = 0L;
            for(Object object4: this.writtenPackets) {
                AudioVisualDataAndSid theoraFile$AudioVisualDataAndSid0 = (AudioVisualDataAndSid)object4;
                OggPacketWriter oggPacketWriter2 = this.w;
                int v1 = theoraFile$AudioVisualDataAndSid0.sid;
                if(v1 != this.sid) {
                    oggPacketWriter2 = (OggPacketWriter)this.soundtrackWriters.get(v1);
                }
                if(theoraFile$AudioVisualDataAndSid0.data.getGranulePosition() >= 0L && v != theoraFile$AudioVisualDataAndSid0.data.getGranulePosition()) {
                    oggPacketWriter2.flush();
                    v = theoraFile$AudioVisualDataAndSid0.data.getGranulePosition();
                    oggPacketWriter2.setGranulePosition(v);
                }
                oggPacketWriter2.bufferPacket(theoraFile$AudioVisualDataAndSid0.data.write());
                if(oggPacketWriter2.getSizePendingFlush() > 0x4000) {
                    oggPacketWriter2.flush();
                }
            }
            this.w.close();
            this.w = null;
            if(oggPacketWriter0 != null) {
                oggPacketWriter0.close();
            }
            for(Object object5: this.soundtrackWriters.values()) {
                ((OggPacketWriter)object5).close();
            }
            this.ogg.close();
            this.ogg = null;
        }
    }

    public void ensureSkeleton() {
        if(this.skeleton != null) {
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        int v = this.sid;
        if(v != -1) {
            arrayList0.add(v);
        }
        for(Object object0: this.soundtracks.keySet()) {
            Integer integer0 = (Integer)object0;
            if(((int)integer0) != -1) {
                arrayList0.add(integer0);
            }
        }
        int v1 = arrayList0.size();
        int[] arr_v = new int[v1];
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_v[v2] = (int)(((Integer)arrayList0.get(v2)));
        }
        this.skeleton = new SkeletonStream(arr_v);
    }

    public TheoraComments getComments() {
        return this.comments;
    }

    public TheoraInfo getInfo() {
        return this.info;
    }

    public OggStreamAudioVisualData getNextAudioVisualPacket() {
        return this.getNextAudioVisualPacket(null);
    }

    public OggStreamAudioVisualData getNextAudioVisualPacket(Set set0) {
        OggStreamAudioVisualData oggStreamAudioVisualData0 = null;
        while(oggStreamAudioVisualData0 == null && !this.pendingPackets.isEmpty()) {
            AudioVisualDataAndSid theoraFile$AudioVisualDataAndSid0 = (AudioVisualDataAndSid)this.pendingPackets.removeFirst();
            if(set0 == null || set0.contains(theoraFile$AudioVisualDataAndSid0.sid)) {
                oggStreamAudioVisualData0 = theoraFile$AudioVisualDataAndSid0.data;
            }
        }
        if(oggStreamAudioVisualData0 == null) {
            OggPacket oggPacket0;
            while((oggPacket0 = this.r.getNextPacket()) != null) {
                if(set0 == null || set0.contains(oggPacket0.getSid())) {
                    if(oggPacket0.getSid() == this.sid) {
                        return (OggStreamVideoData)TheoraPacketFactory.create(oggPacket0);
                    }
                    if(!this.soundtracks.containsKey(oggPacket0.getSid())) {
                        throw new IllegalArgumentException("Unsupported stream type with sid " + oggPacket0.getSid());
                    }
                    return ((OggAudioStreamHeaders)this.soundtracks.get(oggPacket0.getSid())).createAudio(oggPacket0);
                }
            }
        }
        return oggStreamAudioVisualData0;
    }

    public OggFile getOggFile() {
        return this.ogg;
    }

    public TheoraSetup getSetup() {
        return this.setup;
    }

    public int getSid() {
        return this.sid;
    }

    public SkeletonStream getSkeleton() {
        return this.skeleton;
    }

    public Map getSoundtrackStreams() {
        return this.soundtracks;
    }

    public Collection getSoundtracks() {
        return this.soundtracks.values();
    }

    public void writeAudioData(OggStreamAudioData oggStreamAudioData0, int v) {
        if(!this.soundtracks.containsKey(v)) {
            throw new IllegalArgumentException("Unknown audio stream with id " + v);
        }
        this.writtenPackets.add(new AudioVisualDataAndSid(oggStreamAudioData0, v, null));
    }

    public void writeVideoData(TheoraVideoData theoraVideoData0) {
        this.writtenPackets.add(new AudioVisualDataAndSid(theoraVideoData0, this.sid, null));
    }

    class org.gagravarr.theora.TheoraFile.1 {
    }

}

