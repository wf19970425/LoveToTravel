package edu.wf.orsp.service;

import java.util.List;
import java.util.Map;

import edu.wf.orsp.model.Orsp;

public interface OrspService {
	//添加景点订单订单
    Map<String , Object> add(Orsp orsp,Map<String , Object> map);
    //删除景点订单订单
    Map<String , Object> delete(Orsp orsp , Map<String , Object> map);
    //通过id查询景点订单订单
    Orsp load(Integer orsp_id);
    //修改景点订单订单
    Map<String , Object> update(Orsp orsp,Map<String , Object> map);
    //查询景点订单订单列表
    Map<String , Object> orspList(Map<String , Object> map);
  //景点订单统计
    List<Map<String, Object>> orspTotal(String orsp_date);
}
