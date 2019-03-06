package ku.shop.db;

import ku.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class ProductDAO implements IEntityDAO<Product> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Product product) {
        String query = "insert into Product (id, name, price) values (?, ?, ?);";
        Object[] data = new Object[]
                {product.getId(), product.getName(), product.getPrice() };
        jdbcTemplate.update(query, data);
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
