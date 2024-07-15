package NCAARecordHandler;

import java.util.Objects;
import DataStructures.Objects.CCS;

import static DataStructures.List_CCS.ccsHashMap;

public class NCAARecord_CoachCareerComparator
{
    public static String[] compareCoachRecords(String[] record, int recordDescription)
    {
        int previousRecordValue;
        int recordValue = Integer.parseInt(record[13]);

        String previousRecordHolder;
        String recordHolder = record[3];
        String recordHolderCoachID = record[5];

        switch (recordDescription)
        {
            // Total Years Coached
            case 41 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.yearsCoaching;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Total Years Coached at Current School
            case 42 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.yearsWithTeam;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Total Games Coached
            case 43 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.gamesCoached;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Career Wins
            case 44 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.careerVictories;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Longest Win Streak
            case 45 ->
            {
                if(Objects.equals(recordHolderCoachID, String.valueOf(-1)) && ccsHashMap.containsKey(Integer.parseInt(recordHolderCoachID)))
                {
                    recordHolder = ccsHashMap.get(Integer.parseInt(recordHolderCoachID)).coachFirstName + " " +
                                   ccsHashMap.get(Integer.parseInt(recordHolderCoachID)).coachLastName;
                    record[3]  = recordHolder;
                }
            }

            // National Championships
            case 46 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.nationalChampionships;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Bowl Appearances
            case 47 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.bowlAppearances;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }

            // Bowl Wins
            case 48 ->
            {
                for (Integer key : ccsHashMap.keySet())
                {
                    CCS c = ccsHashMap.get(key);
                    int currentValue = c.bowlVictories;

                    if (currentValue >= recordValue)
                    {
                        previousRecordValue = recordValue;
                        previousRecordHolder = recordHolder;
                        recordHolder = c.coachFirstName + " " + c.coachLastName;
                        recordValue = currentValue;
                        recordHolderCoachID = c.coachID;

                        record[0]  = Integer.toString(previousRecordValue);
                        record[2]  = previousRecordHolder;
                        record[3]  = recordHolder;
                        record[5]  = recordHolderCoachID;
                        record[13] = Integer.toString(recordValue);
                    }
                }
            }
        }

        return record;
    }
}