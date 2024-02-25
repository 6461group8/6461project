package csci6461_team8.simulator;

import javax.swing.*;
import java.awt.*;

public class SimulatorGUI {
    JFrame mainFrame = new JFrame("Simulator");
    JLabel titleLabel = new JLabel("CSCI 6461 Machine Simulator");

    // Components of GPR
    JLabel gprLabel = new JLabel("GPR");
    JLabel[] gprIndexLabels = new JLabel[4];
    JTextField[] gprContentTextFields = new JTextField[4];
    JButton[] gprLoadButtons = new JButton[4];


    // Components of IXR
    JLabel ixrLabel = new JLabel("IXR");
    JLabel[] ixrIndexLabels = new JLabel[3];
    JTextField[] ixrContentTextFields = new JTextField[3];
    JButton[] ixrLoadButtons = new JButton[3];


    // Components of PC, MAR, MBR, IR, CC and MFR
    JLabel pcLabel = new JLabel("PC");
    JLabel marLabel = new JLabel("MAR");
    JLabel mbrLabel = new JLabel("MBR");
    JLabel irLabel = new JLabel("IR");
    JLabel ccLabel = new JLabel("CC");
    JLabel mfrLabel = new JLabel("MFR");
    JTextField pcContentTextField = new JTextField("000000000000");
    JTextField marContentTextField = new JTextField("000000000000");
    JTextField mbrContentTextField = new JTextField("0000000000000000");
    JTextField irContentTextField = new JTextField("0000000000000000");
    JTextField ccContentTextField = new JTextField("0000");
    JTextField mfrContentTextField = new JTextField("0000");
    JButton pcLoadButton = new JButton();
    JButton marLoadButton = new JButton();
    JButton mbrLoadButton = new JButton();
    JLabel oudeLabel = new JLabel("OUDE");
    JLabel motrLabel = new JLabel("MOTR");

    // Components of input part
    JLabel binaryInputLabel = new JLabel("BINARY");
    JTextField binaryInputTextField = new JTextField("0000000000000000");
    JLabel octalInputLabel = new JLabel("OCTAL INPUT");
    JTextField octalInputTextField = new JTextField("0000000");

    // Components of instructions (Load, Load+, Store, Store+, Run, Step and Halt)
    JButton loadButton = new JButton();
    JLabel loadLabel = new JLabel("Load");
    JButton loadPlusButton = new JButton();
    JLabel loadPlusLabel = new JLabel("Load+");
    JButton storeButton = new JButton();
    JLabel storeLabel = new JLabel("Store");
    JButton storePlusButton = new JButton();
    JLabel storePlusLabel = new JLabel("Store+");
    JButton runButton = new JButton();
    JLabel runLabel = new JLabel("Run");
    JButton stepButton = new JButton();
    JLabel stepLabel = new JLabel("Step");
    JButton haltButton = new JButton();
    JLabel haltLabel = new JLabel("Halt");

    JButton iplButton = new JButton();
    JLabel iplLabel = new JLabel("IPL");

    JLabel programFileLabel = new JLabel("Program File");
    JTextField programFileTextField = new JTextField("");

