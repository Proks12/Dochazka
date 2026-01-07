public void insert(Connection c, String j, String p, LocalDate d) throws SQLException {
    PreparedStatement ps = c.prepareStatement(
            "INSERT INTO student(jmeno,prijmeni,datum_narozeni) VALUES(?,?,?)");
    ps.setString(1, j);
    ps.setString(2, p);
    ps.setDate(3, Date.valueOf(d));
    ps.executeUpdate();
}
