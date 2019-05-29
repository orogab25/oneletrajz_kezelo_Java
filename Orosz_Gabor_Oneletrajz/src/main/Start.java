package main;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Start extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		FXMLLoader loader=new FXMLLoader();
		AnchorPane pane=loader.load(new FileInputStream("Resources/View.fxml"));
		
		//az ablak aktuális jelenete ez lesz
		Scene scene=new Scene(pane);
		
		//beállítjuk az ablakban ki jelenjen meg
		stage.setScene(scene);
		stage.setTitle("Önéletrajz program");
		stage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}