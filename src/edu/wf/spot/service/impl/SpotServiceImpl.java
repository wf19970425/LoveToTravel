package edu.wf.spot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.client.model.Client;
import edu.wf.main.PageBean;
import edu.wf.spot.mapper.SpotMapper;
import edu.wf.spot.model.Spot;
import edu.wf.spot.service.SpotService;

@Service
public class SpotServiceImpl implements SpotService {
	@Autowired
	private SpotMapper spotMapper;

	@Override
	public Map<String, Object> add(Spot spot, Map<String, Object> map) {
		int result = spotMapper.add(spot);
		if (result > 0) {
			map.put("message", "添加景点成功");
		} else {
			map.put("message", "添加景点失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> delete(Spot spot, Map<String, Object> map) {
		int result = spotMapper.delete(spot.getSpot_id());
		if (result > 0) {
			map.put("message", "删除成功");
		} else {
			map.put("message", "删除失败");
		}
		return map;
	}

	@Override
	public Spot load(Integer spot_id) {
		return spotMapper.load(spot_id);
	}

	@Override
	public Map<String, Object> spotList(Map<String, Object> map) {
		List<Spot> spotList = spotMapper.spotList(map);
		Integer count = spotMapper.count(map);
		map = PageBean.bfMap(map, count, spotList, Spot.class);
		return map;
	}

	@Override
	public Map<String, Object> update(Spot spot, Map<String, Object> map) {
		int result = spotMapper.update(spot);
		if (result > 0) {
			map.put("message", "修改成功");
		} else {
			map.put("message", "修改失败");
		}
		return map;
	}

	@Override
	public List<Spot> spotNewList() {
		return spotMapper.spotNewList();
	}

	@Override
	public Map<String, Object> spotBfList(Map<String, Object> map) {
		List<Spot> spotBfList = spotMapper.spotBfList(map);
		map.put("spotBfList", spotBfList);
		return map;
	}

	@Override
	public List<Spot> tuijianList(Client client) {
		return spotMapper.tuijianList(client);
	}

}
