package com.cognizant.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.project.model.Bookings;
import com.cognizant.project.model.Bus;
import com.cognizant.project.model.User;

@Repository
public class ExeQuery {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private DataSource dataSource;
	private Connection connection = null;

	ExeQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int addUser(String email, String name, String password, String phoneno) {
		try {
			return jdbcTemplate.update("INSERT INTO User VALUES (?, ?, ?, ?)", email, name, password, phoneno);
		} catch (Exception e) {

			return 0;
		}
	}

	public User getUser(String email) {
		String query = "select * from user where email = " + "'" + email + "'";
		try {
			return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
				@Override
				public User extractData(ResultSet rs) throws SQLException {
					User user = new User();
					rs.next();
					user.setEmail(rs.getString("email"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPhoneNo(rs.getString("phoneno"));
					return user;
				}
			});
		} catch (Exception e) {
			return null;
		}
	}
	
	public User getUserBasedOnName(String name) {
		String query = "select * from user where name = " + "'" + name + "'";
		try {
			return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
				@Override
				public User extractData(ResultSet rs) throws SQLException {
					User user = new User();
					rs.next();
					user.setEmail(rs.getString("email"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPhoneNo(rs.getString("phoneno"));
					return user;
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	public List<Bus> getBuses(String source, String destination, String date) {
		List<Bus> buses = new ArrayList<>();

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			// Establish a database connection
			connection = dataSource.getConnection();

			// Prepare the SQL query
			String query = "SELECT b.Id, b.name, b.price " + "FROM buses b "
					+ "INNER JOIN schedule s ON b.Id = s.bus_id "
					+ "WHERE b.source = ? AND b.destination = ? AND s.date = ?";

			// Create a prepared statement with the query
			statement = connection.prepareStatement(query);
			statement.setString(1, source);
			statement.setString(2, destination);
			statement.setString(3, date);

			System.out.println("dao date " + date);
			// Execute the query and retrieve the result set
			resultSet = statement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int price = resultSet.getInt(3);
				System.out.println("dao: " + id + " " + name + " " + price);
				Bus bus = new Bus(id, name, source, destination, price);
				buses.add(bus);
			}
		} catch (SQLException e) {
			// Handle any potential exceptions
			e.printStackTrace();
		} finally {
			// Close the resources in reverse order
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return buses;
	}

	public List<Bus> getAllBuses() {

		String query = "select * from Buses";

		try {
			return jdbcTemplate.query(query, (rs, rowNum) -> new Bus(rs.getInt("id"), rs.getString("name"),
					rs.getString("source"), rs.getString("destination"), rs.getInt("price")));
		} catch (Exception e) {
			return null;
		}

	}

	public int getAvailableSeats(int busId, String date) {
		int availableSeats = 0;

		// Prepare the SQL query
		String query = "SELECT seats FROM schedule WHERE bus_id = ? and date = ?";

		try {
			connection = dataSource.getConnection();

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, busId);
			statement.setString(2, date);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					availableSeats = resultSet.getInt("seats");
				}
			}
		} catch (SQLException e) {
			// Handle any exceptions
		}

		return availableSeats;
	}

	public String makeBooking(String busId, String email, Date date, int numberOfSeats) throws SQLException {

		PreparedStatement statement = null;
		String insert = "INSERT INTO bookings(bus_id, user_email, date, seats_booked) " + "VALUES(?,?,?,?)";

		statement = connection.prepareStatement(insert);
		statement.setString(1, busId);
		statement.setString(2, email);
		statement.setDate(3, date);
		statement.setInt(4, numberOfSeats);

		int result = statement.executeUpdate();

		if (result == 1) {
			return "Booking Successful!";
		}
		return "Not Booked";
	}

	public int updatePassword(String password, String email) {
		String query = "UPDATE User SET password = ? where email = ?";

		return jdbcTemplate.update(query, password, email);
	}

	public int updateName(String name, String email) {
		String query = "UPDATE User SET name = ? where email = ?";

		return jdbcTemplate.update(query, name, email);
	}

	public int updatePhoneno(String phoneno, String email) {
		String query = "UPDATE User SET phoneno = ? where email = ?";

		return jdbcTemplate.update(query, phoneno, email);
	}

	public int findPrice(String busId) throws SQLException {
		String query = "SELECT price FROM buses WHERE id = ?";

		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, busId);

		int res = 0;
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			res = rs.getInt("price");
		}

