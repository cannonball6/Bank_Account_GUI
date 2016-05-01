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

public class Withdraw extends GridPane implements SubmitForm{

	String[] fieldText = {"Account Number: ", "Withdraw Amount: ", "Account Balance: "};
	TextField[] fields = new TextField[fieldText.length];
	
	public Withdraw(){

	
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
		int initAccountNum = Integer.parseInt(fields[0].getText());
		double initWithdraw = Double.parseDouble(fields[1].getText());
		
		Account generic = AccountMain.getAccount(initAccountNum);
		
		if (generic == null){
			AccountMain.setMessage("Account Number Does Not Exist!");
			return;
		}
		//check if CD
		if (generic.getClass() == CDAccount.class){
			AccountMain.setMessage("You Can't Withdraw from an Existing CD Account\nPlease Try Again");
		}
		else{
			generic.withdraw(initWithdraw);
			AccountMain.setMessage("Withdraw Transaction Completed.");
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