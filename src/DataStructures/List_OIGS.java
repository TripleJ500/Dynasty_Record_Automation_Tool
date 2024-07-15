package DataStructures;

import DataStructures.Objects.OIGS;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import static DataStructures.HashMap_Players.pDHashMap;

public class List_OIGS
{
    public static List<OIGS> oIGSList = new ArrayList<>();
    public static HashMap<Integer, List<OIGS>> oigsByTeamHashMap = new HashMap<>();

    public static void createOIGSList(String oigsCSV) throws IOException
    {

        // Checks to see if the BOFF file was provided by the user, if so, iterate through the file and create a OIGS
        // object for each game stat and add each OIGS to a list
        if(oigsCSV != null && !oigsCSV.trim().isEmpty())
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(oigsCSV)))
            {
                reader.readLine();
                String line;
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");

                    // Check if current records is from a player on an active roster or if the record is for a player
                    // on one of the generic FCS teams. This will filter out FCS players and prevent errors.
                    if(pDHashMap.containsKey(Integer.parseInt(values[0])))
                    {
                        OIGS temp = new OIGS(values[0], pDHashMap.get(Integer.parseInt(values[0])).teamID, // Player ID/TeamID  (PGID)/{TGID)
                                                        Integer.parseInt(values[ 2]),                      // Game Number       (SGNM)
                                                        Integer.parseInt(values[ 3]),                      // Week of Season    (SEWN)
                                                        Integer.parseInt(values[ 8]),                      // Pass Yards        (GAYA)
                                                        Integer.parseInt(values[13]),                      // Pass TD's         (GATD)
                                                        Integer.parseInt(values[ 4]),                      // Longest Pass      (gaIN)
                                                        Integer.parseInt(values[10]),                      // Rush Yards        (guya)
                                                        Integer.parseInt(values[15]),                      // Rush Touchdowns   (gutd)
                                                        Integer.parseInt(values[ 5]),                      // Longest Rush      (guIN)
                                                        Integer.parseInt(values[ 9]),                      // Receiving Yards   (gcya)
                                                        Integer.parseInt(values[14]),                      // Receiving TD's    (gctd))
                                                        Integer.parseInt(values[ 6]),                      // Receptions        (gcca)
                                                        Integer.parseInt(values[ 1]));                     // Longest Reception (gcrL)
                        oIGSList.add(temp);

                        createOIGSListByTeam(pDHashMap.get(Integer.parseInt(values[0])).teamID, temp);
                    }
                }
            }
        }
    }

    public static void createOIGSListByTeam(int teamID, OIGS o)
    {
        List<OIGS> tempArr;

        tempArr = oigsByTeamHashMap.get(teamID) == null ? new ArrayList<>() : oigsByTeamHashMap.get(teamID);
        tempArr.add(o);
        oigsByTeamHashMap.put(teamID, tempArr);
    }
}