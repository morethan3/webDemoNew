package com.sgm.b2c.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/3/8.
 */
public class JsonUtil {
    //private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static<T> String modelToString(T obj){
        String str = "";
        try {
            str = new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return str;
       }
    public static<T> byte[] modelToBytes(T obj){
        byte[] bytes = null;
        try {
            bytes = new ObjectMapper().writeValueAsBytes(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return bytes;
    }

    public static<T> Object jsonToModel(byte[] jsonStr,Class<T> obj) {
        T t = null;
        try {
            t = new ObjectMapper().readValue(jsonStr, obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return t;

    }

    public static final InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte aBuf : buf) {
            String hex = Integer.toHexString(aBuf & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return new byte[0];
        }
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
