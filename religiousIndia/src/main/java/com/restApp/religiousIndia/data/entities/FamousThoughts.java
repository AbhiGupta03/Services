package com.restApp.religiousIndia.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RI_FAMOUS_THOUGHTS")
public class FamousThoughts {
	@Id
	private String thoughtId;
	private String thoughtTitle;
	private String thoughtDesc;
	private String thoughtRefrence;
	private String thoughtAuthor;

	public String getThoughtId() {
		return thoughtId;
	}

	public void setThoughtId(String thoughtId) {
		this.thoughtId = thoughtId;
	}

	public String getThoughtTitle() {
		return thoughtTitle;
	}

	public void setThoughtTitle(String thoughtTitle) {
		this.thoughtTitle = thoughtTitle;
	}

	public String getThoughtDesc() {
		return thoughtDesc;
	}

	public void setThoughtDesc(String thoughtDesc) {
		this.thoughtDesc = thoughtDesc;
	}

	public String getThoughtRefrence() {
		return thoughtRefrence;
	}

	public void setThoughtRefrence(String thoughtRefrence) {
		this.thoughtRefrence = thoughtRefrence;
	}

	public String getThoughtAuthor() {
		return thoughtAuthor;
	}

	public void setThoughtAuthor(String thoughtAuthor) {
		this.thoughtAuthor = thoughtAuthor;
	}

	@Override
	public String toString() {
		return "FamousThoughts [thoughtId=" + thoughtId + ", thoughtTitle=" + thoughtTitle + ", thoughtDesc="
				+ thoughtDesc + ", thoughtRefrence=" + thoughtRefrence + ", thoughtAuthor=" + thoughtAuthor + "]";
	}

}
