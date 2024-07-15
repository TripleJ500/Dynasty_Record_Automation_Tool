package DataStructures;

import DataStructures.Objects.Schedule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class HashMap_Schedule
{
    public static int year;
    public static HashMap<Integer, List<Schedule>> sDHashMap = new HashMap<>();

    public static void createScheduleHashMap(String sdCSV, Set<Integer> excludedValues) throws IOException
    {
        String line;

        try(BufferedReader reader = new BufferedReader(new FileReader(sdCSV)))
        {
            reader.readLine();
            List<Schedule> temp1;
            List<Schedule> temp2;

            // The while loop will look at the home team column and add tams to the hashmap based on that column.
            while ((line = reader.readLine()) != null)
            {
                String[] values = line.split(",");
                int currentTeam1 = Integer.parseInt(values[7]);
                int currentTeam2 = Integer.parseInt(values[6]);

                // Check if the given teams already have an entry in the hashmap. If so, retrieve their list of SCHD
                // objects and set them equal to temp1 and temp2.
                if(sDHashMap.containsKey(currentTeam1) &&
                   sDHashMap.containsKey(currentTeam2))
                {
                    temp1 = sDHashMap.get(currentTeam1);
                    temp2 = sDHashMap.get(currentTeam2);
                }
                // If this step is reached, we can assume at least one of the current teams does not exist in the
                // hashmap. From there, we can see if one team exists in the hashmap. If one of the two teams exist,
                // we set the respective temp variable equal to their list and set the other team's temp variable to
                // a new array list.
                else if(sDHashMap.containsKey(currentTeam1))
                {
                    temp1 = sDHashMap.get(currentTeam1);
                    temp2 = new ArrayList<>();
                }
                else if(sDHashMap.containsKey(currentTeam2))
                {
                    temp1 = new ArrayList<>();
                    temp2 = sDHashMap.get(currentTeam2);
                }
                // If neither current team has an entry in the hashmap, set temp1 & temp2 to equal a new array list.
                else
                {
                    temp1 = new ArrayList<>();
                    temp2 = new ArrayList<>();
                }
                temp1.add(new Schedule(Integer.parseInt(values[6]),
                                       Integer.parseInt(values[11]),
                                       Integer.parseInt(values[12]),
                                       Integer.parseInt(values[8]),
                                       Integer.parseInt(values[2]),
                                       Integer.parseInt(values[1])));
                sDHashMap.put(currentTeam1, temp1);

                temp2.add(new Schedule(Integer.parseInt(values[7]),
                                       Integer.parseInt(values[11]),
                                       Integer.parseInt(values[12]),
                                       Integer.parseInt(values[8]),
                                       Integer.parseInt(values[1]),
                                       Integer.parseInt(values[2])));
                sDHashMap.put(currentTeam2, temp2);
            }

            // Filters out all FCS teams and all practice games before continuing.
            excludedValues.forEach(sDHashMap::remove);
            // Set year variable to current year.
            year = sDHashMap.get(1).get(0).season + 2013;
        }

    }
}
