package Simuetec.Util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;

public class Limpar {
	public void Limpar(Container container){
		for(Component c : container.getComponents()){
			if(c instanceof JTextField){
				JTextField f = (JTextField)c;
				f.setText("");
			}
			else if( c instanceof Container){
				Limpar ((Container)c);
			}
		}
	}
}
