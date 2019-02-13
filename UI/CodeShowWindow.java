package com.UI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CodeShowWindow {

	public CodeShowWindow() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CodeShow.fxml"));
		ProgramEngine.stage.setScene(new Scene(root));
		ProgramEngine.stage.show();
	}
}
