package phamthuy.ptithcm.dao;

import phamthuy.ptithcm.model.Invoice;

public class InvoiceDao extends AstractDao {
	public int add(Invoice obj) {
		return getJdbcTemplate().update("EXEC AddInvoice ?, ?, ?, ?, ?", obj.getId(), obj.getMemberId(),
				obj.getEmail(), obj.getTel(), obj.getAddress());
	}
}
