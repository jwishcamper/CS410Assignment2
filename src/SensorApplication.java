import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(4,1));
		
		SensorAdapter sA = new SensorAdapter();
		
		//Pressure
		JPanel  pressurePnl = new JPanel();
		pressurePnl.setLayout(new GridLayout(2,3));
		JLabel pressureLevel = new JLabel();
		JPanel Pressure[] = new JPanel[6];
		pressurePnl.setBorder(new TitledBorder(sA.getPressureName()));
		add(pressurePnl);
		for(int i=0;i<6;i++) {
			Pressure[i]=new JPanel();
			if(i==4)
				pressurePnl.add(pressureLevel);
			else
				pressurePnl.add(Pressure[i]);
		}
		
		//Radiation 
		JPanel  radiationPnl = new JPanel();
		radiationPnl.setLayout(new GridLayout(2,3));
		JLabel radiationLevel = new JLabel();
		JPanel Radiation[] = new JPanel[6];
		radiationPnl.setBorder(new TitledBorder(sA.getRadiationName()));
		add(radiationPnl);
		for(int i=0;i<6;i++) {
			Radiation[i]=new JPanel();
			if(i==4)
				radiationPnl.add(radiationLevel);
			else
				radiationPnl.add(Radiation[i]);
		}
		
		//Temperature
		JPanel  temperaturePnl = new JPanel();
		temperaturePnl.setLayout(new GridLayout(2,3));
		JLabel temperatureLevel = new JLabel();
		JPanel Temperature[] = new JPanel[6];
		temperaturePnl.setBorder(new TitledBorder(sA.getTemperatureName()));
		add(temperaturePnl);
		for(int i=0;i<6;i++) {
			Temperature[i]=new JPanel();
			if(i==4)
				temperaturePnl.add(temperatureLevel);
			else
				temperaturePnl.add(Temperature[i]);
		}
		
		JButton runTest = new JButton("Run Sensor Diagnostics");
		JPanel buttonPnl = new JPanel();
		buttonPnl.setLayout(new GridLayout(3,3));
		JPanel Blank[] = new JPanel[9];
		add(buttonPnl);
		for(int i=0;i<9;i++) {
			Blank[i]=new JPanel();
			if(i==4)
				buttonPnl.add(runTest);
			else
				buttonPnl.add(Blank[i]);
		}
		
		runTest.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { //logic for clear button
					
					//clear current levels
					for(int i =0;i<3;i++) {
						Pressure[i].setBackground(null);
						Radiation[i].setBackground(null);
						Temperature[i].setBackground(null);
					}
					
					//Logic for Pressure
					double pLev = sA.getPressureValue();
					pressureLevel.setText(sA.getPressureReading() +" --> "+pLev);
					if(pLev<=5)
						Pressure[0].setBackground(Color.green); //levels OK
					else if (pLev<=6.58) {
						Pressure[0].setBackground(Color.yellow); //levels Critical
						Pressure[1].setBackground(Color.yellow);
					}
					else if (pLev>6.58) {
						Pressure[0].setBackground(Color.red); //levels Danger
						Pressure[1].setBackground(Color.red);
						Pressure[2].setBackground(Color.red);
					}
					
					//Logic for Radiation
					double rLev = sA.getRadiationValue();
					radiationLevel.setText(sA.getRadiationReading() +" --> "+rLev);
					if(rLev<=3)
						Radiation[0].setBackground(Color.green); //levels OK
					else if (rLev<=4) {
						Radiation[0].setBackground(Color.yellow); //levels Critical
						Radiation[1].setBackground(Color.yellow);
					}
					else if (rLev>4) {
						Radiation[0].setBackground(Color.red); //levels Danger
						Radiation[1].setBackground(Color.red);
						Radiation[2].setBackground(Color.red);
					}
					
					//Logic for Temperature
					double tLev = sA.getTemperatureValue();
					temperatureLevel.setText(sA.getTemperatureReading()+" --> "+tLev);
					if(tLev<=235)
						Temperature[0].setBackground(Color.green); //levels OK
					else if (tLev<=300) {
						Temperature[0].setBackground(Color.yellow); //levels Critical
						Temperature[1].setBackground(Color.yellow);
					}
					else if (tLev>300) {
						Temperature[0].setBackground(Color.red); //levels Danger
						Temperature[1].setBackground(Color.red);
						Temperature[2].setBackground(Color.red);
					}
					
				}
			});
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}
