/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knowledge.store.controllers;

import com.backend.dao.NodeDao;
import com.backend.dao.impl.NodeDaoImpl;
import com.backend.models.NodeVo;
import java.net.URL;
import java.util.ResourceBundle;

import com.knowledge.store.model.NodeDataVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KRISHNA
 */
public class TreeManagerController implements Initializable {
	
	private NodeDataVo selectedNode;
        
       private  Stage dialog;
       
       private NodeDao nodedao;
        
    @FXML
    private Button save;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button clear;

    @FXML
    private Label messagelabel;

    @FXML
    private RadioButton isParentradioButton;

    @FXML
    private TextField labelText;
    
    @FXML
    private TextField nodeIdTextField;

	

    public TreeManagerController(NodeDataVo selectedNode, Stage dialog,NodeDao nodedao) {
		this.selectedNode = selectedNode;
                this.dialog=dialog;
          this.nodedao=nodedao;
	}



	/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        messagelabel.setText("Selecteed Node Is:  "+selectedNode.getNodeId() );
        nodeIdTextField.setDisable(true);
    }    
    
     @FXML
    void onClear(ActionEvent event) {

    }

    @FXML
    void onDelete(ActionEvent event) {

    }

    @FXML
    void onSaveAction(ActionEvent event) {
        
       String label= labelText.getText();
        if (label==null || label.isEmpty()) {
            messagelabel.setText("Label cant be EMPTY ");
            return ;
        }
        boolean isParent=isParentradioButton.isSelected();
          NodeVo vo=new NodeVo(nodedao.generateNodeId(), selectedNode.getParentId(), label, isParent);
        
       int insertedFlag=nodedao.addNode(vo);
       if(insertedFlag>0)
        dialog.close();
    }

    @FXML
    void onUpdate(ActionEvent event) {

    }
    
}
