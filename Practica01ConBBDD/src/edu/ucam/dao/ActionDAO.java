package edu.ucam.dao;

import java.util.Hashtable;

import edu.ucam.actions.Action;

public interface ActionDAO {

	public Hashtable<String, Action> loadActions();

}
