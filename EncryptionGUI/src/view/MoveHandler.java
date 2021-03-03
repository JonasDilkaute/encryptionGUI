package view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class to manage drag and drop of this application
 * @author Jonas
 *
 */
public class MoveHandler {
	
	private double xOffset = 0;
    private double yOffset = 0;
    
    /**
     * creates an new MoveHandler with the root pane and the stage
     * @param root the root pane
     * @param stage the stage
     */
    public MoveHandler(Pane root,Stage stage) {
    	 root.setOnMousePressed(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 xOffset = event.getSceneX();
                 yOffset = event.getSceneY();
             }
         });
         
         //move around here
         root.setOnMouseDragged(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 stage.setX(event.getScreenX() - xOffset);
                 stage.setY(event.getScreenY() - yOffset);
             }
         });
    }

}
