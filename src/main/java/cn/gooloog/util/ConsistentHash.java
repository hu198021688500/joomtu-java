/**
 * 
 */
package cn.gooloog.util;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author admin
 * @param <T>
 * 
 */
public class ConsistentHash<T> {
	private final int numberOfReplicas;
	private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();

	public ConsistentHash(int numberOfReplicas,/* 虚拟节点数 */Collection<T> nodes/* 物理节点 */) {
		this.numberOfReplicas = numberOfReplicas;
		for (T node : nodes) {
			add(node);
		}
	}

	public void add(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.put((node.toString() + i).hashCode(), node);
		}
	}

	public void remove(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.remove((node.toString() + i).hashCode());
		}
	}

	// 关键算法
	public T get(Object key) {
		if (circle.isEmpty()) {
			return null;
		}
		int hash = key.hashCode();
		if (circle.containsKey(hash)) {// 如果circle包含指定键的映射关系，则返回 true。
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);// 返回circle的部分视图，其键大于等于
																	// hash。
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		return circle.get(hash);
	}
}
