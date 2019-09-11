package phamthuy.ptithcm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import phamthuy.ptithcm.mapper.AuthorMapper;
import phamthuy.ptithcm.model.Author;

public class AuthorDao extends AstractDao {

	public List<Author> getAllAuthor() {
		List<Author> list = getJdbcTemplate().query("SELECT * FROM AUTHOR", new AuthorMapper());
		return list;
	}

	public int insert(Author author) {
		return getJdbcTemplate().update("insert into author(authorid,AuthorName) values(?,?)", author.getId(),
				author.getName());
	}

	public int delete(int id) {
		return getJdbcTemplate().update("DELETE FROM Author WHERE AuthorId = ?", id);
	}

//	public int delete(String list[]) {
//		try{
//		for (String id : list) {
//			return getJdbcTemplate().update("DELETE FROM Author WHERE AuthorId = ?", Integer.parseInt(id));
//		}}catch(Exception e){
//			
//		}
//		return 1;
//	}

	public int delete(List<Integer> list) {
		for (Integer id : list) {
			return getJdbcTemplate().update("DELETE FROM Author WHERE AuthorId = ?", id);
		}
		return 1;
	}

	public int edit(Author author) {
		return getJdbcTemplate().update("UPDATE Author SET AuthorName = ? WHERE AuthorId = ?", author.getName(),
				author.getId());
	}

	public Author getAuthor(int id) {
		return getJdbcTemplate().queryForObject("SELECT * FROM Author WHERE AuthorId = ?", new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				return new Author(rs.getInt("AuthorId"), rs.getString("AuthorName"));
			}
		}, id);
	}
}
