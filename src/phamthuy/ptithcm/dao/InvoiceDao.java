package phamthuy.ptithcm.dao;

import java.util.List;

import phamthuy.ptithcm.mapper.InvoiceDetailMapper;
import phamthuy.ptithcm.mapper.InvoiceMapper;
import phamthuy.ptithcm.model.Invoice;
import phamthuy.ptithcm.model.InvoiceDetail;

public class InvoiceDao extends AstractDao {
	public int add(Invoice obj) {
		return getJdbcTemplate().update("EXEC AddInvoice ?, ?, ?, ?", obj.getMemberId(), obj.getEmail(), obj.getTel(),
				obj.getAddress());
	}

	public List<Invoice> getAllInvoice(int id) {
		List<Invoice> list = getJdbcTemplate().query("SELECT * FROM dbo.Invoice WHERE MemberId = ?",
				new InvoiceMapper(), id);
		return list;
	}

	public List<InvoiceDetail> getAllInvoiceDdetail(int id) {
		List<InvoiceDetail> list = getJdbcTemplate().query("SELECT InvoiceId, "
				+ "dbo.InvoiceDetail.ProductId ,Quantity, dbo.Product.Price,Title,ImageUrl "
				+ " FROM dbo.InvoiceDetail INNER JOIN dbo.Product "
				+ " ON Product.ProductId = InvoiceDetail.ProductId "
				+ " WHERE InvoiceId = ?",
				new InvoiceDetailMapper(), id);
		return list;
	}

	public int cancel(int id) {
		return getJdbcTemplate().update("UPDATE Invoice SET StatusId = 4 WHERE InvoiceId = ?", id);
	}

}
