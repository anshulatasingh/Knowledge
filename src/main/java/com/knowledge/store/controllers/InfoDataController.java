package com.knowledge.store.controllers;

import com.backend.dao.impl.InfoDaoImpl;
import com.backend.models.InfoVo;
import com.knowledge.store.model.InfoDataVo;
import com.knowledge.store.model.NodeDataVo;

import java.util.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.TextFlow;
import javafx.scene.web.HTMLEditor;
import javafx.util.StringConverter;

public class InfoDataController implements Initializable {

	private final String pattern = "yyyy-MM-dd";
	
	private NodeDataVo selectedNode;
	
	private InfoDaoImpl infoDaoImpl=new InfoDaoImpl();

	@FXML // injecting and intializing the value of infoButtonBar from .fxml
			// file mapping happens with fx:id
	private HBox infoButtonBar;

	@FXML
	private Region regionBar;

	@FXML
	private Button newInfoButton;

	@FXML
	private Button saveInfoButton;

	@FXML
	private Button updateInfoButton;

	@FXML
	private Button deleteInfoButton;

	@FXML
	private Button clearButton;

	@FXML
	private Button reloadButon;

	@FXML
	private TableView<InfoDataVo> infoTable;

	@FXML
	private TableColumn<InfoDataVo, Integer> id;

	@FXML
	private TableColumn<InfoDataVo, String> date;

	@FXML
	private TableColumn<InfoDataVo, String> label;

	@FXML
	private TableColumn<InfoDataVo, String> description;

	@FXML
	private AnchorPane details;

	@FXML
	private Label displayedIssueLabel;

	@FXML
	private HTMLEditor descriptionText;

	@FXML
	private DatePicker datepicker;

	@FXML
	private TextField labelText;
	
	
	public InfoDataController(NodeDataVo selectedNode) {
		this.selectedNode = selectedNode;
	}

	@FXML
	void onClearAction(ActionEvent event) {
		infoTable.getItems().clear();
	}

	@FXML
	void onDeleteInfoButtonAction(ActionEvent event) {
		infoTable.getItems().removeAll(infoTable.getSelectionModel().getSelectedItems());
	}

	@FXML
	void onNewInfoButtonAction(ActionEvent event) {
		clear();
	}

	@FXML
	void onReloadAction(ActionEvent event) {

	}

	@FXML
	void onSaveInfoButtonAction(ActionEvent event) {

		LocalDate date = datepicker.getValue();
		String text = labelText.getText();
		String description = descriptionText.getHtmlText();
		InfoDataVo info = new InfoDataVo(0, date.toString(), text, description);
		infoTable.getItems().add(info);

	}

	@FXML
	void onUpdateInfoAction(ActionEvent event) {
		InfoDataVo view = infoTable.getSelectionModel().getSelectedItem();
		if (view != null) {
			view.setDate(datepicker.getValue().toString());
			view.setDescription(descriptionText.getHtmlText());
			view.setLabel(labelText.getText());
			infoTable.getItems().set(infoTable.getSelectionModel().getSelectedIndex(), view);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loadTableData(selectedNode.getNodeId());

		saveInfoButton.setFocusTraversable(false);
		TextField filteredTextBox = UIUtil.createClearableTextField();

		infoButtonBar.getChildren().add(0, filteredTextBox);
		filteredTextBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("old: " + oldValue + "  new:  " + newValue);
			}
		});

		// mapping table column with infodatavo
		id.setCellValueFactory(new PropertyValueFactory<InfoDataVo, Integer>("id"));
		date.setCellValueFactory(new PropertyValueFactory<InfoDataVo, String>("date"));
		label.setCellValueFactory(new PropertyValueFactory<InfoDataVo, String>("label"));
		description.setCellValueFactory(new PropertyValueFactory<InfoDataVo, String>("description"));
		/*
		 * id.prefWidthProperty().bind(infoTable.widthProperty().divide(0.0));
		 * date.prefWidthProperty().bind(infoTable.widthProperty().divide(0.0));
		 * label.prefWidthProperty().bind(infoTable.widthProperty().divide(0.0))
		 * ;
		 * description.prefWidthProperty().bind(infoTable.widthProperty().divide
		 * (4)); //On selection of Table Row
		 */ infoTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<InfoDataVo>() {
			@Override
			public void changed(ObservableValue<? extends InfoDataVo> observable, InfoDataVo oldValue,
					InfoDataVo newValue) {

				if (newValue != null) {
					populateMasterTable(newValue);
				}

			}
		});

	}
	
	public List<InfoDataVo> loadTableData(Integer nodeId){
		List<InfoDataVo> results =new ArrayList<>();
		List<InfoVo> infoVos=infoDaoImpl.getInfoByNodeId(nodeId);
	
		return results;
	}

	public void populateMasterTable(InfoDataVo data) {

		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};

		datepicker.setConverter(converter);
		datepicker.setValue(LocalDate.parse(data.getDate()));
		labelText.setText(data.getLabel());
		descriptionText.setHtmlText(data.getDescription());

	}

	// To clear the field data
	public void clear() {

		labelText.clear();
		datepicker.setValue(LocalDate.now());
		descriptionText.setHtmlText("");
		labelText.setFocusTraversable(true);
	}

	public void disable(boolean isDisable) {
		saveInfoButton.setDisable(isDisable);
	}

}
