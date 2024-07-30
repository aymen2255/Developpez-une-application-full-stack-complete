package com.openclassrooms.mddapi.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SUBSCRIPTIONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "theme_id", nullable = false)
	private Theme theme;

	@Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP")
	private Timestamp createdAt;

	@PrePersist
	public void onCreate() {
		createdAt = new Timestamp(System.currentTimeMillis());
	}

}
