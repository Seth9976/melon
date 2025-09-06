package org.gagravarr.skeleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.gagravarr.ogg.OggPacket;

public class SkeletonStream {
    private Map bonesByStream;
    private List fisbones;
    private SkeletonFishead fishead;
    private boolean hasWholeStream;
    private List keyFrames;
    private int sid;

    public SkeletonStream(OggPacket oggPacket0) {
        this.sid = oggPacket0.getSid();
        this.hasWholeStream = false;
        this.fisbones = new ArrayList();
        this.bonesByStream = new HashMap();
        this.keyFrames = new ArrayList();
        this.processPacket(oggPacket0);
    }

    public SkeletonStream(int[] arr_v) {
        this.sid = -1;
        this.fishead = new SkeletonFishead();
        for(int v = 0; v < arr_v.length; ++v) {
            this.addBoneForStream(arr_v[v]);
        }
    }

    public SkeletonFisbone addBoneForStream(int v) {
        SkeletonFisbone skeletonFisbone0 = new SkeletonFisbone();
        skeletonFisbone0.setSerialNumber(v);
        this.fisbones.add(skeletonFisbone0);
        if(v == -1 || this.bonesByStream.containsKey(v)) {
            throw new IllegalArgumentException("Invalid / duplicate sid " + v);
        }
        this.bonesByStream.put(v, skeletonFisbone0);
        return skeletonFisbone0;
    }

    public SkeletonFisbone getBoneForStream(int v) {
        return (SkeletonFisbone)this.bonesByStream.get(v);
    }

    public List getFisbones() {
        return this.fisbones;
    }

    public SkeletonFishead getFishead() {
        return this.fishead;
    }

    public List getKeyFrames() {
        return this.keyFrames;
    }

    public int getSid() {
        return this.sid;
    }

    public boolean hasWholeStream() {
        return this.hasWholeStream;
    }

    public void processPacket(OggPacket oggPacket0) {
        SkeletonPacket skeletonPacket0 = SkeletonPacketFactory.create(oggPacket0);
        if(oggPacket0.isBeginningOfStream()) {
            this.fishead = (SkeletonFishead)skeletonPacket0;
        }
        else if(skeletonPacket0 instanceof SkeletonFisbone) {
            this.fisbones.add(((SkeletonFisbone)skeletonPacket0));
            this.bonesByStream.put(((SkeletonFisbone)skeletonPacket0).getSerialNumber(), ((SkeletonFisbone)skeletonPacket0));
        }
        else if(skeletonPacket0 instanceof SkeletonKeyFramePacket) {
            this.keyFrames.add(((SkeletonKeyFramePacket)skeletonPacket0));
        }
        else {
            throw new IllegalStateException("Unexpected Skeleton " + skeletonPacket0);
        }
        if(oggPacket0.isEndOfStream()) {
            this.hasWholeStream = true;
        }
    }
}

