package net.soartex.patcher.listeners;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;

import javax.swing.JFileChooser;


import net.soartex.patcher.Patch_Controller;
import net.soartex.patcher.Soartex_Patcher;
import net.soartex.patcher.helpers.Strings;

public class MainMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//website
		if(e.getActionCommand().equals(Strings.MENU_DATA[0])){
			try {
				Desktop.getDesktop().browse(new URI( "http://soartex.net/"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[1])){
			System.out.println("*Hide Console Clicked*");
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[2])){
			System.out.println("*Show Lastest Textures Clicked*");
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[3])){
			System.out.println("*Soartex Modded*");
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[4])){
			System.out.println("*Soartex FTB*");
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[5])){
			System.out.println("*Soartex Custom*");
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[6])){
			System.out.println("*Browsed Clicked*");
			Soartex_Patcher.browseFiles();
		}
		else if(e.getActionCommand().equals(Strings.MENU_DATA[7])){
			//create patch controller...and patch
			//need to send location of .zip
			System.out.println("*Patched Clicked*");
			Thread thread = new Thread(){
				public void run(){
					if(!Strings.MODDEDZIP_LOCATION.equals("")){
						Patch_Controller temp= new Patch_Controller(Strings.MODDEDZIP_LOCATION);
						temp.run();
					}
					else{
						System.out.println("==================");
						System.out.println("Error: Path not Set!");
						System.out.println("==================");
					}
				}
			};
			thread.start();
		}
	}
}
