package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.zip.Inflater;

public final class ProjectionDecoder {
    private static final int MAX_COORDINATE_COUNT = 10000;
    private static final int MAX_TRIANGLE_INDICES = 0x1F400;
    private static final int MAX_VERTEX_COUNT = 32000;
    private static final int TYPE_DFL8 = 0x64666C38;
    private static final int TYPE_MESH = 0x6D657368;
    private static final int TYPE_MSHP = 0x6D736870;
    private static final int TYPE_PROJ = 0x70726F6A;
    private static final int TYPE_RAW = 0x72617720;
    private static final int TYPE_YTMP = 0x79746D70;

    public static Projection decode(byte[] arr_b, int v) {
        ArrayList arrayList0;
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b);
        try {
            arrayList0 = ProjectionDecoder.isProj(parsableByteArray0) ? ProjectionDecoder.parseProj(parsableByteArray0) : ProjectionDecoder.parseMshp(parsableByteArray0);
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            arrayList0 = null;
        }
        if(arrayList0 == null) {
            return null;
        }
        switch(arrayList0.size()) {
            case 1: {
                return new Projection(((Mesh)arrayList0.get(0)), v);
            }
            case 2: {
                return new Projection(((Mesh)arrayList0.get(0)), ((Mesh)arrayList0.get(1)), v);
            }
            default: {
                return null;
            }
        }
    }

    private static int decodeZigZag(int v) {
        return -(v & 1) ^ v >> 1;
    }

    private static boolean isProj(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.skipBytes(4);
        int v = parsableByteArray0.readInt();
        parsableByteArray0.setPosition(0);
        return v == 0x70726F6A;
    }

    private static Mesh parseMesh(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readInt();
        if(v > 10000) {
            return null;
        }
        float[] arr_f = new float[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_f[v1] = parsableByteArray0.readFloat();
        }
        int v2 = parsableByteArray0.readInt();
        if(v2 > 32000) {
            return null;
        }
        int v3 = (int)Math.ceil(Math.log(((double)v) * 2.0) / 0.693147);
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(parsableByteArray0.data);
        parsableBitArray0.setPosition(parsableByteArray0.getPosition() * 8);
        float[] arr_f1 = new float[v2 * 5];
        int[] arr_v = new int[5];
        int v4 = 0;
        int v5 = 0;
        while(v4 < v2) {
            int v6 = 0;
            while(v6 < 5) {
                int v7 = arr_v[v6] + ProjectionDecoder.decodeZigZag(parsableBitArray0.readBits(v3));
                if(v7 < v && v7 >= 0) {
                    arr_f1[v5] = arr_f[v7];
                    arr_v[v6] = v7;
                    ++v6;
                    ++v5;
                    continue;
                }
                return null;
            }
            ++v4;
        }
        parsableBitArray0.setPosition(parsableBitArray0.getPosition() + 7 & -8);
        int v8 = parsableBitArray0.readBits(0x20);
        SubMesh[] arr_projection$SubMesh = new SubMesh[v8];
        int v9 = 0;
        while(v9 < v8) {
            int v10 = parsableBitArray0.readBits(8);
            int v11 = parsableBitArray0.readBits(8);
            int v12 = parsableBitArray0.readBits(0x20);
            if(v12 > 0x1F400) {
                return null;
            }
            int v13 = (int)Math.ceil(Math.log(((double)v2) * 2.0) / 0.693147);
            float[] arr_f2 = new float[v12 * 3];
            float[] arr_f3 = new float[v12 * 2];
            int v14 = 0;
            int v15 = 0;
            while(v14 < v12) {
                int v16 = v15 + ProjectionDecoder.decodeZigZag(parsableBitArray0.readBits(v13));
                if(v16 >= 0 && v16 < v2) {
                    arr_f2[v14 * 3] = arr_f1[v16 * 5];
                    arr_f2[v14 * 3 + 1] = arr_f1[v16 * 5 + 1];
                    arr_f2[v14 * 3 + 2] = arr_f1[v16 * 5 + 2];
                    arr_f3[v14 * 2] = arr_f1[v16 * 5 + 3];
                    arr_f3[v14 * 2 + 1] = arr_f1[v16 * 5 + 4];
                    ++v14;
                    v15 = v16;
                    continue;
                }
                return null;
            }
            arr_projection$SubMesh[v9] = new SubMesh(v10, arr_f2, arr_f3, v11);
            ++v9;
        }
        return new Mesh(arr_projection$SubMesh);
    }

    private static ArrayList parseMshp(ParsableByteArray parsableByteArray0) {
        if(parsableByteArray0.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray0.skipBytes(7);
        int v = parsableByteArray0.readInt();
        if(v == 0x64666C38) {
            ParsableByteArray parsableByteArray1 = new ParsableByteArray();
            Inflater inflater0 = new Inflater(true);
            try {
                if(!Util.inflate(parsableByteArray0, parsableByteArray1, inflater0)) {
                    return null;
                }
            }
            finally {
                inflater0.end();
            }
            return ProjectionDecoder.parseRawMshpData(parsableByteArray1);
        }
        return v == 0x72617720 ? ProjectionDecoder.parseRawMshpData(parsableByteArray0) : null;
    }

    private static ArrayList parseProj(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.skipBytes(8);
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        while(v < v1) {
            int v2 = parsableByteArray0.readInt() + v;
            if(v2 <= v || v2 > v1) {
                break;
            }
            switch(parsableByteArray0.readInt()) {
                case 0x6D736870: 
                case 0x79746D70: {
                    parsableByteArray0.setLimit(v2);
                    return ProjectionDecoder.parseMshp(parsableByteArray0);
                }
            }
            parsableByteArray0.setPosition(v2);
            v = v2;
        }
        return null;
    }

    private static ArrayList parseRawMshpData(ParsableByteArray parsableByteArray0) {
        ArrayList arrayList0 = new ArrayList();
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        while(v < v1) {
            int v2 = parsableByteArray0.readInt() + v;
            if(v2 > v && v2 <= v1) {
                if(parsableByteArray0.readInt() == 0x6D657368) {
                    Mesh projection$Mesh0 = ProjectionDecoder.parseMesh(parsableByteArray0);
                    if(projection$Mesh0 == null) {
                        return null;
                    }
                    arrayList0.add(projection$Mesh0);
                }
                parsableByteArray0.setPosition(v2);
                v = v2;
                continue;
            }
            return null;
        }
        return arrayList0;
    }
}

