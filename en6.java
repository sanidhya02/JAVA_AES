package encryption;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class en6 extends javax.swing.JFrame {

   
    public en6() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        file_path = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
         jokey=new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Choose");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Encrypt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Decrypt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                  
                    .addGroup(layout.createSequentialGroup()
                    		.addGap(130, 130, 130)
                        .addComponent(jokey, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                      
                     
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(349, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30,30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(jokey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                    .addGap(69, 69, 69)
                    
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(313, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        file_path.setText(f.getAbsolutePath());
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
       
        try{
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("C:\\Users\\sanid\\Pictures\\13");
            byte k[]=jokey.getText().getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The file encrypted Successfully");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
       
        try{
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("C:\\Users\\sanid\\Pictures\\12");
            byte k[]=jokey.getText().getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The image was decrypted successfully");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(en6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(en6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(en6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(en6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new en6().setVisible(true);
            }
        });
    }
    
    private javax.swing.JTextField file_path;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jokey;
   
}

