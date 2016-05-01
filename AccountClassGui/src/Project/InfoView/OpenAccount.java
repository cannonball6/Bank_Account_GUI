package Project.InfoView;

import Project.Account;
import Project.AccountMain;
import Project.CheckingAccount;
import Project.SavingsAccount;
import Project.SubmitForm;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class OpenAccount extends GridPane implements SubmitForm{

	RadioButton button1 = new RadioButton("Checking Account");
	RadioButton button2 = new RadioButton("Savings Account");
	
	String[] fieldText = {"Account Number: ", "Initial Deposit: ", "Annual Interest Rate(%): ", "Account Balance: "};
	TextField[] fields = new TextField[fieldText.length];
	
	public OpenAccount(){
		
		HBox button = new HBox();
		
	    setPadding(new Insets(5));
	    setHgap(10);
	    setVgap(10);
	    
		Label label = new Label("Label");
	    GridPane.setHalignment(label, HPos.CENTER);
	    
	    //radio buttons
	    ToggleGroup group = new ToggleGroup();
	    
	    button1.setToggleGroup(group);
	    button1.setSelected(true);
	    button2.setToggleGroup(group);
	    button.getChildren().add(button1);
	    button.getChildren().add(button2);
	    add(button, 0, 0);
	    
		for (int i = 0; i < fieldText.length; i++){
			HBox row = new HBox();
			fields[i] = new TextField();
			row.getChildren().add(new Label(fieldText[i]));
			row.getChildren().add(fields[i]);
			row.setAlignment(Pos.CENTER_RIGHT);
			add(row, 0, i+1);
			
			if (i != 1)
				fields[i].setEditable(false);
		}
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		double initDeposit = Double.parseDouble(fields[1].getText());
		
		Account generic;
		
		if (button1.isSelected()){
			generic = new CheckingAccount(initDeposit);
			fields[2].setText("0.0");
		} else {
			//new savings
			generic = new SavingsAccount(initDeposit);
			fields[2].setText("3.0");
		}
		
		generic.setAnnualInterestRate(3.0);
		AccountMain.addAccount(generic);
		
		//populate fields
		fields[0].setText(generic.getID() + "");
		fields[3].setText(generic.getBalance() + "");
		
		AccountMain.setMessage("Account Created");
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
		fields[2].setText("3.0");
	}
	
}
