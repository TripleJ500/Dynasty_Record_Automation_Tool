package DataStructures;

import DataStructures.Objects.Schedule;
import DataStructures.Objects.DIGS;
import DataStructures.Objects.TGS;

import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class HashMap_TGS
{
    public static HashMap<Integer, List<TGS>> tGHashMap = new HashMap<>();

    public static void createTGSHashMap(String tgsCSV, Set<Integer> excludedValues)
    {
        String line;

        if(tgsCSV  != null && !tgsCSV.trim().isEmpty())
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(tgsCSV)))
            {
                reader.readLine();
                while ((line = reader.readLine()) != null)
                {
                    String[] values = line.split(",");

                    // If current team is an FCS team, skip the current record.
                    if(excludedValues.contains(Integer.parseInt(values[0])))
                    {  }
                    else
                    {
                        int sacks = 0;
                        int teamScore = 0;
                        int gameWeek = Integer.parseInt(values[2]);
                        int gameNumber = Integer.parseInt(values[1]);
                        List<Schedule> tempSCHD = HashMap_Schedule.sDHashMap.get(Integer.parseInt(values[0]));
                        List<DIGS> tempDIGS = List_DIGS.dIGSList.stream()
                                .filter(d -> d.teamID == Integer.parseInt(values[0]))
                                .filter(d -> d.gameNumber == Integer.parseInt(values[1]) &&
                                        d.gameWeek == Integer.parseInt(values[2]))
                                .toList();

                        // Iterate through temp SCHD to find the schedule record that matches the game number and game
                        // week of the current team game record. Once found, extract the team's score from tempSCHD and
                        // assign it to teamScore.
                        for (Schedule schedule : tempSCHD)
                        {
                            if (schedule.gameNumber == gameNumber &&
                                schedule.gameWeek == gameWeek)
                            {
                                teamScore = schedule.teamScore;
                                break;  // Found the team score, can exit the loop
                            }
                        }

                        for (DIGS tempDIG : tempDIGS)
                        {
                            sacks = sacks + tempDIG.sacks;
                        }

                        List<TGS> tempTGS;

                        if (tGHashMap.containsKey(Integer.parseInt(values[0])))
                        {
                            tempTGS = tGHashMap.get(Integer.parseInt(values[0]));
                        } else {
                            tempTGS = new ArrayList<>();
                        }

                        tempTGS.add(new TGS(Integer.parseInt(values[ 0]),
                                            HashMap_Schedule.year,
                                            Integer.parseInt(values[19]),
                                            Integer.parseInt(values[21]),
                                            Integer.parseInt(values[30]),
                                            teamScore,
                                            sacks,
                                            Integer.parseInt(values[17])));
                        tGHashMap.put(Integer.parseInt(values[0]), tempTGS);
                    }
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}