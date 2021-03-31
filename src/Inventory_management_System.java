import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.*;

public class Inventory_management_System extends JFrame {


    private JPanel contentpane;
    private JButton totalButton;
    private JButton resetButton;
    private JButton exitButton;
    private JTextField nametxt;
    private JTextField addresstxt;
    private JTextField pcodetxt;
    private JTextField teltxt;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField carmileagetxt;
    private JTextField costcartxt;
    private JTextField taxtxt;
    private JTextField sbtotaltxt;
    private JTextField tctxt;
    private JTextField ghpstxt;
    private JTextField cdtxt;
    private JTextField interiortxt;
    private JTextField modifiedtxt;
    private JTextField stereotxt;
    private JCheckBox gpscheckbox;
    private JCheckBox cdcheckbox;
    private JCheckBox LIcheckbox;
    private JCheckBox Modifiedcheckbox;
    private JCheckBox Stereocheckbox;
    private JTextField mailtxt;
    private JLabel namelabel;
    private JLabel addresslabel;
    private JLabel pcodelabel;
    private JLabel Tellabel;
    private JLabel maillabel;
    private JFrame frame;

    public Inventory_management_System(String name){
        super(name);
        this.setDefaultCloseOperation(Inventory_management_System.EXIT_ON_CLOSE);
        this.setContentPane(contentpane);

        setBounds(0,0,1380,800);

        exitButton.addActionListener(e -> {
           frame = new JFrame("EXIT");
           if(JOptionPane.showConfirmDialog(frame,"Confirm ,if you want to exit","Vehicle Inventory System",
                   JOptionPane.YES_NO_OPTION )== JOptionPane.YES_NO_OPTION){//Confirming from the user if he or she wants to exit//
               System.exit(0);
           }

        });
        resetButton.addActionListener(e -> {
            nametxt.setText(null);
            addresstxt.setText(null);
            teltxt.setText(null);
            mailtxt.setText(null);
            pcodetxt.setText(null);
            carmileagetxt.setText("0");
            costcartxt.setText("0");
            ghpstxt.setText("0");
            cdtxt.setText("0");
            interiortxt.setText("0");
            modifiedtxt.setText("0");
            stereotxt.setText("0");
            taxtxt.setText(null);
            tctxt.setText(null);
            sbtotaltxt.setText(null);

            comboBox1.setSelectedItem("Select a Car");
            comboBox2.setSelectedItem("Mileage");

            gpscheckbox.setSelected(false);
            cdcheckbox.setSelected(false);
            LIcheckbox.setSelected(false);
            Modifiedcheckbox.setSelected(false);
            Stereocheckbox.setSelected(false);



        });
        comboBox1.addActionListener(e -> {
            if(comboBox1.getSelectedItem().equals("Bugati")){
                costcartxt.setText("100000");
            }
            if(comboBox1.getSelectedItem().equals("Maruti")){
                costcartxt.setText("2565880");
            }
            if(comboBox1.getSelectedItem().equals("Suzuki")){
                costcartxt.setText("363220");
            }
            if(comboBox1.getSelectedItem().equals("Ferrari")){
                costcartxt.setText("4075512");
            }
            if(comboBox1.getSelectedItem().equals("Kwid")){
                costcartxt.setText("507855");
            }
        });
        comboBox2.addActionListener(e -> {
            if(comboBox2.getSelectedItem().equals("1-5000")){
                carmileagetxt.setText("10000");
            }
            if(comboBox2.getSelectedItem().equals("5000-10000")){
                carmileagetxt.setText("200000");
            }if(comboBox2.getSelectedItem().equals("10000-15000")){
                carmileagetxt.setText("300000");
            }if(comboBox2.getSelectedItem().equals("15000-20000")){
                carmileagetxt.setText("445520");
            }if(comboBox2.getSelectedItem().equals(" 20000-40000")){
                carmileagetxt.setText("5057552");
            }



        });
        gpscheckbox.addActionListener(e -> {
            if (gpscheckbox.isSelected()==true){
                ghpstxt.setText("350");
            }
            else if (gpscheckbox.isSelected()==false){
                ghpstxt.setText("0");
            }
        });
        cdcheckbox.addActionListener(e -> {
            if (cdcheckbox.isSelected()){
                cdtxt.setText("450");
            }
            else  if (!cdcheckbox.isSelected()){
                cdtxt.setText("0");
            }

        });
        LIcheckbox.addActionListener(e -> {
            if (LIcheckbox.isSelected()){
                interiortxt.setText("550");
            }
           else if (!LIcheckbox.isSelected()){
                interiortxt.setText("550");
            }
        });
        Modifiedcheckbox.addActionListener(e -> {
            if (Modifiedcheckbox.isSelected()){
                modifiedtxt.setText("650");
            }
          else  if (!Modifiedcheckbox.isSelected()){
                modifiedtxt.setText("650");
            }

        });
        Stereocheckbox.addActionListener(e -> {
            if (Stereocheckbox.isSelected()){
                stereotxt.setText("750");
            }
           else if (!Stereocheckbox.isSelected()){
                stereotxt.setText("750");
            }

        });
        totalButton.addActionListener(e -> {
           double[] Carcost = new double[10];
             Carcost[0]= parseDouble(costcartxt.getText());
             Carcost[1]= parseDouble(carmileagetxt.getText());
             Carcost[2]= parseDouble(ghpstxt.getText());
             Carcost[3]= parseDouble(cdcheckbox.getText());
             Carcost[4]= parseDouble(interiortxt.getText());
            Carcost[5]= parseDouble(modifiedtxt.getText());
            Carcost[6]= parseDouble(stereotxt.getText());
            Carcost[7]=Carcost[0]-Carcost[1];
            Carcost[8]=Carcost[2]+Carcost[3]+Carcost[4]+Carcost[5]+Carcost[6]+Carcost[7];
            Carcost[9]=(Carcost[8]*300)/100;

String subtotal= String.format("$",Carcost[8]);
            sbtotaltxt.setText(subtotal);

            String taxtotal= String.format("$",Carcost[9]);
            taxtxt.setText(taxtotal);

            String total= String.format("$",(Carcost[8]+Carcost[9]));
            tctxt.setText(total);



        });
    }

    public static void main(String []args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame imsframe = new Inventory_management_System("Inventory Management System");
                    imsframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
