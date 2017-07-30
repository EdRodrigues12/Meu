package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class Principal2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textName1;
	private JTextField textName2;
	private JTextField textName3;
	private JLabel lblplay1;
	private JLabel lblPlay2;
	private JLabel lblPlay3;
	JRadioButton rdbtnOne;
	JRadioButton rdbtnTwo;
	JRadioButton rdbtnThree;
	ButtonGroup buttonGroup1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayers = new JLabel("Number of players");
		lblPlayers.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 11));
		lblPlayers.setBounds(10, 69, 127, 14);
		contentPane.add(lblPlayers);
		
		rdbtnOne = new JRadioButton("One", false);
		rdbtnOne.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnOne.setBounds(10, 95, 109, 23);
		contentPane.add(rdbtnOne);
		//rdbtnOne.setSelected(true);
			
		buttonGroup1 = new ButtonGroup();
		rdbtnTwo = new JRadioButton("Two", false);
		rdbtnTwo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnTwo.setBounds(10, 121, 109, 23);
		contentPane.add(rdbtnTwo);
		
		rdbtnThree = new JRadioButton("Three",false);
		rdbtnThree.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnThree.setBounds(10, 147, 109, 23);
		contentPane.add(rdbtnThree);
		
		lblplay1 = new JLabel("Name Player 1");
		lblplay1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblplay1.setBounds(10, 197, 95, 14);
		contentPane.add(lblplay1);
		lblplay1.setVisible(false);
		
		lblPlay2 = new JLabel("Name Player 2");
		lblPlay2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblPlay2.setBounds(10, 222, 95, 14);
		contentPane.add(lblPlay2);
		lblPlay2.setVisible(false);
		
		lblPlay3 = new JLabel("Name Player 3");
		lblPlay3.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblPlay3.setBounds(10, 247, 95, 14);
		contentPane.add(lblPlay3);
		lblPlay3.setVisible(false);
		
		textName1 = new JTextField();
		textName1.setText("");
		textName1.setBounds(115, 195, 133, 20);
		contentPane.add(textName1);
		textName1.setColumns(10);
		textName1.setVisible(false);
		
		textName2 = new JTextField();
		textName2.setText("");
		textName2.setBounds(115, 220, 133, 20);
		contentPane.add(textName2);
		textName2.setColumns(10);
		textName2.setVisible(false);
		
		textName3 = new JTextField();
		textName3.setText("");
		textName3.setBounds(115, 245, 133, 20);
		contentPane.add(textName3);
		textName3.setColumns(10);
		textName3.setVisible(false);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Arial Black", Font.ITALIC, 11));
		btnPlay.setForeground(Color.GREEN);
		btnPlay.setBounds(159, 284, 89, 23);
		contentPane.add(btnPlay);
		
		JLabel lblTheFuckBoardgame = new JLabel("The FUCK BoardGame");
		lblTheFuckBoardgame.setForeground(Color.BLUE);
		lblTheFuckBoardgame.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
		lblTheFuckBoardgame.setBounds(139, 11, 144, 14);
		contentPane.add(lblTheFuckBoardgame);
		
		btnPlay.addActionListener(this);
		rdbtnOne.addActionListener(this);
		rdbtnTwo.addActionListener(this);
		rdbtnThree.addActionListener(this);
		
		buttonGroup1.add(rdbtnOne);
		buttonGroup1.add(rdbtnThree);
		buttonGroup1.add(rdbtnTwo);
		
		
		}
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();
	    
	    if ("Play".equals(cmd) && rdbtnThree.isSelected() && !textName3.getText().equals("") && !textName2.getText().equals("") 
	    		&& !textName1.getText().equals("")) {
			BoardGame bg = null;
			bg = new BoardGame();
			bg.show();
			textName3.setText("");
			textName2.setText("");
			textName1.setText("");
			
		}
	   
	    
	    else if ("Play".equals(cmd) && rdbtnTwo.isSelected()&& !textName2.getText().equals("") 
	    		&& !textName1.getText().equals("") ) {
			BoardGame bg = null;
			bg = new BoardGame();
			bg.show();
			textName3.setText("");
			textName2.setText("");
			textName1.setText("");
		}
	    
	    else if ("Play".equals(cmd) && rdbtnOne.isSelected() && !textName1.getText().equals("") ) {
			BoardGame bg = null;
			bg = new BoardGame();
			bg.show();
			textName3.setText("");
			textName2.setText("");
			textName1.setText("");
		}
	    
	   	  	    
	    else if (rdbtnOne.isSelected()) { 
				lblplay1.setVisible(true);
				textName1.setVisible(true);
				//contentPane.add(textName1);
				lblPlay2.setVisible(false);
				textName2.setVisible(false);
				lblPlay3.setVisible(false);
				textName3.setVisible(false);
				
			}
			
			else if (rdbtnTwo.isSelected()) { 
				lblplay1.setVisible(true);
				lblPlay2.setVisible(true);
				//contentPane.add(lblplay1);
				//contentPane.add(textName1);
				//contentPane.add(lblPlay2);
				//contentPane.add(textName2);
				textName2.setVisible(true);
				textName1.setVisible(true);
				lblPlay3.setVisible(false);
				textName3.setVisible(false);
			}
			
			else if (rdbtnThree.isSelected()) { 
				lblplay1.setVisible(true);
				lblPlay2.setVisible(true);
				lblPlay3.setVisible(true);
//				contentPane.add(lblplay1);
//				contentPane.add(textName1);
//				contentPane.add(lblPlay2);
//				contentPane.add(textName2);
//				contentPane.add(lblPlay3);
//				contentPane.add(textName3);
				textName1.setVisible(true);
				textName3.setVisible(true);
				textName2.setVisible(true);
			}
	    
			 else if("Play".equals(cmd) && textName3.getText().equals("")&& textName2.getText().equals("")&& textName1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Enter the names of players MOTHERFUCK", "Erro", JOptionPane.ERROR_MESSAGE);
					
				}
		
			
			else {
				JOptionPane.showMessageDialog(null, "Choose the number of players MOTHERFUCK", "Erro", JOptionPane.ERROR_MESSAGE);
				
			}
		}
	
		
	
	}

