package controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import view.ContentAble;

/**
 * Class that manages switching between tabs
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class TabSwitchController  implements Initializable{

    @FXML
    private ToggleButton caesarButton, vigenereButton, rsaButton, permutationButton, permutation1Button, aboutButton;
    
    @FXML
    private Button closeButton;
    
    private ArrayList<ToggleButton> buttonList = new ArrayList<>();
    
    private ContentAble contentAble;
    
    /**
     * creates an new {@link TabSwitchController}
     * @param contentAble the {@link ContentAble}
     */
    public TabSwitchController(ContentAble contentAble) {
    	setContentAble(contentAble);
	}
    
    @FXML
    void close(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void switchTab(ActionEvent event) {
    	
    	ToggleButton button = (ToggleButton) event.getSource();
    	
    	for (ToggleButton toggleButton : buttonList) {
    		toggleButton.setSelected(toggleButton==button);		
		}
    	
    	contentAble.setCurrentPaneById((button.getId().split("Button")[0])+ "Pane");
      	
    }
    
    /**
     * switches the tab by the id
     * @param id
     */
    public void switchTab(String id) {
    	contentAble.setCurrentPaneById(id);
    	id = id.toLowerCase();
    	for (ToggleButton toggleButton : buttonList) {
			toggleButton.setSelected(id.contains(toggleButton.getId().split("Button")[0]));
		}
    	
    	
    }

    /**
     * gets the contentAble
     * @return the contentAble
     */
	public ContentAble getContentAble() {
		return contentAble;
	}

	/**
	 * sets the contentAble
	 * @param contentAble the contentAble
	 */
	public void setContentAble(ContentAble contentAble) {
		this.contentAble = contentAble;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonList.add(caesarButton);
    	buttonList.add(vigenereButton);
    	buttonList.add(rsaButton);
    	buttonList.add(permutationButton);
    	buttonList.add(permutation1Button);
    	buttonList.add(aboutButton);
    	
	}
	
	/**
	 * prepares the controller. should be called after the GUI is builded up.
	 */
	public void init() {
		contentAble.setCurrentPaneById("CaesarPane");
    	caesarButton.setSelected(true);
	}
}