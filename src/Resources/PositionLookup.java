package Resources;

import java.util.HashMap;
import java.util.Map;

public class PositionLookup
{
    private final static Map<Integer, String> positionMap;

    static
    {
        positionMap = new HashMap<>();
        positionMap.put(0,  "QB");
        positionMap.put(1,  "HB");
        positionMap.put(2,  "FB");
        positionMap.put(3,  "WR");
        positionMap.put(4,  "TE");
        positionMap.put(5,  "LT");
        positionMap.put(6,  "LG");
        positionMap.put(7,  "C");
        positionMap.put(8,  "RG");
        positionMap.put(9,  "RT");
        positionMap.put(10, "LE");
        positionMap.put(11, "RE");
        positionMap.put(12, "DT");
        positionMap.put(13, "LOLB");
        positionMap.put(14, "MLB");
        positionMap.put(15, "ROLB");
        positionMap.put(16, "CB");
        positionMap.put(17, "FS");
        positionMap.put(18, "SS");
        positionMap.put(19, "K");
        positionMap.put(20, "P");
    }

    public static String getPosition(int positionID){ return PositionLookup.positionMap.get(positionID);}
}
