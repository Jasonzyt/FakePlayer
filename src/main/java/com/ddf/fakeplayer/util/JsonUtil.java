package com.ddf.fakeplayer.util;

import com.ddf.fakeplayer.util.tuple.Tuple4;

public class JsonUtil {
    public static Tuple4<Boolean, String, String, Integer> parseItem(String outItemName, String outItemNamespace, int inoutItemAux, String inString) {
        if (!inString.isEmpty()) {
            outItemNamespace = "minecraft";
            String[] terms = inString.split(":");
            if (terms.length <= 1) {
                if (terms.length != 1) {
                    return new Tuple4<>(false, outItemName, outItemNamespace, inoutItemAux);
                }
            } else if (!Util.isNumber(terms[1])) {
                String nameSpace = terms[0];
                outItemNamespace = nameSpace.toLowerCase();
                outItemName = terms[1];
                if (terms.length > 2) {
                    inoutItemAux = Util.toInt(terms[2]);
                }
            } else {
                outItemName = terms[0];
            }
            outItemName = outItemName.toLowerCase();
            if (outItemName.startsWith("tile.")) {
                outItemName = outItemName.substring(5);
            }
            return new Tuple4<>(true, outItemName, outItemNamespace, inoutItemAux);
        }
        return new Tuple4<>(false, outItemName, outItemNamespace, inoutItemAux);
    }
}
