package menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import frame.Frame;
import file_management.File_management;

public class Menu {
	
	private JFrame 	menu;
	private JLabel 	gamename;
	private JButton new_game;
	private JButton saved_game;
	private JButton quit;
	private JPanel 	panel;
	private File_management fm;
	
	public Menu(){
		gamename		= new JLabel("Wireworld",SwingConstants.CENTER);
		menu 			= new JFrame("Kovács Máté - Wireworld");
		new_game 		= new JButton("New game");
		saved_game 		= new JButton("Saved game");
		quit 			= new JButton("Quit");
		panel 			= new JPanel();
		fm				= new File_management();
		
		//Egyéb beállítások
				menu.setResizable(false);
				menu.setSize(700,800);
				gamename.setFont(new Font("Verdana",1,20));
		
		//ActionListenerek
		
		
		new_game.addActionListener(new New_GameButtonActionListener());
		saved_game.addActionListener(new Saved_GameButtonActionListener());
		quit.addActionListener(new QuitButtonActionListener());
		
		//Csoportosítás
		
		//new_game.setPreferredSize(new Dimension(400, 80));
		panel.add(new_game);
		panel.add(saved_game);
		panel.add(quit);
		
			
		//Framehez adás
		menu.add(gamename,BorderLayout.NORTH);
		menu.add(panel,BorderLayout.SOUTH);
		
		menu.setVisible(true);
	}
	
	//ActionListenerek
	public class New_GameButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Frame f = new Frame();
			menu.remove(gamename);
			menu.remove(panel);
			f.megjelenit(menu);
		}	
	}
	
	public class Saved_GameButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Frame f = new Frame(fm.loading("savedgame.txt"));
				menu.remove(gamename);
				menu.remove(panel);
				f.megjelenit(menu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public class QuitButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
