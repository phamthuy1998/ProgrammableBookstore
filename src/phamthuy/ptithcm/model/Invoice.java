package phamthuy.ptithcm.model;

import java.util.Date;
import java.util.List;

public class Invoice {
	private String id;
	private Long memberId;
	private String tel;
	private String address;
	private String email;
	private Date date;
	private byte statusId;
	private String status;
	private List<InvoiceDetail> details;

	public Invoice() {
	}

	public Invoice(String id, Long memberId, String tel, String address, String email) {
		this(id, memberId, tel, address, email, Byte.MIN_VALUE, null, null);
	}

	public Invoice(String id, Long memberId, String tel, String address, String email, byte statusId, String status,
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
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
