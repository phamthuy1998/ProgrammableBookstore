package phamthuy.ptithcm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import phamthuy.ptithcm.mapper.AuthorMapper;
import phamthuy.ptithcm.mapper.CartMapper;
import phamthuy.ptithcm.model.Author;
import phamthuy.ptithcm.model.Cart;

public class CartDao extends AstractDao {
	
	public List<Cart> getCarts(int memberId) {
		List<Cart> list = getJdbcTemplate().query("EXEC GetCarts ?", new CartMapper(), memberId);
		return list;
	}

	public int add(Cart cart) {
		return getJdbcTemplate().update("EXEC AddCart  ?, ?, ?", cart.getMemberId(), cart.getProductId(),
				cart.getQuantity());
	}

	public int delete(int cartID) {
		return getJdbcTemplate().update("DELETE FROM CART WHERE CartId = ?", cartID);
	}
}