package org.apache.http.impl.auth;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
final class NTLMEngineImpl implements NTLMEngine {
    public static class CipherGen {
        protected final byte[] challenge;
        protected byte[] clientChallenge;
        protected byte[] clientChallenge2;
        protected final String domain;
        protected byte[] lanManagerSessionKey;
        protected byte[] lm2SessionResponse;
        protected byte[] lmHash;
        protected byte[] lmResponse;
        protected byte[] lmUserSessionKey;
        protected byte[] lmv2Hash;
        protected byte[] lmv2Response;
        protected byte[] ntlm2SessionResponse;
        protected byte[] ntlm2SessionResponseUserSessionKey;
        protected byte[] ntlmHash;
        protected byte[] ntlmResponse;
        protected byte[] ntlmUserSessionKey;
        protected byte[] ntlmv2Blob;
        protected byte[] ntlmv2Hash;
        protected byte[] ntlmv2Response;
        protected byte[] ntlmv2UserSessionKey;
        protected final String password;
        protected byte[] secondaryKey;
        protected final String target;
        protected final byte[] targetInformation;
        protected byte[] timestamp;
        protected final String user;

        public CipherGen(String s, String s1, String s2, byte[] arr_b, String s3, byte[] arr_b1) {
            this(s, s1, s2, arr_b, s3, arr_b1, null, null, null, null);
        }

        public CipherGen(String s, String s1, String s2, byte[] arr_b, String s3, byte[] arr_b1, byte[] arr_b2, byte[] arr_b3, byte[] arr_b4, byte[] arr_b5) {
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.domain = s;
            this.target = s3;
            this.user = s1;
            this.password = s2;
            this.challenge = arr_b;
            this.targetInformation = arr_b1;
            this.clientChallenge = arr_b2;
            this.clientChallenge2 = arr_b3;
            this.secondaryKey = arr_b4;
            this.timestamp = arr_b5;
        }

