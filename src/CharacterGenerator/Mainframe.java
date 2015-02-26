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
import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Enums.Race;
import CharacterGenerator.Interfaces.*;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralRaceGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;
import CharacterGenerator.NeutralGenerators.SeededGenerator;
import Characters.CharacterBase;
import Characters.SeededCharacterBase;
import Story.StoryGenerator;
import Story.StoryPart;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;


/**
 *
 * @author Greatmelons
 */
public class Mainframe extends javax.swing.JFrame {

    /**
     * Creates new form Mainframe
     */
    public Mainframe() {
        initComponents();
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
        StoryGenerator newStoryGenerator = new StoryGenerator();
        ListReader reader = new ListReader();
        
        StoryPart storypart1 = new StoryPart(provider.getPart1());
        StoryPart storypart2 = new StoryPart(provider.getPart2());
        StoryPart storypart3 = new StoryPart(provider.getPart3());
        StoryPart storypart4 = new StoryPart(provider.getPart4());
        StoryPart storypart5 = new StoryPart(provider.getPart5());
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2, storypart3, storypart4, storypart5);
        String story2 = newStoryGenerator.generateStory(storyparts, cleaner, randomizer, character);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storyArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        genderField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        raceField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        seedLabel = new javax.swing.JLabel();
        seedField = new javax.swing.JTextField();
        seedGenButton = new javax.swing.JButton();
        raceSelect = new javax.swing.JComboBox();
        genderSelect = new javax.swing.JComboBox();
        raceLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fantasy Character Generator");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        storyArea.setEditable(false);
        storyArea.setColumns(20);
        storyArea.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        storyArea.setRows(5);
        jScrollPane1.setViewportView(storyArea);

        nameField.setEditable(false);

        genderField.setEditable(false);
        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });

        ageField.setEditable(false);

        raceField.setEditable(false);
        raceField.setBackground(new java.awt.Color(240, 240, 240));
        raceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raceFieldActionPerformed(evt);
            }
        });

        cityField.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(raceField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameField)
                    .addComponent(ageField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(genderField)
                    .addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(raceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Name");

        jLabel2.setText("Race");

        jLabel3.setText("Gender");

        jLabel4.setText("Age");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ageField, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel4, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        jLabel5.setText("City");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cityField, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel5, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seedLabel.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        seedLabel.setText("Seed");

        seedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedFieldActionPerformed(evt);
            }
        });

        seedGenButton.setFont(new java.awt.Font("Book Antiqua", 0, 11)); // NOI18N
        seedGenButton.setText("Generate");
        seedGenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedGenButtonActionPerformed(evt);
            }
        });

        raceSelect.setFont(new java.awt.Font("Book Antiqua", 0, 11)); // NOI18N
        raceSelect.setModel(new DefaultComboBoxModel(Race.values()));
        raceSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raceSelectActionPerformed(evt);
            }
        });

        genderSelect.setFont(new java.awt.Font("Book Antiqua", 0, 11)); // NOI18N
        genderSelect.setModel(new DefaultComboBoxModel(Gender.values())
        );
        genderSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderSelectActionPerformed(evt);
            }
        });

        raceLabel.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        raceLabel.setText("Race");

        genderLabel.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        genderLabel.setText("Gender");

        genButton.setFont(new java.awt.Font("Book Antiqua", 0, 11)); // NOI18N
        genButton.setText("Generate");
        genButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(seedGenButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(raceLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(raceSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(genButton)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(genderLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(genderSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(seedLabel))
                                .addGap(0, 51, Short.MAX_VALUE))
                            .addComponent(seedField))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raceSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(genderSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(genButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(seedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seedGenButton)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genButtonActionPerformed
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
        nameField.setText(character.getFirstname() + " " + character.getLastname());
        raceField.setText(character.getRace().getRaceAsText());
        genderField.setText(character.getGender().getGenderAsText());
        ageField.setText(Integer.toString(character.getAge()));
        cityField.setText(character.getCity());
        String story = generateStory(character, randomizer);
        Font font = new Font("Book Antiqua", Font.PLAIN, 14);
        storyArea.setFont(font);
        storyArea.setText(story);
    }//GEN-LAST:event_genButtonActionPerformed

    private void raceSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raceSelectActionPerformed

    }//GEN-LAST:event_raceSelectActionPerformed

    private void genderSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderSelectActionPerformed

    }//GEN-LAST:event_genderSelectActionPerformed

    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

    private void raceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raceFieldActionPerformed

    private void seedGenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedGenButtonActionPerformed
        ListProvider provider = new ListProviderImpl();
        long seed = 0;
        String userSeed = seedField.getText();
            try{
                seed = Long.valueOf(userSeed);
            }catch(NumberFormatException e) {
                storyArea.setText("Not a valid seed.");
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
        nameField.setText(seededCharacter.getFirstname() + " " + seededCharacter.getLastname());
        raceField.setText(seededCharacter.getRace().getRaceAsText());
        genderField.setText(seededCharacter.getGender().getGenderAsText());
        ageField.setText(Integer.toString(seededCharacter.getAge()));
        cityField.setText(seededCharacter.getCity());
        String story = generateStory(seededCharacter, seededRandomizer);
        Font font = new Font("Book Antiqua", Font.PLAIN, 14);
        storyArea.setFont(font);
        storyArea.setText(story);  
    }//GEN-LAST:event_seedGenButtonActionPerformed

    private void seedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedFieldActionPerformed

    }//GEN-LAST:event_seedFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JTextField cityField;
    private javax.swing.JButton genButton;
    private javax.swing.JTextField genderField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JComboBox genderSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField raceField;
    private javax.swing.JLabel raceLabel;
    private javax.swing.JComboBox raceSelect;
    private javax.swing.JTextField seedField;
    private javax.swing.JButton seedGenButton;
    private javax.swing.JLabel seedLabel;
    private javax.swing.JTextArea storyArea;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
