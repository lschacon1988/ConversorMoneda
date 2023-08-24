package com.LuisChacon.conversor;



import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;


import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import com.LuisChacon.conversor.logic.ConversorLogic;
import com.LuisChacon.conversor.logic.Monedas;

public class Principal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txt;
	private JButton btn;
	private JComboBox<Monedas> cmb;
	private JLabel Lbl;	
	
	private ConversorLogic conversorLogic = new ConversorLogic();
	private JPanel Jp;
	private JPanel JPbtn;
	private JPanel JpLbl;
	private JPanel JPcmb;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	

	
	public Principal() {
		initialize();
	}

 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Jp = new JPanel();
		Jp.setBounds(29, 22, 138, 208);
		frame.getContentPane().add(Jp);
		
		JPcmb = new JPanel();
		JPcmb.setPreferredSize(new Dimension(120, 60));
		Jp.add(JPcmb);
		
		cmb = new JComboBox<Monedas>();
		JPcmb.add(cmb);
		cmb.setForeground(new Color(128, 0, 0));
		cmb.setModel(new DefaultComboBoxModel<Monedas>(Monedas.values()));
		
		JPanel JPtxt = new JPanel();
		JPtxt.setPreferredSize(new Dimension(120, 60));
		Jp.add(JPtxt);
		txt = new JTextField();
		JPtxt.add(txt);
		txt.setColumns(10);
		
		JPbtn = new JPanel();
		JPbtn.setPreferredSize(new Dimension(120, 60));
		JPbtn.setSize(new Dimension(24, 32));
		Jp.add(JPbtn);
		
		btn = new JButton("Convertir");
		JPbtn.add(btn);
		btn.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				conversorLogic.convertir(cmb, Lbl, txt);
			}
		});
		
		JPanel JpTitle = new JPanel();
		JpTitle.setPreferredSize(new Dimension(120, 10));
		JpTitle.setBounds(209, 22, 197, 208);
		frame.getContentPane().add(JpTitle);
		
		JPanel JplblTitle = new JPanel();
		JplblTitle.setPreferredSize(new Dimension(180, 28));
		JpTitle.add(JplblTitle);
		
		lblNewLabel = new JLabel("Conversor \nde\n monedas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(180, 25));
		JplblTitle.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(190, 5));
		JpTitle.add(separator);
		
		JpLbl = new JPanel();
		JpTitle.add(JpLbl);
		JpLbl.setPreferredSize(new Dimension(120, 25));
		
		Lbl = new JLabel("00.00");
		JpLbl.add(Lbl);
		
		separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(190, 10));
		JpTitle.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\conversor\\src\\main\\resources\\icono2.png"));
		lblNewLabel_1.setPreferredSize(new Dimension(100, 100));
		JpTitle.add(lblNewLabel_1);
	}
	
	public JFrame getFrame() {
		return this.frame;
		
	}
	

}
