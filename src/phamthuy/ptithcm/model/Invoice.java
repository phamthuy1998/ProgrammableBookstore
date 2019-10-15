package phamthuy.ptithcm.model;

import java.util.Date;
import java.util.List;

public class Invoice {
	private int id;
	private int memberId;
	private String tel;
	private String address;
	private String email;
	private Date date;
	private byte statusId;
	private String status;
	private List<InvoiceDetail> details;

	public Invoice() {
	}

	public Invoice(String tel, String address, String email) {
		super();
		this.tel = tel;
		this.address = address;
		this.email = email;
	}


	/*public Invoice(String id, int memberId, String tel, String address, String email) {
		this(id, memberId, tel, address, email, Byte.MIN_VALUE, null, null);
	}
*/
	public Invoice(int id, int memberId, String tel, String address, String email, byte statusId, String status,
			Date date) {
		this.id = id;
		this.memberId = memberId;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.statusId = statusId;
		this.status = status;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getStatusId() {
		return statusId;
	}

	public void setStatusId(byte statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<InvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}
}
