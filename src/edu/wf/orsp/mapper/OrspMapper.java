package edu.wf.orsp.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.orsp.model.Orsp;

public interface OrspMapper {
	//删除景点订单
	int delete(Integer orsp_id);
	//添加景点订单
    int add(Orsp orsp);
    //通过id查询景点订单
    Orsp load(Integer orsp_id);
    //修改景点订单
    int update(Orsp orsp);
    //查询景点订单数量
    int count(Map<String , Object> map);
    //查询景点订单列表
    List<Orsp> orspList(Map<String , Object> map);
    //景点订单统计
    List<Map<String, Object>> orspTotal(String orsp_date);
}