        public byte[] getClientChallenge() {
            if(this.clientChallenge == null) {
                this.clientChallenge = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() {
            if(this.clientChallenge2 == null) {
                this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge2;
        }

        public byte[] getLM2SessionResponse() {
            if(this.lm2SessionResponse == null) {
                byte[] arr_b = this.getClientChallenge();
                byte[] arr_b1 = new byte[24];
                this.lm2SessionResponse = arr_b1;
                System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
                Arrays.fill(this.lm2SessionResponse, arr_b.length, this.lm2SessionResponse.length, 0);
            }
            return this.lm2SessionResponse;
        }

        public byte[] getLMHash() {
            if(this.lmHash == null) {
                this.lmHash = NTLMEngineImpl.lmHash(this.password);
            }
            return this.lmHash;
        }

        public byte[] getLMResponse() {
            if(this.lmResponse == null) {
                this.lmResponse = NTLMEngineImpl.lmResponse(this.getLMHash(), this.challenge);
            }
            return this.lmResponse;
        }

        public byte[] getLMUserSessionKey() {
            if(this.lmUserSessionKey == null) {
                this.lmUserSessionKey = new byte[16];
                System.arraycopy(this.getLMHash(), 0, this.lmUserSessionKey, 0, 8);
                Arrays.fill(this.lmUserSessionKey, 8, 16, 0);
            }
            return this.lmUserSessionKey;
        }

        public byte[] getLMv2Hash() {
            if(this.lmv2Hash == null) {
                byte[] arr_b = this.getNTLMHash();
                this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, arr_b);
            }
            return this.lmv2Hash;
        }

        public byte[] getLMv2Response() {
            if(this.lmv2Response == null) {
                byte[] arr_b = this.getLMv2Hash();
                byte[] arr_b1 = this.getClientChallenge();
                this.lmv2Response = NTLMEngineImpl.lmv2Response(arr_b, this.challenge, arr_b1);
            }
            return this.lmv2Response;
        }

        public byte[] getLanManagerSessionKey() {
            if(this.lanManagerSessionKey == null) {
                try {
                    byte[] arr_b = new byte[14];
                    System.arraycopy(this.getLMHash(), 0, arr_b, 0, 8);
                    Arrays.fill(arr_b, 8, 14, -67);
                    Key key0 = NTLMEngineImpl.createDESKey(arr_b, 0);
                    Key key1 = NTLMEngineImpl.createDESKey(arr_b, 7);
                    byte[] arr_b1 = new byte[8];
                    System.arraycopy(this.getLMResponse(), 0, arr_b1, 0, 8);
                    Cipher cipher0 = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher0.init(1, key0);
                    byte[] arr_b2 = cipher0.doFinal(arr_b1);
                    Cipher cipher1 = Cipher.getInstance("DES/ECB/NoPadding");
                    cipher1.init(1, key1);
                    byte[] arr_b3 = cipher1.doFinal(arr_b1);
                    byte[] arr_b4 = new byte[16];
                    this.lanManagerSessionKey = arr_b4;
                    System.arraycopy(arr_b2, 0, arr_b4, 0, arr_b2.length);
                    System.arraycopy(arr_b3, 0, this.lanManagerSessionKey, arr_b2.length, arr_b3.length);
                    return this.lanManagerSessionKey;
                }
                catch(Exception exception0) {
                    throw new NTLMEngineException(exception0.getMessage(), exception0);
                }
            }
            return this.lanManagerSessionKey;
        }

        public byte[] getNTLM2SessionResponse() {
            if(this.ntlm2SessionResponse == null) {
                byte[] arr_b = this.getNTLMHash();
                byte[] arr_b1 = this.getClientChallenge();
                this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(arr_b, this.challenge, arr_b1);
            }
            return this.ntlm2SessionResponse;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() {
            if(this.ntlm2SessionResponseUserSessionKey == null) {
                byte[] arr_b = this.getLM2SessionResponse();
                byte[] arr_b1 = new byte[this.challenge.length + arr_b.length];
                System.arraycopy(this.challenge, 0, arr_b1, 0, this.challenge.length);
                System.arraycopy(arr_b, 0, arr_b1, this.challenge.length, arr_b.length);
                this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(arr_b1, this.getNTLMUserSessionKey());
            }
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getNTLMHash() {
            if(this.ntlmHash == null) {
                this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
            }
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() {
            if(this.ntlmResponse == null) {
                this.ntlmResponse = NTLMEngineImpl.lmResponse(this.getNTLMHash(), this.challenge);
            }
            return this.ntlmResponse;
        }

        public byte[] getNTLMUserSessionKey() {
            if(this.ntlmUserSessionKey == null) {
                MD4 nTLMEngineImpl$MD40 = new MD4();
                nTLMEngineImpl$MD40.update(this.getNTLMHash());
                this.ntlmUserSessionKey = nTLMEngineImpl$MD40.getOutput();
            }
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2Blob() {
            if(this.ntlmv2Blob == null) {
                byte[] arr_b = this.getClientChallenge2();
                byte[] arr_b1 = this.getTimestamp();
                this.ntlmv2Blob = NTLMEngineImpl.createBlob(arr_b, this.targetInformation, arr_b1);
            }
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Hash() {
            if(this.ntlmv2Hash == null) {
                byte[] arr_b = this.getNTLMHash();
                this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, arr_b);
            }
            return this.ntlmv2Hash;
        }

        public byte[] getNTLMv2Response() {
            if(this.ntlmv2Response == null) {
                byte[] arr_b = this.getNTLMv2Hash();
                byte[] arr_b1 = this.getNTLMv2Blob();
                this.ntlmv2Response = NTLMEngineImpl.lmv2Response(arr_b, this.challenge, arr_b1);
            }
            return this.ntlmv2Response;
        }

        public byte[] getNTLMv2UserSessionKey() {
            if(this.ntlmv2UserSessionKey == null) {
                byte[] arr_b = this.getNTLMv2Hash();
                byte[] arr_b1 = new byte[16];
                System.arraycopy(this.getNTLMv2Response(), 0, arr_b1, 0, 16);
                this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(arr_b1, arr_b);
            }
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getSecondaryKey() {
            if(this.secondaryKey == null) {
                this.secondaryKey = new byte[]{-106, 66, 35, 0x4F, -81, -74, 23, -35, (byte)0x80, 73, -24, 66, (byte)0xD0, 38, 0x3F, -50};
            }
            return this.secondaryKey;
        }

        public byte[] getTimestamp() {
            if(this.timestamp == null) {
                long v = (System.currentTimeMillis() + 11644473600000L) * 10000L;
                this.timestamp = new byte[8];
                for(int v1 = 0; v1 < 8; ++v1) {
                    this.timestamp[v1] = (byte)(((int)v));
                    v >>>= 8;
                }
            }
            return this.timestamp;
        }
    }

    static class HMACMD5 {
        protected byte[] ipad;
        protected MessageDigest md5;
        protected byte[] opad;

        public HMACMD5(byte[] arr_b) {
            int v;
            MessageDigest messageDigest0;
            try {
                messageDigest0 = MessageDigest.getInstance("MD5");
                this.md5 = messageDigest0;
                this.ipad = new byte[0x40];
                this.opad = new byte[0x40];
                v = arr_b.length;
            }
            catch(Exception exception0) {
                throw new NTLMEngineException("Error getting md5 message digest implementation: " + exception0.getMessage(), exception0);
            }
            if(v > 0x40) {
                messageDigest0.update(arr_b);
                arr_b = this.md5.digest();
                v = arr_b.length;
            }
            int v1;
            for(v1 = 0; v1 < v; ++v1) {
                this.ipad[v1] = (byte)(54 ^ arr_b[v1]);
                this.opad[v1] = (byte)(92 ^ arr_b[v1]);
            }
            while(v1 < 0x40) {
                this.ipad[v1] = 54;
                this.opad[v1] = 92;
                ++v1;
            }
            this.md5.reset();
            this.md5.update(this.ipad);
        }

        public byte[] getOutput() {
            byte[] arr_b = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(arr_b);
        }

        public void update(byte[] arr_b) {
            this.md5.update(arr_b);
        }

        public void update(byte[] arr_b, int v, int v1) {
            this.md5.update(arr_b, v, v1);
        }
    }

    static class MD4 {
        protected int A;
        protected int B;
        protected int C;
        protected int D;
        protected long count;
        protected byte[] dataBuffer;

        public MD4() {
            this.A = 0x67452301;
            this.B = 0xEFCDAB89;
            this.C = 0x98BADCFE;
            this.D = 0x10325476;
            this.count = 0L;
            this.dataBuffer = new byte[0x40];
        }

        public byte[] getOutput() [...] // 潜在的解密器

        public void processBuffer() {
            int[] arr_v = new int[16];
            for(int v = 0; v < 16; ++v) {
                arr_v[v] = (this.dataBuffer[v * 4] & 0xFF) + ((this.dataBuffer[v * 4 + 1] & 0xFF) << 8) + ((this.dataBuffer[v * 4 + 2] & 0xFF) << 16) + ((this.dataBuffer[v * 4 + 3] & 0xFF) << 24);
            }
            int v1 = this.A;
            int v2 = this.B;
            int v3 = this.C;
            int v4 = this.D;
            this.round1(arr_v);
            this.round2(arr_v);
            this.round3(arr_v);
            this.A += v1;
            this.B += v2;
            this.C += v3;
            this.D += v4;
        }

        public void round1(int[] arr_v) {
            int v = NTLMEngineImpl.rotintlft(this.A + (~this.B & this.D | this.C & this.B) + arr_v[0], 3);
            this.A = v;
            int v1 = NTLMEngineImpl.rotintlft(this.D + (~v & this.C | this.B & v) + arr_v[1], 7);
            this.D = v1;
            int v2 = NTLMEngineImpl.rotintlft(this.C + (~v1 & this.B | this.A & v1) + arr_v[2], 11);
            this.C = v2;
            int v3 = NTLMEngineImpl.rotintlft(this.B + (~v2 & this.A | this.D & v2) + arr_v[3], 19);
            this.B = v3;
            int v4 = NTLMEngineImpl.rotintlft(this.A + (~v3 & this.D | this.C & v3) + arr_v[4], 3);
            this.A = v4;
            int v5 = NTLMEngineImpl.rotintlft(this.D + (~v4 & this.C | this.B & v4) + arr_v[5], 7);
            this.D = v5;
            int v6 = NTLMEngineImpl.rotintlft(this.C + (~v5 & this.B | this.A & v5) + arr_v[6], 11);
            this.C = v6;
            int v7 = NTLMEngineImpl.rotintlft(this.B + (~v6 & this.A | this.D & v6) + arr_v[7], 19);
            this.B = v7;
            int v8 = NTLMEngineImpl.rotintlft(this.A + (~v7 & this.D | this.C & v7) + arr_v[8], 3);
            this.A = v8;
            int v9 = NTLMEngineImpl.rotintlft(this.D + (~v8 & this.C | this.B & v8) + arr_v[9], 7);
            this.D = v9;
            int v10 = NTLMEngineImpl.rotintlft(this.C + (~v9 & this.B | this.A & v9) + arr_v[10], 11);
            this.C = v10;
            int v11 = NTLMEngineImpl.rotintlft(this.B + (~v10 & this.A | this.D & v10) + arr_v[11], 19);
            this.B = v11;
            int v12 = NTLMEngineImpl.rotintlft(this.A + (~v11 & this.D | this.C & v11) + arr_v[12], 3);
            this.A = v12;
            int v13 = NTLMEngineImpl.rotintlft(this.D + (~v12 & this.C | this.B & v12) + arr_v[13], 7);
            this.D = v13;
            int v14 = NTLMEngineImpl.rotintlft(this.C + (~v13 & this.B | this.A & v13) + arr_v[14], 11);
            this.C = v14;
            this.B = NTLMEngineImpl.rotintlft(this.B + (~v14 & this.A | this.D & v14) + arr_v[15], 19);
        }

        public void round2(int[] arr_v) {
            int v = NTLMEngineImpl.rotintlft(this.A + (this.B & (this.C | this.D) | this.C & this.D) + arr_v[0] + 1518500249, 3);
            this.A = v;
            int v1 = NTLMEngineImpl.rotintlft(this.D + (v & (this.B | this.C) | this.B & this.C) + arr_v[4] + 1518500249, 5);
            this.D = v1;
            int v2 = NTLMEngineImpl.rotintlft(this.C + (v1 & (this.A | this.B) | this.A & this.B) + arr_v[8] + 1518500249, 9);
            this.C = v2;
            int v3 = NTLMEngineImpl.rotintlft(this.B + (v2 & (this.D | this.A) | this.D & this.A) + arr_v[12] + 1518500249, 13);
            this.B = v3;
            int v4 = NTLMEngineImpl.rotintlft(this.A + (v3 & (this.C | this.D) | this.C & this.D) + arr_v[1] + 1518500249, 3);
            this.A = v4;
            int v5 = NTLMEngineImpl.rotintlft(this.D + (v4 & (this.B | this.C) | this.B & this.C) + arr_v[5] + 1518500249, 5);
            this.D = v5;
            int v6 = NTLMEngineImpl.rotintlft(this.C + (v5 & (this.A | this.B) | this.A & this.B) + arr_v[9] + 1518500249, 9);
            this.C = v6;
            int v7 = NTLMEngineImpl.rotintlft(this.B + (v6 & (this.D | this.A) | this.D & this.A) + arr_v[13] + 1518500249, 13);
            this.B = v7;
            int v8 = NTLMEngineImpl.rotintlft(this.A + (v7 & (this.C | this.D) | this.C & this.D) + arr_v[2] + 1518500249, 3);
            this.A = v8;
            int v9 = NTLMEngineImpl.rotintlft(this.D + (v8 & (this.B | this.C) | this.B & this.C) + arr_v[6] + 1518500249, 5);
            this.D = v9;
            int v10 = NTLMEngineImpl.rotintlft(this.C + (v9 & (this.A | this.B) | this.A & this.B) + arr_v[10] + 1518500249, 9);
            this.C = v10;
            int v11 = NTLMEngineImpl.rotintlft(this.B + (v10 & (this.D | this.A) | this.D & this.A) + arr_v[14] + 1518500249, 13);
            this.B = v11;
            int v12 = NTLMEngineImpl.rotintlft(this.A + (v11 & (this.C | this.D) | this.C & this.D) + arr_v[3] + 1518500249, 3);
            this.A = v12;
            int v13 = NTLMEngineImpl.rotintlft(this.D + (v12 & (this.B | this.C) | this.B & this.C) + arr_v[7] + 1518500249, 5);
            this.D = v13;
            int v14 = NTLMEngineImpl.rotintlft(this.C + (v13 & (this.A | this.B) | this.A & this.B) + arr_v[11] + 1518500249, 9);
            this.C = v14;
            this.B = NTLMEngineImpl.rotintlft(this.B + (v14 & (this.D | this.A) | this.D & this.A) + arr_v[15] + 1518500249, 13);
        }

        public void round3(int[] arr_v) {
            int v = NTLMEngineImpl.rotintlft(this.A + (this.B ^ this.C ^ this.D) + arr_v[0] + 0x6ED9EBA1, 3);
            this.A = v;
            int v1 = NTLMEngineImpl.rotintlft(this.D + (v ^ this.B ^ this.C) + arr_v[8] + 0x6ED9EBA1, 9);
            this.D = v1;
            int v2 = NTLMEngineImpl.rotintlft(this.C + (v1 ^ this.A ^ this.B) + arr_v[4] + 0x6ED9EBA1, 11);
            this.C = v2;
            int v3 = NTLMEngineImpl.rotintlft(this.B + (v2 ^ this.D ^ this.A) + arr_v[12] + 0x6ED9EBA1, 15);
            this.B = v3;
            int v4 = NTLMEngineImpl.rotintlft(this.A + (v3 ^ this.C ^ this.D) + arr_v[2] + 0x6ED9EBA1, 3);
            this.A = v4;
            int v5 = NTLMEngineImpl.rotintlft(this.D + (v4 ^ this.B ^ this.C) + arr_v[10] + 0x6ED9EBA1, 9);
            this.D = v5;
            int v6 = NTLMEngineImpl.rotintlft(this.C + (v5 ^ this.A ^ this.B) + arr_v[6] + 0x6ED9EBA1, 11);
            this.C = v6;
            int v7 = NTLMEngineImpl.rotintlft(this.B + (v6 ^ this.D ^ this.A) + arr_v[14] + 0x6ED9EBA1, 15);
            this.B = v7;
            int v8 = NTLMEngineImpl.rotintlft(this.A + (v7 ^ this.C ^ this.D) + arr_v[1] + 0x6ED9EBA1, 3);
            this.A = v8;
            int v9 = NTLMEngineImpl.rotintlft(this.D + (v8 ^ this.B ^ this.C) + arr_v[9] + 0x6ED9EBA1, 9);
            this.D = v9;
            int v10 = NTLMEngineImpl.rotintlft(this.C + (v9 ^ this.A ^ this.B) + arr_v[5] + 0x6ED9EBA1, 11);
            this.C = v10;
            int v11 = NTLMEngineImpl.rotintlft(this.B + (v10 ^ this.D ^ this.A) + arr_v[13] + 0x6ED9EBA1, 15);
            this.B = v11;
            int v12 = NTLMEngineImpl.rotintlft(this.A + (v11 ^ this.C ^ this.D) + arr_v[3] + 0x6ED9EBA1, 3);
            this.A = v12;
            int v13 = NTLMEngineImpl.rotintlft(this.D + (v12 ^ this.B ^ this.C) + arr_v[11] + 0x6ED9EBA1, 9);
            this.D = v13;
            int v14 = NTLMEngineImpl.rotintlft(this.C + (v13 ^ this.A ^ this.B) + arr_v[7] + 0x6ED9EBA1, 11);
            this.C = v14;
            this.B = NTLMEngineImpl.rotintlft(this.B + (v14 ^ this.D ^ this.A) + arr_v[15] + 0x6ED9EBA1, 15);
        }

        public void update(byte[] arr_b) {
            byte[] arr_b1;
            int v = (int)(this.count & 0x3FL);
            int v1 = 0;
            while(true) {
                arr_b1 = this.dataBuffer;
                if(arr_b.length - v1 + v < arr_b1.length) {
                    break;
                }
                int v2 = arr_b1.length - v;
                System.arraycopy(arr_b, v1, arr_b1, v, v2);
                this.count += (long)v2;
                v1 += v2;
                this.processBuffer();
                v = 0;
            }
            if(v1 < arr_b.length) {
                int v3 = arr_b.length - v1;
                System.arraycopy(arr_b, v1, arr_b1, v, v3);
                this.count += (long)v3;
            }
        }
    }

    static class NTLMMessage {
        private int currentOutputPosition;
        private byte[] messageContents;

        public NTLMMessage() {
            this.messageContents = null;
            this.currentOutputPosition = 0;
        }

        public NTLMMessage(String s, int v) {
            this.messageContents = null;
            this.currentOutputPosition = 0;
            byte[] arr_b = Base64.decode(EncodingUtils.getBytes(s, "ASCII"), 2);
            this.messageContents = arr_b;
            if(arr_b.length < NTLMEngineImpl.SIGNATURE.length) {
                throw new NTLMEngineException("NTLM message decoding error - packet too short");
            }
            for(int v1 = 0; v1 < NTLMEngineImpl.SIGNATURE.length; ++v1) {
                if(this.messageContents[v1] != NTLMEngineImpl.SIGNATURE[v1]) {
                    throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                }
            }
            int v2 = this.readULong(NTLMEngineImpl.SIGNATURE.length);
            if(v2 != v) {
                throw new NTLMEngineException("NTLM type " + Integer.toString(v) + " message expected - instead got type " + Integer.toString(v2));
            }
            this.currentOutputPosition = this.messageContents.length;
        }

        public void addByte(byte b) {
            int v = this.currentOutputPosition;
            this.messageContents[v] = b;
            this.currentOutputPosition = v + 1;
        }

        public void addBytes(byte[] arr_b) {
            if(arr_b != null) {
                for(int v = 0; v < arr_b.length; ++v) {
                    int v1 = this.currentOutputPosition;
                    this.messageContents[v1] = arr_b[v];
                    this.currentOutputPosition = v1 + 1;
                }
            }
        }

        public void addULong(int v) {
            this.addByte(((byte)(v & 0xFF)));
            this.addByte(((byte)(v >> 8 & 0xFF)));
            this.addByte(((byte)(v >> 16 & 0xFF)));
            this.addByte(((byte)(v >> 24 & 0xFF)));
        }

        public void addUShort(int v) {
            this.addByte(((byte)(v & 0xFF)));
            this.addByte(((byte)(v >> 8 & 0xFF)));
        }

        public int getMessageLength() {
            return this.currentOutputPosition;
        }

        public int getPreambleLength() {
            return NTLMEngineImpl.SIGNATURE.length + 4;
        }

        public String getResponse() {
            byte[] arr_b = this.messageContents;
            int v = this.currentOutputPosition;
            if(arr_b.length > v) {
                byte[] arr_b1 = new byte[v];
                System.arraycopy(arr_b, 0, arr_b1, 0, v);
                arr_b = arr_b1;
            }
            return EncodingUtils.getAsciiString(Base64.encode(arr_b, 2));
        }

        public void prepareResponse(int v, int v1) {
            this.messageContents = new byte[v];
            this.currentOutputPosition = 0;
            this.addBytes(NTLMEngineImpl.SIGNATURE);
            this.addULong(v1);
        }

        public byte readByte(int v) {
            byte[] arr_b = this.messageContents;
            if(arr_b.length < v + 1) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            return arr_b[v];
        }

        public void readBytes(byte[] arr_b, int v) {
            byte[] arr_b1 = this.messageContents;
            if(arr_b1.length < arr_b.length + v) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            System.arraycopy(arr_b1, v, arr_b, 0, arr_b.length);
        }

        public byte[] readSecurityBuffer(int v) {
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, v);
        }

        public int readULong(int v) {
            return NTLMEngineImpl.readULong(this.messageContents, v);
        }

        public int readUShort(int v) {
            return NTLMEngineImpl.readUShort(this.messageContents, v);
        }
    }

    static class Type1Message extends NTLMMessage {
        protected byte[] domainBytes;
        protected byte[] hostBytes;

        public Type1Message(String s, String s1) {
            try {
                byte[] arr_b = null;
                String s2 = NTLMEngineImpl.convertHost(s1);
                String s3 = NTLMEngineImpl.convertDomain(s);
                this.hostBytes = s2 == null ? null : s2.getBytes("ASCII");
                if(s3 != null) {
                    arr_b = s3.toUpperCase(Locale.ENGLISH).getBytes("ASCII");
                }
                this.domainBytes = arr_b;
                return;
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
            }
            throw new NTLMEngineException("Unicode unsupported: " + unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
        }

        @Override  // org.apache.http.impl.auth.NTLMEngineImpl$NTLMMessage
        public String getResponse() {
            this.prepareResponse(40, 1);
            this.addULong(0xA2088201);
            this.addUShort(0);
            this.addUShort(0);
            this.addULong(40);
            this.addUShort(0);
            this.addUShort(0);
            this.addULong(40);
            this.addUShort(0x105);
            this.addULong(2600);
            this.addUShort(0xF00);
            return super.getResponse();
        }
    }

    static class Type2Message extends NTLMMessage {
        protected byte[] challenge;
        protected int flags;
        protected String target;
        protected byte[] targetInfo;

        public Type2Message(String s) {
            super(s, 2);
            byte[] arr_b = new byte[8];
            this.challenge = arr_b;
            this.readBytes(arr_b, 24);
            int v = this.readULong(20);
            this.flags = v;
            if((v & 1) == 0) {
                throw new NTLMEngineException("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.flags));
            }
            this.target = null;
            if(this.getMessageLength() >= 20) {
                byte[] arr_b1 = this.readSecurityBuffer(12);
                if(arr_b1.length != 0) {
                    try {
                        this.target = new String(arr_b1, "UnicodeLittleUnmarked");
                    }
                    catch(UnsupportedEncodingException unsupportedEncodingException0) {
                        throw new NTLMEngineException(unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
                    }
                }
            }
            this.targetInfo = null;
            if(this.getMessageLength() >= 0x30) {
                byte[] arr_b2 = this.readSecurityBuffer(40);
                if(arr_b2.length != 0) {
                    this.targetInfo = arr_b2;
                }
            }
        }

        public byte[] getChallenge() {
            return this.challenge;
        }

        public int getFlags() {
            return this.flags;
        }

        public String getTarget() {
            return this.target;
        }

        public byte[] getTargetInfo() {
            return this.targetInfo;
        }
    }

    static class Type3Message extends NTLMMessage {
        protected byte[] domainBytes;
        protected byte[] hostBytes;
        protected byte[] lmResp;
        protected byte[] ntResp;
        protected byte[] sessionKey;
        protected int type2Flags;
        protected byte[] userBytes;

        public Type3Message(String s, String s1, String s2, String s3, byte[] arr_b, int v, String s4, byte[] arr_b1) {
            byte[] arr_b2;
            this.type2Flags = v;
            String s5 = NTLMEngineImpl.convertHost(s1);
            String s6 = NTLMEngineImpl.convertDomain(s);
            CipherGen nTLMEngineImpl$CipherGen0 = new CipherGen(s6, s2, s3, arr_b, s4, arr_b1);
            try {
                if((0x800000 & v) != 0 && arr_b1 != null && s4 != null) {
                    this.ntResp = nTLMEngineImpl$CipherGen0.getNTLMv2Response();
                    this.lmResp = nTLMEngineImpl$CipherGen0.getLMv2Response();
                    arr_b2 = (v & 0x80) == 0 ? nTLMEngineImpl$CipherGen0.getNTLMv2UserSessionKey() : nTLMEngineImpl$CipherGen0.getLanManagerSessionKey();
                }
                else if((0x80000 & v) != 0) {
                    this.ntResp = nTLMEngineImpl$CipherGen0.getNTLM2SessionResponse();
                    this.lmResp = nTLMEngineImpl$CipherGen0.getLM2SessionResponse();
                    arr_b2 = (v & 0x80) == 0 ? nTLMEngineImpl$CipherGen0.getNTLM2SessionResponseUserSessionKey() : nTLMEngineImpl$CipherGen0.getLanManagerSessionKey();
                }
                else {
                    this.ntResp = nTLMEngineImpl$CipherGen0.getNTLMResponse();
                    this.lmResp = nTLMEngineImpl$CipherGen0.getLMResponse();
                    arr_b2 = (v & 0x80) == 0 ? nTLMEngineImpl$CipherGen0.getNTLMUserSessionKey() : nTLMEngineImpl$CipherGen0.getLanManagerSessionKey();
                }
            }
            catch(NTLMEngineException unused_ex) {
                this.ntResp = new byte[0];
                this.lmResp = nTLMEngineImpl$CipherGen0.getLMResponse();
                arr_b2 = (v & 0x80) == 0 ? nTLMEngineImpl$CipherGen0.getLMUserSessionKey() : nTLMEngineImpl$CipherGen0.getLanManagerSessionKey();
            }
            byte[] arr_b3 = null;
            if((v & 16) == 0) {
                this.sessionKey = null;
            }
            else if((0x40000000 & v) != 0) {
                this.sessionKey = NTLMEngineImpl.RC4(nTLMEngineImpl$CipherGen0.getSecondaryKey(), arr_b2);
            }
            else {
                this.sessionKey = arr_b2;
            }
            try {
                this.hostBytes = s5 == null ? null : s5.getBytes("UnicodeLittleUnmarked");
                if(s6 != null) {
                    arr_b3 = s6.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked");
                }
                this.domainBytes = arr_b3;
                this.userBytes = s2.getBytes("UnicodeLittleUnmarked");
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                throw new NTLMEngineException("Unicode not supported: " + unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
            }
        }

        @Override  // org.apache.http.impl.auth.NTLMEngineImpl$NTLMMessage
        public String getResponse() {
            int v = this.ntResp.length;
            int v1 = this.lmResp.length;
            int v2 = 0;
            int v3 = this.domainBytes == null ? 0 : this.domainBytes.length;
            int v4 = this.hostBytes == null ? 0 : this.hostBytes.length;
            int v5 = this.userBytes.length;
            byte[] arr_b = this.sessionKey;
            if(arr_b != null) {
                v2 = arr_b.length;
            }
            int v6 = v1 + 72 + v;
            int v7 = v6 + v3;
            int v8 = v7 + v5;
            int v9 = v8 + v4;
            this.prepareResponse(v9 + v2, 3);
            this.addUShort(v1);
            this.addUShort(v1);
            this.addULong(72);
            this.addUShort(v);
            this.addUShort(v);
            this.addULong(v1 + 72);
            this.addUShort(v3);
            this.addUShort(v3);
            this.addULong(v6);
            this.addUShort(v5);
            this.addUShort(v5);
            this.addULong(v7);
            this.addUShort(v4);
            this.addUShort(v4);
            this.addULong(v8);
            this.addUShort(v2);
            this.addUShort(v2);
            this.addULong(v9);
            this.addULong(this.type2Flags & 4 | (0x80280 & this.type2Flags | 0x2000000 | 0x8000 & this.type2Flags | this.type2Flags & 0x20 | this.type2Flags & 16 | 0x20000000 & this.type2Flags | 0x80000000 & this.type2Flags | 0x40000000 & this.type2Flags | 0x800000 & this.type2Flags | this.type2Flags & 1));
            this.addUShort(0x105);
            this.addULong(2600);
            this.addUShort(0xF00);
            this.addBytes(this.lmResp);
            this.addBytes(this.ntResp);
            this.addBytes(this.domainBytes);
            this.addBytes(this.userBytes);
            this.addBytes(this.hostBytes);
            byte[] arr_b1 = this.sessionKey;
            if(arr_b1 != null) {
                this.addBytes(arr_b1);
            }
            return super.getResponse();
        }
    }

    static final String DEFAULT_CHARSET = "ASCII";
    protected static final int FLAG_DOMAIN_PRESENT = 0x1000;
    protected static final int FLAG_REQUEST_128BIT_KEY_EXCH = 0x20000000;
    protected static final int FLAG_REQUEST_56BIT_ENCRYPTION = 0x80000000;
    protected static final int FLAG_REQUEST_ALWAYS_SIGN = 0x8000;
    protected static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 0x40000000;
    protected static final int FLAG_REQUEST_LAN_MANAGER_KEY = 0x80;
    protected static final int FLAG_REQUEST_NTLM2_SESSION = 0x80000;
    protected static final int FLAG_REQUEST_NTLMv1 = 0x200;
    protected static final int FLAG_REQUEST_SEAL = 0x20;
    protected static final int FLAG_REQUEST_SIGN = 16;
    protected static final int FLAG_REQUEST_TARGET = 4;
    protected static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    protected static final int FLAG_REQUEST_VERSION = 0x2000000;
    protected static final int FLAG_TARGETINFO_PRESENT = 0x800000;
    protected static final int FLAG_WORKSTATION_PRESENT = 0x2000;
    private static final SecureRandom RND_GEN;
    private static final byte[] SIGNATURE;
    private String credentialCharset;

    static {
        SecureRandom secureRandom0 = null;
        try {
            secureRandom0 = SecureRandom.getInstance("SHA1PRNG");
        }
        catch(Exception unused_ex) {
        }
        NTLMEngineImpl.RND_GEN = secureRandom0;
        byte[] arr_b = EncodingUtils.getBytes("NTLMSSP", "ASCII");
        byte[] arr_b1 = new byte[arr_b.length + 1];
        NTLMEngineImpl.SIGNATURE = arr_b1;
        System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
        arr_b1[arr_b.length] = 0;
    }

    public NTLMEngineImpl() {
        this.credentialCharset = "ASCII";
    }

    public static int F(int v, int v1, int v2) [...] // Inlined contents

    public static int G(int v, int v1, int v2) [...] // Inlined contents

    public static int H(int v, int v1, int v2) [...] // Inlined contents

    public static byte[] RC4(byte[] arr_b, byte[] arr_b1) {
        try {
            Cipher cipher0 = Cipher.getInstance("RC4");
            cipher0.init(1, new SecretKeySpec(arr_b1, "RC4"));
            return cipher0.doFinal(arr_b);
        }
        catch(Exception exception0) {
            throw new NTLMEngineException(exception0.getMessage(), exception0);
        }
    }

    public static byte[] access$100() [...] // 潜在的解密器

    private static String convertDomain(String s) {
        return NTLMEngineImpl.stripDotSuffix(s);
    }

    private static String convertHost(String s) {
        return NTLMEngineImpl.stripDotSuffix(s);
    }

    private static byte[] createBlob(byte[] arr_b, byte[] arr_b1, byte[] arr_b2) {
        byte[] arr_b3 = new byte[arr_b2.length + 20 + arr_b1.length + 4];
        System.arraycopy(new byte[]{1, 1, 0, 0}, 0, arr_b3, 0, 4);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, arr_b3, 4, 4);
        System.arraycopy(arr_b2, 0, arr_b3, 8, arr_b2.length);
        System.arraycopy(arr_b, 0, arr_b3, arr_b2.length + 8, 8);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, arr_b3, arr_b2.length + 16, 4);
        System.arraycopy(arr_b1, 0, arr_b3, arr_b2.length + 20, arr_b1.length);
        System.arraycopy(new byte[]{0, 0, 0, 0}, 0, arr_b3, arr_b2.length + 20 + arr_b1.length, 4);
        return arr_b3;
    }

    private static Key createDESKey(byte[] arr_b, int v) {
        byte[] arr_b1 = new byte[7];
        System.arraycopy(arr_b, v, arr_b1, 0, 7);
        byte[] arr_b2 = {arr_b1[0], ((byte)(arr_b1[0] << 7 | (arr_b1[1] & 0xFF) >>> 1)), ((byte)(arr_b1[1] << 6 | (arr_b1[2] & 0xFF) >>> 2)), ((byte)(arr_b1[2] << 5 | (arr_b1[3] & 0xFF) >>> 3)), ((byte)(arr_b1[3] << 4 | (arr_b1[4] & 0xFF) >>> 4)), ((byte)((arr_b1[5] & 0xFF) >>> 5 | arr_b1[4] << 3)), ((byte)(arr_b1[5] << 2 | (arr_b1[6] & 0xFF) >>> 6)), ((byte)(arr_b1[6] << 1))};
        NTLMEngineImpl.oddParity(arr_b2);
        return new SecretKeySpec(arr_b2, "DES");
    }

    @Override  // org.apache.http.impl.auth.NTLMEngine
    public String generateType1Msg(String s, String s1) {
        return this.getType1Message(s1, s);
    }

    @Override  // org.apache.http.impl.auth.NTLMEngine
    public String generateType3Msg(String s, String s1, String s2, String s3, String s4) {
        Type2Message nTLMEngineImpl$Type2Message0 = new Type2Message(s4);
        return this.getType3Message(s, s1, s3, s2, nTLMEngineImpl$Type2Message0.getChallenge(), nTLMEngineImpl$Type2Message0.getFlags(), nTLMEngineImpl$Type2Message0.getTarget(), nTLMEngineImpl$Type2Message0.getTargetInfo());
    }

    public String getCredentialCharset() {
        return this.credentialCharset;
    }

    public final String getResponseFor(String s, String s1, String s2, String s3, String s4) {
        if(s == null || s.trim().equals("")) {
            return this.getType1Message(s3, s4);
        }
        Type2Message nTLMEngineImpl$Type2Message0 = new Type2Message(s);
        return this.getType3Message(s1, s2, s3, s4, nTLMEngineImpl$Type2Message0.getChallenge(), nTLMEngineImpl$Type2Message0.getFlags(), nTLMEngineImpl$Type2Message0.getTarget(), nTLMEngineImpl$Type2Message0.getTargetInfo());
    }

    public String getType1Message(String s, String s1) {
        return new Type1Message(s1, s).getResponse();
    }

    public String getType3Message(String s, String s1, String s2, String s3, byte[] arr_b, int v, String s4, byte[] arr_b1) {
        return new Type3Message(s3, s2, s, s1, arr_b, v, s4, arr_b1).getResponse();
    }

    public static byte[] hmacMD5(byte[] arr_b, byte[] arr_b1) {
        HMACMD5 nTLMEngineImpl$HMACMD50 = new HMACMD5(arr_b1);
        nTLMEngineImpl$HMACMD50.update(arr_b);
        return nTLMEngineImpl$HMACMD50.getOutput();
    }

    private static byte[] lmHash(String s) {
        try {
            byte[] arr_b = s.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
            byte[] arr_b1 = new byte[14];
            System.arraycopy(arr_b, 0, arr_b1, 0, Math.min(arr_b.length, 14));
            Key key0 = NTLMEngineImpl.createDESKey(arr_b1, 0);
            Key key1 = NTLMEngineImpl.createDESKey(arr_b1, 7);
            byte[] arr_b2 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher cipher0 = Cipher.getInstance("DES/ECB/NoPadding");
            cipher0.init(1, key0);
            byte[] arr_b3 = cipher0.doFinal(arr_b2);
            cipher0.init(1, key1);
            byte[] arr_b4 = cipher0.doFinal(arr_b2);
            byte[] arr_b5 = new byte[16];
            System.arraycopy(arr_b3, 0, arr_b5, 0, 8);
            System.arraycopy(arr_b4, 0, arr_b5, 8, 8);
            return arr_b5;
        }
        catch(Exception exception0) {
            throw new NTLMEngineException(exception0.getMessage(), exception0);
        }
    }

    private static byte[] lmResponse(byte[] arr_b, byte[] arr_b1) {
        try {
            byte[] arr_b2 = new byte[21];
            System.arraycopy(arr_b, 0, arr_b2, 0, 16);
            Key key0 = NTLMEngineImpl.createDESKey(arr_b2, 0);
            Key key1 = NTLMEngineImpl.createDESKey(arr_b2, 7);
            Key key2 = NTLMEngineImpl.createDESKey(arr_b2, 14);
            Cipher cipher0 = Cipher.getInstance("DES/ECB/NoPadding");
            cipher0.init(1, key0);
            byte[] arr_b3 = cipher0.doFinal(arr_b1);
            cipher0.init(1, key1);
            byte[] arr_b4 = cipher0.doFinal(arr_b1);
            cipher0.init(1, key2);
            byte[] arr_b5 = cipher0.doFinal(arr_b1);
            byte[] arr_b6 = new byte[24];
            System.arraycopy(arr_b3, 0, arr_b6, 0, 8);
            System.arraycopy(arr_b4, 0, arr_b6, 8, 8);
            System.arraycopy(arr_b5, 0, arr_b6, 16, 8);
            return arr_b6;
        }
        catch(Exception exception0) {
            throw new NTLMEngineException(exception0.getMessage(), exception0);
        }
    }

    private static byte[] lmv2Hash(String s, String s1, byte[] arr_b) {
        try {
            HMACMD5 nTLMEngineImpl$HMACMD50 = new HMACMD5(arr_b);
            Locale locale0 = Locale.ENGLISH;
            nTLMEngineImpl$HMACMD50.update(s1.toUpperCase(locale0).getBytes("UnicodeLittleUnmarked"));
            if(s != null) {
                nTLMEngineImpl$HMACMD50.update(s.toUpperCase(locale0).getBytes("UnicodeLittleUnmarked"));
            }
            return nTLMEngineImpl$HMACMD50.getOutput();
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new NTLMEngineException("Unicode not supported! " + unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
        }
    }

    private static byte[] lmv2Response(byte[] arr_b, byte[] arr_b1, byte[] arr_b2) {
        HMACMD5 nTLMEngineImpl$HMACMD50 = new HMACMD5(arr_b);
        nTLMEngineImpl$HMACMD50.update(arr_b1);
        nTLMEngineImpl$HMACMD50.update(arr_b2);
        byte[] arr_b3 = nTLMEngineImpl$HMACMD50.getOutput();
        byte[] arr_b4 = new byte[arr_b3.length + arr_b2.length];
        System.arraycopy(arr_b3, 0, arr_b4, 0, arr_b3.length);
        System.arraycopy(arr_b2, 0, arr_b4, arr_b3.length, arr_b2.length);
        return arr_b4;
    }

    private static byte[] makeRandomChallenge() {
        SecureRandom secureRandom0 = NTLMEngineImpl.RND_GEN;
        if(secureRandom0 != null) {
            byte[] arr_b = new byte[8];
            synchronized(secureRandom0) {
                secureRandom0.nextBytes(arr_b);
                return arr_b;
            }
        }
        throw new NTLMEngineException("Random generator not available");
    }

    private static byte[] makeSecondaryKey() {
        SecureRandom secureRandom0 = NTLMEngineImpl.RND_GEN;
        if(secureRandom0 != null) {
            byte[] arr_b = new byte[16];
            synchronized(secureRandom0) {
                secureRandom0.nextBytes(arr_b);
                return arr_b;
            }
        }
        throw new NTLMEngineException("Random generator not available");
    }

    public static byte[] ntlm2SessionResponse(byte[] arr_b, byte[] arr_b1, byte[] arr_b2) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
            messageDigest0.update(arr_b1);
            messageDigest0.update(arr_b2);
            byte[] arr_b3 = messageDigest0.digest();
            byte[] arr_b4 = new byte[8];
            System.arraycopy(arr_b3, 0, arr_b4, 0, 8);
            return NTLMEngineImpl.lmResponse(arr_b, arr_b4);
        }
        catch(Exception exception0) {
            throw exception0 instanceof NTLMEngineException ? ((NTLMEngineException)exception0) : new NTLMEngineException(exception0.getMessage(), exception0);
        }
    }

    private static byte[] ntlmHash(String s) {
        try {
            byte[] arr_b = s.getBytes("UnicodeLittleUnmarked");
            new MD4().update(arr_b);
            return new byte[]{49, -42, -49, (byte)0xE0, (byte)0xD1, 106, -23, 49, -73, 60, 89, -41, (byte)0xE0, (byte)0xC0, (byte)0x89, (byte)0xC0};
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new NTLMEngineException("Unicode not supported: " + unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
        }
    }

    private static byte[] ntlmv2Hash(String s, String s1, byte[] arr_b) {
        try {
            HMACMD5 nTLMEngineImpl$HMACMD50 = new HMACMD5(arr_b);
            nTLMEngineImpl$HMACMD50.update(s1.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            if(s != null) {
                nTLMEngineImpl$HMACMD50.update(s.getBytes("UnicodeLittleUnmarked"));
            }
            return nTLMEngineImpl$HMACMD50.getOutput();
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new NTLMEngineException("Unicode not supported! " + unsupportedEncodingException0.getMessage(), unsupportedEncodingException0);
        }
    }

    private static void oddParity(byte[] arr_b) {
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            arr_b[v] = ((v1 >>> 7 ^ v1 >>> 6 ^ v1 >>> 5 ^ v1 >>> 4 ^ v1 >>> 3 ^ v1 >>> 2 ^ v1 >>> 1) & 1) == 0 ? ((byte)(v1 | 1)) : ((byte)(v1 & -2));
        }
    }

    private static byte[] readSecurityBuffer(byte[] arr_b, int v) {
        int v1 = NTLMEngineImpl.readUShort(arr_b, v);
        int v2 = NTLMEngineImpl.readULong(arr_b, v + 4);
        if(arr_b.length < v2 + v1) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
        }
        byte[] arr_b1 = new byte[v1];
        System.arraycopy(arr_b, v2, arr_b1, 0, v1);
        return arr_b1;
    }

    private static int readULong(byte[] arr_b, int v) {
        if(arr_b.length < v + 4) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
        }
        return (arr_b[v + 3] & 0xFF) << 24 | (arr_b[v] & 0xFF | (arr_b[v + 1] & 0xFF) << 8 | (arr_b[v + 2] & 0xFF) << 16);
    }

    private static int readUShort(byte[] arr_b, int v) {
        if(arr_b.length < v + 2) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
        }
        return (arr_b[v + 1] & 0xFF) << 8 | arr_b[v] & 0xFF;
    }

    public static int rotintlft(int v, int v1) {
        return v >>> 0x20 - v1 | v << v1;
    }

    public void setCredentialCharset(String s) {
        this.credentialCharset = s;
    }

    private static String stripDotSuffix(String s) {
        if(s == null) {
            return null;
        }
        int v = s.indexOf(".");
        return v == -1 ? s : s.substring(0, v);
    }

    public static void writeULong(byte[] arr_b, int v, int v1) {
        arr_b[v1] = (byte)(v & 0xFF);
        arr_b[v1 + 1] = (byte)(v >> 8 & 0xFF);
        arr_b[v1 + 2] = (byte)(v >> 16 & 0xFF);
        arr_b[v1 + 3] = (byte)(v >> 24 & 0xFF);
    }
}

