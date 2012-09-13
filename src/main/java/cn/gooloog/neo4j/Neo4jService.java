package cn.gooloog.neo4j;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.entity.RestNode;
import org.neo4j.rest.graphdb.index.RestIndex;
import org.springframework.stereotype.Service;

import cn.gooloog.config.Neo4jConfig;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;

@Service
public class Neo4jService {

	public RestAPI restAPI;

	@Resource
	private UserService userService;

	public Neo4jService() {
		this.restAPI = new RestAPIFacade(Neo4jConfig.uri);
	}

	public RestNode getNodeByUID(Long uid) {
		RestIndex<RestNode> index = this.restAPI.getIndex("node_auto_index");
		IndexHits<RestNode> hits = index.get("uid", uid);
		if (hits.hasNext()) {
			return hits.getSingle();
		} else {
			return null;
		}
	}

	public RestNode getOrCreateNodeByUID(Long uid) {
		RestNode node = this.getNodeByUID(uid);
		if (null != node) {
			return node;
		}
		User user = userService.find(uid);
		if (null == user) {
			return null;
		}
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("uid", uid);
		props.put("email", user.getEmail());
		node = this.restAPI.createNode(props);
		if (null != node) {
			user.setNid(node.getId());
			userService.update(user);
		}
		return node;
	}

	public RestNode getOrCreateNodeByUID(Long uid, Map<String, Object> props) {
		RestNode node = this.getNodeByUID(uid);
		if (null != node) {
			return node;
		}
		if (!props.containsKey("uid")) {
			props.put("uid", uid);
		}
		if (props.containsKey("email")) {
			return this.restAPI.createNode(props);
		}
		return null;
	}

	public RestNode getNodeById(Long id) {
		try {
			return this.restAPI.getNodeById(id);
		} catch (org.neo4j.graphdb.NotFoundException e) {
			return null;
		}
	}

	public Boolean deleteNodeById(Long id) {
		RestNode node = this.getNodeById(id);
		if (null == node) {
			return false;
		}
		node.delete();
		return true;
	}
	
	public Boolean deleteNodeByUID(Long uid){
		RestNode node = this.getNodeByUID(uid);
		if (null == node) {
			return false;
		}
		node.delete();
		return true;
	}

	public Boolean updateNodeById(Long id, Map<String, Object> props) {
		RestNode node = this.getNodeById(id);
		if (null == node) {
			return false;
		}
		for (String key : props.keySet()) {
			node.setProperty(key, props.get(key));
		}
		node.updateFrom(node, this.restAPI);
		return true;
	}
	
	public Boolean updateNodeByUID(Long uid, Map<String, Object> props) {
		RestNode node = this.getNodeByUID(uid);
		if (null == node) {
			return false;
		}
		for (String key : props.keySet()) {
			node.setProperty(key, props.get(key));
		}
		node.updateFrom(node, this.restAPI);
		return true;
	}

	public RestNode createNode(Map<String, Object> props) {
		return this.restAPI.createNode(props);
	}
}
