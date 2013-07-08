package com.itface.star.system.org.service;

import net.sf.json.JSONArray;

import com.itface.star.system.org.model.Model;

public interface ModelService {

	public Model find(long id);
	public Model add(Model model);
	public Model update(Model model);
	public void remove(long id);
	public JSONArray findSons(long id);
}
