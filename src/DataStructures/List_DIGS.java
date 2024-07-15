package DataStructures;

import DataStructures.Objects.DIGS;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

import static DataStructures.HashMap_DIGS.*;
import static DataStructures.HashMap_Players.pDHashMap;

public class List_DIGS
{
    public static List<DIGS> dIGSList = new ArrayList<>();
    public static HashMap<Integer, List<DIGS>> digsByTeamHashMap = new HashMap<>();

    public static void createDIGSList(String digsCSV) throws IOException
    {
        String line;

        // Checks to see if the BDEF file was provided by the user, if so, iterate through the file and create a DIGS
        // object for each game stat and add each OIGS to a list
        if(digsCSV != null && !digsCSV.trim().isEmpty())
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(digsCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");
                    int currentPlayer = Integer.parseInt(values[0]);

                    // Check if current records is from a player on an active roster or if the record is for a player
                    // on one of the generic FCS teams. This will filter out FCS players and prevent errors.
                    if(pDHashMap.containsKey(currentPlayer))
                    {
                        DIGS temp = new DIGS(Integer.toString(currentPlayer),                   // Player ID                   (PGID)
                                             pDHashMap.get(Integer.parseInt(values[0])).teamID, // Team ID                     (TGID)
                                             Integer.parseInt(values[ 1]),                      // Game Number                 (SGNM)
                                             Integer.parseInt(values[ 2]),                      // Week of Game                (SEWN)
                                             Integer.parseInt(values[ 5]),                      // Tackles                     (gdta)
                                             Integer.parseInt(values[10]),                      // Tackles for Loss            (gdtl)
                                             Integer.parseInt(values[ 8]),                      // Sacks                       (glsk)
                                             Integer.parseInt(values[11]),                      // Interceptions               (gsin)
                                             Integer.parseInt(values[ 3]),                      // Longest INT Return          (gsIR)
                                             Integer.parseInt(values[18]),                      // Total INT Yards             (gsiy)
                                             Integer.parseInt(values[ 7]),                      // Forced Fumbles              (glff)
                                             Integer.parseInt(values[17]));                     // Total Fumble Recovery Yards (glfy)
                        dIGSList.add(temp);

                        createDIGSListByTeam(pDHashMap.get(Integer.parseInt(values[0])).teamID, temp);
                    }
                }
            }
        }
    }
}