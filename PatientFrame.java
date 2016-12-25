package hospital.frame;
import hospital.util.JdbcUtil;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PatientFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm1 = new Frame("医院管理系统");

	// 管理系统病人资料界面
	// Ａ病人基本资料
	Label labe1 = new Label("    Ａ病人基本资料：  （注意：查询，删除请输入病人者姓名）");
	Button btn1 = new Button("病人编号");
	Button btn2 = new Button("姓名");
	Button btn3 = new Button("性别");
	Button btn4 = new Button("出生年月");
	Button btn5 = new Button("出生地");
	Button btn6 = new Button("籍贯");
	Button btn7 = new Button("住院情况");
	Button btn8 = new Button("预交住院费(元)");

	Button addA = new Button("Ａ录入");
	Button delA = new Button("Ａ删除");
	// Button updateA = new Button("Ａ更新");
	Button qryA = new Button("Ａ查询");

	TextField txf1 = new TextField();
	TextField txf2 = new TextField();
	TextField txf3 = new TextField();
	TextField txf4 = new TextField();
	TextField txf5 = new TextField();
	TextField txf6 = new TextField();
	TextField txf7 = new TextField();
	TextField txf8 = new TextField();

	// Ｂ病人就医档案
	Label labe2 = new Label("    Ｂ病人就医档案：（注意：查询，删除请输入病人姓名）");
	Button btnl1 = new Button("病人编号");
	Button btnl2 = new Button("病人姓名");
	Button btnl3 = new Button("就医科室");
	Button btnl4 = new Button("主治医生");
	Button btnl5 = new Button("病因");
	Button btnl6 = new Button("处方编号");
	Button btnl7 = new Button("用药编号");

	Button addB = new Button("Ｂ录入");
	Button delB = new Button("Ｂ删除");
	Button qrbB = new Button("Ｂ查询");

	TextField lst11 = new TextField();
	TextField lst12 = new TextField();
	TextField lst13 = new TextField();
	TextField lst14 = new TextField();
	TextField lst15 = new TextField();
	TextField lst16 = new TextField();
	TextField lst17 = new TextField();

	// Ｃ病人收费管理
	Label labe3 = new Label("    Ｃ病人收费管理：（注意：查询，删除请输入病人编号）　　单位：元");
	Button btnk1 = new Button("病人编号");
	Button btnk2 = new Button("药物费用");
	Button btnk3 = new Button("挂号费");
	Button btnk4 = new Button("处置费");
	Button btnk5 = new Button("化验费");

	Button addC = new Button("Ｃ录入");
	Button delC = new Button("Ｃ删除");
	Button qryC = new Button("Ｃ查询");

	TextField lst21 = new TextField();
	TextField lst22 = new TextField();
	TextField lst23 = new TextField();
	TextField lst24 = new TextField();
	TextField lst25 = new TextField();



	
	public void clearFrameA(){
		 txf1.setText("");
		 txf2.setText("");
		 txf3.setText("");
		 txf4.setText("");
		 txf5.setText("");
		 txf6.setText("");
		 txf7.setText("");
		 txf8.setText("");
	}
	public void clearFrameB(){

		 lst11.setText("");
		 lst12.setText("");
		 lst13.setText("");
		 lst14.setText("");
		 lst15.setText("");
		 lst16.setText("");
		 lst17.setText("");
	}
	public void clearFrameC(){
		 lst21.setText("");
		 lst22.setText("");
		 lst23.setText("");
		 lst24.setText("");
		 lst25.setText("");
	}
	public PatientFrame() {
		addA.addActionListener(this);
		delA.addActionListener(this);
		// updateA.addActionListener(this);
		qryA.addActionListener(this);
		addB.addActionListener(this);
		delB.addActionListener(this);
		// updateB.addActionListener(this);
		qrbB.addActionListener(this);
		addC.addActionListener(this);
		delC.addActionListener(this);
		// udpateC.addActionListener(this);
		qryC.addActionListener(this);

		// 病人资料管理界面
		// 1部分
		labe1.setBounds(0, 30, 1024, 20);
		btn1.setBounds(5, 50, 95, 15);
		txf1.setBounds(5, 65, 95, 20);
		btn2.setBounds(100, 50, 80, 15);
		txf2.setBounds(100, 65, 80, 20);
		btn3.setBounds(180, 50, 40, 15);
		txf3.setBounds(180, 65, 40, 20);
		btn4.setBounds(220, 50, 100, 15);
		txf4.setBounds(220, 65, 100, 20);
		btn5.setBounds(320, 50, 120, 15);
		txf5.setBounds(320, 65, 120, 20);
		btn6.setBounds(440, 50, 80, 15);
		txf6.setBounds(440, 65, 80, 20);
		btn7.setBounds(520, 50, 100, 15);
		txf7.setBounds(520, 65, 100, 20);
		btn8.setBounds(620, 50, 100, 15);
		txf8.setBounds(620, 65, 100, 20);
		addA.setBounds(105, 95, 50, 20);
		delA.setBounds(260, 95, 50, 20);
		// updateA.setBounds(415, 95, 50, 20);
		qryA.setBounds(415, 95, 50, 20);

		
		frm1.add(labe1);
		frm1.add(btn1);
		frm1.add(btn2);
		frm1.add(btn3);
		frm1.add(btn4);
		frm1.add(btn5);
		frm1.add(btn6);
		frm1.add(btn7);
		frm1.add(btn8);
		frm1.add(addA);
		frm1.add(delA);
		// frm1.add(updateA);
		frm1.add(qryA);

		frm1.add(txf1);
		frm1.add(txf2);
		frm1.add(txf3);
		frm1.add(txf4);
		frm1.add(txf5);
		frm1.add(txf6);
		frm1.add(txf7);
		frm1.add(txf8);

		// 2部分
		labe2.setBounds(0, 145, 1024, 20);
		btnl1.setBounds(5, 165, 95, 15);
		btnl2.setBounds(100, 165, 80, 15);
		btnl3.setBounds(180, 165, 60, 15);
		btnl4.setBounds(240, 165, 80, 15);
		btnl5.setBounds(320, 165, 40, 15);
		btnl6.setBounds(360, 165, 80, 15);
		btnl7.setBounds(440, 165, 280, 15);
		addB.setBounds(105, 210, 50, 20);
		delB.setBounds(260, 210, 50, 20);
		// updateB.setBounds(415, 210, 50, 20);
		qrbB.setBounds(415, 210, 50, 20);
		lst11.setBounds(5, 180, 95, 20);
		lst12.setBounds(100, 180, 80, 20);
		lst13.setBounds(180, 180, 60, 20);
		lst14.setBounds(240, 180, 80, 20);
		lst15.setBounds(320, 180, 40, 20);
		lst16.setBounds(360, 180, 80, 20);
		lst17.setBounds(440, 180, 280, 20);

		frm1.add(labe2);
		frm1.add(btnl1);
		frm1.add(btnl2);
		frm1.add(btnl3);
		frm1.add(btnl4);
		frm1.add(btnl5);
		frm1.add(btnl6);
		frm1.add(btnl7);
		frm1.add(addB);
		frm1.add(delB);
		// frm1.add(updateB);
		frm1.add(qrbB);

		frm1.add(lst11);
		frm1.add(lst12);
		frm1.add(lst13);
		frm1.add(lst14);
		frm1.add(lst15);
		frm1.add(lst16);
		frm1.add(lst17);

		// 3部分
		labe3.setBounds(0, 270, 1024, 20);
		btnk1.setBounds(5, 290, 95, 15);
		btnk2.setBounds(100, 290, 120, 15);
		btnk3.setBounds(220, 290, 120, 15);
		btnk4.setBounds(340, 290, 120, 15);
		btnk5.setBounds(460, 290, 120, 15);
		// btnk6.setBounds(580,290,140,15);
		addC.setBounds(105, 335, 50, 20);
		delC.setBounds(260, 335, 50, 20);
		// udpateC.setBounds(415, 335, 50, 20);
		qryC.setBounds(415, 335, 50, 20);
		lst21.setBounds(5, 305, 95, 20);
		lst22.setBounds(100, 305, 120, 20);
		lst23.setBounds(220, 305, 120, 20);
		lst24.setBounds(340, 305, 120, 20);
		lst25.setBounds(460, 305, 120, 20);
		// lst26.setBounds(580,305,140,20);

		frm1.add(labe3);
		frm1.add(btnk1);
		frm1.add(btnk2);
		frm1.add(btnk3);
		frm1.add(btnk4);
		frm1.add(btnk5);
		// frm1.add(btnk6);
		frm1.add(addC);
		frm1.add(delC);
		// frm1.add(udpateC);
		frm1.add(qryC);
		frm1.add(lst21);
		frm1.add(lst22);
		frm1.add(lst23);
		frm1.add(lst24);
		frm1.add(lst25);
		// frm1.add(lst26);

		frm1.setLayout(null);
		frm1.setBounds(500, 200, 725, 395);
		frm1.setBackground(Color.ORANGE);
		frm1.setVisible(true);

		// 实现窗口关闭按扭的事件
		frm1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm1.dispose();
			}
		});

		frm1.setResizable(false);// 固定窗口的大小

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
