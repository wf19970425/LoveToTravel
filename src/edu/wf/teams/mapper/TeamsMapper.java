package edu.wf.teams.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.spot.model.Spot;
import edu.wf.teams.model.Teams;

public interface TeamsMapper {
	//删除跟团游
	int delete(Integer teams_id);
	//添加跟团游
    int add(Teams teams);
    //通过id查询跟团游
    Teams load(Integer teams_id);
    //修改跟团游
    int update(Teams teams);
    //查询跟团游数量
    int count(Map<String , Object> map);
    //查询跟团游列表
    List<Teams> teamsList(Map<String , Object> map);
    //最新团游列表
    List<Teams> teamsNewList();
  //查询前台跟团游列表
    List<Teams> teamsBfList(Map<String , Object> map);
}