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

public class CheckBalance extends GridPane implements SubmitForm{

	String[] fieldText = {"Account Number: ", "Account Balance: "};
	TextField[] fields = new TextField[fieldText.length];
	Label labelRef; //keep reference of current label
	
	public CheckBalance(){
		
    setPadding(new Insets(5)); //make spacing for all labels
    setHgap(10);
    setVgap(10);
    
    
	Label label = new Label("Label"); 
    GridPane.setHalignment(label, HPos.CENTER);
    
	for (int i = 0; i < fieldText.length; i++){
		HBox row = new HBox(); 
		fields[i] = new TextField();
		Label labelTemp = new Label(fieldText[i]);
		
		if (i == 1)
			labelRef = labelTemp; //this will be used between account and CD
		
		row.getChildren().add(labelTemp);
		row.getChildren().add(fields[i]);
		row.setAlignment(Pos.CENTER_RIGHT);
		add(row, 0, i+1);
	}
	
		fields[1].setEditable(false); //make fields un-editable
		
	}

	@Override
	public void submit() {

		int initAccountNum = Integer.parseInt(fields[0].getText());
		
		Account generic = AccountMain.getAccount(initAccountNum);
		
		if (generic == null){
			System.out.println("Account Number Does Not Exist!");
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
