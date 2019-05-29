package main.ctrl;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Util {

	/*
	 * Létrehozunk egy alertet
	 */
	public static Alert createAlert(AlertType alertType,String title,String headerText, String contentText)
	{
		Alert alert=new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
		return alert;
	}
	
	public static Alert createAlert(String title,String headerText, String contentText)
	{
		return createAlert(AlertType.ERROR,title,headerText,contentText);
	}
	
	public static Alert createAlert(String title,String contentText)
	{
		return createAlert(title,null,contentText);
	}
}
