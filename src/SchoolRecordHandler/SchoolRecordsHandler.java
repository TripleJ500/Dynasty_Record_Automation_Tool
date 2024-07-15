package SchoolRecordHandler;

import java.io.*;

import static SchoolRecordHandler.SchoolRecordCareerComparator.compareCareerRecords;
import static SchoolRecordHandler.SchoolRecordGameComparator.compareGameRecords;
import static SchoolRecordHandler.SchoolRecordSeasonComparator.compareSeasonRecords;

public class SchoolRecordsHandler implements Runnable
{
    private static File schoolRecordsFileCSV;

    public SchoolRecordsHandler(File schoolRecordsCSV)
    {
        schoolRecordsFileCSV = schoolRecordsCSV;
    }

    public void run()
    {
        try
        {
            updateSchoolRecords();
        }
        catch (IOException e) { throw new RuntimeException(e); }
    }

    public void updateSchoolRecords() throws IOException
    {
        String line;
        File outputFile = new File(schoolRecordsFileCSV.getParent(), "/Output/Updated School Records (RBKS).csv");

        if (!outputFile.getParentFile().exists())
        {
            outputFile.getParentFile().mkdirs();
        } else {
            outputFile.delete();
            outputFile.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(schoolRecordsFileCSV));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        br.readLine();
        line = br.readLine();

        bw.write("RCDA,RCDD,RCDE,RCDH,RCDI,RCDL,RBDM,RCDM,RPDM,SEWN,RCDO,RCDP,RCDT,RCDU,RCDV,RCDY");
        bw.newLine();
        try (br; bw)
        {
            while (line != null)
            {
                String[] values = line.split(",");
                values = checkForBrokenRecord(values);
                String newLine = String.join(",", values);
                line = br.readLine();
                bw.write(newLine);
                bw.newLine();
            }
            bw.flush();
        }
    }

    private String[] checkForBrokenRecord(String[] record)
    {
        String[] newRecord = null;
        int recordType = Integer.parseInt(record[12]);
        int recordDescription = Integer.parseInt(record[4]);

        /*
        record[0]  = Previous Record Value  (RCDA) | record[1]  = ??? - May be Unused             (RCDD)
        record[2]  = Previous Record Holder (RCDE) | record[3]  = Current Record Holder           (RCDH)
        record[4]  = Record Description     (RCDI) | record[5]  = Current Record Holder Player ID (RCDL)
        record[6]  = ??? - May be Unused    (RBDM) | record[7]  = Team ID                         (RCDM)
        record[8]  = ??? - May be Unused    (RPDM) | record[9]  = Season Week Record Was Broken   (SEWN)
        record[10] = Opponent               (RCDO) | record[11] = ??? - May be Unused             (RCDP)
        record[12] = Record Type            (RCDT) | record[13] = User Profile When Record Broken (RCDU)
        record[14] = Record Value           (RCDV) | record[15] = ??? - May be Unused             (RCDY)
        */

        switch (recordType)
        {
            // Game Records
            case 0 ->
            {
                if (recordDescription < 7)
                    newRecord = compareGameRecords(record, 0);
                else
                {
                    newRecord = compareGameRecords(record, 1);
                }
            }
            // Season Records
            case 1 ->
            {
                if (recordDescription < 7)
                {
                    newRecord = compareSeasonRecords(record, 0);
                } else
                {
                    newRecord = compareSeasonRecords(record, 1);
                }
            }
            // Career Records
            case 2 ->
            {
                if (recordDescription < 7)
                {
                    newRecord = compareCareerRecords(record, 0);
                } else
                {
                    newRecord = compareCareerRecords(record, 1);
                }
            }
        }
        if (newRecord == null) newRecord = record;
        return newRecord;
    }
}