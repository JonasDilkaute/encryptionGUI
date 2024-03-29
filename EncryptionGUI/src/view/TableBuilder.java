package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.FrequencyData;

/**
 * Class that build a new TableView
 * @author Jonas Dilkaute
 * @version 1.0
 * @param <E> the type
 */
public class TableBuilder<E> {
	
	private ObservableList<TableColumn<E, ?>> columnsList = FXCollections.observableArrayList();
	
	/**
	 * creates a new TableBuilder
	 * @param tableView the tableView
	 * @param data the data that should be content in this table
	 */
	public TableBuilder (TableView<E> tableView, ObservableList<E> data) {
	
		/*
		for(TableColumn<E, ?> column: tableView.getColumns() ) {
			//column.impl_setFixed(false);
			column.setResizable(false);
			column.setEditable(true);
			columnsList.add(column);
		}
		*/
		for(int i=0; i<26;i++ ) {
			TableColumn<E, String> column = new TableColumn<>("" + ((char) (i + 65)));
			column.setCellValueFactory(new PropertyValueFactory<E, String>("key"));
			//column.impl_setFixed(false);
			column.setResizable(false);
			column.setMaxWidth(26);
			column.setEditable(false);
			columnsList.add(column);
		}
		
		tableView.getColumns().clear();
		tableView.getColumns().addAll(columnsList);	
		tableView.setItems(data);
	}
}
