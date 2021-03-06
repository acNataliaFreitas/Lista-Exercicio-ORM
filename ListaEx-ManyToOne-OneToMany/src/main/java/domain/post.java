package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class post implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	
	@OneToMany(mappedBy = "todoList", fetch = FetchType.EAGER)
	private List<PostComment> Comments = new ArrayList<PostComment>();

	public post() {
		super();
	}

	public post(Integer id, String title, List<PostComment> postsComments) {
		super();
		this.id = id;
		this.title = title;
		Comments = postsComments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PostComment> getPostsComments() {
		return Comments;
	}

	public void setPostsComments(List<PostComment> postsComments) {
		Comments = postsComments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		post other = (post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
}
