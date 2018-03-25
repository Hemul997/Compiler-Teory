package com.identifiers;

import com.identifiers.exceptions.ExistIdInTableException;
import com.identifiers.exceptions.NotFoundIdInTableException;

import java.util.Map;
import java.util.TreeMap;

public class IdentifierTable {
    private Map<String, IdentifierData> identifiers = new TreeMap<>();
    private Map<String, Integer> data = new TreeMap<>();

    public IdentifierTable () {
        initData();
    }

    private void initData() {
        data.put(String.valueOf(Long.TYPE), Long.BYTES);
        data.put(String.valueOf(Integer.TYPE), Integer.BYTES);
        data.put(String.valueOf(Byte.TYPE), Byte.BYTES);
        data.put(String.valueOf(Double.TYPE), Double.BYTES);
        data.put(String.valueOf(Float.TYPE), Float.BYTES);
        data.put(String.valueOf(Character.TYPE), Character.BYTES);
        data.put(String.valueOf(Boolean.TYPE), 1);
    }

    public void put(String idName, String type) throws ExistIdInTableException {
        if (this.identifiers.containsKey(idName))
            throw new ExistIdInTableException();
        else {
            IdentifierData data = new IdentifierData(type, this.data.get(type));
            this.identifiers.put(idName, data);
        }

    }

    public IdentifierData get(String idName) throws NotFoundIdInTableException {
        if (!this.identifiers.containsKey(idName))
            throw new NotFoundIdInTableException();
        else
            return this.identifiers.get(idName);
    }


}
