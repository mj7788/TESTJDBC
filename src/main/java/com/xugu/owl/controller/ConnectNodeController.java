package com.xugu.owl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xugu.owl.model.ConnectNode;
import com.xugu.owl.model.Result;
import com.xugu.owl.service.ConnectNodeService;
import com.xugu.owl.utils.ResultUtil;

@Controller
@RequestMapping("/node")
public class ConnectNodeController {

	@Autowired
	private ConnectNodeService cns;
	
	@PostMapping
	public @ResponseBody Result addConnectNode(@Valid ConnectNode node) {
		cns.add(node);
		return ResultUtil.success();
	}
	
	@GetMapping
	public @ResponseBody Result listConnectNode(@RequestParam("clusterId") int clusterId){
		List<ConnectNode> list = cns.listAll(clusterId);
		return ResultUtil.success(list);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody Result deleteConnectNode(@PathVariable int id) {
		cns.delete(id);
		return ResultUtil.success();
	}
	
	@PatchMapping
	public @ResponseBody Result updateConnectNode(@Valid ConnectNode node) {
		cns.update(node);
		return ResultUtil.success();
	}
	
}
