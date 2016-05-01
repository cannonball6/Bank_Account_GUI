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

public class Deposit extends GridPane implements SubmitForm{

	String[] fieldText = {"Account Number: ", "Deposit Amount: ", "Account Balance: "};
	TextField[] fields = new TextField[fieldText.length];

	
	public Deposit(){

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
		}
		fields[2].setEditable(false);
		
	}

	@Override
	public void submit() {
		// Reads in account number
		// invoke deposit method into account
		int initAccountNum = Integer.parseInt(fields[0].getText());
		double initDeposit = Double.parseDouble(fields[1].getText());
		
		Account generic = AccountMain.getAccount(initAccountNum);
		
		//check if CD
		if (generic == null){
			System.out.println("Account Number Does Not Exist!");
			return;
		}
		if (generic.getClass() == CDAccount.class){
			AccountMain.setMessage("You Can't Make a Deposit to an Existing CD Account\nPlease Try Again");
		}
		else{
			generic.deposit(initDeposit);
		}
		
		fields[2].setText(generic.getBalance() + "");
		
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
	}
	
}
