package com.google.android.exoplayer2.extractor.mp4;

import b3.Z;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class PsshAtomUtil {
    static class PsshAtom {
        private final byte[] schemeData;
        private final UUID uuid;
        private final int version;

        public PsshAtom(UUID uUID0, int v, byte[] arr_b) {
            this.uuid = uUID0;
            this.version = v;
            this.schemeData = arr_b;
        }

        public static UUID access$000(PsshAtom psshAtomUtil$PsshAtom0) {
            return psshAtomUtil$PsshAtom0.uuid;
        }

        public static int access$100(PsshAtom psshAtomUtil$PsshAtom0) {
            return psshAtomUtil$PsshAtom0.version;
        }

        public static byte[] access$200(PsshAtom psshAtomUtil$PsshAtom0) {
            return psshAtomUtil$PsshAtom0.schemeData;
        }
    }

    private static final String TAG = "PsshAtomUtil";

    public static byte[] buildPsshAtom(UUID uUID0, byte[] arr_b) {
        return PsshAtomUtil.buildPsshAtom(uUID0, null, arr_b);
    }

    public static byte[] buildPsshAtom(UUID uUID0, UUID[] arr_uUID, byte[] arr_b) {
        int v1 = arr_b == null ? 0 : arr_b.length;
        int v2 = arr_uUID == null ? v1 + 0x20 : v1 + 0x20 + (arr_uUID.length * 16 + 4);
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(v2);
        byteBuffer0.putInt(v2);
        byteBuffer0.putInt(0x70737368);
        byteBuffer0.putInt((arr_uUID == null ? 0 : 0x1000000));
        byteBuffer0.putLong(uUID0.getMostSignificantBits());
        byteBuffer0.putLong(uUID0.getLeastSignificantBits());
        if(arr_uUID != null) {
            byteBuffer0.putInt(arr_uUID.length);
            for(int v = 0; v < arr_uUID.length; ++v) {
                UUID uUID1 = arr_uUID[v];
                byteBuffer0.putLong(uUID1.getMostSignificantBits());
                byteBuffer0.putLong(uUID1.getLeastSignificantBits());
            }
        }
        if(arr_b != null && arr_b.length != 0) {
            byteBuffer0.putInt(arr_b.length);
            byteBuffer0.put(arr_b);
        }
        return byteBuffer0.array();
    }

    public static boolean isPsshAtom(byte[] arr_b) {
        return PsshAtomUtil.parsePsshAtom(arr_b) != null;
    }

    private static PsshAtom parsePsshAtom(byte[] arr_b) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b);
        if(parsableByteArray0.limit() < 0x20) {
            return null;
        }
        parsableByteArray0.setPosition(0);
        if(parsableByteArray0.readInt() != parsableByteArray0.bytesLeft() + 4) {
            return null;
        }
        if(parsableByteArray0.readInt() != 0x70737368) {
            return null;
        }
        int v = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
        if(v > 1) {
            Z.q(37, v, "Unsupported pssh version: ", "PsshAtomUtil");
            return null;
        }
        UUID uUID0 = new UUID(parsableByteArray0.readLong(), parsableByteArray0.readLong());
        if(v == 1) {
            parsableByteArray0.skipBytes(parsableByteArray0.readUnsignedIntToInt() * 16);
        }
        int v1 = parsableByteArray0.readUnsignedIntToInt();
        if(v1 != parsableByteArray0.bytesLeft()) {
            return null;
        }
        byte[] arr_b1 = new byte[v1];
        parsableByteArray0.readBytes(arr_b1, 0, v1);
        return new PsshAtom(uUID0, v, arr_b1);
    }

    public static byte[] parseSchemeSpecificData(byte[] arr_b, UUID uUID0) {
        PsshAtom psshAtomUtil$PsshAtom0 = PsshAtomUtil.parsePsshAtom(arr_b);
        if(psshAtomUtil$PsshAtom0 == null) {
            return null;
        }
        if(uUID0 != null && !uUID0.equals(PsshAtom.access$000(psshAtomUtil$PsshAtom0))) {
            String s = String.valueOf(uUID0);
            String s1 = String.valueOf(PsshAtom.access$000(psshAtomUtil$PsshAtom0));
            StringBuilder stringBuilder0 = Z.o(s1.length() + (s.length() + 33), "UUID mismatch. Expected: ", s, ", got: ", s1);
            stringBuilder0.append(".");
            Log.w("PsshAtomUtil", stringBuilder0.toString());
            return null;
        }
        return PsshAtom.access$200(psshAtomUtil$PsshAtom0);
    }

    public static UUID parseUuid(byte[] arr_b) {
        PsshAtom psshAtomUtil$PsshAtom0 = PsshAtomUtil.parsePsshAtom(arr_b);
        return psshAtomUtil$PsshAtom0 == null ? null : PsshAtom.access$000(psshAtomUtil$PsshAtom0);
    }

    public static int parseVersion(byte[] arr_b) {
        PsshAtom psshAtomUtil$PsshAtom0 = PsshAtomUtil.parsePsshAtom(arr_b);
        return psshAtomUtil$PsshAtom0 == null ? -1 : PsshAtom.access$100(psshAtomUtil$PsshAtom0);
    }
}

