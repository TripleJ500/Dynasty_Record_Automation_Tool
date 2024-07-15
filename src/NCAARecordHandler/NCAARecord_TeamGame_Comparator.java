package NCAARecordHandler;

import DataStructures.Objects.TGS;
import DataStructures.HashMap_Schedule;

import java.util.Map;
import java.util.List;

import static DataStructures.HashMap_TGS.tGHashMap;
import static Resources.TeamLookup.getTeamName;


public class NCAARecord_TeamGame_Comparator
{
    public static String[] compareGameRecords(String[] record, int recordDescription)
    {
        int previousRecordValue;
        int recordValue = Integer.parseInt(record[13]);

        String previousRecordHolder;
        String recordHolder = record[3];

        switch (recordDescription)
        {
            // Most Points scored in a Single Game
            case 15 ->
            {
                for (Map.Entry<Integer, List<TGS>> key : tGHashMap.entrySet())
                {
                    List<TGS> list = key.getValue();
                    for (TGS t : list)
                    {
                        int currentValue = t.points;

                        if (currentValue >= recordValue)
                        {
                            // Get the current iterated player's information from the players' hashmap.
                            String newHolder = getTeamName(t.teamID);

                            previousRecordValue = recordValue;
                            previousRecordHolder = recordHolder;
                            recordHolder = newHolder + " (" + HashMap_Schedule.year + ")";
                            recordValue = currentValue;

                            record[0] = Integer.toString(previousRecordValue);
                            record[2] = previousRecordHolder;
                            record[3] = recordHolder;
                            record[13] = Integer.toString(recordValue);
                        }
                    }
                }
            }

            // Most Total Offense in a Single Game
            case 16 ->
            {
                for (Map.Entry<Integer, List<TGS>> key : tGHashMap.entrySet())
                {
                    List<TGS> list = key.getValue();
                    for (TGS t : list)
                    {
                        int currentValue = t.totalOffense;

                        if (currentValue >= recordValue)
                        {
                            // Get the current iterated player's information from the players' hashmap.
                            String newHolder = getTeamName(t.teamID);

                            previousRecordValue = recordValue;
                            previousRecordHolder = recordHolder;
                            recordHolder = newHolder + " (" + HashMap_Schedule.year + ")";
                            recordValue = currentValue;

                            record[0] = Integer.toString(previousRecordValue);
                            record[2] = previousRecordHolder;
                            record[3] = recordHolder;
                            record[13] = Integer.toString(recordValue);
                        }
                    }
                }
            }

            // Most Pass Yards in a Single Game
            case 17 ->
            {
                for (Map.Entry<Integer, List<TGS>> key : tGHashMap.entrySet())
                {
                    List<TGS> list = key.getValue();
                    for (TGS t : list)
                    {
                        int currentValue = t.pssYd;

                        if (currentValue >= recordValue)
                        {
                            // Get the current iterated player's information from the players' hashmap.
                            String newHolder = getTeamName(t.teamID);

                            previousRecordValue = recordValue;
                            previousRecordHolder = recordHolder;
                            recordHolder = newHolder + " (" + HashMap_Schedule.year + ")";
                            recordValue = currentValue;

                            record[0] = Integer.toString(previousRecordValue);
                            record[2] = previousRecordHolder;
                            record[3] = recordHolder;
                            record[13] = Integer.toString(recordValue);
                        }
                    }
                }
            }

            // Most Rush Yards in a Single Game
            case 18 ->
            {
                for (Map.Entry<Integer, List<TGS>> key : tGHashMap.entrySet())
                {
                    List<TGS> list = key.getValue();
                    for (TGS t : list)
                    {
                        int currentValue = t.rshYD;

                        if (currentValue >= recordValue)
                        {
                            // Get the current iterated player's information from the players' hashmap.
                            String newHolder = getTeamName(t.teamID);

                            previousRecordValue = recordValue;
                            previousRecordHolder = recordHolder;
                            recordHolder = newHolder + " (" + HashMap_Schedule.year + ")";
                            recordValue = currentValue;

                            record[0] = Integer.toString(previousRecordValue);
                            record[2] = previousRecordHolder;
                            record[3] = recordHolder;
                            record[13] = Integer.toString(recordValue);
                        }
                    }
                }
            }

            // Most Sacks in a Single Game
            case 19 ->
            {
                for (Map.Entry<Integer, List<TGS>> key : tGHashMap.entrySet())
                {
                    List<TGS> list = key.getValue();
                    for (TGS t : list)
                    {
                        int currentValue = t.sacks;

                        if (currentValue >= recordValue)
                        {
                            // Get the current iterated player's information from the players' hashmap.
                            String newHolder = getTeamName(t.teamID);

                            previousRecordValue = recordValue;
                            previousRecordHolder = recordHolder;
                            recordHolder = newHolder + " (" + HashMap_Schedule.year + ")";
                            recordValue = currentValue;

                            record[0] = Integer.toString(previousRecordValue);
                            record[2] = previousRecordHolder;
                            record[3] = recordHolder;
                            record[13] = Integer.toString(recordValue);
                        }
                    }
                }
            }


            // Most Interceptions in a Single Game
            case 20 ->
            {
                for (Map.Entry<Integer, List<TGS>> key : tGHashMap.entrySet())
                {
                    List<TGS> list = key.getValue();
                    for (TGS t : list)
                    {
                        int currentValue = t.interceptions;

                        if (currentValue >= recordValue)
                        {
                            // Get the current iterated player's information from the players' hashmap.
                            String newHolder = getTeamName(t.teamID);

                            previousRecordValue = recordValue;
                            previousRecordHolder = recordHolder;
                            recordHolder = newHolder + " (" + HashMap_Schedule.year + ")";
                            recordValue = currentValue;

                            record[0] = Integer.toString(previousRecordValue);
                            record[2] = previousRecordHolder;
                            record[3] = recordHolder;
                            record[13] = Integer.toString(recordValue);
                        }
                    }
                }
            }
        }

        return record;
    }
}
