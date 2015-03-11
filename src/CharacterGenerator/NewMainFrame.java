/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Dwarf.DwarfAgeGenerator;
import CharacterGenerator.Dwarf.DwarfCityGenerator;
import CharacterGenerator.Dwarf.DwarfFirstnameGenerator;
import CharacterGenerator.Dwarf.DwarfLastnameGenerator;
import CharacterGenerator.Elf.ElfAgeGenerator;
import CharacterGenerator.Elf.ElfCityGenerator;
import CharacterGenerator.Elf.ElfFirstnameGenerator;
import CharacterGenerator.Elf.ElfLastnameGenerator;
import CharacterGenerator.Enums.Race;
import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.AgeGenerator;
import CharacterGenerator.Interfaces.CityGenerator;
import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.GenderGenerator;
import CharacterGenerator.Interfaces.LastnameGenerator;
import CharacterGenerator.Interfaces.ListProvider;
import CharacterGenerator.Interfaces.RaceGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralRaceGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;
import CharacterGenerator.NeutralGenerators.SeededGenerator;
import Characters.CharacterBase;
import Story.StoryGenerator;
import Story.StoryPart;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Greatmelons
 */
public class NewMainFrame extends javax.swing.JFrame {
    
    List<CharacterBase> characterList = new ArrayList<>();
    int currentCharacter = -1;

