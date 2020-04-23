package edu.wf.spot.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.client.model.Client;
import edu.wf.spot.model.Spot;

public interface SpotMapper {
		//删除景点
		int delete(Integer spot_id);
		//添加景点
	    int add(Spot spot);
	    //通过id查询景点
	    Spot load(Integer spot_id);
	    //修改景点
	    int update(Spot spot);
	    //查询景点数量
	    int count(Map<String , Object> map);
	    //查询景点列表
	    List<Spot> spotList(Map<String , Object> map);
	    //最新景点
	    List<Spot> spotNewList();
	    //查询前台景点列表
	    List<Spot> spotBfList(Map<String , Object> map);
	    //推荐景点
	    List<Spot> tuijianList(Client client);
	    
}