package phamthuy.ptithcm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import phamthuy.ptithcm.mapper.ProductMapper;
import phamthuy.ptithcm.model.Product;

public class ProductDao extends AstractDao {
	public int count() {
		return getJdbcTemplate().queryForObject("SELECT COUNT(*) AS Total FROM Product", new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getInt("Total");
			}
		});
	}

	public List<Product> getProducts() {
		List<Product> list = getJdbcTemplate().query("SELECT * FROM Product", new ProductMapper());
		return list;
	}

	public List<Product> getProducts(int index, int size) {
		return getJdbcTemplate().query(
				"select * from Product order by productid asc offset ? row fetch next ? row only",
				new RowMapper<Product>() {
					@Override
					public Product mapRow(ResultSet rs, int numRow) throws SQLException {
						return new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
								rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
					}
				},(index - 1) * size, size);
	}

	public Product getProduct(int id) {

		return getJdbcTemplate().queryForObject("SELECT * FROM Product WHERE ProductId = ?",
				new RowMapper<Product>() {
					@Override
					public Product mapRow(ResultSet rs, int arg1) throws SQLException {
						return new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
								rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
					}
				}, id);

	}

	public List<Product> search(String q) {
		return getJdbcTemplate().query("SELECT * FROM Product WHERE Title LIKE ?", new ProductMapper() {
			@Override
			public Product mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
			}
		}, "%" + q + "%");
	}
}
