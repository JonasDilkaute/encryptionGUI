package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Interface for all classes that can switch the panes
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public interface ContentAble {

	public void setCurrentPaneById(String fxid);
	public AnchorPane getCurrentPane();
	public void setRootPane(BorderPane rootPane);
	public BorderPane getRootPane();
}
