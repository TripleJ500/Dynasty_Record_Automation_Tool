package DataStructures;

import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import DataStructures.Objects.RISS;

import static DataStructures.HashMap_Players.pDHashMap;

public class HashMap_RISS
{
    public static HashMap<Integer, RISS> rSHashMap  = new HashMap<>();

    public static void createRISSHashMap(String rissCSV)
    {
        String line;

        if(rissCSV != null && !rissCSV.trim().isEmpty())
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(rissCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");

                    rSHashMap.put(Integer.parseInt(values[0]), new RISS(values[0],
                                                                        pDHashMap.get(Integer.parseInt(values[0])).firstName,
                                                                        pDHashMap.get(Integer.parseInt(values[0])).lastName,
                                                                        pDHashMap.get(Integer.parseInt(values[0])).teamID,
                                                                        HashMap_Schedule.year,
                                                                        Integer.parseInt(values[3]),
                                                                        Integer.parseInt(values[2])));
                }
            }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}