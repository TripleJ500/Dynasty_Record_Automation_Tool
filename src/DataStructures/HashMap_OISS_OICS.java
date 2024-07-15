package DataStructures;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import DataStructures.Objects.OISS;
import static DataStructures.HashMap_Schedule.year;
import static DataStructures.HashMap_Players.pDHashMap;

public class HashMap_OISS_OICS
{
    public static HashMap<Integer, OISS> oSHashMap  = new HashMap<>();
    public static HashMap<Integer, OISS> oCHashMap = new HashMap<>();
    public static HashMap<Integer, HashMap<Integer, OISS>> offSeaasonByTeamHashMap  = new HashMap<>();
    public static HashMap<Integer, HashMap<Integer, OISS>> offCareerByTeamHashMap  = new HashMap<>();

    public static void createOISSHashMap(String oissCSV) throws IOException
    {
        String line;

        // Proceed so long as the file exists
        if (oissCSV != null && !oissCSV.trim().isEmpty())
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(oissCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");
                    List<Integer> tempYrArr;
                    HashMap<Integer, OISS> oissByTeam;
                    OISS o;

                    if(oSHashMap.containsKey(Integer.parseInt(values[0])))
                    {
                        // Season records at the top of the file are the oldest seasons and become more recent the farther
                        // down the file you go.
                        o = oSHashMap.get(Integer.parseInt(values[0]));
                        tempYrArr = o.year;
                        tempYrArr.add(year - 1);
                        o.year = tempYrArr;

                        oSHashMap.put(Integer.parseInt(o.playerID), o);
                    } else {
                        // Automatically update the OISS object assigned to the particular player ID. The season stats
                        // are populated in descending order, so the more recent seasons will be towards the bottom
                        // of the file.
                        tempYrArr = new ArrayList<>();
                        tempYrArr.add(year);

                        o = new OISS(values[0],
                                     pDHashMap.get(Integer.parseInt(values[0])).teamID,
                                     tempYrArr,
                                     Integer.parseInt(values[8]),
                                     Integer.parseInt(values[12]),
                                     Integer.parseInt(values[10]),
                                     Integer.parseInt(values[14]),
                                     Integer.parseInt(values[9]),
                                     Integer.parseInt(values[13]),
                                     Integer.parseInt(values[6]));
                        oSHashMap.put(Integer.parseInt(o.playerID), o);
                    }
                    oissByTeam = offSeaasonByTeamHashMap.get(o.teamID) == null ? new HashMap<>() : offSeaasonByTeamHashMap.get(o.teamID);
                    oissByTeam.put(Integer.parseInt(o.playerID), o);
                    offSeaasonByTeamHashMap.put(o.teamID, oissByTeam);

                    createOCSHashMap(o);
                }
            }
        }
    }

    public static void createOCSHashMap(OISS o)
    {
        HashMap<Integer, OISS> tempOCS;

        // If the record
        if(oCHashMap.get(Integer.parseInt(o.playerID)) == null)
        {
            oCHashMap.put(Integer.parseInt(o.playerID), o);
        } else {
            OISS temp = oCHashMap.get(Integer.parseInt(o.playerID));
            temp.passingYards = o.passingYards + temp.passingYards;
            temp.passingTouchdowns = o.passingTouchdowns + temp.passingTouchdowns;
            temp.rushingYards = o.receivingYards + temp.rushingYards;
            temp.rushingTouchdowns = o.rushingTouchdowns + temp.rushingTouchdowns;
            temp.receivingYards = o.receivingYards + temp.receivingYards;
            temp.receivingTouchdowns = o.receivingTouchdowns + temp.receivingTouchdowns;
            temp.receptions = o.receptions + temp.receptions;

            oCHashMap.put(Integer.parseInt(o.playerID), temp);
        }

        tempOCS = offCareerByTeamHashMap.get(o.teamID) == null ? new HashMap<>() : offCareerByTeamHashMap.get(o.teamID);
        tempOCS.put(Integer.parseInt(o.playerID), o);
        offCareerByTeamHashMap.put(o.teamID, tempOCS);
    }
}