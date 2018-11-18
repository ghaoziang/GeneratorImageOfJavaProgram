package com.UI;
import java.io.File;
import com.source.ReaderFromDirectory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WindowController {
	private String path;
	@FXML TextField pathText;
	public void pressButtonCloseApp(ActionEvent event) {
		System.exit(0);
	}
	
	public void pressButtonBrowse(ActionEvent event) {
		DirectoryChooser directoryChoose = new DirectoryChooser();
		File file = directoryChoose.showDialog(new Stage());
		path = file.getPath();
		pathText.setText(path);
	}
	
	public void pressButtonConfirm(ActionEvent event) {
		ReaderFromDirectory reader = new ReaderFromDirectory(path);
	}
	
}
