package phamthuy.ptithcm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import phamthuy.ptithcm.model.Cart;
import phamthuy.ptithcm.model.Invoice;
import phamthuy.ptithcm.model.InvoiceDetail;

public class InvoiceDetailMapper implements RowMapper<InvoiceDetail> {

	@Override
	public InvoiceDetail mapRow(ResultSet rs, int numRow) throws SQLException {
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetail.setId(rs.getInt("InvoiceId"));
		invoiceDetail.setProductId(rs.getInt("ProductId"));
		invoiceDetail.setQuantity(rs.getShort("Quantity"));
		invoiceDetail.setPrice(rs.getInt("Price"));
		invoiceDetail.setTitle(rs.getString("Title"));
		invoiceDetail.setImageUrl(rs.getString("ImageUrl"));
		return invoiceDetail;
	}
}
