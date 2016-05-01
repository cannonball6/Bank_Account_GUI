package Project.InfoView;

import Project.Account;
import Project.AccountMain;
import Project.CDAccount;
import Project.SubmitForm;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class OpenCDAccount extends GridPane implements SubmitForm{

	String[] fieldText = {"Account Number: ", "Deposit Amount: ", "CD Duration(Months): ", "CD Annual Interest Rate(%): ", "Account Maturation Balance: "};
	TextField[] fields = new TextField[fieldText.length];
	
	public OpenCDAccount(){

	
    setPadding(new Insets(5));
    setHgap(10);
    setVgap(10);
    
	Label label = new Label("Label");
    GridPane.setHalignment(label, HPos.CENTER);
    

	for (int i = 0; i < fieldText.length; i++){
		HBox row = new HBox();
		fields[i] = new TextField();
		row.getChildren().add(new Label(fieldText[i]));
		row.getChildren().add(fields[i]);
		row.setAlignment(Pos.CENTER_RIGHT);
		add(row, 0, i+1);
		
		if (i != 1 && i != 2)
			fields[i].setEditable(false);
	}
		fields[3].setText("4.5");
}

	@Override
	public void submit() {
		double initDeposit = Double.parseDouble(fields[1].getText());
		int initDuration = Integer.parseInt(fields[2].getText());
		
		CDAccount generic = new CDAccount(initDeposit, initDuration, 4.5);
		
		generic.setCDAnnualInterestRate(4.5);
		
		AccountMain.addAccount(generic);
		
		fields[0].setText(generic.getID() + "");
		fields[4].setText(generic.getMatureBalance() + "");
		
		AccountMain.setMessage("CD Account Created");
	}

	@Override
	public boolean needsConfirmation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearForm() {
		// TODO Auto-generated method stub
		for (int i = 0; i < fields.length; i++){
			fields[i].setText("");
		}
		fields[3].setText("4.5");
	}
}
