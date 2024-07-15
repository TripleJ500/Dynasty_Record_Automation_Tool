package NCAARecordHandler;

import java.io.*;

public class NCAARecordsHandler implements Runnable
{
    private static File ncaaRecordsFileCSV;
    public NCAARecordsHandler(File ncaaRecordsCSV)
    {
        ncaaRecordsFileCSV = ncaaRecordsCSV;
    }
    @Override
    public void run()
    {
        try
        {
            updateNCAARecords();
        }
        catch (IOException e) { throw new RuntimeException(e); }
    }

    public void updateNCAARecords() throws IOException
    {
        String line;
        File outputFile = new File(ncaaRecordsFileCSV.getParent(), "/Output/Updated NCAA Records (RBKN).csv");

        if (!outputFile.getParentFile().exists())
        {
            outputFile.getParentFile().mkdirs();
        } else {
            outputFile.delete();
            outputFile.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(ncaaRecordsFileCSV));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        br.readLine();
        line = br.readLine();

        bw.write("RCDA,RCDD,RCDE,RCDH,RCDI,RCDL,RBDM,RPDM,SEWN,RCDO,RCDP,RCDR,RCDU,RCDV,RCDY");
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
        int recordDescription = Integer.parseInt(record[4]);

        /*
        record[0]  = Previous Record Value           (RCDA) | record[1]  = ??? - May be Unused             (RCDD)
        record[2]  = Previous Record Holder          (RCDE) | record[3]  = Current Record Holder           (RCDH)
        record[4]  = Record Description              (RCDI) | record[5]  = Current Record Holder Player ID (RCDL)
        record[6]  = ??? - May be Unused             (RBDM) | record[7]  = ??? - May be Unused             (RPDM)
        record[8]  = Season Week Record Was Broken   (SEWN) | record[9]  = Opponent                        (RCDO)
        record[10  = ??? - May be Unused             (RCDP) | record[11] = ??? - May be Unused             (RCDR)
        record[12] = User Profile When Record Broken (RCDU) | record[13] = Record Value                    (RCDV)
        record[14] = ??? - May be Unused             (RCDY)
        */

        switch(recordDescription)
        {
            // Longest "xyz" Records
            case 1, 2, 3, 4, 5, 6, 7, 8 -> newRecord = NCAARecord_IndGame_LongComparator.compareGameRecords(record, recordDescription);
            // Individual Game Records
            case 9, 10, 11, 12, 13, 14 -> newRecord = NCAARecord_IndGameComparator.compareGameRecords(record, recordDescription);
            // Team Game Records
            case 15, 16, 17, 18, 19, 20 -> newRecord = NCAARecord_TeamGame_Comparator.compareGameRecords(record, recordDescription);
            // Individual Season Records
            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 -> newRecord = NCAARecord_IndSeasonComparator.compareSeasonRecords(record, recordDescription);
            // Individual Career Records
            case 32, 33, 34, 35, 36, 37, 38, 39, 40 -> newRecord = NCAARecord_IndCareerComparator.compareCareerRecords(record, recordDescription);
            // Coach Career Records
            case 41, 42, 43, 44, 45, 46, 47, 48 -> newRecord = NCAARecord_CoachCareerComparator.compareCoachRecords(record, recordDescription);
        }

        if (newRecord == null) newRecord = record;
        return newRecord;
    }
}