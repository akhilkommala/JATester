/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JDialog;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class Main extends javax.swing.JFrame {
private ArrayList<Test> tests;
private String filePath;
    /**
     * Creates new form Main
     */
    public Main() throws IOException{
        String dir = System.getProperty("user.dir");
        filePath = dir + "/save.txt";
        initComponents();
        tests = new ArrayList<Test>();
        load();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jButton3.setText("Create Problem Set");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Start Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create Problem Set");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(java.awt.SystemColor.controlHighlight);
        jTextField1.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jTextField1.setText("JATester 1.0");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void save() {
        try(PrintWriter writer = new PrintWriter(new File(filePath))){
            for(int i = 0; i < tests.size(); i++){
                 writer.println(tests.get(i).toString());
            }
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(this, "Error trying to save file: " + ex);
        }
    }
    
    
    
    public void load() throws IOException{
        
        BufferedReader loadFile;
    try {
        loadFile = new BufferedReader(new FileReader(filePath));
        String input;
        while((input = loadFile.readLine()) != null){
            String[] test = input.split(",", 0);
            ArrayList<Question> qs = new ArrayList<Question>();
            for(int i = 1; i < test.length; i++){
                if(test[i].equals("1")){
                    ArrayList<String> a = new ArrayList<String>();
                    a.add(test[i+2]);
                    a.add(test[i+3]);
                    a.add(test[i+4]);
                    a.add(test[i+5]);
                    MCQ q = new MCQ(test[i+1], 0, a);
                    qs.add(q);
                    i+=5;
                }
                else if(test[i].equals("2")){
                    ArrayList<String> a1 = new ArrayList<String>();
                    ArrayList<String> a2 = new ArrayList<String>();
                    a1.add(test[i+2]);
                    a1.add(test[i+3]);
                    a1.add(test[i+4]);
                    a1.add(test[i+5]);
                    a1.add(test[i+6]);
                    a2.add(test[i+7]);
                    a2.add(test[i+8]);
                    a2.add(test[i+9]);
                    a2.add(test[i+10]);
                    a2.add(test[i+11]);
                    Matching m = new Matching(test[i+1], a1, a2, 0);
                    qs.add(m);
                    i+=11;
                }
                else{
                    SAQ s = new SAQ(test[i+1], test[i+2], 0);
                    qs.add(s);
                    i+=2;
                }
            }
            Test newTest = new Test(test[0], qs);
            tests.add(newTest);
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    public void addTest(Test a){
        tests.add(a);
        save();
    }
    
    public void removeTest(int num){
        tests.remove(num);
        save();
    }
    
    public ArrayList<Test> getTests(){
        return tests;
    }
    
    public ArrayList<String> testNames(){
        ArrayList<String> strings = new ArrayList<String>();
        for(int i = 0; i < tests.size(); i++){
            strings.add(tests.get(i).getName());
        }
        return strings;
    }    
    
    public void takeTest(){
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialog dialog = new JDialog(this, true);
        dialog.add(new chooseTest(this));
        dialog.pack();
        dialog.setVisible(true);

        refreshPanels();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JDialog dialog = new JDialog(this, true);
        dialog.add(new newTest(this));
        dialog.pack();
        dialog.setVisible(true);

        refreshPanels();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public static void ojeo() {
    /*
    if previous question was correct, difficulty goes up 1
    if incorrect, repeat question with same difficulty,
    if incorrect again, difficulty goes down 1
    */
    
    /*
    boolean incorrect=false;
    if(user.answerCorrect()&&topic.getDifficulty()!=MAX_DIFFICULTY){
        topic.setDifficulty(topic.getDifficulty()+1);
    }
    if(!user.answerCorrect()&&topic.getDifficulty()!=1&&!incorrect){
        
        incorrect = true;
        topic.setDifficulty(topic.getDifficulty());
    }
    if(!user.answerCorrect()&&topic.getDifficulty()!=1&&incorrect){
        
        incorrect = false;
        topic.setDifficulty(topic.getDifficulty()-1);
    }
    

    */
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void refreshPanels() {
        
    }
}
