package cow.hoya_jpa_crud.member.entity;

import java.util.ArrayList;
import java.util.List;

import cow.hoya_jpa_crud.post.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String name;

	private String email;

	private String password;

	@OneToMany(mappedBy = "post", orphanRemoval = true)
	List<Post> posts = new ArrayList<>();

	@Builder
	private Member(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static Member from(String name) {
		return Member.builder()
			.name(name)
			.build();
	}
}
