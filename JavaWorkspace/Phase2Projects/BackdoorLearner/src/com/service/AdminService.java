package com.service;

import com.dao.AdminDao;
import com.entity.Admin;

public class AdminService {
	
	AdminDao pd = new AdminDao();
	
	public Admin getAdmin() {
		return pd.getAdmin();
		
	}

}
