package phamthuy.ptithcm.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AstractDao {
	protected JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dataSource.setUrl("jdbc:sqlserver://127.0.0.1:1433;databaseName=MiniShop");
			dataSource.setUsername("sa");
			dataSource.setPassword("123");
			jdbcTemplate= new JdbcTemplate(dataSource);
			System.out.println("Kết nối thành công");
		}
		return jdbcTemplate;
	}
}
