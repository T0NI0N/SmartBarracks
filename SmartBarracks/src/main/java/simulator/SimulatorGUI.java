package simulator;

import devices.Device;
import devices.IODevice;
import devices.AnalogicalDevice;
import devices.DigitalDevice;
import drivers.TCPServerDriver;

import javax.swing.*;
import java.awt.*;

public class SimulatorGUI extends JFrame {

    public Device devices;
    public static SimulatorGUI instance;

    private JPanel commonAreaPanel;
    private JPanel foodStoragePanel;
    private JPanel dormitoryPanel;
    private JPanel armoryPanel;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

    private AnalogValue analogValue1;
    private AnalogValue analogValue2;
    private AnalogValue analogValue3;
    private AnalogValue analogValue4;
    private AnalogValue analogValue5;
    private AnalogValue analogValue6;
    private AnalogValue analogValue7;
    private AnalogValue analogValue8;
    private AnalogValue analogValue9;
    private AnalogValue analogValue10;
    private DigitValue digitValue1;
    private DigitValue digitValue2;
    private DigitValue digitValue3;
    private DigitValue digitValue4;
    private DigitValue digitValue5;
    private DigitValue digitValue6;
    private DigitValue digitValue7;
    private DigitValue digitValue8;
    private DigitValue digitValue9;
    private DigitValue digitValue10;
    private DigitValue digitValue11;
    private DigitValue digitValue12;
    private DigitValue digitValue13;
    private DigitValue digitValue14;
    private DigitValue digitValue15;
    private DigitValue digitValue16;
    private DigitValue digitValue17;

