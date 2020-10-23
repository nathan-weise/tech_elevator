package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
        String sql = "INSERT INTO reservation (site_id, name, from_date, to_date) " +
                     "VALUES (?, ?, ?, ?) RETURNING reservation_id;";
        Integer reservationId = jdbcTemplate.queryForObject(sql, Integer.class, siteId, name, fromDate, toDate);
        if (reservationId == null) {
            reservationId = -1;
        }
        return reservationId;
    }

    @Override
    public List<Reservation> findUpcomingReservationsForPark(int parkId) {
        List<Reservation> results = new ArrayList<>();
        String sql = "SELECT reservation_id, r.site_id, r.name, from_date, to_date, create_date "
                + "FROM reservation AS r "
                + "JOIN site AS s ON s.site_id = r.site_id "
                + "JOIN campground AS c ON c.campground_id = s.campground_id "
                + "WHERE park_id = ? AND from_date BETWEEN NOW() AND NOW() + INTERVAL '30 days';";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,parkId);
        while(rowSet.next()) {
            Reservation reservation = mapRowToReservation(rowSet);
            results.add(reservation);
        }
        return results;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }


}
