package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Author implements GenericEntity {

    private Long autorId;
    private String firstname;
    private String lastname;

    public Author() {
    }

    public Author(Long id, String firstname, String lastname) {
        this.autorId = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Author(Long id) {
        autorId = id;
    }

    public Long getAuthorId() {
        return autorId;
    }

    @Override
    public void setId(Long authorId) {
        this.autorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.autorId);
        hash = 89 * hash + Objects.hashCode(this.firstname);
        hash = 89 * hash + Objects.hashCode(this.lastname);
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return Objects.equals(this.autorId, other.autorId);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

//    @Override
//    public String toString() {
//        return "Author{" + "autorId=" + autorId + ", firstname=" + firstname + ", lastname=" + lastname + '}';
//    }
    @Override
    public String getTableName() {
        return "autor";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "autorId,ime,prezime";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(autorId).append(",")
                .append("'").append(firstname).append("',")
                .append("'").append(lastname).append("'");
        return sb.toString();
    }

    @Override
    public String getSelectValues() {
        return "SELECT a.autorId,a.ime,a.prezime FROM autor AS a";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Author(rs.getLong("autorId"), rs.getString("ime"), rs.getString("prezime"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "autorId=" + ((Author) object).getAuthorId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Author author = (Author) object;
        return "ime=" + "'" + author.getFirstname() + "'" + ", prezime= '" + author.getLastname() + "'";
    }

}
