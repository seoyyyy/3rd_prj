package kr.co.prj.vo;
public class SearchVO {
	private String field, keyword;
	private int currentPage;
	public SearchVO() {
		super();
	}
	
	public SearchVO(String field, String keyword, int currentPage) {
		super();
		this.field = field;
		this.keyword = keyword;
		this.currentPage = currentPage;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	
}//class

	

	
