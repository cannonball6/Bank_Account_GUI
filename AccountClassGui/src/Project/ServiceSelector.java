package Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ServiceSelector extends BorderPane{

	//label for messages when buttons pressed
	private Label message = new Label();
	private String[] Titles = {"Open Account", "Open CDAccount", "Deposit", "Withdrawal", "Check Balance", "Close Account"}; 
	ComboBox<String> cbo = new ComboBox<>();
	
	public ServiceSelector(){
		//display text for Combo Box
		this.setLeft(new Label("Select A Service:"));
		//display Combo Box
		this.setCenter(cbo);
		//create label
		this.setBottom(message);
		
		cbo.setPrefWidth(400);
		cbo.setValue("Open Account");
		
		ObservableList<String> items = FXCollections.observableArrayList(Titles);
		cbo.getItems().addAll(items);
		
		
	}
	//Event Handler for Combo Box
	public void setOnAction(EventHandler<ActionEvent> event){
		cbo.setOnAction(event);
	}
	//return selection for Combo Box
	public int getSelection(){
		return cbo.getSelectionModel().getSelectedIndex();
	}
	//This method will set message at top of pane
	public void setMessage(String str){
		message.setText(str);
		message.setWrapText(true);
	}
}
