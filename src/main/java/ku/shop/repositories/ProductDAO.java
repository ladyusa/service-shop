package ku.shop.repositories;

import ku.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class ProductDAO implements IEntityDAO<Product> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product insert(Product product) {

        final String INSERT_SQL = "insert into Product (name, price) values (?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_SQL, new String[] {"id"});
                        ps.setString(1, product.getName());
                        ps.setDouble(2, product.getPrice());
                        return ps;
                    }
                },
                keyHolder);
        product.setId(keyHolder.getKey().intValue());
        return product;
    }

    @Override
    public Product getOne(int id) {
        String query = "select * from product where id = " + id;
        Product product;
        try {
            product = jdbcTemplate.queryForObject(query, new ProductRowMapper());
        } catch (Exception e) {
            product = null;
        }
        return product;    }

    @Override
    public List<Product> getAll() {
        String query = "select * from Product";
        List<Product> products = jdbcTemplate.query(query, new ProductRowMapper());
        return products;
    }

    class ProductRowMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Product product = new Product(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"));
            return product;
        }
    }
}
