package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCSiteDAO implements SiteDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCSiteDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
        List<Site> result = new ArrayList<>();
        String sql = "SELECT site_id, site.campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities " +
                     "FROM site " +
                     "JOIN campground ON site.campground_id = campground.campground_id " +
                     "WHERE park_id = ? AND max_rv_length > 0;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, parkId);
        while (rowSet.next()) {
            result.add(mapRowToSite(rowSet));
        }
        return result;
    }

    @Override
    public List<Site> findSitesAvailableToday(int parkId) {
        List<Site> result = new ArrayList<>();
        String sql = "SELECT site_id, site.campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities " +
                "FROM site " +
                "JOIN campground ON site.campground_id = campground.campground_id " +
                "WHERE park_id = ? " +
                "AND site_id NOT IN (SELECT site_id FROM reservation WHERE now() BETWEEN from_date AND to_date);";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, parkId);
        while (rowSet.next()) {
            result.add(mapRowToSite(rowSet));
        }
        return result;
    }


    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
