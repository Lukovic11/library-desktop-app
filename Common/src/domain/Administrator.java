package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Administrator implements GenericEntity {

    private Long adminId;
    private String firstname;
    private String lastname;
    private String password;

    public Administrator() {
    }

    public Administrator(Long id, String firstname, String lastname, String password) {
        this.adminId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public Administrator(Long id) {
        adminId = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.adminId);
        hash = 11 * hash + Objects.hashCode(this.firstname);
        hash = 11 * hash + Objects.hashCode(this.lastname);
        hash = 11 * hash + Objects.hashCode(this.password);
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.adminId, other.adminId);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public String getTableName() {
        return "administrator";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "adminId,ime,prezime,sifra";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(adminId).append(",")
                .append("'").append(firstname).append("',")
                .append(lastname).append(",")
                .append(password);
        return sb.toString();
    }

    @Override
    public String getSelectValues() {
        return "SELECT a.adminId,a.ime,a.prezime,a.sifra FROM administrator AS a";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Administrator(rs.getLong("adminId"), rs.getString("ime"), rs.getString("prezime"), rs.getString("sifra"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "adminId=" + ((Administrator) object).getAdminId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Administrator administrator = (Administrator) object;
        return "ime=" + "'" + administrator.getFirstname() + "'" + ", prezime=" + administrator.getLastname() + ", password=" + administrator.getPassword();

    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setId(Long id) {
        setAdminId(id);
    }

}
