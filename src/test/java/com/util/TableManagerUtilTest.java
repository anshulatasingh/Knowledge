package com.util;

import static com.util.TableManagerUtil.NODE_TABLE;
import static com.util.TableManagerUtil.INFO_TABLE;

import org.junit.Test;;

public class TableManagerUtilTest {

	@Test
	public void test() {
		
		TableManagerUtil.excuteTable(NODE_TABLE);
		TableManagerUtil.excuteTable(INFO_TABLE);
		
	}

	
}


