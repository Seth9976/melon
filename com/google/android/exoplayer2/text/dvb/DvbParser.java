package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DvbParser {
    static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;
        public final int id;

        public ClutDefinition(int v, int[] arr_v, int[] arr_v1, int[] arr_v2) {
            this.id = v;
            this.clutEntries2Bit = arr_v;
            this.clutEntries4Bit = arr_v1;
            this.clutEntries8Bit = arr_v2;
        }
    }

    static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int v, int v1, int v2, int v3, int v4, int v5) {
            this.width = v;
            this.height = v1;
            this.horizontalPositionMinimum = v2;
            this.horizontalPositionMaximum = v3;
            this.verticalPositionMinimum = v4;
            this.verticalPositionMaximum = v5;
        }
    }

    static final class ObjectData {
        public final byte[] bottomFieldData;
        public final int id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int v, boolean z, byte[] arr_b, byte[] arr_b1) {
            this.id = v;
            this.nonModifyingColorFlag = z;
            this.topFieldData = arr_b;
            this.bottomFieldData = arr_b1;
        }
    }

    static final class PageComposition {
        public final SparseArray regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int v, int v1, int v2, SparseArray sparseArray0) {
            this.timeOutSecs = v;
            this.version = v1;
            this.state = v2;
            this.regions = sparseArray0;
        }
    }

    static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int v, int v1) {
            this.horizontalAddress = v;
            this.verticalAddress = v1;
        }
    }

    static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;
        public final int id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray regionObjects;
        public final int width;

        public RegionComposition(int v, boolean z, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8, SparseArray sparseArray0) {
            this.id = v;
            this.fillFlag = z;
            this.width = v1;
            this.height = v2;
            this.levelOfCompatibility = v3;
            this.depth = v4;
            this.clutId = v5;
            this.pixelCode8Bit = v6;
            this.pixelCode4Bit = v7;
            this.pixelCode2Bit = v8;
            this.regionObjects = sparseArray0;
        }

        public void mergeFrom(RegionComposition dvbParser$RegionComposition0) {
            SparseArray sparseArray0 = dvbParser$RegionComposition0.regionObjects;
            for(int v = 0; v < sparseArray0.size(); ++v) {
                int v1 = sparseArray0.keyAt(v);
                RegionObject dvbParser$RegionObject0 = (RegionObject)sparseArray0.valueAt(v);
                this.regionObjects.put(v1, dvbParser$RegionObject0);
            }
        }
    }

    static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int v, int v1, int v2, int v3, int v4, int v5) {
            this.type = v;
            this.provider = v1;
            this.horizontalPosition = v2;
            this.verticalPosition = v3;
            this.foregroundPixelCode = v4;
            this.backgroundPixelCode = v5;
        }
    }

    static final class SubtitleService {
        public final SparseArray ancillaryCluts;
        public final SparseArray ancillaryObjects;
        public final int ancillaryPageId;
        public final SparseArray cluts;
        public DisplayDefinition displayDefinition;
        public final SparseArray objects;
        public PageComposition pageComposition;
        public final SparseArray regions;
        public final int subtitlePageId;

        public SubtitleService(int v, int v1) {
            this.subtitlePageId = v;
            this.ancillaryPageId = v1;
            this.regions = new SparseArray();
            this.cluts = new SparseArray();
            this.objects = new SparseArray();
            this.ancillaryCluts = new SparseArray();
            this.ancillaryObjects = new SparseArray();
        }

        public void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    private static final int DATA_TYPE_24_TABLE_DATA = 0x20;
    private static final int DATA_TYPE_28_TABLE_DATA = 33;
    private static final int DATA_TYPE_2BP_CODE_STRING = 16;
    private static final int DATA_TYPE_48_TABLE_DATA = 34;
    private static final int DATA_TYPE_4BP_CODE_STRING = 17;
    private static final int DATA_TYPE_8BP_CODE_STRING = 18;
    private static final int DATA_TYPE_END_LINE = 0xF0;
    private static final int OBJECT_CODING_PIXELS = 0;
    private static final int OBJECT_CODING_STRING = 1;
    private static final int PAGE_STATE_NORMAL = 0;
    private static final int REGION_DEPTH_4_BIT = 2;
    private static final int REGION_DEPTH_8_BIT = 3;
    private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
    private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
    private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
    private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
    private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
    private static final String TAG = "DvbParser";
    private Bitmap bitmap;
    private final Canvas canvas;
    private final ClutDefinition defaultClutDefinition;
    private final DisplayDefinition defaultDisplayDefinition;
    private static final byte[] defaultMap2To4;
    private static final byte[] defaultMap2To8;
    private static final byte[] defaultMap4To8;
    private final Paint defaultPaint;
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    static {
        DvbParser.defaultMap2To4 = new byte[]{0, 7, 8, 15};
        DvbParser.defaultMap2To8 = new byte[]{0, 0x77, -120, -1};
        DvbParser.defaultMap4To8 = new byte[]{0, 17, 34, 51, 68, 85, 102, 0x77, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public DvbParser(int v, int v1) {
        Paint paint0 = new Paint();
        this.defaultPaint = paint0;
        paint0.setStyle(Paint.Style.FILL_AND_STROKE);
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint0.setPathEffect(null);
        Paint paint1 = new Paint();
        this.fillRegionPaint = paint1;
        paint1.setStyle(Paint.Style.FILL);
        paint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint1.setPathEffect(null);
        this.canvas = new Canvas();
        this.defaultDisplayDefinition = new DisplayDefinition(0x2CF, 0x23F, 0, 0x2CF, 0, 0x23F);
        this.defaultClutDefinition = new ClutDefinition(0, DvbParser.generateDefault2BitClutEntries(), DvbParser.generateDefault4BitClutEntries(), DvbParser.generateDefault8BitClutEntries());
        this.subtitleService = new SubtitleService(v, v1);
    }

    private static byte[] buildClutMapTable(int v, int v1, ParsableBitArray parsableBitArray0) {
        byte[] arr_b = new byte[v];
        for(int v2 = 0; v2 < v; ++v2) {
            arr_b[v2] = (byte)parsableBitArray0.readBits(v1);
        }
        return arr_b;
    }

    public List decode(byte[] arr_b, int v) {
        int v11;
        int v9;
        SparseArray sparseArray2;
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(arr_b, v);
        while(parsableBitArray0.bitsLeft() >= 0x30 && parsableBitArray0.readBits(8) == 15) {
            DvbParser.parseSubtitlingSegment(parsableBitArray0, this.subtitleService);
        }
        SubtitleService dvbParser$SubtitleService0 = this.subtitleService;
        PageComposition dvbParser$PageComposition0 = dvbParser$SubtitleService0.pageComposition;
        if(dvbParser$PageComposition0 == null) {
            return Collections.EMPTY_LIST;
        }
        DisplayDefinition dvbParser$DisplayDefinition0 = dvbParser$SubtitleService0.displayDefinition == null ? this.defaultDisplayDefinition : dvbParser$SubtitleService0.displayDefinition;
        Bitmap bitmap0 = this.bitmap;
        if(bitmap0 == null) {
        label_15:
            Bitmap bitmap1 = Bitmap.createBitmap(dvbParser$DisplayDefinition0.width + 1, dvbParser$DisplayDefinition0.height + 1, Bitmap.Config.ARGB_8888);
            this.bitmap = bitmap1;
            this.canvas.setBitmap(bitmap1);
        }
        else {
            int v1 = bitmap0.getWidth();
            if(dvbParser$DisplayDefinition0.width + 1 == v1) {
                int v2 = this.bitmap.getHeight();
                if(dvbParser$DisplayDefinition0.height + 1 != v2) {
                    goto label_15;
                }
            }
            else {
                goto label_15;
            }
        }
        ArrayList arrayList0 = new ArrayList();
        SparseArray sparseArray0 = dvbParser$PageComposition0.regions;
        for(int v3 = 0; v3 < sparseArray0.size(); ++v3) {
            this.canvas.save();
            PageRegion dvbParser$PageRegion0 = (PageRegion)sparseArray0.valueAt(v3);
            int v4 = sparseArray0.keyAt(v3);
            RegionComposition dvbParser$RegionComposition0 = (RegionComposition)this.subtitleService.regions.get(v4);
            int v5 = dvbParser$PageRegion0.horizontalAddress + dvbParser$DisplayDefinition0.horizontalPositionMinimum;
            int v6 = dvbParser$PageRegion0.verticalAddress + dvbParser$DisplayDefinition0.verticalPositionMinimum;
            this.canvas.clipRect(v5, v6, Math.min(dvbParser$RegionComposition0.width + v5, dvbParser$DisplayDefinition0.horizontalPositionMaximum), Math.min(dvbParser$RegionComposition0.height + v6, dvbParser$DisplayDefinition0.verticalPositionMaximum));
            ClutDefinition dvbParser$ClutDefinition0 = (ClutDefinition)this.subtitleService.cluts.get(dvbParser$RegionComposition0.clutId);
            if(dvbParser$ClutDefinition0 == null) {
                ClutDefinition dvbParser$ClutDefinition1 = (ClutDefinition)this.subtitleService.ancillaryCluts.get(dvbParser$RegionComposition0.clutId);
                dvbParser$ClutDefinition0 = dvbParser$ClutDefinition1 == null ? this.defaultClutDefinition : dvbParser$ClutDefinition1;
            }
            ClutDefinition dvbParser$ClutDefinition2 = dvbParser$ClutDefinition0;
            SparseArray sparseArray1 = dvbParser$RegionComposition0.regionObjects;
            int v7 = 0;
            while(v7 < sparseArray1.size()) {
                int v8 = sparseArray1.keyAt(v7);
                RegionObject dvbParser$RegionObject0 = (RegionObject)sparseArray1.valueAt(v7);
                ObjectData dvbParser$ObjectData0 = (ObjectData)this.subtitleService.objects.get(v8);
                if(dvbParser$ObjectData0 == null) {
                    dvbParser$ObjectData0 = (ObjectData)this.subtitleService.ancillaryObjects.get(v8);
                }
                if(dvbParser$ObjectData0 == null) {
                    sparseArray2 = sparseArray0;
                    v9 = v7;
                }
                else {
                    sparseArray2 = sparseArray0;
                    v9 = v7;
                    DvbParser.paintPixelDataSubBlocks(dvbParser$ObjectData0, dvbParser$ClutDefinition2, dvbParser$RegionComposition0.depth, dvbParser$RegionObject0.horizontalPosition + v5, dvbParser$RegionObject0.verticalPosition + v6, (dvbParser$ObjectData0.nonModifyingColorFlag ? null : this.defaultPaint), this.canvas);
                }
                v7 = v9 + 1;
                sparseArray0 = sparseArray2;
            }
            if(dvbParser$RegionComposition0.fillFlag) {
                int v10 = dvbParser$RegionComposition0.depth;
                if(v10 == 3) {
                    v11 = dvbParser$ClutDefinition2.clutEntries8Bit[dvbParser$RegionComposition0.pixelCode8Bit];
                }
                else {
                    v11 = v10 == 2 ? dvbParser$ClutDefinition2.clutEntries4Bit[dvbParser$RegionComposition0.pixelCode4Bit] : dvbParser$ClutDefinition2.clutEntries2Bit[dvbParser$RegionComposition0.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(v11);
                this.canvas.drawRect(((float)v5), ((float)v6), ((float)(dvbParser$RegionComposition0.width + v5)), ((float)(dvbParser$RegionComposition0.height + v6)), this.fillRegionPaint);
            }
            arrayList0.add(new Cue(Bitmap.createBitmap(this.bitmap, v5, v6, dvbParser$RegionComposition0.width, dvbParser$RegionComposition0.height), ((float)v5) / ((float)dvbParser$DisplayDefinition0.width), 0, ((float)v6) / ((float)dvbParser$DisplayDefinition0.height), 0, ((float)dvbParser$RegionComposition0.width) / ((float)dvbParser$DisplayDefinition0.width), ((float)dvbParser$RegionComposition0.height) / ((float)dvbParser$DisplayDefinition0.height)));
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.canvas.restore();
        }
        return Collections.unmodifiableList(arrayList0);
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, 0xFF000000, 0xFF7F7F7F};
    }

    private static int[] generateDefault4BitClutEntries() {
        int[] arr_v = new int[16];
        arr_v[0] = 0;
        for(int v = 1; true; ++v) {
            int v1 = 0x7F;
            if(v >= 16) {
                break;
            }
            if(v < 8) {
                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 0xFF) << 16 | ((v & 2) == 0 ? 0 : 0xFF) << 8 | ((v & 4) == 0 ? 0 : 0xFF);
            }
            else {
                if((v & 4) == 0) {
                    v1 = 0;
                }
                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 0x7F) << 16 | ((v & 2) == 0 ? 0 : 0x7F) << 8 | v1;
            }
        }
        return arr_v;
    }

    private static int[] generateDefault8BitClutEntries() {
        int[] arr_v = new int[0x100];
        arr_v[0] = 0;
        for(int v = 0; true; ++v) {
            int v1 = 0xFF;
            if(v >= 0x100) {
                break;
            }
            if(v < 8) {
                if((v & 4) == 0) {
                    v1 = 0;
                }
                arr_v[v] = 0x3F000000 | ((v & 1) == 0 ? 0 : 0xFF) << 16 | ((v & 2) == 0 ? 0 : 0xFF) << 8 | v1;
            }
            else {
                int v2 = 43;
                int v3 = 170;
                int v4 = 85;
                switch(v & 0x88) {
                    case 0: {
                        if((v & 4) == 0) {
                            v4 = 0;
                        }
                        if((v & 0x40) == 0) {
                            v3 = 0;
                        }
                        arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 85) + ((v & 16) == 0 ? 0 : 170) << 16 | ((v & 2) == 0 ? 0 : 85) + ((v & 0x20) == 0 ? 0 : 170) << 8 | v4 + v3;
                        break;
                    }
                    case 8: {
                        if((v & 4) == 0) {
                            v4 = 0;
                        }
                        if((v & 0x40) == 0) {
                            v3 = 0;
                        }
                        arr_v[v] = 0x7F000000 | ((v & 1) == 0 ? 0 : 85) + ((v & 16) == 0 ? 0 : 170) << 16 | ((v & 2) == 0 ? 0 : 85) + ((v & 0x20) == 0 ? 0 : 170) << 8 | v4 + v3;
                        break;
                    }
                    default: {
                        switch(v & 0x88) {
                            case 0x80: {
                                if((v & 4) == 0) {
                                    v2 = 0;
                                }
                                if((v & 0x40) == 0) {
                                    v4 = 0;
                                }
                                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 43) + 0x7F + ((v & 16) == 0 ? 0 : 85) << 16 | ((v & 2) == 0 ? 0 : 43) + 0x7F + ((v & 0x20) == 0 ? 0 : 85) << 8 | v2 + 0x7F + v4;
                                break;
                            }
                            case 0x88: {
                                if((v & 4) == 0) {
                                    v2 = 0;
                                }
                                if((v & 0x40) == 0) {
                                    v4 = 0;
                                }
                                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 43) + ((v & 16) == 0 ? 0 : 85) << 16 | ((v & 2) == 0 ? 0 : 43) + ((v & 0x20) == 0 ? 0 : 85) << 8 | v2 + v4;
                            }
                        }
                    }
                }
            }
        }
        return arr_v;
    }

    private static int getColor(int v, int v1, int v2, int v3) [...] // Inlined contents

    private static int paint2BitPixelCodeString(ParsableBitArray parsableBitArray0, int[] arr_v, byte[] arr_b, int v, int v1, Paint paint0, Canvas canvas0) {
        int v3;
        boolean z;
        int v5;
        int v4;
        do {
            int v2 = parsableBitArray0.readBits(2);
            if(v2 == 0) {
                if(parsableBitArray0.readBit()) {
                    v4 = parsableBitArray0.readBits(3) + 3;
                    v5 = parsableBitArray0.readBits(2);
                }
                else if(parsableBitArray0.readBit()) {
                    z = false;
                    v3 = 1;
                    v2 = 0;
                    goto label_35;
                }
                else {
                    switch(parsableBitArray0.readBits(2)) {
                        case 0: {
                            z = true;
                            v2 = 0;
                            v3 = 0;
                            goto label_35;
                        }
                        case 1: {
                            z = false;
                            v3 = 2;
                            v2 = 0;
                            goto label_35;
                        }
                        case 2: {
                            v4 = parsableBitArray0.readBits(4) + 12;
                            v5 = parsableBitArray0.readBits(2);
                            break;
                        }
                        case 3: {
                            v4 = parsableBitArray0.readBits(8) + 29;
                            v5 = parsableBitArray0.readBits(2);
                            break;
                        }
                        default: {
                            z = false;
                            v2 = 0;
                            v3 = 0;
                            goto label_35;
                        }
                    }
                }
                z = false;
                v3 = v4;
                v2 = v5;
            }
            else {
                z = false;
                v3 = 1;
            }
        label_35:
            if(v3 != 0 && paint0 != null) {
                if(arr_b != null) {
                    v2 = arr_b[v2];
                }
                paint0.setColor(arr_v[v2]);
                canvas0.drawRect(((float)v), ((float)v1), ((float)(v + v3)), ((float)(v1 + 1)), paint0);
            }
            v += v3;
        }
        while(!z);
        return v;
    }

    private static int paint4BitPixelCodeString(ParsableBitArray parsableBitArray0, int[] arr_v, byte[] arr_b, int v, int v1, Paint paint0, Canvas canvas0) {
        int v6;
        int v5;
        int v3;
        boolean z;
        do {
            int v2 = parsableBitArray0.readBits(4);
            if(v2 != 0) {
                z = false;
                v3 = 1;
            }
            else if(parsableBitArray0.readBit()) {
                if(parsableBitArray0.readBit()) {
                    switch(parsableBitArray0.readBits(2)) {
                        case 0: {
                            z = false;
                            v3 = 1;
                            v2 = 0;
                            goto label_41;
                        }
                        case 1: {
                            v2 = 0;
                            v3 = 2;
                            z = false;
                            goto label_41;
                        }
                        case 2: {
                            v5 = parsableBitArray0.readBits(4) + 9;
                            v6 = parsableBitArray0.readBits(4);
                            break;
                        }
                        case 3: {
                            v5 = parsableBitArray0.readBits(8) + 25;
                            v6 = parsableBitArray0.readBits(4);
                            break;
                        }
                        default: {
                            z = false;
                            v2 = 0;
                            v3 = 0;
                            goto label_41;
                        }
                    }
                }
                else {
                    v5 = parsableBitArray0.readBits(2) + 4;
                    v6 = parsableBitArray0.readBits(4);
                }
                z = false;
                v3 = v5;
                v2 = v6;
            }
            else {
                int v4 = parsableBitArray0.readBits(3);
                if(v4 == 0) {
                    z = true;
                    v2 = 0;
                    v3 = 0;
                }
                else {
                    z = false;
                    v3 = v4 + 2;
                    v2 = 0;
                }
            }
        label_41:
            if(v3 != 0 && paint0 != null) {
                if(arr_b != null) {
                    v2 = arr_b[v2];
                }
                paint0.setColor(arr_v[v2]);
                canvas0.drawRect(((float)v), ((float)v1), ((float)(v + v3)), ((float)(v1 + 1)), paint0);
            }
            v += v3;
        }
        while(!z);
        return v;
    }

    private static int paint8BitPixelCodeString(ParsableBitArray parsableBitArray0, int[] arr_v, byte[] arr_b, int v, int v1, Paint paint0, Canvas canvas0) {
        int v3;
        boolean z;
        do {
            int v2 = parsableBitArray0.readBits(8);
            if(v2 != 0) {
                z = false;
                v3 = 1;
            }
            else if(parsableBitArray0.readBit()) {
                z = false;
                v3 = parsableBitArray0.readBits(7);
                v2 = parsableBitArray0.readBits(8);
            }
            else {
                int v4 = parsableBitArray0.readBits(7);
                if(v4 == 0) {
                    z = true;
                    v2 = 0;
                    v3 = 0;
                }
                else {
                    z = false;
                    v3 = v4;
                    v2 = 0;
                }
            }
            if(v3 != 0 && paint0 != null) {
                if(arr_b != null) {
                    v2 = arr_b[v2];
                }
                paint0.setColor(arr_v[v2]);
                canvas0.drawRect(((float)v), ((float)v1), ((float)(v + v3)), ((float)(v1 + 1)), paint0);
            }
            v += v3;
        }
        while(!z);
        return v;
    }

    private static void paintPixelDataSubBlock(byte[] arr_b, int[] arr_v, int v, int v1, int v2, Paint paint0, Canvas canvas0) {
        byte[] arr_b5;
        byte[] arr_b4;
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(arr_b);
        byte[] arr_b1 = null;
        byte[] arr_b2 = null;
        int v3 = v1;
        int v4 = v2;
        byte[] arr_b3 = null;
        while(parsableBitArray0.bitsLeft() != 0) {
            int v5 = parsableBitArray0.readBits(8);
            if(v5 == 0xF0) {
                v4 += 2;
                v3 = v1;
            }
            else {
                switch(v5) {
                    case 16: {
                        switch(v) {
                            case 2: {
                                arr_b4 = arr_b2 == null ? DvbParser.defaultMap2To4 : arr_b2;
                                break;
                            }
                            case 3: {
                                arr_b4 = arr_b3 == null ? DvbParser.defaultMap2To8 : arr_b3;
                                break;
                            }
                            default: {
                                arr_b4 = null;
                            }
                        }
                        v3 = DvbParser.paint2BitPixelCodeString(parsableBitArray0, arr_v, arr_b4, v3, v4, paint0, canvas0);
                        parsableBitArray0.byteAlign();
                        break;
                    }
                    case 17: {
                        if(v == 3) {
                            arr_b5 = arr_b1 == null ? DvbParser.defaultMap4To8 : arr_b1;
                        }
                        else {
                            arr_b5 = null;
                        }
                        v3 = DvbParser.paint4BitPixelCodeString(parsableBitArray0, arr_v, arr_b5, v3, v4, paint0, canvas0);
                        parsableBitArray0.byteAlign();
                        break;
                    }
                    case 18: {
                        v3 = DvbParser.paint8BitPixelCodeString(parsableBitArray0, arr_v, null, v3, v4, paint0, canvas0);
                        break;
                    }
                    case 0x20: {
                        arr_b2 = DvbParser.buildClutMapTable(4, 4, parsableBitArray0);
                        break;
                    }
                    case 33: {
                        arr_b3 = DvbParser.buildClutMapTable(4, 8, parsableBitArray0);
                        break;
                    }
                    case 34: {
                        arr_b1 = DvbParser.buildClutMapTable(16, 8, parsableBitArray0);
                    }
                }
            }
        }
    }

    private static void paintPixelDataSubBlocks(ObjectData dvbParser$ObjectData0, ClutDefinition dvbParser$ClutDefinition0, int v, int v1, int v2, Paint paint0, Canvas canvas0) {
        int[] arr_v;
        switch(v) {
            case 2: {
                arr_v = dvbParser$ClutDefinition0.clutEntries4Bit;
                break;
            }
            case 3: {
                arr_v = dvbParser$ClutDefinition0.clutEntries8Bit;
                break;
            }
            default: {
                arr_v = dvbParser$ClutDefinition0.clutEntries2Bit;
            }
        }
        DvbParser.paintPixelDataSubBlock(dvbParser$ObjectData0.topFieldData, arr_v, v, v1, v2, paint0, canvas0);
        DvbParser.paintPixelDataSubBlock(dvbParser$ObjectData0.bottomFieldData, arr_v, v, v1, v2 + 1, paint0, canvas0);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray0, int v) {
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        int[] arr_v3;
        int v1 = parsableBitArray0.readBits(8);
        parsableBitArray0.skipBits(8);
        int v2 = v - 2;
        int[] arr_v = DvbParser.generateDefault2BitClutEntries();
        int[] arr_v1 = DvbParser.generateDefault4BitClutEntries();
        int[] arr_v2 = DvbParser.generateDefault8BitClutEntries();
        while(v2 > 0) {
            int v3 = parsableBitArray0.readBits(8);
            int v4 = parsableBitArray0.readBits(8);
            if((v4 & 0x80) == 0) {
                arr_v3 = (v4 & 0x40) == 0 ? arr_v2 : arr_v1;
            }
            else {
                arr_v3 = arr_v;
            }
            if((v4 & 1) == 0) {
                int v10 = parsableBitArray0.readBits(6);
                int v11 = parsableBitArray0.readBits(4);
                v7 = parsableBitArray0.readBits(4) << 4;
                v9 = v2 - 4;
                v8 = parsableBitArray0.readBits(2) << 6;
                v5 = v10 << 2;
                v6 = v11 << 4;
            }
            else {
                v5 = parsableBitArray0.readBits(8);
                v6 = parsableBitArray0.readBits(8);
                v7 = parsableBitArray0.readBits(8);
                v8 = parsableBitArray0.readBits(8);
                v9 = v2 - 6;
            }
            if(v5 == 0) {
                v8 = 0xFF;
                v6 = 0;
                v7 = 0;
            }
            arr_v3[v3] = ((int)(((byte)(~v8 & 0xFF)))) << 24 | Util.constrainValue(((int)(1.402 * ((double)(v6 - 0x80)) + ((double)v5))), 0, 0xFF) << 16 | Util.constrainValue(((int)(((double)v5) - 0.34414 * ((double)(v7 - 0x80)) - ((double)(v6 - 0x80)) * 0.71414)), 0, 0xFF) << 8 | Util.constrainValue(((int)(((double)(v7 - 0x80)) * 1.772 + ((double)v5))), 0, 0xFF);
            v2 = v9;
        }
        return new ClutDefinition(v1, arr_v, arr_v1, arr_v2);
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray0) {
        parsableBitArray0.skipBits(4);
        boolean z = parsableBitArray0.readBit();
        parsableBitArray0.skipBits(3);
        int v = parsableBitArray0.readBits(16);
        int v1 = parsableBitArray0.readBits(16);
        return z ? new DisplayDefinition(v, v1, parsableBitArray0.readBits(16), parsableBitArray0.readBits(16), parsableBitArray0.readBits(16), parsableBitArray0.readBits(16)) : new DisplayDefinition(v, v1, 0, v, 0, v1);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray0) {
        int v = parsableBitArray0.readBits(16);
        parsableBitArray0.skipBits(4);
        int v1 = parsableBitArray0.readBits(2);
        boolean z = parsableBitArray0.readBit();
        parsableBitArray0.skipBits(1);
        byte[] arr_b = null;
        if(v1 == 1) {
            parsableBitArray0.skipBits(parsableBitArray0.readBits(8) * 16);
            return new ObjectData(v, z, null, null);
        }
        if(v1 == 0) {
            int v2 = parsableBitArray0.readBits(16);
            int v3 = parsableBitArray0.readBits(16);
            if(v2 > 0) {
                arr_b = new byte[v2];
                parsableBitArray0.readBytes(arr_b, 0, v2);
            }
            if(v3 > 0) {
                byte[] arr_b1 = new byte[v3];
                parsableBitArray0.readBytes(arr_b1, 0, v3);
                return new ObjectData(v, z, arr_b, arr_b1);
            }
        }
        return new ObjectData(v, z, arr_b, arr_b);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray0, int v) {
        int v1 = parsableBitArray0.readBits(8);
        int v2 = parsableBitArray0.readBits(4);
        int v3 = parsableBitArray0.readBits(2);
        parsableBitArray0.skipBits(2);
        int v4 = v - 2;
        SparseArray sparseArray0 = new SparseArray();
        while(v4 > 0) {
            int v5 = parsableBitArray0.readBits(8);
            parsableBitArray0.skipBits(8);
            v4 -= 6;
            sparseArray0.put(v5, new PageRegion(parsableBitArray0.readBits(16), parsableBitArray0.readBits(16)));
        }
        return new PageComposition(v1, v2, v3, sparseArray0);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray0, int v) {
        int v17;
        int v16;
        int v1 = parsableBitArray0.readBits(8);
        parsableBitArray0.skipBits(4);
        boolean z = parsableBitArray0.readBit();
        parsableBitArray0.skipBits(3);
        int v2 = parsableBitArray0.readBits(16);
        int v3 = parsableBitArray0.readBits(16);
        int v4 = parsableBitArray0.readBits(3);
        int v5 = parsableBitArray0.readBits(3);
        parsableBitArray0.skipBits(2);
        int v6 = parsableBitArray0.readBits(8);
        int v7 = parsableBitArray0.readBits(8);
        int v8 = parsableBitArray0.readBits(4);
        int v9 = parsableBitArray0.readBits(2);
        parsableBitArray0.skipBits(2);
        int v10 = v - 10;
        SparseArray sparseArray0 = new SparseArray();
        while(v10 > 0) {
            int v11 = parsableBitArray0.readBits(16);
            int v12 = parsableBitArray0.readBits(2);
            int v13 = parsableBitArray0.readBits(2);
            int v14 = parsableBitArray0.readBits(12);
            parsableBitArray0.skipBits(4);
            int v15 = parsableBitArray0.readBits(12);
            if(v12 == 1 || v12 == 2) {
                v10 -= 8;
                v16 = parsableBitArray0.readBits(8);
                v17 = parsableBitArray0.readBits(8);
            }
            else {
                v16 = 0;
                v17 = 0;
                v10 -= 6;
            }
            sparseArray0.put(v11, new RegionObject(v12, v13, v14, v15, v16, v17));
        }
        return new RegionComposition(v1, z, v2, v3, v4, v5, v6, v7, v8, v9, sparseArray0);
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray0, SubtitleService dvbParser$SubtitleService0) {
        int v = parsableBitArray0.readBits(8);
        int v1 = parsableBitArray0.readBits(16);
        int v2 = parsableBitArray0.readBits(16);
        int v3 = parsableBitArray0.getBytePosition();
        if(v2 * 8 > parsableBitArray0.bitsLeft()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            parsableBitArray0.skipBits(parsableBitArray0.bitsLeft());
            return;
        }
        switch(v) {
            case 16: {
                if(v1 == dvbParser$SubtitleService0.subtitlePageId) {
                    PageComposition dvbParser$PageComposition0 = dvbParser$SubtitleService0.pageComposition;
                    PageComposition dvbParser$PageComposition1 = DvbParser.parsePageComposition(parsableBitArray0, v2);
                    if(dvbParser$PageComposition1.state != 0) {
                        dvbParser$SubtitleService0.pageComposition = dvbParser$PageComposition1;
                        dvbParser$SubtitleService0.regions.clear();
                        dvbParser$SubtitleService0.cluts.clear();
                        dvbParser$SubtitleService0.objects.clear();
                    }
                    else if(dvbParser$PageComposition0 != null && dvbParser$PageComposition0.version != dvbParser$PageComposition1.version) {
                        dvbParser$SubtitleService0.pageComposition = dvbParser$PageComposition1;
                    }
                }
                break;
            }
            case 17: {
                PageComposition dvbParser$PageComposition2 = dvbParser$SubtitleService0.pageComposition;
                if(v1 == dvbParser$SubtitleService0.subtitlePageId && dvbParser$PageComposition2 != null) {
                    RegionComposition dvbParser$RegionComposition0 = DvbParser.parseRegionComposition(parsableBitArray0, v2);
                    if(dvbParser$PageComposition2.state == 0) {
                        RegionComposition dvbParser$RegionComposition1 = (RegionComposition)dvbParser$SubtitleService0.regions.get(dvbParser$RegionComposition0.id);
                        if(dvbParser$RegionComposition1 != null) {
                            dvbParser$RegionComposition0.mergeFrom(dvbParser$RegionComposition1);
                        }
                    }
                    dvbParser$SubtitleService0.regions.put(dvbParser$RegionComposition0.id, dvbParser$RegionComposition0);
                }
                break;
            }
            case 18: {
                if(v1 == dvbParser$SubtitleService0.subtitlePageId) {
                    ClutDefinition dvbParser$ClutDefinition0 = DvbParser.parseClutDefinition(parsableBitArray0, v2);
                    dvbParser$SubtitleService0.cluts.put(dvbParser$ClutDefinition0.id, dvbParser$ClutDefinition0);
                }
                else if(v1 == dvbParser$SubtitleService0.ancillaryPageId) {
                    ClutDefinition dvbParser$ClutDefinition1 = DvbParser.parseClutDefinition(parsableBitArray0, v2);
                    dvbParser$SubtitleService0.ancillaryCluts.put(dvbParser$ClutDefinition1.id, dvbParser$ClutDefinition1);
                }
                break;
            }
            case 19: {
                if(v1 == dvbParser$SubtitleService0.subtitlePageId) {
                    ObjectData dvbParser$ObjectData0 = DvbParser.parseObjectData(parsableBitArray0);
                    dvbParser$SubtitleService0.objects.put(dvbParser$ObjectData0.id, dvbParser$ObjectData0);
                }
                else if(v1 == dvbParser$SubtitleService0.ancillaryPageId) {
                    ObjectData dvbParser$ObjectData1 = DvbParser.parseObjectData(parsableBitArray0);
                    dvbParser$SubtitleService0.ancillaryObjects.put(dvbParser$ObjectData1.id, dvbParser$ObjectData1);
                }
                break;
            }
            case 20: {
                if(v1 == dvbParser$SubtitleService0.subtitlePageId) {
                    dvbParser$SubtitleService0.displayDefinition = DvbParser.parseDisplayDefinition(parsableBitArray0);
                }
            }
        }
        parsableBitArray0.skipBytes(v3 + v2 - parsableBitArray0.getBytePosition());
    }

    public void reset() {
        this.subtitleService.reset();
    }
}

