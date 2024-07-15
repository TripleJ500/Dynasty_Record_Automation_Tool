package DataStructures;

import DataStructures.Objects.KISS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static DataStructures.HashMap_Players.pDHashMap;

public class HashMap_KISS
{
    public static HashMap<Integer, KISS> kSHashMap  = new HashMap<>();

    public static void createKISSHashMap(String kissCSV) throws IOException
    {
        String line;

        if((kissCSV != null) && !kissCSV.trim().isEmpty())
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(kissCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");

                    kSHashMap.put(Integer.parseInt(values[0]), new KISS(values[0],
                                                                        pDHashMap.get(Integer.parseInt(values[0])).firstName,
                                                                        pDHashMap.get(Integer.parseInt(values[0])).lastName,
                                                                        pDHashMap.get(Integer.parseInt(values[0])).teamID,
                                                                        Integer.parseInt(values[ 3]),
                                                                        Integer.parseInt(values[ 2]),
                                                                        Integer.parseInt(values[23])));
                }
            }
        }
    }
}