		return res;
	}

	public int makeBooking(String ticketId, String busId, String email, String date, int numberOfSeats, int cost) {
		String query = "INSERT INTO booking(ticket_id, bus_id, user_email, date, seats_booked, cost) "
				+ "VALUES(?,?,?,?,?,?);";

		return jdbcTemplate.update(query, ticketId, busId, email, date, numberOfSeats, cost);
	}

	public void reduceSeats(String busId, String date, int numberOfSeats) {
		String query = "UPDATE schedule " + "SET seats = seats - ? " + "WHERE bus_id = ? AND date = ?";

		jdbcTemplate.update(query, numberOfSeats, busId, date);
	}

	public List<Bookings> getBookings(String email) throws SQLException {
		List<Bookings> bookingsList = new ArrayList<>();
		connection = dataSource.getConnection();
		String query = "SELECT * FROM booking WHERE	user_email = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Bookings booking = new Bookings(rs.getInt(1), rs.getString(2), String.valueOf(rs.getInt(3)),
					String.valueOf(rs.getDate(5)), rs.getInt(6), rs.getInt(7));
			bookingsList.add(booking);
		}

		return bookingsList;
	}

	@SuppressWarnings("deprecation")
	public String getSource(String busId) {
	    String query = "SELECT source FROM buses WHERE Id = ?";
	    return jdbcTemplate.queryForObject(query, new Object[]{busId}, String.class);
	}


	public String getDestination(String busId) {
		String query = "SELECT destination FROM buses " + "WHERE Id = " + busId;
		return jdbcTemplate.queryForObject(query, String.class);
	}

	public void deleteBooking(String bookingId) {
		String query = "DELETE FROM booking " + "WHERE booking_id = ? ";
		jdbcTemplate.update(query, bookingId);
	}

	public void increaseSeats(int busId, String date, int numberOfSeats) {
	    String query = "UPDATE schedule SET seats = seats + ? WHERE bus_id = ? AND date = ?";
	    jdbcTemplate.update(query, numberOfSeats, busId, date);
	}


	public int addSchedule(int bus_id, Date date, int seat) {
		try {
			return jdbcTemplate.update("INSERT INTO Schedule (bus_id,date,seats) VALUES (?, ?, ?)", bus_id,
					date.toString(), seat);
		} catch (Exception e) {

			return 0;
		}
	}

	public int addBus(String name, String source, String destination, int price) {
		try {
			return jdbcTemplate.update("INSERT INTO Buses (name,source,destination,price) VALUES (?, ?, ?, ?)", name,
					source, destination, price);
		} catch (Exception e) {

			return 0;
		}
	}

	public List<User> getAllUser() {
		String query = "select * from user";
		List<User> userList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneno"));
				userList.add(user);
			}
			
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Bookings> getAllBookings() throws SQLException {
		List<Bookings> bookingsList = new ArrayList<>();
		connection = dataSource.getConnection();
		String query = "SELECT * FROM booking;";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Bookings booking = new Bookings(rs.getInt(1), rs.getString(2), String.valueOf(rs.getInt(3)),
					 rs.getString(4),String.valueOf(rs.getDate(5)), rs.getInt(6), rs.getInt(7));
			bookingsList.add(booking);
		}

		return bookingsList;
	}
	
	public String getName(String email) {
		String query = "SELECT destination FROM buses " + "WHERE Id = " + email;
		return jdbcTemplate.queryForObject(query, String.class);
	}
}
