package DataStructures;

import DataStructures.Objects.DIGS;

import java.util.List;
import java.util.ArrayList;

import static DataStructures.List_DIGS.digsByTeamHashMap;

public class HashMap_DIGS
{
    public static void createDIGSListByTeam(int teamID, DIGS d)
    {
        List<DIGS> tempArr;

        tempArr = digsByTeamHashMap.get(teamID) == null ? new ArrayList<>() : digsByTeamHashMap.get(teamID);
        tempArr.add(d);
        digsByTeamHashMap.put(teamID, tempArr);
    }
}
