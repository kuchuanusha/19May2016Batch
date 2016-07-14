package com.flp.fms.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Film {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int film_id;
	
	private String title;
	private String description;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date release_year;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="language_id")
	private Language language;
	
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacement_cost;
	private double rating;
	private String special_features;
	
	@Column(nullable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
	private Set<Actor> actors = new HashSet<Actor>();
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
	private Category category;
	
	public Film() {
		
	}
	
	
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Date getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Date release_year) {
		this.release_year = release_year;
	}

	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	
	public double getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	
	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}


	public Set<Actor> getActors() {
		return actors;
	}


	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
