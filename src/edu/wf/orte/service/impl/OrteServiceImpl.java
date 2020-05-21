package edu.wf.orte.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.main.PageBean;
import edu.wf.orte.mapper.OrteMapper;
import edu.wf.orte.model.Orte;
import edu.wf.orte.service.OrteService;

@Service
public class OrteServiceImpl implements OrteService {
	@Autowired
	private OrteMapper orteMapper;

	@Override
	public Map<String, Object> add(Orte orte, Map<String, Object> map) {
		int result = orteMapper.add(orte);
		if (result > 0) {
			map.put("message", "添加跟团游订单成功");
		} else {
			map.put("message", "添加跟团游订单失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> delete(Orte orte, Map<String, Object> map) {
		int result = orteMapper.delete(orte.getOrte_id());
		if (result > 0) {
			map.put("message", "删除成功");
		} else {
			map.put("message", "删除失败");
		}
		return map;
	}

	@Override
	public Orte load(Integer orte_id) {
		return orteMapper.load(orte_id);
	}

	@Override
	public Map<String, Object> orteList(Map<String, Object> map) {
		List<Orte> orteList = orteMapper.orteList(map);
		Integer count = orteMapper.count(map);
		map = PageBean.bfMap(map, count, orteList, Orte.class);
		return map;
	}

	@Override
	public Map<String, Object> update(Orte orte, Map<String, Object> map) {
		int result = orteMapper.update(orte);
		if (result > 0) {
			map.put("message", "修改成功");
		} else {
			map.put("message", "修改失败");
		}
		return map;
	}
	@Override
	public List<Map<String, Object>> orteTotal(String orte_date) {
		return orteMapper.orteTotal(orte_date);
	}


}
