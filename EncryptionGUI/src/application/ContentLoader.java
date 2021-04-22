package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * Class that loads the FXML files into the application
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class ContentLoader {
	
	private static ArrayList<AnchorPane> contentPanes = new ArrayList<AnchorPane>();
	private static  String[] paths = {"CaesarPane", "VigenerePane", "PermutationPane","Permutation1Pane","RSAPane","AboutPane"};

	/**
	 * loads the FMXL files with the given Controller
	 * @param controller the controller
	 * @return the loaded AnchorPane as  list
	 */
	public static ArrayList<AnchorPane> loadContent(Object controller) {
		for(String path: paths) {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/application/" + path + ".fxml"));
	        loader.setController(controller);
	     
			try {
				contentPanes.add((AnchorPane) loader.load());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return contentPanes;
		
	}
}
