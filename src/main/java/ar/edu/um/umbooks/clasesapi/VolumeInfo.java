package ar.edu.um.umbooks.clasesapi;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="libros")
public class VolumeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Determina que es autoincrementable
	private Integer id;//
	@Column(name="titulo")
	private String title;//
	@Transient
	private String subtitle;
	@ManyToMany
	//@JoinTable(name="libros_autores", joinColumns		= {@JoinColumn(name="id",referencedColumnName="libros_id")},
	//								inverseJoinColumns  = {@JoinColumn(name="id",referencedColumnName="autores_id")})
	private List<String> authors;// Crear la clase autores y cambiar este atributo por clase autores
	@Transient
	private String publisher;
	@Column(name="fechaPublicacion")
	private String publishedDate;//
	@Column(name="descripcion")
	private String description;//
	@Transient
	private List<Industria> industryIdentifiers;
	@Transient
	private ModoLectura readingModes;
	@Column(name="numeroPaginas")
	private Integer pageCount;//
	@Column(name="paginasImpresas")
	private Integer printedPageCount; // Faltaba
	@Transient
	private String printType;
	@ManyToMany
	//@JoinTable(name="libros_categorias", joinColumns		= {@JoinColumn(name="id",referencedColumnName="libros_id")},
	//								inverseJoinColumns  = {@JoinColumn(name="id",referencedColumnName="categorias_id")})
	@JoinColumn(name="categoria")
	private List<String> categories;//idem autores
	@Column(name="rating")
	private Float averageRating;//
	@Transient
	private Integer ratingsCount;
	@Transient
	private String maturityRating;
	@Transient
	private Boolean allowAnonLogging;
	@Transient
	private String contentVersion;
	@Transient
	private Sumario panelizationSummary;
	@Column(name="imagen")
	private Imagen imageLinks;//
	@Column(name="idioma")
	private String language;//
	@Transient
	private String previewLink;
	@Transient
	private String infoLink;
	@Transient
	private String canonicalVolumeLink;
	
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
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors.add(authors);
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Industria> getIndustryIdentifiers() {
		return industryIdentifiers;
	}
	public void setIndustryIdentifiers(List<Industria> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
	}
	public ModoLectura getReadingModes() {
		return readingModes;
	}
	public void setReadingModes(ModoLectura readingModes) {
		this.readingModes = readingModes;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getPrintType() {
		return printType;
	}
	public void setPrintType(String printType) {
		this.printType = printType;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public Float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Float averageRating) {
		this.averageRating = averageRating;
	}
	public Integer getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount(Integer ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	public String getMaturityRating() {
		return maturityRating;
	}
	public void setMaturityRating(String maturityRating) {
		this.maturityRating = maturityRating;
	}
	public Boolean getAllowAnonLogging() {
		return allowAnonLogging;
	}
	public void setAllowAnonLogging(Boolean allowAnonLogging) {
		this.allowAnonLogging = allowAnonLogging;
	}
	public String getContentVersion() {
		return contentVersion;
	}
	public void setContentVersion(String contentVersion) {
		this.contentVersion = contentVersion;
	}
	public Sumario getPanelizationSummary() {
		return panelizationSummary;
	}
	public void setPanelizationSummary(Sumario panelizationSummary) {
		this.panelizationSummary = panelizationSummary;
	}
	public Imagen getImageLinks() {
		return imageLinks;
	}
	public void setImageLinks(Imagen imageLinks) {
		this.imageLinks = imageLinks;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPreviewLink() {
		return previewLink;
	}
	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}
	public String getInfoLink() {
		return infoLink;
	}
	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}
	public String getCanonicalVolumeLink() {
		return canonicalVolumeLink;
	}
	public void setCanonicalVolumeLink(String canonicalVolumeLink) {
		this.canonicalVolumeLink = canonicalVolumeLink;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Integer getPrintedPageCount() {
		return printedPageCount;
	}
	public void setPrintedPageCount(Integer printedPageCount) {
		this.printedPageCount = printedPageCount;
	}
	
	
	
	

}
