package com.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.backend.models.InfoVo;
import com.backend.models.NodeVo;
import com.util.TableManagerUtil;

public class InfoDaoImplTest {

	private InfoDaoImpl infoImpl;
	
	private NodeDaoImpl nodeImpl;

	@Before
	public void setup() {
		TableManagerUtil.initTable();
		infoImpl = new InfoDaoImpl();
		nodeImpl=new NodeDaoImpl();
	}

	@After
	public void clear() {
		infoImpl = null;
		nodeImpl=null;
	}
	
	/*@Test
	public void test() {
		nodeImpl.getAllNode().forEach(x-> System.out.println(x));
		System.out.println(infoImpl.addInfo(new InfoVo(2,2,"2017-01-01","Language-java","JavaTest")));
	infoImpl.getAllInfo().forEach(x-> System.out.println(x));
	}*/

	@Test
	public void test() {
		nodeImpl.getAllNode().forEach(x-> System.out.println(x));
		
		List<InfoVo> listInfo=new ArrayList<InfoVo>();
		listInfo.add(new InfoVo(1,1,"2017-01-01","Language","Language test test"));
		listInfo.add(new InfoVo(2,2,"2017-01-01","Language-java","JavaTest"));
		listInfo.add(new InfoVo(3,2,"2017-01-01","Language-java","JAVAUNIT"));
		listInfo.add(new InfoVo(4,3,"2017-01-01","Language-SQL","SQLTEST"));
		listInfo.add(new InfoVo(5,3,"2017-01-01","Language-SQL","SQLUNIT"));
		listInfo.add(new InfoVo(6,4,"2017-01-01","Language-JSP","JSPTEST"));
		listInfo.add(new InfoVo(6,5,"2017-01-01","Language-JAXB","JAXBTEST"));

            infoImpl.addInfos(listInfo);
		}
		

	@Test
	public void testRetrive() {
		infoImpl.getAllInfo().forEach(vo -> System.out.println(vo));
	}

}
