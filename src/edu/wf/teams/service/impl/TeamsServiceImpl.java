package edu.wf.teams.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.main.PageBean;
import edu.wf.spot.model.Spot;
import edu.wf.teams.mapper.TeamsMapper;
import edu.wf.teams.model.Teams;
import edu.wf.teams.service.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService {
	@Autowired
	private TeamsMapper teamsMapper;

	@Override
	public Map<String, Object> add(Teams teams, Map<String, Object> map) {
		int result = teamsMapper.add(teams);
		if (result > 0) {
			map.put("message", "添加跟团游成功");
		} else {
			map.put("message", "添加跟团游失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> delete(Teams teams, Map<String, Object> map) {
		int result = teamsMapper.delete(teams.getTeams_id());
		if (result > 0) {
			map.put("message", "删除成功");
		} else {
			map.put("message", "删除失败");
		}
		return map;
	}

	@Override
	public Teams load(Integer teams_id) {
		return teamsMapper.load(teams_id);
	}

	@Override
	public Map<String, Object> teamsList(Map<String, Object> map) {
		List<Teams> teamsList = teamsMapper.teamsList(map);
		Integer count = teamsMapper.count(map);
		map = PageBean.bfMap(map, count, teamsList, Teams.class);
		return map;
	}

	@Override
	public Map<String, Object> update(Teams teams, Map<String, Object> map) {
		int result = teamsMapper.update(teams);
		if (result > 0) {
			map.put("message", "修改成功");
		} else {
			map.put("message", "修改失败");
		}
		return map;
	}

	@Override
	public List<Teams> teamsNewList() {
		return teamsMapper.teamsNewList();
	}
	@Override
	public Map<String, Object> teamsBfList(Map<String, Object> map) {
		List<Teams> teamsBfList = teamsMapper.teamsBfList(map);
		map.put("teamsBfList", teamsBfList);
		return map;
	}
}
