package ar.edu.um.umbooks.clasesapi;

import java.io.Serializable;
import java.util.List;

public class JSON implements Serializable{
	private String kind;
	private Integer totalItems;
	
	private List<Items> items;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
	
}
