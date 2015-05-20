package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MCcontroller
{
	@FXML
	Label housePayment;
	@FXML
	Label totalPayment;
	@FXML
	Label maximumPayment;
	@FXML
	Label maximumMortgage;
	@FXML
	TextField income;
	@FXML
	TextField debt;
	@FXML
	TextField interest;
	@FXML
	TextField downPayment;
	@FXML
	ChoiceBox<Integer> term;
	@FXML
	Button clear;
	@FXML
	Button calculate;
	@FXML
    private void initialize() {
		term.getItems().addAll(10,15,30);
		downPayment.setText("0");
		housePayment.setText("0");
		maximumPayment.setText("0");
		maximumMortgage.setText("0");
		totalPayment.setText("0");
		income.setText("0");
		debt.setText("0");
		interest.setText("0");
		term.setValue(10);
		
		
}
	@FXML
	private void handleClear() {
		downPayment.setText("0");
		housePayment.setText("0");
		maximumPayment.setText("0");
		maximumMortgage.setText("0");
		totalPayment.setText("0");
		income.setText("0");
		debt.setText("0");
		interest.setText("0");
		term.setValue(30);
	}
	@FXML
	private void handleCalculate(){
		double Income;
		double Debt;
		double Interest;
		double DownPayment;
		try{
			Income = Double.parseDouble(income.getText());
		}catch(NumberFormatException a){Income = 0;}
		
		try{
			Debt = Double.parseDouble(debt.getText());
		}catch(NumberFormatException a){Debt = 0;}
		try{
			Interest = Double.parseDouble(interest.getText())/12;
		}catch(NumberFormatException a){Interest = 0;}
		
		int Term = term.getValue()*12;
		
		try{
			DownPayment = Double.parseDouble(downPayment.getText());
		}catch(NumberFormatException a){DownPayment = 0;}
			
		double HousePayment = Income/12*.18;
		double TotalPayment = Income/12*.36 - Debt;
		double MaxPayment = Math.min(HousePayment, TotalPayment);
		housePayment.setText(Double.toString(HousePayment));
		totalPayment.setText(Double.toString(TotalPayment));
		maximumPayment.setText(Double.toString(MaxPayment));
	
		int Mortgage = (int) (((MaxPayment * ((Math.pow((1 + Interest), Term) - 1) 
				/ Interest))/(Math.pow((1 + Interest), Term))) - DownPayment);
		maximumMortgage.setText(Integer.toString(Mortgage));
	}
}

