package edu.wf.teams.service;

import java.util.List;
import java.util.Map;

import edu.wf.spot.model.Spot;
import edu.wf.teams.model.Teams;

public interface TeamsService {
	//添加跟团游
    Map<String , Object> add(Teams teams,Map<String , Object> map);
    //删除跟团游
    Map<String , Object> delete(Teams teams , Map<String , Object> map);
    //通过id查询跟团游
    Teams load(Integer teams_id);
    //修改跟团游
    Map<String , Object> update(Teams teams,Map<String , Object> map);
    //查询跟团游列表
    Map<String , Object> teamsList(Map<String , Object> map);
    List<Teams> teamsNewList();
    //查询前台跟团游列表
    Map<String , Object> teamsBfList(Map<String , Object> map);
}
