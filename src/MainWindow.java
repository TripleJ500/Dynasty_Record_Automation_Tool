import java.io.*;
import javax.swing.*;
import java.awt.event.WindowEvent;

import java.awt.event.ActionEvent;
import java.util.prefs.Preferences;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

class InputFrame extends JFrame implements ActionListener, WindowListener
{
    private static final String LAST_USED_FOLDER = "";
    private JPanel inputDataPanel;
    private JTextField oigsTextField, digsTextField, kickIndGameStatsTextField, returnIndGameStatsTextField,
                       offIndSeasonStatsTextField, defIndSeasonStatsTextField,  kickIndSeasonStatsTextField,
                       returnIndSeasonStatsTextField, teamGameStatsTextField, coachCareerStatsTextField,
                       scheduleDataTextField, playersTextField, schoolRecordsTextField, ncaaRecordsTextField;
    private JLabel offensiveIndividualGameStatsLabel, defensiveIndividualGameStatsLabel, offIndSeasonStatsLabel,
                   defIndSeasonStatsLabel, kickIndSeasonStatsLabel, schoolRecordsLabel, ncaaRecordsLabel,
                   returnIndSeasonStatsLabel, teamGameStatsLabel, coachCareerStatsLabel, scheduleDataLabel;
    private JButton offIndGameStatsBrowseBtn, defIndGameStatsBrowseBtn, offIndSeasonStatsBrowseBtn,
                    defIndSeasonStatsBrowseBtn, kickIndSeasonStatsBrowseBtn, returnIndSeasonStatsBrowseBtn,
                    teamGameStatsBrowseBtn, coachCareerStatsBrowseBtn, scheduleDataBrowseBtn, playersTabBrowseBtn,
                    schoolRecordsBrowseBtn, ncaaRecordsBrowseBtn, updateButton;

    public InputFrame()
    {
        ImageIcon img = new ImageIcon("ncaa14logo.png");
        this.setIconImage(img.getImage());
        this.setContentPane(inputDataPanel);
        this.setTitle("Dynasty Record Updater Tool");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        offIndGameStatsBrowseBtn.addActionListener(this);
        offIndSeasonStatsBrowseBtn.addActionListener(this);
        defIndGameStatsBrowseBtn.addActionListener(this);
        defIndSeasonStatsBrowseBtn.addActionListener(this);
        kickIndSeasonStatsBrowseBtn.addActionListener(this);
        returnIndSeasonStatsBrowseBtn.addActionListener(this);
        teamGameStatsBrowseBtn.addActionListener(this);
        coachCareerStatsBrowseBtn.addActionListener(this);
        scheduleDataBrowseBtn.addActionListener(this);
        schoolRecordsBrowseBtn.addActionListener(this);
        ncaaRecordsBrowseBtn.addActionListener(this);
        playersTabBrowseBtn.addActionListener(this);
        updateButton.addActionListener(this);

        this.setVisible(true);
        this.pack();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == offIndGameStatsBrowseBtn ||
           e.getSource() == offIndSeasonStatsBrowseBtn ||
           e.getSource() == defIndGameStatsBrowseBtn ||
           e.getSource() == defIndSeasonStatsBrowseBtn ||
           e.getSource() == kickIndSeasonStatsBrowseBtn ||
           e.getSource() == returnIndSeasonStatsBrowseBtn ||
           e.getSource() == teamGameStatsBrowseBtn ||
           e.getSource() == coachCareerStatsBrowseBtn ||
           e.getSource() == scheduleDataBrowseBtn ||
           e.getSource() == schoolRecordsBrowseBtn ||
           e.getSource() == ncaaRecordsBrowseBtn ||
           e.getSource() == playersTabBrowseBtn)
        {

            Preferences pref = Preferences.userRoot().node(getClass().getName());
            // Create file chooser object (the button you click to browse file explorer and select the appropriate file).
            // The starting directory of the file chooser is given in the constructor.
            JFileChooser fileChooser = new JFileChooser(pref.get(LAST_USED_FOLDER, new File(".").getAbsolutePath()));

            // Saves the response of the file chooser button to the response variable
            int response = fileChooser.showOpenDialog(null);

            // if response is 'yes' we enter if-else cases to enter selected file in appropriate text field.
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                if (e.getSource().equals(offIndGameStatsBrowseBtn))
                {
                    oigsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(defIndGameStatsBrowseBtn))
                {
                   digsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(offIndSeasonStatsBrowseBtn))
                {
                    offIndSeasonStatsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(defIndSeasonStatsBrowseBtn))
                {
                    defIndSeasonStatsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(kickIndSeasonStatsBrowseBtn))
                {
                    kickIndSeasonStatsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(returnIndSeasonStatsBrowseBtn))
                {
                    returnIndSeasonStatsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(teamGameStatsBrowseBtn))
                {
                    teamGameStatsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(coachCareerStatsBrowseBtn))
                {
                    coachCareerStatsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(scheduleDataBrowseBtn))
                {
                    scheduleDataTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(schoolRecordsBrowseBtn))
                {
                    schoolRecordsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else if (e.getSource().equals(ncaaRecordsBrowseBtn))
                {
                    ncaaRecordsTextField.setText(file.toString());
                    pref.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
                }
                else
                {
                    playersTextField.setText(file.toString());
                }
            }
        }
        else
        {
            String oigsCSV = oigsTextField.getText();
            String digsCSV = digsTextField.getText();
            String oissCSV = offIndSeasonStatsTextField.getText();
            String dissCSV = defIndSeasonStatsTextField.getText();
            String kissCSV = kickIndSeasonStatsTextField.getText();
            String rissCSV = returnIndSeasonStatsTextField.getText();
            String tgsCSV  = teamGameStatsTextField.getText();
            String ccsCSV  = coachCareerStatsTextField.getText();
            String sdCSV   = scheduleDataTextField.getText();
            String playersCSV       = playersTextField.getText();
            String schoolRecordsCSV = schoolRecordsTextField.getText();
            String ncaaRecordsCSV   = ncaaRecordsTextField.getText();

            try
            {
                CSV_Export.CSVExporter(oigsCSV,
                                       digsCSV,
                                       oissCSV,
                                       dissCSV,
                                       kissCSV,
                                       rissCSV,
                                       tgsCSV,
                                       ccsCSV,
                                       sdCSV,
                                       schoolRecordsCSV,
                                       ncaaRecordsCSV,
                                       playersCSV);
            }
            catch (IOException ex) { throw new RuntimeException(ex); }
            dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e)
    {

    }

    public void windowClosing(WindowEvent e)
    {

    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        JOptionPane.showMessageDialog(null, "Records have been updated successfully." );
    }

    @Override
    public void windowIconified(WindowEvent e)
    {

    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {

    }

    @Override
    public void windowActivated(WindowEvent e)
    {

    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {

    }

}