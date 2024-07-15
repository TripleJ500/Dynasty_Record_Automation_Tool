package DataStructures;

import DataStructures.Objects.DISS;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import static DataStructures.HashMap_Schedule.year;
import static DataStructures.HashMap_Players.pDHashMap;

public class HashMap_DISS_DICS
{
    public static HashMap<Integer, DISS> dSHashMap  = new HashMap<>();
    public static HashMap<Integer, DISS> dCHashMap = new HashMap<>();
    public static HashMap<Integer, HashMap<Integer, DISS>> defSeaasonByTeamHashMap  = new HashMap<>();
    public static HashMap<Integer, HashMap<Integer, DISS>> defCareerByTeamHashMap  = new HashMap<>();


    public static void createDISSHashMap(String dissCSV) throws IOException
    {
        String line;

        // Proceed so long as the file exists
        if(dissCSV != null && !dissCSV.trim().isEmpty())
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(dissCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");
                    List<Integer> tempYrArr;
                    HashMap<Integer,  DISS> dissByTeam;
                    DISS d;

                    if(dSHashMap.containsKey(Integer.parseInt(values[0])))
                    {
                        // Season records at the top of the file are the oldest seasons and become more recent the farther
                        // down the file you go.
                        d = dSHashMap.get(Integer.parseInt(values[0]));
                        tempYrArr = d.year;
                        tempYrArr.add(year - 1);
                        d.year = tempYrArr;

                        dSHashMap.put(Integer.parseInt(d.playerID), d);
                    } else {
                        // Automatically update the DISS object assigned to the particular player ID. The season stats
                        // are populated in descending order, so the more recent seasons will be towards the bottom
                        // of the file.
                        tempYrArr = new ArrayList<>();
                        tempYrArr.add(year);

                        d = new DISS(values[0],
                                     pDHashMap.get(Integer.parseInt(values[0])).teamID,
                                     tempYrArr,
                                     Integer.parseInt(values[9]),
                                     Integer.parseInt(values[11]));

                        dSHashMap.put(Integer.parseInt(d.playerID), d);
                    }
                    dissByTeam = defSeaasonByTeamHashMap.get(d.teamID) == null ? new HashMap<>() :
                                                                                defSeaasonByTeamHashMap.get(d.teamID);
                    dissByTeam.put(Integer.parseInt(d.playerID), d);
                    defSeaasonByTeamHashMap.put(d.teamID, dissByTeam);

                    createDCSHashMap(d);
                }
            }
        }
    }

    private static void createDCSHashMap(DISS d)
    {
        HashMap<Integer, DISS> tempDCS;

        // Check if the current player ID doesn't exist, add the DISS record to the hashmap
        // If the record
        if(dCHashMap.get(Integer.parseInt(d.playerID)) == null)
        {
            dCHashMap.put(Integer.parseInt(d.playerID), d);
        } else {
            DISS temp = dCHashMap.get(Integer.parseInt(d.playerID));
            temp.sacks = d.sacks + temp.sacks;
            temp.interceptions = d.interceptions + temp.interceptions;

            dCHashMap.put(Integer.parseInt(d.playerID), temp);
        }

        tempDCS = defCareerByTeamHashMap.get(d.teamID) == null ? new HashMap<>() : defCareerByTeamHashMap.get(d.teamID);
        tempDCS.put(Integer.parseInt(d.playerID), d);
        defCareerByTeamHashMap.put(d.teamID, tempDCS);
    }
}