package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * created by baixuyan on 2018/5/17
 *
 * @author baixuyan
 **/
public class RedisUtil {
    public static byte[] convertToByte(Object object) {
        //convert To Byte
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.writeObject(object);
            byte[] bytes = b.toByteArray();
            return bytes;
        } catch (Exception e) {
            return null;
        }
    }

    public static Object convertToObject(byte[] bytes) {
        //convert To Object
        try {
            ByteArrayInputStream b = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(b);
            return ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
