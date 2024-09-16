package nguyen.dev.data.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nguyen.dev.data.dao.CategoryDao;
import nguyen.dev.data.driver.MySQLDriver;
import nguyen.dev.data.model.Category;

public class CategoryImpl implements CategoryDao {
	
	@Override
	public boolean insert(Category categories) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CATEGORIES(NAME, DESCRIPTION) VALUES (?, ?)";
		try {
			Connection  conn = MySQLDriver.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, categories.name);
			stmt.setString(2, categories.description);
//			stmt.setString(3, "Ao Dong tinh");
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Category categories) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORIES SET NAME = ?, DESCRIPTION = ? WHERE ID = ?";
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, categories.name);
			stmt.setString(2, categories.description);
//			stmt.setString(3, "Ao Dong tinh");
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Category categories) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categories.id);
			stmt.setString(2, categories.name);	
			stmt.setString(3, categories.description);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean select(Category categories) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES WHERE = ?";
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				System.out.format("id:%d - name:%s - description:%s", id, name, description).println();
				return new Category(id, name, description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		List<Category> categoryList = new ArrayList<Category>();
		String sql = "SELECT * FROM CATEGORIES";
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				System.out.format("id:%d - name:%s - description:%s", id, name, description).println();
				categoryList.add(new Category(id, name, description));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}
	
}
