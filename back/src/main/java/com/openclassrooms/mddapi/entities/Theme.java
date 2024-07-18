package com.openclassrooms.mddapi.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "THEMES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
	@Builder.Default
	private List<Article> articles = new ArrayList<>();

	@ManyToMany(mappedBy = "themes", fetch = FetchType.LAZY)
	@Builder.Default
	private List<User> users = new ArrayList<>();

	@Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP")
	private Timestamp createdAt;

	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private Timestamp updatedAt;

	@PrePersist
	public void onCreate() {
		createdAt = new Timestamp(System.currentTimeMillis());
		updatedAt = new Timestamp(System.currentTimeMillis());
	}

	@PreUpdate
	public void onUpdate() {
		updatedAt = new Timestamp(System.currentTimeMillis());
	}
}
