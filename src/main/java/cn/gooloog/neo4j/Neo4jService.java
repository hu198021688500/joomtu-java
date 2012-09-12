package cn.gooloog.neo4j;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.entity.RestNode;
import org.neo4j.rest.graphdb.index.RestIndex;

import cn.gooloog.config.Neo4jConfig;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.HibernateSessionFactory;

public class Neo4jService {

	public RestAPI restAPI;

	public Neo4jService() {
		this.restAPI = new RestAPIFacade(Neo4jConfig.uri);
	}

	public static void main(String[] args) {
		Neo4jService xx = new Neo4jService();
		// xx.test();

		// RestNode node = xx.getNodeByUID((long) 4);
		RestNode node = xx.getOrCreateNodeByUID((long) 4);
		if (null != node) {
			System.out.println(node.getProperty("email"));
		}
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
		User user = (User) HibernateSessionFactory.getSession().get(User.class,
				uid);
		if (null == user) {
			return null;
		}
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("uid", uid);
		props.put("email", user.getEmail());
		node = this.restAPI.createNode(props);
		if (null != node) {
			user.setNid(node.getId());
			HibernateSessionFactory.getSession().merge(user);
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
		return this.restAPI.getNodeById(id);
	}
}
