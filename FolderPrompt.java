import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class FolderPrompt extends JPanel
   implements ActionListener {
   JButton btnSelect;
   JTextField jTexttextField;
   JFileChooser folderPicker;
   String folderPickertitle;
   JLabel label;
    String sDirectory = "";
   
  public FolderPrompt() {
    btnSelect = new JButton("Please select your folder: ");
    btnSelect.addActionListener(this);
    add(btnSelect);
   }

  public void actionPerformed(ActionEvent e) {
    int result;
    
    folderPicker = new JFileChooser(); 
    folderPicker.setCurrentDirectory(new java.io.File("."));
    folderPicker.setDialogTitle(folderPickertitle);
    folderPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    
    folderPicker.setAcceptAllFileFilterUsed(false);
  
    if (folderPicker.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  folderPicker.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  folderPicker.getSelectedFile());
         sDirectory =  folderPicker.getCurrentDirectory().getAbsolutePath();
      }
    else {
      System.out.println("No Folder Selection");
      }
     }
   
  public Dimension getPreferredSize(){
    return new Dimension(400, 400);
    }
    
  public static void main(String s[]) {
    JLabel label = new JLabel("Container Folder", JLabel.CENTER);
    label.setAlignmentX(0);
    label.setAlignmentY(0);
    
    JFrame borderFrame = new JFrame("");
    
    FolderPrompt borderFramePrompt = new FolderPrompt();
    borderFrame.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );
    borderFrame.getContentPane().add(borderFramePrompt,"Center");
    borderFrame.setSize(borderFramePrompt.getPreferredSize());   
    borderFrame.setVisible(true);
    //label.setText(sDirectory);
    borderFrame.add(label);
    }
}