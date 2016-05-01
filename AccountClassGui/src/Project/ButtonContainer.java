package Project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonContainer extends HBox{

	Button b1 = new Button("Open Account");
	Button b2 = new Button("Cancel");
	String bText = "Open Account";//reference for button label
	
	ButtonContainer(){ //button placement
		this.getChildren().add(b1);
		this.getChildren().add(b2);
		this.setAlignment(Pos.CENTER);
	}
	
	public void setText(String str){ //set button text
		b1.setText(str);
		bText = str;
	}
	
	public void setOnAction(EventHandler<ActionEvent> event){//create action on button 1
		b1.setOnAction(event);
	}

	public void setCancel(EventHandler<ActionEvent> event){//create action for b2 "cancel"
		b2.setOnAction(event);
	}
	
	public void showConfirm(boolean b){ //logic for showing confirm button on CloseAccount Class
		b1.setText(b ? "Confirm" : bText );
	}
}
