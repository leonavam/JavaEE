package edu.ucam.dao.factories;

import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;
import edu.ucam.dao.file.UserDAOFile;

public class FileFactory implements Factory {

	@Override
	public UserDAO getUserDAO() {
		return new UserDAOFile();
	}

}
