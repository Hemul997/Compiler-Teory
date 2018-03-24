package com.identifiers;

import com.identifiers.exceptions.ExistIdInTableException;
import com.identifiers.exceptions.NotFoundIdInTableException;

import java.util.Map;
import java.util.TreeMap;

public class IdentifierTable {
    private Map<String, IdentifierData> identifiers = new TreeMap<>();

    public void putID(String idName, IdentifierData data) throws ExistIdInTableException {
        if (this.identifiers.containsKey(idName))
            throw new ExistIdInTableException();
        else
            this.identifiers.put(idName, data);
    }

    public IdentifierData getIDData (String idName) throws NotFoundIdInTableException {
        if (!this.identifiers.containsKey(idName))
            throw new NotFoundIdInTableException();
        else
            return this.identifiers.get(idName);
    }


}
