package hospital.frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Label;

public class MainFunction implements ActionListener {

	Frame frmX = new Frame("医院管理系统");

	Label k1 = new Label("欢迎使用医院管理系统");
	Button patientInfo = new Button("病人资料管理");


	public MainFunction() {

		k1.setBounds(110, 50, 150, 30);
		patientInfo.setBounds(70, 100, 90, 30);
		price.setBounds(210, 100, 90, 30);
		chufang.setBounds(70, 180, 90, 30);
		emp.setBounds(210, 180, 90, 30);
		frmX.add(k1);
		frmX.add(patientInfo);
		frmX.add(price);
		frmX.add(chufang);
		frmX.add(emp);

		patientInfo.addActionListener(this);
		price.addActionListener(this);
		chufang.addActionListener(this);
		emp.addActionListener(this);

		frmX.setLayout(null);
		frmX.setBackground(Color.ORANGE);
		frmX.setBounds(500, 200, 350, 270);
		frmX.setVisible(true);
		
		frmX.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmX.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();
		if (soruce == patientInfo) {
			new PatientFrame();
		}
		if (soruce == price) {
			new MedicineFrame();
		}
		if (soruce == chufang) {
			new ChufangFrame();
		}
		if (soruce == emp) {
			new EmpFrame();
		}
	}
}
