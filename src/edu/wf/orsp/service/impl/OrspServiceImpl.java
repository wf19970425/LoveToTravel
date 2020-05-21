package edu.wf.orsp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.main.PageBean;
import edu.wf.orsp.mapper.OrspMapper;
import edu.wf.orsp.model.Orsp;
import edu.wf.orsp.service.OrspService;

@Service
public class OrspServiceImpl implements OrspService {
	@Autowired
	private OrspMapper orspMapper;

	@Override
	public Map<String, Object> add(Orsp orsp, Map<String, Object> map) {
		int result = orspMapper.add(orsp);
		if (result > 0) {
			map.put("message", "添加景点订单成功");
		} else {
			map.put("message", "添加景点订单失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> delete(Orsp orsp, Map<String, Object> map) {
		int result = orspMapper.delete(orsp.getOrsp_id());
		if (result > 0) {
			map.put("message", "删除成功");
		} else {
			map.put("message", "删除失败");
		}
		return map;
	}

	@Override
	public Orsp load(Integer orsp_id) {
		return orspMapper.load(orsp_id);
	}

	@Override
	public Map<String, Object> orspList(Map<String, Object> map) {
		List<Orsp> orspList = orspMapper.orspList(map);
		Integer count = orspMapper.count(map);
		map = PageBean.bfMap(map, count, orspList, Orsp.class);
		return map;
	}

	@Override
	public Map<String, Object> update(Orsp orsp, Map<String, Object> map) {
		int result = orspMapper.update(orsp);
		if (result > 0) {
			map.put("message", "修改成功");
		} else {
			map.put("message", "修改失败");
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> orspTotal(String orsp_date) {
		return orspMapper.orspTotal(orsp_date);
	}

}
