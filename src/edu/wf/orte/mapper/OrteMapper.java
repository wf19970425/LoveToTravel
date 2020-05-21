package edu.wf.orte.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.orte.model.Orte;

public interface OrteMapper {
	//删除跟团游订单
		int delete(Integer orte_id);
		//添加跟团游订单
	    int add(Orte orte);
	    //通过id查询跟团游订单
	    Orte load(Integer orte_id);
	    //修改跟团游订单
	    int update(Orte orte);
	    //查询跟团游订单数量
	    int count(Map<String , Object> map);
	    //查询跟团游订单列表
	    List<Orte> orteList(Map<String , Object> map);
	  //跟团游订单统计
	    List<Map<String, Object>> orteTotal(String orte_date);
}