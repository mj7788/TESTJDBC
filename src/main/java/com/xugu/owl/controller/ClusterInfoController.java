package com.xugu.owl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xugu.owl.model.ClusterInfo;
import com.xugu.owl.model.Result;
import com.xugu.owl.service.ClusterInfoService;
import com.xugu.owl.utils.ResultUtil;
import com.xugu.owl.vo.Cluster;

@Controller
@RequestMapping("/cluster")
public class ClusterInfoController {
	
	@Autowired
	ClusterInfoService clusterInfoService;
	
	@PostMapping
	public @ResponseBody Result addCluster(@RequestBody @Valid Cluster cluster) {
		clusterInfoService.addCluster(cluster);
		return ResultUtil.success(cluster);
	}
	
	@GetMapping
	public @ResponseBody Result listCluster() {
		List<ClusterInfo> clusters = clusterInfoService.listCluster();
		return ResultUtil.success(clusters);
	}
	
	@DeleteMapping
	public @ResponseBody Result deleteCluster(int id) {
		clusterInfoService.deleteCluster(id);
		return ResultUtil.success();
	}

}
