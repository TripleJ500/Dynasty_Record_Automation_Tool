package DataStructures;

import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import DataStructures.Objects.CCS;

public class List_CCS
{
    public static HashMap<Integer, CCS> ccsHashMap = new HashMap<>();

    public static void createCCSList(String ccsCSV) throws IOException
    {
        String line;

        // Checks to see if the BDEF file was provided by the user, if so, iterate through the file and create a DIGS
        // object for each game stat and add each OIGS to a list

        if(ccsCSV != null && !ccsCSV.trim().isEmpty())
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(ccsCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");

                    CCS temp = new CCS(values[20],
                                       values[65],
                                       values[66],
                          Integer.parseInt(values[137]) + Integer.parseInt(values[56]),
                                       Integer.parseInt(values[137]),
                                       Integer.parseInt(values[ 47]),
                           Integer.parseInt(values[ 76]) + Integer.parseInt(values[47]),
                                       Integer.parseInt(values[ 89]),
                                       Integer.parseInt(values[ 19]),
                                       Integer.parseInt(values[143]));
                    ccsHashMap.put(Integer.parseInt(values[20]), temp);
                }
            }
        }
    }
}