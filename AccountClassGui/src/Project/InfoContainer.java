package Project;

import Project.InfoView.OpenAccount;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class InfoContainer extends Pane{
	
	//Build background for everything to be built on
	InfoContainer(){
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setMinHeight(200);
		getChildren().add(new OpenAccount());
	}
}