    public SimulatorGUI() {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        setTitle("Smart Barracks Monitoring System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 6, 6)); // GridLayout 2x2 con spaziatura tra i pannelli
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // Aggiungi spazio esterno

        commonAreaPanel = createPanelWithCommonArea();
        foodStoragePanel = createPanelWithFoodStorage();
        dormitoryPanel = createPanelWithDormitory();
        armoryPanel = createPanelWithArmory();

        mainPanel.add(commonAreaPanel);
        mainPanel.add(foodStoragePanel);
        mainPanel.add(dormitoryPanel);
        mainPanel.add(armoryPanel);

        instance = this;

        setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(1400, 500));
        pack(); // Ridimensiona il frame per adattarsi ai contenuti

        Runnable task = () -> {
            devices = new Device("SmartBarracks");

            ///////////// COMMON AREA ///////////////////////
            IODevice tmp = new AnalogicalDevice("Temperature");
            devices.addDevice(tmp);
            analogValue1.setDevice(tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("HVAC");
            devices.addDevice(tmp);
            digitValue1.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            tmp = new AnalogicalDevice("CO2");
            devices.addDevice(tmp);
            analogValue8.setDevice(tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("Fire Alarm");
            devices.addDevice(tmp);
            digitValue2.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("Movement");
            devices.addDevice(tmp);
            digitValue3.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("Light");
            devices.addDevice(tmp);
            digitValue4.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            ////////////// FOOD STORAGE //////////////////////
            tmp = new AnalogicalDevice("Temperature");
            devices.addDevice(tmp);
            analogValue2.setDevice(tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("HVAC");
            devices.addDevice(tmp);
            digitValue5.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            tmp = new AnalogicalDevice("CO2");
            devices.addDevice(tmp);
            analogValue9.setDevice(tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("Fire Alarm");
            devices.addDevice(tmp);
            digitValue6.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            tmp = new AnalogicalDevice("Humidity");
            devices.addDevice(tmp);
            analogValue3.setDevice(tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("Movement");
            devices.addDevice(tmp);
            digitValue17.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            tmp = new DigitalDevice("Light");
            devices.addDevice(tmp);
            digitValue7.setDevice((DigitalDevice) tmp);
            //System.out.println(tmp.getIDX());

            ////////////// DORMITORY //////////////////////
            tmp = new AnalogicalDevice("Temperature");
            devices.addDevice(tmp);
            analogValue4.setDevice(tmp);

            tmp = new DigitalDevice("HVAC");
            devices.addDevice(tmp);
            digitValue8.setDevice((DigitalDevice) tmp);   

            tmp = new AnalogicalDevice("CO2");
            devices.addDevice(tmp);
            analogValue5.setDevice(tmp);

            tmp = new DigitalDevice("Fire Alarm");
            devices.addDevice(tmp);
            digitValue9.setDevice((DigitalDevice) tmp);

            tmp = new DigitalDevice("Light");
            devices.addDevice(tmp);
            digitValue10.setDevice((DigitalDevice) tmp);

            ////////////// ARMORY //////////////////////
            tmp = new AnalogicalDevice("Temperature");
            devices.addDevice(tmp);
            analogValue6.setDevice(tmp);

            tmp = new DigitalDevice("HVAC");
            devices.addDevice(tmp);
            digitValue11.setDevice((DigitalDevice) tmp);

            tmp = new AnalogicalDevice("CO2");
            devices.addDevice(tmp);
            analogValue10.setDevice(tmp);

            tmp = new DigitalDevice("Fire Alarm");
            devices.addDevice(tmp);
            digitValue12.setDevice((DigitalDevice) tmp);

            tmp = new AnalogicalDevice("Humidity");
            devices.addDevice(tmp);
            analogValue7.setDevice(tmp);

            tmp = new DigitalDevice("Movement");
            devices.addDevice(tmp);
            digitValue13.setDevice((DigitalDevice) tmp);

            tmp = new DigitalDevice("Light");
            devices.addDevice(tmp);
            digitValue14.setDevice((DigitalDevice) tmp);

            tmp = new DigitalDevice("Biometric");
            devices.addDevice(tmp);
            digitValue15.setDevice((DigitalDevice) tmp);

            tmp = new DigitalDevice("Intruder Alarm");
            devices.addDevice(tmp);
            digitValue16.setDevice((DigitalDevice) tmp);

            TCPServerDriver tp = new TCPServerDriver(devices);
            tp.start();
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void initComponents() {

        commonAreaPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        analogValue1 = new simulator.AnalogValue();
        digitValue1 = new simulator.DigitValue();
        digitValue2 = new simulator.DigitValue();
        digitValue3 = new simulator.DigitValue();
        digitValue4 = new simulator.DigitValue();
        analogValue8 = new simulator.AnalogValue();

        foodStoragePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        analogValue2 = new simulator.AnalogValue();
        analogValue3 = new simulator.AnalogValue();
        analogValue9 = new simulator.AnalogValue();
        digitValue5 = new simulator.DigitValue();
        digitValue6 = new simulator.DigitValue();
        digitValue7 = new simulator.DigitValue();
        digitValue17 = new simulator.DigitValue();

        dormitoryPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        analogValue4 = new simulator.AnalogValue();
        analogValue5 = new simulator.AnalogValue();
        digitValue8 = new simulator.DigitValue();
        digitValue9 = new simulator.DigitValue();
        digitValue10 = new simulator.DigitValue();

        armoryPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        analogValue6 = new simulator.AnalogValue();
        analogValue7 = new simulator.AnalogValue();
        analogValue10 = new simulator.AnalogValue();
        digitValue11 = new simulator.DigitValue();
        digitValue12 = new simulator.DigitValue();
        digitValue13 = new simulator.DigitValue();
        digitValue14 = new simulator.DigitValue();
        digitValue15 = new simulator.DigitValue();
        digitValue16 = new simulator.DigitValue();
    }

    private JPanel createPanelWithCommonArea() {

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(3, 2);
        layout.setHgap(10);
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createTitledBorder("Common Area")); // Aggiungi un bordo con titolo

        panel.add(analogValue1);
        panel.add(digitValue1);

        panel.add(analogValue8);
        panel.add(digitValue2);

        panel.add(digitValue3);
        panel.add(digitValue4);

        return panel;
    }

    private JPanel createPanelWithFoodStorage() {

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4, 2);
        layout.setHgap(10);
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createTitledBorder("Food Storage")); // Aggiungi un bordo con titolo

        panel.add(analogValue2);
        panel.add(digitValue5);

        panel.add(analogValue9);
        panel.add(digitValue6);

        panel.add(analogValue3);
        panel.add(new JLabel());
        
        panel.add(digitValue7);
        panel.add(digitValue17);

        return panel;
    }

    private JPanel createPanelWithDormitory() {

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(3, 2);
        layout.setHgap(10);
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createTitledBorder("Dormitory")); // Aggiungi un bordo con titolo

        panel.add(analogValue4);
        panel.add(digitValue8);

        panel.add(analogValue5);
        panel.add(digitValue9);

        panel.add(digitValue10);
        return panel;
    }

    private JPanel createPanelWithArmory() {

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(5, 2);
        layout.setHgap(10);
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createTitledBorder("Armory")); // Aggiungi un bordo con titolo

        panel.add(analogValue6);
        panel.add(digitValue11);

        panel.add(analogValue10);
        panel.add(digitValue12);

        panel.add(analogValue7);
        panel.add(new JLabel());
        
        panel.add(digitValue13);
        panel.add(digitValue14);

        panel.add(digitValue15);
        panel.add(digitValue16);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimulatorGUI frame = new SimulatorGUI();
            frame.setVisible(true);
        });
    }
}