    public void init(){
        mainFrame.setLayout(null);

        // title
        titleLabel.setBounds(275,40,200,20);
        mainFrame.add(titleLabel);

        // GPR
        gprLabel.setBounds(125,100,40,20);
        mainFrame.add(gprLabel);
        for(int i = 0; i < 4; i++){
            gprIndexLabels[i] = new JLabel(String.valueOf(i));
            gprIndexLabels[i].setBounds(40,125 + 25 * i,20,20);
            gprContentTextFields[i] = new JTextField("0000000000000000");
            gprContentTextFields[i].setBounds(65,125 + 25 * i,140,20);

            gprLoadButtons[i] = new JButton();
            gprLoadButtons[i].setBounds(210,125 + 25 * i,20,20);

            mainFrame.add(gprIndexLabels[i]);
            mainFrame.add(gprContentTextFields[i]);
            mainFrame.add(gprLoadButtons[i]);
        }

        // IXR
        ixrLabel.setBounds(355, 100, 40,20);
        mainFrame.add(ixrLabel);
        for(int i = 1; i <= 3; i++){
            ixrIndexLabels[i-1] = new JLabel(String.valueOf(i));
            ixrIndexLabels[i-1].setBounds(270, 125 + 25 * i,20,20);
            ixrContentTextFields[i-1] = new JTextField("0000000000000000");
            ixrContentTextFields[i-1].setBounds(295,125 + 25 * i,140,20);
            ixrLoadButtons[i-1] = new JButton();
            ixrLoadButtons[i-1].setBounds(440,125 + 25 * i,20,20);

            mainFrame.add(ixrIndexLabels[i-1]);
            mainFrame.add(ixrContentTextFields[i-1]);
            mainFrame.add(ixrLoadButtons[i-1]);
        }

        // PC, MAR, MBR, IR, CC, MFR
        pcLabel.setBounds(500, 125, 40, 20);
        pcContentTextField.setBounds(575, 125, 110, 20);
        pcContentTextField.setHorizontalAlignment(JTextField.RIGHT);
        pcLoadButton.setBounds(700, 125, 20, 20);
        mainFrame.add(pcLabel);
        mainFrame.add(pcContentTextField);
        mainFrame.add(pcLoadButton);

        marLabel.setBounds(500, 150, 40, 20);
        marContentTextField.setBounds(575, 150, 110, 20);
        marContentTextField.setHorizontalAlignment(JTextField.RIGHT);
        marLoadButton.setBounds(700, 150, 20, 20);
        mainFrame.add(marLabel);
        mainFrame.add(marContentTextField);
        mainFrame.add(marLoadButton);

        mbrLabel.setBounds(500, 175, 40, 20);
        mbrContentTextField.setBounds(545, 175, 140, 20);
        mbrContentTextField.setHorizontalAlignment(JTextField.RIGHT);
        mbrLoadButton.setBounds(700, 175, 20, 20);
        mainFrame.add(mbrLabel);
        mainFrame.add(mbrContentTextField);
        mainFrame.add(mbrLoadButton);

        irLabel.setBounds(500, 200, 40, 20);
        irContentTextField.setBounds(545, 200, 140, 20);
        irContentTextField.setHorizontalAlignment(JTextField.RIGHT);
        mainFrame.add(irLabel);
        mainFrame.add(irContentTextField);

        ccLabel.setBounds(595, 225, 40, 20);
        ccContentTextField.setBounds(640, 225, 45, 20);
        ccContentTextField.setHorizontalAlignment(JTextField.RIGHT);
        oudeLabel.setBounds(647,245,43,10);
        oudeLabel.setFont(new Font("Lucida",Font.PLAIN,11));
        mainFrame.add(ccLabel);
        mainFrame.add(ccContentTextField);
        mainFrame.add(oudeLabel);

        mfrLabel.setBounds(595, 260, 40, 20);
        mfrContentTextField.setBounds(640, 260, 45, 20);
        mfrContentTextField.setHorizontalAlignment(JTextField.RIGHT);
        motrLabel.setBounds(647,280,43,10);
        motrLabel.setFont(new Font("Lucida",Font.PLAIN,11));
        mainFrame.add(mfrLabel);
        mainFrame.add(mfrContentTextField);
        mainFrame.add(motrLabel);

        // input area
        octalInputLabel.setBounds(150,260,85,20);
        octalInputTextField.setBounds(240,260,70,20);
        octalInputTextField.setHorizontalAlignment(JTextField.RIGHT);
        mainFrame.add(octalInputLabel);
        mainFrame.add(octalInputTextField);

        binaryInputLabel.setBounds(150, 310, 50, 20);
        binaryInputTextField.setBounds(170,335, 140, 20);
        binaryInputTextField.setHorizontalAlignment(JTextField.RIGHT);
        mainFrame.add(binaryInputLabel);
        mainFrame.add(binaryInputTextField);

        // instructions
        loadButton.setBounds(350,260,20,20);
        loadLabel.setBounds(375,260,45,20);
        loadPlusButton.setBounds(350,285,20,20);
        loadPlusLabel.setBounds(375,285,45,20);
        storeButton.setBounds(350,310,20,20);
        storeLabel.setBounds(375,310,45,20);
        storePlusButton.setBounds(350,335,20,20);
        storePlusLabel.setBounds(375,335,45,20);
        runButton.setBounds(425, 260,20,20);
        runLabel.setBounds(450,260,30, 20);
        stepButton.setBounds(425, 285,20,20);
        stepLabel.setBounds(450,285,30, 20);
        haltButton.setBounds(425,310,20,20);
        haltLabel.setBounds(450,310,30,20);

        mainFrame.add(loadButton);
        mainFrame.add(loadLabel);
        mainFrame.add(loadPlusButton);
        mainFrame.add(loadPlusLabel);
        mainFrame.add(storeButton);
        mainFrame.add(storeLabel);
        mainFrame.add(storePlusButton);
        mainFrame.add(storePlusLabel);
        mainFrame.add(runButton);
        mainFrame.add(runLabel);
        mainFrame.add(stepButton);
        mainFrame.add(stepLabel);
        mainFrame.add(haltButton);
        mainFrame.add(haltLabel);


        // ipl
        iplButton.setBounds(640,335,20,20);
        iplLabel.setBounds(665,335,25,20);
        mainFrame.add(iplButton);
        mainFrame.add(iplLabel);


        // program file
        programFileLabel.setBounds(40,395,80,20);
        programFileTextField.setBounds(125,395,560,20);
        mainFrame.add(programFileLabel);
        mainFrame.add(programFileTextField);





        mainFrame.setSize(750, 500);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimulatorGUI().init();
    }




}