    /**
     * Creates new form NewMainFrame
     */
    public NewMainFrame() {
        initComponents();
        generateBtn.setToolTipText("Generates a character based on the values above.");
        seedGenerationBtn.setToolTipText("Generates a character based on seed. Seed must be an integer.");
        previousChar.setToolTipText("Shows previous character.");
        nextChar.setToolTipText("Shows next character.");
        deleteChar.setToolTipText("Deletes current character.");
    }
        public CharacterSetup getSetupForElf(Randomizer randomizer){
        ListProvider provider = new ListProviderImpl();
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer, provider.getDeityList());
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer, provider.getGenders());
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, provider.getLikesDislikesList());
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer, provider.getPersonalities());
        FirstnameGenerator firstnameGenerator = new ElfFirstnameGenerator(randomizer, provider.getElfFirstnameListM(), provider.getElfFirstnameListF());
        LastnameGenerator lastnameGenerator = new ElfLastnameGenerator(randomizer, provider.getElfLastnameList());
        AgeGenerator ageGenerator = new ElfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new ElfCityGenerator(randomizer, provider.getElfCityList());
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
        
        }
    public CharacterSetup getSetupForDwarf(Randomizer randomizer){
        ListProvider provider = new ListProviderImpl();
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer, provider.getDeityList());
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer, provider.getGenders());
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, provider.getLikesDislikesList());
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer, provider.getPersonalities());
        FirstnameGenerator firstnameGenerator = new DwarfFirstnameGenerator(randomizer, provider.getDwarfFirstnameListM(), provider.getDwarfFirstnameListF());
        LastnameGenerator lastnameGenerator = new DwarfLastnameGenerator(randomizer, provider.getDwarfLastnamePrefixList(), provider.getDwarfLastnameSuffixList());
        AgeGenerator ageGenerator = new DwarfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new DwarfCityGenerator(randomizer, provider.getDwarfCityList());
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
    }
    public String generateStory(CharacterBase character, Randomizer randomizer) {
        ListProvider provider = new ListProviderImpl();
        StoryCleaner cleaner = new StoryCleaner(randomizer, provider);
        StoryGenerator storyGenerator = new StoryGenerator();
        ListReader reader = new ListReader();
        
        StoryPart storypart1 = new StoryPart(provider.getPart1());
        StoryPart storypart2 = new StoryPart(provider.getPart2());
        StoryPart storypart3 = new StoryPart(provider.getPart3());
        StoryPart storypart4 = new StoryPart(provider.getPart4());
        StoryPart storypart5 = new StoryPart(provider.getPart5());
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2, storypart3, storypart4, storypart5);
        String story2 = storyGenerator.generateStory(storyparts, cleaner, randomizer, character);
        return story2;       
    }
    public CharacterBase generateDwarf(Randomizer randomizer, Gender gender, Race race) {
        CharacterSetup characterSetup = getSetupForDwarf(randomizer);
        CharacterBase character = new CharacterBase(characterSetup, gender, race);
        return character;
    }
    public CharacterBase generateElf(Randomizer randomizer, Gender gender, Race race) {
        CharacterSetup characterSetup = getSetupForElf(randomizer);
        CharacterBase character = new CharacterBase(characterSetup, gender, race);
        return character;
    }
    public void displayCharacter(CharacterBase character) {
        characterNumberField.setText(Integer.toString(currentCharacter + 1));
        nameField.setText(character.getFirstname() + " " + character.getLastname());
        raceField.setText(character.getRace().getRaceAsText());
        genderField.setText(character.getGender().getGenderAsText());
        ageField.setText(Integer.toString(character.getAge()));
        cityField.setText(character.getCity());
        Font font = new Font("Book Antiqua", Font.PLAIN, 14);
        storyField.setFont(font);
        storyField.setText(character.getStory());
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        generationPanel = new javax.swing.JPanel();
        raceLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        raceSelect = new javax.swing.JComboBox();
        genderSelect = new javax.swing.JComboBox();
        generateBtn = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        raceLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        cityLbl = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        raceField = new javax.swing.JTextField();
        genderField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        characterPanel = new javax.swing.JPanel();
        previousChar = new javax.swing.JButton();
        nextChar = new javax.swing.JButton();
        deleteChar = new javax.swing.JButton();
        characterNumberLbl = new javax.swing.JLabel();
        characterNumberField = new javax.swing.JTextField();
        seededGenerationPanel = new javax.swing.JPanel();
        seedLabel = new javax.swing.JLabel();
        seedField = new javax.swing.JTextField();
        seedGenerationBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        storyField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FCC");
        setBounds(new java.awt.Rectangle(400, 400, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        generationPanel.setLayout(new java.awt.GridBagLayout());

        raceLabel.setText("Race");
        generationPanel.add(raceLabel, new java.awt.GridBagConstraints());

        genderLabel.setText("Gender");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        generationPanel.add(genderLabel, gridBagConstraints);

        raceSelect.setModel(new DefaultComboBoxModel(Race.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        generationPanel.add(raceSelect, gridBagConstraints);

        genderSelect.setModel(new DefaultComboBoxModel(Gender.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        generationPanel.add(genderSelect, gridBagConstraints);

        generateBtn.setText("Generate");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        generationPanel.add(generateBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(generationPanel, gridBagConstraints);

        infoPanel.setLayout(new java.awt.GridBagLayout());

        nameLbl.setText("Name");
        infoPanel.add(nameLbl, new java.awt.GridBagConstraints());

        ageLbl.setText("Age");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        infoPanel.add(ageLbl, gridBagConstraints);

        raceLbl.setText("Race");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        infoPanel.add(raceLbl, gridBagConstraints);

        genderLbl.setText("Gender");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        infoPanel.add(genderLbl, gridBagConstraints);

        cityLbl.setText("City");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        infoPanel.add(cityLbl, gridBagConstraints);

        nameField.setEditable(false);
        nameField.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        infoPanel.add(nameField, gridBagConstraints);

        ageField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        infoPanel.add(ageField, gridBagConstraints);

        raceField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        infoPanel.add(raceField, gridBagConstraints);

        genderField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        infoPanel.add(genderField, gridBagConstraints);

        cityField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        infoPanel.add(cityField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(infoPanel, gridBagConstraints);

        characterPanel.setLayout(new java.awt.GridBagLayout());

        previousChar.setText("Previous");
        previousChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousCharActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        characterPanel.add(previousChar, gridBagConstraints);

        nextChar.setText("Next");
        nextChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextCharActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        characterPanel.add(nextChar, gridBagConstraints);

        deleteChar.setText("Delete");
        deleteChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCharActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        characterPanel.add(deleteChar, gridBagConstraints);

        characterNumberLbl.setText("Character number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        characterPanel.add(characterNumberLbl, gridBagConstraints);

        characterNumberField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        characterPanel.add(characterNumberField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(characterPanel, gridBagConstraints);

        seededGenerationPanel.setLayout(new java.awt.GridBagLayout());

        seedLabel.setText("Seed");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        seededGenerationPanel.add(seedLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        seededGenerationPanel.add(seedField, gridBagConstraints);

        seedGenerationBtn.setText("Generate");
        seedGenerationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedGenerationBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        seededGenerationPanel.add(seedGenerationBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(47, 0, 47, 0);
        getContentPane().add(seededGenerationPanel, gridBagConstraints);

        storyField.setEditable(false);
        storyField.setColumns(20);
        storyField.setLineWrap(true);
        storyField.setRows(5);
        storyField.setWrapStyleWord(true);
        jScrollPane1.setViewportView(storyField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        CharacterBase character = null;
        Randomizer randomizer = new RandomNumberGenerator();
        Race race = (Race)raceSelect.getSelectedItem();
        Gender gender = (Gender)genderSelect.getSelectedItem();
        switch(race) {
            case DWARF: character = generateDwarf(randomizer, gender, race);
                break;
            case ELF: character = generateElf(randomizer, gender, race);
                break;
            default: System.out.print("woop");
        }
        character.story = generateStory(character, randomizer);
        characterList.add(character);
        currentCharacter = characterList.size() - 1;
        displayCharacter(character);
    }//GEN-LAST:event_generateBtnActionPerformed

    private void seedGenerationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedGenerationBtnActionPerformed
        ListProvider provider = new ListProviderImpl();
        long seed = 0;
        String userSeed = seedField.getText();
            try{
                seed = Long.valueOf(userSeed);
            }catch(NumberFormatException e) {
                storyField.setText("Not a valid seed.");
            }
        Randomizer seededRandomizer = new SeededGenerator(seed);
        RaceGenerator raceGenerator = new NeutralRaceGenerator(seededRandomizer, provider.getRaces());
        Race seededRace = raceGenerator.generateRace();
        GenderGenerator genderGenerator = new NeutralGenderGenerator(seededRandomizer, provider.getGenders());
        Gender seededGender = genderGenerator.generateGender();
        CharacterBase seededCharacter;
        switch(seededRace) {
            case DWARF: seededCharacter = generateDwarf(seededRandomizer, seededGender, seededRace);
                break;
            case ELF: seededCharacter = generateElf(seededRandomizer, seededGender, seededRace);
                break;
            default: 
                throw new IllegalArgumentException("Not a valid race: " + seededRace);
        }
        seededCharacter.story = generateStory(seededCharacter, seededRandomizer);
        characterList.add(seededCharacter);
        currentCharacter = characterList.size() - 1;
        displayCharacter(seededCharacter);
    }//GEN-LAST:event_seedGenerationBtnActionPerformed

    private void previousCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCharActionPerformed

        CharacterBase character;
        if(currentCharacter > 0) {
            currentCharacter--;
            character = characterList.get(currentCharacter);
            displayCharacter(character);            
        }
    }//GEN-LAST:event_previousCharActionPerformed

    private void nextCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextCharActionPerformed

        if(currentCharacter < characterList.size() - 1) {
            currentCharacter++;
            CharacterBase character = characterList.get(currentCharacter);
            displayCharacter(character);
        }
    }//GEN-LAST:event_nextCharActionPerformed

    private void deleteCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCharActionPerformed

        if(!characterList.isEmpty()) {
            characterList.remove(currentCharacter);
            try {    
                currentCharacter--;
                CharacterBase character = characterList.get(currentCharacter);
                displayCharacter(character);
            } catch (ArrayIndexOutOfBoundsException e) {
                characterNumberField.setText("");
                nameField.setText("");
                raceField.setText("");
                genderField.setText("");
                ageField.setText("");
                cityField.setText("");
                storyField.setText("");
                }
            }
    }//GEN-LAST:event_deleteCharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLbl;
    private javax.swing.JTextField characterNumberField;
    private javax.swing.JLabel characterNumberLbl;
    private javax.swing.JPanel characterPanel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLbl;
    private javax.swing.JButton deleteChar;
    private javax.swing.JTextField genderField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JComboBox genderSelect;
    private javax.swing.JButton generateBtn;
    private javax.swing.JPanel generationPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JButton nextChar;
    private javax.swing.JButton previousChar;
    private javax.swing.JTextField raceField;
    private javax.swing.JLabel raceLabel;
    private javax.swing.JLabel raceLbl;
    private javax.swing.JComboBox raceSelect;
    private javax.swing.JTextField seedField;
    private javax.swing.JButton seedGenerationBtn;
    private javax.swing.JLabel seedLabel;
    private javax.swing.JPanel seededGenerationPanel;
    private javax.swing.JTextArea storyField;
    // End of variables declaration//GEN-END:variables
}
