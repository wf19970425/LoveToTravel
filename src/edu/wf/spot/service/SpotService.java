package edu.wf.spot.service;

import java.util.List;
import java.util.Map;

import edu.wf.client.model.Client;
import edu.wf.spot.model.Spot;

public interface SpotService {
	//添加景点
    Map<String , Object> add(Spot spot,Map<String , Object> map);
    //删除景点
    Map<String , Object> delete(Spot spot , Map<String , Object> map);
    //通过id查询景点
    Spot load(Integer spot_id);
    //修改景点
    Map<String , Object> update(Spot spot,Map<String , Object> map);
    //查询景点列表
    Map<String , Object> spotList(Map<String , Object> map);
    //最新景点
    List<Spot> spotNewList();
    //查询前台景点列表
    Map<String , Object> spotBfList(Map<String , Object> map);
    //推荐景点
    List<Spot> tuijianList(Client client);
}
