package com.backend.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.annotation.XmlInlineBinaryData;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.backend.models.NodeVo;
import com.knowledge.store.model.NodeDataVo;

public class NodeDaoImplTest {

	private NodeDaoImpl nodeImpl;

	private InfoDaoImpl infoDaoImpl;

	@Before
	public void setup() {
		nodeImpl = new NodeDaoImpl();
		infoDaoImpl = new InfoDaoImpl();
	}

	@After
	public void clear() {
		nodeImpl = null;
		infoDaoImpl = null;
	}

	@Test
	public void testaddNode() throws IOException {
		File f = new File(this.getClass().getClassLoader().getResource("anshu/data.txt").getPath());
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] rawdata = line.split(",");
			NodeVo nvo = new NodeVo();
			nvo.setNodeId(Integer.parseInt(rawdata[0]));
			nvo.setParentId(Integer.parseInt(rawdata[1]));
			nvo.setLabel(rawdata[2]);
			nvo.setLeaf(Boolean.valueOf(rawdata[3].trim()));
			nodeImpl.addNode(nvo);
		}
		br.close();

	}

	/*@Ignore
	@Test
	public void testRetrive() throws IOException {
		System.out.println(nodeImpl.getNodeById(2));
	}

	@Ignore
	@Test
	public void testdeleteAll() throws IOException {
		System.out.println("Under Delete");
		infoDaoImpl.deleteAllInfo();
		nodeImpl.deleteAllNode();
		nodeImpl.getAllNode();
	}
*/
	@Test
	public void testAllRetrive() throws IOException {
		System.out.println("All Node retrive: ");
		nodeImpl.getAllNode().forEach(nodeVO -> System.out.println(nodeVO));
	}

	
	@Test
	public void addNodeFromUI(){
		//prepare the data 
		NodeDataVo vo=new NodeDataVo(7, 3, "Derby", true);
		NodeVo nodeData=new NodeVo(vo.getNodeId(), vo.getParentId(), vo.getLabel(), vo.isIsLeaf());
		nodeImpl.addNode(nodeData);
		
	}
	
	
}
