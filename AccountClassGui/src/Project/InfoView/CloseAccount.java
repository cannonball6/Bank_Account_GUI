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

public class CloseAccount extends GridPane implements SubmitForm{
	
	String[] fieldText = {"Account Number: ", "Account Balance: "};
	TextField[] fields = new TextField[fieldText.length];
	
	boolean confirmed = false;
	private Label labelRef;
	
	public CloseAccount(){


		
	    setPadding(new Insets(5));
	    setHgap(10);
	    setVgap(10);
	    
		Label label = new Label("Label");
	    GridPane.setHalignment(label, HPos.CENTER);
	    
	    
		for (int i = 0; i < fieldText.length; i++){
			HBox row = new HBox();
			fields[i] = new TextField();
			Label labelTemp = new Label(fieldText[i]);
			
			if (i == 1)
				labelRef = labelTemp;
			
			row.getChildren().add(labelTemp);
			row.getChildren().add(fields[i]);
			row.setAlignment(Pos.CENTER_RIGHT);
			add(row, 0, i+1);
		}
		fields[1].setEditable(false);
	}

	@Override
	public void submit() {
		// Read account number
		// Show account number
		// Remove account from Hash Table
		//check if 
		int initAccountNum = Integer.parseInt(fields[0].getText());
		
		Account generic = AccountMain.getAccount(initAccountNum);
		
		if (generic == null){
			AccountMain.setMessage("Account Number Does Not Exist.");
			return;
		}
		if (generic.getClass() == CDAccount.class){
			labelRef.setText("Account Mature Balance:");
			fields[1].setText(((CDAccount) generic).getMatureBalance() + "");
			
		}
		else{
			labelRef.setText("Account Balance:");
			fields[1].setText(generic.getBalance() + "");
			
		}
		
		
		if (confirmed){
			
			AccountMain.removeAccount(initAccountNum);
			clearForm();
			AccountMain.setMessage("Your Account in Closed.");
		} else {
			if (generic.getClass() == CDAccount.class){
				AccountMain.setMessage("You may lose the interest if you close a CD Account Beofre the Mature Date.\n"
						+ "Please click the confirm button to close the CD Account.");
				confirmed = true;
			}
			else {
				AccountMain.setMessage("Please click the confirm button to close the Account.");
				confirmed = true;
			}
		}
		
	}

	@Override
	public boolean needsConfirmation() {
		// TODO Auto-generated method stub
		return !confirmed;
	}

	@Override
	public void clearForm() {
		// TODO Auto-generated method stub
		for (int i = 0; i < fields.length; i++){
			fields[i].setText("");
		}
	}
}
