Node
INFO

create table node(nodeId int primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
parentId int,label varchar(225),isLeaf boolean);
create table info(id int primary key NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),nodeID int references node(nodeId),c_date varchar(10),label varchar(200),description varchar(65324));


node
======
1,1,target,false
2,1,maven-status,true
3,2,,

//Indentify Task for Nodes:
1: add data in node
2: get node data based on node id.
3: updateNode 
4: deleteNode with Node id
5: get all list of node
6: delete list of nodes
7:delete all node.

// identify task for Info:
1: add info data for node.
2: get info data based on node id.
3: update info for given info id. 
4: delete info for given info id nd node id. 
5: get all list of info based on node id.
6: delete all info
7:delete all info based node ids.


TAB functionality:
======================

1: get node id from Home controller to InfoDataController
2: getInfoByNodeId(Integer nodeId);
3: assign 2nd object to InfoDataVo object.
4:





ONSAVE  button functionality:
==================================
1: get the value from the UI object that is InfoDataVo.
2: convert the infoDataVo object to InfoVo object using UIUTIL converter method
3: now save the infovo object in db.



