package com.itface.star.system.org.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itface.star.system.baseDao.BaseDao;
import com.itface.star.system.easyui.TreeNode;
import com.itface.star.system.org.model.Model;
import com.itface.star.system.org.service.ModelService;
@Service
public class ModelServiceImpl implements ModelService{

	@Autowired
	private BaseDao<Model> baseDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Model add(Model model) {
		// TODO Auto-generated method stub
		return baseDao.persist(model);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Model update(Model model) {
		// TODO Auto-generated method stub
		return baseDao.update(model);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(long id) {
		// TODO Auto-generated method stub
		baseDao.deleteById(Model.class, id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Model find(long id) {
		// TODO Auto-generated method stub
		return baseDao.find(Model.class, id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray findSons(long id) {
		// TODO Auto-generated method stub
		List<Model> list = baseDao.find("from Model t where t.parentModel=?1", new Object[]{id});
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if(list!=null){
			for(Model model : list){
				nodes.add(new TreeNode(model));
			}
			Collections.sort(nodes);
		}
		return JSONArray.fromObject(nodes);
	}

}
