package edu.wf.orte.service;

import java.util.List;
import java.util.Map;

import edu.wf.orte.model.Orte;

public interface OrteService {
	//添加跟团游订单订单
    Map<String , Object> add(Orte orte,Map<String , Object> map);
    //删除跟团游订单订单
    Map<String , Object> delete(Orte orte , Map<String , Object> map);
    //通过id查询跟团游订单订单
    Orte load(Integer orte_id);
    //修改跟团游订单订单
    Map<String , Object> update(Orte orte,Map<String , Object> map);
    //查询跟团游订单订单列表
    Map<String , Object> orteList(Map<String , Object> map);
  //跟团游订单统计
    List<Map<String, Object>> orteTotal(String orte_date);
}
