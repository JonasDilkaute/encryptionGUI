package view;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Class that represents a modified TabPanr
 * @author Jonas
 *
 */
public class GUITabPane implements ContentAble{

	private ArrayList<AnchorPane> contentPanes = new ArrayList<AnchorPane>();
	private BorderPane rootPane;
	private AnchorPane currentPane;
	

	/**
	 * gets the current pane
	 */
	public AnchorPane getCurrentPane() {
		return currentPane;
	}
	/**
	 * sets and updates the current pane
	 * @param currentPane the pane to be current
	 */
	private void setCurrentPane(AnchorPane currentPane) {
		this.currentPane = currentPane;
		rootPane.setCenter(currentPane);
	}
	
	/**
	 * set and updates the pane by its fxid
	 * @param fxid the id
	 */
	public void setCurrentPaneById(String fxid) {
		for(AnchorPane pane: contentPanes) {
			if(pane.getId().equalsIgnoreCase(fxid)) {
				setCurrentPane(pane);
				return;
			}
		}
		throw new IllegalArgumentException("pane not found");
	}

	/**
	 * @return the rootPane
	 */
	public BorderPane getRootPane() {
		return rootPane;
	}

	/**
	 * @param rootPane the rootPane to set
	 */
	public void setRootPane(BorderPane rootPane) {
		this.rootPane = rootPane;
	}

	/**
	 * @return the contentPanes
	 */
	public ArrayList<AnchorPane> getContentPanes() {
		return contentPanes;
	}

	/**
	 * @param contentPanes the contentPanes to set
	 */
	public void setContentPanes(ArrayList<AnchorPane> contentPanes) {
		this.contentPanes = contentPanes;
	}
	
	
	
}
