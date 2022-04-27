package com.Dmitrii.common.networkhub;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author dmitrii
 */
public class Serializer {

	public Serializer() {
	}
	
	public byte[] serialize(Serializable obj) throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bytes);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        bytes.close();
        return bytes.toByteArray();
	}
	
	public Serializable deserialize(byte[] obj) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(obj);
        ObjectInputStream objectInput = new ObjectInputStream(byteArrayInputStream);
        try {
            return (Serializable) objectInput.readObject();
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
