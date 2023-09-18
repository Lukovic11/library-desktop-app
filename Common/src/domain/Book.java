package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Book implements GenericEntity {

    private Long id;
    private String title;
    private Author author;
    private Boolean available;

    public Book() {
    }

    public Book(Long id, String title, Author author, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public Book(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.author);
        hash = 79 * hash + Objects.hashCode(this.available);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return Objects.equals(this.available, other.available);
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public String getTableName() {
        return "knjiga";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "knjigaId,nazivKnjige,autorId,dostupnost";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(title).append("',")
                .append(author.getAuthorId()).append(",")
                .append(available);
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getSelectValues() {
        return "SELECT b.knjigaId,b.nazivKnjige,b.autorId,b.dostupnost FROM knjiga as b";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Book(rs.getLong("knjigaId"), rs.getString("nazivKnjige"), new Author(rs.getLong("autorId")), rs.getBoolean("dostupnost"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "knjigaId=" + ((Book) object).getId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Book book = (Book) object;
        return "nazivKnjige=" + "'" + book.getTitle() + "'" + ",autorId=" + book.getAuthor().getAuthorId() + ",dostupnost=" + (book.getAvailable() ? 1 : 0);
    }

}
