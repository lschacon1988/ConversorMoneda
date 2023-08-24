package com.LuisChacon.conversor.logic;

import javax.swing.JLabel;

public class Validate {
	public Boolean Valida(String text, JLabel lbl) {
		try {
			Double x = Double.parseDouble(text);

			if (x > 0)
				;
			return true;
		} catch (NumberFormatException e) {
			lbl.setText("Solo numeros");
			return false;
		}
	}

}
