package com.LuisChacon.conversor.logic;

import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversorLogic {

	private DecimalFormat format = new DecimalFormat("0.0000");
	public HttpRequest tazasApi = new HttpRequest("http://data.fixer.io/api/latest?access_key=a993eeb3eaafdfbcc5f6db3b4f490814");
	private String responseJson = tazasApi.responseJsonString();
	public Double dolar = tazasApi.RateBaseEur(responseJson, "USD");
	public Double cop = tazasApi.RateBaseEur(responseJson, "COP");
	public Double libra = tazasApi.RateBaseEur(responseJson, "LBP");
	
	public Double valorInput = 0.00D;

	public void convertir(JComboBox<Monedas> cmb, JLabel lbl, JTextField txt) {
		System.out.println(cop);
		if (new Validate().Valida(txt.getText(), lbl)) {

			valorInput = Double.parseDouble(txt.getText());

			Monedas moneda = (Monedas) cmb.getSelectedItem();

			switch (moneda) {
			case EUR_USD: {
				Double res = eurosMoneda(dolar, valorInput);
				lbl.setText(format.format(res));
				break;

			}
			case EUR_COP: {
				Double res = eurosMoneda(cop, valorInput);
				lbl.setText(format.format(res));
				break;
			}
			case EUR_LBP: {
				Double res = eurosMoneda(libra, valorInput);
				lbl.setText(format.format(res));
				break;
			}
			case USD_EUR: {
				Double res = MonedaEuros(dolar, valorInput);
				lbl.setText(format.format(res));
				break;
			}
			case COP_EUR: {
				Double res = MonedaEuros(cop, valorInput);
				lbl.setText(format.format(res));
				break;
			}
			case LBP_EUR: {
				Double res = MonedaEuros(libra, valorInput);
				lbl.setText(format.format(res));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			}
		}

	}

	public Double MonedaEuros(Double moneda, Double valorInput) {
		return valorInput / moneda;

	}

	public Double eurosMoneda(Double moneda, Double valorInput) {

		return moneda * valorInput;

	}
}
