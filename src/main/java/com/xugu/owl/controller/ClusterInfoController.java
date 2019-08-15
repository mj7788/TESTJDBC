package com.xugu.owl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xugu.owl.model.ClusterInfo;
import com.xugu.owl.model.Result;
import com.xugu.owl.service.ClusterInfoService;
import com.xugu.owl.utils.ResultUtil;

@Controller
@RequestMapping("/cluster")
public class ClusterInfoController {
	
	@Autowired
	ClusterInfoService cs;
	
	@PostMapping
	public @ResponseBody Result addCluster(@Valid ClusterInfo cluster) {
		cs.addCluster(cluster);
		return ResultUtil.success(cluster);
	}
	
	@GetMapping
	public @ResponseBody Result listCluster() {
		List<ClusterInfo> clusters = cs.listCluster();
		return ResultUtil.success(clusters);
	}
	
	@DeleteMapping
	public @ResponseBody Result deleteCluster(int id) {
		cs.deleteCluster(id);
		return ResultUtil.success();
	}

}
