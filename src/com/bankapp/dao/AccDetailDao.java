package com.bankapp.dao;

import java.sql.Connection;

public class AccDetailDao {

	public void searchDetail() {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
	}
}
