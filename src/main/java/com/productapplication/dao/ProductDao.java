package com.productapplication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.productapplication.model.AdminUser;
import com.productapplication.model.ProductEntity;

@Repository
public class ProductDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public void registerUser(AdminUser adminUser) {
		this.hibernateTemplate.save(adminUser);
	}

	@Transactional
	public AdminUser checkUserExits(String uname) {

		AdminUser adminUser = null;
		try {
			String qry = "select * from adminuser where uname=?";

			adminUser = jdbcTemplate.queryForObject(qry, new RowMapper<AdminUser>() {

				public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminUser adminUser = new AdminUser();

					adminUser.setId(rs.getInt(1));
					adminUser.setUcpassword(rs.getString(2));
					adminUser.setUname(rs.getString(3));
					adminUser.setUpassword(rs.getString(4));

					return adminUser;
				}

			}, uname);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return adminUser;
	}

	@Transactional
	public AdminUser validateUser(String name, String password) {

		AdminUser adminUser = null;
		try {
			String qry = "select * from adminuser where uname=? and upassword=?";

			adminUser = jdbcTemplate.queryForObject(qry, new RowMapper<AdminUser>() {

				public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {

					AdminUser adminUser = new AdminUser();

					adminUser.setId(rs.getInt(1));
					adminUser.setUcpassword(rs.getString(2));
					adminUser.setUname(rs.getString(3));
					adminUser.setUpassword(rs.getString(4));

					return adminUser;
				}

			}, name, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return adminUser;
	}

	@Transactional
	public void addProduct(ProductEntity productEntity) {

		this.hibernateTemplate.save(productEntity);
	}

	@Transactional
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> products = this.hibernateTemplate.loadAll(ProductEntity.class);
		return products;
	}

	@Transactional
	public void deleteProductDetails(int id) {

		ProductEntity productEntity = this.hibernateTemplate.get(ProductEntity.class, id);
		this.hibernateTemplate.delete(productEntity);
	}

	@Transactional
	public void updateProductDetails(ProductEntity productEntity) {
		this.hibernateTemplate.update(productEntity);
	}

	public ProductEntity getOneProductDetails(int id) {
		ProductEntity productEntity = this.hibernateTemplate.get(ProductEntity.class, id);
		return productEntity;
	}

}
