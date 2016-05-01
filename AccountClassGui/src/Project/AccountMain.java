package Project;

import java.util.HashMap;
import Project.InfoView.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AccountMain extends Application {
	
	private InfoContainer iContainer = new InfoContainer(); //Placeholder for body of application
	private static ServiceSelector selector = new ServiceSelector();  //
	private ButtonContainer bContainer = new ButtonContainer();
	
	private String[] bTitles = {"Open Account", "Open CDAccount", "Deposit", "Withdrawal", "Check Balance", "Close Account"}; 
	
	
	private static HashMap<Integer, Account> hashAccount = new HashMap<>();
	
	public void start(Stage primaryStage) {
	
		
		BorderPane pane = new BorderPane();
		pane.setTop(selector);
		selector.setOnAction((e)->selectorSwitch());
		
		pane.setCenter(iContainer); //container for 
		
		pane.setBottom(bContainer); //container for buttons
		bContainer.setOnAction((e)->handleSubmit());//event to handle button 1
		bContainer.setCancel((e)->handleCancel()); //event to handle cancel button
		
		Scene scene2 = new Scene(pane, 500, 300);//application size
		primaryStage.setTitle("ComboBoxDemo"); //Set the stage title
		primaryStage.setScene(scene2); //Place the scene in the stage
		primaryStage.show(); //Display the stage
		

	}
	
	public void selectorSwitch(){
		//removes views
		iContainer.getChildren().clear();
		//
		bContainer.showConfirm(false);
		
		int index = selector.getSelection();
		
		switch (index){
		case 0:
			iContainer.getChildren().add(new OpenAccount());
			break;
		case 1:
			iContainer.getChildren().add(new OpenCDAccount());
			break;
		case 2:
			iContainer.getChildren().add(new Deposit());
			break;
		case 3:
			iContainer.getChildren().add(new Withdraw());
			break;
		case 4:
			iContainer.getChildren().add(new CheckBalance());
			break;
		case 5:
			iContainer.getChildren().add(new CloseAccount());
			break;
		}
		
		bContainer.setText(bTitles[index]);
		
	}

	public static void main(String[] args) {
		
		Application.launch(args);
	}
	
	public static void addAccount(Account account){
		 hashAccount.put(account.getID(),account);
	}
	
	public static Account getAccount(int AccountID){
		return hashAccount.get(AccountID);
	}
	
	public static void removeAccount(int account){
		hashAccount.remove(account);
	}
	
	public void handleSubmit(){
		
		SubmitForm form = (SubmitForm) iContainer.getChildren().get(0);
		
		//check if form needs confirm
		if (form.needsConfirmation()){
			bContainer.showConfirm(true);
		}
		else {
			bContainer.showConfirm(false);
		}
		
		form.submit();
	}
	
	public void handleCancel(){
		
		SubmitForm form = (SubmitForm) iContainer.getChildren().get(0);
		
		form.clearForm();
	}
	public static void setMessage(String str){
		selector.setMessage(str);
	}
}