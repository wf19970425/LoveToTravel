package edu.wf.client.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.client.model.Client;

public interface ClientMapper {

    int delete(Integer client_id);
    
    int add(Client client);
    
    Client load(Integer client_id);
    
    int update(Client client);
    int count(Map<String , Object> map);
    List<Client> clientList(Map<String , Object> map);
    Client login(Client client);
}