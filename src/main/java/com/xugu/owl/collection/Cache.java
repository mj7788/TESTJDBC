package com.xugu.owl.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

	//集群信息缓存
	public static Map<Integer, String> clusters = new ConcurrentHashMap<>();
	//收集调度缓存
	public static Map<Integer, String> scheduls = new ConcurrentHashMap<>();
}
